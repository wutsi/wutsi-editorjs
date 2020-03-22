package com.wutsi.editorjs.html.tag

import com.wutsi.editorjs.dom.Block
import com.wutsi.editorjs.dom.BlockData
import com.wutsi.editorjs.dom.BlockType
import org.jsoup.nodes.Element
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.StringWriter

class ParagraphTest {

    val tag = Paragraph()

    @Test
    fun export() {
        val block = createBlock("Hello world")
        val writer = StringWriter()

        tag.write(block, writer)

        assertEquals("<p>Hello world</p>\n", writer.toString())
    }

    @Test
    fun read() {
        val elt = createElement("yo")
        val block = tag.read(elt)

        assertEquals(BlockType.paragraph, block.type)
        assertEquals("yo", block.data.text)
    }

    private fun createBlock(text: String) = Block(
            type = BlockType.paragraph,
            data = BlockData(
                    text=text
            )
    )

    private fun createElement(code: String): Element {
        val elt = Element("p")
        elt.text(code)
        return elt
    }
}
