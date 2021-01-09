package com.wutsi.editorjs.html.tag

import com.wutsi.editorjs.dom.Block
import com.wutsi.editorjs.dom.BlockData
import com.wutsi.editorjs.dom.BlockType
import com.wutsi.editorjs.dom.BlockType.AnyButton
import com.wutsi.editorjs.dom.BlockType.code
import com.wutsi.editorjs.dom.BlockType.raw
import org.jsoup.nodes.Element
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import java.io.StringWriter

class AnyButtonTest{
    val tag = AnyButton()

    @Test
    fun writeCode() {
        val block = createBlock("http://www.google.ca", "Hello world")
        val writer = StringWriter()

        tag.write(block, writer)

        assertEquals("<div class='button'><a href='http://www.google.ca'>Hello world</a></div>\n", writer.toString())
    }

    @Test
    fun readHTML() {
        val elt = mock(Element::class.java)
        val block = tag.read(elt)

        assertNull(block)
    }

    private fun createBlock(link: String, text: String) = Block(
        type = AnyButton,
        data = BlockData(
            link = link,
            text = text
        )
    )
}
