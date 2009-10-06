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
public interface TableMultiResultListener<E extends TableMultiResult> extends Remote {

    /**
     * Notified when a new multi-table result is available.
     */
    void tableMultiResultAdded(E multiTableResult) throws RemoteException;

    /**
     * Notified when a multi-table result has been removed.
     */
    void tableMultiResultRemoved(E multiTableResult) throws RemoteException;
}
