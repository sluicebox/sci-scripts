;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23760)
(include sci.sh)
(use Main)

(public
	rm23v760 0
)

(instance rm23v760 of ShiversRoom
	(properties
		picture 23760
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (< 1000 newRoomNumber 23000) ; rm1v00
			(gSounds fade: 22301 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23800
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23800
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22270
	)

	(method (init)
		(self createPoly: 91 37 171 37 171 127 91 127 91 38)
		(super init: &rest)
	)
)

