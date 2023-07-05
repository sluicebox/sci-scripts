;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6602)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianSchool03 0
)

(instance avianSchool03 of Location
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(6607 ; avianSchool08
				(self addPicObj: faceNW faceN faceNE faceSE faceS faceSW faceNW)
			)
			(6605 ; avianSchool06
				(self addPicObj: faceNE faceSE faceS faceSW faceNW faceN faceNE)
			)
			(else
				(self addPicObj: faceN faceNE faceSE faceS faceSW faceNW faceN)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceNE
						(northEastMural init: global117)
					)
					(faceSE
						(southEastMural init: global117)
					)
					(faceS
						(leftSouthMural init: global117)
						(rightSouthMural init: global117)
					)
					(faceSW
						(southWestMural init: global117)
					)
					(faceNW
						(northWestMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceNE
						(northEastMural dispose:)
					)
					(faceSE
						(southEastMural dispose:)
					)
					(faceS
						(leftSouthMural dispose:)
						(rightSouthMural dispose:)
					)
					(faceSW
						(southWestMural dispose:)
					)
					(faceNW
						(northWestMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 6608
		edgeN 0
		edgeS 0
	)

	(method (init)
		(SEexit init:)
		(gCurRoom exitN: SEexit)
		(doorExitSE init:)
		(gCurRoom exitNE: doorExitSE)
		(super init:)
		(murals_0 init:)
		(desks_0 init:)
		(doorNumbers_0 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 6610
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(SWexit init:)
		(gCurRoom exitN: SWexit)
		(doorExitSW init:)
		(gCurRoom exitNW: doorExitSW)
		(super init:)
		(murals_90 init:)
		(desks_90 init:)
		(doorNumbers_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6609
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(muralExitSE init:)
		(gCurRoom exitNW: muralExitSE)
		(muralExitSW init:)
		(gCurRoom exitNE: muralExitSW)
		(doorExitS init:)
		(gCurRoom exitN: doorExitS)
		(super init:)
		(murals_45 init:)
		(desks_45 init:)
		(doorNumbers_45 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(= picture
			(switch [global235 1]
				(0 6645)
				(1 6646)
				(3 6646)
				(else 6607)
			)
		)
		(NEexit init:)
		(gCurRoom exitN: NEexit)
		(super init:)
		(projector_270 init:)
		(mural_270 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 6611
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(NWexit init:)
		(gCurRoom exitN: NWexit)
		(super init:)
		(projector_180 init:)
		(murals_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6606
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(= picture
			(switch [global235 1]
				(0 6643)
				(1 6644)
				(3 6644)
				(else 6606)
			)
		)
		(super init: &rest)
		(projector_225 init:)
	)
)

(instance northEastMural of View
	(properties
		x 557
		y 149
		view 6626
		cel 6
	)
)

(instance southEastMural of View
	(properties
		x 243
		y 135
		view 6626
		cel 7
	)
)

(instance leftSouthMural of View
	(properties
		x 21
		y 134
		view 6626
		cel 8
	)
)

(instance rightSouthMural of View
	(properties
		x 481
		y 108
		view 6626
		cel 9
	)
)

(instance southWestMural of View
	(properties
		x 217
		y 151
		view 6626
		loop 1
	)
)

(instance northWestMural of View
	(properties
		x 3
		y 167
		view 6626
		loop 1
		cel 1
	)
)

(instance defaultExit of ExitFeature ; UNUSED
	(properties)
)

(instance NEexit of ExitFeature
	(properties
		nsLeft 237
		nsTop 80
		nsRight 421
		nsBottom 201
		nextRoom 6607
	)
)

(instance NWexit of ExitFeature
	(properties
		nsLeft 188
		nsTop 72
		nsRight 297
		nsBottom 188
		nextRoom 6605
	)
)

(instance SWexit of ExitFeature
	(properties
		nsLeft 142
		nsTop 75
		nsRight 418
		nsBottom 165
		nextRoom 6603
	)
)

(instance doorExitSW of ExitFeature
	(properties
		nsLeft 6
		nsTop 92
		nsRight 76
		nsBottom 178
		nextRoom 6601
	)
)

(instance doorExitS of ExitFeature
	(properties
		nsLeft 247
		nsTop 77
		nsRight 357
		nsBottom 179
		nextRoom 6601
	)
)

(instance SEexit of ExitFeature
	(properties
		nsLeft 160
		nsTop 77
		nsRight 443
		nsBottom 167
		nextRoom 6609
	)
)

(instance doorExitSE of ExitFeature
	(properties
		nsLeft 491
		nsTop 89
		nsRight 586
		nsBottom 187
		nextRoom 6601
	)
)

(instance muralExitSE of ExitFeature
	(properties
		nsLeft 2
		nsTop 56
		nsRight 158
		nsBottom 162
		nextRoom 6609
	)
)

(instance muralExitSW of ExitFeature
	(properties
		nsLeft 426
		nsTop 65
		nsRight 577
		nsBottom 164
		nextRoom 6603
	)
)

(instance projector_225 of Feature
	(properties
		noun 40
		nsLeft 202
		nsTop 75
		nsRight 394
		nsBottom 246
		x 298
		y 160
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance projector_180 of Feature
	(properties
		noun 40
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 589 87 545 91 511 126 474 157 463 218 479 266 535 292 591 291
					yourself:
				)
		)
	)
)

(instance murals_180 of Feature
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
					init: 97 99 0 72 -2 154 56 158 72 146 79 92
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
					init: 207 92 215 82 351 83 357 92 355 145 346 152 220 153 209 145
					yourself:
				)
		)
	)
)

(instance desks_90 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 227 244 240 233 287 231 290 264 272 275
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 337 233 325 250 332 264 365 267 341 279 341 287 419 287 445 268 430 257 396 250 389 230
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 445 233 429 249 452 272 471 271 481 258 485 235
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 545 250 508 254 515 267 536 279 578 281 590 281 592 259
					yourself:
				)
		)
	)
)

(instance doorNumbers_90 of Feature
	(properties
		noun 55
		nsLeft 17
		nsTop 95
		nsRight 52
		nsBottom 107
		x 34
		y 101
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance doorNumbers_45 of Feature
	(properties
		noun 55
		nsLeft 280
		nsTop 98
		nsRight 311
		nsBottom 108
		x 295
		y 103
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance murals_45 of Feature
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
					init: -1 52 113 67 117 151 108 163 2 164
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 467 83 478 70 593 60 591 158 481 163 470 151
					yourself:
				)
		)
	)
)

(instance desks_45 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 10 251 73 253 77 278 69 294 1 291
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 521 250 492 271 515 289 584 292 585 262
					yourself:
				)
		)
	)
)

(instance murals_0 of Feature
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
					init: 230 91 237 82 283 80 373 79 382 94 377 150 367 159 327 157 242 157 231 149
					yourself:
				)
		)
	)
)

(instance doorNumbers_0 of Feature
	(properties
		noun 55
		nsLeft 535
		nsTop 94
		nsRight 577
		nsBottom 107
		x 556
		y 100
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance desks_0 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 291 232 354 233 354 254 328 270 304 271 294 254
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 200 228 151 259 179 284 252 284 230 262 246 254 239 234
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 96 233 137 231 151 252 131 270 106 270 94 261 93 245
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 8 238 25 240 87 255 61 283 -1 285
					yourself:
				)
		)
	)
)

(instance projector_270 of Feature
	(properties
		noun 40
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 92 26 91 44 105 83 132 128 186 99 275 57 291 -9 289
					yourself:
				)
		)
	)
)

(instance mural_270 of Feature
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
					init: 515 76 505 91 514 159 528 165 592 165 591 72
					yourself:
				)
		)
	)
)

