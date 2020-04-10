/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2018, 2020  AO Industries, Inc.
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
 * @author  AO Industries, Inc.
 */
public class HttpdServerResult extends TableMultiResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int concurrency;
	private final int maxConcurrency;
	private final int concurrencyLow;
	private final int concurrencyMedium;
	private final int concurrencyHigh;
	private final int concurrencyCritical;

	public HttpdServerResult(
		long time,
		long latency,
		AlertLevel alertLevel,
		String error
	) {
		super(time, latency, alertLevel, error);
		this.concurrency = -1;
		this.maxConcurrency = -1;
		this.concurrencyLow = -1;
		this.concurrencyMedium = -1;
		this.concurrencyHigh = -1;
		this.concurrencyCritical = -1;
	}

	public HttpdServerResult(
		long time,
		long latency,
		AlertLevel alertLevel,
		int concurrency,
		int maxConcurrency,
		int concurrencyLow,
		int concurrencyMedium,
		int concurrencyHigh,
		int concurrencyCritical
	) {
		super(time, latency, alertLevel, null);
		this.concurrency = concurrency;
		this.maxConcurrency = maxConcurrency;
		this.concurrencyLow = concurrencyLow;
		this.concurrencyMedium = concurrencyMedium;
		this.concurrencyHigh = concurrencyHigh;
		this.concurrencyCritical = concurrencyCritical;
	}

	@Override
	public int getRowDataSize() {
		return 3;
	}

	@Override
	public Object getRowData(int index) {
		switch(index) {
			case 0: return concurrency;
			case 1: return maxConcurrency;
			case 2: {
				return
					((concurrencyLow == -1) ? "-" : Integer.toString(concurrencyLow))
					+ " / "
					+ ((concurrencyMedium == -1) ? "-" : Integer.toString(concurrencyMedium))
					+ " / "
					+ ((concurrencyHigh == -1) ? "-" : Integer.toString(concurrencyHigh))
					+ " / "
					+ ((concurrencyCritical == -1) ? "-" : Integer.toString(concurrencyCritical))
				;
			}
			default: throw new IndexOutOfBoundsException();
		}
	}

	public int getConcurrency() {
		return concurrency;
	}

	public int getMaxConcurrency() {
		return maxConcurrency;
	}

	public int getConcurrencyLow() {
		return concurrencyLow;
	}

	public int getConcurrencyMedium() {
		return concurrencyMedium;
	}

	public int getConcurrencyHigh() {
		return concurrencyHigh;
	}

	public int getConcurrencyCritical() {
		return concurrencyCritical;
	}
}
