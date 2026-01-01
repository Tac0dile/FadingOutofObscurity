package com.hamburger.oof.mixin;

import com.hamburger.oof.data.ModAttachments;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Slot.class)
public abstract class SlotMixin {

    @Shadow
    public abstract ItemStack getItem();

    /**
     * @author AresTheBnnuy
     * @reason OwO notices ur bulge there
     */
    @Overwrite
    public boolean mayPickup(Player player) {
        ItemStack itemStack = this.getItem();
        return true;
    }
}
