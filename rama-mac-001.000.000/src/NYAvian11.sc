;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5011)
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
	NYAvian11 0
)

(instance NYAvian11 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5012 ; NYAvian12
				(self addPicObj: faceW faceE faceW)
			)
			(5002 ; NYAvian2
				(self addPicObj: faceE faceW faceE)
			)
			(else
				(self addPicObj: faceE faceW faceE)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5045
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc12Exit init:)
		(gCurRoom exitN: loc12Exit)
		(if (IsFlag 223)
			(= picture 5139)
		else
			(= picture 5045)
		)
		(super init: &rest)
		(doorHandle init:)
		(perch init:)
		(tetrahedron_90 init:)
		(tetDoor_90 init:)
		(pylons_90 init:)
		(avianStatue_90 init:)
		(myrm_Statue_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5046
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 142)
			(= picture 5946)
		else
			(= picture 5046)
		)
		(loc2Exit init:)
		(gCurRoom exitN: loc2Exit)
		(super init: &rest)
		(sign_270 init:)
		(gate_270 init:)
		(redPlatform_270 init:)
		(pylons_270 init:)
		(avianDoor_270 init:)
	)
)

(instance doorHandle of View
	(properties
		x 271
		y 90
		view 5002
		loop 3
	)

	(method (init)
		(if (IsFlag 221)
			(if (IsFlag 223)
				(= cel 1)
			else
				(= cel 0)
			)
			(super init: global117)
		)
	)
)

(instance perch of View
	(properties
		x 261
		y 153
		view 5002
		loop 3
		cel 1
	)

	(method (init)
		(if (== (proc70_9 111) 5012)
			(if (IsFlag 223)
				(= cel 3)
			else
				(= cel 2)
			)
			(super init: global117)
		)
	)
)

(instance loc12Exit of ExitFeature
	(properties
		nsLeft 223
		nsTop 66
		nsRight 372
		nsBottom 249
		nextRoom 5012
	)
)

(instance loc2Exit of ExitFeature
	(properties
		nsLeft 97
		nsTop 46
		nsRight 472
		nsBottom 197
		nextRoom 5002
	)
)

(instance sign_270 of Feature
	(properties
		noun 3
		nsLeft 220
		nsTop 50
		nsRight 250
		nsBottom 94
		x 235
		y 72
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pylons_270 of Feature
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
					init: -2 128 5 129 15 185 -1 187
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 113 149 119 144 126 144 130 150 136 182 107 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 255 152 407 156 412 148 419 148 420 155 426 181 404 184
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 477 159 487 156 494 184 476 183
					yourself:
				)
		)
	)
)

(instance gate_270 of Feature
	(properties
		noun 39
		nsLeft 283
		nsTop 166
		nsRight 308
		nsBottom 182
		x 295
		y 174
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance redPlatform_270 of Feature
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
					init: -3 187 114 178 251 177 381 181 430 183 482 183 590 184 591 204 314 216 101 211 1 209
					yourself:
				)
		)
	)
)

(instance avianDoor_270 of Feature
	(properties
		noun 4
		nsLeft 417
		nsTop 80
		nsRight 440
		nsBottom 107
		x 428
		y 93
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance avianStatue_90 of Feature
	(properties
		noun 30
		nsLeft 159
		nsTop 90
		nsRight 216
		nsBottom 238
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance myrm_Statue_90 of Feature
	(properties
		noun 31
		nsLeft 372
		nsTop 94
		nsRight 437
		nsBottom 233
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance tetrahedron_90 of Feature
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
					init: 65 199 138 -3 449 -3 527 199
					yourself:
				)
		)
	)
)

(instance tetDoor_90 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 251 147 296 75 339 148 yourself:)
		)
	)
)

(instance pylons_90 of Feature
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
					init: 17 146 23 137 29 148 35 182 9 184
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 516 165 523 157 524 161 530 185 518 185
					yourself:
				)
		)
	)
)

