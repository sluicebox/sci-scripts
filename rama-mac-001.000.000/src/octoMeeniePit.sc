;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7211)
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
	octoMeeniePit 0
)

(instance octoMeeniePit of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7210 ; octoMeenieGateOutCU
				(if (IsFlag 184)
					(gCurRoom setScript: sOpenGate)
				)
				(self addPicObj: faceAtrium facePit faceAtrium)
			)
			(7208 ; octoMeenie9
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
		picture 7224
		heading 315
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
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 184)
			(= picture 7210)
			(exitToAtrium init:)
			(gCurRoom exitN: exitToAtrium)
			(openGate init:)
		else
			(= picture 7223)
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

(instance exitToAtrium of ExitFeature
	(properties
		nsLeft 178
		nsTop 96
		nsRight 432
		nsBottom 235
		nextRoom 7208
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
		(self setHotspot: 2 98 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(98
				(gCurRoom newRoom: 7210) ; octoMeenieGateOutCU
			)
			(2
				(gCurRoom newRoom: 7210) ; octoMeenieGateOutCU
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
				(gCurRoom drawPic: 7210)
				(meenieGate init: global117)
				(= seconds 1)
			)
			(1
				(meenieGate setMotion: MoveTo 100 241 self)
				(theGateSnd play:)
			)
			(2
				(= gPrevRoomNum 7700) ; octoPitRoom
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
		y 104
		view 7200
	)

	(method (init)
		(self setPri: 20 yStep: 2 setSpeed: 2)
		(super init: &rest)
	)
)

(instance theGateSnd of Sound
	(properties
		flags 5
		number 7025
	)
)

