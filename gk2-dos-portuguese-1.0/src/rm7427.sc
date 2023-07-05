;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7427)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm7427 0
)

(instance rm7427 of ExitRoom
	(properties
		picture 7425
		south 740 ; gastRm
	)

	(method (init)
		(super init: &rest)
		(arti init:)
		(ludPic init:)
	)
)

(instance arti of GKFeature
	(properties
		nsLeft 242
		nsTop 196
		nsRight 298
		nsBottom 261
		BAD_SELECTOR 7441
	)
)

(instance ludPic of GKFeature
	(properties
		modNum 740
		x 265
		y 112
		BAD_SELECTOR 172
		BAD_SELECTOR 7428
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 67 305 55 305 165 226 170
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 456)
			(= BAD_SELECTOR 0)
		else
			(gGk2Music fade:)
		)
		(super doVerb: &rest)
	)
)

