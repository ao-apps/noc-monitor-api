/*
 * Copyright 2008-2011, 2016, 2018, 2020 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.io.Serializable;
import java.util.Locale;

/**
 * Encapsulates a single result from a single result check.
 *
 * @author  AO Industries, Inc.
 */
final public class SingleResult extends Result implements Serializable {

	private static final long serialVersionUID = 2;

	final private SerializableFunction<Locale,String> error;
	final private String report;

	public SingleResult(long time, long latency, SerializableFunction<Locale,String> error, String report) {
		super(time, latency);

		if(error==null && report==null) throw new IllegalArgumentException("error and report may not both be null");
		if(error!=null && report!=null) throw new IllegalArgumentException("error and report may not both be non-null");

		this.error = error;
		this.report = report;
	}

	/**
	 * Gets the error or <code>null</code> for none.
	 */
	public SerializableFunction<Locale,String> getError() {
		return error;
	}

	/**
	 * Gets the raw data received from the server.
	 */
	public String getReport() {
		return report;
	}
}
