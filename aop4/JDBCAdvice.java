package com.oukele.learning.aop4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@Aspect
public class JDBCAdvice {//切面类

    @Around("execution(* *.add(..))")
    public Object add(ProceedingJoinPoint joinPoint) throws Throwable {
        Connection connection = null;
        try {
            //数据库驱动
            Class.forName("org.mariadb.jdbc.Driver");
            //连接数据库
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","oukele","oukele");
            connection.setAutoCommit(false);//将自动提交事务关闭

            //ThreadLocal变量的活动范围为某线程，是该线程“专有的，独自霸占”的，对该变量的所有操作均由该线程完成
            //因为ThreadLocal.set() 到线程中的对象是该线程自己使用的对象，其他线程是不需要访问的，也访问不到的。
            // 当线程终止后，这些值会作为垃圾回收
           JDBC.threadLocal = new ThreadLocal<Connection>();
           JDBC.threadLocal.set(connection);

            Object proceed = joinPoint.proceed();//执行被代理对象的方法
            //被代理方法执行完毕后，提交事务
            connection.commit();
            return proceed;

        } catch (ClassNotFoundException e) {
            System.out.println("没有找到数据库驱动，详细信息:" + e.getMessage());
            throw e;
        } catch (SQLException e) {
            System.out.println("连接数据库出现错误，错误信息：" + e.getMessage());
            throw e;
        } catch (Throwable throwable) {
            if( connection != null ){
                try {
                    connection.rollback();//回滚事务
                } catch (SQLException e) {
                    System.out.println("事务回滚");
                }
            }
            throw throwable;
        }finally {
            if( connection != null){
                try {
                    connection.close();//关闭数据库
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

