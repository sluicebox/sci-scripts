;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6814)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianHatchery14 0
)

(instance avianHatchery14 of Location
	(properties)

	(method (init)
		(super init:)
		(self addPicObj: faceS faceW faceN faceE faceS)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceE
						(westMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceE
						(westMural dispose:)
					)
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
		picture 6890
		heading 180
		edgeN 0
		edgeS 0
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6891
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(jungleGymBar init: setHotspot: 2 144)
		(super init:)
		(avianDoors_270 init:)
		(elevatedRoom_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6893
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(rope init:)
		(incubator_90 init:)
		(murals_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6892
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(incubator_0 init:)
		(column_0 init:)
	)
)

(instance jungleGymClimb of VMDMovie
	(properties
		movieName 6801
		frameRate 10
		endPic 6882
	)

	(method (play)
		(if (<= global188 3)
			(= cacheSize 1200)
			(= preLoadPCT 100)
		)
		(super play: &rest)
	)
)

(instance rope of View
	(properties
		x 410
		y 218
		view 6814
	)

	(method (init)
		(if (== (proc70_9 2) 6814)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance westMural of View
	(properties
		x 47
		y 239
		view 6814
		cel 1
	)
)

(instance jungleGymBar of Feature
	(properties
		noun 39
		nsLeft 113
		nsTop 134
		nsRight 331
		nsBottom 277
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(jungleGymClimb play:)
				(gCurRoom newRoom: 6813) ; avianHatchery13
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance incubator_90 of Feature
	(properties
		noun 38
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 32 239 28 250 54 253 49 271 63 275 60 281 89 283 86 290 109 290 124 270 140 270 147 256 146 247 40 239
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 183 247 182 256 217 262 209 288 229 291 233 272 245 275 250 258 236 252 179 248
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 193 169 228 169 228 211 244 212 242 219 229 225 229 236 197 236 196 224 182 223 182 210 190 207 191 170
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 1 156 27 182 39 206 30 224 2 227 3 232 14 239 3 254 9 265 2 280
					yourself:
				)
		)
	)
)

(instance murals_90 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 50 198 100 201 104 221 53 220
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 123 199 174 199 175 225 132 225
					yourself:
				)
		)
	)
)

(instance incubator_0 of Feature
	(properties
		noun 38
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 448 111 456 104 479 100 489 113 505 113 498 98 517 93 520 81 530 79 531 67 546 52 582 70 577 82 584 90 590 108 578 118 583 134 555 134 561 146 551 147 533 126 531 113 513 115 513 128 499 128 500 140 500 149 474 154 460 141 450 118 460 109
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 590 151 579 178 588 215 587 253 577 254 564 227 516 223 504 240 521 290 593 289
					yourself:
				)
		)
	)
)

(instance column_0 of Feature
	(properties
		noun 37
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 5 167 254 210 287 298 290 339 253 343 209 314 57 346 23 333 4
					yourself:
				)
		)
	)
)

(instance avianDoors_270 of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 237 117 248 116 245 103 274 104 274 115 282 115 296 175 280 189 242 197 223 186 240 119
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 427 101 431 98 436 86 450 87 453 96 459 97 460 148 449 160 444 167 423 166 416 156 408 152 426 93
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 427 101 431 98 436 86 450 87 453 96 459 97 460 148 449 160 444 167 423 166 416 156 408 152 426 93 353 36 372 37 373 7 363 6
					yourself:
				)
		)
	)
)

(instance elevatedRoom_270 of Feature
	(properties
		noun 62
		nsLeft 363
		nsTop 8
		nsRight 376
		nsBottom 39
		x 369
		y 23
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

