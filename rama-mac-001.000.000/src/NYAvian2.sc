;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5002)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	NYAvian2 0
)

(instance NYAvian2 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(faceNE up: lookUpN)
		(faceE up: lookUpE)
		(faceSE up: lookUpS)
		(faceSW up: lookUpS)
		(faceW up: lookUpW)
		(faceNW up: lookUpN)
		(switch gPrevRoomNum
			(5001 ; NYAvian1
				(self addPicObj: faceE faceSE faceSW faceW faceNW faceNE faceE)
			)
			(5003 ; NYAvian3
				(self addPicObj: faceSE faceSW faceW faceNW faceNE faceE faceSE)
			)
			(5004 ; NYAvian4
				(self addPicObj: faceSW faceW faceNW faceNE faceE faceSE faceSW)
			)
			(5011 ; NYAvian11
				(self addPicObj: faceW faceNW faceNE faceE faceSE faceSW faceW)
			)
			(5012 ; NYAvian12
				(self addPicObj: faceW faceNW faceNE faceE faceSE faceSW faceW)
			)
			(5007 ; NYAvian7
				(self addPicObj: faceNW faceNE faceE faceSE faceSW faceW faceNW)
			)
			(5009 ; NYAvian9
				(self addPicObj: faceNW faceNE faceE faceSE faceSW faceW faceNW)
			)
			(else
				(self addPicObj: faceE faceSE faceSW faceW faceNW faceNE faceE)
			)
		)
	)

	(method (setPicObj)
		(super setPicObj: &rest)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5006
		heading 45
		edgeS 0
	)

	(method (init &tmp temp0)
		(neLoc4Exit init:)
		(super init: &rest)
		(if (and (== global413 3) (proc1111_24 229))
			(SetFlag 229)
			(avian_Swoop play:)
		)
		(redPlatform_45 init:)
		(lowWall_45 init:)
		(pylons_45 init:)
		(sign_45 init:)
		(mazeExit_45 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5005
		heading 90
		edgeS 0
	)

	(method (init)
		(if (IsFlag 223)
			(= picture 5138)
		)
		(eLoc4Exit init:)
		(loc11Exit init:)
		(eLoc7Exit init:)
		(super init: &rest)
		(perch init:)
		(redPlatform_90 init:)
		(pylons_90 init:)
		(tetrahedron_90 init:)
		(tet_Door_90 init:)
		(avianStatue_90 init:)
		(columnAlley_90 init:)
		(myrmicatStatue_90 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5011
		heading 135
		edgeS 0
	)

	(method (init)
		(seLoc7Exit init:)
		(super init: &rest)
		(redPlatform_135 init:)
		(pylons_135 init:)
		(lowWall_135 init:)
		(tetrahedron_135 init:)
		(sign_135 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5010
		heading 225
		edgeS 0
	)

	(method (init)
		(loc9Exit init:)
		(super init: &rest)
		(redPlatform_225 init:)
		(pylons_225 init:)
		(lowWall_225 init:)
		(controllerAlley_225 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5008
		heading 270
		edgeS 0
	)

	(method (init)
		(if (IsFlag 142)
			(= picture 5908)
		else
			(= picture 5008)
		)
		(loc1Exit init:)
		(super init: &rest)
		(redPlatform_270 init:)
		(ice_270 init:)
		(gate_270 init:)
		(sign_270 init:)
		(pylons_270 init:)
		(avianDoors_270 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5007
		heading 315
		edgeS 0
	)

	(method (init)
		(loc3Exit init:)
		(super init: &rest)
		(alleyWay_315 init:)
		(redPlatform_315 init:)
		(pylons_315 init:)
		(avianDoors_315 init:)
		(lowWall_315 init:)
	)
)

(instance lookUpN of CameraAngle
	(properties
		picture 5148
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(90 faceE)
				(45 faceNE)
				(315 faceNW)
				(270 faceW)
				(135 faceSE)
				(225 faceSW)
			)
		)
		(if (IsFlag 142)
			(= picture 5144)
		)
		(super init: &rest)
		(ice_0_up init:)
	)
)

(instance lookUpE of CameraAngle
	(properties
		picture 5147
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(90 faceE)
				(45 faceNE)
				(315 faceNW)
				(270 faceW)
				(135 faceSE)
				(225 faceSW)
			)
		)
		(if (IsFlag 142)
			(= picture 5143)
		)
		(super init: &rest)
		(ice_90_up init:)
	)
)

(instance lookUpS of CameraAngle
	(properties
		picture 5145
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(90 faceE)
				(45 faceNE)
				(315 faceNW)
				(270 faceW)
				(135 faceSE)
				(225 faceSW)
			)
		)
		(if (IsFlag 142)
			(= picture 5141)
		)
		(super init: &rest)
		(ice_180_up init:)
	)
)

(instance lookUpW of CameraAngle
	(properties
		picture 5146
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(90 faceE)
				(45 faceNE)
				(315 faceNW)
				(270 faceW)
				(135 faceSE)
				(225 faceSW)
			)
		)
		(if (IsFlag 142)
			(= picture 5142)
		)
		(super init: &rest)
		(ice_270_up init:)
	)
)

(instance loc1Exit of ExitFeature
	(properties
		nsLeft 235
		nsTop 74
		nsRight 344
		nsBottom 188
		nextRoom 5001
	)
)

(instance loc3Exit of ExitFeature
	(properties
		nsLeft 330
		nsTop 128
		nsRight 482
		nsBottom 191
		nextRoom 5003
	)
)

(instance eLoc4Exit of ExitFeature
	(properties
		nsLeft 60
		nsTop 75
		nsRight 179
		nsBottom 222
		nextRoom 5004
	)
)

(instance neLoc4Exit of ExitFeature
	(properties
		nsLeft 266
		nsTop 107
		nsRight 418
		nsBottom 200
		nextRoom 5004
	)
)

(instance loc11Exit of ExitFeature
	(properties
		nsLeft 231
		nsTop 75
		nsRight 365
		nsBottom 190
		nextRoom 5011
	)
)

(instance loc9Exit of ExitFeature
	(properties
		nsLeft 250
		nsTop 109
		nsRight 347
		nsBottom 192
		nextRoom 5009
	)
)

(instance eLoc7Exit of ExitFeature
	(properties
		nsLeft 410
		nsTop 100
		nsRight 535
		nsBottom 235
		nextRoom 5007
	)
)

(instance seLoc7Exit of ExitFeature
	(properties
		nsLeft 128
		nsTop 78
		nsRight 332
		nsBottom 213
		nextRoom 5007
	)
)

(instance avian_Swoop of VMDMovie
	(properties
		movieName 5028
		endPic 5006
		cacheSize 300
	)
)

(instance perch of View
	(properties
		x 285
		y 173
		view 5002
		loop 2
	)

	(method (init)
		(if (IsFlag 222)
			(if (IsFlag 223)
				(= cel 1)
			else
				(= cel 0)
			)
			(super init: global117)
		)
	)
)

(instance pylons_225 of Feature
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
					init: 145 112 152 112 150 99 164 102 175 189 160 193 134 190 145 114
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 493 125 497 124 497 111 503 114 515 109 517 118 538 188 514 191 487 188 494 127
					yourself:
				)
		)
	)
)

(instance lowWall_225 of Feature
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
					init: -2 153 118 149 124 184 131 187 92 191 -2 192
					yourself:
				)
		)
	)
)

(instance controllerAlley_225 of Feature
	(properties
		noun 13
		nsLeft 282
		nsTop 32
		nsRight 315
		nsBottom 180
		x 298
		y 106
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pylons_135 of Feature
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
					init: 105 167 115 171 116 184 109 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 133 168 143 168 144 184 133 183
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 187 166 198 167 201 181 185 183 189 168
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 329 158 339 160 345 167 349 183 329 183 330 157
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 564 106 571 104 570 89 578 90 582 104 586 104 589 196 555 196 565 109
					yourself:
				)
		)
	)
)

(instance lowWall_135 of Feature
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
					init: 349 167 531 147 544 185 556 190 507 193 341 186 348 180
					yourself:
				)
		)
	)
)

(instance tetrahedron_135 of Feature
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
					init: 0 119 44 190 -1 193 -1 121
					yourself:
				)
		)
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
					init: 227 186 296 72 363 187 228 186
					yourself:
				)
		)
	)
)

(instance avianStatue_90 of Feature
	(properties
		noun 30
		nsLeft 268
		nsTop 161
		nsRight 281
		nsBottom 189
		x 274
		y 175
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance myrmicatStatue_90 of Feature
	(properties
		noun 31
		nsLeft 310
		nsTop 163
		nsRight 321
		nsBottom 188
		x 315
		y 175
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 135 159 136 155 142 159 143 181 132 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 28 153 30 146 38 151 38 182 23 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 63 162 66 159 70 162 72 182 62 179
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 17 169 25 167 25 181 18 180
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: -1 159 4 161 4 181 -1 184
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 133 158 134 154 145 181 133 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 413 164 420 165 422 182 413 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 437 165 440 160 448 162 450 180 436 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 498 164 502 160 506 164 513 180 497 182
					yourself:
				)
		)
	)
)

(instance columnAlley_90 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 521 127 547 130 550 107 561 109 561 182 525 180 521 131
					yourself:
				)
		)
	)
)

(instance lowWall_45 of Feature
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
					init: -2 149 258 166 261 184 -3 199
					yourself:
				)
		)
	)
)

(instance pylons_45 of Feature
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
					init: 276 162 279 160 283 180 273 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 304 164 310 162 314 179 303 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 377 164 381 162 384 181 376 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 392 168 396 169 401 151 408 179 395 181 393 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 428 163 429 160 433 163 437 182 428 180
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 492 159 496 155 500 159 506 180 493 183
					yourself:
				)
		)
	)
)

(instance sign_45 of Feature
	(properties
		noun 3
		nsLeft 272
		nsTop 34
		nsRight 304
		nsBottom 84
		x 288
		y 59
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance redPlatform_45 of Feature
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
					init: -1 192 102 190 591 196 589 291 0 290
					yourself:
				)
		)
	)
)

(instance mazeExit_45 of Feature
	(properties
		noun 11
		nsLeft 305
		nsTop -2
		nsRight 355
		nsBottom 180
		x 330
		y 89
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance alleyWay_315 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 345 -2 345 41 453 37 493 -3 497 183 347 187
					yourself:
				)
		)
	)
)

(instance pylons_315 of Feature
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
					init: 102 128 109 128 110 119 124 120 124 129 130 132 139 187 91 187
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 264 143 272 149 280 143 285 188 264 188 264 146
					yourself:
				)
		)
	)
)

(instance lowWall_315 of Feature
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
					init: 535 147 589 148 590 189 515 193
					yourself:
				)
		)
	)
)

(instance redPlatform_315 of Feature
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
					init: 0 187 220 186 410 188 589 192 590 287 0 289
					yourself:
				)
		)
	)
)

(instance gate_270 of Feature
	(properties
		noun 39
		nsLeft 290
		nsTop 172
		nsRight 301
		nsBottom 180
		x 295
		y 176
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sign_270 of Feature
	(properties
		noun 3
		nsLeft 204
		nsTop 16
		nsRight 237
		nsBottom 63
		x 220
		y 39
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
					init: 543 124 553 123 553 114 570 113 570 123 576 124 588 171 589 190 537 189 543 128
					yourself:
				)
		)
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
					init: -1 190 204 184 400 185 541 187 593 189 590 291 0 292
					yourself:
				)
		)
	)
)

(instance ice_270 of Feature
	(properties
		noun 12
		nsLeft 291
		nsTop -1
		nsRight 303
		nsBottom 173
		x 297
		y 86
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance redPlatform_225 of Feature
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
					init: -2 192 87 193 130 186 342 189 490 187 590 190 590 291 -2 289
					yourself:
				)
		)
	)
)

(instance redPlatform_135 of Feature
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
					init: -1 194 168 191 420 188 506 192 552 190 591 195 588 288 -1 289
					yourself:
				)
		)
	)
)

(instance avianDoors_315 of Feature
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
					init: 375 81 391 85 395 102 375 104
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 375 135 394 136 397 156 373 156
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 303 37 327 41 327 66 301 70
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 301 116 330 117 326 143 298 147
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 68 22 91 30 87 65 57 57 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 140 36 166 38 163 68 140 69
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 107 78 134 78 129 107 105 108
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 137 115 164 115 162 144 141 145
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 137 115 164 115 162 144 141 145 509 75 531 77 533 111 507 111
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 550 65 568 63 569 96 551 97
					yourself:
				)
		)
	)
)

(instance sign_135 of Feature
	(properties
		noun 3
		nsLeft 304
		nsTop 9
		nsRight 351
		nsBottom 69
		x 327
		y 39
		z 100
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance avianDoors_270 of Feature
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
					init: 492 26 519 26 520 59 490 61
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 544 64 570 61 569 102 543 107
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 403 67 425 67 427 100 408 100
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 405 130 424 128 424 155 402 155
					yourself:
				)
		)
	)
)

(instance ice_90_up of Feature
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
					init: 234 24 302 22 301 -1 318 -1 321 26 340 27 382 88 388 240 369 269 235 256 216 225 217 61 240 22
					yourself:
				)
		)
	)
)

(instance ice_0_up of Feature
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
					init: -1 135 192 125 196 108 254 64 410 57 435 76 424 207 391 229 231 230 190 211 189 151 3 141
					yourself:
				)
		)
	)
)

(instance ice_270_up of Feature
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
					init: 218 19 354 33 372 230 351 266 292 269 252 259 181 154 202 49 221 24
					yourself:
				)
		)
	)
)

(instance ice_180_up of Feature
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
					init: 199 59 360 60 400 82 403 138 527 148 591 149 590 157 490 155 398 161 393 180 329 226 184 228 158 208 167 80
					yourself:
				)
		)
	)
)

(instance tet_Door_90 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 294 150 285 170 305 168 yourself:)
		)
	)
)

(instance redPlatform_90 of Feature
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
					init: 0 196 218 191 325 191 508 191 591 193 590 290 3 291
					yourself:
				)
		)
	)
)

