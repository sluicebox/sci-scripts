;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use ego_64007)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro400 0
)

(local
	local0
	local1
	local2
	local3
)

(instance ro400 of L7Room
	(properties
		picture 40000
	)

	(method (init)
		(switch gPrevRoomNum
			(401 ; ro401
				(gEgo
					init:
					normalize: 7
					setScaler: Scaler 66 33 462 297
					posn: 220 357
				)
			)
			(else
				(gEgo
					init:
					normalize: 7
					setScaler: Scaler 66 33 462 297
					posn: 505 400
				)
			)
		)
		(gEgo doit:)
		(super init:)
		(gOMusic1 setMusic: 40000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 1 335 2 478 359 475 393 413 574 418 587 393 570 396 408 377 253 335 200 368
					yourself:
				)
		)
		(cond
			((not ((ScriptID 64017 0) test: 237)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 407 223
					setDest: 236 275
					loop: 1
					cel: 5
					setScaleDirect: 49
					setPri: 500
					nMyFlag: 237
					init:
				)
			)
			((not ((ScriptID 64017 0) test: 253)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 575 435
					setDest: 527 511
					loop: 0
					setScaleDirect: 45
					setPri: 50
					nMyFlag: 253
					init:
				)
			)
			((not ((ScriptID 64017 0) test: 254)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 397 433
					setDest: 269 511
					loop: 0
					setScaleDirect: 45
					setPri: 50
					nMyFlag: 254
					init:
				)
			)
		)
		(foExitSouth init:)
		(foChand init:)
		(foPool init:)
		(foRunway init:)
		(foDecor init:)
		(foMermaid init:)
		(foPediment init:)
		(if (== gPrevRoomNum 401) ; ro401
			(poJamie cel: 5 init: setCycle: Beg self)
		else
			(poJamie cel: 0 init:)
		)
		(gCurRoom setScript: soSwimmers)
		(gEgo addVerbHandler: oDreamHandler)
		(gGame handsOn:)
	)
)

(instance oDreamHandler of VerbHandler
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 143) ; Dream
			(ShowEasterEgg)
			((ScriptID 64017 0) set: 303) ; oFlags
			(gCurRoom setScript: soDream)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance soDream of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc64896_1 1 3 self)
				(gOMusic1 fadeOut:)
			)
			(1
				(poSwimmer dispose:)
				(poSwimmerBG dispose:)
				(gCurRoom addRoomPlane: oDreamPlane)
				(Palette 1 401) ; PalLoad
				(poJamieDream view: 40306 loop: 0 cel: 0 posn: 136 479 init:)
				(proc64896_1 0 3 self)
				(gOMusic1 playSound: 40001)
			)
			(2
				(= ticks 60)
			)
			(3
				(ShowEasterEgg 1)
				(poJamieDream setCycle: End self)
			)
			(4
				(poJamieDream view: 40307 loop: 0 cel: 0 doit:)
				(voJamieDreamMouth init:)
				(= global357 toJamieDream)
				(gMessager say: 1 70 0 2 self 401) ; "Say magna-feet."
			)
			(5
				(= global357 0)
				(= ticks 60)
			)
			(6
				(proc64896_1 1 3 self)
			)
			(7
				(gCurRoom deleteRoomPlane: oDreamPlane)
				(Palette 1 400) ; PalLoad
				(proc64896_1 0 3 self)
			)
			(8
				(gGame handsOn:)
				(gOMusic1 setMusic: 40000)
				(gCurRoom setScript: soSwimmers)
			)
		)
	)
)

(instance oDreamPlane of Plane
	(properties
		picture 40100
	)

	(method (init)
		(super init: 0 0 639 479)
	)
)

(instance poJamieDream of Prop
	(properties)
)

(instance voJamieDreamMouth of View
	(properties
		priority 480
		x 136
		y 479
		loop 1
		view 40307
		fixPriority 1
	)
)

(instance toJamieDream of Talker
	(properties
		priority 480
		x 136
		y 479
		loop 1
		view 40307
	)

	(method (init)
		(voJamieDreamMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voJamieDreamMouth show:)
		(super dispose: &rest)
	)
)

(instance poJamie of Prop
	(properties
		noun 1
		priority 330
		x 194
		y 290
		view 40020
		approachX 220
		approachY 357
		fixPriority 1
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 105) ; oFlags
			(= case 0)
		else
			(= case 1)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(gEgo setScript: soTalkToJamie)
			)
			(1 ; Look
				(gMessager say: 1 1 0 0) ; "A gorgeous woman sits before a drafting table, the floor around her littered with the discards of hours of work. She looks troubled, anguished, distraught."
			)
			(else
				(if (proc64037_3 theVerb)
					(gMessager say: 1 161 0 0) ; "Maybe you should talk to her first."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance soTalkToJamie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(poJamie setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 401) ; ro401
				(self dispose:)
			)
		)
	)
)

(instance soSwimmers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soSwimmersBG)
				(= cycles 1)
			)
			(1
				(= seconds (Random 4 10))
			)
			(2
				(while (== local0 local1)
					(= local0 (Random 0 4))
				)
				(= local1 local0)
				(poSwimmer
					view: (+ 40000 local0)
					loop: 0
					cel: 0
					posn: 297 19
					setPri: 15
					init:
					setCycle: End self
				)
			)
			(3
				(poSwimmer dispose:)
				(-= state 3)
				(= cycles 1)
			)
		)
	)
)

(instance soSwimmersBG of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 8))
			)
			(1
				(while (== local2 local3)
					(= local2 (Random 5 9))
				)
				(= local3 local2)
				(poSwimmerBG
					view: (+ 40000 local2)
					loop: 0
					cel: 0
					posn: 297 19
					setPri: 10
					init:
					setCycle: End self
				)
			)
			(2
				(poSwimmerBG dispose:)
				(-= state 3)
				(= cycles 1)
			)
		)
	)
)

(instance poSwimmer of Prop
	(properties)
)

(instance poSwimmerBG of Prop
	(properties)
)

(instance foDecor of Feature
	(properties
		noun 4
		x 156
		y 205
		approachDist 1000
		approachX 103
		approachY 353
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 137 173 167 310 157 306 222 133 273 2 246
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPediment of Feature
	(properties
		noun 5
		x 414
		y 135
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 316 163 409 108 512 150 yourself:)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRunway of Feature
	(properties
		noun 6
		x 304
		y 250
		approachX 253
		approachY 335
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 262 358 218 410 223 261 282
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foMermaid of Feature
	(properties
		noun 7
		x 603
		y 303
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 567 203 583 172 588 137 605 129 622 136 639 135 636 477 590 477 592 447 574 439 573 424 581 419 580 410 598 400 582 341 590 304 605 289 601 265 594 252 596 244 580 217
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foChand of Feature
	(properties
		noun 3
		x 101
		y 117
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Set new:)
					add:
						((Polygon new:)
							type: PTotalAccess
							init: 65 97 84 84 122 87 137 95 134 107 112 125 115 138 112 151 100 145 81 119
							yourself:
						)
						((Polygon new:)
							type: PTotalAccess
							init: 186 126 220 126 217 137 225 145 219 156 210 153 205 145 193 143 183 136 183 128
							yourself:
						)
						((Polygon new:)
							type: PTotalAccess
							init: 275 132 294 129 294 118 327 111 338 118 342 135 336 140 310 139 290 161 281 161
							yourself:
						)
						((Polygon new:)
							type: PTotalAccess
							init: 482 84 509 73 532 76 553 85 550 97 572 100 566 116 569 131 547 148 534 144 542 123 524 116 501 114 495 122 484 119 479 112 486 98
							yourself:
						)
						((Polygon new:)
							type: PTotalAccess
							init: 578 1 638 1 639 64 628 64 619 84 601 78 596 64 610 53 610 26
							yourself:
						)
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPool of Feature
	(properties
		noun 2
		x 286
		y 58
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 45 1 527 1 488 45 441 73 371 104 293 116 227 109 144 78 86 43 66 22
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExitSouth of ExitFeature
	(properties
		x 613
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 429 478 637 326 636 477 yourself:)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 7)) ; oSouthEastCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 402 621 436)
	)
)

