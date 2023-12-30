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

import io.github.carlomicieli.trains.catalog.brands.Brand;
import io.github.carlomicieli.trains.catalog.brands.BrandRequest;
import io.github.carlomicieli.trains.catalog.brands.BrandsList;
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
public class BrandsController {
    @Post("/api/brands")
    public HttpResponse<Void> createBrand(@Body BrandRequest brandRequest) {
        return HttpResponse.ok();
    }

    @Put("/api/brands/{brandId}")
    public HttpResponse<Brand> updateBrand(@PathVariable("brandId") String brandId, @Body BrandRequest brandRequest) {
        return HttpResponse.ok();
    }

    @Get("/api/brands/{brandId}")
    public HttpResponse<Brand> getBrand(@PathVariable("brandId") String brandId) {
        return HttpResponse.ok();
    }

    @Get("/api/brands")
    public HttpResponse<BrandsList> getBrands(
            @Nullable @QueryValue("offset") Integer offset, @Nullable @QueryValue("limit") Integer limit) {
        return HttpResponse.ok();
    }

    @Delete("/api/brands/{brandId}")
    public HttpResponse<Void> deleteBrand(@PathVariable("brandId") String brandId) {
        return HttpResponse.ok();
    }
}
