package com.licc.hbase.service;

import com.licc.hbase.service.impl.HbaseServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.licc.hbase.Application;
import com.licc.hbase.entity.SCnMadeInChina;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class HbaseServiceTests {
  @Resource
  HbaseService hbaseService ;

  @Test
  public  void  test(){
    SCnMadeInChina sCnMadeInChinaQuery = new SCnMadeInChina();
    sCnMadeInChinaQuery.setAppendTime("1513158597822");
    Map<String , CompareOp[]> filterParam =  new HashMap<>();
    filterParam.put("appendTime", new CompareOp[]{CompareOp.GREATER_OR_EQUAL});
    List<SCnMadeInChina> madeInChinaList = hbaseService.findByExample(filterParam,sCnMadeInChinaQuery,SCnMadeInChina.class);
    System.out.println(madeInChinaList);

  }
}
