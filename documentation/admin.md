# InGame Admins

Das Plugin verfügt über eine eigene Admin Steuerung zu dem normalen OP System von Minecraft.

Es ist Möglich einzelnen Spielern in der Tabelle ´MCS_player´ Rechte zu zuweisen.

Folgendee Spalten existieren:
isSupporter, isModerator, isAdmin, isDonator

Die Spalten können mit einer 0 oder 1 befüllt werden. 0 Steht dabei für NEIN und 1 für JA.

## Welche Auswirkung haben die Flags.

### isSupporter = 1

Ein InGame Supporter soll die Admins beim verwalten des Servers unterstützen.
Sie sind automatisch im Support Chat und haben ein paar Rechte um Ihre Arbeit beim Schlichten zu unterstützen.

#### Verfügbare Befehle

`/kick` kickt einen Spieler vom Server der Spieler kann direkt wieder Joinen
`/fly`  der Supporter kann fliegen
`/teleport` der Supporter kann sich zu jemanden teleportieren

### isModerator = 1

Ein InGame Moderator ist die Vorstufe zum Admin und ist wie der Supporter im Chat Support.
Er verfügt zusätzlich zu den Rechten des Supporters noch über weitere Befehle.

#### Verfügbare Befehle

Alle Befehle die ein Supporter nutzen kann plus:

`/timeban` der Moderator kann einen Spieler für eine gewisse Zeit vom Server bannen
`/miner`  der Moderator kann sich das Abbau Protokoll eines Spielers anzeigen lassen.
`/gm` der Modeerator kann seinen GameMode zwischen Creative und Survivel wechseln.

### isAdmin = 1

Ein InGame Admin ist die maximale Rechte Stufe des Plugins. Er hat weiterhin kein OP auf dem Server und kann die allgemeinen Minecraft OP Befehle nicht nutzen, ist jedoch mit seinen Befehlen ausreichend ausgestattet.

#### Verfügbare Befehle

Alle Befehle die ein Moderator und Supporter nutzen kann plus:

`/ban` der Admin kann einen Spieler dauerhaft vom Server ausschließen
`/money` der Admin kann Spielern Geld generieren
`/debug` der Admin kann im debug Modus weitere Informationen bekommen
`/geben` der Admin kann Spielern Items geben
`/balance` dere Admin kann sich den Kontostand eines Spielers ansehen
