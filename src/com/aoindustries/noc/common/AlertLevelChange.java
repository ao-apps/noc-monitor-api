/*
 * Copyright 2008-2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.io.Serializable;

/**
 * Encapsulates the results of changing alert level.
 *
 * @author  AO Industries, Inc.
 */
final public class AlertLevelChange implements Serializable {

    private static long serialVersionUID = 1;

    final private Node node;
    final private String nodeFullPath;
    final private AlertLevel oldAlertLevel;
    final private AlertLevel newAlertLevel;
    final private String alertMessage;

    public AlertLevelChange(Node node, String nodeFullPath, AlertLevel oldAlertLevel, AlertLevel newAlertLevel, String alertMessage) {
        this.node = node;
        this.nodeFullPath = nodeFullPath;
        this.oldAlertLevel = oldAlertLevel;
        this.newAlertLevel = newAlertLevel;
        this.alertMessage = alertMessage;
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
}
