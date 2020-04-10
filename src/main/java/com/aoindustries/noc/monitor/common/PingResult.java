/*
 * Copyright 2009-2012, 2016, 2020 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class PingResult extends TableMultiResult implements Serializable {

	private static final long serialVersionUID = 1L;

	public PingResult(long time, long latency, AlertLevel alertLevel, String error) {
		super(time, latency, alertLevel, error);
	}

	public PingResult(long time, long latency, AlertLevel alertLevel) {
		super(time, latency, alertLevel, null);
	}

	@Override
	public int getRowDataSize() {
		return 0;
	}

	@Override
	public Object getRowData(int index) {
		throw new IndexOutOfBoundsException();
	}
}
