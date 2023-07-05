;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15001)
(include sci.sh)
(use Main)
(use BaseRoom)
(use BaseRegion)
(use Styler)
(use Polygon)
(use Feature)
(use Sound)

(public
	rm15001 0
)

(instance rm15001 of BaseRoom ; "Wittelsbacher Theater: Basement Hall"
	(properties
		modNum 1180
		noun 11
		roomNum 1
		picNorth 15002
		picEast 15001
		picSouth 15004
		picWest 15003
	)

	(method (init)
		(self setRegions: 15000) ; BaseRegion
		(switch gPrevRoomNum
			(1150 ; backStageRm
				(= style 10)
				(Styler seconds: 5)
				(= curDir 1)
			)
			(15002
				(= curDir 3)
			)
			(15005
				(= curDir 0)
			)
			(else
				(= curDir 1)
			)
		)
		(if ((BaseRegion baseDoors:) at: 0)
			(+= picEast 100)
		)
		(if ((BaseRegion baseDoors:) at: 3)
			(+= picSouth 100)
		)
		(Load 140 15012) ; WAVE
		(super init:)
		(if
			(or
				(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 0)))
				(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 3)))
			)
			(exitDoor init:)
		)
		(if (== curDir 3)
			(exitWDoor init:)
		)
	)

	(method (cue)
		(cond
			(
				(or
					(and (== curDir 1) (not ((BaseRegion baseDoors:) at: 0)))
					(and (== curDir 2) (not ((BaseRegion baseDoors:) at: 3)))
				)
				(if (not (gFeatures contains: exitDoor))
					(exitDoor init:)
				)
				(if (gFeatures contains: exitWDoor)
					(exitWDoor dispose:)
				)
			)
			((== curDir 3)
				(if (not (gFeatures contains: exitWDoor))
					(exitWDoor init:)
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
		x 921
		y 118
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 854 0 988 0 988 236 854 236
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(sfxWolfWhine play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sfxWolfWhine of Sound
	(properties
		number 15012
	)
)

