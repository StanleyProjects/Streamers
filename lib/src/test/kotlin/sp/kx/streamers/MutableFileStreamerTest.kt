package sp.kx.streamers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class MutableFileStreamerTest {
    @Test
    fun readerTest() {
        val src = File.createTempFile("foo", "bar")
        check(src.exists())
        check(src.isFile)
        check(src.length() == 0L)
        val streamer: Streamer = MutableFileStreamer(src = src)
        assertEquals(0, streamer.reader().readBytes().size)
        val expected = "foobarbaz"
        src.writeText(expected)
        check(src.length() > 0L)
        val actual = String(streamer.reader().readBytes())
        assertEquals(expected, actual)
    }

    @Test
    fun writerTest() {
        val src = File.createTempFile("foo", "bar")
        check(src.exists())
        check(src.isFile)
        check(src.length() == 0L)
        val dst = File.createTempFile("foo", "bar")
        check(dst.exists())
        check(dst.isFile)
        check(dst.length() == 0L)
        val streamer: MutableStreamer = MutableFileStreamer(src = src, dst = dst)
        assertEquals(0, streamer.reader().readBytes().size)
        src.writeText("foobarsrc")
        check(src.length() > 0L)
        assertEquals("foobarsrc", String(streamer.reader().readBytes()))
        streamer.writer().write("foobardst".toByteArray())
        assertEquals("foobarsrc", String(streamer.reader().readBytes()))
        assertEquals("foobarsrc", src.readText())
        assertEquals("foobardst", dst.readText())
    }
}
