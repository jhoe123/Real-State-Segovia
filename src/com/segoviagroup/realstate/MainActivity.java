package com.segoviagroup.realstate;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		//InitTabs();
		
	}

	void InitTabs()
	{
		TabHost host = this.getTabHost();
		TabHost.TabSpec home = host.newTabSpec("home");
		home.setIndicator("Home");
		home.setContent( new Intent(this,ActivityHome.class));
		host.addTab(home);
		
		TabHost.TabSpec agents = host.newTabSpec("agents");
		agents.setIndicator("Agents");
		agents.setContent( new Intent(this, ActivityAgents.class));
		host.addTab(agents);
		
		TabHost.TabSpec search = host.newTabSpec("search");
		search.setIndicator( "Search");
		search.setContent( new Intent(this, ActivitySearch.class) );
		host.addTab(search);
		
		TabHost.TabSpec myProperties = host.newTabSpec("properties");
		myProperties.setIndicator("My Properties");
		myProperties.setContent( new Intent(this, MyProperties.class));
		host.addTab(myProperties);
		
		TabHost.TabSpec profile =host.newTabSpec("profile");
		profile.setIndicator("Profile");
		profile.setContent( new Intent(this, ActivityProfile.class));
		host.addTab(profile);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
