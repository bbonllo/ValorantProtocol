DELIMITER $$

DROP PROCEDURE IF EXISTS `valorant_protocol`.`bring` $$
CREATE PROCEDURE `bring`(in wUserAgent INT)
BEGIN
DECLARE currentMission INT DEFAULT 0;
DECLARE  agentCod1 INT DEFAULT 0;
DECLARE  agentCod2 INT DEFAULT 0;
DECLARE  agentCod3 INT DEFAULT 0;
DECLARE  agentCod4 INT DEFAULT 0;
DECLARE  agentCod5 INT DEFAULT 0;

SELECT DISTINCT missionCode INTO currentMission FROM agent_on_mission where missionCode in(select missionCode from mission where missionFinished = false) and agentCode = wUserAgent;
SELECT agentCode into agentCod1 FROM agent_on_mission WHERE missionCode = currentMission and agentCode =  wUserAgent group by agentCode;
SELECT agentCode into agentCod2 FROM agent_on_mission WHERE missionCode = currentMission and   agentCode != agentCod1 group by agentCode  LIMIT 1;
SELECT agentCode into agentCod3 FROM agent_on_mission WHERE missionCode = currentMission and   agentCode != agentCod1 and agentCode != agentCod2 group by agentCode LIMIT 1;
SELECT agentCode into agentCod4 FROM agent_on_mission WHERE missionCode = currentMission and   agentCode != agentCod1 and agentCode != agentCod2 and agentCode != agentCod3 group by agentCode  LIMIT 1;
SELECT agentCode into agentCod5 FROM agent_on_mission WHERE missionCode = currentMission and   agentCode != agentCod1 and agentCode != agentCod2 and agentCode != agentCod3  and agentCode != agentCod4 group by agentCode  LIMIT 1;

DROP TABLE IF EXISTS LOG_RECORD;
CREATE TABLE log_record(
agentcode1 int,
agentcode2 INT,
agentcode3 INT,
agentcode4 INT,
agentcode5 INT);

insert into log_record values(agentCod1,agentCod2,agentCod3,agentCod4,agentCod5);

END $$

DELIMITER ;