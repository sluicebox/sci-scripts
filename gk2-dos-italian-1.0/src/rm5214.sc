;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5214)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	rm5214 0
)

(instance rm5214 of ExitRoom
	(properties
		picture 5240
		south 520 ; greatRm
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 1069))
			(vLantern init:)
		)
		(fShrankInterior init:)
		(gGame handsOn:)
	)

	(method (dispose)
		(if (or (gEgo has: 50) (IsFlag 658)) ; invLantern
			(PlayScene 2610)
		else
			(PlayScene 1610)
		)
		(super dispose: &rest)
	)
)

(instance vLantern of View
	(properties
		x 233
		y 230
		view 30609
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 256 118 294 117 296 124 291 139 295 155 292 174 294 187 301 195 299 209 281 218 261 217 253 201 256 190 263 179 260 163 264 146 263 132 258 120
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 610)
			(gEgo get: 50) ; invLantern
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fShrankInterior of GKFeature
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 2 62 0 1 0 520) ; "(LOOK IN SHRANK)Nice closet."
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(self createPoly: -1 -1 537 -2 463 334 -1 334)
		(super init:)
	)
)

