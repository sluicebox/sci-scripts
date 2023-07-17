;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15011)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15011 0
)

(instance rm15011 of BaseRoom
	(properties
		BAD_SELECTOR 11
		BAD_SELECTOR 15042
		BAD_SELECTOR 15041
		BAD_SELECTOR 15044
		BAD_SELECTOR 15043
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15007
				(= BAD_SELECTOR 2)
			)
			(15010
				(= BAD_SELECTOR 1)
			)
			(15012
				(= BAD_SELECTOR 3)
			)
			(else
				(= BAD_SELECTOR 1)
			)
		)
		(if ((BaseRegion sel_890:) at: 12)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 16)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 15)
			(+= BAD_SELECTOR 100)
		)
		(super init:)
		(cond
			((and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 12)))
				(exitNDoor init:)
				(doorLatchN init:)
			)
			((and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 15)))
				(exitWDoor init:)
				(doorLatchW init:)
			)
			((and (== BAD_SELECTOR 1) (not ((BaseRegion sel_890:) at: 16)))
				(exitDoor init:)
			)
		)
	)

	(method (cue)
		(cond
			((and (== BAD_SELECTOR 1) (not ((BaseRegion sel_890:) at: 16)))
				(exitDoor init:)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatchN dispose:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatchW dispose:)
				)
			)
			((and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 12)))
				(exitNDoor init:)
				(doorLatchN init:)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatchW dispose:)
				)
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
			)
			((and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 15)))
				(exitWDoor init:)
				(doorLatchW init:)
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
				(gCurRoom sel_916: (gCurRoom sel_880:) (gCurRoom sel_879:))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitWDoor of ExitFeature
	(properties
		x 932
		y 118
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 881 4 984 4 984 233 881 233
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom sel_916: (gCurRoom sel_880:) (gCurRoom sel_879:))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorLatchW of GKFeature
	(properties
		x 836
		y 216
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 813 249 813 183 860 183 860 249
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(((BaseRegion sel_891:) at: (- (gCurRoom sel_880:) 1))
					sel_905: (gCurRoom sel_880:) (gCurRoom sel_879:)
				)
				(gCurRoom sel_909: (+ (gCurRoom sel_909:) 100))
				(PlayScene 915 gCurRoom)
				(gCurRoom sel_878:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitNDoor of ExitFeature
	(properties
		x 933
		y 119
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 881 0 986 0 986 238 881 238
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom sel_916: (gCurRoom sel_880:) (gCurRoom sel_879:))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorLatchN of GKFeature
	(properties
		x 834
		y 221
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 811 257 811 185 858 185 858 257
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(((BaseRegion sel_891:) at: (- (gCurRoom sel_880:) 1))
					sel_905: (gCurRoom sel_880:) (gCurRoom sel_879:)
				)
				(gCurRoom sel_906: (+ (gCurRoom sel_906:) 100))
				(PlayScene 915 gCurRoom)
				(gCurRoom sel_878:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

