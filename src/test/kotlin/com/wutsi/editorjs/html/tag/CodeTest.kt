package com.wutsi.editorjs.html.tag

import com.wutsi.editorjs.dom.Block
import com.wutsi.editorjs.dom.BlockData
import com.wutsi.editorjs.dom.BlockType
import org.jsoup.nodes.Element
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.StringWriter

class CodeTest {

    val tag = Code()

    @Test
    fun write() {
        val block = createBlock("Hello world")
        val writer = StringWriter()

        tag.write(block, writer)

        assertEquals("<code>Hello world</code>\n", writer.toString())
    }

    @Test
    fun read() {
        val elt = createElement("yo")
        val block = tag.read(elt)

        assertEquals(BlockType.code, block.type)
        assertEquals("yo", block.data.code)
    }

    private fun createBlock(code: String) = Block(
            type = BlockType.code,
            data = BlockData(
                    code=code
            )
    )

    private fun createElement(code: String): Element {
        val elt = Element("code")
        elt.text(code)
        return elt
    }
}
