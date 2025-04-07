;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 311)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use PushButton)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro311 0
)

(local
	local0
	local1
)

(instance ro311 of L7Room
	(properties
		picture 31100
	)

	(method (init)
		(gGame handsOff:)
		(switch gPrevRoomNum
			(312 ; ro313
				(gEgo init: normalize: 3 posn: 390 309)
			)
			(310 ; ro310
				(gEgo init: normalize: 2 posn: 322 312)
			)
			(else
				(gEgo init: normalize: 3 posn: 326 429)
			)
		)
		(super init:)
		(gOMusic1 setMusic: 38000)
		((ScriptID 64017 0) set: 17) ; oFlags
		((ScriptID 64017 0) set: 280) ; oFlags
		(UpdateScreenItem gEgo)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 389 295 245 295 135 477 491 477
					yourself:
				)
		)
		(foOutDoorMid init:)
		(poFlame1 init: hide:)
		(poFlame2 init: hide:)
		(poFlame3 init: hide:)
		(poFlame4 init: hide:)
		(poFlame5 init: hide:)
		(poFlame6 init: hide:)
		(poFlame7 init: hide:)
		(poFlame8 init: hide:)
		(poFlame9 init: hide:)
		(poFlame10 init: hide:)
		(foExitSouth init:)
		(foBreasts1 init:)
		(foBreasts2 init:)
		(foBreasts3 init:)
		(foBreasts4 init:)
		(foBreasts5 init:)
		(foBreasts6 init:)
		(foBreasts7 init:)
		(foBreasts8 init:)
		(foBreasts9 init:)
		(foBreasts10 init:)
		(foCrotches1 init:)
		(foCrotches2 init:)
		(foCrotches3 init:)
		(foCrotches4 init:)
		(foCrotches5 init:)
		(foCrotches6 init:)
		(foCrotches7 init:)
		(foCrotches8 init:)
		(foCrotches9 init:)
		(foCrotches10 init:)
		(foLStatues init:)
		(foRStatues init:)
		(foVault init:)
		(foBuzzer init:)
		(foChandelier1 init:)
		(foChandelier2 init:)
		(voOuterDoor init:)
		(voInnerDoor init:)
		(if
			(or
				(== gPrevRoomNum 310) ; ro310
				(== gPrevRoomNum 312) ; ro313
				((ScriptID 64017 0) test: 62) ; oFlags
				(not ((ScriptID 64017 0) test: 66)) ; oFlags
			)
			(gGame handsOn:)
		else
			(self setScript: soEnterRoom)
		)
		(if (== gPrevRoomNum 312) ; ro313
			(gCurRoom setScript: soVaultDoorCloses)
		)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 66) ; oFlags
		((ScriptID 64017 0) set: 62) ; oFlags
		((ScriptID 64017 0) clear: 65) ; oFlags
		(foOutDoorMid dispose: init:)
	)
)

(instance voLabel of TextItem
	(properties
		back 0
		x 280
		y 240
		font 2510
		fore 87
		maxWidth 400
	)

	(method (init)
		(= text (MakeMessageText 0 0 3 1 311)) ; "Late that evening..."
		(if (not text)
			(return)
		)
		(super init: &rest)
	)
)

(instance voLeaveLabel of TextItem
	(properties
		back 0
		x 280
		y 240
		font 2510
		fore 86
		maxWidth 400
	)

	(method (init)
		(= text (MakeMessageText 0 0 3 1 311)) ; "Late that evening..."
		(if (not text)
			(return)
		)
		(super init: &rest)
	)
)

(instance oBlackPlane of Plane
	(properties)

	(method (init)
		(= picture -1)
		(super init: 0 0 639 479)
	)
)

(instance soVaultDoorCloses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 preload: 31103)
				(voInnerDoor hide:)
				(poDoorOpens
					view: 31104
					loop: 2
					posn: 313 160
					cel: 11
					init:
					setCycle: CT 1 -1 self
				)
				(if ((ScriptID 64017 0) test: 65) ; oFlags
					(= local0 1)
					(gMessager say: 1 58 0 18 coDoneTalking 312) ; "Huh? What's this? (LOOKS) Half a billion dollars worth of stock? (BEAT) But I wanted to get laid! (SIGH)"
				else
					(= local0 0)
				)
			)
			(1
				(gOSound1 playSound: 31103)
				(voInnerDoor init:)
				(poDoorOpens dispose:)
				(= cycles 1)
			)
			(2
				(if local0
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local0 0)
	)
)

(instance soRingBell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gOSound1 playSound: 31104 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soRingBellThenNothing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soRingBell self)
			)
			(1
				(= ticks 120)
			)
			(2
				(gMessager say: 7 160 local1 0 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soAnnetteComesOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((ScriptID 64017 0) test: 312) ; oFlags
					(self setScript: soAnnetteEgg self)
				else
					(self setScript: soRingBell self)
				)
			)
			(1
				(= ticks 180)
			)
			(2
				(gOMusic1 setMusic: 31200)
				(voInnerDoor dispose:)
				(poDoorOpens
					view: 31104
					loop: 2
					posn: 313 160
					cel: 1
					init:
					setCycle: End self
				)
			)
			(3
				(poAnnette
					view: 31104
					loop: 5
					posn: 313 155
					cel: 0
					setPri: 100
					init:
					setCycle: End self 3 999
				)
			)
			(4
				(poAnnette setPri: 220)
				(UpdateScreenItem poAnnette)
			)
			(5
				(gCurRoom newRoom: 312) ; ro313
			)
		)
	)
)

(instance soAnnetteEgg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom addRoomPlane: oEggPlane)
				(Palette 1 315) ; PalLoad
				(gOSound1 preload: 31104)
				(gOMusic1 setMusic: 31200)
				(ShowEasterEgg 1)
				(poAnnette
					view: 31500
					loop: 0
					cel: 0
					posn: 338 408
					init:
					setCycle: End self 26 999
				)
			)
			(1
				(gOSound1 playSound: 31104)
			)
			(2
				(= ticks 30)
			)
			(3
				((ScriptID 64017 0) clear: 312) ; oFlags
				(Palette 1 311) ; PalLoad
				(gCurRoom deleteRoomPlane: oEggPlane)
				(self dispose:)
			)
		)
	)
)

(instance oEggPlane of Plane
	(properties
		picture 31500
	)

	(method (init)
		(super init: 0 0 639 479)
	)
)

(instance soEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(gCurRoom addRoomPlane: oBlackPlane)
				(= cycles 3)
			)
			(1
				(voLabel init:)
				(= cycles 1)
			)
			(2
				(= ticks 180)
			)
			(3
				(voLabel dispose:)
				(gCurRoom deleteRoomPlane: oBlackPlane)
				(gEgo posn: 326 534 show: setMotion: MoveTo 326 429 self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soEnterSuite of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gOSound1 preload: 31101)
				(gEgo hide:)
				(poLarry
					view: 31101
					posn: 313 189
					setPri: 295
					loop: 0
					cel: 0
					cycleSpeed: 7
					init:
					setCycle: End self 5 10 13 99
				)
			)
			(2
				(voOuterDoor dispose:)
				(poOuterDoor
					setPri: 290
					cycleSpeed: (poLarry cycleSpeed:)
					init:
					setCycle: End
				)
				(gOSound1 playSound: 31101)
			)
			(3
				(poLarry setPri: 292)
				(poOuterDoor setPri: 293)
				(UpdateScreenItem poLarry)
				(UpdateScreenItem poOuterDoor)
			)
			(4
				(poLarry setPri: 280)
				(UpdateScreenItem poLarry)
			)
			(5
				(poLarry hide:)
				(gEgo posn: 314 272 normalize: 6 show: walkTo: 351 256 self)
			)
			(6
				(gEgo setHeading: 180 self)
			)
			(7
				(gEgo hide:)
				(poLarry
					view: 31102
					posn: 349 179
					setPri: 280
					loop: 0
					cel: 0
					show:
					setCycle: End self
				)
			)
			(8
				((ScriptID 64017 0) set: 63) ; oFlags
				(gCurRoom newRoom: 310) ; ro310
				(self dispose:)
			)
		)
	)
)

(instance soLeaveExterior of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(gCurRoom drawPic: -1)
				(voLeaveLabel init:)
				(= ticks 90)
			)
			(1
				(gCurRoom newRoom: 551) ; ro551
				(self dispose:)
			)
		)
	)
)

(instance voOuterDoor of View
	(properties
		priority 290
		x 317
		y 184
		view 31150
		fixPriority 1
	)
)

(instance poOuterDoor of Prop
	(properties
		x 253
		y 290
		loop 1
		view 31101
	)
)

(instance voInnerDoor of View
	(properties
		priority 225
		x 313
		y 161
		view 31151
		fixPriority 1
	)
)

(instance poDoorOpens of Prop
	(properties)
)

(instance poAnnette of Prop
	(properties)
)

(instance poLarry of Prop
	(properties)
)

(instance foBreasts1 of Feature
	(properties
		noun 5
		x 86
		y 474
		approachX 145
		approachY 468
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 66 267 93 260 96 279 70 287
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foBreasts2 of Feature
	(properties
		noun 5
		x 114
		y 420
		approachX 156
		approachY 421
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 246 130 238 136 253 109 258
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foBreasts3 of Feature
	(properties
		noun 5
		x 146
		y 377
		approachX 182
		approachY 379
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 136 225 156 220 159 234 140 236
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foBreasts4 of Feature
	(properties
		noun 5
		x 174
		y 341
		approachX 212
		approachY 345
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 161 208 178 204 181 216 164 221
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foBreasts5 of Feature
	(properties
		noun 5
		x 192
		y 301
		approachX 224
		approachY 308
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 187 191 200 186 202 197 187 201
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foBreasts6 of Feature
	(properties
		noun 5
		x 440
		y 301
		approachX 405
		approachY 313
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 433 188 446 190 443 201 430 196
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foBreasts7 of Feature
	(properties
		noun 5
		x 458
		y 339
		approachX 412
		approachY 349
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 454 204 470 206 469 219 452 215
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foBreasts8 of Feature
	(properties
		noun 5
		x 472
		y 374
		approachX 426
		approachY 385
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 475 220 492 226 492 235 473 232
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foBreasts9 of Feature
	(properties
		noun 5
		x 506
		y 419
		approachX 456
		approachY 425
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 501 240 525 245 525 261 497 254
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foBreasts10 of Feature
	(properties
		noun 5
		x 495
		y 468
		approachX 549
		approachY 457
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 535 264 565 270 565 286 535 277
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foCrotches1 of Feature
	(properties
		noun 6
		x 86
		y 474
		approachX 145
		approachY 468
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 63 390 63 401 72 402 75 390
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foCrotches2 of Feature
	(properties
		noun 6
		x 114
		y 420
		approachX 156
		approachY 421
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 101 348 112 346 113 359 100 361
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foCrotches3 of Feature
	(properties
		noun 6
		x 146
		y 377
		approachX 182
		approachY 379
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 133 316 142 313 142 325 133 326
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(231 ; Unzip
				((ScriptID 64017 0) set: 281) ; oFlags
				((ScriptID 64017 0) set: 312) ; oFlags
				(ShowEasterEgg)
				(gMessager say: 0 6 1 1 0 16) ; "You just love to touch, touch, touch."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foCrotches4 of Feature
	(properties
		noun 6
		x 174
		y 341
		approachX 212
		approachY 345
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 159 288 164 285 165 295 155 299
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foCrotches5 of Feature
	(properties
		noun 6
		x 192
		y 301
		approachX 224
		approachY 308
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 259 188 255 192 263 184 266
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foCrotches6 of Feature
	(properties
		noun 6
		x 440
		y 301
		approachX 405
		approachY 313
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 443 255 451 257 445 264 441 261
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foCrotches7 of Feature
	(properties
		noun 6
		x 458
		y 339
		approachX 412
		approachY 349
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 468 286 475 291 475 296 467 295
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foCrotches8 of Feature
	(properties
		noun 6
		x 472
		y 374
		approachX 426
		approachY 385
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 490 314 499 314 501 326 489 326
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foCrotches9 of Feature
	(properties
		noun 6
		x 506
		y 419
		approachX 456
		approachY 425
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 519 347 531 349 531 361 519 357
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foCrotches10 of Feature
	(properties
		noun 6
		x 495
		y 468
		approachX 549
		approachY 457
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 558 388 572 391 572 405 557 400
					yourself:
				)
		)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)
)

(instance foChandelier1 of Feature
	(properties
		x 590
		y 380
	)

	(method (init)
		(= noun 2)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 516 1 639 0 639 44 603 53 582 86 571 46 516 18
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChandelier2 of Feature
	(properties
		x 67
		y 380
	)

	(method (init)
		(= noun 2)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 1 126 1 123 22 68 47 62 79 41 52 1 41
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBuzzer of Feature
	(properties
		noun 7
		x 406
		y 257
		approachX 390
		approachY 309
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 405 191 432 191 430 209 414 216 401 218
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 160)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(160 ; Push
				(cond
					(((ScriptID 64017 0) test: 62) ; oFlags
						(if ((ScriptID 64017 0) test: 65) ; oFlags
							(= local1 5)
							(gCurRoom setScript: soRingBellThenNothing)
						else
							(gCurRoom setScript: soBuzzBoning)
						)
					)
					(((ScriptID 64017 0) test: 66) ; oFlags
						(gMessager say: 7 160 0 0) ; "Remember, Larry: she said she'd leave the door unlocked..."
					)
					(else
						(= local1 6)
						(gCurRoom setScript: soRingBellThenNothing)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soBuzzBoning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(self setScript: soAnnetteComesOut)
			)
		)
	)
)

(instance foVault of Feature
	(properties
		noun 4
		x 318
		y 199
		approachX 321
		approachY 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 39 395 41 406 52 382 226 260 226 235 50
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(if ((ScriptID 64017 0) test: 62) ; oFlags
			(= case 4)
		)
		(if (not ((ScriptID 64017 0) test: 66)) ; oFlags
			(= case 6)
		)
	)
)

(class Flame of Prop
	(properties
		view 31100
	)

	(method (init)
		(self setPri: 289)
		(super init: &rest)
		(= cycleSpeed (Random 5 7))
		(self setCycle: Fwd)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if
			(and
				(<=
					(= temp0
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							approachX
							approachY
						)
					)
					35
				)
				(not (self isNotHidden:))
			)
			(self show:)
		)
		(if (and (> temp0 35) (self isNotHidden:))
			(self hide:)
		)
	)
)

(instance poFlame1 of Flame
	(properties
		x 72
		y 171
		approachX 145
		approachY 468
	)

	(method (init)
		(self setScalePercent: 100)
		(super init: &rest)
	)
)

(instance poFlame2 of Flame
	(properties
		x 111
		y 156
		approachX 156
		approachY 421
	)

	(method (init)
		(self setScalePercent: 90)
		(super init: &rest)
	)
)

(instance poFlame3 of Flame
	(properties
		x 141
		y 150
		approachX 182
		approachY 379
	)

	(method (init)
		(self setScalePercent: 80)
		(super init: &rest)
	)
)

(instance poFlame4 of Flame
	(properties
		x 164
		y 144
		approachX 212
		approachY 345
	)

	(method (init)
		(self setScalePercent: 70)
		(super init: &rest)
	)
)

(instance poFlame5 of Flame
	(properties
		x 187
		y 133
		approachX 224
		approachY 308
	)

	(method (init)
		(self setScalePercent: 60)
		(super init: &rest)
	)
)

(instance poFlame6 of Flame
	(properties
		x 442
		y 135
		approachX 405
		approachY 313
	)

	(method (init)
		(self setScalePercent: 60)
		(super init: &rest)
	)
)

(instance poFlame7 of Flame
	(properties
		x 466
		y 141
		approachX 412
		approachY 349
	)

	(method (init)
		(self setScalePercent: 70)
		(super init: &rest)
	)
)

(instance poFlame8 of Flame
	(properties
		x 488
		y 145
		approachX 426
		approachY 385
	)

	(method (init)
		(self setScalePercent: 80)
		(super init: &rest)
	)
)

(instance poFlame9 of Flame
	(properties
		x 518
		y 154
		approachX 456
		approachY 425
	)

	(method (init)
		(self setScalePercent: 90)
		(super init: &rest)
	)
)

(instance poFlame10 of Flame
	(properties
		x 557
		y 168
		approachX 460
		approachY 457
	)

	(method (init)
		(self setScalePercent: 100)
		(super init: &rest)
	)
)

(instance foOutDoorMid of Feature
	(properties
		noun 3
		x 318
		y 199
		approachX 321
		approachY 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 307 180 306 64 324 64 324 182 333 183 333 191 331 194 334 206 329 218 330 227 321 227 321 289 311 290 308 227 300 227 295 182
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
		(foOutDoorRt init:)
		(foOutDoorLt init:)
		(foOutDoorRtMid init:)
		(foOutDoorLtMid init:)
		(if ((ScriptID 64017 0) test: 62) ; oFlags
			(= case 4)
		)
		(if (not ((ScriptID 64017 0) test: 66)) ; oFlags
			(= case 6)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(61 ; Open
				(if
					(or
						(not ((ScriptID 64017 0) test: 66)) ; oFlags
						((ScriptID 64017 0) test: 62) ; oFlags
					)
					(super doVerb: theVerb &rest)
				else
					(gCurRoom setScript: soEnterSuite)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foOutDoorRt of Feature
	(properties
		noun 3
		x 318
		y 199
		approachX 321
		approachY 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 313 77 313 64 418 64 387 290 318 290 319 279 378 280 401 77
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb)
		(foOutDoorMid doVerb: &rest)
	)
)

(instance foOutDoorLt of Feature
	(properties
		noun 3
		x 318
		y 199
		approachX 321
		approachY 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 313 77 313 65 214 66 246 289 315 290 315 281 256 281 225 78
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb)
		(foOutDoorMid doVerb: &rest)
	)
)

(instance foOutDoorRtMid of Feature
	(properties
		noun 3
		x 318
		y 199
		approachX 321
		approachY 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 331 182 354 182 362 76 373 78 363 183 391 182 389 190 362 190 354 281 344 280 353 190 333 191
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb)
		(foOutDoorMid doVerb: &rest)
	)
)

(instance foOutDoorLtMid of Feature
	(properties
		noun 3
		x 318
		y 199
		approachX 321
		approachY 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 297 191 281 191 286 280 278 281 272 191 241 192 240 181 271 184 259 77 269 78 279 183 296 182
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb)
		(foOutDoorMid doVerb: &rest)
	)
)

(instance foExitSouth of ExitFeature
	(properties
		x 318
		y 456
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 434 637 434 637 477 2 478
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

(instance foLStatues of Feature
	(properties
		noun 1
		x 146
		y 300
		approachX 182
		approachY 379
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 10 295 31 283 65 318 72 296 26 251 70 241 72 200 93 216 106 208 107 181 123 206 140 199 142 172 153 190 159 190 165 159 178 176 188 175 189 148 200 204 220 216 172 302 35 472 22 469 56 383 30 349 31 337 15 313
					yourself:
				)
		)
		(AddDefaultVerbs self)
	)
)

(instance foRStatues of Feature
	(properties
		noun 1
		x 472
		y 300
		approachX 426
		approachY 385
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 443 147 446 178 463 155 470 199 490 168 498 212 518 184 524 228 557 196 563 253 601 249 556 295 573 316 597 286 619 296 575 388 606 465 591 465 540 405 458 291 428 235 412 218 434 208 434 189
					yourself:
				)
		)
		(AddDefaultVerbs self)
	)
)

