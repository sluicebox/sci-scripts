;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6101)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	avianSecurity1 0
)

(local
	[local0 30] = [283 109 295 109 307 109 283 121 295 121 307 121 283 133 295 133 307 133 283 145 295 145 307 145 283 157 295 157 307 157]
)

(procedure (localproc_0 &tmp [temp0 2] temp2 temp3)
	(if (not (IsFlag 134))
		(return)
	)
	(cond
		(global230
			(= temp2 (* (- global230 1) 2))
			(if (not (dotsSet elements:))
				(for ((= temp3 1)) (<= temp3 global230) ((++ temp3))
					(= temp2 (* (- temp3 1) 2))
					(dotsSet
						add:
							((countingDot new:)
								posn: [local0 temp2] [local0 (+ temp2 1)]
								init: global117
								yourself:
							)
					)
				)
			else
				(dotsSet
					add:
						((countingDot new:)
							posn: [local0 temp2] [local0 (+ temp2 1)]
							init: global117
							yourself:
						)
				)
			)
		)
		((dotsSet size:)
			(dotsSet dispose:)
		)
	)
)

(instance avianSecurity1 of Location
	(properties)

	(method (init)
		(super init:)
		(Load rsAUDIO 6104)
		(switch gPrevRoomNum
			(6103 ; avianSecurity3
				(self addPicObj: faceS faceW faceN faceE faceS)
				(if (IsFlag 123)
					(ClearFlag 123)
					(doorMoving play:)
				)
			)
			(6102 ; avianSecurity2
				(if (IsFlag 123)
					(ClearFlag 123)
					(doorMoving play:)
				)
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(6111 ; avianCistern1
				(self setPicObj: faceE)
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 6111) ; avianCistern1
			(= global161 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (== (gCurRoom heading:) 270)
					(proc1111_7 6301 196 173 0 0 -1 0 0)
				)
			)
			(33
				(if (== (gCurRoom heading:) 270)
					(localproc_0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6103
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6001 exitStyle: 13 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6101
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6102 exitStyle: 0 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(secDefDoor_0 init:)
		(doorNumbers_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6102
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6104
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0 temp1)
		(gCurRoom exitN: (defaultExit nextRoom: 6111 init: yourself:))
		(super init: &rest)
		(cistern_270 init:)
		(if (IsFlag 134)
			(= temp0 (((ScriptID 202 0) script:) seconds:)) ; AvianRegion
			(((ScriptID 202 0) script:) seconds: 0 register: 0) ; AvianRegion
			(= temp1 (Max 0 (- 40 (* temp0 10))))
			(proc1111_7 6301 196 173 temp1 0 -1 0 ((ScriptID 202 0) script:)) ; AvianRegion
			(localproc_0)
			(drippingSpigot_270 init:)
		)
	)

	(method (dispose &tmp temp0)
		(if (dotsSet elements:)
			(dotsSet release: dispose:)
		)
		(if (IsFlag 134)
			(if gAutoRobot
				(= temp0 (- 4 (/ (Robot 11) 10))) ; FrameNum
			else
				(= temp0 4)
			)
			(if (== temp0 0)
				(+= temp0 1)
			)
			(((ScriptID 202 0) script:) seconds: temp0) ; AvianRegion
			(proc1111_6)
		)
		(super dispose:)
	)
)

(instance defaultExit of ExitFeature
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(if (and (== theVerb 9) (IsFlag 134))
			(if gAutoRobot
				(= global161 (Robot 11)) ; FrameNum
				(= temp0 (- 4 (/ global168 10)))
			else
				(= temp0 4)
			)
			(if (== temp0 0)
				(+= temp0 1)
			)
			(((ScriptID 202 0) script:) seconds: temp0) ; AvianRegion
			(proc1111_6)
		)
		(super doVerb: theVerb)
	)
)

(instance doorMoving of Sound
	(properties
		number 6104
	)
)

(instance countingDot of View
	(properties
		view 6114
		cel 17
	)
)

(instance dotsSet of Set
	(properties)
)

(instance secDefDoor_0 of Feature
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
					init: 241 64 345 65 390 222 350 265 238 261 201 221
					yourself:
				)
		)
	)
)

(instance cistern_270 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 134 283 196 61 396 63 454 286
					yourself:
				)
		)
	)
)

(instance drippingSpigot_270 of Feature
	(properties
		noun 61
		nsLeft 280
		nsTop 175
		nsRight 312
		nsBottom 205
		x 296
		y 190
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance doorNumbers_0 of Feature
	(properties
		noun 55
		nsLeft 240
		nsTop 36
		nsRight 350
		nsBottom 63
		x 295
		y 49
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

