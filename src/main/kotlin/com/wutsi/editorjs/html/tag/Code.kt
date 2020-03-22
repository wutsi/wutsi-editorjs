package com.wutsi.editorjs.html.tag

import com.wutsi.editorjs.dom.Block
import com.wutsi.editorjs.dom.BlockData
import com.wutsi.editorjs.dom.BlockType
import org.jsoup.nodes.Element
import java.io.StringWriter

class Code: Tag {
    override fun write (block: Block, writer: StringWriter) {
        val code = block.data.code
        writer.write("<code>$code</code>\n")
    }

    override fun read(elt: Element) = Block(
            type = BlockType.code,
            data = BlockData(
                    code = elt.text()
            )
    )

}
