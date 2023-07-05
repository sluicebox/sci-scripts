;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use oFlags)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use foEExit)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro301 0
)

(local
	local0
	local1
	local2 = 3
	local3
	local4
	local5
	local6 = 1
)

(procedure (localproc_0)
	(if ((ScriptID 64017 0) test: 59) ; oFlags
		(if (gEgo has: ((ScriptID 64037 0) get: 45)) ; oInvHandler, ioSuitcase
			(gCurRoom setScript: soWithSuitcase)
		else
			(gCurRoom setScript: soEnterClothed)
		)
	else
		(gCurRoom setScript: soFirstTalk)
	)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(if (== param2 0)
		(= temp1 (Random 425 430))
		(= temp2 450)
		(= temp4 100)
	else
		(= temp1 (Random 215 225))
		(= temp2 100)
		(= temp4 35)
	)
	(if (== param3 0)
		(= temp3 0)
		(= temp0 700)
		(= temp5 -55)
	else
		(= temp3 1)
		(= temp0 -40)
		(= temp5 715)
	)
	(if (== param1 1)
		(= temp6 11)
	else
		(= temp6 14)
	)
	(if (!= param2 0)
		(-= temp6 4)
	)
	(param1
		posn: temp0 temp1
		setPri: temp2
		setLoop: temp3
		setScalePercent: temp4
		setStep: temp6 10
		init:
		setSpeed: 6
		setCycle: Walk
		setMotion: MoveTo temp5 temp1
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2)
	(if (== (= temp0 (Random 0 5)) local2)
		(return 1)
	)
	(= temp1 (Random 0 1))
	(= temp2 (Random 0 1))
	(return
		(switch temp0
			(0
				(if (not (oActorFlags test: 0))
					(oActorFlags set: 0)
					(localproc_1 aoJeremy temp1 temp2)
				)
			)
			(1
				(if (not (oActorFlags test: 1))
					(oActorFlags set: 1)
					(localproc_1 aoClown temp1 temp2)
				)
			)
			(2
				(if (not (oActorFlags test: 2))
					(oActorFlags set: 2)
					(localproc_1 aoTowelSuit temp1 temp2)
				)
			)
			(3
				(if (not (oActorFlags test: 3))
					(oActorFlags set: 3)
					(localproc_1 aoTube temp1 temp2)
				)
			)
			(4
				(if (not (oActorFlags test: 4))
					(oActorFlags set: 4)
					(localproc_1 aoDuck temp1 temp2)
				)
			)
			(5
				(if (not (oActorFlags test: 5))
					(oActorFlags set: 5)
					(localproc_1 aoHangTowel temp1 temp2)
				)
			)
		)
	)
)

(instance ro301 of L7Room
	(properties
		picture 30100
	)

	(method (init)
		(gEgo init: normalize: 1 posn: 620 323)
		(super init:)
		(= local3 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 3 322 3 324 636 324 636 322
					yourself:
				)
		)
		(= global330 0)
		(= gToDick toDick)
		(voTowel init:)
		(foRoof init:)
		(foClothes init:)
		(foExitWest init:)
		(foExitEast init:)
		(poDick init:)
		(voDickMouth init:)
		(gOMusic1 setMusic: 30100)
		(oActorFlags init:)
		(cond
			((not ((ScriptID 64017 0) test: 228)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 47 423
					setDest: 640 423
					loop: 0
					cel: 10
					setPri: 423
					xStep: 12
					nMyFlag: 228
					init:
				)
			)
			((not ((ScriptID 64017 0) test: 229)) ; oFlags
				((ScriptID 50 0) ; oDildo
					posn: 585 479
					setDest: -40 479
					loop: 1
					cel: 0
					setPri: 479
					nMyFlag: 229
					init:
				)
			)
		)
		(= local0 gGameTime)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit: &rest)
		(if (> (- gGameTime local0) local1)
			(= local0 gGameTime)
			(= local1 (Random 200 800))
			(localproc_2)
		)
		(if (and (not local3) (<= (gEgo x:) 198))
			(= local3 1)
			(gEgo setMotion: 0)
			(localproc_0)
		)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 104) ; oFlags
	)

	(method (dispose)
		(= global330 0)
		(= gToDick 0)
		(gOMusic1 stop:)
		(gOSound1 stop:)
		(super dispose: &rest)
	)
)

(instance soFirstTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(voDickMouth dispose:)
				(= local6 0)
				(poDick
					view: 30100
					loop: 0
					cel: 0
					posn: 56 330
					doit:
					setCycle: End self
				)
				(= local4 1)
				(gMessager say: 0 0 1 0 coDoneTalking) ; "Hey! Sorry, dude. Ya gotta stop here."
			)
			(1
				(poDick view: 30102 loop: 0 cel: 0 posn: 20 331 doit:)
				(voDickMouth init:)
				(= local6 1)
				(if (toDick mouth:)
					((toDick mouth:)
						view: (voDickMouth view:)
						loop: (voDickMouth loop:)
						setPri: (voDickMouth priority:)
						posn: (voDickMouth x:) (voDickMouth y:)
						show:
					)
					(voDickMouth hide:)
				)
				(= cycles 1)
			)
			(2
				(if local4
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(gMessager sayRange: 2 4 11 10 14 self) ; "Well, I don't think I should enter naked. Everyone would, uh, stare at my, um, physical attributes!"
			)
			(4
				(voDickMouth dispose:)
				(poDick
					view: 30100
					loop: 1
					cel: 0
					posn: 56 330
					doit:
					setCycle: CT 16 1 self
				)
				(= gToDick 0)
				(gMessager say: 2 4 11 15 self) ; "This little dude right HERE is exactly what you need."
			)
			(5)
			(6
				(gEgo hide:)
				(poLarry
					view: 30103
					loop: 0
					cel: 0
					posn: 310 322
					init:
					setCycle: End self 6 999
				)
				(= local4 1)
				(gMessager say: 2 4 11 19 coDoneTalking) ; "Oh, great. Of course I couldn't get a "normal" swimsuit."
			)
			(7
				(= local5 0)
				(poDick cel: 17 doit: setCycle: End coDickInPlace)
			)
			(8
				(poLarry
					view: 30103
					loop: 1
					cel: 0
					posn: 311 324
					doit:
					setCycle: End self
				)
			)
			(9
				(if local4
					(-- state)
				)
				(= cycles 3)
			)
			(10
				(gMessager say: 2 4 11 20 self) ; "Can I at least have a towel to cover it up?"
			)
			(11
				(if (not local5)
					(-- state)
				)
				(= cycles 3)
			)
			(12
				(= local4 1)
				(= gToDick toDick)
				(gMessager say: 2 4 11 21 coDoneTalking) ; "Fer sure. No problem, dude. Now don't get it wet... it might shrink! (CHUCKLES)"
				(= seconds 2)
			)
			(13
				(voLarryClothes init:)
				(poLarry
					view: 30103
					loop: 2
					cel: 0
					posn: 311 325
					doit:
					setCycle: End self 3 999
				)
			)
			(14
				(voTowel dispose:)
			)
			(15
				(if local4
					(-- state)
				)
				(= cycles 3)
			)
			(16
				((ScriptID 64017 0) set: 59) ; oFlags
				(gCurRoom newRoom: 300) ; ro300
			)
		)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local4 0)
	)
)

(instance coDickInPlace of CueMe
	(properties)

	(method (cue)
		(poDick view: 30101 loop: 0 cel: 0 posn: 16 331 doit:)
		(voDickMouth init:)
		(= local5 1)
	)
)

(instance soEnterClothed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 1)
				(if ((ScriptID 64017 0) test: 104) ; oFlags
					(gMessager say: 2 4 2 0 self) ; "Hi, Dick."
					(= global232 2)
				else
					(= cycles 1)
				)
			)
			(1
				(switch global232
					(0
						(gMessager say: 2 4 5 0 self) ; "Hi ya, Dick. Waddaya got in the way of "trunks?""
					)
					(1
						(gMessager say: 2 4 6 0 self) ; "Hi ya, Dick. Where's "ol Jumbo?""
					)
					(2
						(gMessager say: 2 4 8 0 self) ; "Waddaya got that's long and hard, Dick?"
					)
					(3
						(gMessager say: 2 4 9 0 self) ; "(TOO FRIENDLY) How's my little Dickie today?"
					)
					(4
						(gMessager say: 2 4 10 0 self) ; "All right. Lemme have it."
					)
				)
				(if (== global232 4)
					(= global232 0)
				else
					(++ global232)
				)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 300) ; ro300
				(self dispose:)
			)
		)
	)
)

(instance soWithSuitcase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(voDickMouth dispose:)
				(= local6 0)
				(poDick
					view: 30100
					loop: 0
					cel: 0
					posn: 56 330
					setCycle: End self
				)
				(= local4 1)
				(gMessager say: 0 0 7 0 coDoneTalking) ; "Whoa! Sorry, dude. Ya gotta stop here."
			)
			(1
				(poDick view: 30102 loop: 0 cel: 0 posn: 20 331 doit:)
				(= local6 1)
				(voDickMouth init:)
				(if (toDick mouth:)
					((toDick mouth:)
						view: (voDickMouth view:)
						loop: (voDickMouth loop:)
						setPri: (voDickMouth priority:)
						posn: (voDickMouth x:) (voDickMouth y:)
						show:
					)
					(voDickMouth hide:)
				)
				(= cycles 1)
			)
			(2
				(if local4
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(gEgo put: ((ScriptID 64037 0) get: 45)) ; oInvHandler, ioSuitcase
				((ScriptID 64017 0) set: 271) ; oFlags
				(gCurRoom newRoom: 300) ; ro300
				(self dispose:)
			)
		)
	)
)

(instance aoJeremy of Actor
	(properties
		priority 500
		x 320
		y 470
		view 30110
		fixPriority 1
	)

	(method (doit)
		(super doit: &rest)
		(if (or (> x 705) (< x -45))
			(self dispose:)
		)
	)

	(method (setHeading param1)
		(= heading param1)
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (dispose)
		(super dispose: &rest)
		(oActorFlags clear: 0)
		(= local2 0)
	)
)

(instance aoClown of Actor
	(properties
		priority 500
		x 320
		y 470
		view 30111
		fixPriority 1
	)

	(method (doit)
		(super doit: &rest)
		(if (or (> x 705) (< x -45))
			(self dispose:)
		)
	)

	(method (setHeading param1)
		(= heading param1)
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (dispose)
		(super dispose: &rest)
		(oActorFlags clear: 1)
		(= local2 1)
	)
)

(instance aoTowelSuit of Actor
	(properties
		priority 500
		x 320
		y 470
		view 30113
		fixPriority 1
	)

	(method (doit)
		(super doit: &rest)
		(if (or (> x 705) (< x -45))
			(self dispose:)
		)
	)

	(method (setHeading param1)
		(= heading param1)
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (dispose)
		(super dispose: &rest)
		(oActorFlags clear: 2)
		(= local2 2)
	)
)

(instance aoTube of Actor
	(properties
		priority 500
		x 320
		y 470
		view 30114
		fixPriority 1
	)

	(method (doit)
		(super doit: &rest)
		(if (or (> x 705) (< x -45))
			(self dispose:)
		)
	)

	(method (setHeading param1)
		(= heading param1)
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (dispose)
		(super dispose: &rest)
		(oActorFlags clear: 3)
		(= local2 3)
	)
)

(instance aoDuck of Actor
	(properties
		priority 500
		x 320
		y 470
		view 30115
		fixPriority 1
	)

	(method (doit)
		(super doit: &rest)
		(if (or (> x 705) (< x -45))
			(self dispose:)
		)
	)

	(method (setHeading param1)
		(= heading param1)
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (dispose)
		(super dispose: &rest)
		(oActorFlags clear: 4)
		(= local2 4)
	)
)

(instance aoHangTowel of Actor
	(properties
		priority 500
		x 320
		y 470
		view 30116
		fixPriority 1
	)

	(method (doit)
		(super doit: &rest)
		(if (or (> x 705) (< x -45))
			(self dispose:)
		)
	)

	(method (setHeading param1)
		(= heading param1)
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (dispose)
		(super dispose: &rest)
		(oActorFlags clear: 5)
		(= local2 5)
	)
)

(instance voLarryClothes of View
	(properties
		priority 400
		x 311
		y 324
		view 30104
		fixPriority 1
	)
)

(instance voTowel of View
	(properties
		priority 320
		x 372
		y 198
		loop 1
		view 30105
		fixPriority 1
	)
)

(instance voSuitcase of View ; UNUSED
	(properties
		priority 500
		x 25
		y 449
		view 30106
		fixPriority 1
	)
)

(instance foClothes of Feature
	(properties
		noun 1
		x 400
		y 221
		approachX 400
		approachY 323
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 175 204 500 204 500 190 493 187 492 156 522 184 558 176 598 171 612 151 622 153 626 201 608 222 595 202 579 218 574 251 544 250 534 279 482 276 483 245 457 240 457 258 400 255 391 255 390 285 385 285 381 245 368 245 360 287 348 205 331 205 331 291 311 249 293 289 287 289 281 206 254 209 260 275 217 278 225 208 206 208 210 234 174 236
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRoof of Feature
	(properties
		noun 3
		x 317
		y 89
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 625 142 525 26 536 26 537 18 533 11 519 13 516 5 506 9 510 16 440 26 308 23 211 17 138 6 132 15 133 24 141 24 10 130 93 174 309 174 469 162 587 161
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
		(gEgo walkTo: 10 323)
	)
)

(instance foExitEast of ExitFeature
	(properties
		x 613
		y 187
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
		(self forceCursor: (ScriptID 64006 13)) ; oMapCursor
	)

	(method (doVerb)
		((ScriptID 90 0) init:) ; oTravelScreen
	)
)

(instance poLarry of Prop
	(properties)
)

(instance poDick of Prop
	(properties
		noun 2
		priority 400
		x 16
		y 331
		view 30101
		approachX 199
		approachY 323
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(72 ; Wad o' Dough
				(gEgo put: ((ScriptID 64037 0) get: 52)) ; oInvHandler, ioMoney
				(super doVerb: theVerb &rest)
			)
			(4 ; Talk
				(gEgo walkTo: 190 323)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voDickMouth of View
	(properties)

	(method (init)
		(= view (poDick view:))
		(= loop (+ (poDick loop:) 1))
		(= x (poDick x:))
		(= y (poDick y:))
		(self setPri: (+ (poDick priority:) 1))
		(super init: &rest)
	)
)

(instance toDick of Talker
	(properties)

	(method (init)
		(= view (poDick view:))
		(= loop (+ (poDick loop:) 1))
		(= x (poDick x:))
		(= y (poDick y:))
		(= priority (+ (poDick priority:) 1))
		(if (voDickMouth plane:)
			(voDickMouth hide:)
		)
		(super init: &rest)
		(if (not local6)
			(mouth hide:)
		)
	)

	(method (dispose)
		(if (voDickMouth plane:)
			(voDickMouth show:)
		)
		(super dispose: &rest)
	)
)

(instance oActorFlags of oFlagsClass
	(properties
		size 6
	)
)

