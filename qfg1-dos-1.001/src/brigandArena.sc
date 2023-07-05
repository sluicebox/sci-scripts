;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 465)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Actor)
(use System)

(public
	brigandArena 0
	brigand 1
)

(local
	local0
	local1
)

(instance brigandArena of Arena
	(properties
		picture 400
	)

	(method (dispose)
		(brigMusic stop:)
		(gEndBattle number: (SoundFX 7) loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 467)
		(= monster brigand)
		(body init: setPri: 1 stopUpd: addToPic:)
		(leftArm ignoreActors: init: setPri: 3 stopUpd:)
		(rightArm ignoreActors: init: setPri: 2 stopUpd:)
		(super init: &rest)
		(brigMusic number: (SoundFX 3) loop: -1 play:)
		(monster setScript: brigandScript)
	)

	(method (doit)
		(if (and (IsFlag 233) (== (brigandScript state:) 0))
			(brigandScript setScript: brigandHurt)
		)
		(if (and (<= (monster health:) 0) (== gPrevRoomNum 91) (> (-- global265) 0))
			(HighPrint 465 0) ; "You've taken out the brigand, but... oh, no! Here comes another one!"
			(= gPrevRoomNum gCurRoomNum)
			(= gCurRoomNum 91)
		)
		(super doit:)
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
		y 77
		x 152
		view 467
		loop 3
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
		warriorX 180
		warriorY 189
		flameX 162
		flameY 84
	)

	(method (init)
		(if (== gPrevRoomNum 91)
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
			((and global251 (== state 0))
				(+= cycles global251)
				(= global251 0)
				(ClearFlag 233)
			)
			(local0
				(= local1 (= cycles 0))
			)
			((and (not local1) (== cycles 10))
				(= local1 1)
				(brigand action: 3)
				(self setScript: brigandBlock)
			)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(= global332 465)
		(= global264
			(if global264
				global264
			else
				(Random 3 5)
			)
		)
		(client view: 467 setLoop: global264 cel: 0 setPri: 2 stopUpd:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client action: 0 setCel: 0)
				(rightArm setCel: 0)
				(leftArm setCel: 0)
				(= cycles (Random 10 25))
			)
			(1
				(client action: 1)
				(rightArm setCel: 2)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
				(= cycles 4)
			)
			(2
				(if (client ateEgo:)
					(client doDamage: (client opponent:) ateEgo: 0)
				)
				(rightArm setCel: 1)
				(= cycles 2)
			)
			(3
				(rightArm setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance body of View
	(properties
		y 174
		x 149
		view 467
	)
)

(instance leftArm of Prop
	(properties
		y 70
		x 180
		view 467
		loop 2
	)
)

(instance rightArm of View
	(properties
		y 71
		x 126
		view 467
		loop 1
	)
)

(instance brigandHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(ClearFlag 233)
				(brigand setCel: 1)
				(= cycles 7)
			)
			(1
				(brigand setCel: 2)
				(= cycles 3)
			)
			(2
				(= local0 0)
				(client changeState: 0)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance brigandBlock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftArm setCel: 1)
				(= cycles 8)
			)
			(1
				(= local1 0)
				(leftArm setCel: 0)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

