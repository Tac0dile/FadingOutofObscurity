package com.hamburger.oof.world.item;

import com.hamburger.oof.Oof;
import com.hamburger.oof.world.item.anomalous_items.CupOfJoe;
import com.hamburger.oof.world.item.utilities.VoidResonator;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Oof.MODID);

    public static final DeferredItem<Item> VOID_RESONATOR = ITEMS.registerItem(
            "void_resonator",
            VoidResonator::new,
            new Item.Properties().stacksTo(1)
    );

    //Items
    public static final DeferredItem<Item> CUP_OF_JOE = ITEMS.registerItem(
            "cup_of_joe",
            CupOfJoe::new,
            new Item.Properties().stacksTo(1)
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
