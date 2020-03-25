package com.wutsi.editorjs.dom

data class BlockData (
        var text: String = "",

        var level: Int = 1,

        var items: List<String> = emptyList(),
        var style: ListStyle = ListStyle.unordered,

        var file: File = File(),
        var caption: String = "",
        var withBorder: Boolean = false,
        var stretched: Boolean = false,
        var withBackground: Boolean = false,

        var code: String = "",

        var alignment: String = ""
)
