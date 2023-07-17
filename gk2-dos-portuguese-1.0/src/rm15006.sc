;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15006)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15006 0
)

(instance rm15006 of BaseRoom
	(properties
		BAD_SELECTOR 6
		BAD_SELECTOR 15022
		BAD_SELECTOR 15021
		BAD_SELECTOR 15024
		BAD_SELECTOR 15023
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15002
				(= BAD_SELECTOR 2)
			)
			(15005
				(= BAD_SELECTOR 1)
			)
			(15007
				(= BAD_SELECTOR 3)
			)
			(15010
				(= BAD_SELECTOR 0)
			)
			(else
				(= BAD_SELECTOR 1)
			)
		)
		(if ((BaseRegion sel_890:) at: 4)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 8)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 11)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 7)
			(+= BAD_SELECTOR 100)
		)
		(super init:)
		(if (and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 4)))
			(exitNDoor init:)
			(doorLatchN init:)
		)
		(if (and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 7)))
			(exitWDoor init:)
			(doorLatchW init:)
		)
		(if
			(or
				(and (== BAD_SELECTOR 1) (not ((BaseRegion sel_890:) at: 8)))
				(and (== BAD_SELECTOR 2) (not ((BaseRegion sel_890:) at: 11)))
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
						(not ((BaseRegion sel_890:) at: 8))
					)
					(and
						(== BAD_SELECTOR 2)
						(not ((BaseRegion sel_890:) at: 11))
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
			((and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 4)))
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
			((and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 7)))
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
				(switch (gCurRoom sel_879:)
					(1
						(gCurRoom sel_916: (gCurRoom sel_880:) (gCurRoom sel_879:))
					)
					(2
						(gCurRoom sel_916: (gCurRoom sel_880:) (gCurRoom sel_879:))
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
		x 933
		y 133
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 885 22 982 22 982 244 885 244
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
		x 870
		y 222
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 856 263 856 181 884 181 884 263
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
		x 939
		y 131
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 893 23 985 23 985 240 893 240
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
		x 877
		y 221
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 863 258 863 185 892 185 892 258
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

