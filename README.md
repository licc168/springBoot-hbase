#SpringBootHbase  

### HbaseService基础类封装
封装了一个简易的Hbase-ORM框架

- 接口
```java
  <T> List<T> findByExample(Map<String, CompareOp[]> filter, Object t ,Class<T> classz);
  <T> List<T> findByExample(Scan scan,Class<T> classz);
  <T> void save(T t,Class<T> classz);
```
- 使用范列
```java
    /**构造查询条件**/
    
    SCnMadeInChina sCnMadeInChinaQuery = new SCnMadeInChina();
    sCnMadeInChinaQuery.setAppendTime("1513158597822");
    Map<String , CompareOp[]> filterParam =  new HashMap<>();
    filterParam.put("appendTime", new CompareOp[]{CompareOp.GREATER_OR_EQUAL});
    
    //查询
    List<SCnMadeInChina> madeInChinaList = hbaseService.findByExample(filterParam,sCnMadeInChinaQuery,SCnMadeInChina.class);
```