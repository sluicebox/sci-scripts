;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4021)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Feature)
(use System)

(public
	bk1MusSECU3 0
)

(instance bk1MusSECU3 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4044)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit24Butn init: global117)
		(TOOL_135 init:)
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
				(wrench stop: self 1)
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

(instance TOOL_135 of Feature
	(properties
		noun 17
		nsBottom 175
		nsLeft 232
		nsRight 349
		nsTop 131
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance exhibit24Butn of ExhibitButton
	(properties
		x 261
		y 200
		view 4054
	)

	(method (init)
		(if (IsFlag 312)
			(wrench init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(wrench stop: 0 1)
					(ClearFlag 312)
				else
					(wrench init: 1 play:)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wrench of RobotPlayer
	(properties
		robot 4052
		robotX 253
		robotY 104
	)
)

