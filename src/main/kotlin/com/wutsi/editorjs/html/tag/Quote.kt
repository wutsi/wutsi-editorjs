package com.wutsi.editorjs.html.tag

import com.wutsi.editorjs.dom.Block
import com.wutsi.editorjs.dom.BlockData
import com.wutsi.editorjs.dom.BlockType
import org.jsoup.nodes.Element
import java.io.StringWriter

class Quote: Tag {
    override fun write (block: Block, writer: StringWriter) {
        val text = block.data.text
        val caption = block.data.caption
        writer.write("<blockquote><p>$text</p><footer>$caption</footer></blockquote>\n")
    }

    override fun read(elt: Element): Block {
        val p = elt.children().filter { it.tagName().toLowerCase() == "p" }
        val footer = elt.children().filter { it.tagName().toLowerCase() == "footer" }
        return Block(
                type = BlockType.quote,
                data = BlockData(
                        text = if (p.isEmpty()) "" else p[0].text(),
                        caption = if (footer.isEmpty()) "" else footer[0].text()
                )
        )
    }

}
