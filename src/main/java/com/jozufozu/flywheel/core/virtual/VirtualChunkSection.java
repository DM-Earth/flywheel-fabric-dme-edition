package com.jozufozu.flywheel.core.virtual;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunkSection;

public class VirtualChunkSection extends LevelChunkSection {

	public VirtualChunk owner;

	public final int xStart;
	public final int yStart;
	public final int zStart;

	public VirtualChunkSection(VirtualChunk owner, int yBase) {
		super(owner.world.registryAccess()
			.registryOrThrow(Registries.BIOME));
		this.owner = owner;
		this.xStart = owner.getPos()
			.getMinBlockX();
		this.yStart = yBase;
		this.zStart = owner.getPos()
			.getMinBlockZ();
	}

	@Override
	public BlockState getBlockState(int x, int y, int z) {
		// ChunkSection#getBlockState expects local chunk coordinates, so we add to get
		// back into world coords.
		return owner.world.getBlockState(x + xStart, y + yStart, z + zStart);
	}

	@Override
	public BlockState setBlockState(int x, int y, int z, BlockState state, boolean useLock) {
		throw new IllegalStateException("Chunk sections should not be mutated in a fake world.");
	}
}
