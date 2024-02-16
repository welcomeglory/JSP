package edu.sejong.ex;

public class Circle{
	private double r;

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	
	public double getArea() {
		return Math.PI*r*r;
	}	

}
