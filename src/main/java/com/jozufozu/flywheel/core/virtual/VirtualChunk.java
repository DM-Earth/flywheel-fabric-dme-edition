package com.jozufozu.flywheel.core.virtual;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.longs.LongSets;
import it.unimi.dsi.fastutil.shorts.ShortList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.UpgradeData;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.ticks.BlackholeTickAccess;
import net.minecraft.world.ticks.TickContainerAccess;

public class VirtualChunk extends ChunkAccess {
	public final VirtualRenderWorld world;

	private final VirtualChunkSection[] sections;

	private boolean needsLight;

	public VirtualChunk(VirtualRenderWorld world, int x, int z) {
		super(new ChunkPos(x, z), UpgradeData.EMPTY, world, world.registryAccess()
			.registryOrThrow(Registries.BIOME), 0L, null, null);

		this.world = world;

		int sectionCount = world.getSectionsCount();
		this.sections = new VirtualChunkSection[sectionCount];

		for (int i = 0; i < sectionCount; i++) {
			sections[i] = new VirtualChunkSection(this, i << 4);
		}
	}

	@Override
	public LevelChunkSection[] getSections() {
		return sections;
	}

	@Override
	public ChunkStatus getStatus() {
		return ChunkStatus.LIGHT;
	}

	@Nullable
	@Override
	public BlockState setBlockState(BlockPos p_177436_1_, BlockState p_177436_2_, boolean p_177436_3_) {
		return null;
	}

	@Override
	public void setBlockEntity(BlockEntity entity) {}

	@Override
	public void addEntity(Entity entity) {}

	@Override
	public Set<BlockPos> getBlockEntitiesPos() {
		return null;
	}

	@Override
	public Collection<Map.Entry<Heightmap.Types, Heightmap>> getHeightmaps() {
		return null;
	}

	@Override
	public void setHeightmap(Heightmap.Types types, long[] p_201607_2_) {}

	@Override
	public Heightmap getOrCreateHeightmapUnprimed(Heightmap.Types types) {
		return null;
	}

	@Override
	public int getHeight(Heightmap.Types p_201576_1_, int p_201576_2_, int p_201576_3_) {
		return 0;
	}

	@Override
	public void setUnsaved(boolean p_177427_1_) {}

	@Override
	public boolean isUnsaved() {
		return false;
	}

	@Override
	public void removeBlockEntity(BlockPos p_177425_1_) {}

	@Override
	public ShortList[] getPostProcessing() {
		return new ShortList[0];
	}

	@Nullable
	@Override
	public CompoundTag getBlockEntityNbt(BlockPos p_201579_1_) {
		return null;
	}

	@Nullable
	@Override
	public CompoundTag getBlockEntityNbtForSaving(BlockPos p_223134_1_) {
		return null;
	}

	@Override
	public UpgradeData getUpgradeData() {
		return null;
	}

	@Override
	public void setInhabitedTime(long p_177415_1_) {}

	@Override
	public long getInhabitedTime() {
		return 0;
	}

	@Override
	public boolean isLightCorrect() {
		return needsLight;
	}

	@Override
	public void setLightCorrect(boolean needsLight) {
		this.needsLight = needsLight;
	}

	@Nullable
	@Override
	public BlockEntity getBlockEntity(BlockPos pos) {
		return null;
	}

	@Override
	public BlockState getBlockState(BlockPos pos) {
		return world.getBlockState(pos);
	}

	@Override
	public FluidState getFluidState(BlockPos p_204610_1_) {
		return null;
	}

	@Override
	@Nullable
	public StructureStart getStartForStructure(Structure structure) {
		return null;
	}

	@Override
	public void setStartForStructure(Structure structure, StructureStart start) {
	}

	@Override
	public Map<Structure, StructureStart> getAllStarts() {
		return Collections.emptyMap();
	}

	@Override
	public void setAllStarts(Map<Structure, StructureStart> structureStarts) {
	}

	@Override
	public LongSet getReferencesForStructure(Structure structure) {
		return LongSets.emptySet();
	}

	@Override
	public void addReferenceForStructure(Structure structure, long reference) {
	}

	@Override
	public Map<Structure, LongSet> getAllReferences() {
		return Collections.emptyMap();
	}

	@Override
	public void setAllReferences(Map<Structure, LongSet> structureReferences) {
	}

	@Override
	public int getHeight() {
		return world.getHeight();
	}

	@Override
	public int getMinBuildHeight() {
		return world.getMinBuildHeight();
	}

	@Override
	public TickContainerAccess<Fluid> getFluidTicks() {
		return BlackholeTickAccess.emptyContainer();
	}

	@Override
	public TicksToSave getTicksForSerialization() {
		return null;
	}

	@Override
	public TickContainerAccess<Block> getBlockTicks() {
		return BlackholeTickAccess.emptyContainer();
	}

}
