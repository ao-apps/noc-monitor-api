/*
 * Copyright 2008-2011 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.rmi.RemoteException;

/**
 * @author  AO Industries, Inc.
 */
public interface RootNode extends Node {

    /**
     * Adds a TreeListener, which will be notified when nodes are added, removed, or change alert status.
     */
    void addTreeListener(TreeListener treeListener) throws RemoteException;

    /**
     * Removes a TreeListener.
     */
    void removeTreeListener(TreeListener treeListener) throws RemoteException;

    /**
     * Gets a snapshot of the root node and all of its children.
     */
    NodeSnapshot getSnapshot() throws RemoteException;
}
