/*
 * Copyright 2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.io.Serializable;

/**
 * Field descriptions copied from {@link http://www.apcupsd.com/manual/manual.html#status-report-fields}
 *
 * @author  AO Industries, Inc.
 */
public class UpsResult extends TableMultiResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String upsname;
    // Overall status
    private final String status;
    // Line
    private final float linev;
    private final float lotrans;
    private final float hitrans;
    private final float linefreq;
    // Output
    private final float outputv;
    private final float nomoutv;
    // Load
    private final float loadpct;
    // Batteries
    private final float bcharge;
    private final float battv;
    private final float nombattv;
    private final int extbatts;
    private final int badbatts;
    // Runtime
    private final TimeSpan tonbatt;
    private final TimeSpan timeleft;
    private final float itemp;

    public UpsResult(
        MonitoringPoint monitoringPoint,
        long time,
        long latency,
        AlertLevel alertLevel,
        String error
    ) {
        super(monitoringPoint, time, latency, alertLevel, error);
        this.upsname = null;
        this.status = null;
        this.linev = Float.NaN;
        this.lotrans = Float.NaN;
        this.hitrans = Float.NaN;
        this.linefreq = Float.NaN;
        this.outputv = Float.NaN;
        this.nomoutv = Float.NaN;
        this.loadpct = Float.NaN;
        this.bcharge = Float.NaN;
        this.battv = Float.NaN;
        this.nombattv = Float.NaN;
        this.extbatts = -1;
        this.badbatts = -1;
        this.tonbatt = null;
        this.timeleft = null;
        this.itemp = Float.NaN;
    }

    public UpsResult(
        MonitoringPoint monitoringPoint,
        long time,
        long latency,
        AlertLevel alertLevel,
        String upsname,
        String status,
        float linev,
        float lotrans,
        float hitrans,
        float linefreq,
        float outputv,
        float nomoutv,
        float loadpct,
        float bcharge,
        float battv,
        float nombattv,
        int extbatts,
        int badbatts,
        TimeSpan tonbatt,
        TimeSpan timeleft,
        float itemp
    ) {
        super(monitoringPoint, time, latency, alertLevel, null);
        this.upsname = upsname;
        this.status = status;
        this.linev = linev;
        this.lotrans = lotrans;
        this.hitrans = hitrans;
        this.linefreq = linefreq;
        this.outputv = outputv;
        this.nomoutv = nomoutv;
        this.loadpct = loadpct;
        this.bcharge = bcharge;
        this.battv = battv;
        this.nombattv = nombattv;
        this.extbatts = extbatts;
        this.badbatts = badbatts;
        this.tonbatt = tonbatt;
        this.timeleft = timeleft;
        this.itemp = itemp;
    }

    @Override
    public int getRowDataSize() {
        return 11;
    }

    @Override
    public Object getRowData(int index) {
        switch(index) {
            case 0: return upsname;
            case 1: return status;
            case 2:
                if(Float.isNaN(linev)) return null;
                if(Float.isNaN(linefreq)) return String.format("%.1fV", linev);
                return String.format("%.1fV @ %.1fHz", linev, linefreq);
            case 3:
                if(Float.isNaN(outputv)) return null;
                return String.format("%.1fV", outputv);
            case 4:
                if(Float.isNaN(loadpct)) return null;
                return String.format("%.1f%%", loadpct);
            case 5:
                if(Float.isNaN(bcharge)) return null;
                return String.format("%.1f%%", bcharge);
            case 6:
                if(Float.isNaN(battv)) return null;
                return String.format("%.1fV", battv);
            case 7:
                if(badbatts==-1) return null;
                if(extbatts==-1) return badbatts;
                return badbatts + "/" + extbatts;
            case 8:
                return tonbatt;
            case 9:
                return timeleft;
            case 10:
                if(Float.isNaN(itemp)) return null;
                return String.format("%.1f \u00B0C", itemp);
            default: throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Gets the name of the UPS as stored in the EEPROM or in the UPSNAME directive in the configuration file.
     *
     * @return  the UPSNAME or <code>null</code> if unavailable.
     */
    public String getUpsname() {
        return upsname;
    }

    /**
     * Gets the current status of the UPS (ONLINE, CHARGING, ONBATT, etc.).
     *
     * @return  the STATUS or <code>null</code> if unavailable.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the current line voltage as returned by the UPS.
     *
     * @return  the LINEV or <code>Float.NaN</code> if unavailable.
     */
    public float getLinev() {
        return linev;
    }

    /**
     * Gets the line voltage below which the UPS will switch to batteries.
     *
     * @return  the LOTRANS or <code>Float.NaN</code> if unavailable.
     */
    public float getLotrans() {
        return lotrans;
    }

    /**
     * Gets the line voltage above which the UPS will switch to batteries.
     *
     * @return  the HITRANS or <code>Float.NaN</code> if unavailable.
     */
    public float getHitrans() {
        return hitrans;
    }

    /**
     * Gets the line frequency in hertz as given by the UPS.
     *
     * @return  the LINEFREQ or <code>Float.NaN</code> if unavailable.
     */
    public float getLinefreq() {
        return linefreq;
    }

    /**
     * Gets the voltage the UPS is supplying to your equipment.
     *
     * @return  the OUTPUTV or <code>Float.NaN</code> if unavailable.
     */
    public float getOutputv() {
        return outputv;
    }

    /**
     * Gets the output voltage that the UPS will attempt to supply when on battery power.
     *
     * @return  the NOMOUTV or <code>Float.NaN</code> if unavailable.
     */
    public float getNomoutv() {
        return nomoutv;
    }

    /**
     * Gets the percentage of load capacity as estimated by the UPS.
     *
     * @return  the LOADPCT or <code>Float.NaN</code> if unavailable.
     */
    public float getLoadpct() {
        return loadpct;
    }

    /**
     * Gets the percentage charge on the batteries.
     *
     * @return  the BCHARGE or <code>Float.NaN</code> if unavailable.
     */
    public float getBcharge() {
        return bcharge;
    }

    /**
     * Gets the battery voltage as supplied by the UPS.
     *
     * @return  the BATTV or <code>Float.NaN</code> if unavailable.
     */
    public float getBattv() {
        return battv;
    }

    /**
     * Gets the nominal battery voltage.
     *
     * @return  the NOMBATTV or <code>Float.NaN</code> if unavailable.
     */
    public float getNombattv() {
        return nombattv;
    }

    /**
     * Gets the number of external batteries as defined by the user.
     * A correct number here helps the UPS compute the remaining runtime more accurately.
     *
     * @return  the EXTBATTS or <code>-1</code> if unavailable.
     */
    public int getExtbatts() {
        return extbatts;
    }

    /**
     * Gets the number of bad battery packs.
     *
     * @return  the BADBATTS or <code>-1</code> if unavailable.
     */
    public int getBadbatts() {
        return badbatts;
    }

    /**
     * Gets the time currently on batteries.
     *
     * @return  the TONBATT or <code>null</code> if unavailable.
     */
    public TimeSpan getTonbatt() {
        return tonbatt;
    }

    /**
     * Gets the remaining runtime left on batteries as estimated by the UPS.
     *
     * @return  the TIMELEFT or <code>null</code> if unavailable.
     */
    public TimeSpan getTimeleft() {
        return timeleft;
    }

    /**
     * Gets the internal UPS temperature as supplied by the UPS.
     *
     * @return  the ITEMP or <code>Float.NaN</code> if unavailable.
     */
    public float getItemp() {
        return itemp;
    }
}
