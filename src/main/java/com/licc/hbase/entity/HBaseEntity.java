package com.licc.hbase.entity;

import org.apache.hadoop.hbase.util.Bytes;


public abstract class HBaseEntity {

    public static final String FAMILY_NAME = "c";
    public static final byte[] FAMILY_NAME_BYTES = Bytes.toBytes(FAMILY_NAME);
    protected static final String TABLE_PREFIX = "JSpider_";


}
