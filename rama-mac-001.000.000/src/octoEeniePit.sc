;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7112)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoEeniePit 0
)

(instance octoEeniePit of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7111 ; octoEenieGateOutCU
				(if (IsFlag 193)
					(gCurRoom setScript: sOpenGate)
				)
				(self addPicObj: faceAtrium facePit faceAtrium)
			)
			(7108 ; octoEenie9
				(self addPicObj: facePit faceAtrium facePit)
			)
			(else
				(self addPicObj: faceAtrium facePit faceAtrium)
			)
		)
	)
)

(instance facePit of CameraAngle
	(properties
		picture 7126
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToPit init:)
		(gCurRoom exitN: exitToPit)
		(super init:)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 193)
			(= picture 7132)
			(exitToAtriumDir init:)
			(gCurRoom exitN: exitToAtriumDir)
			(openGate init:)
		else
			(= picture 7125)
			(exitToGate init:)
		)
		(super init:)
	)
)

(instance exitToPit of ExitFeature
	(properties
		nsLeft 178
		nsTop 96
		nsRight 432
		nsBottom 235
		nextRoom 7700
		exitStyle 256
	)
)

(instance exitToAtriumDir of ExitFeature
	(properties
		nsLeft 178
		nsTop 96
		nsRight 432
		nsBottom 235
		nextRoom 7108
	)
)

(instance openGate of Feature
	(properties
		noun 31
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
		noun 31
		case 1
		nsLeft 265
		nsTop 145
		nsRight 335
		nsBottom 195
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 88 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(88
				(gCurRoom newRoom: 7111) ; octoEenieGateOutCU
			)
			(2
				(gCurRoom newRoom: 7111) ; octoEenieGateOutCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom drawPic: 7132)
				(innerGate init: global117)
				(= seconds 1)
			)
			(1
				(innerGate setMotion: MoveTo 77 400 self)
				(theGateSnd play:)
			)
			(2
				(= gPrevRoomNum 7108) ; octoEenie9
				(innerGate dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance innerGate of Actor
	(properties
		x 77
		y 250
		view 7101
		loop 2
	)

	(method (init)
		(self setPri: 20 yStep: 3 setSpeed: 2)
		(super init: &rest)
	)
)

(instance theGateSnd of Sound
	(properties
		flags 5
		number 7025
	)
)

