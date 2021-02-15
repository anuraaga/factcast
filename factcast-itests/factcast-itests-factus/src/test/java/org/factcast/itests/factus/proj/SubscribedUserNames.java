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
package org.factcast.itests.factus.proj;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;
import org.factcast.factus.Handler;
import org.factcast.factus.projection.LocalSubscribedProjection;
import org.factcast.itests.factus.event.UserCreated;
import org.springframework.stereotype.Component;

@Component
public class SubscribedUserNames extends LocalSubscribedProjection implements UserNames {
  @Getter private final Map<UUID, String> userNames = new ConcurrentHashMap<UUID, String>();

  /**
   * this should cause an "Unhandled error" log entry and basically a long stacktrace if you run
   * {@link org.factcast.itests.factus.FactusClientTest.testSubscription} - with otel javaagent in
   * place this test will just hang and wont log something - with otel removed (or disabled) the
   * test fails and we see the log line - with this override commented out the test succeeds (with
   * and without otel)
   *
   * @param created
   */
  @Override
  @Handler
  public void apply(UserCreated created) {
    throw new IllegalStateException("broken");
  }
}
