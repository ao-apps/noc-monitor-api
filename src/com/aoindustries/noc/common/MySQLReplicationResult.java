/*
 * Copyright 2009-2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class MySQLReplicationResult extends TableMultiResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String secondsBehindMaster;
    private final String file;
    private final String position;
    private final String slaveIOState;
    private final String masterLogFile;
    private final String readMasterLogPos;
    private final String slaveIORunning;
    private final String slaveSQLRunning;
    private final String lastErrno;
    private final String lastError;
    private final String alertThresholds;

    public MySQLReplicationResult(
        long time,
        long latency,
        AlertLevel alertLevel,
        String error
    ) {
        super(time, latency, alertLevel, error);
        this.secondsBehindMaster = null;
        this.file = null;
        this.position = null;
        this.slaveIOState = null;
        this.masterLogFile = null;
        this.readMasterLogPos = null;
        this.slaveIORunning = null;
        this.slaveSQLRunning = null;
        this.lastErrno = null;
        this.lastError = null;
        this.alertThresholds = null;
    }

    public MySQLReplicationResult(
        long time,
        long latency,
        AlertLevel alertLevel,
        String secondsBehindMaster,
        String file,
        String position,
        String slaveIOState,
        String masterLogFile,
        String readMasterLogPos,
        String slaveIORunning,
        String slaveSQLRunning,
        String lastErrno,
        String lastError,
        String alertThresholds
    ) {
        super(time, latency, alertLevel, null);
        this.secondsBehindMaster = secondsBehindMaster;
        this.file = file;
        this.position = position;
        this.slaveIOState = slaveIOState;
        this.masterLogFile = masterLogFile;
        this.readMasterLogPos = readMasterLogPos;
        this.slaveIORunning = slaveIORunning;
        this.slaveSQLRunning = slaveSQLRunning;
        this.lastErrno = lastErrno;
        this.lastError = lastError;
        this.alertThresholds = alertThresholds;
    }

    @Override
    public int getRowDataSize() {
        return 11;
    }

    @Override
    public String getRowData(int index) {
        switch(index) {
            case 0: return secondsBehindMaster;
            case 1: return file;
            case 2: return position;
            case 3: return slaveIOState;
            case 4: return masterLogFile;
            case 5: return readMasterLogPos;
            case 6: return slaveIORunning;
            case 7: return slaveSQLRunning;
            case 8: return lastErrno;
            case 9: return lastError;
            case 10: return alertThresholds;
            default: throw new IndexOutOfBoundsException();
        }
    }

    public String getSecondsBehindMaster() {
        return secondsBehindMaster;
    }

    public String getFile() {
        return file;
    }

    public String getPosition() {
        return position;
    }

    public String getSlaveIOState() {
        return slaveIOState;
    }

    public String getMasterLogFile() {
        return masterLogFile;
    }

    public String getReadMasterLogPos() {
        return readMasterLogPos;
    }

    public String getSlaveIORunning() {
        return slaveIORunning;
    }

    public String getSlaveSQLRunning() {
        return slaveSQLRunning;
    }

    public String getLastErrno() {
        return lastErrno;
    }

    public String getLastError() {
        return lastError;
    }

    public String getAlertThresholds() {
        return alertThresholds;
    }
}
