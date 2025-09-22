package sp.kx.streamers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class FileStreamerTest {
    @Test
    fun readerTest() {
        val delegate = File.createTempFile("foo", "bar")
        check(delegate.exists())
        check(delegate.isFile)
        check(delegate.length() == 0L)
        val expected = "foobarbaz"
        delegate.writeText(expected)
        check(delegate.length() > 0L)
        val streamer: Streamer = FileStreamer(delegate = delegate)
        val actual = String(streamer.reader().readBytes())
        assertEquals(expected, actual)
    }
}
