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

import com.aoapps.lang.Strings;
import java.io.Serializable;

/**
 * Encapsulates a size in bytes, kilobytes, megabytes, ...
 * Displays the user-friendly value.  Stores the exact value.
 *
 * @author  AO Industries, Inc.
 */
final public class ApproximateDisplayExactSize implements Serializable {

	private static final long serialVersionUID = 1;

	final private long size;

	public ApproximateDisplayExactSize(long size) {
		this.size = size;
	}

	public long getSize() {
		return size;
	}

	@Override
	public String toString() {
		return Strings.getApproximateSize(size);
	}
}
