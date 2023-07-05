;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5008)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NYAvian8 0
)

(instance NYAvian8 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self addPicObj: faceSW faceN faceSW)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5033
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc7Exit init:)
		(gCurRoom exitN: loc7Exit)
		(super init: &rest)
		(tetrahedron_0 init:)
		(pylons_0 init:)
		(lowWall_0 init:)
		(sign_0 init:)
		(wallIcons_0 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5034
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc20Exit init:)
		(gCurRoom exitN: loc20Exit)
		(super init: &rest)
		(melonMural_225 init:)
	)
)

(instance loc20Exit of ExitFeature
	(properties
		nsLeft 228
		nsTop 77
		nsRight 330
		nsBottom 183
		nextRoom 5020
	)
)

(instance loc7Exit of ExitFeature
	(properties
		nsLeft 277
		nsTop 101
		nsRight 462
		nsBottom 185
		nextRoom 5007
	)
)

(instance melonMural_225 of Feature
	(properties
		noun 16
		case 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 197 127 230 107 229 81 326 80 326 105 365 127 326 149 326 184 230 178 224 148
					yourself:
				)
		)
	)
)

(instance tetrahedron_0 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 282 144 333 144 306 180 yourself:)
		)
	)
)

(instance pylons_0 of Feature
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
					init: 337 150 342 146 346 149 354 184 332 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 540 159 544 151 547 158 549 181 538 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 475 167 484 165 486 183 476 183
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 427 171 436 169 437 181 428 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 354 168 362 169 364 179 355 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 259 160 264 156 270 160 273 179 256 181
					yourself:
				)
		)
	)
)

(instance lowWall_0 of Feature
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
					init: 165 170 244 168 244 182 166 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 249 175 296 174 296 181 270 180 248 180
					yourself:
				)
		)
	)
)

(instance sign_0 of Feature
	(properties
		noun 3
		nsLeft 439
		nsTop 74
		nsRight 459
		nsBottom 104
		x 449
		y 89
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance wallIcons_0 of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 189 -2 190 12 228 19 232 -2
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 273 -2 272 24 315 29 314 -1
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 416 -3 417 9 449 6 454 -2
					yourself:
				)
		)
	)
)

