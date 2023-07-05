;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)
(use CycleBet)
(use ADRoom)
(use Print)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm115 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(theWalkIcon init: stopUpd:)
	(theLookIcon init: stopUpd:)
	(theHandIcon init: stopUpd:)
	(theTalkIcon init: stopUpd:)
	(theInvIcon init: stopUpd:)
	(theCurInvIcon init: stopUpd:)
	(theControlIcon init: stopUpd:)
	(qMarkIcon init: stopUpd:)
	(truthIcon init: stopUpd:)
	(quizIcon init: stopUpd:)
)

(procedure (localproc_1)
	(theWalkIcon dispose:)
	(theLookIcon dispose:)
	(theTalkIcon dispose:)
	(theHandIcon dispose:)
	(theInvIcon dispose:)
	(theCurInvIcon dispose:)
	(theControlIcon dispose:)
	(qMarkIcon dispose:)
	(truthIcon dispose:)
	(quizIcon dispose:)
)

(procedure (localproc_2)
	(theInvWindow init: stopUpd:)
	(invEye init: stopUpd:)
	(invHand init: stopUpd:)
	(invArrow init: stopUpd:)
	(invTalk init: stopUpd:)
	(invUp init: stopUpd:)
	(invDown init: stopUpd:)
	(invOk init: stopUpd:)
)

(procedure (localproc_3)
	(theInvWindow dispose:)
	(invEye dispose:)
	(invHand dispose:)
	(invArrow dispose:)
	(invTalk dispose:)
	(invUp dispose:)
	(invDown dispose:)
	(invOk dispose:)
)

(instance rm115 of ADRoom
	(properties
		picture 120
		vanishingY 20
		autoLoad 1
	)

	(method (cue)
		(gLongSong number: 121 setLoop: -1 play:)
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 122 125 155 125 181 141 181 150 139 160 111 160 85 150 85 142
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 319 189 319 163 263 163 263 151 319 151 319 132 249 132 249 99 203 99 196 103 196 132 181 132 181 139 154 123 115 123 115 126 64 126 64 117 44 110 0 115 0 189
					yourself:
				)
		)
		(gLongSong number: 120 flags: 1 setLoop: 1 play: self)
		((ScriptID 895 0) ; pepper
			init:
			x: 154
			y: 167
			view: 115
			setCycle: 0
			setLoop: 0
			cel: 0
			signal: 16384
		)
		((ScriptID 895 1) ; lockjaw
			init:
			x: 123
			y: 171
			view: 115
			setCycle: 0
			setLoop: 1
			cel: 0
			signal: 16384
			stopUpd:
		)
		(hardGum init: stopUpd:)
		(drainPipe init:)
		(ourCursor init: illegalBits: 0 ignoreActors: 1 ignoreHorizon: 1)
		(gGame handsOff: setCursor: 996 1)
		(ClearFlag 6)
		(ClearFlag 3)
		(ClearFlag 4)
		(ClearFlag 54)
		(self setScript: helpScript 0 1)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if
			(and
				(not gModelessDialog)
				(not (event modifiers:))
				(& (event type:) evMOUSEKEYBOARD)
				(not (event claimed:))
			)
			(event claimed: 1)
			(restartCode doit:)
		)
	)

	(method (dispose)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance restartCode of Code
	(properties)

	(method (doit &tmp temp0)
		(ourCursor hide:)
		(Animate (gCast elements:) 0)
		(gGame setCursor: 999 1 85 130)
		(if
			(= temp0
				(Print
					posn: 70 70
					font: 4
					addText: 1 0 18 1 0 0 ; "Had enough help? Okay, let's play!"
					addButton: 1 1 0 2 0 0 20 ; "YES"
					addButton: 0 1 0 3 0 0 38 ; "NO"
					init:
				)
			)
			(gGame setCursor: gWaitCursor 1)
			(gMouseDownHandler delete: gCurRoom)
			(gKeyDownHandler delete: gCurRoom)
			(gCurRoom newRoom: gPrevRoomNum)
		else
			(ourCursor show:)
			(gGame setCursor: 996 1)
		)
	)
)

(instance helpCode of Code
	(properties)

	(method (doit &tmp temp0)
		(ourCursor hide:)
		(Animate (gCast elements:) 0)
		(gGame setCursor: 999 1 85 130)
		(if
			(= temp0
				(Print
					posn: 70 70
					font: 4
					addText: 1 0 18 local0 0 0
					addButton: 1 1 0 2 0 0 20 ; "YES"
					addButton: 0 1 0 3 0 0 38 ; "NO"
					init:
				)
			)
			(gGame setCursor: 996 1)
			(ourCursor show:)
			(helpScript cue:)
		else
			(gGame setCursor: gWaitCursor 1)
			(if local1
				(SetFlag 6)
			)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)
)

(instance helpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 2001)
				(= ticks 60)
			)
			(1
				(gTheIconBar disable:)
				((ScriptID 2000 3) talkLoop: 2) ; PepperTalker
				((ScriptID 2004 0) winX: 25 winY: 150 tailPosn: 1 talkWidth: 80) ; LockjawTalker
				(gMessager say: 1 0 1 0 self) ; "Hi! I'm Pepper Pumpernickel and this is my dog, Lockjaw. You're going to be playing Pepper's Adventures with us!"
			)
			(2
				((ScriptID 895 1) ; lockjaw
					normalize:
					heading: 180
					loop: 8
					cel: 2
					normal: 1
				)
				(ourCursor setMotion: MoveTo 21 17 self)
			)
			(3
				(localproc_0)
				(= cycles 2)
			)
			(4
				(theWalkIcon setCel: 1)
				(= seconds 2)
			)
			(5
				(gMessager say: 1 0 4 0 self) ; "This is my Walk icon. Just click this wherever you want me to go."
			)
			(6
				(theWalkIcon setCel: 0)
				(ourCursor setMotion: MoveTo 52 17 self)
			)
			(7
				(theLookIcon setCel: 1)
				(= seconds 2)
			)
			(8
				(gMessager say: 1 0 5 0 self) ; "This is my Look icon. Click this on anything or anyone you want me to look at."
			)
			(9
				(theLookIcon setCel: 0)
				(ourCursor setMotion: MoveTo 82 17 self)
			)
			(10
				(theHandIcon setCel: 1)
				(= seconds 2)
			)
			(11
				(gMessager say: 1 0 6 0 self) ; "This is my Hand icon. Click this on objects to take them. You can also use this icon to do things--grab people, move things, stuff like that."
			)
			(12
				(theHandIcon setCel: 0)
				(ourCursor setMotion: MoveTo 114 17 self)
			)
			(13
				(theTalkIcon setCel: 1)
				(= seconds 2)
			)
			(14
				(gMessager say: 1 0 7 0 self) ; "This is my Talk icon. Click this on any person or thing you want to talk to."
			)
			(15
				(theTalkIcon setCel: 0)
				(ourCursor setMotion: MoveTo 144 17 self)
			)
			(16
				(theInvIcon setCel: 1)
				(= seconds 2)
			)
			(17
				(gMessager say: 1 0 8 0 self) ; "This backpack holds my inventory. Click on this icon to see what I'm carrying. Once you're in, you can look at and touch the items."
			)
			(18
				(theInvIcon setCel: 0)
				(ourCursor setMotion: MoveTo 175 17 self)
			)
			(19
				(gMessager say: 1 0 9 0 self) ; "This box displays the inventory item you've selected. If you don't have one selected, there won't be anything in here."
			)
			(20
				(ourCursor setMotion: MoveTo 208 17 self)
			)
			(21
				(theControlIcon setCel: 1)
				(= seconds 2)
			)
			(22
				(gMessager say: 1 0 10 0 self) ; "If you pick this icon, you'll bring up the Game Control Panel."
			)
			(23
				(theControlIcon setCel: 0)
				(ourCursor setMotion: MoveTo 237 17 self)
			)
			(24
				(qMarkIcon setCel: 1)
				(= seconds 2)
			)
			(25
				(gMessager say: 1 0 11 0 self) ; "This is the Help icon. If you select this icon, you can run it over the other icons in the bar to find out what they do."
			)
			(26
				(qMarkIcon setCel: 0)
				(ourCursor setMotion: MoveTo 266 17 self)
			)
			(27
				(truthIcon setCel: 1)
				(= seconds 2)
			)
			(28
				(gMessager say: 1 0 12 0 self) ; "This is the Truth Detector. If you click it on almost anything on the screen, you'll find out if it's really supposed to be here or not."
			)
			(29
				(truthIcon setCel: 0)
				(ourCursor setMotion: MoveTo 300 17 self)
			)
			(30
				(quizIcon setCel: 1)
				(= seconds 2)
			)
			(31
				(gMessager say: 1 0 13 0 self) ; "This is the Quiz icon. At the start of each act, you'll be given five things to look for; the answers to the quiz at the END of the act."
			)
			(32
				(quizIcon setCel: 0)
				(= seconds 1)
			)
			(33
				(ourCursor setMotion: MoveTo 21 17 self)
			)
			(34
				(= seconds 2)
			)
			(35
				(theWalkIcon setCel: 1)
				(= seconds 2)
			)
			(36
				(theWalkIcon setCel: 0)
				(ourCursor view: 903 setCel: 0)
				(= cycles 15)
			)
			(37
				(localproc_1)
				(ourCursor setMotion: MoveTo 118 90 self)
			)
			(38
				(gMessager say: 1 0 14 0 self) ; "Okay, let's look at Lockjaw's icon bar. The first two icons are the same as mine--Walk and Look."
			)
			(39
				(ourCursor view: 999 setMotion: MoveTo 23 21 self)
			)
			(40
				(lWalkIcon init: setPri: 14 stopUpd:)
				(lLookIcon init: setPri: 14 stopUpd:)
				(lPawIcon init: setPri: 14 stopUpd:)
				(lSniffIcon init: setPri: 14 stopUpd:)
				(lBiteIcon init: setPri: 14 stopUpd:)
				(lInvIcon init: setPri: 14 stopUpd:)
				(lCurInvIcon init: setPri: 14 stopUpd:)
				(lCtrlIcon init: setPri: 14 stopUpd:)
				(lQMarkIcon init: setPri: 14 stopUpd:)
				(lTrivIcon init: setPri: 14 stopUpd:)
				(lQuizIcon init: setPri: 14 stopUpd:)
				(= cycles 2)
			)
			(41
				(lWalkIcon setCel: 1)
				(= seconds 3)
			)
			(42
				(lWalkIcon setCel: 0)
				(ourCursor setMotion: MoveTo 52 21 self)
			)
			(43
				(lLookIcon setCel: 1)
				(= seconds 2)
			)
			(44
				(lLookIcon setCel: 0)
				(ourCursor setMotion: MoveTo 75 21 self)
			)
			(45
				(lPawIcon setCel: 1)
				(= seconds 2)
			)
			(46
				(gMessager say: 1 0 15 0 self) ; "The next icon is Lockjaw's Paw. You can click this icon on people and objects to jump, dig, and paw on things."
			)
			(47
				(lPawIcon setCel: 0)
				(ourCursor setMotion: MoveTo 100 21 self)
			)
			(48
				(lSniffIcon setCel: 1)
				(= seconds 2)
			)
			(49
				(gMessager say: 1 0 16 0 self) ; "The next one is Lockjaw's Nose icon. Click this icon on anything you want to smell."
			)
			(50
				(lSniffIcon setCel: 0)
				(ourCursor setMotion: MoveTo 127 21 self)
			)
			(51
				(lBiteIcon setCel: 1)
				(= seconds 2)
			)
			(52
				((ScriptID 2004 0) winX: 25 winY: 150 tailPosn: 1 talkWidth: 80) ; LockjawTalker
				(gMessager say: 1 0 17 0 self) ; "This is Lockjaw's favorite icon; his Teeth. Use this icon to eat, drink, pick up objects, and bite people."
			)
			(53
				(lWalkIcon dispose:)
				(lLookIcon dispose:)
				(lPawIcon dispose:)
				(lSniffIcon dispose:)
				(lBiteIcon dispose:)
				(lCurInvIcon dispose:)
				(lInvIcon dispose:)
				(lCtrlIcon dispose:)
				(lQMarkIcon dispose:)
				(lTrivIcon dispose:)
				(lQuizIcon dispose:)
				(ourCursor setMotion: MoveTo 214 164 self)
			)
			(54
				(ourCursor hide:)
				(= seconds 2)
			)
			(55
				(Load rsMESSAGE 121)
				(= local0 2)
				(helpCode doit:)
			)
			(56
				((ScriptID 2000 3) talkWidth: 140) ; PepperTalker
				(gMessager say: 1 7 4 0 self 121) ; "When you play, you need to look at everything, and pick up everything you find. How about that old, hard gob of bubblegum?"
			)
			(57
				(ourCursor show:)
				(self setScript: gotAnyGum self)
			)
			(58
				(gMessager say: 1 7 5 0 self 121) ; "Hmm, this gum is too hard to stick to anything. We need to soften it up. Hey, don't look at ME! Let's give it to Lockjaw."
			)
			(59
				(ourCursor hide:)
				(= seconds 2)
			)
			(60
				(ourCursor show:)
				(self setScript: inventoryScript self)
			)
			(61
				(ourCursor view: 999 setMotion: MoveTo 50 50 self)
			)
			(62
				((ScriptID 895 1) ; lockjaw
					normalize:
					normal: 0
					loop: 8
					cel: 2
					setScript: 0
				)
				(self setScript: lockjawChewGumScr self)
			)
			(63
				(ourCursor setMotion: MoveTo 30 50)
				((ScriptID 895 0) setMotion: PolyPath 250 150 self) ; pepper
			)
			(64
				((ScriptID 895 0) ; pepper
					view: 839
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(65
				(softGum dispose:)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(66
				((ScriptID 895 0) normalize: setHeading: 180 self) ; pepper
			)
			(67
				(= cycles 2)
			)
			(68
				(gMessager say: 1 7 7 0 self 121) ; "Great! Now we have a useful piece of gooey gum, just perfect for gluing things together. That wasn't so hard, was it?"
			)
			(69
				(ourCursor hide:)
				(gMessager say: 1 7 8 0 self 121) ; "Would you like some help on the second puzzle?"
			)
			(70
				(= local0 3)
				(= local1 1)
				(helpCode doit:)
			)
			(71
				(self setScript: connectPipe self)
			)
			(72
				((ScriptID 895 0) setHeading: 180 self) ; pepper
			)
			(73
				(= cycles 2)
			)
			(74
				(gMessager say: 1 7 14 0 self 121) ; "That's it! The second puzzle! You get the idea. Would you like some help with the third puzzle?"
			)
			(75
				(helpCode doit:)
			)
			(76
				(gMessager say: 1 7 15 0 self 121) ; "Well..."
			)
			(77
				(SetFlag 3)
				(SetFlag 4)
				(SetFlag 6)
				(gGame setCursor: gWaitCursor 1)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance inventoryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ourCursor setMotion: MoveTo 144 17 self)
			)
			(1
				(localproc_0)
				(theInvIcon setCel: 1)
				(= seconds 2)
			)
			(2
				(theInvIcon setCel: 0)
				(ourCursor view: 999)
				(= cycles 15)
			)
			(3
				(localproc_1)
				(= cycles 2)
			)
			(4
				(localproc_2)
				(hardGum
					view: 907
					loop: 0
					cel: 3
					x: 51
					y: 80
					init:
					setPri: 15
					stopUpd:
				)
				(= cycles 2)
			)
			(5
				(ourCursor setMotion: MoveTo 68 89 self)
			)
			(6
				(hardGum dispose:)
				(ourCursor view: 909 setLoop: 0 setCel: 3)
				(= cycles 7)
			)
			(7
				(ourCursor setMotion: MoveTo 240 56 self)
			)
			(8
				(localproc_3)
				(ourCursor setMotion: MoveTo 129 165 self)
			)
			(9
				(= seconds 2)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance connectPipe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 7 11 0 self 121) ; "Now all we have to do is find something to fix with this gum. How about the broken drainpipe? Let's pick up the broken piece of pipe."
			)
			(1
				(ourCursor
					view: 903
					setLoop: 0
					setCel: 2
					setMotion: MoveTo 97 119 self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				((ScriptID 895 0) setPri: -1 setMotion: PolyPath 82 134 self) ; pepper
				(ourCursor setMotion: MoveTo 50 50)
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 839
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(drainPipe dispose:)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(6
				((ScriptID 895 0) view: 115 setCycle: 0 setLoop: 0) ; pepper
				(= seconds 2)
			)
			(7
				(gMessager say: 1 7 12 0 self 121) ; "Like we mentioned earlier, one way of solving puzzles is to use inventory items on each other."
			)
			(8
				(ourCursor setMotion: MoveTo 144 17 self)
			)
			(9
				(localproc_0)
				(ourCursor view: 999)
				(theInvIcon setCel: 1)
				(= seconds 2)
			)
			(10
				(localproc_1)
				(localproc_2)
				(invPipe init: setPri: 15)
				(hardGum view: 907 loop: 0 cel: 4 x: 54 y: 73 setPri: 15 init:)
				(ourCursor setMotion: MoveTo 68 82 self)
			)
			(11
				(= seconds 2)
			)
			(12
				(ourCursor
					view: 907
					loop: 0
					cel: 4
					setMotion: MoveTo 88 75 self
				)
			)
			(13
				(= seconds 2)
			)
			(14
				(invPipe dispose:)
				(hardGum view: 907 loop: 0 cel: 2)
				(ourCursor view: 999)
				(= seconds 2)
			)
			(15
				(ourCursor setMotion: MoveTo 68 82 self)
			)
			(16
				(= seconds 2)
			)
			(17
				(ourCursor
					view: 907
					setLoop: 0
					setCel: 2
					setMotion: MoveTo 230 41 self
				)
				(gGame points: 197 2)
			)
			(18
				(hardGum dispose:)
				(localproc_3)
				(gMessager say: 1 7 13 0 self 121) ; "Great!  Now we have the broken piece of pipe with the gum stuck to it. All we have to do is use it on the rest of the drainpipe!"
			)
			(19
				(ourCursor setMotion: MoveTo 67 72 self)
			)
			(20
				(ourCursor dispose:)
				(self setScript: installPipe self)
			)
			(21
				(self dispose:)
			)
		)
	)
)

(instance installPipe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 1207 loop: 1 play:)
				((ScriptID 895 0) ; pepper
					view: 800
					setLoop: -1
					setCycle: Walk
					setMotion: PolyPath 83 79 self
				)
			)
			(1
				(gEgo
					view: 122
					x: 83
					y: 79
					setLoop: 0
					cel: 7
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(2
				(gGame points: 198 3)
				(gLongSong2 loop: -1)
				(drainPipe
					view: 120
					loop: 0
					cel: 2
					init:
					cel: 3
					x: 88
					y: 67
					setPri: 5
					stopUpd:
				)
				(gEgo
					setLoop: 0
					cel: 1
					posn: 66 113
					normalize: 800 (gEgo loop:)
				)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance gotAnyGum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ourCursor setMotion: MoveTo 82 17 self)
			)
			(1
				(localproc_0)
				(= seconds 2)
			)
			(2
				(theHandIcon setCel: 1)
				(= seconds 2)
			)
			(3
				(localproc_1)
				(ourCursor
					view: 903
					setLoop: 0
					setCel: 2
					setMotion: MoveTo 215 145 self
				)
			)
			(4
				(= seconds 2)
			)
			(5
				(ourCursor setMotion: MoveTo 30 50)
				(gEgo
					view: 800
					normalize:
					loop: 8
					cel: 2
					setCycle: Walk
					setMotion: PolyPath 217 141 self
				)
			)
			(6
				((ScriptID 895 0) ; pepper
					view: 121
					x: 224
					y: 147
					setLoop: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(7
				(gGame points: 195 1)
				(SetFlag 54)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(8
				(hardGum dispose:)
				(= cycles 1)
			)
			(9
				((ScriptID 895 0) setLoop: 1 setCycle: End self) ; pepper
			)
			(10
				((ScriptID 895 0) view: 115 setLoop: 0 cel: 0 setCycle: 0) ; pepper
				(= cycles 2)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance lockjawChewGumScr of Script
	(properties)

	(method (dispose)
		((ScriptID 895 1) normal: 1) ; lockjaw
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= local3 ((ScriptID 895 1) cycleSpeed:)) ; lockjaw
				(SetFlag 6)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					normalize:
					setCycle: Walk
					setLoop: -1
					setMotion: PolyPath 228 155 self
				)
			)
			(2
				((ScriptID 895 0) setHeading: 225 self) ; pepper
				((ScriptID 895 1) ; lockjaw
					normal: 0
					normalize:
					ignoreActors: 1
					setMotion: PolyPath 207 154 self
				)
				(gGame points: 196 1)
			)
			(3
				((ScriptID 895 0) normalize:) ; pepper
			)
			(4
				((ScriptID 895 1) setLoop: 8 cel: 4 setCycle: 0 forceUpd:) ; lockjaw
				((ScriptID 895 0) stopUpd:) ; pepper
				(= cycles 3)
			)
			(5
				(self cue:)
			)
			(6
				((ScriptID 895 1) x: 1000 hide: stopUpd:) ; lockjaw
				(gEgo
					view: 121
					setLoop: 2
					cel: 0
					cycleSpeed: 5
					posn: 215 154
					setCycle: End self
				)
			)
			(7
				(gLongSong2 number: 1204 loop: 1 play: self)
				(gEgo setLoop: 5 cel: 0 setCycle: Fwd)
			)
			(8
				(gLongSong2 number: 1205 loop: 1 play: self)
				(gEgo cycleSpeed: 4 setLoop: 3 cel: 0 setCycle: CT 5 1 self)
			)
			(9)
			(10
				(gLongSong2 number: 1208 loop: 1 play: self)
				(gEgo cel: 6)
			)
			(11
				(= ticks 30)
			)
			(12
				(gLongSong2 number: 1203 loop: 1 play: self)
				(gEgo cycleSpeed: 6 cel: 9 setCycle: CycleBet 9 11 2)
				(= cycles 2)
			)
			(13
				(self cue:)
			)
			(14
				(gEgo setCycle: End self)
			)
			(15)
			(16
				((= register (Prop new:))
					view: 121
					setLoop: 6
					cel: 0
					x: 218
					y: 143
					setPri: 15
					ignoreActors: 1
					init:
					cycleSpeed: 6
					setCycle: End self
				)
				(gLongSong2 number: 949 loop: 1 play: self)
			)
			(17)
			(18
				(register dispose:)
				(gEgo
					cycleSpeed: 6
					setLoop: 4
					cel: 0
					x: (- (gEgo x:) 2)
					y: (+ (gEgo y:) 1)
					setCycle: CT 2 1 self
				)
			)
			(19
				(gLongSong2 number: 1206 loop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(20)
			(21
				((ScriptID 895 1) ; lockjaw
					normalize:
					view: 838
					setLoop: 1
					cel: 0
					setCycle: End
					cycleSpeed: 6
					x: 207
					y: 154
					show:
					approachX: 207
					approachY: 166
				)
				(gEgo
					normalize: 800
					x: 228
					y: 155
					loop: 8
					cel: 5
					cycleSpeed: local2
				)
				(softGum init: posn: 261 154)
				(= seconds 3)
			)
			(22
				(self dispose:)
			)
		)
	)
)

(instance ourCursor of Actor
	(properties
		x 120
		y 120
		yStep 4
		view 999
		cycleSpeed 0
		xStep 4
		moveSpeed 0
	)

	(method (init)
		(self setPri: 15)
		(super init: &rest)
	)
)

(instance theWalkIcon of View
	(properties
		y -5
		view 900
		priority 14
		signal 20496
	)
)

(instance theLookIcon of View
	(properties
		x 39
		y -5
		view 900
		loop 1
		priority 14
		signal 20496
	)
)

(instance theHandIcon of View
	(properties
		x 69
		y -5
		view 900
		loop 2
		priority 14
		signal 20496
	)
)

(instance theTalkIcon of View
	(properties
		x 99
		y -5
		view 900
		loop 3
		priority 14
		signal 20496
	)
)

(instance theInvIcon of View
	(properties
		x 129
		y -5
		view 900
		loop 4
		priority 14
		signal 20496
	)
)

(instance theCurInvIcon of View
	(properties
		x 159
		y -5
		view 900
		loop 5
		priority 14
		signal 20496
	)
)

(instance theControlIcon of View
	(properties
		x 194
		y -5
		view 900
		loop 6
		priority 14
		signal 20496
	)
)

(instance qMarkIcon of View
	(properties
		x 224
		y -5
		view 900
		loop 7
		priority 14
		signal 20496
	)
)

(instance truthIcon of View
	(properties
		x 254
		y -5
		view 900
		loop 8
		priority 14
		signal 20496
	)
)

(instance quizIcon of View
	(properties
		x 284
		y -5
		view 900
		loop 9
		priority 14
		signal 20496
	)
)

(instance theInvWindow of View
	(properties
		x 27
		y 28
		view 9000
		priority 15
		signal 16
	)
)

(instance invEye of View
	(properties
		x 62
		y 63
		view 901
		loop 2
		priority 15
		signal 16
	)
)

(instance invHand of View
	(properties
		x 93
		y 63
		view 901
		priority 15
		signal 16
	)
)

(instance invArrow of View
	(properties
		x 123
		y 63
		view 901
		loop 4
		priority 15
		signal 16
	)
)

(instance invTalk of View
	(properties
		x 154
		y 63
		view 901
		loop 1
		priority 15
		signal 16
	)
)

(instance invUp of View
	(properties
		x 184
		y 63
		view 901
		loop 5
		cel 2
		priority 15
		signal 16
	)
)

(instance invDown of View
	(properties
		x 214
		y 63
		view 901
		loop 6
		cel 2
		priority 15
		signal 16
	)
)

(instance invOk of View
	(properties
		x 244
		y 63
		view 901
		loop 3
		priority 15
		signal 16
	)
)

(instance hardGum of Prop
	(properties
		x 215
		y 145
		view 120
		cel 1
		signal 16384
	)
)

(instance lWalkIcon of View
	(properties
		view 902
		signal 16384
	)
)

(instance lLookIcon of View
	(properties
		x 38
		y 4
		view 902
		loop 1
		signal 16384
	)
)

(instance lPawIcon of View
	(properties
		x 65
		y 4
		view 902
		loop 2
		signal 16384
	)
)

(instance lSniffIcon of View
	(properties
		x 88
		y 4
		view 902
		loop 3
		signal 16384
	)
)

(instance lBiteIcon of View
	(properties
		x 116
		y 4
		view 902
		loop 4
		signal 16384
	)
)

(instance lInvIcon of View
	(properties
		x 142
		y 4
		view 902
		loop 5
		signal 16384
	)
)

(instance lCurInvIcon of View
	(properties
		x 169
		y 4
		view 902
		loop 6
		signal 16384
	)
)

(instance lCtrlIcon of View
	(properties
		x 203
		y 4
		view 902
		loop 7
		signal 16384
	)
)

(instance lQMarkIcon of View
	(properties
		x 227
		y 4
		view 902
		loop 8
		signal 16384
	)
)

(instance lTrivIcon of View
	(properties
		x 248
		y 4
		view 902
		loop 9
		signal 16384
	)
)

(instance lQuizIcon of View
	(properties
		x 274
		y 4
		view 902
		loop 10
		signal 16384
	)
)

(instance drainPipe of Prop
	(properties
		x 97
		y 119
		view 120
		cel 2
		signal 16385
	)
)

(instance softGum of Prop
	(properties
		x 215
		y 145
		view 120
		cel 1
		signal 16384
	)
)

(instance invPipe of View
	(properties
		x 89
		y 72
		view 907
		cel 1
		priority 14
		signal 16400
	)
)

