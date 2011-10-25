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
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.TimeZone;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Junit test for {@link DateTime}
 *
 * @author Alistair A. Israel
 */
public final class DateTimeTest {

    /**
     *
     */
    private static final Date FEB_24_2011_8_03 = new Date(1298505780000L);

    private static final LocalDate FEB_24_2011 = new LocalDate(2011, Month.FEBRUARY, 24);

    private static final LocalTime EIGHT_03 = new LocalTime(8, 3);

    private static final TimeZone PHT = TimeZone.getTimeZone("Asia/Manila");

    /**
     * ExpectedException rule
     */
    @Rule
    // SUPPRESS CHECKSTYLE VisibilityModifier
    public final ExpectedException thrown = ExpectedException.none();

    /**
     *
     */
    @Test
    public void testNewUsingDateTimeZone() {
        final DateTime dt = new DateTime(FEB_24_2011_8_03, PHT);
        assertEquals("2011-02-24 08:03:00.000 PHT", dt.toString());
    }

    /**
     *
     */
    @Test
    public void testNewUsingLocalDateLocalTimeTimeZone() {
        final DateTime dt = new DateTime(FEB_24_2011, EIGHT_03, PHT);
        assertEquals("2011-02-24 08:03 PHT", dt.toString());
    }

    /**
     *
     */
    @Test
    public void testInvalidYear() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(is("Invalid year: -1! Year must be within 1900..2099"));
        DateTime.getDateTime(-1, FEBRUARY, 24, 8, 3, 0, PHT);
    }
}
