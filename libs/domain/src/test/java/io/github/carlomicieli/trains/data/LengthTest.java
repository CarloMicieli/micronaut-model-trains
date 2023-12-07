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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("Lengths")
class LengthTest {
    @ParameterizedTest
    @EnumSource(MeasureUnit.class)
    void shouldCreateLengthValues(MeasureUnit measureUnit) {
        BigDecimal value = BigDecimal.valueOf(42);
        Length length = Length.of(value, measureUnit);
        assertNotNull(length);
        assertEquals(measureUnit, length.measureUnit());
        assertEquals(value, length.value());
    }

    @ParameterizedTest
    @EnumSource(MeasureUnit.class)
    void shouldThrowExceptionForNegativeValues(MeasureUnit measureUnit) {
        BigDecimal negativeValue = BigDecimal.valueOf(-42);
        assertThrowsExactly(IllegalArgumentException.class, () -> Length.of(negativeValue, measureUnit));
    }
}
