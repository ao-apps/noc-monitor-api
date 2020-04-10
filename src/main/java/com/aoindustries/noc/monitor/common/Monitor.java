/*
 * Copyright 2008-2011, 2016, 2017, 2018, 2019, 2020 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import com.aoindustries.aoserv.client.account.User;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Locale;

/**
 * @author  AO Industries, Inc.
 */
public interface Monitor extends Remote {

	/**
	 * The ports used for RMI communication.
	 */
	public static final int DEFAULT_RMI_CLIENT_PORT = 4586; // 4585 used by mobile server
	public static final int DEFAULT_RMI_SERVER_PORT = 4584;

	/**
	 * Logs into the server.  Once authentication has been successfully completed,
	 * resolves a (possibly already running) root node.  The root node is started
	 * in the background.  Once started, a root node will always run.  There is
	 * one unique root node per locale, username, and password combination.
	 */
	RootNode login(Locale locale, User.Name username, String password) throws RemoteException, IOException, SQLException;
}
