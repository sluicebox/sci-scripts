;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 465)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use TCyc)
(use n814)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	brigandArena 0
	brigand 1
	brigandScript 2
	killBrigand 3
	brigand2 4
)

(local
	local0
	local1
	local2
	[local3 11] = [0 0 0 1 0 2 0 1 0 0 -32768]
)

(instance brigandArena of Arena
	(properties
		picture 430
	)

	(method (dispose)
		(brigMusic stop:)
		(gLongSong2 number: 7 loop: 1 play:)
		(DisposeScript 419)
		(super dispose:)
	)

	(method (init)
		TCyc
		(= monster brigand)
		(super init: &rest)
		(if (!= gPrevRoomNum 91)
			(= global244 1)
		else
			(brigand2 init: stopUpd:)
			(brigand3 init: stopUpd:)
			(= global244 3)
		)
		(Load rsVIEW 467)
		(brigMusic number: 3 loop: -1 play:)
		(monster drawStatus: init: setScript: brigandScript)
	)
)

(instance brigMusic of Sound
	(properties
		number 3
		priority 2
		loop -1
	)
)

(instance brigand of Monster
	(properties
		x 161
		y 121
		view 467
		cycleSpeed 15
		strength 30
		intell 30
		agil 40
		vit 30
		luck 30
		weap 30
		dodge 30
		armorValue 4
		weapValue 6
		attackRange 65
		warriorX 110
		warriorY 141
		flameX 160
		flameY 83
		lowBlow 1
	)

	(method (init)
		(self ignoreActors:)
		(if (or (== gPrevRoomNum 91) (== gPrevRoomNum 73))
			(= strength (= agil (= vit (= luck (= weap (= dodge 50))))))
			(= armorValue 5)
			(= weapValue 8)
		)
		(super init: &rest)
	)

	(method (die)
		(SolvePuzzle 740 1 0)
		(self canFight: 0)
	)
)

(instance brigandScript of Script
	(properties)

	(method (doit)
		(cond
			((and global230 (== state 0))
				(self changeState: 5)
				(ClearFlag 233)
			)
			(local0
				(= local1 (= ticks 0))
			)
			(local1
				(= ticks 0)
			)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(= global279 465)
		(= global243
			(if global243
				global243
			else
				(Random 3 5)
			)
		)
		(client view: 467 setLoop: 0 cel: 0 setPri: 2)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 0)
				(client action: 0 setLoop: 0 ateEgo: 0 cycleSpeed: 22 setCel: 0)
				(if (IsFlag 285)
					(ClearFlag 285)
					(self changeState: 2)
				else
					(switch (Random 0 5)
						(0
							(client action: 3 setLoop: 3 setCycle: End self)
						)
						(1
							(client action: 3 setLoop: 3 setCycle: End self)
						)
						(2
							(client setCycle: TCyc @local3 self)
						)
						(3
							(client setCycle: CT 1 1 self)
						)
						(4
							(client action: 3 setLoop: 3 setCycle: End self)
						)
						(5
							(client action: 3 setLoop: 3 setCycle: End self)
						)
					)
				)
			)
			(1
				(if (Random 0 2)
					(= state -1)
				)
				(= ticks 18)
			)
			(2
				(= local2 1)
				(client action: 1 setLoop: 0 setCel: 0 setCycle: End self)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
			)
			(3
				(client stopUpd:)
				(if (client ateEgo:)
					(client ateEgo: 0 doDamage: (client opponent:))
					(= ticks 30)
				else
					(= ticks 18)
				)
			)
			(4
				(self changeState: 0)
			)
			(5
				(client action: 0)
				(client setCycle: 0)
				(= state -1)
				(= ticks (* global230 3))
				(= global230 0)
			)
		)
	)
)

(instance killBrigand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 102)
				(self cue:)
			)
			(1
				(if (> global244 1)
					(brigand hide:)
					(= ticks 10)
				else
					(self cue:)
				)
			)
			(2
				(switch (-- global244)
					(0
						(= global280 0)
						(gCurRoom newRoom: gPrevRoomNum)
					)
					(1
						(brigand2 dispose:)
						(brigand show: posn: 161 121)
					)
					(2
						(brigand3 dispose:)
						(brigand show: posn: 161 121)
					)
				)
				(self cue:)
			)
			(3
				(if global244
					(brigand
						setLoop: 0
						cel: 0
						cycleSpeed: 15
						health: (brigand calcHealth:)
						stamina: (brigand calcStamina:)
					)
					(brigand
						setMonsterHP: (brigand health:)
						setScript: brigandScript
					)
					(ClearFlag 102)
					(HandsOn)
				)
				(brigandArena inTransit: 0)
				(self dispose:)
			)
		)
	)
)

(instance brigand2 of View
	(properties
		x 252
		y 107
		view 467
	)
)

(instance brigand3 of View
	(properties
		x 286
		y 115
		view 467
		loop 3
	)
)

