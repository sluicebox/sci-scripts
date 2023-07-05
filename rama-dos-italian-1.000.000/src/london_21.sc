;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3041)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	london_21 0
)

(instance london_21 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3043 ; london_23
				(self addPicObj: faceSE faceS faceSW faceNW faceN faceNE faceSE)
			)
			(3042 ; london_22
				(self addPicObj: faceN faceNE faceSE faceS faceSW faceNW faceN)
			)
			(else
				(self addPicObj: faceSW faceNW faceN faceNE faceSE faceS faceSW)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 3233
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(southWestExit init:)
		(drains_180 init:)
		(walkway_180 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		picture 3234
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(pipe_225 init:)
		(drains_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 3235
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(northWestExit init:)
		(drains_315 init:)
		(walkway_315 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 3232
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(drains_135 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 45
		picture 3231
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(eastExit init:)
		(drains_45 init:)
		(walkway_45 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3230
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(drains_0 init:)
		(pipes_0 init:)
	)
)

(instance southWestExit of ExitFeature
	(properties
		nextRoom 3042
	)
)

(instance eastExit of ExitFeature
	(properties
		nextRoom 3040
	)
)

(instance northWestExit of ExitFeature
	(properties
		nextRoom 3043
	)
)

(instance drains_225 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 134 245 178 247 210 277 225 319 216 324 214 322 182 297 134 278 132
					yourself:
				)
		)
	)
)

(instance drains_180 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 309 148 345 147 345 173 311 173
					yourself:
				)
		)
	)
)

(instance walkway_180 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 162 191 294 395 291 312 159
					yourself:
				)
		)
	)
)

(instance drains_135 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 268 132 238 185 239 220 278 229 313 226 322 222 320 183 291 136 279 131
					yourself:
				)
		)
	)
)

(instance drains_45 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 134 4 124 90 101 169 210 173 211 136 200 92 195 7
					yourself:
				)
		)
	)
)

(instance walkway_45 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 285 163 181 290 410 293 309 160
					yourself:
				)
		)
	)
)

(instance drains_0 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 329 134 304 182 304 204 345 211 371 210 374 178 337 134
					yourself:
				)
		)
	)
)

(instance pipes_0 of Feature
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
					init: 61 2 60 44 50 52 49 113 62 123 58 174 149 181 228 174 229 125 252 115 243 59 224 53 226 4
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 300 0 300 55 287 63 285 112 311 129 306 164 374 171 452 168 450 112 460 95 456 57 445 38 442 2
					yourself:
				)
		)
	)
)

(instance drains_315 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 316 145 344 145 347 175 311 175
					yourself:
				)
		)
	)
)

(instance walkway_315 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 279 161 207 289 401 291 311 159
					yourself:
				)
		)
	)
)

(instance pipe_225 of Feature
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
					init: 340 4 335 164 442 173 538 170 539 100 520 6
					yourself:
				)
		)
	)
)

