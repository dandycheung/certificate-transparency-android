/*
 * Copyright 2018 Babylon Healthcare Services Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.certificatetransparency.ctlog.data.loglist

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class InMemoryDataSourceTest {

    @Test
    fun emptyDataSourceReturnsNull() = runBlocking {
        // given a new data source
        val dataSource = InMemoryDataSource<String>()

        // when we get the current value
        val result = dataSource.get()

        // then it returns null
        assertNull(result)
    }

    @Test
    fun dataSourceReturnsSetValue() = runBlocking {
        // given a new data source populated with a value
        val dataSource = InMemoryDataSource<String>()
        dataSource.set("1")

        // when we get the current value
        val result = dataSource.get()

        // then it returns the value
        assertEquals("1", result)
    }

    @Test
    fun dataSourceReturnsLatestSetValue() = runBlocking {
        // given a new data source populated with a value
        val dataSource = InMemoryDataSource<String>()
        dataSource.set("1")

        // when we set a second value
        dataSource.set("2")

        // then the second value is returned when retrieved
        assertEquals("2", dataSource.get())
    }
}
