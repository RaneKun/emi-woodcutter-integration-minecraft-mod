# EMI Woodcutter Integration

A Fabric mod for Minecraft 1.20.1 that bridges **Nemo's Woodcutter** and **EMI**, displaying all woodcutting recipes (including custom datapack recipes) directly in the EMI recipe viewer.

**Author:** Rane Kun

---

## Description

This mod adds an EMI plugin that registers all stonecutter/woodcutter recipes from Nemo's Woodcutter into the EMI item list and recipe viewer. Any custom woodcutting recipes added via datapacks are automatically supported.

## Features

- Displays all Nemo's Woodcutter recipes in EMI
- Supports custom datapack woodcutting recipes
- Client-side only — no server installation required
- Lightweight with no performance overhead

## Requirements

| Dependency | Version |
|---|---|
| Minecraft | 1.20.1 |
| Fabric Loader | ≥ 0.16.0 |
| Java | ≥ 21 |
| EMI | ≥ 1.1.0 |
| Nemo's Woodcutter | ≥ 1.12.0 |

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.20.1
2. Download and place the following mods in your `mods/` folder:
   - [EMI](https://modrinth.com/mod/emi)
   - [Nemo's Woodcutter](https://modrinth.com/mod/nemos-woodcutter)
   - This mod (`emi-woodcutter-integration-1.0.0.jar`)
3. Launch the game — woodcutter recipes will appear in EMI automatically

## Credits

This mod is built on top of two excellent mods:

- **[EMI](https://modrinth.com/mod/emi)** — A modern recipe viewer and item list mod for Fabric/Forge. All recipe display functionality is powered by EMI.
- **[Nemo's Woodcutter](https://modrinth.com/mod/nemos-woodcutter)** — Adds a functional Woodcutter block with a full recipe system. All woodcutting recipe data comes from this mod.

Full credit for the underlying systems goes to the authors of these two mods. This integration mod simply connects them together.

## License

MIT License — see [LICENSE](LICENSE) for details.
