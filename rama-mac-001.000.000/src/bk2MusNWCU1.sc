;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4128)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Feature)
(use Actor)
(use System)

(public
	bk2MusNWCU1 0
)

(instance bk2MusNWCU1 of CloseupLocation
	(properties
		heading 315
	)

	(method (init)
		(super init: 4144)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit24Butn init: global117)
		(LIGHT_315 init:)
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

(instance exhibit24Butn of ExhibitButton
	(properties
		x 273
		y 220
		view 4153
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
					(light dispose:)
					(ClearFlag 312)
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
		x 189
		y 30
		view 4153
		loop 1
	)
)

(instance LIGHT_315 of Feature
	(properties
		noun 34
		nsLeft 250
		nsTop 72
		nsRight 341
		nsBottom 211
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

