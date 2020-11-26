package com.wutsi.editorjs.html.tag.embed

import com.wutsi.editorjs.dom.Block
import com.wutsi.editorjs.dom.BlockData
import com.wutsi.editorjs.dom.BlockType
import com.wutsi.editorjs.html.tag.Tag
import org.apache.commons.lang3.StringEscapeUtils
import org.jsoup.nodes.Element
import java.io.StringWriter
import java.util.regex.Matcher
import java.util.regex.Pattern

class EmbedYouTube: Tag {
    override fun write(block: Block, writer: StringWriter) {
        if (block.data.service != "youtube"){
            return
        }

        val width = block.data.width
        val height = block.data.height
        val source = block.data.source
        val caption = StringEscapeUtils.escapeHtml4(block.data.caption)
        val id = extractId(source)
        writer.write(
                "<div class='youtube' data-id='$id' data-source='$source' data-width='$width' data-height='$height' data-caption='$caption'><div id='youtube-$id' class='player'></div></div>\n"
        )
    }

    override fun read(elt: Element): Block? {
        val clazz = elt.attr("class")
        val id = elt.attr("data-id")
        if (id.isEmpty() || clazz != "youtube"){
            return null
        }

        return Block(
                type = BlockType.embed,
                data = BlockData(
                        caption = elt.attr("data-caption"),
                        width = elt.attr("data-width"),
                        height = elt.attr("data-height"),
                        source = elt.attr("data-source"),
                        embed = "https://twitframe.com/show?url=" + elt.attr("data-source"),
                        service = "youtube"
                )
        )
    }

    private fun extractId(url: String): String {
        val pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*"

        val compiledPattern: Pattern = Pattern.compile(pattern)
        val matcher: Matcher = compiledPattern.matcher(url) //url is youtube url for which you want to extract the id.

        return if (matcher.find()) matcher.group() else ""
    }
}
