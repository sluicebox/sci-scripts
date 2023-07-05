;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5213)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	NY_Human_Plaza_13 0
)

(instance NY_Human_Plaza_13 of Location
	(properties
		noun 32
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5212 ; humanPlazaRm12
				(self addPicObj: faceE faceW faceE)
			)
			(5214 ; NY_Human_Plaza_14
				(self addPicObj: faceE faceW faceE)
			)
			(else
				(self addPicObj: faceW faceE faceW)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5236
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(mazeCard init:)
		(mazePiston init:)
		(mazeLights init:)
		(exitToMazeCtrl init:)
		(mazeCtrl_90 init:)
		(mazeMap_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5235
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom12 init:)
		(walls_270 init:)
		(super init: &rest)
	)
)

(instance exitToRoom12 of ExitFeature
	(properties
		nsLeft 258
		nsTop 80
		nsRight 370
		nsBottom 224
		nextRoom 5212
	)
)

(instance exitToMazeCtrl of Feature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 292 118 349 125 425 194 428 237 419 288 157 287 154 195 227 131
					yourself:
				)
			setHotspot: 2 46
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5214) ; NY_Human_Plaza_14
			)
			(46
				(gCurRoom newRoom: 5214) ; NY_Human_Plaza_14
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mazeCard of View
	(properties
		x 283
		y 229
		view 5222
		loop 2
	)

	(method (init)
		(if (== (proc70_9 47) 5214)
			(super init: global117 &rest)
		)
	)
)

(instance mazePiston of View
	(properties
		x 215
		y 203
		view 5222
	)

	(method (init)
		(= cel global256)
		(super init: global117 &rest)
	)
)

(instance mazeLights of View
	(properties
		view 5222
		loop 1
	)

	(method (init)
		(if (== (proc70_9 47) 5214)
			(switch (= cel global256)
				(0
					(self posn: 240 177)
				)
				(1
					(self posn: 260 177)
				)
				(2
					(self posn: 282 177)
				)
				(3
					(self posn: 302 177)
				)
				(4
					(self posn: 322 177)
				)
			)
			(super init: global117 &rest)
		)
	)
)

(instance walls_270 of Feature
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
					init: 1 0 591 0 592 290 415 289 369 248 370 205 260 203 157 290 0 291
					yourself:
				)
		)
	)
)

(instance mazeMap_90 of Feature
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
					init: 239 8 347 8 376 25 398 28 420 55 399 76 375 80 345 102 239 100 210 79 187 78 164 54 187 27 218 29
					yourself:
				)
		)
	)
)

(instance mazeCtrl_90 of Feature
	(properties
		noun 3
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 253 124 290 120 343 125 360 134 358 152 370 169 376 181 379 188 401 187 404 196 425 194 431 214 426 235 423 237 422 257 421 279 406 290 176 290 160 282 159 273 164 253 162 238 157 235 152 229 153 206 160 195 175 195 179 187 192 188 197 193 207 175 217 160 225 150 224 135
					yourself:
				)
		)
	)
)

