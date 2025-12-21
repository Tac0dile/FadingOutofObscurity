package com.hamburger.oof.common.event;

import com.hamburger.oof.data.component.JoeRecord;
import com.hamburger.oof.data.component.ModComponents;
import com.hamburger.oof.world.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;

public class ModItemEvents {

    public static void onItemPickup(ItemEntityPickupEvent.Post event) {
        ItemStack itemStack = event.getOriginalStack();
        Player player = event.getPlayer();


        if (itemStack.is(ModItems.CUP_OF_JOE)) {
            player.getCooldowns().addCooldown(itemStack, 20);
            itemStack.set(ModComponents.JOE_ACTIVE_COMPONENT, new JoeRecord(true));
        }
    }


}
