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
package io.github.carlomicieli.trains.app.catalog;

import io.github.carlomicieli.trains.catalog.scales.Scale;
import io.github.carlomicieli.trains.catalog.scales.ScaleRequest;
import io.github.carlomicieli.trains.catalog.scales.ScalesList;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;

@Controller
public class ScalesController {
    @Post("/api/scales")
    public HttpResponse<Void> createScale(@Body ScaleRequest scaleRequest) {
        return HttpResponse.ok();
    }

    @Put("/api/scales/{scaleId}")
    public HttpResponse<Scale> updateScale(@PathVariable("scaleId") String scaleId, @Body ScaleRequest scaleRequest) {
        return HttpResponse.ok();
    }

    @Get("/api/scales/{scaleId}")
    public HttpResponse<Scale> getScale(@PathVariable("scaleId") String scaleId) {
        return HttpResponse.ok();
    }

    @Get("/api/scales")
    public HttpResponse<ScalesList> getScales(
            @Nullable @QueryValue("offset") Integer offset, @Nullable @QueryValue("limit") Integer limit) {
        return HttpResponse.ok();
    }

    @Delete("/api/scales/{scaleId}")
    public HttpResponse<Void> deleteScale(@PathVariable("scaleId") String scaleId) {
        return HttpResponse.ok();
    }
}
