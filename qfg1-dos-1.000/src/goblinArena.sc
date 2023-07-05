;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 445)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	goblinArena 0
	goblin 1
)

(local
	local0
	local1
	local2
)

(instance gobMusic of Sound
	(properties
		number 3
		priority 2
		loop -1
	)
)

(instance gob3Body of View
	(properties
		y 127
		x 226
		view 447
		loop 4
		priority 5
	)
)

(instance gob3Arm of Prop
	(properties
		view 447
		loop 5
		priority 6
		cycleSpeed 3
	)
)

(instance gob2Body of View
	(properties
		y 145
		x 99
		view 447
		loop 2
		priority 7
	)
)

(instance gob2Arm of Prop
	(properties
		view 447
		loop 3
		priority 8
		cycleSpeed 3
	)
)

(instance goblinBody of View
	(properties
		y 177
		x 173
		view 447
		loop 1
		priority 9
	)
)

(instance goblinHead of Prop
	(properties
		view 447
		loop 6
		priority 14
	)
)

(instance goblin of Monster
	(properties
		y 119
		x 173
		view 447
		priority 10
		cycleSpeed 1
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
		warriorX 190
		warriorY 218
		flameX 173
		flameY 93
	)

	(method (die)
		(SolvePuzzle 742 1 0)
		(super die:)
	)
)

(instance goblinArena of Arena
	(properties
		picture 400
	)

	(method (dispose)
		(gobMusic stop:)
		(gEndBattle number: (SoundFX 7) loop: 1 play:)
		(super dispose:)
	)

	(method (doit)
		(if (and (IsFlag 233) (monster script:) (== (fightScript state:) 0))
			(fightScript setScript: goblinHurt)
		)
		(if (or inTransit (> (monster health:) 0))
			(super doit:)
		else
			(= inTransit 1)
			(monster setScript: 0)
			(self setScript: killGoblin)
		)
	)

	(method (init)
		(Load rsVIEW 447)
		(= monster goblin)
		(= global332 445)
		(super init: &rest)
		(if (== gPrevRoomNum 45)
			(= local1 (+ global331 1))
		else
			(= local1 1)
		)
		(goblinBody init: setPri: 9 stopUpd:)
		(if (> local1 1)
			(if (> local1 2)
				(gob3Body setPri: 5 init: stopUpd:)
				(gob3Arm
					setPri: 6
					posn: (- (gob3Body x:) 14) (- (gob3Body y:) 40)
					init:
					stopUpd:
				)
				(if (== gHowFast 0)
					(gob3Arm setCycle: End)
				else
					(gob3Arm setCycle: Fwd)
				)
			)
			(gob2Body setPri: 7 init: stopUpd:)
			(gob2Arm
				setPri: 8
				posn: (- (gob2Body x:) 22) (- (gob2Body y:) 55)
				init:
				stopUpd:
			)
			(if (== gHowFast 0)
				(gob2Arm setCycle: End)
			else
				(gob2Arm setCycle: Fwd)
			)
		)
		(gobMusic number: (SoundFX 3) init: play:)
		(goblin
			view: 447
			setLoop: 0
			cel: 0
			setPri: 10
			init:
			stopUpd:
			setScript: fightScript
		)
	)
)

(instance fightScript of Script
	(properties)

	(method (doit)
		(if (and global251 (== state 0))
			(+= cycles global251)
			(= global251 0)
			(ClearFlag 233)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goblin cel: 0 setCycle: 0 stopUpd: action: 0)
				(= cycles (Random 10 30))
			)
			(1
				(goblin action: 2 setCycle: CT 2 1 self)
			)
			(2
				(if (goblin tryAttack: (goblin opponent:))
					(goblin doDamage: (goblin opponent:))
				)
				(goblin setCycle: End self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance goblinHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 233)
				(goblin setCel: 1 stopUpd:)
				(goblinHead
					setLoop: 6
					cel: 0
					posn: (+ (goblinBody x:) 1) (- (goblinBody y:) 74)
					setPri: 14
					cycleSpeed: 2
					init:
					setCycle: End self
				)
			)
			(1
				(goblinHead dispose:)
				(goblin setCel: -1 startUpd:)
				(self dispose:)
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
				((ScriptID 213 0) canFight: 0) ; warrior
				(if (> local1 1)
					(if (> local1 2)
						(gob3Arm setCycle: 0 stopUpd:)
					)
					(gob2Arm setCycle: 0 stopUpd:)
				)
				(goblin setCel: 1 stopUpd:)
				(goblinHead
					setLoop: 6
					cel: 0
					posn: (+ (goblinBody x:) 1) (- (goblinBody y:) 74)
					setPri: 14
					cycleSpeed: 2
					init:
					setCycle: End self
				)
			)
			(1
				(if (> local1 1)
					(TimePrint 2 445 0) ; "You killed a goblin."
					(goblinBody hide:)
					(goblin hide:)
					(if (gCast contains: goblinHead)
						(goblinHead hide:)
					)
					(= cycles 10)
				else
					(self cue:)
				)
			)
			(2
				(= local2 (not local2))
				(switch (-- local1)
					(0
						(if (== gPrevRoomNum 45)
							(++ global331)
						)
						(= global333 0)
						(goblin dispose:)
						((ScriptID 213 0) dispose:) ; warrior
						(gCurRoom newRoom: gPrevRoomNum)
					)
					(1
						(gob2Body dispose:)
						(gob2Arm dispose:)
						(goblin show:)
						(goblinBody show:)
					)
					(2
						(gob3Body dispose:)
						(gob3Arm dispose:)
						(goblin show:)
						(goblinBody show:)
						(if local2
							(gob2Body posn: 226 (gob2Body y:))
							(gob2Arm
								posn: (- (gob2Body x:) 22) (- (gob2Body y:) 55)
							)
						else
							(gob2Body posn: 99 (gob2Body y:))
							(gob2Arm
								posn: (- (gob2Body x:) 22) (- (gob2Body y:) 55)
							)
						)
						(if (== gHowFast 0)
							(gob2Arm setCycle: End)
						else
							(gob2Arm setCycle: Fwd)
						)
					)
					(else
						(if local2
							(gob2Body posn: 226 (gob2Body y:))
							(gob2Arm
								posn: (- (gob2Body x:) 22) (- (gob2Body y:) 55)
							)
							(gob3Body posn: 99 (gob3Body y:))
							(gob3Arm
								posn: (- (gob3Body x:) 14) (- (gob3Body y:) 40)
							)
						else
							(gob2Body posn: 99 (gob2Body y:))
							(gob2Arm
								posn: (- (gob2Body x:) 22) (- (gob2Body y:) 55)
							)
							(gob3Body posn: 226 (gob3Body y:))
							(gob3Arm
								posn: (- (gob3Body x:) 14) (- (gob3Body y:) 40)
							)
						)
						(goblin show:)
						(goblinBody show:)
						(if (== gHowFast 0)
							(gob2Arm setCycle: End)
							(gob3Arm setCycle: End)
						else
							(gob2Arm setCycle: Fwd)
							(gob3Arm setCycle: Fwd)
						)
					)
				)
				(if local1
					(goblin
						setLoop: 0
						cel: 0
						cycleSpeed: 1
						health: (goblin calcHealth:)
						stamina: (goblin calcStamina:)
					)
					(goblin
						setMonsterHP: (goblin health:)
						setScript: fightScript
					)
					((ScriptID 213 0) canFight: 1) ; warrior
					(HandsOn)
				)
				(goblinArena inTransit: 0)
				(self dispose:)
			)
		)
	)
)

