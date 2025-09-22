package sp.kx.streamers

import java.io.OutputStream

interface MutableStreamer : Streamer {
    fun writer(): OutputStream
}
