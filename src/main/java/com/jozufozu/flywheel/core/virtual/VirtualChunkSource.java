package com.jozufozu.flywheel.core.virtual;

import java.util.HashMap;
import java.util.function.BooleanSupplier;

import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraft.world.level.chunk.LightChunk;
import net.minecraft.world.level.lighting.LevelLightEngine;

public class VirtualChunkSource extends ChunkSource {
	private final VirtualRenderWorld world;

	public final HashMap<Long, VirtualChunk> chunks = new HashMap<>();

	public VirtualChunkSource(VirtualRenderWorld world) {
		this.world = world;
	}

	@Override
	public LightChunk getChunkForLighting(int x, int z) {
		return getChunk(x, z);
	}

	@Override
	public Level getLevel() {
		return world;
	}

	@Override
	public ChunkAccess getChunk(int x, int z, ChunkStatus status, boolean load) {
		return getChunk(x, z);
	}

	public ChunkAccess getChunk(int x, int z) {
		long pos = ChunkPos.asLong(x, z);

		return chunks.computeIfAbsent(pos, $ -> new VirtualChunk(world, x, z));
	}

	@Override
	public String gatherStats() {
		return "WrappedChunkProvider";
	}

	@Override
	public LevelLightEngine getLightEngine() {
		return world.getLightEngine();
	}

	@Override
	public void tick(BooleanSupplier hasTimeLeft, boolean tickChunks) {
	}

	@Override
	public int getLoadedChunksCount() {
		return 0;
	}
}
