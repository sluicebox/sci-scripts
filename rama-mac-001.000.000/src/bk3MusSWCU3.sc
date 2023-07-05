;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4226)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Feature)
(use System)

(public
	bk3MusSWCU3 0
)

(instance bk3MusSWCU3 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 4244)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit30Butn init: global117)
		(GAME_225 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sStopThing)
		else
			(super pitch: param1 &rest)
		)
	)
)

(instance sStopThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(octoThing stop: self 1)
				(ClearFlag 312)
			)
			(1
				(= seconds 2)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance exhibit30Butn of ExhibitButton
	(properties
		x 270
		y 236
		view 4256
	)

	(method (init)
		(if (IsFlag 312)
			(octoThing init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(octoThing stop: 0 1)
					(ClearFlag 312)
				else
					(octoThing init: 1 play:)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoThing of RobotPlayer
	(properties
		robot 4256
		robotX 246
		robotY 69
	)
)

(instance GAME_225 of Feature
	(properties
		noun 49
		nsLeft 248
		nsTop 111
		nsRight 337
		nsBottom 156
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

