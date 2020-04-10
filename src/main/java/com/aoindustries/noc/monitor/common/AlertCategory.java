/*
 * Copyright 2018, 2020 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
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
