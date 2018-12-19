package com.oukele.learning.aop4;

import java.sql.Connection;

public class JDBC {

    public static ThreadLocal<Connection> threadLocal = null;

    //得到连接
    public static Connection getConne(){
        return threadLocal.get();
    }


}
