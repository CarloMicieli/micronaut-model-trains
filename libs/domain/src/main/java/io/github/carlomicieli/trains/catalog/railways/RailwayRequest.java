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
package io.github.carlomicieli.trains.catalog.railways;

import io.github.carlomicieli.trains.data.ContactInfo;
import io.github.carlomicieli.trains.data.LocalizedText;
import io.github.carlomicieli.trains.data.OrganizationEntityType;
import io.github.carlomicieli.trains.data.Socials;
import java.util.List;

/**
 * It represents the request to create/update railways
 * @param name the railway name
 * @param abbreviation the railway abbreviated name
 * @param registeredCompanyName the registered company name
 * @param organizationEntityType
 * @param description
 * @param country the registration ISO country code (ISO 3166-1 alpha-2)
 * @param periodOfActivity
 * @param gauge
 * @param headquarters the railway headquarters
 * @param totalLength
 * @param contactInfo
 * @param socials
 */
public record RailwayRequest(
        String name,
        String abbreviation,
        String registeredCompanyName,
        OrganizationEntityType organizationEntityType,
        LocalizedText description,
        String country,
        RailwayPeriodOfActivity periodOfActivity,
        RailwayGauge gauge,
        List<String> headquarters,
        RailwayTotalLength totalLength,
        ContactInfo contactInfo,
        Socials socials) {}
