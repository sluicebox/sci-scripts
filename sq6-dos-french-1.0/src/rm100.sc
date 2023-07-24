;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use SQRoom)
(use DText)
(use Str)
(use Array)
(use Print)
(use Talker)
(use ForwardCounter)
(use Cursor)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm100 0
	KielbasaCloseTalker 1
	KielbasaTalker 2
	starconTalker 3
	rogerNHTalker 4
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(if (or (< argc 2) (== param2 0))
		(= param2 1)
	)
	(if (or (== argc 0) (== param1 1))
		(for ((= temp0 100)) (> temp0 0) ((-= temp0 param2))
			(Palette 2 0 81 temp0) ; PalIntensity
			(Palette 2 83 256 temp0) ; PalIntensity
			(= gGameTime (+ gTickOffset (GetTime)))
			(gCast doit:)
			(FrameOut)
		)
	else
		(for ((= temp0 0)) (< temp0 100) ((+= temp0 param2))
			(Palette 2 0 81 temp0) ; PalIntensity
			(Palette 2 83 256 temp0) ; PalIntensity
			(= gGameTime (+ gTickOffset (GetTime)))
			(gCast doit:)
			(FrameOut)
		)
	)
	(if (== param1 1)
		(Palette 2 0 81 0) ; PalIntensity
		(Palette 2 83 256 0) ; PalIntensity
	else
		(Palette 2 0 81 100) ; PalIntensity
		(Palette 2 83 256 100) ; PalIntensity
	)
	(FrameOut)
	(if (and (== argc 3) param3)
		(param3 cue:)
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(Message msgGET 99 [param1 0] [param1 1] [param1 2] [param1 3] (local1 data:))
	(= temp1 (IntArray with: 0 0 0 0))
	(Text 0 (temp1 data:) (local1 data:) gUserFont 192) ; TextSize
	((= local2 (DText new:))
		mode: 1
		font: gUserFont
		text: (KString 8 (local1 data:)) ; StrDup
		fore: 82
		back: 0
		x: (- 160 (/ (temp1 at: 2) 2))
		y: 150
		setSize: 192
		setPri: (+ (GetHighPlanePri) 1)
		init:
	)
	(temp1 dispose:)
)

(instance rm100 of SQRoom
	(properties
		style 0
		exitStyle 0
	)

	(method (init)
		(Load 140 100) ; WAVE
		(Load rsPIC 100)
		(Load rsVIEW 100)
		(= local1 (Str newWith: 512 {}))
		(Palette 2 0 79 0) ; PalIntensity
		(Palette 2 87 256 0) ; PalIntensity
		(super init:)
		((gCurRoom plane:) setRect: 0 0 320 200)
		(UpdatePlane plane)
		(self setScript: sShowLogo)
	)

	(method (handleEvent event)
		(if (and (event type:) (== (gCurRoom script:) sShowIntro) (not local3))
			(event claimed: 1)
			(gGame setCursor: gNormalCursor 1)
			(gTheCursor show:)
			(switch
				(Print
					addBitmap: 19 0 0
					addButtonBM: 19 1 0 0 { } 12 25
					addButtonBM: 19 2 0 1 { } 79 25
					init:
				)
				(0
					(gTheCursor hide:)
				)
				(1
					(gGSound1 stop:)
					(gTheCursor show:)
					(gGame setCursor: gWaitCursor 1)
					(gUser canControl: 0 canInput: 0)
					(gCurRoom setScript: sSkipCartoon)
				)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(PalVary 3) ; PalVaryKill
		(super dispose:)
	)
)

(instance sSkipCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gTalkers isEmpty:))
					(gTalkers eachElementDo: #dispose)
				)
				(= cycles 3)
			)
			(1
				(SetFlag 0)
				(gKeyDownHandler delete: rm100)
				(gMouseDownHandler delete: rm100)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance sShowLogo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gTheCursor hide:)
				(globe init: setCycle: Fwd)
				(gCurRoom drawPic: 100)
				(= cycles 1)
			)
			(2
				(introSound play: self)
				(localproc_0 0 2)
			)
			(3
				(localproc_0 1 2 self)
			)
			(4
				(globe dispose:)
				(= ticks 60)
			)
			(5
				(gTheCursor show:)
				(gGame setCursor: specialWait 1)
				(gGSound1 number: 150 flags: 1 setLoop: -1 play:)
				(= ticks 280)
			)
			(6
				(gCurRoom drawPic: 150)
				(newGameButton init:)
				(oldGameButton init:)
				(quitButton init:)
				(PalCycle 0 1 63 -1 1) ; Start
				(PalCycle 0 64 111 -1 2) ; Start
				(PalCycle 0 112 143 -1 3) ; Start
				(PalCycle 0 144 159 -1 4) ; Start
				(= cycles 1)
			)
			(7
				(localproc_0 0 2 self)
			)
			(8
				(gGame setCursor: specialArrow 1)
				(self dispose:)
			)
		)
	)
)

(instance sShowIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: gNormalCursor 1)
				(gTheCursor hide:)
				(= cycles 1)
			)
			(1
				(localproc_0 1 2 self)
			)
			(2
				(PalCycle 4) ; Off
				(newGameButton dispose:)
				(oldGameButton dispose:)
				(quitButton dispose:)
				(gCurRoom drawPic: 10)
				(= cycles 2)
			)
			(3
				(localproc_0 0 2 self)
			)
			(4
				(gKeyDownHandler addToFront: rm100)
				(gMouseDownHandler addToFront: rm100)
				(gGSound1 number: 199 setLoop: 1 play:)
				(= seconds 2)
			)
			(5
				(localproc_1 0 0 4 1 82)
				(Load rsSCRIPT 64929)
				(Load rsHEAP 64929)
				(gMessager say: 0 0 4 1 self 99) ; "The StarCon Federation has reached its decision."
			)
			(6
				(local2 dispose:)
				(= ticks 60)
			)
			(7
				(gCurRoom drawPic: 20 0)
				(sfx number: 960 setLoop: 1 play:)
				(Load rsMESSAGE 100)
				(= ticks 90)
			)
			(8
				(localproc_1 0 0 4 2)
				(gMessager say: 0 0 4 2 self 99) ; "Roger Wilco, please step forward."
			)
			(9
				(local2 dispose:)
				(UpdatePlane (gCurRoom plane:))
				(Load rsVIEW 20)
				(Load rsVIEW 21)
				(sfx number: 961 setLoop: 1 play:)
				(= ticks 780)
			)
			(10
				(prop1
					view: 20
					init:
					x: 162
					y: 114
					setLoop: 0 1
					setCel: 0
					setCycle: End
				)
				(= ticks 180)
			)
			(11
				(prop1
					view: 20
					x: 162
					y: 114
					setLoop: 1 1
					setCel: 0
					setCycle: End
				)
				(= ticks 81)
			)
			(12
				(prop1
					view: 21
					x: 160
					y: 109
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
				(sfx number: 962 setLoop: 1 play:)
			)
			(13
				(gCurRoom drawPic: 30 0)
				(prop1 view: 30 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(= seconds 2)
			)
			(14
				(prop2
					view: 30
					init:
					setLoop: 1
					setCel: 0
					x: 159
					y: 46
					setPri: 139
				)
				(= ticks 30)
			)
			(15
				(prop2
					view: 31
					setLoop: 0 1
					setCel: 0
					x: 159
					y: 46
					setPri: 139
					setCycle: CT 2 1 self
				)
			)
			(16
				(= ticks 45)
			)
			(17
				(prop2 setCycle: CT 6 1 self)
			)
			(18
				(= ticks 45)
			)
			(19
				(prop2 setCycle: End self)
			)
			(20
				(gCurRoom drawPic: 50)
				(prop2 view: 50 setLoop: 0 1 setCel: 0 x: 163 y: 120)
				(prop1 hide:)
				(= ticks 120)
			)
			(21
				(prop2 setCycle: End self)
			)
			(22
				(= ticks 60)
			)
			(23
				(gCurRoom drawPic: 30)
				(prop1 show:)
				(prop2
					view: 30
					setLoop: 1
					setCel: 0
					x: 159
					y: 46
					setPri: 139
					doit:
				)
				(localproc_1 0 0 4 3 82)
				(gMessager say: 0 0 4 3 self 99) ; "Roger Wilco, you have been judged guilty of the following crimes:"
			)
			(24
				(local2 dispose:)
				(Load rsVIEW 32)
				(= cycles 1)
			)
			(25
				(Load rsVIEW 32)
				(localproc_1 0 0 4 4 82)
				(gMessager say: 0 0 4 4 self 99) ; "Abandoning your post. Deviating from mission parameters."
				(= ticks 170)
			)
			(26
				(prop1
					view: 32
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: End prop2
				)
				(prop2 hide: view: 32 setLoop: 1 1 setCel: 0 x: 159 y: 46)
			)
			(27
				(local2 dispose:)
				(= cycles 1)
			)
			(28
				(Load rsVIEW 33)
				(localproc_1 0 0 4 5 82)
				(gMessager say: 0 0 4 5 self 99) ; "Misuse of StarCon property."
				(= ticks 170)
			)
			(29
				(prop1
					view: 33
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: End prop2
				)
				(prop2 hide: view: 33 setLoop: 1 1 setCel: 0 x: 158 y: 45)
			)
			(30
				(local2 dispose:)
				(= cycles 1)
			)
			(31
				(Load rsVIEW 34)
				(localproc_1 0 0 4 6 82)
				(gMessager say: 0 0 4 6 self 99) ; "Disintegrating a fellow officer."
				(= ticks 170)
			)
			(32
				(prop1
					view: 34
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: End
				)
				(prop2
					view: 34
					setLoop: 1 1
					setCel: 0
					x: 158
					y: 45
					setScript: 0
					setCycle: End
				)
			)
			(33
				(local2 dispose:)
				(= cycles 1)
			)
			(34
				(Load rsVIEW 30)
				(Load rsVIEW 35)
				(localproc_1 0 0 4 7 82)
				(gMessager say: 0 0 4 7 self 99) ; "Perpetrating a sequel without authorization."
				(= ticks 170)
			)
			(35
				(prop1 view: 30 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(prop2
					view: 35
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: End
				)
			)
			(36
				(local2 dispose:)
				(= cycles 1)
			)
			(37
				(Load rsVIEW 30)
				(Load rsVIEW 36)
				(localproc_1 0 0 4 8 82)
				(gMessager say: 0 0 4 8 self 99) ; "And consorting with a female of higher rank."
				(= ticks 170)
			)
			(38
				(prop1 view: 30 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(prop2
					show:
					view: 36
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: End
				)
			)
			(39
				(local2 dispose:)
				(= cycles 1)
			)
			(40
				(prop1 view: 30 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(prop2
					view: 30
					setLoop: 1
					setCel: 0
					x: 159
					y: 46
					setPri: 139
					setScript: sBlink
				)
				(= ticks 1)
			)
			(41
				(Load rsVIEW 37)
				(= ticks 60)
			)
			(42
				(localproc_1 0 0 5 1 82)
				(gMessager say: 0 0 5 1 self 99) ; "Do you have anything to say for yourself before we pronounce sentence?"
			)
			(43
				(local2 dispose:)
				(= cycles 1)
			)
			(44
				(prop2
					view: 37
					show:
					setLoop: 0
					setCel: 0
					x: 164
					y: 138
					setScript: 0
					setPri: (+ (prop1 priority:) 1)
					setCycle: End
				)
				(localproc_1 0 0 5 2 82)
				(gMessager say: 0 0 5 2 self 99) ; "Umm ..."
			)
			(45
				(local2 dispose:)
				(prop1
					view: 37
					setLoop: 1 1
					setCel: 0
					x: 164
					y: 138
					setCycle: End
				)
				(prop2 hide:)
				(localproc_1 0 0 5 3 82)
				(gMessager say: 0 0 5 3 self 99) ; "Can't you guys take a joke?"
			)
			(46
				(local2 dispose:)
				(prop1 view: 30 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(prop2
					view: 30
					show:
					setLoop: 1
					setCel: 0
					x: 159
					y: 46
					setPri: 139
					setScript: sBlink
				)
				(localproc_1 0 0 5 4 82)
				(gMessager say: 0 0 5 4 self 99) ; "Do you have anything INTELLIGENT to say for yourself before we pronounce sentence?"
			)
			(47
				(local2 dispose:)
				(prop2
					show:
					view: 39
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setScript: 0
					setCycle: End
				)
				(localproc_1 0 0 5 5 82)
				(gMessager say: 0 0 5 5 self 99) ; "Uh, nope."
			)
			(48
				(local2 dispose:)
				(prop2
					view: 30
					show:
					setLoop: 1
					setCel: 0
					x: 159
					y: 46
					setPri: 139
					setScript: sBlink
				)
				(localproc_1 0 0 5 6 82)
				(gMessager say: 0 0 5 6 self 99) ; "Very well. It is the opinion of this tribunal that as punishment for your crimes against the StarCon Federation, you are to be decommissioned."
			)
			(49
				(local2 dispose:)
				(prop2
					view: 39
					setLoop: 1 1
					setCel: 0
					setScript: 0
					x: 164
					y: 138
				)
				(localproc_1 0 0 5 7 82)
				(gMessager say: 0 0 5 7 self 99) ; "You are hereby stripped of the rank of Captain. (LOUD RIPPING SOUND)"
			)
			(50
				(local2 dispose:)
				(prop2 hide:)
				(prop1
					view: 40
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: CT 2 1 self
				)
			)
			(51
				(prop1 setCycle: End self)
				(sfx number: 963 setLoop: 1 play:)
			)
			(52
				(Load rsVIEW 41)
				(prop1 view: 41 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(localproc_1 0 0 5 8 82)
				(gMessager say: 0 0 5 8 self 99) ; "You are no longer an officer of the StarCon Federation. (ANOTHER LOUD RIP)"
			)
			(53
				(local2 dispose:)
				(prop2 hide:)
				(prop1
					view: 42
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: CT 4 1 self
				)
				(sfx number: 964 setLoop: 1 play:)
			)
			(54
				(prop1 setCycle: End self)
				(sfx number: 965 setLoop: 1 play:)
			)
			(55
				(prop1 view: 43 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(prop2
					show:
					view: 43
					setLoop: 1 1
					setCel: 0
					x: 164
					y: 138
					setScript: 0
					setCycle: End self
				)
			)
			(56
				(prop2 hide:)
				(prop1
					view: 44
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: End self
				)
			)
			(57
				(Load rsVIEW 45)
				(prop1 view: 45 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(prop2
					view: 45
					setLoop: 1 1
					setCycle: 0
					x: 162
					y: 45
					setScript: sBlink
				)
				(localproc_1 0 0 5 9 82)
				(gMessager say: 0 0 5 9 self 99) ; "Your enrollment at StarCon Academy is hereby terminated."
			)
			(58
				(local2 dispose:)
				(prop2 hide:)
				(prop1
					view: 46
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: End self
				)
				(sfx number: 966 setLoop: 1 play:)
			)
			(59
				(Load rsVIEW 47)
				(prop1 view: 47 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(localproc_1 0 0 5 10 82)
				(gMessager say: 0 0 5 10 self 99) ; "However ..."
			)
			(60
				(local2 dispose:)
				(prop2
					show:
					view: 47
					setLoop: 1 1
					setCel: 0
					x: 164
					y: 138
					setScript: 0
					setCycle: End self
				)
				(sfx number: 967 setLoop: 1 play:)
			)
			(61
				(prop2 hide:)
				(prop1
					view: 48
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
					setCycle: End self
				)
				(sfx number: 968 setLoop: 1 play:)
			)
			(62
				(prop1 view: 24 x: 160 y: 109 setLoop: 1 1 setCel: 1)
				(prop3 view: 22 init: setLoop: 0 setCel: 1 x: 242 y: 108)
				(prop2
					view: 23
					init:
					setLoop: 0
					setCel: 0
					x: 160
					y: 117
					setScript: 0
				)
				(gCurRoom drawPic: 20 0)
				(gCast doit:)
				(= cycles 1)
			)
			(63
				(Load rsVIEW 24)
				(prop2 setCycle: End prop4)
				(localproc_1 0 0 5 11 82)
				(gMessager say: 0 0 5 11 self 99) ; "Due to your successful return of the SCS Eureka, your rescue of the Goliath's crew ..."
			)
			(64
				(local2 dispose:)
				(= cycles 1)
			)
			(65
				(prop3 hide:)
				(prop2 hide:)
				(prop1
					view: 60
					setLoop: 0 1
					setCel: 0
					x: 140
					y: 71
					setCycle: End self
				)
				(gCast doit:)
				(gCurRoom drawPic: 60 0)
				(Load rsVIEW 25)
				(Load rsPIC 20)
				(localproc_1 0 0 5 12 82)
				(gMessager say: 0 0 5 12 self 99) ; "... and the fact that nobody gets rid of stubborn mildew stains and black heel marks as well as you do ..."
			)
			(66
				(= ticks 90)
			)
			(67
				(prop1 setCycle: Beg self)
			)
			(68
				(prop1 view: 25 setLoop: 0 1 setCel: 0 x: 160 y: 109)
				(gCast doit:)
				(gCurRoom drawPic: 20)
			)
			(69
				(local2 dispose:)
				(= cycles 1)
			)
			(70
				(prop1 view: 70 setLoop: 0 1 setCel: 0 x: 164 y: 138)
				(prop2
					show:
					view: 70
					setLoop: 1 1
					setCel: 0
					x: 160
					y: 48
					setScript: sBlink
				)
				(prop3
					show:
					view: 70
					setLoop: 2 1
					setCel: 0
					x: 125
					y: 45
					cycleSpeed: 20
					setCycle: End
				)
				(gCast doit:)
				(gCurRoom drawPic: 70 0)
				(localproc_1 0 0 5 13 82)
				(gMessager say: 0 0 5 13 self 99) ; "... we are returning you to your former post with StarCon Fleet."
			)
			(71
				(local2 dispose:)
				(prop3 hide: cycleSpeed: 10)
				(prop2 hide: setScript: 0)
				(prop1
					view: 71
					setLoop: 2 1
					setCel: 0
					x: 164
					y: 138
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(72
				(prop1 setLoop: 3 1 setCel: 0 setCycle: End self)
				(sfx number: 970 setLoop: 1 play:)
			)
			(73
				(prop1 setLoop: 4 1 setCel: 0 setCycle: End self)
			)
			(74
				(prop1
					cycleSpeed: 10
					view: 73
					setLoop: 0 1
					setCel: 0
					x: 164
					y: 138
				)
				(prop2
					show:
					view: 73
					setLoop: 1 1
					x: 160
					y: 48
					setScript: sLookAside
				)
				(prop3
					show:
					view: 72
					setLoop: 0 1
					setCel: 0
					x: 258
					y: 4
					setPri: (+ (prop2 priority:) 1)
					setCycle: End self
				)
			)
			(75
				(prop3 view: 72 setLoop: 1 1 setCel: 0 setCycle: Fwd)
				(localproc_1 0 0 5 14 82)
				(gMessager say: 0 0 5 14 self 99) ; "You are hereby ordered to resume your duties immediately as Janitor Second Class on board ..."
			)
			(76
				(local2 dispose:)
				(localproc_1 0 0 5 15 82)
				(gMessager say: 0 0 5 15 self 99) ; "... the SCS DeepShip 86."
			)
			(77
				(local2 dispose:)
				(prop1 hide:)
				(prop2 hide:)
				(prop3 hide:)
				(Fade 1 1 self)
			)
			(78
				(gCurRoom drawPic: -1 0)
				(Fade 0 1 self)
				(= local3 1)
			)
			(79
				(if (<= gHowFast 3)
					(PlayVMD 0 {75.vmd}) ; Open
					(PlayVMD 1 0 0) ; Put
				else
					(PlayVMD 0 {1075.vmd}) ; Open
					(PlayVMD 1 109 57) ; Put
				)
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 1)
			)
			(80
				(= local3 0)
				(Load rsPIC 380)
				(Load rsVIEW 380)
				(Load rsVIEW 80)
				(gCurRoom drawPic: 430 14)
				(gCurRoom curPic: 430)
				(prop1
					view: 81
					show:
					setLoop: 0 1
					setCel: 0
					x: 199
					y: 130
					doit:
					setCycle: Fwd
				)
				(prop3
					view: 86
					show:
					setLoop: 0
					setCel: 0
					posn: 120 108
					doit:
					setScript: occ3
				)
				(prop4
					view: 86
					init:
					setLoop: 1
					setCel: 0
					x: 122
					y: 111
					doit:
					setScript: occ4
				)
				(prop5
					view: 86
					init:
					setLoop: 2
					setCel: 0
					x: 246
					y: 105
					doit:
					setScript: occ5
				)
				(prop6
					view: 86
					init:
					setLoop: 3
					setCel: 0
					x: 246
					y: 105
					doit:
					setScript: occ6
				)
				(prop7
					view: 86
					init:
					setLoop: 4
					setCel: 0
					x: 176
					y: 94
					doit:
					setScript: occ7
				)
				(prop8
					view: 86
					init:
					setLoop: 6
					setCel: 0
					x: 228
					y: 94
					doit:
					setScript: occ8
				)
				(sfx number: 971 setLoop: -1 play:)
				(= seconds 6)
			)
			(81
				(prop2
					view: 80
					show:
					setLoop: 0 1
					setCel: 0
					x: 72
					y: 58
					setCycle: End self
				)
			)
			(82
				(Load rsMESSAGE 100)
				(prop2 setLoop: 1 1 setCel: 0 setCycle: Fwd)
				(sfx stop:)
				(localproc_1 0 0 1 1 82)
				(gMessager say: 0 0 1 1 self 99) ; "Attention, all hands."
			)
			(83
				(local2 dispose:)
				(prop3 setScript: 0)
				(prop4 setScript: 0)
				(prop5 setScript: 0)
				(prop6 setScript: 0)
				(prop7 setScript: 0)
				(prop8 setScript: 0)
				(= cycles 1)
			)
			(84
				(prop1 setLoop: 1 1 setCel: 0 setCycle: End)
				(prop3 view: 87 setCel: 0 setCycle: End)
				(prop4 view: 87 setCel: 0 setCycle: End)
				(prop5 view: 87 setCel: 0 setCycle: End)
				(prop6 view: 87 setCel: 0 setCycle: End)
				(prop7 view: 87 setCel: 0 setCycle: End)
				(prop8 view: 87 setCel: 0 setCycle: End)
				(localproc_1 0 0 1 2 82)
				(gMessager say: 0 0 1 2 self 99) ; "This is your commander speaking ..."
			)
			(85
				(local2 dispose:)
				(gCurRoom drawPic: 80 0)
				(gCurRoom curPic: 80)
				(prop1 hide:)
				(prop2 hide:)
				(prop3 hide:)
				(prop4 hide:)
				(prop5 hide:)
				(prop6 hide:)
				(prop7 hide:)
				(prop8 hide:)
				(localproc_1 0 0 1 3 82)
				(gMessager say: 0 0 1 3 self 99) ; "I'd like to thank each and every one of you for your fine performance during our recent episode, "A Stitch In Time Saves Gamma Nine.""
			)
			(86
				(local2 dispose:)
				(localproc_1 0 0 1 4 82)
				(gMessager say: 0 0 1 4 self 99) ; "So, Thank you. Thank you. Thank you..."
			)
			(87
				(= register 1)
				(local2 dispose:)
				(prop9
					view: 380
					init:
					setLoop: 0
					setCel: 0
					posn: 148 23
					setCycle: Fwd
				)
				(prop10
					view: 380
					init:
					setLoop: 1
					setCel: 0
					posn: 207 85
					setCycle: Fwd
				)
				(prop11
					view: 380
					init:
					setLoop: 6
					setCel: 0
					setPri: 200
					posn: 150 108
				)
				(prop12
					view: 380
					init:
					setLoop: 7
					setCel: 0
					posn: 257 26
					setCycle: Fwd
				)
				(gCurRoom drawPic: 380 0)
				(gCurRoom curPic: 380)
				(gCast doit:)
				(localproc_1 0 0 1 5 82)
				(gMessager say: 0 0 1 5 self 99) ; "Thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you ..."
			)
			(88
				(= register 0)
				(local2 dispose:)
				(gCurRoom drawPic: 430 0)
				(gCurRoom curPic: 430)
				(prop1
					view: 84
					setLoop: 0
					x: 195
					y: 131
					setCel: 0
					show:
					setScript: sLookWatch
				)
				(prop2 show:)
				(prop3 show:)
				(prop4 show:)
				(prop5 show:)
				(prop6 show:)
				(prop7 show:)
				(prop8 show:)
				(prop9 dispose:)
				(prop10 dispose:)
				(prop11 dispose:)
				(prop12 dispose:)
				(localproc_1 0 0 1 6 82)
				(gMessager say: 0 0 1 6 self 99) ; "Thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you, thank you ..."
			)
			(89
				(local2 dispose:)
				(prop1 hide: setScript: 0)
				(prop2 hide:)
				(prop3 hide:)
				(prop4 hide:)
				(prop5 hide:)
				(prop6 hide:)
				(prop7 hide:)
				(prop8 hide:)
				(prop9
					view: 85
					init:
					setLoop: 0
					setCel: 0
					x: 154
					y: 116
					setScript: sThankYou
				)
				(gCurRoom drawPic: 80 0)
				(gCurRoom curPic: 80)
				(gCast doit:)
				(localproc_1 0 0 1 7 82)
				(gMessager say: 0 0 1 7 self 99) ; "... thank you, thank you ... thank you."
			)
			(90
				(local2 dispose:)
				(gCurRoom drawPic: 430 0)
				(gCurRoom curPic: 430)
				(prop9 dispose:)
				(prop2 show:)
				(prop1
					setCycle: 0
					setScript: 0
					view: 84
					setLoop: 0 1
					x: 195
					y: 131
					setCel: 0
					show:
				)
				(prop3 show:)
				(prop4 show:)
				(prop5 show:)
				(prop6 show:)
				(prop7 show:)
				(prop8 show:)
				(localproc_1 0 0 1 8 82)
				(gMessager say: 0 0 1 8 self 99) ; "As a gesture of appreciation, we're putting in for shore leave on Polysorbate LX. Enjoy yourselves and don't do anything I wouldn't do. Kielbasa out."
			)
			(91
				(local2 dispose:)
				(prop2 setLoop: 2 1 setCel: 0 setCycle: End)
				(prop3 view: 88 setCel: 0 setCycle: End)
				(prop4 view: 88 setCel: 0 setCycle: End)
				(prop5 view: 88 setCel: 0 setCycle: End)
				(prop6 view: 88 setCel: 0 setCycle: End)
				(prop7 view: 88 setCel: 0 setCycle: End)
				(prop8 view: 88 setCel: 0 setCycle: End)
				(sfx number: 972 setLoop: 1 play:)
				(= seconds 4)
			)
			(92
				(localproc_0 1 2 self)
			)
			(93
				(sfx stop:)
				(localproc_1 0 0 2 1 82)
				(gMessager say: 0 0 2 1 self 99) ; "Meanwhile, in a deserted warehouse just outside the galaxy ..."
			)
			(94
				(local2 dispose:)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: -1)
				(localproc_0 0 1 self)
			)
			(95
				(= local3 1)
				(if (<= gHowFast 3)
					(PlayVMD 0 {90.vmd}) ; Open
					(PlayVMD 1 0 0) ; Put
				else
					(PlayVMD 0 {1090.vmd}) ; Open
					(PlayVMD 1 0 0) ; Put
				)
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 1)
			)
			(96
				(= local3 0)
				(SetFlag 0)
				(gTheCursor show:)
				(gKeyDownHandler delete: rm100)
				(gMouseDownHandler delete: rm100)
				(gCurRoom newRoom: 340)
				(self dispose:)
			)
		)
	)
)

(instance sDoFade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: specialWait 1)
				(= cycles 1)
			)
			(1
				(localproc_0 1 2 self)
			)
			(2
				(gCurRoom drawPic: -1)
				(newGameButton dispose:)
				(oldGameButton dispose:)
				(quitButton dispose:)
				(= ticks 60)
			)
			(3
				(= gQuit 1)
				(self dispose:)
			)
		)
	)
)

(instance sButtonAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: ForwardCounter 5 self)
			)
			(1
				(switch client
					(newGameButton
						(gGSound1 fade: 0 5 10 1)
						(gCurRoom setScript: sShowIntro)
					)
					(oldGameButton
						(gGame restore:)
					)
					(else
						(gGSound1 fade: 0 5 10 1)
						(gCurRoom setScript: sDoFade)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance globe of Prop
	(properties
		x 159
		y 68
		view 100
		cycleSpeed 4
	)
)

(class ButtonProp of Prop
	(properties
		hiliteState 0
	)

	(method (init)
		(gMouseDownHandler add: self)
		(super init:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(not (gCurRoom script:))
			)
			(self setScript: sButtonAction)
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(cond
			((self onMe: gMouseX gMouseY)
				(if (not hiliteState)
					(self setCel: 3 hiliteState: 1)
				)
			)
			(hiliteState
				(self setCel: 0 hiliteState: 0)
			)
		)
		(super doit:)
	)
)

(instance newGameButton of ButtonProp
	(properties
		x 91
		y 81
		view 150
	)
)

(instance oldGameButton of ButtonProp
	(properties
		x 91
		y 97
		view 150
		loop 1
	)
)

(instance quitButton of ButtonProp
	(properties
		x 123
		y 113
		view 150
		loop 2
	)
)

(instance introSound of Sound
	(properties
		flags 1
		number 100
	)
)

(instance prop1 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance prop2 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)

	(method (cue)
		(self show: setScript: sBlink)
	)
)

(instance prop3 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance prop4 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)

	(method (cue)
		(prop2 view: 24 setLoop: 0 setCel: 0 setCycle: End)
	)
)

(instance prop5 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance prop6 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance prop7 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance prop8 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance prop9 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance prop10 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance prop11 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance prop12 of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(self ignoreActors: cycleSpeed: 10)
	)
)

(instance sBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(= ticks (Random 180 300))
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sLookAside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(client setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(2
				(client setCel: 0)
				(= ticks 120)
			)
			(3
				(client setCycle: End self)
			)
			(4
				(client setCel: 0)
				(= ticks 120)
			)
			(5
				(client setLoop: 2 1 setCel: 0 setCycle: End self)
			)
			(6
				(client setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(7
				(client setCel: 0)
				(= ticks 60)
			)
			(8
				(client setLoop: 2 1 setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance sLookWatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(client view: 84 x: 195 y: 131 setCel: 0 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance occ3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 10 30))
			)
			(1
				(client setCel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance occ4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 10 30))
			)
			(1
				(client setCel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance occ5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 10 30))
			)
			(1
				(client setCel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance occ6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 10 30))
			)
			(1
				(client setCel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance occ7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 10 30))
			)
			(1
				(client setCel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance occ8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 10 30))
			)
			(1
				(client setCel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sThankYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance KielbasaCloseTalker of Talker
	(properties)

	(method (init)
		(switch (gGame printLang:)
			(33
				(= name {Commandeur Kielbasa})
			)
			(49
				(= name {Kommander Kielbasa})
			)
			(else
				(= name {Commander Kielbasa})
			)
		)
		(super init: kielMouth 0 kielEyes)
	)

	(method (handleEvent event)
		(gCurRoom handleEvent: event)
	)
)

(instance KielbasaTalker of Talker
	(properties)

	(method (init)
		(super init: 0 0 0)
	)

	(method (handleEvent event)
		(gCurRoom handleEvent: event)
	)
)

(instance rogerNHTalker of Talker
	(properties)

	(method (init)
		(super init: 0 0 0)
	)

	(method (handleEvent event)
		(gCurRoom handleEvent: event)
	)
)

(instance starconTalker of Talker
	(properties)

	(method (init)
		(super init: 0 0 0)
	)

	(method (handleEvent event)
		(gCurRoom handleEvent: event)
	)
)

(instance kielMouth of Prop
	(properties
		x 161
		y 76
		view 82
	)
)

(instance kielEyes of Prop
	(properties
		x 161
		y 60
		view 82
		loop 1
	)
)

(instance specialArrow of Cursor
	(properties
		view 150
		loop 3
	)
)

(instance specialWait of Cursor
	(properties
		view 150
		loop 3
		cel 1
	)
)

(instance sfx of Sound
	(properties)
)

