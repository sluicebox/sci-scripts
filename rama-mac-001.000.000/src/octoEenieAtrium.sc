;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7100)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use n1111)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoEenieAtrium 0
)

(instance octoEenieAtrium of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7113 ; octoEenieAtriumCU
				(self addPicObj: faceAtrium faceEenie faceAtrium)
				(if (IsFlag 180)
					(gCurRoom setScript: sOpenGate)
				)
			)
			(7102 ; octoEenie3
				(self addPicObj: faceAtrium faceEenie faceAtrium)
			)
			(else
				(if (!= (SoundManager musicNum:) 7150)
					(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7150)
				)
				(self addPicObj: faceEenie faceAtrium faceEenie)
			)
		)
	)

	(method (dispose)
		(if
			(and
				(IsFlag 181)
				(== picObj faceAtrium)
				(!= (SoundManager musicNum:) 7000)
			)
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7000)
		)
		(super dispose: &rest)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 180)
			(exitToAtrium init:)
			(gCurRoom exitN: exitToAtrium)
			(= picture 7127)
			(openGate init:)
		else
			(= picture 7101)
			(exitToGate init:)
		)
		(super init:)
	)
)

(instance faceEenie of CameraAngle
	(properties
		picture 7102
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToEenie init:)
		(gCurRoom exitN: exitToEenie)
		(super init:)
	)
)

(instance exitToAtrium of ExitFeature
	(properties
		nsLeft 178
		nsTop 96
		nsRight 432
		nsBottom 235
		nextRoom 7002
		exitStyle 256
	)
)

(instance openGate of Feature
	(properties
		noun 27
		case 2
		nsLeft 178
		nsTop 96
		nsRight 432
		nsBottom 235
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance exitToGate of Feature
	(properties
		noun 27
		case 1
		nsLeft 265
		nsTop 145
		nsRight 335
		nsBottom 195
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 104 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(104
				(gCurRoom newRoom: 7113) ; octoEenieAtriumCU
			)
			(2
				(gCurRoom newRoom: 7113) ; octoEenieAtriumCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToEenie of ExitFeature
	(properties
		nsLeft 178
		nsTop 96
		nsRight 432
		nsBottom 235
		nextRoom 7102
	)
)

(instance sOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom drawPic: 7127)
				(theGate init: global117)
				(= seconds 1)
			)
			(1
				(theGate setMotion: MoveTo 118 360 self)
				(theGateSnd play:)
			)
			(2
				(= gPrevRoomNum 7102) ; octoEenie3
				(theGate dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theGate of Actor
	(properties
		x 118
		y 230
		view 7102
	)

	(method (init)
		(self setPri: 20 setSpeed: 2 yStep: 2 ignoreActors: 1)
		(super init: &rest)
	)
)

(instance theGateSnd of Sound
	(properties
		flags 5
		number 7025
	)
)

