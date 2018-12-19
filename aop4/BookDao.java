package com.oukele.learning.aop4;

import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class BookDao {

    public void add(String bookName) throws SQLException {

        PreparedStatement statement = JDBC.getConne().prepareStatement("insert into book(bookName) values (?)");
        statement.setObject(1, bookName);
        statement.execute();

        //测试事务回滚
//        PreparedStatement statement1 = JDBC.getConne().prepareStatement("insert into sdf(bookName) values (?)");
//        statement1.setObject(1, bookName);
//        statement1.execute();

    }

}
