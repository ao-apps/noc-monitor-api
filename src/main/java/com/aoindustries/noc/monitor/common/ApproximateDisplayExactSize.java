/*
 * Copyright 2008-2011, 2016, 2020 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import com.aoindustries.lang.Strings;
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
		return Strings.getApproximateSize(size);
	}
}