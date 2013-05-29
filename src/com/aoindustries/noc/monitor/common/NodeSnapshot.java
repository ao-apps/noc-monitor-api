/*
 * Copyright 2008-2011 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    final private NodeSnapshot parent;
    private Node node;
    final private List<NodeSnapshot> children;
    final private AlertLevel alertLevel;
    final private String alertMessage;
    final private boolean allowsChildren;
    final private String label;

    /**
     * Recursively obtains the snapshot of the provided node.
     */
    public NodeSnapshot(NodeSnapshot parent, Node node) throws RemoteException {
        this.parent = parent;
        this.node = node;
        List<? extends Node> nodeChildren = node.getChildren();
        int size = nodeChildren.size();
        if(size==0) {
            this.children = Collections.emptyList();
        } else if(size==1) {
            this.children = Collections.singletonList(new NodeSnapshot(this, nodeChildren.get(0)));
        } else {
            List<NodeSnapshot> modifiableChildren = new ArrayList<NodeSnapshot>(size);
            for(Node child : nodeChildren) {
                modifiableChildren.add(new NodeSnapshot(this, child));
            }
            this.children = Collections.unmodifiableList(modifiableChildren);
        }
        alertLevel = node.getAlertLevel();
        alertMessage = node.getAlertMessage();
        allowsChildren = node.getAllowsChildren();
        label = node.getLabel();
    }

    /**
     * Gets the parent of this snapshot or <code>null</code> for none.
     */
    public NodeSnapshot getParent() {
        return parent;
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
     * This allows the node to be replaced, this is used when a filter wraps a
     * node.
     */
    public void setNode(Node node) {
        this.node = node;
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
     * @see Node#getLabel
     */
    public String getLabel() {
        return label;
    }
}
