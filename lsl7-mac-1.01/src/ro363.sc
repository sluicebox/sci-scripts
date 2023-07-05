;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 363)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use foEExit)
(use Talker)
(use RandCycle)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	ro363 0
)

(instance ro363 of L7Room
	(properties
		picture 36300
	)

	(method (init)
		(gEgo
			view: 36300
			loop: 0
			cel: 0
			init:
			setScale: 0
			setPri: 500
			posn: 463 205
			state: (& (gEgo state:) $fffd)
		)
		((ScriptID 64017 0) set: 204) ; oFlags
		((ScriptID 64017 0) set: 83) ; oFlags
		(super init:)
		(= global330 toLarry)
		(foSpike init:)
		(if (not ((ScriptID 64017 0) test: 86)) ; oFlags
			(voScrewdriver init:)
		)
		(if ((ScriptID 64017 0) test: 85) ; oFlags
			(voMagnet init:)
		)
		(foToolBox init:)
		(foScaffold init:)
		(foDown init:)
		(foExit init:)
		(gCurRoom setScript: soClimbLadder)
	)

	(method (notify)
		(if ((ScriptID 64017 0) test: 205) ; oFlags
			((ScriptID 64017 0) clear: 205) ; oFlags
			(gCurRoom setScript: soAttemptWalk)
		else
			(voMagnet doVerb: 35)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 0) ((ScriptID 64037 0) get: 37)) ; oInvHandler, ioChaseLights, oInvHandler, ioRemote
	)

	(method (dispose)
		(= global330 0)
		(gEgo state: (| (gEgo state:) $0002))
		((ScriptID 64017 0) clear: 204) ; oFlags
		(super dispose:)
	)
)

(instance soClimbLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo cycleSpeed: 8 setCycle: End self)
			)
			(2
				(gEgo setScript: soNervous)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soNervous of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 300))
			)
			(1
				(gEgo loop: 1 setCycle: ForwardCounter (Random 3 6) self)
			)
			(2
				(gEgo loop: 0 cel: 99)
				(self changeState: 0)
			)
		)
	)
)

(instance soDownLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScript: 0
					setCycle: 0
					loop: 0
					cel: 99
					setCycle: Beg self
				)
			)
			(1
				(gCurRoom newRoom: 360) ; ro360
				(self dispose:)
			)
		)
	)
)

(instance soMakeMagnet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 36302) ; WAVE
				(gEgo
					setScript: 0
					setCycle: 0
					view: 36305
					loop: 0
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(gMessager say: 1 34) ; "I think I can just barely reach it from here...."
				(gEgo setCycle: CT 18 1 self)
			)
			(2
				(gOSound1 playSound: 36302 self)
				(gEgo setCycle: RangeRandCycle -1 18 22)
			)
			(3
				(voMagnet init:)
				(gEgo cel: 23 setCycle: End self)
			)
			(4
				((ScriptID 64017 0) set: 85) ; oFlags
				(gEgo
					view: 36300
					loop: 0
					cel: 99
					put: ((ScriptID 64037 0) get: 0) ; oInvHandler, ioChaseLights
					setScript: soNervous
				)
				(= cycles 1)
			)
			(5
				(if (gTalkers isEmpty:)
					(gGame handsOn:)
					(self dispose:)
				else
					(-- state)
					(= cycles 3)
				)
			)
		)
	)
)

(instance soAttracted of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global330 0)
				(Load 140 36102 36103) ; WAVE
				(gEgo
					setScript: 0
					setCycle: 0
					view: 36306
					loop: 0
					cel: 0
					setCycle: End self 7 11 27 999
				)
			)
			(1
				(gOSound1 setAmbient: 36102)
			)
			(2
				(gMessager say: 0 35 2) ; "(CHOKING VIA MEDALLION CHAIN) Arrgggh! Cough, sputter, gag."
			)
			(3
				(gOSound1 playSound: 36103)
			)
			(4
				(gMessager kill:)
				((ScriptID 64017 0) set: 82) ; oFlags
				(gEgo view: 36300 loop: 0 cel: 99 setScript: soNervous)
				(= global330 toLarry)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soAttemptWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScript: 0
					setCycle: 0
					view: 36300
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo view: 36300 loop: 0 cel: 99 setScript: soNervous)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voScrewdriver of View
	(properties
		noun 3
		x 383
		y 157
		view 36399
	)

	(method (init)
		(super init: &rest)
		(self setPri: 420)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				((ScriptID 64017 0) set: 86) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 39)) ; oInvHandler, ioScrewdriver
				(foToolBox case: 4)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voMagnet of View
	(properties
		noun 1
		case 2
		x 261
		y 120
		view 36307
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35 ; Remote Control
				(gCurRoom setScript: soAttracted)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foSpike of Feature
	(properties
		noun 1
		x 388
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 292 4 239 115 318 124 383 28
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(34 ; Battery Powered Chase Lights
				(gCurRoom setScript: soMakeMagnet)
			)
			(1 ; Look
				(if ((ScriptID 64017 0) test: 85) ; oFlags
					(gMessager say: noun theVerb 2) ; "The chase light-wrapped steel spike would look sorta Christmas-y if it were green and cone-shaped and sticking up through the floor, but instead, it's steel and pointy and sticking down through the ceiling."
				else
					(gMessager say: noun theVerb) ; "From up here it's easy to see a large steel spike has been driven right through the ship's deck from above."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foToolBox of Feature
	(properties
		noun 2
		case 3
		x 379
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 341 155 341 145 354 139 341 115 344 113 361 138 377 130 395 128 418 136 417 164 390 178 365 170 364 159 341 156
					yourself:
				)
		)
		(if ((ScriptID 64017 0) test: 86) ; oFlags
			(= case 4)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(if ((ScriptID 64017 0) test: 86) ; oFlags
					(super doVerb: theVerb)
				else
					(voScrewdriver doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foScaffold of Feature
	(properties
		noun 4
		x 327
		y 230
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 81 277 87 238 106 237 113 271 234 176 246 146 252 146 266 169 371 169 369 158 410 161 413 145 428 145 427 170 456 187 465 167 479 174 472 191 517 214 524 190 539 197 528 223 547 234 548 221 564 224 559 242 577 244 574 257 448 230 441 263 120 282 94 316 78 304 115 275 189 261 437 245 442 223 417 203 410 244 400 244 407 195 384 176 257 178 267 254 256 254 247 182 190 234 132 270 111 274 83 286
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(foScaffold2 init:)
	)
)

(instance foScaffold2 of Feature
	(properties
		noun 4
		x 251
		y 373
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 465 57 453 70 473 107 438 93 411 131 376 109 298 116 293 130 321 155 392 197 350 190 343 205 317 212 319 218 336 264 333 256 276 270 275 280 342 372 337 379 312 391 312 397 267 408 267 404 333 427 333 421 370 463 428 456 477 425 477 434 434 387 360 381 362 381 393 368 477 359 477 368 386 375 348 276 348 282 373 295 477 284 476 264 349 255 349 224 389 256 469 235 477 219 397 176 457 186 478 50 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foDown of Feature
	(properties
		x 64
		y 378
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 282 74 282 81 317 103 323 127 376 78 417 91 435 69 455 51 443 33 455 33 475 3 475
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		(foDown2 init:)
		(foDown3 init:)
		(foDown4 init:)
		(foDown5 init:)
		(foDown6 init:)
		(foDown7 init:)
	)

	(method (doVerb)
		(gMessager say: 0 0 5) ; "(SCARED OF HEIGHTS) Uhhhh-wooooahhhh! I don't think I've ever been THIS high before!"
	)
)

(instance foDown2 of Feature
	(properties
		x 589
		y 338
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 569 228 635 228 636 449 618 447 593 426 615 380 542 327 561 264 577 264 580 244 568 242
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (doVerb)
		(foDown doVerb:)
	)
)

(instance foDown3 of Feature
	(properties
		x 331
		y 215
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 262 181 380 181 401 198 394 245 274 250
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (doVerb)
		(foDown doVerb:)
	)
)

(instance foDown4 of Feature
	(properties
		x 330
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 273 276 388 268 387 305 372 309 371 331 284 333
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (doVerb)
		(foDown doVerb:)
	)
)

(instance foDown5 of Feature
	(properties
		x 326
		y 403
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 286 354 367 354 357 452 297 453
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (doVerb)
		(foDown doVerb:)
	)
)

(instance foDown6 of Feature
	(properties
		x 204
		y 228
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 157 261 242 196 251 254 yourself:)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (doVerb)
		(foDown doVerb:)
	)
)

(instance foDown7 of Feature
	(properties
		x 194
		y 325
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 290 250 275 261 323 220 326 213 310 186 317 188 346 153 376
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (doVerb)
		(foDown doVerb:)
	)
)

(instance foExit of ExitFeature
	(properties
		x 566
		y 409
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 448 233 513 256 527 341 637 341 637 477 476 476 412 386
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soDownLadder)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(super init: poLarryMouth voLarryBody)
		(gEgo hide:)
	)

	(method (dispose)
		(gEgo show:)
		(super dispose:)
	)
)

(instance poLarryMouth of Prop
	(properties
		view 36308
		loop 1
	)

	(method (init)
		(= x (gEgo x:))
		(= y (- (gEgo y:) 13))
		(self setPri: (+ (gEgo priority:) 2))
		(super init: &rest)
	)
)

(instance voLarryBody of View
	(properties
		view 36308
	)

	(method (init)
		(= x (gEgo x:))
		(= y (gEgo y:))
		(self setPri: (+ (gEgo priority:) 1))
		(super init: &rest)
	)
)

