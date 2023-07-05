;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7200)
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
	octoMeenieAtrium 0
)

(instance octoMeenieAtrium of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7212 ; octoMeenieAtriumCU
				(if (IsFlag 181)
					(gCurRoom setScript: sOpenGate)
				)
				(self addPicObj: faceAtrium faceMeenie faceAtrium)
			)
			(7202 ; octoMeenie3
				(self addPicObj: faceAtrium faceMeenie faceAtrium)
			)
			(else
				(if (!= (SoundManager musicNum:) 7150)
					(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7150)
				)
				(self addPicObj: faceMeenie faceAtrium faceMeenie)
			)
		)
	)

	(method (dispose)
		(if
			(and
				(IsFlag 180)
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
		heading 225
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 181)
			(= picture 7203)
			(exitToAtrium init:)
			(gCurRoom exitN: exitToAtrium)
			(openGate init:)
		else
			(= picture 7201)
			(exitToGate init:)
		)
		(super init:)
	)
)

(instance faceMeenie of CameraAngle
	(properties
		heading 45
		picture 7202
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMeenie init:)
		(gCurRoom exitN: exitToMeenie)
		(super init:)
	)
)

(instance exitToGate of Feature
	(properties
		noun 27
		nsBottom 195
		nsLeft 265
		nsRight 335
		nsTop 145
		case 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 91 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(91
				(gCurRoom newRoom: 7212) ; octoMeenieAtriumCU
			)
			(2
				(gCurRoom newRoom: 7212) ; octoMeenieAtriumCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openGate of Feature
	(properties
		noun 27
		nsBottom 235
		nsLeft 178
		nsRight 432
		nsTop 96
		case 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance exitToAtrium of ExitFeature
	(properties
		nsBottom 235
		nsLeft 178
		nsRight 432
		nsTop 96
		nextRoom 7004
		exitStyle 256
	)
)

(instance exitToMeenie of ExitFeature
	(properties
		nsBottom 235
		nsLeft 178
		nsRight 432
		nsTop 125
		nextRoom 7202
	)
)

(instance sOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom drawPic: 7203)
				(meenieGate init: global117)
				(= seconds 1)
			)
			(1
				(meenieGate setMotion: MoveTo 100 241 self)
				(theGateSnd play:)
			)
			(2
				(= gPrevRoomNum 7202) ; octoMeenie3
				(meenieGate dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance meenieGate of Actor
	(properties
		x 100
		y 105
		loop 2
		view 7200
	)

	(method (init)
		(self setPri: 20 setSpeed: 2 yStep: 2)
		(super init: &rest)
	)
)

(instance theGateSnd of Sound
	(properties
		number 7025
		flags 5
	)
)

