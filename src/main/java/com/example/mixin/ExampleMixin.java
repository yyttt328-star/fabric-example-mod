package com.example.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ZombieEntity.class)
public class ZombieMixin {

    /**
     * @author you
     * @reason Force 100% villager zombification
     */
    @Overwrite
    public boolean tryAttack(net.minecraft.entity.Entity target) {
        if (target instanceof VillagerEntity villager) {

            World world = villager.getWorld();

            if (!world.isClient) {
                villager.convertTo(EntityType.ZOMBIE_VILLAGER, true);
            }
        }

        return true;
    }
		}
