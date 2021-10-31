/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2009-2012, 2016, 2020  AO Industries, Inc.
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
 * @author  AO Industries, Inc.
 */
public class NetBindResult extends TableMultiResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String result;

	public NetBindResult(long time, long latency, AlertLevel alertLevel, String error, String result) {
		super(time, latency, alertLevel, error);
		if(error!=null && result!=null) throw new IllegalArgumentException("error!=null && result!=null");
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	@Override
	public int getRowDataSize() {
		return 1;
	}

	@Override
	public String getRowData(int index) {
		switch(index) {
			case 0: return result;
			default: throw new IndexOutOfBoundsException();
		}
	}
}
