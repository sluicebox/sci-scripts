;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12420)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v42 0
)

(instance rm12v42 of ShiversRoom
	(properties
		picture 12420
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 3)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nsLeft 21
		nsTop 0
		nsRight 243
		nsBottom 143
		nextRoom 12120
	)

	(method (init)
		(self
			createPoly:
				255
				143
				225
				125
				225
				102
				190
				65
				190
				2
				66
				2
				66
				65
				30
				104
				30
				125
				22
				130
				22
				144
		)
		(super init: &rest)
	)
)

