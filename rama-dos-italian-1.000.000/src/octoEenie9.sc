;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7108)
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
	octoEenie9 0
)

(instance octoEenie9 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(7016 ; octoAbacusCU
				(self
					addPicObj:
						faceAbacus
						faceAtrium
						faceEenie
						facePit
						faceAbacus
				)
			)
			(7110 ; octoEenieGateInCU
				(self
					addPicObj: facePit faceAbacus faceAtrium faceEenie facePit
				)
				(if (IsFlag 193)
					(gCurRoom setScript: sOpenGate)
				)
			)
			(7106 ; octoEenie7
				(if (== global164 270)
					(self
						addPicObj:
							faceAbacus
							faceAtrium
							faceEenie
							facePit
							faceAbacus
					)
					(= global164 0)
				else
					(self
						addPicObj:
							facePit
							faceAbacus
							faceAtrium
							faceEenie
							facePit
					)
				)
			)
			(else
				(self
					addPicObj:
						faceAtrium
						faceEenie
						facePit
						faceAbacus
						faceAtrium
				)
			)
		)
	)
)

(instance faceEenie of CameraAngle
	(properties
		heading 315
		picture 7119
		edgeS 0
		edgeN 0
	)
)

(instance faceAbacus of CameraAngle
	(properties
		heading 135
		picture 7121
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToAbacus init:)
		(spikes init: global117)
		(super init: &rest)
	)
)

(instance facePit of CameraAngle
	(properties
		heading 45
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 193)
			(exitToPit init:)
			(gCurRoom exitN: exitToPit)
			(= picture 7131)
			(openGate init:)
		else
			(= picture 7120)
			(exitToGate init:)
		)
		(super init:)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 225
		picture 7118
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToAtriumDir init:)
		(gCurRoom exitN: exitToAtriumDir)
		(super init:)
	)
)

(instance exitToAbacus of Feature
	(properties
		noun 30
		nsBottom 249
		nsLeft 252
		nsRight 361
		nsTop 120
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7016) ; octoAbacusCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToPit of ExitFeature
	(properties
		nsBottom 235
		nsLeft 178
		nsRight 432
		nsTop 96
		nextRoom 7112
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
		(self setHotspot: 2 88 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(88
				(gCurRoom newRoom: 7110) ; octoEenieGateInCU
			)
			(2
				(gCurRoom newRoom: 7110) ; octoEenieGateInCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToAtriumDir of ExitFeature
	(properties
		nsBottom 192
		nsLeft 189
		nsRight 398
		nsTop 128
		nextRoom 7106
	)
)

(instance sOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom drawPic: 7131)
				(innerGate init: global117)
				(= seconds 1)
			)
			(1
				(innerGate setMotion: MoveTo 119 360 self)
				(theGateSnd play:)
			)
			(2
				(= gPrevRoomNum 7106) ; octoEenie7
				(innerGate dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance innerGate of Actor
	(properties
		x 119
		y 232
		loop 1
		view 7101
	)

	(method (init)
		(self setPri: 20 yStep: 3 setSpeed: 2)
		(super init: &rest)
	)
)

(instance spikes of View
	(properties
		x 262
		y 131
		view 7101
	)
)

(instance theGateSnd of Sound
	(properties
		number 7025
		flags 5
	)
)

