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
		edgeN 0
		edgeS 0
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
		picture 7402
		heading 225
		edgeN 0
		edgeS 0
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
		nsLeft 178
		nsTop 96
		nsRight 432
		nsBottom 250
		nextRoom 7008
		exitStyle 256
	)
)

(instance exitToCis of ExitFeature
	(properties
		nsLeft 221
		nsTop 117
		nsRight 561
		nsBottom 256
		nextRoom 7401
	)
)

(instance entToCis of Feature
	(properties
		noun 28
		nsLeft 221
		nsTop 117
		nsRight 561
		nsBottom 256
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance exitToGate of Feature
	(properties
		nsLeft 267
		nsTop 151
		nsRight 337
		nsBottom 201
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
		nsLeft 12
		nsTop 5
		nsRight 571
		nsBottom 277
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
		flags 5
		number 7025
	)
)

