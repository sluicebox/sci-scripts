;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use Arena)
(use Monster)
(use TCyc)
(use n814)
(use RandCycle)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	saurusArena 0
	saurus 1
	saurusScript 2
)

(local
	local0
	local1
	[local2 11] = [0 0 0 1 0 2 0 3 0 1 -32768]
	[local13 11] = [0 0 0 1 0 2 0 1 0 0 -32768]
	[local24 11] = [0 0 0 7 0 6 0 7 0 6 -32768]
	[local35 3] = [0 1 7]
)

(instance saurusArena of Arena
	(properties
		picture 432
	)

	(method (dispose)
		(saurMusic dispose:)
		(gLongSong2 number: 7 loop: 1 play:)
		(DisposeScript 419)
		(super dispose:)
	)

	(method (init)
		TCyc
		(= monster saurus)
		(= global279 430)
		(monster drawStatus:)
		(super init: &rest)
		(saurusTail init: ignoreActors: setCycle: RandCycle)
		(saurMusic number: 3 init: play:)
		(Load rsVIEW 432)
		(monster init: ignoreActors: setScript: saurusScript)
	)
)

(instance saurMusic of Sound
	(properties
		number 3
		priority 2
		loop -1
	)
)

(instance saurus of Monster
	(properties
		x 186
		y 135
		view 432
		strength 30
		intell 5
		agil 20
		vit 25
		luck 10
		weap 30
		dodge 10
		armorValue 3
		weapValue 5
		attackRange 55
		warriorX 122
		warriorY 142
		flameX 176
		flameY 91
		lowBlow 1
	)

	(method (init)
		(super init:)
	)

	(method (die)
		(SolvePuzzle 741 1 0)
		(= local1 1)
	)
)

(instance saurusScript of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (doit)
		(cond
			(local1
				(= local1 (= ticks 0))
			)
			((and global230 (== state 0))
				(self changeState: 6)
				(ClearFlag 233)
			)
		)
		(if (== state -1)
			(client cycleSpeed: (Random 15 20))
			(saurusTail cycleSpeed: (Random 20 80))
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 284)
				(client action: 0 ateEgo: 0 setLoop: 0)
				(if (IsFlag 285)
					(ClearFlag 285)
					(= state 2)
					(self cue:)
				else
					(if (not (Random 0 3))
						(= state -1)
					)
					(if (not register)
						(switch (Random 0 3)
							(0
								(client setCycle: TCyc @local13 self)
							)
							(1
								(client setCycle: TCyc @local2 self)
							)
							(2
								(client setCycle: TCyc @local24 self)
							)
							(3
								(= state -1)
								(++ register)
								(self cue:)
							)
						)
					else
						(++ register)
						(client setCel: [local35 (Random 0 2)])
						(if (> register (Random 2 4))
							(= state (= register 0))
						else
							(= state -1)
						)
						(= ticks (Random 12 16))
					)
				)
			)
			(1
				(client setCel: 0)
				(= ticks 10)
			)
			(2
				(client setLoop: 1)
				(= ticks 30)
			)
			(3
				(ClearFlag 284)
				(if (client tryAttack: (client opponent:))
					(client ateEgo: 1)
				)
				(client
					action: 1
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 4 1
				)
				(= ticks 62)
			)
			(4
				(if (client ateEgo:)
					(client ateEgo: 0 doDamage: (client opponent:))
				)
				(client setCycle: End self)
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

(instance saurusTail of Prop
	(properties
		x 189
		y 102
		view 432
		loop 2
		cycleSpeed 26
	)
)

