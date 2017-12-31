package genericCheckpointing.xmlStoreRestore;

//import genericCheckpointing.server.DeserStrategy;

public class XMLDeserialization {
	
	private StoreRestoreHandler storeRestoreHandler;

	public XMLDeserialization() {
		// TODO Auto-generated constructor stub
	}

	
	public XMLDeserialization(StoreRestoreHandler handler) {
		// TODO Auto-generated constructor stub
		this.storeRestoreHandler = handler;
	}
	
	public Object processOutput() 
	{
		DeserializeTypes deserialize = new DeserializeTypes();

		int startI, lastI;
		String fieldName, getFieldType;
		String desVal;
		
		Class cls2;
		String fileLine;
		String clsName;
		Object dObj = null;
		
				
		while ((fileLine = storeRestoreHandler.readLine()) != null) 
		{
			if (fileLine.trim().contains("<DPSerialization>") || fileLine.trim().contains("</DPSerialization>"))
				continue;
			else if (fileLine.contains("</complexType>")) 
			{
				return dObj;
			} 
			else if (fileLine.trim().contains("<complexType xsi:type=\"")) 
			{
				startI = fileLine.indexOf('"');
				lastI = fileLine.lastIndexOf('"');
				clsName = fileLine.substring(startI + 1, lastI);

				try {
					cls2 = Class.forName(clsName);
					dObj = cls2.newInstance();
				} 
				catch (ClassNotFoundException ex) 
				{
					System.out.println("The Class is not found" + clsName);
					ex.printStackTrace();
					System.exit(1);
				} 
				catch (IllegalAccessException ie) {
					System.out.println("Illeegal Access Exception");
					ie.printStackTrace();
					System.exit(1);
				} 
				catch (InstantiationException e) {
					System.out.println("InstantiationException found");
					e.printStackTrace();
					System.exit(1);
				}

			} 
			else {
				fieldName = fileLine.substring(fileLine.indexOf('<') + 1, fileLine.indexOf('x') - 1);
				getFieldType = fileLine.substring(fileLine.lastIndexOf(':') + 1, fileLine.lastIndexOf('"'));
				desVal = fileLine.substring(fileLine.indexOf('>') + 1, fileLine.lastIndexOf('<'));

				switch (getFieldType) {
					case "int":
						deserialize.deserInt(Integer.parseInt(desVal), fieldName, dObj);
						break;

					case "long":
						deserialize.deserLong(Long.parseLong(desVal), fieldName, dObj);
						break;

					case "string":
							deserialize.deserString(desVal, fieldName, dObj);
							break;

					case "boolean":
						deserialize.deserBoolean(Boolean.parseBoolean(desVal), fieldName, dObj);
						break;

					case "double":
						deserialize.deserDouble(Double.parseDouble(desVal), fieldName, dObj);
						break;

					case "float":
						deserialize.deserFloat(Float.parseFloat(desVal), fieldName, dObj);
						break;

					case "short":
						deserialize.deserShort(Short.parseShort(desVal), fieldName, dObj);
						break;

					case "char":
						deserialize.deserChar(desVal.charAt(0), fieldName, dObj);
						break;

					default:
						System.out.println("Field Type mismatched");
						break;
				}
			}
		}
		return dObj;
	}
}
	

