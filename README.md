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

Weitere Anleitungen zum Projekt findet Ihr im Wiki des Github Projekts.

### Starten des Servers mit craftbukkit im Debug mdus
java -Xmx8G -Xms1G -Xdebug -Xrunjdwp:transport=dt_socket,address=1000,server=y,suspend=n -jar craftbukkit.jar

### starten des Servers mit Spigot im Debug mdus
java -Xmx6G -Xms1G  -Xdebug -Xrunjdwp:transport=dt_socket,address=1000,server=y,suspend=n -jar spigot-1.14.4.jar


[CodeQL](https://github.com/MuellerMH/MinecraftSocial/workflows/CodeQL/badge.svg) [Build compile and release Minecraft Social](https://github.com/MuellerMH/MinecraftSocial/workflows/Build%20compile%20and%20release%20Minecraft%20Social/badge.svg)

# Minecraft Social
Minecraft Social Server Plugin

### Content of the repository? ###

* summary
This repository contains the source code of the MinecraftSocial plugin.
Under Release are the current plugin jars for the corresponding Minecraft versions

* version
current supported Minecraft version: 14.4.4

### A few videos

[![PlayerShop Tutorial](https://img.youtube.com/vi/PdU8wz7eN8w)](https://www.youtube.com/watch?v=PdU8wz7eN8w&t=15s)
[![Old server presentation](https://img.youtube.com/vi/uXoV3CyQoaM)](https://www.youtube.com/watch?v=uXoV3CyQoaM)
[![Server presentation](https://img.youtube.com/vi/KMjII45l-x4)](https://www.youtube.com/watch?v=KMjII45l-x4)
[![Live Coding NPC Shop](https://img.youtube.com/vi/UGFalkxNiOQ)](https://www.youtube.com/watch?v=UGFalkxNiOQ)

### Contact the developer? ###

Slack: https://crankzone.slack.com/signup
* Other community or team contact

Get a Patron on Patreon https://www.patreon.com/deronkozockt
You can Donate on Paypal muellermh.media@gmail.com

### Installation / Setup

To run the plugin you need the Spigot Server File, a MariaDB and the plugin JAR File.

#### Jar file into the plugin folder
To install MC-Social on your server, download the JAR file from Bukkit or Github

Download the Jar file on your server into the plugin directory

#### Database Config File

Create a subortner MinecraftSocial in the folder plugin. Create here a new file with the name config.yml

The file must contain the following database information:

``yaml
mysql:
  address: 192.178.178.20
  port: 3306
  username: root
  password: 1234
  database: mcstest
```

An example file can be found in the resource folder of the github project.

At the next start the plugin will be loaded and connects to the database. At startup all required database tables are created automatically.

You can find further instructions in the Github project's Wiki.

### Starting the server with craftbukkit in debug mdus
java -Xmx8G -Xms1G -Xdebug -Xrunjdwp:transport=dt_socket,address=1000,server=y,suspend=n -jar craftbukkit.jar

### start the server with spigot in debug mdus
java -Xmx6G -Xms1G -Xdebug -Xrunjdwp:transport=dt_socket,address=1000,server=y,suspend=n -jar spigot-1.14.4.jar

 Translated with www.DeepL.com/Translator (free version)