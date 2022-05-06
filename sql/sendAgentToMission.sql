DELIMITER $$

DROP PROCEDURE IF EXISTS `valorant_protocol`.`sendAgentToMission` $$
CREATE PROCEDURE `sendAgentToMission`(in wMissionCode integer, in wAgentCode integer ,
in wPrimaryWeaponName varchar(16), in wSecondaryWeaponName varchar(16))
BEGIN
      insert into agent_on_mission values(wMissionCode,wAgentCode,wPrimaryWeaponName);
      insert into agent_on_mission values(wMissionCode,wAgentCode,wSecondaryWeaponName);
      update agent set agentIsOnMission = true where agentCode = wAgentCode;
END $$

DELIMITER ;