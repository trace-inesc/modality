/*
 * Copyright (c) 2016 Rodrigo Lourenço, Miguel Costa, Paulo Ferreira, João Barreto @  INESC-ID.
 *
 * This file is part of TRACE.
 *
 * TRACE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TRACE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TRACE.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.trace.modalityrecognizer.data;

import com.google.android.gms.location.DetectedActivity;
import com.google.gson.JsonObject;

/**
 * A TraceModality object is characterized by the user's modality, the confidence associated with
 * that specific modality and the time at which the modality was recognized.
 * <br><br>
 * The library was designed to support a specific set of modalities.
 *
 * @see Modality
 */
public class TraceModality {

    private Modality modality;
    private int confidence;
    private long timestamp;

    public TraceModality(){}

    public TraceModality(Modality modality, int confidence, long timestamp){
        this.modality   = modality;
        this.confidence = confidence;
        this.timestamp  = timestamp;

    }

    public TraceModality(int activity, int confidence, long timestamp){
        this.modality   = activityToModality(activity);
        this.confidence = confidence;
        this.timestamp  = timestamp;
    }

    private Modality activityToModality(int activity){

        switch (activity){
            case DetectedActivity.TILTING:
            case DetectedActivity.UNKNOWN:
                return Modality.Unknown;
            case DetectedActivity.ON_BICYCLE:
                return Modality.Cycling;
            case DetectedActivity.IN_VEHICLE:
                return Modality.Car;
            case DetectedActivity.ON_FOOT:
            case DetectedActivity.WALKING:
                return Modality.Walking;
            case DetectedActivity.RUNNING:
                return Modality.Running;
            case DetectedActivity.STILL:
                return Modality.Stationary;

        }

        return Modality.Unknown;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public JsonObject toJson(){
        JsonObject object = new JsonObject();

        object.addProperty("modality", modality.ordinal());
        object.addProperty("confidence", confidence);
        object.addProperty("timestamp", timestamp);

        return object;
    }

    @Override
    public String toString(){
        return toJson().toString();
    }

    /**
     * Two TraceModality objects are considered equal if the have the same modality and confidence
     * levels, regardless of their timestamp.
     * @param o The TraceModality to compare
     * @return True if they are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        TraceModality m2 = (TraceModality) o;

        return m2.getConfidence() == this.getConfidence() && m2.getModality() == this.getModality();
    }
}