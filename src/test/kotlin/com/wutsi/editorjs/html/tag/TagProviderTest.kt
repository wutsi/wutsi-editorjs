package com.wutsi.editorjs.html.tag

import com.wutsi.editorjs.dom.BlockType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TagProviderTest {
    private val provider = TagProvider()

    @Test
    fun all() {
        val tags = provider.all()
        assertEquals(8, tags.size)
    }

    @Test
    fun get() {
        assertTrue(provider.get(BlockType.code) is Code)
        assertTrue(provider.get(BlockType.delimiter) is Delimiter)
        assertTrue(provider.get(BlockType.header) is Header)
        assertTrue(provider.get(BlockType.image) is Image)
        assertTrue(provider.get(BlockType.list) is List)
        assertTrue(provider.get(BlockType.paragraph) is Paragraph)
        assertTrue(provider.get(BlockType.quote) is Quote)
        assertTrue(provider.get(BlockType.linkTool) is Link)
    }
}
