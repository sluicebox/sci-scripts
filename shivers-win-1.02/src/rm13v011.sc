;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13011)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm13v011 0
)

(instance rm13v011 of ShiversRoom
	(properties
		picture 13100
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (== gPrevRoomNum 13013) ; rm13v013
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13009
	)

	(method (init)
		(self createPoly: 63 142 104 99 104 41 164 41 164 107 192 142)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 21301 0 1 30 1 self)
			)
			(1
				(gGame handsOn:)
				(proc951_9 21303)
				(gSounds play: 21303 -1 0 0)
				(gSounds fade: 21303 18 15 8 0 0)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

