/*
 * Copyright 2008-2011 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author  AO Industries, Inc.
 */
public interface TableMultiResultNode<T,E extends TableMultiResult<? extends T>> extends Node {

    /**
     * Adds a TableMultiResultListener, which will be notified when new results are available.
     */
    void addTableMultiResultListener(TableMultiResultListener<? super E> tableMultiResultListener) throws RemoteException;

    /**
     * Removes a TableMultiResultListener.
     */
    void removeTableMultiResultListener(TableMultiResultListener<? super E> tableMultiResultListener) throws RemoteException;

    /**
     * Gets the column headers for the table.  This should not include the time and latency, they are implied.
     */
    List<?> getColumnHeaders() throws RemoteException;

    /**
     * Gets the unmodifiable snapshot-copy of the complete list of results.
     */
    List<? extends E> getResults() throws RemoteException;
}
