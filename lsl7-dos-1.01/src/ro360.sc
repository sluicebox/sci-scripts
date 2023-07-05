;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use foEExit)
(use Plane)
(use Scaler)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	ro360 0
)

(local
	local0
)

(instance ro360 of L7Room
	(properties
		picture 36000
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 84) ; oFlags
			(= picture 36100)
		)
		(switch gPrevRoomNum
			(363 ; ro363
				(gEgo
					init:
					normalize:
					view: 36105
					loop: 0
					cel: 99
					posn: 605 435
				)
			)
			(370 ; ro370
				(gEgo
					init:
					normalize: 2
					setScaler: Scaler 48 32 479 324
					posn: 320 325
				)
			)
			(else
				(gEgo
					init:
					normalize: 3
					setScaler: Scaler 48 32 479 324
					posn: 327 454
				)
			)
		)
		(super init:)
		(gGame handsOff:)
		(if (not (OneOf gPrevRoomNum 340 360 363)) ; ro340, ro360, ro363
			(gOMusic1 setMusic: 34000)
		)
		(if ((ScriptID 64017 0) test: 84) ; oFlags
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 204 385 179 403 2 422 2 476 440 476 438 460 357 460 362 432 468 412 623 440 623 406 609 387 465 369 390 395 353 324 285 324 251 399
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((= local0 (Polygon new:))
						type: PContainedAccess
						init: 204 385 179 403 2 422 2 476 498 476 434 434 531 408 422 389 390 395 353 324 285 324 251 399
						yourself:
					)
			)
		)
		(if ((ScriptID 64017 0) test: 84) ; oFlags
			(foRubble init:)
			(foLadder init:)
		else
			(foVenus init:)
			(foVenusFoot init:)
			(poSculptor init:)
		)
		(if ((ScriptID 64017 0) test: 85) ; oFlags
			(voMagnet init:)
		)
		(poTikiFire init:)
		(poNeonSigns init:)
		(foDavid init:)
		(foDavidFoot init:)
		(foDavidGroin init:)
		(foSpike init:)
		(foLeftSpike init:)
		(foLadyLuck init:)
		(foLeftTiki init:)
		(foRightTiki init:)
		(foScaffold init:)
		(foSign1 init:)
		(foSign2 init:)
		(foSign3 init:)
		(if (not ((ScriptID 64017 0) test: 233)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 167 447
				setDest: -40 447
				loop: 1
				cel: 0
				setScaleDirect: 31
				setPri: 447
				nMyFlag: 233
				oAltScript: soDildo
				init:
			)
		)
		(foDoor init:)
		(foExitSouth init:)
		(if (== gPrevRoomNum 363) ; ro363
			(gCurRoom setScript: soClimbDownLadder)
		else
			(gGame handsOn:)
		)
	)

	(method (notify)
		(foSpike doVerb: 35)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 330 340 341 360 363)) ; ro330, ro340, ro341, ro360, ro363
			(gOMusic1 fadeOut:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance soTakeCards of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poLarryArm init: cel: 0 posn: 334 411 setCycle: CT 8 1 self)
				(gMessager say: 17 8 0 1 self) ; "(SNEAKY) Nobody will ever miss a couple of these playing cards."
			)
			(1 0)
			(2
				(poLarryArm setCycle: Beg self)
				(gMessager say: 17 8 0 2 self) ; "Darn. Glued tight!"
			)
			(3 0)
			(4
				(poLarryArm dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeDice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 15 8 0 1) ; "(SNEAKY) Nobody will ever miss a couple of these dice."
				(poLarryArm init: posn: 385 411 setCycle: End self 8 999)
			)
			(1
				(gOSound1 playSound: 36201)
				(voDice dispose:)
			)
			(2
				(if (gTalkers isEmpty:)
					(= cycles 1)
				else
					(-- state)
					(= ticks 60)
				)
			)
			(3
				(poLarryArm dispose:)
				(gCurRoom drawPic: 36400)
				(poLarry init: doit:)
				(= ticks 60)
			)
			(4
				(gOSound1 playSound: 36401 self)
				(= ticks 30)
			)
			(5
				(poFallingDice init: setCycle: End self)
			)
			(6
				(poFallingDice loop: 3 cel: 0 posn: 564 309 setCycle: End self)
			)
			(7
				(poLarry setCycle: End)
				(gMessager say: 15 8 0 2) ; "(AS THE VENUS CRUMBLES TO THE GROUND; SOFTLY, HOPING NO ONE NOTICES) Ooooops."
				(poFallingDice loop: 2 cel: 0 posn: 303 309 setCycle: End self)
			)
			(8
				(poFallingDice loop: 3 cel: 0 posn: 414 309 setCycle: End self)
			)
			(9 0)
			(10
				((ScriptID 64017 0) set: 84) ; oFlags
				(gEgo posn: 423 466 get: ((ScriptID 64037 0) get: 42)) ; oInvHandler, ioSouvenirDice
				(poLarry dispose:)
				(poFallingDice dispose:)
				(foVenus dispose:)
				(foVenusFoot dispose:)
				(gCurRoom deleteRoomPlane: oVenusCUPlane)
				((gCurRoom obstacles:) delete: local0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 204 385 179 403 2 422 2 476 440 476 438 460 357 460 362 432 468 412 623 440 623 406 609 387 465 369 390 395 353 324 285 324 251 399
							yourself:
						)
				)
				(poSculptor setScript: soSculptorCries)
				(foRubble init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soSculptor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: ForwardCounter (Random 3 6) self)
			)
			(1
				(= ticks (Random 60 240))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance soSculptorCries of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 36101) ; WAVE
				(client setCycle: 0)
				(= ticks 30)
			)
			(1
				(client view: 36100 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(oCrySFX playSound: 36101)
				(client
					loop: 1
					cel: 0
					setCycle: ForwardCounter (Random 3 5) self
				)
			)
			(3
				(= ticks (Random 10 60))
			)
			(4
				(self changeState: (- state 2))
			)
		)
	)
)

(instance soClimbLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 605 435 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gEgo
					view: 36105
					loop: 0
					cel: 0
					setScale: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(4
				(gEgo setSpeed: register)
				(gCurRoom newRoom: 363) ; ro363
				(self dispose:)
			)
		)
	)
)

(instance soClimbDownLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(gEgo cycleSpeed: 6 setCycle: Beg self)
			)
			(2
				(gEgo
					normalize: 1
					setScaler: Scaler 48 32 479 324
					setSpeed: register
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soMagnetize of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 36102 36103 36104 36105) ; WAVE
				(gOSound1 setAmbient: 36102)
				(= ticks 60)
			)
			(1
				(oSFX playSound: 36104)
				(poMagneticDie init: setMotion: MoveTo 541 16)
				(poMagneticThing2 init: setMotion: MoveTo 541 16)
				(poMagneticThing3 init: setMotion: MoveTo 541 16)
				(poMagneticThing4 init: setMotion: MoveTo 541 16 self)
			)
			(2
				(oSFX stop:)
				(= ticks 60)
			)
			(3
				(gOSound1 playSound: 36103)
				(poMagneticDie setStep: 6 6 setMotion: MoveTo 541 52)
				(poMagneticThing2 setStep: 6 6 setMotion: MoveTo 541 52)
				(poMagneticThing3 setStep: 6 6 setMotion: MoveTo 541 52)
				(poMagneticThing4 setStep: 6 6 setMotion: MoveTo 541 52 self)
			)
			(4
				(gOSound1 playSound: 36105)
				(poMagneticDie dispose:)
				(poMagneticThing2 dispose:)
				(poMagneticThing3 dispose:)
				(poMagneticThing4 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soDildo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 50 0) ; oDildo
					setSpeed: 10
					setStep: 6 30
					setCycle: Walk
					setMotion: MoveTo -40 447 self
				)
			)
			(1
				((ScriptID 50 0) setStep: 6 30) ; oDildo
				(self dispose:)
			)
		)
	)
)

(instance poSculptor of Prop
	(properties
		noun 4
		priority 480
		x 472
		y 108
		view 36000
		approachDist 1000
		fixPriority 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4 setScript: soSculptor)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(38 ; Souvenir Dice
				(if ((ScriptID 64017 0) test: 84) ; oFlags
					(gMessager say: noun theVerb 2) ; "Taunt Sculptor Bob with the very weapon of his demise? Suddenly, larry Laffer, your cruel side begins to show!"
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if ((ScriptID 64017 0) test: 84) ; oFlags
					(gMessager say: noun theVerb 2) ; "Sculptor Bob seems more than just a little distraught. He'd prefer to be alone... with his shattered dreams."
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Talk
				(if ((ScriptID 64017 0) test: 84) ; oFlags
					(gMessager say: noun 1 2) ; "Sculptor Bob seems more than just a little distraught. He'd prefer to be alone... with his shattered dreams."
				else
					(gMessager say: noun theVerb 1) ; "Hello? Excuse me? Mr. Sculptor, sir? (TO SELF) Guess he's busy."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poTikiFire of Prop
	(properties
		x 318
		y 258
		view 36101
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance poLarry of Prop
	(properties
		x 348
		y 280
		loop 1
		view 36400
	)

	(method (init)
		(poLarryBody init:)
		(super init:)
		(self setPri: (+ (poLarryBody priority:) 1))
	)

	(method (dispose)
		(poLarryBody dispose:)
		(super dispose:)
	)
)

(instance poLarryBody of Prop
	(properties
		x 348
		y 280
		view 36400
	)
)

(instance poFallingDice of Prop
	(properties
		x 319
		y 309
		loop 2
		view 36400
	)
)

(instance poMagneticDie of Actor
	(properties
		x 612
		y 459
		view 36110
		moveSpeed 1
	)

	(method (init)
		(self
			posn: 650 459
			setLoop: 0 1
			setScaler: Scaler 100 44 459 16
			setSpeed: 1
			setStep: 45 45
			setPri: 500
		)
		(super init:)
	)
)

(instance poMagneticThing2 of Actor
	(properties
		x 354
		y 451
		loop 1
		view 36110
		moveSpeed 1
	)

	(method (init)
		(self
			posn: 354 490
			setLoop: 1 1
			setScaler: Scaler 100 44 459 16
			setSpeed: 1
			setStep: 45 45
			setPri: 500
		)
		(super init:)
	)
)

(instance poMagneticThing3 of Actor
	(properties
		x 245
		y 455
		loop 2
		view 36110
		moveSpeed 1
	)

	(method (init)
		(self
			posn: 245 490
			setLoop: 2 1
			setScaler: Scaler 100 44 459 16
			setSpeed: 1
			setStep: 45 45
			setPri: 500
		)
		(super init:)
	)
)

(instance poMagneticThing4 of Actor
	(properties
		x 112
		y 445
		loop 3
		view 36110
		moveSpeed 1
	)

	(method (init)
		(self
			posn: -10 445
			setLoop: 3 1
			setScaler: Scaler 100 44 459 16
			setSpeed: 1
			setStep: 45 45
			setPri: 500
		)
		(super init:)
	)
)

(instance voMagnet of View
	(properties
		noun 5
		x 537
		y 17
		view 36115
		approachDist 1000
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(foSpike doVerb: theVerb)
	)
)

(instance poNeonSigns of Prop
	(properties
		x 319
		y 189
		cycleSpeed 40
		view 36050
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance foVenus of Feature
	(properties
		noun 2
		x 529
		y 169
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 477 279 485 231 508 201 504 183 487 191 482 186 481 140 508 122 507 108 488 87 498 63 526 59 539 82 533 109 559 117 576 118 581 132 571 205 581 266 570 279
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foVenusFoot of Feature
	(properties
		noun 10
		x 536
		y 432
		approachX 423
		approachY 466
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 593 463 581 426 584 390 583 373 492 374 509 426 510 447 501 447 487 458 504 463 543 469 550 475 575 476
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom addRoomPlane: oVenusCUPlane)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foRubble of Feature
	(properties
		noun 14
		x 496
		y 373
		approachX 394
		approachY 415
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 368 448 453 391 472 367 504 284 516 276 532 279 553 314 575 333 578 347 604 408 624 462 585 470 522 468 504 456 472 462 455 448
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLadder of ExitFeature
	(properties
		x 576
		y 216
		approachX 530
		approachY 408
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 587 368 583 306 562 311 544 179 566 174 559 117 582 112 569 75 560 55 551 21 571 21 577 55 588 57 603 107 579 128 584 178 562 186 581 297 598 292 607 357 609 412
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soClimbLadder)
	)
)

(instance foDavid of Feature
	(properties
		noun 3
		x 124
		y 457
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 67 463 76 433 55 369 57 339 48 313 38 315 23 299 14 277 14 219 27 142 60 128 63 117 51 82 59 52 90 45 111 53 110 72 96 119 104 117 116 111 128 114 164 170 167 199 149 195 125 173 119 235 138 334 141 348 117 358 87 299 83 358 90 373 93 430 99 438 95 465 76 469
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foDavidFoot of Feature
	(properties
		noun 16
		x 124
		y 457
		approachX 227
		approachY 449
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 182 473 185 457 171 446 162 430 160 404 148 404 137 406 148 439 148 446 157 458 165 472 175 476
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 17 1) ; "The David o' Cards is no "house of cards." It's glued tightly together."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foDavidGroin of Feature
	(properties
		noun 18
		x 85
		y 460
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 59 247 111 246 111 289 59 289
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSpike of Feature
	(properties
		noun 5
		x 542
		y 105
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 530 4 554 4 553 26 533 27
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(((ScriptID 64017 0) test: 85) ; oFlags
						(gMessager say: noun theVerb 5) ; "Yes, the Juggs' chase lights are still wrapped around the iron spike. You pretend to be proud of yourself."
					)
					(((ScriptID 64017 0) test: 83) ; oFlags
						(gMessager say: noun theVerb 4) ; "Yes, that iron spike is protruding through the casino lobby ceiling."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(35 ; Remote Control
				(if ((ScriptID 64017 0) test: 85) ; oFlags
					((ScriptID 64017 0) set: 82) ; oFlags
					(gMessager say: 38 62 1 0 0 11) ; "Cool."
					(gCurRoom setScript: soMagnetize)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foLeftSpike of Feature
	(properties
		noun 5
		x 30
		y 16
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 33 31 33 31 40 1 20 0 26 33
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(((ScriptID 64017 0) test: 85) ; oFlags
						(gMessager say: noun theVerb 5) ; "Yes, the Juggs' chase lights are still wrapped around the iron spike. You pretend to be proud of yourself."
					)
					(((ScriptID 64017 0) test: 83) ; oFlags
						(gMessager say: noun theVerb 4) ; "Yes, that iron spike is protruding through the casino lobby ceiling."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(35 ; Remote Control
				(if ((ScriptID 64017 0) test: 85) ; oFlags
					(gMessager say: 38 62 1 0 0 11) ; "Cool."
					(gCurRoom setScript: soMagnetize)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foLadyLuck of Feature
	(properties
		noun 9
		x 317
		y 141
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 316 50 341 50 353 64 360 89 348 112 382 153 377 159 332 164 332 179 356 230 316 221 281 232 309 179 307 162 253 161 293 110 280 84 298 54
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLeftTiki of Feature
	(properties
		noun 7
		x 236
		y 323
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 267 245 264 262 268 267 357 251 383 216 383 205 374 211 314
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRightTiki of Feature
	(properties
		noun 8
		x 401
		y 323
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 392 263 415 267 420 293 429 292 425 312 430 324 431 378 415 383 387 383 372 356 376 268
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foScaffold of Feature
	(properties
		noun 1
		x 538
		y 100
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 630 469 630 404 632 362 621 339 613 304 615 260 617 219 614 145 616 108 593 62 571 21 545 16 525 26 523 45 465 72 469 109 445 114 450 217 452 267 448 311 456 360 450 368 452 405 451 415 456 445 484 460 489 66 524 59 544 111 576 119 571 302 589 462
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 64017 0) test: 84) ; oFlags
					(gMessager say: noun theVerb 2) ; "The scaffold may look rickety, but in fact, it's INCREDIBLY rickety! Is your life insurance paid up?"
				else
					(gMessager say: noun theVerb 1) ; "Bob Bitt the sculptor wouldn't appreciate you climbing up his scaffold and disturbing him while he's completing his masterpiece."
				)
			)
			(81 ; Climb
				(cond
					(
						(and
							((ScriptID 64017 0) test: 84) ; oFlags
							(gCast contains: poSculptor)
						)
						(gMessager say: 4 1 2) ; "Sculptor Bob seems more than just a little distraught. He'd prefer to be alone... with his shattered dreams."
					)
					(((ScriptID 64017 0) test: 84) ; oFlags
						(foLadder doVerb:)
					)
					(else
						(gMessager say: 1 1 1) ; "Bob Bitt the sculptor wouldn't appreciate you climbing up his scaffold and disturbing him while he's completing his masterpiece."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foSign1 of Feature
	(properties
		noun 11
		x 573
		y 470
		approachX 364
		approachY 466
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 581 450 581 435 566 439 566 455
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSign2 of Feature
	(properties
		noun 12
		x 502
		y 470
		approachX 364
		approachY 466
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 510 448 510 431 495 424 495 440
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSign3 of Feature
	(properties
		noun 13
		x 472
		y 470
		approachX 364
		approachY 466
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 481 437 481 419 463 410 464 427
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foDoor of ExitFeature
	(properties
		x 319
		y 273
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 246 284 233 308 225 334 226 358 235 364 246 358 261 369 272 368 287 355 305 355 321 282 322 282 302 272 285 269 271 280 261
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 370 320 325 1)
	)
)

(instance foExitSouth of ExitFeature
	(properties
		x 251
		y 464
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 450 455 450 502 479 0 479
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 340 324 475 1)
	)
)

(instance oVenusCUPlane of Plane
	(properties
		picture 36200
	)

	(method (init)
		(Load rsPIC 36400)
		(Load rsVIEW 36200 36400)
		(Load 140 36201 36401) ; WAVE
		(gThePlane drawPic: -1)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(voDice init:)
		(foToes init:)
		(foExitVenus init:)
	)

	(method (dispose)
		(if ((ScriptID 64017 0) test: 84) ; oFlags
			(gThePlane drawPic: 36100)
		else
			(gThePlane drawPic: 36000)
		)
		(super dispose: &rest)
	)
)

(instance voDice of View
	(properties
		noun 15
		x 328
		y 422
		view 36250
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gCurRoom setScript: soTakeDice)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foToes of Feature
	(properties
		noun 15
		x 357
		y 256
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 314 152 252 344 87 564 155 566 253 519 300 502 293 495 300 482 290 328 425 210 366 208 341
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gCurRoom setScript: soTakeDice)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poLarryArm of Prop
	(properties
		x 385
		y 411
		view 36200
	)
)

(instance foExitVenus of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oVenusCUPlane)
	)
)

(instance oCrySFX of TPSound
	(properties)
)

(instance oSFX of TPSound
	(properties)
)

