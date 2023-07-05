;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1000)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use System)

(public
	hubCamp0 0
)

(instance hubCamp0 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(1099 ; ShuttleRide
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 1001
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1101)
		)
		(super init: &rest)
		(storage_180 init:)
		(airlock_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 1003
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cond
			((proc1111_24 81)
				(= showBlack 1)
				(= picture 61)
			)
			((IsFlag 80)
				(= picture 1103)
			)
			((IsFlag 79)
				(= picture 1005)
			)
			(else
				(= picture 1003)
			)
		)
		(super init: &rest)
		(exitToRamp init:)
		(exitToEdge init:)
		(exitToLockers init:)
		(if (proc1111_24 81)
			(SetFlag 81)
			(SetFlag 79)
			(gCurRoom setScript: nicoleIntroScript)
		)
		(if (IsFlag 80)
			(northHCyl_0 init:)
			(horns_0 init:)
			(sea_0 init:)
			(newYork_0 init:)
			(lights_0 init:)
		else
			(darkSky_0 init:)
		)
		(gangplank_0 init:)
		(locker_0 init:)
		(if (proc1111_24 79)
			(cableCar_0 init:)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 1002
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1102)
		)
		(super init: &rest)
		(cots_270 init:)
		(computer_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 1004
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1104)
		)
		(super init: &rest)
		(storage_90 init:)
	)
)

(instance exitToRamp of ExitFeature
	(properties
		nsBottom 196
		nsLeft 8
		nsRight 103
		nsTop 122
		nextRoom 1003
	)
)

(instance exitToEdge of ExitFeature
	(properties
		nsBottom 200
		nsLeft 205
		nsRight 404
		nsTop 119
		nextRoom 1006
	)
)

(instance exitToLockers of ExitFeature
	(properties
		nsBottom 182
		nsLeft 433
		nsRight 507
		nsTop 125
		nextRoom 1002
	)
)

(instance faceSExit of ExitFeature ; UNUSED
	(properties
		nextRoom 24
	)
)

(instance nicoleIntroScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(nicoles_Intro play:)
				(SoundManager playMusic: 0 1 1100)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance nicoles_Intro of VMDMovie
	(properties
		movieName 38111
		options 64
		endPic 38119
		cacheSize 1000
	)
)

(instance darkSky_0 of Feature
	(properties
		noun 1
		x 296
		y 91
		nsBottom 181
		nsLeft 2
		nsRight 591
		nsTop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance gangplank_0 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 149 119 134 149 136 150 162 -1 199
					yourself:
				)
		)
	)
)

(instance locker_0 of Feature
	(properties
		noun 2
		x 528
		y 150
		nsBottom 184
		nsLeft 481
		nsRight 575
		nsTop 117
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
					init: 108 180 262 139 399 140 412 182 304 212 196 231
					yourself:
				)
		)
	)
)

(instance computer_270 of Feature
	(properties
		noun 5
		x 492
		y 131
		nsBottom 168
		nsLeft 395
		nsRight 590
		nsTop 95
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 1 106 115 6 480 3 586 78 585 159 472 165 469 216 269 213 259 181 205 185 176 203 114 203 112 116
					yourself:
				)
		)
	)
)

(instance storage_180 of Feature
	(properties
		noun 7
		x 58
		y 174
		nsBottom 240
		nsLeft 1
		nsRight 116
		nsTop 109
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
					init: 52 210 57 143 148 139 146 80 428 82 457 213 318 226 147 219
					yourself:
				)
		)
	)
)

(instance cableCar_0 of Feature
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
					init: 73 107 106 109 115 156 88 167 66 147
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
				((Polygon new:) type: PTotalAccess init: 64 1 179 71 169 81 31 3 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 399 76 520 0 549 5 406 89
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
					init: 181 174 181 105 232 45 303 28 380 63 414 122 410 172
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
					init: 222 171 218 126 249 79 299 64 350 89 373 130 372 171
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
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
					init: 284 137 297 130 310 147 296 160 283 152
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
					init: 200 151 200 108 215 79 250 60 217 103
					yourself:
				)
		)
	)
)

