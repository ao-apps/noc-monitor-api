/*
 * Copyright 2008-2011, 2016, 2018, 2020 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
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
