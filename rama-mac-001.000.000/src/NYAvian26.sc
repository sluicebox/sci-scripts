;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5026)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	NYAvian26 0
)

(instance NYAvian26 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5024 ; NYAvian24
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5088
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc24Exit init:)
		(super init: &rest)
		(roomJunk_45 init:)
		(window_45 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5087
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(roomJunk_135 init:)
		(decorations_135 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5086
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(roomJunk_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5085
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5025 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(if (not (OneOf ((proc70_6 38) owner:) -2 -3 5018))
			(jack init: global117)
		)
		(room_Junk_315 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance jack of View
	(properties
		noun 29
		x 451
		y 229
		view 5062
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 38)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance loc24Exit of ExitFeature
	(properties
		nextRoom 5024
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 69 0 92 15 92 95 0 178
					yourself:
				)
		)
	)
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
					init: 128 148 133 137 156 116 233 107 300 112 327 150 303 161 311 246 146 259 147 182 148 156
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 69 7 66 62 61 79 66 94 66 123 60 136 68 154 66 175 61 188 66 202 69 240 39 284 119 267 142 248 85 234 89 203 101 183 84 163 87 148 101 139 86 123 88 99 93 84 86 69 87 9
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 336 228 361 214 365 182 357 178 363 169 363 148 358 139 364 129 367 106 353 95 365 82 366 41 357 29 359 5 400 2 398 30 389 39 388 84 396 96 389 108 387 127 396 138 386 154 387 168 397 181 385 194 386 217 421 241 376 249 340 241 327 231
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 463 2 466 32 451 45 462 61 480 60 510 171 535 175 550 242 567 180 581 181 589 171
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 443 -3 464 10 469 29 458 52 511 175 536 178 551 237 563 183 588 178 594 158 590 0
					yourself:
				)
		)
	)
)

(instance decorations_135 of Feature
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
					init: 120 -1 207 111 222 96 248 114 303 50 328 -1
					yourself:
				)
		)
	)
)

(instance roomJunk_45 of Feature
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
					init: 132 -1 132 13 121 27 128 44 131 99 118 102 111 196 111 247 147 255 170 245 171 197 169 107 159 97 156 46 164 33 157 21 157 4
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 274 -3 277 8 277 25 266 37 275 51 278 105 270 109 263 191 263 242 298 244 317 241 316 191 311 107 301 101 300 60 312 41 301 26 301 8 306 2
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 395 0 399 33 391 89 398 117 375 174 355 207 365 231 364 259 385 268 396 285 438 286 430 249 433 225 443 270 469 286 500 291 504 285 478 212 461 198 445 194 418 114 426 97 424 77 417 34 421 4
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
					init: 0 1 79 -2 101 13 103 97 -1 196
					yourself:
				)
		)
	)
)

(instance room_Junk_315 of Feature
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
					init: 36 -1 41 197 21 221 66 217 52 198 60 1
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 107 -2 115 59 121 62 121 200 89 214 124 225 181 213 136 197 144 162 144 137 144 109 143 61 148 55 151 -5
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 372 -1 376 59 379 79 375 191 356 210 394 219 431 213 396 194 399 65 406 2
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 543 0 539 110 527 226 575 236 579 107 569 99 569 59 571 6
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 111 1 112 57 146 59 155 1
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
					init: 113 54 261 65 264 73 319 72 333 65 347 72 367 72 383 63 399 74 413 73 420 59 442 72 492 75 497 18 527 78 563 64 584 72 588 109 546 109 517 108 500 149 464 112 418 110 382 106 326 107 266 104 121 113 103 81
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 102 241 124 202 258 211 264 218 323 220 330 215 342 219 365 220 378 214 398 219 415 222 424 216 439 221 470 221 486 162 518 224 553 224 558 205 568 221 582 223 588 247 578 249 519 248 513 259 476 252 432 250 377 246 330 252 262 249 109 255
					yourself:
				)
		)
	)
)

