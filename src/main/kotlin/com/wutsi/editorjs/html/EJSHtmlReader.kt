package com.wutsi.editorjs.html

import com.wutsi.editorjs.dom.EJSDocument
import com.wutsi.editorjs.html.tag.TagProvider
import org.jsoup.Jsoup

class EJSHtmlReader(private val provider: TagProvider = TagProvider()) {
    fun read (html: String): EJSDocument {
        val html = Jsoup.parse(html)
        val ejs = EJSDocument()

        html.body().children().forEach {
            val tag = provider.get(it)
            if (tag != null) {
                val block = tag.read(it)
                ejs.blocks.add(block)
            }
        }
        return ejs
    }
}
