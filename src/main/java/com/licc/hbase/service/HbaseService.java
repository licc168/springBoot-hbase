package com.licc.hbase.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
/**
 * Hbase基础类
 * @author lichangchao
 * @version 1.0.0
 * @date 2017/12/14 13:45
 * @see
 */
public interface  HbaseService {
  <T> List<T> findByExample(Map<String, CompareOp[]> filter, Object t ,Class<T> classz);
  <T> List<T> findByExample(Scan scan,Class<T> classz);
  <T> void save(T t,Class<T> classz);

}
