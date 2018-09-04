package com.spring.mvc.service;

import com.spring.mvc.dao.entity.Account;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mr.PanYang on 2018/5/17.
 */
public interface JdbcInterface {

    void test();

    boolean transfer(float money, int from, int to) throws Exception;

    Account findById(int serializable) throws Exception;

    List<Account> findList() throws Exception;
}
