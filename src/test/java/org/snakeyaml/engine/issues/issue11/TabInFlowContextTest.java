/*
 * Copyright (c) 2018, http://www.snakeyaml.org
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
package org.snakeyaml.engine.issues.issue11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@org.junit.jupiter.api.Tag("fast")
public class TabInFlowContextTest {

    @Test
    @DisplayName("Do not fail to parse if TAB is used (issue 11)")
    void parseTabInFlowContext() {
        Load loader = new Load(LoadSettings.builder().build());
        Map<String, String> list = (Map<String, String>) loader.loadFromString("{\n\t\"x\": \"y\"\n}");
        assertEquals(1, list.size());
        assertEquals("y", list.get("x"));
    }
}
