;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37420)
(include sci.sh)
(use Main)

(public
	rm37v420 0
)

(instance rm37v420 of ShiversRoom
	(properties
		picture 37420
	)

	(method (init)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 37190
	)

	(method (init)
		(if (== gPrevRoomNum 37220) ; rm37v220
			(= nextRoom gPrevRoomNum)
		)
		(self createPoly: 52 0 43 143 0 143 0 0 209 0 213 143 263 143 263 0)
		(super init: &rest)
	)
)

