;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15005)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15005 0
)

(instance rm15005 of BaseRoom
	(properties
		BAD_SELECTOR 5
		BAD_SELECTOR 15018
		BAD_SELECTOR 15017
		BAD_SELECTOR 15020
		BAD_SELECTOR 15019
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15001
				(= BAD_SELECTOR 2)
			)
			(15006
				(= BAD_SELECTOR 3)
			)
			(15009
				(= BAD_SELECTOR 0)
			)
			(else
				(= BAD_SELECTOR 1)
			)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 3)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 7)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 10)
			(+= BAD_SELECTOR 100)
		)
		(super init:)
		(if (and (== BAD_SELECTOR 0) (not ((BaseRegion BAD_SELECTOR:) at: 3)))
			(exitNDoor init:)
			(doorLatch init:)
		)
		(if
			(or
				(and
					(== BAD_SELECTOR 1)
					(not ((BaseRegion BAD_SELECTOR:) at: 7))
				)
				(and
					(== BAD_SELECTOR 2)
					(not ((BaseRegion BAD_SELECTOR:) at: 10))
				)
				(== BAD_SELECTOR 3)
			)
			(exitDoor init:)
		)
	)

	(method (cue)
		(cond
			(
				(or
					(and
						(== BAD_SELECTOR 1)
						(not ((BaseRegion BAD_SELECTOR:) at: 7))
					)
					(and
						(== BAD_SELECTOR 2)
						(not ((BaseRegion BAD_SELECTOR:) at: 10))
					)
					(== BAD_SELECTOR 3)
				)
				(if (not (gFeatures contains: exitDoor))
					(exitDoor init:)
				)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatch dispose:)
				)
			)
			((and (== BAD_SELECTOR 0) (not ((BaseRegion BAD_SELECTOR:) at: 3)))
				(if (not (gFeatures contains: exitNDoor))
					(exitNDoor init:)
					(doorLatch init:)
				)
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
			)
			(else
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatch dispose:)
				)
			)
		)
	)
)

(instance exitDoor of ExitFeature
	(properties
		x 926
		y 131
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 868 23 985 23 985 240 868 240
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(switch (gCurRoom BAD_SELECTOR:)
					(3
						(PlayScene 913)
						(gCurRoom BAD_SELECTOR:)
					)
					(1
						(gCurRoom
							BAD_SELECTOR:
								(gCurRoom BAD_SELECTOR:)
								(gCurRoom BAD_SELECTOR:)
						)
					)
					(2
						(gCurRoom
							BAD_SELECTOR:
								(gCurRoom BAD_SELECTOR:)
								(gCurRoom BAD_SELECTOR:)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitNDoor of ExitFeature
	(properties
		x 941
		y 131
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 894 23 988 23 988 240 894 240
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom
					BAD_SELECTOR:
						(gCurRoom BAD_SELECTOR:)
						(gCurRoom BAD_SELECTOR:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorLatch of GKFeature
	(properties
		x 880
		y 218
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 868 257 868 179 893 179 893 257
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(((BaseRegion BAD_SELECTOR:) at: (- (gCurRoom BAD_SELECTOR:) 1))
					BAD_SELECTOR:
						(gCurRoom BAD_SELECTOR:)
						(gCurRoom BAD_SELECTOR:)
				)
				(gCurRoom BAD_SELECTOR: (+ (gCurRoom BAD_SELECTOR:) 100))
				(PlayScene 915 gCurRoom)
				(gCurRoom BAD_SELECTOR:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

