Rough 'how to mod' outline:
0) Prereqs:
	- Download Forge MDK for your Minecraft version
	- Download JDK8
	- Install JDK8
	- Unpack Forge MDK on a volume with plenty of space
	To verify you've done this correctly:
		- run `gradlew runClient` from your MDK root dir, verify Minecraft launches with a mod called 'examplemod' installed

1) Giving the example mod a haircut:
	- Alter lines 13, 14, and 15 of ExampleMod.java
	- Remove the sample code using the logger in ExampleMod.java
	- Alter lines 17,18, and 19 of build.gradle
	- Move ExampleMod.java to the package you just said you would, and rename it
	- Alter mcmod.info, at minimum the "modid" line
	To verify you've done this correctly:
		- run `gradlew build`, look in the `build/libs` directory for your JAR, check that the name is correct, install it into a copy of Minecraft and run Minecraft, check the 'mods' page of the menu

2) Registering a new item
	- Create a new class called the ItemRegisterer
	- Annotate it with @Mod.EventBusSubscriber(modid=yrModId)
	- Create a static void method called registerItems that takes a parameter of type Register<Item>
	- Annotate it with @SubscribeEvent
	- Create the item as a static variable
	- Initialize it using chained setters for localizedName, creativeTab, and registryName
	To verify you've done this correctly:
		- run `gradlew runClient`, look @ the creative tab you named, check there's an item there with a very ugly picture

3) Making the item a sword
	- Change the constructor of Item() to ItemSword() and use ToolMaterial.DIAMOND as the one argument
	To verify you've done this correctly:
		- run `gradlew runClient`, check the item's tooltip now lists damage and an attack delay for a diamond sword

4) Making the item show up visually
	- Add to ItemRegisterer to register a renderer
	- Emplace .png at assets/yrModId/textures/items (yes with an s)
	- Emplace .json at assets/yrModId/models/item (no with no s)
		-You must change the "layer0" property to be correct for your mod and item
	- Emplace .lang file at assets/yrModId/lang/en_us.lang (for English)
	To verify you've done this correctly:
		- run `gradlew build`, install the mod into a copy of Minecraft and run Minecraft, check that the item appears in the game as you textured it, with the name you wrote into the lang file

5) Making the item more powerful 
   - Add to ItemRegisterer to create a static ToolMaterial using EnumHelper.addToolMaterial()
   - Use the new ToolMaterial in your call to the ItemSword constructor when registering the Item
	 To verify you've done this correctly:
	   - run `gradlew runClient`, check that the item does 1003 damage if you set the ToolMaterials base damage to 1000
	
6) Responding to events
	- TODO