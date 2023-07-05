;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6111)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	avianCistern1 0
)

(local
	local0
	[local1 32] = [120 162 119 129 119 93 135 46 184 27 215 27 244 28 273 28 303 28 335 28 365 28 394 28 425 50 435 97 435 128 436 161]
	[local33 30] = [284 103 297 103 310 103 284 117 297 117 310 117 284 129 297 129 310 129 284 142 297 142 310 142 284 155 297 155 310 155]
)

(procedure (localproc_0 &tmp [temp0 2] temp2 temp3)
	(if (not (IsFlag 134))
		(return)
	)
	(= temp2 (* global230 2))
	(countHighlight setCel: global230 posn: [local1 temp2] [local1 (+ temp2 1)])
	(cond
		(global230
			(= temp2 (* (- global230 1) 2))
			(if (not (dotsSet elements:))
				(for ((= temp3 1)) (<= temp3 global230) ((++ temp3))
					(= temp2 (* (- temp3 1) 2))
					(dotsSet
						add:
							((countingDot new:)
								posn: [local33 temp2] [local33 (+ temp2 1)]
								init: global117
								yourself:
							)
					)
				)
			else
				(dotsSet
					add:
						((countingDot new:)
							posn: [local33 temp2] [local33 (+ temp2 1)]
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
	(if (global117 contains: countHighlight)
		(UpdateScreenItem countHighlight)
	else
		(countHighlight init: global117 setPri: 100)
	)
)

(instance avianCistern1 of Location
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(6101 ; avianSecurity1
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (== (gCurRoom heading:) 270)
					(proc1111_7 6300 188 175 0 0 -1 0 0)
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

(instance faceN of CameraAngle
	(properties
		picture 6303
		edgeN 0
		edgeS 0
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6301
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(doorExit init:)
		(gCurRoom exitN: doorExit)
		(super init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6304
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(switchExit init:)
		(gCurRoom exitN: switchExit)
		(if (IsFlag 134)
			(= picture 6308)
		)
		(super init:)
		(cisternSwitch_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6302
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(Load rsVIEW 6114)
		(super init: &rest)
		(localproc_0)
		(cisternAll_270 init:)
		(cisternPool_270 init:)
		(banners_270 init:)
		(cond
			(global161
				(((ScriptID 202 0) script:) seconds: 0 register: 0) ; AvianRegion
				(proc1111_7
					6300
					188
					175
					global161
					0
					-1
					0
					((ScriptID 202 0) script:) ; AvianRegion
				)
				(= global161 0)
				(drippingSpigot_270 init:)
			)
			((IsFlag 134)
				(if ((ScriptID 202 0) script:) ; AvianRegion
					(= temp0 (((ScriptID 202 0) script:) seconds:)) ; AvianRegion
					(((ScriptID 202 0) script:) seconds: 0 register: 0) ; AvianRegion
					(= local0 (Max 0 (- 40 (* temp0 10))))
				else
					(= local0 global161)
				)
				(proc1111_7
					6300
					188
					175
					local0
					0
					-1
					0
					((ScriptID 202 0) script:) ; AvianRegion
				)
				(drippingSpigot_270 init:)
			)
		)
	)

	(method (dispose &tmp temp0)
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
		(if (dotsSet elements:)
			(dotsSet release: dispose:)
		)
		(super dispose: &rest)
	)
)

(instance switchExit of ExitFeature
	(properties
		nsLeft 263
		nsTop 70
		nsRight 362
		nsBottom 210
		nextRoom 6112
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 188
		nsTop 7
		nsRight 431
		nsBottom 289
		nextRoom 6101
		exitStyle 256
	)
)

(instance countHighlight of View
	(properties
		view 6114
		loop 1
	)
)

(instance countingDot of View
	(properties
		view 6114
		cel 16
	)
)

(instance dotsSet of Set
	(properties)
)

(instance cisternAll_270 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 184 8 413 11 474 75 476 163 442 169 434 235 421 247 440 289 166 290 189 253 158 231 158 170 118 167 123 74
					yourself:
				)
		)
	)
)

(instance cisternSwitch_180 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 265 69 359 68 360 205 263 212
					yourself:
				)
		)
	)
)

(instance cisternPool_270 of Feature
	(properties
		noun 7
		nsLeft 179
		nsTop 184
		nsRight 435
		nsBottom 290
		x 307
		y 237
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance drippingSpigot_270 of Feature
	(properties
		noun 61
		nsLeft 277
		nsTop 173
		nsRight 311
		nsBottom 207
		x 294
		y 190
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance banners_270 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 179 64 205 71 225 67 245 61 252 145 177 151 177 62 189 62
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 344 62 358 62 377 72 394 68 406 62 412 64 418 141 345 148 344 61 352 62
					yourself:
				)
		)
	)
)

