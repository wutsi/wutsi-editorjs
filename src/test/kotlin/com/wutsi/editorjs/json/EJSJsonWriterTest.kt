package com.wutsi.editorjs.json

import com.wutsi.editorjs.ResourceHelper
import com.wutsi.editorjs.dom.Block
import com.wutsi.editorjs.dom.BlockData
import com.wutsi.editorjs.dom.BlockType
import com.wutsi.editorjs.dom.EJSDocument
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.StringWriter

class EJSJsonWriterTest {

    @Test
    fun write() {
        val doc = createDocument()
        val expected = ResourceHelper.loadResourceAsString("/writer.json")

        val sw = StringWriter()
        val writer = EJSJsonWriter()
        writer.write(doc, sw)

        System.out.println(sw.toString())

        assertEquals(expected.trim(), sw.toString().trim())
    }

    private fun createDocument() = EJSDocument(
            blocks = arrayListOf(
                    Block(
                            type = BlockType.header,
                            data = BlockData(
                                    level = 1,
                                    text = "Editor.js"
                            )
                    ),
                    Block(
                            type = BlockType.paragraph,
                            data = BlockData(
                                    text = "Hey. Meet the new Editor. On this page you can see it in action — try to edit this text"
                            )
                    ),
                    Block(
                            type = BlockType.list,
                            data = BlockData(
                                    items = arrayListOf(
                                            "It is a block-styled editor",
                                            "It returns clean data output in JSON",
                                            "Designed to be extendable and pluggable with a simple API"
                                    )
                            )
                    ),
                    Block(
                            type = BlockType.divider
                    ),
                    Block(
                            type = BlockType.image,
                            data = BlockData(
                                    url = "/upload/temporary/o_488cfb382712d6af914301c73f376e8c.jpg",
                                    caption = "Logo",
                                    withBackground = true,
                                    withBorder = true,
                                    stretched = true
                            )
                    ),
                    Block(
                            type = BlockType.code,
                            data = BlockData(
                                    code = "class Foo { }"
                            )
                    )
            )
    )
}
