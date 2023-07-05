;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50500)
(include sci.sh)
(use Main)
(use oInvHandler)
(use oHandsOnWhenCued)
(use TPScript)
(use n64896)
(use Talker)
(use Motion)
(use Actor)
(use System)

(public
	roJailCell 0
	toJudge 1
)

(instance poTorin of Prop
	(properties)
)

(instance poBoogle of Prop
	(properties)
)

(instance poDreep of Prop
	(properties)
)

(instance poCop of Prop
	(properties)
)

(instance aoTorin of Actor
	(properties)

	(method (setHeading head)
		(= heading head)
	)

	(method (cantBeHere)
		(return 0)
	)
)

(instance poJudge of Prop
	(properties
		x 318
		y 102
		priority 102
		fixPriority 1
		view 50503
		loop 1
	)
)

(instance voJudgeFace of View
	(properties
		x 318
		y 102
		priority 105
		fixPriority 1
		view 50503
		loop 2
	)
)

(instance toJudge of Talker
	(properties
		x 318
		y 102
		view 50503
		loop 2
		priority 200
	)

	(method (init)
		(= loop (voJudgeFace loop:))
		(voJudgeFace hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voJudgeFace show:)
		(super dispose: &rest)
	)
)

(instance soCycleJudgeDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voJudgeFace hide: setLoop: 5)
				(poJudge loop: 3 cel: 0 setCycle: End self)
			)
			(1
				(= ticks (poJudge cycleSpeed:))
			)
			(2
				(poJudge loop: 4 cel: 0)
				(voJudgeFace show:)
				(self dispose:)
			)
		)
	)
)

(instance soCycleJudgeUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(voJudgeFace hide: setLoop: 2)
				(poJudge loop: 6 cel: 0 setCycle: End self)
			)
			(1
				(= ticks (poJudge cycleSpeed:))
			)
			(2
				(poJudge loop: 1 cel: 0)
				(voJudgeFace show:)
				(self dispose:)
			)
		)
	)
)

(instance soCycleTorinUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin loop: 8 cel: 0 setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soCycleTorinDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin loop: 9 cel: 0 setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soPlayMovie of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(LoseAllBut)
				(gEgo put: ((ScriptID 64001 0) get: 34)) ; oInvHandler, ioKnife
				(gCurRoom picture: 50500)
				(gCurRoom drawPic: 50500)
				(goMusic1 setMusic: 50400)
				(poTorin
					view: 50501
					loop: 3
					cel: 0
					posn: 140 204
					setPri: 265
					init:
				)
				(= ticks 360)
			)
			(1
				(poDreep
					view: 50501
					loop: 2
					cel: 0
					posn: 434 142
					init:
					setCycle: End self
				)
			)
			(2
				(poDreep dispose:)
				(poTorin loop: 3 cel: 0 posn: 140 204 setCycle: CT 10 1 self)
				(goMusic1 playSound: 50597)
			)
			(3
				(poTorin setCycle: End self)
				(gMessager say: 0 0 2 0 self) ; "Now what do I do? All this way...just to be arrested."
			)
			(4)
			(5
				(poTorin loop: 5 cel: 0 posn: 140 204 setCycle: End self)
				(gMessager say: 0 0 1 1 self) ; "Boogle! Is that you?"
			)
			(6)
			(7
				(poBoogle
					view: 50501
					loop: 4
					cel: 0
					posn: 513 202
					setPri: 100
					init:
					setCycle: CT 7 1 self
				)
			)
			(8
				(= ticks 5)
			)
			(9
				(poBoogle dispose:)
				(poDreep dispose:)
				(poTorin dispose:)
				(gCurRoom picture: 50501)
				(gCurRoom drawPic: 50501)
				(poTorin view: 50502 loop: 3 cel: 0 posn: 313 319 init:)
				(poBoogle
					view: 50502
					loop: 0
					cel: 0
					posn: 312 319
					setPri: -1
					init:
					setCycle: End self
				)
			)
			(10
				(goMusic1 setMusic: 50599)
				(poDreep
					view: 50502
					loop: 1
					cel: 0
					posn: 355 307
					setPri: 1
					init:
					setCycle: CT 9 1 self
				)
			)
			(11
				(= ticks 45)
			)
			(12
				(poDreep setCycle: CT 14 1 self)
			)
			(13
				(poDreep setCycle: CT 15 1 self)
			)
			(14
				(= ticks (poDreep cycleSpeed:))
			)
			(15
				(poDreep setPri: 500 cel: 16 doit: setCycle: CT 21 1 self)
				(poBoogle dispose:)
				(gMessager say: 0 0 1 2) ; "(DREEP'S GOT ME!) Bwark. Bwaaaarrrrkkkk!!"
			)
			(16
				(poDreep setPri: 1 setCycle: CT 22 1 self)
			)
			(17
				(= ticks 60)
			)
			(18
				(poDreep setCycle: End self)
			)
			(19
				(poTorin dispose:)
				(poDreep dispose:)
				(gCurRoom picture: 50500)
				(gCurRoom drawPic: 50500)
				(poTorin
					view: 50502
					loop: 2
					cel: 0
					posn: 430 255
					init:
					setCycle: End self
				)
				(gMessager kill:)
				(gMessager say: 0 0 3 0 self) ; "BOOGLE! NO!!"
			)
			(20)
			(21
				(= ticks 60)
			)
			(22
				(gMessager say: 0 0 4 1 self) ; "(CRESTFALLEN AS BOOGLE IS CAPTURED BY GOONS) Oh, Boogle."
			)
			(23
				(= ticks 180)
			)
			(24
				(gMessager say: 0 0 4 3 self) ; "Come on, boy. It's time!"
			)
			(25
				(poTorin dispose:)
				(gCurRoom picture: 50502)
				(gCurRoom drawPic: 50502)
				(goMusic1 setMusic: 50598)
				(poTorin view: 50503 loop: 0 cel: 0 posn: 305 296 init:)
				(poJudge view: 50503 loop: 1 cel: 0 posn: 318 102 init:)
				(voJudgeFace view: 50503 loop: 2 cel: 0 posn: 318 102 init:)
				(gMessager say: 0 0 5 1 self) ; "Do you have anything to say before I pass judgment, young man?"
			)
			(26
				(gMessager say: 0 0 5 2 self) ; "(START SLOW AND ACCELERATE AS YOU GET EXCITED) Well, no sir, not really. It's just that, well, I'm really sorry I landed in your plants. It was an accident. I only landed in that flower bed because I fell out of that air duct that I crawled through to escape from that storeroom that I materialized in from that phenocryst that I used to get here from Asthenia. I didn't..."
				(self setScript: soCycleTorinUp self)
			)
			(27)
			(28
				(self setScript: soCycleJudgeDown self)
			)
			(29
				(gMessager sayRange: 0 0 5 3 4 self) ; "(INTERRUPTING, INCREDULOUS) Phenocryst, you say?"
				(self setScript: soCycleTorinDown self)
			)
			(30)
			(31
				(self setScript: soCycleJudgeUp self)
			)
			(32
				(gMessager say: 0 0 5 5 self) ; "I haven't heard of one of those being used in years. Where did you say you're from, son?"
			)
			(33
				(gMessager say: 0 0 5 6 self) ; "(SLOWLY AND ACCEL AGAIN) From The Lands Above, sir. See, see, this evil sorceress put my parents in a magic spell and kidnapped them and this old guy saw it all and he said her name was Lycentia and she's from down here and that's where my parents are so I set out to find her and save them but nobody has ever heard of her and well I don't even know if she's down here or if this has all been some kind of... (FINALLY RUNS OUT OF GAS) ...Geez, do you think YOU could help me, Sir?"
				(self setScript: soCycleTorinUp self)
			)
			(34)
			(35
				(gMessager say: 0 0 5 7 self) ; "Lycentia, eh? (COVERING UP; HE KNOWS HE SENT HER AWAY) There's no one on this planet by that name."
			)
			(36
				(gMessager sayRange: 0 0 5 8 10 self) ; "But whether you're a visitor here or not, you need to learn three lessons about Tenebrous and me."
				(self setScript: soCycleTorinDown self)
			)
			(37)
			(38
				(self setScript: soCycleJudgeDown self)
			)
			(39
				(gMessager say: 0 0 5 11 self) ; "And, third, one more mistake and I'll toss you right off this planet into the Null Void!"
			)
			(40
				(self setScript: soCycleJudgeUp self)
			)
			(41
				(gMessager say: 0 0 5 12 self) ; "(TO POLICEMAN) Now take him back where you found him! (TO TORIN) And young man, I don't ever want to see YOU here again!"
			)
			(42
				(voJudgeFace hide:)
				(poJudge loop: 7 cel: 0 setCycle: CT 2 1 self)
			)
			(43
				(goSound1 playSound: 50501)
				(poJudge setCycle: End self)
			)
			(44
				(poJudge loop: 7 cel: 0 setCycle: CT 2 1 self)
			)
			(45
				(goSound1 playSound: 50501)
				(poJudge setCycle: CT 5 1 self)
			)
			(46
				(poTorin loop: 10 cel: 0 setCycle: End self)
			)
			(47
				(gCurRoom newRoom: 50400) ; roInPlanter
			)
		)
	)

	(method (ff)
		(gCurRoom newRoom: 50400) ; roInPlanter
	)

	(method (rewind)
		(poBoogle dispose:)
		(poTorin dispose:)
		(poDreep dispose:)
		(poJudge dispose:)
		(voJudgeFace dispose:)
		(gCurRoom newRoom: 50300) ; roAirDuctEnd
	)
)

(instance toCop1 of Talker
	(properties
		x 537
		y 284
		view 55000
		loop 4
		priority 500
	)
)

(instance toCop2 of Talker
	(properties
		x 487
		y 289
		view 55000
		loop 5
		priority 500
	)
)

(instance soPlayMovie2 of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(FadeToBlack 0 100 self)
			)
			(1
				(gCurRoom picture: 50502)
				(gCurRoom drawPic: 50502)
				(goMusic1 setMusic: 50598)
				(poTorin view: 50503 loop: 0 cel: 0 posn: 305 296 init:)
				(poJudge view: 50503 loop: 1 cel: 0 posn: 318 104 init:)
				(voJudgeFace view: 50503 loop: 2 cel: 0 posn: 318 104 init:)
				(gMessager say: 0 0 0 1 self 55000) ; "(FORMAL SENTENCING VOICE) Torin of The Lands Above, since you violated the probationary period I granted you, I have no choice but to sentence you to immediate ostracization from the world of Tenebrous. Into the Null Void with him!"
			)
			(2
				(voJudgeFace hide:)
				(poJudge loop: 7 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(goSound1 playSound: 50501)
				(poJudge setCycle: End self)
			)
			(4
				(poJudge loop: 7 cel: 0 setCycle: CT 2 1 self)
			)
			(5
				(goSound1 playSound: 50501)
				(poJudge setCycle: CT 5 1 self)
			)
			(6
				(gMessager sayRange: 0 0 0 2 3 self 55000) ; "Not the Null Void!"
				(self setScript: soCycleTorinUp self)
			)
			(7)
			(8
				(poTorin dispose:)
				(poJudge dispose:)
				(voJudgeFace dispose:)
				(gCurRoom picture: 55002)
				(gCurRoom drawPic: 55002)
				(goMusic1 setMusic: 55099)
				(poCop view: 55000 posn: 537 284 loop: 0 cel: 0 init:)
				(goSound1 preload: 55003)
				(= gtCop toCop1)
				(gMessager say: 0 0 0 4 self 55000) ; "Here we are, boy. You stand over THERE!"
			)
			(9
				(poCop setCycle: End self)
			)
			(10
				(if ((ScriptID 64017 0) test: 216) ; oFlags
					((ScriptID 56000 0) stopCorder:) ; oCrystCorder
				)
				(goSound1 playSound: 55003)
				((ScriptID 64017 0) set: 225) ; oFlags
				(if (not ((ScriptID 64017 0) test: 214)) ; oFlags
					(((ScriptID 64001 0) get: 53) moveTo: -1) ; oInvHandler, ioAudcryst
					(gEgo get: ((ScriptID 64001 0) get: 54)) ; oInvHandler, ioShatteredShard
					(LoseAllBut
						((ScriptID 64001 0) get: 54) ; oInvHandler, ioShatteredShard
						((ScriptID 64001 0) get: 52) ; oInvHandler, ioCrystcorder
						((ScriptID 64001 0) get: 46) ; oInvHandler, ioBagpipes
						((ScriptID 64001 0) get: 51) ; oInvHandler, ioMagicBook
					)
				else
					(LoseAllBut
						((ScriptID 64001 0) get: 52) ; oInvHandler, ioCrystcorder
						((ScriptID 64001 0) get: 46) ; oInvHandler, ioBagpipes
						((ScriptID 64001 0) get: 51) ; oInvHandler, ioMagicBook
					)
				)
				(poCop loop: 1 setCycle: End self)
				(poTorin
					view: 55000
					posn: 414 273
					loop: 2
					cel: 0
					init:
					setCycle: CT 6 1 self
				)
			)
			(11)
			(12
				(= ticks 120)
			)
			(13
				(poTorin setCycle: End self)
			)
			(14
				(poCop loop: 3 cel: 0 posn: 487 289 setCycle: CT 1 1 self)
			)
			(15
				(poCop cel: 2)
				(poTorin dispose:)
				(= ticks (poCop cycleSpeed:))
			)
			(16
				(gMessager say: 0 0 0 5 self 55000) ; "Hey!"
				(poCop setCycle: End self)
			)
			(17)
			(18
				(= gtCop toCop2)
				(gMessager say: 0 0 0 6 self 55000) ; "Good riddance, plant crusher!"
			)
			(19
				(= gtCop 0)
				(poCop dispose:)
				(gCurRoom picture: 55003)
				((gCurRoom plane:) drawPic: 55003)
				(aoTorin
					view: 51102
					loop: 1
					cel: 0
					posn: 316 192
					init:
					setCycle: CT 4 1 self
					setStep: 1 20
				)
			)
			(20
				(poCop view: 51102 loop: 2 posn: 290 192 setPri: 2 init:)
				(aoTorin setCycle: CT 7 1 self)
			)
			(21
				(aoTorin setCycle: End self setMotion: MoveTo 316 0)
			)
			(22
				(aoTorin dispose:)
				(gCurRoom newRoom: 51100) ; roInsideNullVoid
			)
		)
	)
)

(instance roJailCell of TPRoom
	(properties)

	(method (init)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 224) ; oFlags
			(gCurRoom setScript: soPlayMovie2)
		else
			(gCurRoom setScript: soPlayMovie)
		)
	)

	(method (gimme))
)

