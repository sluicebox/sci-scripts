;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8642)
(include sci.sh)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	wahn8642 0
)

(instance wahn8642 of ExitRoom
	(properties
		picture 8642
		south 8602 ; wahnDisp2Rm
	)

	(method (init)
		(super init: &rest)
		(SetFlag 631)
		(deathmask init:)
	)
)

(instance deathmask of GKFeature
	(properties
		noun 9
		modNum 860
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 325 82 354 77 397 117 398 193 316 257 274 248 258 230 259 182 281 130
					yourself:
				)
		)
		(super init: &rest)
	)
)

