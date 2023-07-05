;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro371 0
	proc371_1 1
	proc371_2 2
)

(local
	local0
	local1
	local2
	local3
)

(procedure (proc371_1)
	(gMessager say: 0 0 12) ; "What? Save your game? Are you trying to cheat?"
)

(procedure (proc371_2)
	(gCurRoom setScript: soTryToLeave)
)

(instance ro371 of L7Room
	(properties
		picture 37100
	)

	(method (init)
		(super init:)
		(= global330 toLarry)
		(= gToCroupier toCroupier)
		(poLarry init:)
		(poJacques init:)
		(foPlayArea init:)
		(foExit init:)
		(gGame handsOn:)
		(if ((ScriptID 64017 0) test: 200) ; oFlags
			((ScriptID 64017 0) clear: 200) ; oFlags
			(poJacques doVerb: 4)
		)
	)

	(method (gimme)
		(gEgo
			get:
				((ScriptID 64037 0) get: 42) ; oInvHandler, ioSouvenirDice
				((ScriptID 64037 0) get: 40) ; oInvHandler, ioShavedDice
				((ScriptID 64037 0) get: 19) ; oInvHandler, ioLegalDice
		)
	)

	(method (newRoom newRoomNumber)
		(if (gEgo has: ((ScriptID 64037 0) get: 19)) ; oInvHandler, ioLegalDice
			(gCurRoom setScript: soTryToLeave)
		else
			(if (!= newRoomNumber 370) ; ro370
				(gOMusic1 fadeOut:)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (dispose)
		(= global330 0)
		(= gToCroupier 0)
		(super dispose: &rest)
	)
)

(instance soLose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 37201) ; WAVE
				(= cycles 3)
			)
			(1
				(= ticks 30)
			)
			(2
				(switch global217
					(0
						(gMessager say: 1 40 1 1 self) ; "Come on! Baby needs a new pair of platform shoes!"
					)
					(1
						(gMessager say: 1 40 2 1 self) ; "I can feel Lady Luck comin' on!"
					)
					(2
						(gMessager say: 1 40 3 1 self) ; "Oooh, these dice are hot, hot, hot!"
					)
					(3
						(gMessager say: 1 40 4 1 self) ; "I GOTTA win sometime!"
					)
					(4
						(gMessager say: 1 40 5 1 self) ; "I'm a dice-rolling machine!"
					)
					(5
						(gMessager say: 1 40 10 1 self) ; "Here it comes. Here it comes!"
					)
					(else
						(gMessager say: 1 40 11 1 self) ; "My luck has gotta change this time!"
					)
				)
			)
			(3
				(poLarryEyes2 dispose:)
				(gOSound1 playSound: 37201)
				(poLarry2 loop: 0 cel: 0 posn: 214 354 setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(poLarry2 loop: 2 cel: 0 posn: 347 305 setCycle: End self 4)
			)
			(6
				(switch global217
					(0
						(gMessager say: 1 40 1 2 self) ; "(LOSES) Oh!"
					)
					(1
						(gMessager say: 1 40 2 2 self) ; "(LOSES) Guess she went right past me."
					)
					(2
						(gMessager say: 1 40 3 2 self) ; "(LOSES) But I'm cold, cold, cold."
					)
					(3
						(gMessager say: 1 40 4 2 self) ; "(LOSES) And that time isn't now."
					)
					(4
						(gMessager say: 1 40 5 2 self) ; "(LOSES) Guess I need a tune-up."
					)
					(5
						(gMessager say: 1 40 10 2 self) ; "(LOSES) There it goes! There it goes."
					)
					(else
						(gMessager say: 1 40 11 2 self) ; "(LOSES) Yeah, it changed. It got worse!"
					)
				)
				(if (> (++ global217) 6)
					(= global217 0)
				)
			)
			(7
				(poLarry2 loop: 0 cel: 0 posn: 214 354)
				(gCurRoom deleteRoomPlane: oRollingCUPlane)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 37201 36201 37104) ; WAVE
				(= register 0)
				(= cycles 3)
			)
			(1
				(= ticks 30)
			)
			(2
				(if local3
					(gCurRoom addRoomPlane: oRollingCUPlane)
				)
				(poLarryEyes2 show:)
				(poLarry2 loop: 0 cel: 0 posn: 214 354 doit:)
				(if ((ScriptID 64017 0) test: 89) ; oFlags
					(gMessager say: 1 39 13 (++ register) self)
				else
					(gMessager say: 1 39 8 (++ register) self)
				)
			)
			(3
				(gOSound1 playSound: 37201)
				(poLarryEyes2 hide:)
				(poLarry2 loop: 0 cel: 0 posn: 214 354 setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(poLarry2 loop: 3 cel: 0 posn: 217 354 setCycle: End self)
			)
			(6
				(= ticks 30)
			)
			(7
				(gCurRoom deleteRoomPlane: oRollingCUPlane)
				(if (== register 1)
					(voChips init:)
				else
					(voChips cel: 1)
				)
				(poLarry view: 37105 loop: 0 cel: 0 posn: 503 151 doit:)
				(poLarryMouth posn: 505 152)
				(voLarryBust posn: 505 152)
				(cond
					((and ((ScriptID 64017 0) test: 89) (>= register 3)) ; oFlags
						(gMessager sayRange: 1 39 13 4 99 self) ; "Yes, yes, yes!"
					)
					(((ScriptID 64017 0) test: 89) ; oFlags
						(poJacques
							loop: 3
							cel: 8
							doit:
							setScript: soPushDice self
						)
						(gMessager say: 1 39 13 (++ register) self)
					)
					(else
						(poJacques
							loop: 3
							cel: 8
							doit:
							setScript: soPushDice self
						)
						(gMessager say: 1 39 8 (++ register) self)
					)
				)
			)
			(8
				(if (and ((ScriptID 64017 0) test: 89) (>= register 3)) ; oFlags
					(gEgo get: ((ScriptID 64037 0) get: 52)) ; oInvHandler, ioMoney
					(gCurRoom newRoom: 370) ; ro370
					(self dispose:)
				)
			)
			(9
				(poLarry setScript: soGetChips self)
			)
			(10
				(if (< register 4)
					(= local3 1)
					(= global330 toLarry2)
					(self changeState: 2)
				else
					(= cycles 1)
				)
			)
			(11
				(gCurRoom addRoomPlane: oRollingCUPlane)
				(voChipsCU cel: 1)
				(poDewmi init: hide:)
				(poLarryEyes2 show:)
				(poLarry2 loop: 0 cel: 0 posn: 214 354 doit:)
				(gMessager say: 1 39 8 6 self) ; "(WINS; NOT TOO BIG) Look at those stacks!"
			)
			(12
				(poDewmi show: setCycle: End self)
				(gOMusic1 setMusic: 37300)
			)
			(13
				(poLarryEyes2 hide:)
				(poLarry2
					view: 37300
					loop: 0
					cel: 0
					posn: 331 309
					setCycle: End self
				)
			)
			(14
				(gMessager say: 1 39 8 7 self) ; "(DEWMI MOORE ENTERS FRAME) Oh, my gawd! Look at THOSE stacks!"
				(poLarry2 loop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(15 0)
			(16
				(= global335 toDewmi)
				(= global330 toLarry3)
				(gMessager sayRange: 1 39 8 8 11 self) ; "Hello, handsome. I'm Dewmi Moore."
			)
			(17
				(poLarry2 setCycle: Beg self)
			)
			(18
				(= global330 toLarry2)
				(poLarryEyes2 show:)
				(gMessager say: 1 39 8 5 self) ; "(YOU'RE HOT NOW!) Finally, I'm gettin' lucky!!"
			)
			(19
				(gOSound1 playSound: 37201)
				(poLarryEyes2 hide:)
				(poLarry2
					view: 37205
					loop: 0
					cel: 0
					setPri: 505
					posn: 214 354
					setCycle: End self
				)
			)
			(20
				(= ticks 60)
			)
			(21
				(poLarry2 loop: 1 cel: 0 posn: 217 354 setCycle: End self)
			)
			(22
				(gCurRoom drawPic: 37500)
				(Palette 1 375) ; PalLoad
				(= global335 toDewmi2)
				(voChipsCU dispose:)
				(poDewmi view: 37500 loop: 3 cel: 0 posn: 391 412 doit:)
				(poLarry2 view: 37501 loop: 0 cel: 0 posn: 391 412 doit:)
				(poLarryEyes2
					view: 37501
					loop: 1
					cel: 0
					posn: 391 412
					show:
					doit:
				)
				(= ticks 30)
			)
			(23
				(poDewmi cycleSpeed: 15 setCycle: End self)
			)
			(24
				(poDewmiArm
					init:
					loop: 2
					cel: 0
					cycleSpeed: 9
					setPri: 605
					setCycle: End self
				)
				(poLarryEyes2 loop: 2 cel: 0 setCycle: End)
				(gMessager say: 1 39 8 12 self) ; "Would you like to go to my cabin... for a "more intimate" dice game?"
			)
			(25
				(poLarryEyes2 loop: 3 cel: 0 setCycle: End self)
			)
			(26 0)
			(27
				(poLarryEyes2 cel: 0 setCycle: End)
				(gMessager say: 1 39 8 13 self) ; "Hubba, hubba. (Hope I have a rubba!)"
			)
			(28
				(gCurRoom drawPic: 37600)
				(Palette 1 376) ; PalLoad
				(poDewmi hide:)
				(poDewmiArm hide:)
				(= global330 toLarry4)
				(poLarry2
					view: 37600
					loop: 0
					cel: 0
					setPri: 500
					posn: 0 478
					doit:
				)
				(poLarry2Mouth init: doit:)
				(poLarryEyes2
					view: 37600
					loop: 2
					cel: 0
					posn: 0 478
					setPri: 510
					doit:
					setCycle: End
				)
				(gMessager say: 1 39 8 14 self) ; "Sure. What is it?"
			)
			(29
				(gCurRoom drawPic: 37500)
				(Palette 1 375) ; PalLoad
				(= global335 toDewmi2)
				(poDewmi show: doit:)
				(poDewmiArm show: doit:)
				(poLarry2 view: 37501 loop: 0 cel: 0 posn: 391 412 doit:)
				(poLarry2Mouth hide:)
				(poLarryEyes2 view: 37501 loop: 3 cel: 99 posn: 391 412 doit:)
				(gMessager say: 1 39 8 15 self) ; "Strip liar's dice. You do know how to play strip liar's dice, don't you, Larry?"
			)
			(30
				(gCurRoom drawPic: 37600)
				(Palette 1 376) ; PalLoad
				(poDewmi hide:)
				(poDewmiArm dispose:)
				(= global330 toLarry4)
				(poLarry2 view: 37600 loop: 0 cel: 0 posn: 0 478 doit:)
				(poLarry2Mouth show: doit:)
				(poLarryEyes2
					view: 37600
					loop: 2
					cel: 99
					posn: 0 478
					setPri: 515
					doit:
					setCycle: Beg
				)
				(gMessager sayRange: 1 39 8 16 17 self) ; "Sure!"
			)
			(31
				(poLarryEyes2 setCycle: End)
				(gMessager say: 1 39 8 18 self) ; "Where's your cabin?"
			)
			(32
				(gCurRoom drawPic: 37700)
				(Palette 1 377) ; PalLoad
				(poLarry2 hide:)
				(poLarry2Mouth hide:)
				(poLarryEyes2 hide:)
				(poTikiFlames init: doit: setCycle: Fwd)
				(poFlashNips init: doit: setCycle: Fwd)
				(poNeonSign init: doit: setCycle: Fwd)
				(= global335 toDewmi3)
				(poDewmiMouth2 view: 37700 loop: 1 cel: 0 posn: 284 479)
				(poDewmi view: 37700 loop: 2 cel: 0 posn: 284 479 show: doit:)
				(= local2 0)
				(gMessager say: 1 39 8 19 oMessageDone) ; "It's 510. I'll go get the dice and the cups!"
				(= ticks 120)
			)
			(33
				(if (not local2)
					(poDewmiMouth2 hide:)
				)
				(poDewmi cycleSpeed: 7 setCycle: End self)
			)
			(34
				(if local2
					(= cycles 1)
				else
					(-- state)
					(= cycles 3)
				)
			)
			(35
				(gCurRoom drawPic: 37800)
				(Palette 1 378) ; PalLoad
				(poDewmi dispose:)
				(poTikiFlames dispose:)
				(poFlashNips dispose:)
				(poNeonSign dispose:)
				(= global330 toLarry5)
				(= global335 0)
				(poLarry2 view: 37800 loop: 0 cel: 0 posn: 0 478 show: doit:)
				(poLarry2Mouth
					view: 37800
					loop: 1
					cel: 0
					posn: 0 478
					show:
					doit:
				)
				(poLarryEyes2
					view: 37800
					loop: 2
					cel: 0
					posn: 0 478
					show:
					doit:
				)
				(gMessager say: 1 39 8 20 self) ; "(BEWILDERED) You mean, I gotta wear a cup?!"
				(= ticks 60)
			)
			(36
				(poLarryEyes2 setCycle: End self)
			)
			(37 0)
			(38
				(gCurRoom drawPic: 37600)
				(Palette 1 376) ; PalLoad
				(= global330 toLarry4)
				(poLarry2 view: 37600 loop: 0 cel: 0 doit:)
				(poLarry2Mouth view: 37600 loop: 1 cel: 0 doit:)
				(poLarryEyes2
					view: 37600
					loop: 2
					cel: 0
					setPri: 515
					doit:
					setCycle: End
				)
				(gMessager say: 1 39 8 21 self) ; "Hurry, Larry! I just can't wait to... "up your ante!""
			)
			(39
				(poLarryEyes2 setCycle: Beg)
				(gMessager say: 1 39 8 22 self) ; "(MOAN SOFTLY) Oooh."
			)
			(40
				(gEgo get: ((ScriptID 64037 0) get: 52)) ; oInvHandler, ioMoney
				((ScriptID 64017 0) set: 89) ; oFlags
				((ScriptID 80 0) setReal: (ScriptID 80 0) 0) ; oAnnounceTimer, oAnnounceTimer
				(proc64896_1 1 2 self)
			)
			(41
				(gCurRoom deleteRoomPlane: oRollingCUPlane newRoom: 510) ; ro510
				(self dispose:)
			)
		)
	)
)

(instance soBuyChips of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 36201 37104) ; WAVE
				(if local0
					(gMessager say: 1 79 7 1 self) ; "Let's go again. Another hundred on "come." Well, I mean, the "come line." You know, the line with... yeah."
				else
					(gMessager say: 1 79 6 1 self) ; "Here's my Thygh's Man Trophy scorecard. Charge a hundred smackers worth of chips to my room, will ya, bub? I feel lucky!"
				)
			)
			(1
				(poLarry loop: 2 cel: 0 setCycle: CT 12 1 self)
				(if local0
					(gMessager say: 1 79 7 2 self) ; "No problem."
				else
					(gMessager say: 1 79 6 2 self) ; "Of course, sir."
				)
			)
			(2 0)
			(3
				(poJacques loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(poJacques loop: 3 cel: 0 setScript: soPushDice self)
				(poLarry setCycle: End self)
			)
			(5
				(if local0
					(= local2 1)
					(gMessager say: 1 79 7 3) ; "(Yankee asshole.)"
				else
					(= local2 0)
					(gMessager say: 1 79 6 3 oMessageDone) ; "Put it all on "come." With a name like that, how can I lose?"
				)
			)
			(6
				(if local2
					(poJacques loop: 1 cel: 0)
					(if local0
						(= cycles 1)
					else
						(gMessager say: 1 79 6 4 self) ; "Yes sir. Right away. Here are your dice."
					)
				else
					(-- state)
					(= cycles 3)
				)
			)
			(7
				(poLarry
					view: 37105
					loop: 0
					cel: 0
					posn: 503 152
					setScript: soGetChips self
				)
				(if local0
					(= cycles 1)
				else
					(gMessager say: 1 79 6 5 self) ; "(American asshole.)"
				)
			)
			(8 0)
			(9
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPushDice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self 23 30 999)
			)
			(1
				(gOSound1 playSound: 37104)
			)
			(2
				(voDie1 init:)
				(voDie2 init:)
			)
			(3
				(client setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance soGetChips of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self 7 999)
			)
			(1
				(gOSound1 playSound: 36201)
				(voDie1 dispose:)
				(voDie2 dispose:)
			)
			(2
				(client view: 37100 loop: 2 cel: 0 posn: 509 153 setCycle: 0)
				(gEgo get: ((ScriptID 64037 0) get: 19)) ; oInvHandler, ioLegalDice
				(self dispose:)
			)
		)
	)
)

(instance soTryToLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 playSubtitledSound: 5011 2 0 0 2 self 341)
			)
			(1
				(gMessager say: 0 0 9 0 self) ; "You can't leave with the dice, sir. Either roll them or give them back to me and cancel your bet. House rules, you know."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poJacques of Prop
	(properties
		noun 2
		priority 300
		x 211
		y 197
		loop 1
		view 37110
		fixPriority 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(40 ; Legal Dice
				(gOSound1 playSound: 37103)
				(super doVerb: theVerb)
				(gEgo put: ((ScriptID 64037 0) get: 19)) ; oInvHandler, ioLegalDice
			)
			(79 ; Play
				(foPlayArea doVerb: 79)
			)
			(16 ; TMT Scorecard
				(foPlayArea doVerb: 79)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poLarry of Prop
	(properties
		priority 300
		x 509
		y 153
		loop 2
		view 37100
		fixPriority 1
	)
)

(instance poLarry2 of Prop
	(properties
		priority 500
		x 214
		y 354
		view 37205
		fixPriority 1
	)
)

(instance poLarry2Mouth of Prop
	(properties
		priority 505
		y 478
		loop 1
		view 37600
		fixPriority 1
	)
)

(instance poDewmi of Prop
	(properties
		priority 200
		x 577
		y 332
		view 37305
		fixPriority 1
	)
)

(instance poDewmiDouble of Prop ; UNUSED
	(properties
		priority 500
		x 577
		y 332
		loop 3
		view 37305
		fixPriority 1
	)
)

(instance poDewmiArm of Prop
	(properties
		priority 500
		x 391
		y 412
		loop 2
		view 37500
		fixPriority 1
	)
)

(instance poTikiFlames of Prop
	(properties
		x 143
		y 153
		view 37750
	)
)

(instance poFlashNips of Prop
	(properties
		x 318
		y 103
		view 37755
	)
)

(instance poNeonSign of Prop
	(properties
		x 318
		y 103
		loop 1
		view 37755
	)
)

(instance voDie1 of View
	(properties
		priority 100
		x 458
		y 216
		view 37315
		fixPriority 1
	)
)

(instance voDie2 of View
	(properties
		priority 100
		x 470
		y 223
		view 37315
		fixPriority 1
	)
)

(instance voChips of View
	(properties
		x 309
		y 321
		view 37199
	)
)

(instance voChipsCU of View
	(properties
		x 370
		y 479
		view 37299
	)
)

(instance foPlayArea of Feature
	(properties
		noun 1
		x 351
		y 276
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 66 291 388 176 637 213 488 355 458 370 418 377 375 374
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 79)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(40 ; Legal Dice
				(gCurRoom addRoomPlane: oRollingCUPlane)
			)
			(39 ; Shaved Dice
				(if (gEgo has: ((ScriptID 64037 0) get: 19)) ; oInvHandler, ioLegalDice
					((ScriptID 64017 0) set: 88) ; oFlags
					(= local1 1)
					(gCurRoom addRoomPlane: oRollingCUPlane)
				else
					(gMessager say: 2 39) ; "Mind if I use my own dice?"
				)
			)
			(79 ; Play
				(cond
					((not (gEgo has: ((ScriptID 64037 0) get: 46))) ; oInvHandler, ioScorecard
						(gMessager say: 1 79 15) ; "Even though you've "cleared" the table, you can't enter the Thygh's Man Trophy craps-playing competition without a Thygh's Man Trophy scorecard. You'd better get up to the lounge pronto, Tonto! The meeting's starting right now!"
					)
					((gEgo has: ((ScriptID 64037 0) get: 19)) ; oInvHandler, ioLegalDice
						(self doVerb: 40)
					)
					(else
						(gCurRoom setScript: soBuyChips)
					)
				)
			)
			(16 ; TMT Scorecard
				(self doVerb: 79)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foExit of CUExitFeature
	(properties
		rExitTo 370
	)

	(method (doVerb)
		(if (gEgo has: ((ScriptID 64037 0) get: 19)) ; oInvHandler, ioLegalDice
			(gCurRoom setScript: soTryToLeave)
		else
			(super doVerb: &rest)
		)
	)
)

(instance oRollingCUPlane of Plane
	(properties
		picture 37200
	)

	(method (init)
		(gThePlane drawPic: -1)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(Palette 1 372) ; PalLoad
		((ScriptID 64017 0) set: 243) ; oFlags
		(= global330 toLarry2)
		(poLarry2 init: posn: 214 354)
		(poLarryEyes2 init:)
		(cond
			(local3
				(voChipsCU init:)
			)
			(local1
				(voChipsCU init: hide:)
				(gCurRoom setScript: soWin)
			)
			(else
				(gCurRoom setScript: soLose)
			)
		)
	)

	(method (dispose)
		(gThePlane drawPic: 37100)
		(Palette 1 371) ; PalLoad
		(gEgo put: ((ScriptID 64037 0) get: 19)) ; oInvHandler, ioLegalDice
		(= global330 toLarry)
		(super dispose:)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(super init: poLarryMouth voLarryBust)
		(poLarry hide:)
	)

	(method (dispose)
		(poLarry show:)
		(super dispose:)
	)
)

(instance poLarryMouth of Prop
	(properties
		x 509
		y 153
		loop 1
		view 37100
	)

	(method (init)
		(self setPri: (+ (poLarry priority:) 1))
		(super init: &rest)
	)
)

(instance voLarryBust of View
	(properties
		x 509
		y 153
		view 37100
	)

	(method (init)
		(self setPri: (poLarry priority:))
		(super init: &rest)
	)
)

(instance toCroupier of Talker
	(properties)

	(method (init)
		(= x (poJacques x:))
		(= y (poJacques y:))
		(super init: poCroupierMouth voCroupierBust)
		(poJacques hide:)
	)

	(method (dispose)
		(poJacques show:)
		(super dispose:)
	)
)

(instance poCroupierMouth of Prop
	(properties
		loop 2
		view 37110
	)

	(method (init)
		(= x (poJacques x:))
		(= y (poJacques y:))
		(self setPri: (+ (poJacques priority:) 1))
		(super init: &rest)
	)
)

(instance voCroupierBust of View
	(properties
		loop 1
		view 37110
	)

	(method (init)
		(= x (poJacques x:))
		(= y (poJacques y:))
		(self setPri: (poJacques priority:))
		(super init: &rest)
	)
)

(instance toLarry2 of Talker
	(properties
		x 264
		y 218
	)

	(method (init)
		(super init: poLarryMouth2 voLarryBust2)
		(poLarry2 hide:)
	)

	(method (dispose)
		(poLarry2 show:)
		(super dispose:)
	)
)

(instance poLarryMouth2 of Prop
	(properties
		loop 1
		view 37200
	)

	(method (init)
		(= x (toLarry2 x:))
		(= y (toLarry2 y:))
		(self setPri: 510)
		(super init: &rest)
	)
)

(instance voLarryBust2 of View
	(properties
		view 37200
	)

	(method (init)
		(= x (toLarry2 x:))
		(= y (toLarry2 y:))
		(self setPri: 500)
		(super init: &rest)
	)
)

(instance poLarryEyes2 of Prop
	(properties
		priority 515
		x 264
		y 218
		cycleSpeed 10
		loop 2
		view 37200
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 80)
	)
)

(instance toLarry3 of Talker
	(properties
		x 331
		y 310
	)

	(method (init)
		(super init: poLarryMouth3)
		(poLarry2 hide:)
	)

	(method (dispose)
		(poLarry2 show:)
		(super dispose:)
	)
)

(instance poLarryMouth3 of Prop
	(properties
		loop 2
		view 37300
	)

	(method (init)
		(= x (toLarry3 x:))
		(= y (toLarry3 y:))
		(self setPri: 505)
		(super init: &rest)
	)
)

(instance toLarry4 of Talker
	(properties
		x 0
		y 478
	)

	(method (init)
		(super init: poLarryMouth4)
		(poLarry2Mouth hide:)
	)

	(method (dispose)
		(poLarry2Mouth show:)
		(super dispose:)
	)
)

(instance poLarryMouth4 of Prop
	(properties
		loop 1
		view 37600
	)

	(method (init)
		(= x (toLarry4 x:))
		(= y (toLarry4 y:))
		(self setPri: (poLarry2Mouth priority:))
		(super init: &rest)
	)
)

(instance toLarry5 of Talker
	(properties
		x 0
		y 478
	)

	(method (init)
		(super init: poLarryMouth5)
		(poLarry2Mouth hide:)
	)

	(method (dispose)
		(poLarry2Mouth show:)
		(super dispose:)
	)
)

(instance poLarryMouth5 of Prop
	(properties
		loop 1
		view 37800
	)

	(method (init)
		(= x (toLarry5 x:))
		(= y (toLarry5 y:))
		(self setPri: (poLarry2Mouth priority:))
		(super init: &rest)
	)
)

(instance toDewmi of Talker
	(properties
		x 577
		y 332
	)

	(method (init)
		(super init: poDewmiMouth voDewmiBody)
		(poDewmi hide:)
	)

	(method (dispose)
		(poDewmi show:)
		(super dispose:)
	)
)

(instance poDewmiMouth of Prop
	(properties
		loop 1
		view 37310
	)

	(method (init)
		(= x (toDewmi x:))
		(= y (toDewmi y:))
		(self setPri: (+ (poDewmi priority:) 2))
		(super init: &rest)
	)
)

(instance voDewmiBody of View
	(properties
		view 37310
	)

	(method (init)
		(= x (toDewmi x:))
		(= y (toDewmi y:))
		(self setPri: (+ (poDewmi priority:) 1))
		(super init: &rest)
	)
)

(instance toDewmi2 of Talker
	(properties
		x 391
		y 412
	)

	(method (init)
		(super init: poDewmiMouth2 voDewmiBody2)
		(poDewmi hide:)
	)

	(method (dispose)
		(poDewmi show:)
		(super dispose:)
	)
)

(instance poDewmiMouth2 of Prop
	(properties
		x 391
		y 412
		loop 1
		view 37500
	)

	(method (init)
		(self setPri: (+ (poDewmi priority:) 5))
		(super init: &rest)
	)
)

(instance voDewmiBody2 of View
	(properties
		x 391
		y 412
		view 37500
	)

	(method (init)
		(self setPri: (poDewmi priority:))
		(super init: &rest)
	)
)

(instance toDewmi3 of Talker
	(properties
		x 391
		y 412
	)

	(method (init)
		(super init: poDewmiMouth2)
	)
)

(instance oMessageDone of CueMe
	(properties)

	(method (cue)
		(= local2 1)
	)
)

