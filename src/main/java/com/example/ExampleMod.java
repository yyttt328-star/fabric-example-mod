package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;

public class ExampleMod implements ModInitializer {

    @Override
    public void onInitialize() {

        ServerTickEvents.END_SERVER_TICK.register(server -> {

            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

                if (player.currentScreenHandler == null) continue;

                TradeOfferList trades = player.currentScreenHandler.getRecipes();

                if (trades == null) continue;

                for (TradeOffer offer : trades) {

                    // 💀 semua trade jadi 1 emerald
                    offer.getFirstBuyItem().setCount(1);
                }
            }
        });
    }
} 
