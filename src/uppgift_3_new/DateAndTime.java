package uppgift_3_new;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {

	private String date;
	private String time;

	DateAndTime(String time) {
		this.time = time;
		setDateTime();
	}

	public void setDateTime() {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDate = sd.format(date);
		this.date = formattedDate;

	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

}
