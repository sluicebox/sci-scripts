;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	trollArena 0
	troll 1
)

(local
	local0
	local1
	[local2 4]
	local6
	local7
)

(instance trollArena of Arena
	(properties
		picture 400
	)

	(method (dispose)
		(trollMusic stop:)
		(gEndBattle number: (SoundFX 38) loop: 1 play:)
		(super dispose:)
	)

	(method (init)
		(= monster troll)
		(= global332 450)
		(Load rsVIEW 452)
		(super init: &rest)
		(trollLegs init:)
		(trollMusic number: (SoundFX 2) loop: -1 play:)
		(monster setScript: trollScript)
	)
)

(instance trollMusic of Sound
	(properties
		number 2
		priority 2
		loop -1
	)
)

(instance troll of Monster
	(properties
		y 93
		x 157
		view 452
		priority 10
		strength 80
		intell 30
		agil 40
		vit 60
		luck 30
		weap 65
		dodge 50
		armorValue 5
		weapValue 8
		attackRange 65
		warriorX 185
		warriorY 200
		flameX 166
		flameY 74
	)

	(method (init)
		(if (or (== gPrevRoomNum 88) (== gPrevRoomNum 89))
			(= strength (= agil (= vit (= luck (= weap (= dodge 80))))))
			(= intell 60)
			(= weapValue 9)
			(= armorValue 6)
		)
		(super init: &rest)
	)

	(method (die)
		(SolvePuzzle 611 4 0)
		(self canFight: 0)
	)
)

(instance trollScript of Script
	(properties)

	(method (doit)
		(if (and global251 (== state 0))
			(+= cycles global251)
			(= global251 0)
			(ClearFlag 233)
		)
		(if (IsFlag 233)
			(= cycles 0)
			(client setScript: trollHurt)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(= local1 1)
		(client view: 452 setLoop: 0 setPri: 10 illegalBits: 0 cel: 8)
		(trollLegs addToPic:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client action: 0 stopUpd:)
				(if local6
					(= local6 0)
					(= cycles 2)
				else
					(= cycles (Random 15 25))
				)
			)
			(1
				(switch (Random 1 8)
					(1
						(= [local2 0] 0)
						(= [local2 1] 1)
						(= [local2 2] 2)
						(= [local2 3] 1)
						(= [local2 4] 0)
					)
					(2
						(= [local2 0] 4)
						(= [local2 1] 3)
						(= [local2 2] 2)
						(= [local2 3] 3)
						(= [local2 4] 4)
					)
					(3
						(= [local2 0] 4)
						(= [local2 1] 3)
						(= [local2 2] 2)
						(= [local2 3] 1)
						(= [local2 4] 0)
					)
					(4
						(= [local2 0] 0)
						(= [local2 1] 1)
						(= [local2 2] 2)
						(= [local2 3] 3)
						(= [local2 4] 4)
					)
					(5
						(= [local2 0] 0)
						(= [local2 1] 4)
						(= [local2 2] 3)
						(= [local2 3] 4)
						(= [local2 4] 4)
					)
					(6
						(= [local2 0] 4)
						(= [local2 1] 0)
						(= [local2 2] 1)
						(= [local2 3] 0)
						(= [local2 4] 0)
					)
					(7
						(= [local2 0] 0)
						(= [local2 1] 1)
						(= [local2 2] 2)
						(= [local2 3] 1)
						(= [local2 4] 0)
					)
					(8
						(= [local2 0] 0)
						(= [local2 1] 1)
						(= [local2 2] 2)
						(= [local2 3] 3)
						(= [local2 4] 4)
					)
				)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
				(client action: 1 startUpd: setCel: [local2 0])
				(= cycles local1)
			)
			(2
				(client setCel: [local2 1])
				(= cycles local1)
			)
			(3
				(client setCel: [local2 2])
				(= cycles 2)
			)
			(4
				(client setCel: [local2 3])
				(if (and (not local7) (== [local2 2] 2) (client ateEgo:))
					(client doDamage: (client opponent:) ateEgo: 0)
				)
				(= cycles local1)
			)
			(5
				(client setCel: [local2 4])
				(= cycles local1)
			)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance trollLegs of View
	(properties
		y 110
		x 158
		view 452
		loop 1
		priority 4
	)
)

(instance trollFace of Prop
	(properties
		y 63
		x 158
		view 452
	)
)

(instance trollHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 233)
				(trollFace init: setLoop: 2 setPri: 14 setCycle: End self)
			)
			(1
				(trollFace dispose:)
				(= local6 1)
				(client setScript: trollScript 1)
			)
		)
	)
)

