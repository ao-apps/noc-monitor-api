/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2008-2012, 2016, 2018, 2020, 2022  AO Industries, Inc.
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
 * @author  AO Industries, Inc.
 */
public interface Node extends Remote {

  /**
   * Gets the parent of this node or <code>null</code> if this is the root node.
   */
  Node getParent() throws RemoteException;

  /**
   * Gets an unmodifiable list of children of this node.  The list returned
   * is a snapshot copy of the node state; it will not be updated when the
   * node children change and it may be used without any additional
   * synchronization.
   */
  List<? extends Node> getChildren() throws RemoteException;

  /**
   * Gets the current alert level for this node.
   */
  AlertLevel getAlertLevel() throws RemoteException;

  /**
   * Gets the current alert message or <code>null</code> for none.
   */
  String getAlertMessage() throws RemoteException;

  /**
   * Gets the alert category for this node.
   */
  AlertCategory getAlertCategory() throws RemoteException;

  /**
   * Gets the flag indicating the node allows children.  This is primarily
   * used as a hint for GUI interfaces to render the node correctly, but
   * every node is expected to return <code>true</code> here if it will
   * ever have any children.
   */
  boolean getAllowsChildren() throws RemoteException;

  /**
   * Gets the label for this node.  The label must be
   * constant throughout the life of the node.
   */
  String getLabel() throws RemoteException;
}
