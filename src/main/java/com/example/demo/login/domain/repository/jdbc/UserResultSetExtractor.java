package com.example.demo.login.domain.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.demo.login.domain.model.User;

public class UserResultSetExtractor implements ResultSetExtractor<List<User>> {

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<User> userList = new ArrayList<>();
		
		UserRowMapper userRowMapper = new UserRowMapper();
		int rowNum = 0;
		while (rs.next()) {
			User user = userRowMapper.mapRow(rs, rowNum);
			userList.add(user);
			rowNum += 1;
		}

		if (userList.size() == 0) {
			throw new EmptyResultDataAccessException(1);
		}

		return userList;
	}
}
