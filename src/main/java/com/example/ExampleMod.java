package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;

import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ExampleMod implements ModInitializer {

    @Override
    public void onInitialize() {

        // Contoh: semua farmer jual diamond cuma 1 emerald
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> 
                new TradeOffer(
                    new net.minecraft.item.ItemStack(Items.EMERALD, 1), // harga
                    new net.minecraft.item.ItemStack(Items.DIAMOND, 1), // hasil
                    999, // max use
                    1,   // xp
                    0.05f
                )
            );
        });
    }
}
