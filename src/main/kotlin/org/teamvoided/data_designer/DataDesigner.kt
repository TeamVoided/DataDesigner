package org.teamvoided.data_designer

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.data_designer.init.DDFakeBlocks

@Suppress("unused")
object DataDesigner {
    const val MODID = "data_designer"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(DataDesigner::class.simpleName)

    fun commonInit() {
        log.info("Hello from Common")
        DDFakeBlocks.init()
    }

    fun clientInit() {
        log.info("Hello from Client")
    }

    fun id(path: String) = Identifier(MODID, path)
}
