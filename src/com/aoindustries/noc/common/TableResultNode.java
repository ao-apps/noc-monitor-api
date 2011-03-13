/*
 * Copyright 2008-2011 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.rmi.RemoteException;

/**
 * @author  AO Industries, Inc.
 */
public interface TableResultNode extends Node {

    /**
     * Adds a TableResultListener, which will be notified when new results are available.
     */
    void addTableResultListener(TableResultListener tableResultListener) throws RemoteException;

    /**
     * Removes a TableResultListener.
     */
    void removeTableResultListener(TableResultListener tableResultListener) throws RemoteException;

    /**
     * Gets the most recently available result or <code>null</code> if unavailable.
     */
    TableResult getLastResult() throws RemoteException;
}
