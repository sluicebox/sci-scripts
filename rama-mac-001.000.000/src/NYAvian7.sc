;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5007)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NYAvian7 0
)

(instance NYAvian7 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5001 ; NYAvian1
				(self addPicObj: faceSE faceS faceSW faceNW faceN faceSE)
			)
			(5002 ; NYAvian2
				(self addPicObj: faceSE faceS faceSW faceNW faceN faceSE)
			)
			(5008 ; NYAvian8
				(self addPicObj: faceN faceSE faceS faceSW faceNW faceN)
			)
			(5009 ; NYAvian9
				(self addPicObj: faceN faceSE faceS faceSW faceNW faceN)
			)
			(5017 ; NYAvian17
				(self addPicObj: faceN faceSE faceS faceSW faceNW faceN)
			)
			(else
				(self addPicObj: faceN faceSE faceS faceSW faceNW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5027
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(redPlatform_0 init:)
		(tetrahedron_0 init:)
		(pylons_0 init:)
		(sign_0 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5031
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc17Exit init:)
		(gCurRoom exitN: loc17Exit)
		(super init: &rest)
		(pylons_135 init:)
		(columnAlley_135 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5030
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc8Exit init:)
		(gCurRoom exitN: loc8Exit)
		(super init: &rest)
		(redPlatform_180 init:)
		(melonMural_180 init:)
		(pylons_180 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5029
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc9Exit init:)
		(gCurRoom exitN: loc9Exit)
		(super init: &rest)
		(redPlatform_225 init:)
		(pylons_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5028
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc2Exit init:)
		(gCurRoom exitN: loc2Exit)
		(super init: &rest)
		(redPlatform_315 init:)
		(tetrahedron_315 init:)
		(pylons_315 init:)
		(lowWall_315 init:)
		(signs_315 init:)
	)
)

(instance loc2Exit of ExitFeature
	(properties
		nsLeft 309
		nsTop 116
		nsRight 485
		nsBottom 200
		nextRoom 5002
	)
)

(instance loc9Exit of ExitFeature
	(properties
		nsLeft 273
		nsTop 126
		nsRight 381
		nsBottom 195
		nextRoom 5009
	)
)

(instance loc8Exit of ExitFeature
	(properties
		nsLeft 325
		nsTop 127
		nsRight 424
		nsBottom 200
		nextRoom 5008
	)
)

(instance loc17Exit of ExitFeature
	(properties
		nsLeft 207
		nsTop 110
		nsRight 305
		nsBottom 191
		nextRoom 5017
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
				((Polygon new:)
					type: PTotalAccess
					init: 13 91 140 92 107 179 29 188
					yourself:
				)
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
					init: 90 136 118 136 112 188 91 189
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 369 138 394 136 396 189 361 189
					yourself:
				)
		)
	)
)

(instance redPlatform_0 of Feature
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
					init: 0 189 103 186 285 186 375 187 565 191 591 193 591 287 -1 289
					yourself:
				)
		)
	)
)

(instance tetrahedron_315 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 486 102 502 185 566 185 569 140 588 135 591 103 590 79 485 101
					yourself:
				)
		)
	)
)

(instance pylons_315 of Feature
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
					init: 88 126 94 116 99 116 102 127 107 187 81 188 89 127
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 248 158 253 154 258 159 261 181 247 182 247 161
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 337 164 348 164 349 182 334 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 373 170 383 170 382 183 372 183
					yourself:
				)
		)
	)
)

(instance lowWall_315 of Feature
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
					init: 119 156 239 166 243 183 147 190 108 185 120 158
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 429 172 499 168 498 179 429 183
					yourself:
				)
		)
	)
)

(instance redPlatform_315 of Feature
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
					init: -3 190 153 185 356 186 569 190 584 190 590 291 -2 290 -1 188
					yourself:
				)
		)
	)
)

(instance signs_315 of Feature
	(properties
		noun 3
		nsLeft 158
		nsTop 73
		nsRight 179
		nsBottom 107
		x 168
		y 90
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pylons_225 of Feature
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
					init: 119 121 126 121 128 109 135 113 147 109 147 121 151 121 162 142 165 162 159 188 107 188 111 167 108 163 114 155 112 143 122 120 128 111
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 536 113 530 123 525 190 553 187 545 126 541 114
					yourself:
				)
		)
	)
)

(instance redPlatform_225 of Feature
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
					init: -3 191 117 188 163 189 527 186 560 187 585 189 592 291 2 291
					yourself:
				)
		)
	)
)

(instance melonMural_180 of Feature
	(properties
		noun 16
		case 1
		nsLeft 393
		nsTop 154
		nsRight 415
		nsBottom 176
		x 404
		y 165
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pylons_180 of Feature
	(properties
		noun 9
		nsLeft 551
		nsTop 107
		nsRight 590
		nsBottom 191
		x 570
		y 149
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance redPlatform_180 of Feature
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
					init: -1 193 285 187 589 192 589 289 -1 291
					yourself:
				)
		)
	)
)

(instance pylons_135 of Feature
	(properties
		noun 9
		nsLeft 33
		nsTop 80
		nsRight 102
		nsBottom 196
		x 67
		y 138
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance columnAlley_135 of Feature
	(properties
		noun 13
		nsLeft 240
		nsTop 105
		nsRight 290
		nsBottom 181
		x 265
		y 143
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sign_0 of Feature
	(properties
		noun 3
		nsLeft 374
		nsTop -1
		nsRight 406
		nsBottom 12
		x 390
		y 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

