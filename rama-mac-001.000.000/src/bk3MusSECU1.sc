;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4219)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Feature)
(use Actor)
(use System)

(public
	bk3MusSECU1 0
)

(instance bk3MusSECU1 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4238)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit23Button init: global117)
		(LIGHT_135 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sTurnOffLight)
		else
			(super pitch: param1 &rest)
		)
	)
)

(instance sTurnOffLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(light dispose:)
				(ClearFlag 312)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance exhibit23Button of ExhibitButton
	(properties
		x 268
		y 206
		view 4253
	)

	(method (init)
		(if (IsFlag 312)
			(light init: global117)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(ClearFlag 312)
					(light dispose:)
				else
					(light init: global117)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance light of View
	(properties
		x 167
		y 76
		view 4253
		loop 1
	)
)

(instance LIGHT_135 of Feature
	(properties
		noun 50
		nsLeft 196
		nsTop 98
		nsRight 401
		nsBottom 247
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

