;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4026)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Feature)
(use Sound)
(use System)

(public
	bk1MusSWCU3 0
)

(instance bk1MusSWCU3 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 4048)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit29Butn init: global117)
		(eyeGlasses_225 init:)
	)

	(method (pitch param1)
		(if (IsFlag 312)
			(self setScript: sStopThing)
		else
			(super pitch: param1 &rest)
		)
	)

	(method (cue)
		(if (IsFlag 312)
			(ClearFlag 312)
		)
	)
)

(instance sStopThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (eyeGlasses isPlaying:)
					(eyeGlasses stop: self 1)
				else
					(= cycles 1)
				)
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

(instance exhibit29Butn of ExhibitButton
	(properties
		x 288
		y 232
		view 4056
	)

	(method (init)
		(if (IsFlag 312)
			(eyeGlasses init: 0 play: gCurRoom)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(eyeGlasses stop: 0 1)
					(ClearFlag 312)
				else
					(holoUpSnd play:)
					(eyeGlasses init: 0 play: gCurRoom)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eyeGlasses_225 of Feature
	(properties
		noun 14
		nsBottom 188
		nsLeft 236
		nsRight 335
		nsTop 148
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance eyeGlasses of RobotPlayer
	(properties
		robot 4053
		robotX 123
		robotY 137
	)
)

(instance holoUpSnd of Sound
	(properties
		number 4024
	)
)

