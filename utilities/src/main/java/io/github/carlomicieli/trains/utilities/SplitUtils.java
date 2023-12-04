/*
 *   Copyright (c) 2023-2023 (C) Carlo Micieli
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
package io.github.carlomicieli.trains.utilities;

import io.github.carlomicieli.trains.list.LinkedList;

class SplitUtils {
    public static LinkedList split(String source) {
        int lastFind = 0;
        int currentFind = 0;
        LinkedList result = new LinkedList();

        while ((currentFind = source.indexOf(" ", lastFind)) != -1) {
            String token = source.substring(lastFind);
            if (currentFind != -1) {
                token = token.substring(0, currentFind - lastFind);
            }

            addIfValid(token, result);
            lastFind = currentFind + 1;
        }

        String token = source.substring(lastFind);
        addIfValid(token, result);

        return result;
    }

    private static void addIfValid(String token, LinkedList list) {
        if (isTokenValid(token)) {
            list.add(token);
        }
    }

    private static boolean isTokenValid(String token) {
        return !token.isEmpty();
    }
}
