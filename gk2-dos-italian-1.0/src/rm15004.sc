;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15004)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15004 0
)

(instance rm15004 of BaseRoom
	(properties
		BAD_SELECTOR 4
		BAD_SELECTOR 15014
		BAD_SELECTOR 15013
		BAD_SELECTOR 15016
		BAD_SELECTOR 15015
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15003
				(= BAD_SELECTOR 1)
			)
			(15008
				(= BAD_SELECTOR 0)
			)
			(else
				(= BAD_SELECTOR 2)
			)
		)
		(if ((BaseRegion sel_890:) at: 2)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 6)
			(+= BAD_SELECTOR 100)
		)
		(super init:)
		(if (and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 2)))
			(exitWDoor init:)
			(doorLatch init:)
		)
		(if (and (== BAD_SELECTOR 2) (not ((BaseRegion sel_890:) at: 6)))
			(exitDoor init:)
		)
	)

	(method (cue)
		(cond
			((and (== BAD_SELECTOR 2) (not ((BaseRegion sel_890:) at: 6)))
				(if (not (gFeatures contains: exitDoor))
					(exitDoor init:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatch dispose:)
				)
			)
			((and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 2)))
				(if (not (gFeatures contains: exitWDoor))
					(exitWDoor init:)
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
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
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
		x 936
		y 129
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 894 23 978 26 978 232 894 235
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

(instance doorLatch of GKFeature
	(properties
		x 882
		y 216
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 871 249 871 183 893 183 893 249
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

