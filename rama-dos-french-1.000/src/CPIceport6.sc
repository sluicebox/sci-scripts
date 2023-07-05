;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2105)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	CPIceport6 0
)

(instance CPIceport6 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2103 ; CPIceport4
				(faceN showBlack: 1)
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(2106 ; CPIceport7
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2421
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(= showBlack 0)
		(sea_0 init:)
		(horns_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2422
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2106 init:)
		(if (IsFlag 72)
			(= picture 2435)
		)
		(super init: &rest)
		(sea_90 init:)
		(icemobile_90 init:)
		(port_90 init:)
		(if (not (SetFlag 76))
			(proc1111_31 23)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2423
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2103 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(hubsite_180 init:)
		(spikes_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2424
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(pillar_270 init:)
		(sea_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance sea_0 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 -2 72 -2 103 48 142 90 180 118 242 140 298 147 357 138 412 115 451 89 488 52 510 15 518 -2 590 -1 592 290 -2 290
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 2
		x 292
		y 57
		nsBottom 81
		nsLeft 266
		nsRight 318
		nsTop 34
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pillar_270 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 31 279 58 256 80 244 120 55 135 51 149 -1 363 -1 374 53 393 59 428 245 419 290 188 291 184 250 171 239 165 239 140 258 137 290 43 290
					yourself:
				)
		)
	)
)

(instance sea_270 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 362 -1 590 -2 590 292 413 289 426 245 390 59 371 53
					yourself:
				)
		)
	)
)

(instance hubsite_180 of Feature
	(properties
		noun 3
		x 296
		y 28
		nsBottom 57
		nsLeft 259
		nsRight 333
		nsTop -1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance spikes_180 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 540 178 544 120 553 178 yourself:)
				((Polygon new:) type: PTotalAccess init: 558 176 559 156 565 176 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 572 177 576 142 587 160 590 177
					yourself:
				)
		)
	)
)

(instance sea_90 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 251 0 239 79 248 118 244 126 242 143 234 149 201 148 179 153 173 156 78 240 78 251 84 255 95 262 78 290 -1 291
					yourself:
				)
		)
	)
)

(instance icemobile_90 of Feature
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
					init: 95 264 106 252 121 244 140 240 155 241 187 243 194 249 194 259 185 267 175 272 161 273 159 293 78 291 78 288 95 287 98 277 93 276
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(if (IsFlag 72)
					(gMessager say: 4 144 1 0 0 208) ; "Nicole is waiting for you."
				else
					(gMessager say: 4 144 2 0 0 208) ; "That is an vehicle made especially by the ISA for traveling on Ice."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance port_90 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 96 259 83 254 76 247 75 240 81 233 166 157 173 152 183 149 193 149 231 146 258 150 301 151 306 195 281 197 233 255 194 259 190 243 188 242 144 238 126 242 111 247 102 255
					yourself:
				)
		)
	)
)

