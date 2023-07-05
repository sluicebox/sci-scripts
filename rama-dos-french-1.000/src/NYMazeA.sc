;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5500)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NYMazeA 0
)

(instance NYMazeA of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5501 ; NYMazeB
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5701 ; NYPort2
				(self addPicObj: faceE faceS faceW faceN faceE)
				(gCurRoom setScript: doorCloses)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5504
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5502
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5501
		edgeS 0
		edgeN 0
	)

	(method (init)
		(eastExit init:)
		(dataCube init:)
		(walls_90 init:)
		(plaza_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5503
		edgeS 0
		edgeN 0
	)

	(method (init)
		(frame_270 init:)
		(door_270 init:)
		(super init: &rest)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsBottom 180
		nsLeft 254
		nsRight 340
		nsTop 94
		nextRoom 5501
	)
)

(instance dataCube of View
	(properties
		x 538
		y 281
		view 5501
	)

	(method (init)
		(if (== (proc70_9 30) 5500)
			(super init: global117 &rest)
			(self
				setHotspot: 2
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 517 249 517 288 575 288 575 249
						yourself:
					)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 30)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorCloses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(doorSnd number: 5702 setVol: 127 play: self)
			)
			(2
				(ClearFlag 71)
				(if (not (IsFlag 78))
					(SetFlag 78)
					(proc1111_31 34)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doorSnd of Sound
	(properties
		flags 5
	)
)

(instance walls_0 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 590 1 589 224 497 224 497 229 359 229 353 225 229 224 222 229 176 231 109 232 47 223 -1 232
					yourself:
				)
		)
	)
)

(instance plaza_90 of Feature
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
					init: 271 1 327 2 325 183 268 182
					yourself:
				)
		)
	)
)

(instance walls_90 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 1 590 1 590 229 544 222 543 216 522 210 453 205 446 201 409 197 406 189 356 181 324 181 269 179 247 182 183 191 183 197 169 198 144 200 135 206 118 209 67 210 38 223 -2 232
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 3 590 0 591 227 540 223 472 232 408 232 364 228 361 224 314 224 312 227 282 227 249 223 230 229 178 231 112 230 93 228 90 224 55 225 0 223
					yourself:
				)
		)
	)
)

(instance frame_270 of Feature
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
					init: 112 -2 486 0 512 227 85 225
					yourself:
				)
		)
	)
)

(instance door_270 of Feature
	(properties
		noun 2
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 241 37 350 35 398 82 406 163 423 224 423 229 411 230 369 218 220 218 182 229 170 229 170 223 182 191 188 166 195 86
					yourself:
				)
		)
	)
)

