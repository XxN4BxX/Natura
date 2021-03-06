package mods.natura.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mods.natura.blocks.CloudBlock;
import mods.natura.blocks.HeatSand;
import mods.natura.blocks.TaintedSoil;
import mods.natura.blocks.crops.BerryBush;
import mods.natura.blocks.crops.CropBlock;
import mods.natura.blocks.crops.FlowerBlock;
import mods.natura.blocks.crops.Glowshroom;
import mods.natura.blocks.crops.LargeGlowshroom;
import mods.natura.blocks.crops.NetherBerryBush;
import mods.natura.blocks.crops.ThornVines;
import mods.natura.blocks.overrides.AlternateBookshelf;
import mods.natura.blocks.overrides.AlternateFence;
import mods.natura.blocks.overrides.AlternateWorkbench;
import mods.natura.blocks.trees.DarkTreeBlock;
import mods.natura.blocks.trees.LogTwoxTwo;
import mods.natura.blocks.trees.NDoor;
import mods.natura.blocks.trees.NLeaves;
import mods.natura.blocks.trees.NLeavesDark;
import mods.natura.blocks.trees.NLeavesNocolor;
import mods.natura.blocks.trees.NSaplingBlock;
import mods.natura.blocks.trees.OverworldLeaves;
import mods.natura.blocks.trees.OverworldSapling;
import mods.natura.blocks.trees.OverworldTreeBlock;
import mods.natura.blocks.trees.Planks;
import mods.natura.blocks.trees.SaguaroBlock;
import mods.natura.blocks.trees.SimpleLog;
import mods.natura.blocks.trees.TreeBlock;
import mods.natura.blocks.trees.WillowBlock;
import mods.natura.items.BerryItem;
import mods.natura.items.BerryMedley;
import mods.natura.items.BoneBag;
import mods.natura.items.BowlEmpty;
import mods.natura.items.BowlStew;
import mods.natura.items.CactusJuice;
import mods.natura.items.NaturaSeeds;
import mods.natura.items.NetherBerryItem;
import mods.natura.items.NetherFoodItem;
import mods.natura.items.PlantItem;
import mods.natura.items.SeedBag;
import mods.natura.items.SeedFood;
import mods.natura.items.StickItem;
import mods.natura.items.blocks.BerryBushItem;
import mods.natura.items.blocks.CloudItem;
import mods.natura.items.blocks.DarkTreeItem;
import mods.natura.items.blocks.GlowshroomItem;
import mods.natura.items.blocks.LogTwoxTwoItem;
import mods.natura.items.blocks.NAlternateItem;
import mods.natura.items.blocks.NDoorItem;
import mods.natura.items.blocks.NLeavesDarkItem;
import mods.natura.items.blocks.NLeavesItem;
import mods.natura.items.blocks.NSaplingItem;
import mods.natura.items.blocks.NetherBerryBushItem;
import mods.natura.items.blocks.NoColorLeavesItem;
import mods.natura.items.blocks.OverworldLeavesItem;
import mods.natura.items.blocks.OverworldSaplingItem;
import mods.natura.items.blocks.OverworldTreeItem;
import mods.natura.items.blocks.PlanksItem;
import mods.natura.items.blocks.RedwoodItem;
import mods.natura.items.blocks.SaguaroItem;
import mods.natura.items.blocks.TreeItem;
import mods.natura.items.blocks.WillowItem;
import mods.natura.items.tools.NaturaBow;
import mods.natura.items.tools.NaturaHatchet;
import mods.natura.items.tools.NaturaKama;
import mods.natura.items.tools.NaturaPickaxe;
import mods.natura.items.tools.NaturaShovel;
import mods.natura.items.tools.NaturaSword;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;

public class NContent
{

    public void preInit ()
    {
        //Crops
        plantItem = new PlantItem(PHNatura.foodID).setUnlocalizedName("barleyFood");
        crops = new CropBlock(PHNatura.floraCropsID);
        seeds = new NaturaSeeds(PHNatura.barleySeedID, crops.blockID, Block.tilledField.blockID).setUnlocalizedName("barley.seed");
        GameRegistry.registerBlock(crops, "N Crops");

        waterDrop = new CactusJuice(PHNatura.cactusJuice, false).setUnlocalizedName("waterdrop");

        wheatBag = new SeedBag(PHNatura.wheatBagID, Block.crops, 0, "wheat").setUnlocalizedName("wheatBag");
        barleyBag = new SeedBag(PHNatura.barleyBagID, crops, 0, "barley").setUnlocalizedName("barleyBag");
        potatoBag = new SeedBag(PHNatura.potatoBagID, Block.potato, 0, "potato").setUnlocalizedName("potatoBag");
        carrotBag = new SeedBag(PHNatura.carrotBagID, Block.carrot, 0, "carrot").setUnlocalizedName("carrotBag");
        netherWartBag = new SeedBag(PHNatura.netherWartBagID, Block.netherStalk, 0, "netherwart").setUnlocalizedName("wartBag");
        cottonBag = new SeedBag(PHNatura.cottonBagID, crops, 4, "cotton").setUnlocalizedName("cottonBag");
        boneBag = new BoneBag(PHNatura.boneBagID, "bone").setUnlocalizedName("boneBag");

        netherBerryItem = new NetherBerryItem(PHNatura.netherBerryItem, 1).setUnlocalizedName("berry.nether");
        berryItem = new BerryItem(PHNatura.berryItemID, 1).setUnlocalizedName("berry");
        berryMedley = new BerryMedley(PHNatura.berryMedley, 5).setUnlocalizedName("berryMedley");

        berryBush = new BerryBush(PHNatura.berryBlockID);
        GameRegistry.registerBlock(berryBush, BerryBushItem.class, "BerryBush");
        netherBerryBush = new NetherBerryBush(PHNatura.netherBerryBlock);
        GameRegistry.registerBlock(netherBerryBush, NetherBerryBushItem.class, "NetherBerryBush");

        //Clouds
        cloud = new CloudBlock(PHNatura.cloudID);
        GameRegistry.registerBlock(cloud, CloudItem.class, "Cloud");

        //Trees
        tree = new TreeBlock(PHNatura.treeID).setUnlocalizedName("natura.treeblock");
        redwood = new SimpleLog(PHNatura.redwoodID).setUnlocalizedName("natura.redwood");
        planks = new Planks(PHNatura.planksID).setUnlocalizedName("natura.planks");
        floraLeaves = (NLeaves) new NLeaves(PHNatura.floraLeavesID).setUnlocalizedName("natura.leaves");
        floraLeavesNoColor = (NLeaves) new NLeavesNocolor(PHNatura.cherryLeavesID).setUnlocalizedName("natura.leavesnocolor");
        floraSapling = (NSaplingBlock) new NSaplingBlock(PHNatura.floraSaplingID).setUnlocalizedName("natura.sapling");
        willow = new WillowBlock(PHNatura.willow).setUnlocalizedName("willow");

        saguaro = new SaguaroBlock(PHNatura.saguaroID).setUnlocalizedName("saguaro.block");
        seedFood = new SeedFood(PHNatura.seedFood, 3, 0.3f, saguaro.blockID).setUnlocalizedName("saguaro.fruit");

        doorItem = new NDoorItem(PHNatura.doorItemID).setUnlocalizedName("redwoodDoorItem");
        redwoodDoor = new NDoor(PHNatura.redwoodDoor, Material.wood, 0, "redwood").setUnlocalizedName("door.redwood");
        eucalyptusDoor = new NDoor(PHNatura.eucalyptusDoor, Material.wood, 1, "eucalyptus").setUnlocalizedName("door.eucalyptus");
        hopseedDoor = new NDoor(PHNatura.hopseedDoor, Material.wood, 2, "hopseed").setUnlocalizedName("door.hopseed");
        sakuraDoor = new NDoor(PHNatura.sakuraDoor, Material.wood, 3, "sakura").setUnlocalizedName("door.sakura");
        ghostDoor = new NDoor(PHNatura.ghostDoor, Material.wood, 4, "ghostwood").setUnlocalizedName("door.ghostwood");
        bloodDoor = new NDoor(PHNatura.bloodDoor, Material.wood, 5, "bloodwood").setUnlocalizedName("door.bloodwood");
        redwoodBarkDoor = new NDoor(PHNatura.redwoodBarkDoor, Material.wood, 6, "redwoodbark").setUnlocalizedName("door.redwoodbark");

        MinecraftForge.addGrassSeed(new ItemStack(seeds, 1, 0), 3);
        MinecraftForge.addGrassSeed(new ItemStack(seeds, 1, 1), 3);

        //floraBoat = new NBoat(PHNatura.boatItemID).setIconCoord(0, 3).setUnlocalizedName("floraBoat");

        GameRegistry.registerBlock(tree, TreeItem.class, "tree");
        GameRegistry.registerBlock(redwood, RedwoodItem.class, "redwood");
        GameRegistry.registerBlock(planks, PlanksItem.class, "planks");
        GameRegistry.registerBlock(floraLeaves, NLeavesItem.class, "floraleaves");
        GameRegistry.registerBlock(floraLeavesNoColor, NoColorLeavesItem.class, "floraleavesnocolor");
        GameRegistry.registerBlock(floraSapling, NSaplingItem.class, "florasapling");
        GameRegistry.registerBlock(redwoodDoor, "Redwood Door");
        GameRegistry.registerBlock(saguaro, SaguaroItem.class, "Saguaro");
        GameRegistry.registerBlock(willow, WillowItem.class, "willow");

        //Nether
        bloodwood = new LogTwoxTwo(PHNatura.bloodwoodID, 8f, Material.vine).setUnlocalizedName("bloodwood");
        GameRegistry.registerBlock(bloodwood, LogTwoxTwoItem.class, "bloodwood");
        taintedSoil = new TaintedSoil(PHNatura.taintedSoil).setUnlocalizedName("TaintedSoil");
        GameRegistry.registerBlock(taintedSoil, "soil.tainted");
        heatSand = new HeatSand(PHNatura.heatSand).setUnlocalizedName("HeatSand");//.setLightValue(0.375f);
        GameRegistry.registerBlock(heatSand, "heatsand");
        /*netherAir = new SulfurAirBlock(PHNatura.sulfurair).setUnlocalizedName("SulfurAir");
        GameRegistry.registerBlock(netherAir, "netherAir");*/
        /*infernalStone = new NBlock(PHNatura.infernalStone, Material.rock, 1.5f, new String[] { "infernal_stone" }).setUnlocalizedName("infernalStone");
        GameRegistry.registerBlock(infernalStone, "infernalStone");*/

        darkTree = new DarkTreeBlock(PHNatura.darkTree).setUnlocalizedName("Darktree");
        GameRegistry.registerBlock(darkTree, DarkTreeItem.class, "Dark Tree");
        darkLeaves = (NLeaves) new NLeavesDark(PHNatura.darkLeaves).setUnlocalizedName("Darkleaves");
        GameRegistry.registerBlock(darkLeaves, NLeavesDarkItem.class, "Dark Leaves");
        thornVines = new ThornVines(PHNatura.thornVines).setUnlocalizedName("Thornvines").setLightValue(0.625f);
        GameRegistry.registerBlock(thornVines, "Thornvines");
        glowshroom = (Glowshroom) new Glowshroom(PHNatura.glowshroom).setUnlocalizedName("Glowshroom").setLightValue(0.625f);
        GameRegistry.registerBlock(glowshroom, GlowshroomItem.class, "Glowshroom");
        glowshroomBlue = new LargeGlowshroom(PHNatura.glowshroomBlue, Material.wood, "blue").setUnlocalizedName("blueGlowshroom").setLightValue(0.625f);
        GameRegistry.registerBlock(glowshroomBlue, "blueGlowshroom");
        glowshroomPurple = new LargeGlowshroom(PHNatura.glowshroomPurple, Material.wood, "purple").setUnlocalizedName("purpleGlowshroom").setLightValue(0.5f);
        GameRegistry.registerBlock(glowshroomPurple, "purpleGlowshroom");
        glowshroomGreen = new LargeGlowshroom(PHNatura.glowshroomGreen, Material.wood, "green").setUnlocalizedName("greenGlowshroom").setLightValue(0.5f);
        GameRegistry.registerBlock(glowshroomGreen, "greenGlowshroom");
        
        Block.netherrack.setResistance(4f);

        /*public static Block glowshroomBlue;
        public static Block glowshroomGreen;
        public static Block glowshroomPurple;*/

        potashApple = new NetherFoodItem(PHNatura.netherFood).setUnlocalizedName("Natura.netherfood");

        //Rare overworld
        rareTree = new OverworldTreeBlock(PHNatura.rareTree).setUnlocalizedName("RareTree");
        GameRegistry.registerBlock(rareTree, OverworldTreeItem.class, "Rare Tree");
        rareLeaves = (NLeaves) new OverworldLeaves(PHNatura.rareLeaves).setUnlocalizedName("RareLeaves");
        GameRegistry.registerBlock(rareLeaves, OverworldLeavesItem.class, "Rare Leaves");
        rareSapling = (OverworldSapling) new OverworldSapling(PHNatura.rareSapling).setUnlocalizedName("RareSapling");
        GameRegistry.registerBlock(rareSapling, OverworldSaplingItem.class, "Rare Sapling");
        //rareLeaves;
        bluebells = new FlowerBlock(PHNatura.bluebells).setUnlocalizedName("Bluebells");
        GameRegistry.registerBlock(bluebells, "Bluebells");

        //Vanilla overrides and alternates
        //Block.blocksList[58] = null;
        //Item.itemsList[58] = null;
        alternateWorkbench = new AlternateWorkbench(PHNatura.alternateWorkbench).setHardness(2.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("workbench").setCreativeTab(NaturaTab.tab);
        GameRegistry.registerBlock(alternateWorkbench, NAlternateItem.class, "Natura.workbench");

        //Block.blocksList[47] = null;
        //Item.itemsList[47] = null;
        alternateBookshelf = new AlternateBookshelf(PHNatura.alternateBookshelf).setHardness(1.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("bookshelf").setCreativeTab(NaturaTab.tab);
        GameRegistry.registerBlock(alternateBookshelf, NAlternateItem.class, "Natura.bookshelf");

        alternateFence = new AlternateFence(PHNatura.alternateFence, Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("fence")
                .setCreativeTab(NaturaTab.tab);
        GameRegistry.registerBlock(alternateFence, NAlternateItem.class, "Natura.fence");

        //Item.itemsList[24] = null;
        //Item.stick = null;
        stickItem = (new StickItem(PHNatura.stickItem)).setFull3D().setUnlocalizedName("natura.stick").setCreativeTab(NaturaTab.tab);
        GameRegistry.registerItem(stickItem, "natura.stick");

        EnumToolMaterial Bloodwood = EnumHelper.addToolMaterial("Bloodwood", 2, 350, 7f, 3, 24);

        ghostwoodSword = new NaturaSword(PHNatura.ghostwoodSword, EnumToolMaterial.WOOD, "ghostwood").setUnlocalizedName("natura.sword.ghostwood");
        ghostwoodPickaxe = new NaturaPickaxe(PHNatura.ghostwoodPickaxe, EnumToolMaterial.WOOD, "ghostwood").setUnlocalizedName("natura.pickaxe.ghostwood");
        ghostwoodShovel = new NaturaShovel(PHNatura.ghostwoodShovel, EnumToolMaterial.WOOD, "ghostwood").setUnlocalizedName("natura.shovel.ghostwood");
        ghostwoodAxe = new NaturaHatchet(PHNatura.ghostwoodAxe, EnumToolMaterial.WOOD, "ghostwood").setUnlocalizedName("natura.axe.ghostwood");
        
        bloodwoodSword = new NaturaSword(PHNatura.bloodwoodSword, Bloodwood, "bloodwood").setUnlocalizedName("natura.sword.bloodwood");
        bloodwoodPickaxe = new NaturaPickaxe(PHNatura.bloodwoodPickaxe, Bloodwood, "bloodwood").setUnlocalizedName("natura.pickaxe.bloodwood");
        bloodwoodShovel = new NaturaShovel(PHNatura.bloodwoodShovel, Bloodwood, "bloodwood").setUnlocalizedName("natura.shovel.bloodwood");
        bloodwoodAxe = new NaturaHatchet(PHNatura.bloodwoodAxe, Bloodwood, "bloodwood").setUnlocalizedName("natura.axe.bloodwood");
        
        darkwoodSword = new NaturaSword(PHNatura.darkwoodSword, EnumToolMaterial.STONE, "darkwood").setUnlocalizedName("natura.sword.darkwood");
        darkwoodPickaxe = new NaturaPickaxe(PHNatura.darkwoodPickaxe, EnumToolMaterial.STONE, "darkwood").setUnlocalizedName("natura.pickaxe.darkwood");
        darkwoodShovel = new NaturaShovel(PHNatura.darkwoodShovel, EnumToolMaterial.STONE, "darkwood").setUnlocalizedName("natura.shovel.darkwood");
        darkwoodAxe = new NaturaHatchet(PHNatura.darkwoodAxe, EnumToolMaterial.STONE, "darkwood").setUnlocalizedName("natura.axe.darkwood");
        
        fusewoodSword = new NaturaSword(PHNatura.fusewoodSword, EnumToolMaterial.IRON, "fusewood").setUnlocalizedName("natura.sword.fusewood");
        fusewoodPickaxe = new NaturaPickaxe(PHNatura.fusewoodPickaxe, EnumToolMaterial.IRON, "fusewood").setUnlocalizedName("natura.pickaxe.fusewood");
        fusewoodShovel = new NaturaShovel(PHNatura.fusewoodShovel, EnumToolMaterial.IRON, "fusewood").setUnlocalizedName("natura.shovel.fusewood");
        fusewoodAxe = new NaturaHatchet(PHNatura.fusewoodAxe, EnumToolMaterial.IRON, "fusewood").setUnlocalizedName("natura.axe.fusewood");
        
        netherquartzSword = new NaturaSword(PHNatura.netherquartzSword, EnumToolMaterial.STONE, "netherquartz").setUnlocalizedName("natura.sword.netherquartz");
        netherquartzPickaxe = new NaturaPickaxe(PHNatura.netherquartzPickaxe, EnumToolMaterial.STONE, "netherquartz").setUnlocalizedName("natura.pickaxe.netherquartz");
        netherquartzShovel = new NaturaShovel(PHNatura.netherquartzShovel, EnumToolMaterial.STONE, "netherquartz").setUnlocalizedName("natura.shovel.netherquartz");
        netherquartzAxe = new NaturaHatchet(PHNatura.netherquartzAxe, EnumToolMaterial.STONE, "netherquartz").setUnlocalizedName("natura.axe.netherquartz");
        netherquartzKama = new NaturaKama(PHNatura.netherquartzKama, EnumToolMaterial.STONE, "netherquartz").setUnlocalizedName("natura.kama.netherquartz");

        ghostwoodKama = new NaturaKama(PHNatura.ghostwoodKama, EnumToolMaterial.WOOD, "ghostwood").setUnlocalizedName("natura.kama.ghostwood");
        bloodwoodKama = new NaturaKama(PHNatura.bloodwoodKama, Bloodwood, "bloodwood").setUnlocalizedName("natura.kama.bloodwood");
        darkwoodKama = new NaturaKama(PHNatura.darkwoodKama, EnumToolMaterial.STONE, "darkwood").setUnlocalizedName("natura.kama.darkwood");
        fusewoodKama = new NaturaKama(PHNatura.fusewoodKama, EnumToolMaterial.IRON, "fusewood").setUnlocalizedName("natura.kama.fusewood");
        
        ghostwoodBow = new NaturaBow(PHNatura.ghostwoodBow, 384, "ghostwood").setUnlocalizedName("natura.bow.ghostwood");
        bloodwoodBow = new NaturaBow(PHNatura.bloodwoodBow, 1501, "bloodwood").setUnlocalizedName("natura.bow.bloodwood");
        darkwoodBow = new NaturaBow(PHNatura.darkwoodBow, 162, "darkwood").setUnlocalizedName("natura.bow.darkwood");
        fusewoodBow = new NaturaBow(PHNatura.fusewoodBow, 28, "fusewood").setUnlocalizedName("natura.bow.fusewood");
        
        /*public static Item ghostwoodBow;
        public static Item bloodwoodBow;
        public static Item darkwoodBow;
        public static Item fusewoodBow;*/
        
        MinecraftForge.setToolClass(ghostwoodPickaxe, "pickaxe", 0);
        MinecraftForge.setToolClass(ghostwoodShovel, "shovel", 0);
        MinecraftForge.setToolClass(ghostwoodAxe, "axe", 0);
        
        MinecraftForge.setToolClass(bloodwoodPickaxe, "pickaxe", 2);
        MinecraftForge.setToolClass(bloodwoodShovel, "shovel", 2);
        MinecraftForge.setToolClass(bloodwoodAxe, "axe", 2);
        
        MinecraftForge.setToolClass(darkwoodPickaxe, "pickaxe", 1);
        MinecraftForge.setToolClass(darkwoodShovel, "shovel", 1);
        MinecraftForge.setToolClass(darkwoodAxe, "axe", 1);
        
        MinecraftForge.setToolClass(fusewoodPickaxe, "pickaxe", 2);
        MinecraftForge.setToolClass(fusewoodShovel, "shovel", 2);
        MinecraftForge.setToolClass(fusewoodAxe, "axe", 2);
        
        MinecraftForge.setToolClass(netherquartzPickaxe, "pickaxe", 1);
        MinecraftForge.setToolClass(netherquartzShovel, "shovel", 1);
        MinecraftForge.setToolClass(netherquartzAxe, "axe", 1);
        //Material.vine.setRequiresTool();

        MinecraftForge.setBlockHarvestLevel(bloodwood, "axe", 2);
        MinecraftForge.setBlockHarvestLevel(darkTree, 1, "axe", 1);
        
        bowlEmpty = new BowlEmpty(PHNatura.bowlEmpty).setUnlocalizedName("natura.emptybowl");
        bowlStew = new BowlStew(PHNatura.bowlStew).setUnlocalizedName("natura.stewbowl");
        addRecipes();
    }

    public void addRecipes ()
    {
        //Crops
        GameRegistry.addRecipe(new ItemStack(wheatBag, 1, 0), "sss", "sss", "sss", 's', Item.seeds);
        GameRegistry.addRecipe(new ItemStack(barleyBag, 1, 0), "sss", "sss", "sss", 's', seeds);
        GameRegistry.addRecipe(new ItemStack(potatoBag, 1, 0), "sss", "sss", "sss", 's', Item.potato);
        GameRegistry.addRecipe(new ItemStack(carrotBag, 1, 0), "sss", "sss", "sss", 's', Item.carrot);
        GameRegistry.addRecipe(new ItemStack(netherWartBag, 1, 0), "sss", "sss", "sss", 's', Item.netherStalkSeeds);
        GameRegistry.addRecipe(new ItemStack(cottonBag, 1, 0), "sss", "sss", "sss", 's', new ItemStack(seeds, 1, 1));
        GameRegistry.addRecipe(new ItemStack(boneBag, 1, 0), "sss", "sss", "sss", 's', new ItemStack(Item.dyePowder, 1, 15));

        GameRegistry.addRecipe(new ItemStack(Item.seeds, 9, 0), "s", 's', wheatBag);
        GameRegistry.addRecipe(new ItemStack(seeds, 9, 0), "s", 's', barleyBag);
        GameRegistry.addRecipe(new ItemStack(Item.potato, 9, 0), "s", 's', potatoBag);
        GameRegistry.addRecipe(new ItemStack(Item.carrot, 9, 0), "s", 's', carrotBag);
        GameRegistry.addRecipe(new ItemStack(Item.netherStalkSeeds, 9, 0), "s", 's', netherWartBag);
        GameRegistry.addRecipe(new ItemStack(seeds, 9, 1), "s", 's', cottonBag);
        GameRegistry.addRecipe(new ItemStack(Item.dyePowder, 9, 15), "s", 's', boneBag);

        GameRegistry.addRecipe(new ItemStack(Item.silk), "sss", 's', new ItemStack(plantItem, 1, 3));
        GameRegistry.addRecipe(new ItemStack(Block.cloth), "sss", "sss", "sss", 's', new ItemStack(plantItem, 1, 3));

        GameRegistry.addRecipe(new ItemStack(waterDrop, 1), "X", 'X', Block.cactus);
        GameRegistry.addRecipe(new ItemStack(Item.bucketWater, 1), "www", "wBw", "www", 'w', waterDrop, 'B', Item.bucketEmpty);

        GameRegistry.addRecipe(new ItemStack(Item.bread), "bbb", 'b', new ItemStack(plantItem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(plantItem, 1, 1), "X", 'X', new ItemStack(plantItem, 1, 0));
        GameRegistry.addRecipe(new ItemStack(plantItem, 1, 2), "X", 'X', new ItemStack(Item.wheat));

        FurnaceRecipes.smelting().addSmelting(saguaro.blockID, 0, new ItemStack(Item.dyePowder, 1, 2), 0.2F);

        for (int i = 1; i <= 2; i++)
        {
            FurnaceRecipes.smelting().addSmelting(plantItem.itemID, i, new ItemStack(Item.bread, 1), 0.5f);
            GameRegistry.addRecipe(new ItemStack(Item.cake, 1), "AAA", "BEB", " C ", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', new ItemStack(plantItem, 1, i), 'E', Item.egg);
        }

        String[] berryTypes = new String[] { "cropRaspberry", "cropBlueberry", "cropBlackberry", "cropMaloberry", "cropStrawberry", "cropCranberry" };

        for (int iter1 = 0; iter1 < berryTypes.length - 2; iter1++)
            for (int iter2 = iter1 + 1; iter2 < berryTypes.length - 1; iter2++)
                for (int iter3 = iter2 + 1; iter3 < berryTypes.length; iter3++)
                    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(berryMedley, 1, 0), new ItemStack(Item.bowlEmpty), berryTypes[iter1], berryTypes[iter2], berryTypes[iter3]));

        for (int iter1 = 0; iter1 < berryTypes.length - 3; iter1++)
            for (int iter2 = iter1 + 1; iter2 < berryTypes.length - 2; iter2++)
                for (int iter3 = iter2 + 1; iter3 < berryTypes.length - 1; iter3++)
                    for (int iter4 = iter3 + 1; iter4 < berryTypes.length; iter4++)
                        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(berryMedley, 2, 0), new ItemStack(Item.bowlEmpty), new ItemStack(Item.bowlEmpty), berryTypes[iter1],
                                berryTypes[iter2], berryTypes[iter3], berryTypes[iter4]));

        //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(toolStationWood, 1, 1), "p", "w", 'p', new ItemStack(blankPattern, 1, 0), 'w', "logWood"));
        /*GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 1), new ItemStack(berryItem, 1, 0), new ItemStack(berryItem, 1, 1), new ItemStack(berryItem, 1, 2), new ItemStack(Item.bowlEmpty));
        GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 1), new ItemStack(berryItem, 1, 0), new ItemStack(berryItem, 1, 1), new ItemStack(berryItem, 1, 3), new ItemStack(Item.bowlEmpty));
        GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 1), new ItemStack(berryItem, 1, 0), new ItemStack(berryItem, 1, 2), new ItemStack(berryItem, 1, 3), new ItemStack(Item.bowlEmpty));
        GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 1), new ItemStack(berryItem, 1, 1), new ItemStack(berryItem, 1, 2), new ItemStack(berryItem, 1, 3), new ItemStack(Item.bowlEmpty));
        GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 2), new ItemStack(berryItem, 1, 0), new ItemStack(berryItem, 1, 1), new ItemStack(berryItem, 1, 2), new ItemStack(berryItem, 1, 3),
        		new ItemStack(Item.bowlEmpty), new ItemStack(Item.bowlEmpty));*/
        //GameRegistry.addShapelessRecipe(new ItemStack(plantItem, 1, 2), new ItemStack(plantItem, 1, 1), Item.bucketWater );
        //GameRegistry.addShapelessRecipe(new ItemStack(plantItem, 2, 2), new ItemStack(plantItem, 1, 1), Item.egg );

        //Clouds
        GameRegistry.addRecipe(new ItemStack(Item.coal, 1, 1), "ccc", "ccc", "ccc", 'c', new ItemStack(cloud, 1, 2));
        GameRegistry.addRecipe(new ItemStack(plantItem, 1, 4), "cc", "cc", 'c', new ItemStack(cloud, 1, 3));
        GameRegistry.addRecipe(new ItemStack(Item.gunpowder, 1, 0), "cc", "cc", 'c', new ItemStack(plantItem, 1, 4));

        //Trees
        for (int i = 0; i < 3; i++)
        {
            GameRegistry.addRecipe(new ItemStack(planks, 4, i), "w", 'w', new ItemStack(tree, 1, i));
            GameRegistry.addRecipe(new ItemStack(planks, 4, i + 6), "w", 'w', new ItemStack(rareTree, 1, i));
        }
        GameRegistry.addRecipe(new ItemStack(planks, 4, 3), "w", 'w', new ItemStack(redwood, 1, 1));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 4), "w", 'w', new ItemStack(bloodwood, 1, Short.MAX_VALUE));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 5), "w", 'w', new ItemStack(tree, 1, 3));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 10), "w", 'w', new ItemStack(willow, 1, 0));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 11), "w", 'w', new ItemStack(darkTree, 1, 0));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 12), "w", 'w', new ItemStack(darkTree, 1, 1));
        
        GameRegistry.addRecipe(new ItemStack(plantItem, 1, 1), "X", 'X', new ItemStack(plantItem, 1, 0));

        /*ItemStack[] plankStacks = new ItemStack[] { new ItemStack(planks, 1, 0), new ItemStack(planks, 1, 1), new ItemStack(planks, 1, 2), new ItemStack(planks, 1, 3), new ItemStack(planks, 1, 5),
                new ItemStack(planks, 1, 6), new ItemStack(planks, 1, 7), new ItemStack(planks, 1, 8), new ItemStack(planks, 1, 9), new ItemStack(planks, 1, 10), new ItemStack(planks, 1, 11) };*/
        ItemStack[] logStacks = new ItemStack[] { new ItemStack(tree, 1, 0), new ItemStack(tree, 1, 1), new ItemStack(tree, 1, 2), new ItemStack(tree, 1, 3), new ItemStack(redwood, 1, 1),
                new ItemStack(rareTree, 1, 0), new ItemStack(rareTree, 1, 1), new ItemStack(rareTree, 1, 2), new ItemStack(rareTree, 1, 3), new ItemStack(willow, 1, 0), new ItemStack(darkTree, 1, 0) };
        int[] exclusions = { 4, 11 };
        
        GameRegistry.addRecipe(new ItemStack(plantItem, 1, 5), " s ", "#s#", "#s#", 's', new ItemStack(stickItem, 1, 2), '#', new ItemStack(floraLeavesNoColor, 1, 1));
        GameRegistry.addRecipe(new ItemStack(Item.arrow, 4, 0), " f ", "#s#", " # ", 's', new ItemStack(stickItem, 1, Short.MAX_VALUE), '#', new ItemStack(plantItem, 1, 5),
        		'f', Item.flint);
        GameRegistry.addRecipe(new ItemStack(Item.arrow, 4, 0), " f ", "#s#", " # ", 's', Item.stick, '#', new ItemStack(plantItem, 1, 5),
        		'f', Item.flint);

        List recipes = CraftingManager.getInstance().getRecipeList();
        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 0), "##", "##", "##", '#', new ItemStack(planks, 1, 3));
        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 1), "##", "##", "##", '#', new ItemStack(planks, 1, 0));
        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 2), "##", "##", "##", '#', new ItemStack(planks, 1, 5));
        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 3), "##", "##", "##", '#', new ItemStack(planks, 1, 1));
        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 4), "##", "##", "##", '#', new ItemStack(planks, 1, 2));
        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 5), "##", "##", "##", '#', new ItemStack(planks, 1, 4));
        addShapedRecipeFirst(recipes, new ItemStack(doorItem, 1, 6), "##", "##", "##", '#', new ItemStack(redwood, 1, 0));

        for (int i = 0; i < woodTextureNames.length; i++)
        {
            addShapedRecipeFirst(recipes, new ItemStack(stickItem, 4, i), "#", "#", '#', new ItemStack(planks, 1, i));
            addShapedRecipeFirst(recipes, new ItemStack(alternateWorkbench, 1, i), "##", "##", '#', new ItemStack(planks, 1, i));
            addShapedRecipeFirst(recipes, new ItemStack(alternateBookshelf, 1, i), "###", "bbb", "###", '#', new ItemStack(planks, 1, i), 'b', Item.book);
            addShapedRecipeFirst(recipes, new ItemStack(alternateFence, 2, i), "###", "###", '#', new ItemStack(stickItem, 1, i));
        }

        int meta = 0;
        for (int i = 0; i < logStacks.length; i++)
        {
            for (int e = 0; e < exclusions.length; e++)
            {
                if (exclusions[e] == i)
                        meta++;
            }
            OreDictionary.registerOre("plankWood", new ItemStack(planks, 1, meta));
            OreDictionary.registerOre("logWood", logStacks[i]);
            OreDictionary.registerOre("stickWood", new ItemStack(stickItem, 1, meta));
            meta++;
        }
        int[] toolMeta = {2, 4, 11, 12};
        Item[][] tools = {
                {ghostwoodSword, ghostwoodPickaxe, ghostwoodShovel, ghostwoodAxe, ghostwoodKama, ghostwoodBow},
                {bloodwoodSword, bloodwoodPickaxe, bloodwoodShovel, bloodwoodAxe, bloodwoodKama, bloodwoodBow},
                {darkwoodSword, darkwoodPickaxe, darkwoodShovel, darkwoodAxe, darkwoodKama, darkwoodBow},
                {fusewoodSword, fusewoodPickaxe, fusewoodShovel, fusewoodAxe, fusewoodKama, fusewoodBow}
                };
        
        for (int i = 0; i < toolMeta.length; i++)
        {
            addShapedRecipeFirst(recipes, new ItemStack(tools[i][0], 1, 0), "#", "#", "s", '#', new ItemStack(planks, 1, toolMeta[i]), 's', new ItemStack(stickItem, 1, toolMeta[i]));
            addShapedRecipeFirst(recipes, new ItemStack(tools[i][1], 1, 0), "###", " s ", " s ", '#', new ItemStack(planks, 1, toolMeta[i]), 's', new ItemStack(stickItem, 1, toolMeta[i]));
            addShapedRecipeFirst(recipes, new ItemStack(tools[i][2], 1, 0), "#", "s", "s", '#', new ItemStack(planks, 1, toolMeta[i]), 's', new ItemStack(stickItem, 1, toolMeta[i]));
            addShapedRecipeFirst(recipes, new ItemStack(tools[i][3], 1, 0), "##", "#s", " s", '#', new ItemStack(planks, 1, toolMeta[i]), 's', new ItemStack(stickItem, 1, toolMeta[i]));
            addShapedRecipeFirst(recipes, new ItemStack(tools[i][4], 1, 0), "##", " s", " s", '#', new ItemStack(planks, 1, toolMeta[i]), 's', new ItemStack(stickItem, 1, toolMeta[i]));
            addShapedRecipeFirst(recipes, new ItemStack(tools[i][5], 1, 0), "#s ", "# s", "#s ", '#', new ItemStack(Item.silk), 's', new ItemStack(stickItem, 1, toolMeta[i]));
        }
        
        GameRegistry.addRecipe(new ItemStack(netherquartzSword, 1, 0), "#", "#", "s", '#', new ItemStack(Block.blockNetherQuartz, 1, Short.MAX_VALUE), 's', new ItemStack(stickItem, 1, 2));
        GameRegistry.addRecipe(new ItemStack(netherquartzPickaxe, 1, 0), "###", " s ", " s ", '#',new ItemStack(Block.blockNetherQuartz, 1, Short.MAX_VALUE), 's', new ItemStack(stickItem, 1, 2));
        GameRegistry.addRecipe(new ItemStack(netherquartzShovel, 1, 0), "#", "s", "s", '#', new ItemStack(Block.blockNetherQuartz, 1, Short.MAX_VALUE), 's', new ItemStack(stickItem, 1, 2));
        GameRegistry.addRecipe(new ItemStack(netherquartzAxe, 1, 0), "##", "#s", " s", '#', new ItemStack(Block.blockNetherQuartz, 1, Short.MAX_VALUE), 's', new ItemStack(stickItem, 1, 2));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.swordWood, 1, 0), "##", "#s", " s", 's', new ItemStack(stickItem, 1, Short.MAX_VALUE), '#', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.pickaxeWood, 1, 0), "##", "#s", " s", 's', new ItemStack(stickItem, 1, Short.MAX_VALUE), '#', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.shovelWood, 1, 0), "##", "#s", " s", 's', new ItemStack(stickItem, 1, Short.MAX_VALUE), '#', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.axeWood, 1, 0), "##", "#s", " s", 's', new ItemStack(stickItem, 1, Short.MAX_VALUE), '#', "plankWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.hoeWood, 1, 0), "##", "#s", " s", 's', new ItemStack(stickItem, 1, Short.MAX_VALUE), '#', "plankWood"));
        
        for (int i = 0; i < BowlEmpty.textureNames.length; i++)
        {
            if (!(BowlEmpty.textureNames[i].equals("")))
            {
                addShapedRecipeFirst(recipes, new ItemStack(bowlEmpty, 4, i), "# #", " # ", '#', new ItemStack(planks, 1, i));
                GameRegistry.addShapelessRecipe(new ItemStack(bowlStew, 1, i+1), new ItemStack(bowlEmpty, 1, i), new ItemStack(Block.mushroomBrown), new ItemStack(Block.mushroomRed));
                GameRegistry.addShapelessRecipe(new ItemStack(bowlStew, 1, i+15), new ItemStack(bowlEmpty, 1, i), new ItemStack(glowshroom, 1, 0), new ItemStack(glowshroom, 1, 1), new ItemStack(glowshroom, 1, 2));
            }
        }
        
        addShapelessRecipeFirst(recipes, new ItemStack(bowlStew, 1, 0), new ItemStack(Block.mushroomBrown), new ItemStack(Block.mushroomRed), new ItemStack(Item.bowlEmpty));
        GameRegistry.addShapelessRecipe(new ItemStack(bowlStew, 1, 14), new ItemStack(glowshroom, 1, 0), new ItemStack(glowshroom, 1, 1), new ItemStack(glowshroom, 1, 2), new ItemStack(Item.bowlEmpty));
        
        /*bowlEmpty = new BowlEmpty(PHNatura.bowlEmpty).setUnlocalizedName("natura.emptybowl");
        bowlStew = new BowlStew(PHNatura.bowlStew).setUnlocalizedName("natura.stewbowl");*/
        
        //Turn logs into charcoal
        FurnaceRecipes.smelting().addSmelting(tree.blockID, 0, new ItemStack(Item.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().addSmelting(tree.blockID, 1, new ItemStack(Item.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().addSmelting(tree.blockID, 2, new ItemStack(Item.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().addSmelting(tree.blockID, 3, new ItemStack(Item.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().addSmelting(redwood.blockID, 0, new ItemStack(Item.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().addSmelting(redwood.blockID, 1, new ItemStack(Item.coal, 1, 1), 0.15f);
        FurnaceRecipes.smelting().addSmelting(redwood.blockID, 2, new ItemStack(Item.coal, 1, 1), 0.15f);
    }

    public void addShapedRecipeFirst (List recipeList, ItemStack itemstack, Object... objArray)
    {
        String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        if (objArray[var4] instanceof String[])
        {
            String[] var7 = (String[]) ((String[]) objArray[var4++]);

            for (int var8 = 0; var8 < var7.length; ++var8)
            {
                String var9 = var7[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        }
        else
        {
            while (objArray[var4] instanceof String)
            {
                String var11 = (String) objArray[var4++];
                ++var6;
                var5 = var11.length();
                var3 = var3 + var11;
            }
        }

        HashMap var12;

        for (var12 = new HashMap(); var4 < objArray.length; var4 += 2)
        {
            Character var13 = (Character) objArray[var4];
            ItemStack var14 = null;

            if (objArray[var4 + 1] instanceof Item)
            {
                var14 = new ItemStack((Item) objArray[var4 + 1]);
            }
            else if (objArray[var4 + 1] instanceof Block)
            {
                var14 = new ItemStack((Block) objArray[var4 + 1], 1, Short.MAX_VALUE);
            }
            else if (objArray[var4 + 1] instanceof ItemStack)
            {
                var14 = (ItemStack) objArray[var4 + 1];
            }

            var12.put(var13, var14);
        }

        ItemStack[] var15 = new ItemStack[var5 * var6];

        for (int var16 = 0; var16 < var5 * var6; ++var16)
        {
            char var10 = var3.charAt(var16);

            if (var12.containsKey(Character.valueOf(var10)))
            {
                var15[var16] = ((ItemStack) var12.get(Character.valueOf(var10))).copy();
            }
            else
            {
                var15[var16] = null;
            }
        }

        ShapedRecipes var17 = new ShapedRecipes(var5, var6, var15, itemstack);
        recipeList.add(0, var17);
    }
    
    public void addShapelessRecipeFirst(List recipeList, ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        recipeList.add(0, new ShapelessRecipes(par1ItemStack, arraylist));
    }

    public void addLoot ()
    {
        //ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(VanityBlocksStorage.StorageBlock,0,0),3,5,6));
    }
    
    public void intermodCommunication()
    {
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(berryBush, 1, 12));
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(berryBush, 1, 13));
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(berryBush, 1, 14));
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(berryBush, 1, 15));
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(netherBerryBush, 1, 12));
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(netherBerryBush, 1, 13));
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(netherBerryBush, 1, 14));
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(netherBerryBush, 1, 15));
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(crops, 1, 8));

        StringBuilder builder = new StringBuilder();
        String string = builder.append("farmBarley@").append(seeds.itemID).append(".0.").append(crops.blockID).append(".3").toString();
        FMLInterModComms.sendMessage("Forestry", "add-farmable-crop", string);
        string = builder.append("farmCotton@").append(seeds.itemID).append(".1.").append(crops.blockID).append(".8").toString();
        FMLInterModComms.sendMessage("Forestry", "add-farmable-crop", string);
    }

    public void addOredictSupport ()
    {
        OreDictionary.registerOre("cropRaspberry", new ItemStack(berryItem, 1, 0));
        OreDictionary.registerOre("cropBlueberry", new ItemStack(berryItem, 1, 1));
        OreDictionary.registerOre("cropBlackberry", new ItemStack(berryItem, 1, 2));
        OreDictionary.registerOre("cropMaloberry", new ItemStack(berryItem, 1, 3));

        OreDictionary.registerOre("cropBlightberry", new ItemStack(netherBerryItem, 1, 0));
        OreDictionary.registerOre("cropDuskberry", new ItemStack(netherBerryItem, 1, 1));
        OreDictionary.registerOre("cropSkyberry", new ItemStack(netherBerryItem, 1, 2));
        OreDictionary.registerOre("cropStingberry", new ItemStack(netherBerryItem, 1, 3));
    }

    //Crops
    public static Item wheatBag;
    public static Item barleyBag;
    public static Item potatoBag;
    public static Item carrotBag;
    public static Item netherWartBag;
    public static Item cottonBag;
    public static Item boneBag;

    public static Item seeds;
    public static Item plantItem;
    public static Item netherBerryItem;
    public static Item berryItem;
    public static Item berryMedley;
    public static Item seedFood;

    public static Item waterDrop;

    public static CropBlock crops;
    public static BerryBush berryBush;
    public static NetherBerryBush netherBerryBush;

    public static Block baseHerb;
    public static Block bloodyHerb;
    public static Block manaHerb;
    public static Block whiteHerb;
    public static Block poisonHerb;
    public static Block leafyHerb;
    public static Block orangeHerb;

    //Others
    public static Block cloud;
    public static Block ivy;
    public static Block flower;

    //Trees    
    public static Block tree;
    public static Block redwood;
    public static Block planks;
    public static Block bloodwood;
    public static Block netherAir;
    public static Block willow;

    public static NLeaves floraLeaves;
    public static NLeaves floraLeavesNoColor;
    public static NSaplingBlock floraSapling;

    public static Block saguaro;

    public static Block redwoodDoor;
    public static Block eucalyptusDoor;
    public static Block hopseedDoor;
    public static Block sakuraDoor;
    public static Block ghostDoor;
    public static Block bloodDoor;
    public static Block redwoodBarkDoor;

    public static Item doorItem;
    //public static Item floraBoat;

    //Nether
    public static Block taintedSoil;
    public static Block heatSand;
    //public static Block infernalStone;
    public static Glowshroom glowshroom;
    public static Block darkTree;
    public static NLeaves darkLeaves;
    public static Block thornVines;

    public static Block glowshroomBlue;
    public static Block glowshroomGreen;
    public static Block glowshroomPurple;

    public static Item potashApple;
    
    //Tools
    public static Item ghostwoodSword;
    public static Item ghostwoodPickaxe;
    public static Item ghostwoodShovel;
    public static Item ghostwoodAxe;
    public static Item bloodwoodSword;
    public static Item bloodwoodPickaxe;
    public static Item bloodwoodShovel;
    public static Item bloodwoodAxe;
    public static Item darkwoodSword;
    public static Item darkwoodPickaxe;
    public static Item darkwoodShovel;
    public static Item darkwoodAxe;
    public static Item fusewoodSword;
    public static Item fusewoodPickaxe;
    public static Item fusewoodShovel;
    public static Item fusewoodAxe;
    public static Item netherquartzSword;
    public static Item netherquartzPickaxe;
    public static Item netherquartzShovel;
    public static Item netherquartzAxe;

    public static Item ghostwoodKama;
    public static Item bloodwoodKama;
    public static Item darkwoodKama;
    public static Item fusewoodKama;
    public static Item netherquartzKama;
    
    public static Item ghostwoodBow;
    public static Item bloodwoodBow;
    public static Item darkwoodBow;
    public static Item fusewoodBow;

    //Extra overworld
    public static Block rareTree;
    public static NLeaves rareLeaves;
    public static OverworldSapling rareSapling;
    public static Block bluebells;
    
    public static Item stickItem;
    public static Item bowlEmpty;
    public static Item bowlStew;

    //Vanilla overrides and alternates
    public static final String woodTextureNames[] = { "eucalyptus", "sakura", "ghostwood", "redwood", "bloodwood", "hopseed", "maple", "silverbell", "purpleheart", "tiger", "willow", "darkwood",
            "fusewood" };
    public static Block alternateWorkbench;
    public static Block alternateBookshelf;
    public static Block alternateFence;
}
