;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4125)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Feature)
(use System)

(public
	bk2MusSWCU2 0
)

(instance bk2MusSWCU2 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 4141)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit20Butn init: global117)
		(ROCKET_225 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sStopRocket)
		else
			(proc1111_6)
			(super pitch: param1 &rest)
		)
	)
)

(instance sStopRocket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mirmicatRocket stop: self 1)
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

(instance exhibit20Butn of ExhibitButton
	(properties
		x 258
		y 230
		view 4151
	)

	(method (init)
		(if (IsFlag 312)
			(mirmicatRocket init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(mirmicatRocket stop: 0 1)
					(ClearFlag 312)
				else
					(mirmicatRocket init: 1 play:)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mirmicatRocket of RobotPlayer
	(properties
		robot 4151
		startRobot 4153
		endRobot 4154
		robotX 323
		robotY 11
		startSnd 4120
		loopSnd 4121
		endSnd 4122
	)
)

(instance ROCKET_225 of Feature
	(properties
		noun 38
		nsBottom 116
		nsLeft 174
		nsRight 399
		nsTop 54
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

