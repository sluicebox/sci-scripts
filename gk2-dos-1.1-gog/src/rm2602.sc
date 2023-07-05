;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2602)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	rm2602 0
)

(instance rm2602 of ExitRoom
	(properties
		modNum 260
		picture 2602
		south 260 ; dornIntRm
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 2640)
			(gEgo
				posn: 396 303
				heading: 135
				normalize:
				init:
				setScaler: Scaler 113 79 374 301
			)
		)
		(fCatCage init:)
		(fOtherCagesLeft init:)
		(fOtherCagesRight init:)
		(gGame handsOn:)
	)
)

(instance fCatCage of GKFeature
	(properties
		modNum 260
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 490 130 535 134 534 277 494 249)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((gEgo has: 55) ; invWolfTags
					(gMessager say: 4 62 0 1 0 260) ; "(CLICK ON LARGE CAT IN CAGE)I think I'll leave the cat alone."
				)
				((gCast contains: gEgo)
					(gCurRoom newRoom: 2640)
				)
				(else
					(PlayScene 590 0 2640) ; rm2640
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fOtherCagesLeft of GKFeature
	(properties
		modNum 260
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 130 117 129 118 268 24 338 0 335)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 651)
				(gMessager say: 5 62 2 1 0 260) ; "(LOOK AT ANIMALS AGAIN, ANGRY)If I ever solve this case, I'll sick Leber on this guy."
			else
				(SetFlag 651)
				(gMessager say: 5 62 1 1 0 260) ; "(LOOK AT DORN'S ANIMALS)These animals are filthy. hungry too. I'd like to put Dorn in one of these cages - and leave him there."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fOtherCagesRight of GKFeature
	(properties
		modNum 260
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 536 133 617 135 613 329 534 277)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 651)
				(gMessager say: 5 62 2 1 0 260) ; "(LOOK AT ANIMALS AGAIN, ANGRY)If I ever solve this case, I'll sick Leber on this guy."
			else
				(SetFlag 651)
				(gMessager say: 5 62 1 1 0 260) ; "(LOOK AT DORN'S ANIMALS)These animals are filthy. hungry too. I'd like to put Dorn in one of these cages - and leave him there."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

