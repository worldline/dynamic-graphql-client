/*
 * Copyright 2020 jefrajames.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.worldline.graphql.dynaql.impl.http;

import com.worldline.graphql.dynaql.impl.DynaQLResponse;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jefrajames
 */
public class HttpResponse {
    
    private Map<String, String> headers = new HashMap<>();
    
    private DynaQLResponse graphQLResponse;
    
    protected HttpResponse() {}

    public Map<String, String> getHeaders() {
        return headers;
    }

    protected void header(String key, String value) {
        this.headers.put(key, value);
    }

    protected void setGraphQLResponse(DynaQLResponse graphQLResponse) {
        this.graphQLResponse = graphQLResponse;
    }

    public DynaQLResponse getGraphQLResponse() {
        return graphQLResponse;
    }

    @Override
    public String toString() {
        return "HttpResponse{" + "headers=" + headers + ", graphQLResponse=" + graphQLResponse + '}';
    }
    
    
}