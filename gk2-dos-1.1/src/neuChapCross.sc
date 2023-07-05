;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9442)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	neuChapCross 0
)

(instance neuChapCross of ExitRoom
	(properties
		picture 9442
		south 940 ; rm940
	)

	(method (init)
		(super init: &rest)
		(cross init:)
		(picExit init:)
	)
)

(instance cross of GKFeature
	(properties
		noun 18
		modNum 940
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 190 53 190 88 248 88 292 120 292 328 329 328 329 209 344 216 354 202 332 154 340 117 379 94 431 95 430 63 356 59 361 31 327 19 328 -5 298 -3 297 22 270 26 269 54
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance picExit of ExitFeature
	(properties
		nsRight 630
		nsBottom 30
		nextRoomNum 9440 ; neuChapPic
		exitDir 0
	)
)

