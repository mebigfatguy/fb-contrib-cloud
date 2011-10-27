package com.mebigfatguy.fbcontribcloud;

import java.io.IOException;

import javax.swing.JOptionPane;

import edu.umd.cs.findbugs.BugCollection;
import edu.umd.cs.findbugs.cloud.CloudPlugin;
import edu.umd.cs.findbugs.cloud.username.NameLookup;

public class FBUserName implements NameLookup {
	
	@Override
	public String getUsername() {
		return System.getProperty("user.name");
	}

	@Override
	public boolean signIn(CloudPlugin plugin, BugCollection bugCollection)
			throws IOException {
		return true;
	}

}
