package com.waracle.mytestapplication

import java.io.InputStreamReader

class MockeResponseFileReader (path: String) {
    val content: String
    init {
        val reader = InputStreamReader(this.javaClass.classLoader!!.getResourceAsStream(path))
        content = reader.readText()
        reader.close()
    }
}