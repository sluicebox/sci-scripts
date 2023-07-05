;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 255)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use foEExit)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro255 0
)

(instance ro255 of L7Room
	(properties
		picture 25500
	)

	(method (init)
		(super init: &rest)
		(if (not ((ScriptID 64017 0) test: 34)) ; oFlags
			(gOMusic1 setMusic: 25202)
		else
			(gOMusic1 setMusic: 0)
			(gOAmbience setAmbient: 13001)
		)
		(if (== gPrevRoomNum 256) ; ro256
			(gEgo posn: 539 442 init: normalize: 7)
		else
			(gEgo posn: 103 381 init: normalize: 4)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 68 361 50 382 235 476 327 463 397 479 479 477 590 426 551 409 501 443 416 463 318 444 231 406 144 376
					yourself:
				)
		)
		(foExitWest init:)
		(if (not ((ScriptID 64017 0) test: 34)) ; oFlags
			(poJugg1Top init:)
			(poJugg2Top init:)
			(poJuggsBottom init:)
			(poBubbles init:)
			(foSpa init:)
			(oBubbles setRelVol: 50 setAmbient: 25201)
		)
		(foBucket init:)
		(foPipes init:)
		(foGlasses init:)
		(foBush init:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 210 220 230 250 260 262)) ; ro210, ro220, ro230, ro250, ro260, ro262
			(gOAmbience stop:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance oBubbles of TPSound
	(properties)
)

(instance soTalkToJuggs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 539 442 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gCurRoom newRoom: 256) ; ro256
				(self dispose:)
			)
		)
	)
)

(instance foExitWest of ExitFeature
	(properties
		x 613
		y 480
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
		(gCurRoom exitRoom: 250 -50 362)
	)
)

(instance poJugg1Top of Prop
	(properties
		noun 6
		x 343
		y 432
		view 25500
		approachX 539
		approachY 442
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 46) ; oFlags
			(= case 3)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				((ScriptID 64017 0) set: 206) ; oFlags
				(gEgo setScript: soTalkToJuggs)
			)
			(1 ; Look
				((ScriptID 64017 0) set: 206) ; oFlags
				(gEgo setScript: soTalkToJuggs)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poJugg2Top of Prop
	(properties
		noun 6
		x 362
		y 433
		view 25501
		approachX 539
		approachY 442
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 46) ; oFlags
			(= case 3)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb)
		(poJugg1Top doVerb: &rest)
	)
)

(instance poJuggsBottom of Prop
	(properties
		noun 6
		x 362
		y 433
		view 25503
		approachX 539
		approachY 442
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 46) ; oFlags
			(= case 3)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
		(= cycleSpeed 7)
		(self setCycle: Fwd)
	)

	(method (doVerb)
		(poJugg1Top doVerb: &rest)
	)
)

(instance poBubbles of Prop
	(properties
		x 338
		y 425
		view 25502
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 8)
		(self setCycle: RandCycle)
	)
)

(instance foBucket of Feature
	(properties
		noun 2
		x 138
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 328 1 290 27 225 35 164 30 80 9 49 40 31 40 17 60 0 233 0 243 25 245 42 264 51 263 60 249 68 233 118 233 194 252 278 276 323 266 338 160 360 79 360 38 348
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBush of Feature
	(properties
		noun 7
		x 30
		y 450
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 333 51 358 66 402 119 409 215 433 235 467 235 474 151 478 1 408
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foGlasses of Feature
	(properties
		noun 5
		x 255
		y 350
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 175 372 195 361 202 314 172 296 167 275 222 266 226 241 211 220 215 213 243 208 245 192 235 180 255 176 252 163 246 155 256 147 256 138 249 130 257 128 268 121 256 101 277 98 271 110 270 123 284 135 279 141 279 151 290 156 281 168 284 179 304 180 299 192 291 198 293 215 323 221 296 247 298 271 299 260 343 268 343 281 308 313 315 332 336 338 288 345 291 358 325 367 325 375 253 372 234 378 203 384
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSpa of Feature
	(properties
		noun 4
		x 381
		y 390
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 389 253 377 314 380 329 367 297 356 322 348 395 349 478 364 513 386 513 404 461 429 375 433 331 425 272 406
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1 0 0 0 256) ; "Lucky bubbles!"
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance foPipes of Feature
	(properties
		noun 3
		x 477
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 330 263 355 111 372 105 377 82 564 3 581 13 589 49 579 75 598 71 612 68 625 85 623 123 612 144 430 143 374 281 343 283 343 267
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

