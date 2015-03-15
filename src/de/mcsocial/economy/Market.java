package de.mcsocial.economy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Material;

import de.mcsocial.main.MySQL;

public class Market {

	private static Double priceGOLD_ORE = 500.00;
	private static Double priceACACIA_DOOR= 500.00;
	private static Double priceACACIA_DOOR_ITEM= 500.00;
	private static Double priceACACIA_FENCE= 500.00;
	private static Double priceACACIA_FENCE_GATE= 500.00;
	private static Double priceACACIA_STAIRS= 500.00;
	private static Double priceACTIVATOR_RAIL= 500200.00;
	private static Double priceANVIL= 500.00;
	private static Double priceAPPLE= 500.00;
	private static Double priceARMOR_STAND= 500.00;
	private static Double priceARROW= 500.00;
	private static Double priceBAKED_POTATO= 500.00;
	private static Double priceBANNER= 500.00;
	private static Double priceBARRIER= 500.00;
	private static Double priceBEACON= 500.00;
	private static Double priceBED= 500.00;
	private static Double priceBEDROCK= 500.00;
	private static Double priceBED_BLOCK= 500.00;
	private static Double priceBIRCH_DOOR= 500.00;
	private static Double priceBIRCH_DOOR_ITEM= 500.00;
	private static Double priceBIRCH_FENCE= 500.00;
	private static Double priceBIRCH_FENCE_GATE= 500.00;
	private static Double priceBIRCH_WOOD_STAIRS= 500.00;
	private static Double priceBLAZE_POWDER= 500.00;
	private static Double priceBLAZE_ROD= 500.00;
	private static Double priceBOAT= 500.00;
	private static Double priceBONE= 500.00;
	private static Double priceBOOK= 500.00;
	private static Double priceBOOKSHELF= 500.00;
	private static Double priceBOOK_AND_QUILL= 500.00;
	private static Double priceBOW= 500.00;
	private static Double priceBOWL= 500.00;
	private static Double priceBREAD= 500.00;
	private static Double priceBREWING_STAND= 500.00;
	private static Double priceBREWING_STAND_ITEM= 500.00;
	private static Double priceBRICK= 500.00;
	private static Double priceBRICK_STAIRS= 500.00;
	private static Double priceBROWN_MUSHROOM= 500.00;
	private static Double priceBUCKET= 500.00;
	private static Double priceBURNING_FURNACE= 500.00;
	private static Double priceCACTUS= 500.00;
	private static Double priceCAKE= 500.00;
	private static Double priceCAKE_BLOCK= 500.00;
	private static Double priceCARPET= 500.00;
	private static Double priceCARROT= 500.00;
	private static Double priceCARROT_ITEM= 500.00;
	private static Double priceCARROT_STICK= 500.00;
	private static Double priceCAULDRON= 500.00;
	private static Double priceCAULDRON_ITEM= 500.00;
	private static Double priceCHAINMAIL_BOOTS= 500.00;
	private static Double priceCHAINMAIL_CHESTPLATE= 500.00;
	private static Double priceCHAINMAIL_HELMET= 500.00;
	private static Double priceCHAINMAIL_LEGGINGS= 500.00;
	private static Double priceCHEST= 500.00;
	private static Double priceCLAY= 500.00;
	private static Double priceCLAY_BALL= 500.00;
	private static Double priceCLAY_BRICK= 500.00;
	private static Double priceCOAL= 500.00;
	private static Double priceCOAL_BLOCK= 500.00;
	private static Double priceCOAL_ORE= 500.00;
	private static Double priceCOBBLESTONE= 500.00;
	private static Double priceCOBBLESTONE_STAIRS= 500.00;
	private static Double priceCOBBLE_WALL= 500.00;
	private static Double priceCOCOA= 500.00;
	private static Double priceCOMMAND= 500.00;
	private static Double priceCOMMAND_MINECART= 500.00;
	private static Double priceCOMPASS= 500.00;
	private static Double priceCOOKED_BEEF= 500.00;
	private static Double priceCOOKED_CHICKEN= 500.00;
	private static Double priceCOOKED_FISH= 500.00;
	private static Double priceCOOKED_MUTTON= 500.00;
	private static Double priceCOOKED_RABBIT= 500.00;
	private static Double priceCOOKIE= 500.00;
	private static Double priceCROPS= 500.00;
	private static Double priceDARK_OAK_DOOR= 500.00;
	private static Double priceDARK_OAK_DOOR_ITEM= 500.00;
	private static Double priceDARK_OAK_FENCE= 500.00;
	private static Double priceDARK_OAK_FENCE_GATE= 500.00;
	private static Double priceDARK_OAK_STAIRS= 500.00;
	private static Double priceDAYLIGHT_DETECTOR= 500.00;
	private static Double priceDAYLIGHT_DETECTOR_INVERTED= 500.00;
	private static Double priceDEAD_BUSH= 500.00;
	private static Double priceDETECTOR_RAIL= 500.00;
	private static Double priceDIAMOND= 500.00;
	private static Double priceDIAMOND_AXE= 500.00;
	private static Double priceDIAMOND_BARDING= 500.00;
	private static Double priceDIAMOND_BLOCK= 500.00;
	private static Double priceDIAMOND_BOOTS= 500.00;
	private static Double priceDIAMOND_CHESTPLATE= 500.00;
	private static Double priceDIAMOND_HELMET= 500.00;
	private static Double priceDIAMOND_HOE= 500.00;
	private static Double priceDIAMOND_LEGGINGS= 500.00;
	private static Double priceDIAMOND_ORE= 500.00;
	private static Double priceDIAMOND_PICKAXE= 500.00;
	private static Double priceDIAMOND_SPADE= 500.00;
	private static Double priceDIAMOND_SWORD= 500.00;
	private static Double priceDIODE= 500.00;
	private static Double priceDIODE_BLOCK_OFF= 500.00;
	private static Double priceDIODE_BLOCK_ON= 500.00;
	private static Double priceDIRT= 500.00;
	private static Double priceDISPENSER= 500.00;
	private static Double priceDOUBLE_PLANT= 500.00;
	private static Double priceDOUBLE_STEP= 500.00;
	private static Double priceDOUBLE_STONE_SLAB2= 500.00;
	private static Double priceDRAGON_EGG= 500.00;
	private static Double priceDROPPER= 500.00;
	private static Double priceEGG= 500.00;
	private static Double priceEMERALD= 500.00;
	private static Double priceEMERALD_BLOCK= 500.00;
	private static Double priceEMERALD_ORE= 500.00;
	private static Double priceEMPTY_MAP= 500.00;
	private static Double priceENCHANTED_BOOK= 500.00;
	private static Double priceENCHANTMENT_TABLE= 500.00;
	private static Double priceENDER_CHEST= 500.00;
	private static Double priceENDER_PEARL= 500.00;
	private static Double priceENDER_PORTAL= 500.00;
	private static Double priceENDER_PORTAL_FRAME= 500.00;
	private static Double priceENDER_STONE= 500.00;
	private static Double priceEXPLOSIVE_MINECART= 500.00;
	private static Double priceEXP_BOTTLE= 500.00;
	private static Double priceEYE_OF_ENDER= 500.00;
	private static Double priceFEATHER= 500.00;
	private static Double priceFENCE= 500.00;
	private static Double priceFENCE_GATE= 500.00;
	private static Double priceFERMENTED_SPIDER_EYE= 500.00;
	private static Double priceFIRE= 500.00;
	private static Double priceFIREBALL= 500.00;
	private static Double priceFIREWORK= 500.00;
	private static Double priceFIREWORK_CHARGE= 500.00;
	private static Double priceFISHING_ROD= 500.00;
	private static Double priceFLINT= 500.00;
	private static Double priceFLINT_AND_STEEL= 500.00;
	private static Double priceFLOWER_POT= 500.00;
	private static Double priceFLOWER_POT_ITEM= 500.00;
	private static Double priceFURNACE= 500.00;
	private static Double priceGHAST_TEAR= 500.00;
	private static Double priceGLASS= 500.00;
	private static Double priceGLASS_BOTTLE= 500.00;
	private static Double priceGLOWING_REDSTONE_ORE= 500.00;
	private static Double priceGLOWSTONE= 500.00;
	private static Double priceGLOWSTONE_DUST= 500.00;
	private static Double priceGOLDEN_APPLE= 500.00;
	private static Double priceGOLDEN_CARROT= 500.00;
	private static Double priceGOLD_AXE= 500.00;
	private static Double priceGOLD_BARDING= 500.00;
	private static Double priceGOLD_BLOCK= 500.00;
	private static Double priceGOLD_BOOTS= 500.00;
	private static Double priceGOLD_CHESTPLATE= 500.00;
	private static Double priceGOLD_HELMET= 500.00;
	private static Double priceGOLD_HOE= 500.00;
	private static Double priceGOLD_INGOT= 500.00;
	private static Double priceGOLD_LEGGINGS= 500.00;
	private static Double priceGOLD_NUGGET= 500.00;
	private static Double priceGOLD_PICKAXE= 500.00;
	private static Double priceGOLD_PLATE= 500.00;
	private static Double priceGOLD_RECORD= 500.00;
	private static Double priceGOLD_SPADE= 500.00;
	private static Double priceGOLD_SWORD= 500.00;
	private static Double priceGRASS= 500.00;
	private static Double priceGRAVEL= 500.00;
	private static Double priceGREEN_RECORD= 500.00;
	private static Double priceGRILLED_PORK= 500.00;
	private static Double priceHARD_CLAY= 500.00;
	private static Double priceHAY_BLOCK= 500.00;
	private static Double priceHOPPER= 500.00;
	private static Double priceHOPPER_MINECART= 500.00;
	private static Double priceHUGE_MUSHROOM_1= 500.00;
	private static Double priceHUGE_MUSHROOM_2= 500.00;
	private static Double priceICE= 500.00;
	private static Double priceINK_SACK= 500.00;
	private static Double priceIRON_AXE= 500.00;
	private static Double priceIRON_BARDING= 500.00;
	private static Double priceIRON_BLOCK= 500.00;
	private static Double priceIRON_BOOTS= 500.00;
	private static Double priceIRON_CHESTPLATE= 500.00;
	private static Double priceIRON_DOOR= 500.00;
	private static Double priceIRON_DOOR_BLOCK= 500.00;
	private static Double priceIRON_FENCE= 500.00;
	private static Double priceIRON_HELMET= 500.00;
	private static Double priceIRON_HOE= 500.00;
	private static Double priceIRON_INGOT= 500.00;
	private static Double priceIRON_LEGGINGS= 500.00;
	private static Double priceIRON_ORE= 500.00;
	private static Double priceIRON_PICKAXE= 500.00;
	private static Double priceIRON_PLATE= 500.00;
	private static Double priceIRON_SPADE= 500.00;
	private static Double priceIRON_SWORD= 500.00;
	private static Double priceIRON_TRAPDOOR= 500.00;
	private static Double priceITEM_FRAME= 500.00;
	private static Double priceJACK_O_LANTERN= 500.00;
	private static Double priceJUKEBOX= 500.00;
	private static Double priceJUNGLE_DOOR= 500.00;
	private static Double priceJUNGLE_DOOR_ITEM= 500.00;
	private static Double priceJUNGLE_FENCE= 500.00;
	private static Double priceJUNGLE_FENCE_GATE= 500.00;
	private static Double priceJUNGLE_WOOD_STAIRS= 500.00;
	private static Double priceLADDER= 500.00;
	private static Double priceLAPIS_BLOCK= 500.00;
	private static Double priceLAPIS_ORE= 500.00;
	private static Double priceLAVA= 500.00;
	private static Double priceLAVA_BUCKET= 500.00;
	private static Double priceLEASH= 500.00;
	private static Double priceLEATHER= 500.00;
	private static Double priceLEATHER_BOOTS= 500.00;
	private static Double priceLEATHER_CHESTPLATE= 500.00;
	private static Double priceLEATHER_HELMET= 500.00;
	private static Double priceLEATHER_LEGGINGS= 500.00;
	private static Double priceLEAVES= 500.00;
	private static Double priceLEAVES_2= 500.00;
	private static Double priceLEVER= 500.00;
	private static Double priceLOG= 500.00;
	private static Double priceLOG_2= 500.00;
	private static Double priceLONG_GRASS= 500.00;
	private static Double priceMAGMA_CREAM= 500.00;
	private static Double priceMAP= 500.00;
	private static Double priceMELON= 500.00;
	private static Double priceMELON_BLOCK= 500.00;
	private static Double priceMELON_SEEDS= 500.00;
	private static Double priceMELON_STEM= 500.00;
	private static Double priceMILK_BUCKET= 500.00;
	private static Double priceMINECART= 500.00;
	private static Double priceMOB_SPAWNER= 500.00;
	private static Double priceMONSTER_EGG= 500.00;
	private static Double priceMONSTER_EGGS= 500.00;
	private static Double priceMOSSY_COBBLESTONE= 500.00;
	private static Double priceMUSHROOM_SOUP= 500.00;
	private static Double priceMUTTON= 500.00;
	private static Double priceMYCEL= 500.00;
	private static Double priceNAME_TAG= 500.00;
	private static Double priceNETHERRACK= 500.00;
	private static Double priceNETHER_BRICK= 500.00;
	private static Double priceNETHER_BRICK_ITEM= 500.00;
	private static Double priceNETHER_BRICK_STAIRS= 500.00;
	private static Double priceNETHER_FENCE= 500.00;
	private static Double priceNETHER_STALK= 500.00;
	private static Double priceNETHER_STAR= 500.00;
	private static Double priceNETHER_WARTS= 500.00;
	private static Double priceNOTE_BLOCK= 500.00;
	private static Double priceOBSIDIAN= 500.00;
	private static Double pricePACKED_ICE= 500.00;
	private static Double pricePAINTING= 500.00;
	private static Double pricePAPER= 500.00;
	private static Double pricePISTON_BASE= 500.00;
	private static Double pricePISTON_EXTENSION= 500.00;
	private static Double pricePISTON_MOVING_PIECE= 500.00;
	private static Double pricePISTON_STICKY_BASE= 500.00;
	private static Double pricePOISONOUS_POTATO= 500.00;
	private static Double pricePORK= 500.00;
	private static Double pricePORTAL= 500.00;
	private static Double pricePOTATO= 500.00;
	private static Double pricePOTATO_ITEM= 500.00;
	private static Double pricePOTION= 500.00;
	private static Double pricePOWERED_MINECART= 500.00;
	private static Double pricePOWERED_RAIL= 500.00;
	private static Double pricePRISMARINE= 500.00;
	private static Double pricePRISMARINE_CRYSTALS= 500.00;
	private static Double pricePRISMARINE_SHARD= 500.00;
	private static Double pricePUMPKIN= 500.00;
	private static Double pricePUMPKIN_PIE= 500.00;
	private static Double pricePUMPKIN_SEEDS= 500.00;
	private static Double pricePUMPKIN_STEM= 500.00;
	private static Double priceQUARTZ= 500.00;
	private static Double priceQUARTZ_BLOCK= 500.00;
	private static Double priceQUARTZ_ORE= 500.00;
	private static Double priceQUARTZ_STAIRS= 500.00;
	private static Double priceRABBIT= 500.00;
	private static Double priceRABBIT_FOOT= 500.00;
	private static Double priceRABBIT_HIDE= 500.00;
	private static Double priceRABBIT_STEW= 500.00;
	private static Double priceRAILS= 500.00;
	private static Double priceRAW_BEEF= 500.00;
	private static Double priceRAW_CHICKEN= 500.00;
	private static Double priceRAW_FISH= 500.00;
	private static Double priceRECORD_10= 500.00;
	private static Double priceRECORD_11= 500.00;
	private static Double priceRECORD_12= 500.00;
	private static Double priceRECORD_3= 500.00;
	private static Double priceRECORD_4= 500.00;
	private static Double priceRECORD_5= 500.00;
	private static Double priceRECORD_6= 500.00;
	private static Double priceRECORD_7= 500.00;
	private static Double priceRECORD_8= 500.00;
	private static Double priceRECORD_9= 500.00;
	private static Double priceREDSTONE= 500.00;
	private static Double priceREDSTONE_BLOCK= 500.00;
	private static Double priceREDSTONE_COMPARATOR= 500.00;
	private static Double priceREDSTONE_COMPARATOR_OFF= 500.00;
	private static Double priceREDSTONE_COMPARATOR_ON= 500.00;
	private static Double priceREDSTONE_LAMP_OFF= 500.00;
	private static Double priceREDSTONE_LAMP_ON= 500.00;
	private static Double priceREDSTONE_ORE= 500.00;
	private static Double priceREDSTONE_TORCH_OFF= 500.00;
	private static Double priceREDSTONE_TORCH_ON= 500.00;
	private static Double priceREDSTONE_WIRE= 500.00;
	private static Double priceRED_MUSHROOM= 500.00;
	private static Double priceRED_ROSE= 500.00;
	private static Double priceRED_SANDSTONE= 500.00;
	private static Double priceRED_SANDSTONE_STAIRS= 500.00;
	private static Double priceROTTEN_FLESH= 500.00;
	private static Double priceSADDLE= 500.00;
	private static Double priceSAND= 500.00;
	private static Double priceSANDSTONE= 500.00;
	private static Double priceSANDSTONE_STAIRS= 500.00;
	private static Double priceSAPLING= 500.00;
	private static Double priceSEA_LANTERN= 500.00;
	private static Double priceSEEDS= 500.00;
	private static Double priceSHEARS= 500.00;
	private static Double priceSIGN= 500.00;
	private static Double priceSIGN_POST= 500.00;
	private static Double priceSKULL= 500.00;
	private static Double priceSKULL_ITEM= 500.00;
	private static Double priceSLIME_BALL= 500.00;
	private static Double priceSLIME_BLOCK= 500.00;
	private static Double priceSMOOTH_BRICK= 500.00;
	private static Double priceSMOOTH_STAIRS= 500.00;
	private static Double priceSNOW= 500.00;
	private static Double priceSNOW_BALL= 500.00;
	private static Double priceSNOW_BLOCK= 500.00;
	private static Double priceSOIL= 500.00;
	private static Double priceSOUL_SAND= 500.00;
	private static Double priceSPECKLED_MELON= 500.00;
	private static Double priceSPIDER_EYE= 500.00;
	private static Double priceSPONGE= 500.00;
	private static Double priceSPRUCE_DOOR= 500.00;
	private static Double priceSPRUCE_DOOR_ITEM= 500.00;
	private static Double priceSPRUCE_FENCE= 500.00;
	private static Double priceSPRUCE_FENCE_GATE= 500.00;
	private static Double priceSPRUCE_WOOD_STAIRS= 500.00;
	private static Double priceSTAINED_CLAY= 500.00;
	private static Double priceSTAINED_GLASS= 500.00;
	private static Double priceSTAINED_GLASS_PANE= 500.00;
	private static Double priceSTANDING_BANNER= 500.00;
	private static Double priceSTATIONARY_LAVA= 500.00;
	private static Double priceSTATIONARY_WATER= 500.00;
	private static Double priceSTEP= 500.00;
	private static Double priceSTICK= 500.00;
	private static Double priceSTONE= 500.00;
	private static Double priceSTONE_AXE= 500.00;
	private static Double priceSTONE_BUTTON= 500.00;
	private static Double priceSTONE_HOE= 500.00;
	private static Double priceSTONE_PICKAXE= 500.00;
	private static Double priceSTONE_PLATE= 500.00;
	private static Double priceSTONE_SLAB2= 500.00;
	private static Double priceSTONE_SPADE= 500.00;
	private static Double priceSTONE_SWORD= 500.00;
	private static Double priceSTORAGE_MINECART= 500.00;
	private static Double priceSTRING= 500.00;
	private static Double priceSUGAR= 500.00;
	private static Double priceSUGAR_CANE= 500.00;
	private static Double priceSUGAR_CANE_BLOCK= 500.00;
	private static Double priceSULPHUR= 500.00;
	private static Double priceTHIN_GLASS= 500.00;
	private static Double priceTNT= 500.00;
	private static Double priceTORCH= 500.00;
	private static Double priceTRAPPED_CHEST= 500.00;
	private static Double priceTRAP_DOOR= 500.00;
	private static Double priceTRIPWIRE= 500.00;
	private static Double priceTRIPWIRE_HOOK= 500.00;
	private static Double priceVINE= 500.00;
	private static Double priceWALL_BANNER= 500.00;
	private static Double priceWALL_SIGN= 500.00;
	private static Double priceWATCH= 500.00;
	private static Double priceWATER= 500.00;
	private static Double priceWATER_BUCKET= 500.00;
	private static Double priceWATER_LILY= 500.00;
	private static Double priceWEB= 500.00;
	private static Double priceWHEAT= 500.00;
	private static Double priceWOOD= 500.00;
	private static Double priceWOODEN_DOOR= 500.00;
	private static Double priceWOOD_AXE= 500.00;
	private static Double priceWOOD_BUTTON= 500.00;
	private static Double priceWOOD_DOOR= 500.00;
	private static Double priceWOOD_DOUBLE_STEP= 500.00;
	private static Double priceWOOD_HOE= 500.00;
	private static Double priceWOOD_PICKAXE= 500.00;
	private static Double priceWOOD_PLATE= 500.00;
	private static Double priceWOOD_SPADE= 500.00;
	private static Double priceWOOD_STAIRS= 500.00;
	private static Double priceWOOD_STEP= 500.00;
	private static Double priceWOOD_SWORD= 500.00;
	private static Double priceWOOL= 500.00;
	private static Double priceWORKBENCH= 500.00;
	private static Double priceWRITTEN_BOOK= 500.00;
	private static Double priceYELLOW_FLOWER= 500.00;
	
	public static Double getPrice(Material item){
		
		switch(item){
		case GOLD_ORE :
			return priceGOLD_ORE;
		case ACACIA_DOOR:
			return priceACACIA_DOOR;
		case ACACIA_DOOR_ITEM:
			return priceACACIA_DOOR_ITEM;
		case ACACIA_FENCE:
			return priceACACIA_FENCE;
		case ACACIA_FENCE_GATE:
			return priceACACIA_FENCE_GATE;
		case ACACIA_STAIRS:
			return priceACACIA_STAIRS;
		case ACTIVATOR_RAIL:
			return priceACTIVATOR_RAIL;
		case ANVIL:
			return priceANVIL;
		case APPLE:
			return priceAPPLE;
		case ARMOR_STAND:
			return priceARMOR_STAND;
		case ARROW:
			return priceARROW;
		case BAKED_POTATO:
			return priceBAKED_POTATO;
		case BANNER:
			return priceBANNER;
		case BARRIER:
			return priceBARRIER;
		case BEACON:
			return priceBEACON;
		case BED:
			return priceBED;
		case BEDROCK:
			return priceBEDROCK;
		case BED_BLOCK:
			return priceBED_BLOCK;
		case BIRCH_DOOR:
			return priceBIRCH_DOOR;
		case BIRCH_DOOR_ITEM:
			return priceBIRCH_DOOR_ITEM;
		case BIRCH_FENCE:
			return priceBIRCH_FENCE;
		case BIRCH_FENCE_GATE:
			return priceBIRCH_FENCE_GATE;
		case BIRCH_WOOD_STAIRS:
			return priceBIRCH_WOOD_STAIRS;
		case BLAZE_POWDER:
			return priceBLAZE_POWDER;
		case BLAZE_ROD:
			return priceBLAZE_ROD;
		case BOAT:
			return priceBOAT;
		case BONE:
			return priceBONE;
		case BOOK:
			return priceBOOK;
		case BOOKSHELF:
			return priceBOOKSHELF;
		case BOOK_AND_QUILL:
			return priceBOOK_AND_QUILL;
		case BOW:
			return priceBOW;
		case BOWL:
			return priceBOWL;
		case BREAD:
			return priceBREAD;
		case BREWING_STAND:
			return priceBREWING_STAND;
		case BREWING_STAND_ITEM:
			return priceBREWING_STAND_ITEM;
		case BRICK:
			return priceBRICK;
		case BRICK_STAIRS:
			return priceBRICK_STAIRS;
		case BROWN_MUSHROOM:
			return priceBROWN_MUSHROOM;
		case BUCKET:
			return priceBUCKET;
		case BURNING_FURNACE:
			return priceBURNING_FURNACE;
		case CACTUS:
			return priceCACTUS;
		case CAKE:
			return priceCAKE;
		case CAKE_BLOCK:
			return priceCAKE_BLOCK;
		case CARPET:
			return priceCARPET;
		case CARROT:
			return priceCARROT;
		case CARROT_ITEM:
			return priceCARROT_ITEM;
		case CARROT_STICK:
			return priceCARROT_STICK;
		case CAULDRON:
			return priceCAULDRON;
		case CAULDRON_ITEM:
			return priceCAULDRON_ITEM;
		case CHAINMAIL_BOOTS:
			return priceCHAINMAIL_BOOTS;
		case CHAINMAIL_CHESTPLATE:
			return priceCHAINMAIL_CHESTPLATE;
		case CHAINMAIL_HELMET:
			return priceCHAINMAIL_HELMET;
		case CHAINMAIL_LEGGINGS:
			return priceCHAINMAIL_LEGGINGS;
		case CHEST:
			return priceCHEST;
		case CLAY:
			return priceCLAY;
		case CLAY_BALL:
			return priceCLAY_BALL;
		case CLAY_BRICK:
			return priceCLAY_BRICK;
		case COAL:
			return priceCOAL;
		case COAL_BLOCK:
			return priceCOAL_BLOCK;
		case COAL_ORE:
			return priceCOAL_ORE;
		case COBBLESTONE:
			return priceCOBBLESTONE;
		case COBBLESTONE_STAIRS:
			return priceCOBBLESTONE_STAIRS;
		case COBBLE_WALL:
			return priceCOBBLE_WALL;
		case COCOA:
			return priceCOCOA;
		case COMMAND:
			return priceCOMMAND;
		case COMMAND_MINECART:
			return priceCOMMAND_MINECART;
		case COMPASS:
			return priceCOMPASS;
		case COOKED_BEEF:
			return priceCOOKED_BEEF;
		case COOKED_CHICKEN:
			return priceCOOKED_CHICKEN;
		case COOKED_FISH:
			return priceCOOKED_FISH;
		case COOKED_MUTTON:
			return priceCOOKED_MUTTON;
		case COOKED_RABBIT:
			return priceCOOKED_RABBIT;
		case COOKIE:
			return priceCOOKIE;
		case CROPS:
			return priceCROPS;
		case DARK_OAK_DOOR:
			return priceDARK_OAK_DOOR;
		case DARK_OAK_DOOR_ITEM:
			return priceDARK_OAK_DOOR_ITEM;
		case DARK_OAK_FENCE:
			return priceDARK_OAK_FENCE;
		case DARK_OAK_FENCE_GATE:
			return priceDARK_OAK_FENCE_GATE;
		case DARK_OAK_STAIRS:
			return priceDARK_OAK_STAIRS;
		case DAYLIGHT_DETECTOR:
			return priceDAYLIGHT_DETECTOR;
		case DAYLIGHT_DETECTOR_INVERTED:
			return priceDAYLIGHT_DETECTOR_INVERTED;
		case DEAD_BUSH:
			return priceDEAD_BUSH;
		case DETECTOR_RAIL:
			return priceDETECTOR_RAIL;
		case DIAMOND:
			return priceDIAMOND;
		case DIAMOND_AXE:
			return priceDIAMOND_AXE;
		case DIAMOND_BARDING:
			return priceDIAMOND_BARDING;
		case DIAMOND_BLOCK:
			return priceDIAMOND_BLOCK;
		case DIAMOND_BOOTS:
			return priceDIAMOND_BOOTS;
		case DIAMOND_CHESTPLATE:
			return priceDIAMOND_CHESTPLATE;
		case DIAMOND_HELMET:
			return priceDIAMOND_HELMET;
		case DIAMOND_HOE:
			return priceDIAMOND_HOE;
		case DIAMOND_LEGGINGS:
			return priceDIAMOND_LEGGINGS;
		case DIAMOND_ORE:
			return priceDIAMOND_ORE;
		case DIAMOND_PICKAXE:
			return priceDIAMOND_PICKAXE;
		case DIAMOND_SPADE:
			return priceDIAMOND_SPADE;
		case DIAMOND_SWORD:
			return priceDIAMOND_SWORD;
		case DIODE:
			return priceDIODE;
		case DIODE_BLOCK_OFF:
			return priceDIODE_BLOCK_OFF;
		case DIODE_BLOCK_ON:
			return priceDIODE_BLOCK_ON;
		case DIRT:
			return priceDIRT;
		case DISPENSER:
			return priceDISPENSER;
		case DOUBLE_PLANT:
			return priceDOUBLE_PLANT;
		case DOUBLE_STEP:
			return priceDOUBLE_STEP;
		case DOUBLE_STONE_SLAB2:
			return priceDOUBLE_STONE_SLAB2;
		case DRAGON_EGG:
			return priceDRAGON_EGG;
		case DROPPER:
			return priceDROPPER;
		case EGG:
			return priceEGG;
		case EMERALD:
			return priceEMERALD;
		case EMERALD_BLOCK:
			return priceEMERALD_BLOCK;
		case EMERALD_ORE:
			return priceEMERALD_ORE;
		case EMPTY_MAP:
			return priceEMPTY_MAP;
		case ENCHANTED_BOOK:
			return priceENCHANTED_BOOK;
		case ENCHANTMENT_TABLE:
			return priceENCHANTMENT_TABLE;
		case ENDER_CHEST:
			return priceENDER_CHEST;
		case ENDER_PEARL:
			return priceENDER_PEARL;
		case ENDER_PORTAL:
			return priceENDER_PORTAL;
		case ENDER_PORTAL_FRAME:
			return priceENDER_PORTAL_FRAME;
		case ENDER_STONE:
			return priceENDER_STONE;
		case EXPLOSIVE_MINECART:
			return priceEXPLOSIVE_MINECART;
		case EXP_BOTTLE:
			return priceEXP_BOTTLE;
		case EYE_OF_ENDER:
			return priceEYE_OF_ENDER;
		case FEATHER:
			return priceFEATHER;
		case FENCE:
			return priceFENCE;
		case FENCE_GATE:
			return priceFENCE_GATE;
		case FERMENTED_SPIDER_EYE:
			return priceFERMENTED_SPIDER_EYE;
		case FIRE:
			return priceFIRE;
		case FIREBALL:
			return priceFIREBALL;
		case FIREWORK:
			return priceFIREWORK;
		case FIREWORK_CHARGE:
			return priceFIREWORK_CHARGE;
		case FISHING_ROD:
			return priceFISHING_ROD;
		case FLINT:
			return priceFLINT;
		case FLINT_AND_STEEL:
			return priceFLINT_AND_STEEL;
		case FLOWER_POT:
			return priceFLOWER_POT;
		case FLOWER_POT_ITEM:
			return priceFLOWER_POT_ITEM;
		case FURNACE:
			return priceFURNACE;
		case GHAST_TEAR:
			return priceGHAST_TEAR;
		case GLASS:
			return priceGLASS;
		case GLASS_BOTTLE:
			return priceGLASS_BOTTLE;
		case GLOWING_REDSTONE_ORE:
			return priceGLOWING_REDSTONE_ORE;
		case GLOWSTONE:
			return priceGLOWSTONE;
		case GLOWSTONE_DUST:
			return priceGLOWSTONE_DUST;
		case GOLDEN_APPLE:
			return priceGOLDEN_APPLE;
		case GOLDEN_CARROT:
			return priceGOLDEN_CARROT;
		case GOLD_AXE:
			return priceGOLD_AXE;
		case GOLD_BARDING:
			return priceGOLD_BARDING;
		case GOLD_BLOCK:
			return priceGOLD_BLOCK;
		case GOLD_BOOTS:
			return priceGOLD_BOOTS;
		case GOLD_CHESTPLATE:
			return priceGOLD_CHESTPLATE;
		case GOLD_HELMET:
			return priceGOLD_HELMET;
		case GOLD_HOE:
			return priceGOLD_HOE;
		case GOLD_INGOT:
			return priceGOLD_INGOT;
		case GOLD_LEGGINGS:
			return priceGOLD_LEGGINGS;
		case GOLD_NUGGET:
			return priceGOLD_NUGGET;
		case GOLD_PICKAXE:
			return priceGOLD_PICKAXE;
		case GOLD_PLATE:
			return priceGOLD_PLATE;
		case GOLD_RECORD:
			return priceGOLD_RECORD;
		case GOLD_SPADE:
			return priceGOLD_SPADE;
		case GOLD_SWORD:
			return priceGOLD_SWORD;
		case GRASS:
			return priceGRASS;
		case GRAVEL:
			return priceGRAVEL;
		case GREEN_RECORD:
			return priceGREEN_RECORD;
		case GRILLED_PORK:
			return priceGRILLED_PORK;
		case HARD_CLAY:
			return priceHARD_CLAY;
		case HAY_BLOCK:
			return priceHAY_BLOCK;
		case HOPPER:
			return priceHOPPER;
		case HOPPER_MINECART:
			return priceHOPPER_MINECART;
		case HUGE_MUSHROOM_1:
			return priceHUGE_MUSHROOM_1;
		case HUGE_MUSHROOM_2:
			return priceHUGE_MUSHROOM_2;
		case ICE:
			return priceICE;
		case INK_SACK:
			return priceINK_SACK;
		case IRON_AXE:
			return priceIRON_AXE;
		case IRON_BARDING:
			return priceIRON_BARDING;
		case IRON_BLOCK:
			return priceIRON_BLOCK;
		case IRON_BOOTS:
			return priceIRON_BOOTS;
		case IRON_CHESTPLATE:
			return priceIRON_CHESTPLATE;
		case IRON_DOOR:
			return priceIRON_DOOR;
		case IRON_DOOR_BLOCK:
			return priceIRON_DOOR_BLOCK;
		case IRON_FENCE:
			return priceIRON_FENCE;
		case IRON_HELMET:
			return priceIRON_HELMET;
		case IRON_HOE:
			return priceIRON_HOE;
		case IRON_INGOT:
			return priceIRON_INGOT;
		case IRON_LEGGINGS:
			return priceIRON_LEGGINGS;
		case IRON_ORE:
			return priceIRON_ORE;
		case IRON_PICKAXE:
			return priceIRON_PICKAXE;
		case IRON_PLATE:
			return priceIRON_PLATE;
		case IRON_SPADE:
			return priceIRON_SPADE;
		case IRON_SWORD:
			return priceIRON_SWORD;
		case IRON_TRAPDOOR:
			return priceIRON_TRAPDOOR;
		case ITEM_FRAME:
			return priceITEM_FRAME;
		case JACK_O_LANTERN:
			return priceJACK_O_LANTERN;
		case JUKEBOX:
			return priceJUKEBOX;
		case JUNGLE_DOOR:
			return priceJUNGLE_DOOR;
		case JUNGLE_DOOR_ITEM:
			return priceJUNGLE_DOOR_ITEM;
		case JUNGLE_FENCE:
			return priceJUNGLE_FENCE;
		case JUNGLE_FENCE_GATE:
			return priceJUNGLE_FENCE_GATE;
		case JUNGLE_WOOD_STAIRS:
			return priceJUNGLE_WOOD_STAIRS;
		case LADDER:
			return priceLADDER;
		case LAPIS_BLOCK:
			return priceLAPIS_BLOCK;
		case LAPIS_ORE:
			return priceLAPIS_ORE;
		case LAVA:
			return priceLAVA;
		case LAVA_BUCKET:
			return priceLAVA_BUCKET;
		case LEASH:
			return priceLEASH;
		case LEATHER:
			return priceLEATHER;
		case LEATHER_BOOTS:
			return priceLEATHER_BOOTS;
		case LEATHER_CHESTPLATE:
			return priceLEATHER_CHESTPLATE;
		case LEATHER_HELMET:
			return priceLEATHER_HELMET;
		case LEATHER_LEGGINGS:
			return priceLEATHER_LEGGINGS;
		case LEAVES:
			return priceLEAVES;
		case LEAVES_2:
			return priceLEAVES_2;
		case LEVER:
			return priceLEVER;
		case LOG:
			return priceLOG;
		case LOG_2:
			return priceLOG_2;
		case LONG_GRASS:
			return priceLONG_GRASS;
		case MAGMA_CREAM:
			return priceMAGMA_CREAM;
		case MAP:
			return priceMAP;
		case MELON:
			return priceMELON;
		case MELON_BLOCK:
			return priceMELON_BLOCK;
		case MELON_SEEDS:
			return priceMELON_SEEDS;
		case MELON_STEM:
			return priceMELON_STEM;
		case MILK_BUCKET:
			return priceMILK_BUCKET;
		case MINECART:
			return priceMINECART;
		case MOB_SPAWNER:
			return priceMOB_SPAWNER;
		case MONSTER_EGG:
			return priceMONSTER_EGG;
		case MONSTER_EGGS:
			return priceMONSTER_EGGS;
		case MOSSY_COBBLESTONE:
			return priceMOSSY_COBBLESTONE;
		case MUSHROOM_SOUP:
			return priceMUSHROOM_SOUP;
		case MUTTON:
			return priceMUTTON;
		case MYCEL:
			return priceMYCEL;
		case NAME_TAG:
			return priceNAME_TAG;
		case NETHERRACK:
			return priceNETHERRACK;
		case NETHER_BRICK:
			return priceNETHER_BRICK;
		case NETHER_BRICK_ITEM:
			return priceNETHER_BRICK_ITEM;
		case NETHER_BRICK_STAIRS:
			return priceNETHER_BRICK_STAIRS;
		case NETHER_FENCE:
			return priceNETHER_FENCE;
		case NETHER_STALK:
			return priceNETHER_STALK;
		case NETHER_STAR:
			return priceNETHER_STAR;
		case NETHER_WARTS:
			return priceNETHER_WARTS;
		case NOTE_BLOCK:
			return priceNOTE_BLOCK;
		case OBSIDIAN:
			return priceOBSIDIAN;
		case PACKED_ICE:
			return pricePACKED_ICE;
		case PAINTING:
			return pricePAINTING;
		case PAPER:
			return pricePAPER;
		case PISTON_BASE:
			return pricePISTON_BASE;
		case PISTON_EXTENSION:
			return pricePISTON_EXTENSION;
		case PISTON_MOVING_PIECE:
			return pricePISTON_MOVING_PIECE;
		case PISTON_STICKY_BASE:
			return pricePISTON_STICKY_BASE;
		case POISONOUS_POTATO:
			return pricePOISONOUS_POTATO;
		case PORK:
			return pricePORK;
		case PORTAL:
			return pricePORTAL;
		case POTATO:
			return pricePOTATO;
		case POTATO_ITEM:
			return pricePOTATO_ITEM;
		case POTION:
			return pricePOTION;
		case POWERED_MINECART:
			return pricePOWERED_MINECART;
		case POWERED_RAIL:
			return pricePOWERED_RAIL;
		case PRISMARINE:
			return pricePRISMARINE;
		case PRISMARINE_CRYSTALS:
			return pricePRISMARINE_CRYSTALS;
		case PRISMARINE_SHARD:
			return pricePRISMARINE_SHARD;
		case PUMPKIN:
			return pricePUMPKIN;
		case PUMPKIN_PIE:
			return pricePUMPKIN_PIE;
		case PUMPKIN_SEEDS:
			return pricePUMPKIN_SEEDS;
		case PUMPKIN_STEM:
			return pricePUMPKIN_STEM;
		case QUARTZ:
			return priceQUARTZ;
		case QUARTZ_BLOCK:
			return priceQUARTZ_BLOCK;
		case QUARTZ_ORE:
			return priceQUARTZ_ORE;
		case QUARTZ_STAIRS:
			return priceQUARTZ_STAIRS;
		case RABBIT:
			return priceRABBIT;
		case RABBIT_FOOT:
			return priceRABBIT_FOOT;
		case RABBIT_HIDE:
			return priceRABBIT_HIDE;
		case RABBIT_STEW:
			return priceRABBIT_STEW;
		case RAILS:
			return priceRAILS;
		case RAW_BEEF:
			return priceRAW_BEEF;
		case RAW_CHICKEN:
			return priceRAW_CHICKEN;
		case RAW_FISH:
			return priceRAW_FISH;
		case RECORD_10:
			return priceRECORD_10;
		case RECORD_11:
			return priceRECORD_11;
		case RECORD_12:
			return priceRECORD_12;
		case RECORD_3:
			return priceRECORD_3;
		case RECORD_4:
			return priceRECORD_4;
		case RECORD_5:
			return priceRECORD_5;
		case RECORD_6:
			return priceRECORD_6;
		case RECORD_7:
			return priceRECORD_7;
		case RECORD_8:
			return priceRECORD_8;
		case RECORD_9:
			return priceRECORD_9;
		case REDSTONE:
			return priceREDSTONE;
		case REDSTONE_BLOCK:
			return priceREDSTONE_BLOCK;
		case REDSTONE_COMPARATOR:
			return priceREDSTONE_COMPARATOR;
		case REDSTONE_COMPARATOR_OFF:
			return priceREDSTONE_COMPARATOR_OFF;
		case REDSTONE_COMPARATOR_ON:
			return priceREDSTONE_COMPARATOR_ON;
		case REDSTONE_LAMP_OFF:
			return priceREDSTONE_LAMP_OFF;
		case REDSTONE_LAMP_ON:
			return priceREDSTONE_LAMP_ON;
		case REDSTONE_ORE:
			return priceREDSTONE_ORE;
		case REDSTONE_TORCH_OFF:
			return priceREDSTONE_TORCH_OFF;
		case REDSTONE_TORCH_ON:
			return priceREDSTONE_TORCH_ON;
		case REDSTONE_WIRE:
			return priceREDSTONE_WIRE;
		case RED_MUSHROOM:
			return priceRED_MUSHROOM;
		case RED_ROSE:
			return priceRED_ROSE;
		case RED_SANDSTONE:
			return priceRED_SANDSTONE;
		case RED_SANDSTONE_STAIRS:
			return priceRED_SANDSTONE_STAIRS;
		case ROTTEN_FLESH:
			return priceROTTEN_FLESH;
		case SADDLE:
			return priceSADDLE;
		case SAND:
			return priceSAND;
		case SANDSTONE:
			return priceSANDSTONE;
		case SANDSTONE_STAIRS:
			return priceSANDSTONE_STAIRS;
		case SAPLING:
			return priceSAPLING;
		case SEA_LANTERN:
			return priceSEA_LANTERN;
		case SEEDS:
			return priceSEEDS;
		case SHEARS:
			return priceSHEARS;
		case SIGN:
			return priceSIGN;
		case SIGN_POST:
			return priceSIGN_POST;
		case SKULL:
			return priceSKULL;
		case SKULL_ITEM:
			return priceSKULL_ITEM;
		case SLIME_BALL:
			return priceSLIME_BALL;
		case SLIME_BLOCK:
			return priceSLIME_BLOCK;
		case SMOOTH_BRICK:
			return priceSMOOTH_BRICK;
		case SMOOTH_STAIRS:
			return priceSMOOTH_STAIRS;
		case SNOW:
			return priceSNOW;
		case SNOW_BALL:
			return priceSNOW_BALL;
		case SNOW_BLOCK:
			return priceSNOW_BLOCK;
		case SOIL:
			return priceSOIL;
		case SOUL_SAND:
			return priceSOUL_SAND;
		case SPECKLED_MELON:
			return priceSPECKLED_MELON;
		case SPIDER_EYE:
			return priceSPIDER_EYE;
		case SPONGE:
			return priceSPONGE;
		case SPRUCE_DOOR:
			return priceSPRUCE_DOOR;
		case SPRUCE_DOOR_ITEM:
			return priceSPRUCE_DOOR_ITEM;
		case SPRUCE_FENCE:
			return priceSPRUCE_FENCE;
		case SPRUCE_FENCE_GATE:
			return priceSPRUCE_FENCE_GATE;
		case SPRUCE_WOOD_STAIRS:
			return priceSPRUCE_WOOD_STAIRS;
		case STAINED_CLAY:
			return priceSTAINED_CLAY;
		case STAINED_GLASS:
			return priceSTAINED_GLASS;
		case STAINED_GLASS_PANE:
			return priceSTAINED_GLASS_PANE;
		case STANDING_BANNER:
			return priceSTANDING_BANNER;
		case STATIONARY_LAVA:
			return priceSTATIONARY_LAVA;
		case STATIONARY_WATER:
			return priceSTATIONARY_WATER;
		case STEP:
			return priceSTEP;
		case STICK:
			return priceSTICK;
		case STONE:
			return priceSTONE;
		case STONE_AXE:
			return priceSTONE_AXE;
		case STONE_BUTTON:
			return priceSTONE_BUTTON;
		case STONE_HOE:
			return priceSTONE_HOE;
		case STONE_PICKAXE:
			return priceSTONE_PICKAXE;
		case STONE_PLATE:
			return priceSTONE_PLATE;
		case STONE_SLAB2:
			return priceSTONE_SLAB2;
		case STONE_SPADE:
			return priceSTONE_SPADE;
		case STONE_SWORD:
			return priceSTONE_SWORD;
		case STORAGE_MINECART:
			return priceSTORAGE_MINECART;
		case STRING:
			return priceSTRING;
		case SUGAR:
			return priceSUGAR;
		case SUGAR_CANE:
			return priceSUGAR_CANE;
		case SUGAR_CANE_BLOCK:
			return priceSUGAR_CANE_BLOCK;
		case SULPHUR:
			return priceSULPHUR;
		case THIN_GLASS:
			return priceTHIN_GLASS;
		case TNT:
			return priceTNT;
		case TORCH:
			return priceTORCH;
		case TRAPPED_CHEST:
			return priceTRAPPED_CHEST;
		case TRAP_DOOR:
			return priceTRAP_DOOR;
		case TRIPWIRE:
			return priceTRIPWIRE;
		case TRIPWIRE_HOOK:
			return priceTRIPWIRE_HOOK;
		case VINE:
			return priceVINE;
		case WALL_BANNER:
			return priceWALL_BANNER;
		case WALL_SIGN:
			return priceWALL_SIGN;
		case WATCH:
			return priceWATCH;
		case WATER:
			return priceWATER;
		case WATER_BUCKET:
			return priceWATER_BUCKET;
		case WATER_LILY:
			return priceWATER_LILY;
		case WEB:
			return priceWEB;
		case WHEAT:
			return priceWHEAT;
		case WOOD:
			return priceWOOD;
		case WOODEN_DOOR:
			return priceWOODEN_DOOR;
		case WOOD_AXE:
			return priceWOOD_AXE;
		case WOOD_BUTTON:
			return priceWOOD_BUTTON;
		case WOOD_DOOR:
			return priceWOOD_DOOR;
		case WOOD_DOUBLE_STEP:
			return priceWOOD_DOUBLE_STEP;
		case WOOD_HOE:
			return priceWOOD_HOE;
		case WOOD_PICKAXE:
			return priceWOOD_PICKAXE;
		case WOOD_PLATE:
			return priceWOOD_PLATE;
		case WOOD_SPADE:
			return priceWOOD_SPADE;
		case WOOD_STAIRS:
			return priceWOOD_STAIRS;
		case WOOD_STEP:
			return priceWOOD_STEP;
		case WOOD_SWORD:
			return priceWOOD_SWORD;
		case WOOL:
			return priceWOOL;
		case WORKBENCH:
			return priceWORKBENCH;
		case WRITTEN_BOOK:
			return priceWRITTEN_BOOK;
		case YELLOW_FLOWER:
			return priceYELLOW_FLOWER;
		default:
			return 0.00;
		}

	}
	
@SuppressWarnings("incomplete-switch")
	public static void setPrice(Material item, Double price){
		
		switch(item){
		case GOLD_ORE :
			priceGOLD_ORE=price;
		case ACACIA_DOOR:
			priceACACIA_DOOR=price;
		case ACACIA_DOOR_ITEM:
			priceACACIA_DOOR_ITEM=price;
		case ACACIA_FENCE:
			priceACACIA_FENCE=price;
		case ACACIA_FENCE_GATE:
			priceACACIA_FENCE_GATE=price;
		case ACACIA_STAIRS:
			priceACACIA_STAIRS=price;
		case ACTIVATOR_RAIL:
			priceACTIVATOR_RAIL=price;
		case ANVIL:
			priceANVIL=price;
		case APPLE:
			priceAPPLE=price;
		case ARMOR_STAND:
			priceARMOR_STAND=price;
		case ARROW:
			priceARROW=price;
		case BAKED_POTATO:
			priceBAKED_POTATO=price;
		case BANNER:
			priceBANNER=price;
		case BARRIER:
			priceBARRIER=price;
		case BEACON:
			priceBEACON=price;
		case BED:
			priceBED=price;
		case BEDROCK:
			priceBEDROCK=price;
		case BED_BLOCK:
			priceBED_BLOCK=price;
		case BIRCH_DOOR:
			priceBIRCH_DOOR=price;
		case BIRCH_DOOR_ITEM:
			priceBIRCH_DOOR_ITEM=price;
		case BIRCH_FENCE:
			priceBIRCH_FENCE=price;
		case BIRCH_FENCE_GATE:
			priceBIRCH_FENCE_GATE=price;
		case BIRCH_WOOD_STAIRS:
			priceBIRCH_WOOD_STAIRS=price;
		case BLAZE_POWDER:
			priceBLAZE_POWDER=price;
		case BLAZE_ROD:
			priceBLAZE_ROD=price;
		case BOAT:
			priceBOAT=price;
		case BONE:
			priceBONE=price;
		case BOOK:
			priceBOOK=price;
		case BOOKSHELF:
			priceBOOKSHELF=price;
		case BOOK_AND_QUILL:
			priceBOOK_AND_QUILL=price;
		case BOW:
			priceBOW=price;
		case BOWL:
			priceBOWL=price;
		case BREAD:
			priceBREAD=price;
		case BREWING_STAND:
			priceBREWING_STAND=price;
		case BREWING_STAND_ITEM:
			priceBREWING_STAND_ITEM=price;
		case BRICK:
			priceBRICK=price;
		case BRICK_STAIRS:
			priceBRICK_STAIRS=price;
		case BROWN_MUSHROOM:
			priceBROWN_MUSHROOM=price;
		case BUCKET:
			priceBUCKET=price;
		case BURNING_FURNACE:
			priceBURNING_FURNACE=price;
		case CACTUS:
			priceCACTUS=price;
		case CAKE:
			priceCAKE=price;
		case CAKE_BLOCK:
			priceCAKE_BLOCK=price;
		case CARPET:
			priceCARPET=price;
		case CARROT:
			priceCARROT=price;
		case CARROT_ITEM:
			priceCARROT_ITEM=price;
		case CARROT_STICK:
			priceCARROT_STICK=price;
		case CAULDRON:
			priceCAULDRON=price;
		case CAULDRON_ITEM:
			priceCAULDRON_ITEM=price;
		case CHAINMAIL_BOOTS:
			priceCHAINMAIL_BOOTS=price;
		case CHAINMAIL_CHESTPLATE:
			priceCHAINMAIL_CHESTPLATE=price;
		case CHAINMAIL_HELMET:
			priceCHAINMAIL_HELMET=price;
		case CHAINMAIL_LEGGINGS:
			priceCHAINMAIL_LEGGINGS=price;
		case CHEST:
			priceCHEST=price;
		case CLAY:
			priceCLAY=price;
		case CLAY_BALL:
			priceCLAY_BALL=price;
		case CLAY_BRICK:
			priceCLAY_BRICK=price;
		case COAL:
			priceCOAL=price;
		case COAL_BLOCK:
			priceCOAL_BLOCK=price;
		case COAL_ORE:
			priceCOAL_ORE=price;
		case COBBLESTONE:
			priceCOBBLESTONE=price;
		case COBBLESTONE_STAIRS:
			priceCOBBLESTONE_STAIRS=price;
		case COBBLE_WALL:
			priceCOBBLE_WALL=price;
		case COCOA:
			priceCOCOA=price;
		case COMMAND:
			priceCOMMAND=price;
		case COMMAND_MINECART:
			priceCOMMAND_MINECART=price;
		case COMPASS:
			priceCOMPASS=price;
		case COOKED_BEEF:
			priceCOOKED_BEEF=price;
		case COOKED_CHICKEN:
			priceCOOKED_CHICKEN=price;
		case COOKED_FISH:
			priceCOOKED_FISH=price;
		case COOKED_MUTTON:
			priceCOOKED_MUTTON=price;
		case COOKED_RABBIT:
			priceCOOKED_RABBIT=price;
		case COOKIE:
			priceCOOKIE=price;
		case CROPS:
			priceCROPS=price;
		case DARK_OAK_DOOR:
			priceDARK_OAK_DOOR=price;
		case DARK_OAK_DOOR_ITEM:
			priceDARK_OAK_DOOR_ITEM=price;
		case DARK_OAK_FENCE:
			priceDARK_OAK_FENCE=price;
		case DARK_OAK_FENCE_GATE:
			priceDARK_OAK_FENCE_GATE=price;
		case DARK_OAK_STAIRS:
			priceDARK_OAK_STAIRS=price;
		case DAYLIGHT_DETECTOR:
			priceDAYLIGHT_DETECTOR=price;
		case DAYLIGHT_DETECTOR_INVERTED:
			priceDAYLIGHT_DETECTOR_INVERTED=price;
		case DEAD_BUSH:
			priceDEAD_BUSH=price;
		case DETECTOR_RAIL:
			priceDETECTOR_RAIL=price;
		case DIAMOND:
			priceDIAMOND=price;
		case DIAMOND_AXE:
			priceDIAMOND_AXE=price;
		case DIAMOND_BARDING:
			priceDIAMOND_BARDING=price;
		case DIAMOND_BLOCK:
			priceDIAMOND_BLOCK=price;
		case DIAMOND_BOOTS:
			priceDIAMOND_BOOTS=price;
		case DIAMOND_CHESTPLATE:
			priceDIAMOND_CHESTPLATE=price;
		case DIAMOND_HELMET:
			priceDIAMOND_HELMET=price;
		case DIAMOND_HOE:
			priceDIAMOND_HOE=price;
		case DIAMOND_LEGGINGS:
			priceDIAMOND_LEGGINGS=price;
		case DIAMOND_ORE:
			priceDIAMOND_ORE=price;
		case DIAMOND_PICKAXE:
			priceDIAMOND_PICKAXE=price;
		case DIAMOND_SPADE:
			priceDIAMOND_SPADE=price;
		case DIAMOND_SWORD:
			priceDIAMOND_SWORD=price;
		case DIODE:
			priceDIODE=price;
		case DIODE_BLOCK_OFF:
			priceDIODE_BLOCK_OFF=price;
		case DIODE_BLOCK_ON:
			priceDIODE_BLOCK_ON=price;
		case DIRT:
			priceDIRT=price;
		case DISPENSER:
			priceDISPENSER=price;
		case DOUBLE_PLANT:
			priceDOUBLE_PLANT=price;
		case DOUBLE_STEP:
			priceDOUBLE_STEP=price;
		case DOUBLE_STONE_SLAB2:
			priceDOUBLE_STONE_SLAB2=price;
		case DRAGON_EGG:
			priceDRAGON_EGG=price;
		case DROPPER:
			priceDROPPER=price;
		case EGG:
			priceEGG=price;
		case EMERALD:
			priceEMERALD=price;
		case EMERALD_BLOCK:
			priceEMERALD_BLOCK=price;
		case EMERALD_ORE:
			priceEMERALD_ORE=price;
		case EMPTY_MAP:
			priceEMPTY_MAP=price;
		case ENCHANTED_BOOK:
			priceENCHANTED_BOOK=price;
		case ENCHANTMENT_TABLE:
			priceENCHANTMENT_TABLE=price;
		case ENDER_CHEST:
			priceENDER_CHEST=price;
		case ENDER_PEARL:
			priceENDER_PEARL=price;
		case ENDER_PORTAL:
			priceENDER_PORTAL=price;
		case ENDER_PORTAL_FRAME:
			priceENDER_PORTAL_FRAME=price;
		case ENDER_STONE:
			priceENDER_STONE=price;
		case EXPLOSIVE_MINECART:
			priceEXPLOSIVE_MINECART=price;
		case EXP_BOTTLE:
			priceEXP_BOTTLE=price;
		case EYE_OF_ENDER:
			priceEYE_OF_ENDER=price;
		case FEATHER:
			priceFEATHER=price;
		case FENCE:
			priceFENCE=price;
		case FENCE_GATE:
			priceFENCE_GATE=price;
		case FERMENTED_SPIDER_EYE:
			priceFERMENTED_SPIDER_EYE=price;
		case FIRE:
			priceFIRE=price;
		case FIREBALL:
			priceFIREBALL=price;
		case FIREWORK:
			priceFIREWORK=price;
		case FIREWORK_CHARGE:
			priceFIREWORK_CHARGE=price;
		case FISHING_ROD:
			priceFISHING_ROD=price;
		case FLINT:
			priceFLINT=price;
		case FLINT_AND_STEEL:
			priceFLINT_AND_STEEL=price;
		case FLOWER_POT:
			priceFLOWER_POT=price;
		case FLOWER_POT_ITEM:
			priceFLOWER_POT_ITEM=price;
		case FURNACE:
			priceFURNACE=price;
		case GHAST_TEAR:
			priceGHAST_TEAR=price;
		case GLASS:
			priceGLASS=price;
		case GLASS_BOTTLE:
			priceGLASS_BOTTLE=price;
		case GLOWING_REDSTONE_ORE:
			priceGLOWING_REDSTONE_ORE=price;
		case GLOWSTONE:
			priceGLOWSTONE=price;
		case GLOWSTONE_DUST:
			priceGLOWSTONE_DUST=price;
		case GOLDEN_APPLE:
			priceGOLDEN_APPLE=price;
		case GOLDEN_CARROT:
			priceGOLDEN_CARROT=price;
		case GOLD_AXE:
			priceGOLD_AXE=price;
		case GOLD_BARDING:
			priceGOLD_BARDING=price;
		case GOLD_BLOCK:
			priceGOLD_BLOCK=price;
		case GOLD_BOOTS:
			priceGOLD_BOOTS=price;
		case GOLD_CHESTPLATE:
			priceGOLD_CHESTPLATE=price;
		case GOLD_HELMET:
			priceGOLD_HELMET=price;
		case GOLD_HOE:
			priceGOLD_HOE=price;
		case GOLD_INGOT:
			priceGOLD_INGOT=price;
		case GOLD_LEGGINGS:
			priceGOLD_LEGGINGS=price;
		case GOLD_NUGGET:
			priceGOLD_NUGGET=price;
		case GOLD_PICKAXE:
			priceGOLD_PICKAXE=price;
		case GOLD_PLATE:
			priceGOLD_PLATE=price;
		case GOLD_RECORD:
			priceGOLD_RECORD=price;
		case GOLD_SPADE:
			priceGOLD_SPADE=price;
		case GOLD_SWORD:
			priceGOLD_SWORD=price;
		case GRASS:
			priceGRASS=price;
		case GRAVEL:
			priceGRAVEL=price;
		case GREEN_RECORD:
			priceGREEN_RECORD=price;
		case GRILLED_PORK:
			priceGRILLED_PORK=price;
		case HARD_CLAY:
			priceHARD_CLAY=price;
		case HAY_BLOCK:
			priceHAY_BLOCK=price;
		case HOPPER:
			priceHOPPER=price;
		case HOPPER_MINECART:
			priceHOPPER_MINECART=price;
		case HUGE_MUSHROOM_1:
			priceHUGE_MUSHROOM_1=price;
		case HUGE_MUSHROOM_2:
			priceHUGE_MUSHROOM_2=price;
		case ICE:
			priceICE=price;
		case INK_SACK:
			priceINK_SACK=price;
		case IRON_AXE:
			priceIRON_AXE=price;
		case IRON_BARDING:
			priceIRON_BARDING=price;
		case IRON_BLOCK:
			priceIRON_BLOCK=price;
		case IRON_BOOTS:
			priceIRON_BOOTS=price;
		case IRON_CHESTPLATE:
			priceIRON_CHESTPLATE=price;
		case IRON_DOOR:
			priceIRON_DOOR=price;
		case IRON_DOOR_BLOCK:
			priceIRON_DOOR_BLOCK=price;
		case IRON_FENCE:
			priceIRON_FENCE=price;
		case IRON_HELMET:
			priceIRON_HELMET=price;
		case IRON_HOE:
			priceIRON_HOE=price;
		case IRON_INGOT:
			priceIRON_INGOT=price;
		case IRON_LEGGINGS:
			priceIRON_LEGGINGS=price;
		case IRON_ORE:
			priceIRON_ORE=price;
		case IRON_PICKAXE:
			priceIRON_PICKAXE=price;
		case IRON_PLATE:
			priceIRON_PLATE=price;
		case IRON_SPADE:
			priceIRON_SPADE=price;
		case IRON_SWORD:
			priceIRON_SWORD=price;
		case IRON_TRAPDOOR:
			priceIRON_TRAPDOOR=price;
		case ITEM_FRAME:
			priceITEM_FRAME=price;
		case JACK_O_LANTERN:
			priceJACK_O_LANTERN=price;
		case JUKEBOX:
			priceJUKEBOX=price;
		case JUNGLE_DOOR:
			priceJUNGLE_DOOR=price;
		case JUNGLE_DOOR_ITEM:
			priceJUNGLE_DOOR_ITEM=price;
		case JUNGLE_FENCE:
			priceJUNGLE_FENCE=price;
		case JUNGLE_FENCE_GATE:
			priceJUNGLE_FENCE_GATE=price;
		case JUNGLE_WOOD_STAIRS:
			priceJUNGLE_WOOD_STAIRS=price;
		case LADDER:
			priceLADDER=price;
		case LAPIS_BLOCK:
			priceLAPIS_BLOCK=price;
		case LAPIS_ORE:
			priceLAPIS_ORE=price;
		case LAVA:
			priceLAVA=price;
		case LAVA_BUCKET:
			priceLAVA_BUCKET=price;
		case LEASH:
			priceLEASH=price;
		case LEATHER:
			priceLEATHER=price;
		case LEATHER_BOOTS:
			priceLEATHER_BOOTS=price;
		case LEATHER_CHESTPLATE:
			priceLEATHER_CHESTPLATE=price;
		case LEATHER_HELMET:
			priceLEATHER_HELMET=price;
		case LEATHER_LEGGINGS:
			priceLEATHER_LEGGINGS=price;
		case LEAVES:
			priceLEAVES=price;
		case LEAVES_2:
			priceLEAVES_2=price;
		case LEVER:
			priceLEVER=price;
		case LOG:
			priceLOG=price;
		case LOG_2:
			priceLOG_2=price;
		case LONG_GRASS:
			priceLONG_GRASS=price;
		case MAGMA_CREAM:
			priceMAGMA_CREAM=price;
		case MAP:
			priceMAP=price;
		case MELON:
			priceMELON=price;
		case MELON_BLOCK:
			priceMELON_BLOCK=price;
		case MELON_SEEDS:
			priceMELON_SEEDS=price;
		case MELON_STEM:
			priceMELON_STEM=price;
		case MILK_BUCKET:
			priceMILK_BUCKET=price;
		case MINECART:
			priceMINECART=price;
		case MOB_SPAWNER:
			priceMOB_SPAWNER=price;
		case MONSTER_EGG:
			priceMONSTER_EGG=price;
		case MONSTER_EGGS:
			priceMONSTER_EGGS=price;
		case MOSSY_COBBLESTONE:
			priceMOSSY_COBBLESTONE=price;
		case MUSHROOM_SOUP:
			priceMUSHROOM_SOUP=price;
		case MUTTON:
			priceMUTTON=price;
		case MYCEL:
			priceMYCEL=price;
		case NAME_TAG:
			priceNAME_TAG=price;
		case NETHERRACK:
			priceNETHERRACK=price;
		case NETHER_BRICK:
			priceNETHER_BRICK=price;
		case NETHER_BRICK_ITEM:
			priceNETHER_BRICK_ITEM=price;
		case NETHER_BRICK_STAIRS:
			priceNETHER_BRICK_STAIRS=price;
		case NETHER_FENCE:
			priceNETHER_FENCE=price;
		case NETHER_STALK:
			priceNETHER_STALK=price;
		case NETHER_STAR:
			priceNETHER_STAR=price;
		case NETHER_WARTS:
			priceNETHER_WARTS=price;
		case NOTE_BLOCK:
			priceNOTE_BLOCK=price;
		case OBSIDIAN:
			priceOBSIDIAN=price;
		case PACKED_ICE:
			pricePACKED_ICE=price;
		case PAINTING:
			pricePAINTING=price;
		case PAPER:
			pricePAPER=price;
		case PISTON_BASE:
			pricePISTON_BASE=price;
		case PISTON_EXTENSION:
			pricePISTON_EXTENSION=price;
		case PISTON_MOVING_PIECE:
			pricePISTON_MOVING_PIECE=price;
		case PISTON_STICKY_BASE:
			pricePISTON_STICKY_BASE=price;
		case POISONOUS_POTATO:
			pricePOISONOUS_POTATO=price;
		case PORK:
			pricePORK=price;
		case PORTAL:
			pricePORTAL=price;
		case POTATO:
			pricePOTATO=price;
		case POTATO_ITEM:
			pricePOTATO_ITEM=price;
		case POTION:
			pricePOTION=price;
		case POWERED_MINECART:
			pricePOWERED_MINECART=price;
		case POWERED_RAIL:
			pricePOWERED_RAIL=price;
		case PRISMARINE:
			pricePRISMARINE=price;
		case PRISMARINE_CRYSTALS:
			pricePRISMARINE_CRYSTALS=price;
		case PRISMARINE_SHARD:
			pricePRISMARINE_SHARD=price;
		case PUMPKIN:
			pricePUMPKIN=price;
		case PUMPKIN_PIE:
			pricePUMPKIN_PIE=price;
		case PUMPKIN_SEEDS:
			pricePUMPKIN_SEEDS=price;
		case PUMPKIN_STEM:
			pricePUMPKIN_STEM=price;
		case QUARTZ:
			priceQUARTZ=price;
		case QUARTZ_BLOCK:
			priceQUARTZ_BLOCK=price;
		case QUARTZ_ORE:
			priceQUARTZ_ORE=price;
		case QUARTZ_STAIRS:
			priceQUARTZ_STAIRS=price;
		case RABBIT:
			priceRABBIT=price;
		case RABBIT_FOOT:
			priceRABBIT_FOOT=price;
		case RABBIT_HIDE:
			priceRABBIT_HIDE=price;
		case RABBIT_STEW:
			priceRABBIT_STEW=price;
		case RAILS:
			priceRAILS=price;
		case RAW_BEEF:
			priceRAW_BEEF=price;
		case RAW_CHICKEN:
			priceRAW_CHICKEN=price;
		case RAW_FISH:
			priceRAW_FISH=price;
		case RECORD_10:
			priceRECORD_10=price;
		case RECORD_11:
			priceRECORD_11=price;
		case RECORD_12:
			priceRECORD_12=price;
		case RECORD_3:
			priceRECORD_3=price;
		case RECORD_4:
			priceRECORD_4=price;
		case RECORD_5:
			priceRECORD_5=price;
		case RECORD_6:
			priceRECORD_6=price;
		case RECORD_7:
			priceRECORD_7=price;
		case RECORD_8:
			priceRECORD_8=price;
		case RECORD_9:
			priceRECORD_9=price;
		case REDSTONE:
			priceREDSTONE=price;
		case REDSTONE_BLOCK:
			priceREDSTONE_BLOCK=price;
		case REDSTONE_COMPARATOR:
			priceREDSTONE_COMPARATOR=price;
		case REDSTONE_COMPARATOR_OFF:
			priceREDSTONE_COMPARATOR_OFF=price;
		case REDSTONE_COMPARATOR_ON:
			priceREDSTONE_COMPARATOR_ON=price;
		case REDSTONE_LAMP_OFF:
			priceREDSTONE_LAMP_OFF=price;
		case REDSTONE_LAMP_ON:
			priceREDSTONE_LAMP_ON=price;
		case REDSTONE_ORE:
			priceREDSTONE_ORE=price;
		case REDSTONE_TORCH_OFF:
			priceREDSTONE_TORCH_OFF=price;
		case REDSTONE_TORCH_ON:
			priceREDSTONE_TORCH_ON=price;
		case REDSTONE_WIRE:
			priceREDSTONE_WIRE=price;
		case RED_MUSHROOM:
			priceRED_MUSHROOM=price;
		case RED_ROSE:
			priceRED_ROSE=price;
		case RED_SANDSTONE:
			priceRED_SANDSTONE=price;
		case RED_SANDSTONE_STAIRS:
			priceRED_SANDSTONE_STAIRS=price;
		case ROTTEN_FLESH:
			priceROTTEN_FLESH=price;
		case SADDLE:
			priceSADDLE=price;
		case SAND:
			priceSAND=price;
		case SANDSTONE:
			priceSANDSTONE=price;
		case SANDSTONE_STAIRS:
			priceSANDSTONE_STAIRS=price;
		case SAPLING:
			priceSAPLING=price;
		case SEA_LANTERN:
			priceSEA_LANTERN=price;
		case SEEDS:
			priceSEEDS=price;
		case SHEARS:
			priceSHEARS=price;
		case SIGN:
			priceSIGN=price;
		case SIGN_POST:
			priceSIGN_POST=price;
		case SKULL:
			priceSKULL=price;
		case SKULL_ITEM:
			priceSKULL_ITEM=price;
		case SLIME_BALL:
			priceSLIME_BALL=price;
		case SLIME_BLOCK:
			priceSLIME_BLOCK=price;
		case SMOOTH_BRICK:
			priceSMOOTH_BRICK=price;
		case SMOOTH_STAIRS:
			priceSMOOTH_STAIRS=price;
		case SNOW:
			priceSNOW=price;
		case SNOW_BALL:
			priceSNOW_BALL=price;
		case SNOW_BLOCK:
			priceSNOW_BLOCK=price;
		case SOIL:
			priceSOIL=price;
		case SOUL_SAND:
			priceSOUL_SAND=price;
		case SPECKLED_MELON:
			priceSPECKLED_MELON=price;
		case SPIDER_EYE:
			priceSPIDER_EYE=price;
		case SPONGE:
			priceSPONGE=price;
		case SPRUCE_DOOR:
			priceSPRUCE_DOOR=price;
		case SPRUCE_DOOR_ITEM:
			priceSPRUCE_DOOR_ITEM=price;
		case SPRUCE_FENCE:
			priceSPRUCE_FENCE=price;
		case SPRUCE_FENCE_GATE:
			priceSPRUCE_FENCE_GATE=price;
		case SPRUCE_WOOD_STAIRS:
			priceSPRUCE_WOOD_STAIRS=price;
		case STAINED_CLAY:
			priceSTAINED_CLAY=price;
		case STAINED_GLASS:
			priceSTAINED_GLASS=price;
		case STAINED_GLASS_PANE:
			priceSTAINED_GLASS_PANE=price;
		case STANDING_BANNER:
			priceSTANDING_BANNER=price;
		case STATIONARY_LAVA:
			priceSTATIONARY_LAVA=price;
		case STATIONARY_WATER:
			priceSTATIONARY_WATER=price;
		case STEP:
			priceSTEP=price;
		case STICK:
			priceSTICK=price;
		case STONE:
			priceSTONE=price;
		case STONE_AXE:
			priceSTONE_AXE=price;
		case STONE_BUTTON:
			priceSTONE_BUTTON=price;
		case STONE_HOE:
			priceSTONE_HOE=price;
		case STONE_PICKAXE:
			priceSTONE_PICKAXE=price;
		case STONE_PLATE:
			priceSTONE_PLATE=price;
		case STONE_SLAB2:
			priceSTONE_SLAB2=price;
		case STONE_SPADE:
			priceSTONE_SPADE=price;
		case STONE_SWORD:
			priceSTONE_SWORD=price;
		case STORAGE_MINECART:
			priceSTORAGE_MINECART=price;
		case STRING:
			priceSTRING=price;
		case SUGAR:
			priceSUGAR=price;
		case SUGAR_CANE:
			priceSUGAR_CANE=price;
		case SUGAR_CANE_BLOCK:
			priceSUGAR_CANE_BLOCK=price;
		case SULPHUR:
			priceSULPHUR=price;
		case THIN_GLASS:
			priceTHIN_GLASS=price;
		case TNT:
			priceTNT=price;
		case TORCH:
			priceTORCH=price;
		case TRAPPED_CHEST:
			priceTRAPPED_CHEST=price;
		case TRAP_DOOR:
			priceTRAP_DOOR=price;
		case TRIPWIRE:
			priceTRIPWIRE=price;
		case TRIPWIRE_HOOK:
			priceTRIPWIRE_HOOK=price;
		case VINE:
			priceVINE=price;
		case WALL_BANNER:
			priceWALL_BANNER=price;
		case WALL_SIGN:
			priceWALL_SIGN=price;
		case WATCH:
			priceWATCH=price;
		case WATER:
			priceWATER=price;
		case WATER_BUCKET:
			priceWATER_BUCKET=price;
		case WATER_LILY:
			priceWATER_LILY=price;
		case WEB:
			priceWEB=price;
		case WHEAT:
			priceWHEAT=price;
		case WOOD:
			priceWOOD=price;
		case WOODEN_DOOR:
			priceWOODEN_DOOR=price;
		case WOOD_AXE:
			priceWOOD_AXE=price;
		case WOOD_BUTTON:
			priceWOOD_BUTTON=price;
		case WOOD_DOOR:
			priceWOOD_DOOR=price;
		case WOOD_DOUBLE_STEP:
			priceWOOD_DOUBLE_STEP=price;
		case WOOD_HOE:
			priceWOOD_HOE=price;
		case WOOD_PICKAXE:
			priceWOOD_PICKAXE=price;
		case WOOD_PLATE:
			priceWOOD_PLATE=price;
		case WOOD_SPADE:
			priceWOOD_SPADE=price;
		case WOOD_STAIRS:
			priceWOOD_STAIRS=price;
		case WOOD_STEP:
			priceWOOD_STEP=price;
		case WOOD_SWORD:
			priceWOOD_SWORD=price;
		case WOOL:
			priceWOOL=price;
		case WORKBENCH:
			priceWORKBENCH=price;
		case WRITTEN_BOOK:
			priceWRITTEN_BOOK=price;
		case YELLOW_FLOWER:
			priceYELLOW_FLOWER=price;
		}

	}

	public static void savePrices(){
		for (Material mat : Material.values()) {
			  // do what you want
			String sql = "insert into MCS_market (material, price)"
			        + " values (?, ?)"
			        + " ON DUPLICATE KEY UPDATE price = ?";
			
			PreparedStatement preparedStmt = MySQL.getPreStat(sql);
			
			try {
				preparedStmt.setString (1, mat.toString());
				preparedStmt.setDouble (2, Market.getPrice(mat));	
				preparedStmt.setDouble (3, Market.getPrice(mat));			
				MySQL.insertDB(preparedStmt);								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void loadPrices(){
		PreparedStatement preparedStmt = MySQL.getPreStat("SELECT material,price FROM MCS_market");
		ResultSet result = null;
		try {
			result = MySQL.callDB(preparedStmt);
			
			while(result.next()){
				Market.setPrice(result.getString("material"),result.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("incomplete-switch")
	public static void setPrice(String string, double price) {
		Material item = Material.getMaterial(string);

		switch(item){
		case GOLD_ORE :
			priceGOLD_ORE=price;
		case ACACIA_DOOR:
			priceACACIA_DOOR=price;
		case ACACIA_DOOR_ITEM:
			priceACACIA_DOOR_ITEM=price;
		case ACACIA_FENCE:
			priceACACIA_FENCE=price;
		case ACACIA_FENCE_GATE:
			priceACACIA_FENCE_GATE=price;
		case ACACIA_STAIRS:
			priceACACIA_STAIRS=price;
		case ACTIVATOR_RAIL:
			priceACTIVATOR_RAIL=price;
		case ANVIL:
			priceANVIL=price;
		case APPLE:
			priceAPPLE=price;
		case ARMOR_STAND:
			priceARMOR_STAND=price;
		case ARROW:
			priceARROW=price;
		case BAKED_POTATO:
			priceBAKED_POTATO=price;
		case BANNER:
			priceBANNER=price;
		case BARRIER:
			priceBARRIER=price;
		case BEACON:
			priceBEACON=price;
		case BED:
			priceBED=price;
		case BEDROCK:
			priceBEDROCK=price;
		case BED_BLOCK:
			priceBED_BLOCK=price;
		case BIRCH_DOOR:
			priceBIRCH_DOOR=price;
		case BIRCH_DOOR_ITEM:
			priceBIRCH_DOOR_ITEM=price;
		case BIRCH_FENCE:
			priceBIRCH_FENCE=price;
		case BIRCH_FENCE_GATE:
			priceBIRCH_FENCE_GATE=price;
		case BIRCH_WOOD_STAIRS:
			priceBIRCH_WOOD_STAIRS=price;
		case BLAZE_POWDER:
			priceBLAZE_POWDER=price;
		case BLAZE_ROD:
			priceBLAZE_ROD=price;
		case BOAT:
			priceBOAT=price;
		case BONE:
			priceBONE=price;
		case BOOK:
			priceBOOK=price;
		case BOOKSHELF:
			priceBOOKSHELF=price;
		case BOOK_AND_QUILL:
			priceBOOK_AND_QUILL=price;
		case BOW:
			priceBOW=price;
		case BOWL:
			priceBOWL=price;
		case BREAD:
			priceBREAD=price;
		case BREWING_STAND:
			priceBREWING_STAND=price;
		case BREWING_STAND_ITEM:
			priceBREWING_STAND_ITEM=price;
		case BRICK:
			priceBRICK=price;
		case BRICK_STAIRS:
			priceBRICK_STAIRS=price;
		case BROWN_MUSHROOM:
			priceBROWN_MUSHROOM=price;
		case BUCKET:
			priceBUCKET=price;
		case BURNING_FURNACE:
			priceBURNING_FURNACE=price;
		case CACTUS:
			priceCACTUS=price;
		case CAKE:
			priceCAKE=price;
		case CAKE_BLOCK:
			priceCAKE_BLOCK=price;
		case CARPET:
			priceCARPET=price;
		case CARROT:
			priceCARROT=price;
		case CARROT_ITEM:
			priceCARROT_ITEM=price;
		case CARROT_STICK:
			priceCARROT_STICK=price;
		case CAULDRON:
			priceCAULDRON=price;
		case CAULDRON_ITEM:
			priceCAULDRON_ITEM=price;
		case CHAINMAIL_BOOTS:
			priceCHAINMAIL_BOOTS=price;
		case CHAINMAIL_CHESTPLATE:
			priceCHAINMAIL_CHESTPLATE=price;
		case CHAINMAIL_HELMET:
			priceCHAINMAIL_HELMET=price;
		case CHAINMAIL_LEGGINGS:
			priceCHAINMAIL_LEGGINGS=price;
		case CHEST:
			priceCHEST=price;
		case CLAY:
			priceCLAY=price;
		case CLAY_BALL:
			priceCLAY_BALL=price;
		case CLAY_BRICK:
			priceCLAY_BRICK=price;
		case COAL:
			priceCOAL=price;
		case COAL_BLOCK:
			priceCOAL_BLOCK=price;
		case COAL_ORE:
			priceCOAL_ORE=price;
		case COBBLESTONE:
			priceCOBBLESTONE=price;
		case COBBLESTONE_STAIRS:
			priceCOBBLESTONE_STAIRS=price;
		case COBBLE_WALL:
			priceCOBBLE_WALL=price;
		case COCOA:
			priceCOCOA=price;
		case COMMAND:
			priceCOMMAND=price;
		case COMMAND_MINECART:
			priceCOMMAND_MINECART=price;
		case COMPASS:
			priceCOMPASS=price;
		case COOKED_BEEF:
			priceCOOKED_BEEF=price;
		case COOKED_CHICKEN:
			priceCOOKED_CHICKEN=price;
		case COOKED_FISH:
			priceCOOKED_FISH=price;
		case COOKED_MUTTON:
			priceCOOKED_MUTTON=price;
		case COOKED_RABBIT:
			priceCOOKED_RABBIT=price;
		case COOKIE:
			priceCOOKIE=price;
		case CROPS:
			priceCROPS=price;
		case DARK_OAK_DOOR:
			priceDARK_OAK_DOOR=price;
		case DARK_OAK_DOOR_ITEM:
			priceDARK_OAK_DOOR_ITEM=price;
		case DARK_OAK_FENCE:
			priceDARK_OAK_FENCE=price;
		case DARK_OAK_FENCE_GATE:
			priceDARK_OAK_FENCE_GATE=price;
		case DARK_OAK_STAIRS:
			priceDARK_OAK_STAIRS=price;
		case DAYLIGHT_DETECTOR:
			priceDAYLIGHT_DETECTOR=price;
		case DAYLIGHT_DETECTOR_INVERTED:
			priceDAYLIGHT_DETECTOR_INVERTED=price;
		case DEAD_BUSH:
			priceDEAD_BUSH=price;
		case DETECTOR_RAIL:
			priceDETECTOR_RAIL=price;
		case DIAMOND:
			priceDIAMOND=price;
		case DIAMOND_AXE:
			priceDIAMOND_AXE=price;
		case DIAMOND_BARDING:
			priceDIAMOND_BARDING=price;
		case DIAMOND_BLOCK:
			priceDIAMOND_BLOCK=price;
		case DIAMOND_BOOTS:
			priceDIAMOND_BOOTS=price;
		case DIAMOND_CHESTPLATE:
			priceDIAMOND_CHESTPLATE=price;
		case DIAMOND_HELMET:
			priceDIAMOND_HELMET=price;
		case DIAMOND_HOE:
			priceDIAMOND_HOE=price;
		case DIAMOND_LEGGINGS:
			priceDIAMOND_LEGGINGS=price;
		case DIAMOND_ORE:
			priceDIAMOND_ORE=price;
		case DIAMOND_PICKAXE:
			priceDIAMOND_PICKAXE=price;
		case DIAMOND_SPADE:
			priceDIAMOND_SPADE=price;
		case DIAMOND_SWORD:
			priceDIAMOND_SWORD=price;
		case DIODE:
			priceDIODE=price;
		case DIODE_BLOCK_OFF:
			priceDIODE_BLOCK_OFF=price;
		case DIODE_BLOCK_ON:
			priceDIODE_BLOCK_ON=price;
		case DIRT:
			priceDIRT=price;
		case DISPENSER:
			priceDISPENSER=price;
		case DOUBLE_PLANT:
			priceDOUBLE_PLANT=price;
		case DOUBLE_STEP:
			priceDOUBLE_STEP=price;
		case DOUBLE_STONE_SLAB2:
			priceDOUBLE_STONE_SLAB2=price;
		case DRAGON_EGG:
			priceDRAGON_EGG=price;
		case DROPPER:
			priceDROPPER=price;
		case EGG:
			priceEGG=price;
		case EMERALD:
			priceEMERALD=price;
		case EMERALD_BLOCK:
			priceEMERALD_BLOCK=price;
		case EMERALD_ORE:
			priceEMERALD_ORE=price;
		case EMPTY_MAP:
			priceEMPTY_MAP=price;
		case ENCHANTED_BOOK:
			priceENCHANTED_BOOK=price;
		case ENCHANTMENT_TABLE:
			priceENCHANTMENT_TABLE=price;
		case ENDER_CHEST:
			priceENDER_CHEST=price;
		case ENDER_PEARL:
			priceENDER_PEARL=price;
		case ENDER_PORTAL:
			priceENDER_PORTAL=price;
		case ENDER_PORTAL_FRAME:
			priceENDER_PORTAL_FRAME=price;
		case ENDER_STONE:
			priceENDER_STONE=price;
		case EXPLOSIVE_MINECART:
			priceEXPLOSIVE_MINECART=price;
		case EXP_BOTTLE:
			priceEXP_BOTTLE=price;
		case EYE_OF_ENDER:
			priceEYE_OF_ENDER=price;
		case FEATHER:
			priceFEATHER=price;
		case FENCE:
			priceFENCE=price;
		case FENCE_GATE:
			priceFENCE_GATE=price;
		case FERMENTED_SPIDER_EYE:
			priceFERMENTED_SPIDER_EYE=price;
		case FIRE:
			priceFIRE=price;
		case FIREBALL:
			priceFIREBALL=price;
		case FIREWORK:
			priceFIREWORK=price;
		case FIREWORK_CHARGE:
			priceFIREWORK_CHARGE=price;
		case FISHING_ROD:
			priceFISHING_ROD=price;
		case FLINT:
			priceFLINT=price;
		case FLINT_AND_STEEL:
			priceFLINT_AND_STEEL=price;
		case FLOWER_POT:
			priceFLOWER_POT=price;
		case FLOWER_POT_ITEM:
			priceFLOWER_POT_ITEM=price;
		case FURNACE:
			priceFURNACE=price;
		case GHAST_TEAR:
			priceGHAST_TEAR=price;
		case GLASS:
			priceGLASS=price;
		case GLASS_BOTTLE:
			priceGLASS_BOTTLE=price;
		case GLOWING_REDSTONE_ORE:
			priceGLOWING_REDSTONE_ORE=price;
		case GLOWSTONE:
			priceGLOWSTONE=price;
		case GLOWSTONE_DUST:
			priceGLOWSTONE_DUST=price;
		case GOLDEN_APPLE:
			priceGOLDEN_APPLE=price;
		case GOLDEN_CARROT:
			priceGOLDEN_CARROT=price;
		case GOLD_AXE:
			priceGOLD_AXE=price;
		case GOLD_BARDING:
			priceGOLD_BARDING=price;
		case GOLD_BLOCK:
			priceGOLD_BLOCK=price;
		case GOLD_BOOTS:
			priceGOLD_BOOTS=price;
		case GOLD_CHESTPLATE:
			priceGOLD_CHESTPLATE=price;
		case GOLD_HELMET:
			priceGOLD_HELMET=price;
		case GOLD_HOE:
			priceGOLD_HOE=price;
		case GOLD_INGOT:
			priceGOLD_INGOT=price;
		case GOLD_LEGGINGS:
			priceGOLD_LEGGINGS=price;
		case GOLD_NUGGET:
			priceGOLD_NUGGET=price;
		case GOLD_PICKAXE:
			priceGOLD_PICKAXE=price;
		case GOLD_PLATE:
			priceGOLD_PLATE=price;
		case GOLD_RECORD:
			priceGOLD_RECORD=price;
		case GOLD_SPADE:
			priceGOLD_SPADE=price;
		case GOLD_SWORD:
			priceGOLD_SWORD=price;
		case GRASS:
			priceGRASS=price;
		case GRAVEL:
			priceGRAVEL=price;
		case GREEN_RECORD:
			priceGREEN_RECORD=price;
		case GRILLED_PORK:
			priceGRILLED_PORK=price;
		case HARD_CLAY:
			priceHARD_CLAY=price;
		case HAY_BLOCK:
			priceHAY_BLOCK=price;
		case HOPPER:
			priceHOPPER=price;
		case HOPPER_MINECART:
			priceHOPPER_MINECART=price;
		case HUGE_MUSHROOM_1:
			priceHUGE_MUSHROOM_1=price;
		case HUGE_MUSHROOM_2:
			priceHUGE_MUSHROOM_2=price;
		case ICE:
			priceICE=price;
		case INK_SACK:
			priceINK_SACK=price;
		case IRON_AXE:
			priceIRON_AXE=price;
		case IRON_BARDING:
			priceIRON_BARDING=price;
		case IRON_BLOCK:
			priceIRON_BLOCK=price;
		case IRON_BOOTS:
			priceIRON_BOOTS=price;
		case IRON_CHESTPLATE:
			priceIRON_CHESTPLATE=price;
		case IRON_DOOR:
			priceIRON_DOOR=price;
		case IRON_DOOR_BLOCK:
			priceIRON_DOOR_BLOCK=price;
		case IRON_FENCE:
			priceIRON_FENCE=price;
		case IRON_HELMET:
			priceIRON_HELMET=price;
		case IRON_HOE:
			priceIRON_HOE=price;
		case IRON_INGOT:
			priceIRON_INGOT=price;
		case IRON_LEGGINGS:
			priceIRON_LEGGINGS=price;
		case IRON_ORE:
			priceIRON_ORE=price;
		case IRON_PICKAXE:
			priceIRON_PICKAXE=price;
		case IRON_PLATE:
			priceIRON_PLATE=price;
		case IRON_SPADE:
			priceIRON_SPADE=price;
		case IRON_SWORD:
			priceIRON_SWORD=price;
		case IRON_TRAPDOOR:
			priceIRON_TRAPDOOR=price;
		case ITEM_FRAME:
			priceITEM_FRAME=price;
		case JACK_O_LANTERN:
			priceJACK_O_LANTERN=price;
		case JUKEBOX:
			priceJUKEBOX=price;
		case JUNGLE_DOOR:
			priceJUNGLE_DOOR=price;
		case JUNGLE_DOOR_ITEM:
			priceJUNGLE_DOOR_ITEM=price;
		case JUNGLE_FENCE:
			priceJUNGLE_FENCE=price;
		case JUNGLE_FENCE_GATE:
			priceJUNGLE_FENCE_GATE=price;
		case JUNGLE_WOOD_STAIRS:
			priceJUNGLE_WOOD_STAIRS=price;
		case LADDER:
			priceLADDER=price;
		case LAPIS_BLOCK:
			priceLAPIS_BLOCK=price;
		case LAPIS_ORE:
			priceLAPIS_ORE=price;
		case LAVA:
			priceLAVA=price;
		case LAVA_BUCKET:
			priceLAVA_BUCKET=price;
		case LEASH:
			priceLEASH=price;
		case LEATHER:
			priceLEATHER=price;
		case LEATHER_BOOTS:
			priceLEATHER_BOOTS=price;
		case LEATHER_CHESTPLATE:
			priceLEATHER_CHESTPLATE=price;
		case LEATHER_HELMET:
			priceLEATHER_HELMET=price;
		case LEATHER_LEGGINGS:
			priceLEATHER_LEGGINGS=price;
		case LEAVES:
			priceLEAVES=price;
		case LEAVES_2:
			priceLEAVES_2=price;
		case LEVER:
			priceLEVER=price;
		case LOG:
			priceLOG=price;
		case LOG_2:
			priceLOG_2=price;
		case LONG_GRASS:
			priceLONG_GRASS=price;
		case MAGMA_CREAM:
			priceMAGMA_CREAM=price;
		case MAP:
			priceMAP=price;
		case MELON:
			priceMELON=price;
		case MELON_BLOCK:
			priceMELON_BLOCK=price;
		case MELON_SEEDS:
			priceMELON_SEEDS=price;
		case MELON_STEM:
			priceMELON_STEM=price;
		case MILK_BUCKET:
			priceMILK_BUCKET=price;
		case MINECART:
			priceMINECART=price;
		case MOB_SPAWNER:
			priceMOB_SPAWNER=price;
		case MONSTER_EGG:
			priceMONSTER_EGG=price;
		case MONSTER_EGGS:
			priceMONSTER_EGGS=price;
		case MOSSY_COBBLESTONE:
			priceMOSSY_COBBLESTONE=price;
		case MUSHROOM_SOUP:
			priceMUSHROOM_SOUP=price;
		case MUTTON:
			priceMUTTON=price;
		case MYCEL:
			priceMYCEL=price;
		case NAME_TAG:
			priceNAME_TAG=price;
		case NETHERRACK:
			priceNETHERRACK=price;
		case NETHER_BRICK:
			priceNETHER_BRICK=price;
		case NETHER_BRICK_ITEM:
			priceNETHER_BRICK_ITEM=price;
		case NETHER_BRICK_STAIRS:
			priceNETHER_BRICK_STAIRS=price;
		case NETHER_FENCE:
			priceNETHER_FENCE=price;
		case NETHER_STALK:
			priceNETHER_STALK=price;
		case NETHER_STAR:
			priceNETHER_STAR=price;
		case NETHER_WARTS:
			priceNETHER_WARTS=price;
		case NOTE_BLOCK:
			priceNOTE_BLOCK=price;
		case OBSIDIAN:
			priceOBSIDIAN=price;
		case PACKED_ICE:
			pricePACKED_ICE=price;
		case PAINTING:
			pricePAINTING=price;
		case PAPER:
			pricePAPER=price;
		case PISTON_BASE:
			pricePISTON_BASE=price;
		case PISTON_EXTENSION:
			pricePISTON_EXTENSION=price;
		case PISTON_MOVING_PIECE:
			pricePISTON_MOVING_PIECE=price;
		case PISTON_STICKY_BASE:
			pricePISTON_STICKY_BASE=price;
		case POISONOUS_POTATO:
			pricePOISONOUS_POTATO=price;
		case PORK:
			pricePORK=price;
		case PORTAL:
			pricePORTAL=price;
		case POTATO:
			pricePOTATO=price;
		case POTATO_ITEM:
			pricePOTATO_ITEM=price;
		case POTION:
			pricePOTION=price;
		case POWERED_MINECART:
			pricePOWERED_MINECART=price;
		case POWERED_RAIL:
			pricePOWERED_RAIL=price;
		case PRISMARINE:
			pricePRISMARINE=price;
		case PRISMARINE_CRYSTALS:
			pricePRISMARINE_CRYSTALS=price;
		case PRISMARINE_SHARD:
			pricePRISMARINE_SHARD=price;
		case PUMPKIN:
			pricePUMPKIN=price;
		case PUMPKIN_PIE:
			pricePUMPKIN_PIE=price;
		case PUMPKIN_SEEDS:
			pricePUMPKIN_SEEDS=price;
		case PUMPKIN_STEM:
			pricePUMPKIN_STEM=price;
		case QUARTZ:
			priceQUARTZ=price;
		case QUARTZ_BLOCK:
			priceQUARTZ_BLOCK=price;
		case QUARTZ_ORE:
			priceQUARTZ_ORE=price;
		case QUARTZ_STAIRS:
			priceQUARTZ_STAIRS=price;
		case RABBIT:
			priceRABBIT=price;
		case RABBIT_FOOT:
			priceRABBIT_FOOT=price;
		case RABBIT_HIDE:
			priceRABBIT_HIDE=price;
		case RABBIT_STEW:
			priceRABBIT_STEW=price;
		case RAILS:
			priceRAILS=price;
		case RAW_BEEF:
			priceRAW_BEEF=price;
		case RAW_CHICKEN:
			priceRAW_CHICKEN=price;
		case RAW_FISH:
			priceRAW_FISH=price;
		case RECORD_10:
			priceRECORD_10=price;
		case RECORD_11:
			priceRECORD_11=price;
		case RECORD_12:
			priceRECORD_12=price;
		case RECORD_3:
			priceRECORD_3=price;
		case RECORD_4:
			priceRECORD_4=price;
		case RECORD_5:
			priceRECORD_5=price;
		case RECORD_6:
			priceRECORD_6=price;
		case RECORD_7:
			priceRECORD_7=price;
		case RECORD_8:
			priceRECORD_8=price;
		case RECORD_9:
			priceRECORD_9=price;
		case REDSTONE:
			priceREDSTONE=price;
		case REDSTONE_BLOCK:
			priceREDSTONE_BLOCK=price;
		case REDSTONE_COMPARATOR:
			priceREDSTONE_COMPARATOR=price;
		case REDSTONE_COMPARATOR_OFF:
			priceREDSTONE_COMPARATOR_OFF=price;
		case REDSTONE_COMPARATOR_ON:
			priceREDSTONE_COMPARATOR_ON=price;
		case REDSTONE_LAMP_OFF:
			priceREDSTONE_LAMP_OFF=price;
		case REDSTONE_LAMP_ON:
			priceREDSTONE_LAMP_ON=price;
		case REDSTONE_ORE:
			priceREDSTONE_ORE=price;
		case REDSTONE_TORCH_OFF:
			priceREDSTONE_TORCH_OFF=price;
		case REDSTONE_TORCH_ON:
			priceREDSTONE_TORCH_ON=price;
		case REDSTONE_WIRE:
			priceREDSTONE_WIRE=price;
		case RED_MUSHROOM:
			priceRED_MUSHROOM=price;
		case RED_ROSE:
			priceRED_ROSE=price;
		case RED_SANDSTONE:
			priceRED_SANDSTONE=price;
		case RED_SANDSTONE_STAIRS:
			priceRED_SANDSTONE_STAIRS=price;
		case ROTTEN_FLESH:
			priceROTTEN_FLESH=price;
		case SADDLE:
			priceSADDLE=price;
		case SAND:
			priceSAND=price;
		case SANDSTONE:
			priceSANDSTONE=price;
		case SANDSTONE_STAIRS:
			priceSANDSTONE_STAIRS=price;
		case SAPLING:
			priceSAPLING=price;
		case SEA_LANTERN:
			priceSEA_LANTERN=price;
		case SEEDS:
			priceSEEDS=price;
		case SHEARS:
			priceSHEARS=price;
		case SIGN:
			priceSIGN=price;
		case SIGN_POST:
			priceSIGN_POST=price;
		case SKULL:
			priceSKULL=price;
		case SKULL_ITEM:
			priceSKULL_ITEM=price;
		case SLIME_BALL:
			priceSLIME_BALL=price;
		case SLIME_BLOCK:
			priceSLIME_BLOCK=price;
		case SMOOTH_BRICK:
			priceSMOOTH_BRICK=price;
		case SMOOTH_STAIRS:
			priceSMOOTH_STAIRS=price;
		case SNOW:
			priceSNOW=price;
		case SNOW_BALL:
			priceSNOW_BALL=price;
		case SNOW_BLOCK:
			priceSNOW_BLOCK=price;
		case SOIL:
			priceSOIL=price;
		case SOUL_SAND:
			priceSOUL_SAND=price;
		case SPECKLED_MELON:
			priceSPECKLED_MELON=price;
		case SPIDER_EYE:
			priceSPIDER_EYE=price;
		case SPONGE:
			priceSPONGE=price;
		case SPRUCE_DOOR:
			priceSPRUCE_DOOR=price;
		case SPRUCE_DOOR_ITEM:
			priceSPRUCE_DOOR_ITEM=price;
		case SPRUCE_FENCE:
			priceSPRUCE_FENCE=price;
		case SPRUCE_FENCE_GATE:
			priceSPRUCE_FENCE_GATE=price;
		case SPRUCE_WOOD_STAIRS:
			priceSPRUCE_WOOD_STAIRS=price;
		case STAINED_CLAY:
			priceSTAINED_CLAY=price;
		case STAINED_GLASS:
			priceSTAINED_GLASS=price;
		case STAINED_GLASS_PANE:
			priceSTAINED_GLASS_PANE=price;
		case STANDING_BANNER:
			priceSTANDING_BANNER=price;
		case STATIONARY_LAVA:
			priceSTATIONARY_LAVA=price;
		case STATIONARY_WATER:
			priceSTATIONARY_WATER=price;
		case STEP:
			priceSTEP=price;
		case STICK:
			priceSTICK=price;
		case STONE:
			priceSTONE=price;
		case STONE_AXE:
			priceSTONE_AXE=price;
		case STONE_BUTTON:
			priceSTONE_BUTTON=price;
		case STONE_HOE:
			priceSTONE_HOE=price;
		case STONE_PICKAXE:
			priceSTONE_PICKAXE=price;
		case STONE_PLATE:
			priceSTONE_PLATE=price;
		case STONE_SLAB2:
			priceSTONE_SLAB2=price;
		case STONE_SPADE:
			priceSTONE_SPADE=price;
		case STONE_SWORD:
			priceSTONE_SWORD=price;
		case STORAGE_MINECART:
			priceSTORAGE_MINECART=price;
		case STRING:
			priceSTRING=price;
		case SUGAR:
			priceSUGAR=price;
		case SUGAR_CANE:
			priceSUGAR_CANE=price;
		case SUGAR_CANE_BLOCK:
			priceSUGAR_CANE_BLOCK=price;
		case SULPHUR:
			priceSULPHUR=price;
		case THIN_GLASS:
			priceTHIN_GLASS=price;
		case TNT:
			priceTNT=price;
		case TORCH:
			priceTORCH=price;
		case TRAPPED_CHEST:
			priceTRAPPED_CHEST=price;
		case TRAP_DOOR:
			priceTRAP_DOOR=price;
		case TRIPWIRE:
			priceTRIPWIRE=price;
		case TRIPWIRE_HOOK:
			priceTRIPWIRE_HOOK=price;
		case VINE:
			priceVINE=price;
		case WALL_BANNER:
			priceWALL_BANNER=price;
		case WALL_SIGN:
			priceWALL_SIGN=price;
		case WATCH:
			priceWATCH=price;
		case WATER:
			priceWATER=price;
		case WATER_BUCKET:
			priceWATER_BUCKET=price;
		case WATER_LILY:
			priceWATER_LILY=price;
		case WEB:
			priceWEB=price;
		case WHEAT:
			priceWHEAT=price;
		case WOOD:
			priceWOOD=price;
		case WOODEN_DOOR:
			priceWOODEN_DOOR=price;
		case WOOD_AXE:
			priceWOOD_AXE=price;
		case WOOD_BUTTON:
			priceWOOD_BUTTON=price;
		case WOOD_DOOR:
			priceWOOD_DOOR=price;
		case WOOD_DOUBLE_STEP:
			priceWOOD_DOUBLE_STEP=price;
		case WOOD_HOE:
			priceWOOD_HOE=price;
		case WOOD_PICKAXE:
			priceWOOD_PICKAXE=price;
		case WOOD_PLATE:
			priceWOOD_PLATE=price;
		case WOOD_SPADE:
			priceWOOD_SPADE=price;
		case WOOD_STAIRS:
			priceWOOD_STAIRS=price;
		case WOOD_STEP:
			priceWOOD_STEP=price;
		case WOOD_SWORD:
			priceWOOD_SWORD=price;
		case WOOL:
			priceWOOL=price;
		case WORKBENCH:
			priceWORKBENCH=price;
		case WRITTEN_BOOK:
			priceWRITTEN_BOOK=price;
		case YELLOW_FLOWER:
			priceYELLOW_FLOWER=price;
		}

	}
}
