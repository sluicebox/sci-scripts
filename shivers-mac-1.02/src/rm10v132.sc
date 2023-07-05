;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10132)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v132 0
)

(local
	local0
)

(instance rm10v132 of ShiversRoom
	(properties
		picture 10132
	)

	(method (init)
		(proc951_16 100)
		(gSounds play: 10618 0 82 0)
		(= local0 1)
		(super init: &rest)
		(efExitBack init: 8)
		(hsNote init:)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 10130
	)

	(method (init)
		(if (>= gPrevRoomNum 10400) ; rm10v400
			(= nextRoom gPrevRoomNum)
		)
		(self
			createPoly:
				0
				0
				34
				0
				34
				140
				237
				140
				237
				114
				224
				105
				224
				16
				213
				2
				263
				2
				263
				143
				0
				143
				0
				0
		)
		(super init: &rest)
	)
)

(instance hsNote of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				35
				0
				35
				139
				236
				139
				236
				115
				223
				105
				223
				17
				212
				3
				212
				0
				35
				0
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if local0
			(gSounds play: 10622 0 82 0)
			(= local0 0)
			(gCurRoom drawPic: 10133)
		else
			(gSounds play: 10622 0 82 0)
			(= local0 1)
			(gCurRoom drawPic: 10132)
		)
	)
)

