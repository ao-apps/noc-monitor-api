/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2008-2012, 2016, 2020, 2021, 2022  AO Industries, Inc.
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
 * along with noc-monitor-api.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aoindustries.noc.monitor.common;

import java.io.Serializable;

/**
 * Encapsulates a single result, this will be a single row in the
 * table showing the current and history.
 *
 * <ul>
 * <li><a href="http://codeguru.earthweb.com/java/articles/139.shtml">http://codeguru.earthweb.com/java/articles/139.shtml</a></li>
 * <li><a href="http://74.125.45.104/search?q=cache:La1aeG_jfaIJ:www.experts-exchange.com/Programming/Languages/Java/Q_22583929.html+jtable+merge+cells&amp;hl=en&amp;client=firefox-a&amp;gl=us&amp;strip=1">http://74.125.45.104/search?q=cache:La1aeG_jfaIJ:www.experts-exchange.com/Programming/Languages/Java/Q_22583929.html+jtable+merge+cells&amp;hl=en&amp;client=firefox-a&amp;gl=us&amp;strip=1</a></li>
 * <li><a href="http://quicktable.org/discussion/cutecast/cutecast.pl?session=CMwYr6oQ8NxQu3SZ83YhXc1KpO&amp;action=&amp;forum=1&amp;thread=121&amp;user=&amp;query=&amp;msgid=&amp;page=&amp;sort=&amp;do=&amp;key=&amp;others=">http://quicktable.org/discussion/cutecast/cutecast.pl?session=CMwYr6oQ8NxQu3SZ83YhXc1KpO&amp;action=&amp;forum=1&amp;thread=121&amp;user=&amp;query=&amp;msgid=&amp;page=&amp;sort=&amp;do=&amp;key=&amp;others=</a></li>
 * </ul>
 *
 * @author  AO Industries, Inc.
 */
public abstract class TableMultiResult extends Result implements Serializable {

	private static final long serialVersionUID = 2L;

	private final AlertLevel alertLevel;
	private final String error;

	/**
	 * Either error is null or rowData is null, it cannot be that both are null or both are not null.
	 */
	protected TableMultiResult(long time, long latency, AlertLevel alertLevel, String error) {
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
	public abstract int getRowDataSize();

	/**
	 * Gets the data for one row.  This should not include the time and latency, they are implied.
	 * When there is an error, getRowData will not be checked and should return null.
	 */
	public abstract Object getRowData(int index);

	/**
	 * Gets the alert level for this row.
	 */
	public AlertLevel getAlertLevel() {
		return alertLevel;
	}
}
