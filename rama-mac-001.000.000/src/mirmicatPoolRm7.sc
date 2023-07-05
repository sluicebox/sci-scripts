;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6907)
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
	mirmicatPoolRm7 0
)

(instance mirmicatPoolRm7 of Location
	(properties
		noun 54
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(6910 ; poolControlsCloseUp
				(switch global164
					(0
						(self addPicObj: faceN faceE faceS faceW faceN)
					)
					(270
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
				)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		edgeN 0
		edgeS 0
	)

	(method (init)
		(door_0 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(switch global232
					(2
						(= picture 6961)
					)
					(3
						(= picture 6984)
					)
					(0
						(= picture 6997)
					)
					(4
						(= picture 6996)
					)
					(1
						(= picture 6995)
					)
					(5
						(= picture 6994)
					)
				)
				(pool_0 noun: 50 init:)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(switch global232
					(2
						(= picture 6983)
					)
					(3
						(= picture 6985)
					)
					(0
						(= picture 6989)
					)
					(4
						(= picture 6988)
					)
					(1
						(= picture 6987)
					)
					(5
						(= picture 6986)
					)
				)
				(pool_0 noun: 49 init:)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(switch global232
					(2
						(= picture 6961)
					)
					(3
						(= picture 6984)
					)
					(0
						(= picture 6997)
					)
					(4
						(= picture 6996)
					)
					(1
						(= picture 6995)
					)
					(5
						(= picture 6994)
					)
				)
				(pool_0 noun: 50 init:)
			)
			(else
				(switch global232
					(2
						(= picture 6983)
					)
					(3
						(= picture 6985)
					)
					(0
						(= picture 6989)
					)
					(4
						(= picture 6988)
					)
					(1
						(= picture 6987)
					)
					(5
						(= picture 6986)
					)
				)
				(pool_0 noun: 49 init:)
			)
		)
		(super init: &rest)
		(myrmSeats_0 init:)
		(if (not (IsFlag 146))
			(controls_0 init:)
			(rust init: global117)
		else
			(poolControls noun: 0)
		)
		(poolControls init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6962
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(pool_135 init:)
		(myrmSeats_135 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6963
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6963)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6963)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6990)
			)
			(else
				(= picture 6990)
			)
		)
		(rampExit init:)
		(gCurRoom exitN: rampExit)
		(super init:)
		(myrmSeats_180 init:)
		(ramp_180 init:)
		(myrmSeats_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6964
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(doors_225 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6964)
				(pool_225 noun: 50 init:)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6964)
				(pool_225 noun: 50 init:)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6991)
				(pool_225 noun: 49 init:)
			)
			(else
				(= picture 6991)
				(pool_225 noun: 49 init:)
			)
		)
		(super init: &rest)
		(myrmSeats_225 init:)
		(if (== (proc70_9 36) 6911)
			(humanKey init: global117)
		)
	)
)

(instance poolControls of Feature
	(properties
		noun 51
		nsLeft 213
		nsTop 180
		nsRight 414
		nsBottom 242
	)

	(method (init)
		(super init:)
		(= plane global116)
		(if (not (IsFlag 146))
			(self setHotspot: 2 21 144)
		else
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 6910) ; poolControlsCloseUp
				(self deleteHotspot:)
			)
			(21
				(gCurRoom newRoom: 6910) ; poolControlsCloseUp
				(self deleteHotspot:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rampExit of ExitFeature
	(properties
		nsLeft 215
		nsTop 14
		nsRight 358
		nsBottom 132
		nextRoom 6901
	)
)

(instance humanKey of View
	(properties
		x 278
		y 138
		view 6903
		cel 5
	)
)

(instance rust of View
	(properties
		x 298
		y 228
		view 6903
		loop 1
	)
)

(instance door_0 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 143 260 71 320 73 355 143
					yourself:
				)
		)
	)
)

(instance pool_0 of Feature
	(properties
		noun 50
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 205 200 148 196 143 172 237 150 293 149 354 152 422 164 454 174 443 205 403 203 194 205
					yourself:
				)
		)
	)
)

(instance controls_0 of Feature
	(properties
		noun 51
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 206 203 215 194 216 182 225 183 226 192 291 179 307 179 304 154 308 152 316 157 316 178 354 185 355 177 362 177 363 186 404 203 410 222 380 284 226 288 215 258 197 241 198 203 214 195
					yourself:
				)
		)
	)
)

(instance myrmSeats_0 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 12 180 84 175 115 175 130 189 173 195 184 191 192 193 192 216 190 250 164 259 130 254 107 264 57 248 15 227 5 232
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 401 196 448 183 476 173 523 173 587 189 588 223 548 232 546 256 553 270 547 287 516 288 439 254 440 226 408 220 404 199
					yourself:
				)
		)
	)
)

(instance doors_225 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 108 242 27 309 29 344 103
					yourself:
				)
		)
	)
)

(instance pool_225 of Feature
	(properties
		noun 50
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 202 202 146 183 131 158 171 134 237 122 295 120 353 124 413 134 450 152 458 171 423 189 356 204 292 208 208 203
					yourself:
				)
		)
	)
)

(instance myrmSeats_225 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 5 162 31 159 38 153 52 147 85 148 94 166 136 171 154 187 199 203 205 222 149 269 150 283 105 296 32 291 31 262 26 225 -3 209 -3 168
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 225 234 251 199 303 212 323 203 336 207 341 237 306 294 218 239
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 370 200 396 196 409 221 438 267 438 279 465 292 400 294 393 279 375 243 366 230 369 198
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 441 204 446 178 466 173 473 178 496 170 497 154 508 139 540 139 589 151 591 194 550 227 557 263 509 289 456 271 458 244 517 227 446 206
					yourself:
				)
		)
	)
)

(instance ramp_180 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 73 244 148 186 187 157 239 104 325 99 521 240 586 271 0 277 77 247
					yourself:
				)
		)
	)
)

(instance myrmSeats_180 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 200 52 180 51 151 68 142 65 119 94 112 137 121 181 121 218 117 177 158 134 183 98 218 75 247 50 251 32 259 -8 266 -7 210 -7 200 14 196 52 179 47 156
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 384 113 416 117 434 114 447 121 462 119 467 114 476 113 503 119 504 137 500 143 492 143 500 153 524 148 539 156 538 173 566 196 570 204 562 232 568 237 590 239 591 261 592 294 567 294 551 267 527 236 509 192 497 177 508 216 506 229 471 202 446 184 403 224 393 216 391 185 392 150 352 124 379 125 387 114 399 111
					yourself:
				)
		)
	)
)

(instance pool_135 of Feature
	(properties
		noun 49
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 156 176 125 299 117 414 126 481 149 493 173 450 203 361 219 241 221 170 210 98 177 99 151
					yourself:
				)
		)
	)
)

(instance myrmSeats_135 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 147 22 153 60 153 61 169 86 170 88 183 91 193 111 194 127 185 136 189 143 204 168 198 191 255 228 245 239 245 238 224 254 216 270 225 334 216 349 234 373 237 379 234 370 224 379 197 395 192 466 201 467 175 486 173 500 181 524 177 501 171 507 146 526 150 533 153 552 149 563 156 591 168 590 194 584 214 555 281 533 291 479 287 51 290 44 285 24 250 0 201 4 154 19 153
					yourself:
				)
		)
	)
)

