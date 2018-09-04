package com.spring.mvc.service.impl;

import com.spring.mvc.dao.JdbcDao;
import com.spring.mvc.dao.entity.Account;
import com.spring.mvc.service.JdbcInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mr.PanYang on 2018/5/17.
 */
@Service
public class JdbcInterfaceImpl implements JdbcInterface {

    @Autowired
    private JdbcDao jdbcDao;

    @Override
    public void test() {
        Object object = jdbcDao.test();
        System.out.println(object);
    }

    @Override
    public boolean transfer(float money, int from, int to) throws Exception {
        if (money > 0) {
            this.jdbcDao.minusMoney(from, money);
//            int i = 1 / 0;
            this.jdbcDao.addMoney(to, money);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Account findById(int serializable) throws Exception {
        return jdbcDao.findById(serializable);
    }

    @Override
    public List<Account> findList() throws Exception {
        return jdbcDao.findList();
    }
}
