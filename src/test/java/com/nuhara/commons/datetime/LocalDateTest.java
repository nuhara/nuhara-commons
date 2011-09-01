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
 * Created Aug 31, 2011
 */
package com.nuhara.commons.datetime;

import static com.nuhara.commons.datetime.Month.FEBRUARY;
import static com.nuhara.commons.datetime.Month.JANUARY;
import static com.nuhara.commons.util.ClassUtils.getShortClassName;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author Alistair A. Israel
 */
public final class LocalDateTest {

    /**
     * Test {@link LocalDate#toString()}
     */
    @Test
    public void testToString() {
        final LocalDate date = new LocalDate(2011, Month.FEBRUARY, 24);
        assertEquals("2011-02-24", date.toString());
    }

    /**
     *
     */
    @Test
    public void testInvalidConstruction() {
        final Object[][] aargs = { { -1, FEBRUARY, 1 }, { 1899, FEBRUARY, 1 }, { 2100, FEBRUARY, 1 },
                { 1999, FEBRUARY, 0 }, { 1999, FEBRUARY, 29 }, { 2000, FEBRUARY, 30 }, { 1900, null, 1 } };
        final String[] msgs = { "Invalid year: -1! Year must be within 1900..2099",
                "Invalid year: 1899! Year must be within 1900..2099",
                "Invalid year: 2100! Year must be within 1900..2099", "Invalid day of month: 0! Must be within 1..28",
                "Invalid day of month: 29! Must be within 1..28", "Invalid day of month: 30! Must be within 1..29",
                "Month cannot be null!" };
        for (int i = 0; i < msgs.length; ++i) {
            final Object[] args = aargs[i];
            try {
                @SuppressWarnings("unused")
                final LocalDate ld = new LocalDate((Integer) args[0], (Month) args[1], (Integer) args[2]);
                fail("IllegalArgumentException(\"" + msgs[i] + "\") not thrown!");
            } catch (final Exception e) {
                if (!(e instanceof IllegalArgumentException)) {
                    e.printStackTrace();
                    fail("Expecting IllegalArgumentException, got " + getShortClassName(e));
                }
                assertEquals(msgs[i], e.getMessage());
            }
        }
    }

    private final LocalDate millenium = new LocalDate(2000, JANUARY, 1);
    private final LocalDate d1 = new LocalDate(2011, FEBRUARY, 24);
    private final LocalDate d2 = new LocalDate(2011, FEBRUARY, 24);

    /**
     * Test for {@link LocalDate#hashCode()}.
     */
    @Test
    public void testHashCode() {
        assertEquals(1951792, millenium.hashCode());
        assertEquals(1962417, d1.hashCode());
        assertEquals(1962417, d2.hashCode());
    }

    /**
     * Test for {@link LocalDate#equals(Object)}.
     */
    @Test
    public void testEqualsObject() {
        assertFalse(d1.equals(millenium));
        assertTrue(d1.equals(d2));
        assertTrue(d2.equals(d1));
    }

    /**
     * Test for {@link LocalDate#compareTo(LocalDate)}.
     */
    @Test
    public void testCompareTo() {
        assertEquals(-1, millenium.compareTo(d1));
        assertEquals(1, d1.compareTo(millenium));
        assertEquals(0, d1.compareTo(d2));
        assertEquals(0, d2.compareTo(d1));
    }

}
