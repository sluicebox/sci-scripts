;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3066)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)

(public
	london_36 0
)

(instance london_36 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceS faceW faceN faceE faceS)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3323
		heading 180
		edgeN 0
		edgeS 0
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3322
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(crane_270 init:)
		(if (proc1111_24 114)
			(= picture 3352)
			(spider_270 init:)
		)
		(super init: &rest)
		(laser init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3320
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3321
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(northExitToLondon35 init:)
	)
)

(instance northExitToLondon35 of ExitFeature
	(properties
		nextRoom 3065
	)
)

(instance westExitToLondon34 of ExitFeature ; UNUSED
	(properties
		nextRoom 3064
	)
)

(instance cranePickingUpSpider of VMDMovie
	(properties
		movieName 3322
		endPic 3322
	)
)

(instance cranePuttingDownSpider of VMDMovie
	(properties
		movieName 3323
		endPic 3352
	)
)

(instance laser of Feature
	(properties
		noun 34
		nsLeft 253
		nsTop 210
		nsRight 327
		nsBottom 270
	)

	(method (init)
		(super init:)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (proc1111_24 114)
					(cranePickingUpSpider play:)
					(SetFlag 114)
				else
					(cranePuttingDownSpider play:)
					(ClearFlag 114)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spider_270 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 142 267 142 277 171 285 182 290 192 302 195 301 207 286 207 282 211 275 201 260 193 251 193
					yourself:
				)
		)
	)
)

(instance crane_270 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 247 129 257 124 257 94 278 85 280 68 271 47 260 28 272 20 289 19 297 19 316 20 321 36 313 50 313 72 328 87 334 127 362 127 366 173 377 195 378 202 358 202 333 200 324 187 332 158 305 172 288 172 271 166 252 193
					yourself:
				)
		)
	)
)

