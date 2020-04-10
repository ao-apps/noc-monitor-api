/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2008-2012, 2016, 2020  AO Industries, Inc.
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
abstract public class TableMultiResult extends Result implements Serializable {

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
	abstract public Object getRowData(int index);

	/**
	 * Gets the alert level for this row.
	 */
	public AlertLevel getAlertLevel() {
		return alertLevel;
	}
}
