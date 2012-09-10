/*
 * Copyright 2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/**
 * One of the points of view that runs monitoring.
 *
 * @author  AO Industries, Inc.
 */
public class MonitoringPoint implements Serializable, Comparable<MonitoringPoint> {

    private static final long serialVersionUID = 1;

    final private String hostname;
    transient private String lowerHostname;
    final private float latitude;
    final private float longitude;

    public MonitoringPoint(String hostname, float latitude, float longitude) {
        this.hostname = hostname;
        this.lowerHostname = hostname.toLowerCase(Locale.ENGLISH);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
        lowerHostname = hostname.toLowerCase(Locale.ENGLISH);
    }

    @Override
    public String toString() {
        return hostname;
    }

    @Override
    public int hashCode() {
        return lowerHostname.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof MonitoringPoint)) return false;
        MonitoringPoint other = (MonitoringPoint)o;
        return lowerHostname.equals(other.lowerHostname);
    }

    @Override
    public int compareTo(MonitoringPoint other) {
        return lowerHostname.compareTo(other.lowerHostname);
    }

    /**
     * Gets the unique hostname of this monitoring point.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Gets the latitude coordinate of the point of view.
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Gets the longitude coordinate of the point of view.
     */
    public float getLongtitude() {
        return longitude;
    }
}
