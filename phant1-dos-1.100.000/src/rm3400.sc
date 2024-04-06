;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3400)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	rm3400 0
)

(instance rm3400 of ScaryRoom
	(properties
		picture 3400
		stepSound 4
	)

	(method (init)
		(gEgo init: setScaler: Scaler 145 53 158 90 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			((OneOf gPrevRoomNum 5600 5500 5100)
				(gEgo normalize: 2 posn: 147 118)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo posn: 147 118 normalize: 3)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		((ScriptID 30) init:) ; FidgetCode
		(southExit init: 3)
		(if (IsFlag 14)
			(libDoorExit init: 1)
			(libDoor init:)
		else
			(libDoor init: setHotspot: 4 3 8) ; Do, Move, invLibKey
		)
		(super init:)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 0 self 20)
				)
				(1
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(gEgo hide:)
					(SetFlag 14)
					(floor init:)
					(DoRobot 1980 0 0 gEgo -1 1)
					(gCurRoom drawPic: 3620)
				)
				(2
					(if (not global184)
						(global114 endPause:)
					)
					(gGame handsOff:)
					(gCurRoom newRoom: 5600)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(SetFlag 14)
					(if (gCast contains: libDoor)
						(libDoor dispose:)
					)
					(if (not global184)
						(global114 endPause:)
					)
					(gGame handsOff:)
					(gCurRoom newRoom: 5600)
				)
			)
		)
	)
)

(instance sDoorTry of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gEgo setHeading: 0 self 20)
				)
				(1
					(if (gCast contains: libDoor)
						(libDoor hide:)
					)
					(gEgo hide:)
					(DoRobot 410 33 -51)
					(gCurRoom drawPic: 3620)
				)
				(2
					(gEgo
						show:
						posn: 146 104
						normalize: 2
						cel: 0
						setCycle: End self
					)
					(if (gCast contains: libDoor)
						(libDoor show:)
					)
					(gCurRoom drawPic: 3400)
				)
				(3
					(gEgo setCycle: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo show: posn: 146 104 normalize: 2 setCycle: 0)
					(if (gCast contains: libDoor)
						(libDoor show:)
					)
					(gCurRoom drawPic: 3400)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance libDoor of View
	(properties
		approachX 147
		approachY 104
		x 133
		y 96
		view 3400
	)

	(method (init)
		(if (IsFlag 14)
			(self cel: 1)
		else
			(self cel: 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (IsFlag 14)
			(libDoor doVerb: theVerb &rest)
		else
			(switch theVerb
				(4 ; Do
					(gGame handsOff:)
					(SetFlag 93)
					(gCurRoom setScript: sDoorTry)
				)
				(8 ; invLibKey
					(gGame handsOff:)
					(gCurRoom setScript: sOpenDoor)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance floor of View
	(properties
		x 212
		y 102
		priority 10
		fixPriority 1
		view 3620
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 110
		nsTop 120
		nsRight 211
		approachX 147
		approachY 128
		y 143
		nextRoom 3200
	)
)

(instance libDoorExit of ExitFeature
	(properties
		nsLeft 130
		nsTop 52
		nsRight 168
		nsBottom 102
		approachX 147
		approachY 104
		x 147
		y 73
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (not global184)
				(global114 endPause:)
			)
			(gGame handsOff:)
			(gCurRoom newRoom: 5600)
		else
			(super doVerb: theVerb)
		)
	)
)

