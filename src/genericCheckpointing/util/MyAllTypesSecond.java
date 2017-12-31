package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
	
	private double myDoubleT;
	private double myOtherDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	
	public MyAllTypesSecond() {

	}

	public MyAllTypesSecond(double i, double j, float d, short k, char c) {
		this.myDoubleT = i;
		this.myOtherDoubleT = j;
		this.myFloatT = d;
		this.myShortT = k;
		this.myCharT = c;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null || getClass() != obj.getClass()) 
			return false;

		MyAllTypesSecond my2 = (MyAllTypesSecond) obj;

		if (my2.myDoubleT != myDoubleT) 
			return false;
		if (my2.myFloatT != myFloatT) 
			return false;
		if (myShortT != my2.myShortT) 
			return false;
		
		return myCharT == my2.myCharT;

	}

	public double getmyDoubleT() {
		return myDoubleT;
	}
	public void setMyDoubleT(double myDoubleT) {
		this.myDoubleT = myDoubleT;
	}
	
	public double getmyOtherDoubleT() {
		return myOtherDoubleT;
	}
	public void setMyOtherDoubleT(double myOtherDoubleT) {
		this.myOtherDoubleT = myOtherDoubleT;
	}
	
	public float getmyFloatT() {
		return myFloatT;
	}
	public void setMyFloatT(float myFloatT) {
		this.myFloatT = myFloatT;
	}
	
	public short getmyShortT() {
		return myShortT;
	}
	public void setMyShortT(short myShortT) {
		this.myShortT = myShortT;
	}
	
	public char getmyCharT() {
		return myCharT;
	}
	public void setMyCharT(char myCharT) {
		this.myCharT = myCharT;
	}
	

	@Override
	public String toString() {
		return "Type: MyAllTypesSecond\n{ " +
				"myDoubleT=" + myDoubleT +
				"\n  myFloatT=" + myFloatT +
				"\n  myShortT=" + myShortT +
				"\n  myCharT=" + myCharT +
				" }";
	}
	
	
	
}