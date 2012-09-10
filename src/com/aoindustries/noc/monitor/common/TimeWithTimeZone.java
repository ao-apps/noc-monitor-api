/*
 * Copyright 2008-2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import com.aoindustries.util.i18n.ThreadLocale;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Encapsulates a time and an optional time zone.
 *
 * @author  AO Industries, Inc.
 */
final public class TimeWithTimeZone implements Serializable {

    private static final long serialVersionUID = 1;

    final private long time;
    final private TimeZone timeZone;

    public TimeWithTimeZone(long time, TimeZone timeZone) {
        this.time = time;
        this.timeZone = timeZone;
    }

    public TimeWithTimeZone(long time) {
        this(time, null);
    }

    public long getTime() {
        return time;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    @Override
    public String toString() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.LONG, ThreadLocale.get());
        if(timeZone!=null) df.setTimeZone(timeZone);
        return df.format(new Date(time));
    }
}
