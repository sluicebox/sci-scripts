;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5025)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use newYorkRegion)
(use Polygon)
(use Feature)

(public
	NYAvian25 0
)

(instance NYAvian25 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(proc201_1 37)
		(switch gPrevRoomNum
			(5024 ; NYAvian24
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(5026 ; NYAvian26
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 45
		picture 5081
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit
			nextRoom: 5024
			init:
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 240 15 274 0 592 0 592 231 566 231 566 196 389 197 390 237 359 237 240 115
					yourself:
				)
		)
		(super init: &rest)
		(window_45 init:)
		(perches_45 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 5082
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5026 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(roomJunk_135 init:)
		(decoration_135 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		picture 5083
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(roomJunk_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 5084
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5023 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance roomJunk_135 of Feature
	(properties
		noun 27
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 75 26 205 27 193 242 67 234
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 389 72 436 41 447 58 470 81 490 80 471 91 471 117 450 186 449 230 424 197 408 192 395 145 381 141 386 122 376 111 378 101 386 90 401 74
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 247 167 331 162 330 227 239 229
					yourself:
				)
		)
	)
)

(instance decoration_135 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 78 249 68 314 68 335 79 327 124 296 158 268 160 235 126 225 99
					yourself:
				)
		)
	)
)

(instance window_45 of Feature
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 164 0 159 114 303 254 351 250 353 206 524 206 526 245 567 243 591 208 590 14 589 0
					yourself:
				)
		)
	)
)

(instance roomJunk_225 of Feature
	(properties
		noun 27
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 71 19 66 33 55 50 66 82 69 109 6 136 66 171 65 178 58 192 67 213 69 234 57 239 69 266 70 281 57 295 70 355 70 359 56 457 52 513 50 521 41 533 79 519 123 507 113 363 110 350 98 293 100 281 108 267 100 241 100 229 108 212 100 196 100 184 110 163 100 134 101 109 153 79 96 50 101 30 108 19 94 -10 94
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: -3 230 18 228 35 216 48 230 78 228 103 167 131 230 162 229 180 220 195 232 214 230 229 222 242 233 271 233 283 222 297 231 353 231 360 217 453 213 513 211 519 204 531 258 360 259 352 255 292 258 231 256 188 257 125 256 1 257
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 576 0 574 50 565 68 573 86 571 118 565 138 575 153 573 180 568 186 571 212 570 255 539 274 560 288 592 291 586 254 586 211 589 177 586 148 592 133 587 116 586 83 589 68 586 51 586 1
					yourself:
				)
		)
	)
)

(instance perches_45 of Feature
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
					init: 261 184 313 207 317 227 305 228 279 213 257 190
					yourself:
				)
		)
	)
)

