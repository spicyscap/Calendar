import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MyCalendar {
	static final String WEEK[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
	private static int[] mDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static final int FIRSTDAY_OF_MONTH=1;
	static final int DAYS_PER_WEEK    =7;
	static final int MONTHS_PER_YEAR =12;
private final void actualDisplay(int year,int month){
	if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {mDays[2] = 29;}     //判斷閏年
	
	Calendar startDay = new GregorianCalendar(year, month - 1, FIRSTDAY_OF_MONTH);     //開始日		
	int dayOfWeek = startDay.get(Calendar.DAY_OF_WEEK);     //開始日是星期幾
	StringBuilder sb = new StringBuilder(280);     //建立StringBuilder串接
	//開始印月曆		
		System.out.printf("%12s"+year+"年"+month+"月\n"," ");
			for (String n : WEEK) { sb.append(n).append("  "); }
	sb.append("\n");
	// 第一行空白
		for (int i = 1; i < dayOfWeek; i++) {sb.append("     ");}
	// 第一行日期
		for (int i = 0; i <= (DAYS_PER_WEEK-dayOfWeek); i++){
			int dayOfFirstLine = (FIRSTDAY_OF_MONTH + i);
			sb.append( (dayOfFirstLine<10 ? ("  " + dayOfFirstLine):(" " + dayOfFirstLine)) + "  ");
		}//end of for		
	sb.append("\n");		
	int firstDayOfSecondWeek=(FIRSTDAY_OF_MONTH + (DAYS_PER_WEEK - dayOfWeek));
	int weeksRemain=(mDays[month] - firstDayOfSecondWeek) / DAYS_PER_WEEK;
	// 剩下的日期
	for (int n = 0; n <= weeksRemain; n++) {
		for (int i = 1; i <= DAYS_PER_WEEK; i++) {	
		  int dayOfOtherLine = (firstDayOfSecondWeek + i + DAYS_PER_WEEK * n);				
			if (dayOfOtherLine <= mDays[month])
				sb.append( (dayOfOtherLine<10 ? ("  " + dayOfOtherLine):(" " + dayOfOtherLine)) + "  ");
		}//end of inner for
	sb.append("\n");	
	}//end of outer for
	sb.append("=================================\n");
	System.out.print(sb);
	// 結束印月曆
}//end of actualDisplay()

public final void display(int year,int month){	//透過傳參數(year,month)來印月曆
	if(month < 0 || month > MONTHS_PER_YEAR){	//錯誤處理：數字超過範圍
		System.out.println("亂搞！");
	}else if(month==0){
		display(year);
	}else{
		System.out.printf("%14s萬年曆= = = \n", "= = =");
		actualDisplay(year, month);
	}
}//end of display()	

public final void display(int year){	//透過傳參數(year)來印月曆
	System.out.printf("%14s萬年曆= = = \n", "= = =");
	for(int i=1 ;i<=MONTHS_PER_YEAR; i++){
		int month=i;
		actualDisplay(year, month);}
}//end of display()	

public final void display(){	//透過Scan輸入來印月曆
	try{
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入年份：");
		int year = scan.nextInt();
		System.out.println("顯示整年月曆(0)；顯示當月月曆(1-12)：");
		int month = scan.nextInt();
		display(year,month);
		scan.close();	
	}catch(InputMismatchException e ){	//錯誤處理：輸入非數字
		System.out.println("亂搞！重新輸入！");
		display();  //若輸入非數字，會重來
	}//end of catch
}//end of display()
	public static void main(String[] args) {	
		MyCalendar m = new MyCalendar();
		m.display();
	}
}