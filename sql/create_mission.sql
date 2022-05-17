 DELIMITER $$
DROP PROCEDURE IF EXISTS `valorant_protocol`.`createMission` $$
CREATE PROCEDURE `valorant_protocol`.`createMission` (in wMapName varchar(25),in wMissionSD date,in wMissionFD date,wType char)


BEGIN

insert into mission values(null,wMapName,wMissionSD,wMissionFD,false);

   if wType = 'A' then
insert into attack_mission(attackMissionCode) select max(missionCode) from mission;

else
insert into defend_mission(defendMissionCode) select max(missionCode) from mission;

end if;


END $$
DELIMITER;