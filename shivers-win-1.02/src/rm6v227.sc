;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6227)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v227 0
)

(instance rm6v227 of ShiversRoom
	(properties
		picture 6227
	)

	(method (init)
		(if (== gPrevRoomNum 6220) ; rm6v220
			(gSounds play: 10618 0 58 0)
		else
			(gSounds play: 10622 0 58 0)
		)
		(proc951_16 87)
		(efBack init: 8)
		(efDown init: 5)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 6220
	)

	(method (init)
		(self createPoly: 0 0 0 143 20 143 20 20 243 20 243 143 263 143 263 0)
		(super init: &rest)
	)
)

(instance efDown of ExitFeature
	(properties
		nsLeft 20
		nsTop 103
		nsRight 243
		nsBottom 143
		nextRoom 6228
	)
)

