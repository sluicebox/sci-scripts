;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 921)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Print)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	bed2 0
)

(instance bed2 of ExitRoom ; "Neuschwanstein: Bedroom"
	(properties
		modNum 920
		noun 22
		picture 9202
		south 910 ; rm910
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		else
			(panel init:)
		)
		(gEgo
			posn: 309 302
			heading: 225
			sel_737:
			setScaler: Scaler 77 42 361 272
			init:
		)
		(super init: &rest)
		(leftPic init:)
		(rightPic init:)
		(statue init:)
		(bedArea init:)
		(chapelExit init:)
		(livingRmExit init:)
		(cond
			((not (IsFlag 729))
				(guard1 init:)
				(SetFlag 786)
			)
			((not (IsFlag 787))
				(ClearFlag 786)
				(guard2 init:)
			)
			(else
				(SetFlag 786)
			)
		)
	)
)

(instance guardsRotate of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
				(= register 0)
			)
			(1
				(if (not (gCast contains: guard1))
					(Prints {guard1 enters from entry hall})
					(guard1 init:)
					(ClearFlag 729)
					(if (gCast contains: guard2)
						(Prints {guard2 leaves for living room})
						(= register guard2)
						(SetFlag 786)
					)
				else
					(Prints {guard1 leaves for entry hall.})
					(= register guard1)
					(SetFlag 729)
					(if (not (IsFlag 787))
						(Prints {guard2 arrives from living room})
						(guard2 init:)
						(ClearFlag 786)
					)
				)
				(= seconds 1)
			)
			(2
				(if register
					(register dispose:)
				)
				(self init:)
			)
		)
	)
)

(instance bedArea of GKFeature
	(properties
		modNum 920
		x 203
		y 205
		BAD_SELECTOR 9210
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 90 137 88 282 318 268 318 129
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance statue of GKFeature
	(properties
		modNum 920
		approachY 400
		x 28
		y 178
		BAD_SELECTOR 9242
	)

	(method (init)
		(if (== gChapter 6)
			(= sightAngle 360)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 90 23 63 40 73 57 132 26 287 1 293
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== gChapter 6)
			(= noun 19)
			(= BAD_SELECTOR 0)
		)
		(super doVerb: &rest)
	)
)

(instance leftPic of GKFeature
	(properties
		modNum 920
		x 438
		y 72
		BAD_SELECTOR 9243
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 377 30 500 6 499 134 378 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightPic of GKFeature
	(properties
		modNum 920
		x 567
		y 64
		BAD_SELECTOR 9244
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 520 2 521 129 612 126 614 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance panel of GKFeature
	(properties
		modNum 920
		x 499
		y 230
		BAD_SELECTOR 9211
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 445 151 595 149 595 312 445 297
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chapelExit of ExitFeature
	(properties
		x 609
		y 231
		BAD_SELECTOR 940
		BAD_SELECTOR 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 615 140 602 173 602 319 617 323
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance livingRmExit of ExitFeature
	(properties
		x 419
		y 222
		BAD_SELECTOR 950
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 402 153 436 151 436 294 402 272
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tourTapeButton of View
	(properties
		noun 1
		modNum 920
		sightAngle 360
		x 10
		y 290
		view 141
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 582)
		)
		(super doVerb: theVerb)
	)
)

(instance guard1 of Prop
	(properties
		modNum 910
		sightAngle 360
		x 432
		y 333
		view 481
	)

	(method (init)
		(super init: &rest)
		(self setScript: FidgetScript)
	)

	(method (doVerb theVerb)
		(= noun
			(if (== gChapter 4)
				(if (== theVerb 62) ; Do
					1
				else
					(= theVerb 0)
					2
				)
			else
				(switch theVerb
					(31 19) ; invDove
					(else
						(= theVerb 62) ; Do
						18
					)
				)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance guard2 of Prop
	(properties
		modNum 910
		sightAngle 360
		x 428
		y 333
		view 23920
	)

	(method (init)
		(super init: &rest)
		(self setScript: (FidgetScript new:))
	)

	(method (doVerb theVerb)
		(= noun
			(if (== gChapter 4)
				(if (== theVerb 62) 1 else 2) ; Do
			else
				(switch theVerb
					(31 19) ; invDove
					(else
						(= theVerb 62) ; Do
						18
					)
				)
			)
		)
		(super doVerb: theVerb)
	)
)

