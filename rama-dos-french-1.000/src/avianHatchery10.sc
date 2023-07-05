;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6810)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianHatchery10 0
)

(instance avianHatchery10 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6809 ; avianHatchery09
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(6805 ; avianHatchery05
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceE
						(westMural1 init: global117)
						(westMural2 init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceE
						(westMural1 dispose:)
						(westMural2 dispose:)
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
		heading 180
		picture 6860
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(incubator_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 6861
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 6805 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(jungleGym_270 init:)
		(column_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 6863
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(murals_90 init:)
		(incubator_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6862
		edgeS 0
		edgeN 0
	)

	(method (init)
		(consoleExit init:)
		(gCurRoom exitN: consoleExit)
		(super init:)
		(incubator_0 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties
		nsBottom 245
		nsLeft 101
		nsRight 523
		nsTop 61
	)
)

(instance consoleExit of ExitFeature
	(properties
		nsBottom 211
		nsLeft 329
		nsRight 509
		nsTop 84
		nextRoom 6811
	)
)

(instance westMural1 of View
	(properties
		x 131
		y 140
		view 6810
	)
)

(instance westMural2 of View
	(properties
		x 363
		y 140
		cel 1
		view 6810
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
					init: 131 92 273 94 271 168 129 168
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 364 99 507 96 504 167 361 167
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 127 89 269 93 271 167 134 169
					yourself:
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
					init: 55 230 76 199 99 200 102 221 188 223 194 208 218 209 219 222 261 220 271 209 294 209 306 231 345 231 347 206 371 208 383 235 404 236 388 225 409 200 433 200 427 214 490 217 496 205 507 203 523 213 543 217 583 220 586 231 570 233 543 243 548 254 536 257 543 280 544 285 512 243 490 248 490 284 237 286 180 270 170 252 52 237
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
					init: 95 290 93 263 84 251 78 213 167 200 252 191 270 214 320 214 316 199 370 195 374 180 392 180 391 133 439 107 495 125 494 137 478 137 482 155 491 183 525 202 549 209 566 194 597 204 587 234 515 235 541 257 501 263 419 236 429 211 401 214 368 210 346 211 348 220 274 229 281 270 306 286 308 292 104 285
					yourself:
				)
		)
	)
)

(instance column_270 of Feature
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
					init: 202 3 196 126 176 126 155 163 201 195 326 204 422 181 429 152 403 119 397 2
					yourself:
				)
		)
	)
)

(instance jungleGym_270 of Feature
	(properties
		noun 39
		x 146
		y 72
		nsBottom 68
		nsLeft 146
		nsRight 146
		nsTop 75
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance incubator_180 of Feature
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
					init: 99 179 149 176 215 180 215 205 254 218 315 215 349 197 405 188 481 215 586 279 244 288 245 231 163 226 164 214 119 212 97 171
					yourself:
				)
		)
	)
)

