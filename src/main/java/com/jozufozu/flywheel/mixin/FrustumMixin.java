package com.jozufozu.flywheel.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.jozufozu.flywheel.backend.ShadersModHandler;
import com.jozufozu.flywheel.core.LastActiveCamera;
import com.jozufozu.flywheel.event.BeginFrameEvent;
import com.jozufozu.flywheel.fabric.event.FlywheelEvents;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;

@Mixin(Frustum.class)
public class FrustumMixin {

	@Inject(method = "prepare", at = @At("TAIL"))
	private void onPrepare(double x, double y, double z, CallbackInfo ci) {
		if (ShadersModHandler.isRenderingShadowPass()) {
			FlywheelEvents.BEGIN_FRAME.invoker().handleEvent(new BeginFrameEvent(Minecraft.getInstance().level, LastActiveCamera.getActiveCamera(), (Frustum) (Object) this));
		}
	}
}
