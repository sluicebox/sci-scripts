;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4216)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk3MusNECU2 0
)

(instance bk3MusNECU2 of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 4235)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit19Butn init: global117)
		(SHIP_45 init:)
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
				(octoRocket stop: self 1)
			)
			(1
				(ClearFlag 312)
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

(instance exhibit19Butn of ExhibitButton
	(properties
		x 268
		y 229
		view 4251
	)

	(method (init)
		(if (IsFlag 312)
			(octoRocket init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (octoRocket isPlaying:)
					(octoRocket stop: 0 1)
					(ClearFlag 312)
				else
					(octoRocket init: 1 play:)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoRocket of RobotPlayer
	(properties
		robot 4251
		startRobot 4253
		endRobot 4257
		robotX 375
		robotY 56
		startSnd 4212
		loopSnd 4213
		endSnd 4214
	)
)

(instance SHIP_45 of Feature
	(properties
		noun 54
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 159 98 237 7 275 66 411 72 406 129 273 134 235 151 169 99
					yourself:
				)
		)
	)
)

