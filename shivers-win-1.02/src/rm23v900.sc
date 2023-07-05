;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23900)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v900 0
)

(instance rm23v900 of ShiversRoom
	(properties
		picture 23900
	)

	(method (init)
		(proc951_16 53)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23530
	)

	(method (init)
		(if (== gPrevRoomNum 23540) ; rm23v540
			(self nextRoom: 23540)
		)
		(self createPoly: 0 0 0 142 262 142 262 0 1 0)
		(super init: &rest)
	)
)

