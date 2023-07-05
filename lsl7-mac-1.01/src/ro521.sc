;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 521)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use foEExit)
(use Scaler)
(use Polygon)
(use Feature)
(use System)

(public
	ro521 0
)

(instance ro521 of L7Room
	(properties
		picture 52100
	)

	(method (init)
		(gEgo
			init:
			normalize: 3
			setScaler: Scaler 149 119 454 348
			posn: 314 446
		)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 178 350 35 434 18 462 615 462 607 453 494 354
					yourself:
				)
		)
		(gOMusic1 setMusic: 38000)
		(foDoor init:)
		(foFloor init:)
		(foHandle init:)
		(foPipes init:)
		(foPorthole init:)
		(foExit init:)
		(gGame handsOn:)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 6)) ; oInvHandler, ioMasterKey
	)
)

(instance soUnlockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gOSound1 playSound: 50101 self)
			)
			(1
				(gCurRoom newRoom: 520) ; ro520
				(self dispose:)
			)
		)
	)
)

(instance foDoor of Feature
	(properties
		noun 1
		approachX 310
		approachY 360
		x 311
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 226 101 397 101 356 341 241 341
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(23 ; Custodial Key
				((ScriptID 64017 0) set: 133) ; oFlags
				(gCurRoom setScript: soUnlockDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foFloor of Feature
	(properties
		noun 5
		x 320
		y 408
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 639 479 639 444 502 339 146 338 1 419 1 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHandle of Feature
	(properties
		noun 2
		approachX 310
		approachY 360
		x 325
		y 251
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 325 280 330 269 337 269 343 273 348 269 341 264 344 254 350 254 352 249 349 248 342 248 340 239 346 235 346 229 340 228 334 235 329 234 330 223 327 221 322 225 323 233 316 235 311 230 308 230 308 235 311 239 308 248 300 249 298 254 304 257 308 254 311 264 306 268 305 271 311 272 316 267 322 270 322 277 325 281
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 220)
		(self addApproachVerb: 220)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(23 ; Custodial Key
				(foDoor doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foPipes of Feature
	(properties
		noun 4
		x 311
		y 58
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 622 2 618 22 608 33 581 38 571 65 558 77 535 84 472 86 452 82 436 68 432 58 417 57 413 63 409 63 404 63 403 58 382 57 375 53 193 55 187 48 187 38 184 39 178 43 173 43 170 39 150 36 147 36 141 27 133 27 125 28 126 35 133 38 133 47 124 50 127 84 131 85 137 78 144 77 155 83 158 97 154 110 148 113 136 115 135 113 114 117 106 111 99 89 95 51 90 46 90 40 84 40 77 47 69 45 64 44 52 44 52 63 37 80 26 86 17 88 10 95 1 99 2 0
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPorthole of Feature
	(properties
		noun 3
		approachX 310
		approachY 360
		x 310
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 307 192 322 189 332 177 336 162 331 147 318 137 300 137 287 145 279 158 279 170 285 183 300 191 304 193
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 221)
		(self addApproachVerb: 221)
	)
)

(instance foExit of ExitFeature
	(properties
		x 613
		y 500
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 429 639 429 639 479 0 479
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 13)) ; oMapCursor
	)

	(method (doVerb)
		((ScriptID 90 0) init:) ; oTravelScreen
	)
)

