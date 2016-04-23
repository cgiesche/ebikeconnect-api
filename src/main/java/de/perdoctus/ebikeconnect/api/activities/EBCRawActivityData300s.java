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

public class EBCRawActivityData300s extends EBCRawActivityData {

    @JsonProperty("air_pressure")
    private List<Double> airPressures;

    @JsonProperty("temperature")
    private List<Double> temperatures;

    @JsonProperty("altitude")
    private List<Double> altitudes;


    public List<Double> getAirPressures() {
        return airPressures;
    }

    public void setAirPressures(List<Double> airPressures) {
        this.airPressures = airPressures;
    }

    public List<Double> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<Double> temperatures) {
        this.temperatures = temperatures;
    }

    public List<Double> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(List<Double> altitudes) {
        this.altitudes = altitudes;
    }
}
