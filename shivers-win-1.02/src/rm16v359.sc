;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16359)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm16v359 0
)

(instance rm16v359 of ShiversRoom
	(properties
		picture 16359
	)

	(method (init)
		(super init: &rest)
		(gCurRoom setScript: sGlowingEyes)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nsLeft 0
		nsTop 31
		nsRight 264
		nsBottom 143
		nextRoom 16350
	)
)

(instance sGlowingEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc951_16 103)
				(gGame handsOff:)
				(proc951_7 11603)
				(= ticks 30)
			)
			(1
				(gSounds play: 11603 0 32 self)
				(snakeEyes
					init:
					setPri: 255 1
					cel: 0
					loop: 0
					setCycle: End self
				)
			)
			(2)
			(3
				(snakeEyes
					setPri: 255 1
					loop: 1
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(gGame handsOn:)
				(efExitDown init: 5)
				(snakeEyes dispose:)
				(self dispose:)
			)
		)
	)
)

(instance snakeEyes of Prop
	(properties
		view 16359
	)
)

