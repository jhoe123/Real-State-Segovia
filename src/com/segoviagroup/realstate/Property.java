package com.segoviagroup.realstate;

public final class Property extends DataType{

	public String mAgent;
	public String mDatePost;
	public String mName;
	public String mDescription;
	public int mType;
	
	
	
	public static Property GetProperty( String pId, boolean pIsServer)
	{ 
		return null;
	}
	
	public static Property GetProperty( String pId)
	{
		Property property = GetProperty( pId, false);
		if( property == null )
			property = GetProperty( pId, true);
		
		return property;
	}
}
