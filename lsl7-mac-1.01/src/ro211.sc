;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use foEExit)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro211 0
)

(instance ro211 of L7Room
	(properties
		picture 21100
	)

	(method (init)
		(Load 140 21100 21101 21102) ; WAVE
		(super init:)
		(gOMusic1 setMusic: 0)
		(gOSound1 setAmbient: 21200)
		(poLarry init:)
		(poCompass init:)
		(poDice init:)
		(poCan init:)
		(poDog init:)
		(poWheel init:)
		(foJunctionBox init:)
		(foPanel init:)
		(foExit init:)
		(if (not ((ScriptID 64017 0) test: 220)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 348 396
				setDest: 560 478
				loop: 0
				cel: 0
				setPri: 396
				nMyFlag: 220
				init:
			)
		)
		(gGame handsOn:)
	)

	(method (dispose)
		(gOSound1 fadeOut:)
		(super dispose:)
	)
)

(instance soSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poDog setCycle: 0)
				(if (!= (poDog cel:) 0)
					(poDog setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(poDog loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(= ticks 30)
			)
			(3
				(poDog setCycle: Beg self)
			)
			(4
				(poDog loop: 0)
				(self dispose:)
			)
		)
	)
)

(instance soBark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 1 cel: 0 setCycle: End self 3 99)
			)
			(1
				(oSFX playSound: 21100)
			)
			(2
				(oSFX stop:)
				(client cel: 3 setCycle: CT 1 -1 self)
			)
			(3
				(client loop: 0 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance soPetDog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poLarry loop: 0 cel: 0 setCycle: End self 3)
			)
			(1
				(poDog setScript: soBark self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTryJunctionBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poLarry loop: 1 cel: 0 setCycle: End self 6)
			)
			(1
				(poDog setScript: soBark self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: End self 6 26 999)
			)
			(1
				(oCanSFX playSound: 21101)
			)
			(2
				(oCanSFX playSound: 21102)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance poLarry of Prop
	(properties
		x 200
		y 400
		view 21101
	)
)

(instance poDog of Prop
	(properties
		noun 8
		x 77
		y 416
		priority 500
		fixPriority 1
		view 21100
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 159)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(159 ; Pet
				(gCurRoom setScript: soPetDog)
			)
			(94 ; Sit
				(self setScript: soSit)
			)
			(else
				(super doVerb: theVerb)
				(if (not script)
					(self setScript: soBark)
				)
			)
		)
	)
)

(instance poCan of Prop
	(properties
		noun 2
		x 533
		y 354
		priority 50
		fixPriority 1
		view 21102
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(foCans1 init:)
		(foCan2 init:)
		(self setScript: soCan)
	)
)

(instance poWheel of Prop
	(properties
		noun 7
		x 533
		y 354
		view 21102
		loop 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self setCycle: Fwd)
	)
)

(instance poDice of Prop
	(properties
		noun 6
		x 584
		y 123
		view 21103
		cycleSpeed 40
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self setCycle: RandCycle -1)
	)
)

(instance poCompass of Prop
	(properties
		noun 1
		x 639
		y 478
		priority 500
		fixPriority 1
		view 21104
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self setCycle: Fwd)
		(foCompass init:)
	)
)

(instance foCompass of Feature
	(properties
		noun 1
		x 561
		y 408
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 489 479 484 445 508 433 537 377 599 339 636 338 638 477
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCans1 of Feature
	(properties
		noun 2
		x 396
		y 350
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 372 351 401 343 402 331 420 331 421 368 379 370
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCan2 of Feature
	(properties
		noun 2
		x 406
		y 239
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 393 253 396 223 420 225 417 255
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foJunctionBox of Feature
	(properties
		noun 3
		x 65
		y 293
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 9 256 93 250 121 258 115 333 31 337 12 330
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 146)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(146 ; Operate
				(gCurRoom setScript: soTryJunctionBox)
			)
			(160 ; Push
				(gCurRoom setScript: soTryJunctionBox)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foPanel of Feature
	(properties
		noun 5
		x 428
		y 272
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 314 257 434 257 543 259 539 285 432 281 334 287
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(foPanel2 init:)
	)
)

(instance foPanel2 of Feature
	(properties
		noun 5
		x 419
		y 58
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 300 66 539 115 428 2 317 1
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExit of ExitFeature
	(properties
		x 545
		y 431
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 70 210 33 239 54 230 136 214 132 200 176 222 186 199 212 210 272 187 377 156 387
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gCurRoom newRoom: 210) ; ro210
	)
)

(instance oSFX of TPSound
	(properties)
)

(instance oCanSFX of TPSound
	(properties)
)

