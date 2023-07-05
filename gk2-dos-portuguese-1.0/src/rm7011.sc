;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7011)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm7011 0
)

(instance rm7011 of ExitRoom
	(properties
		picture 7011
		south 700 ; sqRm
	)

	(method (init)
		(if (and (IsFlag 310) (IsFlag 613))
			(SetFlag 400)
		)
		(churchDoor init:)
		(churchCourtyard init:)
		(churchSign init:)
		(northExit init:)
		(super init: &rest)
		(cond
			((== gChapter 2)
				(lily loop: 2 x: 341 y: 253 init:)
			)
			((== gChapter 6)
				(lily loop: 1 x: 344 y: 247 init:)
			)
			((== gChapter 4)
				(if (IsFlag 400)
					(lily loop: 0 x: 341 y: 252 init:)
				else
					(lily loop: 2 x: 341 y: 253 init:)
				)
			)
		)
	)
)

(instance churchDoor of ExitFeature
	(properties
		nsLeft 56
		nsRight 192
		nsBottom 108
		x 124
		y 52
		BAD_SELECTOR 7012
		BAD_SELECTOR 7
	)
)

(instance churchCourtyard of GKFeature
	(properties
		nsLeft 264
		nsTop 120
		nsRight 526
		nsBottom 249
		x 394
		y 184
		BAD_SELECTOR 7014
	)
)

(instance northExit of ExitFeature
	(properties
		BAD_SELECTOR 1460
		BAD_SELECTOR 100
		BAD_SELECTOR 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 499 -2 499 72 520 81 520 146 474 174 513 187 563 155 563 -2
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance churchSign of GKFeature
	(properties
		nsLeft 10
		nsRight 42
		nsBottom 48
		x 26
		y 24
		BAD_SELECTOR 7012
	)
)

(instance lily of View
	(properties
		x 344
		y 252
		view 30428
	)

	(method (init)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

