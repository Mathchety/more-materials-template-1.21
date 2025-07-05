package net.matthew.more_materials.item;

import com.google.common.base.Suppliers;
import net.matthew.more_materials.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    COPPER(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL, 190, 5F, 1.0F, 10, () -> Ingredient.ofItems(Items.COPPER_INGOT)),
    ALUMINIUM(ModTags.Blocks.INCORRECT_FOR_ALUMINIUM_TOOL, 230, 6F, 2.0F, 13, () -> Ingredient.ofItems(ModItems.ALUMINIUM_INGOT)),
    EMERALD(ModTags.Blocks.INCORRECT_FOR_EMERALD_TOOL, 1610, 8.0F, 3.0F, 18, () -> Ingredient.ofItems(Items.EMERALD)),
    STEEL(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL, 2100, 9F, 4F, 20, () -> Ingredient.ofItems(ModItems.STEEL_INGOT));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

   ModToolMaterials(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}