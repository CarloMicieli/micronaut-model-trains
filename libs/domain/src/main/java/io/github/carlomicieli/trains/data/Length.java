/*
 *   Copyright (c) 2023 (C) Carlo Micieli
 *
 *    Licensed to the Apache Software Foundation (ASF) under one
 *    or more contributor license agreements.  See the NOTICE file
 *    distributed with this work for additional information
 *    regarding copyright ownership.  The ASF licenses this file
 *    to you under the Apache License, Version 2.0 (the
 *    "License"); you may not use this file except in compliance
 *    with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */
package io.github.carlomicieli.trains.data;

import java.math.BigDecimal;
import java.util.Objects;

public sealed interface Length {
    default MeasureUnit measureUnit() {
        return switch (this) {
            case Inches in -> MeasureUnit.INCHES;
            case Kilometers km -> MeasureUnit.KILOMETERS;
            case Meters m -> MeasureUnit.METERS;
            case Miles mi -> MeasureUnit.MILES;
            case Millimeters mm -> MeasureUnit.MILLIMETERS;
        };
    }

    static Length of(BigDecimal value, MeasureUnit measureUnit) {
        Objects.requireNonNull(value);
        Objects.requireNonNull(measureUnit);

        return switch (measureUnit) {
            case INCHES -> new Inches(value);
            case KILOMETERS -> new Kilometers(value);
            case METERS -> new Meters(value);
            case MILES -> new Miles(value);
            case MILLIMETERS -> new Millimeters(value);
        };
    }
}

record Millimeters(BigDecimal value) implements Length {}

record Meters(BigDecimal value) implements Length {}

record Miles(BigDecimal value) implements Length {}

record Inches(BigDecimal value) implements Length {}

record Kilometers(BigDecimal value) implements Length {}
