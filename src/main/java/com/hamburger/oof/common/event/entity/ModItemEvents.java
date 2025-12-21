package com.hamburger.oof.common.event.entity;

import com.hamburger.oof.world.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;


public class ModItemEvents {

    public static void onItemPickup(ItemEntityPickupEvent.Post event) {
        ItemStack itemStack = event.getOriginalStack();

        if(itemStack.is(ModItems.CUP_OF_JOE)) {
            System.out.println("Faggot");
        }
    }

}