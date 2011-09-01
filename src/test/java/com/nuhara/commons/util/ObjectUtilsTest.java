/**
 * Copyright (c) 2011 Nuhara, Inc.
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
 *
 * Created Sep 1, 2011
 */
package com.nuhara.commons.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test for {@link ObjectUtils}
 *
 * @author Alistair A. Israel
 */
public final class ObjectUtilsTest {

    /**
     * Test for {@link ObjectUtils#nullSafeEquals(Object, Object)}.
     */
    @Test
    public void testNullSafeEquals() {
        final Object nil = null;
        final String dog = "dog";

        assertTrue(ObjectUtils.nullSafeEquals(nil, nil));
        assertFalse(ObjectUtils.nullSafeEquals(nil, dog));
        assertFalse(ObjectUtils.nullSafeEquals(dog, nil));
        assertTrue(ObjectUtils.nullSafeEquals(dog, dog));
    }

}
