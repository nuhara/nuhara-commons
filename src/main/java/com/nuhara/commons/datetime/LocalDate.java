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

import static com.nuhara.commons.datetime.DateUtils.UTC;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.YEAR;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.nuhara.commons.util.Assert;
import com.nuhara.commons.util.Hashcode;

/**
 * An 'abstract' date in the Gregorian calendar, with no time or timezone information.
 *
 * @author Alistair A. Israel
 * @since 0.1
 */
public class LocalDate implements Serializable, Comparable<LocalDate> {

    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 387427985277361928L;

    private final int year;

    private final Month month;

    private final int dayOfMonth;

    /**
     * @return LocalDate in system default timezone
     */
    public static LocalDate today() {
        final GregorianCalendar cal = new GregorianCalendar();
        return new LocalDate(cal.get(YEAR), Month.of(cal), cal.get(DAY_OF_MONTH));
    }

    /**
     * @param timeZone
     *        the {@link TimeZone}
     * @return LocalDate in the given timezone
     */
    public static LocalDate today(final TimeZone timeZone) {
        final GregorianCalendar cal = new GregorianCalendar(timeZone);
        return new LocalDate(cal.get(YEAR), Month.of(cal), cal.get(DAY_OF_MONTH));
    }

    /**
     * @param year
     *        the year
     * @param month
     *        the {@link Month}
     * @param dayOfMonth
     *        the day of the month
     */
    public LocalDate(final int year, final Month month, final int dayOfMonth) {
        Assert.isTrue(year >= 1900 && year <= 2099, "Invalid year: " + year + "! Year must be within 1900..2099");
        // IllegalArgumentException instead of NPE
        Assert.isTrue(month != null, "Month cannot be null!");
        final GregorianCalendar cal = new GregorianCalendar(UTC);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month.intValue());
        final int min = cal.getActualMinimum(DAY_OF_MONTH);
        final int max = cal.getActualMaximum(DAY_OF_MONTH);
        Assert.isTrue(dayOfMonth >= min && dayOfMonth <= max, "Invalid day of month: " + dayOfMonth
                + "! Must be within " + min + ".." + max);
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    /**
     * @return the year
     */
    public final int getYear() {
        return year;
    }

    /**
     * @return the month
     */
    public final Month getMonth() {
        return month;
    }

    /**
     * @return the day of the month
     */
    public final int getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#hashCode()
     */
    // SUPPRESS CHECKSTYLE DesignForExtension
    @Override
    public int hashCode() {
        return Hashcode.of(year, month.intValue(), dayOfMonth);
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    // SUPPRESS CHECKSTYLE DesignForExtension
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LocalDate other = (LocalDate) obj;
        return this.year == other.year && this.month == other.month && this.dayOfMonth == other.dayOfMonth;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    // SUPPRESS CHECKSTYLE DesignForExtension
    @Override
    public int compareTo(final LocalDate other) {
        if (this.year != other.year) {
            if (this.year < other.year) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.month != other.month) {
            return this.month.compareTo(other.month);
        } else if (this.dayOfMonth != other.dayOfMonth) {
            if (this.dayOfMonth < other.dayOfMonth) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#toString()
     */
    // SUPPRESS CHECKSTYLE DesignForExtension
    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", this.year, this.month.intValue() + 1, this.dayOfMonth);
    }
}
