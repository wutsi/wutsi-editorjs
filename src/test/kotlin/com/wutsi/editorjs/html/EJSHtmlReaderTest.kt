package com.wutsi.editorjs.html

import com.wutsi.editorjs.ResourceHelper.loadResourceAsString
import com.wutsi.editorjs.dom.BlockType
import com.wutsi.editorjs.dom.ListStyle
import com.wutsi.editorjs.html.tag.TagProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class EJSHtmlReaderTest {
    @Test
    fun read() {
        val html = loadResourceAsString("/reader.html")
        val reader = EJSHtmlReader(TagProvider())
        val doc = reader.read(html)

        assertEquals(6, doc.blocks.size)

        assertEquals(BlockType.header, doc.blocks[0].type)
        assertEquals(1, doc.blocks[0].data.level)
        assertEquals("Editor.js", doc.blocks[0].data.text)

        assertEquals(BlockType.paragraph, doc.blocks[1].type)
        assertEquals("Hey. Meet the new Editor. On this page you can see it in action — try to edit this text", doc.blocks[1].data.text)

        assertEquals(BlockType.list, doc.blocks[2].type)
        assertEquals(ListStyle.unordered, doc.blocks[2].data.style)
        assertEquals(3, doc.blocks[2].data.items.size)
        assertEquals("It is a block-styled editor", doc.blocks[2].data.items[0])
        assertEquals("It returns clean data output in JSON", doc.blocks[2].data.items[1])
        assertEquals("Designed to be extendable and pluggable with a simple API", doc.blocks[2].data.items[2])

        assertEquals(BlockType.delimiter, doc.blocks[3].type)

        assertEquals(BlockType.image, doc.blocks[4].type)
        assertEquals("/upload/temporary/o_488cfb382712d6af914301c73f376e8c.jpg", doc.blocks[4].data.file.url)
        assertEquals(-1, doc.blocks[4].data.file.width)
        assertEquals(-1, doc.blocks[4].data.file.height)
        assertEquals("Logo", doc.blocks[4].data.caption)
        assertTrue(doc.blocks[4].data.withBackground)
        assertTrue(doc.blocks[4].data.withBorder)
        assertTrue(doc.blocks[4].data.stretched)


        assertEquals(BlockType.code, doc.blocks[5].type)
        assertEquals("class Foo { }", doc.blocks[5].data.code)

    }
}
