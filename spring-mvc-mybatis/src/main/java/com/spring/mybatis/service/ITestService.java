package com.spring.mybatis.service;

import com.spring.mybatis.model.Account;
import com.spring.mybatis.model.User;

import java.util.List;

public interface ITestService {

    public void test();

    public boolean transfer(float money, int from, int to) throws Exception;

    public int insertAccount(Account account) throws Exception;

    public Account findAccountById(int i);

    public User findUserById(int i);

    public List<Account> findAccountsById(int i);
}
