;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use foEExit)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro330 0
)

(local
	local0
	local1
	local2
	local3
)

(instance ro330 of L7Room
	(properties
		picture 33000
	)

	(method (init)
		(super init: &rest)
		(gEgo init: setScaler: Scaler 90 19 259 182)
		(= local1 0)
		(switch gPrevRoomNum
			(323 ; ro323
				(gEgo normalize: 2 1 posn: 236 174)
			)
			(331 ; ro331
				(gEgo normalize: 0 1 posn: 513 318)
			)
			(340 ; ro340
				(gEgo normalize: 1 1 posn: 400 230)
			)
			(540 ; ro540
				(gEgo normalize: 0 1 posn: 120 220)
			)
			(else
				(gEgo normalize: 1 1 posn: 400 230)
			)
		)
		(gEgo doit:)
		(if (OneOf gPrevRoomNum 331 340 341 360 363) ; ro331, ro340, ro341, ro360, ro363
			(if (gOMusic1 isPlaying:)
				(gOMusic1 setRelVol: 50)
			else
				(gOMusic1 setMusic: 34000 setRelVol: 50)
			)
		else
			(gOMusic1 setMusic: 34000 setRelVol: 50)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 414 227 357 214 265 205 250 174 230 173 240 207 122 210 100 221 95 240 18 300 23 397 220 454 494 449 577 406 561 339 494 285 420 251
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 493 299 518 323 540 360 493 383 441 400 348 410 294 408 206 406 113 393 34 370 30 344 67 295 146 303 301 294
					yourself:
				)
		)
		(= global330 0)
		(foMeatLoaf init:)
		(foMushrooms init:)
		(foLimaBeans init:)
		(foGreekSalad init:)
		(foCousCous init:)
		(foYogurt init:)
		(foIceMermaid init:)
		(foDrinks init:)
		(foCeiling init:)
		(foUvula init:)
		(foFarSigns init:)
		(foLeftTable init:)
		(foRightTable init:)
		(foExitLobby init:)
		(foExitKitchen init:)
		(foFarDoor init:)
		(foBeanDip init:)
		(foNachos init:)
		(foServingLine1 init:)
		(foServingLine2 init:)
		(foServingLine3 init:)
		(foServingLine4 init:)
		(foServingLine5 init:)
		(foServingLine6 init:)
		(foHotMeat init:)
		(if (not ((ScriptID 64017 0) test: 268)) ; oFlags
			(poWangStand init:)
		)
		(if (not ((ScriptID 64017 0) test: 71)) ; oFlags
			(voKnife init:)
		)
		(if (not ((ScriptID 64017 0) test: 230)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 367 459
				setDest: 425 510
				loop: 0
				cel: 0
				setPri: 500
				setScaleDirect: 70
				nMyFlag: 230
				init:
			)
		)
		(poALarry init: hide:)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((> (gEgo y:) 259)
				(if (!= local1 1)
					(gEgo setScaler: Scaler 158 88 430 260 doit:)
					(= local1 1)
				)
			)
			((!= local1 0)
				(gEgo setScaler: Scaler 90 19 259 182 doit:)
				(= local1 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(= global330 0)
		(switch newRoomNumber
			(331 ; ro331
				(gOMusic1 setRelVol: 50)
			)
			(else
				(gOMusic1 setRelVol: 100)
			)
		)
		(gOSound1 stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance soCantHoldItAnyLonger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo moveSpeed:))
				(gEgo setSpeed: 7 setHeading: 180 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(gEgo view: 6012 loop: 0 cel: 0 setCycle: End self)
				(gOSound1 playSound: 37405 self)
			)
			(3 0)
			(4
				((ScriptID 64017 0) clear: 68) ; oFlags
				(gEgo
					deleteHotspotVerb: 11
					normalize: 2 1
					setSpeed: register
				)
				(gMessager say: 1 11 6 0 self 60) ; "Mayday! Mayday! Mayday!! Man overboard."
			)
			(5
				(= global215 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soFirstEatDip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poALarry
					view: 33005
					loop: 0
					cel: 0
					posn: 70 261
					show:
					setCycle: CT 12 1 self
				)
				(gEgo hide:)
			)
			(1
				(= local0 0)
				(gMessager say: 9 92 0 1 coEndTalk) ; "(SLURPING MUNCHING SOUNDS) Mmmm. (CHEW) I love bean dip! (SMACK LIPS)"
				(poALarry setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(3
				(poALarry setCycle: End self)
			)
			(4
				(gEgo normalize: 5 1 show:)
				(poALarry hide:)
				(gMessager say: 9 92 0 2 self) ; "Just because it's "all you can eat" doesn't mean you're obligated to make yourself sick!"
			)
			(5
				(gMessager say: 9 92 0 3 self) ; "Why not?"
			)
			(6
				(= register (gEgo cycleSpeed:))
				(gEgo setSpeed: 8 setHeading: 135 self)
			)
			(7
				(= cycles 3)
			)
			(8
				(gOSound1 playSound: 37401 self)
				(gEgo view: 6000 loop: 0 cel: 0 setCycle: End self)
			)
			(9 0)
			(10
				(gEgo normalize: 4 1 setSpeed: register)
				(gMessager say: 1 11 2 2 self 60) ; "I don't think anyone will even notice that "wee little laddie.""
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soEatDip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poALarry
					view: 33005
					loop: 0
					cel: 0
					posn: 70 261
					show:
					setCycle: End self 2 6 9999
				)
				(gEgo hide:)
			)
			(1
				(gOSound1 playSound: 33101)
			)
			(2
				(gOSound1 playSound: 33102)
			)
			(3
				(gEgo normalize: 5 1 show:)
				(poALarry hide:)
				(if local3
					(= cycles 1)
				else
					(gMessager sayRange: 9 92 3 1 3 self) ; "You know, Larry, they only put 239 beans in that bowl of dip."
				)
			)
			(4
				(if local3
					(= cycles 1)
				else
					(gOSound1 playSound: 24407 self)
				)
			)
			(5
				(if local3
					(= cycles 1)
				else
					(= local3 1)
					(gMessager say: 9 92 3 4 self) ; "(TO SELF) That sounds like a Mark Seibert joke!"
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDrool of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 show: setCycle: Fwd)
				(= ticks (Random 60 150))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= ticks 30)
			)
			(3
				(client hide:)
				(= ticks (Random 300 450))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance soArmTwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 cycleSpeed: (Random 7 15) show: setCycle: Fwd)
				(= ticks (Random 30 300))
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(= ticks (Random 300 900))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance soDoorListen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 236 172 self 1 1 1)
			)
			(1
				(= global330 0)
				(gOSound1 playSound: 32101 self)
			)
			(2
				(gMessager say: 6 221 0 1 self) ; "Wow."
			)
			(3
				(gMessager say: 6 221 0 2 self) ; "This ship has everything!"
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soHotMeat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 513 318 self 1 1 1)
			)
			(1
				(if ((ScriptID 64017 0) test: 268) ; oFlags
					(gMessager say: 3 1 0 0 self) ; "The hot meat serving station is presently unattended."
				else
					(gMessager say: 3 1 2 0 self) ; "That's a special table serving hot meat."
				)
			)
			(2
				(gCurRoom newRoom: 331) ; ro331
				(self dispose:)
			)
		)
	)
)

(instance soWang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 513 318 self 1 1 1)
			)
			(1
				(gCurRoom newRoom: 331) ; ro331
				(self dispose:)
			)
		)
	)
)

(instance poWangStand of Prop
	(properties
		noun 18
		priority 200
		x 600
		y 220
		view 33000
		approachX 513
		approachY 318
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(poWangEyes init:)
		(poWangDrool init:)
		(poWangArm init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: soWang)
			)
			(4 ; Talk
				(gCurRoom setScript: soWang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poWangEyes of Prop
	(properties
		priority 202
		loop 1
		view 33000
		fixPriority 1
	)

	(method (init)
		(= x (poWangStand x:))
		(= y (poWangStand y:))
		(super init: &rest)
		(self cycleSpeed: 10)
		(self setCycle: Blink 130)
	)
)

(instance poWangDrool of Prop
	(properties
		priority 230
		loop 2
		view 33000
		fixPriority 1
	)

	(method (init)
		(= x (poWangStand x:))
		(= y (poWangStand y:))
		(super init: &rest)
		(self setScript: soDrool)
	)
)

(instance poWangArm of Prop
	(properties
		priority 202
		loop 3
		view 33000
		fixPriority 1
	)

	(method (init)
		(= x (poWangStand x:))
		(= y (poWangStand y:))
		(super init: &rest)
		(self setScript: soArmTwitch)
	)
)

(instance poALarry of Prop
	(properties
		x 72
		y 261
		view 33005
	)
)

(instance voKnife of View
	(properties
		x 563
		y 279
		view 33010
	)
)

(instance foBeanDip of Feature
	(properties
		noun 9
		x 20
		y 200
		approachX 70
		approachY 261
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 25 223 44 217 42 200 38 198 34 191 29 188 19 188 15 191 9 195 2 199 1 202 4 206 3 220 12 222
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(92 ; Eat
				((ScriptID 64017 0) set: 68) ; oFlags
				(gEgo addHotspotVerb: 11)
				(cond
					((> (++ global215) 3)
						(gCurRoom setScript: soCantHoldItAnyLonger)
					)
					(local2
						(gCurRoom setScript: soEatDip)
					)
					(else
						(gCurRoom setScript: soFirstEatDip)
						(= local2 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foFarDoor of Feature
	(properties
		noun 6
		x 236
		y 159
		approachX 236
		approachY 172
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 228 149 244 152 243 170 228 170
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(if ((ScriptID 64017 0) test: 66) ; oFlags
			(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
			(self addHotspotVerb: 221 97)
		else
			(self addHotspotVerb: 221 61 97)
		)
	)

	(method (doVerb theVerb)
		(if ((ScriptID 64017 0) test: 66) ; oFlags
			(gCurRoom exitRoom: 323 236 174 1)
		else
			(switch theVerb
				(1 ; Look
					(if ((ScriptID 64017 0) test: 66) ; oFlags
						(gMessager say: 6 1 1) ; "Now you know: that door hid the Blind Dessert Tasting. And now it's wide open."
					else
						(gMessager say: 6 1) ; "There are some signs near that door and more signs on it."
					)
				)
				(221 ; Listen
					(if ((ScriptID 64017 0) test: 66) ; oFlags
						(gMessager say: 6 221 1) ; "Not a sound comes from the Dessert Tasting now."
					else
						(gCurRoom setScript: soDoorListen)
					)
				)
				(61 ; Open
					(if (not ((ScriptID 64017 0) test: 66)) ; oFlags
						(gMessager say: 6 61) ; "This door is locked."
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance foFarSigns of Feature
	(properties
		noun 8
		x 234
		y 156
		approachX 236
		approachY 172
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 162 218 162 214 161 212 152 219 152 219 147 251 148 253 155 256 156 253 165 247 164 247 157 242 151 227 151
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 97)
	)
)

(instance foCeiling of Feature
	(properties
		noun 5
		x 317
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 249 140 581 0 53 0 232 141
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foUvula of Feature
	(properties
		noun 10
		x 302
		y 32
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 288 1 285 9 280 24 283 37 291 45 302 48 311 45 321 35 324 26 318 11 314 3 314 1
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLeftTable of Feature
	(properties
		noun 7
		x 186
		y 178
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 144 204 161 206 209 201 224 191 230 174 228 158 222 155 194 152 176 150 163 155 143 167
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 94)
	)
)

(instance foRightTable of Feature
	(properties
		noun 7
		x 310
		y 178
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 377 203 375 168 352 155 278 150 275 159 250 156 244 166 245 174 255 181 275 193 289 193 313 203 350 206
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 94)
	)
)

(instance foServingLine1 of Feature
	(properties
		noun 2
		x 56
		y 470
		approachX 67
		approachY 384
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 50 478 77 444 113 413 77 400 3 383 0 393 1 474
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92)
	)
)

(instance foServingLine2 of Feature
	(properties
		noun 2
		x 137
		y 470
		approachX 175
		approachY 406
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 478 223 431 217 421 164 413 117 411 110 417 82 440 52 471 52 476 128 478
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92)
	)
)

(instance foServingLine3 of Feature
	(properties
		noun 2
		x 277
		y 470
		approachX 277
		approachY 416
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 347 479 336 445 325 424 321 422 274 421 229 421 224 421 224 426 208 477
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92)
	)
)

(instance foServingLine4 of Feature
	(properties
		noun 2
		x 401
		y 470
		approachX 389
		approachY 411
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 475 477 476 470 452 442 430 418 388 418 337 422 326 427 340 455 348 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92)
	)
)

(instance foServingLine5 of Feature
	(properties
		noun 2
		x 522
		y 470
		approachX 488
		approachY 408
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 603 477 603 477 610 462 610 446 581 426 547 407 530 408 462 416 442 418 434 421 465 455 477 471 476 478
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92)
	)
)

(instance foServingLine6 of Feature
	(properties
		noun 2
		x 596
		y 470
		approachX 581
		approachY 389
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 638 477 638 393 617 387 562 403 555 410 584 427 607 443 609 450 608 465 604 478
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92)
	)
)

(instance foNachos of Feature
	(properties
		noun 1
		x 62
		y 199
		approachX 80
		approachY 251
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 63 211 73 208 76 200 83 196 71 194 64 187 55 185 53 191 46 190 46 196 42 196 43 208 49 214
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92)
	)
)

(instance foMeatLoaf of Feature
	(properties
		noun 11
		x 47
		y 480
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 93 426 93 413 65 405 59 396 47 395 34 390 32 382 28 381 25 354 28 330 31 321 25 318 20 335 21 360 25 380 21 381 20 388 12 387 4 392 1 445 47 469
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foMushrooms of Feature
	(properties
		noun 12
		x 148
		y 480
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 469 203 456 199 445 180 430 163 425 139 424 126 426 124 421 120 419 116 425 114 429 100 438 94 448 98 458 112 471 128 476 147 477 166 477 184 474
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLimaBeans of Feature
	(properties
		noun 13
		x 278
		y 480
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 314 478 321 468 326 455 321 445 308 440 295 437 290 433 287 435 283 432 279 430 275 436 257 436 240 440 230 447 231 454 236 466 244 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foGreekSalad of Feature
	(properties
		noun 14
		x 405
		y 480
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 405 477 427 472 437 466 442 462 449 448 448 441 444 435 453 428 460 421 466 414 466 411 461 406 455 408 443 421 438 433 434 431 429 429 424 426 430 422 428 419 417 424 401 423 385 426 376 428 367 426 362 431 362 434 354 441 348 441 345 446 346 451 353 454 359 466 371 473 392 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCousCous of Feature
	(properties
		noun 15
		x 517
		y 480
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 526 462 554 455 565 447 571 438 570 433 560 425 552 421 544 419 543 413 538 411 524 406 526 401 522 398 512 398 511 394 503 392 500 397 494 399 492 412 482 418 482 421 469 430 463 442 466 449 478 457 494 461 519 463
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foYogurt of Feature
	(properties
		noun 16
		x 609
		y 480
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 616 430 635 427 639 423 637 392 623 390 616 390 610 386 599 369 590 368 595 379 605 391 597 393 582 401 579 409 579 413 584 422 595 427
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foIceMermaid of Feature
	(properties
		noun 4
		x 305
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 323 83 343 90 354 104 353 121 344 140 337 141 329 140 325 144 325 150 336 150 341 160 347 172 359 175 359 190 364 200 360 208 339 216 330 234 333 248 372 262 404 288 401 307 385 320 338 321 300 341 263 382 238 390 216 381 206 358 217 371 235 366 236 356 228 335 237 326 246 323 228 297 228 272 243 250 259 242 254 261 269 282 299 298 307 312 301 321 326 308 330 293 316 288 294 289 279 277 274 258 287 237 305 221 292 177 294 161 306 147 294 124 291 106 311 88
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 7)
	)
)

(instance foDrinks of Feature
	(properties
		noun 17
		x 496
		y 211
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 524 243 527 236 537 237 538 223 542 202 548 184 532 180 500 184 503 203 503 220 498 219 498 213 495 202 489 213 482 197 476 206 472 205 472 196 472 184 463 184 455 201 444 211 451 218 457 219 468 218 470 225 480 231 500 231 500 234 519 242
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHotMeat of Feature
	(properties
		noun 3
		x 578
		y 318
		approachX 513
		approachY 318
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 636 302 637 271 615 261 612 248 572 240 548 230 519 241 519 246 554 263 578 276 593 282 618 302
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: soHotMeat)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foExitLobby of ExitFeature
	(properties
		x 545
		y 149
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 475 107 480 141 476 176 457 224 431 220 431 157 440 104 458 99
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 340 419 230 1)
	)
)

(instance foExitKitchen of ExitFeature
	(properties
		x 82
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 60 89 112 105 107 144 113 197 80 212 52 142
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 540 102 212 1)
	)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local0 1)
	)
)

