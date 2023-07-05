;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use CycleBet)
(use smell)
(use BalloonTalker)
(use ADRoom)
(use Print)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	intro 0
	rev1Talk 2
	rev2Talk 3
	nellieTalk 4
	tattleTalk 5
	pennyTalk 6
	gluttTalk 7
	post1Talk 8
	quibTalk 9
	vicarTalk 10
	percyTalk 14
)

(local
	local0
)

(instance intro of ADRoom
	(properties)

	(method (init)
		(LoadMany rsPIC 100 420)
		(LoadMany rsSOUND 111 112 113 114 115)
		(SetFlag 2)
		(= gNormalCursor 996)
		(gGame setCursor: 996 1 304 172)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 118 240 117 238 68 213 68 221 118 66 116 75 68 33 68 31 118 0 118 0 0 319 0
					yourself:
				)
		)
		(proc875_0)
		(super init: &rest)
		(gTheIconBar disable:)
		(gTheIconBar disable: 5)
		(gUser canInput: 1)
		(Palette palSET_INTENSITY 0 254 0)
		(gCurRoom setScript: sDoClockAnimation)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance sDoClockAnimation of Script
	(properties)

	(method (doit &tmp temp0)
		(if (== state 2)
			(= temp0 (sFXTickTock prevSignal:))
		)
		(cond
			((and (== state 2) (== temp0 10))
				(ticktock cel: 1)
			)
			((and (== state 2) (== temp0 20))
				(ticktock cel: 0)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(and
				(< state 17)
				(OneOf (event type:) evMOUSEBUTTON evKEYBOARD evJOYDOWN)
				(not (event modifiers:))
			)
			(event claimed: 1)
			(ticktock addToPic:)
			(spinningHands addToPic:)
			(sFXTickTock fade:)
			(sFXPeaceful fade:)
			(self changeState: 17)
		)
		(event claimed: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 420 10)
				(LoadMany rsVIEW 103 101 102)
				(LoadMany rsSOUND 111 114 113 112 115)
				(= cycles 1)
			)
			(1
				(sFXPeaceful play:)
				(gCurRoom drawPic: 100 10)
				(ticktock init:)
				(spinningHands init:)
				(= seconds 1)
			)
			(2
				(sFXTickTock play:)
				(= seconds 5)
			)
			(3
				(sFXSpin play:)
				(= cycles 1)
			)
			(4
				(spinningHands setCycle: End self)
			)
			(5
				(curlyHands init:)
				(spinningHands dispose:)
				(= cycles 1)
			)
			(6
				(curlyHands setCycle: End self)
			)
			(7
				(clockface init:)
				(ticktock dispose:)
				(= cycles 1)
			)
			(8
				(sFXSprings play:)
				(sFXSpin stop:)
				(sFXTickTock stop:)
				(sFXPeaceful stop:)
				(= cycles 1)
			)
			(9
				(clockface setCycle: End self)
			)
			(10
				(curlyHands stopUpd:)
				(clockface stopUpd:)
				(= cycles 1)
			)
			(11
				(twisty init: setStep: 1 12)
				(= cycles 1)
			)
			(12
				(twisty setMotion: MoveTo 144 18 self)
			)
			(13
				(sFXDrop play:)
				(twisty setMotion: MoveTo 144 8 self)
			)
			(14
				(twisty setMotion: MoveTo 144 18 self)
			)
			(15
				(twisty setMotion: MoveTo 144 15 self)
			)
			(16
				(= seconds 6)
			)
			(17
				(= cycles 2)
			)
			(18
				(client setScript: sFirstScreenInput)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
	)

	(method (dispose)
		(super dispose:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
	)
)

(instance sFirstScreenInput of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= gNormalCursor 996)
				(gGame setCursor: 999 1 100 100)
				(switch
					(Print
						addText: {What do you feel like doing?}
						font: gUserFont
						addButton: 1 7 0 8 1 0 12 ; "INTRODUCTION"
						addButton: 2 7 0 8 2 0 26 ; "HOW TO PLAY"
						addButton: 3 7 0 8 3 0 40 ; "START GAME"
						addButton: 4 7 0 8 4 0 54 ; "RESTORE A GAME"
						addButton: 5 7 0 8 5 0 68 ; "QUIT"
						init:
					)
					(1
						(LoadMany rsPIC 110 111 112 113)
						(client setScript: sDoIntro)
					)
					(2
						(gCurRoom newRoom: 115)
					)
					(3
						(client setScript: sDoPickAnAct)
					)
					(4
						(= gNormalCursor 999)
						(gGame restore:)
						(-- state)
						(= cycles 2)
					)
					(5
						(= gQuit 1)
					)
					(else
						(client setScript: sDoPickAnAct)
					)
				)
			)
		)
	)
)

(instance sDoIntro of Script
	(properties)

	(method (changeState newState &tmp [temp0 10])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame handsOff:)
				(gGame setCursor: 996 1 100 100)
				((ScriptID 895 0) ; pepper
					view: 800
					loop: 1
					x: 300
					y: 128
					normalize:
					setHeading: 270
					init:
				)
				((ScriptID 895 1) ; lockjaw
					view: 807
					loop: 1
					x: 320
					y: 120
					init:
					normalize:
				)
				(twisty dispose:)
				(spinningHands dispose:)
				(clockface dispose:)
				(curlyHands dispose:)
				(gCurRoom drawPic: 111 6)
				(pennyP init:)
				(postal init:)
				(gLongSong number: 110 flags: 1 loop: -1 play: self)
				(= cycles 1)
			)
			(2
				((ScriptID 895 0) ; pepper
					setMotion: PolyPath 295 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) setMotion: PolyPath 315 ((ScriptID 895 1) y:)) ; lockjaw, lockjaw
			)
			(3
				(= ticks 30)
			)
			(4
				((ScriptID 2000 3) winX: 124 winY: 91 tailPosn: 1) ; PepperTalker
				(gMessager say: 7 0 9 1 self) ; "This is Pepper Pumpernickel and newshound Lockjaw, reporting live for Pepper's Adventures in Time!"
			)
			(5
				(gMessager say: 7 0 9 2 self) ; "Let's talk to a few witnesses, and see if they'll give us a reaction to this bizarre new twist in time and space!"
			)
			(6
				((ScriptID 895 0) setHeading: 315 self) ; pepper
			)
			(7
				(= ticks 30)
			)
			(8
				(gMessager say: 7 0 9 3 self) ; "Hey, Miss Centime, did you know that Mark Seibert is the Producer?"
			)
			(9
				(gMessager say: 7 0 9 4 self) ; "That's nice, Pepper, but I have to go produce breakfast now. See ya!"
			)
			(10
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(pennyP dispose:)
				((ScriptID 895 0) ; pepper
					setMotion: PolyPath 161 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) setMotion: PolyPath 173 ((ScriptID 895 1) y:)) ; lockjaw, lockjaw
			)
			(11
				((ScriptID 895 0) setLoop: 8 cel: 7 heading: 300) ; pepper
				(= ticks 30)
			)
			(12
				(gMessager say: 7 0 9 5 self) ; "Mr. Ennui, did you know the director was the whole Team Tribal Byte?"
			)
			(13
				(postal cel: 0 setCycle: Beg)
				(gMessager say: 7 0 9 6 self) ; "Tribal what? Oh, go away. My life has no direction, and I like it that way."
			)
			(14
				(postal cel: 0 setCycle: Beg)
				((ScriptID 895 0) ; pepper
					normalize:
					setMotion: PolyPath -20 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) setMotion: PolyPath 0 ((ScriptID 895 1) y:)) ; lockjaw, lockjaw
			)
			(15
				(postal dispose:)
				(gCurRoom drawPic: 110 11)
				(percy init: setCycle: Walk setMotion: MoveTo 190 130 self)
				(nellie init: stopUpd:)
				(glutton init: setSpeed: 12 stopUpd:)
				((ScriptID 895 0) ; pepper
					posn: 300 ((ScriptID 895 0) y:) ; pepper
					setMotion: PolyPath 295 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) ; lockjaw
					posn: 320 ((ScriptID 895 1) y:) ; lockjaw
					setMotion: PolyPath 315 ((ScriptID 895 1) y:) self ; lockjaw
				)
			)
			(16 0)
			(17
				0
				((ScriptID 895 0) stopUpd:) ; pepper
				((ScriptID 895 1) stopUpd:) ; lockjaw
			)
			(18
				(percy stopUpd:)
				(= cycles 2)
			)
			(19
				((ScriptID 2000 3) winX: 124 winY: 91 tailPosn: 1) ; PepperTalker
				(gMessager say: 7 0 9 7 self) ; "Good morning, Mr. Chompfodder. Did you know this game is based on an original concept by Bill Davis?"
			)
			(20
				(gMessager say: 7 0 9 8 self) ; "Uh...that's nice...Pepper, could you call off your--"
				(Load rsSOUND 905)
			)
			(21
				((ScriptID 2004 0) winX: 220 winY: 125 tailPosn: 4) ; LockjawTalker
				(gMessager say: 7 0 9 9 self) ; "GRRRRRRRR!"
				(sFXDrop number: 905 play:)
			)
			(22
				((ScriptID 2004 0) winX: 0 winY: 0) ; LockjawTalker
				((ScriptID 895 0) stopUpd:) ; pepper
				((ScriptID 895 1) ; lockjaw
					view: 110
					setLoop: 3
					setStep: 9 6
					setCycle: Walk
					setMotion: MoveTo 237 132 self
				)
			)
			(23
				((ScriptID 895 1) ; lockjaw
					view: 112
					setLoop: 0
					cel: 0
					posn: 229 134
					setCycle: CT 4 1 self
				)
			)
			(24
				((ScriptID 895 1) setCycle: End self) ; lockjaw
				(sFXDrop number: 900 play:)
			)
			(25
				(percy
					view: 110
					loop: 1
					cel: 0
					posn: 190 130
					setCycle: CT 7 1 self
				)
			)
			(26
				(sFXDrop number: 4114 play: self)
				(percy setCycle: End self)
			)
			(27 0)
			(28
				(gMessager say: 7 0 9 10 self) ; "YIKES!"
				((ScriptID 895 1) normalize: 807 1) ; lockjaw
				(percy
					view: 108
					setStep: 24 16
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo -10 130 self
				)
				(sFXDrop number: 953 play:)
			)
			(29 0)
			(30
				(percy dispose:)
				((ScriptID 895 1) stopUpd:) ; lockjaw
				(= cycles 2)
			)
			(31
				(= cycles 1)
			)
			(32
				(glutton view: 105 setLoop: 0)
				(gMessager say: 7 0 9 11 self) ; "Shame on you, Lockjaw!"
			)
			(33
				((ScriptID 895 0) setHeading: 315 self) ; pepper
			)
			(34
				(= ticks 30)
			)
			(35
				(gMessager say: 7 0 9 12 self) ; "Oh, hi, Mrs. Vitriol. I'd like you to know that this game was designed by Gano Haine, Jane Jensen, Josh Mandel, and Lorelei Shannon!"
			)
			(36
				(gMessager say: 7 0 9 13 self) ; "And guess what, Lorelei wrote all the text and dialog!"
			)
			(37
				(nellie view: 105 setLoop: 1 setCycle: End self)
				(gMessager say: 7 0 9 14 self) ; "A conspiracy! I KNEW it!"
			)
			(38 0)
			(39
				(nellie setCycle: Beg self)
			)
			(40
				((ScriptID 895 0) ; pepper
					normalize:
					setMotion: PolyPath 30 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) setMotion: PolyPath 50 ((ScriptID 895 1) y:)) ; lockjaw, lockjaw
			)
			(41
				(= cycles 2)
			)
			(42
				(Face gEgo glutton self)
				(Face (ScriptID 895 1) glutton self) ; lockjaw
			)
			(43
				0
				(glutton view: 105 setLoop: 0 setCycle: Beg)
			)
			(44
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(= ticks 30)
			)
			(45
				(gMessager say: 7 0 9 15 self) ; "Oh, Mr. Spheroid! Guess what, the Lead Artist is Jim Larsen, the Lead Animator is Tony Margioni, and the Lead Programmer is Carlos Escobar!"
			)
			(46
				(glutton setCycle: CT 3 1 self)
			)
			(47
				(glutton setCycle: CT 7 1)
				(sFXDrop number: 902 play: self)
			)
			(48
				(sFXDrop number: 1204 play: self)
				(glutton setCycle: CycleBet 7 10)
			)
			(49
				(glutton setCycle: End self)
				(gMessager say: 7 0 9 16 self) ; "So what? Who's the Lead Chef, huh?"
			)
			(50 0)
			(51
				((ScriptID 895 0) ; pepper
					setMotion: PolyPath -20 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) setMotion: PolyPath 0 ((ScriptID 895 1) y:)) ; lockjaw, lockjaw
			)
			(52
				(percy dispose:)
				(nellie dispose:)
				(glutton dispose:)
				(gCurRoom drawPic: 112 11)
				(tattle init: stopUpd:)
				(willRev init: stopUpd:)
				(nedRev init: stopUpd:)
				(goody init: stopUpd:)
				(= cycles 1)
			)
			(53
				((ScriptID 895 0) ; pepper
					posn: 300 ((ScriptID 895 0) y:) ; pepper
					setMotion: PolyPath 295 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) ; lockjaw
					posn: 320 ((ScriptID 895 1) y:) ; lockjaw
					setMotion: PolyPath 315 ((ScriptID 895 1) y:) ; lockjaw
				)
			)
			(54
				((ScriptID 895 0) setHeading: 315 self) ; pepper
				((ScriptID 895 1) stopUpd:) ; lockjaw
			)
			(55
				(= ticks 30)
			)
			(56
				((ScriptID 895 0) stopUpd:) ; pepper
				(= cycles 1)
			)
			(57
				((ScriptID 2000 3) winX: 124 winY: 91 tailPosn: 1) ; PepperTalker
				(gMessager say: 7 0 9 17 self) ; "Good morning, Miss Gumflapper! Were you aware that Neal Grandstaff did the music for this game?"
			)
			(58
				(gMessager say: 7 0 9 18 self) ; "Musicians! Hmmph! Let me tell you a thing or two about musicians, young lady..."
			)
			(59
				((ScriptID 895 0) ; pepper
					setMotion: PolyPath 170 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) setMotion: PolyPath 192 ((ScriptID 895 1) y:)) ; lockjaw, lockjaw
			)
			(60
				((ScriptID 895 0) setHeading: 180 self) ; pepper
			)
			(61
				(= cycles 2)
			)
			(62
				((ScriptID 895 0) stopUpd:) ; pepper
				((ScriptID 895 1) stopUpd:) ; lockjaw
				(= cycles 2)
			)
			(63
				((ScriptID 2000 3) winX: 15 winY: 97 tailPosn: 1) ; PepperTalker
				(gMessager say: 7 0 9 19 self) ; "Hey, Will and Ned! The artists are Terry Falls, Maria Fruehe, Darlou Gams, Tony Margioni, Jim Larsen, and Al Roughton!"
			)
			(64
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(rev1Talk x: 156 y: 148 tailPosn: 3)
				(gMessager say: 7 0 9 20 self) ; "Oh, wow, they sound cool!"
			)
			(65
				(gMessager say: 7 0 9 21 self) ; "Totally! Do they like to party? Bring 'em over here, dudette!"
			)
			(66
				((ScriptID 895 0) ; pepper
					setMotion: PolyPath 62 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) setMotion: PolyPath 72 ((ScriptID 895 1) y:)) ; lockjaw, lockjaw
			)
			(67
				((ScriptID 895 0) setHeading: 360 self) ; pepper
			)
			(68
				(= ticks 30)
			)
			(69
				(gMessager say: 7 0 9 22 self) ; "Hi, Ms. Maplebar! The programmers are Kim Bowdish, Chris Carr, Hugh Diedrichs, Carlos Escobar, and Thaddeus Pritchard!"
			)
			(70
				(goody setCycle: End self)
				(rev1Talk winX: 72 winY: 64 tailPosn: 3)
				(gMessager say: 7 0 9 23 self) ; "Oh, that's nice, Pepper dear. Why don't you all come by for supper tonight!"
			)
			(71 0)
			(72
				(goody setCycle: Beg)
				((ScriptID 895 0) ; pepper
					setMotion: PolyPath -20 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) setMotion: PolyPath 0 ((ScriptID 895 1) y:)) ; lockjaw, lockjaw
			)
			(73
				(tattle dispose:)
				(willRev dispose:)
				(nedRev dispose:)
				(goody dispose:)
				(gCurRoom drawPic: 113 11)
				(vicar init: stopUpd:)
				(quibble init: stopUpd:)
				(= cycles 1)
			)
			(74
				((ScriptID 895 0) ; pepper
					posn: 300 ((ScriptID 895 0) y:) ; pepper
					setMotion: PolyPath 295 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) ; lockjaw
					posn: 320 ((ScriptID 895 1) y:) ; lockjaw
					setMotion: PolyPath 315 ((ScriptID 895 1) y:) ; lockjaw
				)
			)
			(75
				(= cycles 2)
			)
			(76
				(vicar setCycle: Fwd)
				(gMessager say: 7 0 9 24 self) ; "Am not!"
			)
			(77
				(vicar setCycle: 0 cel: 2)
				(quibble setCycle: Fwd)
				(gMessager say: 7 0 9 25 self) ; "Are too!"
			)
			(78
				(quibble setCycle: 0 cel: 9)
				(vicar setCycle: Fwd)
				(gMessager say: 7 0 9 26 self) ; "Am not!"
			)
			(79
				(vicar setCycle: 0 cel: 2)
				(quibble setCycle: Fwd)
				(gMessager say: 7 0 9 27 self) ; "Are too!"
			)
			(80
				(quibble setCycle: 0 cel: 9)
				((ScriptID 2000 3) winX: 124 winY: 91 tailPosn: 1) ; PepperTalker
				(gMessager say: 7 0 9 28 self) ; "Uh, hi, Mr. and Mrs. Crankee. Were you aware that Dan Woolard is the Senior QA Analyst?"
			)
			(81
				(quibble setCycle: Fwd)
				(gMessager say: 7 0 9 29 self) ; "Oh, yeah? Can he assure me a better quality husband than this one?"
			)
			(82
				(quibble setCycle: 0 cel: 9)
				(vicar setCycle: Fwd)
				(gMessager say: 7 0 9 30 self) ; "HEY!"
			)
			(83
				(vicar setCycle: 0 cel: 2)
				((ScriptID 895 0) ; pepper
					setMotion: PolyPath 170 ((ScriptID 895 0) y:) self ; pepper
				)
				((ScriptID 895 1) setMotion: PolyPath 192 ((ScriptID 895 1) y:)) ; lockjaw, lockjaw
			)
			(84
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(gMessager say: 7 0 9 31 self) ; "Well, I'll see you all later! C'mon, Lockjaw!"
			)
			(85
				(vicar dispose:)
				(quibble dispose:)
				(gCurRoom drawPic: 99)
				(= cycles 1)
			)
			(86
				(client setScript: sDoPickAnAct)
			)
		)
	)
)

(instance sDoPickAnAct of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame setCursor: 999 1 100 100)
				(= register 120)
				(switch
					(Print
						addText: {Where to?}
						font: gUserFont
						addButton: 1 7 0 7 1 0 12 ; "ACT I: TIME TRAVEL"
						addButton: 2 7 0 7 2 0 26 ; "ACT II: PHILADELPHIA"
						addButton: 3 7 0 7 3 0 40 ; "ACT III: KITE/KEY EXPERIMENT"
						addButton: 4 7 0 7 4 0 54 ; "ACT IV: STAMP ACT"
						addButton: 5 7 0 7 5 0 68 ; "ACT V: CONSTITUTIONAL CONVENTION"
						addButton: 6 7 0 7 6 0 91 ; "ACT VI: RESCUE LOCKJAW"
						init:
					)
					(1
						(= register 120)
						(= gAct 1)
						(gCurRoom newRoom: 601)
					)
					(2
						(= register 210)
						(= gAct 2)
						(gEgo get: 4) ; Pebbles
						(SetFlag 32)
						(SetFlag 10)
						(SetFlag 11)
						(gCurRoom setScript: sDoActChange)
					)
					(3
						(= register 330)
						(= gAct 3)
						(gEgo get: 9 get: 4) ; Package, Pebbles
						((ScriptID 895 1) get: 7) ; lockjaw, Ima_s_Room_Key
						(SetFlag 32)
						(SetFlag 10)
						(SetFlag 11)
						(SetFlag 12)
						(SetFlag 7)
						(SetFlag 30)
						(SetFlag 33)
						(SetFlag 48)
						(SetFlag 8)
						(SetFlag 53)
						(SetFlag 141)
						(SetFlag 85)
						(SetFlag 97)
						(SetFlag 285)
						((gInventory at: 9) cel: 2 noun: 5 message: 37) ; Package
						(ClearFlag 140)
						(SetFlag 8)
						(gCurRoom setScript: sDoActChange)
					)
					(4
						(= register 330)
						(= gAct 4)
						(SetFlag 26)
						(SetFlag 25)
						(SetFlag 48)
						(SetFlag 24)
						(SetFlag 40)
						(SetFlag 46)
						(SetFlag 32)
						(SetFlag 28)
						(SetFlag 29)
						(SetFlag 10)
						(SetFlag 11)
						(SetFlag 19)
						(SetFlag 20)
						(SetFlag 7)
						(SetFlag 22)
						(SetFlag 21)
						(SetFlag 34)
						(SetFlag 147)
						(SetFlag 51)
						(SetFlag 27)
						(SetFlag 31)
						(SetFlag 62)
						(SetFlag 12)
						(SetFlag 30)
						(SetFlag 33)
						(SetFlag 34)
						(SetFlag 9)
						(SetFlag 70)
						(SetFlag 16)
						(SetFlag 17)
						(SetFlag 18)
						(SetFlag 23)
						(SetFlag 35)
						(SetFlag 36)
						(SetFlag 37)
						(SetFlag 38)
						(SetFlag 39)
						(SetFlag 69)
						(SetFlag 8)
						(SetFlag 49)
						(SetFlag 53)
						(SetFlag 141)
						(SetFlag 85)
						(SetFlag 144)
						(SetFlag 295)
						(SetFlag 97)
						(SetFlag 217)
						(SetFlag 229)
						(SetFlag 287)
						(SetFlag 275)
						(SetFlag 274)
						(SetFlag 262)
						(SetFlag 263)
						(SetFlag 264)
						(SetFlag 283)
						(SetFlag 403)
						(SetFlag 285)
						(SetFlag 301)
						(SetFlag 91)
						(gEgo get: 18 get: 4 get: 33 get: 10 get: 14) ; Glass_Jar, Pebbles, Magnet, Doctrine, Ordinary_String
						(gCurRoom setScript: sDoActChange)
					)
					(5
						(= register 320)
						(= gAct 5)
						(SetFlag 163)
						(SetFlag 78)
						(SetFlag 156)
						(SetFlag 162)
						(SetFlag 152)
						(SetFlag 158)
						(SetFlag 26)
						(SetFlag 25)
						(SetFlag 48)
						(SetFlag 24)
						(SetFlag 40)
						(SetFlag 46)
						(SetFlag 70)
						(SetFlag 32)
						(SetFlag 29)
						(SetFlag 10)
						(SetFlag 11)
						(ClearFlag 12)
						(SetFlag 19)
						(SetFlag 20)
						(SetFlag 7)
						(SetFlag 22)
						(SetFlag 21)
						(SetFlag 34)
						(SetFlag 147)
						(SetFlag 51)
						(SetFlag 27)
						(SetFlag 53)
						(SetFlag 62)
						(SetFlag 12)
						(SetFlag 30)
						(SetFlag 33)
						(SetFlag 34)
						(SetFlag 9)
						(SetFlag 16)
						(SetFlag 17)
						(SetFlag 18)
						(SetFlag 23)
						(SetFlag 35)
						(SetFlag 36)
						(SetFlag 37)
						(SetFlag 38)
						(SetFlag 39)
						(SetFlag 69)
						(SetFlag 41)
						(SetFlag 43)
						(SetFlag 45)
						(SetFlag 47)
						(SetFlag 50)
						(SetFlag 53)
						(SetFlag 8)
						(SetFlag 49)
						(SetFlag 85)
						(SetFlag 141)
						(SetFlag 144)
						(SetFlag 295)
						(SetFlag 97)
						(SetFlag 217)
						(SetFlag 229)
						(SetFlag 287)
						(SetFlag 275)
						(SetFlag 274)
						(SetFlag 262)
						(SetFlag 263)
						(SetFlag 264)
						(SetFlag 283)
						(SetFlag 403)
						(SetFlag 247)
						(SetFlag 285)
						(SetFlag 301)
						(SetFlag 91)
						(gEgo
							get: 28 ; King_s_Letter
							get: 18 ; Glass_Jar
							get: 4 ; Pebbles
							get: 10 ; Doctrine
							get: 33 ; Magnet
							get: 23 ; Back_Scratcher
							get: 25 ; Paddles
						)
						((ScriptID 895 1) get: 7 put: 7 410) ; lockjaw, Ima_s_Room_Key, Ima_s_Room_Key
						(gCurRoom setScript: sDoActChange)
					)
					(6
						(= register 320)
						(= gAct 6)
						(SetFlag 163)
						(SetFlag 78)
						(SetFlag 156)
						(SetFlag 162)
						(SetFlag 152)
						(SetFlag 158)
						(SetFlag 26)
						(SetFlag 25)
						(SetFlag 48)
						(SetFlag 24)
						(SetFlag 40)
						(SetFlag 46)
						(SetFlag 32)
						(SetFlag 29)
						(SetFlag 10)
						(SetFlag 11)
						(ClearFlag 12)
						(SetFlag 19)
						(SetFlag 20)
						(SetFlag 7)
						(SetFlag 70)
						(SetFlag 22)
						(SetFlag 21)
						(SetFlag 34)
						(SetFlag 147)
						(SetFlag 51)
						(SetFlag 27)
						(SetFlag 53)
						(SetFlag 62)
						(SetFlag 58)
						(SetFlag 12)
						(SetFlag 7)
						(SetFlag 30)
						(SetFlag 33)
						(SetFlag 34)
						(SetFlag 9)
						(SetFlag 16)
						(SetFlag 17)
						(SetFlag 18)
						(SetFlag 23)
						(SetFlag 35)
						(SetFlag 36)
						(SetFlag 37)
						(SetFlag 38)
						(SetFlag 39)
						(SetFlag 69)
						(SetFlag 41)
						(SetFlag 43)
						(SetFlag 44)
						(SetFlag 45)
						(SetFlag 47)
						(SetFlag 50)
						(SetFlag 53)
						(SetFlag 52)
						(SetFlag 55)
						(SetFlag 56)
						(SetFlag 58)
						(SetFlag 59)
						(SetFlag 61)
						(SetFlag 65)
						(SetFlag 66)
						(SetFlag 67)
						(SetFlag 8)
						(SetFlag 49)
						(SetFlag 144)
						(SetFlag 141)
						(SetFlag 85)
						(SetFlag 53)
						(SetFlag 295)
						(SetFlag 97)
						(SetFlag 217)
						(SetFlag 229)
						(SetFlag 287)
						(SetFlag 275)
						(SetFlag 274)
						(SetFlag 262)
						(SetFlag 263)
						(SetFlag 264)
						(SetFlag 283)
						(SetFlag 265)
						(SetFlag 441)
						(SetFlag 266)
						(SetFlag 441)
						(SetFlag 276)
						(SetFlag 277)
						(SetFlag 267)
						(SetFlag 284)
						(SetFlag 219)
						(SetFlag 403)
						(SetFlag 285)
						(SetFlag 247)
						(SetFlag 311)
						(SetFlag 301)
						(SetFlag 91)
						(gEgo
							get: 35 ; Chocolate
							get: 4 ; Pebbles
							get: 10 ; Doctrine
							get: 33 ; Magnet
							get: 18 ; Glass_Jar
							get: 23 ; Back_Scratcher
							get: 25 ; Paddles
						)
						(gCurRoom setScript: sDoActChange)
					)
					(else
						(client setScript: sFirstScreenInput)
					)
				)
			)
		)
	)
)

(instance sDoActChange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 996 1 100 100)
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 601)
			)
		)
	)
)

(instance spinningHands of Prop
	(properties
		x 153
		y 147
		view 102
		priority 15
		signal 16
	)
)

(instance clockface of Prop
	(properties
		x 158
		y 184
		view 101
		loop 1
		priority 11
		signal 16
	)
)

(instance ticktock of Prop
	(properties
		x 157
		y 184
		view 102
		loop 1
		priority 14
		signal 16400
	)
)

(instance curlyHands of Prop
	(properties
		x 154
		y 148
		view 101
		priority 15
		signal 16
	)
)

(instance twisty of Actor
	(properties
		x 144
		y -50
		view 103
		signal 8192
	)
)

(instance sFXPeaceful of Sound
	(properties
		flags 1
		number 111
		loop -1
	)
)

(instance sFXTickTock of Sound
	(properties
		flags 1
		number 112
		loop -1
	)
)

(instance sFXSpin of Sound
	(properties
		flags 1
		number 113
	)
)

(instance sFXSprings of Sound
	(properties
		flags 1
		number 114
	)
)

(instance sFXDrop of Sound
	(properties
		flags 1
		number 115
	)
)

(instance pennyP of Actor
	(properties
		x 170
		y 46
		view 107
		loop 1
	)
)

(instance postal of Actor
	(properties
		x 123
		y 99
		view 107
		priority 8
		signal 16
	)
)

(instance percy of Actor
	(properties
		x 75
		y 128
		view 110
		loop 1
		signal 16384
	)
)

(instance glutton of Actor
	(properties
		x 72
		y 77
		view 110
		loop 4
	)
)

(instance nellie of Actor
	(properties
		x 223
		y 75
		view 110
		loop 5
	)
)

(instance tattle of Actor
	(properties
		x 179
		y 55
		view 106
		loop 3
	)
)

(instance willRev of Actor
	(properties
		x 113
		y 167
		view 106
		loop 2
	)
)

(instance nedRev of Actor
	(properties
		x 162
		y 169
		view 106
		loop 1
	)
)

(instance goody of Actor
	(properties
		x 65
		y 80
		view 106
	)
)

(instance quibble of Actor
	(properties
		x 142
		y 116
		view 104
		loop 1
	)
)

(instance vicar of Actor
	(properties
		x 171
		y 115
		view 104
		loop 2
	)
)

(instance rev1Talk of BalloonTalker
	(properties
		x 174
		y 118
		talkWidth 120
	)
)

(instance rev2Talk of BalloonTalker
	(properties
		x 129
		y 120
		talkWidth 150
	)
)

(instance nellieTalk of BalloonTalker
	(properties
		x 60
		y 59
		talkWidth 150
		tailPosn 4
	)
)

(instance tattleTalk of BalloonTalker
	(properties
		x 6
		y 59
		talkWidth 150
		tailPosn 4
	)
)

(instance pennyTalk of BalloonTalker
	(properties
		x 27
		y 52
		talkWidth 120
		tailPosn 4
	)
)

(instance gluttTalk of BalloonTalker
	(properties
		x 76
		y 53
		talkWidth 150
		tailPosn 3
	)
)

(instance post1Talk of BalloonTalker
	(properties
		x 124
		y 56
		talkWidth 180
	)
)

(instance quibTalk of BalloonTalker
	(properties
		x 6
		y 66
		talkWidth 120
		tailPosn 1
	)
)

(instance vicarTalk of BalloonTalker
	(properties
		x 169
		y 67
		talkWidth 100
	)
)

(instance percyTalk of BalloonTalker
	(properties
		x 192
		y 79
		talkWidth 100
	)
)

