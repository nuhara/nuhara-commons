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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author Alistair A. Israel
 */
public final class LocalTimeTest {

    private static final LocalTime LAST_MIDNIGHT = new LocalTime(0, 0);

    private static final LocalTime NOON = new LocalTime(12, 0);

    private static final LocalTime NEXT_MIDNIGHT = new LocalTime(24, 0);

    private static final LocalTime[] TIMES = { LAST_MIDNIGHT, new LocalTime(1, 23, 45, 678), NOON, NEXT_MIDNIGHT };

    /**
     * Test construction with invalid parameters
     */
    @Test
    public void testInvalidTimes() {
        final int[][] aargs = {
            { -1, 0 },
            { 25, 0 },
            { 0, -1 },
            { 0, 60 },
            { 0, 0, -1 },
            { 0, 0, 60 },
            { 0, 0, 0, -1 },
            { 0, 0, 0, 1000 },
            { 24, 1 },
            { 24, 0, 1 },
            { 24, 0, 0, 1 }
        };
        final String[] messages = {
            "Invalid hour: -1",
            "Invalid hour: 25",
            "Invalid minute: -1",
            "Invalid minute: 60",
            "Invalid second: -1",
            "Invalid second: 60",
            "Invalid millisecond: -1",
            "Invalid millisecond: 1000",
            "Can only represent up to 24:00:00.000!",
            "Can only represent up to 24:00:00.000!",
            "Can only represent up to 24:00:00.000!"
        };
        for (int i = 0; i < aargs.length; ++i) {
            final int[] args = aargs[i];
            try {
                @SuppressWarnings("unused")
                final LocalTime time = constructUsing(args);
                fail("No exception thrown for: " + Arrays.toString(args));
            } catch (final IllegalArgumentException e) {
                assertEquals(messages[i], e.getMessage());
            }
        }
    }

    /**
     * @param args
     *        the args
     * @return LocalTime
     */
    private static LocalTime constructUsing(final int... args) {
        switch (args.length) {
        case 1:
            fail("Not enough arguments: " + Arrays.toString(args));
            break;
        case 2:
            return new LocalTime(args[0], args[1]);
        case 3:
            return new LocalTime(args[0], args[1], args[2]);
        case 4:
            return new LocalTime(args[0], args[1], args[2], args[3]);
        default:
            fail("Too many arguments: " + Arrays.toString(args));
        }
        return null;
    }

    /**
     * Test for {@link LocalTime#toMillisPastMidnight()}.
     */
    @Test
    public void testToMillisPastMidnight() {
        final int[] expected = { 0, 5025678 };
        for (int i = 0; i < expected.length; ++i) {
            final LocalTime time = TIMES[i];
            assertEquals(expected[i], time.toMillisPastMidnight());
        }
    }

    /**
     * Test for {@link LocalTime#hashCode()}
     */
    @Test
    public void testHashCode() {
        final int[] expected = { 0, 5025678, 43200000, 86400000 };
        for (int i = 0; i < expected.length; ++i) {
            final LocalTime time = TIMES[i];
            assertEquals(expected[i], time.hashCode());
        }
    }

    /**
     * Test for {@link LocalTime#equals(java.lang.Object)}.
     */
    @Test
    public void testEquals() {
        final LocalTime time1 = TIMES[1];
        final Object time2 = new LocalTime(1, 23, 45, 678);
        assertTrue(time1.equals(time2));
        assertTrue(time2.equals(time1));
        assertEquals(time1, time2);
        assertEquals(time2, time1);

        assertFalse(time1.equals(NOON));
    }

    /**
     * Test for {@link LocalTime#compareTo(LocalTime)}.
     */
    @Test
    public void testCompareTo() {
        final LocalTime time1 = TIMES[1];
        final LocalTime time2 = new LocalTime(1, 23, 45, 678);
        assertEquals(0, time1.compareTo(time2));
        assertEquals(0, time2.compareTo(time1));

        assertEquals(-1, LAST_MIDNIGHT.compareTo(NOON));
        assertEquals(1, NEXT_MIDNIGHT.compareTo(NOON));
    }
}
