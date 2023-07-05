;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5001)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	NYAvian1 0
)

(instance NYAvian1 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5700 ; NYPort
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(5001 ; NYAvian1
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5002 ; NYAvian2
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5004 ; NYAvian4
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5007 ; NYAvian7
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5001
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(avianDoor_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5004
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc2Exit init:)
		(gCurRoom exitN: loc2Exit)
		(super init: &rest)
		(signs_90 init:)
		(tetrahedron_90 init:)
		(pylons_90 init:)
		(lowWall_90 init:)
		(wallIcon_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5003
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5002
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 142)
			(= picture 5902)
		else
			(= picture 5002)
		)
		(defaultExit nextRoom: 5501 init: exitStyle: 256)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(gate_270 init:)
	)
)

(instance loc2Exit of ExitFeature
	(properties
		nsLeft 261
		nsTop 146
		nsRight 324
		nsBottom 192
		nextRoom 5002
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance signs_90 of Feature
	(properties
		noun 3
		nsLeft 528
		nsTop 21
		nsRight 564
		nsBottom 64
		x 546
		y 42
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance tetrahedron_90 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 292 150 272 180 311 181 yourself:)
		)
	)
)

(instance pylons_90 of Feature
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
					init: 201 161 206 158 210 162 213 181 198 180
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 226 169 228 168 230 171 232 180 223 180
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 363 166 368 163 372 167 375 179 361 180
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 380 164 384 160 389 164 390 179 379 180
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 111 168 113 167 117 179 112 179
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 122 170 126 169 128 172 128 180 122 180
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 451 170 455 168 456 174 458 180 452 180
					yourself:
				)
		)
	)
)

(instance lowWall_90 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 148 173 189 172 189 182 146 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 391 172 415 174 415 180 394 183
					yourself:
				)
		)
	)
)

(instance wallIcon_90 of Feature
	(properties
		noun 22
		nsLeft 114
		nsTop -2
		nsRight 142
		nsBottom 23
		x 128
		y 10
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance gate_270 of Feature
	(properties
		noun 39
		nsLeft 290
		nsTop 170
		nsRight 310
		nsBottom 184
		x 300
		y 177
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance avianDoor_0 of Feature
	(properties
		noun 4
		nsLeft 479
		nsTop 23
		nsRight 524
		nsBottom 90
		x 501
		y 56
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

