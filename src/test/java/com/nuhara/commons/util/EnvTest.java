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
 * Created Jun 7, 2011
 */
package com.nuhara.commons.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Alistair A. Israel
 */
public final class EnvTest {

    private static final String KEY = "some.property";

    private static final String NOT_A_KEY = "not a key";

    /**
     * Test method for {@link com.nuhara.commons.util.Env#get(String, boolean)}.
     */
    @Test
    public void testGetStringBoolean() {
        assertTrue(Env.get(NOT_A_KEY, true));
        assertFalse(Env.get(NOT_A_KEY, false));

        System.setProperty(KEY, "");

        assertTrue(Env.get(KEY, true));
        assertFalse(Env.get(KEY, false));

        final String[] falseValues = { "0", "false", "FALSE", "no", "No" };
        for (final String value : falseValues) {
            System.setProperty(KEY, value);
            assertFalse("Env.get(\"" + value + "\", true) returned true", Env.get(KEY, true));
        }
        final String[] trueValues = { "1", "true", "TRUE", "yes", "Yes" };
        for (final String value : trueValues) {
            System.setProperty(KEY, value);
            assertTrue("Env.get(\"" + value + "\", false) returned false", Env.get(KEY, false));
        }
    }

    /**
     * Test method for {@link com.nuhara.commons.util.Env#get(String, int)}.
     */
    @Test
    public void testGetStringInt() {
        for (int i = -100; i < 100; ++i) {
            assertEquals(i, Env.get(NOT_A_KEY, i));
            System.setProperty(KEY, Integer.toString(i));
            assertEquals(i, Env.get(KEY, Integer.MIN_VALUE));
            assertEquals(i, Env.get(KEY, Integer.MAX_VALUE));
        }
    }

}
