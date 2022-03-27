package net.dain.nourriture.block;

import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;

public class CauldronWithBucketBlock extends AbstractCauldronBlock {

    private static final float FILL_WITH_RAIN_CHANCE = 0.05f;
    protected static final VoxelShape OUTLINE_SHAPE = VoxelShapes.union(
            VoxelShapes.combineAndSimplify(
                    VoxelShapes.union(
                            VoxelShapes.fullCube(),
                            CauldronWithBucketBlock.createCuboidShape(1.0, 16.0, 7.5, 15.0, 17.0, 8.5)
                    ),
                    VoxelShapes.union(
                            CauldronWithBucketBlock.createCuboidShape(0.0, 0.0, 4.0, 16.0, 3.0, 12.0),
                            CauldronWithBucketBlock.createCuboidShape(4.0, 0.0, 0.0, 12.0, 3.0, 16.0),
                            CauldronWithBucketBlock.createCuboidShape(2.0, 0.0, 2.0, 14.0, 3.0, 14.0),
                            AbstractCauldronBlock.createCuboidShape(2.0, 4.0, 2.0, 14.0, 16.0, 14.0)
                    ),
                    BooleanBiFunction.ONLY_FIRST
            ),
            CauldronWithBucketBlock.createCuboidShape(4.0, 8.0, 4.0, 12.0, 16.0, 12.0)
    );

    public CauldronWithBucketBlock(Settings settings) {
        super(settings, CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR);
    }

    @Override
    public boolean isFull(BlockState state) {
        return false;
    }

    protected static boolean canFillWithPrecipitation(World world, Biome.Precipitation precipitation) {
        if (precipitation == Biome.Precipitation.RAIN) {
            return world.getRandom().nextFloat() < FILL_WITH_RAIN_CHANCE;
        }
        return false;
    }

    @Override
    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {
        if (!CauldronWithBucketBlock.canFillWithPrecipitation(world, precipitation)) {
            return;
        }
        if (precipitation == Biome.Precipitation.RAIN) {
            world.setBlockState(pos, Blocks.WATER_CAULDRON.getDefaultState());
            world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
        }
    }

    @Override
    protected boolean canBeFilledByDripstone(Fluid fluid) {
        return true;
    }

    @Override
    protected void fillFromDripstone(BlockState state, World world, BlockPos pos, Fluid fluid) {
        if (fluid == Fluids.WATER) {
            world.setBlockState(pos, Blocks.WATER_CAULDRON.getDefaultState());
            world.syncWorldEvent(WorldEvents.POINTED_DRIPSTONE_DRIPS_WATER_INTO_CAULDRON, pos, 0);
            world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPE;
    }
}

