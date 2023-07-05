;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9210)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	neuBed 0
)

(instance neuBed of ExitRoom
	(properties
		picture 9210
		east 920 ; rm920
		south 920 ; rm920
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
		(washStand init:)
		(bed init:)
	)
)

(instance washStand of Feature
	(properties
		noun 14
		modNum 920
		x 137
		y 260
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 44 215 231 204 231 279 44 316
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(cond
			((== gChapter 6)
				(= noun 19)
			)
			((IsFlag 590)
				(= noun 15)
			)
		)
		(super doVerb: &rest)
	)
)

(instance bed of Feature
	(properties
		noun 12
		modNum 920
		x 479
		y 156
	)

	(method (init)
		(if (== gChapter 6)
			(= noun 19)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 342 -1 364 214 409 316 614 316 616 -3
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tourTapeButton of View
	(properties
		noun 3
		modNum 920
		x 10
		y 290
		view 141
		loop 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 589)
				(= noun 4)
				(ClearFlag 589)
				(SetFlag 590)
			else
				(= noun 3)
				(SetFlag 589)
			)
		)
		(super doVerb: theVerb)
	)
)

