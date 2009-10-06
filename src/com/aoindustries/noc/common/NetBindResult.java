/*
 * Copyright 2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class NetBindResult extends TableMultiResult<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String result;

    public NetBindResult(long time, long latency, AlertLevel alertLevel, String error, String result) {
        super(time, latency, alertLevel, error);
        if(error!=null && result!=null) throw new IllegalArgumentException("error!=null && result!=null");
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    /**
     * Gets the number of data elements for this result.
     */
    @Override
    public int getRowDataSize() {
        return 1;
    }

    /**
     * Gets the data for one row.  This should not include the time and latency, they are implied.
     * When there is an error, getRowData will not be checked and should return null.
     */
    @Override
    public String getRowData(int index) {
        switch(index) {
            case 0: return result;
            default: throw new IndexOutOfBoundsException();
        }
    }
}
