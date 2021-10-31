/*
 * noc-monitor-api - API of Network Operations Center Monitoring.
 * Copyright (C) 2008-2011, 2016, 2017, 2018, 2019, 2020  AO Industries, Inc.
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

import com.aoindustries.aoserv.client.account.User;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Locale;

/**
 * @author  AO Industries, Inc.
 */
public interface Monitor extends Remote {

	/**
	 * The ports used for RMI communication.
	 */
	public static final int DEFAULT_RMI_CLIENT_PORT = 4586; // 4585 used by mobile server
	public static final int DEFAULT_RMI_SERVER_PORT = 4584;

	/**
	 * Logs into the server.  Once authentication has been successfully completed,
	 * resolves a (possibly already running) root node.  The root node is started
	 * in the background.  Once started, a root node will always run.  There is
	 * one unique root node per locale, username, and password combination.
	 */
	RootNode login(Locale locale, User.Name username, String password) throws RemoteException, IOException, SQLException;
}
