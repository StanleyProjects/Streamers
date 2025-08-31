package sp.kx.streamers

import java.io.File
import java.io.FileInputStream
import java.io.InputStream

class FileStreamer(private val delegate: File) : Streamer {
    override fun reader(): InputStream {
        return FileInputStream(delegate)
    }
}
