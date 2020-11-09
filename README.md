![CodeQL](https://github.com/MuellerMH/MinecraftSocial/workflows/CodeQL/badge.svg) ![Build compile and release Minecraft Social](https://github.com/MuellerMH/MinecraftSocial/workflows/Build%20compile%20and%20release%20Minecraft%20Social/badge.svg)

# Minecraft Social
Minecraft Social Server Plugin

### Inhalt des Repositories? ###

* Zusammenfassung
In diesem Repository liegt der QuellCode des MinecraftSocial Plugins.
Unter Release liegen die aktuellen Plugin Jars zu den entsprechenden Minecraft Versionen

* Version
aktuelle unterstützte Minecraft Version: 14.4.4

### Ein paar Videos

[![SpielerShop Tutorial](https://img.youtube.com/vi/PdU8wz7eN8w)](https://www.youtube.com/watch?v=PdU8wz7eN8w&t=15s)
[![Alte Servervorstellung](https://img.youtube.com/vi/uXoV3CyQoaM)](https://www.youtube.com/watch?v=uXoV3CyQoaM)
[![Servervorstellung](https://img.youtube.com/vi/KMjII45l-x4)](https://www.youtube.com/watch?v=KMjII45l-x4)
[![Live Coding NPC-Shop](https://img.youtube.com/vi/UGFalkxNiOQ)](https://www.youtube.com/watch?v=UGFalkxNiOQ)

### Kontakt zum Entwickker? ###

Slack: https://crankzone.slack.com/signup
* Other community or team contact

Get a Patron on Patreon https://www.patreon.com/deronkozockt
You can Donate on Paypal muellermh.media@gmail.com

### Installation / Setup

Um das Plugin zu betreiben benötigt Ihr das Spigot Server File, eine MariaDB und das Plugin JAR File.

#### Jar file in den plugin Ordner
Um MC-Social auf deinem Servere zu installieren, lade dir das JAR File von Bukkit oder Github herunter.

Lade das Jar File auf deinen Server in das plugin Verzeichnis

#### Datenbank Config File

Erstelle im Ordner plugin einen Unterortner MinecraftSocial. Erstelle hier eine neue Datei mit dem Namen config.yml

Die Datei muss folgende Datenbank Informationen beinhalten:

```yaml
mysql:
  adress: 192.178.178.20
  port: 3306
  username: root
  password: 1234
  database: mcstest
```

Eine Beispiel Datei findet Ihr im Github Projekt im Ordner resource.

Beim nächsten Start wird das Plugin geladen und verbindet Sich mit der Datenbank. Beim Start werden alle benötigten Datenbank Tabellen automatisch angelegt.

Weitere Anleitungen zum Projekt findet Ihr im Ordner documentationen im Github Projekt.

### Starten des Servers mit craftbukkit im Debug mdus
java -Xmx8G -Xms1G -Xdebug -Xrunjdwp:transport=dt_socket,address=1000,server=y,suspend=n -jar craftbukkit.jar

### starten des Servers mit Spigot im Debug mdus
java -Xmx6G -Xms1G  -Xdebug -Xrunjdwp:transport=dt_socket,address=1000,server=y,suspend=n -jar spigot-1.14.4.jar


