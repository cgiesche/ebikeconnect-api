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

import java.util.List;

public class EBCRawActivityData1s extends EBCRawActivityData {

    @JsonProperty("cadence")
    private List<Short> cadence;

    @JsonProperty("heart_rate")
    private List<Short> heartRate;

    @JsonProperty("driver_torque")
    private List<Float> driverTorque;

    @JsonProperty("motor_torque")
    private List<Float> motorTorque;

    @JsonProperty("energy_economy")
    private List<Float> energyEconomy;

    @JsonProperty("diff_distance_gained")
    private List<Short> distanceGained;

    @JsonProperty("speed")
    private List<Float> speeds;

    @JsonProperty("motor_revolution_rate")
    private List<Short> motorRevolutionRate;

    public List<Short> getCadence() {
        return cadence;
    }

    public void setCadence(List<Short> cadence) {
        this.cadence = cadence;
    }

    public List<Short> getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(List<Short> heartRate) {
        this.heartRate = heartRate;
    }

    public List<Float> getDriverTorque() {
        return driverTorque;
    }

    public void setDriverTorque(List<Float> driverTorque) {
        this.driverTorque = driverTorque;
    }

    public List<Float> getMotorTorque() {
        return motorTorque;
    }

    public void setMotorTorque(List<Float> motorTorque) {
        this.motorTorque = motorTorque;
    }

    public List<Float> getEnergyEconomy() {
        return energyEconomy;
    }

    public void setEnergyEconomy(List<Float> energyEconomy) {
        this.energyEconomy = energyEconomy;
    }

    public List<Short> getDistanceGained() {
        return distanceGained;
    }

    public void setDistanceGained(List<Short> distanceGained) {
        this.distanceGained = distanceGained;
    }

    public List<Float> getSpeeds() {
        return speeds;
    }

    public void setSpeeds(List<Float> speeds) {
        this.speeds = speeds;
    }

    public List<Short> getMotorRevolutionRate() {
        return motorRevolutionRate;
    }

    public void setMotorRevolutionRate(List<Short> motorRevolutionRate) {
        this.motorRevolutionRate = motorRevolutionRate;
    }
}
