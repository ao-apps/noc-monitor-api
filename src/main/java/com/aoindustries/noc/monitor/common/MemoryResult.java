/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2009-2012, 2016, 2020, 2022  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of noc-monitor-api.
 *
 * noc-monitor-api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * noc-monitor-api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with noc-monitor-api.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.aoindustries.noc.monitor.common;

import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class MemoryResult extends TableMultiResult implements Serializable {

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

  @Override
  public int getRowDataSize() {
    return 6;
  }

  @Override
  public ApproximateDisplayExactSize getRowData(int index) {
    switch (index) {
      case 0:
        return new ApproximateDisplayExactSize(memTotal);
      case 1:
        return new ApproximateDisplayExactSize(memFree);
      case 2:
        return new ApproximateDisplayExactSize(buffers);
      case 3:
        return new ApproximateDisplayExactSize(cached);
      case 4:
        return new ApproximateDisplayExactSize(swapTotal);
      case 5:
        return new ApproximateDisplayExactSize(swapFree);
      default:
        throw new IndexOutOfBoundsException();
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
