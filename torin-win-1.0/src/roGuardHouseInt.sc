;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15100)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use CueMe)
(use n64896)
(use foEExit)
(use Plane)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roGuardHouseInt 0
	toHermanTable 1
	toHermanDrinking 2
	toHermanBookcase 3
)

(instance foMainExit of ExitFeature
	(properties
		nsLeft 598
		nsTop 211
		nsRight 630
		nsBottom 315
		approachX 627
		approachY 249
		x 650
		y 249
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(gEgo approachThenFace: self self)
	)

	(method (cue)
		(gCurRoom setScript: soBackOutside)
	)
)

(instance foEmptiness of Feature
	(properties
		nsLeft 380
		nsTop 92
		nsRight 601
		nsBottom 213
		x 497
		y 139
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gEgo setScript: soScanRoom)
	)
)

(instance soScanRoom of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo face: foEmptiness self)
			)
			(1
				(goSound1 preload: 15101)
				(gMessager say: 2 0 1 0 self) ; "Looks like the ol' boy took the square root pie and split. (PAUSE) Hope he doesn't get a "divide by zero" error!"
			)
			(2
				(goSound1 playSound: 15101)
				(self dispose:)
			)
		)
	)
)

(instance soBackOutside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gEgo has: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
					(gCurRoom newRoom: 15000) ; roGuardHouseExt
				else
					(= cycles 2)
					(= state -1)
				)
			)
		)
	)
)

(instance soWaitForBoogleToTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gEgo has: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
					(poGuard doVerb: 1)
				else
					(= cycles 2)
					(= state -1)
				)
			)
		)
	)
)

(instance foDoorExit of Feature
	(properties
		nsLeft 169
		nsTop 43
		nsRight 228
		nsBottom 188
		approachX 224
		approachY 187
		x 223
		y 186
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(gEgo setScript: soTorinsPassage)
	)
)

(instance soTorinsPassage of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo approachThenFace: foDoorExit self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 220 183)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 15200) ; roPortalChamber
			)
		)
	)
)

(instance soTorinServesBerries of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (ff)
		(goSound1 stop:)
		(poTorinJuicesBerries dispose:)
		(poTorinShakesJuicer dispose:)
		(voJuicerlessBookcase dispose:)
		(poTorinDuckwalks dispose:)
		(gEgo
			setMotion: 0
			posn: (poGuard approachX:) (poGuard approachY:)
			loop: 6
			stopwalk:
			show:
		)
		((ScriptID 64018 0) ; oBoogle
			setMotion: 0
			posn: 476 288
			loop: 2
			stopwalk:
			show:
			setWander: 1
		)
		(goMusic1 setMusic: 15100)
		(if (== (gCurRoom plane:) oTalkInset)
			(gCurRoom deleteRoomPlane: oTalkInset)
		)
		(voCup init:)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (rewind)
		(goSound1 stop:)
		(poTorinJuicesBerries dispose:)
		(poTorinShakesJuicer dispose:)
		(voJuicerlessBookcase dispose:)
		(poTorinDuckwalks dispose:)
		(gEgo
			setMotion: 0
			posn: (poGuard approachX:) (poGuard approachY:)
			loop: 6
			stopwalk:
			show:
		)
		((ScriptID 64018 0) ; oBoogle
			setMotion: 0
			posn: 235 210
			loop: 6
			stopwalk:
			show:
			setWander: 1
		)
		(goMusic1 setMusic: 15100)
		(if (== (gCurRoom plane:) oTalkInset)
			(gCurRoom deleteRoomPlane: oTalkInset)
		)
		(voCup dispose:)
		(gCurRoom setScript: soTorinServesBerries)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 1 8 4 1 4 self) ; "Here you are, Herman. I brought you some berries."
			)
			(1
				(goSound1 preload: 15103)
				(gEgo setMotion: PolyPath 282 191 self)
				((ScriptID 64018 0) ; oBoogle
					setWander: 0
					setMotion: PolyPath 235 210 coFaceBoogleNE
				)
			)
			(2
				(gEgo hide:)
				(poTorinJuicesBerries setCel: 0 init: setCycle: End self)
			)
			(3
				(poTorinJuicesBerries dispose:)
				(poTorinShakesJuicer setCel: 0 init: setCycle: CT 2 1 self)
			)
			(4
				(= ticks (poTorinShakesJuicer cycleSpeed:))
			)
			(5
				(voJuicerlessBookcase init:)
				(goSound1 playSound: 15103)
				(poTorinShakesJuicer setCel: 3 setCycle: CT 16 1 self)
			)
			(6
				(poTorinShakesJuicer setCel: 3 setCycle: CT 16 1 self)
			)
			(7
				(poTorinShakesJuicer setCel: 3 setCycle: CT 16 1 self)
			)
			(8
				(= ticks (poTorinShakesJuicer cycleSpeed:))
			)
			(9
				(voJuicerlessBookcase dispose:)
				(poTorinShakesJuicer setCel: 17 setCycle: End self)
			)
			(10
				(poTorinShakesJuicer dispose:)
				(gEgo posn: 284 192 setLoop: 5 stopwalk: show:)
				(gMessager say: 1 8 4 5 self) ; "Boogle, can you be an ax?"
			)
			(11
				((ScriptID 64018 0) setMotion: PolyPath 235 210 self) ; oBoogle
			)
			(12
				((ScriptID 64018 0) setHeading: 45 self) ; oBoogle
			)
			(13
				(gEgo hide:)
				((ScriptID 64018 0) hide:) ; oBoogle
				(poTorinDuckwalks
					setCel: 0
					init:
					setPri: 240
					setCycle: End self
				)
				(goMusic1 playSound: 15199)
			)
			(14
				(poTorinDuckwalks dispose:)
				(gEgo
					posn: 419 239
					setLoop: 4
					stopwalk:
					show:
					approachThenFace: poGuard self
				)
				((ScriptID 64018 0) ; oBoogle
					posn: 469 240
					setLoop: 2
					stopwalk:
					show:
					setMotion: PolyPath 476 288
				)
			)
			(15
				(goSound1 preload: 15101)
				(gMessager sayRange: 1 8 4 6 7 self) ; "Whew! Here ya go. Say, uh, what kind of berries are those?"
			)
			(16
				(goSound1 playSound: 15101 self)
			)
			(17
				(goMusic1 setMusic: 15100)
				(gCurRoom addRoomPlane: oTalkInset)
				(poGuardDrinks init:)
				(poTorinServesBerries setCel: 0 init:)
				(= ticks 1)
			)
			(18
				(= ticks 120)
			)
			(19
				(poTorinServesBerries setCycle: End self)
				(poGuardDrinks setCycle: CT 44 1 self)
				(goSound1 preload: 15104)
				(goSound1 playSound: 15106)
			)
			(20)
			(21
				(goSound1 playSound: 15104)
				(poGuardDrinks setCycle: End self)
			)
			(22
				(poTorinServesBerries dispose:)
				(= gnHermanTalker 4)
				(gMessager sayRange: 1 8 4 8 17 self) ; "Ah, that tastes great. But now, I'm gettin' a little hungry."
			)
			(23
				(= gnHermanTalker 3)
				(gGame handsOn:)
				(gCurRoom deleteRoomPlane: oTalkInset)
				(voCup init:)
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance voCup of View
	(properties
		x 528
		y 144
		view 15111
	)
)

(instance coFaceBoogleNE of CueMe
	(properties)

	(method (cue)
		((ScriptID 64018 0) setHeading: 45) ; oBoogle
	)
)

(instance poTorinJuicesBerries of Prop
	(properties
		x 282
		y 191
		view 15101
		loop 1
	)
)

(instance poTorinShakesJuicer of Prop
	(properties
		x 282
		y 191
		view 15101
		loop 3
	)
)

(instance voJuicerlessBookcase of View
	(properties
		x 202
		y 105
		view 15115
	)
)

(instance poTorinDuckwalks of Prop
	(properties
		x 284
		y 192
		view 15101
	)
)

(instance poTorinServesBerries of Prop
	(properties
		x 599
		y 187
		view 15106
	)
)

(instance poGuardDrinks of Prop
	(properties
		x 159
		y 222
		view 15106
		loop 1
		cel 8
	)
)

(instance soTorinServesSlugetti of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (ff)
		(gEgo
			setMotion: 0
			posn: (poGuard approachX:) (poGuard approachY:)
			loop: 6
			stopwalk:
			show:
		)
		(poTorinCooksSlugs dispose:)
		(goSound1 stop:)
		(if (== (gCurRoom plane:) oTalkInset)
			(gCurRoom deleteRoomPlane: oTalkInset)
		)
		(voPlate init:)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (rewind)
		(gEgo
			setMotion: 0
			posn: (poGuard approachX:) (poGuard approachY:)
			loop: 6
			stopwalk:
			show:
		)
		(poTorinCooksSlugs dispose:)
		(goSound1 stop:)
		(if (== (gCurRoom plane:) oTalkInset)
			(gCurRoom deleteRoomPlane: oTalkInset)
		)
		(voPlate dispose:)
		(gCurRoom setScript: soTorinServesSlugetti)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 1 20 6 1 5 self) ; "Here's your order, sir. Slugs and peat moss. Just as you requested. But, boy, did I have to go through a lot just to bring these to you."
			)
			(1
				(gEgo setMotion: PolyPath 310 187 self)
			)
			(2
				(gEgo setHeading: 0 self)
			)
			(3
				(gEgo
					hide:
					posn: (poGuard approachX:) (poGuard approachY:)
					setLoop: 6
				)
				(poTorinCooksSlugs
					setCel: 0
					setScaler: Scaler 110 110 1 0
					init:
					setCycle: CT 21 1 self
				)
				(goSound1 setMusic: 15109)
			)
			(4
				(= ticks (poTorinCooksSlugs cycleSpeed:))
			)
			(5
				(poTorinCooksSlugs setCel: 1 setCycle: CT 21 1 self)
			)
			(6
				(= ticks (poTorinCooksSlugs cycleSpeed:))
			)
			(7
				(poTorinCooksSlugs setCel: 1 setCycle: CT 21 1 self)
			)
			(8
				(goSound1 stop:)
				(= ticks (poTorinCooksSlugs cycleSpeed:))
			)
			(9
				(poTorinCooksSlugs setCycle: End self)
			)
			(10
				(poTorinCooksSlugs dispose:)
				(gCurRoom addRoomPlane: oTalkInset)
				(poGuardEats setCel: 0 init:)
				(gMessager say: 1 20 6 6 self) ; "Wow. At least it's quick to prepare. (WAITER-LIKE) Here you are, monsieur. Bon appetite!"
			)
			(11
				(poTorinServesSlugetti
					setCel: 0
					init:
					setPri: 255
					setCycle: CT 2 1 self
				)
			)
			(12
				(poTorinServesSlugetti setCycle: End)
				(goSound1 playSound: 15108)
				(poGuardEats setCycle: CT 8 1 self)
			)
			(13
				(= ticks (poGuardEats cycleSpeed:))
				(goSound1 playSound: 15107)
			)
			(14
				(poGuardEats setCycle: CT 34 1 self)
			)
			(15
				(= ticks (poGuardEats cycleSpeed:))
				(goSound1 playSubtitledSound: 15105 1 20 6 7)
			)
			(16
				(poGuardEats setCycle: End self)
			)
			(17
				(poGuardEats setCel: 8 setCycle: CT 34 1 self)
				(goSound1 playSound: 15107)
			)
			(18
				(= ticks (poGuardEats cycleSpeed:))
				(goSound1 playSubtitledSound: 15105 1 20 6 7)
			)
			(19
				(poGuardEats setCycle: End self)
			)
			(20
				(gCurRoom deleteRoomPlane: oTalkInset)
				(voPlate init:)
				(gEgo show:)
				(goSound1 stop:)
				(gMessager sayRange: 1 20 6 8 17 self) ; "Now can we get on with it?"
			)
			(21
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voPlate of View
	(properties
		x 518
		y 150
		view 15111
		loop 1
	)
)

(instance poTorinCooksSlugs of Prop
	(properties
		x 310
		y 187
		view 15102
	)
)

(instance poTorinServesSlugetti of Prop
	(properties
		x 599
		y 186
		view 15105
	)
)

(instance poBowlSettles of Prop ; UNUSED
	(properties
		x 197
		y 250
		view 15105
		loop 1
	)
)

(instance poGuardEats of Prop
	(properties
		x 43
		y 253
		view 15105
		loop 2
	)
)

(instance poBookcaseOpens of Prop
	(properties
		x 246
		y 180
		view 15109
	)
)

(instance voBookcase of View
	(properties
		x 246
		y 180
		view 15110
	)
)

(instance foTorinStandsHere of Feature
	(properties
		approachX 231
		approachY 234
		x 241
		y 234
	)
)

(instance soGuardLeavesRoom of TPScript
	(properties
		bHasFF 1
	)

	(method (ff)
		(goSound1 stop:)
		(gCurRoom newRoom: 15500) ; roPickAShard
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager sayRange: 1 9 8 1 3 self) ; "Here ya go. One large root. Want to help me fix it?"
			)
			(1
				(gMessager say: 1 9 8 4 self) ; "Say, nice square shape, too. Them's the best kind!"
				(gEgo setMotion: PolyPath 249 199 self)
			)
			(2)
			(3
				(gEgo face: poGuard self)
			)
			(4
				(gMessager say: 1 9 8 5 self) ; "Okay. How about if I make it into a pie?"
			)
			(5
				(gEgo setHeading: 315 self)
			)
			(6
				(gEgo hide:)
				(poPrepareSquareRoot setCel: 0 init: setCycle: CT 19 1 self)
			)
			(7
				(poPrepareSquareRoot setCycle: CT 37 1 self)
				(goSound1 setMusic: 15111)
			)
			(8
				(poPrepareSquareRoot setCel: 19 setCycle: CT 37 1 self)
			)
			(9
				(poPrepareSquareRoot setCel: 19 setCycle: CT 37 1 self)
			)
			(10
				(goSound1 stop:)
				(poPrepareSquareRoot setCycle: End self)
			)
			(11
				(poPrepareSquareRoot dispose:)
				(poBakeSquareRoot setCel: 0 init: setCycle: End self)
			)
			(12
				(poBakeSquareRoot dispose:)
				(gEgo
					posn: 288 186
					setLoop: 6
					stopwalk:
					show:
					approachThenFace: foTorinStandsHere self
				)
				((ScriptID 64018 0) setWander: 0 setMotion: PolyPath 476 288) ; oBoogle
				(goSound1 preload: 15101)
				(gMessager sayRange: 1 9 8 6 7 self) ; "Great! While that's in the oven baking, why don't you and I head back to the phenocryst chamber?"
			)
			(13)
			(14
				(goSound1 playSound: 15101 self)
			)
			(15
				(gMessager say: 1 9 8 8 self) ; "Whew. Say, uh, we going out on that joke?"
			)
			(16
				((ScriptID 64018 0) setHeading: 315) ; oBoogle
				(= gnHermanTalker 0)
				(poGuard dispose:)
				(poGuardLeavesRoom
					setCel: 0
					init:
					setPri: 210
					setCycle: CT 34 1 self
				)
				(gMessager say: 1 9 8 9 self) ; "No, we're going out through the secret passage!"
			)
			(17)
			(18
				(poGuardLeavesRoom setCycle: End self)
				(gEgo setHeading: 45 self)
			)
			(19)
			(20
				(poBookcaseOpens setCel: 0 init: setCycle: End self)
				(goSound1 playSound: 15102)
			)
			(21
				(= ticks (poBookcaseOpens cycleSpeed:))
			)
			(22
				(= gnHermanTalker 6)
				(gMessager say: 0 0 4 1 self 15200) ; "Wait here while I get something."
			)
			(23
				(FadeToBlack 1 10 self)
			)
			(24
				(gCurRoom newRoom: 15500) ; roPickAShard
			)
		)
	)
)

(instance poPrepareSquareRoot of Prop
	(properties
		x 249
		y 199
		view 15104
	)
)

(instance poBakeSquareRoot of Prop
	(properties
		x 219
		y 201
		view 15104
		loop 1
	)
)

(instance poGuardLeavesRoom of Prop
	(properties
		x 596
		y 171
		view 15104
		loop 2
	)
)

(instance oTalkInset of Plane
	(properties
		picture 15101
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance soFirstEntrance of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (ff)
		(goSound1 stop:)
		(poGuard dispose: loop: 1 cel: (poGuard lastCel:) init:)
		(gEgo setMotion: 0 posn: 455 235 loop: 6 stopwalk: show:)
		(poBoogleSniffing dispose:)
		(poGuardReact dispose:)
		(gEgo get: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
		((ScriptID 64018 0) init: setScript: soBoogleEntrance) ; oBoogle
		(gGame handsOn:)
		(self dispose:)
	)

	(method (rewind)
		(goSound1 stop:)
		(poGuard dispose:)
		(gEgo setMotion: 0 posn: 635 262 loop: 3 stopwalk: hide:)
		(poBoogleSniffing dispose:)
		(poGuardReact dispose:)
		((ScriptID 64018 0) dispose:) ; oBoogle
		(gEgo put: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
		(gGame handsOff:)
		(gEgo setScript: soFirstEntrance)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(= ticks 120)
			)
			(1
				(poGuard setLoop: 0 setCel: 0 init: setCycle: CT 9 1 self)
			)
			(2
				(goSound1 playSound: 15110)
				(= ticks (poGuard cycleSpeed:))
			)
			(3
				(poGuard setCycle: End self)
			)
			(4
				(gEgo show:)
				(gEgo setMotion: MoveTo 455 235 coFaceEgo)
				(= cycles 6)
			)
			(5
				(poGuard setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6
				(poBoogleSniffing
					setCel: 0
					init:
					setScaler: Scaler 90 90 0 1
					setCycle: CT 40 1 self
				)
			)
			(7
				(goSound1 playSound: 20403)
				(= ticks (poBoogleSniffing cycleSpeed:))
			)
			(8
				(poBoogleSniffing setCycle: CT 45 1 self)
			)
			(9
				(poGuard hide:)
				(poGuardReact setCel: 0 init: setCycle: End self)
				(poBoogleSniffing setCycle: CT 57 1 self)
			)
			(10)
			(11
				(poBoogleSniffing setCycle: End self)
				(goSound1 playSound: 60019)
			)
			(12
				(poBoogleSniffing dispose:)
				(gEgo get: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
				((ScriptID 64018 0) init: setScript: soBoogleEntrance) ; oBoogle
				(poGuardReact dispose:)
				(poGuard show:)
				(self dispose:)
			)
		)
	)
)

(instance coFaceEgo of CueMe
	(properties)

	(method (cue)
		(gEgo setHeading: 45)
		(gGame handsOn:)
	)
)

(instance poGuard of Prop
	(properties
		noun 1
		approachX 510
		approachY 229
		x 587
		y 169
		view 15100
	)

	(method (init)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 35) ; oFlags
			(self addHotspotVerb: 1 21 20 8 9)
		else
			(self addHotspotVerb: 1)
		)
		(self approachVerbs: 1 2) ; Do, ioAx
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				((ScriptID 64002 6) disable:) ; oFastForward
				((ScriptID 64002 4) disable:) ; oRewind
				(if (not (gEgo has: ((ScriptID 64001 1) get: 4))) ; oBoogleHandler, ioBoogleLantern
					(gCurRoom setScript: soWaitForBoogleToTalk)
					(return)
				else
					(gGame handsOn:)
				)
				(cond
					((not ((ScriptID 64017 0) test: 35)) ; oFlags
						((ScriptID 64017 0) set: 35) ; oFlags
						(self addHotspotVerb: 21 20 8 9)
						(gMessager say: noun theVerb 2 0) ; "SO?! Get started!"
					)
					((not ((ScriptID 64017 0) test: 33)) ; oFlags
						(gMessager say: noun theVerb 4 0) ; "Hey, who are you? Do I know you?"
					)
					((not ((ScriptID 64017 0) test: 32)) ; oFlags
						(gMessager say: noun theVerb 6 0) ; "What exactly do you want me to bring you?"
					)
					((not ((ScriptID 64017 0) test: 34)) ; oFlags
						(gMessager say: noun theVerb 8 0) ; "All you want is a root?"
					)
					(else
						(PrintDebug {Error: Guard shouldn't be here.})
					)
				)
			)
			(20 ; ioSlugs
				(if (not ((ScriptID 64017 0) test: 33)) ; oFlags
					(gMessager say: noun theVerb 4 0) ; "Waddaya doin'? I'm thirsty, boy. (But that peat looks mighty fine... yep, mighty fine!)"
					(return)
				)
				(if (gEgo has: ((ScriptID 64001 0) get: 11)) ; oInvHandler, ioPeat
					((ScriptID 64017 0) set: 32) ; oFlags
					(gEgo put: ((ScriptID 64001 0) get: 10)) ; oInvHandler, ioSlugs
					(gEgo put: ((ScriptID 64001 0) get: 11)) ; oInvHandler, ioPeat
					(gCurRoom setScript: soTorinServesSlugetti)
				else
					(gMessager say: noun theVerb 10 0) ; "Here you are. Slugs. Just like you wanted."
				)
			)
			(21 ; ioPeat
				(if (not ((ScriptID 64017 0) test: 33)) ; oFlags
					(gMessager say: noun theVerb 4 0) ; "Waddaya doin'? I'm thirsty, boy. (But that peat looks mighty fine... yep, mighty fine!)"
					(return)
				)
				(if (gEgo has: ((ScriptID 64001 0) get: 10)) ; oInvHandler, ioSlugs
					((ScriptID 64017 0) set: 32) ; oFlags
					(gEgo put: ((ScriptID 64001 0) get: 10)) ; oInvHandler, ioSlugs
					(gEgo put: ((ScriptID 64001 0) get: 11)) ; oInvHandler, ioPeat
					(gCurRoom setScript: soTorinServesSlugetti)
				else
					(gMessager say: noun theVerb 11 0) ; "Here you are. Peat. Just like you wanted."
				)
			)
			(8 ; ioChuckBerries
				((ScriptID 64017 0) set: 33 30) ; oFlags
				(gEgo put: ((ScriptID 64001 0) get: 4)) ; oInvHandler, ioChuckBerries
				(gCurRoom setScript: soTorinServesBerries)
			)
			(9 ; ioSquareRoot
				(if (not ((ScriptID 64017 0) test: 33)) ; oFlags
					(gMessager say: noun theVerb 4 0) ; "Root? Already? Did I ask for root? No, no I did not! But, did I ever tell you 'bout how my ol' Mammy use'ta fix root?"
					(return)
				)
				(if (not ((ScriptID 64017 0) test: 32)) ; oFlags
					(gMessager say: noun theVerb 6 0) ; "Nice root."
					(return)
				)
				((ScriptID 64017 0) set: 34) ; oFlags
				(gEgo put: ((ScriptID 64001 0) get: 5)) ; oInvHandler, ioSquareRoot
				(gCurRoom setScript: soGuardLeavesRoom)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance toHermanTable of Talker
	(properties
		x 587
		y 169
		view 15100
		loop 2
	)

	(method (init)
		(poGuard hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poGuard show:)
		(super dispose: &rest)
	)
)

(instance toHermanDrinking of Talker
	(properties)

	(method (init)
		(= frame voHermanDrinkingBody)
		(= mouth poHermanDrinkingMouth)
		(poGuardDrinks hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poGuardDrinks show:)
		(super dispose: &rest)
	)
)

(instance toHermanBookcase of Talker
	(properties
		view 15113
		loop 1
	)

	(method (init)
		(= x (poGuardLeavesRoom x:))
		(= y (poGuardLeavesRoom y:))
		(= priority 211)
		(poGuardLeavesRoom hide:)
		(voHermanBookcaseBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(poGuardLeavesRoom show:)
		(voHermanBookcaseBody dispose:)
		(super dispose: &rest)
	)
)

(instance voHermanBookcaseBody of View
	(properties
		view 15113
	)

	(method (init)
		(= x (poGuardLeavesRoom x:))
		(= y (poGuardLeavesRoom y:))
		(self setPri: 210)
		(super init: &rest)
	)
)

(instance poHermanDrinkingMouth of Prop
	(properties
		x 159
		y 222
		view 15106
		loop 3
	)

	(method (init)
		(self setPri: 250)
		(super init: &rest)
	)
)

(instance voHermanDrinkingBody of View
	(properties
		x 159
		y 222
		view 15106
		loop 2
	)
)

(instance poBoogleSniffing of Prop
	(properties
		x 393
		y 375
		view 15103
	)
)

(instance poGuardReact of Prop
	(properties
		x 587
		y 169
		view 15103
		loop 1
	)
)

(instance soBoogleEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 180)
				((ScriptID 64018 0) hide:) ; oBoogle
			)
			(1
				((ScriptID 64018 0) ; oBoogle
					show:
					normalize:
					setScaler: Scaler 100 92 239 192
					setWander: 0
					posn: 629 291
					setMotion: MoveTo 540 293 self
				)
			)
			(2
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soBooglePassageEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64018 0) ; oBoogle
					show:
					normalize:
					setScaler: Scaler 100 92 239 192
					setWander: 0
					posn: 207 180
					loop: 4
				)
			)
			(1
				(gGame handsOn:)
				((ScriptID 64018 0) setMotion: MoveTo 224 187 self) ; oBoogle
			)
			(2
				((ScriptID 64018 0) setMotion: PolyPath 373 201 self) ; oBoogle
			)
			(3
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soSecondEntrance of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 455 235 self)
			)
			(1
				(if ((ScriptID 64017 0) test: 34) ; oFlags
					(self cue:)
				else
					(gEgo setHeading: 45 self)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roGuardHouseInt of TPRoom
	(properties
		picture 15100
		south 15000
	)

	(method (init)
		(super init: &rest)
		(gEgo init: normalize: setScaler: Scaler 100 92 239 192)
		(= gnHermanTalker 3)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(15000 ; roGuardHouseExt
				(gGame handsOff:)
				(gEgo posn: 635 262 loop: 3)
				(if ((ScriptID 64017 0) test: 31) ; oFlags
					(gEgo setScript: soSecondEntrance)
					((ScriptID 64018 0) init: setScript: soBoogleEntrance) ; oBoogle
				else
					(gEgo setScript: soFirstEntrance)
				)
			)
			(15200 ; roPortalChamber
				(gGame handsOff:)
				(gEgo posn: 200 184 loop: 4)
				(gEgo setMotion: MoveTo 273 209 soBooglePassageEntrance)
				((ScriptID 64018 0) init: setScript: soBooglePassageEntrance) ; oBoogle
			)
			(else
				(gEgo posn: 282 292 loop: 3)
			)
		)
		(foMainExit init:)
		(if ((ScriptID 64017 0) test: 34) ; oFlags
			(foDoorExit init:)
			(voBookcase init:)
			(foEmptiness init:)
			(goMusic1 setMusic: 15200)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 640 212 461 227 374 193 343 205 224 187 203 200 178 204 123 221 304 255 607 287 632 320
						yourself:
					)
			)
		else
			(goMusic1 setMusic: 15100)
			(if ((ScriptID 64017 0) test: 31) ; oFlags
				(poGuard setLoop: 1 setCel: (poGuard lastCel:) init:)
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 640 212 461 227 374 193 390 176 283 174 203 200 178 204 123 221 304 255 607 287 632 320
						yourself:
					)
			)
		)
		(if ((ScriptID 64017 0) test: 33) ; oFlags
			(voCup init:)
		)
		(if ((ScriptID 64017 0) test: 32) ; oFlags
			(voPlate init:)
		)
		((ScriptID 64017 0) set: 31) ; oFlags
	)

	(method (dispose)
		(= gnHermanTalker 0)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo
			get:
				((ScriptID 64001 0) get: 4) ; oInvHandler, ioChuckBerries
				((ScriptID 64001 0) get: 5) ; oInvHandler, ioSquareRoot
				((ScriptID 64001 0) get: 11) ; oInvHandler, ioPeat
				((ScriptID 64001 0) get: 10) ; oInvHandler, ioSlugs
		)
	)
)

