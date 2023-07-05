;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3004)
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
	london_4 0
)

(instance london_4 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3003 ; london_3
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(3007 ; london_7
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(3013 ; london_Display_Control
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
		picture 3105
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToLondon3 init:)
		(super init:)
		(mp_Piece_B22y init:)
		(door2Out_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3106
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(displayControls init: setHotspot: 2)
		(super init:)
		(mp_Piece_L22x init:)
		(NY_Map_Piece_D init:)
		(if (IsFlag 110)
			(displays_270 case: 0 init:)
		else
			(displays_270 case: 2 init:)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3120
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 110)
			(= picture 3104)
			(if (and (== global285 1) global273 (IsFlag 111))
				(solvedLeftNYPuzzle init:)
			else
				(LeftMapSlot_1 init:)
				(LeftMapSlot_2 init:)
				(LeftMapSlot_3 init:)
				(LeftMapSlot_4 init:)
				(LeftMapSlot_5 init:)
				(LeftMapSlot_6 init:)
			)
			(if (and (== global291 1) global279 (IsFlag 111))
				(solvedRightNYPuzzle init:)
			else
				(RightMapSlot_1 init:)
				(RightMapSlot_2 init:)
				(RightMapSlot_3 init:)
				(RightMapSlot_4 init:)
				(RightMapSlot_5 init:)
				(RightMapSlot_6 init:)
			)
		)
		(super init: &rest)
		(exitToCPMap init:)
		(exitToNYMap init:)
		(if (IsFlag 110)
			(mapPuzzles_90 case: 0 init:)
		else
			(mapPuzzles_90 case: 1 init:)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3103
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 99)
			(= picture 3118)
		)
		(super init:)
		(northExitToLondon7 init:)
		(door3_0 init:)
	)
)

(instance mp_Piece_L22x of View
	(properties
		x 30
		y 213
		view 3100
		loop 3
		cel 1
	)

	(method (init)
		(if (== (proc70_9 70) 3004)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 70)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_Piece_B22y of View
	(properties
		x 70
		y 206
		view 3100
		loop 2
	)

	(method (init)
		(if (== (proc70_9 56) 3004)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (onMe param1)
		(return (and (<= 61 (param1 x:) 91) (<= 194 (param1 y:) 210)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 56)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance NY_Map_Piece_D of View
	(properties
		x 144
		y 202
		view 3100
		loop 3
	)

	(method (init)
		(if (== (proc70_9 86) 3004)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 86)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance LeftMapSlot_1 of View
	(properties
		x 100
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global285 0])
		(= cel [global273 0])
		(super init: global117)
	)
)

(instance LeftMapSlot_2 of View
	(properties
		x 113
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global285 1])
		(= cel [global273 1])
		(super init: global117)
	)
)

(instance LeftMapSlot_3 of View
	(properties
		x 126
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global285 2])
		(= cel [global273 2])
		(super init: global117)
	)
)

(instance LeftMapSlot_4 of View
	(properties
		x 139
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global285 3])
		(= cel [global273 3])
		(super init: global117)
	)
)

(instance LeftMapSlot_5 of View
	(properties
		x 152
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global285 4])
		(= cel [global273 4])
		(super init: global117)
	)
)

(instance LeftMapSlot_6 of View
	(properties
		x 164
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global285 5])
		(= cel [global273 5])
		(super init: global117)
	)
)

(instance RightMapSlot_1 of View
	(properties
		x 380
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global291 0])
		(= cel [global279 0])
		(super init: global117)
	)
)

(instance RightMapSlot_2 of View
	(properties
		x 392
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global291 1])
		(= cel [global279 1])
		(super init: global117)
	)
)

(instance RightMapSlot_3 of View
	(properties
		x 404
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global291 2])
		(= cel [global279 2])
		(super init: global117)
	)
)

(instance RightMapSlot_4 of View
	(properties
		x 417
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global291 3])
		(= cel [global279 3])
		(super init: global117)
	)
)

(instance RightMapSlot_5 of View
	(properties
		x 430
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global291 4])
		(= cel [global279 4])
		(super init: global117)
	)
)

(instance RightMapSlot_6 of View
	(properties
		x 442
		y 125
		view 3101
	)

	(method (init)
		(&= signal $efff)
		(= loop [global291 5])
		(= cel [global279 5])
		(super init: global117)
	)
)

(instance solvedLeftNYPuzzle of View
	(properties
		x 98
		y 157
		view 3101
		loop 2
	)

	(method (init)
		(super init: global117)
	)
)

(instance solvedRightNYPuzzle of View
	(properties
		x 380
		y 125
		view 3101
		loop 3
	)

	(method (init)
		(super init: global117)
	)
)

(instance southExitToLondon3 of ExitFeature
	(properties
		nsLeft 145
		nsTop 83
		nsRight 435
		nsBottom 203
		nextRoom 3003
	)
)

(instance northExitToLondon7 of ExitFeature
	(properties
		nsLeft 113
		nsTop 95
		nsRight 477
		nsBottom 216
		nextRoom 3007
	)
)

(instance exitToCPMap of ExitFeature
	(properties
		nsLeft 95
		nsTop 102
		nsRight 212
		nsBottom 181
		nextRoom 3014
	)

	(method (doVerb theVerb)
		(= global164 45)
		(super doVerb: theVerb)
	)
)

(instance exitToNYMap of ExitFeature
	(properties
		nsLeft 381
		nsTop 107
		nsRight 480
		nsBottom 186
		nextRoom 3014
	)

	(method (doVerb theVerb)
		(= global164 135)
		(super doVerb: theVerb)
	)
)

(instance displayControls of Feature
	(properties
		nsLeft 285
		nsTop 149
		nsRight 320
		nsBottom 200
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 3013) ; london_Display_Control
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door3_0 of Feature
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
					init: 213 169 258 109 293 102 326 113 377 171
					yourself:
				)
		)
	)
)

(instance displays_270 of Feature
	(properties
		noun 10
		case 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 198 151 201 114 279 110 313 135 335 95 394 74 447 101 446 128 414 149 412 165 318 192 282 190 209 165
					yourself:
				)
		)
	)
)

(instance door2Out_180 of Feature
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
					init: 258 169 256 109 264 92 321 91 329 117 329 168
					yourself:
				)
		)
	)
)

(instance mapPuzzles_90 of Feature
	(properties
		noun 37
		case 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 88 234 98 230 184 38 184
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 330 95 516 88 516 178 329 181
					yourself:
				)
		)
	)
)

