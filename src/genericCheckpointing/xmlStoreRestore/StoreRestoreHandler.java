package genericCheckpointing.xmlStoreRestore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import genericCheckpointing.server.SerStrategy;
import genericCheckpointing.util.SerializableObject;

/* 
 // if the method is write
    // if the wireFormat is XML
        //  call serializeData(args[0], new XMLSerializationStrategy());

 // if statements to check if it is the read method so that
 // deserialization can be done ... }

*/
public class StoreRestoreHandler implements InvocationHandler
{
	public File fp;
	public FileWriter fw;
	public BufferedWriter bw;
	public BufferedReader br;
	private static int counter = 0;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object res = null;
		if(method.getName().equals("writeObj"))
		{
			if(args[2].equals("XML"))
			{
				serializeData((SerializableObject) args[0], new XMLSerialization(this));
			}
		}
		else if (method.getName().equals("readObj"))
		{
			if (args[0].equals("XML")) {
				return deserializeData(new XMLDeserialization(this));
			}
		}
		
		return res;
		
	}
		public void openFile(String fileName) throws IOException {
			fp = new File(fileName);
			fw = new FileWriter(fp); 
			bw = new BufferedWriter(fw);
		}
		public void writeFile(String str) throws IOException {
		
			bw.write(str);  
		//	System.out.println(str);
    	}

		public String readLine()
		{
			String readline = null; 
			try {
				if(br!=null)
				 readline = br.readLine();
				counter++;
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error to read file at: " + counter);
				e.printStackTrace();
				System.exit(1);
			}
			return readline;
			
		}
		public void closeFile () throws Exception {
			try {
				//br.close();
				if(bw!=null) {
				bw.close();}
			}
			catch (Exception err) {
				System.err.println("Error caught: " + err );
				err.printStackTrace();
			}
		}
		
		public void serializeData(SerializableObject sObject, SerStrategy serStrategy)
		{
			serStrategy.processInput(sObject);
		}	
		
		private Object deserializeData(XMLDeserialization xmlDeserialization) {
			Object obj = xmlDeserialization.processOutput();
			return obj;
		}
	}
