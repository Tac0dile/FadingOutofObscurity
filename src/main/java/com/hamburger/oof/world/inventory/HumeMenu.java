package com.hamburger.oof.world.inventory;

import com.hamburger.oof.world.level.block.ModBlocks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class HumeMenu extends AbstractCraftingMenu {
    private final ContainerLevelAccess access;

    public HumeMenu(int containerId, ContainerLevelAccess access) {
        super(MenuType.CRAFTING, containerId, 3, 3);
        this.access = access;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, ModBlocks.HUME_INFUSER.get());
    }

    @Override
    public Slot getResultSlot() {
        return null;
    }

    @Override
    public List<Slot> getInputGridSlots() {
        return List.of();
    }

    @Override
    protected Player owner() {
        return null;
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return null;
    }
}
