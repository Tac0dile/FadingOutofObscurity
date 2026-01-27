package com.hamburger.oof.world.level.block;

import com.hamburger.oof.Oof;
import com.hamburger.oof.world.item.ModItems;
import com.hamburger.oof.world.level.block.state.properties.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class StoneTablet extends Block {
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty MOTHERBOARD = ModBlockStateProperties.MOTHERBOARD;
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 8, 16);

    public StoneTablet(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(MOTHERBOARD, false));
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        boolean isOccupied = state.getValue(MOTHERBOARD);
        if (!level.isClientSide) {
            if (stack.is(ModBlocks.BIOLOGICAL_MOTHERBOARD.asItem())) {
                if (!state.getValue(MOTHERBOARD)) {
                    level.setBlock(pos, state.setValue(MOTHERBOARD, isOccupied = true), 3);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
                    stack.consume(1, player);
                    return InteractionResult.SUCCESS;
                }
            }
            else {
                if(state.getValue(MOTHERBOARD)) {
                    level.setBlock(pos, state.setValue(MOTHERBOARD, isOccupied = false), 3);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
                    player.getInventory().add(ModBlocks.BIOLOGICAL_MOTHERBOARD.toStack());
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, MOTHERBOARD);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip." + Oof.MODID + ".stone_tablet"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
