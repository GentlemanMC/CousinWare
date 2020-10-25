package io.ace.nordclient.mixin;


import io.ace.nordclient.managers.HackManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderPlayer.class)
public class MixinRenderPlayer {

    @Inject(method = "renderEntityName", at = @At("HEAD"), cancellable = true)
    public void renderLivingLabel(AbstractClientPlayer entityIn, double x, double y, double z, String name, double distanceSq, CallbackInfo info) {

        //WurstplusEventRenderName event_packet = new WurstplusEventRenderName(entityIn, x, y, z, name, distanceSq);



        if (HackManager.getHackByName("NameTags").isEnabled()) {
            info.cancel();
        }

    }

}
