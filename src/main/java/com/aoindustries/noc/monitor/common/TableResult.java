/*
 * Copyright 2008-2011, 2016, 2018, 2020 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/**
 * Encapsulates the results that may be in a table, including table columns headers and rows.  Each row has a different alert level.
 *
 * @author  AO Industries, Inc.
 */
final public class TableResult extends Result implements Serializable {

	private static final long serialVersionUID = 1L;

	final private boolean isError;
	final private int columns;
	final private int rows;
	final private SerializableFunction<Locale,? extends List<String>> columnHeaders;
	final private SerializableFunction<Locale,? extends List<?>> tableData;
	final private List<AlertLevel> alertLevels;

	public TableResult(
		long time,
		long latency,
		boolean isError,
		int columns,
		int rows,
		SerializableFunction<Locale,? extends List<String>> columnHeaders,
		SerializableFunction<Locale,? extends List<?>> tableData,
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
	 * List<?> tableData = tableResult.getTableData();
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
	public List<AlertLevel> getAlertLevels() {
		return alertLevels;
	}

	@Override
	public String toString() {
		return time+", "+latency+"ns, isError="+isError+", "+columns+"x"+rows+", "+columnHeaders;
	}
}