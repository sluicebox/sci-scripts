;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5017)
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
	NYAvian17 0
)

(instance NYAvian17 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(faceSE up: (faceUp down: faceSE yourself:))
		(switch gPrevRoomNum
			(5007 ; NYAvian7
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
			(5018 ; NYAvian18
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
			(5022 ; NYAvian22
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(else
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 45
		picture 5059
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 5058
		edgeS 0
	)

	(method (init)
		(if (IsFlag 224)
			(loc22Exit init:)
			(= picture 5106)
		)
		(jack init:)
		(statueBaseExit init:)
		(super init: &rest)
		(pillar_135 init:)
		(window_135 init:)
		(perches_135 init:)
		(balcony_135 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		picture 5061
		edgeS 0
		edgeN 0
	)

	(method (init)
		(loc23Exit init:)
		(loc21Exit init:)
		(switch ((ScriptID 201 0) curAPRampPosition:) ; newYorkRegion
			(1
				(= picture 5116)
			)
			(2
				(= picture 5115)
			)
			(3
				(= picture 5061)
			)
			(4
				(= picture 5117)
			)
			(5
				(= picture 5118)
			)
		)
		(super init: &rest)
		(window_225 init:)
		(ramp_225 init:)
		(rampGear_225 init:)
		(openDoor_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 5060
		edgeS 0
		edgeN 0
	)

	(method (init)
		(plazaExit init:)
		(super init: &rest)
		(tetrahedron_315 init:)
		(wallIcons_315 init:)
	)
)

(instance faceUp of CameraAngle
	(properties
		heading 180
		picture 5063
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 224)
			(if (IsFlag 142)
				(= picture 5963)
			else
				(= picture 5863)
			)
		else
			(pillar_180_up init:)
			(if (IsFlag 142)
				(= picture 5763)
			else
				(= picture 5063)
			)
		)
		(super init: &rest)
		(wallIcon_180_up init:)
		(iceArch_180_up init:)
	)
)

(instance plazaExit of ExitFeature
	(properties
		nsBottom 242
		nsLeft 122
		nsRight 391
		nsTop 49
		nextRoom 5007
	)
)

(instance loc21Exit of ExitFeature
	(properties
		nsBottom 227
		nsLeft 43
		nsRight 196
		nsTop 131
		nextRoom 5021
	)
)

(instance loc23Exit of ExitFeature
	(properties
		nsBottom 246
		nsLeft 195
		nsRight 509
		nsTop 60
		nextRoom 5023
	)
)

(instance statueBaseExit of Feature
	(properties
		nsBottom 281
		nsLeft 264
		nsRight 320
		nsTop 213
	)

	(method (init)
		(super init:)
		(self setHotspot: 2 60)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom newRoom: 5018) ; NYAvian18
			)
		)
	)
)

(instance loc22Exit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 298 65 347 73 324 254 259 245
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5022) ; NYAvian22
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jack of View
	(properties
		x 284
		y 269
		loop 1
		view 5002
	)

	(method (init)
		(if (== (proc70_9 38) 5018)
			(if (IsFlag 224)
				(= cel 0)
			else
				(= cel 1)
			)
			(super init: global117)
		)
	)
)

(instance pillar_135 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 286 -2 280 239 254 244 245 256 271 271 313 273 351 258 339 247 310 234 310 -2
					yourself:
				)
		)
	)
)

(instance window_135 of Feature
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 510 61 542 24 567 15 589 20 588 90 580 90 580 83 534 93 532 100 528 104 507 82 507 59
					yourself:
				)
		)
	)
)

(instance perches_135 of Feature
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
					init: 87 72 105 73 104 84 89 83
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 131 75 148 76 143 88 132 86
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 166 76 185 77 178 88 167 88
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 201 80 217 80 215 91 201 91
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 235 81 251 83 250 90 231 92
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 269 83 283 87 279 96 271 96
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 302 86 314 89 314 96 303 97
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 330 88 345 89 344 97 332 97
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 389 92 401 92 398 99 389 101
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 415 94 429 94 427 103 417 102
					yourself:
				)
		)
	)
)

(instance balcony_135 of Feature
	(properties
		noun 20
		x 258
		y 54
		nsBottom 106
		nsLeft 55
		nsRight 461
		nsTop 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance tetrahedron_315 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 163 151 191 152 189 179 161 179
					yourself:
				)
		)
	)
)

(instance wallIcons_315 of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 0 249 0 250 41 210 40
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 146 1 172 3 172 41 144 41
					yourself:
				)
		)
	)
)

(instance openDoor_225 of Feature
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
					init: 224 62 245 67 255 131 215 123
					yourself:
				)
		)
	)
)

(instance window_225 of Feature
	(properties
		noun 21
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 26 59 64 32 87 31 124 53 123 78 98 105 44 104 23 78
					yourself:
				)
		)
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
					init: 198 159 258 162 350 164 351 173 296 173 258 172 197 171 194 158
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 393 163 581 157 582 168 397 173
					yourself:
				)
		)
	)
)

(instance ramp_225 of Feature
	(properties
		noun 23
		x 400
		y 168
		nsBottom 214
		nsLeft 212
		nsRight 588
		nsTop 123
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pillar_180_up of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 295 40 300 33 312 36 366 289 307 290
					yourself:
				)
		)
	)
)

(instance wallIcon_180_up of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 392 110 428 113 444 141 404 137
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 198 23 225 25 231 41 195 43
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 198 23 225 25 231 41 195 43
					yourself:
				)
		)
	)
)

(instance iceArch_180_up of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 234 2 238 22 248 24 254 37 272 42 270 61 276 54 301 55 292 41 301 33 310 35 314 56 320 88 351 89 348 82 363 83 369 94 378 96 388 103 396 103 402 101 404 104 414 0
					yourself:
				)
		)
	)
)

