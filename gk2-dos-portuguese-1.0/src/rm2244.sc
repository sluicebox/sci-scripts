;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2244)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)
(use System)

(public
	rm2244 0
)

(instance rm2244 of ExitRoom ; "Huber Farm Exterior"
	(properties
		modNum 220
		noun 9
		south 220 ; farmFldRm
	)

	(method (init)
		(if (== gPrevRoomNum 2242)
			(= picture -1)
		else
			(= picture 2244)
		)
		(fTrashCan init:)
		(fCementBag init:)
		(if (not (gEgo has: 73)) ; invPitcher
			(vBucket init:)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 2242)
			(self setScript: sEmptyTheBucket)
		else
			(gGame handsOn: 0)
		)
	)

	(method (dispose)
		(if (gEgo has: 73) ; invPitcher
			(PlayScene 1023 0 2213) ; rm2213
		else
			(PlayScene 4023 0 2213) ; rm2213
		)
		(super dispose:)
	)
)

(instance sEmptyTheBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame BAD_SELECTOR: 0)
				(gEgo put: 73 posn: 447 336 BAD_SELECTOR: 315) ; invPitcher
				(gCurRoom picture: 2244)
				(PlayScene 24 self)
			)
			(2
				(vBucket init:)
				(self dispose:)
			)
		)
	)
)

(instance sLookAtCement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 5 62 0 0 self 220) ; "(LOOK AT CEMENT BAG)I could be wrong, but I think this bag contains cement. Schnell? Quick? 'Quick drying cement?'"
			)
			(1
				(if (not (IsFlag 417))
					(SetFlag 417)
					(gMessager say: 6 62 0 0 self 220) ; "(DOESN'T KNOW WHAT TO DO WITH CEMENT YET)Well. That's useful."
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sGetCement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 417))
					(SetFlag 417)
					(gMessager say: 5 62 0 0 self 220) ; "(LOOK AT CEMENT BAG)I could be wrong, but I think this bag contains cement. Schnell? Quick? 'Quick drying cement?'"
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo get: 73) ; invPitcher
				(gUser BAD_SELECTOR: 111)
				((gUser BAD_SELECTOR:) update:)
				(gCurInvView update:)
				(PlayScene 23 self)
			)
			(2
				(vBucket dispose:)
				(gEgo posn: 332 332 BAD_SELECTOR: 315)
				(self dispose:)
			)
		)
	)
)

(instance vBucket of View
	(properties
		noun 20
		modNum 220
		sightAngle 360
		x 287
		y 89
		view 2244
	)
)

(instance fTrashCan of GKFeature
	(properties
		modNum 220
		sightAngle 360
	)

	(method (init)
		(self
			createPoly: 463 337 463 309 477 299 502 299 525 308 536 318 532 334
		)
		(super init: &rest)
		(if (or (IsFlag 415) (not (== gChapter 1)))
			(= noun 19)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 7 62 0 1 0 220) ; "(LOOKING IN GARBAGE CAN)Nothing of interest in there."
			)
			(111 ; invPitcher
				(gCurRoom setScript: sEmptyTheBucket)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fCementBag of GKFeature
	(properties
		modNum 220
		sightAngle 360
	)

	(method (init)
		(self createPoly: 230 -1 293 -3 291 37 292 91 224 92)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((IsFlag 415)
					(gMessager say: 19 62 0 0 0 220) ; "(TRY TO GET CEMENT AFTER MAKING CAST)Don't think I need any more cement."
				)
				((and (not (gEgo has: 73)) (IsFlag 413)) ; invPitcher
					(gCurRoom setScript: sGetCement)
				)
				(else
					(gCurRoom setScript: sLookAtCement)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

