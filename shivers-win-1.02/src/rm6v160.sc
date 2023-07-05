;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6160)
(include sci.sh)
(use Main)

(public
	rm6v160 0
)

(instance rm6v160 of ShiversRoom
	(properties
		picture 6160
	)

	(method (init)
		(efExitBack init: 8)
		(efLetter init: 0)
		(if (<= 6161 gPrevRoomNum 6162) ; rm6v161, rm6v162
			(gSounds play: 10621 0 58 0)
		)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 6090
	)

	(method (init)
		(self
			createPoly:
				0
				0
				20
				20
				20
				143
				243
				143
				243
				20
				20
				20
				0
				0
				263
				0
				263
				143
				0
				143
		)
		(super init: &rest)
	)
)

(instance efLetter of ExitFeature
	(properties
		nextRoom 6161
	)

	(method (init)
		(self createPoly: 44 115 61 109 69 109 73 110 82 116 62 119 44 115)
		(super init: &rest)
	)
)

