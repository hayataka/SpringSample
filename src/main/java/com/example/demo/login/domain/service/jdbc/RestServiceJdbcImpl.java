package com.example.demo.login.domain.service.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;
import com.example.demo.login.domain.service.RestService;

@Transactional
@Service
public class RestServiceJdbcImpl implements RestService {

    @Autowired
    @Qualifier("UserDaoJdbcImpl")
    UserDao dao;

    @Override
    public boolean insert(User user) {

        int count = dao.insertOne(user);
        boolean result = (count > 0);
        return result;
    }

    @Override
    public User selectOne(String userId) {
        return dao.selectOne(userId);
    }

    @Override
    public List<User> selectMany() {
        return dao.selectMany();
    }

    @Override
    public boolean update(User user) {

        int count = dao.updateOne(user);
        boolean result = (count > 0);
        return result;
    }

    @Override
    public boolean delete(String userId) {
        int count = dao.deleteOne(userId);
        boolean result = (count > 0);
        return result;
    }
}