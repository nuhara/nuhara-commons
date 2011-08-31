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

import java.io.Serializable;
import java.util.Formatter;

/**
 * An 'abstract' time of day (in 24-hour format), with no date or time zone information. Provides up to millisecond
 * resolution.
 *
 * @author Alistair A. Israel
 * @since 0.1
 */
public class LocalTime implements Serializable, Comparable<LocalTime> {

    /**
     * Computed serial version UID
     */
    private static final long serialVersionUID = 4057426100116054081L;

    private final int hour;

    private final int minute;

    private final Integer second;

    private final Integer millis;

    /**
     * @param hour
     *        the hour of day, which can be from 0 (midnight past) to 24 (next midnight)
     * @param minute
     *        the minute
     */
    public LocalTime(final int hour, final int minute) {
        if (hour < 0 || hour > 24) {
            throw new IllegalArgumentException("Invalid hour: " + hour);
        }
        if (hour == 24 && minute != 0) {
            throw new IllegalArgumentException("Can only represent up to 24:00!");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Invalid minute: " + minute);
        }
        this.hour = hour;
        this.minute = minute;
        this.second = null;
        this.millis = null;
    }

    /**
     * @param hour
     *        the hour of day
     * @param minute
     *        the minute
     * @param second
     *        the second
     */
    public LocalTime(final int hour, final int minute, final int second) {
        if (hour < 0 || hour > 24) {
            throw new IllegalArgumentException("Invalid hour: " + hour);
        }
        if (hour == 24 && !(minute == 0 && second == 0)) {
            throw new IllegalArgumentException("Can only represent up to 24:00:00!");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Invalid minute: " + minute);
        }
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("Invalid second: " + second);
        }
        this.hour = hour;
        this.minute = minute;
        this.second = Integer.valueOf(second);
        this.millis = null;
    }

    /**
     * @param hour
     *        the hour of day
     * @param minute
     *        the minute
     * @param second
     *        the second
     * @param millis
     *        the milliseconds
     */
    // SUPPRESS CHECKSTYLE CyclomaticComplexity
    public LocalTime(final int hour, final int minute, final int second, final int millis) {
        if (hour < 0 || hour > 24) {
            throw new IllegalArgumentException("Invalid hour: " + hour);
        }
        if (hour == 24 && !(minute == 0 && second == 0 && millis == 0)) {
            throw new IllegalArgumentException("Can only represent up to 24:00:00.000!");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Invalid minute: " + minute);
        }
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("Invalid second: " + second);
        }
        if (millis < 0 || millis >= 1000) {
            throw new IllegalArgumentException("Invalid millisecond: " + millis);
        }
        this.hour = hour;
        this.minute = minute;
        this.second = Integer.valueOf(second);
        this.millis = Integer.valueOf(millis);
    }

    /**
     * @return the hour
     */
    public final int getHour() {
        return hour;
    }

    /**
     * @return the minute
     */
    public final int getMinute() {
        return minute;
    }

    /**
     * @return the second
     */
    public final int getSecond() {
        if (second != null) {
            return second.intValue();
        }
        return 0;
    }

    /**
     * @return the millis
     */
    public final int getMillis() {
        if (millis != null) {
            return millis.intValue();
        }
        return 0;
    }

    /**
     * @return the number of milliseconds past midnight this time object represents
     */
    public final int toMillisPastMidnight() {
        int ms = ((hour * 60) + minute) * 60;
        if (second != null) {
            ms += second.intValue();
        }
        ms *= 1000;
        if (millis != null) {
            ms += millis.intValue();
        }
        return ms;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#hashCode()
     */
    // SUPPRESS CHECKSTYLE DesignForExtension
    @Override
    public int hashCode() {
        return toMillisPastMidnight();
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
        final LocalTime other = (LocalTime) obj;
        if (this.hour != other.hour || this.minute != other.minute) {
            return false;
        }
        return this.hour == other.hour && this.minute == other.minute && this.getSecond() == other.getSecond()
                && this.getMillis() == other.getMillis();
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    // SUPPRESS CHECKSTYLE DesignForExtension
    @Override
    public int compareTo(final LocalTime other) {
        final int ms = toMillisPastMidnight();
        final int otherMs = other.toMillisPastMidnight();
        if (ms == otherMs) {
            return 0;
        } else if (ms < otherMs) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#toString()
     */
    // SUPPRESS CHECKSTYLE DesignForExtension
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final Formatter f = new Formatter(sb);
        f.format("%02d:%02d", hour, minute);
        if (second != null) {
            f.format(":%02d", second.intValue());
            if (millis != null) {
                f.format(".%03d", millis.intValue());
            }
        }
        return sb.toString();
    }

}
