;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Actor)

(public
	stableRm 0
)

(instance stableRm of ExitRoom ; "Hunting Lodge: Stable"
	(properties
		modNum 510
		noun 1
		picture 5101
	)

	(method (init)
		(gEgo
			posn: 515 348
			heading: 225
			sel_737:
			setScaler: Scaler 100 72 348 285
			init:
		)
		(super init: &rest)
		(if (== gPrevRoomNum 500) ; lodgeExtRm
			(Lock 140 250 0) ; WAVE
			(Lock 140 510 1) ; WAVE
			(gGk2Music setLoop: -1 number: 510 play:)
		)
		(fToolWall init:)
		(fExitToLodge init:)
		(fStall init:)
		(gGame handsOn:)
		(if (not (gEgo has: 53)) ; invShears
			(vShears init:)
		)
	)

	(method (cue)
		(PlayScene 2605 0 5111) ; stableWall
	)
)

(instance fExitToLodge of ExitFeature
	(properties
		approachX 640
		approachY 200
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 426 333 427 0 616 0 614 332)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 500) ; lodgeExtRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fStall of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1 64 2 285 115 267 113 158)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 7 62) ; "(TRY TO GO OVER TO THE HORSE STALLS)I'd prefer to keep the horses over THERE and me over HERE."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fToolWall of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 259 139 255 33 380 19 380 141)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (gEgo has: 53) ; invShears
				(gMessager say: 9 62) ; "(CLICK ON TOOL WALL AFTER TAKING SHEARS)Nothin' else I can use."
			else
				(PlayScene 2605 0 5111) ; stableWall
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vShears of View
	(properties
		x 331
		y 182
		view 36051
	)

	(method (doVerb)
		(fToolWall doVerb: &rest)
	)
)

