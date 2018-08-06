package com.javaee.jefferson.pucnasdaq.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.javaee.jefferson.pucnasdaq.domain.AuthEmail;

public class UserEmailConfig {

	AuthEmail result;
	InputStream inputStream;
 
	public AuthEmail getPropValues() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "auth.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			AuthEmail _user = new AuthEmail();
			_user.setPassword(prop.getProperty("password"));
			_user.setUser(prop.getProperty("user"));

			return _user;
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		
		return result;
	}
	
}
