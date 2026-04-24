package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLivingEntityEvents;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.VillagerEntity;

public class ExampleMod implements ModInitializer {

    @Override
    public void onInitialize() {

        ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, amount) -> {

            if (!(entity instanceof VillagerEntity villager)) return true;

            if (!(damageSource.getAttacker() instanceof ZombieEntity zombie)) return true;

            // 💀 paksa zombie convert (kayak hard mode)
            zombie.setCanBreakDoors(true); // optional, biar lebih “hard mode feel”
            zombie.setPersistent();

            // ini kunci: paksa behavior zombify
            villager.setHealth(0.1f);

            return true;
        });
    }
}
