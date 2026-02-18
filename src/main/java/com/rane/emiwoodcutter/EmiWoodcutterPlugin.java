package com.rane.emiwoodcutter;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class EmiWoodcutterPlugin implements EmiPlugin {
    
    // Recipe type ID for Nemo's Woodcutter
    public static final Identifier WOODCUTTING_ID = 
        new Identifier("nemos-woodcutter", "woodcutting");
    
    // Create the recipe category
    public static final EmiRecipeCategory WOODCUTTING_CATEGORY = 
        new EmiRecipeCategory(
            WOODCUTTING_ID,
            EmiStack.of(Registries.ITEM.get(new Identifier("nemos-woodcutter", "woodcutter")))
        );
    
    @Override
    public void register(EmiRegistry registry) {
        System.out.println("[EMI Woodcutter] Plugin starting...");
        
        // Register the category
        registry.addCategory(WOODCUTTING_CATEGORY);
        System.out.println("[EMI Woodcutter] Category registered");
        
        // Add the woodcutter block as a workstation
        registry.addWorkstation(
            WOODCUTTING_CATEGORY, 
            EmiStack.of(Registries.ITEM.get(new Identifier("nemos-woodcutter", "woodcutter")))
        );
        System.out.println("[EMI Woodcutter] Workstation registered");
        
        // Debug: Print all recipe types to find the correct one
        System.out.println("[EMI Woodcutter] Looking for woodcutting recipes...");
        int recipeCount = 0;
        
        for (Recipe<?> recipe : registry.getRecipeManager().values()) {
            String recipeTypeId = recipe.getType().toString();
            
            // Print first few recipe types for debugging
            if (recipeCount < 5) {
                System.out.println("[EMI Woodcutter] Found recipe type: " + recipeTypeId);
            }
            
            // Check for woodcutting recipes
            if (recipeTypeId.contains("woodcutting") || recipeTypeId.contains("nemos")) {
                System.out.println("[EMI Woodcutter] Found woodcutting recipe: " + recipe.getId());
                registry.addRecipe(new WoodcuttingEmiRecipe(recipe));
                recipeCount++;
            }
        }
        
        System.out.println("[EMI Woodcutter] Added " + recipeCount + " woodcutting recipes");
    }
}
