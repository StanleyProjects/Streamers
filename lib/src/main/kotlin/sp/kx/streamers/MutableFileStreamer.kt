package sp.kx.streamers

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

class MutableFileStreamer(private val delegate: File) : MutableStreamer {
    override fun writer(): OutputStream {
        return FileOutputStream(delegate)
    }

    override fun reader(): InputStream {
        return FileInputStream(delegate)
    }
}
