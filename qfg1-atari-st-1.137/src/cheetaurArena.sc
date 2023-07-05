;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	cheetaurArena 0
	cheetaur 1
)

(local
	local0
	[local1 2]
	local3
	[local4 3]
	[local7 3]
	[local10 3] = [2 0 0]
	[local13 3] = [1 2 2]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(= [local7 temp0] (Clone aFightScript))
		([local4 temp0] setScript: [local7 temp0] 0 temp0)
	)
)

(instance leftArm of Prop
	(properties
		y 65
		x 208
		view 442
		loop 2
	)
)

(instance rightArm of Prop
	(properties
		y 73
		x 138
		view 442
		loop 3
	)
)

(instance cheetMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

(instance tail of Prop
	(properties
		y 137
		x 230
		view 442
		loop 4
		cel 2
	)
)

(instance chest of PV
	(properties
		y 110
		x 189
		view 442
		loop 1
		priority 5
	)
)

(instance cheetaur of Monster
	(properties
		view 442
		strength 70
		intell 65
		agil 70
		vit 50
		luck 30
		weap 40
		dodge 60
		armorValue 3
		weapValue 5
		attackRange 65
		warriorX 190
		warriorY 200
		flameX 177
		flameY 89
	)

	(method (die)
		(SolvePuzzle 612 4 0)
		(= local0 1)
	)
)

(instance cheetaurArena of Arena
	(properties
		picture 440
	)

	(method (dispose)
		(cheetMusic stop:)
		(gEndBattle number: (SoundFX 38) loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 442)
		(= monster cheetaur)
		(= global332 440)
		(super init: &rest)
		(tail setPri: 2 init: setCycle: Fwd startUpd:)
		(chest init:)
		(gAddToPics add: chest doit:)
		(leftArm setPri: 12 init: stopUpd:)
		(rightArm setPri: 12 init: stopUpd:)
		(cheetaur view: 442 setLoop: 5 cel: 2 posn: 172 42 setPri: 10 stopUpd:)
		(= [local4 0] cheetaur)
		(= [local4 1] leftArm)
		(= [local4 2] rightArm)
		(cheetMusic number: (SoundFX 2) init: play:)
		(localproc_0)
	)

	(method (doit)
		(if
			(and
				(IsFlag 233)
				(== (cheetaur script:) [local7 0])
				(== ([local7 0] state:) 0)
			)
			((cheetaur script:) setScript: cheetaurHurt)
		)
		(super doit:)
	)
)

(instance aFightScript of Script
	(properties)

	(method (doit)
		(cond
			((and local0 (== client cheetaur))
				(= local0 (= cycles 0))
			)
			((and global251 (== state 0) (not script))
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
				([local4 register] cel: [local10 register] setCycle: 0 stopUpd:)
				(if (== client cheetaur)
					(cheetaur y: 42 setLoop: 5 cycleSpeed: 3 setCycle: Fwd)
				)
				(cheetaur action: 0)
				(if (< cycles 15)
					(= cycles (Random 12 20))
				)
			)
			(1
				(= local3 (Random 0 1))
				(cheetaur action: 1)
				(if (== client cheetaur)
					(cheetaur y: (+ (cheetaur y:) 6) setLoop: 0)
					(self cue:)
				else
					([local4 register] setCycle: CT [local13 register] 1 self)
				)
				(if (cheetaur tryAttack: (cheetaur opponent:))
					(cheetaur ateEgo: 1)
				)
			)
			(2
				(if (cheetaur ateEgo:)
					(cheetaur doDamage: (cheetaur opponent:))
					(cheetaur ateEgo: 0)
				)
				(cond
					((== client cheetaur)
						(cheetaur cycleSpeed: 1 setCycle: End self)
					)
					(local3
						([local4 register]
							setCycle: CT ([local4 register] cel:) 1 self
						)
					)
					(else
						(client setCycle: End self)
					)
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance cheetaurHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 233)
				(cheetaur setLoop: 6 cel: 0 setCycle: Fwd)
				(= cycles 8)
			)
			(1
				(client setScript: 0)
			)
		)
	)
)

