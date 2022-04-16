/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2008-2011, 2016, 2018, 2020, 2022  AO Industries, Inc.
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

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Notified when the tree is modified.
 *
 * @author  AO Industries, Inc.
 */
public interface TreeListener extends Remote {

	/**
	 * Called sometime after one or more nodes are added.
	 */
	void nodeAdded() throws RemoteException;

	/**
	 * Called sometime after one or more nodes are removed.
	 */
	void nodeRemoved() throws RemoteException;

	/**
	 * Called after one or more nodes change alert levels.
	 */
	void nodeAlertChanged(List<AlertChange> changes) throws RemoteException;
}
