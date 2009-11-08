/*
 * Copyright 2008-2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import com.aoindustries.sql.SQLUtility;
import java.io.Serializable;
import java.util.Locale;

/**
 * Encapsulates a time span in nanoseconds,
 * will display the time in client-specific locale.
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
        return toString(Locale.getDefault());
    }

    public static String toString(long nanoTimeSpan, Locale userLocale) {
        if(nanoTimeSpan < 1000000) return ApplicationResourcesAccessor.getMessage(userLocale, "NanoTimeSpan.toString.micro", SQLUtility.getMilliDecimal(nanoTimeSpan));
        if(nanoTimeSpan < 1000000000) return ApplicationResourcesAccessor.getMessage(userLocale, "NanoTimeSpan.toString.milli", SQLUtility.getMilliDecimal(nanoTimeSpan/1000));
        return ApplicationResourcesAccessor.getMessage(userLocale, "NanoTimeSpan.toString.second", SQLUtility.getMilliDecimal(nanoTimeSpan/1000000));
    }

    public String toString(Locale userLocale) {
        return toString(nanoTimeSpan, userLocale);
    }
}
