package de.mcsocial.main;

public class MySQLSetup {

	static void createTables() {
		MySQLSetup setup = new MySQLSetup();
		setup.createMCS_account();
		setup.createMCS_adminlog();
		setup.createMCS_chat();
		setup.createMCS_chunkowner();
		setup.createMCS_city();
		setup.createMCS_city_resident();
		setup.createMCS_jailcell();
		setup.createMCS_jobs();
		setup.createMCS_market();
		setup.createMCS_miner();
		setup.createMCS_npcshop();
		setup.createMCS_player();
		setup.createMCS_shop();
		setup.createMCS_skills();
		setup.createMSC_chunkaccess();
		setup.createMSC_chunkflags();
		setup.createcommands();
		setup.createderonkozockt();
	}

	private void createMCS_account() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_account` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `player` VARCHAR(55) NULL DEFAULT NULL,");
		sql.append("   `balance` DOUBLE NULL DEFAULT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 546");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `player_UNIQUE` ON `MCS_account` (`player` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `PlayerIndex` ON `MCS_account` (`player` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_adminlog() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_adminlog` (");
		sql.append("   `int` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `createtime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,");
		sql.append("   `admin` VARCHAR(255) NOT NULL,");
		sql.append("   `player` VARCHAR(255) NULL DEFAULT NULL,");
		sql.append("   `action` VARCHAR(255) NULL DEFAULT NULL,");
		sql.append("   `argument` VARCHAR(255) NULL DEFAULT NULL,");
		sql.append("   PRIMARY KEY (`int`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 934");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_chat() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_chat` (");
		sql.append("   `int` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `chattime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,");
		sql.append("   `user` VARCHAR(255) NOT NULL,");
		sql.append("   `message` TEXT NOT NULL,");
		sql.append("   PRIMARY KEY (`int`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 36179");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_chunkowner() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_chunkowner` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `chunkid` VARCHAR(55) NOT NULL,");
		sql.append("   `ownerid` VARCHAR(55) NOT NULL,");
		sql.append("   `iscity` INT(11) NULL DEFAULT NULL,");
		sql.append("   `cityname` VARCHAR(245) NULL DEFAULT NULL,");
		sql.append("   `claimedon` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,");
		sql.append("   `world` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `buyable` INT(11) NULL DEFAULT NULL,");
		sql.append("   `buyprice` DOUBLE NULL DEFAULT NULL,");
		sql.append("   `isJail` INT(11) NULL DEFAULT '0',");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 1677");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `chunkid_UNIQUE` ON `MCS_chunkowner` (`chunkid` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `chunkid` ON `MCS_chunkowner` (`chunkid` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `chunkid_2` ON `MCS_chunkowner` (`chunkid` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `Owner` ON `MCS_chunkowner` (`ownerid` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `Chunk` ON `MCS_chunkowner` (`chunkid` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `city` ON `MCS_chunkowner` (`cityname` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_city() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_city` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `name` VARCHAR(55) NOT NULL,");
		sql.append("   `owner` VARCHAR(55) NULL DEFAULT NULL,");
		sql.append("   `x` INT(11) NULL DEFAULT NULL,");
		sql.append("   `y` INT(11) NULL DEFAULT NULL,");
		sql.append("   `z` INT(11) NULL DEFAULT NULL,");
		sql.append("   `resident` TEXT NULL DEFAULT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 52");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `POSINDEX` ON `MCS_city` (`x` ASC, `y` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `INDEXNAME` ON `MCS_city` (`name` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_city_resident() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_city_resident` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `name` VARCHAR(55) NULL DEFAULT NULL,");
		sql.append("   `player` VARCHAR(55) NULL DEFAULT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 244");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `uni` ON `MCS_city_resident` (`name` ASC, `player` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `CityIndex` ON `MCS_city_resident` (`name` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `ResidentIndex` ON `MCS_city_resident` (`player` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_jailcell() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_jailcell` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `location` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `chunkid` VARCHAR(255) NULL DEFAULT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 6");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `Chunk` ON `MCS_jailcell` (`chunkid` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_jobs() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_jobs` (");
		sql.append("   `id` INT(11) NOT NULL,");
		sql.append("   `name` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `description` TEXT NULL DEFAULT NULL,");
		sql.append("   `items` TEXT NULL DEFAULT NULL,");
		sql.append("   `status` INT(11) NULL DEFAULT '0',");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_market() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_market` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `material` VARCHAR(45) NOT NULL,");
		sql.append("   `price` DOUBLE NOT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 802");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `material_UNIQUE` ON `MCS_market` (`material` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `material` ON `MCS_market` (`material` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_miner() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_miner` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `lastupdate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,");
		sql.append("   `player` VARCHAR(55) NULL DEFAULT NULL,");
		sql.append("   `type` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `count` INT(11) NULL DEFAULT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 510");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `player` ON `MCS_miner` (`player` ASC, `type` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_npcshop() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_npcshop` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `name` VARCHAR(45) NOT NULL,");
		sql.append("   `items` TEXT NULL DEFAULT NULL,");
		sql.append("   `location` VARCHAR(45) NOT NULL,");
		sql.append("   `profession` INT(1) NOT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 53");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `Uniw` ON `MCS_npcshop` (`name` ASC, `location` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_player() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_player` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `name` VARCHAR(55) NOT NULL,");
		sql.append("   `uuid` VARCHAR(55) NOT NULL,");
		sql.append("   `lastjoin` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,");
		sql.append("   `isSupporter` INT(11) NULL DEFAULT '0',");
		sql.append("   `isModerator` INT(11) NULL DEFAULT '0',");
		sql.append("   `isAdmin` INT(11) NULL DEFAULT '0',");
		sql.append("   `isDonator` INT(11) NULL DEFAULT '0',");
		sql.append("   `job` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `folk` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `nation` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `lastJobChange` BIGINT(20) NULL DEFAULT NULL,");
		sql.append("   `lastlogin` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 556");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE UNIQUE INDEX `uuid_UNIQUE` ON `MCS_player` (`uuid` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `PlayerUUID` ON `MCS_player` (`uuid` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `PlayerName` ON `MCS_player` (`name` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_shop() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_shop` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `shopName` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `owner` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `sign` VARCHAR(255) NULL DEFAULT NULL,");
		sql.append("   `chest` VARCHAR(255) NULL DEFAULT NULL,");
		sql.append("   `item` VARCHAR(255) NULL DEFAULT NULL,");
		sql.append("   `admin` INT(11) NULL DEFAULT NULL,");
		sql.append("   `amount` INT(11) NULL DEFAULT NULL,");
		sql.append("   `buyItems` INT(11) NULL DEFAULT NULL,");
		sql.append("   `signText` VARCHAR(45) NULL DEFAULT NULL,");
		sql.append("   `pricesell` DOUBLE NULL DEFAULT NULL,");
		sql.append("   `pricebuy` DOUBLE NULL DEFAULT NULL,");
		sql.append("   `createdate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" AUTO_INCREMENT = 62");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `Owner` ON `MCS_shop` (`owner` ASC);");
		MySQL.callDBUpdate(sql.toString());
		sql = new StringBuilder();
		sql.append(" CREATE INDEX `Delte` ON `MCS_shop` (`sign` ASC);");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMCS_skills() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MCS_skills` (");
		sql.append("   `int` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `user` VARCHAR(255) NOT NULL,");
		sql.append("   `item` VARCHAR(255) NOT NULL,");
		sql.append("   `points` INT(11) NOT NULL,");
		sql.append("   PRIMARY KEY (`int`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMSC_chunkaccess() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MSC_chunkaccess` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `chunkid` VARCHAR(55) NULL DEFAULT NULL,");
		sql.append("   `player` VARCHAR(55) NULL DEFAULT NULL,");
		sql.append("   `state` INT(11) NULL DEFAULT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createMSC_chunkflags() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `MSC_chunkflags` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `chunkid` VARCHAR(55) NULL DEFAULT NULL,");
		sql.append("   `flag` VARCHAR(55) NULL DEFAULT NULL,");
		sql.append("   `state` INT(11) NULL DEFAULT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = MyISAM");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createcommands() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `commands` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `command` TEXT NULL DEFAULT NULL,");
		sql.append("   `level` INT(11) NULL DEFAULT '0',");
		sql.append("   `output` TEXT NULL DEFAULT NULL,");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = InnoDB");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
	}

	private void createderonkozockt() {
		StringBuilder sql = new StringBuilder();
		sql.append(" CREATE TABLE IF NOT EXISTS `deronkozockt` (");
		sql.append("   `id` INT(11) NOT NULL AUTO_INCREMENT,");
		sql.append("   `user` TEXT NULL DEFAULT NULL,");
		sql.append("   `currency` BIGINT(20) NULL DEFAULT '0',");
		sql.append("   `subscriber` INT(11) NULL DEFAULT '0',");
		sql.append("   `regular` INT(11) NULL DEFAULT '0',");
		sql.append("   `btag` TEXT NULL DEFAULT NULL,");
		sql.append("   `userlevel` INT(11) NULL DEFAULT '0',");
		sql.append("   `display_name` TEXT NULL DEFAULT NULL,");
		sql.append("   `time_watched` BIGINT(20) NULL DEFAULT '0',");
		sql.append("   PRIMARY KEY (`id`))");
		sql.append(" ENGINE = InnoDB");
		sql.append(" AUTO_INCREMENT = 76");
		sql.append(" DEFAULT CHARACTER SET = latin1");
		MySQL.callDBUpdate(sql.toString());
	}
}
