;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4016)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk1MusNECU2 0
)

(instance bk1MusNECU2 of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 4039)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit18Butn init: global117)
		(rocket_45 init:)
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
				(earthRocket stop: self 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(gGame handsOn:)
				(ClearFlag 312)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance exhibit18Butn of ExhibitButton
	(properties
		x 260
		y 230
		view 4051
	)

	(method (init)
		(if (IsFlag 312)
			(earthRocket init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(earthRocket stop: 0 1)
					(ClearFlag 312)
				else
					(earthRocket init: 1 play:)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rocket_45 of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 174 56 222 31 307 37 349 59 474 105 422 129 335 128 191 105 180 50
					yourself:
				)
		)
	)
)

(instance earthRocket of RobotPlayer
	(properties
		startRobot 4054
		robot 4050
		endRobot 4055
		robotX 92
		robotY 1
		startSnd 4020
		loopSnd 4021
		endSnd 4022
	)
)

