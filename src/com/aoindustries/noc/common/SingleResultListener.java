/*
 * Copyright 2008-2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Notified when results are available.
 *
 * @author  AO Industries, Inc.
 */
public interface SingleResultListener extends Remote {

    /**
     * Called when new results are available.
     */
    void singleResultUpdated(SingleResult singleResult) throws RemoteException;
}
