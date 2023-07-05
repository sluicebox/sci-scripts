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
		roomNum 2
		picNorth 15006
		picEast 15005
		picSouth 15008
		picWest 15007
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15001
				(= curDir 1)
			)
			(15003
				(= curDir 3)
			)
			(15006
				(= curDir 0)
			)
			(else
				(= curDir 1)
			)
		)
		(if ((BaseRegion baseDoors:) at: 0)
			(+= picWest 100)
		)
		(if ((BaseRegion baseDoors:) at: 1)
			(+= picEast 100)
		)
		(if ((BaseRegion baseDoors:) at: 4)
			(+= picSouth 100)
		)
		(super init:)
		(if (and (== curDir 3) (not ((BaseRegion baseDoors:) at: 0)))
			(exitWDoor init:)
			(doorLatch init:)
		)
		(if
			(or
				(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 1)))
				(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 4)))
			)
			(exitDoor init:)
		)
	)

	(method (cue)
		(cond
			(
				(or
					(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 1)))
					(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 4)))
				)
				(if (not (gFeatures contains: exitDoor))
					(exitDoor init:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
					(doorLatch dispose:)
				)
			)
			((and (== curDir 3) (not ((BaseRegion baseDoors:) at: 0)))
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
					init: 886 23 985 23 985 240 886 240
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

