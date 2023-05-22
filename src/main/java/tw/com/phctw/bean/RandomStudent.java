package tw.com.phctw.bean;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

public class RandomStudent {
	//有沒有重複資訊，可去抓最大值 再往後增加
	public static Student getStudent(int nummax) {
		Student stu = new Student();
		stu.setSno(getNo(nummax));
		stu.setSname(getName());
		stu.setSbday(getDate());
		stu.setSsex(getSex());
		stu.setSid(getId());
		return stu;
	}
	
	//算出年齡
	public static int getAgeByBirth(Date birthday) {
		//日曆，從Calendar物件中獲得Date物件
		Calendar cal = Calendar.getInstance();
		//學生出生日期放入Calendar類型中
		Calendar bir = Calendar.getInstance();
		bir.setTime(birthday);
		
		//取出目前年月日
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow =  cal.get(Calendar.MONTH);
		int dayNow = cal.get(Calendar.DAY_OF_MONTH);
		
		//取出出生年月日
		int yearBirth = bir.get(Calendar.YEAR);
		int monthBirth = bir.get(Calendar.MONTH);
		int dayBirth = bir.get(Calendar.DAY_OF_MONTH);
		//年齡當前減去出生年
		int age = yearNow - yearBirth;
		//若目前月份小於出生月份，或是目前月等於出生月但日期小於出生日，年齡-1
		if(monthNow<monthBirth || (monthNow==monthBirth && dayNow<dayBirth)) {
			age--;
		}
		return age;
	}
	
	//編號
	public static String getNo(int nummax) {
		//補0 String.format("%04d", rannum)
		int num = nummax+1;
		String num2 = String.format("%04d", num);
		String sno = "A"+num2;
		return sno;
	}
	
	//姓名
	public static String getName() {
		String[] firstNameArray = {"李", "王", "張", "劉", "陳", "楊", "趙", "黃", "周", "吳", "徐", "孫", "胡", "朱", "高", "歐陽", "太史", "端木", "上官", "司馬"};
		String[] lastNameArray = { "偉", "勇", "軍", "磊", "濤", "斌", "強", "鵬", "傑", "峰", "超", "波", "輝", "剛", "健", "明", "亮","俊", "飛", "凱", "浩", "華", "平", "鑫", "毅", "林", "洋", "宇", "敏", "寧", "建", "兵", "旭", "雷", "鋒", "彬", "龍", "翔", "陽", "劍", "靜", "敏", "燕", "艷", "麗", "娟", "莉", "芳", "萍", "玲", "娜", "丹", "潔", "紅", "穎", "琳", "霞", "婷", "慧", "瑩", "晶", "華", "倩", "英", "佳", "梅", "雪", "蕾", "琴", "璐", "偉", "雲", "蓉", "青", "薇", "欣", "瓊", "寧", "平", "媛"};
		
		int firstPos = (int)(Math.random() * 20);
		StringBuilder name = new StringBuilder(firstNameArray[firstPos]);
		int lastLen = (int)(Math.random()*2)+1;
		
		for(int i=0;i<lastLen;i++) {
			int lastPos = (int)(Math.random() * 80);
			name.append(lastNameArray[lastPos]);
		}
		
		return name.toString();
	}
	
	//出生日範圍在1980.1.1-2005.12.31
	public static Date getDate() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		
		cal.set(1980, 0, 1);
		long minMillis = cal.getTimeInMillis();
		cal.set(2005, 0, 1);
		long maxMillis = cal.getTimeInMillis();
		
		long millis = (long)((maxMillis - minMillis) * (Math.random()))+minMillis;
		
		return (new Date(millis));
	}
	
	//性別
	public static Integer getSex() {
		int ranNum = new Random().nextInt(2) + 1;
		return ranNum;
	}
	
	//身分證
	public static String getId() {
		//A-Z的值
		char[] characterArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		//英文字對應到的數
		int[] numArray = {10,11,12,13,14,15,16,17,34,18,19,20,21,22,35,23,24,25,26,27,28,29,32,30,31,33}; 
		//身分證字串
		String result = "";
		//驗證碼
		int checksum = 0;
		
		//產生第一個字
		//隨機產生英文字的位置
		int index0 = (int)(Math.random()*26);
		//對應的英文字的數字、英文
		int id0num = numArray[index0];
		char id0eng = characterArray[index0];
		//System.out.println(id0num+","+id0eng);
		
		checksum += id0num/10; //加入英文字第一碼
		checksum += (id0num%10)*9; //加入英文字第二碼
		result += id0eng;
		
		//產生第二個數字 1-2
		int id1 = (int)(Math.random()*2)+1;
		checksum += id1*8;
		result += id1;
		
		//產生後7碼流水號 以及檢查號 1-9
		for(int i=1;i<8;i++) {
			int num = (int)(Math.random()*9)+1;
			result += num;
			checksum += num*(8-i);
		}
		
		//產生最後一碼
		int checksumfinal = 10-(checksum%10);
		if(checksumfinal==10) {
			checksumfinal = 0;
		}
		result += checksumfinal;
		
		return result;
		
	}
}
