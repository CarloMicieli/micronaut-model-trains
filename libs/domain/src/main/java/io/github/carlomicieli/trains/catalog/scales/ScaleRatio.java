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
package io.github.carlomicieli.trains.catalog.scales;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * It represents the ratio between the real world and the model (e.g. 1/87 or 1:87)
 * @param value the ratio value
 */
public record ScaleRatio(BigDecimal value) {
    /**
     * The ratio for the H0 scale (1:87)
     */
    public static final ScaleRatio H0_RATIO = new ScaleRatio(BigDecimal.valueOf(87));
    /**
     * The ratio for the TT scale (1:120)
     */
    public static final ScaleRatio TT_RATIO = new ScaleRatio(BigDecimal.valueOf(120));
    /**
     * The ratio for the N scale (1:160)
     */
    public static final ScaleRatio N_RATIO = new ScaleRatio(BigDecimal.valueOf(160));

    public ScaleRatio {
        Objects.requireNonNull(value);
    }

    public static ScaleRatio of(float value) {
        if (value == H0_RATIO.value.floatValue()) {
            return H0_RATIO;
        } else if (value == TT_RATIO.value.floatValue()) {
            return TT_RATIO;
        } else if (value == N_RATIO.value.floatValue()) {
            return N_RATIO;
        }

        return new ScaleRatio(BigDecimal.valueOf(value));
    }
}
