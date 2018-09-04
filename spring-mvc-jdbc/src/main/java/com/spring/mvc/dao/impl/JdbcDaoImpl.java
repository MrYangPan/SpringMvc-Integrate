package com.spring.mvc.dao.impl;

import com.spring.mvc.dao.JdbcDao;
import com.spring.mvc.dao.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mr.PanYang on 2018/5/17.
 */
@Repository
public class JdbcDaoImpl implements JdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> test() {
        return this.jdbcTemplate.queryForList("select * from account ", Account.class);
    }

    @Override
    public boolean addMoney(int userId, float money) {
        int row = this.jdbcTemplate.update("update account set money = money + ? where id=" + userId, money);
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean minusMoney(int userId, float money) {
        int row = this.jdbcTemplate.update("update account set money = money - ? where id=" + userId, money);
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Account findById(int serializable) {
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<>(Account.class);
        Account account = this.jdbcTemplate.queryForObject("select * from account where id = ?", rowMapper, serializable);
        if (!StringUtils.isEmpty(account)) {
            return account;
        }
        return null;
    }

    @Override
    public List<Account> findList() {
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<>(Account.class);
        List<Account> list = this.jdbcTemplate.query("select id,name,money from account ", rowMapper);
        return list;
    }
}
