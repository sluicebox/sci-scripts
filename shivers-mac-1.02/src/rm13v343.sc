;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13343)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm13v343 0
)

(instance rm13v343 of ShiversRoom
	(properties
		picture 13720
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
		(if (== gPrevRoomNum 13345) ; rm13v345
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13341
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13342
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 21401 0 5 8 1 self)
				(gSounds fade: 21402 0 5 16 1 0)
			)
			(1
				(proc951_10 21401)
				(= cycles 1)
			)
			(2
				(proc951_9 21302)
				(gSounds play: 21302 -1 0 0)
				(gSounds fade: 21302 114 10 8 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

