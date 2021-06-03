package com.se7en.fearngreed

import com.se7en.fearngreed.ui.index.meter.convert
import org.junit.Test

class IndexMeterUtilsTest {

    @Test
    fun `converting lowest number from first range returns lowest number from second range`() {
        val result = (0f..100f).convert(0f, 200f..500f)
        assert(result == 200f)
    }

    @Test
    fun `converting mid number from first range returns mid number within second range`() {
        val result = (0f..100f).convert(50f, 200f..500f)
        assert(result == 350f)
    }

    @Test
    fun `converting highest number from first range returns highest number from second range`() {
        val result = (0f..100f).convert(100f, 200f..500f)
        assert(result == 500f)
    }
}
