/*
 * Copyright 2008-2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author  AO Industries, Inc.
 */
public interface TableMultiResultNode<R extends TableMultiResult> extends Node {

    /**
     * Adds a TableMultiResultListener, which will be notified when new results are available.
     */
    void addTableMultiResultListener(TableMultiResultListener<? super R> tableMultiResultListener) throws RemoteException;

    /**
     * Removes a TableMultiResultListener.
     */
    void removeTableMultiResultListener(TableMultiResultListener<? super R> tableMultiResultListener) throws RemoteException;

    /**
     * Gets the column headers for the table.  This should not include the time and latency, they are implied.
     */
    List<?> getColumnHeaders() throws RemoteException;

    /**
     * Gets an unmodifiable snapshot-copy of the complete list of results.
     */
    List<? extends R> getResults() throws RemoteException;
}
