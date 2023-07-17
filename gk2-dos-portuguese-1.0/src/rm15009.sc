;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15009)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15009 0
)

(instance rm15009 of BaseRoom
	(properties
		BAD_SELECTOR 9
		BAD_SELECTOR 15034
		BAD_SELECTOR 15033
		BAD_SELECTOR 15036
		BAD_SELECTOR 15035
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15005
				(= BAD_SELECTOR 2)
			)
			(15010
				(= BAD_SELECTOR 3)
			)
			(else
				(= BAD_SELECTOR 1)
			)
		)
		(if ((BaseRegion sel_890:) at: 10)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 14)
			(+= BAD_SELECTOR 100)
		)
		(super init:)
		(cond
			((and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 10)))
				(exitNDoor init:)
				(doorLatch init:)
			)
			((and (== BAD_SELECTOR 1) (not ((BaseRegion sel_890:) at: 14)))
				(exitDoor init:)
			)
		)
	)

	(method (cue)
		(cond
			((== BAD_SELECTOR 3)
				(if (gFeatures contains: exitDoor)
					(exitDoor dispose:)
				)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatch dispose:)
				)
			)
			((and (== BAD_SELECTOR 1) (not ((BaseRegion sel_890:) at: 14)))
				(exitDoor init:)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatch dispose:)
				)
			)
			((and (== BAD_SELECTOR 0) (not ((BaseRegion sel_890:) at: 10)))
				(exitNDoor init:)
				(doorLatch init:)
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
				(gCurRoom sel_916: (gCurRoom sel_880:) (gCurRoom sel_879:))
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
		y 127
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 885 12 984 12 984 243 885 243
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
		x 866
		y 225
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 849 257 849 194 884 194 884 257
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

