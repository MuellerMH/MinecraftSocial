# NPC Shops

Wie richte ich einen NPC Shop ein.

## Aufstellen des Händlers

Stelle dich im Spiel an die Position wo der NPC stehen soll und gib den Befehl

`/shop add NAME PROFESSION`

Der NAME ist frei wählbar zum Beispiel Holzbedarf.
Die Profession ist das Erscheinungsbild des NPC´s und kann jederzeit in der Datenbank geändert werden. Der Wert ist eine zahl zwischen 0 und 10

Zur Auswahl stehen aktuell:

```
0: Villager.Profession.ARMORER;
1: Villager.Profession.BUTCHER;
2: Villager.Profession.CARTOGRAPHER;
3: Villager.Profession.CLERIC;
4: Villager.Profession.FARMER;
5: Villager.Profession.FISHERMAN;
6: Villager.Profession.FLETCHER;
7: Villager.Profession.LEATHERWORKER;
8: Villager.Profession.LIBRARIAN;
9: Villager.Profession.MASON;
10 Villager.Profession.NITWIT;
```

### Bewegen des Händlers

Falls Ihr später den Shop an einer anderen Postion haben möchtet, könnt ihr entweder in der Datenbank die Location ändern oder im Spiel mit einem Befehl den NPC an Eure Position setzten.

`/shop move NAME`

Der Name entspricht dem, der über dem Händler steht. Dies ist der Name den Ihr beim Einrichten verwendet habt.

### Löschen eines Händlers

Um einen Händler zu löschen könnt Ihr diesen einfach aus der Datenbank Löschen oder den InGame Befehl nutzen.

`/shop remove NAME`

### Shop aktuallisieren

Um einen Shop wärend des Spiels zu aktuallisieren nutz den InGame Befehl nutzen.

`/shop reload NAME`

Alternativ könnt Ihr auch das Plugin reeloaden mit dem Minecraft Server Befehl
`/reload`

## Shop mit Ware befüllen

Die Shop können aktuell nur über die Datenbank mit Ware befüllt werden.
Hierzu öffnet Ihr die Tabelle MCS_npcshop und fügt in die Spalte Items die Liste der zu verkaufenden Items ein.

Als Beispiel:
[,DIAMOND_AXE:0,DIAMOND_CHESTPLATE:0,DIAMOND_HELMET:0,DIAMOND_HOE:0,DIAMOND_LEGGINGS:0,DIAMOND_SPADE:0,DIAMOND_SWORD:0,GOLD_AXE:0,GOLD_BOOTS:0,GOLD_CHESTPLATE:0,GOLD_HELMET:0,GOLD_HOE:0,GOLD_INGOT:0,GOLD_LEGGINGS:0,GOLD_NUGGET:0,GOLD_RECORD:0,GOLD_SWORD:0,IRON_AXE:0,IRON_BOOTS:0,IRON_CHESTPLATE:0,IRON_DOOR:0,IRON_HELMET:0,IRON_HOE:0,IRON_INGOT:0,IRON_LEGGINGS:0,IRON_PLATE:0,IRON_SPADE:0,IRON_SWORD:0,IRON_TRAPDOOR:0,STONE_PICKAXE:0]

Die Zahl hinter dem doppeltpunkt entspricht dabei dem Status des Items. Einige Items können zum Beispiel den Status 1 haben und sehen damit anders aus. Zum Beispiel eine Lampe würde bei 0 normal aussehen und bei 1 eeingeschaltet aussehen.

Die Empfehlung ist alle Items mit :0 einzurichten.

Die Trennung der Items wird mit einem Komma `,`gemacht.

Die Preise werden gesondert über das Economy System behandelt.
