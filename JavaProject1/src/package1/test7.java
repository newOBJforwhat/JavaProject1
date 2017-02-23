package package1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class test7 {
	public static void main(String[] args){
		long[] section = new long[2];
		String currentTime = test7.getTimeFromLong2(System.currentTimeMillis());
		int year = Integer.parseInt(currentTime.substring(0, 4));
		int month = Integer.parseInt(currentTime.substring(5, 7));
		int lastMonth = 0;
		if(month == 1)
		{
			year = year -1;
			lastMonth = 12;
		}
		else
			lastMonth = month - 1;
		StringBuilder from = new StringBuilder();
		from.append(year);
		from.append("-");
		from.append(lastMonth);
		from.append("-");
		from.append("01");
		System.out.println(from.toString());
		try {
			section[0] = test7.getTime2(from.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		StringBuilder to = new StringBuilder();
		to.append(year);
		to.append("-");
		to.append(month);
		to.append("-");
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			to.append("31");
		}else if(month == 2){
			to.append("28");
		}else if(month == 4 || month == 6 || month == 9 || month == 11){
			to.append("30");
		}
		try {
			section[1] = test7.getTime2(to.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将long形式的时间转为yyyy-MM-dd形式
	 * @param time
	 * @return
	 */
	public static String getTimeFromLong2(long time){
		if(time < 1000000000000L){
			time = time * 1000;
		}
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		return sd.format(new Date(time));
	}
	
	/**
	 * 将字符串形式的时间转化为long类型的时间形式。
	 * @param time 格式为：yyyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static long getTime2(String time) throws ParseException{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		//由string类型的时间获取long类型的时间值
		Date d = sd.parse(time);
		return d.getTime();
	}
}
