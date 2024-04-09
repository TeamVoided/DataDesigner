package org.teamvoided.data_designer.init

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.data_designer.DataDesigner.id

object DDFakeBlocks {

    val FULL_BLOCK = register("full_block", Block(FabricBlockSettings.create()))
    fun init() {}
    fun register(id: String, block: Block): Block = Registry.register(Registries.BLOCK, id(id), block)
}