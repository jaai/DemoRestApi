package com.jazz.restapidemo.utils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommanUtils {

	public Date convertToDate(String date) {
		Date Cdate = null;
		try {
			DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			Cdate = (Date) formatter.parse(date);
			System.out.println(Cdate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Cdate;

	}

	public Date convertToDateFromURL(String date) {
		Date date1 = null;

		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;

	}
}