;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3065)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	london_35 0
)

(instance london_35 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3064 ; london_34
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3319
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToLondon36 init:)
		(super init:)
		(laser_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3316
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (proc1111_24 114)
			(= picture 3346)
			(spider_270 init:)
		)
		(super init:)
		(westExitToLondon34 init:)
		(crane_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3318
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3317
		edgeN 0
		edgeS 0
	)
)

(instance southExitToLondon36 of ExitFeature
	(properties
		nsLeft 143
		nsTop 87
		nsRight 424
		nsBottom 276
		nextRoom 3066
	)
)

(instance westExitToLondon34 of ExitFeature
	(properties
		nsLeft 209
		nsTop 105
		nsRight 372
		nsBottom 280
		nextRoom 3064
	)
)

(instance laser_180 of Feature
	(properties
		noun 34
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 458 124 328 259 364 278 462 274 485 281 525 279 506 254 503 148 514 144 511 131
					yourself:
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
					init: 175 187 192 183 183 153 192 139 207 143 221 164 221 186 233 182 242 186 241 216 231 221 218 205 213 199 192 204 179 214 173 210 166 186
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
					init: 182 182 182 133 199 125 205 94 229 82 229 70 216 55 199 35 199 16 225 15 256 14 268 14 270 37 271 65 268 83 284 90 291 125 322 131 322 177 327 201 300 204 285 199 285 167 261 175 234 171 214 165 208 184 208 199 194 201 187 202
					yourself:
				)
		)
	)
)

