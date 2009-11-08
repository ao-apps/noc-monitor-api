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
 * Encapsulates a time span in milliseconds,
 * will display the time in client-specific locale.
 *
 * @author  AO Industries, Inc.
 */
final public class TimeSpan implements Serializable {

    private static final long serialVersionUID = 1;

    final private long timeSpan;

    public TimeSpan(long timeSpan) {
        this.timeSpan = timeSpan;
    }

    /**
     * Gets the time span in milliseconds.
     */
    public long getTimeSpan() {
        return timeSpan;
    }

    @Override
    public String toString() {
        return toString(Locale.getDefault());
    }

    public String toString(Locale userLocale) {
        return ApplicationResourcesAccessor.getMessage(userLocale, "TimeSpan.toString", SQLUtility.getMilliDecimal(timeSpan));
    }
}
