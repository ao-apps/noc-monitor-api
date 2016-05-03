/*
 * Copyright 2008-2012, 2016 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
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
