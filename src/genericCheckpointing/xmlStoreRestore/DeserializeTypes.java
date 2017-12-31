package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeserializeTypes {

	public void deserInt(int value, String tagName, Object object) {
		Class[] clsInt = new Class[1];
		clsInt[0] = Integer.TYPE;
		Method setterMethod = null;
		String xmlString = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			setterMethod = object.getClass().getMethod(xmlString, clsInt);
			setterMethod.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception Caught " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

    public void deserLong(long value, String tagName, Object object) {
		Class[] clsDouble = new Class[1];
		clsDouble[0] = Long.TYPE;
		Method setterMethod;
		String xmlString = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			setterMethod = object.getClass().getMethod(xmlString, clsDouble);
			setterMethod.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception Caught " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	
	public void deserString(String value, String tagName, Object object) {
		Class[] paramString = new Class[1];
		paramString[0] = String.class;
		Method setterMethod = null;
		String xmlString = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			setterMethod = object.getClass().getMethod(xmlString, paramString);
			setterMethod.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception Caught " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	public void deserBoolean(boolean value, String tagName, Object object) {
		Class[] paramBoolean = new Class[1];
		paramBoolean[0] = Boolean.TYPE;
		Method setterMethod = null;
		String xmlString = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			setterMethod = object.getClass().getMethod(xmlString, paramBoolean);
			setterMethod.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception Caught " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	
	public void deserDouble(double value, String tagName, Object object) {
		Class[] clsDouble = new Class[1];
		clsDouble[0] = Double.TYPE;
		Method setterMethod = null;
		String xmlString = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			setterMethod = object.getClass().getMethod(xmlString, clsDouble);
			setterMethod.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception Caught " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	public void deserFloat(float value, String tagName, Object object) {
		Class[] clsFloat = new Class[1];
		clsFloat[0] = Float.TYPE;
		Method setterMethod = null;
		String xmlString = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			setterMethod = object.getClass().getMethod(xmlString, clsFloat);
			setterMethod.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception Caught " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	
	public void deserShort(short value, String tagName, Object object) {
		Class[] clsShort = new Class[1];
		clsShort[0] = Short.TYPE;
		Method setterMethod = null;
		String xmlString = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			setterMethod = object.getClass().getMethod(xmlString, clsShort);
			setterMethod.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception Caught " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	public void deserChar(char value, String tagName, Object object) {
		Class[] clsChar = new Class[1];
		clsChar[0] = Character.TYPE;
		Method setterMethod = null;
		String xmlString = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			setterMethod = object.getClass().getMethod(xmlString, clsChar);
			setterMethod.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception Caught " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }
}
