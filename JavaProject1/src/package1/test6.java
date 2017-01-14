package package1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test6 {

	public static void main(String[] args){
	    SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");  
	    Long time=System.currentTimeMillis(); 
	    String d = format.format(time);  
	    Date date = null;
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    System.out.println("Format To String(Date):"+d);  
	    System.out.println("Format To Date:"+date);
		
	}
}
