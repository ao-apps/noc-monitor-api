/*
 * Copyright 2008-2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Locale;

/**
 * @author  AO Industries, Inc.
 */
public interface TableMultiResultNode extends Node {

    /**
     * Adds a TableMultiResultListener, which will be notified when new results are available.
     */
    void addTableMultiResultListener(TableMultiResultListener tableMultiResultListener) throws RemoteException;

    /**
     * Removes a TableMultiResultListener.
     */
    void removeTableMultiResultListener(TableMultiResultListener tableMultiResultListener) throws RemoteException;

    /**
     * Gets the column headers for the table.  This should not include the time and latency, they are implied.
     */
    List<?> getColumnHeaders(Locale locale) throws RemoteException;

    /**
     * Gets the unmodifiable snapshot-copy of the complete list of results.
     */
    List<? extends TableMultiResult> getResults() throws RemoteException;
}
