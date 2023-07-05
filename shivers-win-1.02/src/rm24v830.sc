;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24830)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v830 0
)

(instance rm24v830 of ShiversRoom
	(properties
		picture 24830
	)

	(method (init)
		(proc951_16 57)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 24320
	)

	(method (init)
		(if (== gPrevRoomNum 24420) ; rm24v420
			(self nextRoom: 24420)
		)
		(self createPoly: 0 0 262 0 262 143 0 143 0 1)
		(super init: &rest)
	)
)

