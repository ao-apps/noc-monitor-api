/*
 * Copyright 2008-2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import com.aoindustries.util.StringUtility;
import java.io.Serializable;

/**
 * Encapsulates a size in bytes, kilobytes, megabytes, ...
 * Displays the user-friendly value.  Stores the exact value.
 *
 * @author  AO Industries, Inc.
 */
final public class ApproximateDisplayExactSize implements Serializable {

    private static final long serialVersionUID = 1;

    final private long size;

    public ApproximateDisplayExactSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    @Override
    public String toString() {
        return StringUtility.getApproximateSize(size);
    }
}
