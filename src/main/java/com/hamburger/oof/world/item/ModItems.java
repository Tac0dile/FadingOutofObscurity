package com.hamburger.oof.world.item;

import com.hamburger.oof.Oof;
import com.hamburger.oof.world.item.anomalous_items.CupOfJoe;
import com.hamburger.oof.world.item.anomalous_items.DiamondBrick;
import com.hamburger.oof.world.item.anomalous_items.EvilWaterBotllef;
import com.hamburger.oof.world.item.utilities.VoidResonator;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
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
    public static final DeferredItem<Item> CUP_OF_JOE = ITEMS.register(
            "cup_of_joe",
            resourceLocation -> new CupOfJoe(
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, resourceLocation))
                            .stacksTo(1))
    );

    public static final DeferredItem<Item> EVIL_WATER_BOTLLEF = ITEMS.registerItem(
            "evil_water_botllef",
            EvilWaterBotllef::new,
            new Item.Properties().stacksTo(1)
    );

    public static final DeferredItem<Item> DIAMOND_BRICK = ITEMS.registerItem(
            "diamond_brick",
            DiamondBrick::new,
            new Item.Properties().stacksTo(64)
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
