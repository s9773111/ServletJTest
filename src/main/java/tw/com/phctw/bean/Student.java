package tw.com.phctw.bean;

import java.sql.Date;

public class Student {
	String sno;
	String sname;
	Date sbday;
	Integer ssex;
	String sid;
	
	//新增年齡
	Integer age;
	
	public Student() {
		super();
	}
	
	public Student(String sno, String sname, Date sbday, Integer ssex, String sid) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sbday = sbday;
		this.ssex = ssex;
		this.sid = sid;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getSbday() {
		return sbday;
	}
	public void setSbday(Date sbday) {
		this.sbday = sbday;
	}
	public Integer getSsex() {
		return ssex;
	}
	public void setSsex(Integer ssex) {
		this.ssex = ssex;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
}
