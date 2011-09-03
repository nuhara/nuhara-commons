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
 * Created Sep 3, 2011
 */
package com.nuhara.commons.lang;

import java.util.Iterator;

/**
 * A read-only iterator that throws {@link UnsupportedOperationException} on {@link #remove()}.
 *
 * @param <T>
 *        a type
 * @author Alistair A. Israel
 */
public abstract class ReadOnlyIterator<T> implements Iterator<T> {

    /**
     * Will throw {@link UnsupportedOperationException}.
     *
     * @see java.util.Iterator#remove()
     */
    @Override
    public final void remove() {
        throw new UnsupportedOperationException("remove() not allowed for " + getClass().getName()
                + " [ReadOnlyIterator]!");
    }

}
