/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2009-2012, 2016, 2020, 2021, 2022  AO Industries, Inc.
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

import com.aoapps.sql.MilliInterval;
import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class TimeResult extends TableMultiResult implements Serializable {

  private static final long serialVersionUID = 1L;

  private final long skew;

  public TimeResult(long time, long latency, AlertLevel alertLevel, String error) {
    super(time, latency, alertLevel, error);
    this.skew = Long.MIN_VALUE;
  }

  public TimeResult(long time, long latency, AlertLevel alertLevel, long skew) {
    super(time, latency, alertLevel, null);
    this.skew = skew;
  }

  public long getSkew() {
    return skew;
  }

  @Override
  public int getRowDataSize() {
    return 1;
  }

  @Override
  public MilliInterval getRowData(int index) {
    switch (index) {
      case 0:
        return new MilliInterval(skew);
      default:
        throw new IndexOutOfBoundsException();
    }
  }
}
