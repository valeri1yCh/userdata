package org.bloodwyn.userdata.data

import java.io.BufferedInputStream
import java.lang.NullPointerException
import java.lang.StringBuilder

fun readFile(filename: String, inputStreamHolder: Class<*>): String {
    val stream = inputStreamHolder.getResourceAsStream(filename)
    val sb = StringBuilder()
    var byte: Int
    if(stream != null) {
        BufferedInputStream(stream).use {
            while (true) {
                byte = it.read()
                if(byte >= 0) {
                    sb.append(byte.toChar())
                } else {
                    break
                }
            }
        }
    } else {
        throw NullPointerException(
            "Impossible create stream from the file, stream == null. Pls check is the file exist " +
                    "in the same folder that inputStreamHolder is")
    }

    return sb.toString()
}