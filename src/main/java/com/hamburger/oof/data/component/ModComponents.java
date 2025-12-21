package com.hamburger.oof.data.component;

import com.hamburger.oof.Oof;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModComponents {
    public static final Codec<JoeRecord> JOE_CODEC = RecordCodecBuilder.create(joeRecordInstance ->
            joeRecordInstance.group(
                    Codec.BOOL.fieldOf("isActive").forGetter(JoeRecord::isActive)
            ).apply(joeRecordInstance, JoeRecord::new)
    );

    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Oof.MODID);

    public static final Supplier<DataComponentType<JoeRecord>> JOE_ACTIVE_COMPONENT = COMPONENTS.registerComponentType(
            "joe_active_component",
            joeRecordBuilder -> joeRecordBuilder
                    .persistent(JOE_CODEC)
    );

    public static void register(IEventBus eventBus) {
        COMPONENTS.register(eventBus);
    }
}
