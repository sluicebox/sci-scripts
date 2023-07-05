;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use foEExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro230 0
)

(local
	local0 = 1
)

(instance ro230 of L7Room
	(properties
		picture 23000
	)

	(method (init)
		(switch gPrevRoomNum
			(240 ; ro240
				(gEgo
					init:
					normalize: 0
					setScaler: Scaler 152 57 419 197
					posn: 231 238
				)
			)
			(261 ; ro261
				(gEgo
					init:
					normalize:
					setScaler: Scaler 152 57 419 197
					posn: (Max global221 45) (- global222 50)
				)
			)
			(262 ; ro262
				(gEgo
					init:
					normalize: 0
					setScaler: Scaler 152 57 419 197
					posn: 322 206
				)
			)
			(else
				(gEgo
					init:
					normalize: 0
					setScaler: Scaler 152 57 419 197
					posn: 126 333
				)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 289 198 133 283 2 279 2 394 540 395 478 199 445 199 435 214 397 215 369 199
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 294 270 293 250 328 250 327 271
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 326 218 353 218 355 240 325 239
					yourself:
				)
		)
		(gOAmbience setAmbient: 13001)
		(if
			(and
				(or
					(== gPrevRoomNum 261) ; ro261
					(== global219 gCurRoomNum)
					(and (== global219 0) (< (Random 1 100) 50))
					(and (!= global219 gPrevRoomNum) (< (Random 1 100) 50))
				)
				(!= global219 262)
			)
			(aoPeggy init:)
			(gOMusic1 stop: setMusic: 26100)
		else
			(= global219 0)
			(= global220 0)
			(gOMusic1 fadeOut:)
		)
		(foEntrance init:)
		(foGangPlank init:)
		(foRail init:)
		(foBushDildo init:)
		(foBushWeasel init:)
		(foBushCat init:)
		(foExitWest init:)
		(foLoungeEntrance init:)
		(foBackWest init:)
		(gCurRoom setScript: soCyberSniff)
		(if (not ((ScriptID 64017 0) test: 221)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 424 209
				setDest: 250 200
				loop: 1
				cel: 0
				setPri: 180
				setScaleDirect: 77
				nMyFlag: 221
				oAltScript: soDildo
				init:
			)
		)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(oSFXHum stop:)
		(if (not (OneOf newRoomNumber 210 220 230 250 260 261 262)) ; ro210, ro220, ro230, ro250, ro260, ro261, ro262
			(gOAmbience stop:)
		)
		(if (not (OneOf newRoomNumber 230 260 261 262)) ; ro230, ro260, ro261, ro262
			(= global219 0)
			(= global220 0)
		)
		(if (!= newRoomNumber 261) ; ro261
			(gOMusic1 fadeOut:)
		)
		(super newRoom: newRoomNumber)
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
				(if ((ScriptID 64017 0) test: 202) ; oFlags
					(proc64896_15 1 0)
				else
					(proc64896_15 1)
					((ScriptID 64017 0) set: 202) ; oFlags
				)
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
					setStep: 3 10
					setCycle: Walk
					setMotion: MoveTo 418 186 self
				)
			)
			(1
				((ScriptID 50 0) setStep: 4 20 setMotion: MoveTo 402 214 self) ; oDildo
			)
			(2
				((ScriptID 50 0) setStep: 6 30 setMotion: MoveTo 250 200 self) ; oDildo
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soExitBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 285 200 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 230 200 self 0 0 0)
			)
			(2
				(if ((ScriptID 64017 0) test: 311) ; oFlags
					(= cycles 1)
				else
					((ScriptID 64017 0) set: 311) ; oFlags
					(gMessager say: 0 0 1 0 self) ; "Don't you wish you could see the stuff that's back here?"
				)
			)
			(3
				(gCurRoom newRoom: 262) ; ro262
				(self dispose:)
			)
		)
	)
)

(instance soExitLounge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 223 241 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 129 222 self 0 0 0)
			)
			(2
				(gCurRoom newRoom: 240) ; ro240
				(self dispose:)
			)
		)
	)
)

(instance aoPeggy of Actor
	(properties
		noun 4
		x 312
		y 415
		view 26001
		approachDist 1000
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
		(= global219 230)
		(= global220 2)
		(self setLoop: 0 1 cel: 0)
		(if (== gPrevRoomNum 261) ; ro261
			(self posn: global221 global222)
		)
		(self
			setScalePercent: 130
			setSpeed: 9
			setCycle: Walk
			setStep: 13 2
			setMotion: MoveTo -80 415 self
		)
		(Load 140 26109) ; WAVE
		(if (Random 0 1)
			(oSFXHum playSound: 26111)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1 0 0 0 260) ; "Peggy is the ship's surly foul-mouthed deckhand. Heavily affected by a childhood spent watching too many pirate movies, she thinks she's a swashbuckler. She even had her peg leg rigged to accept multiple interchangeable janitorial attachments."
			)
			(4 ; Talk
				(self setMotion: 0)
				(= global224 (gEgo x:))
				(= global225 (gEgo y:))
				(= global226 (gEgo cel:))
				(= global221 (self x:))
				(= global222 (self y:))
				(gCurRoom newRoom: 261) ; ro261
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gOMusic1 fadeOut:)
		(oSFXHum fadeOut:)
		(= global219 260)
		(self dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== cel 1) local0)
				(= local0 0)
				(oSFX playSound: 26109)
			)
			((and (!= cel 1) (not local0))
				(= local0 1)
			)
		)
	)
)

(instance foEntrance of Feature
	(properties
		noun 1
		x 232
		y 144
		approachX 260
		approachY 240
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 131 271 120 148 126 39 149 18 209 18 234 50 331 43 338 47 344 72 343 97 245 101 275 206 251 220 220 89 154 89 149 160 150 201 165 255
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foGangPlank of Feature
	(properties
		noun 2
		x 182
		y 458
		approachX 187
		approachY 413
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 89 358 276 357 276 433 267 433 257 448 261 479 111 477 112 433 98 432 97 376
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRail of Feature
	(properties
		noun 3
		x 50
		y 416
		approachX 120
		approachY 417
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 371 69 370 82 383 84 433 0 432 0 477 101 478 96 382 77 355 0 355
					yourself:
				)
		)
		(super init: &rest)
		(foRail2 init:)
		(foRailBack init:)
		(foRailSide init:)
		(AddDefaultVerbs self)
	)
)

(instance foRail2 of Feature
	(properties
		noun 3
		x 424
		y 431
		approachX 358
		approachY 406
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 275 441 275 376 291 355 631 353 637 361 628 369 623 369 611 433 588 433 604 368 438 369 439 436 423 437 420 369 298 370 291 383 290 440
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRailBack of Feature
	(properties
		noun 3
		x 378
		y 182
		approachX 368
		approachY 207
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 342 169 412 169 414 177 404 178 402 196 343 195
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRailSide of Feature
	(properties
		noun 3
		x 566
		y 263
		approachX 473
		approachY 270
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 500 169 638 357 558 353 545 301 514 241 495 197
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBushDildo of Feature
	(properties
		noun 5
		x 424
		y 133
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 418 165 424 163 430 150 433 133 436 126 433 119 428 115 423 110 423 101 413 101 412 109 419 111 413 118 413 128 415 134 416 146 413 158 413 163
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBushWeasel of Feature
	(properties
		noun 6
		x 491
		y 470
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 469 178 470 197 462 220 451 206 437 206 433 214 434 218 444 217 455 237 455 239 447 241 442 248 450 265 444 275 444 312 457 342 466 354 539 353 548 330 550 312 527 270 520 254 520 240 510 257 517 277 529 308 522 328 510 338 489 315 487 296 483 271 489 222 495 191 494 168 493 163 500 153 495 147 479 152 475 148 478 143 467 138 463 147 453 149 437 162 437 171 445 180 457 180
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBushCat of Feature
	(properties
		noun 7
		x 40
		y 470
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 3 334 17 328 17 308 28 312 39 329 49 338 65 324 67 312 74 315 82 314 107 304 121 298 97 283 88 272 83 247 74 273 69 272 64 241 53 275 50 276 29 250 14 246 0 254 0 331
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
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 40 0 40 480 0 480 yourself:)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 260 -45 335)
	)
)

(instance foLoungeEntrance of ExitFeature
	(properties
		x 203
		y 151
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 254 152 194 150 109 156 91 221 91 231 152 249 221
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitLounge)
	)
)

(instance foBackWest of ExitFeature
	(properties
		x 293
		y 158
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 281 218 254 149 247 101 337 97 340 220
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gCurRoom setScript: soExitBack)
	)
)

(instance oSFX of TPSound
	(properties)
)

(instance oSFXHum of TPSound
	(properties)
)

