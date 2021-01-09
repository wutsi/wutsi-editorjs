package com.wutsi.editorjs.html.tag

import com.wutsi.editorjs.dom.Block
import com.wutsi.editorjs.dom.BlockData
import com.wutsi.editorjs.dom.BlockType
import com.wutsi.editorjs.dom.BlockType.code
import org.apache.commons.text.StringEscapeUtils
import org.jsoup.nodes.Element
import java.io.StringWriter

class AnyButton: Tag {
    override fun write (block: Block, writer: StringWriter) {
        val link = block.data.link
        val text = StringEscapeUtils.escapeHtml4(block.data.text)
        writer.write("<div class='button'><a href='$link'>$text</a></div>\n")
    }

    override fun read(elt: Element): Block? = null

}
