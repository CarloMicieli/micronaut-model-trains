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

import io.github.carlomicieli.trains.catalog.catalogitems.RollingStock;
import io.github.carlomicieli.trains.catalog.catalogitems.RollingStockRequest;
import io.github.carlomicieli.trains.catalog.catalogitems.RollingStocksList;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

@Controller
public class RollingStocksController {
    @Post("/api/catalog-items/{catalogItemId}/rolling-stocks")
    public HttpResponse<Void> addRollingStock(
            @PathVariable("catalogItemId") String catalogItemId, @Body RollingStockRequest rollingStockRequest) {
        return HttpResponse.ok();
    }

    @Delete("/api/catalog-items/{catalogItemId}/rolling-stocks/{rollingStockId}")
    public HttpResponse<Void> deleteRollingStock(
            @PathVariable("catalogItemId") String catalogItemId,
            @PathVariable("rollingStockId") String rollingStockId) {
        return HttpResponse.ok();
    }

    @Get("/api/catalog-items/{catalogItemId}/rolling-stocks/{rollingStockId}")
    public HttpResponse<RollingStock> getRollingStock(
            @PathVariable("catalogItemId") String catalogItemId,
            @PathVariable("rollingStockId") String rollingStockId) {
        return HttpResponse.ok();
    }

    @Get("/api/catalog-items/{catalogItemId}/rolling-stocks")
    public HttpResponse<RollingStocksList> getRollingStocks(@PathVariable("catalogItemId") String catalogItemId) {
        return HttpResponse.ok();
    }

    @Put("/api/catalog-items/{catalogItemId}/rolling-stocks/{rollingStockId}")
    public HttpResponse<RollingStock> updateRollingStock(
            @PathVariable("catalogItemId") String catalogItemId,
            @PathVariable("rollingStockId") String rollingStockId,
            @Body RollingStockRequest rollingStockRequest) {
        return HttpResponse.ok();
    }
}
