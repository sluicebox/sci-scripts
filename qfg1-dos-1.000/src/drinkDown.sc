;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 336)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	drinkDown 0
)

(instance drinkDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: End)
				(= cycles 10)
			)
			(1
				(switch global337
					(1
						(switch global338
							(1
								(HighPrint 336 0) ; "This tastes as sour as it smells, and it burns your throat as you swallow it. Still, it isn't the worst beer you've ever drunk."
								(= cycles 5)
							)
							(2
								(HighPrint 336 1) ; "You know, that actually tasted fine! This really isn't such a bad place, after all, and the bartender reminds you of an old friend you used to know."
								(= cycles 5)
							)
							(3
								(HighPrint 336 2) ; "Suddenly, you don't feel so good..."
								(client setScript: tooDrunk)
							)
						)
					)
					(2
						(HighPrint 336 3) ; "Smells like Troll's Sweat. Tastes like Troll's Sweat. By golly, it IS Troll's Sweat...."
						(client setScript: tooDrunk)
					)
					(3
						(HighPrint 336 4) ; "You've never tasted anything like it before."
						(client setScript: breathDeath)
					)
				)
			)
			(2
				(gEgo setCycle: Beg)
				(= global337 0)
				(User canInput: 1)
				(client setScript: 0)
				(DisposeScript 336)
			)
		)
	)
)

(instance tooDrunk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 336)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg)
				(= cycles 15)
			)
			(1
				(gEgo loop: 6 cel: 0)
				(deadMug init:)
				(gAddToPics add: deadMug doit:)
				(= cycles 2)
			)
			(2
				(switch global337
					(1
						(HighPrint 336 5) ; "Too much beer."
					)
					(2
						(HighPrint 336 6) ; "...and one Troll's Sweat is too many."
					)
				)
				(= cycles 2)
			)
			(3
				(gEgo cycleSpeed: 2 setCycle: CT 6 1)
				(= cycles 25)
			)
			(4
				(gEgo cycleSpeed: 0 setCycle: End)
				(= cycles 20)
			)
			(5
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 16)
				(self cue:)
			)
			(6
				(SolvePuzzle 605 -5)
				(SetFlag 118)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance breathDeath of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 336)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 336 7) ; "Ohhhhhhhhh woooowwwwwww!!!"
				(gEgo loop: 5 cel: 0 cycleSpeed: 2 setCycle: CT 12 1 self)
			)
			(1
				(dust init:)
				(gAddToPics add: dust doit:)
				(gEgo setCycle: End self)
			)
			(2
				(EgoDead 336 8 80 { Talk about a "fiery brew". } 82 331 0 0) ; "Maybe you really shouldn't have tried the Dragon's Breath! Better luck next time, and we hope you saved your game."
			)
		)
	)
)

(instance deadMug of PV
	(properties
		y 80
		x 165
		view 331
		cel 2
		priority 12
	)
)

(instance dust of PV
	(properties
		y 89
		x 149
		view 504
		loop 2
		cel 4
		priority 15
	)
)

