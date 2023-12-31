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

import io.github.carlomicieli.trains.data.LocalizedText;
import java.util.List;

/**
 * It represents a request to create/update rail transport modelling scales
 * @param name the scale name
 * @param ratio the ratio between the real world and the model (e.g. 1/87 or 1:87)
 * @param gauge the scale gauge
 * @param description
 * @param standards the list of standards
 */
public record ScaleRequest(
        String name, ScaleRatio ratio, ScaleGauge gauge, LocalizedText description, List<ScaleStandard> standards) {}
