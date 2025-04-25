package com.hamburger.oof.world.item;

import com.hamburger.oof.Oof;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Oof.MODID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
