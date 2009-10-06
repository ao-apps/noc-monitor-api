/*
 * Copyright 2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class MemoryResult extends TableMultiResult<ApproximateDisplayExactSize> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long memTotal;
    private final long memFree;
    private final long buffers;
    private final long cached;
    private final long swapTotal;
    private final long swapFree;

    public MemoryResult(
        long time,
        long latency,
        AlertLevel alertLevel,
        String error
    ) {
        super(time, latency, alertLevel, error);
        memTotal = Long.MIN_VALUE;
        memFree = Long.MIN_VALUE;
        buffers = Long.MIN_VALUE;
        cached = Long.MIN_VALUE;
        swapTotal = Long.MIN_VALUE;
        swapFree = Long.MIN_VALUE;
    }

    public MemoryResult(
        long time,
        long latency,
        AlertLevel alertLevel,
        long memTotal,
        long memFree,
        long buffers,
        long cached,
        long swapTotal,
        long swapFree
    ) {
        super(time, latency, alertLevel, null);
        this.memTotal = memTotal;
        this.memFree = memFree;
        this.buffers = buffers;
        this.cached = cached;
        this.swapTotal = swapTotal;
        this.swapFree = swapFree;
    }

    /**
     * Gets the number of data elements for this result.
     */
    @Override
    public int getRowDataSize() {
        return 6;
    }

    /**
     * Gets the data for one row.  This should not include the time and latency, they are implied.
     * When there is an error, getRowData will not be checked and should return null.
     */
    @Override
    public ApproximateDisplayExactSize getRowData(int index) {
        switch(index) {
            case 0: return new ApproximateDisplayExactSize(memTotal);
            case 1: return new ApproximateDisplayExactSize(memFree);
            case 2: return new ApproximateDisplayExactSize(buffers);
            case 3: return new ApproximateDisplayExactSize(cached);
            case 4: return new ApproximateDisplayExactSize(swapTotal);
            case 5: return new ApproximateDisplayExactSize(swapFree);
            default: throw new IndexOutOfBoundsException();
        }
    }

    public long getMemTotal() {
        return memTotal;
    }

    public long getMemFree() {
        return memFree;
    }

    public long getBuffers() {
        return buffers;
    }

    public long getCached() {
        return cached;
    }

    public long getSwapTotal() {
        return swapTotal;
    }

    public long getSwapFree() {
        return swapFree;
    }
}
