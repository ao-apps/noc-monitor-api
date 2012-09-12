/*
 * Copyright 2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Cache for various types of root nodes.
 *
 * @author  AO Industries, Inc.
 */
public class RootNodeCache<RN extends RootNode> {

    /**
     * Used to create a new root node if doesn't exist in cache.
     */
    public static interface RootNodeFactory<RN extends RootNode> {

        /**
         * Creates a new root node.  Only one root node may be created at a
         * time, so this should be non-blocking when possible.
         */
        RN createRootNode(Locale locale, String username, String password) throws RemoteException, IOException, SQLException;
    }

    /**
     * Each root node is stored on a per locale, username, password basis.
     */
    private static class CacheKey {

        final private Locale locale;
        final private String username;
        final private String password;

        private CacheKey(Locale locale, String username, String password) {
            this.locale = locale;
            this.username = username;
            this.password = password;
        }

        @Override
        public boolean equals(Object O) {
            if(O==null) return false;
            if(!(O instanceof CacheKey)) return false;
            CacheKey other = (CacheKey)O;
            return
                locale.equals(other.locale)
                && username.equals(other.username)
                && password.equals(other.password)
            ;
        }

        @Override
        public int hashCode() {
            return
                locale.hashCode()
                ^ (username.hashCode()*7)
                ^ (password.hashCode()*11)
            ;
        }
    }

    private final Map<CacheKey,RN> cache = new HashMap<CacheKey,RN>();

    private final RootNodeFactory<? extends RN> factory;

    public RootNodeCache(RootNodeFactory<? extends RN> factory) {
        this.factory = factory;
    }

    /**
     * Gets a root node, reusing if already created, or creating a new one from
     * the factory if needed.  Only one factory may be created at a time.
     */
    public RN getOrCreate(Locale locale, String username, String password) throws RemoteException, IOException, SQLException {
        CacheKey key = new CacheKey(locale, username, password);
        synchronized(cache) {
            RN rootNode = cache.get(key);
            if(rootNode==null) {
                rootNode = factory.createRootNode(locale, username, password);
                cache.put(key, rootNode);
            }
            return rootNode;
        }
    }
}
