public class MyCalendarMain extends MyCalendar{
	public static void main(String[] args) {
		MyCalendarMain t=new MyCalendarMain();
		
		t.display(2014,12);  //傳兩個參數：印當月月曆
		
		t.display(2015);	 //傳一個參數：印整年月曆
		
		t.display();		 //利用鍵盤輸入參數
	}

}
