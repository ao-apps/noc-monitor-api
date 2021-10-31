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
 * along with noc-monitor-api.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.aoindustries.noc.monitor.common;

/**
 * The different alert levels in the system.
 *
 * @author  AO Industries, Inc.
 */
// Matches enum com.aoindustries.aoserv.client.AlertLevel
// Matches aoserv-master-db/aoindustries/monitoring/AlertLevel-type.sql
public enum AlertLevel {
	NONE,
	LOW,
	MEDIUM,
	HIGH,
	CRITICAL,
	UNKNOWN;

	private static final AlertLevel[] alertLevels = values();

	/**
	 * Gets the alert level from ordinal without the overhead of a call
	 * to <code>values</code>.
	 */
	public static AlertLevel fromOrdinal(int ordinal) {
		return alertLevels[ordinal];
	}
}
