package net.lax1dude.eaglercraft.v1_8.client;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

/** Simple settings screen for Aurora's lightweight client-side overlays. */
public class GuiAuroraModules extends GuiScreen {
	private final GuiScreen parent;

	public GuiAuroraModules(GuiScreen parent) {
		this.parent = parent;
	}

	@Override
	public void initGui() {
		buttonList.clear();
		int center = width / 2;
		int start = height / 2 - 36;
		buttonList.add(new GuiButton(0, center - 100, start, 200, 20, label("FPS Counter", AuroraClient.showFPS)));
		buttonList.add(new GuiButton(1, center - 100, start + 24, 200, 20, label("Coordinates", AuroraClient.showCoordinates)));
		buttonList.add(new GuiButton(2, center - 100, start + 48, 200, 20, label("Keystrokes", AuroraClient.showKeystrokes)));
		buttonList.add(new GuiButton(3, center - 100, start + 84, 200, 20, "Done"));
	}

	private static String label(String name, boolean enabled) {
		return name + ": " + (enabled ? "§aON" : "§cOFF");
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0:
			AuroraClient.showFPS = !AuroraClient.showFPS;
			break;
		case 1:
			AuroraClient.showCoordinates = !AuroraClient.showCoordinates;
			break;
		case 2:
			AuroraClient.showKeystrokes = !AuroraClient.showKeystrokes;
			break;
		case 3:
			mc.displayGuiScreen(parent);
			return;
		default:
			return;
		}
		initGui();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawWorldBackground(0);
		drawCenteredString(fontRendererObj, "§bAURORA CLIENT", width / 2, height / 2 - 76, 0xFFFFFFFF);
		drawCenteredString(fontRendererObj, "Lightweight HUD modules", width / 2, height / 2 - 60, 0xFFB8C7D9);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
