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
package com.nuhara.commons.datetime;

import java.util.TimeZone;

/**
 * @author Alistair A. Israel
 * @since 0.1
 */
public final class DateUtils {

    /**
     * {@code TimeZone.getTimeZone("UTC")}
     */
    public static final TimeZone UTC = TimeZone.getTimeZone("UTC");

    /**
     * Utility classes should not have a public or default constructor.
     */
    private DateUtils() {
        // noop
    }

}
