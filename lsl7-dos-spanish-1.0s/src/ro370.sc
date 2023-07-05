;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro370 0
)

(local
	local0
	local1
	local2 = 37000
)

(instance ro370 of L7Room
	(properties
		picture 37000
	)

	(method (init)
		(switch gPrevRoomNum
			(381 ; ro381
				(gEgo init: setScale: scaleX: 31 scaleY: 31 posn: 540 206)
			)
			(371 ; ro371
				(gEgo
					init:
					normalize: 4
					setScaler: Scaler 60 19 342 114
					posn: 50 347
				)
			)
			(else
				(gEgo
					init:
					normalize: 5
					setScaler: Scaler 60 19 342 114
					posn: 544 118
				)
			)
		)
		(super init:)
		(if ((ScriptID 64017 0) test: 87) ; oFlags
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 543 107 512 131 131 314 61 287 45 298 49 311 10 338 12 355 39 369 105 336 437 474 461 441 192 335 543 128 550 127 565 108
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((= local0 (Polygon new:))
						type: PContainedAccess
						init: 543 107 512 131 131 314 54 284 36 294 37 310 432 470 461 441 192 335 543 128 550 127 565 108
						yourself:
					)
			)
		)
		(cond
			((== gPrevRoomNum 371) ; ro371
				(gOMusic1 fade: global227 6 3 0)
			)
			(((ScriptID 64017 0) test: 87) ; oFlags
				(gOMusic1 setMusic: 37000)
			)
			(else
				(gOMusic1 setMusic: 37000)
				(gOSound1 setAmbient: 37001)
			)
		)
		(= gToBonds toBonds)
		(poCroupier init:)
		(if (not ((ScriptID 64017 0) test: 87)) ; oFlags
			(poShooter init:)
			(poBonds init:)
			(aoWaitress init:)
			(voCrowdBack init:)
			(voCrowdFront init:)
		)
		(poBJDealer init:)
		(voBJPlayers init:)
		(poCarcano init:)
		(foBlackjack init:)
		(foCrapsTable init:)
		(foDisco init:)
		(foHuts init:)
		(foPalms init:)
		(foSlots init:)
		(foTikis init:)
		(foVolcano init:)
		(if (not ((ScriptID 64017 0) test: 234)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 476 359
				setDest: 381 285
				loop: 1
				cel: 0
				setScalePercent: 46
				setPri: 285
				nMyFlag: 234
				init:
				setSpeed: 5
				setStep: 3 10
			)
		)
		(foEscalator init:)
		(foExitBreak init:)
		(foExitDoor init:)
		(if (== gPrevRoomNum 381) ; ro381
			(gGame handsOff:)
			(gCurRoom setScript: soComeFromBreakroom)
		else
			(gGame handsOn:)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(>= (gEgo y:) 274)
				(== local2 37000)
				(not ((ScriptID 64017 0) test: 87)) ; oFlags
			)
			(= local2 37003)
			(gOMusic1 setMusic: 37003)
		)
		(if
			(and
				(< (gEgo y:) 274)
				(== local2 37003)
				(not ((ScriptID 64017 0) test: 87)) ; oFlags
			)
			(= local2 37000)
			(gOMusic1 setMusic: 37000)
		)
	)

	(method (cue)
		(gCurRoom setScript: soFartCartoon)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 68) ; oFlags
		(= global215 1)
		(gEgo addHotspotVerb: 11)
		(gEgo get: ((ScriptID 64037 0) get: 40) ((ScriptID 64037 0) get: 42)) ; oInvHandler, ioShavedDice, oInvHandler, ioSouvenirDice
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 371) ; ro371
				(gOMusic1 fade: (/ global227 2) 6 3 0)
				(gOSound1 fadeOut:)
			)
			((!= newRoomNumber 370) ; ro370
				(gOMusic1 fadeOut:)
				(gOSound1 fadeOut:)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= gToBonds 0)
		(= gToWaitress 0)
		(super dispose:)
	)
)

(instance soGoBreakroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 532 134 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 553 143 self 0 1 0)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(= cycles 3)
			)
			(4
				(= register (gEgo moveSpeed:))
				(gEgo
					setScale:
					scaleX: 31
					scaleY: 31
					setMotion: 0
					setCycle: 0
					moveSpeed: 3
					setMotion: MoveTo 605 234 self
				)
			)
			(5
				(gEgo moveSpeed: register walkTo: 619 234 self 1 0 0)
			)
			(6
				(gEgo walkTo: 614 246 self 0 0 0)
			)
			(7
				(gEgo walkTo: 527 227 self 0 0 0)
			)
			(8
				(gEgo walkTo: 540 206 self 0 1 0)
			)
			(9
				(gCurRoom newRoom: 381) ; ro381
				(self dispose:)
			)
		)
	)
)

(instance soComeFromBreakroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 527 227 self 1 0 0)
			)
			(1
				(gEgo walkTo: 614 246 self 0 0 0)
			)
			(2
				(gEgo walkTo: 619 234 self 0 0 0)
			)
			(3
				(gEgo walkTo: 605 234 self 0 1 0)
			)
			(4
				(gEgo setHeading: 270 self)
			)
			(5
				(= cycles 3)
			)
			(6
				(= register (gEgo moveSpeed:))
				(gEgo
					setMotion: 0
					setCycle: 0
					moveSpeed: 3
					setMotion: MoveTo 553 143 self
				)
			)
			(7
				(gEgo moveSpeed: register walkTo: 532 134 self 1 1 0)
			)
			(8
				(gEgo normalize: 1 setScaler: Scaler 60 19 342 114)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soFartCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (<= global215 2)
					(Load 140 37404) ; WAVE
				else
					(Load 140 37405) ; WAVE
				)
				(if (or (!= (gEgo x:) 175) (!= (gEgo y:) 338))
					(= register 1)
					(gEgo walkTo: 175 338 self)
				else
					(= register 0)
					(= cycles 1)
				)
			)
			(1
				(if register
					(Face gEgo foCrapsTable self)
				else
					(= cycles 1)
				)
			)
			(2
				(= cycles 3)
			)
			(3
				(poShooter dispose:)
				(poBonds dispose:)
				(voCrowdBack dispose:)
				(voCrowdFront dispose:)
				(if (gCast contains: aoWaitress)
					(aoWaitress dispose:)
				)
				((ScriptID 64017 0) set: 87) ; oFlags
				(poCroupier approachX: 50 approachY: 347 case: 2)
				(foCrapsTable approachX: 50 approachY: 347 case: 2)
				(gCurRoom addRoomPlane: oFartCUPlane)
				(poFarter init: cel: 0)
				(= cycles 3)
			)
			(4
				(= ticks 30)
			)
			(5
				(poFarter setCycle: CT 10 1 self)
			)
			(6
				(gOMusic1 fadeOut:)
				(gOSound1 stop:)
				(oSFX stop:)
				(if (<= global215 2)
					(gOSound1 playSound: 37404)
				else
					(gOSound1 playSound: 37405)
				)
				(= ticks 120)
			)
			(7
				(poFarter setCycle: CT 27 1 self)
			)
			(8
				(proc64896_15 5 0)
				(oSFX playSound: 37402 self)
				(poFarter setCycle: End self)
			)
			(9 0)
			(10
				((gCurRoom obstacles:) delete: local0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 543 107 512 131 131 314 61 287 45 298 49 311 10 338 12 355 39 369 105 336 437 474 461 441 192 335 543 128 550 127 565 108
							yourself:
						)
				)
				(gCurRoom deleteRoomPlane: oFartCUPlane)
				(= cycles 3)
			)
			(11
				(switch global215
					(3
						(gMessager say: 1 11 6 0 self 60) ; "Mayday! Mayday! Mayday!! Man overboard."
					)
					(2
						(gMessager say: 1 11 5 0 self 60) ; "Whew! That could clean your hull of barnacles!"
					)
					(1
						(gMessager say: 1 11 1 0 self 60) ; "Wow! That bean dip is really effective!"
					)
				)
				((ScriptID 64017 0) clear: 68) ; oFlags
				(gEgo deleteHotspotVerb: 11)
				(= global215 0)
			)
			(12
				(gOMusic1 setMusic: 37000)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soRunCraps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poCroupier cel: 0 setCycle: End self)
			)
			(1
				(poCroupier cel: 0)
				(= ticks 30)
			)
			(2
				(if (== (poShooter cel:) 16)
					(poShooter setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(3
				(poShooter cel: 0 setCycle: CT 16 1 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(if (< (Random 1 100) 50)
					(oSFX playSound: 37002)
				)
				(= cycles 1)
			)
			(6
				(= ticks (Random 90 240))
			)
			(7
				(self changeState: 0)
			)
		)
	)
)

(instance soWaitress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(client
					setLoop: 0 1
					setCycle: Walk
					setMotion: MoveTo 312 396 self
				)
			)
			(2
				(if
					(or
						(gCurRoom script:)
						(not (gTalkers isEmpty:))
						((ScriptID 50 0) script:) ; oDildo
					)
					(-- state)
					(= cycles 3)
				else
					(gGame handsOff:)
					(gEgo setMotion: 0)
					(if (== local2 37000)
						(gOMusic1 setMusic: 37003)
					)
					(client setMotion: 0)
					(= gToWaitress toWaitress)
					(gMessager say: 0 0 3 1 self) ; "Drinks, anyone?"
				)
			)
			(3
				(= gToWaitress 0)
				(poBonds setCycle: End self)
			)
			(4
				(gMessager say: 0 0 3 2 self) ; "(IN UNISON) Martini. Shaken, not stirred."
			)
			(5
				(poBonds setCycle: Beg self)
			)
			(6
				(if (< (gEgo y:) 274)
					(gOMusic1 setMusic: 37000)
				)
				(oSFX stop:)
				(gMessager say: 0 0 3 6 self) ; "Can I get some bean dip here?"
			)
			(7
				(oSFX2 playSound: 37005 self)
			)
			(8
				(client setMotion: MoveTo -20 273 self)
				(gGame handsOn:)
			)
			(9
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soDeal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End self)
			)
			(1
				(client cel: 0)
				(= ticks (Random 90 180))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance poCroupier of Prop
	(properties
		noun 4
		x 65
		y 447
		case 1
		view 37005
		approachX 81
		approachY 304
	)

	(method (init)
		(super init:)
		(if ((ScriptID 64017 0) test: 87) ; oFlags
			(= case 2)
			(= approachX 50)
			(= approachY 347)
		else
			(self setScript: soRunCraps)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(cond
					((not ((ScriptID 64017 0) test: 87)) ; oFlags
						(gMessager say: noun theVerb 1) ; "Excuse me."
					)
					(((ScriptID 64017 0) test: 131) ; oFlags
						(gMessager say: 2 79 6) ; "You have no need for money, Larry."
					)
					((gEgo has: ((ScriptID 64037 0) get: 52)) ; oInvHandler, ioMoney
						(gMessager say: 2 79 5) ; "You have plenty of money already, Larry. Besides, this isn't about the money."
					)
					(else
						((ScriptID 64017 0) set: 200) ; oFlags
						(gCurRoom newRoom: 371) ; ro371
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poShooter of Prop
	(properties
		noun 3
		priority 440
		x 49
		y 420
		loop 1
		view 37005
		z 150
		approachX 81
		approachY 304
		fixPriority 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(gMessager say: noun theVerb 0 (Random 1 8))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poBonds of Prop
	(properties
		noun 3
		x 138
		y 418
		loop 2
		view 37000
		approachX 81
		approachY 304
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(poShooter doVerb: theVerb)
	)
)

(instance aoWaitress of Actor
	(properties
		noun 5
		x 544
		y 480
		view 37010
		approachDist 1000
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8 setStep: 5 5 setScript: soWaitress)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(= gToWaitress toWaitress)
				(super doVerb: theVerb)
				(= gToWaitress 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voCrowdBack of View
	(properties
		priority 400
		x 100
		y 400
		loop 2
		view 37020
		fixPriority 1
	)
)

(instance voCrowdFront of View
	(properties
		priority 450
		x 100
		y 400
		loop 3
		view 37020
		fixPriority 1
	)
)

(instance poBJDealer of Prop
	(properties
		noun 1
		x 572
		y 317
		cycleSpeed 10
		view 37015
		approachX 409
		approachY 184
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self setScript: soDeal)
	)
)

(instance voBJPlayers of View
	(properties
		noun 1
		priority 100
		x 100
		y 400
		loop 1
		view 37020
		approachX 409
		approachY 184
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance poCarcano of Prop
	(properties
		noun 8
		x 135
		y 78
		view 37020
		approachX 259
		approachY 256
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
		(AddDefaultVerbs self)
	)
)

(instance foCrapsTable of Feature
	(properties
		noun 2
		x 126
		y 384
		case 1
		approachX 81
		approachY 304
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 16 347 96 300 236 352 207 423 141 468 31 410
					yourself:
				)
		)
		(if ((ScriptID 64017 0) test: 87) ; oFlags
			(= case 2)
			(= approachX 50)
			(= approachY 347)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 79)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(79 ; Play
				(cond
					((not ((ScriptID 64017 0) test: 87)) ; oFlags
						(poShooter doVerb: 4)
					)
					(((ScriptID 64017 0) test: 131) ; oFlags
						(gMessager say: noun theVerb 6) ; "You have no need for money, Larry."
					)
					((gEgo has: ((ScriptID 64037 0) get: 52)) ; oInvHandler, ioMoney
						(gMessager say: noun theVerb 5) ; "You have plenty of money already, Larry. Besides, this isn't about the money."
					)
					(else
						(gCurRoom newRoom: 371) ; ro371
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBlackjack of Feature
	(properties
		noun 1
		x 599
		y 250
		approachX 409
		approachY 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 565 403 634 286 637 285 638 422 620 439 561 442
					yourself:
				)
		)
		(super init: &rest)
		(foBlackjack2 init:)
		(foBlackjack3 init:)
		(AddDefaultVerbs self)
	)
)

(instance foBlackjack2 of Feature
	(properties
		noun 1
		x 522
		y 250
		approachX 409
		approachY 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 453 361 517 264 560 244 594 276 592 300 510 416 451 403
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBlackjack3 of Feature
	(properties
		noun 1
		x 395
		y 250
		approachX 409
		approachY 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 429 238 448 249 448 268 367 330 342 311 349 291
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foDisco of Feature
	(properties
		noun 9
		x 595
		y 37
		approachX 315
		approachY 242
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 552 1 581 38 603 56 638 74 638 1
					yourself:
				)
		)
		(super init: &rest)
		(foDisco2 init:)
		(AddDefaultVerbs self)
	)
)

(instance foDisco2 of Feature
	(properties
		noun 9
		x 29
		y 25
		approachX 315
		approachY 242
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 50 35 27 59 1 0 0 yourself:)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPalms of Feature
	(properties
		noun 7
		x 264
		y 181
		approachX 315
		approachY 242
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 273 352 280 250 281 149 276 92 233 121 234 140 196 111 170 161 155 216 147 244 138 255 117 248 114 232 101 233 102 245 98 254 67 177 41 118 31 118 11 141 7 125 12 111 1 113 2 97 9 75 38 60 9 48 20 41 51 49 69 23 87 17 75 46 101 43 117 52 79 75 63 97 76 116 51 120 100 227 110 226 87 136 70 92 77 85 104 157 120 220 123 242 132 245 155 177 183 115 161 122 159 107 185 90 162 71 191 73 204 84 219 74 240 77 243 65 184 58 200 42 234 34 213 7 245 9 270 24 278 33 316 10 354 12 326 43 358 47 372 59 326 72 345 90 351 111 291 86 294 141 299 216 298 332 314 333 359 203 393 128 418 87 368 105 368 77 400 46 412 44 377 26 358 3 389 3 422 14 432 25 465 4 491 4 486 24 470 37 512 48 528 71 492 68 455 57 467 84 463 136 428 88 396 149 373 208 337 321 329 359
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSlots of Feature
	(properties
		noun 6
		x 441
		y 202
		approachX 409
		approachY 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 375 205 511 130 528 130 528 154 358 274 354 274
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(foSlots2 init:)
		(foSlots3 init:)
		(foSlots4 init:)
	)
)

(instance foSlots2 of Feature
	(properties
		noun 6
		x 415
		y 155
		approachX 409
		approachY 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 400 141 423 130 441 133 444 153 386 181
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSlots3 of Feature
	(properties
		noun 6
		x 339
		y 185
		approachX 409
		approachY 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 299 180 379 150 362 192 302 220
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSlots4 of Feature
	(properties
		noun 6
		x 252
		y 218
		approachX 409
		approachY 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 226 204 278 185 280 188 280 228 241 251 225 245
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHuts of Feature
	(properties
		noun 11
		x 223
		y 193
		approachX 259
		approachY 256
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 230 191 197 202 207 207 207 221 191 214 192 207 178 183 173 180 149 196 131 207 145 214 151 231 136 235 136 245 158 249 158 266 140 281 163 279 183 225 203 223 247 205 249 190 255 191 245 176 243 172 253
					yourself:
				)
		)
		(super init: &rest)
		(foHuts2 init:)
		(foHuts3 init:)
		(AddDefaultVerbs self)
	)
)

(instance foHuts2 of Feature
	(properties
		noun 11
		x 312
		y 159
		approachX 259
		approachY 256
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 297 158 316 139 328 167 299 179
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHuts3 of Feature
	(properties
		noun 11
		x 38
		y 199
		approachX 259
		approachY 256
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 267 36 260 40 240 33 241 14 248 0 242 1 149 8 138 20 136 31 143 45 132 56 151 61 172 47 179 28 180 24 190 34 205 30 225 41 232 37 221 60 197 77 224 76 258
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foTikis of Feature
	(properties
		noun 12
		x 519
		y 94
		approachX 544
		approachY 118
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 514 74 532 72 532 108 522 115 507 116 509 89
					yourself:
				)
		)
		(super init: &rest)
		(foTikis2 init:)
		(AddDefaultVerbs self)
	)
)

(instance foTikis2 of Feature
	(properties
		noun 12
		x 587
		y 100
		approachX 544
		approachY 118
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 582 75 590 72 600 77 597 123 584 129 575 123 574 102
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foVolcano of Feature
	(properties
		noun 8
		x 137
		y 130
		approachX 259
		approachY 256
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 99 132 114 105 100 86 133 68 156 75 175 89 160 100 147 102 163 149 147 192 116 192
					yourself:
				)
		)
		(super init: &rest)
		(foVolcano2 init:)
		(foVolcano3 init:)
		(AddDefaultVerbs self)
	)
)

(instance foVolcano2 of Feature
	(properties
		noun 8
		x 175
		y 175
		approachX 259
		approachY 256
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 160 190 172 161 191 185 yourself:)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foVolcano3 of Feature
	(properties
		noun 8
		x 87
		y 170
		approachX 259
		approachY 256
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 76 166 90 150 99 191 87 189
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foEscalator of Feature
	(properties
		noun 10
		x 574
		y 183
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 604 237 602 229 557 139 543 136 544 145 548 146 593 234
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExitDoor of ExitFeature
	(properties
		x 554
		y 81
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 536 106 533 91 533 78 541 72 534 67 543 57 565 56 576 65 572 74 575 82 572 94 566 106
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 360 544 118 1)
	)
)

(instance foExitBreak of ExitFeature
	(properties
		x 579
		y 184
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 609 234 614 226 614 219 563 129 548 126 543 136 558 140 605 236
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soGoBreakroom)
	)
)

(instance oFartCUPlane of Plane
	(properties
		picture 37400
	)

	(method (init)
		(gThePlane drawPic: -1)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(Palette 1 374) ; PalLoad
	)

	(method (dispose)
		(gThePlane drawPic: 37000)
		(Palette 1 370) ; PalLoad
		(super dispose: &rest)
	)
)

(instance poFarter of Prop
	(properties
		x 74
		y 479
		cycleSpeed 9
		view 37400
	)
)

(instance toBonds of Talker
	(properties)

	(method (init)
		(= x (poBonds x:))
		(= y (poBonds y:))
		(super init: poBondsMouths voBondsBusts)
		(poBonds hide:)
	)

	(method (dispose)
		(poBonds show:)
		(super dispose:)
	)
)

(instance poBondsMouths of Prop
	(properties
		loop 1
		view 37000
	)

	(method (init)
		(= x (poBonds x:))
		(= y (poBonds y:))
		(self setPri: (+ (poBonds priority:) 1))
		(super init: &rest)
	)
)

(instance voBondsBusts of View
	(properties
		view 37000
	)

	(method (init)
		(= x (poBonds x:))
		(= y (poBonds y:))
		(self setPri: (poBonds priority:))
		(super init: &rest)
	)
)

(instance toWaitress of Talker
	(properties)

	(method (init)
		(= x (aoWaitress x:))
		(= y (aoWaitress y:))
		(super init: poWaitressMouth voWaitressBust)
		(aoWaitress hide:)
	)

	(method (dispose)
		(aoWaitress show:)
		(super dispose:)
	)
)

(instance poWaitressMouth of Prop
	(properties
		loop 2
		view 37010
	)

	(method (init)
		(= x (aoWaitress x:))
		(= y (aoWaitress y:))
		(self setPri: (+ (aoWaitress priority:) 1))
		(super init: &rest)
	)
)

(instance voWaitressBust of View
	(properties
		loop 1
		view 37010
	)

	(method (init)
		(= x (aoWaitress x:))
		(= y (aoWaitress y:))
		(self setPri: (aoWaitress priority:))
		(super init: &rest)
	)
)

(instance oSFX of TPSound
	(properties)
)

(instance oSFX2 of TPSound
	(properties)
)

