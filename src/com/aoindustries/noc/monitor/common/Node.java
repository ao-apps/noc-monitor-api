/*
 * Copyright 2008-2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

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
     * Gets the flag indicating the node allows children.  This is primarily
     * used as a hint for GUI interfaces to render the node correctly, but
     * every node is expected to return <code>true</code> here if it will
     * ever have any children.
     */
    boolean getAllowsChildren() throws RemoteException;

    /**
     * Gets the identifier for this node.  The identifier is unique among all
     * children of a single parent.
     */
    String getId() throws RemoteException;

    /**
     * Gets the label for this node.  The label must be
     * constant throughout the life of the node.
     */
    String getLabel() throws RemoteException;

    /**
     * Gets the UUID of this node.  The UUID will not change unless the server,
     * or some component between the client and server, is restarted.  Two nodes
     * are considered equal when their UUIDs are equal, and their hashCode is
     * based on the UUID value.
     */
    UUID getUuid() throws RemoteException;

    /**
     * Every node implementation must base equality off of UUID value.
     */
    //@Override
    //boolean equals(Object obj);

    /**
     * Every node implementation must generate its hashCode from the UUID value.
     */
    //@Override
    //int hashCode();

    /**
     * Every node implementation must have toString call getLabel();
     */
    //@Override
    //String toString();
}
