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
 * along with noc-monitor-api.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aoindustries.noc.monitor.common;

import java.io.Serializable;

/**
 * Encapsulates the results of changing alert level or category.
 *
 * @author  AO Industries, Inc.
 */
final public class AlertChange implements Serializable {

	private static final long serialVersionUID = 2;

	final private Node node;
	final private String nodeFullPath;
	final private AlertLevel oldAlertLevel;
	final private AlertLevel newAlertLevel;
	final private String alertMessage;
	final private AlertCategory oldAlertCategory;
	final private AlertCategory newAlertCategory;

	public AlertChange(
		Node node,
		String nodeFullPath,
		AlertLevel oldAlertLevel,
		AlertLevel newAlertLevel,
		String alertMessage,
		AlertCategory oldAlertCategory,
		AlertCategory newAlertCategory
	) {
		this.node = node;
		this.nodeFullPath = nodeFullPath;
		this.oldAlertLevel = oldAlertLevel;
		this.newAlertLevel = newAlertLevel;
		this.alertMessage = alertMessage;
		this.oldAlertCategory = oldAlertCategory;
		this.newAlertCategory = newAlertCategory;
	}

	/**
	 * Gets the node that changed status.
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * Gets the full path for simplified displays.
	 */
	public String getNodeFullPath() {
		return nodeFullPath;
	}

	/**
	 * Gets the old alert level.
	 */
	public AlertLevel getOldAlertLevel() {
		return oldAlertLevel;
	}

	/**
	 * Gets the new alert level.
	 */
	public AlertLevel getNewAlertLevel() {
		return newAlertLevel;
	}

	/**
	 * Gets the associated alert message.
	 */
	public String getAlertMessage() {
		return alertMessage;
	}

	/**
	 * Gets the old alert category.
	 */
	public AlertCategory getOldAlertCategory() {
		return oldAlertCategory;
	}

	/**
	 * Gets the new alert category.
	 */
	public AlertCategory getNewAlertCategory() {
		return newAlertCategory;
	}
}
