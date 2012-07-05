package eu.jpereira.testfw;

import java.util.Date;

public class DateUtils {

	public static final long ONE_DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

	public static Date getDateInFuture(long offsetInMillis) {

		return new Date(System.currentTimeMillis() + offsetInMillis);
	}

	public static Date getDateInThePast(long offsetInMillis) {
		return new Date(System.currentTimeMillis() - offsetInMillis);
	}

	public static Date getToday() {

		return new Date();
	}

	public static Date getYesterday() {
		return DateUtils.getDateInThePast(DateUtils.ONE_DAY_IN_MILLIS);
	}

	public static Date getTomorrow() {

		return DateUtils.getDateInFuture(DateUtils.ONE_DAY_IN_MILLIS);

	}

	
}
