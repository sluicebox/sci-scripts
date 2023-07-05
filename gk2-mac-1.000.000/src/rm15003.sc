;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15003)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15003 0
)

(instance rm15003 of BaseRoom
	(properties
		roomNum 3
		picNorth 15010
		picEast 15009
		picSouth 15012
		picWest 15011
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15002
				(= curDir 1)
			)
			(15004
				(= curDir 3)
			)
			(15007
				(= curDir 0)
			)
			(else
				(= curDir 1)
			)
		)
		(if ((BaseRegion baseDoors:) at: 1)
			(+= picWest 100)
		)
		(if ((BaseRegion baseDoors:) at: 2)
			(+= picEast 100)
		)
		(if ((BaseRegion baseDoors:) at: 5)
			(+= picSouth 100)
		)
		(super init:)
		(if (and (== curDir 3) (not ((BaseRegion baseDoors:) at: 1)))
			(exitWDoor init:)
			(doorLatch init:)
		)
		(if
			(or
				(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 2)))
				(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 5)))
			)
			(exitDoor init:)
		)
	)

	(method (cue)
		(cond
			(
				(or
					(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 2)))
					(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 5)))
				)
				(if (not (gFeatures contains: exitDoor))
					(exitDoor init:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatch dispose:)
				)
			)
			((and (== curDir 3) (not ((BaseRegion baseDoors:) at: 1)))
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
		exitDir 0
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
				(switch (gCurRoom curDir:)
					(1
						(gCurRoom travel: (gCurRoom roomNum:) (gCurRoom curDir:))
					)
					(2
						(gCurRoom travel: (gCurRoom roomNum:) (gCurRoom curDir:))
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
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 890 45 969 45 969 225 890 225
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom travel: (gCurRoom roomNum:) (gCurRoom curDir:))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorLatch of GKFeature
	(properties
		x 877
		y 209
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 865 239 865 180 890 180 890 239
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(((BaseRegion baseRooms:) at: (- (gCurRoom roomNum:) 1))
					closeDoor: (gCurRoom roomNum:) (gCurRoom curDir:)
				)
				(gCurRoom picWest: (+ (gCurRoom picWest:) 100))
				(PlayScene 915 gCurRoom)
				(gCurRoom refresh:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

