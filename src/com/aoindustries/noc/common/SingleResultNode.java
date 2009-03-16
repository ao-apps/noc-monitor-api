/*
 * Copyright 2008-2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.rmi.RemoteException;

/**
 * @author  AO Industries, Inc.
 */
public interface SingleResultNode extends Node {

    /**
     * Adds a SingleResultListener, which will be notified when new results are available.
     */
    void addSingleResultListener(SingleResultListener singleResultListener) throws RemoteException;

    /**
     * Removes a SingleResultListener.
     */
    void removeSingleResultListener(SingleResultListener singleResultListener) throws RemoteException;

    /**
     * Gets the most recently available result or <code>null</code> if unavailable.
     */
    SingleResult getLastResult() throws RemoteException;
}
