package com.example.demo.login.domain.repository.jdbc;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int count() throws DataAccessException {
        int count = jdbc.queryForObject("SELECT COUNT(*) FROM m_user", Integer.class);
        return count;
    }

    @Override
    public int insertOne(User user) throws DataAccessException {

    	// 使うのはupdate
        int rowNumber = jdbc.update("INSERT INTO m_user(user_id,"
                + " password,"
                + " user_name,"
                + " birthday,"
                + " age,"
                + " marriage,"
                + " role)"
                + " VALUES(?, ?, ?, ?, ?, ?, ?)",
                user.getUserId(),
                user.getPassword(),
                user.getUserName(),
                user.getBirthday(),
                user.getAge(),
                user.isMarriage(),
                user.getRole());

        return rowNumber;
    }

    @Override
    public User selectOne(String userId) throws DataAccessException {

        // １件取得
        Map<String, Object> map = jdbc.queryForMap("SELECT * FROM m_user"
                + " WHERE user_id = ?", userId);

        User user = new User();

        user.setUserId((String) map.get("user_id"));
        user.setPassword((String) map.get("password"));
        user.setUserName((String) map.get("user_name"));
        user.setBirthday((Date) map.get("birthday"));
        user.setAge((Integer) map.get("age"));
        user.setMarriage((Boolean) map.get("marriage"));
        user.setRole((String) map.get("role"));

        return user;
    }

    Function<Map<String, Object>, User> toUser = x -> {
        User user = new User();
        user.setUserId((String) x.get("user_id"));
        user.setPassword((String) x.get("password"));
        user.setUserName((String) x.get("user_name"));
        user.setBirthday((Date) x.get("birthday"));
        user.setAge((Integer) x.get("age"));
        user.setMarriage((Boolean) x.get("marriage"));
        user.setRole((String) x.get("role"));
    	return user;
    };
    
    @Override
    public List<User> selectMany() throws DataAccessException {

        List<Map<String, Object>> getList = jdbc.queryForList("SELECT * FROM m_user");        
        List<User> userList = getList.stream()
        		.map(toUser)
        		.collect((Collectors.toList()));
        return userList;
    }

    @Override
    public int updateOne(User user) throws DataAccessException {

        int rowNumber = jdbc.update("UPDATE M_USER"
                + " SET"
                + " password = ?,"
                + " user_name = ?,"
                + " birthday = ?,"
                + " age = ?,"
                + " marriage = ?"
                + " WHERE user_id = ?",
                user.getPassword(),
                user.getUserName(),
                user.getBirthday(),
                user.getAge(),
                user.isMarriage(),
                user.getUserId());

        //トランザクション確認用途
        //        if (rowNumber > 0) {
        //            throw new DataAccessException("トランザクションテスト") {
        //            };
        //        }

        return rowNumber;
    }

    @Override
    public int deleteOne(String userId) throws DataAccessException {

    	int count = jdbc.update("DELETE FROM m_user WHERE user_id = ?", userId);

        return count;
    }

    /**
     * csvにする
     */
    @Override
    public void userCsvOut() throws DataAccessException {

        String sql = "SELECT * FROM m_user";
        UserRowCallbackHandler handler = new UserRowCallbackHandler();
        jdbc.query(sql, handler);
    }
}
