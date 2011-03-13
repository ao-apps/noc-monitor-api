/*
 * Copyright 2008-2011 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.io.Serializable;

/**
 * Encapsulates a single result, this will be a single row in the
 * table showing the current and history.
 *
 * http://codeguru.earthweb.com/java/articles/139.shtml
 * http://74.125.45.104/search?q=cache:La1aeG_jfaIJ:www.experts-exchange.com/Programming/Languages/Java/Q_22583929.html+jtable+merge+cells&hl=en&client=firefox-a&gl=us&strip=1
 * http://quicktable.org/discussion/cutecast/cutecast.pl?session=CMwYr6oQ8NxQu3SZ83YhXc1KpO&action=&forum=1&thread=121&user=&query=&msgid=&page=&sort=&do=&key=&others=
 * 
 * @author  AO Industries, Inc.
 */
abstract public class TableMultiResult<E> extends Result implements Serializable {

    private static final long serialVersionUID = 2L;

    final private AlertLevel alertLevel;
    final private String error;

    /**
     * Either error is null or rowData is null, it cannot be that both are null or both are not null.
     */
    public TableMultiResult(long time, long latency, AlertLevel alertLevel, String error) {
        super(time, latency);

        this.alertLevel = alertLevel;
        this.error = error;
    }

    /**
     * If is an error, gets the error message or <code>null</code> for no error.
     */
    public String getError() {
        return error;
    }

    /**
     * Gets the number of data elements for this result.
     */
    abstract public int getRowDataSize();

    /**
     * Gets the data for one row.  This should not include the time and latency, they are implied.
     * When there is an error, getRowData will not be checked and should return null.
     */
    abstract public E getRowData(int index);

    /**
     * Gets the alert level for this row.
     */
    public AlertLevel getAlertLevel() {
        return alertLevel;
    }
}
