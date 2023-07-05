;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Scaler)
(use ROsc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro540 0
)

(local
	local0
	local1
	local2
	local3
)

(instance ro540 of L7Room
	(properties
		picture 54000
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 141) ; oFlags
			(= picture 54100)
			(Palette 1 540) ; PalLoad
		)
		(gEgo
			init:
			normalize: 5
			setScaler: Scaler 150 84 369 253
			posn: 561 263
		)
		(super init:)
		(if ((ScriptID 64017 0) test: 141) ; oFlags
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 519 237 478 246 442 241 148 341 207 378 487 275 597 305 508 348 558 364 636 319 636 262
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((= local1 (Polygon new:))
						type: PContainedAccess
						init: 12 379 442 241 479 246 519 236 636 262 636 318 365 476 202 476
						yourself:
					)
					((= local2 (Polygon new:))
						type: PBarredAccess
						init: 155 430 140 407 487 274 597 305 279 469 225 466
						yourself:
					)
			)
		)
		(gOMusic1 setMusic: 38000)
		(poCheeseMaker init:)
		(foStove init:)
		(poStoveDoor init:)
		(if (not ((ScriptID 64017 0) test: 142)) ; oFlags
			(voFishNMag init:)
		)
		(if (not ((ScriptID 64017 0) test: 143)) ; oFlags
			(voPot init:)
		)
		(if (not ((ScriptID 64017 0) test: 144)) ; oFlags
			(voSalt init:)
		)
		(aoOcean init:)
		(if (not ((ScriptID 64017 0) test: 141)) ; oFlags
			(foPole init:)
		)
		(foCaviarMaster init:)
		(foCookiePuss init:)
		(foDrawers init:)
		(foEntrails init:)
		(foFishnet init:)
		(foFishheads init:)
		(foGarbage init:)
		(foGuillotine init:)
		(foHotdogs init:)
		(foNoPest init:)
		(foPoodle init:)
		(foFridge init:)
		(foTowel init:)
		(foSwordfish init:)
		(foTentacles init:)
		(if ((ScriptID 64017 0) test: 141) ; oFlags
			(foPigInPython init:)
		)
		(if (not ((ScriptID 64017 0) test: 284)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 618 221
				setDest: 640 494
				view: 54019
				loop: 0
				cel: 0
				setPri: 481
				nMyFlag: 284
				oAltScript: soDildo
				init:
			)
		)
		(if (not ((ScriptID 64017 0) test: 142)) ; oFlags
			(poStoveDoor setScript: soCyberSniff)
		)
		(foExitEast init:)
		(gGame handsOn:)
	)

	(method (notify)
		(if (gEgo has: ((ScriptID 64037 0) get: 49)) ; oInvHandler, ioBeaverCheese
			(gCurRoom setScript: soMakeQuiche)
		else
			(poCheeseMaker doVerb: 43)
		)
	)

	(method (gimme)
		(gEgo
			get:
				((ScriptID 64037 0) get: 50) ; oInvHandler, ioBeaverMilk
				((ScriptID 64037 0) get: 22) ; oInvHandler, ioLimeJuice
				((ScriptID 64037 0) get: 25) ; oInvHandler, ioMold
				((ScriptID 64037 0) get: 38) ; oInvHandler, ioSalt
				((ScriptID 64037 0) get: 17) ; oInvHandler, ioKumquat
		)
	)

	(method (dispose)
		(gOMusic1 fadeOut:)
		(super dispose:)
	)
)

(instance soCyberSniff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 120)
			)
			(2
				(proc64896_15 7 (if ((ScriptID 64017 0) test: 289) 0 else 1)) ; oFlags
				((ScriptID 64017 0) set: 289) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soMakeQuiche of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 306 476 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(Load 140 54002 54007 54008) ; WAVE
				(gEgo walkTo: 313 479 self 0 0 0)
			)
			(2
				(gMessager say: 0 0 3 0 oCueMe) ; "You set the cute little kitchen timer for exactly 55 minutes, mix the kumquat into your pot of beaver cheese, throw in a few more things you find lying under the kitchen counter, then place the entire mess in a clean baking dish, and slam it in the oven. (BEAT) Well, okay, "a" baking dish."
				(= register (gEgo moveSpeed:))
				(gEgo
					view: 54010
					loop: 0
					cel: 0
					setScale: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(3
				(proc64896_1 1 10 self)
			)
			(4
				(gOSound1 playSound: 54002)
				(aoOcean setScript: 0)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 54200)
				(Palette 1 542) ; PalLoad
				(poTimerDial init:)
				(proc64896_1 0 10 self)
			)
			(5
				(oSFX setAmbient: 54007)
				(poTimerDial setCycle: End self)
			)
			(6
				(oSFX playSound: 54008)
				(gCurRoom drawPic: 54100)
				(Palette 1 540) ; PalLoad
				(poTimerDial dispose:)
				(gEgo view: 54015 loop: 0 cel: 0 posn: 122 352)
				(gCast eachElementDo: #show)
				(aoOcean setScript: soOcean)
				(= cycles 1)
			)
			(7
				(gEgo setCycle: End self 3 5 999)
			)
			(8
				(poStoveDoor hide:)
			)
			(9
				(poStoveDoor view: 54015 loop: 1 cel: 0 posn: 122 352 show:)
				(proc64896_15 8 0)
			)
			(10
				(gEgo
					get: ((ScriptID 64037 0) get: 16) ; oInvHandler, ioQuiche
					put: ((ScriptID 64037 0) get: 49) ; oInvHandler, ioBeaverCheese
					put: ((ScriptID 64037 0) get: 17) ; oInvHandler, ioKumquat
					normalize: 4
					setScaler: Scaler 150 84 369 253
					posn: 125 357
					setSpeed: register
				)
				((ScriptID 64017 0) set: 141) ; oFlags
				((gCurRoom obstacles:) delete: local1)
				((gCurRoom obstacles:) delete: local2)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 519 237 478 246 442 241 86 358 207 378 487 275 597 305 508 348 558 364 636 319 636 262
							yourself:
						)
				)
				(foPole dispose:)
				(foPigInPython init:)
				(= cycles 1)
			)
			(11
				(if local3
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

(instance soMakeCheese of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 54006 54004 54005 33101) ; WAVE
				(gMessager say: 11 43 0 1 self) ; "Let's see... some beaver milk, this mold scraped from my shower wall, a pinch of salt and this lime juice...."
			)
			(1
				(= register (gEgo moveSpeed:))
				(gEgo
					view: 54005
					loop: 0
					cel: 0
					setScaler: 0
					setScale:
					scaleX: 160
					scaleY: 160
					posn: 296 347
					setSpeed: 7
					setCycle: End self 12 21 28
				)
			)
			(2
				(gOSound1 playSound: 54006)
				(gEgo setPri: 500)
			)
			(3
				(gEgo setPri: -1)
			)
			(4
				(gEgo
					setCycle: 0
					normalize: 4
					setScaler: Scaler 150 84 369 253
					posn: 306 344
				)
				(gOSound1 playSound: 54004)
				(poCheeseMaker setCycle: CT 9 1 self)
			)
			(5
				(gOSound1 setAmbient: 54005)
				(poCheeseMaker view: 54007 cel: 1 setCycle: ROsc 4 1 3 self)
			)
			(6
				(poCheeseMaker setCycle: End self 4 self)
			)
			(7
				(gOSound1 playSound: 33101)
			)
			(8
				(gMessager say: 11 43 0 2 self) ; "And voila! Venezuelan Beaver Cheese!"
				(poCheeseMaker view: 54006 loop: 0 cel: 9 setPri: 370)
				(voBowl init:)
				(poCheese init: setCycle: End self)
			)
			(9 0)
			(10
				(gMessager say: 11 43 0 3 self) ; "Phew. That stuff stinks!"
			)
			(11
				(proc64896_15 8)
				(voBowl dispose:)
				(poCheese dispose:)
				(poCheeseMaker setCycle: Beg)
				(gEgo
					get: ((ScriptID 64037 0) get: 49) ; oInvHandler, ioBeaverCheese
					put: ((ScriptID 64037 0) get: 50) ; oInvHandler, ioBeaverMilk
					put: ((ScriptID 64037 0) get: 22) ; oInvHandler, ioLimeJuice
					put: ((ScriptID 64037 0) get: 25) ; oInvHandler, ioMold
					put: ((ScriptID 64037 0) get: 38) ; oInvHandler, ioSalt
					put: ((ScriptID 64037 0) get: 32) ; oInvHandler, ioPot
					setSpeed: register
				)
				((ScriptID 64017 0) set: 140) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soOcean of OceanMotionSin
	(properties
		nCenterY 196
		nRange 12
	)
)

(instance soTakeFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 54001) ; WAVE
				(gMessager sayRange: 10 8 0 1 4 self) ; "That fish has gone bad."
			)
			(1
				((ScriptID 64017 0) set: 142) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 23)) ; oInvHandler, ioMagPage
				(voFishNMag dispose:)
				(gMessager say: 10 8 0 5 self) ; "That's good."
				(gEgo walkTo: 445 250 self)
			)
			(2 0)
			(3
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 54000
					loop: 0
					cel: 0
					posn: 443 246
					setScale: 0
					cycleSpeed: 6
					setCycle: End self 11 999
				)
			)
			(4
				(gOSound1 playSound: 54001)
			)
			(5
				(gEgo
					normalize: 6
					setScaler: Scaler 150 84 369 253
					cycleSpeed: register
					posn: 445 250
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCaviar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 33101) ; WAVE
				(poCaviar init: cel: 0 setCycle: End self)
				(gOSound1 playSound: 33101)
			)
			(1
				(poCaviar cel: 0 dispose:)
				(gMessager say: 7 146 0 0 self) ; "(SQUEEZING CAVIER FROM A DEAD FISH) Unnnngh."
			)
			(2
				((ScriptID 64017 0) set: 138) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soStoveJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 24405) ; WAVE
				(gMessager say: 8 1 0 1 self) ; "Do you know the three principal parts of the common wood stove? The lifter, leg and poker."
			)
			(1
				(gOSound1 playSound: 24405)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soFishnetJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 24405) ; WAVE
				(gMessager sayRange: 9 1 0 1 3 self) ; "These fish must not be very good."
			)
			(1
				(gOSound1 playSound: 24405)
				((ScriptID 64017 0) set: 136) ; oFlags
				(gGame handsOn:)
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
				((ScriptID 50 0) setCycle: End self 21 9999) ; oDildo
			)
			(1
				((ScriptID 50 0) setPri: 479) ; oDildo
			)
			(2
				((ScriptID 50 0) hide:) ; oDildo
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance poCheeseMaker of Prop
	(properties
		noun 11
		priority 373
		x 409
		y 382
		view 54006
		z 100
		approachX 306
		approachY 344
		fixPriority 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(= local0
			(if
				(and
					(gEgo has: ((ScriptID 64037 0) get: 50)) ; oInvHandler, ioBeaverMilk
					(gEgo has: ((ScriptID 64037 0) get: 22)) ; oInvHandler, ioLimeJuice
					(gEgo has: ((ScriptID 64037 0) get: 25)) ; oInvHandler, ioMold
				)
				(gEgo has: ((ScriptID 64037 0) get: 38)) ; oInvHandler, ioSalt
			)
		)
		(switch theVerb
			(43 ; Venezuelan Beaver Milk
				(if local0
					(gCurRoom setScript: soMakeCheese)
				else
					(gMessager say: 11 43 2) ; "Once again, Larry, you're missing something."
				)
			)
			(45 ; Lime Juice
				(self doVerb: 43)
			)
			(44 ; Mold
				(self doVerb: 43)
			)
			(42 ; Salt
				(self doVerb: 43)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self cel: 0)
	)
)

(instance voBowl of View
	(properties
		priority 371
		x 409
		y 282
		loop 1
		view 54007
		fixPriority 1
	)
)

(instance poCheese of Prop
	(properties
		priority 372
		x 409
		y 282
		cycleSpeed 8
		view 54008
		fixPriority 1
	)
)

(instance voFishNMag of View
	(properties
		noun 10
		priority 400
		x 353
		y 319
		loop 2
		view 54050
		approachX 324
		approachY 326
		fixPriority 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gCurRoom setScript: soTakeFish)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poStoveDoor of Prop
	(properties
		noun 8
		x 35
		y 311
		view 54050
		approachX 111
		approachY 361
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(foStove doVerb: theVerb)
	)
)

(instance voPot of View
	(properties
		noun 5
		x 65
		y 457
		loop 1
		view 54050
		z 50
		approachX 145
		approachY 404
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8 setPri: 510)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				((ScriptID 64017 0) set: 143) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voSalt of View
	(properties
		noun 6
		x 67
		y 468
		loop 3
		view 54050
		z 50
		approachX 145
		approachY 404
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8 setPri: 500)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				((ScriptID 64017 0) set: 144) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 38)) ; oInvHandler, ioSalt
				(super doVerb: theVerb)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poTimerDial of Prop
	(properties
		x 333
		y 333
		cycleSpeed 25
		view 54200
	)
)

(instance aoOcean of Actor
	(properties
		priority 5
		x 76
		y 196
		view 54099
		yStep 1
		fixPriority 1
		moveSpeed 4
	)

	(method (init)
		(super init:)
		(self setScript: soOcean)
	)
)

(instance poCaviar of Prop
	(properties
		x 132
		y 185
		view 54040
	)
)

(instance foStove of Feature
	(properties
		noun 8
		x 54
		y 287
		approachX 111
		approachY 361
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 221 22 215 59 215 86 220 99 226 99 231 91 238 86 249 89 258 103 273 109 291 106 304 96 319 98 340 88 344 83 328 62 334 43 334 29 330 33 356 16 360 13 350 9 324 0 314 0 266 15 251 14 238 4 229
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: soStoveJoke)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCaviarMaster of Feature
	(properties
		noun 7
		x 124
		y 193
		approachX 211
		approachY 317
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 179 79 176 87 166 101 166 102 155 117 159 114 149 124 150 124 169 135 167 144 173 160 165 155 193 141 184 136 188 141 198 163 205 170 219 157 237 123 232 117 223 109 225 97 221 97 202 89 199 89 190 78 189
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 146 addApproachVerb: 146)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(146 ; Operate
				(gCurRoom setScript: soCaviar)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foCookiePuss of Feature
	(properties
		noun 25
		x 504
		y 451
		approachX 393
		approachY 459
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 424 435 453 423 483 426 513 439 519 448 534 443 550 459 552 465 597 468 596 479 414 479 412 454
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 7)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(92 ; Eat
				(if ((ScriptID 64017 0) test: 141) ; oFlags
					(gMessager say: 25 92 1) ; "Oops. You should have eaten it earlier!"
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

(instance foDrawers of Feature
	(properties
		noun 12
		x 355
		y 233
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 333 265 335 209 377 201 369 255
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(foDrawers2 init:)
	)
)

(instance foDrawers2 of Feature
	(properties
		noun 12
		x 168
		y 279
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 132 243 208 232 199 306 129 326
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foEntrails of Feature
	(properties
		noun 17
		x 325
		y 372
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 261 348 309 365 362 340 398 357 352 403 311 405 280 390 283 375 269 369 260 382 252 375
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPole of Feature
	(properties
		noun 21
		x 247
		y 184
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 227 225 143 233 142 270 220
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foFishnet of Feature
	(properties
		noun 9
		x 376
		y 42
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 210 0 233 26 224 42 237 48 242 33 248 36 239 59 227 63 224 77 246 70 260 80 259 67 252 59 270 55 290 75 290 84 301 85 300 76 326 71 359 82 401 82 424 69 446 68 440 76 450 75 449 65 479 47 470 60 493 66 491 52 542 1
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: soFishnetJoke)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foFishheads of Feature
	(properties
		noun 14
		x 232
		y 401
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 181 387 228 359 237 361 237 372 254 372 258 378 274 375 283 379 279 392 287 396 286 413 269 426 260 438 231 443 200 434 177 401
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				((ScriptID 64017 0) set: 139) ; oFlags
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foGarbage of Feature
	(properties
		noun 13
		x 468
		y 213
		approachX 445
		approachY 250
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 453 186 466 184 492 184 503 191 498 195 490 239 473 242 458 235 454 222 441 231 433 228 437 203 450 192
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foGuillotine of Feature
	(properties
		noun 3
		x 278
		y 293
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 249 332 250 240 263 239 307 249 303 343 296 348
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHotdogs of Feature
	(properties
		noun 4
		x 546
		y 358
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 454 408 458 390 477 375 508 380 512 388 541 404 552 399 553 370 564 337 544 338 549 324 576 321 582 286 611 280 619 261 632 263 638 284 638 338 629 358 638 371 638 389 619 412 620 416 638 419 638 433 613 455 506 418 496 401 481 396 466 405
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foNoPest of Feature
	(properties
		noun 32
		x 147
		y 59
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 118 136 113 144 86 137 58 149 30 142 6 144 0 158 0 151 8 156 27 153 41 145 57 145 69 155 90 153 103
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPigInPython of Feature
	(properties
		noun 19
		x 402
		y 408
		case 1
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 286 449 311 424 369 413 385 388 414 383 438 395 438 384 430 372 444 363 482 363 489 358 484 343 502 339 523 339 523 342 501 341 490 348 496 362 489 370 450 370 442 377 454 388 455 398 442 408 411 426 383 430 369 427 323 436 309 450 308 463 326 478 287 478 282 457
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				((ScriptID 64017 0) set: 145) ; oFlags
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foFridge of Feature
	(properties
		noun 1
		x 388
		y 160
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 376 201 341 195 341 149 354 150 354 138 374 127 383 109 399 110 398 134 410 138 420 133 414 113 436 122 436 211 419 205 375 209
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)
)

(instance foTowel of Feature
	(properties
		noun 16
		x 491
		y 133
		approachX 487
		approachY 245
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 470 100 495 87 509 93 509 104 514 107 513 114 515 115 516 119 507 120 502 174 497 180 477 178 471 170 472 127 467 123
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 97)
	)
)

(instance foPoodle of Feature
	(properties
		noun 29
		x 103
		y 46
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 83 0 75 36 85 46 93 43 91 86 99 93 109 82 105 65 120 62 120 37 131 37 129 0
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				((ScriptID 64017 0) set: 137) ; oFlags
				(if ((ScriptID 64017 0) test: 141) ; oFlags
					(gMessager say: 29 1 1) ; "What happened to that poodle that was hanging there?!"
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

(instance foSwordfish of Feature
	(properties
		noun 2
		x 379
		y 131
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 299 189 328 136 321 124 322 112 327 99 310 98 323 73 350 84 373 83 391 82 420 75 436 84 450 84 450 99 442 99 452 129 446 151 456 161 460 176 445 167 436 185 438 123 412 110 419 133 413 132 412 139 407 131 401 132 400 107 382 107 376 122 359 135 355 139 357 151 350 152 344 142 337 142 304 190
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foTentacles of Feature
	(properties
		noun 18
		x 105
		y 426
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 125 438 155 435 169 446 172 453 187 463 186 472 206 460 211 469 197 479 1 479 0 373 11 373 19 375 1 390 2 407 11 412 17 426 16 441 68 450 82 449 106 436
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExitEast of ExitFeature
	(properties
		x 575
		y 159
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 516 232 518 85 634 64 631 255
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 330 561 263 1)
	)
)

(instance oSFX of TPSound
	(properties)
)

(instance oCueMe of CueMe
	(properties)

	(method (cue)
		(= local3 1)
	)
)

