;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5315)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	NY_Octospider_Plaza_15 0
)

(instance NY_Octospider_Plaza_15 of Location
	(properties)

	(method (init)
		(super init:)
		(proc201_1 0)
		(switch gPrevRoomNum
			(5311 ; NY_Octospider_Plaza_11
				(self addPicObj: faceNE faceE faceS faceSW faceW faceN faceNE)
			)
			(5316 ; NY_Octospider_Plaza_16
				(switch global298
					(315
						(self
							addPicObj:
								faceSW
								faceW
								faceN
								faceNE
								faceE
								faceS
								faceSW
						)
					)
					(0
						(self
							addPicObj:
								faceW
								faceN
								faceNE
								faceE
								faceS
								faceSW
								faceW
						)
					)
				)
			)
			(5317 ; NY_Octospider_Plaza_17
				(self addPicObj: faceW faceN faceNE faceE faceS faceSW faceW)
			)
			(5318 ; NY_Octospider_Plaza_18
				(self addPicObj: faceN faceNE faceE faceS faceSW faceW faceN)
			)
			(5319 ; NY_Octospider_Plaza_19
				(switch global298
					(135
						(self
							addPicObj:
								faceNE
								faceE
								faceS
								faceSW
								faceW
								faceN
								faceNE
						)
					)
					(90
						(self
							addPicObj:
								faceN
								faceNE
								faceE
								faceS
								faceSW
								faceW
								faceN
						)
					)
				)
			)
			(5320 ; NY_Octospider_Plaza_20
				(self addPicObj: faceNE faceE faceS faceSW faceW faceN faceNE)
			)
			(5321 ; NY_Octospider_Plaza_21
				(switch global298
					(135
						(self
							addPicObj:
								faceNE
								faceE
								faceS
								faceSW
								faceW
								faceN
								faceNE
						)
					)
					(180
						(self
							addPicObj:
								faceE
								faceS
								faceSW
								faceW
								faceN
								faceNE
								faceE
						)
					)
				)
			)
			(5322 ; NY_Octospider_Plaza_22
				(self addPicObj: faceE faceS faceSW faceW faceN faceNE faceE)
			)
			(5323 ; NY_Octospider_Plaza_23
				(self addPicObj: faceS faceSW faceW faceN faceNE faceE faceS)
			)
			(5324 ; NY_Octospider_Plaza_24
				(switch global298
					(315
						(self
							addPicObj:
								faceSW
								faceW
								faceN
								faceNE
								faceE
								faceS
								faceSW
						)
					)
					(270
						(self
							addPicObj:
								faceS
								faceSW
								faceW
								faceN
								faceNE
								faceE
								faceS
						)
					)
				)
			)
			(else
				(self addPicObj: faceS faceSW faceW faceN faceNE faceE faceS)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 5311) ; NY_Octospider_Plaza_11
			(= exitStyle 13)
			(= global298 0)
		else
			(= global298 heading)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5360
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom21 init:)
		(exitToRoom22 init:)
		(super init:)
		(tetraYRState view: 5360 loop: 0 x: 127 y: 180 init: global117)
		(lock_180 init:)
		(cup_180 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5355
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(exitToRoom20 init:)
		(photoExit init:)
		(tetraExit init:)
		(super init:)
		(prismState init: global117)
		(cond
			((not (IsFlag 235))
				(= temp0 0)
				(photo_135 init:)
			)
			((and (IsFlag 235) (== (proc70_9 108) 5319))
				(= temp0 1)
			)
			(else
				(= temp0 2)
			)
		)
		(photoState view: 5355 loop: 1 cel: temp0 x: 26 y: 183 init: global117)
		(tetraYRState view: 5355 loop: 2 x: 510 y: 180 init: global117)
		(prismPed_135 init:)
		(lock_135 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5356
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom18 init:)
		(exitToRoom19 init:)
		(super init:)
		(photoState
			view: 5356
			loop: 0
			cel: (if (IsFlag 235) 1 else 0)
			x: 399
			y: 181
			init: global117
		)
		(if (not (photoState cel:))
			(photo_90 init:)
		)
		(corn_90 init:)
		(lock_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5357
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom16 init:)
		(exitToRoom17 init:)
		(super init:)
		(lock_0 init:)
		(matrix_0 init:)
		(filter_0 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5358
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitOut init:)
		(exitOut24 init:)
		(exitOut16 init:)
		(super init:)
		(lock_315 init:)
		(cutters_315 init:)
		(matrix_315 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5359
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom23 init:)
		(exitToRoom24 init:)
		(super init:)
		(lock_270 init:)
		(mapPiece_270 init:)
		(clippers_270 init:)
	)
)

(instance exitToRoom16 of Feature
	(properties
		nsLeft 98
		nsTop 143
		nsRight 182
		nsBottom 241
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5316) ; NY_Octospider_Plaza_16
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRoom17 of Feature
	(properties
		nsLeft 281
		nsTop 146
		nsRight 419
		nsBottom 290
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5317) ; NY_Octospider_Plaza_17
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRoom18 of Feature
	(properties
		nsLeft 118
		nsTop 141
		nsRight 284
		nsBottom 286
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5318) ; NY_Octospider_Plaza_18
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRoom19 of Feature
	(properties
		nsLeft 374
		nsTop 144
		nsRight 477
		nsBottom 241
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5319) ; NY_Octospider_Plaza_19
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRoom20 of Feature
	(properties
		nsLeft 242
		nsTop 139
		nsRight 356
		nsBottom 207
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 227 131 362 131 362 225 227 225
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5320) ; NY_Octospider_Plaza_20
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRoom21 of Feature
	(properties
		nsLeft 117
		nsTop 141
		nsRight 203
		nsBottom 235
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5321) ; NY_Octospider_Plaza_21
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRoom22 of Feature
	(properties
		nsLeft 310
		nsTop 148
		nsRight 449
		nsBottom 287
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5322) ; NY_Octospider_Plaza_22
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRoom23 of Feature
	(properties
		nsLeft 117
		nsTop 141
		nsRight 286
		nsBottom 288
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5323) ; NY_Octospider_Plaza_23
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRoom24 of Feature
	(properties
		nsLeft 374
		nsTop 143
		nsRight 473
		nsBottom 241
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5324) ; NY_Octospider_Plaza_24
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitOut of ExitFeature
	(properties
		nsLeft 172
		nsTop 118
		nsRight 404
		nsBottom 206
		nextRoom 5311
	)
)

(instance tetraExit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 501 162 532 126 564 156 564 247 510 247 480 231
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5321) ; NY_Octospider_Plaza_21
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance photoExit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 24 130 85 155 98 195 116 226 103 240 63 249 24 249
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5319) ; NY_Octospider_Plaza_19
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitOut24 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 24 145 24 245 73 245 110 235 111 224 85 172 61 151
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5324) ; NY_Octospider_Plaza_24
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitOut16 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 473 222 513 145 540 145 558 173 558 248 511 248
					yourself:
				)
			setHotspot: 2
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5316) ; NY_Octospider_Plaza_16
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance prismState of View
	(properties
		x 285
		y 166
		view 5355
	)

	(method (init)
		(if (IsFlag 237)
			(= cel 1)
		)
		(super init: &rest)
	)
)

(instance photoState of View
	(properties
		x 26
		y 183
		view 5355
		loop 1
	)

	(method (init)
		(super init: &rest)
	)
)

(instance tetraYRState of View
	(properties
		x 510
		y 180
		view 5355
		loop 2
	)

	(method (init)
		(cond
			((not (IsFlag 236))
				(= cel 0)
			)
			((and (IsFlag 236) (== (proc70_9 103) 5321))
				(= cel 1)
			)
			(else
				(= cel 2)
			)
		)
		(super init: &rest)
	)
)

(instance prismPed_135 of Feature
	(properties
		noun 4
		nsLeft 274
		nsTop 149
		nsRight 319
		nsBottom 202
		x 296
		y 175
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance corn_90 of Feature
	(properties
		noun 8
		nsLeft 209
		nsTop 144
		nsRight 223
		nsBottom 184
		x 216
		y 164
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lock_90 of Feature
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
					init: 152 168 172 153 195 171 173 191
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 397 163 406 151 417 161 407 172
					yourself:
				)
		)
	)
)

(instance lock_0 of Feature
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
					init: 128 161 135 152 143 161 134 169
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 301 168 320 152 339 169 319 183
					yourself:
				)
		)
	)
)

(instance matrix_0 of Feature
	(properties
		noun 10
		nsLeft 133
		nsTop 157
		nsRight 142
		nsBottom 172
		x 137
		y 164
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance filter_0 of Feature
	(properties
		noun 9
		nsLeft 339
		nsTop 160
		nsRight 355
		nsBottom 190
		x 347
		y 175
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lock_315 of Feature
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
					init: 15 165 29 150 41 163 28 176
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 509 162 519 150 529 161 518 172
					yourself:
				)
		)
	)
)

(instance cutters_315 of Feature
	(properties
		noun 12
		nsLeft 42
		nsTop 160
		nsRight 71
		nsBottom 174
		x 56
		y 167
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance matrix_315 of Feature
	(properties
		noun 10
		nsLeft 519
		nsTop 160
		nsRight 534
		nsBottom 174
		x 526
		y 167
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lock_270 of Feature
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
					init: 149 173 175 151 197 170 174 188
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 389 159 397 149 410 163 398 174
					yourself:
				)
		)
	)
)

(instance mapPiece_270 of Feature
	(properties
		noun 11
		nsLeft 192
		nsTop 164
		nsRight 235
		nsBottom 189
		x 213
		y 176
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance clippers_270 of Feature
	(properties
		noun 12
		nsLeft 407
		nsTop 160
		nsRight 432
		nsBottom 174
		x 419
		y 167
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lock_180 of Feature
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
					init: 143 161 154 148 164 160 154 171
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 324 168 344 152 361 169 341 183
					yourself:
				)
		)
	)
)

(instance cup_180 of Feature
	(properties
		noun 13
		nsLeft 357
		nsTop 160
		nsRight 381
		nsBottom 184
		x 369
		y 172
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lock_135 of Feature
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
					init: 17 164 30 151 43 164 31 177
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 273 155 282 147 292 154 283 161
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 520 161 531 150 543 161 532 171
					yourself:
				)
		)
	)
)

(instance photo_135 of Feature
	(properties
		noun 7
		nsLeft 50
		nsTop 157
		nsRight 65
		nsBottom 173
		x 57
		y 165
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 35)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance photo_90 of Feature
	(properties
		noun 7
		nsLeft 424
		nsTop 158
		nsRight 438
		nsBottom 171
		x 431
		y 164
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(proc1111_31 35)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

