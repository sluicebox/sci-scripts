;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6904)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use mirmicatPoolRm6)
(use Polygon)
(use Feature)

(public
	mirmicatPoolRm4 0
)

(instance mirmicatPoolRm4 of Location
	(properties
		noun 54
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6905 ; mirmicatPoolRm5
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(6903 ; mirmicatPoolRm3
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(6911 ; mirmicatPoolCloseUp
				(switch global164
					(0
						(self addPicObj: faceS faceW faceN faceE faceS)
					)
					(90
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
					(270
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
				)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6943
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(door_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6944
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6944)
				(= temp0 1)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6980)
				(= temp0 0)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6944)
				(= temp0 1)
			)
			(else
				(= picture 6980)
				(= temp0 0)
			)
		)
		(defaultExit nextRoom: 6903 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(ramp_135 init:)
		(myrmSeats_135 init:)
		(pool_SE init: temp0)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6941
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6941)
				(= temp0 1)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6946)
				(= temp0 0)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6947)
				(= temp0 1)
			)
			(else
				(= picture 6979)
				(= temp0 0)
			)
		)
		(SWExit init:)
		(gCurRoom exitN: SWExit)
		(SEExit init:)
		(gCurRoom exitN: SEExit)
		(super init: &rest)
		(door_180 init:)
		(ramp_180 init:)
		(myrmseats_180 init:)
		(pool_S init: temp0)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6942
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6942)
				(= temp0 1)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6948)
				(= temp0 0)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6949)
				(= temp0 1)
			)
			(else
				(= picture 6945)
				(= temp0 0)
			)
		)
		(defaultExit nextRoom: 6905 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(door_225 init:)
		(ramp_225 init:)
		(myrmSeats_225 init:)
		(pool_SW init: temp0)
	)
)

(instance pool_S of PoolFeature
	(properties
		nsLeft 91
		nsTop 206
		nsRight 564
		nsBottom 288
	)
)

(instance pool_SE of PoolFeature
	(properties
		nsLeft 316
		nsTop 208
		nsRight 547
		nsBottom 290
	)
)

(instance pool_SW of PoolFeature
	(properties
		nsLeft 10
		nsTop 211
		nsRight 296
		nsBottom 292
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
		nextRoom 6903
	)
)

(instance SEExit of ExitFeature
	(properties
		nsLeft 8
		nsTop 91
		nsRight 93
		nsBottom 197
		nextRoom 6903
	)
)

(instance SWExit of ExitFeature
	(properties
		nsLeft 500
		nsTop 101
		nsRight 583
		nsBottom 203
		nextRoom 6905
	)
)

(instance ramp_180 of Feature
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
					init: 241 151 337 153 338 180 244 181
					yourself:
				)
		)
	)
)

(instance door_180 of Feature
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
					init: 478 162 489 114 537 120 555 169
					yourself:
				)
		)
	)
)

(instance myrmseats_180 of Feature
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
					init: 79 171 62 180 62 215 242 197 317 197 396 202 522 217 522 179 461 170 429 160 408 167 381 167 358 159 339 158 332 173 301 176 258 174 242 174 234 158 177 168 106 171 78 175 61 173
					yourself:
				)
		)
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
					init: 219 166 237 123 266 124 282 163
					yourself:
				)
		)
	)
)

(instance myrmSeats_225 of Feature
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
					init: 84 164 126 173 155 171 180 172 192 168 203 169 205 176 253 175 255 209 109 208 0 213 -1 186 60 184 69 184 79 173 79 168
					yourself:
				)
		)
	)
)

(instance ramp_225 of Feature
	(properties
		noun 53
		nsLeft -3
		nsTop 152
		nsRight 76
		nsBottom 191
		x 36
		y 171
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ramp_135 of Feature
	(properties
		noun 53
		nsLeft 503
		nsTop 150
		nsRight 589
		nsBottom 195
		x 546
		y 172
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance myrmSeats_135 of Feature
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
					init: 343 174 496 165 588 188 587 213 467 211 372 211 330 210
					yourself:
				)
		)
	)
)

(instance door_0 of Feature
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
					init: 93 243 191 38 391 35 500 251
					yourself:
				)
		)
	)
)

