package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{
	
	private int myInt;
	private int myOtherInt;
	private long myLong;
	private String myString;
	private boolean myBool;
	
	public MyAllTypesFirst() {

	}
	
	public MyAllTypesFirst(int i, int j, long k, String string, boolean b) {
		this.myInt = i;
		this.myOtherInt = j;
		this.myLong = k;
		this.myString = string;
		this.myBool = b;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null || getClass() != obj.getClass()) 
			return false;

		MyAllTypesFirst my1 = (MyAllTypesFirst) obj;

		if (myInt != my1.myInt) 
			return false;
		if (myLong != my1.myLong) 
			return false;
		if (myBool != my1.myBool) 
			return false;
		
		return myString.equals(my1.myString);

	}

	public int getmyInt() {
		return myInt;
	}
	public void setmyInt(int myInt) {
		this.myInt = myInt;
	}
	
	public int getmyOtherInt() {
		return myOtherInt;
	}
	public void setmyOtherInt(int myOtherInt) {
		this.myOtherInt = myOtherInt;
	}
	
	public long getmyLong() {
		return myLong;
	}
	public void setmyLong(long myLong) {
		this.myLong = myLong;
	}
	
	public String getmyString() {
		return myString;
	}
	public void setmyString(String myString) {
		this.myString = myString;
	}
	
	public boolean getmyBool() {
		return myBool;
	}
	public void setmyBool(boolean myBool) {
		this.myBool = myBool;
	}
	
	@Override
	public String toString() {
		return "Type: MyAllTypesFirst\n{ " +
				"myInt=" + myInt +
				"\n  myLong=" + myLong +
				"\n  myString=" + myString +
				"\n  myBool=" + myBool +
				" }";
	}
}
