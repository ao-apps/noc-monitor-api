/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2008-2011, 2016, 2018, 2020, 2021  AO Industries, Inc.
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

import com.aoapps.lang.function.SerializableFunction;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/**
 * Encapsulates the results that may be in a table, including table columns headers and rows.  Each row has a different alert level.
 *
 * @author  AO Industries, Inc.
 */
public final class TableResult extends Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private final boolean isError;
	private final int columns;
	private final int rows;
	private final SerializableFunction<Locale, ? extends List<String>> columnHeaders;
	private final SerializableFunction<Locale, ? extends List<?>> tableData;
	private final List<AlertLevel> alertLevels;

	/**
	 * @param  alertLevels  Must be unmodifiable - no defensive copy is made
	 */
	public TableResult(
		long time,
		long latency,
		boolean isError,
		int columns,
		int rows,
		SerializableFunction<Locale, ? extends List<String>> columnHeaders,
		SerializableFunction<Locale, ? extends List<?>> tableData,
		List<AlertLevel> alertLevels
	) {
		super(time, latency);

		if(rows != alertLevels.size()) throw new AssertionError("rows != alertLevels.size()");

		this.isError = isError;
		this.columns = columns;
		this.rows = rows;
		this.columnHeaders = columnHeaders;
		this.tableData = tableData;
		this.alertLevels = alertLevels;
	}

	/**
	 * If is an error, columns=1, rows=1, and tableData.get(0) has the error.
	 */
	public boolean isError() {
		return isError;
	}

	/**
	 * Gets the number of columns in the table.
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * Gets the number of rows in the table.
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Gets the column headers for the table.
	 */
	public List<String> getColumnHeaders(Locale locale) {
		List<String> headers = columnHeaders.apply(locale);
		if(columns != headers.size()) throw new AssertionError("columns != headers.size()");
		return headers;
	}

	/**
	 * Gets the table data, each element may be found with the expression:
	 * <pre>
	 * List&lt;?&gt; tableData = tableResult.getTableData();
	 * int columns = tableResult.getColumns();
	 * 
	 * Object cellData = tableData.get(row*columns + column);
	 * </pre>
	 */
	public List<?> getTableData(Locale locale) {
		List<?> td = tableData.apply(locale);
		if((rows*columns) != td.size()) throw new AssertionError("(rows*columns) != tc.size()");
		return td;
	}

	/**
	 * Gets the alert level on a per-row basis.
	 */
	@SuppressWarnings("ReturnOfCollectionOrArrayField") // Returning unmodifiable
	public List<AlertLevel> getAlertLevels() {
		return alertLevels;
	}

	@Override
	public String toString() {
		return time+", "+latency+"ns, isError="+isError+", "+columns+"x"+rows+", "+columnHeaders;
	}
}
