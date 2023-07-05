;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use soFlashCyberSniff)
(use Plane)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro250 0
)

(local
	local0
)

(instance ro250 of L7Room
	(properties
		picture 25000
	)

	(method (init)
		(gEgo init:)
		(if (== gPrevRoomNum 255) ; ro255
			(gEgo normalize: 1 posn: 586 429)
		else
			(gEgo normalize: 4 posn: 58 208)
		)
		(gEgo setScaler: Scaler 108 74 421 216)
		(super init:)
		(gOMusic1 setMusic: 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 2 180 2 392 65 477 629 477 629 389 510 452 418 436 355 278 351 260 209 195 118 211 84 199 32 195 22 180
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 20 217 64 222 62 245 17 242
					yourself:
				)
		)
		(foLobby init:)
		(foBush init:)
		(foCourt init:)
		(foCentaur init:)
		(foSlot init:)
		(foStake init:)
		(poTail init:)
		(poLeg init:)
		(poChampagne init:)
		(gOAmbience setAmbient: 13001)
		(if (not ((ScriptID 64017 0) test: 225)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 413 170
				setDest: 371 137
				loop: 1
				cel: 6
				setPri: 170
				setScaleDirect: 46
				nMyFlag: 225
				init:
			)
		)
		(foExitWest init:)
		(foExitEast init:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(cond
			((gEgo has: ((ScriptID 64037 0) get: 14)) ; oInvHandler, ioHorseshoe
				(gMessager say: 0 0 1 0) ; "(MUFFLED) Horseshoes may not be removed from the horseshoe area."
			)
			(local0
				(gMessager say: 0 0 2 0) ; "(MUFFLED) Do not exit the horseshoe area without removing your scorecard from the horse's ass (UNDER BREATH) you horse's ass."
			)
			(else
				(if (not (OneOf newRoomNumber 210 220 230 250 260 262)) ; ro210, ro220, ro230, ro250, ro260, ro262
					(gOAmbience stop:)
				)
				(super newRoom: newRoomNumber)
			)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 46)) ; oInvHandler, ioScorecard
		(gEgo get: ((ScriptID 64037 0) get: 37)) ; oInvHandler, ioRemote
		((ScriptID 64017 0) set: 85) ; oFlags
	)

	(method (dispose)
		((ScriptID 64017 0) clear: 182) ; oFlags
		(super dispose:)
	)
)

(instance oWaves of TPSound ; UNUSED
	(properties)
)

(instance foCourt of Feature
	(properties
		noun 2
		approachX 384
		approachY 425
		x 40
		y 233
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 6 224 50 219 432 401 268 455
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 79)
		(self addExceptionVerb: 79 35)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35 ; Remote Control
				(foStake doVerb: theVerb &rest)
			)
			(79 ; Play
				(foStake doVerb: theVerb &rest)
			)
			(36 ; Horseshoe
				(foStake doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foStake of Feature
	(properties
		noun 1
		approachX 56
		approachY 216
		x 41
		y 234
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 22 233 36 226 38 204 44 204 44 225 64 228 64 233 54 240 33 241 23 237
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 79)
		(self addExceptionVerb: 79 35 36)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35 ; Remote Control
				(if ((ScriptID 64017 0) test: 85) ; oFlags
					((ScriptID 64017 0) set: 4) ; oFlags
					((ScriptID 64017 0) set: 182) ; oFlags
					(gMessager say: 38 3 2 0 0 11) ; "Watch out!"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(36 ; Horseshoe
				(if
					(and
						((ScriptID 64017 0) test: 85) ; oFlags
						((ScriptID 64017 0) test: 182) ; oFlags
					)
					(gCurRoom setScript: soThrowAndWin)
				else
					(gCurRoom setScript: soThrowAndLose)
				)
			)
			(79 ; Play
				(if ((ScriptID 64017 0) test: 45) ; oFlags
					(gMessager say: 2 16 2 0 0 420) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
					(return)
				)
				(cond
					((gEgo has: ((ScriptID 64037 0) get: 14)) ; oInvHandler, ioHorseshoe
						(self doVerb: 36)
					)
					(local0
						(gCurRoom setScript: soGetShoeThenPlay)
					)
					(else
						(gMessager say: 2 79 7 0) ; "First, insert your "Thygh's Man Trophy" scorecard in the cardreader."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soThrowAndLose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 384 425 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64017 0) set: 242) ; oFlags
				(gEgo setHeading: 315 self)
			)
			(2
				(gCurRoom addRoomPlane: oStakeCamPlane)
				(poLarry
					view: 25100
					loop: 0
					cel: 0
					posn: 440 378
					cycleSpeed: 7
					init:
				)
				(= ticks 180)
				(gOSound1 preload: 25003)
			)
			(3
				(poLarry setCycle: End self 10 99)
			)
			(4
				(gOSound1 playSound: 25003)
			)
			(5
				(= ticks 120)
				(gOSound1 preload: 25101)
			)
			(6
				(if (== (GetRandomNumber 1 4) 1)
					(gOSound1 playSound: 32018)
				else
					(gOSound1 playSound: 25101)
				)
				(= ticks 120)
			)
			(7
				(gCurRoom deleteRoomPlane: oStakeCamPlane)
				(gGame handsOn:)
				(gMessager say: 1 36 0 (GetRandomNumber 2 7))
				(gEgo put: ((ScriptID 64037 0) get: 14)) ; oInvHandler, ioHorseshoe
				(self dispose:)
			)
		)
	)
)

(instance soThrowAndWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 384 425 self)
			)
			(1
				(gGame handsOff:)
				((ScriptID 64017 0) set: 242) ; oFlags
				(gEgo setHeading: 315 self)
			)
			(2
				(gCurRoom addRoomPlane: oStakeCamPlane)
				(poLarry
					view: 25100
					loop: 0
					cel: 0
					posn: 440 378
					cycleSpeed: 7
					init:
				)
				(= ticks 180)
				(gOSound1 preload: 25003)
			)
			(3
				(gOSound1 preload: 25102)
				(poLarry setCycle: End self 10 99)
			)
			(4
				(gOSound1 playSound: 25003)
			)
			(5
				(= ticks 120)
				(gOSound1 preload: 25102)
			)
			(6
				(poHorseshoe
					view: 25110
					loop: 0
					cel: 0
					posn: 103 480
					cycleSpeed: 6
					init:
					setCycle: End self 3 999
				)
			)
			(7
				(gOSound1 playSound: 25102)
			)
			(8
				(= cycles 1)
			)
			(9
				(poHorseshoe dispose:)
				(poHorseshoeStack cel: 0 init:)
				(poLight init:)
				(= ticks 60)
			)
			(10
				(poLarry
					cel: 0
					doit:
					cycleSpeed: 5
					setCycle: CycleCueList 14 1 self 10 14
				)
			)
			(11
				(gOSound1 playSound: 25003)
			)
			(12
				(poLarry
					cel: 0
					doit:
					cycleSpeed: 4
					setCycle: CycleCueList 14 1 self 10 14
				)
			)
			(13
				(oAltSound playSound: 25003)
			)
			(14
				(poLarry
					cel: 0
					doit:
					cycleSpeed: 3
					setCycle: CycleCueList 14 1 self 10 14
				)
			)
			(15
				(gOSound1 playSound: 25003)
			)
			(16
				(poLarry cel: 0 doit: cycleSpeed: 2 setCycle: End self 10 999)
			)
			(17
				(gOSound1 playSound: 25003)
			)
			(18
				(poHorseshoe
					view: 25110
					loop: 0
					cel: 0
					posn: 103 480
					cycleSpeed: 4
					init:
					setCycle: End self 3 999
				)
			)
			(19
				(oAltSound playSound: 25102)
			)
			(20
				(= cycles 1)
			)
			(21
				(poHorseshoe dispose:)
				(poHorseshoeStack cel: 1)
				(= ticks 30)
			)
			(22
				(poHorseshoe
					view: 25110
					loop: 0
					cel: 0
					posn: 103 480
					cycleSpeed: 3
					init:
					setCycle: End self 3 999
				)
			)
			(23
				(gOSound1 playSound: 25102)
			)
			(24
				(= cycles 1)
			)
			(25
				(poHorseshoe dispose:)
				(poHorseshoeStack cel: 2)
				(= ticks 20)
			)
			(26
				(poHorseshoe
					view: 25110
					loop: 0
					cel: 0
					posn: 103 480
					cycleSpeed: 2
					init:
					setCycle: End self 3 999
				)
			)
			(27
				(oAltSound playSound: 25102)
			)
			(28
				(= cycles 1)
			)
			(29
				(poHorseshoe dispose:)
				(poHorseshoeStack cel: 3)
				(= ticks 10)
			)
			(30
				(poHorseshoe
					view: 25110
					loop: 0
					cel: 0
					posn: 103 480
					cycleSpeed: 1
					init:
					setCycle: End self 3 999
				)
			)
			(31
				(gOSound1 playSound: 25102)
			)
			(32
				(= cycles 1)
			)
			(33
				(poHorseshoe dispose:)
				(poHorseshoeStack cel: 4)
				(= ticks 120)
			)
			(34
				(gCurRoom deleteRoomPlane: oStakeCamPlane)
				(voHorseshoesLS init:)
				(gGame handsOn:)
				(gMessager say: 1 36 4 0) ; "(MUFFLED) Congratulations! Another ringer!"
				(gEgo put: ((ScriptID 64037 0) get: 14)) ; oInvHandler, ioHorseshoe
				((ScriptID 64017 0) set: 45) ; oFlags
				((ScriptID 80 0) setReal: (ScriptID 80 0) 5) ; oAnnounceTimer, oAnnounceTimer
				(self dispose:)
			)
		)
	)
)

(instance oAltSound of TPSound
	(properties)
)

(instance voHorseshoesLS of View
	(properties
		x 41
		y 230
		view 25075
	)
)

(instance foLobby of Feature
	(properties
		noun 3
		approachX 73
		approachY 199
		x 76
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 129 79 134 115 102 162 103 183 130 214 141 229 127 277 97 304 113 360 105 410 112 453 98 454 79 376 88 306 95 229 75 165 88 125 80 122 75 41 70 40 109 1 100
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
		approachX 73
		approachY 199
		x 76
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 28 177 80 140 112 104 161 106 186 143 197 143 202 189 121 202 89 188 30 188
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCentaur of Feature
	(properties
		noun 4
		approachX 403
		approachY 421
		x 487
		y 388
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 393 312 407 322 412 307 395 284 401 262 437 241 456 256 460 281 494 280 508 226 529 204 519 167 493 156 489 170 477 163 473 132 473 113 498 115 522 132 523 145 512 145 523 154 536 139 559 146 570 167 560 183 634 233 632 240 614 231 607 266 598 266 578 249 571 266 579 302 560 361 572 399 552 402 548 336 519 356 533 382 513 386 510 368 493 384 517 435 503 438 492 435 492 422 485 417 486 397 476 378 483 360 476 359 460 364 447 374 463 418 440 417 433 362 446 347 436 330 409 336 394 326
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; TMT Scorecard
				(foSlot doVerb: 16 &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poChampagne of Prop
	(properties
		x 164
		y 137
		priority 20
		fixPriority 1
		view 25060
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance foSlot of Feature
	(properties
		noun 5
		approachX 403
		approachY 421
		x 487
		y 389
	)

	(method (init)
		(= noun 5)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 446 294 477 297 468 350 441 344
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addExceptionVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; TMT Scorecard
				(if ((ScriptID 64017 0) test: 45) ; oFlags
					(gMessager say: 2 16 2 0 0 420) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
					(return)
				)
				(gEgo setScript: soPutCard)
				(self addHotspotVerb: 8)
			)
			(8 ; Take
				(if (not local0)
					(super doVerb: theVerb &rest)
				else
					(gEgo setScript: soGetCard)
					(self deleteHotspotVerb: 8)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soPutCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(gOSound1 preload: 25001)
				(gEgo hide:)
				(poLarry
					view: 25000
					posn: 403 421
					loop: 0
					cel: 0
					cycleSpeed: 7
					init:
					setCycle: End self 26 99
				)
			)
			(2
				(gEgo put: ((ScriptID 64037 0) get: 46)) ; oInvHandler, ioScorecard
				(= local0 1)
				(gOSound1 playSound: 25001)
			)
			(3
				(= ticks 60)
			)
			(4
				(self setScript: soGetShoe self)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGetCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 410 423 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gOSound1 preload: 25006)
				(gEgo hide:)
				(poLarry
					view: 25000
					posn: 403 421
					loop: 1
					cel: 0
					cycleSpeed: 7
					init:
					setCycle: CycleCueList 8 1 self 7 8
				)
			)
			(3
				(gOSound1 playSound: 25006)
			)
			(4
				(gMessager say: 5 8 6 0 self) ; "(SHOVING YOUR ARM UP THE HORSE'S ASS) Yuck! I hope that's my card."
			)
			(5
				(poLarry setCycle: End self)
			)
			(6
				(= cycles 1)
			)
			(7
				(poLarry dispose:)
				(gEgo show:)
				(gEgo get: ((ScriptID 64037 0) get: 46)) ; oInvHandler, ioScorecard
				(gEgo put: ((ScriptID 64037 0) get: 14)) ; oInvHandler, ioHorseshoe
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGetShoe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(gOSound1 preload: 25005)
				(if (poLarry plane:)
					(poLarry dispose:)
				)
				(poLarry
					view: 25002
					posn: 403 421
					loop: 0
					cel: 0
					cycleSpeed: 7
					init:
					setCycle: End self 3 8 14 99
				)
			)
			(1
				(poTail hide:)
				(poLeg setCycle: End)
				(gOSound1 playSound: 25005)
			)
			(2
				(poTail cel: 0 show: setCycle: End)
			)
			(3
				(poLeg setCycle: Beg self)
			)
			(4
				(= cycles 1)
			)
			(5
				(gEgo get: ((ScriptID 64037 0) get: 14)) ; oInvHandler, ioHorseshoe
				(poLarry dispose:)
				(gEgo posn: 384 425 loop: 8 cel: 7 heading: 315 show:)
			)
			(6
				((ScriptID 64017 0) set: 44) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soGetShoeThenPlay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 403 421 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(self setScript: soGetShoe self)
			)
			(3
				(= ticks 60)
			)
			(4
				(if
					(and
						((ScriptID 64017 0) test: 85) ; oFlags
						((ScriptID 64017 0) test: 182) ; oFlags
					)
					(gCurRoom setScript: soThrowAndWin self)
				else
					(gCurRoom setScript: soThrowAndLose self)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foExitWest of Feature
	(properties
		x 1
		y 1
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
		(cond
			((gEgo has: ((ScriptID 64037 0) get: 14)) ; oInvHandler, ioHorseshoe
				(gMessager say: 0 0 1 0) ; "(MUFFLED) Horseshoes may not be removed from the horseshoe area."
			)
			(local0
				(gMessager say: 0 0 2 0) ; "(MUFFLED) Do not exit the horseshoe area without removing your scorecard from the horse's ass (UNDER BREATH) you horse's ass."
			)
			(else
				(gCurRoom exitRoom: 340 -23 208)
			)
		)
	)
)

(instance foExitEast of Feature
	(properties
		x 613
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 600 0 640 0 640 480 600 480
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(cond
			((gEgo has: ((ScriptID 64037 0) get: 14)) ; oInvHandler, ioHorseshoe
				(gMessager say: 0 0 1 0) ; "(MUFFLED) Horseshoes may not be removed from the horseshoe area."
			)
			(local0
				(gMessager say: 0 0 2 0) ; "(MUFFLED) Do not exit the horseshoe area without removing your scorecard from the horse's ass (UNDER BREATH) you horse's ass."
			)
			(else
				(gCurRoom exitRoom: 255 690 445)
			)
		)
	)
)

(instance poLarry of Prop
	(properties)
)

(instance poTail of Prop
	(properties
		x 493
		y 428
		priority 419
		fixPriority 1
		view 25005
		loop 1
		cel 3
	)
)

(instance poLeg of Prop
	(properties
		x 491
		y 437
		priority 420
		fixPriority 1
		view 25005
	)
)

(instance oStakeCamPlane of Plane
	(properties)

	(method (init)
		(= picture 25100)
		(super init: 0 0 639 479)
	)
)

(instance poHorseshoe of Prop
	(properties
		priority 501
		fixPriority 1
	)
)

(instance poHorseshoeStack of Prop
	(properties
		x 103
		y 480
		view 25110
		loop 1
	)
)

(instance poLight of Prop
	(properties
		x 329
		y 101
		priority 500
		fixPriority 1
		view 25150
	)

	(method (init)
		(super init: &rest)
		(self setScript: soBlink)
	)
)

(instance soBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(poLight hide:)
				(= ticks 30)
			)
			(2
				(poLight show:)
				(= ticks 30)
				(-= state 2)
			)
		)
	)
)

