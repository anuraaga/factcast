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
package org.factcast.factus;

import lombok.Data;
import org.factcast.factus.projection.Aggregate;

@Data
class PersonAggregate extends Aggregate {

  private String name = "";

  private int processed = 0;

  @Handler
  void process(NameEvent event) {
    this.name = event.name();
    this.processed++;
  }
}