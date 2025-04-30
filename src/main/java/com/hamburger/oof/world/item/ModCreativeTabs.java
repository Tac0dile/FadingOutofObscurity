package com.hamburger.oof.world.item;

import com.hamburger.oof.Oof;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Oof.MODID);

    public static final Supplier<CreativeModeTab> ANOMALOUS_ITEMS = CREATIVE_TAB.register("anomalous_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Oof.MODID + ".anomalous_items"))
            .icon(() -> new ItemStack(ModItems.CUP_OF_JOE.get()))
            .displayItems((params, output) -> {
                output.accept(ModItems.CUP_OF_JOE);
            })
            .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_TAB.register(eventBus);
    }
}
