package com.spring.mvc.dao;

import com.spring.mvc.dao.entity.Account;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mr.PanYang on 2018/5/17.
 */
public interface JdbcDao {

    Object test();

    boolean addMoney(int userId, float money);

    boolean minusMoney(int userId, float money);

    Account findById(int serializable);

    List<Account> findList();

}
