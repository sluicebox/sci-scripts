;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2103)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	CPIceport4 0
)

(instance CPIceport4 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2102 ; CPIceport3
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(2104 ; CPIceport5
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(2105 ; CPIceport6
				(faceS showBlack: 1)
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2413
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2105 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(sea_0 init:)
		(horns_0 init:)
		(pillar_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2414
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2104 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(pillar_90 init:)
		(sea_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2415
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2102 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(= showBlack 0)
		(hubSite_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2416
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(pillar_270 init:)
		(sea_270 init:)
		(spikes_270 init:)
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
					init: -1 1 74 0 93 38 127 79 168 114 228 138 294 147 352 141 418 116 461 82 495 39 518 1 592 0 592 280 565 222 546 211 541 273 449 274 446 205 416 205 413 264 352 235 350 184 331 185 331 234 260 235 260 185 242 185 242 233 217 272 181 272 178 205 151 205 144 273 53 273 49 210 44 203 23 204 3 63 -2 61
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 2
		nsLeft 268
		nsTop 36
		nsRight 319
		nsBottom 82
		x 293
		y 59
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pillar_0 of Feature
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
					init: -2 62 3 65 22 203 9 217 5 272 -1 272
					yourself:
				)
		)
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
					init: 411 248 425 233 444 228 467 81 485 72 492 29 535 -1 593 -1 593 290 501 291 449 279
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
					init: 282 0 534 -1 491 28 481 72 468 79 446 209 399 194 344 172 304 137 289 97 284 55 282 15
					yourself:
				)
		)
	)
)

(instance spikes_270 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 53 167 60 114 66 170 70 170 78 72 88 174 94 174 97 154 101 174 101 179 76 177 59 174
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 129 175 134 113 139 176 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 152 167 155 136 162 103 170 173
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 185 174 189 119 196 175 yourself:)
		)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 3
		nsLeft 258
		nsTop -1
		nsRight 335
		nsBottom 58
		x 296
		y 28
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pillar_90 of Feature
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
					init: 0 55 28 38 28 31 63 11 74 9 116 36 117 46 154 69 159 102 171 108 190 215 202 220 213 230 200 239 156 244 70 243 47 250 40 250 35 213 27 205 14 213 7 261 1 259
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
					init: -1 0 320 1 319 50 312 98 303 129 294 142 282 136 275 147 268 151 257 165 250 170 234 183 216 193 188 203 169 109 157 104 153 72 117 47 119 38 73 11 62 13 29 32 28 38 0 57
					yourself:
				)
		)
	)
)

