/** This class mimics a simple database which contains static records.  The methods */
/** contained in this class pertain to the creation of cards for the player. */

/** Basically, this is an auxillary class supporting the Player and PlayerList */
/** classes and at the same time, makes use of the Card class hierarchy. */


public class CardList{
    private Card[] card;
    private int i;
	private final int cardsMade;

	/** This constructor initializes the size of the card array */
    public CardList(){
        cardsMade = 100;
		card = new Card[cardsMade];
    }

	/** populates the card array with Monster Cards with database-like records, */
	/** each with its own attribute such as cardName, type, image's location,
	/** star-level, attack points and defense points */

    public void generateMonsterCards(){
		String[] type = new String[4];
        i = 0;

        /* Monsters without Effect */

		type[0] = "Light";  // 1
        type[1] = "Dragon";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Blue-Eyes White Dragon", type, "SKE-001", 8, 3000, 2500);

        type[0] = "Dark";   // 2
        type[1] = "Dragon";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Koumori Dragon", type , "SKE-003", 4, 3000, 2500);

        type[0] = "Earth";  // 3
        type[1] = "Warrior";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Kojikocy", type, "MRD-010", 4, 1500, 1200);

        type[0] = "Wind";   // 4
        type[1] = "Dragon";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Luster Dragon", type, "DEN-003", 6, 2400, 1400);

        type[0] = "Light";   // 5
		type[1] = "Spellcaster";
		type[2] = null;
		type[3] = null;
        card[i++] = new MonsterCard("Rogue Doll", type, "SKE-004", 4, 1600, 1000);

        type[0] = "Dark";   // 6
		type[1] = "Warrior";
		type[2] = null;
		type[3] = null;
        card[i++] = new MonsterCard("Succubus Knight", type, "LOB-117", 5, 1650, 1300);

        type[0] = "Earth";   // 7
		type[1] = "Dinosaur";
		type[2] = null;
		type[3] = null;
        card[i++] = new MonsterCard("Uraby", type, "LOB-069", 4, 1500, 800);

        type[0] = "Light";   // 8
		type[1] = "Dragon";
		type[2] = null;
		type[3] = null;
        card[i++] = new MonsterCard("Hyozanryu", type, "SKE-011", 7, 2100, 2800);

		type[0] = "Earth";   // 9
		type[1] = "Beast";
		type[2] = "Warrior";
		type[3] = null;
        card[i++] = new MonsterCard("Battle Ox", type, "SKE-002", 4, 1700, 1000);

        type[0] = "Dark";   // 10
        type[1] = "Dragon";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Tri-Horned Dragon", type, "LOB-000", 8, 2850, 2350);

        type[0] = "Dark";   // 11
        type[1] = "Spellcaster";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Dark Magician", type, "LOB-005", 7, 2500, 2100);

        type[0] = "Insect";   // 12
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Hunter Spider", type, "MRD-049", 5, 1600, 1400);

        type[0] = "Warrior";	// 13
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Celtic Guardian", type, "LOB-007", 4, 1400, 1200);

        type[0] = "Earth";   // 14
        type[1] = "Insect";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Basic Insect", type, "LOB-008", 2, 500, 700);

        type[0] = "Zombie";   // 15
        type[1] = "Dark";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("The 13th Grave", type, "LOB-014", 3, 1200, 900);

        type[0] = "Beast";   // 16
        type[1] = "Earth";
        type[2] = "Warrior";
        type[3] = null;
        card[i++] = new MonsterCard("Hitotsu-Me Giant", type, "LOB-002", 4, 1200, 1000);

        type[0] = "Dark";   // 17
        type[1] = "Zombie";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Skull Servant", type, "LOB-004", 1, 300, 200);

        type[0] = "Earth";   // 18
        type[1] = "Beast";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Silver Fang", type, "LOB-010", 3, 1200, 800);

        type[0] = "Earth";   // 19
        type[1] = "Beast";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Dark Gray", type, "LOB-011", 3, 800, 900);

        type[0] = "Spellcaster";   // 20
        type[1] = "Dark";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Nemuriko", type, "LOB-013", 3, 800, 700);

        type[0] = "Spellcaster";   // 21
        type[1] = "Fire";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Flame Manipulator", type, "LOB-016", 3, 1200, 1400);

        type[0] = "Plant";   //22
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Firegrass", type, "LOB-018", 2, 700, 600);

        type[0] = "Dark";   //23
		type[1] = "Fiend";
		type[2] = null;
		type[3] = null;
		card[i++] = new MonsterCard("Dark King of the Abyss", type, "LOB-020", 3, 1200, 800);

		type[0] = "Winged Beast";   //24
        type[1] = "Light";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Fiend Reflection #2", type, "LOB-021", 4, 1100, 1400);

		type[0] = "Aqua";   //25
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Turtle Tiger", type, "LOB-023", 4, 1000, 1500);

		type[0] = "Fairy";   //26
        type[1] = "Light";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Petit Angel", type, "LOB-025", 3, 600, 900);

		type[0] = "Spellcaster";   //27
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Aqua Madoor", type, "LOB-027", 4, 1200, 2000);

		type[0] = "Dragon";   //28
        type[1] = "Wind";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Petit Dragon", type, "LOB-024", 2, 600, 700);

		type[0] = "Warrior";   //29
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Kagemusha of the Blue Flame", type, "LOB-028", 2, 800, 400);

		type[0] = "Dragon";   //30
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Two-Mouth Darkruler", type, "LOB-030", 3, 900, 700);

		type[0] = "Rock";   //31
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Dissolverock", type, "LOB-031", 3, 900, 1000);

		type[0] = "Fish";   //32
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Root Water", type, "LOB-032", 3, 900, 800);

		type[0] = "Aqua";   //33
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("The Furious Sea King", type, "LOB-033", 3, 800, 700);

		type[0] = "Earth";   //34
        type[1] = "Plant";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Green Phantom King", type, "LOB-034", 3, 500, 1600);

		type[0] = "Fairy";   //35
        type[1] = "Light";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Ray & Temperature", type, "LOB-035", 3, 1000, 1000);

		type[0] = "Beast";   //36
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Mystical Sheep #2", type, "LOB-037", 3, 800, 1000);

		type[0] = "Warrior";   //37
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Masaki the Legendary Swordsman", type, "LOB-038", 4, 1100, 1100);

		type[0] = "Winged Beast";   //38
        type[1] = "Wind";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Kurama", type, "LOB-039", 3, 800, 800);

		type[0] = "Spellcaster";   //39
        type[1] = "Light";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Mystical Elf", type, "SDY-001", 4, 800, 2000);

		type[0] = "Winged Beast";   //40
        type[1] = "Wind";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Tyhone", type, "LOB-063", 4, 1200, 1400);

		type[0] = "Beast";   //41
        type[1] = "Warrior";
        type[2] = "Earth";
        type[3] = null;
        card[i++] = new MonsterCard("Beaver Warrior", type, "LOB-064", 4, 1200, 1500);

		type[0] = "Fish";   //42
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Tongyo", type, "MRD-045", 4, 1350, 800);

		type[0] = "Fusion";   //43
        type[1] = "Warrior";
        type[2] = "Earth";
        type[3] = null;
        card[i++] = new MonsterCard("Karbonala Warrior", type, "LOB-067", 4, 1500, 1200);

		type[0] = "Rock";   //44
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Giant Soldier of Stone", type, "LOB-068", 3, 1300, 2000);

		type[0] = "Fiend";   //45
        type[1] = "Dark";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Witty Phantom", type, "LOB-072", 4, 1400, 1300);


		type[0] = "Beast";   //46
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Larvas", type, "LOB-073", 3, 800, 1000);

		type[0] = "Warrior";   //47
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Hard Armor", type, "LOB-074", 3, 300, 1200);

		type[0] = "Plant";   //48
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Man Eater", type, "LOB-075", 2, 800, 600);

		type[0] = "Warrior";   //49
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("M-Warrior #1", type, "LOB-076", 3, 1000, 500);

		type[0] = "Warrior";   //50
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("M-Warrior #2", type, "LOB-077", 4, 500, 1000);

		type[0] = "Fairy";   //51
        type[1] = "Light";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Spirit of the Harp", type, "LOB-078", 4, 800, 2000);

		type[0] = "Warrior";   //52
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Armaill", type, "LOB-079", 3, 700, 1300);

		type[0] = "Fiend";   //53
        type[1] = "Dark";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Terra the Terrible", type, "LOB-080", 4, 1200, 1300);

		type[0] = "Beast";   //54
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Frenzied Panda", type, "LOB-081", 4, 1200, 1000);

		type[0] = "Insect";   //55
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Kumootoko", type, "LOB-082", 3, 700, 1400);

		type[0] = "Fiend";   //56
        type[1] = "Dark";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Meda Bat", type, "LOB-083", 2, 800, 400);

		type[0] = "Fish";   //57
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Enchanting Mermaid", type, "LOB-084", 3, 1300, 900);

		type[0] = "Pyro";   //58
		type[1] = "Fire";
		type[2] = null;
		type[3] = null;
		card[i++] = new MonsterCard("Fireyarou", type, "LOB-085", 4, 1300, 1000);

		type[0] = "Dragon";   //59
        type[1] = "Wind";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("One-Eyed Shield Dragon", type, "LOB-087", 3, 700, 1300);

		type[0] = "Sea Serpent";   //60
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Spike Seadra", type, "LOB-103", 5, 1600, 1300);

		type[0] = "Winged Beast";   //61
        type[1] = "Wind";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Skull Red Bird", type, "LOB-105", 4, 1550, 1200);

		type[0] = "Earth";   //62
        type[1] = "Rock";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Sand Stone", type, "LOB-109", 5, 1300, 1600);

		type[0] = "Fish";   //63
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Misairuzame", type, "LOB-111", 5, 1400, 1600);

		type[0] = "Machine";   //64
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Steel Ogre Grotto #1", type, "LOB-112", 5, 1400, 1800);

		type[0] = "Wind";   //65
        type[1] = "Thunder";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Mega Thunderball", type, "MRD-044", 2, 750, 600);

		type[0] = "Earth";   //66
        type[1] = "Reptile";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Ancient Lizard Warrior", type, "MRD-050", 4, 1400, 1100);

		type[0] = "Reptile";   //67
		type[1] = "Earth";
		type[2] = null;
		type[3] = null;
		card[i++] = new MonsterCard("Drooling Lizard", type, "LOB-115", 3, 900, 800);

		type[0] = "Aqua";   //68
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Armored Starfish", type, "LOB-116", 4, 850, 1400);

		type[0] = "Dragon";   //69
        type[1] = "Dark";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Serpent Night Dragon", type, "MRL-103", 7, 2350, 2400);

		type[0] = "Fiend";   //70
        type[1] = "Dark";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Feral Imp", type, "SDY-002", 4, 1300, 1400);

		type[0] = "Dragon";   //71
        type[1] = "Wind";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Winged Dragon Guardian of the Fortress #1", type, "SDY-003", 4, 1400, 1200);

		type[0] = "Dark";   //72
        type[1] = "Fiend";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Summoned Skull", type, "SDY-004", 6, 2500, 1200);

		type[0] = "Aqua";   //73
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Red Archery Girl", type, "SDP-002", 4, 1400, 1500);

		type[0] = "Water";   //74
        type[1] = "Reptile";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Toon Alligator", type, "SDP-009", 4, 800, 1600);

		type[0] = "Earth";   //75
        type[1] = "Zombie";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Master Kyonshee", type, "DEN-001", 4, 1750,1000);

		type[0] = "Wind";   //76
        type[1] = "Dragon";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Luster Dragon #2", type, "SKE-014", 6, 2400, 1400);

		type[0] = "Dark";   //77
        type[1] = "Dragon";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Red Eyes Black Dragon", type, "DEN-002", 7, 2400, 2000);

		type[0] = "Earth";   //78
        type[1] = "Rock";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Rock Ogre Grotto #1", type, "MRD-004", 3, 800, 1200);

		type[0] = "Earth";   //79
        type[1] = "Reptile";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Armored Lizard", type, "MRD-005", 4, 1500, 1200);

		type[0] = "Wind";   //80
        type[1] = "Insect";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Killer Needle", type, "MRD-006", 4, 1200, 1000);

		type[0] = "Wind";   //81
        type[1] = "Winged-Beast";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Harpie Lady", type, "MRD-008", 4, 1300, 1400);

		type[0] = "Earth";   //82
        type[1] = "Dragon";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Crawling Dragon", type, "MRD-012", 5, 1600, 1400);

		type[0] = "Earth";   //83
        type[1] = "Zombie";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Armored Zombie", type, "MRD-013", 3, 1500, 00);

		type[0] = "Dark";   //84
        type[1] = "Fairy";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Doma The Angel of Silence", type, "MRD-015", 5, 1600, 1400);

		type[0] = "Water";   //85
        type[1] = "Aqua";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Water Omotics", type, "MRD-021", 4, 1400, 1200);

		type[0] = "Earth";   //86
        type[1] = "Machine";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Ground Attacker Bugroth", type, "MRD-022", 4, 1500, 1000);

		type[0] = "Earth";   //87
        type[1] = "Insect";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Petit Moth", type, "MRD-023", 1, 300, 200);

		type[0] = "Light";   //88
        type[1] = "Fairy";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Ocubeam", type, "MRD-030", 5, 1550, 1650);

		type[0] = "Earth";   //89
        type[1] = "Beast";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Leogun", type, "MRD-033", 5, 1750, 1550);

		type[0] = "Light";   //90
        type[1] = "Spellcaster";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Ancient Elf", type, "MRD-037", 4, 0450, 1200);

		type[0] = "Fish";   //91
        type[1] = "Water";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Bottom Dweller", type, "MRD-039", 5, 1650, 1700);

		type[0] = "Rock";   //92
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Destroyer Golem", type, "MRD-040", 4, 1500, 1000);

		type[0] = "Fiend";   //93
        type[1] = "Dark";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Morinphen", type, "MRD-043", 5, 1550, 1300);

		type[0] = "Warrior";   //94
        type[1] = "Earth";
        type[2] = null;
        type[3] = null;
        card[i++] = new MonsterCard("Hibikime", type, "MRD-055", 4, 1450, 1000);

	}

	/** populates the card array with Magic Cards with database-like records, */
	/** each with its own attribute such as cardName, type, and image's location */

    public void generateMagicCards(){
        String[] type = new String[2];
        i = 0;

  		type[0] = "equip"; //1
		type[1] = "Beast";
		card[i++] = new MagicCard("Beast Fangs", type, "LOB-041", 300);

        type[0] = "equip"; //2
        type[1] = "Spellcaster";
        card[i++] = new MagicCard("Book of Secret Arts", type, "LOB-043", 300, 300);

        type[0] = "equip"; //3
        type[1] = "Aqua";
        card[i++] = new MagicCard("Power of Kaishin", type, "LOB-044", 300, 300);

        type[0] = "equip"; //4
        type[1] = "Ritual";
        card[i++] = new MagicCard("Ritual Weapon", type, "SEN-034", 1500, 1500);

        type[0] = "equip"; //5
        type[1] = "Dinosaur";
       	card[i++] = new MagicCard("Raise Body Heat", type, "LOB-097", 300, 300);

        type[0] = "equip"; //6
        type[1] = "Fiend";
        card[i++] = new MagicCard("Dark Energy", type, "LOB-088", 300);

        type[0] = "equip"; //7
        type[1] = "Insect";
        card[i++] = new MagicCard("Laser Cannon Armor", type, "LOB-089", 300);

        type[0] = "equip"; //8
        type[1] = "Plant";
       	card[i++] = new MagicCard("Vile Germs", type, "LOB-090", 300);

	    type[0] = "equip"; //9
	    type[1] = "Fairy";
		card[i++] = new MagicCard("Silver Bow and Arrow", type, "LOB-091", 300);

        type[0] = "equip"; //10
        type[1] = "Dragon";
       	card[i++] = new MagicCard("Dragon Treasure", type, "LOB-092", 300);

        type[0] = "equip"; //11
        type[1] = "Thunder";
       	card[i++] = new MagicCard("Electro-Whip", type, "LOB-093", 300);

        type[0] = "equip"; //12
        type[1] = "Beast-Warrior";
       	card[i++] = new MagicCard("Mystical Moon", type, "LOB-094", 300);

        type[0] = "equip"; //13
        type[1] = "Machine";
       	card[i++] = new MagicCard("Machine Conversion Factory", type, "LOB-096", 300);

		type[0] = "destroy"; //14
		type[1] = "Spell and Trap card";
		card[i++] = new MagicCard("Heavy Storm", type, "SKE-026");

        type[0] = "destroy"; //15
        type[1] = "monster card";
        card[i++] = new MagicCard("Dark Hole", type, "LOB-052", 0);

        type[0] = "destroy"; //16
        type[1] = "monster card";
        card[i++] = new MagicCard("Fissure", type, "LOB-057", 1);

        type[0] = "destroy"; //17
        type[1] = "trap Card";
        card[i++] = new MagicCard("Remove Trap", type, "LOB-060", 1);

        type[0] = "destroy"; //18
        type[1] = "monster card";
        card[i++] = new MagicCard("Raigeki", type, "LOB-053", 0);

        type[0] = "lifePoints"; //19
        type[1] = "own";
        card[i++] = new MagicCard("Red Medicine", type, "LOB-054", 500);

        type[0] = "lifePoints"; //20
        type[1] = "opponent";
       	card[i++] = new MagicCard("Final Flame", type, "LOB-100", 600f);

        type[0] = "lifePoints"; //21
        type[1] = "opponent";
        card[i++] = new MagicCard("Ookazi", type, "KPC-001", 800);

        type[0] = "lifePoints"; //22
        type[1] = "opponent";
        card[i++] = new MagicCard("Sparks", type, "LOB-055", 200);

        type[0] = "lifePoints"; //23
        type[1] = "opponent";
        card[i++] = new MagicCard("Hinotama", type, "LOB-056", 500);

     	type[0] = "normal";//24
        type[1] = "Special Summon";
        card[i++] = new MagicCard("Dark Factory of Mass Production", type, "KPC-006", 2);

		type[0] = "normal"; //25
		type[1] = "Special Summon";
		card[i++] = new MagicCard("Monster Reborn", type, "LOB-118", 1);

        type[0] = "normal"; //26
        type[1] = "Own Deck";
        card[i++] = new MagicCard("Pot of Greed", type, "LOB-119", 2);
    }

	/** populates the card array with Trap Cards with database-like records, */
	/** each with its own attribute such as cardName, type, and image's location */

    public void generateTrapCards(){
        String[] type = new String[2];
        i = 0;

        type[0] = "normal";
        type[1] = "draw";
       	card[i++] = new TrapCard("Jar of Greed", type, "BWZ-003");

        type[0] = "normal";
        type[1] = "return";
       	card[i++] = new TrapCard("Compulsory Evacuation Device", type, "BWZ-005");

        type[0] = "destroy";
        type[1] = "monster";
       	card[i++] = new TrapCard("Sakuretso Armor", type, "BWZ-004");

        type[0] = "destroy";
        type[1] = "monster";
       	card[i++] = new TrapCard("Mirror Force", type, "DBM-003");

        type[0] = "negate";
        type[1] = "attack";
       	card[i++] = new TrapCard("Magic Cylinder", type, "BWZ-007");

        type[0] = "negate";
        type[1] = "attack";
       	card[i++] = new TrapCard("Threatening Roar", type, "FET-124");

        type[0] = "damage";
        type[1] = "graveyard";
       	card[i++] = new TrapCard("D.D. Dynamite", type, "FET-053", 300);

        type[0] = "damage";
        type[1] = "graveyard";
       	card[i++] = new TrapCard("Cemetery Bomb", type, "SEN-013", 100);

        type[0] = "remove";
        type[1] = "own hand";
       	card[i++] = new TrapCard("Hallowed Life Barrier", type, "SFC-087");

        type[0] = "negate";
        type[1] = "attack";
       	card[i++] = new TrapCard("Spirit Barrier", type, "RFC-245");

        type[0] = "negate";
        type[1] = "effect";
       	card[i++] = new TrapCard("The Emperor's Holiday", type, "BNS-044");

        type[0] = "destroy";
        type[1] = "monster";
       	card[i++] = new TrapCard("Burst Breath", type, "TMD-058");

    }

    public int getNumberOfCards(){
        return i;                                       // returns how many cards have been created
    }

    public Card getCard(int j){                         // returns certain card (based on i), yet make sure
        return card[j];									// that a generate method is invoked first
    }


    public void loadCards(){                            // parameter: playername (for existing players)

    }

    public static boolean canEquipMonster(MagicCard magic, MonsterCard monster){
		String[] monsterTypes = monster.getCardTypes();
		String magicType = magic.getCardTypes(1);

		boolean result = false;

		for(int i = 0; i < monsterTypes.length; i++){
			if( monsterTypes[i] == null )
				break;

			else if( magicType.equals(monsterTypes[i]) ){
				result = true;
				break;
			}
		}

		return result;
	}

}