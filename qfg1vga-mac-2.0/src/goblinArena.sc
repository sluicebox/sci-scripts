;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 445)
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
	goblinArena 0
	goblin 1
	fightScript 2
	killGoblin 3
	goblin2 4
)

(local
	local0
	local1
	local2
	[local3 13] = [0 1 0 3 0 1 0 0 0 1 0 3 -32768]
)

(instance gobMusic of Sound
	(properties
		number 3
		priority 2
		loop -1
	)
)

(instance goblin of Monster
	(properties
		x 166
		y 106
		view 447
		priority 10
		cycleSpeed 15
		illegalBits 0
		strength 30
		intell 20
		agil 25
		vit 30
		luck 20
		weap 30
		dodge 30
		armorValue 3
		armorEnc 1400
		weapValue 5
		attackRange 40
		warriorX 119
		warriorY 145
		flameX 162
		flameY 77
		lowBlow 1
	)

	(method (init)
		(super init:)
	)

	(method (die)
		(SolvePuzzle 742 1 0)
		(super die:)
	)
)

(instance goblinArena of Arena
	(properties
		picture 430
	)

	(method (dispose)
		(gobMusic stop:)
		(DisposeScript 419)
		(gLongSong2 number: 7 loop: 1 play:)
		(super dispose:)
	)

	(method (doit)
		(if (or inTransit (> (monster health:) 0))
			(super doit:)
		)
	)

	(method (init)
		TCyc
		(= monster goblin)
		(= global279 445)
		(monster drawStatus:)
		(super init: &rest)
		(if (== gPrevRoomNum 45)
			(= local1 (+ global278 1))
		else
			(= local1 1)
		)
		(Load rsVIEW 447)
		(if (> local1 1)
			(goblin2 init: stopUpd:)
			(if (> local1 2)
				(goblin3 init: stopUpd:)
			)
		)
		(gobMusic number: 3 init: play:)
		(goblin
			view: 447
			setLoop: 0
			cel: 0
			setPri: 7
			init:
			stopUpd:
			setScript: fightScript
		)
	)
)

(instance fightScript of Script
	(properties)

	(method (doit)
		(if (and global230 (== state 0))
			(self changeState: 6)
			(ClearFlag 233)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setCel: 0
					ateEgo: 0
					setCycle: 0
					cycleSpeed: (Random 15 18)
				)
				(if (IsFlag 285)
					(ClearFlag 285)
					(self cue:)
				else
					(switch (Random 0 3)
						(0
							(client action: 0 setLoop: 3 setCycle: End self)
						)
						(1
							(client setLoop: 2 action: 3 setCycle: End self)
						)
						(2
							(client action: 0 setCycle: TCyc @local3 self)
						)
						(3
							(client setLoop: 2 action: 3 setCycle: End self)
						)
					)
				)
			)
			(1
				(if (not (Random 0 3))
					(= state -1)
				)
				(= ticks (Random 15 18))
			)
			(2
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
				(client setLoop: 0 setCel: 0 action: 1 setCycle: CT 2 1)
				(= ticks 60)
			)
			(3
				(if (client ateEgo:)
					(client doDamage: (client opponent:))
					(client ateEgo: 0)
				)
				(client setCycle: End self)
			)
			(4
				(client stopUpd:)
				(= ticks 15)
			)
			(5
				(self changeState: 0)
			)
			(6
				(client action: 0)
				(client setCycle: 0)
				(= state -1)
				(= ticks (* global230 3))
				(= global230 0)
			)
		)
	)
)

(instance killGoblin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 102)
				(self cue:)
			)
			(1
				(if (> local1 1)
					(goblin hide: forceUpd:)
					(= ticks 10)
				else
					(self cue:)
				)
			)
			(2
				(= local2 (not local2))
				(switch (-- local1)
					(0
						(if (== gPrevRoomNum 45)
							(++ global278)
						)
						(= global280 0)
						(goblinArena inTransit: 0)
						(gCurRoom newRoom: gPrevRoomNum)
					)
					(1
						(goblin2 dispose:)
						(goblin show: posn: 166 106)
					)
					(2
						(goblin3 dispose:)
						(goblin show: posn: 166 106)
					)
					(else
						(goblin show: posn: 166 106)
					)
				)
				(self cue:)
			)
			(3
				(if local1
					(goblin
						setLoop: 0
						cel: 0
						cycleSpeed: 12
						health: (goblin calcHealth:)
						stamina: (goblin calcStamina:)
					)
					(goblin
						setMonsterHP: (goblin health:)
						setScript: fightScript
					)
					(HandsOn)
				)
				(ClearFlag 102)
				(goblinArena inTransit: 0)
				(self dispose:)
			)
		)
	)
)

(instance goblin2 of View
	(properties
		x 216
		y 88
		view 447
	)
)

(instance goblin3 of View
	(properties
		x 246
		y 88
		view 447
	)
)

