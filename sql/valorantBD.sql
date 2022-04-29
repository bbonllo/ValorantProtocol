-- MySQL dump 10.13  Distrib 5.7.29, for Win64 (x86_64)
--
-- Host: localhost    Database: valorant_protocol
-- ------------------------------------------------------
-- Server version	5.7.29-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ability`
--

DROP TABLE IF EXISTS `ability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ability` (
  `abilityName` varchar(20) NOT NULL DEFAULT '',
  `agentCode` int(11) NOT NULL,
  `abilityDesciption` varchar(500) DEFAULT NULL,
  `orbNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`abilityName`,`agentCode`),
  KEY `agentCode` (`agentCode`),
  CONSTRAINT `ability_ibfk_1` FOREIGN KEY (`agentCode`) REFERENCES `agent` (`agentCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ability`
--

LOCK TABLES `ability` WRITE;
/*!40000 ALTER TABLE `ability` DISABLE KEYS */;
INSERT INTO `ability` VALUES ('AFTERSHOCK',13,'EQUIP a fusion charge. FIRE the charge to set a slow-acting burst through the wall. The burst does heavy damage to anyone caught in its area.',NULL),('ALARMBOT',4,'EQUIP a covert Alarmbot. FIRE to deploy a bot that hunts down enemies that get in range. After reaching its target, the bot explodes and applies Vulnerable to enemies in the area. HOLD EQUIP to recall a deployed bot.',NULL),('BARRIER ORB',7,'EQUIP a barrier orb. FIRE places a wall that fortifies after a few seconds. ALT FIRE rotates the targeter.',NULL),('BLADE STORM',10,'EQUIP a set of highly accurate throwing knives. FIRE to throw a single knife and recharge knives on a kill. ALTERNATE FIRE to throw all remaining daggers but does not recharge on a kill.',7),('BLAST PACK',12,'INSTANTLY throw a Blast Pack that will stick to surfaces. RE-USE the ability after deployment to detonate, damaging and moving anything hit.',NULL),('Blaze',9,'EQUIP a flame wall. FIRE to create a line of flames that moves forward, creating a wall that blocks vision and damages players passing through it. HOLD FIRE to bend the wall in the direction of your crosshair.',NULL),('BLINDSIDE',15,'EQUIP to rip an unstable dimensional fragment from reality. FIRE to throw the fragment, activating a flash that winds up once it collides with a hard surface in world.',NULL),('BOOM BOT',12,'EQUIP a Boom Bot. FIRE will deploy the bot, causing it to travel in a straight line on the ground, bouncing off walls. The Boom Bot will lock on to any enemies in its frontal cone and chase them, exploding for heavy damage if it reaches them.',NULL),('CLOUDBURST',10,'INSTANTLY throw a projectile that expands into a brief vision-blocking cloud on impact with a surface. HOLD the ability key to curve the smoke in the direction of your crosshair.',NULL),('COSMIC DIVIDE',16,'When Cosmic Divide is charged, use SECONDARY FIRE in Astral Form to begin aiming it, then PRIMARY FIRE to select two locations. An infinite Cosmic Divide connects the two points you select. Cosmic Divide blocks bullets and heavily dampens audio.',7),('CURVEBALL',9,'EQUIP a flare orb that takes a curving path and detonates shortly after throwing. FIRE to curve the flare orb to the left, detonating and blinding any player who sees the orb. ALTERNATE FIRE to curve the flare orb to the right.',NULL),('CYBER CAGE',5,'INSTANTLY toss the cyber cage in front of Cypher. ACTIVATE to create a zone that blocks vision and plays an audio cue when enemies pass through it.',NULL),('DARK COVER',3,'EQUIP a shadow orb, entering a phased world to place and target the orbs. PRESS the ability key to throw the shadow orb to the marked location, creating a long-lasting shadow sphere that blocks vision. HOLD FIRE while targeting to move the marker further away. HOLD SECONDARY FIRE while targeting to move the marker closer. PRESS RELOAD to toggle normal targeting view.',NULL),('DEVOUR',11,'INSTANTLY consume a nearby Soul Orb, rapidly healing for a short duration. Health gained through this skill exceeding 100 will decay over time. If Empress is active, this skill will automatically cast and not consume the Soul Orb.',NULL),('DIMENSIONAL DRIFT',15,'EQUIP a mask that can see between dimensions. FIRE to drift into Yorus dimension, unable to be affected or seen by enemies from the outside.',7),('DISMISS',11,'INSTANTLY consume a nearby Soul Orb, becoming intangible for a short duration. If Empress is active, also become invisible.',NULL),('EMPRESS',11,'INSTANTLY enter a frenzy, increasing firing, equip and reload speed dramatically. Grants infinite charges of Soul Harvest abilities. When an enemy dies to Reyna, or dies within 3 seconds of taking damage from Reyna, the duration is renewed.',6),('FAKEOUT',15,'EQUIP an echo that transforms into a mirror image of Yoru when activated. FIRE to instantly activate the mirror image and send it forward. ALT FIRE to place an inactive echo. USE to transform an inactive echo into a mirror image and send it forward. Mirror images explode in a blinding flash when destroyed by enemies.',NULL),('FAST LANE',19,'FIRE two energy lines forward on the ground that extend a short distance or until they hit a surface. The lines rise into two walls of static electricity that block vision and damage enemies passing through them.',NULL),('FAULT LINE',13,'EQUIP a seismic blast. HOLD FIRE to increase the distance. RELEASE to set off the quake, dazing all players in its zone and in a line up to the zone.',NULL),('FLASH/DRIVE',17,'EQUIP a flash grenade. FIRE to throw. The flash grenade explodes after a short fuse, blinding anyone in line of sight.',NULL),('FLASHPOINT',13,'EQUIP a blinding charge. FIRE the charge to set a fast-acting burst through the wall. The charge detonates to blind all players looking at it.',NULL),('FRAG/MENT',17,'EQUIP an explosive fragment. FIRE to throw. The fragment sticks to the floor and explodes multiple times, dealing near lethal damage at the center with each explosion.',NULL),('FROM THE SHADOWS',3,'EQUIP a tactical map. FIRE to begin teleporting to the selected location. While teleporting, Omen will appear as a Shade that can be destroyed by an enemy to cancel his teleport, or press EQUIP for Omen to cancel his teleport.',7),('GATECRASH',15,'EQUIP to harness a rift tether. FIRE to send the tether out moving forward. ALT FIRE to place a tether in place. ACTIVATE to teleport to the tethers location. USE to trigger a fake teleport.',NULL),('GRAVITY WELL',16,'Place Stars in Astral Form. ACTIVATE a Star to form a Gravity Well. Players in the area are pulled toward the center before it explodes, making all players still trapped inside vulnerable.',NULL),('GUIDING LIGHT',14,'EQUIP a hawk trinket. FIRE to send it forward. HOLD FIRE to guide the hawk in the direction of your crosshair. RE-USE while the hawk is in flight to transform it into a flash that plays a hit confirm if an enemy was within range and line of sight.',NULL),('HEADHUNTER',18,'ACTIVATE to equip a heavy pistol. ALT FIRE with the pistol equipped to aim down sights.',NULL),('HEALING ORB',7,'EQUIP a healing orb. FIRE with your crosshairs over a damaged ally to activate a heal-over-time on them. ALT FIRE while Sage is damaged to activate a self heal-over-time.',NULL),('HIGH GEAR',19,'INSTANTLY channel Neons high power for increased speed. When charged, ALT FIRE to trigger an electric slide. Slide charge resets every two kills.',NULL),('HOT HANDS',9,'EQUIP a fireball. FIRE to throw a fireball that explodes after a set amount of time or upon hitting the ground, creating a lingering fire zone that damages enemies.',NULL),('HUNTERS FURY',6,'EQUIP a bow with three long-range, wall-piercing energy blasts. FIRE to release an energy blast in a line in front of Sova, dealing damage and revealing the location of enemies caught in the line. This ability can be RE-USED up to two more times while the ability timer is active.',8),('INCENDIARY',1,'EQUIP an incendiary grenade launcher. FIRE to launch a grenade that detonates as it comes to a rest on the floor, creating a lingering fire zone that damages players within the zone.',NULL),('LEER',11,'EQUIP an ethereal, destructible eye. ACTIVATE to cast the eye a short distance forward. The eye will Nearsight all enemies who look at it.',NULL),('LOCKDOWN',4,'EQUIP the Lockdown device. FIRE to deploy the device. After a long windup, the device Detains all enemies caught in the radius. The device can be destroyed by enemies.',7),('NANOSWARM',4,'EQUIP a Nanoswarm grenade. FIRE to throw the grenade. Upon landing, the Nanoswarm goes covert. ACTIVATE the Nanoswarm to deploy a damaging swarm of nanobots.',NULL),('NEBULA',16,'Place Stars in Astral Form. ACTIVATE a Star to transform it into a Nebula (smoke). USE a Star to Dissipate it, returning the Star to be placed in a new location after a delay. Dissipate briefly forms a fake Nebula at the Stars location before returning.',NULL),('NEURAL THEFT',5,'INSTANTLY use on a dead enemy player in your crosshairs to reveal the location of all living enemy players.',6),('NOVA PULSE',16,'Place Stars in Astral Form. ACTIVATE a Star to detonate a Nova Pulse. The Nova Pulse charges briefly then strikes, concussing all players in its area.',NULL),('NULL/CMD',17,'INSTANTLY overload with polarized radianite energy that pulses from KAY/O in a massive radius. Enemies hit with pulses are suppressed for a short duration. While overloaded, KAY/O gains combat stim and can be re-stabilized if downed.',7),('ORBITAL STRIKE',1,'EQUIP a tactical map. FIRE to launch a lingering orbital strike laser at the selected location, dealing high damage-over-time to players caught in the selected area.',7),('OVERDRIVE',19,'Unleash Neons full power and speed for a short duration. FIRE to channel the power into a deadly lightning beam with high movement accuracy.',7),('OWL DRONE',6,'EQUIP an owl drone. FIRE to deploy and take control of movement of the drone. While in control of the drone, FIRE to shoot a marking dart. This dart will reveal the location of any player struck by the dart.',NULL),('PAINT SHELLS',12,'EQUIP a cluster grenade. FIRE to throw the grenade, which does damage and creates sub-munitions, each doing damage to anyone in their range.',NULL),('PARANOIA',3,'EQUIP a blinding orb. FIRE to throw it forward, briefly reducing the vision range and deafening all players it touches. This projectile can pass through walls.',NULL),('POISON CLOUD',2,'EQUIP a gas emitter. FIRE to throw the emitter that perpetually remains throughout the round. RE-USE the ability to create a toxic gas cloud at the cost of fuel. This ability can be RE-USED more than once and can be picked up to be REDEPLOYED.',NULL),('RECON BOLT',6,'EQUIP a bow with recon bolt. FIRE to send the recon bolt forward, activating upon collision and revealing the location of nearby enemies caught in the line of sight of the bolt. Enemies can destroy this bolt. HOLD FIRE to extend the range of the projectile. ALTERNATE FIRE to add up to two bounces to this arrow.',NULL),('REGROWTH',14,'EQUIP a healing trinket. HOLD FIRE to channel, healing allies in range and line of sight. Can be reused until her healing pool is depleted. Skye cannot heal herself.',NULL),('RELAY BOLT',19,'INSTANTLY throw an energy bolt that bounces once. Upon hitting each surface, the bolt electrifies the ground below with a concussive blast.',NULL),('RENDEZVOUS',18,'PLACE two teleport anchors. While on the ground and in range of an anchor, REACTIVATE to quickly teleport to the other anchor. Anchors can be picked up to be REDEPLOYED.',NULL),('RESURRECTION',7,'EQUIP a resurrection ability. FIRE with your crosshairs placed over a dead ally to begin resurrecting them. After a brief channel, the ally will be brought back to life with full health.',8),('ROLLING THUNDER',13,'EQUIP a seismic charge. FIRE to send a cascading quake through all terrain in a large line. The quake dazes and knocks up anyone caught in it.',7),('RUN IT BACK',9,'INSTANTLY place a marker at Phoenixs location. While this ability is active, dying or allowing the timer to expire will end this ability and bring Phoenix back to this location with full health.',6),('SEEKERS',14,'EQUIP a Seeker trinket. FIRE to send out three Seekers to track down the three closest enemies. If a Seeker reaches its target, it nearsights them.',7),('SHOCK BOLT',6,'EQUIP a bow with shock bolt. FIRE to send the explosive bolt forward, detonating upon collision and damaging players nearby. HOLD FIRE to extend the range of the projectile. ALTERNATE FIRE to add up to two bounces to this arrow.',NULL),('SHOWSTOPPER',12,'EQUIP a rocket launcher. FIRE shoots a rocket that does massive area damage on contact with anything.',8),('SHROUDED STEP',3,'EQUIP a shrouded step ability and see its range indicator. FIRE to begin a brief channel, then teleport to the marked location.',NULL),('SKY SMOKE',1,'EQUIP a tactical map. FIRE to set locations where Brimstones smoke clouds will land. ALTERNATE FIRE to confirm, launching long-lasting smoke clouds that block vision in the selected area.',NULL),('SLOW ORB',7,'EQUIP a slowing orb. FIRE to throw a slowing orb forward that detonates upon landing, creating a lingering field that slows players caught inside of it.',NULL),('SNAKE BITE',2,'EQUIP a chemical launcher. FIRE to launch a canister that shatters upon hitting the floor, creating a lingering chemical zone that damages and applies Vulnerable.',NULL),('SPYCAM',5,'EQUIP a spycam. FIRE to place the spycam at the targeted location. RE-USE this ability to take control of the cameras view. While in control of the camera, FIRE to shoot a marking dart. This dart will reveal the location of any player struck by the dart.',NULL),('STIM BEACON',1,'INSTANTLY toss a stim beacon in front of Brimstone. Upon landing, the stim beacon will create a field that grants players RapidFire and a speed boost.',NULL),('TAILWIND',10,'INSTANTLY propel Jett in the direction she is moving. If Jett is standing still, she will propel forward.',NULL),('TOUR DE FORCE',18,'ACTIVATE to summon a powerful, custom sniper rifle that will kill an enemy with any direct hit. Killing an enemy creates a lingering field that slows players caught inside of it.',7),('TOXIC SCREEN',2,'EQUIP a gas emitter launcher. FIRE to deploy a long line of gas emitters. RE-USE the ability to create a tall wall of toxic gas at the cost of fuel. This ability can be RE-USED more than once.',NULL),('TRADEMARK',18,'PLACE a trap that scans for enemies. When a visible enemy comes in range, the trap counts down and then destabilizes the terrain around them, creating a lingering field that slows players caught inside of it.',NULL),('TRAILBLAZER',14,'EQUIP a Tasmanian tiger trinket. FIRE to send out and take control of the predator. While in control, FIRE to leap forward, exploding in a concussive blast and damaging directly hit enemies.',NULL),('TRAPWIRE',5,'EQUIP a trapwire. FIRE to place a destructible and covert tripwire at the targeted location, creating a line that spans between the placed location and the wall opposite. Enemy players who cross a tripwire will be tethered, revealed, and dazed after a short period if they do not destroy the device in time. This ability can be picked up to be REDEPLOYED.',NULL),('TURRET',4,'EQUIP a Turret. FIRE to deploy a turret that automatically fires at enemies in a 180 degree cone. HOLD EQUIP to recall the deployed turret.',NULL),('UPDRAFT',10,'INSTANTLY propel Jett high into the air.',NULL),('VIPERS PIT',2,'EQUIP a chemical sprayer. FIRE to spray a chemical cloud in all directions around Viper, creating a large cloud that reduces the vision range of players and maximum health of enemies inside of it. HOLD the ability key to disperse the cloud early.',7),('ZERO/POINT',17,'EQUIP a suppression blade. FIRE to throw. The blade sticks to the first surface it hits, winds up, and suppresses anyone in the radius of the explosion.',NULL);
/*!40000 ALTER TABLE `ability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent` (
  `agentCode` int(11) NOT NULL DEFAULT '0',
  `agentPasswd` varchar(30) DEFAULT NULL,
  `agentName` varchar(16) DEFAULT NULL,
  `agentNationality` varchar(25) DEFAULT NULL,
  `agentRol` varchar(25) DEFAULT NULL,
  `agentIsAdmin` tinyint(1) DEFAULT NULL,
  `agentIsOnMission` tinyint(1) DEFAULT NULL,
  `agentIsActive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`agentCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES (0,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,'abcd*1234','Brimstone','American','Controller',1,0,1),(2,'venenito','Viper','American','Controller',1,0,1),(3,'omengatitouwu','Omen','Unknown','Controller',1,0,1),(4,'abcd*1234','Killjoy','German','Sentinel',1,0,1),(5,'n0ra*1234','Cypher','Moroccan','Sentinel',1,0,1),(6,'nightowl123','Sova','Russian','Initiator',1,0,1),(7,'abcd*1234','Sage','Chinese','Sentinel',1,0,1),(9,'F1r3b0y','Phoenix','British','Duelist',0,0,1),(10,'W1ndG1rl','Jett','Korean','Duelist',0,0,1),(11,'VampireQueen','Reyna','Mexican','Duelist',0,0,1),(12,'BOOOM','Raze','Brazilian','Duelist',0,0,1),(13,'1234','Breach','Swede','Initiator',1,0,1),(14,'HAWKOUT123','Skye','Australian','Initiator',0,0,1),(15,'dimensionalboy','Yoru','Japanese','Duelist',0,0,1),(16,'StarG1rl','Astra','Ghanaian','Controller',0,0,1),(17,'toastbot','KAY/O','Unknown','Initiator',0,0,1),(18,'baguette','Chamber','French','Sentinel',0,0,1),(19,'Rayosuperpoderoso','Neon','Filipino','Duelist',0,0,1);
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent_on_mission`
--

DROP TABLE IF EXISTS `agent_on_mission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_on_mission` (
  `missionCode` int(11) NOT NULL DEFAULT '0',
  `agentCode` int(11) DEFAULT NULL,
  `WeaponName` varchar(16) NOT NULL,
  PRIMARY KEY (`WeaponName`,`missionCode`),
  KEY `missionCode` (`missionCode`),
  KEY `agentCode` (`agentCode`),
  CONSTRAINT `agent_on_mission_ibfk_1` FOREIGN KEY (`missionCode`) REFERENCES `mission` (`missionCode`),
  CONSTRAINT `agent_on_mission_ibfk_2` FOREIGN KEY (`agentCode`) REFERENCES `agent` (`agentCode`),
  CONSTRAINT `agent_on_mission_ibfk_3` FOREIGN KEY (`WeaponName`) REFERENCES `weapon` (`weaponName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent_on_mission`
--

LOCK TABLES `agent_on_mission` WRITE;
/*!40000 ALTER TABLE `agent_on_mission` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent_on_mission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attack_mission`
--

DROP TABLE IF EXISTS `attack_mission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attack_mission` (
  `attackMissionCode` int(11) NOT NULL DEFAULT '0',
  `stolenRadianite` int(11) DEFAULT NULL,
  PRIMARY KEY (`attackMissionCode`),
  CONSTRAINT `attack_mission_ibfk_1` FOREIGN KEY (`attackMissionCode`) REFERENCES `mission` (`missionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attack_mission`
--

LOCK TABLES `attack_mission` WRITE;
/*!40000 ALTER TABLE `attack_mission` DISABLE KEYS */;
/*!40000 ALTER TABLE `attack_mission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `defend_mission`
--

DROP TABLE IF EXISTS `defend_mission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defend_mission` (
  `defendMissionCode` int(11) NOT NULL DEFAULT '0',
  `defendedRadianite` int(11) DEFAULT NULL,
  PRIMARY KEY (`defendMissionCode`),
  CONSTRAINT `defend_mission_ibfk_1` FOREIGN KEY (`defendMissionCode`) REFERENCES `mission` (`missionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `defend_mission`
--

LOCK TABLES `defend_mission` WRITE;
/*!40000 ALTER TABLE `defend_mission` DISABLE KEYS */;
/*!40000 ALTER TABLE `defend_mission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map`
--

DROP TABLE IF EXISTS `map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `map` (
  `mapName` varchar(16) NOT NULL DEFAULT '',
  `mapDesc` varchar(800) DEFAULT NULL,
  PRIMARY KEY (`mapName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map`
--

LOCK TABLES `map` WRITE;
/*!40000 ALTER TABLE `map` DISABLE KEYS */;
INSERT INTO `map` VALUES ('Ascent','An open playground for small wars of position and attrition divide two sites on Ascent. Each site can be fortified by irreversible bomb doors; once they’re down, you’ll have to destroy them or find another way. Yield as little territory as possible.'),('Bind','Two sites. No middle. Gotta pick left or right. What’s it going to be then? Both offer direct paths for attackers and a pair of one-way teleporters make it easier to flank.'),('Breeze','Take in the sights of historic ruins or seaside caves on this tropical paradise. But bring some cover. You´ll need them for the wide open spaces and long range engagements. Watch your flanks and this will be a Breeze.'),('Fracture','A top secret research facility split apart by a failed radianite experiment. With defender options as divided as the map, the choice is yours: meet the attackers on their own turf or batten down the hatches to weather the assault.'),('Haven','Beneath a forgotten monastery, a clamour emerges from rival Agents clashing to control three sites. There’s more territory to control, but defenders can use the extra real estate for aggressive pushes.'),('Icebox','Your next battleground is a secret Kingdom excavation site overtaken by the arctic. The two plant sites protected by snow and metal require some horizontal finesse. Take advantage of the ziplines and they’ll never see you coming.'),('Split','If you want to go far, you’ll have to go up. A pair of sites split by an elevated center allows for rapid movement using two rope ascenders. Each site is built with a looming tower vital for control. Remember to watch above before it all blows sky-high.');
/*!40000 ALTER TABLE `map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission`
--

DROP TABLE IF EXISTS `mission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mission` (
  `missionCode` int(11) NOT NULL AUTO_INCREMENT,
  `mapName` varchar(25) DEFAULT NULL,
  `missionSD` date DEFAULT NULL,
  `missionFD` date DEFAULT NULL,
  `missionFinished` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`missionCode`),
  KEY `mapName` (`mapName`),
  CONSTRAINT `mission_ibfk_1` FOREIGN KEY (`mapName`) REFERENCES `map` (`mapName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission`
--

LOCK TABLES `mission` WRITE;
/*!40000 ALTER TABLE `mission` DISABLE KEYS */;
/*!40000 ALTER TABLE `mission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weapon`
--

DROP TABLE IF EXISTS `weapon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weapon` (
  `weaponName` varchar(16) NOT NULL DEFAULT '',
  `weaponDamage` int(11) DEFAULT NULL,
  `weaponType` varchar(16) DEFAULT NULL,
  `weaponSubType` varchar(25) DEFAULT NULL,
  `weaponIsActive` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`weaponName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weapon`
--

LOCK TABLES `weapon` WRITE;
/*!40000 ALTER TABLE `weapon` DISABLE KEYS */;
INSERT INTO `weapon` VALUES ('Ares',30,'Primary','Machine gun',1),('Bucky',20,'Primary','Shotgun',1),('Bulldog',35,'Primary','Rifle',1),('Classic',26,'Secondary',NULL,1),('Frenzy',26,'Secondary',NULL,1),('Ghost',30,'Secondary',NULL,1),('Guardian',65,'Primary','Rifle',1),('Judge',17,'Primary','Shotgun',1),('Marshall',101,'Primary','Sniper',1),('Odin',38,'Primary','Machine gun',1),('Operator',150,'Primary','Sniper',1),('Phantom',39,'Primary','Rifle',1),('Sheriff',55,'Secondary',NULL,1),('Shorty',12,'Secondary',NULL,1),('Spectre',26,'Primary','SMG',1),('Stinger',27,'Primary','SMG',1),('Vandal',40,'Primary','Rifle',1);
/*!40000 ALTER TABLE `weapon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-26 10:20:43
