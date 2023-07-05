;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6401)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianTheatre2 0
)

(instance avianTheatre2 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6400 ; avianTheatre1
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(6402 ; avianTheatre3
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(6403 ; avianTheatre4
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6402
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(northExitStairsDoor init:)
		(gCurRoom exitN: northExitStairsDoor)
		(super init:)
		(perches_180 init:)
		(doorThOut_180 init:)
		(myrmicatHead_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6403
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (== (proc70_9 35) 6403)
			(gourdOnStage init: global117)
		)
		(eastExitGourd init:)
		(gCurRoom exitN: eastExitGourd)
		(super init:)
		(perches_270 init:)
		(lights_270 init:)
		(lightsBurnedOut_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6404
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(westExitBackStageDoor init:)
		(gCurRoom exitN: westExitBackStageDoor)
		(super init:)
		(perches_90 init:)
		(stage_90 init:)
		(door2Bkstage_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6405
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(myrmSeats_0 init:)
		(stage_0 init:)
		(banner_0 init:)
	)
)

(instance northExitStairsDoor of ExitFeature
	(properties
		nsLeft 250
		nsTop 158
		nsRight 345
		nsBottom 234
		nextRoom 6400
	)
)

(instance westExitBackStageDoor of ExitFeature
	(properties
		nsLeft 170
		nsTop 140
		nsRight 234
		nsBottom 233
		nextRoom 6402
	)
)

(instance eastExitGourd of ExitFeature
	(properties
		nsLeft 379
		nsTop 127
		nsRight 528
		nsBottom 230
		nextRoom 6403
	)
)

(instance westExitMovie of VMDMovie ; UNUSED
	(properties
		movieName 6403
		frameRate 10
		options 256
		endPic 6407
	)
)

(instance gourdOnStage of View
	(properties
		x 483
		y 173
		z 10
		view 6400
		cel 1
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
					init: -1 173 19 166 29 145 62 149 70 174 3 212
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 76 198 115 172 120 150 155 148 164 177 110 228 75 229
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 196 228 194 201 220 168 220 148 253 150 256 177 242 228
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 317 147 345 144 349 171 365 207 366 229 318 228
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 414 149 446 149 451 172 482 203 485 227 442 230 406 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 499 176 507 142 541 149 552 166 593 188 592 223 565 226
					yourself:
				)
		)
	)
)

(instance stage_0 of Feature
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
					init: 2 67 191 67 199 115 178 129 157 97 -2 99
					yourself:
				)
		)
	)
)

(instance banner_0 of Feature
	(properties
		noun 20
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 14 160 7 201 16 200 54 167 61 140 52
					yourself:
				)
		)
	)
)

(instance perches_270 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 103 180 194 177 321 258 76 252
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
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
					init: 438 176 434 163 457 162 453 179
					yourself:
				)
		)
	)
)

(instance lightsBurnedOut_270 of Feature
	(properties
		noun 26
		nsLeft 483
		nsTop 166
		nsRight 503
		nsBottom 184
		x 493
		y 175
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance perches_180 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 119 232 254 236 86 288 6 281 2 239
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 356 233 472 230 588 242 589 287 527 290
					yourself:
				)
		)
	)
)

(instance doorThOut_180 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 277 175 313 175 333 235 259 236
					yourself:
				)
		)
	)
)

(instance myrmicatHead_180 of Feature
	(properties
		noun 27
		nsLeft 275
		nsTop 93
		nsRight 317
		nsBottom 138
		x 296
		y 115
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance perches_90 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 410 179 501 185 545 254 276 268
					yourself:
				)
		)
	)
)

(instance stage_90 of Feature
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
					init: 41 0 192 50 177 104 128 106 112 72 6 44
					yourself:
				)
		)
	)
)

(instance door2Bkstage_90 of Feature
	(properties
		noun 28
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 150 215 154 234 220 219 236 177 225 168 206
					yourself:
				)
		)
	)
)

