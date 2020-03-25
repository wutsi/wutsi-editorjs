package com.wutsi.editorjs.html.tag

import com.wutsi.editorjs.dom.BlockType
import org.jsoup.nodes.Element

class TagProvider {
    private val tagsByType = mapOf(
            BlockType.code to Code(),
            BlockType.divider to Divider(),
            BlockType.header to Header(),
            BlockType.image to Image(),
            BlockType.list to List(),
            BlockType.paragraph to Paragraph(),
            BlockType.quote to Quote()
    )

    private val tagsByName = mapOf(
            "code" to Code(),
            "hr" to Divider(),
            "h1" to Header(),
            "h2" to Header(),
            "h3" to Header(),
            "h4" to Header(),
            "h5" to Header(),
            "h6" to Header(),
            "img" to Image(),
            "figure" to Image(),
            "ul" to List(),
            "ol" to List(),
            "p" to Paragraph(),
            "blockquote" to Quote()
    )

    fun all () = tagsByType.values

    fun get (type: BlockType): Tag? = tagsByType.get(type)

    fun get (elt: Element): Tag? = tagsByName.get(elt.tagName())
}
