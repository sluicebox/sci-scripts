;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7208)
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
	octoMeenie9 0
)

(instance octoMeenie9 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7209 ; octoMeenieGateInCU
				(if (IsFlag 184)
					(gCurRoom setScript: sOpenGate)
				)
				(self
					addPicObj: facePit faceMeenie faceAtrium faceMuseum facePit
				)
			)
			(7211 ; octoMeeniePit
				(self
					addPicObj:
						faceAtrium
						faceMuseum
						facePit
						faceMeenie
						faceAtrium
				)
			)
			(7206 ; octoMeenie7
				(if (== global164 270)
					(self
						addPicObj:
							faceMuseum
							facePit
							faceMeenie
							faceAtrium
							faceMuseum
					)
				else
					(self
						addPicObj:
							facePit
							faceMeenie
							faceAtrium
							faceMuseum
							facePit
					)
				)
			)
			(7600 ; octoMuseum
				(self
					addPicObj:
						faceMeenie
						faceAtrium
						faceMuseum
						facePit
						faceMeenie
				)
			)
			(else
				(self
					addPicObj:
						faceAtrium
						faceMuseum
						facePit
						faceMeenie
						faceAtrium
				)
			)
		)
	)
)

(instance faceMeenie of CameraAngle
	(properties
		heading 45
		picture 7220
		edgeS 0
		edgeN 0
	)
)

(instance faceMuseum of CameraAngle
	(properties
		heading 225
		picture 7218
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
		(museumExit init:)
		(super init:)
	)
)

(instance facePit of CameraAngle
	(properties
		heading 315
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 184)
			(= picture 7209)
			(exitToPit init:)
			(gCurRoom exitN: exitToPit)
			(openGate init:)
		else
			(= picture 7219)
			(exitToGate init:)
		)
		(super init:)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 135
		picture 7217
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToAtrium init:)
		(gCurRoom exitN: exitToAtrium)
		(super init:)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 235
		nsLeft 178
		nsRight 432
		nsTop 96
		nextRoom 7600
	)
)

(instance exitToPit of ExitFeature
	(properties
		nsBottom 235
		nsLeft 178
		nsRight 432
		nsTop 96
		nextRoom 7211
	)
)

(instance exitToGate of Feature
	(properties
		noun 31
		nsBottom 195
		nsLeft 265
		nsRight 335
		nsTop 145
		case 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 98 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(98
				(gCurRoom newRoom: 7209) ; octoMeenieGateInCU
			)
			(2
				(gCurRoom newRoom: 7209) ; octoMeenieGateInCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToAtrium of ExitFeature
	(properties
		nsBottom 192
		nsLeft 189
		nsRight 398
		nsTop 128
		nextRoom 7206
	)
)

(instance sOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom drawPic: 7209)
				(meenieGate init: global117)
				(= seconds 1)
			)
			(1
				(meenieGate setMotion: MoveTo 100 241 self)
				(theGateSnd play:)
			)
			(2
				(= gPrevRoomNum 7206) ; octoMeenie7
				(meenieGate dispose:)
				(openGate init:)
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
		loop 1
		view 7200
	)

	(method (init)
		(self setPri: 20 yStep: 2 setSpeed: 2)
		(super init: &rest)
	)
)

(instance museumExit of Feature
	(properties
		noun 29
		nsBottom 235
		nsLeft 178
		nsRight 432
		nsTop 96
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance openGate of Feature
	(properties
		noun 31
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

(instance theGateSnd of Sound
	(properties
		number 7025
		flags 5
	)
)

