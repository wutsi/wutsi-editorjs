package com.wutsi.editorjs.readability.rule

import com.wutsi.editorjs.dom.EJSDocument
import com.wutsi.editorjs.readability.ReadabilityContext
import com.wutsi.editorjs.readability.RuleResult

class BulletRule: AbstractRule() {
    override fun validate(doc: EJSDocument, context: ReadabilityContext): RuleResult {
        val doc = super.toHtml(doc, context)
        val headers = collect(doc, arrayListOf("li"))
        return result(headers.isNotEmpty())
    }
}
