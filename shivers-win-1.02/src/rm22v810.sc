;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22810)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v810 0
)

(instance rm22v810 of ShiversRoom
	(properties
		picture 22810
	)

	(method (init)
		(proc951_16 47)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 22360
	)

	(method (init)
		(if (== gPrevRoomNum 22340) ; rm22v340
			(self nextRoom: 22340)
		)
		(self createPoly: 0 0 262 0 262 143 0 143 0 1)
		(super init: &rest)
	)
)

