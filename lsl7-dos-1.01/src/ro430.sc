;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
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
(use Actor)
(use System)

(public
	ro430 0
	toLarryTalker 1
)

(local
	local0 = 43200
	local1
	local2
	local3
)

(instance ro430 of L7Room
	(properties
		picture 43000
	)

	(method (init)
		(switch gPrevRoomNum
			(340 ; ro340
				(gEgo normalize: 3 posn: 300 458)
				(if
					(or
						((ScriptID 64017 0) test: 167) ; oFlags
						((ScriptID 64017 0) test: 168) ; oFlags
					)
					(= picture 43100)
					(= local0 43300)
					((ScriptID 64017 0) clear: 199) ; oFlags
				)
			)
			(432 ; ro432
				(gEgo normalize: 5 posn: 348 311)
				(= local0 43200)
			)
			(433 ; ro433
				(gEgo normalize: 5 posn: 348 311)
				(= picture 43100)
				(= local0 43300)
			)
			(else
				(gEgo normalize: 3 posn: 300 458)
				(if
					(or
						((ScriptID 64017 0) test: 167) ; oFlags
						((ScriptID 64017 0) test: 168) ; oFlags
					)
					(= picture 43100)
					(= local0 43300)
				)
			)
		)
		(gEgo init: setScaler: Scaler 200 90 471 290)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 394 465 330 343 382 301 356 297 275 322 189 465
					yourself:
				)
		)
		(foExitEast init:)
		(foExitSouth init:)
		(foBeaver init:)
		(foEMBook init:)
		(foFokkerBook init:)
		(foDesk init:)
		(foSubmarine init:)
		(foDiveHelmet init:)
		(foClock init:)
		(foGlobe init:)
		(foLamp init:)
		(foBook01 init:)
		(foBook02 init:)
		(foBook03 init:)
		(foBook04 init:)
		(foBook05 init:)
		(foBook06 init:)
		(foBook07 init:)
		(foBook08 init:)
		(foBook09 init:)
		(foEmptyShelf1 init:)
		(foEmptyShelf2 init:)
		(foEmptyShelf3 init:)
		(foEmptyShelf4 init:)
		(foEmptyShelf5 init:)
		(foEmptyShelf6 init:)
		(foEmptyShelf7 init:)
		(foEmptyShelf8 init:)
		(foEmptyShelf9 init:)
		(foEmptyShelf10 init:)
		(foEmptyShelf11 init:)
		(poOcean init:)
		(if (OneOf gPrevRoomNum 432 433) ; ro432, ro433
			(if (gOMusic1 isPlaying:)
				(gOMusic1 setRelVol: 75)
			else
				(gOMusic1 setMusic: local0 setRelVol: 75)
			)
		else
			(gOMusic1 setMusic: local0 setRelVol: 75)
		)
		(if (not ((ScriptID 64017 0) test: 238)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 206 331
				setDest: 500 331
				loop: 0
				cel: 7
				setScaleDirect: 84
				setPri: 331
				nMyFlag: 238
				init:
			)
		)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 432 433) ; ro432, ro433
			(gOMusic1 setRelVol: 100)
		else
			(gOMusic1 stop: setRelVol: 100)
		)
		(if
			(and
				((ScriptID 64017 0) test: 199) ; oFlags
				(not (OneOf newRoomNumber 430 432)) ; ro430, ro432
			)
			((ScriptID 64017 0) clear: 199) ; oFlags
		)
		(super newRoom: newRoomNumber)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 57) ; oFlags
		((ScriptID 64017 0) set: 85) ; oFlags
	)

	(method (dispose)
		(gOSound1 stop:)
		(super dispose: &rest)
	)
)

(instance soLookFokker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: local1 local2 self 1 1 1)
			)
			(1
				(Face gEgo foFokkerBook)
				(gMessager say: 13 1 0 1 self) ; "Hmm. What's this? A book on that great aircraft manufacturer. "Fokker: More Than Just An Airplane!""
			)
			(2
				(if ((ScriptID 64017 0) test: 57) ; oFlags
					(gMessager say: 13 1 1 1 self) ; "(ENTHUSIASTICALLY) AND it's by Drew Baringmore!"
				else
					(gMessager say: 13 1 3 1 self) ; "By someone named Drew Baringmore, whoever HE is."
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soTakeFokker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 13 8 0 1 2 self) ; "I think I'll scan a little of this first to see if it's something I want to read in depth..."
			)
			(1
				(if ((ScriptID 64017 0) test: 57) ; oFlags
					(gMessager say: 13 8 1 1 self) ; "No woman, even a totally naked one, is worth reading THAT!"
				else
					(gMessager say: 13 8 0 3 self) ; "(LITERALLY YAWN) (Yawn.) I don't think so."
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soTakeEM of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 14 8 0 1 4 self) ; "I think I'll scan a little of this first to see if it's something I want to read in depth..."
			)
			(1
				(if ((ScriptID 64017 0) test: 85) ; oFlags
					(gMessager say: 14 8 2 1 self) ; "Hey! That's what I did... to the horseshoe stake!"
				else
					(= cycles 1)
				)
			)
			(2
				(gMessager sayRange: 14 8 0 5 6 self) ; "(BORING) You too can have fun with electromagnets. Wrap any iron bar with wire and apply electricity and WHEE! You're having Fun...with Electromagnetism!"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 180 walkTo: 320 460 self 1 1 0)
			)
			(1
				((ScriptID 64017 0) clear: 199) ; oFlags
				(gGame handsOff:)
				(gCurRoom newRoom: 340) ; ro340
				(self dispose:)
			)
		)
	)
)

(instance soMotion of OceanMotionSin
	(properties
		nRange 12
	)
)

(instance poOcean of Prop
	(properties
		priority 2
		x 144
		y 236
		view 43099
		fixPriority 1
	)

	(method (init)
		(switch (gCurRoom picture:)
			(43000
				(= view 43099)
			)
			(43100
				(= view 43199)
			)
			(else
				(= view 43099)
			)
		)
		(super init: &rest)
		(self setScript: soMotion)
	)
)

(instance poLarryEyes of Prop ; UNUSED
	(properties)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 2))
		(self setPri: (+ (poLarry priority:) 10))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 10)
	)

	(method (show)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= view (poLarry view:))
		(self setCycle: Blink 10)
		(super show:)
	)
)

(instance foBeaver of Feature
	(properties
		noun 2
		x 547
		y 50
		approachX 344
		approachY 465
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 498 0 487 2 482 1 479 6 483 9 481 11 482 14 478 18 481 23 464 34 464 48 476 49 488 32 490 33 493 39 500 41 512 45 505 47 495 45 489 46 486 51 486 53 489 53 490 60 495 57 500 61 500 56 511 59 522 56 529 66 529 77 525 90 524 101 543 96 547 90 553 86 559 90 584 83 585 75 591 68 600 41 609 27 623 27 630 21 631 16 619 8 603 7 586 13 576 23 573 33 572 45 561 38 565 31 561 23 552 20 537 22 530 21 530 15 549 15 554 5 532 3 521 9 521 3 525 0 527 0
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				((ScriptID 64017 0) set: 117) ; oFlags
				(super doVerb: theVerb)
			)
			(234 ; Milk
				(if (not ((ScriptID 64017 0) test: 249)) ; oFlags
					(ShowEasterEgg)
				)
				((ScriptID 64017 0) set: 249) ; oFlags
				(gMessager say: 2 5) ; "You love the feel of a good beaver, don't you, Larry?"
			)
			(10 ; Screw
				(gMessager say: 2 110) ; "Stuffed or not, you're a man with a mission!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foEMBook of Feature
	(properties
		noun 14
		x 167
		y 348
		approachX 235
		approachY 389
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 195 335 199 337 199 342 191 350 180 362 138 363 136 353 165 334
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				((ScriptID 64017 0) set: 118) ; oFlags
				(gCurRoom setScript: soTakeEM)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foFokkerBook of Feature
	(properties
		noun 13
		x 464
		y 232
		approachX 362
		approachY 405
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 470 215 447 251 456 257 482 249 482 208 472 210
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local3 (self noun:))
				(= local1 (self approachX:))
				(= local2 (self approachY:))
				(gCurRoom setScript: soLookFokker)
			)
			(8 ; Take
				(gCurRoom setScript: soTakeFokker)
				((ScriptID 64017 0) set: 116) ; oFlags
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foDesk of Feature
	(properties
		noun 12
		x 392
		y 255
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 396 225 400 223 402 255 402 287 390 282 392 272 392 273 389 254 386 254 385 244 383 242 392 239 392 237 394 234 391 232 394 229 395 229 396 226
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foDiveHelmet of Feature
	(properties
		noun 16
		x 53
		y 48
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 92 96 92 96 98 91 100 80 94 76 84 76 79 77 68 72 65 61 75 58 86 49 96 42 104 26 106 5 104 0 6 0 2 11 3 25 9 31 12 33 16 43 23 50 35 58 32 63 29 65 17 65 10 62 8 61 1 66 0 69 0 78 3 86 7 89 27 78 32 77
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSubmarine of Feature
	(properties
		noun 15
		x 30
		y 30
		approachX 242
		approachY 394
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 181 134 191 131 195 127 204 132 207 136 210 137 213 134 218 139 222 136 222 132 216 129 215 125 211 123 209 124 199 117 197 108 191 96 178 87 137 62 123 58 113 63 104 76 102 87 103 99
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foClock of Feature
	(properties
		noun 17
		x 230
		y 237
		approachX 269
		approachY 334
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 299 237 222 242 184 236 164 220 180 219 310
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foGlobe of Feature
	(properties
		noun 18
		x 262
		y 226
		approachX 289
		approachY 318
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 273 247 269 246 266 235 272 232 276 223 278 219 281 216 284 213 274 212 269 205 259 202 250 210 248 215 248 219 243 223 241 226 243 230 251 230 256 234 263 235 263 243 257 247 256 248 261 249 268 250
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLamp of Feature
	(properties
		noun 19
		x 354
		y 225
		approachX 345
		approachY 310
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 359 244 361 237 369 236 369 226 361 214 363 208 357 206 349 208 350 214 340 226 342 235 347 235 348 243
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBook01 of Feature
	(properties
		noun 3
		x 581
		y 145
		approachX 394
		approachY 465
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 595 134 571 140 566 146 568 155 571 157 596 152
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8) ; "Nah. You've already read this one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook02 of Feature
	(properties
		noun 4
		x 577
		y 160
		approachX 394
		approachY 465
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 595 165 560 168 558 164 562 158 596 153
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8) ; "Nah. You've already read this one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook03 of Feature
	(properties
		noun 5
		x 76
		y 359
		approachX 196
		approachY 454
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 104 356 99 345 60 342 48 349 48 370 78 377
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8) ; "Nah. You've already read this one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook04 of Feature
	(properties
		noun 6
		x 72
		y 379
		approachX 196
		approachY 454
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 51 392 64 396 68 393 96 372 95 363 78 378 48 370
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8) ; "Nah. You've already read this one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook05 of Feature
	(properties
		noun 7
		x 44
		y 374
		approachX 191
		approachY 463
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 347 41 412 47 410 53 404 51 392 46 339 35 337
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8) ; "Nah. You've already read this one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook06 of Feature
	(properties
		noun 8
		x 183
		y 186
		approachX 256
		approachY 354
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 197 191 199 201 181 200 177 195 174 176 178 165 193
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8) ; "Nah. You've already read this one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook07 of Feature
	(properties
		noun 9
		x 557
		y 440
		approachX 394
		approachY 465
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 557 322 520 329 571 361 591 361 594 338
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8) ; "Nah. You've already read this one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook08 of Feature
	(properties
		noun 10
		x 553
		y 440
		approachX 394
		approachY 465
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 532 344 516 351 519 367 521 371 572 414 585 413 591 365 565 376 548 358
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8) ; "Nah. You've already read this one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook09 of Feature
	(properties
		noun 11
		x 538
		y 440
		approachX 394
		approachY 465
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 544 398 557 399 541 386 527 377 519 388 523 397
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gMessager say: 3 8) ; "Nah. You've already read this one."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foEmptyShelf1 of Feature
	(properties
		noun 1
		x 83
		y 135
		approachX 193
		approachY 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 125 182 132 119 40 89 34 164
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf2 of Feature
	(properties
		noun 1
		x 79
		y 240
		approachX 193
		approachY 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 271 126 190 31 175 33 306 89 283
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf3 of Feature
	(properties
		noun 1
		x 92
		y 417
		approachX 193
		approachY 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 45 434 133 358 140 416 92 476 51 475
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf4 of Feature
	(properties
		noun 1
		x 169
		y 230
		approachX 237
		approachY 387
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 205 253 207 209 132 191 132 270
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf5 of Feature
	(properties
		noun 1
		x 169
		y 301
		approachX 237
		approachY 387
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 206 301 206 258 132 278 136 344
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf6 of Feature
	(properties
		noun 1
		x 314
		y 273
		approachX 320
		approachY 309
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 365 282 367 249 262 259 264 297 320 286
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf7 of Feature
	(properties
		noun 1
		x 440
		y 160
		approachX 362
		approachY 405
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 481 178 476 126 400 155 404 194
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf8 of Feature
	(properties
		noun 1
		x 442
		y 305
		approachX 362
		approachY 405
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 472 352 479 278 406 258 408 305
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf9 of Feature
	(properties
		noun 1
		x 440
		y 365
		approachX 362
		approachY 405
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 462 417 473 362 408 313 408 345
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf10 of Feature
	(properties
		noun 1
		x 545
		y 244
		approachX 394
		approachY 465
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 595 310 598 178 492 187 492 272
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foEmptyShelf11 of Feature
	(properties
		noun 1
		x 521
		y 423
		approachX 394
		approachY 465
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 571 476 574 465 480 370 469 433 493 476
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foExitSouth of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 439 478 419 430 181 430 154 478
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitSouth)
	)
)

(instance foExitEast of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 376 337 402 324 393 153 313 305
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(if
			(and
				((ScriptID 64017 0) test: 167) ; oFlags
				(not ((ScriptID 64017 0) test: 199)) ; oFlags
			)
			(gCurRoom exitRoom: 433 438 302)
		else
			(gCurRoom exitRoom: 432 438 302)
		)
	)
)

(instance poLarry of Prop
	(properties
		priority 50
		x 250
		y 250
		view 11015
		fixPriority 1
	)
)

(instance poLarryMouth of Prop
	(properties)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(self setPri: (+ (poLarry priority:) 10))
		(super init: &rest)
	)
)

(instance toLarryTalker of Talker
	(properties)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= priority (+ (poLarry priority:) 5))
		(poLarryMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(poLarryMouth show:)
	)
)

