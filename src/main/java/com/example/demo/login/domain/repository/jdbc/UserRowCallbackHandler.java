package com.example.demo.login.domain.repository.jdbc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

public class UserRowCallbackHandler implements RowCallbackHandler {

	@Override
	public void processRow(ResultSet rs) throws SQLException {

		File file = new File("sample.csv");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()))) {
			do {
				String str = rs.getString("user_id")
						+ "," + rs.getString("password")
						+ "," + rs.getString("user_name")
						+ "," + rs.getDate("birthday")
						+ "," + rs.getInt("age")
						+ "," + rs.getBoolean("marriage")
						+ "," + rs.getString("role");
				bw.write(str);
				bw.newLine();
			} while (rs.next());
			bw.flush();
		} catch (IOException e) {
			throw new SQLException(e);
		}
	}
}
