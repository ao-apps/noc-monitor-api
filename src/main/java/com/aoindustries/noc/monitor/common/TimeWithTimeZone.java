/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2008-2011, 2016, 2020, 2021  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of noc-monitor-api.
 *
 * noc-monitor-api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * noc-monitor-api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with noc-monitor-api.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoindustries.noc.monitor.common;

import com.aoapps.lang.i18n.ThreadLocale;
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
