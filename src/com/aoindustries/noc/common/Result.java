/*
 * Copyright 2008-2011 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.io.Serializable;

/**
 * Encapsulates any type of result.
 *
 * @author  AO Industries, Inc.
 */
abstract public class Result implements Serializable {

    private static final long serialVersionUID = 1;

    final protected long time;
    final protected long latency;

    public Result(long time, long latency) {
        this.time = time;
        this.latency = latency;
    }

    /**
     * Gets the time this check was performed.
     */
    public long getTime() {
        return time;
    }

    /**
     * Gets the number of nanoseconds it took to perform the check.
     */
    public long getLatency() {
        return latency;
    }
}
