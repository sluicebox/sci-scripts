;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 245)
(include sci.sh)
(use Main)
(use DialogPlane)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	ro245 0
)

(instance ro245 of L7Room
	(properties
		picture 24500
	)

	(method (init)
		(gEgo
			init:
			normalize: 3
			setScaler: Scaler 150 100 473 313
			posn: 344 452
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 473 477 508 430 533 417 447 326 321 320 228 434 66 429 194 477
					yourself:
				)
		)
		(if (not ((ScriptID 64017 0) test: 223)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 64 481
				setDest: 443 505
				loop: 0
				cel: 0
				nMyFlag: 223
				setPri: 475
				setScalePercent: 100
				init:
			)
		)
		(foExitSouth init:)
		(if ((ScriptID 64017 0) test: 38) ; oFlags
			(voLubricant init:)
		else
			(voDeodorant init:)
		)
		(if
			(and
				((ScriptID 64017 0) test: 249) ; oFlags
				(not ((ScriptID 64017 0) test: 250)) ; oFlags
			)
			(gCurRoom setScript: soJuggsEgg)
			(return)
		else
			(gOMusic1 setMusic: 38000)
			(voNozzle init:)
		)
		(foButton init:)
		(foBarrel init:)
		(foBoots init:)
		(foClothes init:)
		(foGuns init:)
		(foTrough init:)
		(foRug init:)
		(foDiscs init:)
		(foStereo init:)
		(foHairspray init:)
		(foBales init:)
		(foMirror init:)
		((ScriptID 64017 0) set: 39) ; oFlags
		(gGame handsOn:)
	)

	(method (dispose)
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
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 41)) ; oInvHandler, ioLubricant
		((ScriptID 64017 0) set: 249) ; oFlags
		((ScriptID 64017 0) clear: 250) ; oFlags
	)
)

(instance soJuggsEgg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gEgo dispose:)
				(gOMusic1 stop:)
				(gOSound1 setRelVol: 50 setAmbient: 24501)
				(gCurRoom addRoomPlane: oBlackPlane)
				(gMessager sayRange: 0 0 2 1 2 self) ; "Come on in, Honey."
			)
			(1
				(gCurRoom deleteRoomPlane: oBlackPlane)
				(gOMusic1 setMusic: 24500)
				(ShowEasterEgg 1)
				(poJuggs
					view: 24500
					loop: 0
					cel: 0
					posn: 351 423
					init:
					setCycle: Osc
				)
				(= ticks 120)
			)
			(2
				(gMessager say: 0 0 2 3 self) ; "(3-SECOND SHRIEK!) Yee-haw!"
			)
			(3
				(gOSound1 stop:)
				((ScriptID 64017 0) set: 250) ; oFlags
				(gCurRoom newRoom: 246) ; ro246
			)
		)
	)
)

(instance poJuggs of Prop
	(properties)
)

(instance oBlackPlane of Plane
	(properties)

	(method (init)
		(= picture -1)
		(super init: 0 0 639 479)
	)
)

(instance voDeodorant of View
	(properties
		noun 13
		approachX 78
		approachY 428
		x 61
		y 241
		view 24550
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31 ; Silicone Lubricant
				(gEgo get: ((ScriptID 64037 0) get: 7)) ; oInvHandler, ioDeodorant
				(gEgo put: ((ScriptID 64037 0) get: 41)) ; oInvHandler, ioLubricant
				(gMessager say: 13 31 0 0) ; "Sneaky idea. The Juggs will never notice. The two cans look almost identical!"
				(voLubricant init:)
				((ScriptID 64017 0) set: 38) ; oFlags
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voLubricant of View
	(properties
		noun 14
		approachX 78
		approachY 428
		x 61
		y 241
		view 24550
		loop 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance voNozzle of View
	(properties
		x 445
		y 240
		view 24550
		loop 2
	)
)

(instance foButton of Feature
	(properties
		noun 16
		approachX 349
		approachY 324
		x 347
		y 210
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 331 173 347 174 347 190 331 189
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 160)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(160 ; Push
				(if ((ScriptID 64017 0) test: 159) ; oFlags
					((ScriptID 64017 0) clear: 159) ; oFlags
					(if ((ScriptID 64017 0) test: 41) ; oFlags
						((ScriptID 64017 0) set: 37) ; oFlags
					)
					(gOSound1 playSound: 24502)
				else
					(if ((ScriptID 64017 0) test: 36) ; oFlags
						(gOSound1 playSound: 24502)
					else
						(gEgo setScript: soPushButton)
					)
					((ScriptID 64017 0) set: 159) ; oFlags
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soPushButton of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 16 160 0 1 self) ; "What a surprise. You pushed an unmarked button. You hope nothing bad happens."
			)
			(1
				((ScriptID 64017 0) set: 36) ; oFlags
				(gOSound1 playSound: 24502 self)
			)
			(2
				(gMessager say: 16 160 0 2 self) ; "Whew. Got away with another one!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foExitSouth of ExitFeature
	(properties
		x 613
		y 450
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 429 639 429 639 479 0 479
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

(instance soExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 344 500 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 344 500 0 0 0 0)
				(= ticks 20)
			)
			(2
				(gCurRoom newRoom: 246) ; ro246
			)
		)
	)
)

(instance foBales of Feature
	(properties
		noun 10
		x 93
		y 451
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 351 71 362 69 430 181 438 184 476 2 477
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBarrel of Feature
	(properties
		noun 9
		x 563
		y 418
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 515 378 571 361 637 360 638 477 489 477 501 420
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBoots of Feature
	(properties
		noun 2
		x 297
		y 278
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 219 254 370 252 375 288 360 304 265 298 262 269 220 276
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foClothes of Feature
	(properties
		noun 4
		x 558
		y 342
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 490 97 618 40 635 116 638 358 542 363 479 319
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foGuns of Feature
	(properties
		noun 5
		x 556
		y 341
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 474 56 527 31 525 15 555 0 637 2 639 36 474 109
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foHairspray of Feature
	(properties
		noun 1
		x 426
		y 291
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 374 147 407 110 416 62 430 63 443 106 478 151 464 300 427 309 398 302 385 297 387 250
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foTrough of Feature
	(properties
		noun 7
		approachX 66
		approachY 429
		x 123
		y 345
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 29 291 147 256 202 264 179 276 173 294 140 286 126 277 109 286 101 309 101 335 76 347 37 338
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(77 ; Whiz
				(gEgo setScript: soPeeInTrough)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soPeeInTrough of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo walkTo: 66 429 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(2
				(gMessager say: 7 77 0 1 self) ; "Okay."
			)
			(3
				(gOSound1 playSound: 108 self)
			)
			(4
				(gMessager say: 7 77 0 2 self) ; "Ahhh. Hey! Where's the flusher?!"
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foDiscs of Feature
	(properties
		noun 12
		approachX 315
		approachY 329
		x 293
		y 152
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 225 80 361 69 358 235 273 233 273 222 257 204 275 169 301 170 321 206 355 207 358 114 231 119
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: soLookAtDiscs)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soLookAtDiscs of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 12 1 0 0 self) ; "Each of their songs is on a separate disc. One disc is titled:"
			)
			(1
				(= temp0 (GetNumMessages 245 12 1 3))
				(gMessager say: 12 1 3 (Random 1 temp0) self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foMirror of Feature
	(properties
		noun 6
		x 123
		y 344
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 12 23 155 76 152 182 11 193
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRug of Feature
	(properties
		noun 8
		approachX 343
		approachY 403
		x 343
		y 380
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 293 330 434 333 500 417 488 475 191 475 187 446 293 331
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foStereo of Feature
	(properties
		noun 3
		approachX 315
		approachY 329
		x 311
		y 141
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 269 127 354 125 354 155 276 158
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 79)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(79 ; Play
				(gCurRoom setScript: soSelectMusic)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soSelectMusic of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp1 global270)
				(= global270 0)
				(switch
					(= temp0
						(StackedButtonDialog
							10
							0
							0
							(MakeMessageText 12 1 3 16 245)
							(MakeMessageText 12 1 3 1 245)
							(MakeMessageText 12 1 3 2 245)
							(MakeMessageText 12 1 3 3 245)
							(MakeMessageText 12 1 3 4 245)
							(MakeMessageText 12 1 3 5 245)
							(MakeMessageText 12 1 3 6 245)
							(MakeMessageText 12 1 3 14 245)
							(MakeMessageText 12 1 3 8 245)
							(MakeMessageText 12 1 3 9 245)
						)
					)
					(0
						(gOMusic1 playSound: 24200)
					)
					(1
						(gOMusic1 setMusic: 30000)
					)
					(2
						(gOMusic1 setMusic: 31200)
					)
					(3
						(gOMusic1 setMusic: 34000)
					)
					(4
						(gOMusic1 setMusic: 40000)
					)
					(5
						(gOMusic1 setMusic: 43300)
					)
					(6
						(gOMusic1 setMusic: 51200)
					)
					(7
						(gOMusic1 setMusic: 13000)
					)
					(8
						(gOMusic1 setMusic: 37000)
					)
					(9
						(gOMusic1 setMusic: 25202)
					)
				)
				(= global270 temp1)
				(self dispose:)
			)
		)
	)
)

