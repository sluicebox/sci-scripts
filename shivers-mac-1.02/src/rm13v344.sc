;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13344)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm13v344 0
)

(instance rm13v344 of ShiversRoom
	(properties
		picture 13860
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (== gPrevRoomNum 13342) ; rm13v342
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13345
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13345
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14010
	)

	(method (init)
		(self createPoly: 49 142 40 17 84 1 137 1 181 17 177 137 169 142)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 21302 0 1 30 1 self)
			)
			(1
				(proc951_10 21302)
				(= cycles 1)
			)
			(2
				(proc951_9 21401)
				(gSounds play: 21401 -1 34 0)
				(if (proc951_11 3 14000)
					(proc951_9 21402)
					(gSounds play: 21402 -1 66 0)
				)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

