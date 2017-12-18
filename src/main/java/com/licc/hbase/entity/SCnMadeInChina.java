package com.licc.hbase.entity;

import org.apache.hadoop.hbase.util.Bytes;

import com.alibaba.fastjson.JSONObject;


public class SCnMadeInChina extends HBaseEntity {
    public final static String TAB_NAME = TABLE_PREFIX + "cn.made-in-china.com";

    public final static byte[] COL_CLEANED = Bytes.toBytes("cleaned");
    public final static byte[] COL_CLEANEDERRORMSG = Bytes.toBytes("cleanedErrorMsg");
    public final static byte[] COL_APPENDTIME = Bytes.toBytes("appendTime");
    public final static byte[] COL_CERTSIGN = Bytes.toBytes("certsign");
    public final static byte[] COL_COMPANYNAME = Bytes.toBytes("companyName");
    public final static byte[] COL_DELIVERYTIME = Bytes.toBytes("deliveryTime");
    public final static byte[] COL_DETAILDESC = Bytes.toBytes("detailDesc");
    public final static byte[] COL_HTMLDESCRIPTION = Bytes.toBytes("htmldescription");
    public final static byte[] COL_HTMLKEYWORDS = Bytes.toBytes("htmlkeywords");
    public final static byte[] COL_HTMLTITILE = Bytes.toBytes("htmltitile");
    public final static byte[] COL_LEVELTYPE = Bytes.toBytes("levelType");
    public final static byte[] COL_LINK = Bytes.toBytes("link");
    public final static byte[] COL_LINKDDRESS = Bytes.toBytes("linkAddress");
    public final static byte[] COL_LINKMAN = Bytes.toBytes("linkMan");
    public final static byte[] COL_LINKTEL = Bytes.toBytes("linkTel");
    public final static byte[] COL_LOCAL = Bytes.toBytes("local");
    public final static byte[] COL_PAYTYPE = Bytes.toBytes("payType");
    public final static byte[] COL_PRICELIST = Bytes.toBytes("priceList");
    public final static byte[] COL_PRODUCTLARGEIMAGE = Bytes.toBytes("productLargeImage");
    public final static byte[] COL_PRODUCTNAME = Bytes.toBytes("productName");
    public final static byte[] COL_PRODUCTPARAM = Bytes.toBytes("productParam");
    public final static byte[] COL_PRODUCTSMALLIMAGE = Bytes.toBytes("productSmallImage");
    public final static byte[] COL_SITE = Bytes.toBytes("site");
    public final static byte[] COL_TOTAL = Bytes.toBytes("total");
    public final static byte[] COL_TYPE = Bytes.toBytes("type");
    public final static byte[] COL_KEY = Bytes.toBytes("key");
    public final static byte[] COL_MEASURE = Bytes.toBytes("measure");

    private String rowKey;

    private String appendTime;
    private String certsign;
    private String companyName;
    private String deliveryTime;
    private String detailDesc;
    private String htmldescription;
    private String htmlkeywords;
    private String htmltitile;
    private String levelType;
    private String link;
    private String linkddress;
    private String linkMan;
    private String linkTel;
    private String local;
    private String payType;
    private JSONObject priceList;
    private String productLargeImage;
    private String productName;
    private JSONObject productParam;
    private String productSmallImage;
    private String site;
    private String total;
    private String type;
    private String key;

    private String measure;

    /**
     *
     */
    private Integer cleaned;
    private String cleanedErrorMsg;

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public String getAppendTime() {
        return appendTime;
    }

    public void setAppendTime(String appendTime) {
        this.appendTime = appendTime;
    }

    public String getCertsign() {
        return certsign;
    }

    public void setCertsign(String certsign) {
        this.certsign = certsign;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getHtmldescription() {
        return htmldescription;
    }

    public void setHtmldescription(String htmldescription) {
        this.htmldescription = htmldescription;
    }

    public String getHtmlkeywords() {
        return htmlkeywords;
    }

    public void setHtmlkeywords(String htmlkeywords) {
        this.htmlkeywords = htmlkeywords;
    }

    public String getHtmltitile() {
        return htmltitile;
    }

    public void setHtmltitile(String htmltitile) {
        this.htmltitile = htmltitile;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkddress() {
        return linkddress;
    }

    public void setLinkddress(String linkddress) {
        this.linkddress = linkddress;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public JSONObject getPriceList() {
        return priceList;
    }

    public void setPriceList(JSONObject priceList) {
        this.priceList = priceList;
    }

    public String getProductLargeImage() {
        return productLargeImage;
    }

    public void setProductLargeImage(String productLargeImage) {
        this.productLargeImage = productLargeImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public JSONObject getProductParam() {
        return productParam;
    }

    public void setProductParam(JSONObject productParam) {
        this.productParam = productParam;
    }

    public String getProductSmallImage() {
        return productSmallImage;
    }

    public void setProductSmallImage(String productSmallImage) {
        this.productSmallImage = productSmallImage;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getCleaned() {
        return cleaned;
    }

    public void setCleaned(Integer cleaned) {
        this.cleaned = cleaned;
    }

    public String getCleanedErrorMsg() {
        return cleanedErrorMsg;
    }

    public void setCleanedErrorMsg(String cleanedErrorMsg) {
        this.cleanedErrorMsg = cleanedErrorMsg;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
