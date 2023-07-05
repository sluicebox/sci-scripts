;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6906)
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
	mirmicatPoolRm6 0
)

(instance mirmicatPoolRm6 of Location
	(properties
		noun 54
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6901 ; mirmicatPoolRm1
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(6905 ; mirmicatPoolRm5
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(6911 ; mirmicatPoolCloseUp
				(switch global164
					(0
						(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
					)
					(90
						(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
					)
					(270
						(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
					)
				)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 6921
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(door_45 init:)
		(ramp_45 init:)
		(myrmSeats_45 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6921)
				(= temp0 1)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6925)
				(= temp0 1)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6926)
				(= temp0 0)
			)
			(else
				(= picture 6974)
				(= temp0 0)
			)
		)
		(NEExit init:)
		(SEExit init:)
		(super init: &rest)
		(NEpool init: temp0)
		(if (== (proc70_9 36) 6911)
			(NEHumanKey init: global117)
		)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 6924
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(doors_0 init:)
		(myrmSeats_0 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6924)
				(= temp0 1)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6927)
				(= temp0 1)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6928)
				(= temp0 0)
			)
			(else
				(= picture 6975)
				(= temp0 0)
			)
		)
		(defaultExit nextRoom: 6905 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(NWpool init: temp0)
		(if (== (proc70_9 36) 6911)
			(NWHumanKey init: global117)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 6922
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(ramp_90 init:)
		(myrmSeats_90 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6922)
				(= temp0 1)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6922)
				(= temp0 1)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6998)
				(= temp0 0)
			)
			(else
				(= picture 6998)
				(= temp0 0)
			)
		)
		(defaultExit nextRoom: 6901 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(SEpool init: temp0)
		(if (== (proc70_9 36) 6911)
			(SEHumanKey init: global117)
		)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 6923
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(door_225 init:)
	)
)

(class PoolFeature of Feature
	(properties)

	(method (init param1)
		(super init: &rest)
		(if param1
			(self setHotspot: 2 22 15 144)
			(= noun 50)
		else
			(self setHotspot: 2 144)
			(= noun 49)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gGame autoSave: 1)
				(gCurRoom newRoom: 6911) ; mirmicatPoolCloseUp
			)
			(22
				((gTheCursor invItem:) doVerb: 22)
			)
			(15
				(proc70_3 35)
				(proc1111_31 3)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance NEpool of PoolFeature
	(properties
		nsLeft 126
		nsTop 196
		nsRight 496
		nsBottom 253
	)
)

(instance SEpool of PoolFeature
	(properties
		nsLeft 13
		nsTop 200
		nsRight 304
		nsBottom 289
	)
)

(instance NWpool of PoolFeature
	(properties
		nsLeft 317
		nsTop 197
		nsRight 563
		nsBottom 290
	)
)

(instance hallExit of ExitFeature ; UNUSED
	(properties
		nsLeft 220
		nsTop 62
		nsRight 393
		nsBottom 227
		nextRoom 6513
	)
)

(instance defaultExit of ExitFeature
	(properties
		nsLeft 220
		nsTop 62
		nsRight 393
		nsBottom 227
	)
)

(instance NEExit of ExitFeature
	(properties
		nsLeft 8
		nsTop 91
		nsRight 93
		nsBottom 197
		nextRoom 6905
	)
)

(instance SEExit of ExitFeature
	(properties
		nsLeft 500
		nsTop 101
		nsRight 583
		nsBottom 203
		nextRoom 6901
	)
)

(instance NEHumanKey of View
	(properties
		x 312
		y 207
		view 6903
		cel 1
	)
)

(instance SEHumanKey of View
	(properties
		x 47
		y 238
		view 6903
		cel 2
	)
)

(instance NWHumanKey of View
	(properties
		x 542
		y 246
		view 6903
		cel 3
	)
)

(instance door_225 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 243 208 37 381 35 473 241
					yourself:
				)
		)
	)
)

(instance myrmSeats_90 of Feature
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
					init: 5 210 81 202 146 202 236 208 288 208 285 186 209 177 155 177 153 170 141 170 137 176 107 178 79 178 39 178 -1 178 0 198
					yourself:
				)
		)
	)
)

(instance ramp_90 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 187 0 132 279 170 277 192
					yourself:
				)
		)
	)
)

(instance door_45 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 51 164 79 116 112 116 134 157
					yourself:
				)
		)
	)
)

(instance ramp_45 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 271 147 347 149 509 171 512 188 336 175 278 173
					yourself:
				)
		)
	)
)

(instance myrmSeats_45 of Feature
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
					init: 116 199 104 169 262 160 262 160 331 166 376 165 383 160 389 167 424 172 505 182 511 201 439 192 357 185 303 180 232 188 176 190 116 200 107 168
					yourself:
				)
		)
	)
)

(instance doors_0 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 291 165 329 115 359 120 377 163
					yourself:
				)
		)
	)
)

(instance myrmSeats_0 of Feature
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
					init: 341 171 331 211 547 206 589 209 579 190 541 188 516 173 526 163 510 163 493 171 483 176 346 170
					yourself:
				)
		)
	)
)

