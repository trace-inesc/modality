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

/**
 * Supported modalities.
 */
public enum  Modality {
    /** Unknown modality */
    Unknown,
    /** The modality when the user is stationary or still */
    Stationary,
    /** The modality when the user is walking */
    Walking,
    /** The modality when the user is running */
    Running,
    /** The modality when the user is cycling a regular bike */
    Cycling,
    /** The modality when the user is cycling a sports bike */
    SportsCycling,
    /** The modality when the user is cycling an electric bike */
    EBike,
    /** The modality when the user is riding a motorcycle */
    Motorcycle,
    /** The modality when the user is riding a car */
    Car,
    /** The modality when the user is taking the bus */
    Bus,
    /** The modality when the user is taking the train */
    Train,
    /** The modality when the user is taking the tram */
    Tram,
    /** The modality when the user is the subway */
    Subway
}
