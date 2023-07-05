;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 246)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use CycleCueList)
(use CueMe)
(use foEExit)
(use Plane)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	ro246 0
)

(local
	local0
	local1
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local0 0)
	)
)

(instance ro246 of L7Room
	(properties
		picture 24800
	)

	(method (init)
		(switch gPrevRoomNum
			(240 ; ro240
				(gEgo
					init:
					normalize: 6
					setScaler: Scaler 100 62 476 323
					posn: 93 466
				)
			)
			(245 ; ro245
				(gEgo
					normalize: 5
					setScaler: Scaler 100 62 476 323
					posn: 213 324
					init:
				)
			)
			(else
				(gEgo
					normalize: 5
					setScaler: Scaler 100 62 476 323
					posn: 213 324
					init:
				)
			)
		)
		(super init: &rest)
		(gOMusic1 setMusic: 38000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 207 341 220 365 77 466 98 476 258 403 301 370 482 406 490 435 467 468 531 473 581 371 302 317 277 334 119 297 94 315
					yourself:
				)
		)
		(poJohnson init:)
		(if ((ScriptID 64017 0) test: 189) ; oFlags
			(poJohnson hide:)
		)
		(foJuggsExit init:)
		(foFrontExit init:)
		(if ((ScriptID 64017 0) test: 159) ; oFlags
			(voTruss init:)
			(foStairsExit init:)
		else
			(foPole init:)
		)
		(foChest1 init:)
		(foChest2 init:)
		(foCannon1 init:)
		(foCannon2 init:)
		(foNet1 init:)
		(foNet2 init:)
		(foGallery init:)
		(gGame handsOn:)
		(if ((ScriptID 64017 0) test: 189) ; oFlags
			(gCurRoom setScript: soJohnsonGiveDrink)
		)
		(if
			(and
				((ScriptID 64017 0) test: 34) ; oFlags
				((ScriptID 64017 0) test: 30) ; oFlags
				((ScriptID 64017 0) test: 32) ; oFlags
				((ScriptID 64017 0) test: 292) ; oFlags
			)
			(poNull setScript: soPlayAudience)
		)
	)

	(method (doit)
		(if (poNull script:)
			((poNull script:) doit:)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if (poNull script:)
			((poNull script:) dispose:)
		)
		(if
			(and
				((ScriptID 64017 0) test: 41) ; oFlags
				((ScriptID 64017 0) test: 38) ; oFlags
				(not (OneOf gNewRoomNum 240 245 246)) ; ro240, ro245, ro246
			)
			((ScriptID 64017 0) set: 162) ; oFlags
		)
		(if
			(and
				((ScriptID 64017 0) test: 34) ; oFlags
				((ScriptID 64017 0) test: 30) ; oFlags
				((ScriptID 64017 0) test: 32) ; oFlags
				(not (OneOf gNewRoomNum 240 245 246)) ; ro240, ro245, ro246
			)
			((ScriptID 64017 0) set: 292) ; oFlags
		)
		(if (gTimers contains: oJohnsonTimer)
			(oJohnsonTimer dispose: delete:)
		)
		(= global353 0)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 13)) ; oInvHandler, ioHeatBulb
		(if (not ((ScriptID 64017 0) test: 159)) ; oFlags
			((ScriptID 64017 0) set: 159) ; oFlags
			(voTruss init:)
		)
	)
)

(instance voTruss of View
	(properties
		noun 8
		priority 600
		x 425
		y 131
		view 24850
		approachX 153
		approachY 304
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addApproachVerb: 1)
		(if ((ScriptID 64017 0) test: 43) ; oFlags
			(if ((ScriptID 64017 0) test: 41) ; oFlags
				(voHeatLampLS init:)
			else
				(voSocketLS init:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: soGoToLamp)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soGoToLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 153 304 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gCurRoom addRoomPlane: oLampCUPlane)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voHeatLampLS of View
	(properties
		priority 601
		x 338
		y 106
		view 24851
		fixPriority 1
	)
)

(instance voSocketLS of View
	(properties
		priority 601
		x 338
		y 106
		cel 1
		view 24851
		fixPriority 1
	)
)

(instance foCannon1 of Feature
	(properties
		noun 1
		x 56
		y 287
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 264 57 238 106 243 111 270 88 291 4 336
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCannon2 of Feature
	(properties
		noun 1
		x 590
		y 381
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 554 286 639 327 636 477 603 474 588 443 614 405 630 399 632 375 613 362 602 354 630 328 588 310 575 324 552 327 542 311
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foNet1 of Feature
	(properties
		noun 4
		x 279
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 97 221 2 373 0 350 82
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foNet2 of Feature
	(properties
		noun 4
		x 41
		y 88
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 2 176 3 1 80 1 32 176 yourself:)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPole of Feature
	(properties
		noun 8
		x 423
		y 164
		case 12
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 404 198 407 1 439 1 442 202 423 204 406 200
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foGallery of Feature
	(properties
		noun 6
		x 388
		y 163
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 144 141 380 93 499 83 593 84 636 119 638 243 139 188
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foStairs of Feature ; UNUSED
	(properties
		noun 9
		x 168
		y 250
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 197 218 201 218 240 198 294 172 304 119 289
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foStairsExit of Feature
	(properties
		x 168
		y 250
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 197 218 201 218 240 198 294 172 304 119 289
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(voTruss doVerb: 1)
	)
)

(instance foChest1 of Feature
	(properties
		noun 7
		x 94
		y 380
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 368 20 374 27 342 83 327 85 285 175 306 188 320 188 330 171 353 167 381 131 411 80 397 73 419 46 421 20 442 21 469 5 476
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChest2 of Feature
	(properties
		noun 7
		x 337
		y 409
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 322 341 457 369 466 386 442 428 439 467 431 476 208 477 210 452 226 448 275 459 277 422 318 388
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foJuggsExit of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 215 256 212 279 220 286 249 286 304 257 321 194 306 222 291 225 244 236 219
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soGoToJuggs)
	)
)

(instance poNull of Prop
	(properties)
)

(instance soPlayAudience of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oAudience setRelVol: 40)
				(= cycles 1)
			)
			(1
				(= seconds (Random 5 15))
			)
			(2
				(switch (Random 0 2)
					(0
						(oAudience playSound: 24402 self)
					)
					(1
						(oAudience playSound: 24403 self)
					)
					(2
						(oAudience playSound: 24404 self)
					)
				)
				(-= state 2)
			)
		)
	)
)

(instance oAudience of TPSound
	(properties)
)

(instance soGoToJuggs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 213 324 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gGame handsOn:)
				(if ((ScriptID 64017 0) test: 189) ; oFlags
					(gCurRoom newRoom: 245) ; ro245
					(self dispose:)
					(return)
				else
					(= local1 0)
					(self setScript: soJohnsonStopFidgeting self)
				)
			)
			(3
				(poJohnson
					view: 24010
					setPri: 20
					loop: 0
					cel: 0
					posn: 335 274
					setCycle: CycleCueList 12 1 coJohnsonInPlace 12
				)
				(= global353 toJohnsonStop)
				(gMessager say: 3 0 3 0 self) ; "Hey! Hold it! What do you think you're doing? You can't go in there. That's private. Why, them women could be naked in there! Their breasts a'swingin' back and forth. And the nipple thing... They could be hanging upside down again! You jest don't know!"
				(gEgo setHeading: 90)
			)
			(4
				(= global353 0)
				(if (not local1)
					(-- state)
				)
				(= cycles 2)
			)
			(5
				(poJohnson view: 24010 cel: 12 setCycle: End self)
				(voJohnsonStopMouth dispose:)
			)
			(6
				(poJohnson
					view: 24000
					loop: 0
					cel: 0
					posn: 332 272
					setPri: 1
					setScript: soJohnsonFidgets
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coJohnsonInPlace of CueMe
	(properties)

	(method (cue)
		(poJohnson view: 24011 loop: 0 cel: 0 posn: 335 274)
		(voJohnsonStopMouth init:)
		(if (toJohnsonStop mouth:)
			(voJohnsonStopMouth hide:)
			((toJohnsonStop mouth:) show:)
		)
		(= local1 1)
	)
)

(instance voJohnsonStopMouth of View
	(properties
		priority 21
		x 335
		y 274
		loop 1
		view 24011
		fixPriority 1
	)
)

(instance toJohnsonStop of Talker
	(properties
		priority 21
		x 335
		y 274
		loop 1
		view 24011
	)

	(method (init)
		(super init: &rest)
		(if (not local1)
			(mouth hide:)
		)
		(if (voJohnsonStopMouth plane:)
			(voJohnsonStopMouth hide:)
		)
	)

	(method (dispose)
		(if (voJohnsonStopMouth plane:)
			(voJohnsonStopMouth show:)
		)
		(super dispose: &rest)
	)
)

(instance foFrontExit of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 350 26 349 34 446 275 452 276 476 1 478
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitFront)
	)
)

(instance soExitFront of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 54 500 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 54 500 0 0 0 0)
				(= ticks 20)
			)
			(2
				(gCurRoom newRoom: 240) ; ro240
			)
		)
	)
)

(instance poLarry of Prop
	(properties)
)

(instance poJohnson of Prop
	(properties
		noun 2
		priority 1
		x 332
		y 272
		view 24000
		approachX 312
		approachY 323
		fixPriority 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
		(self setScript: soJohnsonFidgets)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(gCurRoom setScript: soTalkToJohnson)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soJohnsonFidgets of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poJohnson view: 24000 posn: 332 272 setPri: 1 loop: 0 cel: 0)
				(= cycles 1)
			)
			(1
				(= seconds (Random 5 10))
			)
			(2
				(poJohnson setCycle: CT 8 1 self)
			)
			(3
				(poJohnson cel: 4 setCycle: CT 8 1 self)
			)
			(4
				(poJohnson cel: 4 setCycle: End self)
			)
			(5
				(poJohnson cel: 0)
				(-= state 5)
				(= cycles 1)
			)
		)
	)
)

(instance soJohnsonStopFidgeting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poJohnson setScript: 0)
				(if (!= (poJohnson cel:) 0)
					(poJohnson setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(poJohnson cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance soTalkToJohnson of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
				(self setScript: soJohnsonStopFidgeting self)
			)
			(1)
			(2
				(self dispose:)
				(gCurRoom addRoomPlane: oJohnsonTalkPlane)
				(gCurRoom setScript: soJohnsonIntro)
			)
		)
	)
)

(instance oJohnsonTalkPlane of Plane
	(properties
		picture 24900
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(poJohnsonCU
			cycleSpeed: 7
			view: 24015
			loop: 0
			cel: 0
			posn: 334 384
			init:
		)
		(voJohnsonMouth init:)
		(= global353 toJohnsonCU)
		(if (not ((ScriptID 64017 0) test: 224)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 99 221
				setDest: 533 200
				loop: 0
				cel: 3
				setScaleDirect: 150
				setPri: 50
				nMyFlag: 224
				init:
			)
		)
		(foCUExit init:)
	)

	(method (dispose)
		(= global353 0)
		(super dispose: &rest)
	)
)

(instance soJohnsonIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if ((ScriptID 64017 0) test: 176) ; oFlags
					(cond
						(((ScriptID 64017 0) test: 104) ; oFlags
							(gMessager say: 2 101 8 0 self) ; "Hey, Johnson. It's me, Larry."
						)
						(((ScriptID 64017 0) test: 294) ; oFlags
							(gMessager say: 2 101 0 0 self) ; "If it isn't my old friend, the mixologist."
						)
						(else
							((ScriptID 64017 0) set: 294) ; oFlags
							(gMessager say: 2 101 10 0 self) ; "Hey, uh, Johnson. How's it hangin', Johnson? It's me, Larry."
						)
					)
				else
					((ScriptID 64017 0) set: 176) ; oFlags
					((ScriptID 64017 0) set: 42) ; oFlags
					(gMessager say: 2 100 0 0 self) ; "Howdy, barkeep. Whadaya got?"
				)
			)
			(1
				(L7TalkWindow init: poJohnsonCU global258)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJohnsonMakesBourbon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 25003)
				(gMessager sayRange: 2 200 0 1 3 self) ; "How about a bourbon and soda? On the rocks. With a twist. And an umbrella. And some fruit. And maybe a bendy straw, if you got 'em."
			)
			(1
				(voJohnsonMouth dispose:)
				(poJohnsonCU
					view: 24021
					loop: 0
					cel: 0
					posn: 314 373
					cycleSpeed: 3
					setCycle: End self
				)
				(if (voDrink plane:)
					(voDrink dispose:)
				)
				(gOSound1 playSound: 25003 self)
			)
			(2)
			(3
				(poJohnsonCU setCycle: Beg self)
				(gOSound1 playSound: 25003 self)
			)
			(4)
			(5
				(voDrink loop: 0 cel: 0 init:)
				(poJohnsonCU
					cycleSpeed: 7
					view: 24015
					loop: 0
					cel: 0
					posn: 334 384
				)
				(voJohnsonMouth init:)
				(gMessager sayRange: 2 200 0 4 8 self) ; "(1 SECOND FLASH OF MOTION) Here. We ain't got no bendy straws, so I gave you a "Cap'n Happy's Barrel O' Fun" straw."
				((ScriptID 64017 0) set: 296) ; oFlags
			)
			(6
				(voDrink hide:)
				(gOSound1 playSound: 105 self)
			)
			(7
				(voDrink show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJohnsonMakesCocktail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 25003)
				(gMessager sayRange: 2 237 0 1 4 self) ; "Give me, uh..."
			)
			(1
				(voJohnsonMouth dispose:)
				(poJohnsonCU
					view: 24021
					loop: 0
					cel: 0
					posn: 314 373
					cycleSpeed: 3
					setCycle: End self
				)
				(if (voDrink plane:)
					(voDrink dispose:)
				)
				(gOSound1 playSound: 25003 self)
			)
			(2)
			(3
				(poJohnsonCU setCycle: Beg self)
				(gOSound1 playSound: 25003 self)
			)
			(4)
			(5
				(voDrink loop: 1 cel: (Random 0 4) init:)
				(poJohnsonCU
					cycleSpeed: 7
					view: 24015
					loop: 0
					cel: 0
					posn: 334 384
				)
				(voJohnsonMouth init:)
				(gMessager sayRange: 2 237 0 5 5 self) ; "Here ya go."
			)
			(6
				(voDrink hide:)
				(gMessager sayRange: 2 237 0 6 6 self) ; "(DOWNING DRINK IN ONE BIG CHUG) Gulp, gulp, gulp."
			)
			(7
				(voDrink show:)
				(gMessager sayRange: 2 237 0 7 7 self) ; "Boy, are these drinks watered down!"
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJohnsonLimeJuice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 25003)
				(gMessager sayRange: 2 145 0 1 19 self) ; "(JACK NICHOLSON'S FIVE EASY PIECES BIT; START AS LARRY) Excuse me, Johnson. I want a glass of lime juice."
			)
			(1
				(voJohnsonMouth dispose:)
				(poJohnsonCU
					view: 24021
					loop: 0
					cel: 0
					posn: 314 373
					cycleSpeed: 3
					setCycle: End self
				)
				(if (voDrink plane:)
					(voDrink dispose:)
				)
				(gOSound1 playSound: 25003 self)
			)
			(2)
			(3
				(poJohnsonCU setCycle: Beg self)
				(gOSound1 playSound: 25003 self)
			)
			(4)
			(5
				(voDrink loop: 2 cel: 0 init:)
				(poJohnsonCU
					cycleSpeed: 7
					view: 24015
					loop: 0
					cel: 0
					posn: 334 384
				)
				(voJohnsonMouth init:)
				(gMessager say: 2 145 0 20 self) ; "Here! Pucker up!"
			)
			(6
				(gEgo get: ((ScriptID 64037 0) get: 22)) ; oInvHandler, ioLimeJuice
				((ScriptID 64017 0) set: 31) ; oFlags
				(voDrink dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGoodbye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 86 0 0 self) ; "See ya later, Johnson."
			)
			(1
				(foCUExit doVerb:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJohnsonMakesErection of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 189) ; oFlags
				(L7TalkWindow addTopic: 236)
				((ScriptID 64017 0) set: 40) ; oFlags
				(gMessager sayRange: 2 236 0 1 5 self) ; "Oh, Johnson! I want a "Gigantic Erection!""
			)
			(1
				(voJohnsonMouth dispose:)
				(if (voDrink plane:)
					(voDrink dispose:)
				)
				(poJohnsonCU
					view: 24020
					loop: 0
					cel: 0
					posn: 314 373
					setCycle: End self
				)
			)
			(2
				(L7TalkWindow dispose:)
				(poJohnson hide:)
				(poJohnsonCU dispose:)
				(oJohnsonTimer setReal: oJohnsonTimer 15)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oJohnsonTimer of Timer
	(properties)

	(method (cue)
		(if
			(or
				(and gTalkers (not (gTalkers isEmpty:)))
				(not (gUser canControl:))
				(gCurRoom script:)
				(gEgo script:)
				(== (gCurRoom plane:) oLampCUPlane)
			)
			(self setReal: self 2)
			(return)
		)
		(if (== (gCurRoom plane:) oJohnsonTalkPlane)
			(gCurRoom setScript: soCUJohnsonGiveDrink)
		else
			(gCurRoom setScript: soJohnsonGiveDrink)
		)
	)
)

(instance soCUJohnsonGiveDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom deleteRoomPlane: oJohnsonTalkPlane)
				(= local0 1)
				(if ((ScriptID 64017 0) test: 296) ; oFlags
					(gMessager sayRange: 2 236 0 7 7 coDoneTalking) ; "Thanks."
				else
					(gMessager sayRange: 2 236 0 6 7 coDoneTalking) ; "Here ya go. I'll just charge it to your room. That your keycard? Okay."
					((ScriptID 64017 0) set: 296) ; oFlags
				)
				(gEgo hide:)
				(poLarry view: 24026 loop: 0 cel: 0 posn: 307 323 init:)
				(= ticks 180)
			)
			(1
				(poJohnson
					view: 24025
					cel: 0
					loop: 0
					posn: 332 273
					setPri: 1
					show:
					setCycle: End self 7 8
				)
			)
			(2
				(poLarry setCycle: End self 13)
			)
			(3
				(poJohnson setPri: 20)
			)
			(4
				(poJohnson cel: 0 loop: 1 setCycle: End self)
			)
			(5
				(poJohnson setPri: 1)
				(if local0
					(-- state)
				)
				(= cycles 2)
			)
			(6
				(poJohnsonCU view: 24015 loop: 0 cel: 0 posn: 334 384)
				(poLarry dispose:)
				(gEgo show:)
				(gCurRoom addRoomPlane: oJohnsonTalkPlane)
				((ScriptID 64017 0) clear: 189) ; oFlags
				(= ticks 60)
			)
			(7
				(gMessager sayRange: 2 236 0 8 8 self) ; "Doesn't seem to work!"
			)
			(8
				(L7TalkWindow init: poJohnsonCU global258)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soJohnsonGiveDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) clear: 189) ; oFlags
				(self setScript: soJohnsonStopFidgeting self)
			)
			(1
				(gMessager say: 0 0 1 1 self) ; "Hey, loser! You want this drink you ordered?"
				(gEgo walkTo: 312 323 self)
			)
			(2)
			(3
				(gEgo setHeading: 45 self)
			)
			(4
				(= local0 1)
				(gMessager say: 0 0 1 2 coDoneTalking) ; "I'll charge it to your room."
				(gEgo hide:)
				(poLarry view: 24026 loop: 0 cel: 0 posn: 307 323 init:)
				(= ticks 120)
			)
			(5
				(poJohnson
					view: 24025
					cel: 0
					loop: 0
					posn: 332 273
					show:
					setCycle: End self 7 8
				)
			)
			(6
				(poLarry setCycle: CT 3 1 self)
			)
			(7
				(poJohnson setPri: 20)
			)
			(8
				(if local0
					(-- state)
				)
				(= cycles 2)
			)
			(9
				(gMessager say: 0 0 1 3 self) ; "Thanks. Hey, my banana's all soft and flaccid... with little brown spots!"
			)
			(10
				(gCurRoom addRoomPlane: oJohnsonTalkPlane)
				(gMessager say: 0 0 1 4 self) ; "Sorry, bud. I only do drinks!"
			)
			(11
				(gCurRoom deleteRoomPlane: oJohnsonTalkPlane)
				(poLarry setCycle: End self 13)
			)
			(12
				(poJohnson cel: 0 loop: 1 setCycle: End self)
			)
			(13
				(poJohnson
					view: 24000
					loop: 0
					cel: 0
					posn: 332 272
					setPri: 1
					setScript: soJohnsonFidgets
				)
				(poLarry dispose:)
				(gEgo show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oJohnsonTalkPlane)
		(if (L7TalkWindow oPlane:)
			(L7TalkWindow dispose:)
		)
		(poJohnson setScript: soJohnsonFidgets)
	)
)

(instance poJohnsonCU of Prop
	(properties
		noun 2
		x 334
		y 384
		view 24015
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(236 ; Gigantic Erection
				(gCurRoom setScript: soJohnsonMakesErection)
			)
			(200 ; Bourbon
				(gCurRoom setScript: soJohnsonMakesBourbon)
			)
			(237 ; A Cocktail
				(gCurRoom setScript: soJohnsonMakesCocktail)
			)
			(145 ; Lime juice
				(if ((ScriptID 64017 0) test: 31) ; oFlags
					(gMessager say: 2 70 0 3) ; "Nope. Don't ever ask me 'bout that no more!"
				else
					(gCurRoom setScript: soJohnsonLimeJuice)
				)
			)
			(86 ; Goodbye
				(gCurRoom setScript: soGoodbye)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voJohnsonMouth of View
	(properties
		priority 390
		x 334
		y 384
		loop 1
		view 24015
		fixPriority 1
	)
)

(instance toJohnsonCU of Talker
	(properties
		priority 390
		x 334
		y 384
		loop 1
		view 24015
	)

	(method (init)
		(voJohnsonMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voJohnsonMouth show:)
		(super dispose: &rest)
	)
)

(instance voDrink of View
	(properties
		priority 600
		x 248
		y 399
		view 24950
		fixPriority 1
	)
)

(instance oLampCUPlane of Plane
	(properties
		picture 24700
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(foLampCUExit init:)
		(foSpotlight init:)
		(gGame handsOn:)
	)
)

(instance foSpotlight of Feature
	(properties)

	(method (init)
		(= noun 5)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 110 173 114 206 141 224 177 224 229 205 260 172 271 134 253 108 215 101 172 115 124 130 110
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(if ((ScriptID 64017 0) test: 43) ; oFlags
			(if ((ScriptID 64017 0) test: 41) ; oFlags
				(= case 4)
				(voHeatLamp loop: 1 init:)
			else
				(= case 6)
			)
		else
			(= case 0)
			(self addHotspotVerb: 8)
			(voHeatLamp loop: 0 init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(if (== case 0)
					(gCurRoom setScript: soTakeOldLight)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(33 ; Heat Lamp Bulb
				(if (== case 6)
					((ScriptID 64017 0) set: 41) ; oFlags
					(gEgo put: ((ScriptID 64037 0) get: 13)) ; oInvHandler, ioHeatBulb
					(= case 4)
					(voHeatLamp loop: 1 init:)
					(gMessager say: 5 33 6 0) ; "That's a sneaky idea. The bulb fits. It's the right voltage. But won't it make the stage uncomfortably warm?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voHeatLamp of View
	(properties
		x 169
		y 187
		view 24750
	)
)

(instance soTakeOldLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 8 0 1 self) ; "(SLOWLY, STRULLING) Lemme... just... ease this..."
			)
			(1
				(voHeatLamp dispose:)
				(gOSound1 playSound: 24601 self)
			)
			(2
				(gMessager say: 5 8 0 2 self) ; "(SOUND OF SMASHING GLASS; THEN SOFTLY) Whoops."
			)
			(3
				((ScriptID 64017 0) set: 43) ; oFlags
				(foSpotlight case: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foLampCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oLampCUPlane)
		(if (voHeatLampLS plane:)
			(voHeatLampLS dispose:)
		)
		(if (voSocketLS plane:)
			(voSocketLS dispose:)
		)
		(if ((ScriptID 64017 0) test: 43) ; oFlags
			(if ((ScriptID 64017 0) test: 41) ; oFlags
				(voHeatLampLS init:)
			else
				(voSocketLS init:)
			)
		)
		(gEgo hide: normalize: 4 1 show:)
	)
)

