/*
 * Copyright 2008-2011 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import static com.aoindustries.noc.monitor.common.ApplicationResources.accessor;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Encapsulates a time span in nanoseconds.
 *
 * @author  AO Industries, Inc.
 */
final public class NanoTimeSpan implements Serializable {

    private static final long serialVersionUID = 1;

    final private long nanoTimeSpan;

    public NanoTimeSpan(long nanoTimeSpan) {
        this.nanoTimeSpan = nanoTimeSpan;
    }

    /**
     * Gets the time span in nanoseconds.
     */
    public long getTimeSpan() {
        return nanoTimeSpan;
    }

    @Override
    public String toString() {
        return toString(nanoTimeSpan);
    }

    public static String toString(long nanoTimeSpan) {
        if(nanoTimeSpan < 1000000) return accessor.getMessage("NanoTimeSpan.toString.micro", BigDecimal.valueOf(nanoTimeSpan, 3));
        if(nanoTimeSpan < 1000000000) return accessor.getMessage("NanoTimeSpan.toString.milli", BigDecimal.valueOf(nanoTimeSpan/1000, 3));
        return accessor.getMessage("NanoTimeSpan.toString.second", BigDecimal.valueOf(nanoTimeSpan/1000000, 3));
    }
}
