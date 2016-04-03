package de.perdoctus.ebikeconnect.api.login;

/*
 * #%L
 * ebikeconnect-api
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


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class EBCUserSettings {

    @JsonProperty("id")
    private String id;

    @JsonProperty("language")
    private String language;

    @JsonProperty("units")
    private String units;

    @JsonProperty("time_format")
    private String timeFormat;

    @JsonProperty("date_format")
    private String dateFormat;

    @JsonProperty("user_objective")
    private String userObjective;

    @JsonProperty("overall_fitness")
    private Integer overallFitness;

    @JsonProperty("detailed_fitness")
    private Integer detailedFitness;

    @JsonProperty("s_pedelec")
    private Integer sPedelec;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getUserObjective() {
        return userObjective;
    }

    public void setUserObjective(String userObjective) {
        this.userObjective = userObjective;
    }

    public Integer getOverallFitness() {
        return overallFitness;
    }

    public void setOverallFitness(Integer overallFitness) {
        this.overallFitness = overallFitness;
    }

    public Integer getDetailedFitness() {
        return detailedFitness;
    }

    public void setDetailedFitness(Integer detailedFitness) {
        this.detailedFitness = detailedFitness;
    }

    public Integer getsPedelec() {
        return sPedelec;
    }

    public void setsPedelec(Integer sPedelec) {
        this.sPedelec = sPedelec;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
