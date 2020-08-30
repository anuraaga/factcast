/*
 * Copyright © 2017-2020 factcast.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.factcast.itests.factus.event;

import java.util.Set;
import java.util.UUID;

import org.factcast.factus.event.EventObject;
import org.factcast.factus.event.Specification;

import com.google.common.collect.Sets;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Specification(ns = "test")
public class TestAggregateIncremented implements EventObject {
    UUID aggregateId;

    @Override
    public Set<UUID> aggregateIds() {
        return Sets.newHashSet(aggregateId);
    }
}
