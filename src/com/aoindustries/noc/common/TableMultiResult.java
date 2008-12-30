/*
 * Copyright 2008 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.io.Serializable;
import java.util.List;

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
final public class TableMultiResult extends Result implements Serializable {

    private static long serialVersionUID = 1;

    final private String error;
    final private List<?> rowData;
    final private AlertLevel alertLevel;

    /**
     * Either error is null or rowData is null, it cannot be that both are null or both are not null.
     */
    public TableMultiResult(long time, long latency, String error, List<?> rowData, AlertLevel alertLevel) {
        super(time, latency);

        if(error==null && rowData==null) throw new IllegalArgumentException("error and rowData may not both be null");
        if(error!=null && rowData!=null) throw new IllegalArgumentException("error and rowData may not both be non-null");

        this.error = error;
        this.rowData = rowData;
        this.alertLevel = alertLevel;
    }

    /**
     * If is an error, gets the error message or <code>null</code> for no error.
     */
    public String getError() {
        return error;
    }

    /**
     * Gets the data for one row.  This should not include the time and latency, they are implied.
     */
    public List<?> getRowData() {
        return rowData;
    }
    
    /**
     * Gets the alert level for this row.
     */
    public AlertLevel getAlertLevel() {
        return alertLevel;
    }
}
