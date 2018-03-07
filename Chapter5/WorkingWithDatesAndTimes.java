import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class WorkingWithDatesAndTimes {
	
	public static void main(String[] args){
		
		WorkingWithDatesAndTimes w = new WorkingWithDatesAndTimes();
		//w.printZoneId();
		//w.printPeriodAndDuration();
		//w.daylightSavings();
		w.i18nAndL10n();
			
		
	}	
	public void printZoneId(){
		System.out.println(ZoneId.systemDefault());
		
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zoned1 = ZonedDateTime.of(2018, 1, 17,6, 15, 30, 200, zone);
		LocalDate date1 = LocalDate.of(2018,10,20);
		LocalTime time1 = LocalTime.of(22,53,20);
		LocalDateTime dateTime1 = LocalDateTime.of(date1,time1);
		
		ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
		ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);
		System.out.println(zoned1);
		System.out.println(zoned2);
		System.out.println(zoned3);
		ZoneId.getAvailableZoneIds().stream()
				.filter(z -> z.contains("Australia") || z.contains("Perth"))
				.sorted().forEach(System.out::println);
				
	}
	public void printPeriodAndDuration(){ 
	
		System.out.println(Period.of(3,0,1));//P31D
		System.out.println(Period.ofWeeks(3)); //P21D
		System.out.println(Period.ofWeeks(6)); //P42D
		
		//one way
		Duration daily = Duration.ofDays(3); // PT72H
		Duration hourly = Duration.ofHours(1); // PT1H
		Duration everyMinute = Duration.ofMinutes(1); // PT1M
		Duration everyTenSeconds = Duration.ofSeconds(10); // PT10S
		Duration everyMilli = Duration.ofMillis(1); // PT0.001S
		Duration everyNano = Duration.ofNanos(1); // PT0.000000001S
		//the other way
		daily = Duration.of(1, ChronoUnit.DAYS );//12hrs
		Duration every12Hours = Duration.of(1, ChronoUnit.HALF_DAYS );//12hrs
		hourly = Duration.of(1, ChronoUnit.HOURS);
		everyMinute = Duration.of(1, ChronoUnit.MINUTES);
		everyTenSeconds = Duration.of(10, ChronoUnit.SECONDS);
		everyMilli = Duration.of(1, ChronoUnit.MILLIS);
		everyNano = Duration.of(1, ChronoUnit.NANOS);
		System.out.println(daily);
		
		LocalTime one = LocalTime.of(5, 05);
		LocalTime two = LocalTime.of(6, 55);
		LocalDate date = LocalDate.of(2016, 1, 20);
		System.out.println(ChronoUnit.HOURS.between(one, two)); // 1 - truncates rather then rounds
		System.out.println(ChronoUnit.MINUTES.between(one, two)); // 
		
		date = LocalDate.of(2015, 1, 20);
		LocalTime time = LocalTime.of(6, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		Duration duration = Duration.ofHours(6);
		System.out.println(dateTime.plus(duration)); // 2015–01–20T12:15
		System.out.println(time.plus(duration)); // 12:15
		
	}
	
	public void printInstant(){
		LocalDate date = LocalDate.of(2015, 5, 25);
		LocalTime time = LocalTime.of(11, 55, 00);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
		Instant instant = zonedDateTime.toInstant(); // 2015–05–25T15:55:00Z
		System.out.println(zonedDateTime); // 2015–05–25T11:55–04:00[US/Eastern]
		System.out.println(instant); // 2015–05–25T15:55:
		
		Instant nextDay = instant.plus(1, ChronoUnit.DAYS);
		System.out.println(nextDay); // 2015–05–26T15:55:00Z
		Instant nextHour = instant.plus(1, ChronoUnit.HOURS);
		System.out.println(nextHour); // 2015–05–25T16:55:00Z
		Instant nextWeek = instant.plus(1, ChronoUnit.WEEKS); // exception
	
	}
	public void daylightSavings (){
		LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
		System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
		dateTime = dateTime.plusHours(1);
		System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]
		
		date = LocalDate.of(2016, Month.MARCH, 13);
		time = LocalTime.of(2, 30);
		dateTime = ZonedDateTime.of(date, time, zone);
		//time moved forward because it does not exist.
		System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]
	}
	
	public void i18nAndL10n (){//internationalization and location
	
		Locale locale = Locale.getDefault();
		System.out.println(locale); //en_AU
		System.out.println(Locale.GERMAN); // de
		System.out.println(Locale.GERMANY); // de_DE
		
		System.out.println(new Locale("fr")); // fr
		System.out.println(new Locale("hi", "IN")); // hi_IN
		
		Locale l1 = new Locale.Builder()
									.setLanguage("en")
									.setRegion("US")
									.build();
		Locale l2 = new Locale.Builder()
									.setRegion("US")
									.setLanguage("en")
									.build();
						
		Locale.setDefault(l1); // change the default
		System.out.println(Locale.getDefault()); // fr
	}
		
}