;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15007)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15007 0
)

(instance rm15007 of BaseRoom
	(properties
		BAD_SELECTOR 7
		BAD_SELECTOR 15026
		BAD_SELECTOR 15025
		BAD_SELECTOR 15028
		BAD_SELECTOR 15027
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15003
				(= BAD_SELECTOR 2)
			)
			(15006
				(= BAD_SELECTOR 1)
			)
			(15008
				(= BAD_SELECTOR 3)
			)
			(15011
				(= BAD_SELECTOR 0)
			)
			(else
				(= BAD_SELECTOR 1)
			)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 5)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 9)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 12)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion BAD_SELECTOR:) at: 8)
			(+= BAD_SELECTOR 100)
		)
		(super init:)
		(if (and (== BAD_SELECTOR 0) (not ((BaseRegion BAD_SELECTOR:) at: 5)))
			(exitNDoor init:)
			(doorLatchN init:)
		)
		(if (and (== BAD_SELECTOR 3) (not ((BaseRegion BAD_SELECTOR:) at: 8)))
			(exitWDoor init:)
			(doorLatchW init:)
		)
		(if
			(or
				(and
					(== BAD_SELECTOR 1)
					(not ((BaseRegion BAD_SELECTOR:) at: 9))
				)
				(and
					(== BAD_SELECTOR 2)
					(not ((BaseRegion BAD_SELECTOR:) at: 12))
				)
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
						(not ((BaseRegion BAD_SELECTOR:) at: 9))
					)
					(and
						(== BAD_SELECTOR 2)
						(not ((BaseRegion BAD_SELECTOR:) at: 12))
					)
				)
				(if (not (gFeatures contains: exitDoor))
					(exitDoor init:)
				)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatchN dispose:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatchW dispose:)
				)
			)
			((and (== BAD_SELECTOR 0) (not ((BaseRegion BAD_SELECTOR:) at: 5)))
				(if (not (gFeatures contains: exitNDoor))
					(exitNDoor init:)
					(doorLatchN init:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatchW dispose:)
				)
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
			)
			((and (== BAD_SELECTOR 3) (not ((BaseRegion BAD_SELECTOR:) at: 8)))
				(if (not (gFeatures contains: exitWDoor))
					(exitWDoor init:)
					(doorLatchW init:)
				)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatchN dispose:)
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
					(doorLatchN dispose:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatchW dispose:)
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

(instance exitWDoor of ExitFeature
	(properties
		x 945
		y 137
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 900 34 990 34 990 240 900 240
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

(instance doorLatchW of GKFeature
	(properties
		x 882
		y 219
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 865 255 865 184 899 184 899 255
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

(instance exitNDoor of ExitFeature
	(properties
		x 931
		y 137
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 886 33 977 33 977 242 886 242
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

(instance doorLatchN of GKFeature
	(properties
		x 842
		y 227
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 823 258 823 197 861 197 861 258
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

