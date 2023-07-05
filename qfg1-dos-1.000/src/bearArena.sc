;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	bearArena 0
	bear 1
)

(local
	local0
	[local1 2]
	local3
	[local4 3]
	[local7 3]
	local10
	local11 = 5
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 2) ((++ temp0))
		(= [local7 temp0] (Clone aFightScript))
		([local4 temp0] setScript: [local7 temp0] 0 temp0)
	)
)

(instance leftArm of Prop
	(properties
		y 39
		x 199
		view 422
		loop 2
	)
)

(instance rightArm of Prop
	(properties
		y 42
		x 115
		view 422
		loop 1
	)
)

(instance bearMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

(instance bear of Monster
	(properties
		view 422
		strength 70
		intell 25
		agil 40
		vit 65
		luck 25
		weap 50
		dodge 60
		armorValue 3
		weapValue 5
		attackRange 65
		warriorX 170
		flameX 172
		flameY 73
	)

	(method (die)
		(= local0 1)
		(SetFlag 169)
		(SolvePuzzle 601 -25)
		(gCurRoom newRoom: 171) ; rmBear
	)
)

(instance bearArena of Arena
	(properties
		picture 420
	)

	(method (dispose)
		(bearMusic stop:)
		(gEndBattle number: (SoundFX 38) loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 422)
		(= monster bear)
		(= global332 420)
		(= gPrevRoomNum 171) ; rmBear
		(super init: &rest)
		(leftArm setPri: 12 init: stopUpd:)
		(rightArm setPri: 12 init: stopUpd:)
		(bear
			view: 422
			setLoop: 0
			cel: 0
			posn: 156 68
			setPri: 10
			cycleSpeed: 2
			setScript: bearCycle
		)
		(= [local4 0] leftArm)
		(= [local4 1] rightArm)
		(bearMusic number: (SoundFX 2) init: play:)
		(localproc_0)
	)

	(method (doit)
		(if (IsFlag 233)
			(bear setScript: bearHurt)
		)
		(super doit:)
	)
)

(instance aFightScript of Script
	(properties)

	(method (doit)
		(cond
			(local0
				(= local0 (= cycles 0))
			)
			((and global251 (== state 0))
				(+= cycles global251)
				(= global251 0)
				(ClearFlag 233)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				([local4 register] cel: local10 setCycle: 0 stopUpd:)
				(bear action: 0)
				(= cycles (Random 20 30))
			)
			(1
				(= local3 (Random 0 1))
				(bear action: 1)
				([local4 register] setCycle: CT local11 1 self)
				(if (bear tryAttack: (bear opponent:))
					(bear ateEgo: 1)
				)
			)
			(2
				(if (bear ateEgo:)
					(bear doDamage: (bear opponent:))
					(bear ateEgo: 0)
				)
				(if local3
					([local4 register]
						setCycle: CT ([local4 register] cel:) 1 self
					)
				else
					(client setCycle: End self)
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance bearHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 233)
				(bear setLoop: 0 cel: 1 cycleSpeed: 0 setCycle: End self)
			)
			(1
				(= cycles (Random 2 4))
			)
			(2
				(bear cel: 4)
				(= cycles (Random 2 4))
			)
			(3
				(bear cel: 5)
				(= cycles (Random 2 4))
			)
			(4
				(bear cycleSpeed: 1 setCycle: Beg self)
			)
			(5
				(bear cel: 0 cycleSpeed: 2 setScript: bearCycle)
			)
		)
	)
)

(instance bearCycle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bear setCycle: CT 3 1)
				(= cycles (Random 9 15))
			)
			(1
				(bear setCycle: Beg self)
				(= cycles (Random 9 15))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

