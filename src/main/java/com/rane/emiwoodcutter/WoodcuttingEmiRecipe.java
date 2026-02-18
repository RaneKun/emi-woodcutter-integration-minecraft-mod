package com.rane.emiwoodcutter;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import com.mojang.datafixers.util.Pair;

import java.lang.reflect.Method;
import java.util.List;

public class WoodcuttingEmiRecipe implements EmiRecipe {
    private final Identifier id;
    private final List<EmiIngredient> input;
    private final List<EmiStack> output;
    
    public WoodcuttingEmiRecipe(Recipe<?> recipe) {
        this.id = recipe.getId();
        
        // Get the ingredientPair using getIngredientPair()
        Ingredient inputIngredient = Ingredient.EMPTY;
        
        try {
            Method getIngredientPairMethod = recipe.getClass().getMethod("getIngredientPair");
            Pair<Ingredient, Integer> ingredientPair = (Pair<Ingredient, Integer>) getIngredientPairMethod.invoke(recipe);
            
            if (ingredientPair != null && ingredientPair.getFirst() != null) {
                inputIngredient = ingredientPair.getFirst();
            }
        } catch (Exception e) {
            System.out.println("[EMI Woodcutter] Failed to get ingredient for: " + recipe.getId());
        }
        
        this.input = List.of(EmiIngredient.of(inputIngredient));
        
        // Get output
        ItemStack outputStack = recipe.getOutput(null);
        this.output = List.of(EmiStack.of(outputStack));
    }
    
    @Override
    public EmiRecipeCategory getCategory() {
        return EmiWoodcutterPlugin.WOODCUTTING_CATEGORY;
    }
    
    @Override
    public @Nullable Identifier getId() {
        return id;
    }
    
    @Override
    public List<EmiIngredient> getInputs() {
        return input;
    }
    
    @Override
    public List<EmiStack> getOutputs() {
        return output;
    }
    
    @Override
    public int getDisplayWidth() {
        return 76;
    }
    
    @Override
    public int getDisplayHeight() {
        return 18;
    }
    
    @Override
    public void addWidgets(WidgetHolder widgets) {
        // Add input slot
        widgets.addSlot(input.get(0), 0, 0);
        
        // Add arrow
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 26, 1);
        
        // Add output slot
        widgets.addSlot(output.get(0), 58, 0).recipeContext(this);
    }
}
