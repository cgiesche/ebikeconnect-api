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


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EBCUser {

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("home_address")
    private EBCAddress homeAddress;

    @JsonProperty("work_address")
    private EBCAddress workAddress;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("height")
    private int height;

    @JsonProperty("weight")
    private double weight;

    @JsonProperty("activity_level")
    private int activityLevel;

    @JsonProperty("wifi_token_list")
    private List<EBCWifiToken> wifiTokenList;

    @JsonProperty("remaining_home_changes")
    private int remainingHomeChanges;

    @JsonProperty("facebook")
    private long facebookId;

    @JsonProperty("picture")
    private String picture;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EBCAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(EBCAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public EBCAddress getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(EBCAddress workAddress) {
        this.workAddress = workAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public List<EBCWifiToken> getWifiTokenList() {
        return wifiTokenList;
    }

    public void setWifiTokenList(List<EBCWifiToken> wifiTokenList) {
        this.wifiTokenList = wifiTokenList;
    }

    public int getRemainingHomeChanges() {
        return remainingHomeChanges;
    }

    public void setRemainingHomeChanges(int remainingHomeChanges) {
        this.remainingHomeChanges = remainingHomeChanges;
    }

    public long getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(long facebookId) {
        this.facebookId = facebookId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
