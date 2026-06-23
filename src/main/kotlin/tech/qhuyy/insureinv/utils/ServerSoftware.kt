package tech.qhuyy.insureinv.utils

import com.tcoded.folialib.FoliaLib

enum class ServerSoftware {
    PAPER, FOLIA, SPIGOT, UNKNOWN;

    companion object {
        fun detectServerSoftware(foliaLib: FoliaLib): ServerSoftware = when {
            foliaLib.isFolia -> FOLIA
            foliaLib.isPaper -> PAPER
            foliaLib.isSpigot -> SPIGOT
            else -> UNKNOWN
        }
    }
}