;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6400)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianTheatre1 0
)

(instance avianTheatre1 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6401 ; avianTheatre2
				(self addPicObj: faceS faceN faceS)
			)
			(else
				(self addPicObj: faceN faceS faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 61
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 131)
			(= picture 6400)
		)
		(super init:)
		(FrameOut)
		(if (!= (proc70_9 35) 6403)
			(southExitToMirmicatStand init: stairsNoGourd)
		else
			(southExitToMirmicatStand init: stairsWithGourd)
			(gourdOnStage init: global117)
		)
		(if (not (IsFlag 131))
			(avianPlay play:)
			(SetFlag 131)
			(proc1111_31 45)
		)
		(gourds_0 init:)
		(stages_0 init:)
		(myrmSeats_0 init:)
		(perches_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6401
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(northExitToTunnel init:)
		(gCurRoom exitN: northExitToTunnel)
		(doorTheaterOut_180 init:)
		(doorNumbers_180 init:)
	)
)

(instance northExitToTunnel of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 6005
		exitStyle 13
	)
)

(instance southExitToMirmicatStand of ExitFeature
	(properties
		nsBottom 228
		nsLeft 258
		nsRight 337
		nsTop 114
		nextRoom 6401
	)
)

(instance avianPlay of VMDMovie
	(properties
		movieName 6402
		endPic 6400
	)
)

(instance stairsWithGourd of VMDMovie
	(properties
		movieName 6400
		frameRate 10
		options 256
		endPic 6405
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(gourdOnStage dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stairsNoGourd of VMDMovie
	(properties
		movieName 6401
		frameRate 10
		options 256
		endPic 6405
	)
)

(instance gourdOnStage of View
	(properties
		x 222
		y 146
		view 6400
		z 10
	)
)

(instance stages_0 of Feature
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
					init: 327 1 408 4 406 30 320 26
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 188 47 249 48 270 41 265 70 190 79
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 319 85 331 89 332 100 393 95 403 105 395 121 327 121 313 109
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 192 140 258 140 262 129 273 129 275 144 268 155 193 155
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
					init: 261 161 331 161 332 177 259 175
					yourself:
				)
		)
	)
)

(instance perches_0 of Feature
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
					init: 3 222 162 168 260 172 154 290 4 286
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 338 177 436 173 588 220 590 286 428 293
					yourself:
				)
		)
	)
)

(instance doorTheaterOut_180 of Feature
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
					init: 238 44 351 42 392 235 346 277 237 279 191 234
					yourself:
				)
		)
	)
)

(instance gourds_0 of Feature
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
					init: 217 107 204 78 200 46 191 6 266 4 269 28 257 55 248 106 254 140 202 140
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 333 88 343 46 327 20 332 2 396 3 376 46 375 97
					yourself:
				)
		)
	)
)

(instance doorNumbers_180 of Feature
	(properties
		noun 55
		x 293
		y 30
		nsBottom 45
		nsLeft 242
		nsRight 344
		nsTop 16
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

