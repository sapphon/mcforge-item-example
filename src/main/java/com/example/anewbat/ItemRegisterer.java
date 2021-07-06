package com.example.anewbat;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=ANewBatMod.MODID)
public class ItemRegisterer {

    private static final Item a_new_bat = new ItemSword(Item.ToolMaterial.DIAMOND).setRegistryName(ANewBatMod.MODID, "a_new_bat").setUnlocalizedName("a_new_bat").setCreativeTab(CreativeTabs.MISC);

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(a_new_bat);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(a_new_bat, 0, new ModelResourceLocation(a_new_bat.getRegistryName(), "inventory"));
    }
}
