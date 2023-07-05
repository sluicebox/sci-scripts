;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1006)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	hubCamp6 0
)

(instance hubCamp6 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(faceN down: faceNDown)
		(faceNDown up: faceN)
		(switch gPrevRoomNum
			(1002 ; hubCamp2
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(1003 ; hubCamp3
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
		picture 1061
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1161)
		)
		(super init: &rest)
		(exitToDoor init:)
		(airlock_180 init:)
		(storage_180 init:)
		(cots_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 1063
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1163)
		)
		(super init: &rest)
		(if (proc1111_24 80)
			(darkSky_0 init:)
		else
			(northHCyl_0 init:)
			(horns_0 init:)
			(sea_0 init:)
			(newYork_0 init:)
			(lights_0 init:)
		)
	)
)

(instance faceNDown of CameraAngle
	(properties
		picture 1065
		edgeS 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1165)
		)
		(super init: &rest)
		(if (proc1111_24 80)
			(darkSky_0_Down init:)
		)
		(ledge_0_Down init:)
		(bombLight init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 1062
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(cond
			((IsFlag 80)
				(= picture 1162)
			)
			((IsFlag 79)
				(= picture 1066)
			)
			(else
				(= picture 1062)
			)
		)
		(super init: &rest)
		(exitToComputer init:)
		(if (proc1111_24 80)
			(darkSky_270 init:)
		)
		(computer_270 init:)
		(if (proc1111_24 79)
			(cableCar_270 init:)
		)
		(cots_270 init:)
		(gangplank_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 1064
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1164)
		)
		(super init: &rest)
		(exitToLockers init:)
		(if (proc1111_24 80)
			(darkSky_90 init:)
		)
		(storage_90 init:)
		(lockers_90 init:)
	)
)

(instance exitToDoor of ExitFeature
	(properties
		nextRoom 1000
	)
)

(instance exitToLockers of ExitFeature
	(properties
		nextRoom 1002
	)
)

(instance exitToComputer of ExitFeature
	(properties
		nextRoom 1003
	)
)

(instance bombLight of View
	(properties
		x 487
		y 220
		view 1065
	)

	(method (init)
		(if (proc1111_24 80)
			(super init: global117)
			(gCurRoom setScript: blinking_Light)
		)
	)

	(method (dispose)
		(blinking_Light dispose:)
		(super dispose: &rest)
	)
)

(instance blinking_Light of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bombLight show:)
				(= seconds 1)
			)
			(1
				(bombLight hide:)
				(= state -1)
				(= seconds 1)
			)
		)
	)
)

(instance darkSky_0 of Feature
	(properties
		noun 1
		nsLeft 3
		nsTop 2
		nsRight 588
		nsBottom 268
		x 295
		y 135
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance darkSky_270 of Feature
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
					init: 379 4 587 0 587 278 377 168
					yourself:
				)
		)
	)
)

(instance gangplank_270 of Feature
	(properties
		noun 3
		nsLeft 289
		nsTop 137
		nsRight 587
		nsBottom 181
		x 438
		y 159
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance computer_270 of Feature
	(properties
		noun 5
		nsLeft 100
		nsTop 99
		nsRight 305
		nsBottom 155
		x 202
		y 127
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance cots_270 of Feature
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
					init: 2 147 91 126 99 161 0 175
					yourself:
				)
		)
	)
)

(instance storage_180 of Feature
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
					init: 3 131 110 129 115 79 166 76 247 116 261 163 183 159 90 202 4 210
					yourself:
				)
		)
	)
)

(instance airlock_180 of Feature
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
					init: 188 104 245 57 370 53 436 94 434 137 412 135 411 163 265 163 256 115
					yourself:
				)
		)
	)
)

(instance cots_180 of Feature
	(properties
		noun 4
		nsLeft 509
		nsTop 129
		nsRight 584
		nsBottom 165
		x 546
		y 147
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance darkSky_90 of Feature
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
					init: 3 -1 182 4 179 96 122 98 117 218 3 284
					yourself:
				)
		)
	)
)

(instance lockers_90 of Feature
	(properties
		noun 2
		nsLeft 124
		nsTop 95
		nsRight 207
		nsBottom 221
		x 165
		y 158
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance storage_90 of Feature
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
					init: 213 140 500 128 519 89 588 95 590 201 403 199 371 179 215 184
					yourself:
				)
		)
	)
)

(instance darkSky_0_Down of Feature
	(properties
		noun 1
		nsLeft 2
		nsTop 2
		nsRight 588
		nsBottom 170
		x 295
		y 86
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ledge_0_Down of Feature
	(properties
		noun 8
		nsTop 167
		nsRight 590
		nsBottom 288
		x 295
		y 227
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance cableCar_270 of Feature
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
					init: 498 124 521 86 545 86 579 138 571 174 516 174
					yourself:
				)
		)
	)
)

(instance lights_0 of Feature
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
					init: 71 -1 190 76 183 89 34 4 412 71 520 -1 555 2 413 87
					yourself:
				)
		)
	)
)

(instance sea_0 of Feature
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
					init: 196 83 264 32 341 35 400 89 397 206 329 260 249 253 188 204 174 133
					yourself:
				)
		)
	)
)

(instance newYork_0 of Feature
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
					init: 207 93 226 72 250 58 219 99 201 150 197 117 204 99
					yourself:
				)
		)
	)
)

(instance northHCyl_0 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 231 104 267 72 319 69 361 102 373 169 332 213 295 224 237 198 215 153
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 15
		nsLeft 284
		nsTop 133
		nsRight 311
		nsBottom 156
		x 297
		y 144
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

