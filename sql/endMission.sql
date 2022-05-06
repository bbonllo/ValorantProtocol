DELIMITER $$

DROP PROCEDURE IF EXISTS `valorant_protocol`.`endMission` $$
CREATE PROCEDURE `valorant_protocol`.`endMission`(in wMissionCode integer, in wType char)
BEGIN

  update mission set missionFinished = true where missionCode = wMissionCode;
  update agent set agentIsOnMission = false where agentCode in(select agentCode from agent_on_mission where missionCode = wMissionCode);

 if wType = 'A' then
  update attack_mission set stolenRadianite = FLOOR(1 + (RAND() * 99)) where attackMissionCode = wMissionCode;

else
  update defend_mission set defendedRadianite =FLOOR(1 + (RAND() * 99))  where defendMissionCode = wMissionCode;

end if;

END$$

DELIMITER;