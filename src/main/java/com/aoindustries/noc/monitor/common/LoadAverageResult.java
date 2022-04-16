/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2009-2012, 2016, 2020, 2022  AO Industries, Inc.
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
public class LoadAverageResult extends TableMultiResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private final float oneMinute;
	private final float fiveMinute;
	private final float tenMinute;
	private final int runningProcesses;
	private final int totalProcesses;
	private final int lastPID;
	private final float loadLow;
	private final float loadMedium;
	private final float loadHigh;
	private final float loadCritical;

	public LoadAverageResult(
		long time,
		long latency,
		AlertLevel alertLevel,
		String error
	) {
		super(time, latency, alertLevel, error);
		this.oneMinute = Float.NaN;
		this.fiveMinute = Float.NaN;
		this.tenMinute = Float.NaN;
		this.runningProcesses = Integer.MIN_VALUE;
		this.totalProcesses = Integer.MIN_VALUE;
		this.lastPID = Integer.MIN_VALUE;
		this.loadLow = Float.NaN;
		this.loadMedium = Float.NaN;
		this.loadHigh = Float.NaN;
		this.loadCritical = Float.NaN;
	}

	public LoadAverageResult(
		long time,
		long latency,
		AlertLevel alertLevel,
		float oneMinute,
		float fiveMinute,
		float tenMinute,
		int runningProcesses,
		int totalProcesses,
		int lastPID,
		float loadLow,
		float loadMedium,
		float loadHigh,
		float loadCritical
	) {
		super(time, latency, alertLevel, null);
		this.oneMinute = oneMinute;
		this.fiveMinute = fiveMinute;
		this.tenMinute = tenMinute;
		this.runningProcesses = runningProcesses;
		this.totalProcesses = totalProcesses;
		this.lastPID = lastPID;
		this.loadLow = loadLow;
		this.loadMedium = loadMedium;
		this.loadHigh = loadHigh;
		this.loadCritical = loadCritical;
	}

	@Override
	public int getRowDataSize() {
		return 7;
	}

	@Override
	public Object getRowData(int index) {
		switch(index) {
			case 0: return oneMinute;
			case 1: return fiveMinute;
			case 2: return tenMinute;
			case 3: return runningProcesses;
			case 4: return totalProcesses;
			case 5: return lastPID;
			case 6: {
				return
					(Float.isNaN(loadLow) ? "-" : Float.toString(loadLow))
					+ " / "
					+ (Float.isNaN(loadMedium) ? "-" : Float.toString(loadMedium))
					+ " / "
					+ (Float.isNaN(loadHigh) ? "-" : Float.toString(loadHigh))
					+ " / "
					+ (Float.isNaN(loadCritical) ? "-" : Float.toString(loadCritical))
				;
			}
			default: throw new IndexOutOfBoundsException();
		}
	}

	public float getOneMinute() {
		return oneMinute;
	}

	public float getFiveMinute() {
		return fiveMinute;
	}

	public float getTenMinute() {
		return tenMinute;
	}

	public int getRunningProcesses() {
		return runningProcesses;
	}

	public int getTotalProcesses() {
		return totalProcesses;
	}

	public int getLastPID() {
		return lastPID;
	}

	public float getLoadLow() {
		return loadLow;
	}

	public float getLoadMedium() {
		return loadMedium;
	}

	public float getLoadHigh() {
		return loadHigh;
	}

	public float getLoadCritical() {
		return loadCritical;
	}
}
