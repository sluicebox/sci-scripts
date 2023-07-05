;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15010)
(include sci.sh)
(use Main)
(use n011)
(use BaseRoom)
(use BaseRegion)
(use Polygon)
(use Feature)

(public
	rm15010 0
)

(instance rm15010 of BaseRoom
	(properties
		roomNum 10
		picNorth 15038
		picEast 15037
		picSouth 15040
		picWest 15039
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(15006
				(= curDir 2)
			)
			(15009
				(= curDir 1)
			)
			(15011
				(= curDir 3)
			)
			(else
				(= curDir 1)
			)
		)
		(if ((BaseRegion baseDoors:) at: 11)
			(+= picNorth 100)
		)
		(if ((BaseRegion baseDoors:) at: 15)
			(+= picEast 100)
		)
		(if ((BaseRegion baseDoors:) at: 14)
			(+= picWest 100)
		)
		(super init:)
		(cond
			((and (== curDir 0) (not ((BaseRegion baseDoors:) at: 11)))
				(exitNDoor init:)
				(doorLatchN init:)
			)
			((and (== curDir 3) (not ((BaseRegion baseDoors:) at: 14)))
				(exitWDoor init:)
				(doorLatchW init:)
			)
			((and (== curDir 1) (not ((BaseRegion baseDoors:) at: 15)))
				(exitDoor init:)
			)
		)
	)

	(method (cue)
		(cond
			((and (== curDir 1) (not ((BaseRegion baseDoors:) at: 15)))
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
			((and (== curDir 0) (not ((BaseRegion baseDoors:) at: 11)))
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
			((and (== curDir 3) (not ((BaseRegion baseDoors:) at: 14)))
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
				(gCurRoom travel: (gCurRoom roomNum:) (gCurRoom curDir:))
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
		y 128
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 885 16 981 16 981 240 885 240
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
		x 841
		y 219
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 817 254 817 185 865 185 865 254
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
		x 934
		y 123
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 883 6 986 6 986 241 883 241
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
		x 850
		y 218
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 829 256 829 181 871 181 871 256
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

