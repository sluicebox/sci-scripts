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
		roomNum 5
		picNorth 15018
		picEast 15017
		picSouth 15020
		picWest 15019
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15001
				(= curDir 2)
			)
			(15006
				(= curDir 3)
			)
			(15009
				(= curDir 0)
			)
			(else
				(= curDir 1)
			)
		)
		(if ((BaseRegion baseDoors:) at: 3)
			(+= picNorth 100)
		)
		(if ((BaseRegion baseDoors:) at: 7)
			(+= picEast 100)
		)
		(if ((BaseRegion baseDoors:) at: 10)
			(+= picSouth 100)
		)
		(super init:)
		(if (and (== curDir 0) (not ((BaseRegion baseDoors:) at: 3)))
			(exitNDoor init:)
			(doorLatch init:)
		)
		(if
			(or
				(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 7)))
				(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 10)))
				(== curDir 3)
			)
			(exitDoor init:)
		)
	)

	(method (cue)
		(cond
			(
				(or
					(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 7)))
					(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 10)))
					(== curDir 3)
				)
				(if (not (gFeatures contains: exitDoor))
					(exitDoor init:)
				)
				(if (gFeatures contains: exitNDoor)
					(exitNDoor dispose:)
					(doorLatch dispose:)
				)
			)
			((and (== curDir 0) (not ((BaseRegion baseDoors:) at: 3)))
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
					(3
						(PlayScene 913)
						(gCurRoom refresh:)
					)
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

(instance exitNDoor of ExitFeature
	(properties
		x 941
		y 131
		exitDir 0
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
				(((BaseRegion baseRooms:) at: (- (gCurRoom roomNum:) 1))
					closeDoor: (gCurRoom roomNum:) (gCurRoom curDir:)
				)
				(gCurRoom picNorth: (+ (gCurRoom picNorth:) 100))
				(PlayScene 915 gCurRoom)
				(gCurRoom refresh:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

