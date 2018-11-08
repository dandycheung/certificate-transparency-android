package org.certificatetransparency.ctlog.internal.utils

import java.io.PrintWriter
import java.io.StringWriter

fun Exception.stringStackTrace() = StringWriter().use {
    PrintWriter(it).use {
        printStackTrace(it)
    }
    it.toString()
}