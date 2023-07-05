;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3023)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	london_13 0
)

(instance london_13 of Location
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(3024 ; london_14
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(3029 ; london_WildCard
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(3032 ; london_Elevator_Cntrl
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3217
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToLondon14 init:)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3218
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(biotDispDoor_270 init:)
		(pit_270 init:)
		(cond
			((IsFlag 113)
				(= picture 3261)
				(elevator_270 init:)
			)
			((IsFlag 100)
				(= picture 3257)
			)
		)
		(super init:)
		(elev_Controls init: setHotspot: 2 140)
		(if (IsFlag 113)
			(westExitToLondon16 init:)
		)
		(elevControls_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3216
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(mantisDoor_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3215
		edgeN 0
		edgeS 0
	)

	(method (init)
		(northExitToMatrixPiece init:)
		(super init:)
		(pitPillars_0 init:)
		(matrixBox init: global117)
	)
)

(instance southExitToLondon14 of ExitFeature
	(properties
		nextRoom 3024
	)
)

(instance northExitToMatrixPiece of ExitFeature
	(properties
		nextRoom 3029
	)
)

(instance westExitToLondon16 of ExitFeature
	(properties
		nsLeft 238
		nsTop 101
		nsRight 345
		nsBottom 213
		nextRoom 3026
		exitStyle 256
	)
)

(instance elev_Controls of Feature
	(properties
		nsLeft 367
		nsTop 129
		nsRight 423
		nsBottom 237
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 3032) ; london_Elevator_Cntrl
			)
			(140
				(gCurRoom newRoom: 3032) ; london_Elevator_Cntrl
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance matrixBox of View
	(properties
		x 78
		y 178
		view 3200
		loop 2
	)

	(method (init)
		(if (== (proc70_9 48) 3004)
			(super init: global117)
		)
	)
)

(instance mantisDoor_90 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 150 228 156 202 168 190 167 70 173 29 192 -2 392 -2 406 29 414 78 414 186 424 204 427 232 346 233 333 221 242 221 228 235
					yourself:
				)
		)
	)
)

(instance pitPillars_0 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 29 51 33 56 44 129 53 134 47 175 50 180 64 365 86 395 129 397 163 7 177
					yourself:
				)
		)
	)
)

(instance pit_270 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 170 145 163 287 164 431 164 548 168 589 172 576 240 564 241 436 225 152 224 41 253 3 250
					yourself:
				)
		)
	)
)

(instance elevControls_270 of Feature
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
					init: 367 168 372 123 421 125 422 169 406 175 422 238 395 250 358 245 385 174 364 174
					yourself:
				)
		)
	)
)

(instance biotDispDoor_270 of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 148 241 140 250 138 265 143 268 154
					yourself:
				)
		)
	)
)

(instance elevator_270 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 118 237 120 183 96 176 100 139 135 114 185 138 198 165 180 204 181 225 207 209 212 186 204 162 208 151 240 94 259 94 262 126 276 127 288 76 307 77 319 127 330 128 332 93 356 93 373 125 418 119 459 121 496 167 480 228 423 225 118 234
					yourself:
				)
		)
	)
)

