package com.spring.mvc.dynamicdatasource;

/**
 * Created by Mr.PanYang on 2018/5/17.
 */
public class DataSourceHolder {

    public static final String dataSourceOne = "dataSourceOne";
    public static final String dataSourceTwo = "dataSourceTwo";
    //线程本地环境
    private static final ThreadLocal<String> dataSources = new ThreadLocal<>();

    //设置数据源
    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
    }

    //获取数据源
    public static String getDataSource() {
        return dataSources.get();
    }

    //清除数据源
    public static void clearDataSource() {
        dataSources.remove();
    }
}
