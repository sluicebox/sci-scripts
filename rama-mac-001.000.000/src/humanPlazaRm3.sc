;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5203)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	humanPlazaRm3 0
)

(instance humanPlazaRm3 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(faceNW up: faceUpNW)
		(faceFinale up: faceUpNW)
		(faceNE up: faceUpNE)
		(facePent up: faceUpPent)
		(faceControls up: faceUpPent)
		(faceMaze up: faceUpMaze)
		(switch gPrevRoomNum
			(5202 ; humanPlazaRm2
				(self
					addPicObj:
						faceNE
						facePent
						faceControls
						faceMaze
						faceNW
						faceFinale
						faceNE
				)
			)
			(5204 ; humanPlazaRm4
				(self
					addPicObj:
						faceControls
						faceMaze
						faceNW
						faceFinale
						faceNE
						facePent
						faceControls
				)
			)
			(5205 ; humanPlazaRm5
				(self
					addPicObj:
						faceNW
						faceFinale
						faceNE
						facePent
						faceControls
						faceMaze
						faceNW
				)
			)
			(5206 ; humanPlazaRm6
				(self
					addPicObj:
						faceFinale
						faceNE
						facePent
						faceControls
						faceMaze
						faceNW
						faceFinale
				)
			)
			(else
				(self
					addPicObj:
						faceFinale
						faceNE
						facePent
						faceControls
						faceMaze
						faceNW
						faceFinale
				)
			)
		)
	)
)

(instance faceControls of CameraAngle
	(properties
		picture 5213
		heading 180
		edgeS 0
	)

	(method (init)
		(exitToControls init:)
		(walls_180 init:)
		(alley_180 init:)
		(super init: &rest)
	)
)

(instance faceFinale of CameraAngle
	(properties
		picture 5210
		edgeS 0
	)

	(method (init)
		(exitToFinale init:)
		(walls_0 init:)
		(exit_0 init:)
		(super init: &rest)
	)
)

(instance faceMaze of CameraAngle
	(properties
		picture 5212
		heading 225
		edgeS 0
	)

	(method (init)
		(exitToMaze init:)
		(walls_225 init:)
		(super init: &rest)
	)
)

(instance faceUpMaze of CameraAngle
	(properties
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(0 faceFinale)
				(45 faceNE)
				(315 faceNW)
				(180 faceControls)
				(135 facePent)
				(225 faceMaze)
			)
		)
		(if (IsFlag 142)
			(= picture 5272)
		else
			(= picture 5268)
		)
		(sea_225_up init:)
		(super init: &rest)
	)
)

(instance facePent of CameraAngle
	(properties
		picture 5214
		heading 135
		edgeS 0
	)

	(method (init)
		(exitToPent init:)
		(walls_135 init:)
		(pentahedron_135 init:)
		(fork_135 init:)
		(super init: &rest)
	)
)

(instance faceUpPent of CameraAngle
	(properties
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(0 faceFinale)
				(45 faceNE)
				(315 faceNW)
				(180 faceControls)
				(135 facePent)
				(225 faceMaze)
			)
		)
		(if (IsFlag 142)
			(= picture 5271)
		else
			(= picture 5267)
		)
		(sea_135_up init:)
		(super init: &rest)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5209
		heading 45
		edgeS 0
	)

	(method (init)
		(walls_45 init:)
		(super init: &rest)
	)
)

(instance faceUpNE of CameraAngle
	(properties
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(0 faceFinale)
				(45 faceNE)
				(315 faceNW)
				(180 faceControls)
				(135 facePent)
				(225 faceMaze)
			)
		)
		(if (IsFlag 142)
			(= picture 5269)
		else
			(= picture 5265)
		)
		(sea_45_up init:)
		(super init: &rest)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5211
		heading 315
		edgeS 0
	)

	(method (init)
		(walls_315 init:)
		(super init: &rest)
	)
)

(instance faceUpNW of CameraAngle
	(properties
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(0 faceFinale)
				(45 faceNE)
				(315 faceNW)
				(180 faceControls)
				(135 facePent)
				(225 faceMaze)
			)
		)
		(if (IsFlag 142)
			(= picture 5270)
		else
			(= picture 5266)
		)
		(sea_315_up init:)
		(super init: &rest)
	)
)

(instance exitToFinale of ExitFeature
	(properties
		nsLeft 201
		nsTop 47
		nsRight 330
		nsBottom 213
		nextRoom 5204
	)
)

(instance exitToControls of ExitFeature
	(properties
		nsLeft 212
		nsTop 48
		nsRight 329
		nsBottom 213
		nextRoom 5206
	)
)

(instance exitToMaze of ExitFeature
	(properties
		nsLeft 157
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5202
	)
)

(instance exitToPent of ExitFeature
	(properties
		nsLeft 240
		nsTop 85
		nsRight 367
		nsBottom 212
		nextRoom 5205
	)
)

(instance walls_0 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 1 592 2 592 184 515 182 476 184 446 182 426 183 388 183 336 184 168 184 145 184 103 182 83 184 18 182 -2 184
					yourself:
				)
		)
	)
)

(instance exit_0 of Feature
	(properties
		noun 28
		nsLeft 239
		nsTop 1
		nsRight 292
		nsBottom 179
		x 265
		y 90
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_45 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 -2 591 -1 589 181 145 179 107 181 51 181 -1 181
					yourself:
				)
		)
	)
)

(instance walls_135 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 0 590 0 590 181 -2 180
					yourself:
				)
		)
	)
)

(instance pentahedron_135 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 300 147 320 181 281 180 yourself:)
		)
	)
)

(instance fork_135 of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 345 160 356 160 358 182 344 181
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 591 1 590 182 -1 181
					yourself:
				)
		)
	)
)

(instance alley_180 of Feature
	(properties
		noun 2
		nsLeft 256
		nsTop 119
		nsRight 283
		nsBottom 180
		x 269
		y 149
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_225 of Feature
	(properties
		noun 32
		nsLeft -1
		nsRight 590
		nsBottom 182
		x 294
		y 91
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_315 of Feature
	(properties
		noun 32
		nsTop 1
		nsRight 589
		nsBottom 181
		x 294
		y 91
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_45_up of Feature
	(properties
		noun 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 306 16 352 111 431 194 412 204 423 215 426 231 422 236 408 236 402 229 395 229 372 266 373 271 320 266 314 256 301 254 292 262 254 259 221 198 189 157 174 141 235 20 236 22 248 23 249 19 256 18 259 22 272 22 275 16 281 16 283 20 300 20 300 16
					yourself:
				)
		)
	)
)

(instance sea_135_up of Feature
	(properties
		noun 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 288 23 404 79 400 82 400 92 406 93 406 100 402 104 402 117 408 120 407 125 404 127 403 142 407 142 408 155 404 154 403 164 398 165 397 182 391 163 351 180 313 206 287 226 265 246 233 279 219 266 223 261 218 257 207 268 194 270 188 267 188 254 196 246 196 242 190 237 184 238 178 236 179 230 172 226 167 227 162 224 163 222 158 217 154 218 158 165 163 164 169 159 169 156 165 152 164 150 170 146 170 144 166 139 160 139 163 106 196 90 232 67 266 41
					yourself:
				)
		)
	)
)

(instance sea_225_up of Feature
	(properties
		noun 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 218 19 271 23 271 28 277 35 285 30 290 37 294 32 295 26 334 29 363 83 395 125 417 149 355 270 352 267 344 268 341 272 334 272 332 268 317 269 316 273 309 274 308 269 291 270 290 274 285 274 271 238 246 191 217 152 184 117 160 97 168 87 172 90 175 89 179 85 168 73 165 57 168 54 182 55 188 62 194 62 199 56 196 51 200 47 204 46 209 39 206 36 212 29 213 30 218 24
					yourself:
				)
		)
	)
)

(instance sea_315_up of Feature
	(properties
		noun 30
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 354 13 370 22 367 29 372 33 382 22 398 19 403 22 401 35 394 42 394 47 401 51 405 51 411 55 410 61 416 64 421 62 427 65 427 69 431 72 438 72 440 74 432 128 429 126 422 131 427 137 421 144 428 150 428 184 400 196 367 216 337 238 303 269 188 210 190 209 190 198 186 196 186 189 190 187 187 171 184 171 183 165 187 164 188 145 185 145 186 135 187 134 189 126 199 130 244 105 279 85 314 56
					yourself:
				)
		)
	)
)

