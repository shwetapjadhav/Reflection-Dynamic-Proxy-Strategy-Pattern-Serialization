package genericCheckpointing.driver;

import java.io.IOException;
import java.util.ArrayList;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {
    
    public static void main(String[] args) throws IOException {
	
    	if (args.length < 3 || args.length > 3) {
			System.out.println("Format: <mode> <number of objects> <output file name>");
			System.exit(1);
		}
	// FIXME: read the value of checkpointFile from the command line
    
  //  String line = args[0];
    StoreRestoreHandler handler = new StoreRestoreHandler();
    int NUM_OF_OBJECTS = Integer.parseInt(args[1]);
	ProxyCreator pc = new ProxyCreator();

	ArrayList<Object> serList = new ArrayList<>();
	ArrayList<Object> deserList = new ArrayList<>();
	
	// create an instance of StoreRestoreHandler (which implements
	// the InvocationHandler
	
	// create a proxy
	StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
								 new Class[] {
								     StoreI.class, RestoreI.class
								 }, 
								 handler
						);
	
	SerializableObject myRecordRet;
	MyAllTypesFirst myFirst;
	MyAllTypesSecond  mySecond;
		
	// FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file
		if(args[0].equals("serdeser")) 
		{
			int counter = 0;
			handler.openFile(args[2]);
		
		for (int i=0; i<NUM_OF_OBJECTS; i++) {

		    myFirst = new MyAllTypesFirst(i,i*2,i*999,"str1",true);
		    mySecond = new MyAllTypesSecond((double)(i*9999),(double)(i*1000), (float)(i/3),(short)(i+10),'c');

		    // FIXME: store myFirst and mySecond in the data structure
		    ((StoreI) cpointRef).writeObj(myFirst,1, "XML");
		    ((StoreI) cpointRef).writeObj(mySecond,1, "XML");
		   
		    serList.add(myFirst);
			serList.add(mySecond);

			myRecordRet = ((RestoreI) cpointRef).readObj("XML");
			deserList.add(myRecordRet);
			myRecordRet = ((RestoreI) cpointRef).readObj("XML");
			deserList.add(myRecordRet);
		}
		

		for (int i = 0; i < serList.size(); i++) {
			Object obj = serList.get(i);
			Object ob = deserList.get(i);

			if (!obj.equals(ob)) {
				counter++;
			}
			System.out.println("\n Mismatched Objects are: " + counter);
		}

		}	
		if(args[0].equals("deser")) 
		{
			handler.openFile(args[2]);
			handler.readLine();
			for (int j=0; j<2*NUM_OF_OBJECTS; j++) 
			{
				myRecordRet = ((RestoreI) cpointRef).readObj("XML");
				deserList.add(myRecordRet);	
			}
			System.out.println("\n 0 Objects");
		}
		
		try {
			handler.closeFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
}
	