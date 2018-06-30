/*
 * Copyright 2018 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
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
