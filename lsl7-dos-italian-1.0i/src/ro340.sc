;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use foEExit)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro340 0
)

(local
	local0
	local1
	local2
	local3
)

(instance ro340 of L7Room
	(properties)

	(method (init)
		(if ((ScriptID 64017 0) test: 111) ; oFlags
			(= picture 34000)
		else
			(= picture 34005)
		)
		(switch gPrevRoomNum
			(130 ; ro130
				(gEgo
					init:
					posn: 164 300
					normalize: 7
					setScaler: Scaler 38 18 365 285
				)
			)
			(250 ; ro250
				(if ((ScriptID 64017 0) test: 313) ; oFlags
					((ScriptID 64017 0) clear: 313) ; oFlags
					(gEgo
						init:
						posn: 178 301
						normalize:
						setScaler: Scaler 38 18 365 285
					)
				else
					(gEgo
						init:
						posn: 600 49
						normalize: 2
						setScale:
						scaleX: 18
						scaleY: 18
					)
				)
			)
			(330 ; ro330
				(gEgo
					init:
					posn: 42 324
					normalize: 0
					setScaler: Scaler 38 18 365 285
				)
			)
			(341 ; ro341
				(cond
					(((ScriptID 64017 0) test: 180) ; oFlags
						((ScriptID 64017 0) clear: 180) ; oFlags
						(gEgo
							init:
							posn: 110 310
							normalize: 1
							setScaler: Scaler 38 18 365 285
						)
					)
					(((ScriptID 64017 0) test: 181) ; oFlags
						((ScriptID 64017 0) clear: 181) ; oFlags
						(gEgo
							init:
							posn: 257 293
							normalize: 0
							setScaler: Scaler 38 18 365 285
						)
					)
					(else
						(gEgo
							init:
							posn: 164 300
							normalize: 7
							setScaler: Scaler 38 18 365 285
						)
					)
				)
			)
			(360 ; ro360
				(gEgo
					init:
					posn: 597 295
					normalize: 1
					setScaler: Scaler 38 18 365 285
				)
			)
			(430 ; ro430
				(gEgo
					init:
					posn: 294 289
					normalize: 5
					setScaler: Scaler 38 18 365 285
				)
			)
			(else
				(gEgo
					init:
					posn: 178 301
					normalize:
					setScaler: Scaler 38 18 365 285
				)
			)
		)
		(super init:)
		(proc64038_3 1)
		(if (not (OneOf gPrevRoomNum 130 340 341)) ; ro130, ro340, ro341
			(gOMusic1 setMusic: 34000)
		)
		(if (not (OneOf gPrevRoomNum 340 341)) ; ro340, ro341
			(gOSound1 setAmbient: 34002)
		)
		(if (== gPrevRoomNum 250) ; ro250
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 557 63 580 54 611 52 622 53 623 48 613 46 592 47 573 51 559 56
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 1 317 1 360 45 360 79 348 103 369 171 369 238 353 244 333 183 312 181 303 309 299 416 295 516 296 635 316 635 298 529 289 416 286 256 289 105 307
						yourself:
					)
			)
		)
		(if (== gPrevRoomNum 250) ; ro250
			(foExitHigh init:)
		else
			(foExitLibrary init:)
			(foExitWest init:)
			(foExitEast init:)
			(foPurserArea init:)
			(foPurserDesk init:)
			(foWallPhone init:)
		)
		(poPurser init:)
		(voAnnouncer init:)
		(poWaterfall init:)
		(poSeagulls init:)
		(if (> (Random 1 100) 65)
			(poChicken init:)
		else
			(poPlayer init:)
		)
		(if (> (Random 1 100) 33)
			(if (< (Random 1 100) 50)
				(aoPogoGirl init:)
			else
				(aoWaiter init:)
			)
		)
		(if (> (Random 1 100) 50)
			(aoGuy init:)
		)
		(if (< (Random 1 100) 50)
			(aoGirl init:)
		)
		(if ((ScriptID 64017 0) test: 111) ; oFlags
			(poLavaLamp init:)
			(foLavaLamp init:)
		)
		(foWaterfall init:)
		(foBush init:)
		(foPiano init:)
		(foColumn init:)
		(foOtherDecks init:)
		(foYellowPool init:)
		(foLowerDeck init:)
		(if (== gPrevRoomNum 130) ; ro130
			((ScriptID 80 0) setReal: (ScriptID 80 0) 10) ; oAnnounceTimer, oAnnounceTimer
		)
		(cond
			((not ((ScriptID 64017 0) test: 232)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 522 308
					setDest: 660 309
					loop: 0
					cel: 0
					setPri: 308
					setScalePercent: 70
					nMyFlag: 232
					init:
				)
			)
			((not ((ScriptID 64017 0) test: 251)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 352 286
					setDest: 650 317
					loop: 0
					cel: 0
					setPri: 50
					setScalePercent: 58
					nMyFlag: 251
					init:
				)
			)
			((not ((ScriptID 64017 0) test: 252)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 118 93
					setDest: 171 103
					loop: 1
					setPri: 50
					setScalePercent: 40
					nMyFlag: 252
					init:
				)
			)
		)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 330 331 340 341 360)) ; ro330, ro331, ro340, ro341, ro360
			(gOMusic1 fadeOut:)
		)
		(if (not (OneOf newRoomNumber 340 341)) ; ro340, ro341
			(gOSound1 fadeOut:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance soExitToLibrary of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 329 288 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gCurRoom newRoom: 430) ; ro430
				(self dispose:)
			)
		)
	)
)

(instance soPurserReturns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 60)
			)
			(2
				(poPurser show: setCycle: End)
				(self dispose:)
			)
		)
	)
)

(instance soSeagulls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 0 300))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client cel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance soPlayPiano of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: RandCycle (Random 90 240) self)
			)
			(1
				(client cycleSpeed: (Random 5 10))
				(= ticks (Random 20 40))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance soWaiterWalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Random (GetTime))
				(= ticks (Random 60 300))
			)
			(2
				(client setMotion: MoveTo 618 403 self)
			)
			(3
				(client setMotion: MoveTo 496 372 self)
			)
			(4
				(client setMotion: MoveTo 383 362 self)
			)
			(5
				(client setMotion: MoveTo 249 373 self)
			)
			(6
				(client setMotion: MoveTo 143 398 self)
			)
			(7
				(client setMotion: MoveTo 65 445 self)
			)
			(8
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soWaiterWalksR of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Random (GetTime))
				(= ticks (Random 60 300))
			)
			(2
				(client setMotion: MoveTo 143 398 self)
			)
			(3
				(client setMotion: MoveTo 249 373 self)
			)
			(4
				(client setMotion: MoveTo 383 362 self)
			)
			(5
				(client setMotion: MoveTo 496 372 self)
			)
			(6
				(client setMotion: MoveTo 618 403 self)
			)
			(7
				(client setMotion: MoveTo 659 434 self)
			)
			(8
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soPogoGo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks (Random 60 300))
			)
			(2
				(client setMotion: MoveTo 618 407 self)
			)
			(3
				(client setMotion: MoveTo 512 376 self)
			)
			(4
				(client setMotion: MoveTo 365 360 self)
			)
			(5
				(client setMotion: MoveTo 239 371 self)
			)
			(6
				(client setMotion: MoveTo 65 438 self)
			)
			(7
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soPogoGoR of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks (Random 60 300))
			)
			(2
				(client setMotion: MoveTo 239 371 self)
			)
			(3
				(client setMotion: MoveTo 365 360 self)
			)
			(4
				(client setMotion: MoveTo 512 376 self)
			)
			(5
				(client setMotion: MoveTo 618 407 self)
			)
			(6
				(client setMotion: MoveTo 645 426 self)
			)
			(7
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soGuyWalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Random (GetTime))
				(= ticks (Random 60 300))
			)
			(2
				(client setMotion: MoveTo 629 309 self)
			)
			(3
				(client setMotion: MoveTo 504 295 self)
			)
			(4
				(client setMotion: MoveTo 366 291 self)
			)
			(5
				(client setMotion: MoveTo 252 295 self)
			)
			(6
				(client setMotion: MoveTo 106 311 self)
			)
			(7
				(client setMotion: MoveTo 5 335 self)
			)
			(8
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soGuyWalksR of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Random (GetTime))
				(= ticks (Random 60 300))
			)
			(2
				(client setMotion: MoveTo 106 311 self)
			)
			(3
				(client setMotion: MoveTo 252 295 self)
			)
			(4
				(client setMotion: MoveTo 366 291 self)
			)
			(5
				(client setMotion: MoveTo 504 295 self)
			)
			(6
				(client setMotion: MoveTo 629 309 self)
			)
			(7
				(client setMotion: MoveTo 654 312 self)
			)
			(8
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soGirlWalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks (Random 60 300))
			)
			(2
				(client setMotion: MoveTo 524 219 self)
			)
			(3
				(client setMotion: MoveTo 381 228 self)
			)
			(4
				(client setMotion: MoveTo 224 219 self)
			)
			(5
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soGirlWalksR of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks (Random 60 300))
			)
			(2
				(client setMotion: MoveTo 381 228 self)
			)
			(3
				(client setMotion: MoveTo 524 219 self)
			)
			(4
				(client setMotion: MoveTo 565 214 self)
			)
			(5
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance poPurser of Prop
	(properties
		priority 100
		x 138
		y 276
		cel 27
		view 34000
		fixPriority 1
	)

	(method (init)
		(super init:)
		(if ((ScriptID 64017 0) test: 203) ; oFlags
			((ScriptID 64017 0) clear: 203) ; oFlags
			(self hide: cel: 0 setScript: soPurserReturns)
		)
	)
)

(instance voAnnouncer of Prop
	(properties
		priority 100
		x 182
		y 278
		view 34099
		fixPriority 1
	)
)

(instance poWaterfall of Prop
	(properties
		noun 4
		priority 400
		loop 1
		view 34000
		approachDist 1000
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self setCycle: Fwd)
	)
)

(instance poLavaLamp of Prop
	(properties
		noun 3
		priority 400
		x 324
		y 298
		cycleSpeed 9
		view 34001
		approachDist 1000
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self setCycle: Fwd)
	)
)

(instance poSeagulls of Prop
	(properties
		x 639
		cycleSpeed 9
		view 34003
	)

	(method (init)
		(super init: &rest)
		(self setScript: soSeagulls)
	)
)

(instance poChicken of Prop
	(properties
		priority 476
		x 425
		y 450
		view 34002
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: soPlayPiano)
	)
)

(instance poPlayer of Prop
	(properties
		x 443
		y 476
		view 34008
	)

	(method (init)
		(super init: &rest)
		(self setScript: soPlayPiano)
	)
)

(instance aoWaiter of Actor
	(properties
		priority 100
		x 659
		y 434
		view 34004
		fixPriority 1
	)

	(method (init)
		(self setCycle: Walk)
		(Random (GetTime))
		(if (= local1 (< (Random 1 100) 50))
			(self posn: 65 445 setLoop: 1 1)
		else
			(self posn: 659 434 setLoop: 0 1)
		)
		(super init: &rest)
		(if local1
			(self setScript: soWaiterWalksR)
		else
			(self setScript: soWaiterWalks)
		)
	)
)

(instance aoPogoGirl of Actor
	(properties
		priority 100
		x 645
		y 426
		view 34007
		fixPriority 1
	)

	(method (init)
		(self setCycle: Walk)
		(Random (GetTime))
		(if (= local0 (< (Random 1 100) 50))
			(self posn: 65 438 setLoop: 1 1)
		else
			(self posn: 645 426 setLoop: 0 1)
		)
		(super init: &rest)
		(if local0
			(self setScript: soPogoGoR)
		else
			(self setScript: soPogoGo)
		)
	)
)

(instance aoGuy of Actor
	(properties
		x 654
		y 312
		view 34006
	)

	(method (init)
		(self setCycle: Walk)
		(if
			(and
				(or (gCast contains: aoWaiter) (gCast contains: aoPogoGirl))
				(or local1 local0)
			)
			(= local2 0)
		else
			(= local2 1)
		)
		(if local2
			(self posn: 5 335 setLoop: 1 1)
		else
			(self posn: 654 312 setLoop: 0 1)
		)
		(super init: &rest)
		(if local2
			(self setScript: soGuyWalksR)
		else
			(self setScript: soGuyWalks)
		)
	)
)

(instance aoGirl of Actor
	(properties
		x 565
		y 214
		view 34005
	)

	(method (init)
		(self setCycle: Walk)
		(cond
			((and (gCast contains: aoGuy) local2)
				(= local3 0)
			)
			((gCast contains: aoGuy)
				(= local3 1)
			)
			(
				(and
					(or
						(gCast contains: aoWaiter)
						(gCast contains: aoPogoGirl)
					)
					(or local1 local0)
				)
				(= local3 0)
			)
			(else
				(= local3 1)
			)
		)
		(if local3
			(self posn: 224 219 setLoop: 1 1)
		else
			(self posn: 565 214 setLoop: 0 1)
		)
		(super init: &rest)
		(if local3
			(self setScript: soGirlWalksR)
		else
			(self setScript: soGirlWalks)
		)
	)
)

(instance foExitLibrary of ExitFeature
	(properties
		x 326
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 294 222 358 222 356 295 294 292
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitToLibrary)
	)
)

(instance foLavaLamp of Feature
	(properties
		noun 3
		x 318
		y 297
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 307 160 321 156 335 159 352 314 330 349 347 429 324 438 301 436 285 429 306 349 285 312
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foWallPhone of Feature
	(properties
		noun 9
		x 214
		y 296
		approachX 200
		approachY 319
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 204 308 205 279 225 280 223 313
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 249 addApproachVerb: 249)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(249 ; Call
				((ScriptID 64017 0) set: 173) ; oFlags
				(gCurRoom newRoom: 341) ; ro341
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foPurserArea of Feature
	(properties
		noun 8
		x 147
		y 257
		approachX 164
		approachY 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 110 274 110 233 162 235 162 272
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4 addApproachVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Smell
				(gMessager say: noun theVerb) ; MISSING MESSAGE
				(proc64896_15 7 0)
			)
			(4 ; Talk
				(gCurRoom newRoom: 341) ; ro341
			)
			(else
				(if (proc64037_3 theVerb)
					(= global218 theVerb)
					(gCurRoom newRoom: 341) ; ro341
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance foPurserDesk of Feature
	(properties
		noun 5
		x 155
		y 285
		approachX 164
		approachY 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 108 276 200 271 203 291 108 300
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foWaterfall of Feature
	(properties
		noun 4
		x 460
		y 241
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 382 402 411 304 458 303 492 205 496 204 517 131 533 77 538 77 532 132 521 139 512 205 508 208 499 306 477 313 477 390 415 398 392 405
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBush of Feature
	(properties
		noun 10
		x 534
		y 58
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 549 69 551 60 547 51 554 46 554 43 545 44 540 48 540 52 531 57 529 54 523 50 523 57 520 55 515 59 515 63 525 68 536 74 541 74
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPiano of Feature
	(properties
		noun 6
		x 489
		y 442
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 416 430 424 424 427 415 483 405 515 413 557 408 572 413 572 433 562 439 562 456 555 458 553 440 497 459 496 477 486 477 487 464 480 466 462 459 459 479 434 478 413 469 407 445 421 443 421 436
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
					((gCast contains: poPlayer)
						(gMessager say: noun theVerb 8) ; "When Lefty plays piano, it sounds like a jazz combo!"
					)
					((gCast contains: poChicken)
						(gMessager say: noun theVerb 9) ; "(IT'S A PIANO-PLAYING CHICKEN) When Lefty takes a break, his pecker entertains the crowds."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foColumn of Feature
	(properties
		noun 1
		x 53
		y 313
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 2 107 404 52 367 0 83 0 27 52 2
					yourself:
				)
		)
		(super init: &rest)
		(foColumn2 init:)
		(foColumn3 init:)
		(foColumn4 init:)
		(foColumn5 init:)
		(AddDefaultVerbs self)
	)
)

(instance foColumn2 of Feature
	(properties
		noun 1
		x 196
		y 313
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 224 32 249 316 224 305 225 280 202 278 143 31 187 21
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foColumn3 of Feature
	(properties
		noun 1
		x 243
		y 388
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 227 373 253 361 260 415 237 416
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foColumn4 of Feature
	(properties
		noun 1
		x 432
		y 313
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 532 79 442 234 422 247 432 261 413 291 397 296 396 316 356 392 333 389 451 76 480 66
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foColumn5 of Feature
	(properties
		noun 1
		x 580
		y 313
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 549 59 600 44 639 51 639 89 616 180 590 223 595 265 560 390 522 387
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foOtherDecks of Feature
	(properties
		noun 12
		x 318
		y 30
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 637 220 637 36 535 69 424 82 332 78 270 68 193 45 107 2 0 72 0 189 15 216 193 235 244 235 257 230 326 234 365 234 395 231 479 236 536 227
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLowerDeck of Feature
	(properties
		noun 12
		x 373
		y 30
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 639 423 639 329 597 317 582 315 519 310 428 305 356 305 319 304 277 309 246 315 267 324 267 345 263 350 253 360 225 373 183 382 140 383 108 382 108 423 121 430 155 413 214 391 264 381 332 372 375 370 462 377 504 386 516 390 522 400 571 407 609 415
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foYellowPool of Feature
	(properties
		noun 11
		x 345
		y 240
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 359 468 348 454 352 443 368 426 386 418 428 406 460 401 521 400 520 390 503 386 427 375 367 373 353 393 343 394 330 391 339 373 303 375 256 382 259 413 249 417 237 416 230 389 180 404 127 429 168 445 212 453 271 465 343 469 359 469
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExitWest of ExitFeature
	(properties
		x 613
		y 187
		approachX 41
		approachY 323
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 199 40 199 40 369 0 369
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 330 -13 337)
	)
)

(instance foExitEast of ExitFeature
	(properties
		x 613
		y 187
		approachX 599
		approachY 299
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 600 193 640 193 640 316 600 316
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 360 655 316)
	)
)

(instance foExitHigh of ExitFeature
	(properties
		x 625
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 611 1 611 90 639 90 638 1
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 250 650 49)
	)
)

