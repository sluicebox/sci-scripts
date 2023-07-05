;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8241)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm8241 0
)

(instance rm8241 of ExitRoom
	(properties
		picture 8241
		south 820 ; rm820
	)

	(method (init)
		(super init: &rest)
		(medals init:)
		(plaque init:)
	)
)

(instance medals of GKFeature
	(properties
		noun 15
		modNum 820
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -5 45 157 47 150 74 71 73 40 166 -4 200
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 126 283 437 273 450 318 113 318
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 251 45 243 102 134 102 120 170 457 170 476 309 516 320 560 296 589 316 618 269 619 190 514 190 500 159 532 171 550 150 515 98 592 95 570 38 400 45 415 92 504 97 498 155 455 165 442 120 383 120 358 106 321 102 318 45
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 149 198 215 200 208 254 142 252
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 39 250 72 252 88 263 90 295 66 319 32 326 11 311 14 279
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 68 171 30 221 50 237 95 217 96 192 82 168
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance plaque of GKFeature
	(properties
		nextRoomNum 8251 ; rm8251
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 177 407 177 415 264 236 264
					yourself:
				)
		)
		(super init: &rest)
	)
)

