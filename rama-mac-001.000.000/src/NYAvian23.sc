;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5023)
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
	NYAvian23 0
)

(instance NYAvian23 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5021 ; NYAvian21
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(5025 ; NYAvian25
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(5028 ; NYAvian28
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(else
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5078
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 224)
			(= picture 5112)
		)
		(defaultExit nextRoom: 5017 init:)
		(super init: &rest)
		(jack init:)
		(pillar_45 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5079
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (== ((ScriptID 201 0) curAPRampPosition:) 1) ; newYorkRegion
			(loc21Exit init:)
			(defaultExit
				nextRoom: 5025
				init:
				setPolygon:
					((Polygon new:)
						type: PTotalAccess
						init: 272 0 355 0 355 88 272 88
						yourself:
					)
			)
			(gCurRoom exitN: defaultExit)
			(= picture 5130)
			(openDoor_135 init:)
			(ramp1_135 init:)
			(rampGear_135 init:)
			(avianDoors_135 init:)
		else
			(defaultExit nextRoom: 5021 init:)
			(gCurRoom exitN: defaultExit)
			(balcony_135 init:)
			(rampGear2_135 init:)
			(openDoor2_135 init:)
			(perches2_135 init:)
		)
		(super init: &rest)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5076
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(switch ((ScriptID 201 0) curAPRampPosition:) ; newYorkRegion
			(1
				(= picture 5126)
				(ramp1_225 init:)
			)
			(2
				(= picture 5125)
				(ramp2_225 init:)
			)
			(3
				(= picture 5076)
				(ramp3_225 init:)
			)
			(4
				(= picture 5127)
				(ramp4_225 init:)
			)
			(5
				(= picture 5128)
				(ramp5_225 init:)
			)
		)
		(super init: &rest)
		(rampGear_225 init:)
		(avianDoors_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5077
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(switch ((ScriptID 201 0) curAPRampPosition:) ; newYorkRegion
			(5
				(= picture 5133)
				(avianDoors_315 init:)
				(ramp5_315 init:)
				(rampGear_315 init:)
			)
			(else
				(= picture 5077)
			)
		)
		(loc28Exit init:)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance loc21Exit of ExitFeature
	(properties
		nsLeft 89
		nsTop 149
		nsRight 154
		nsBottom 200
		nextRoom 5021
	)
)

(instance loc28Exit of Feature
	(properties
		noun 26
	)

	(method (init)
		(if (== ((ScriptID 201 0) curAPRampPosition:) 5) ; newYorkRegion
			(= nsLeft 406)
			(= nsTop 145)
			(= nsRight 477)
			(= nsBottom 198)
		else
			(= nsLeft 60)
			(= nsTop 135)
			(= nsRight 138)
			(= nsBottom 202)
		)
		(super init:)
		(self setHotspot: 2 123 124 125 126 127)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom newRoom: 5028) ; NYAvian28
			)
		)
	)
)

(instance jack of View
	(properties
		x 416
		y 213
		view 5002
		loop 8
	)

	(method (init)
		(if (== (proc70_9 38) 5018)
			(super init: global117)
		)
	)
)

(instance pillar_45 of Feature
	(properties
		noun 18
		nsLeft 409
		nsTop 1
		nsRight 590
		nsBottom 214
		x 499
		y 107
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance rampGear_225 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -3 136 244 150 392 147 507 144 588 138 588 162 475 163 376 164 278 169 145 166 -1 163
					yourself:
				)
		)
	)
)

(instance ramp1_225 of Feature
	(properties
		noun 23
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 71 -1 131 1 269 107 279 107 287 148 292 176 287 225 292 313 253 278 234 2 70
					yourself:
				)
		)
	)
)

(instance ramp2_225 of Feature
	(properties
		noun 23
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 79 184 87 366 263 189 290 174 277 147 268 156 250 115 227 51 223 102 180 92 79
					yourself:
				)
		)
	)
)

(instance ramp3_225 of Feature
	(properties
		noun 23
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 257 94 334 94 402 277 189 273
					yourself:
				)
		)
	)
)

(instance ramp4_225 of Feature
	(properties
		noun 23
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 409 88 499 76 489 180 538 225 477 227 430 245 443 266 418 271 404 290 223 264 239 243 260 239 411 94 407 92 407 89
					yourself:
				)
		)
	)
)

(instance ramp5_225 of Feature
	(properties
		noun 23
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 270 254 292 240 302 240 589 68 590 135 590 265 482 275 487 286 473 295 434 292 416 292 362 293 327 291 273 254
					yourself:
				)
		)
	)
)

(instance ramp5_315 of Feature
	(properties
		noun 23
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 263 85 348 85 423 292 161 293 172 268 199 257
					yourself:
				)
		)
	)
)

(instance avianDoors_315 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 92 -2 179 0 196 77 72 59
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 273 1 251 77 370 82 342 4
					yourself:
				)
		)
	)
)

(instance rampGear_315 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -4 136 111 144 243 146 236 166 84 170 3 165
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 358 147 365 168 395 165 400 166 402 147 356 146
					yourself:
				)
		)
	)
)

(instance avianDoors_225 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 2 76 68 195 87 174 1
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 269 1 323 2 342 87 246 86
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 413 0 395 84 510 69 487 -1
					yourself:
				)
		)
	)
)

(instance openDoor_135 of Feature
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
					init: 282 0 261 84 367 83 344 1
					yourself:
				)
		)
	)
)

(instance ramp1_135 of Feature
	(properties
		noun 23
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 273 90 355 90 346 95 409 255 436 271 442 293 191 289 199 267 222 254 276 96 273 92 272 89
					yourself:
				)
		)
	)
)

(instance rampGear_135 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 147 261 147 389 147 505 145 586 136 590 162 470 164 391 165 371 165 216 165
					yourself:
				)
		)
	)
)

(instance avianDoors_135 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 443 0 425 78 564 55 542 0
					yourself:
				)
		)
	)
)

(instance balcony_135 of Feature
	(properties
		noun 20
		nsLeft 5
		nsTop 1
		nsRight 230
		nsBottom 202
		x 117
		y 101
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance rampGear2_135 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 389 143 506 138 588 136 590 163 519 164 455 164 393 163
					yourself:
				)
		)
	)
)

(instance openDoor2_135 of Feature
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
					init: 466 -1 451 57 589 45 589 0
					yourself:
				)
		)
	)
)

(instance perches2_135 of Feature
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
					init: -1 91 14 92 13 104 1 104
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 26 92 51 91 46 105 26 104
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 58 92 75 92 75 102 56 103
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 114 92 136 94 133 102 113 103
					yourself:
				)
		)
	)
)

