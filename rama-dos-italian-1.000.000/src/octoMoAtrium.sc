;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7400)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use newYorkRegion)
(use n1111)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoMoAtrium 0
)

(instance octoMoAtrium of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7401 ; octoMoCistern
				(self addPicObj: faceAtrium faceCis faceAtrium)
			)
			(7402 ; octoMoAtrCU
				(if (proc1111_24 194)
					(proc201_1 15)
					(gCurRoom setScript: sOpenGate)
				)
				(self addPicObj: faceAtrium faceCis faceAtrium)
			)
			(else
				(self addPicObj: faceCis faceAtrium faceCis)
			)
		)
	)

	(method (dispose)
		(if
			(and
				(== picObj faceAtrium)
				(proc1111_24 194)
				(IsFlag 198)
				(!= (SoundManager musicNum:) 7000)
			)
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7000)
		)
		(super dispose: &rest)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 45
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 194)
			(if (IsFlag 181)
				(= picture 7410)
			else
				(= picture 7401)
			)
			(exitToGate init:)
		else
			(if (IsFlag 181)
				(= picture 7409)
			else
				(= picture 7407)
			)
			(exitToAtrium init:)
			(gCurRoom exitN: exitToAtrium)
		)
		(theGate init:)
		(super init:)
	)
)

(instance faceCis of CameraAngle
	(properties
		heading 225
		picture 7402
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToCis init:)
		(gCurRoom exitN: exitToCis)
		(entToCis init:)
		(super init:)
	)
)

(instance exitToAtrium of ExitFeature
	(properties
		nsBottom 250
		nsLeft 178
		nsRight 432
		nsTop 96
		nextRoom 7008
		exitStyle 256
	)
)

(instance exitToCis of ExitFeature
	(properties
		nsBottom 256
		nsLeft 221
		nsRight 561
		nsTop 117
		nextRoom 7401
	)
)

(instance entToCis of Feature
	(properties
		noun 28
		nsBottom 256
		nsLeft 221
		nsRight 561
		nsTop 117
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance exitToGate of Feature
	(properties
		nsBottom 201
		nsLeft 267
		nsRight 337
		nsTop 151
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 84)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84
				(gCurRoom newRoom: 7402) ; octoMoAtrCU
			)
			(2
				(gCurRoom newRoom: 7402) ; octoMoAtrCU
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theGate of Feature
	(properties
		noun 27
		nsBottom 277
		nsLeft 12
		nsRight 571
		nsTop 5
	)

	(method (init)
		(if (IsFlag 194)
			(= case 1)
		else
			(= case 2)
		)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance sOpenGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(innerGate init: global117)
				(= seconds 1)
			)
			(1
				(innerGate setMotion: MoveTo 110 365 self)
				(theGateSnd play:)
			)
			(2
				(= gPrevRoomNum 7401) ; octoMoCistern
				(innerGate dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance innerGate of Actor
	(properties
		x 110
		y 233
		view 7401
	)

	(method (init)
		(self setPri: 20 yStep: 3 setSpeed: 2)
		(super init: &rest)
	)
)

(instance theGateSnd of Sound
	(properties
		number 7025
		flags 5
	)
)

