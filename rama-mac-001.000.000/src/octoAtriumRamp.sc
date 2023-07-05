;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7000)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	octoAtriumRamp 0
)

(instance octoAtriumRamp of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7001 ; octoAtriumPad
				(self addPicObj: faceTunnel facePad faceTunnel)
				(gCurRoom setScript: sPadUp)
			)
			(7010 ; octoRampBottom
				(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7000)
				(self addPicObj: facePad faceTunnel facePad)
			)
			(else
				(self addPicObj: facePad faceTunnel facePad)
			)
		)
		(if (proc1111_24 212)
			(proc1111_31 28)
			(SetFlag 212)
		)
	)

	(method (dispose)
		(if (== picObj faceTunnel)
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7150)
		)
		(super dispose: &rest)
	)
)

(instance faceTunnel of CameraAngle
	(properties
		picture 7001
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(rampExit init:)
		(gCurRoom exitN: rampExit)
		(super init:)
		(theRamps init:)
	)
)

(instance facePad of CameraAngle
	(properties
		picture 7002
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (proc1111_24 181)
			(meenieGate init: global117)
		)
		(exitToPad init:)
		(gCurRoom exitN: exitToPad)
		(padUp_90 init:)
		(super init:)
	)
)

(instance rampExit of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 7010
		exitStyle 256
	)
)

(instance theRamps of Feature
	(properties
		noun 16
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance exitToPad of ExitFeature
	(properties
		nsLeft 234
		nsTop 105
		nsRight 375
		nsBottom 202
		nextRoom 7001
	)
)

(instance padUp_90 of Feature
	(properties
		noun 25
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 237 215 218 229 198 214 268 194 320 195 390 212 373 230 354 215 238 214
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

(instance meenieGate of View
	(properties
		x 36
		y 127
		view 7002
		loop 1
		cel 2
	)
)

