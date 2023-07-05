;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32810)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v810 0
)

(instance rm32v810 of ShiversRoom
	(properties
		picture 32810
	)

	(method (init)
		(proc951_16 65)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 32200
	)

	(method (init)
		(if (== gPrevRoomNum 32220) ; rm32v220
			(self nextRoom: 32220)
		)
		(self createPoly: 0 0 263 0 263 143 0 143 0 1)
		(super init: &rest)
	)
)

