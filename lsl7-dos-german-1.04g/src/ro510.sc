;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 510)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use foEExit)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro510 0
)

(instance ro510 of L7Room
	(properties
		picture 51000
	)

	(method (init)
		(gEgo
			init:
			normalize: 3
			setScaler: Scaler 150 100 451 207
			posn: 369 457
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 527 477 527 416 633 416 633 365 507 364 507 238 630 239 629 216 540 174 542 225 405 225 379 212 186 202 4 257 5 362 196 396 235 459 266 478
					yourself:
				)
		)
		(if (not ((ScriptID 64017 0) test: 130)) ; oFlags
			(voOrgasmPowder init:)
		)
		(voBottle init:)
		(voBottles init:)
		(poOcean init:)
		(poFountain init:)
		(foBoat init:)
		(foBoatLights init:)
		(foChest init:)
		(foChair init:)
		(foTable init:)
		(foHottub init:)
		(foMermaid init:)
		(foPorthole1 init:)
		(foPorthole2 init:)
		(foVase init:)
		(foExit init:)
		(if ((ScriptID 64017 0) test: 131) ; oFlags
			(gOMusic1 setMusic: 38000)
			(gGame handsOn:)
		else
			(= global335 toDewmi)
			(voDewmi init:)
			(self setScript: soFirstTime)
			((ScriptID 64017 0) set: 18) ; oFlags
		)
	)

	(method (dispose)
		(= global335 0)
		(super dispose:)
	)
)

(instance soFirstTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo setHeading: 315)
				(= ticks 60)
			)
			(2
				(gMessager sayRange: 0 0 3 1 2 self) ; "How 'bout a drink, Larry?"
			)
			(3
				(gMessager say: 0 0 3 3 self) ; "Okay. Sit down."
				(gEgo walkTo: 216 199)
			)
			(4
				(gCurRoom newRoom: 511) ; roLiarsRoom
				(self dispose:)
			)
		)
	)
)

(instance soMotion of OceanMotionSin
	(properties
		nCenterY 132
		nRange 12
	)
)

(instance voDewmi of View
	(properties
		x 208
		y 241
		view 51005
	)
)

(instance voOrgasmPowder of View
	(properties
		noun 17
		x 63
		y 151
		view 51011
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				((ScriptID 64017 0) set: 130) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 28)) ; oInvHandler, ioOrgasmPowder
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voBottle of View
	(properties
		x 63
		y 142
		view 51010
	)
)

(instance voBottles of View
	(properties
		x 70
		y 130
		loop 1
		view 51010
	)
)

(instance poFountain of Prop
	(properties
		priority 600
		x -5
		y 257
		view 51098
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poOcean of Prop
	(properties
		priority 1
		x 106
		y 132
		view 51099
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: soMotion)
	)
)

(instance foBoat of Feature
	(properties
		noun 15
		x 586
		y 273
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 535 194 540 189 602 242 638 244 637 357 610 325 606 294 601 288 595 287 599 267 591 263 589 241
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBoatLights of Feature
	(properties
		noun 14
		x 598
		y 167
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 557 202 639 119 639 147 569 215
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChest of Feature
	(properties
		noun 7
		x 584
		y 424
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 531 477 534 427 561 390 637 370 638 478
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChair of Feature
	(properties
		noun 12
		x 461
		y 138
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 498 52 508 63 508 70 516 73 519 89 523 95 514 119 517 128 491 165 474 175 478 183 473 189 464 183 461 202 479 206 485 216 477 224 455 224 452 214 437 223 423 223 419 213 425 200 434 211 442 210 442 177 429 185 423 171 399 156 428 137 456 136 449 113 454 106 453 85 460 82 466 83 472 62 483 68
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foTable of Feature
	(properties
		noun 10
		x 327
		y 129
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 192 127 209 117 254 108 317 105 385 111 452 122 463 150 361 154 252 145 194 134
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHottub of Feature
	(properties
		noun 5
		x 87
		y 430
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 381 47 384 117 398 172 416 175 448 168 477 0 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foMermaid of Feature
	(properties
		noun 1
		x 130
		y 435
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 97 182 124 216 138 258 156 271 155 287 150 293 164 304 160 323 152 327 147 342 150 350 144 363 129 370 129 376 167 356 200 350 209 357 203 383 184 431 204 428 206 439 229 438 244 447 240 465 231 472 241 478 254 473 254 464 261 464 259 477 202 478 210 465 203 455 193 453 181 463 171 461 171 417 161 413 141 438 117 443 106 447 69 446 49 432 42 397 64 380 67 387 61 393 69 411 80 388 67 366 89 341 81 331 52 366 43 358 38 292 15 304 0 293 2 263 7 261 4 247 17 219 25 238 24 247 33 245 26 231 37 200 59 192 72 205
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPorthole1 of Feature
	(properties
		noun 13
		x 220
		y 41
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 177 56 196 37 217 0 230 0 247 24 263 40 256 47 250 47 251 58 242 64 242 74 220 83 193 77
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPorthole2 of Feature
	(properties
		noun 13
		x 425
		y 40
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 379 49 400 26 418 0 442 0 473 46 465 61 449 75 420 80 389 69 378 48
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foVase of Feature
	(properties
		noun 6
		x 23
		y 139
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 27 19 40 28 46 48 42 66 26 82 31 102 35 103 29 114 30 120 24 123 23 136 33 136 28 143 14 148 1 140 10 138 9 123 4 126 0 116 5 87 7 81 0 79 0 19
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExit of ExitFeature
	(properties
		x 613
		y 187
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

(instance toDewmi of Talker
	(properties)

	(method (init)
		(= x (voDewmi x:))
		(= y (voDewmi y:))
		(super init: poDewmiMouth)
	)
)

(instance poDewmiMouth of Prop
	(properties
		loop 1
		view 51005
	)

	(method (init)
		(= x (voDewmi x:))
		(= y (voDewmi y:))
		(self setPri: (+ (voDewmi priority:) 1))
		(super init: &rest)
	)
)

