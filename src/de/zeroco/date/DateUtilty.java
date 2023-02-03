package de.zeroco.date;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import de.zeroco.dao.Utility;

public class DateUtilty {
	/**
	 * this method will add minutes  to the given time 
	 * @author sujwal b
	 * @since 2022-12-16
	 * @param minutes
	 * @param date
	 * @return date
	 */
	public static Date addMinToTime(int minutes, Date date) {
		if (Utility.isBlank(date)) {
			return null;
		}
		return new Date((date.getTime() + (minutes*60000)));
	}
	
	/**
	 * this method will adds the duration to the given date
	 * @author sujwal b
	 * @since 2022-12-16
	 * @param input
	 * @param format
	 * @param durationType
	 * @param duration
	 * @return date
	 */
	public static String addDurationToDate(Date input, String format, String durationType, int duration) {
		if (Utility.isBlank(format)||Utility.isBlank(durationType)||Utility.isBlank(duration)) {
			return "";
		}
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
		LocalDateTime start = LocalDateTime.ofInstant(input.toInstant(), ZoneId.systemDefault());
		if (durationType.equalsIgnoreCase("days")) {
			return start.plusDays(duration).format(dateFormat);
		} else if (durationType.equalsIgnoreCase("months")) {
			return start.plusMonths(duration).format(dateFormat);
		} else if (durationType.equalsIgnoreCase("years")) {
			return start.plusYears(duration).format(dateFormat);
		}
		return start.format(dateFormat);
	}
	
	/**
	 * this method subtract the duration to the given date
	 * @author sujwal b
	 * @since 2022-12-16
	 * @param input
	 * @param format
	 * @param durationType
	 * @param duration
	 * @return date
	 */
	public static String subtractDurationToDate(Date input, String format, String durationType, int duration) {
		if (Utility.isBlank(format)||Utility.isBlank(durationType)||Utility.isBlank(duration)) {
			return "";
		}
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
		LocalDateTime start = LocalDateTime.ofInstant(input.toInstant(), ZoneId.systemDefault());
		if (durationType.equalsIgnoreCase("days")) {
			return start.minusDays(duration).format(dateFormat);
		} else if (durationType.equalsIgnoreCase("months")) {
			return start.minusMonths(duration).format(dateFormat);
		} else if (durationType.equalsIgnoreCase("years")) {
			return start.minusYears(duration).format(dateFormat);
		}
		return start.format(dateFormat);
	}
	public static String subtractDurationToDate(String input,int days) {
		if (Utility.isBlank(input)) {
			return null;
		}
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(input, dateFormat);
		return date.minusDays(days).toString();	
	}
	public static int ageCalculator(String input,LocalDate curreDate) {
		if (Utility.isBlank(input)) {
			return 0;
		}
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(input, dateFormat);
		Period period = Period.between(date, curreDate);
		return period.getYears();
	}
	/**
	 * this method will converts the given date to string in the specified format
	 * @author sujwal b
	 * @since 2022-12-16
	 * @param date
	 * @param format
	 * @return date 
	 */
	public static String dateToString(Date date, String format) {
		if (Utility.isBlank(date)||Utility.isBlank(format)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	/**
	 * this method will converts the given date to string 
	 * @author sujwal b
	 * @since 2022-12-16
	 * @param date
	 * @return date 
	 */
	public static String dateToString(Date date) {
		if (Utility.isBlank(date)) 
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}
	
	/**
	 * this method will convert the string to date 
	 * @author sujwal b
	 * @since 2022-12-16 
	 * @param date
	 * @return date
	 */
	public static Date stringToDate(String date) {
		if (Utility.isBlank(date)) 
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date output = null;
		try {
			output = dateFormat.parse(date);
			return output;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return output;
	}
	/**
	 * this method will converts the string to date according to given datepattern
	 * @author sujwal b
	 * @since 2022-12-16
	 * @param date
	 * @param format
	 * @return date
	 */
	public static Date stringToDate(String date,String format) {
		if (Utility.isBlank(date)) 
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date output = null;
		try {
			output = dateFormat.parse(date);
			return output;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return output;
	}

	public static String getIndianFormat(double input) {
		if (input <= 1000) {
			return getFormat(",###.00", input);
		} else {
			return getFormat(",##", (int) (input / 1000)) + "," + getFormat("###", (int) (input % 1000)) + ".00";
		}
	}

	public static String getUSFormat(double input) {
		return getFormat(",###", input);

	}

	public static String getFormat(String format, double input) {
		if (Utility.isBlankWithVarArguments(format, input)) {
			return "";
		}
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(input);
	}

	public static void main(String[] args) {
		System.out.println(getFormat(null, 456135));
		System.out.println(getUSFormat(456445454));
		System.out.println(getIndianFormat(100000456));
		System.out.println(stringToDate("22/12/2022"));
		System.out.println(stringToDate("22-12-2022", "dd-MM-yy"));
	}

	/**
	 * this method will compares the given dates and gives the latest date
	 * 
	 * @author sujwal b
	 * @since 2022-12-16
	 * @param dateOne
	 * @param dateTwo
	 * @return date
	 */
	public static Date compare(Date dateOne, Date dateTwo) {
		if (dateOne.compareTo(dateTwo) < 0) {
			return dateTwo;
		} else if (dateOne.compareTo(dateTwo) > 0) {
			return dateOne;
		}
		return dateTwo;
	}

	public static long subtractTwoDates(String fromDate, String toDate) {
		if (Utility.isBlank(fromDate) || Utility.isBlank(toDate)) {
			return 0;
		}
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dateOne = format.parse(fromDate);
			Date dateTwo = format.parse(toDate);
			long difference = dateTwo.getTime() - dateOne.getTime();
			return (difference / (1000 * 60 * 60 * 24));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String subtractToDates(String dateOne, String dateTwo) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate one = LocalDate.parse(dateOne, dateFormat);
		LocalDate two = LocalDate.parse(dateTwo, dateFormat);
		System.out.println(one.getYear());
		System.out.println(one);
		System.out.println(two);
		return null;

	}
	}
