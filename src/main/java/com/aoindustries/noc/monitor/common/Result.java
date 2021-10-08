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

import java.io.Serializable;

/**
 * Encapsulates any type of result.
 *
 * @author  AO Industries, Inc.
 */
public abstract class Result implements Serializable {

	private static final long serialVersionUID = 1;

	protected final long time;
	protected final long latency;

	protected Result(long time, long latency) {
		this.time = time;
		this.latency = latency;
	}

	/**
	 * Gets the time this check was performed.
	 */
	public long getTime() {
		return time;
	}

	/**
	 * Gets the number of nanoseconds it took to perform the check.
	 */
	public long getLatency() {
		return latency;
	}
}
