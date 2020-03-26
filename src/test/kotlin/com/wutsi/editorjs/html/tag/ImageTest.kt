package com.wutsi.editorjs.html.tag

import com.wutsi.editorjs.dom.Block
import com.wutsi.editorjs.dom.BlockData
import com.wutsi.editorjs.dom.BlockType
import org.jsoup.nodes.Element
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.StringWriter

class ImageTest {

    val tag = Image()

    @Test
    fun writeUrl() {
        val block = createBlock("http://www.img.com/1.png")
        val writer = StringWriter()

        tag.write(block, writer)

        assertEquals("<figure><img src='http://www.img.com/1.png' /></figure>\n", writer.toString())
    }

    @Test
    fun writeWithCaption() {
        val block = createBlock(url="http://www.img.com/1.png", caption="foo")
        val writer = StringWriter()

        tag.write(block, writer)

        assertEquals("<figure><img src='http://www.img.com/1.png' alt='foo' /><figcaption>foo</figcaption></figure>\n", writer.toString())
    }

    @Test
    fun writeWithBorder() {
        val block = createBlock(url="http://www.img.com/1.png", border = true)
        val writer = StringWriter()

        tag.write(block, writer)

        assertEquals("<figure><img src='http://www.img.com/1.png' class='border' /></figure>\n", writer.toString())
    }

    @Test
    fun writeWithBackground() {
        val block = createBlock(url="http://www.img.com/1.png", background = true)
        val writer = StringWriter()

        tag.write(block, writer)

        assertEquals("<figure><img src='http://www.img.com/1.png' class='background' /></figure>\n", writer.toString())
    }

    @Test
    fun writeStretched() {
        val block = createBlock(url="http://www.img.com/1.png", stretched = true)
        val writer = StringWriter()

        tag.write(block, writer)

        assertEquals("<figure><img src='http://www.img.com/1.png' class='stretched' /></figure>\n", writer.toString())
    }

    @Test
    fun writeAll() {
        val block = createBlock(url="http://www.img.com/1.png", caption = "foo", stretched = true, background = true, border = true)
        val writer = StringWriter()

        tag.write(block, writer)

        assertEquals("<figure><img src='http://www.img.com/1.png' alt='foo' class='stretched border background' /><figcaption>foo</figcaption></figure>\n", writer.toString())
    }

    @Test
    fun readIMG() {
        val elt = createIMGElement("http://www.google.com/1.png", "test")
        val block = tag.read(elt)

        assertEquals(BlockType.image, block.type)
        assertEquals("http://www.google.com/1.png", block.data.url)
        assertEquals("test", block.data.caption)
        assertTrue(block.data.withBackground)
        assertTrue(block.data.withBackground)
        assertTrue(block.data.stretched)
    }

    @Test
    fun readFigure() {
        val elt = createFigureElement("http://www.google.com/1.png", "test")
        val block = tag.read(elt)

        assertEquals(BlockType.image, block.type)
        assertEquals("http://www.google.com/1.png", block.data.url)
        assertEquals("test", block.data.caption)
        assertTrue(block.data.withBackground)
        assertTrue(block.data.withBackground)
        assertTrue(block.data.stretched)
    }

    private fun createBlock(
            url: String,
            caption: String="",
            stretched: Boolean=false,
            background: Boolean=false,
            border: Boolean=false
    ) = Block(
            type = BlockType.image,
            data = BlockData(
                    url=url,
                    caption = caption,
                    stretched = stretched,
                    withBorder = border,
                    withBackground = background
            )
    )


    private fun createIMGElement(url: String, alt: String): Element {
        val elt = Element("img")
        elt.attr("src", url)
        elt.attr("alt", alt)
        elt.addClass("stretched")
        elt.addClass("background")
        elt.addClass("border")
        return elt
    }

    private fun createFigureElement(url: String, alt: String): Element {
        val elt = Element("figure")

        val caption = Element("figcaption")
        caption.text(alt)

        elt.appendChild(createIMGElement(url, alt))
        elt.appendChild(caption)
        return elt
    }

}
