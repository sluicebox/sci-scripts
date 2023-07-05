;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8010)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	HumanWheelRm 0
)

(procedure (localproc_0)
	(return (and (== global263 3) (== global264 1) (== global265 4)))
)

(instance HumanWheelRm of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8000 ; HumanRamp
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(8030 ; HumanMainHall2
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
		(if (proc1111_24 178)
			(proc1111_31 13)
			(SetFlag 178)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 270
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 155)
			(defaultExit nextRoom: 8030 init:)
			(gCurRoom exitN: defaultExit)
			(= picture 8067)
			(doorWay_270 init:)
			(BOMB_270 init:)
		else
			(innerWheel init: global117)
			(middleWheel init: global117)
			(outerWheel init: global117)
			(solvedWheel init: global117)
			(= picture 8002)
			(wheelPuzzle_0 init:)
		)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 90
		picture 8003
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 8000 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(stairsUp_180 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 8004
		edgeS 0
		edgeN 0
	)
)

(instance faceW of CameraAngle
	(properties
		heading 180
		picture 8005
		edgeS 0
		edgeN 0
	)
)

(instance defaultExit of ExitFeature
	(properties
		exitStyle 256
	)
)

(instance solvedWheel of Actor
	(properties
		x 144
		y 7
		view 8002
	)

	(method (init)
		(super init: &rest)
		(self setPri: 50 setSpeed: 4)
	)
)

(instance innerWheel of View
	(properties
		x 296
		y 153
		view 8000
	)

	(method (init)
		(= cel global263)
		(super init: &rest)
		(self setHotspot: 2 setPri: 60)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (+ (self lastCel:) 1))
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(= cel (mod (++ cel) temp0))
				(= global263 cel)
				(wheelTurnSnd play:)
				(UpdateScreenItem self)
				(if (localproc_0)
					(gCurRoom setScript: sWheelSolved)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance middleWheel of View
	(properties
		x 296
		y 153
		loop 1
		view 8000
	)

	(method (init)
		(= cel global264)
		(super init: &rest)
		(self setHotspot: 2 setPri: 60)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (+ (self lastCel:) 1))
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(= cel (mod (++ cel) temp0))
				(= global264 cel)
				(wheelTurnSnd play:)
				(UpdateScreenItem self)
				(if (localproc_0)
					(gCurRoom setScript: sWheelSolved)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance outerWheel of View
	(properties
		x 296
		y 154
		loop 2
		view 8000
	)

	(method (init)
		(= cel global265)
		(super init: &rest)
		(self setHotspot: 2 setPri: 60)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (+ (self lastCel:) 1))
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(= cel (mod (++ cel) temp0))
				(= global265 cel)
				(wheelTurnSnd play:)
				(UpdateScreenItem self)
				(if (localproc_0)
					(gCurRoom setScript: sWheelSolved)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sWheelSolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(innerWheel dispose:)
				(middleWheel dispose:)
				(outerWheel dispose:)
				(= seconds 1)
			)
			(1
				(SetFlag 155)
				(SetFlag 158)
				(wheelMoveSnd setVol: 127 play:)
				(solvedWheel setMotion: MoveTo -123 7 self)
			)
			(2
				(gCurRoom drawPic: 8067)
				(defaultExit nextRoom: 8030 init:)
				(wheelPuzzle_0 dispose:)
				(doorWay_270 init:)
				(BOMB_270 init:)
				(gCurRoom exitN: defaultExit)
				(= seconds 1)
			)
			(3
				(proc1111_31 38 11)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wheelPuzzle_0 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 150 151 184 60 299 8 390 51 438 155 397 249 300 289 186 250 151 151
					yourself:
				)
		)
	)
)

(instance stairsUp_180 of Feature
	(properties
		noun 2
		nsBottom 285
		nsLeft 237
		nsRight 346
		nsTop 78
		case 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance doorWay_270 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 219 39 362 41 429 154 334 259 334 292 255 290 256 260 168 155 230 50
					yourself:
				)
		)
	)
)

(instance BOMB_270 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 248 190 277 171 331 172 338 217 272 218 246 194
					yourself:
				)
		)
	)
)

(instance wheelTurnSnd of Sound
	(properties
		number 8006
		flags 5
	)
)

(instance wheelMoveSnd of Sound
	(properties
		number 8005
		flags 5
	)
)

