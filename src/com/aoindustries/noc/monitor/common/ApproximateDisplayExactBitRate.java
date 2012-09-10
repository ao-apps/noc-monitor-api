/*
 * Copyright 2008-2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import com.aoindustries.util.StringUtility;
import java.io.Serializable;

/**
 * Encapsulates a throughput in bits/second.
 * Displays the user-friendly value.  Stores the exact value.
 *
 * @author  AO Industries, Inc.
 */
final public class ApproximateDisplayExactBitRate implements Serializable {

    private static final long serialVersionUID = 1;

    final private long bit_rate;

    public ApproximateDisplayExactBitRate(long bit_rate) {
        this.bit_rate = bit_rate;
    }

    public long getBitRate() {
        return bit_rate;
    }

    @Override
    public String toString() {
        return StringUtility.getApproximateBitRate(bit_rate);
    }
}
