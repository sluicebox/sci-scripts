;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7008)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	octoAtriumMo 0
)

(instance octoAtriumMo of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7001 ; octoAtriumPad
				(self addPicObj: faceGate facePad faceGate)
				(gCurRoom setScript: sPadUp)
			)
			(else
				(self addPicObj: facePad faceGate facePad)
			)
		)
	)
)

(instance faceGate of CameraAngle
	(properties
		heading 225
		picture 7029
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToGate init:)
		(gCurRoom exitN: exitToGate)
		(theGate init:)
		(super init:)
	)
)

(instance facePad of CameraAngle
	(properties
		heading 45
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 181)
			(= picture 7039)
		else
			(= picture 7030)
		)
		(exitToPad init:)
		(gCurRoom exitN: exitToPad)
		(super init:)
		(padUp init:)
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

(instance exitToGate of ExitFeature
	(properties
		nsBottom 278
		nsLeft 136
		nsRight 463
		nsTop 125
		nextRoom 7400
		exitStyle 256
	)
)

(instance padUp of Feature
	(properties
		noun 25
		nsBottom 215
		nsLeft 200
		nsRight 355
		nsTop 190
		case 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance theGate of Feature
	(properties
		noun 24
		nsBottom 278
		nsLeft 136
		nsRight 463
		nsTop 125
		case 2
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance meenieGate_45 of Feature ; UNUSED
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 181)
			(= case 2)
		else
			(= case 1)
		)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 138 323 138 343 172 248 171 268 140
					yourself:
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

(instance padUpSnd of Sound
	(properties
		number 7100
		flags 5
	)
)

