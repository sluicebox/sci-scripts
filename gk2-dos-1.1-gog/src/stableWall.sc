;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5111)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	stableWall 0
)

(instance stableWall of ExitRoom ; "Hunting Lodge: Stable"
	(properties
		modNum 510
		noun 1
		picture 5111
	)

	(method (init)
		(super init: &rest)
		(if (not (gEgo has: 53)) ; invShears
			(vShears
				init:
				createPoly:
					244
					331
					310
					239
					312
					143
					330
					105
					334
					206
					385
					120
					383
					154
					363
					200
					335
					245
					337
					264
					352
					298
					363
					334
					333
					332
					314
					271
					284
					333
			)
		)
		(fTools init:)
		(fHorseStuff init:)
		(fSouthExit init:)
		(gGame handsOn:)
	)

	(method (cue)
		(PlayScene 605)
		(gEgo get: 53) ; invShears
		(vShears dispose:)
	)
)

(instance vShears of View
	(properties
		modNum 510
		x 233
		y 333
		view 30605
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 686)
			(gMessager say: 8 62 0 1 gCurRoom 510) ; "(LOOK AT SHEARS)Shears... These might come in handy."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fTools of GKFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 303 36 226 40 161 65 165 51 188 58 240 85 252 91 304
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 177 15 522 21 604 36 483 168 382 166 388 119 347 167 331 163 333 108 320 109 309 164 144 168 142 86 176 95
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 6 62 0 1 0 510) ; "(NOT REAL INTERESTED)Tools."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fHorseStuff of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 120 253 121 79 92 33 111 -2 172 -2 177 94 143 85 142 256
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 6 62 0 1 0 510) ; "(NOT REAL INTERESTED)Tools."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		exitDir 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (gEgo has: 53) ; invShears
				(PlayScene 4605 0 500) ; lodgeExtRm
			else
				(PlayScene 3605 0 500) ; lodgeExtRm
			)
		)
	)
)

