package com.mebigfatguy.fbcontribcloud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import com.mongodb.Mongo;

import edu.umd.cs.findbugs.BugCollection;
import edu.umd.cs.findbugs.BugDesignation;
import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.cloud.AbstractCloud;
import edu.umd.cs.findbugs.cloud.CloudPlugin;

public class FBContribCloud extends AbstractCloud {

	private static final String MONGO_HOST_PROP = "com.mebigfatguy.fb-contrib-cloud.host";
	private static final String MONGO_PORT_PROP = "com.mebigfatguy.fb-contrib-cloud.port";
	
	private Mongo m_db;
	private SigninState m_signinState = SigninState.SIGNED_OUT;
	
	public FBContribCloud(CloudPlugin cloudPlugin, BugCollection bugs, Properties properties)
	{
		super(cloudPlugin, bugs, properties);
	}
	
	@Override
	public String getCloudName() {
		return "Fb-Cloud";
	}

	@Override
	public boolean availableForInitialization() {
		try {
		    if (m_db != null) {
    			String host = System.getProperty(MONGO_HOST_PROP, "localhost");
    			String port = System.getProperty(MONGO_PORT_PROP, "27017");
    			
    			m_db = new Mongo(host, Integer.parseInt(port));
		    }
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void waitUntilNewIssuesUploaded() {
	}

	@Override
	public void waitUntilIssueDataDownloaded() {
	}

	@Override
	public void bugsPopulated() {
	}

	@Override
	public void initiateCommunication() {
	}

	@Override
	public String getUser() {
		return System.getProperty("user.name");
	}

	@Override
	public void setSaveSignInInformation(boolean save) {
	}

	@Override
	public boolean isSavingSignInInformationEnabled() {
		return false;
	}

	@Override
	public void signIn() throws IOException {
	    m_signinState = SigninState.SIGNED_IN;
	}

	@Override
	public void signOut() {
	       m_signinState = SigninState.SIGNED_OUT;
	}
	
	@Override
	public SigninState getSigninState() {
        return m_signinState;
    }

	@Override
	public Collection<String> getProjects(String className) {
		return new ArrayList<String>();
	}

	@Override
	public boolean isInCloud(BugInstance b) {
		return true;
	}

	@Override
	public boolean isOnlineCloud() {
		return false;
	}

	@Override
	public void bugFiled(BugInstance b, Object bugLink) {
	}

	@Override
	public BugDesignation getPrimaryDesignation(BugInstance b) {
		return null;
	}

	@Override
	public void storeUserAnnotation(BugInstance bugInstance) {
	}

	@Override
	protected Iterable<BugDesignation> getLatestDesignationFromEachUser(BugInstance bd) {
		return new ArrayList<BugDesignation>();
	}
}
