/*
 * Copyright 2014 Dayatang Open Source..
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

package org.dayatang.domain.internal;

import org.dayatang.domain.MapParameters;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yyang
 */
public class SizeGtCriterionTest {
    
    private SizeGtCriterion instance;

    @Before
    public void setUp() {
        instance = new SizeGtCriterion("name", 3);
    }

    @Test
    public void testGetValue() {
        assertEquals(3, instance.getValue());
    }

    @Test
    public void testToQueryString() {
        assertEquals("size(rootEntity.name) > :rootEntity_name", 
                instance.toQueryString());
    }

    @Test
    public void testGetParameters() {
        assertEquals(MapParameters.create().add("rootEntity_name", 3), 
                instance.getParameters());
    }

    @Test
    public void testEquals() {
        assertFalse(instance.equals(null));
        assertFalse(instance.equals("abc"));
        assertTrue(instance.equals(instance));
        
        SizeGtCriterion other = new SizeGtCriterion("name", 3);
        assertTrue(instance.equals(other));
        assertTrue(other.equals(instance));
        
        assertFalse(instance.equals(new SizeGtCriterion("name", 4)));
    }
    
}