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

import static com.nuhara.commons.util.ObjectUtils.nullSafeEquals;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.YEAR;
import static java.util.TimeZone.SHORT;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.nuhara.commons.util.Assert;
import com.nuhara.commons.util.Hashcode;

/**
 * Really just a decorator around an internal {@link GregorianCalendar}.
 *
 * @author Alistair A. Israel
 * @since 0.1
 */
public class DateTime {

    private final LocalDate localDate;

    private final LocalTime localTime;

    private final TimeZone timeZone;

    private GregorianCalendar cal;

    private boolean inDST;

    /**
     * @param localDate
     *        {@link LocalDate}
     * @param localTime
     *        {@link LocalTime}
     * @param timeZone
     *        {@link TimeZone}
     */
    public DateTime(final LocalDate localDate, final LocalTime localTime, final TimeZone timeZone) {
        Assert.notNull(localDate, "localDate cannot be null!");
        Assert.notNull(localTime, "localTime cannot be null!");
        Assert.notNull(timeZone, "timeZone cannot be null!");
        this.localDate = localDate;
        this.localTime = localTime;
        this.timeZone = timeZone;
    }

    /**
     * @param date
     *        the {@link Date}
     * @param timeZone
     *        the {@link TimeZone}
     */
    public DateTime(final Date date, final TimeZone timeZone) {
        Assert.notNull(date, "date cannot be null!");
        Assert.notNull(timeZone, "timeZone cannot be null!");
        this.cal = new GregorianCalendar(timeZone);
        cal.setTime(date);
        this.localDate = new LocalDate(cal.get(YEAR), Month.lookup(cal.get(MONTH)), cal.get(Calendar.DAY_OF_MONTH));
        this.localTime = new LocalTime(cal.get(HOUR_OF_DAY), cal.get(MINUTE), cal.get(SECOND), cal.get(MILLISECOND));
        this.timeZone = timeZone;
    }

    /**
     * @param year
     *        the year
     * @param month
     *        the {@link Month}
     * @param dayOfMonth
     *        the day of the month
     * @param hour
     *        the hour of day
     * @param minute
     *        the minute
     * @param second
     *        the second
     * @param zone
     *        the {@link TimeZone}
     * @return the {@link DateTime}
     */
    public static DateTime getDateTime(final int year, final Month month, final int dayOfMonth, final int hour,
            final int minute, final int second, final TimeZone zone) {
        return new DateTime(new LocalDate(year, month, dayOfMonth), new LocalTime(hour, minute, second), zone);
    }

    /**
     * @return the year
     * @see com.nuhara.commons.datetime.LocalDate#getYear()
     */
    public final int getYear() {
        return localDate.getYear();
    }

    /**
     * @return the month
     * @see com.nuhara.commons.datetime.LocalDate#getMonth()
     */
    public final Month getMonth() {
        return localDate.getMonth();
    }

    /**
     * @return the day of month
     * @see com.nuhara.commons.datetime.LocalDate#getDayOfMonth()
     */
    public final int getDayOfMonth() {
        return localDate.getDayOfMonth();
    }

    /**
     * @return the hour
     * @see com.nuhara.commons.datetime.LocalTime#getHour()
     */
    public final int getHour() {
        return localTime.getHour();
    }

    /**
     * @return the minute
     * @see com.nuhara.commons.datetime.LocalTime#getMinute()
     */
    public final int getMinute() {
        return localTime.getMinute();
    }

    /**
     * @return the second
     * @see com.nuhara.commons.datetime.LocalTime#getSecond()
     */
    public final int getSecond() {
        return localTime.getSecond();
    }

    /**
     * @return the milliseconds
     * @see com.nuhara.commons.datetime.LocalTime#getMillis()
     */
    public final int getMillis() {
        return localTime.getMillis();
    }

    /**
     * @return a {@link GregorianCalendar}
     */
    public final GregorianCalendar toGregorianCalendar() {
        return (GregorianCalendar) getCalendar().clone();
    }

    /**
     * @return the {@link Date}
     */
    public final Date toJavaDate() {
        return getCalendar().getTime();
    }

    /**
     * @return or create the internal {@link GregorianCalendar}
     */
    private GregorianCalendar getCalendar() {
        if (cal == null) {
            cal = new GregorianCalendar(timeZone);
            cal.set(localDate.getYear(), localDate.getMonth().intValue(), localDate.getDayOfMonth(),
                    localTime.getHour(), localTime.getMinute(), localTime.getSecond());
            cal.set(MILLISECOND, localTime.getMillis());
            inDST = timeZone.inDaylightTime(cal.getTime());
        }
        return cal;
    }

    /**
     * @return the timeZone
     */
    public final TimeZone getTimeZone() {
        return timeZone;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#hashCode()
     */
    // SUPPRESS CHECKSTYLE DesignForExtension
    @Override
    public int hashCode() {
        return Hashcode.of(localDate, localTime, timeZone);
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
        final DateTime other = (DateTime) obj;
        return nullSafeEquals(this.localDate, other.localDate) && nullSafeEquals(this.localTime, other.localTime)
                && nullSafeEquals(this.timeZone, other.timeZone);
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#toString()
     */
    // SUPPRESS CHECKSTYLE DesignForExtension
    @Override
    public String toString() {
        getCalendar();
        return this.localDate.toString() + " " + this.localTime.toString() + " " + this.timeZone.getDisplayName(inDST, SHORT);
    }
}
