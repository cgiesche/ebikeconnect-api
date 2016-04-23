package de.perdoctus.ebikeconnect.api.activities;

/*
 * #%L
 * EbikeConnect API
 * %%
 * Copyright (C) 2016 Christoph Giesche
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import de.perdoctus.ebikeconnect.api.login.EBCLocation;

import java.util.ArrayList;
import java.util.List;

public class EBCRawActivity {

    @JsonUnwrapped
    private EBCActivityHeader activityHeader;

    @JsonProperty("index")
    private int index;

    @JsonProperty("avg_speed")
    private double avgSpeed;

    @JsonProperty("avg_heart_rate")
    private double avgHeartRate;

    @JsonProperty("avg_cadence")
    private double avgCadence;

    @JsonProperty("avg_altitude")
    private double avgAltitude;

    @JsonProperty("max_speed")
    private double maxSpeed;

    @JsonProperty("max_heart_rate")
    private int maxHeartRate;

    @JsonProperty("max_cadence")
    private int maxCadence;

    @JsonProperty("max_altitude")
    private double maxAltitude;

    @JsonProperty("drive_unit_serial")
    private String driveUnitSerial;

    @JsonProperty("training_effect")
    private int trainingEffect;

    @JsonProperty("training_load_peak")
    private int trainingLoadPeak;

    @JsonProperty("significant")
    private int significant;

    @JsonProperty("elevation_gain")
    private double elevationGain;

    @JsonProperty("elevation_loss")
    private double elevationLoss;

    @JsonProperty("serials_batteries")
    private List<Object> serialsBatteries = new ArrayList<>();

    @JsonProperty("gps_points")
    private List<EBCLocation> gpsPoints;

    @JsonProperty("altitudes")
    private List<Float> altitudes;

    @JsonProperty("activity_data")
    private List<EBCRawActivityData> activityData;

    public EBCActivityHeader getActivityHeader() {
        return activityHeader;
    }

    public void setActivityHeader(EBCActivityHeader activityHeader) {
        this.activityHeader = activityHeader;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public double getAvgHeartRate() {
        return avgHeartRate;
    }

    public void setAvgHeartRate(double avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }

    public double getAvgCadence() {
        return avgCadence;
    }

    public void setAvgCadence(double avgCadence) {
        this.avgCadence = avgCadence;
    }

    public double getAvgAltitude() {
        return avgAltitude;
    }

    public void setAvgAltitude(double avgAltitude) {
        this.avgAltitude = avgAltitude;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxHeartRate() {
        return maxHeartRate;
    }

    public void setMaxHeartRate(int maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }

    public int getMaxCadence() {
        return maxCadence;
    }

    public void setMaxCadence(int maxCadence) {
        this.maxCadence = maxCadence;
    }

    public double getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(double maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public String getDriveUnitSerial() {
        return driveUnitSerial;
    }

    public void setDriveUnitSerial(String driveUnitSerial) {
        this.driveUnitSerial = driveUnitSerial;
    }

    public int getTrainingEffect() {
        return trainingEffect;
    }

    public void setTrainingEffect(int trainingEffect) {
        this.trainingEffect = trainingEffect;
    }

    public int getTrainingLoadPeak() {
        return trainingLoadPeak;
    }

    public void setTrainingLoadPeak(int trainingLoadPeak) {
        this.trainingLoadPeak = trainingLoadPeak;
    }

    public int getSignificant() {
        return significant;
    }

    public void setSignificant(int significant) {
        this.significant = significant;
    }

    public double getElevationGain() {
        return elevationGain;
    }

    public void setElevationGain(double elevationGain) {
        this.elevationGain = elevationGain;
    }

    public double getElevationLoss() {
        return elevationLoss;
    }

    public void setElevationLoss(double elevationLoss) {
        this.elevationLoss = elevationLoss;
    }

    public List<Object> getSerialsBatteries() {
        return serialsBatteries;
    }

    public void setSerialsBatteries(List<Object> serialsBatteries) {
        this.serialsBatteries = serialsBatteries;
    }

    public List<EBCLocation> getGpsPoints() {
        return gpsPoints;
    }

    public void setGpsPoints(List<EBCLocation> gpsPoints) {
        this.gpsPoints = gpsPoints;
    }

    public List<Float> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(List<Float> altitudes) {
        this.altitudes = altitudes;
    }

    public List<EBCRawActivityData> getActivityData() {
        return activityData;
    }

    public void setActivityData(List<EBCRawActivityData> activityData) {
        this.activityData = activityData;
    }
}
