package com.wutsi.editorjs.readability

import com.wutsi.editorjs.dom.EJSDocument
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ReadabilityCalculatorTest {
    @Mock
    private lateinit var rule1: ReadabilityRule

    @Mock
    private lateinit var rule2: ReadabilityRule

    @Mock
    private lateinit var rule3: ReadabilityRule

    @Test
    fun evaluate() {
        val doc = EJSDocument()
        val ctx = ReadabilityContext()

        `when`(rule1.validate(doc, ctx)).thenReturn(createRuleResult(rule1, 100))
        `when`(rule2.validate(doc, ctx)).thenReturn(createRuleResult(rule2, 100))
        `when`(rule3.validate(doc, ctx)).thenReturn(createRuleResult(rule3, 50))
        val service = ReadabilityCalculator(arrayListOf(rule1, rule2, rule3))

        val result = service.compute(doc, ctx)

        assertEquals(83, result.score)
        assertEquals(3, result.ruleResults.size)
    }

    private fun createRuleResult(rule: ReadabilityRule, score: Int) = RuleResult(
            rule = rule,
            score = score
    )

}
