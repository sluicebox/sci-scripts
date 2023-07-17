;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15002)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15002 0
)

(instance rm15002 of BaseRoom
	(properties
		BAD_SELECTOR 2
		BAD_SELECTOR 15006
		BAD_SELECTOR 15005
		BAD_SELECTOR 15008
		BAD_SELECTOR 15007
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15001
				(= BAD_SELECTOR 1)
			)
			(15003
				(= BAD_SELECTOR 3)
			)
			(15006
				(= BAD_SELECTOR 0)
			)
			(else
				(= BAD_SELECTOR 1)
			)
		)
		(if ((BaseRegion sel_890:) at: 0)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 1)
			(+= BAD_SELECTOR 100)
		)
		(if ((BaseRegion sel_890:) at: 4)
			(+= BAD_SELECTOR 100)
		)
		(super init:)
		(if (and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 0)))
			(exitWDoor init:)
			(doorLatch init:)
		)
		(if
			(or
				(and (== BAD_SELECTOR 1) (not ((BaseRegion sel_890:) at: 1)))
				(and (== BAD_SELECTOR 2) (not ((BaseRegion sel_890:) at: 4)))
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
						(not ((BaseRegion sel_890:) at: 1))
					)
					(and
						(== BAD_SELECTOR 2)
						(not ((BaseRegion sel_890:) at: 4))
					)
				)
				(if (not (gFeatures contains: exitDoor))
					(exitDoor init:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatch dispose:)
				)
			)
			((and (== BAD_SELECTOR 3) (not ((BaseRegion sel_890:) at: 0)))
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
		x 935
		y 131
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 886 23 985 23 985 240 886 240
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
		x 867
		y 219
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 850 188 885 179 885 248 873 260 850 260
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

