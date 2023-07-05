;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 604)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	death1Script 0
	death2Script 1
	death3Script 2
	death4Script 3
	cedric 5
	tigerStuffScript 6
	summonWandScript 7
)

(instance death1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 896 loop: 1 play:)
				(= cycles 10)
			)
			(1
				(gMordObj
					setMotion:
						MoveTo
						(- (gEgo x:) 8)
						(- (gEgo y:) 13)
						self
				)
			)
			(2
				(gEgo dispose:)
				(= seconds 5)
			)
			(3
				(= global103 0)
				(= global330
					{That wasn't a smart move, Graham!}
				)
				(EgoDead)
			)
		)
	)
)

(instance death2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 896 loop: 1 play:)
				(global390 setCycle: End self)
				(switch global387
					(4
						(global388 dispose:)
						(global389 dispose:)
						(gEgo view: 722 setLoop: 11 cel: 0 setCycle: CT 1 1)
					)
				)
			)
			(1
				(global392
					view: 728
					setLoop: 6
					illegalBits: 0
					ignoreActors:
					posn: (+ (global390 x:) 64) (global390 y:)
					setStep: 6 6
					setPri: 13
					init:
				)
				(RedrawCast)
				(global392
					setMotion:
						MoveTo
						(+ (global392 x:) 40)
						(+ (global392 y:) 40)
						self
				)
				(gGlobalSound4 number: 200 vol: 127 priority: 10 loop: 1 play:)
				(global390 setCycle: Beg)
			)
			(2
				(if (!= global387 4)
					(global388 dispose:)
					(global389 dispose:)
				)
				(global392 dispose:)
				(switch global387
					(4
						(gEgo setCycle: End self)
					)
					(2
						(gEgo view: 719 setLoop: 2 cel: 0 setCycle: End self)
					)
					(1
						(gEgo view: 719 setLoop: 0 cel: 0 setCycle: End self)
					)
					(3
						(gEgo
							view: 719
							setLoop: 3
							z: 0
							cel: 0
							setCycle: End self
						)
					)
				)
			)
			(3
				(if (== global387 4)
					(gEgo view: 728 setLoop: 7 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(4
				(= global103 0)
				(= global330
					{That wasn't a smart move, Graham!}
				)
				(EgoDead)
			)
		)
	)
)

(instance death3Script of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlobalSound number: 896 loop: 1 play:)
				(gMordObj setLoop: 12 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(gMordObj setCycle: Beg)
				(switch global387
					(4
						(= temp0 5)
					)
					(2
						(= temp0 6)
					)
					(3
						(global388 dispose:)
						(= temp0 4)
					)
				)
				(gEgo
					view: 719
					setLoop: temp0
					cycleSpeed: 2
					cel: 0
					z: 0
					setCycle: End self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(= global103 0)
				(= global330
					{That wasn't a smart move, Graham!}
				)
				(EgoDead)
			)
		)
	)
)

(instance death4Script of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlobalSound number: 896 loop: 1 play:)
				(gMordObj setLoop: 5)
				(global389 setLoop: 6)
				(= seconds 1)
			)
			(1
				(gMordObj setLoop: 7)
				(global389 setLoop: 8)
				(= seconds 1)
			)
			(2
				(gMordObj dispose:)
				(global389 dispose:)
				(switch global387
					(4
						(= temp0 7)
					)
					(2
						(= temp0 2)
					)
					(1
						(= temp0 0)
					)
				)
				(gEgo
					view: 719
					setLoop: temp0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gEgo view: 719 setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(= global103 0)
				(= global330
					{That wasn't a smart move, Graham!}
				)
				(EgoDead)
			)
		)
	)
)

(instance cedric of Actor
	(properties
		x 346
		y 39
		view 720
		illegalBits 0
	)
)

(instance tigerStuffScript of Script
	(properties)

	(method (changeState newState)
		(if (== (client script:) self)
			(switch (= state newState)
				(0
					(client setCycle: End self)
				)
				(1
					(client setCycle: Beg self)
				)
				(2
					(= seconds (Random 1 5))
				)
				(3
					(self init:)
				)
			)
		)
	)
)

(instance summonWandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global388
					view: 714
					setLoop: 4
					illegalBits: 0
					setPri: 3
					cycleSpeed: 1
					setStep: 8 8
					posn: 227 66 0
					init:
				)
				(gMordObj setLoop: 1 cel: 0 setCycle: End self)
				(gGlobalSound2 number: 838 loop: 1 play:)
			)
			(1
				(global388
					setPri: 15
					setCycle: Fwd
					posn: 215 59
					moveSpeed: 1
					setMotion: (ScriptID 124 2) self ; getWand
				)
				(gEgo put: 35) ; Mordack_s_Wand
			)
			(2
				(global388
					setMotion:
						MoveTo
						(+ (gMordObj x:) 16)
						(- (gMordObj y:) 31)
						self
				)
			)
			(3
				(global388 view: 712 setPri: -1 z: 1000 setCycle: 0)
				(gMordObj setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(if (not (IsFlag 55))
					(proc0_28 75 604 0 67 50 30 25 5) ; "Graham... I've heard from Crispin!"
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(5
				(if (not (IsFlag 55))
					(cls)
					(= seconds 2)
				else
					(= cycles 1)
				)
			)
			(6
				(if (not (IsFlag 55))
					(cedric
						init:
						setLoop: 4
						setCycle: Walk
						setPri: 15
						moveSpeed: 1
						ignoreActors: 1
						setMotion: MoveTo 246 52
					)
				)
				(= cycles 1)
			)
			(7
				(gMordObj setLoop: 3 cel: 0 setCycle: End self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

