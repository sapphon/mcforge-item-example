package com.example.anewbat;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=ANewBatMod.MODID)
public class ItemRegisterer {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        Item a_new_bat = new Item().setRegistryName(ANewBatMod.MODID, "a_new_bat").setUnlocalizedName("anewbat.a_new_bat").setCreativeTab(CreativeTabs.MISC);
        event.getRegistry().register(a_new_bat);
    }
}
