;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6901)
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
	mirmicatPoolRm1 0
)

(instance mirmicatPoolRm1 of Location
	(properties
		noun 54
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6907 ; mirmicatPoolRm7
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(6906 ; mirmicatPoolRm6
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(6902 ; mirmicatPoolRm2
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
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6911)
				(leftPool_0 noun: 50 init:)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6911)
				(leftPool_0 noun: 50 init:)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6972)
				(leftPool_0 noun: 50 init:)
			)
			(else
				(= picture 6972)
				(leftPool_0 noun: 50 init:)
			)
		)
		(controlsExit init:)
		(gCurRoom exitN: controlsExit)
		(super init:)
		(door_0 init:)
		(ramp_0 init:)
		(rightPool_0 init:)
		(myrmSeats_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 6912
		edgeS 0
		edgeN 0
	)

	(method (init)
		(doorExitE init:)
		(gCurRoom exitN: doorExitE)
		(super init:)
		(pool_90 init:)
		(myrmSeats_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		edgeS 0
		edgeN 0
	)

	(method (init)
		(doors_270 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6913)
				(myrmPool_270 noun: 50 init:)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6913)
				(myrmPool_270 noun: 50 init:)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6973)
				(myrmPool_270 noun: 49 init:)
			)
			(else
				(= picture 6973)
				(myrmPool_270 noun: 49 init:)
			)
		)
		(doorExitW init:)
		(gCurRoom exitN: doorExitW)
		(super init:)
		(if (== (proc70_9 36) 6911)
			(humanKey init: global117)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6968
		edgeS 0
		edgeN 0
	)
)

(instance controlsExit of ExitFeature
	(properties
		nsBottom 156
		nsLeft 238
		nsRight 353
		nsTop 90
		nextRoom 6907
	)
)

(instance doorExitE of ExitFeature
	(properties
		nsBottom 191
		nsLeft 214
		nsRight 354
		nsTop 88
		nextRoom 6902
	)
)

(instance doorExitW of ExitFeature
	(properties
		nsBottom 191
		nsLeft 214
		nsRight 354
		nsTop 88
		nextRoom 6906
	)
)

(instance humanKey of View
	(properties
		x 530
		y 204
		view 6903
	)
)

(instance doors_270 of Feature
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
					init: 247 186 288 85 350 91 379 171
					yourself:
				)
		)
	)
)

(instance myrmPool_270 of Feature
	(properties
		noun 50
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 338 195 469 178 589 190 586 264 524 275 385 243 341 209
					yourself:
				)
		)
	)
)

(instance ramp_0 of Feature
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
					init: 197 286 202 235 210 210 233 179 248 150 258 127 282 120 315 122 335 127 344 150 362 173 417 235 418 289 290 286
					yourself:
				)
		)
	)
)

(instance leftPool_0 of Feature
	(properties
		noun 50
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 240 100 204 120 170 21 158 -1 159
					yourself:
				)
		)
	)
)

(instance rightPool_0 of Feature
	(properties
		noun 49
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 470 169 579 158 586 225 526 218 457 187
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
					init: 247 129 269 91 308 92 328 129
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
					init: 46 276 30 269 -6 281 -1 251 1 229 36 205 40 201 49 196 70 199 77 214 87 210 87 203 96 192 96 177 128 181 130 186 143 177 143 173 148 167 138 165 123 171 100 165 88 166 78 166 69 167 34 164 17 162 17 152 42 150 140 135 198 136 228 137 236 157 228 179 214 200 180 242 157 243
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 442 259 527 239 587 246 588 226 577 219 568 205 542 200 498 186 446 170 473 155 540 154 364 137 347 144 371 181 403 223 440 255
					yourself:
				)
		)
	)
)

(instance pool_90 of Feature
	(properties
		noun 49
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 177 84 175 178 173 251 180 239 208 167 228 68 234 -2 229
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
					init: 6 233 37 236 45 246 74 247 77 225 94 217 112 220 115 232 166 232 174 250 155 262 116 261 109 274 88 285 33 280 22 289 1 290
					yourself:
				)
		)
	)
)

