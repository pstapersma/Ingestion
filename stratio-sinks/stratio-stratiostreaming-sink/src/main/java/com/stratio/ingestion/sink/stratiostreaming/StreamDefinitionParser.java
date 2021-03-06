/**
 * Copyright (C) 2014 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
  * Copyright 2014 Stratio.
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
package com.stratio.ingestion.sink.stratiostreaming;

import org.codehaus.jackson.map.ObjectMapper;

public class StreamDefinitionParser {
    
    private String jsonDefinition;

    public StreamDefinitionParser(String jsonDefinition) {
        this.jsonDefinition = jsonDefinition;
    }
    
    public StreamDefinition parse() {
        ObjectMapper mapper = new ObjectMapper();
        StreamDefinition streamDefinition;
        try {
            streamDefinition = mapper.readValue(jsonDefinition,
                              StreamDefinition.class);
            } catch (Exception e) {
               throw new StratioStreamingSinkException(e);
            }
            return streamDefinition;
    }
}

