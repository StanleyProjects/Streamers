package sp.kx.streamers

import java.io.InputStream

interface Streamer {
    fun reader(): InputStream
}
