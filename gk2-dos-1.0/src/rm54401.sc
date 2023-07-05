;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54401)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	rm54401 0
)

(instance rm54401 of ExitRoom
	(properties
		modNum 543
		picture 5540
	)

	(method (init)
		(super init: &rest)
		(fClothes init:)
		(fSouthExit init:)
		(if (not (gEgo has: 54)) ; invRope
			(vRope init:)
		)
		(fRopeSpot init:)
		(gGame handsOn:)
	)
)

(instance fClothes of GKFeature
	(properties
		modNum 543
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				296
				217
				315
				200
				372
				169
				402
				173
				405
				144
				564
				130
				576
				202
				572
				275
				415
				254
				349
				277
				335
				264
				334
				241
				311
				245
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 645)
			)
			(22 ; invRope
				(gMessager say: 3 22 0 1 0 543) ; "(TRY TO PUT BACK PRESS'S ROPE)I think I'll keep the rope for now."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fRopeSpot of GKFeature
	(properties
		noun 3
		modNum 543
	)

	(method (init)
		(super init: &rest)
		(self createPoly: -1 268 -1 -1 616 -1 616 267)
	)

	(method (onMe)
		(if (== (gCurInvView itemNumber:) 54)
			(super onMe: &rest)
		else
			(return 0)
		)
	)
)

(instance vRope of View
	(properties
		modNum 543
		x 157
		y 254
		view 30646
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 646)
			(gEgo get: 54) ; invRope
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		modNum 543
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 269 618 269 616 332 -1 332)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 2646 0 543) ; priessRm
		else
			(super doVerb: &rest)
		)
	)
)

