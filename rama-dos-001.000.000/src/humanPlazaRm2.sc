;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5202)
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
	humanPlazaRm2 0
)

(instance humanPlazaRm2 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(faceWall up: faceUpWall)
		(faceUpWall down: faceWall)
		(faceDeadEnd up: faceUpDeadEnd)
		(faceUpDeadEnd down: faceDeadEnd)
		(faceControls up: faceUpControls)
		(faceUpControls down: faceControls)
		(faceCenter up: faceUpCenter)
		(faceUpCenter down: faceCenter)
		(switch gPrevRoomNum
			(5203 ; humanPlazaRm3
				(self
					addPicObj:
						faceWall
						faceDeadEnd
						faceCenter
						faceControls
						faceWall
				)
			)
			(else
				(self
					addPicObj:
						faceCenter
						faceControls
						faceWall
						faceDeadEnd
						faceCenter
				)
			)
		)
	)
)

(instance faceCenter of CameraAngle
	(properties
		heading 45
		picture 5205
		edgeS 0
	)

	(method (init)
		(exitToCenter init:)
		(walls_45 init:)
		(super init: &rest)
	)
)

(instance faceUpCenter of CameraAngle
	(properties
		heading 45
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 142)
			(= picture 5269)
		else
			(= picture 5265)
		)
		(sea_45_up init:)
		(super init: &rest)
	)
)

(instance faceWall of CameraAngle
	(properties
		heading 225
		picture 5207
		edgeS 0
	)

	(method (init)
		(walls_225 init:)
		(tetraBY init:)
		(super init: &rest)
	)
)

(instance faceUpWall of CameraAngle
	(properties
		heading 225
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 142)
			(= picture 5272)
		else
			(= picture 5268)
		)
		(sea_225_up init:)
		(super init: &rest)
	)
)

(instance faceDeadEnd of CameraAngle
	(properties
		heading 315
		picture 5206
		edgeS 0
	)

	(method (init)
		(walls_315 init:)
		(super init: &rest)
	)
)

(instance faceUpDeadEnd of CameraAngle
	(properties
		heading 315
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 142)
			(= picture 5270)
		else
			(= picture 5266)
		)
		(sea_315_up init:)
		(super init: &rest)
	)
)

(instance faceControls of CameraAngle
	(properties
		heading 135
		picture 5208
		edgeS 0
	)

	(method (init)
		(walls_135 init:)
		(exit_135 init:)
		(super init: &rest)
	)
)

(instance faceUpControls of CameraAngle
	(properties
		heading 135
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 142)
			(= picture 5271)
		else
			(= picture 5267)
		)
		(sea_135_up init:)
		(super init: &rest)
	)
)

(instance exitToCenter of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5203
	)
)

(instance tetraBY of View
	(properties
		noun 16
		x 462
		y 247
		view 5204
	)

	(method (init)
		(if (== (proc70_9 93) 5202)
			(super init: global117 &rest)
			(self setHotspot: 2 144)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 93)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walls_45 of Feature
	(properties
		noun 32
		x 295
		y 90
		nsBottom 181
		nsRight 590
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
					init: 234 21 238 23 248 23 249 19 256 18 258 22 273 22 276 15 280 15 282 20 300 19 304 15 332 75 374 140 407 173 429 194 422 202 416 199 411 206 422 214 424 228 423 235 411 236 400 227 396 228 392 232 394 238 390 243 385 244 382 248 384 255 379 260 376 260 372 265 374 270 319 264 320 261 314 256 307 257 301 253 295 259 294 263 257 260 234 218 203 173 174 139
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
					init: 0 1 590 -1 589 189 517 190 437 184 368 185 337 181 265 181 235 180 195 181 164 181 81 180 -1 180
					yourself:
				)
		)
	)
)

(instance exit_135 of Feature
	(properties
		noun 2
		x 251
		y 134
		nsBottom 181
		nsLeft 238
		nsRight 265
		nsTop 87
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 288 23 404 80 399 80 400 93 405 94 405 101 401 104 402 116 408 120 407 126 404 127 404 143 408 143 408 154 403 154 369 170 322 199 277 232 235 275 220 266 222 260 217 256 210 264 192 270 188 266 186 252 196 246 196 242 189 236 185 239 179 234 180 229 174 225 169 229 165 225 164 220 158 215 154 217 157 165 164 164 168 159 168 156 165 152 168 147 169 144 165 140 160 139 164 107 205 85 258 50
					yourself:
				)
		)
	)
)

(instance walls_225 of Feature
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
					init: 0 0 591 0 589 184 151 182 150 184 -2 185
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
					init: 217 19 270 23 271 28 278 36 284 31 291 36 296 32 296 26 336 30 368 89 416 150 356 269 353 266 343 267 342 271 335 271 334 267 318 268 316 274 310 273 308 270 291 270 290 273 287 273 256 207 218 154 161 99 167 87 174 91 178 84 169 76 165 58 168 55 180 55 187 62 194 62 198 58 196 52 200 46 205 45 209 40 206 35 210 29 215 29 219 25
					yourself:
				)
		)
	)
)

(instance walls_315 of Feature
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
					init: -1 0 590 -1 589 180 388 181 388 184 306 186 273 184 225 184 175 183 -1 184
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
					init: 355 13 370 22 367 30 372 33 381 24 398 20 403 24 403 34 395 43 394 48 401 55 406 52 409 55 410 57 417 64 422 60 426 64 428 68 433 74 438 72 433 126 430 126 425 130 422 132 426 137 422 145 428 149 430 151 426 181 398 198 360 221 335 240 303 267 188 210 191 207 191 197 186 195 186 189 190 186 187 172 182 168 182 165 187 163 187 149 184 147 183 136 214 122 275 87 318 54
					yourself:
				)
		)
	)
)

