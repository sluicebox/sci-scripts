;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 381)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use foEExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro381 0
)

(instance ro381 of L7Room
	(properties
		picture 38100
	)

	(method (init)
		(cond
			((== gPrevRoomNum 380) ; ro380
				(gEgo
					init:
					normalize: 5
					setScaler: Scaler 147 39 472 224
					posn: 537 278
				)
			)
			(((ScriptID 64017 0) test: 265) ; oFlags
				(gEgo
					init:
					normalize: 6
					setScaler: Scaler 147 39 472 224
					posn: 290 407
				)
			)
			(else
				(gEgo
					init:
					normalize: 6
					setScaler: Scaler 147 39 472 224
					posn: 177 466
				)
			)
		)
		(super init:)
		(gOMusic1 setMusic: 53000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 479 262 466 275 506 282 131 474 174 474 555 273
					yourself:
				)
		)
		(if ((ScriptID 64017 0) test: 95) ; oFlags
			(foDoorExit init:)
		else
			(foDoor init:)
			(foLatch init:)
		)
		(foExit init:)
		(poDoor init:)
		(foVoiceScan init:)
		(foEyeScan init:)
		(foTongueScan init:)
		(foCardScan init:)
		(foHandScan init:)
		(foDNAScan init:)
		(foPic1 init:)
		(foPic2 init:)
		(foPic3 init:)
		(foPic4 init:)
		(foPic5 init:)
		(foPic6 init:)
		(foPic7 init:)
		(foPic8 init:)
		(foPic9 init:)
		(foPic10 init:)
		(foThygh init:)
		(poLasers init:)
		(gGame handsOn:)
		(if (not ((ScriptID 64017 0) test: 265)) ; oFlags
			(poGuns init:)
		else
			(foCannons init:)
			(poTrackingGuns init: doit:)
		)
	)

	(method (doit)
		(if (and (not ((ScriptID 64017 0) test: 265)) (<= (gEgo y:) 407)) ; oFlags
			(gEgo setMotion: 0)
			(gCurRoom setScript: soShowGuns)
		)
		(super doit: &rest)
	)
)

(instance oAlarmSound of TPSound
	(properties)
)

(instance soShowGuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 38113 38116 38115)
				((ScriptID 64017 0) set: 265) ; oFlags
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(oAlarmSound playSound: 38116)
				(= ticks 30)
			)
			(2
				(poGuns setCycle: End self 1 8 999)
			)
			(3
				(gOSound1 playSound: 38113)
			)
			(4
				(gOSound1 playSound: 38115)
			)
			(5
				(= cycles 1)
			)
			(6
				(poGuns dispose:)
				(foCannons init:)
				(poTrackingGuns init: doit:)
				(gGame handsOn:)
			)
		)
	)
)

(instance soPushDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((ScriptID 64017 0) test: 279) ; oFlags
					(gMessager say: 1 160 0 2 self) ; "(YOU GIVE UP. HE'S HOPELESS!) Okay. It's your ass!"
				else
					(gMessager say: 1 160 0 0 self) ; "Hey, look! The door doesn't quite latch. I can just walk right in!"
				)
			)
			(1
				(poDoor setCycle: End self)
			)
			(2
				(gEgo walkTo: 579 247 0 1 0 0)
				(= ticks 30)
			)
			(3
				(gGame handsOff:)
				((ScriptID 64017 0) set: 95) ; oFlags
				(gCurRoom newRoom: 380) ; ro380
				(self dispose:)
			)
		)
	)
)

(instance poLasers of Prop
	(properties
		x 21
		y 385
		priority 408
		fixPriority 1
		view 38151
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poTrackingGuns of Prop
	(properties
		noun 21
		y 479
		priority 4
		fixPriority 1
		view 38101
	)

	(method (init)
		(gOSound1 preload: 38113)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((> (= temp0 (gEgo y:)) 390)
				(= temp1 0)
			)
			((and (<= temp0 390) (> temp0 356))
				(= temp1 1)
			)
			((and (<= temp0 356) (> temp0 322))
				(= temp1 2)
			)
			((and (<= temp0 322) (> temp0 288))
				(= temp1 3)
			)
			((<= temp0 288)
				(= temp1 4)
			)
		)
		(if (!= cel temp1)
			(self setScript: soCameraSound)
			(= cel temp1)
		)
		(super doit: &rest)
	)
)

(instance soCameraSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gOSound1 playSound: 38113)
				(= cycles 1)
			)
			(1
				(= ticks 30)
			)
			(2
				(gOSound1 stop:)
				(self dispose:)
			)
		)
	)
)

(instance poGuns of Prop
	(properties
		x 71
		y 313
		priority 3
		fixPriority 1
		view 38100
	)
)

(instance poDoor of Prop
	(properties
		x 562
		y 259
		priority 1
		fixPriority 1
		view 38150
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 95) ; oFlags
			(= cel 2)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance foDoorExit of Feature
	(properties
		approachX 543
		approachY 278
		x 565
		y 169
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 505 253 500 86 630 68 618 270
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soExitDoor)
	)
)

(instance soExitDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 562 259 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 579 247 0 0 0 0)
				(= ticks 30)
			)
			(2
				(gCurRoom newRoom: 380) ; ro380
			)
		)
	)
)

(instance foDoor of Feature
	(properties
		noun 1
		approachX 543
		approachY 278
		x 583
		y 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 505 253 500 86 630 68 618 270
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
		(if (and ((ScriptID 64017 0) test: 285) ((ScriptID 64017 0) test: 279)) ; oFlags, oFlags
			(foDoor addHotspotVerb: 160)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (poTrackingGuns plane:)
					(gMessager say: 1 1 1 0) ; "Intense security is this door's hallmark. To its left is a keycard scanner, a retinal scanner, a fingerprint scanner, a voiceprint scanner, a tongueprint scanner, and an auto-DNA sampler. Something tells you it would be better for you to pass all those tests than to fail any one!"
				else
					(gMessager say: 1 1 0 0) ; "You wonder where that door leads."
				)
			)
			(160 ; Push
				(gCurRoom setScript: soPushDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foLatch of Feature
	(properties
		noun 20
		approachX 543
		approachY 278
		x 610
		y 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 610 160 634 162 631 219 610 218
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addApproachVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 1 160 0 1) ; "Hey, look! The door doesn't quite latch. I can just walk right in!"
				((ScriptID 64017 0) set: 279) ; oFlags
				(if ((ScriptID 64017 0) test: 285) ; oFlags
					(foDoor addHotspotVerb: 160)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foExit of ExitFeature
	(properties
		x 613
		y 187
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
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soExitCasino)
	)
)

(instance soExitCasino of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 147 496 self 1 0 1)
			)
			(1
				(gGame handsOff:)
				(gEgo walkTo: 127 496 0 0 0 0)
				(= ticks 10)
			)
			(2
				(gCurRoom newRoom: 370) ; ro370
			)
		)
	)
)

(instance foVoiceScan of Feature
	(properties
		noun 9
		approachX 488
		approachY 266
		x 491
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 477 143 492 143 492 157 478 156
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 146)
	)
)

(instance foEyeScan of Feature
	(properties
		noun 7
		approachX 488
		approachY 266
		x 491
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 478 159 492 160 492 169 478 169
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 146)
	)
)

(instance foTongueScan of Feature
	(properties
		noun 11
		approachX 488
		approachY 266
		x 491
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 479 173 492 171 492 186 481 188
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 146)
	)
)

(instance foHandScan of Feature
	(properties
		noun 8
		approachX 488
		approachY 266
		x 491
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 476 191 496 189 497 206 479 207
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 146)
	)
)

(instance foCardScan of Feature
	(properties
		noun 4
		approachX 488
		approachY 266
		x 491
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 480 210 498 209 498 215 481 217
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 146)
	)
)

(instance foDNAScan of Feature
	(properties
		noun 10
		approachX 488
		approachY 266
		x 491
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 486 219 493 218 496 230 484 232
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 146)
	)
)

(instance foPic1 of Feature
	(properties
		noun 22
		x 75
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 42 73 107 77 109 166 46 166
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPic2 of Feature
	(properties
		noun 22
		x 77
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 45 206 108 202 109 291 51 303
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPic3 of Feature
	(properties
		noun 22
		x 156
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 128 83 183 87 184 164 131 167
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPic4 of Feature
	(properties
		noun 22
		x 160
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 132 199 184 196 189 274 134 284
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPic5 of Feature
	(properties
		noun 22
		x 351
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 335 106 369 109 369 162 333 162
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPic6 of Feature
	(properties
		noun 22
		x 347
		y 213
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 333 187 364 183 363 239 331 243
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPic7 of Feature
	(properties
		noun 22
		x 395
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 382 111 411 114 410 162 380 161
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPic8 of Feature
	(properties
		noun 22
		x 393
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 380 182 409 180 409 229 378 235
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPic9 of Feature
	(properties
		noun 22
		x 436
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 422 116 450 118 450 160 423 160
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPic10 of Feature
	(properties
		noun 22
		x 438
		y 201
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 423 180 453 178 453 218 425 225
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foThygh of Feature
	(properties
		noun 12
		x 258
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 202 76 315 86 315 266 205 289
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCannons of Feature
	(properties
		noun 2
		x 258
		y 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 226 190 291 181 322 212 313 240 290 252 246 269
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

