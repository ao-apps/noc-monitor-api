/*
 * Copyright 2008-2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import com.aoindustries.util.AoCollections;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Gets a serializable snapshot of a node, including all of its children.
 * Nodes themselves are Remote objects.  Thus any iteration over them incurs
 * may round-trips to the RMI server.  This snapshot mechanism allows calling
 * code to get the current state of the node tree with a single RMI call.
 *
 * @author  AO Industries, Inc.
 */
final public class NodeSnapshot implements Serializable {

    private static final long serialVersionUID = 1;

    final private Node node;
    final private List<NodeSnapshot> children;
    final private AlertLevel alertLevel;
    final private String alertMessage;
    final private boolean allowsChildren;
    final private String id;
    final private String label;
    final private UUID uuid;

    public NodeSnapshot(
        Node node,
        List<NodeSnapshot> children,
        AlertLevel alertLevel,
        String alertMessage,
        boolean allowsChildren,
        String id,
        String label,
        UUID uuid
    ) {
        this.node           = node;
        this.children       = AoCollections.unmodifiableCopyList(children);
        this.alertLevel     = alertLevel;
        this.alertMessage   = alertMessage;
        this.allowsChildren = allowsChildren;
        this.id             = id;
        this.label          = label;
        this.uuid           = uuid;
    }

    /**
     * Gets the underlying node that this is a snapshot of.  This is the
     * <code>Remote</code> object, and may be used to check the type of
     * node or make calls for real-time data.
     */
    public Node getNode() {
        return node;
    }

    /**
     * @see Node#getChildren
     */
    public List<NodeSnapshot> getChildren() {
        return children;
    }

    /**
     * @see Node#getAlertLevel
     */
    public AlertLevel getAlertLevel() {
        return alertLevel;
    }

    /**
     * @see Node#getAlertMessage
     */
    public String getAlertMessage() {
        return alertMessage;
    }

    /**
     * @see Node#getAllowsChildren
     */
    public boolean getAllowsChildren() {
        return allowsChildren;
    }

    /**
     * @see Node#getId
     */
    public String getId() {
        return id;
    }

    /**
     * @see Node#getLabel
     */
    public String getLabel() {
        return label;
    }

    /**
     * @see Node#getUuid
     */
    public UUID getUuid() {
        return uuid;
    }
}
