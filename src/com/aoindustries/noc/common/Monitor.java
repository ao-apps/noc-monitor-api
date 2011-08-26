/*
 * Copyright 2008-2011 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import com.aoindustries.aoserv.client.validator.UserId;
import com.aoindustries.security.LoginException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Locale;

/**
 * @author  AO Industries, Inc.
 */
public interface Monitor extends Remote {

    /**
     * The ports used for RMI communication.
     */
    public static final int DEFAULT_RMI_CLIENT_PORT = 4585;
    public static final int DEFAULT_RMI_SERVER_PORT = 4584;

    /**
     * Logs into the server.  Once authentication has been successfully completed,
     * resolves a (possibly already running) root node.  The root node is started
     * in the background.  Once started, a root node will always run.  There is
     * one unique root node per locale, username, and password combination.
     */
    RootNode login(Locale locale, UserId username, String password) throws RemoteException, LoginException;
}