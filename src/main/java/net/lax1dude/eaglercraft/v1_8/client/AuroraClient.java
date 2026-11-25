package net.lax1dude.eaglercraft.v1_8.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.settings.KeyBinding;

/** Lightweight, client-side Aurora quality-of-life overlays. */
public final class AuroraClient {

	public static boolean showFPS = true;
	public static boolean showCoordinates = true;
	public static boolean showKeystrokes = true;

	private AuroraClient() {
	}

	public static void renderOverlay(GuiIngame hud) {
		Minecraft mc = Minecraft.getMinecraft();
		if (mc.thePlayer == null || mc.theWorld == null || mc.gameSettings.showDebugInfo) {
			return;
		}

		int x = 6;
		int y = 6;
		int lineHeight = 10;
		int lines = (showFPS ? 1 : 0) + (showCoordinates ? 1 : 0);
		if (lines > 0) {
			Gui.drawRect(x - 3, y - 3, x + 156, y + lines * lineHeight + 1, 0x8807101C);
			if (showFPS) {
				hud.getFontRenderer().drawStringWithShadow("§bAURORA §7| §f" + Minecraft.debugFPS + " FPS", x, y,
						0xFFFFFFFF);
				y += lineHeight;
			}
			if (showCoordinates) {
				hud.getFontRenderer().drawStringWithShadow(String.format("§7XYZ §f%.1f  %.1f  %.1f",
						mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ), x, y, 0xFFFFFFFF);
			}
		}

		if (showKeystrokes) {
			int left = 6;
			int top = mc.scaledResolution.getScaledHeight() - 54;
			drawKey(hud, mc.gameSettings.keyBindForward, "W", left + 22, top);
			drawKey(hud, mc.gameSettings.keyBindLeft, "A", left, top + 18);
			drawKey(hud, mc.gameSettings.keyBindBack, "S", left + 22, top + 18);
			drawKey(hud, mc.gameSettings.keyBindRight, "D", left + 44, top + 18);
		}
	}

	private static void drawKey(GuiIngame hud, KeyBinding binding, String label, int x, int y) {
		boolean pressed = binding.isKeyDown();
		Gui.drawRect(x, y, x + 20, y + 16, pressed ? 0xCC20AFC1 : 0x9907101C);
		hud.getFontRenderer().drawStringWithShadow(label, x + 7, y + 4, 0xFFFFFFFF);
	}
}
