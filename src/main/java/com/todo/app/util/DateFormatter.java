package com.todo.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'";
	public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

	private DateFormatter() {
	}

	/**
	 * Gets the formatted date.
	 *
	 * @param dueDate the due date
	 * @return the formatted date
	 */
	public static String getFormattedDate(String dueDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
		Date date = null;
		try {
			date = simpleDateFormat.parse(dueDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
		return sdf.format(date);
	}
}
