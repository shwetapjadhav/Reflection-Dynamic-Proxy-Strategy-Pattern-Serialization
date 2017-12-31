package genericCheckpointing.xmlStoreRestore;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import genericCheckpointing.server.SerStrategy;
import genericCheckpointing.util.SerializableObject;

public class XMLSerialization implements SerStrategy 
{    

	private StoreRestoreHandler storeRestoreHandler;

	public XMLSerialization() {
		// TODO Auto-generated constructor stub
		//this.storeRestoreHandler = handler;
	}

	
	public XMLSerialization(StoreRestoreHandler handler) {
		// TODO Auto-generated constructor stub
		this.storeRestoreHandler = handler;
	}

	public void processInput(SerializableObject obj) 
		{
	        Class<?> cls = obj.getClass();
	        String xmlString = "";
	        xmlString += "<DPSerialization>\n<complexType xsi:type=\""+cls.getName()+"\">";

	        for(Field field : cls.getDeclaredFields())
	        {
	        	try
	        	{
	        		String fieldName = field.getName();
	        	
	        		SerializeTypes ser1 = new SerializeTypes();
	        
	       if (field.getType() == int.class) {
	    	  String methodName = "get" + fieldName;
	          Method getterMethod = cls.getMethod(methodName);
	          Object invokeRet = getterMethod.invoke(obj);
	          int value = (int)invokeRet;
	         
	          xmlString += "\n"+ ser1.serializeInt(value, fieldName);
	       }
	       else if (field.getType() == long.class) {
	    	   	String methodName = "get" + fieldName;
		        Method getterMethod = cls.getMethod(methodName);
		        Object invokeRet = getterMethod.invoke(obj);
		        long value = (long) invokeRet;
		        xmlString += "\n"+ ser1.serializeLong(value, fieldName);
		   }
	       else if (field.getType() == String.class) {
	    	   	String methodName = "get" + fieldName;
		        Method getterMethod = cls.getMethod(methodName);
		        Object invokeRet = getterMethod.invoke(obj);
		        String value = (String) invokeRet;
//		        xmlString += "\n";
		        xmlString += "\n"+ ser1.serializeString(value, fieldName);
				//System.out.println(xmlString);

		   }
	       else if (field.getType() == boolean.class) {
	    	   	String methodName = "get" + fieldName;
		        Method getterMethod = cls.getMethod(methodName);
		        Object invokeRet = getterMethod.invoke(obj);
		        boolean value = (boolean) invokeRet;
		//        xmlString += "\n";
		        xmlString += "\n"+ ser1.serializeBool(value, fieldName);
				//System.out.println(xmlString);

		   }
	       else if (field.getType() == double.class) {
	    	   	String methodName = "get" + fieldName;
		        Method getterMethod = cls.getMethod(methodName);
		        Object invokeRet = getterMethod.invoke(obj);
		        double value = (double) invokeRet;
		        xmlString += "\n"+ ser1.serializeDouble(value, fieldName);
				//System.out.println(xmlString);

	       }
	       
	       else if (field.getType() == short.class) {
	    	   	String methodName = "get" + fieldName;
		        Method getterMethod = cls.getMethod(methodName);
		        Object invokeRet = getterMethod.invoke(obj);
		        short value = (short) invokeRet;
		        xmlString += "\n"+ ser1.serializeShort(value, fieldName);
				//System.out.println(xmlString);

	       }
	       else if (field.getType() == char.class) {
	    	   	String methodName = "get" + fieldName;
		        Method getterMethod = cls.getMethod(methodName);
		        Object invokeRet = getterMethod.invoke(obj);
		        char value = (char) invokeRet;
		        xmlString += "\n"+ ser1.serializeChar(value, fieldName);
				//System.out.println(xmlString);

	       }
	        	}catch(Exception e) {
	      		System.err.println(e.getMessage());
	//       		System.exit(0);
	        	}
	        }xmlString += "\n</complexType>\n</DPSerialization>\n";
		try {
			storeRestoreHandler.writeFile(xmlString);
		//	System.out.println(xmlString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}

