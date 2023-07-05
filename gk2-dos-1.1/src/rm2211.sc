;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2211)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	rm2211 0
)

(instance rm2211 of ExitRoom
	(properties
		modNum 220
		picture 2211
		east 2202 ; rm2202
	)

	(method (init)
		(if (gEgo has: 73) ; invPitcher
			(Palette 1 (= global249 205)) ; PalLoad
		else
			(Palette 1 (= global249 204)) ; PalLoad
		)
		(super init: &rest)
		(switch gPrevRoomNum
			(2241
				(gEgo posn: 559 288 heading: 135)
			)
			(else
				(gEgo posn: 559 288 heading: 225)
			)
		)
		(gEgo normalize: setScaler: Scaler 70 55 329 290 init:)
		(fSpyArea init:)
		(fWoods init:)
		(gGame handsOn: 0)
	)

	(method (cue)
		(FrameOut)
		(PlayScene 17 0 2241) ; rm2241
	)
)

(instance fExit of GKFeature ; UNUSED
	(properties
		modNum 220
		sightAngle 6
		x 700
		y 400
		nextRoomNum 2202 ; rm2202
	)

	(method (init)
		(super init:)
		(self createPoly: 461 333 615 217 614 333)
	)
)

(instance fWoods of GKFeature
	(properties
		noun 17
		modNum 220
		sightAngle 360
	)

	(method (init)
		(super init:)
		(self createPoly: 0 0 -1 332 396 212 615 198 613 1)
	)
)

(instance fSpyArea of GKFeature
	(properties
		modNum 220
		sightAngle 360
		sceneNum 17
		nextRoomNum 2241 ; rm2241
	)

	(method (init)
		(super init:)
		(self createPoly: 414 254 498 273 486 303 445 318 394 280)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 62) (not (IsFlag 416)) (== gChapter 1)) ; Do
			(SetFlag 416)
		)
		(super doVerb: theVerb)
	)
)

