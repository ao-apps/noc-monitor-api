/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2008-2011, 2016, 2018, 2020  AO Industries, Inc.
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
