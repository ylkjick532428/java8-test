package java8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Java8Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Java8Test8 java8tester = new Java8Test8();
		java8tester.testLocalDateTime();
		java8tester.testZonedDateTime();
		java8tester.testChromoUnits();
		java8tester.testPeriod();
		java8tester.testDuration();
		java8tester.testAdjusters();
		java8tester.testBackwardCompatability();
	}

	public void testLocalDateTime() {
		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("Current date1: " + date1);

		Month month = currentTime.getMonth();
		int day = currentTime.getMinute();
		int seconds = currentTime.getSecond();
		System.out.println("Month: " + month + " day: " + day + " seconds: " + seconds);

		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(12);
		System.out.println(date2);

		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println(date3);

		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println(date4);

		LocalTime date5 = LocalTime.parse("22:23:34");
		System.out.println(date5);

	}

	/**
	 * zoned test
	 */
	public void testZonedDateTime() {
		ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Shanghai]");
		System.out.println(date1);

		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId: " + id);

		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("CurrentZone: " + currentZone);
	}

	public void testChromoUnits() {
		LocalDate today = LocalDate.now();
		System.out.println("Current time: " + today);

		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("next week date: " + nextWeek);

		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("next year date: " + nextYear);

		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("next decade date: " + nextDecade);

	}

	public void testPeriod() {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);

		Period period = Period.between(date2, date1);
		System.out.println(period);

	}

	public void testDuration() {
		LocalTime time1 = LocalTime.now();
		Duration twoHours = Duration.ofHours(2);

		LocalTime time2 = time1.plus(twoHours);
		System.out.println(time1 + " " + time2);

		Duration duration = Duration.between(time1, time2);
		System.out.println("Duration " + duration);
	}

	public void testAdjusters() {
		LocalDate date1 = LocalDate.now();
		System.out.println(date1);

		LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("Next Tuesday on: " + nextTuesday);

		LocalDate firstInYear = LocalDate.of(date1.getYear(), date1.getMonth(), 1);
		System.out.println(firstInYear);

		LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
				.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday on : " + secondSaturday);
	}
	
	public void testBackwardCompatability() {
	      //Get the current date
	      Date currentDate = new Date();
	      System.out.println("Current date: " + currentDate);
			
	      //Get the instant of current date in terms of milliseconds
	      Instant now = currentDate.toInstant();
	      ZoneId currentZone = ZoneId.systemDefault();
			
	      LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
	      System.out.println("Local date: " + localDateTime);
			
	      ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
	      System.out.println("Zoned date: " + zonedDateTime);
	   }


}
