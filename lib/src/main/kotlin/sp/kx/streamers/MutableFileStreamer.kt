package sp.kx.streamers

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

class MutableFileStreamer(
    private val src: File,
    private val dst: File = src,
) : MutableStreamer {
    override fun writer(): OutputStream {
        return FileOutputStream(dst)
    }

    override fun reader(): InputStream {
        return FileInputStream(src)
    }
}
