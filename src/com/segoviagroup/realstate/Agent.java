package com.segoviagroup.realstate;

public final class Agent extends DataType {

	static Agent mSigned;
	public static Agent GetSignedAgent()
	{
		return mSigned;
	}
	
	public Image mAvatar;
	public String[] mProperties;
	public String[] mFavorites;
	public String[] mContactInfo;
	
	public void Logout()
	{}
	
	public static void Login( String pId, String pPassword)
	{}
	
	public static Agent SearchAgent( String pId)
	{
		return null;
	}
	
	public void Cache()
	{
	}
	
	public void Retrieve()
	{}
}
