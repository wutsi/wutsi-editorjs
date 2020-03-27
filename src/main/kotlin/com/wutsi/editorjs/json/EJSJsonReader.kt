package com.wutsi.editorjs.json

import com.fasterxml.jackson.databind.ObjectMapper
import com.wutsi.editorjs.dom.EJSDocument

class EJSJsonReader(private val mapper: ObjectMapper) {
    fun read (json: String) = mapper.readValue(json, EJSDocument::class.java)
}
