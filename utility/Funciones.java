package utility;

import java.time.LocalDateTime;

public class Funciones {

	public static boolean checkDateTime(String dateTimeMission) {
		boolean isCorrect = false;
		LocalDateTime localDate = LocalDateTime.now();

		String year = dateTimeMission.substring(0, 3);
		String month = dateTimeMission.substring(5, 6);
		if (month.substring(0) == "0")
			month = month.substring(1);
		String day = dateTimeMission.substring(8, 9);
		if (day.substring(0) == "0")
			day = day.substring(1);
		String hour = dateTimeMission.substring(11, 12);
		if (hour.substring(0) == "0")
			hour = hour.substring(1);
		String min = dateTimeMission.substring(14, 15);
		if (min.substring(0) == "0")
			min = min.substring(1);
		String sec = dateTimeMission.substring(17, 18);
		if (sec.substring(0) == "0")
			sec = sec.substring(1);

		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month);
		int dayInt = Integer.parseInt(day);
		int hourInt = Integer.parseInt(hour);
		int minInt = Integer.parseInt(min);
		int secInt = Integer.parseInt(sec);

		if (yearInt >= localDate.getYear()) {
			if (monthInt >= localDate.getMonthValue() && monthInt <= 12) {
				if (dayInt >= localDate.getDayOfMonth()) {
					if ((monthInt == 2 && dayInt < 28)
							|| ((monthInt == 1 || monthInt == 3 || monthInt == 5 || monthInt == 7 || monthInt == 8
									|| monthInt == 10 || monthInt == 12) && (dayInt < 31))
							|| ((monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11) && (dayInt < 30))) {
						if (hourInt >= 8 && hourInt < 20) {
							if (minInt >= 0 && minInt <= 59) {
								if (secInt >= 0 && secInt <= 59) {
									isCorrect = true;
								}
							}
						}
					}
				}
			}
		}

		return isCorrect;

	}

}
