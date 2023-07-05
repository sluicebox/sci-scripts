;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7601)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	octoMusTeaDoor 0
)

(instance octoMusTeaDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7600 ; octoMuseum
				(self addPicObj: faceGate faceMuseum faceGate)
			)
			(7602 ; octoMusDoorCU
				(self addPicObj: faceGate faceMuseum faceGate)
			)
			(7800 ; octoTeacher
				(self addPicObj: faceMuseum faceGate faceMuseum)
			)
			(else
				(self addPicObj: faceMuseum faceGate faceMuseum)
			)
		)
	)
)

(instance faceGate of CameraAngle
	(properties
		heading 225
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 185)
			(gCurRoom drawPic: 7621)
			(= picture 7621)
			(spinner init: global117)
			(museumGate init: global117)
			(if (or (proc1111_24 191) (== (proc70_9 6) 7800))
				(teacher init: global117 setCycle: Osc)
			)
			(exitToTeacher init:)
			(gCurRoom exitN: exitToTeacher)
			(chartOf41 init: global117)
		else
			(= picture 7609)
			(greyLock init: global117)
			(exitToGate init:)
			(GATE_225 init:)
		)
		(super init: &rest)
	)

	(method (dispose)
		(proc1111_6)
		(super dispose: &rest)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		heading 45
		picture 7610
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
		(super init:)
		(if (IsFlag 185)
			(gCurRoom setScript: sGateClosing)
		)
	)
)

(instance spinner of View
	(properties
		x 260
		y 135
		loop 1
		view 7600
	)

	(method (init)
		(self
			setCel:
				(switch global262
					(0 0)
					(15 1)
					(30 2)
					(45 3)
				)
		)
		(super init: &rest)
		(self setPri: 92)
	)
)

(instance chartOf41 of View
	(properties
		x 266
		y 133
		loop 1
		cel 4
		view 7600
	)

	(method (init)
		(if
			(and
				(== (proc70_9 7) 7800)
				(IsFlag 191)
				(!= (proc70_9 6) 7800)
			)
			(super init: &rest)
			(self setPri: 90)
		)
	)
)

(instance teacher of Prop
	(properties
		noun 55
		x 236
		y 167
		case 9
		view 7600
	)

	(method (init)
		(super init: &rest)
		(self setPri: 90)
	)
)

(instance greyLock of View
	(properties
		x 286
		y 179
		cel 1
		view 7602
	)

	(method (init)
		(if (not (IsFlag 195))
			(super init: global117 &rest)
		)
	)
)

(instance GATE_225 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 195)
			(= case 2)
		else
			(= case 1)
		)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 157 102 459 98 558 256 61 256 157 100
					yourself:
				)
		)
	)
)

(instance museumGate of Actor
	(properties
		x 47
		y 275
		view 7601
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100 ignoreActors: 1 yStep: 4 setSpeed: 2)
		(gCurRoom setScript: sOpenGate)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 224
		nsLeft 213
		nsRight 400
		nsTop 151
		nextRoom 7600
	)
)

(instance exitToTeacher of ExitFeature
	(properties
		nsBottom 278
		nsLeft 136
		nsRight 463
		nsTop 125
		nextRoom 7800
		exitStyle 256
	)
)

(instance exitToGate of Feature
	(properties
		nsBottom 278
		nsLeft 136
		nsRight 463
		nsTop 125
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 96)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(96
				(gCurRoom newRoom: 7602) ; octoMusDoorCU
			)
			(2
				(gCurRoom newRoom: 7602) ; octoMusDoorCU
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
				(= seconds 1)
			)
			(1
				(museumGate setMotion: MoveTo 47 450 self)
				(theGateSnd play:)
			)
			(2
				(museumGate dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGateClosing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 185)
				(= cycles 1)
			)
			(1
				(gateClosingSnd play: self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gateClosingSnd of Sound
	(properties
		number 7600
		flags 5
	)
)

(instance theGateSnd of Sound
	(properties
		number 7025
		flags 5
	)
)

