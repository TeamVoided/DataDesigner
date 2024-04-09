package org.teamvoided.data_designer.data.gen.providers

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import org.teamvoided.data_designer.init.DDFakeBlocks

class ModelProvider(o: FabricDataOutput) : FabricModelProvider(o) {
    override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
        //Generating a basic block
        gen.registerSimpleCubeAll(DDFakeBlocks.FULL_BLOCK)
    }

    override fun generateItemModels(gen: ItemModelGenerator) {}
}