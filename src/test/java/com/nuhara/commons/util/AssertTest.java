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

import static com.nuhara.commons.util.ClassUtils.getShortClassName;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test for {@link Assert}.
 *
 * @author Alistair A. Israel
 */
public final class AssertTest {

    /**
     * Test for {@link Assert#notNull(Object, String)}.
     */
    @Test
    public void testNotNull() {
        try {
            Assert.notNull(null, "NPE message");
            fail("NullPointerException not thrown!");
        } catch (final Exception e) {
            assertTrue("Expecting NullPointerException, got " + getShortClassName(e), e instanceof NullPointerException);
            assertEquals("NPE message", e.getMessage());
        }
    }

}
