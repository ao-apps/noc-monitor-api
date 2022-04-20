/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2018, 2020, 2022  AO Industries, Inc.
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

import com.aoindustries.aoserv.client.signup.Request;
import com.aoindustries.aoserv.client.ticket.TicketType;

/**
 * The different alert categories in the system.  The category can affect
 * which sound is played, for example.
 * <p>
 * These categories are in a priority order.  When two alerts exist at the same
 * level, but in different categories, the higher priority category is used
 * for audible notifications.
 * </p>
 *
 * @author  AO Industries, Inc.
 */
public enum AlertCategory {

  /**
   * Something that is otherwise uncategorized.
   */
  UNCATEGORIZED,

  /**
   * Alerts to incoming email messages not otherwise moved into the ticket system.
   */
  EMAIL,

  /**
   * @see  TicketType#CONTACT
   */
  CONTACT,

  /**
   * @see  TicketType#SUPPORT
   */
  SUPPORT,

  /**
   * @see  Request
   */
  SIGNUP,

  /**
   * Alerts coming from the monitoring system.
   * <p>
   * TODO: Should this be split to infrastructure, virtual, and other?
   * </p>
   */
  MONITORING
}
