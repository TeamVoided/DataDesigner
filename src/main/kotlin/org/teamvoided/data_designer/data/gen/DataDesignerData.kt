package org.teamvoided.data_designer.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.registry.RegistrySetBuilder
import org.teamvoided.data_designer.DataDesigner.log
import org.teamvoided.data_designer.data.gen.providers.ModelProvider

@Suppress("unused")
class DataDesignerData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

        pack.addProvider(::ModelProvider)
//        pack.addProvider(::DataDesignerWorldGenerator)
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
//        gen.add(RegistryKeys.BIOME, DataDesignerBiomes::boostrap)
    }
}