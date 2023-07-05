;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4612)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm4612 0
)

(instance rm4612 of ExitRoom ; "Hunt Club: Ritual Room"
	(properties
		modNum 460
		noun 6
		picture 4612
		south 460 ; ritualRm
	)

	(method (init)
		(gGame handsOn:)
		(super init: &rest)
		(fBook init:)
		(fAntelope init:)
		(fLion init:)
		(fDeer init:)
		(fOccult init:)
	)
)

(instance fOccult of Feature
	(properties)

	(method (init)
		(self createPoly: 381 296 381 266 350 255 285 252 239 273 240 296)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gGame changeScore: 938)
			(gMessager say: 2 62 0 0 0 460) ; "(LOOK AT OCCULT SYMBOLS IN BASEMENT)Just a guess, but I don't think this stuff has much to do with huntin'."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fAntelope of GKFeature
	(properties
		modNum 460
	)

	(method (init)
		(self createPoly: 126 58 214 58 202 209 138 209)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gGame changeScore: 937)
			(gMessager say: 1 62 0 0 0 460) ; "(HUNT CLUB BASEMENT. LOOK AT TROPHIES)Aren't some of these endangered species?"
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fLion of GKFeature
	(properties
		modNum 460
	)

	(method (init)
		(self
			createPoly:
				355
				-2
				267
				-3
				257
				22
				220
				54
				275
				132
				275
				197
				349
				197
				349
				142
				381
				87
				404
				57
				379
				35
				369
				16
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(fAntelope doVerb: theVerb)
	)
)

(instance fDeer of GKFeature
	(properties
		modNum 460
	)

	(method (init)
		(self createPoly: 409 24 422 169 422 197 486 197 495 122 483 17)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(fAntelope doVerb: theVerb)
	)
)

(instance fBook of GKFeature
	(properties
		modNum 460
	)

	(method (init)
		(self createPoly: 396 297 421 297 421 265 396 265)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 525)
			(PlayScene 334 0 4642) ; rm4642
		else
			(super doVerb: theVerb)
		)
	)
)

