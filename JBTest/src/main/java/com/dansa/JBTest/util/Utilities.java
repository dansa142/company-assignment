package com.dansa.JBTest.util;

import java.sql.Date;

public class Utilities {
	public static java.sql.Date convertDateToSql(java.util.Date date) {
		java.sql.Date sqlDate = new Date(date.getYear() - 1900, date.getMonth() - 1, date.getDate());

		return sqlDate;
	}
}
