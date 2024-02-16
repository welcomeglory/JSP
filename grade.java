package edu.sejong.ex;

public class grade{
	private String name;
	private double kor;
	private double eng;
	private double math;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getKor() {
		return kor;
	}
	public void setKor(double kor) {
		this.kor = kor;
	}
	public double getEng() {
		return eng;
	}
	public void setEng(double eng) {
		this.eng = eng;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public double getSum() {
		return kor+eng+math;
	}	
	public double getAvg() {
		return (kor+eng+math)/3.0 ;
	}
	public String getGrades() {
		String str = null;
		if(getAvg()>=90)
				str="수 입니다.";
		else if(getAvg()>=80)
			str="우 입니다.";
		else if(getAvg()>=70)
			str="미 입니다.";
		else if(getAvg()>=60)
			str="양 입니다.";
		else	
			str="가 입니다.";		
		return str;
	}
	
	

}
