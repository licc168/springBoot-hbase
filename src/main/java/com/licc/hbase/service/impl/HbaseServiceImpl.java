package com.licc.hbase.service.impl;

import com.alibaba.fastjson.JSONObject;

import com.licc.hbase.api.HbaseTemplate;
import com.licc.hbase.api.RowMapper;
import com.licc.hbase.api.TableCallback;
import com.licc.hbase.entity.HBaseEntity;
import com.licc.hbase.service.HbaseService;
import com.licc.hbase.util.BeanMapper;
import com.licc.hbase.util.Reflect;
import com.licc.hbase.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/12/14 14:14
 * @see
 */
@Service
public class HbaseServiceImpl implements HbaseService {
    //过滤字段
    private static final String fileterColumns = "FAMILY_NAME,FAMILY_NAME_BYTES,JSpider_,TAB_NAME,TABLE_PREFIX";
    private  Class<?> tClass;
    @Autowired
    private HbaseTemplate hbaseTemplate;
    RowMapper<Object> rowMapper = new RowMapper<Object>(){

        @Override
        public Object mapRow(Result result, int i) throws Exception {
            Reflect reflect = Reflect.on(tClass).create();
            Map<String, Reflect> allFieldsStatic = reflect.fields(true);
            //获取非静态属性值
            Map<String, Reflect> allFields = reflect.fields(false);
            Set<String> cloumNames = allFields.keySet();

            allFieldsStatic.forEach((String key, Reflect v) -> {
                if (fileterColumns.indexOf(key) < 0) {
                    byte[] value = v.get();
                    String cloumName = Bytes.toString(value);
                    if (cloumNames.contains(cloumName)) {
                        byte[] hbaseValue = result.getValue(HBaseEntity.FAMILY_NAME_BYTES, value);
                        if (null != hbaseValue) {
                            String val = Bytes.toString(hbaseValue);
                            if (reflect.field0(cloumName).getGenericType() == Reflect.on(JSONObject.class).type()) {
                                JSONObject proceList = JSONObject.parseObject(val);
                                reflect.set(cloumName, proceList);
                            } else if (reflect.field0(cloumName).getGenericType() == Reflect.on(Integer.class).type()) {
                                 val = val.replace("[^0-9]","");
                                  try {
                                   reflect.set(cloumName, Integer.parseInt(val));
                                  }catch (NumberFormatException e){

                                  }

                            } else {
                                reflect.set(cloumName, val);
                            }
                        }
                    }
                }
            });
            reflect.set("rowKey", Bytes.toString(result.getRow()));
            return reflect.get();
        }
    };

    @Override
    public <T> List<T> findByExample(Map<String, CompareOp[]> filterParam, Object t ,Class<T> classz) {
        Scan scan = new Scan();
        scan.addFamily(HBaseEntity.FAMILY_NAME_BYTES);
        Reflect reflect =  Reflect.on(t);
        //获取静态属性值 static
        Map<String, Reflect> allFieldsStatic = reflect.fields(true);
        //获取非静态属性值
        Map<String, Reflect> allFields = reflect.fields(false);
        Set<String> cloumNames = allFields.keySet();
        allFieldsStatic.forEach((String k, Reflect v) -> {
            if (fileterColumns.indexOf(k) < 0) {
                byte[] value = v.get();
                String cloumName = Bytes.toString(value);
                //如果字段是String类型  则作为过滤字段
                if (cloumNames.contains(cloumName)) {
                    Field field = reflect.field0(cloumName);
                    if (field.getGenericType() == String.class) {
                        String s = reflect.get(cloumName);
                        if (StringUtils.isNotEmpty(s)) {
                            CompareOp[] campanyOps = filterParam.get(cloumName);
                            if (campanyOps != null) {
                                for (CompareOp campanyOp : campanyOps) {
                                    SingleColumnValueFilter filter = new SingleColumnValueFilter(
                                        HBaseEntity.FAMILY_NAME_BYTES,
                                        value, campanyOp,
                                        Bytes.toBytes(s));
                                    scan.setFilter(filter);
                                }
                            }

                        }
                    }
                }
            }
        });
        tClass = classz;
        List<Object> rows = hbaseTemplate.find(reflect.field("TAB_NAME").toString(), scan, rowMapper);
        return BeanMapper.mapList(rows,classz);
    }

    @Override
    public <T> List<T> findByExample(Scan scan,Class<T> classz) {
        Reflect reflect = Reflect.on(classz).create();
        List<Object> rows = hbaseTemplate.find(reflect.field("TAB_NAME").toString(), scan, rowMapper);
        return BeanMapper.mapList(rows,classz);
    }



    @Override
    public <T> void save(T t,Class<T> classz) {
        Reflect reflect =  Reflect.on(classz).create();
        String tableName = reflect.field("TAB_NAME").toString();
        hbaseTemplate.execute(tableName, new TableCallback<String>() {
            @Override
            public String doInTable(Table table) throws Throwable {
                Reflect reflect = Reflect.on(t);
                String rowKey = reflect.field("rowKey").get().toString();
                Put p = new Put(Bytes.toBytes(rowKey));
                Map<String, Reflect> allFieldsStatic = reflect.fields(true);
                //获取非静态属性值
                Map<String, Reflect> allFields = reflect.fields(false);
                Set<String> cloumNames = allFields.keySet();
                allFieldsStatic.forEach((String key, Reflect v) -> {
                    if (fileterColumns.indexOf(key) < 0) {
                        byte[] value = v.get();
                        String cloumName = Bytes.toString(value);
                        if (cloumNames.contains(cloumName)) {
                            T cloumValue = reflect.get(cloumName);
                            if (null != cloumValue) {
                                if (cloumValue instanceof Integer) {
                                    p.addColumn(HBaseEntity.FAMILY_NAME_BYTES, value, Bytes.toBytes((Integer) cloumValue));
                                } else if (cloumValue instanceof Boolean) {
                                    p.addColumn(HBaseEntity.FAMILY_NAME_BYTES, value, Bytes.toBytes((Boolean) cloumValue));
                                } else if (cloumValue instanceof String) {
                                    p.addColumn(HBaseEntity.FAMILY_NAME_BYTES, value, Bytes.toBytes((String) cloumValue));
                                } else if (cloumValue instanceof JSONObject) {
                                    p.addColumn(HBaseEntity.FAMILY_NAME_BYTES, value, Bytes.toBytes(((JSONObject) cloumValue).toJSONString()));
                                }

                            }
                        }
                    }
                });
                table.put(p);
                return rowKey;
            }

        });
            }




public static void main(String arge[]){
 String  s = "1我我我123   你1231";
    System.out.println(s.replaceAll("[^0-9]",""));
}
}

