;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7006)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use System)

(public
	octoAtriumMynie 0
)

(instance octoAtriumMynie of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7001 ; octoAtriumPad
				(self addPicObj: faceGate facePad faceGate)
				(gCurRoom setScript: sPadUp)
			)
			(7007 ; octoAtriumMynieCU
				(SoundManager playMusic: 0 1 7000)
				(self addPicObj: faceGate facePad faceGate)
			)
			(else
				(self addPicObj: facePad faceGate facePad)
			)
		)
	)
)

(instance faceGate of CameraAngle
	(properties
		picture 7026
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToGate init:)
		(super init: &rest)
		(theGate init:)
	)
)

(instance facePad of CameraAngle
	(properties
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 180)
			(= picture 7038)
		else
			(= picture 7027)
		)
		(exitToPad init:)
		(gCurRoom exitN: exitToPad)
		(super init: &rest)
		(padUp init:)
		(theRamps_315 init:)
		(eenieGate_315 init:)
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

(instance exitToGate of Feature
	(properties
		nsLeft 265
		nsTop 145
		nsRight 336
		nsBottom 195
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 7007) ; octoAtriumMynieCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theGate of Feature
	(properties
		noun 23
		nsLeft 136
		nsTop 125
		nsRight 463
		nsBottom 278
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance padUp of Feature
	(properties
		noun 25
		case 4
		nsLeft 198
		nsTop 191
		nsRight 390
		nsBottom 209
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance theRamps_315 of Feature
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
					init: 52 99 127 105 139 142 32 138 60 98
					yourself:
				)
		)
	)
)

(instance eenieGate_315 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 180)
			(= case 2)
		else
			(= case 1)
		)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 264 138 319 139 342 170 250 172
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
		flags 5
		number 7100
	)
)

