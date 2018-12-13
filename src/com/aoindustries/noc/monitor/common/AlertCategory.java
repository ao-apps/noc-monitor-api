/*
 * Copyright 2018 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import com.aoindustries.aoserv.client.signup.Request;
import com.aoindustries.aoserv.client.ticket.TicketType;

/**
 * The different alert categories in the system.  The category can affect
 * which sound is played, for example.
 *
 * @author  AO Industries, Inc.
 */
public enum AlertCategory {

	/**
	 * @see  TicketType#CONTACT
	 */
	CONTACT,

	/**
	 * Alerts to incoming email messages not otherwise moved into the ticket system.
	 */
	EMAIL,

	/**
	 * Alerts coming from the monitoring system.
	 * <p>
	 * TODO: Should this be split to infrastructure, virtual, and other?
	 * </p>
	 */
	MONITORING,

	/**
	 * @see  Request
	 */
	SIGNUP,

	/**
	 * @see  TicketType#SUPPORT
	 */
	SUPPORT,

	/**
	 * Something that is otherwise uncategorized.
	 */
	UNCATEGORIZED
}
