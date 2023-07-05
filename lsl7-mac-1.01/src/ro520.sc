;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro520 0
)

(instance ro520 of L7Room
	(properties
		picture 52000
	)

	(method (init)
		(gEgo
			init:
			normalize: 5
			setScaler: Scaler 145 103 472 380
			posn: 589 426
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 3 454 1 475 636 475 636 388 573 397 574 412 146 459 109 440
					yourself:
				)
		)
		(gOMusic1 setMusic: 52000)
		((ScriptID 64017 0) set: 133) ; oFlags
		(foCage init:)
		(foRightTrail init:)
		(foLeftTrail init:)
		(foLog init:)
		(foSexBeavers init:)
		(foHumpBeaver init:)
		(foDrinkBeaver init:)
		(foDoor init:)
		(foBottle init:)
		(foLog init:)
		(foTopTube init:)
		(foExit init:)
		(poLeftTrailBeaver init:)
		(poHangingBeaver init:)
		(poThirstyBeaver init:)
		(poKickingBeaver init:)
		(poRightTrailBeaver init:)
		(gGame handsOn:)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
	)
)

(instance soMilkBeaver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 132) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 50)) ; oInvHandler, ioBeaverMilk
				(gEgo put: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
				(= ticks 60)
			)
			(1
				(gMessager say: 1 234 2 1 self) ; "If you think you're man enough, go ahead!"
			)
			(2
				(gEgo walkTo: 254 460 self 1 1 1)
			)
			(3
				(gEgo normalize: 3 1)
				(proc64896_1 1 10 self)
			)
			(4
				(= ticks 60)
			)
			(5
				(gOMusic1 stop:)
				(oMunchSound stop:)
				(gOSound1 playSound: 52201 self)
				(gCurRoom addRoomPlane: oBeaverPlane)
			)
			(6
				(proc64896_17 100)
				(gOMusic1 playSound: 52200)
				(poSmokingBeaver setCycle: Fwd)
				(poUsedBeaver setCycle: Fwd)
				(poSmokingBeaver2 setCycle: Fwd)
				(poTiredBeaver setCycle: Fwd)
				(= ticks 30)
			)
			(7
				(poShakyBeaver cycleSpeed: 9 setCycle: End self)
			)
			(8
				(gMessager say: 0 0 1 1 self 522) ; "(ENTHUSIASTICALLY) Next!"
			)
			(9
				(= ticks 90)
			)
			(10
				(proc64896_1 1 20 self)
			)
			(11
				(oMunchSound setAmbient: 52001 setRelVol: 100)
				(gCurRoom deleteRoomPlane: oBeaverPlane)
				(gMessager say: 1 234 2 2 self) ; "Was it good for you?"
			)
			(12
				(gOMusic1 setMusic: 38000)
				(proc64896_17 100)
				(gGame handsOn:)
				((ScriptID 90 0) init:) ; oTravelScreen
				(self dispose:)
			)
		)
	)
)

(instance soLeftTrailBeaver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLeftTrailBeaver setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(poLeftTrailBeaver cycleSpeed: (Random 8 12))
				(= ticks (Random 240 400))
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance soHangingBeaver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poHangingBeaver setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(poHangingBeaver cycleSpeed: (Random 12 16))
				(= ticks (Random 120 240))
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance soThirstyBeaver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poThirstyBeaver setCycle: Fwd)
				(= cycles 1)
				(oMunchSound setAmbient: 52001)
			)
			(1
				(poThirstyBeaver cycleSpeed: (Random 8 15))
				(= ticks (Random 60 180))
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance soKickingBeaver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poKickingBeaver setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(poKickingBeaver cycleSpeed: (Random 2 6))
				(= ticks (Random 120 200))
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance soRightTrailBeaver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poRightTrailBeaver setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(poRightTrailBeaver cycleSpeed: (Random 15 30))
				(= ticks (Random 200 400))
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance poLeftTrailBeaver of Prop
	(properties
		noun 1
		approachX 70
		approachY 414
		x 100
		y 350
		view 52000
		cycleSpeed 15
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self setScript: soLeftTrailBeaver)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Pot
				(if ((ScriptID 64017 0) test: 132) ; oFlags
					(gMessager say: 1 234 0 1) ; "That's a nifty idea. What are you going to store the milk in?"
				else
					(gCurRoom setScript: soMilkBeaver)
				)
			)
			(234 ; Milk
				(if (gEgo has: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
					(self doVerb: 41)
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

(instance poHangingBeaver of Prop
	(properties
		noun 1
		approachX 199
		approachY 468
		x 222
		y 183
		view 52001
		cycleSpeed 12
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self setScript: soHangingBeaver)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Pot
				(if ((ScriptID 64017 0) test: 132) ; oFlags
					(gMessager say: 1 234 0 1) ; "That's a nifty idea. What are you going to store the milk in?"
				else
					(gCurRoom setScript: soMilkBeaver)
				)
			)
			(234 ; Milk
				(if (gEgo has: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
					(gCurRoom setScript: soMilkBeaver)
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

(instance poThirstyBeaver of Prop
	(properties
		noun 1
		approachX 369
		approachY 418
		x 365
		y 361
		priority 200
		fixPriority 1
		view 52002
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self setScript: soThirstyBeaver)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Pot
				(if ((ScriptID 64017 0) test: 132) ; oFlags
					(gMessager say: 1 234 0 1) ; "That's a nifty idea. What are you going to store the milk in?"
				else
					(gCurRoom setScript: soMilkBeaver)
				)
			)
			(234 ; Milk
				(if (gEgo has: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
					(gCurRoom setScript: soMilkBeaver)
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

(instance poKickingBeaver of Prop
	(properties
		noun 1
		approachX 459
		approachY 420
		x 414
		y 319
		view 52003
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self setScript: soKickingBeaver)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Pot
				(if ((ScriptID 64017 0) test: 132) ; oFlags
					(gMessager say: 1 234 0 1) ; "That's a nifty idea. What are you going to store the milk in?"
				else
					(gCurRoom setScript: soMilkBeaver)
				)
			)
			(234 ; Milk
				(if (gEgo has: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
					(gCurRoom setScript: soMilkBeaver)
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

(instance poRightTrailBeaver of Prop
	(properties
		noun 1
		approachX 539
		approachY 404
		x 533
		y 303
		view 52004
		cycleSpeed 9
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self setScript: soRightTrailBeaver)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Pot
				(if ((ScriptID 64017 0) test: 132) ; oFlags
					(gMessager say: 1 234 0 1) ; "That's a nifty idea. What are you going to store the milk in?"
				else
					(gCurRoom setScript: soMilkBeaver)
				)
			)
			(234 ; Milk
				(if (gEgo has: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
					(gCurRoom setScript: soMilkBeaver)
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

(instance poSmokingBeaver of Prop
	(properties
		x 435
		y 260
		view 52200
	)
)

(instance poUsedBeaver of Prop
	(properties
		x 265
		y 205
		view 52201
	)
)

(instance poShakyBeaver of Prop
	(properties
		x 30
		y 285
		view 52202
	)
)

(instance poSmokingBeaver2 of Prop
	(properties
		x 220
		y 462
		view 52203
	)
)

(instance poTiredBeaver of Prop
	(properties
		x 514
		y 443
		view 52204
	)
)

(instance foCage of Feature
	(properties
		noun 2
		approachX 210
		approachY 468
		x 307
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 525 400 530 385 520 379 533 302 551 224 577 130 589 129 591 118 512 97 471 86 377 71 240 54 163 49 122 70 75 100 24 137 28 145 31 146 42 204 53 308 57 358 53 361 53 374 113 414 151 445 276 425 377 413 483 401
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRightTrail of Feature
	(properties
		noun 5
		approachX 539
		approachY 404
		x 539
		y 263
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 467 316 507 306 555 300 606 296 639 294 639 232 577 227 521 222 483 220 470 210 462 211 454 219 453 245 441 256 439 267 442 289 449 306 458 314
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLeftTrail of Feature
	(properties
		noun 5
		approachX 70
		approachY 414
		x 68
		y 267
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 336 123 326 133 298 136 248 131 221 120 200 108 190 101 191 92 195 1 195 0 344 38 341 72 337 91 334 103 338
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLog of Feature
	(properties
		noun 4
		approachX 380
		approachY 418
		x 422
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 447 375 446 336 433 311 425 290 425 275 439 258 453 246 461 133 468 0 390 0 388 149 385 235 398 251 407 266 412 278 412 290 400 304 382 321 381 341 377 372 380 376 385 381 396 382 400 381 405 376 408 382 414 382 415 383 418 375 420 381 429 383 436 380 441 378
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSexBeavers of Feature
	(properties
		noun 9
		x 347
		y 356
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 415 382 405 357 392 357 373 339 360 334 349 335 347 336 347 328 342 330 335 332 331 330 322 327 323 327 319 320 316 324 314 326 306 333 302 349 298 352 304 355 311 351 280 361 280 368 287 375 297 377 314 366 322 355 332 355 331 367 324 359 314 381 321 389 329 389 331 383 326 369 330 377 341 377 351 383 348 390 356 392 365 386 391 388 405 388
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Pot
				(if ((ScriptID 64017 0) test: 132) ; oFlags
					(gMessager say: 1 234 0 1) ; "That's a nifty idea. What are you going to store the milk in?"
				else
					(gCurRoom setScript: soMilkBeaver)
				)
			)
			(234 ; Milk
				(if (gEgo has: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
					(gCurRoom setScript: soMilkBeaver)
				else
					(gMessager say: 1 234) ; "That's a nifty idea. What are you going to store the milk in?"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foHumpBeaver of Feature
	(properties
		noun 7
		x 447
		y 356
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 461 288 455 283 437 292 429 279 431 275 445 275 457 259 464 239 464 233 468 233 474 238 477 215 466 203 453 203 450 207 445 200 439 209 439 215 446 217 446 229 431 234 426 231 436 221 436 216 424 217 417 233 426 239 419 255 424 276 427 288 434 300 448 303 460 297
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Pot
				(if ((ScriptID 64017 0) test: 132) ; oFlags
					(gMessager say: 1 234 0 1) ; "That's a nifty idea. What are you going to store the milk in?"
				else
					(gCurRoom setScript: soMilkBeaver)
				)
			)
			(234 ; Milk
				(if (gEgo has: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
					(gCurRoom setScript: soMilkBeaver)
				else
					(gMessager say: 1 234) ; "That's a nifty idea. What are you going to store the milk in?"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foDrinkBeaver of Feature
	(properties
		noun 8
		x 341
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 347 330 360 310 367 300 351 276 324 273 319 294 316 317
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Pot
				(if ((ScriptID 64017 0) test: 132) ; oFlags
					(gMessager say: 1 234 0 1) ; "That's a nifty idea. What are you going to store the milk in?"
				else
					(gCurRoom setScript: soMilkBeaver)
				)
			)
			(234 ; Milk
				(if (gEgo has: ((ScriptID 64037 0) get: 32)) ; oInvHandler, ioPot
					(gCurRoom setScript: soMilkBeaver)
				else
					(gMessager say: 1 234) ; "That's a nifty idea. What are you going to store the milk in?"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foDoor of Feature
	(properties
		noun 6
		x 256
		y 301
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 289 404 296 311 309 218 314 196 258 190 205 190 202 282 200 363 198 413 249 408
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61 82)
	)
)

(instance foBottle of Feature
	(properties
		noun 3
		x 368
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 346 294 358 302 362 296 366 279 373 276 371 271 383 263 392 241 385 235 385 163 373 160 348 166 345 233 345 254 351 266 356 271 353 273 353 276 358 278 355 292 348 285 345 288
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foTopTube of Feature
	(properties
		noun 5
		x 423
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 459 150 476 144 478 0 376 0 369 131 380 142 388 147
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExit of ExitFeature
	(properties
		approachX 320
		approachY 480
		x 620
		y 239
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 639 479 639 0 600 0 600 479
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

(instance oBeaverPlane of Plane
	(properties
		picture 52200
		priority 20
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
		(Palette 1 522) ; PalLoad
		(poSmokingBeaver init:)
		(poUsedBeaver init:)
		(poShakyBeaver init:)
		(poSmokingBeaver2 init:)
		(poTiredBeaver init:)
	)

	(method (dispose)
		(Palette 1 520) ; PalLoad
		(gThePlane drawPic: 52000)
		(super dispose: &rest)
	)
)

(instance oMunchSound of TPSound
	(properties)
)

