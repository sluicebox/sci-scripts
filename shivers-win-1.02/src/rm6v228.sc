;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6228)
(include sci.sh)
(use Main)

(public
	rm6v228 0
)

(instance rm6v228 of ShiversRoom
	(properties
		picture 6228
	)

	(method (init)
		(efBack init: 8)
		(efUp init: 4)
		(gSounds play: 10622 0 58 0)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 6220
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 123 243 123 243 0 263 0 263 143 0 143)
		(super init: &rest)
	)
)

(instance efUp of ExitFeature
	(properties
		nsLeft 20
		nsTop 0
		nsRight 243
		nsBottom 40
		nextRoom 6227
	)
)

