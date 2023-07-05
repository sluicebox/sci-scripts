;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2064)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	CPLondon5 0
)

(instance CPLondon5 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2062 ; CPLondon3
				(self addPicObj: faceN faceSE faceS faceNW faceN)
			)
			(2065 ; CPLondon6
				(self addPicObj: faceSE faceS faceNW faceN faceSE)
			)
			(else
				(self addPicObj: faceN faceSE faceS faceNW faceN)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(137
				(if (global117 contains: rayBeam)
					(rayBeam show:)
				)
				(global122 doVerb: theVerb)
			)
			(138
				(if (global117 contains: rayBeam)
					(rayBeam hide:)
				)
				(global122 doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2310
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(sea_0 init:)
		(starship_0 init:)
		(lights_0 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 2311
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(london_135 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2312
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(threeExit_180 init:)
		(super init: &rest)
		(rayBeam init: global117)
		(london_180 init:)
		(spikes_180 init:)
		(hubSite_180 init:)
		(beam_180 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 2313
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(sixExit_315 init:)
		(super init: &rest)
		(starship_315 init:)
		(sea_315 init:)
	)
)

(instance rayBeam of Prop
	(properties
		noun 2
		x 210
		y 162
		view 2312
	)

	(method (init)
		(if (IsFlag 117)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 21 6)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sea_0 of Feature
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
					init: 52 -1 199 -1 192 20 166 23 146 32 115 24 83 36 77 36 64 21
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 398 34 390 -1 539 -2 515 33 477 35 454 41 422 43
					yourself:
				)
		)
	)
)

(instance starship_0 of Feature
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
					init: 3 141 29 131 82 128 119 134 144 146 162 147 165 152 189 161 185 170 159 170 174 186 168 193 113 197 48 199 23 196 -3 190 -3 173 11 160
					yourself:
				)
		)
	)
)

(instance lights_0 of Feature
	(properties
		noun 6
		nsLeft 342
		nsTop -2
		nsRight 358
		nsBottom 33
		x 350
		y 15
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance starship_315 of Feature
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
					init: 497 200 483 189 506 162 495 149 526 134 592 127 592 208 556 206 517 204
					yourself:
				)
		)
	)
)

(instance sea_315 of Feature
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
					init: 303 -2 434 -2 436 30 447 54 453 65 435 67 422 72 404 79 395 69 379 56 368 55 342 60 319 31
					yourself:
				)
		)
	)
)

(instance london_180 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 -2 164 -2 147 15 209 78 204 107 189 108 190 142 237 188 133 205 85 219 33 223 -1 225
					yourself:
				)
		)
	)
)

(instance spikes_180 of Feature
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
					init: 248 185 255 104 260 163 266 97 274 186
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 316 185 317 149 323 173 327 128 331 145 335 101 339 140 343 119 354 188
					yourself:
				)
		)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 5
		nsLeft 266
		nsTop 3
		nsRight 324
		nsBottom 54
		x 295
		y 28
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance beam_180 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 208 161 248 161 248 180 229 180
					yourself:
				)
		)
	)
)

(instance london_135 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 136 176 153 160 157 139 153 126 152 112 162 106 164 76 185 50 183 99 186 103 201 91 204 84 217 74 216 70 201 68 201 64 215 41 222 -2 228 -2 228 36 241 34 247 37 250 -2 260 -1 256 51 296 18 293 5 276 5 270 -1 306 0 308 12 330 -1 591 -2 589 192 531 200 464 200 398 193 334 191
					yourself:
				)
		)
	)
)

(instance sixExit_315 of ExitFeature
	(properties
		nsLeft 87
		nsTop 88
		nsRight 485
		nsBottom 239
		x 286
		y 163
		nextRoom 2065
	)
)

(instance threeExit_180 of ExitFeature
	(properties
		nsLeft 138
		nsTop 77
		nsRight 478
		nsBottom 237
		x 308
		y 157
		nextRoom 2062
	)
)

