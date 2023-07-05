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
		roomNum 6
		picNorth 15022
		picEast 15021
		picSouth 15024
		picWest 15023
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15002
				(= curDir 2)
			)
			(15005
				(= curDir 1)
			)
			(15007
				(= curDir 3)
			)
			(15010
				(= curDir 0)
			)
			(else
				(= curDir 1)
			)
		)
		(if ((BaseRegion baseDoors:) at: 4)
			(+= picNorth 100)
		)
		(if ((BaseRegion baseDoors:) at: 8)
			(+= picEast 100)
		)
		(if ((BaseRegion baseDoors:) at: 11)
			(+= picSouth 100)
		)
		(if ((BaseRegion baseDoors:) at: 7)
			(+= picWest 100)
		)
		(super init:)
		(if (and (== curDir 0) (not ((BaseRegion baseDoors:) at: 4)))
			(exitNDoor init:)
			(doorLatchN init:)
		)
		(if (and (== curDir 3) (not ((BaseRegion baseDoors:) at: 7)))
			(exitWDoor init:)
			(doorLatchW init:)
		)
		(if
			(or
				(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 8)))
				(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 11)))
			)
			(exitDoor init:)
		)
	)

	(method (cue)
		(cond
			(
				(or
					(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 8)))
					(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 11)))
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
			((and (== curDir 0) (not ((BaseRegion baseDoors:) at: 4)))
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
			((and (== curDir 3) (not ((BaseRegion baseDoors:) at: 7)))
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
		x 933
		y 133
		exitDir 0
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
				(gCurRoom travel: (gCurRoom roomNum:) (gCurRoom curDir:))
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

(instance exitNDoor of ExitFeature
	(properties
		x 939
		y 131
		exitDir 0
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
				(gCurRoom travel: (gCurRoom roomNum:) (gCurRoom curDir:))
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

