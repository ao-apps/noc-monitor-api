/*
 * Copyright 2018, 2020 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.io.Serializable;
import java.util.function.Function;

/**
 * @author  AO Industries, Inc.
 */
public interface SerializableFunction<T, R> extends Function<T, R>, Serializable {

}
