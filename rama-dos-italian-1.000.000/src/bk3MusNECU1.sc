;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4215)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Feature)
(use Actor)
(use System)

(public
	bk3MusNECU1 0
)

(instance bk3MusNECU1 of CloseupLocation
	(properties
		heading 45
	)

	(method (init)
		(super init: 4234)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit18Butn init: global117)
		(HELMET_45 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sTurnOffHelmet)
		else
			(super pitch: param1 &rest)
		)
	)
)

(instance sTurnOffHelmet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(helmet dispose:)
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

(instance exhibit18Butn of ExhibitButton
	(properties
		x 274
		y 291
		view 4260
	)

	(method (init)
		(if (IsFlag 312)
			(helmet init: global117)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(helmet dispose:)
					(ClearFlag 312)
				else
					(helmet init: global117)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance helmet of View
	(properties
		x 198
		y 260
		loop 1
		view 4260
	)
)

(instance HELMET_45 of Feature
	(properties
		noun 53
		nsBottom 211
		nsLeft 216
		nsRight 367
		nsTop 123
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

