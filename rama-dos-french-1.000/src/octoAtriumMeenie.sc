;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7004)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoAtriumMeenie 0
)

(instance octoAtriumMeenie of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7001 ; octoAtriumPad
				(self addPicObj: faceGate facePad faceGate)
				(gCurRoom setScript: sPadUp)
			)
			(7005 ; octoAtriumMeenieCU
				(self addPicObj: faceGate facePad faceGate)
				(if (IsFlag 181)
					(gGame handsOff:)
					(self drawPic: 7033)
					(gCurRoom setScript: sGateDown)
				)
			)
			(else
				(SoundManager playMusic: 0 1 7000)
				(self addPicObj: facePad faceGate facePad)
			)
		)
	)
)

(instance faceGate of CameraAngle
	(properties
		heading 45
		picture 7023
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 181)
			(= picture 7033)
			(exitToMeenie init:)
			(gCurRoom exitN: exitToMeenie)
		else
			(= picture 7023)
			(exitToGate init:)
		)
		(super init:)
		(theGate init:)
	)
)

(instance facePad of CameraAngle
	(properties
		heading 225
		picture 7024
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPad init:)
		(gCurRoom exitN: exitToPad)
		(super init:)
		(padUp init:)
		(exitToMo_225 init:)
		(exitToRamp_225 init:)
	)
)

(instance exitToPad of ExitFeature
	(properties
		nsBottom 224
		nsLeft 213
		nsRight 400
		nsTop 151
		nextRoom 7001
	)
)

(instance exitToMeenie of ExitFeature
	(properties
		nsBottom 278
		nsLeft 136
		nsRight 463
		nsTop 125
		nextRoom 7200
		exitStyle 256
	)
)

(instance theGate of Feature
	(properties
		noun 24
		nsBottom 278
		nsLeft 136
		nsRight 463
		nsTop 125
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 181)
			(= case 2)
		else
			(= case 1)
		)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance padUp of Feature
	(properties
		noun 25
		nsBottom 209
		nsLeft 198
		nsRight 390
		nsTop 191
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance exitToRamp_225 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 470 104 537 102 563 145 448 142 469 107
					yourself:
				)
		)
	)
)

(instance exitToMo_225 of Feature
	(properties
		noun 24
		case 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 270 141 326 139 349 177 247 173 268 140
					yourself:
				)
		)
	)
)

(instance exitToGate of Feature
	(properties
		nsBottom 195
		nsLeft 265
		nsRight 342
		nsTop 145
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 91)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(91
				(gCurRoom newRoom: 7005) ; octoAtriumMeenieCU
			)
			(2
				(gCurRoom newRoom: 7005) ; octoAtriumMeenieCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sPadUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(padUpSnd init: play: self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGateDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(meenieGate setPri: 20 setSpeed: 2 yStep: 3 init: global117)
				(= seconds 1)
			)
			(1
				(meenieGate setMotion: MoveTo 78 243 self)
				(theGateSnd play:)
				(proc201_1 16)
			)
			(2
				(= gPrevRoomNum 7001) ; octoAtriumPad
				(meenieGate dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance meenieGate of Actor
	(properties
		x 78
		y 92
		view 7002
	)
)

(instance padUpSnd of Sound
	(properties
		number 7100
		flags 5
	)
)

(instance theGateSnd of Sound
	(properties
		number 7025
		flags 5
	)
)

