;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15008)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15008 0
)

(instance rm15008 of BaseRoom
	(properties
		BAD_SELECTOR 8
		BAD_SELECTOR 15030
		BAD_SELECTOR 15029
		BAD_SELECTOR 15032
		BAD_SELECTOR 15031
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15004
				(= BAD_SELECTOR 2)
			)
			(15007
				(= BAD_SELECTOR 1)
			)
			(15012
				(= BAD_SELECTOR 0)
			)
			(else
				(= BAD_SELECTOR 2)
			)
		)
		(if ((BaseRegion sel_890:) at: 6)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 13)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 9)
			(+= BAD_SELECTOR 100)
		)
		(super init:)
		(if (and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 6)))
			(exitNDoor init:)
			(doorLatchN init:)
		)
		(if (and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 9)))
			(exitWDoor init:)
			(doorLatchW init:)
		)
		(if (and (== BAD_SELECTOR 2) (not ((BaseRegion sel_890:) at: 13)))
			(exitDoor init:)
		)
	)

	(method (cue)
		(cond
			((and (== BAD_SELECTOR 2) (not ((BaseRegion sel_890:) at: 13)))
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
			((and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 6)))
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
			((and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 9)))
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
		x 929
		y 139
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 886 38 973 38 973 240 886 240
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
		x 834
		y 225
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 815 254 815 196 854 196 854 254
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
		x 934
		y 126
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 884 11 984 11 984 242 884 242
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
		x 865
		y 229
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 847 261 847 197 883 197 883 261
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

