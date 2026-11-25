# Aurora Client (EaglercraftX 1.8)

Aurora is a lightweight client-side customization layer for this EaglercraftX 1.8 workspace. The existing built-in PBR shader pack and atmospheric rendering are intentionally unchanged. The workspace contains no custom 4D tessellation implementation: Minecraft's Tessellator is the standard buffered 3D geometry API. Replacing it would damage rendering instead of improving performance.

## Included HUD modules

- FPS counter
- Player coordinates
- WASD keystrokes

## Integration

Connect the module screen and overlay from the existing game GUI classes:

1. In `GuiMainMenu.initGui()`, add an Aurora Modules button and route it in `actionPerformed()` to `new GuiAuroraModules(this)`.
2. In `GuiIngame.renderGameOverlay(float)`, call `AuroraClient.renderOverlay(this)` once after the vanilla HUD is drawn.

These modules use simple HUD text and rectangles. They perform no per-frame tessellation subdivision or shader changes.
