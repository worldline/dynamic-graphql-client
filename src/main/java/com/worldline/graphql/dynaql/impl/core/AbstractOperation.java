/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.worldline.graphql.dynaql.impl.core;

import org.eclipse.microprofile.graphql.client.core.Field;
import org.eclipse.microprofile.graphql.client.core.Operation;
import org.eclipse.microprofile.graphql.client.core.OperationType;
import org.eclipse.microprofile.graphql.client.core.Variable;

import java.util.List;

public abstract class AbstractOperation implements Operation {
    private OperationType type;
    private String name;
    private List<Variable> variables;
    private List<Field> fields;

    /*
        Constructors
    */
    public AbstractOperation() {
    }

    /*
        Getter/Setter
    */
    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> vars) {
        this.variables = vars;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
