;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8611)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	wahn8611 0
)

(instance wahn8611 of ExitRoom
	(properties
		picture 8611
		south 8602 ; wahnDisp2Rm
	)

	(method (init)
		(super init: &rest)
		(plq init:)
		(letter init:)
		(desk init:)
	)
)

(instance plq of GKFeature
	(properties
		sightAngle 40
		x 230
		y 199
		nextRoomNum 8648 ; wahn8648
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 201 180 264 185 258 218 197 212
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance letter of GKFeature
	(properties
		sightAngle 40
		x 352
		y 218
		nextRoomNum 8640 ; wahn8640
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 324 202 404 210 383 234 300 222
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance desk of GKFeature
	(properties
		noun 2
		modNum 860
		x 352
		y 212
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 245 115 169 218 181 336 275 335 519 336 534 124
					yourself:
				)
		)
		(super init: &rest)
	)
)

