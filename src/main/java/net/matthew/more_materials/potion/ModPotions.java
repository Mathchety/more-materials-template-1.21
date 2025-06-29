package net.matthew.more_materials.potion;

import net.matthew.more_materials.MoreMaterials;
import net.matthew.more_materials.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> SLIMEY_POTION  = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 1200, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion){
        return Registry.registerReference(Registries.POTION, Identifier.of(MoreMaterials.MOD_ID, name), potion);
    }


    public static void registerPotions() {
        MoreMaterials.LOGGER.info("Registering Mod Potions for "+MoreMaterials.MOD_ID);
    }
}
