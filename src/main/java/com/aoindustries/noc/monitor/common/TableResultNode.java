/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2008-2011, 2016, 2020, 2022  AO Industries, Inc.
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

import java.rmi.RemoteException;

/**
 * @author  AO Industries, Inc.
 */
public interface TableResultNode extends Node {

  /**
   * Adds a TableResultListener, which will be notified when new results are available.
   */
  void addTableResultListener(TableResultListener tableResultListener) throws RemoteException;

  /**
   * Removes a TableResultListener.
   */
  void removeTableResultListener(TableResultListener tableResultListener) throws RemoteException;

  /**
   * Gets the most recently available result or <code>null</code> if unavailable.
   */
  TableResult getLastResult() throws RemoteException;
}
