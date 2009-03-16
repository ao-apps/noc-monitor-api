/*
 * Copyright 2008-2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Notified when the tree is modified.
 *
 * @author  AO Industries, Inc.
 */
public interface TreeListener extends Remote {

    /**
     * Called sometime after one or more nodes are added.
     */
    void nodeAdded() throws RemoteException;

    /**
     * Called sometime after one or more nodes are removed.
     */
    void nodeRemoved() throws RemoteException;

    /**
     * Called after one or more nodes change alert levels.
     */
    void nodeAlertLevelChanged(List<AlertLevelChange> changes) throws RemoteException;
}
