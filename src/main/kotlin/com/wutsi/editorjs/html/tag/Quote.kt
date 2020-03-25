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
        val p = elt.children().first { it.tagName().toLowerCase() == "p" }
        val footer = elt.children().first { it.tagName().toLowerCase() == "footer" }
        return Block(
                type = BlockType.quote,
                data = BlockData(
                        text = if (p == null) "" else p.text(),
                        caption = if (footer == null) "" else footer.text()
                )
        )
    }

}
