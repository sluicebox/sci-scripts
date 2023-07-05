;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7002)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoAtriumEenie 0
)

(instance octoAtriumEenie of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7001 ; octoAtriumPad
				(self addPicObj: faceGate facePad faceGate)
				(self setScript: sPadUp)
			)
			(7003 ; octoAtriumEenieCU
				(gCurRoom addPicObj: faceGate facePad faceGate)
				(if (IsFlag 180)
					(gGame handsOff:)
					(gCurRoom drawPic: 7032)
					(gCurRoom setScript: sGateDown)
				)
			)
			(else
				(self addPicObj: facePad faceGate facePad)
			)
		)
	)
)

(instance faceGate of CameraAngle
	(properties
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 180)
			(= picture 7032)
			(exitToEenie init:)
		else
			(= picture 7021)
			(exitToGate init:)
		)
		(theGate init:)
		(gCurRoom exitN: exitToGate)
		(super init: &rest)
	)
)

(instance facePad of CameraAngle
	(properties
		picture 7022
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToPad init:)
		(gCurRoom exitN: exitToPad)
		(super init:)
		(padUp init:)
		(mynieGate_135 init:)
	)
)

(instance exitToPad of ExitFeature
	(properties
		nsLeft 213
		nsTop 151
		nsRight 400
		nsBottom 224
		nextRoom 7001
	)
)

(instance exitToEenie of ExitFeature
	(properties
		nsLeft 136
		nsTop 125
		nsRight 463
		nsBottom 278
		nextRoom 7100
		exitStyle 256
	)
)

(instance theGate of Feature
	(properties
		noun 24
		nsLeft 136
		nsTop 125
		nsRight 463
		nsBottom 278
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 180)
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
		case 4
		nsLeft 200
		nsTop 190
		nsRight 355
		nsBottom 215
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mynieGate_135 of Feature
	(properties
		noun 24
		case 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 142 326 142 350 173 251 175 269 143
					yourself:
				)
		)
	)
)

(instance exitToGate of Feature
	(properties
		nsLeft 265
		nsTop 145
		nsRight 335
		nsBottom 195
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 104)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(104
				(gCurRoom newRoom: 7003) ; octoAtriumEenieCU
			)
			(2
				(gCurRoom newRoom: 7003) ; octoAtriumEenieCU
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
				(eenieGate setPri: 20 setSpeed: 2 yStep: 3 init: global117)
				(= seconds 1)
			)
			(1
				(eenieGate setMotion: MoveTo 78 243 self)
				(theGateSnd play:)
				(proc201_1 16)
			)
			(2
				(= gPrevRoomNum 7001) ; octoAtriumPad
				(eenieGate dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance padUpSnd of Sound
	(properties
		flags 5
		number 7100
	)
)

(instance theGateSnd of Sound
	(properties
		flags 5
		number 7025
	)
)

(instance eenieGate of Actor
	(properties
		x 78
		y 92
		view 7001
	)
)

