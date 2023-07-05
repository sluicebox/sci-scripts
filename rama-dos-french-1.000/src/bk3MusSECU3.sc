;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4221)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk3MusSECU3 0
)

(instance bk3MusSECU3 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4240)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit25Butn init: global117)
		(TOOL_135 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sStopWrench)
		else
			(super pitch: param1 &rest)
		)
	)
)

(instance sStopWrench of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(octoWrench stop: self 1)
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

(instance exhibit25Butn of ExhibitButton
	(properties
		x 263
		y 178
		view 4254
	)

	(method (init)
		(if (IsFlag 312)
			(octoWrench init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(octoWrench stop: 0 1)
					(ClearFlag 312)
				else
					(octoWrench init: 1 play:)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoWrench of RobotPlayer
	(properties
		robot 4254
		robotX 153
		robotY 82
	)
)

(instance TOOL_135 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 222 93 328 36 334 72 217 140 201 116 216 94
					yourself:
				)
		)
	)
)

