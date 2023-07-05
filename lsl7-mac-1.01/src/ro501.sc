;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
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
	ro501 0
)

(instance ro501 of L7Room
	(properties
		picture 50100
	)

	(method (init)
		(gEgo
			init:
			normalize: 3
			setScaler: Scaler 149 119 454 348
			posn: 314 446
		)
		(super init:)
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
				(gCurRoom newRoom: 500) ; ro500
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
		y 50
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
					init: 637 444 501 340 143 338 1 418 1 479 639 479
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
		x 324
		y 251
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 325 279 345 273 351 252 347 231 328 223 309 231 297 252 306 269
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
		x 312
		y 59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 623 0 616 28 598 36 581 37 572 61 558 77 523 85 479 86 454 82 444 75 430 57 417 57 413 61 406 63 403 57 383 57 370 51 309 53 196 56 189 48 187 39 185 39 178 43 171 43 170 38 150 36 138 27 129 27 126 32 133 38 134 46 124 50 125 83 132 83 138 77 149 77 160 92 155 107 148 112 139 115 135 113 110 119 101 102 96 51 89 45 89 39 77 47 67 46 52 44 55 59 47 73 26 86 18 89 11 94 2 98 2 1
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
		x 307
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 307 190 320 189 336 173 331 150 320 138 301 138 287 147 278 165 285 183 297 191
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
		x 300
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

