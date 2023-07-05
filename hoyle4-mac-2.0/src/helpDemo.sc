;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 910)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use TrackingView)
(use Tray)
(use Print)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	helpDemo 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 28] = [1 18 12 2 93 10 3 167 10 4 246 11 5 187 75 6 69 80 7 127 73 8 6 84 9 257 87 -1]
	[local38 47] = [8 4 84 19 8 5 121 19 8 6 158 19 8 0 88 53 8 1 124 25 8 2 163 36 -1 1 2 4 2 2 19 3 2 33 4 2 47 5 2 61 6 2 75 7 2 89 -1]
	[local85 35]
	local120
	[local121 9]
	[local130 9]
	[local139 9]
	[local148 6]
	local154
	local155
	local156
	local157
)

(procedure (localproc_0 param1 param2)
	(cond
		((== local120 0)
			(if (and [local121 param1] (< local154 3))
				(= [local121 param1] 0)
				(++ local154)
				(localproc_3 param1 param2)
				(local155
					guyCel: param1
					guyView: 908
					guyX: local156
					guyY: local157
				)
			)
		)
		((and [local130 param1] (< local154 3))
			(= [local130 param1] 0)
			(++ local154)
			(localproc_3 param1 param2)
			(local155 guyCel: param1 guyView: 909 guyX: local156 guyY: local157)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3)
	(= temp3 (PicNotValid))
	(PicNotValid 1)
	(= temp1 (if (== (= local120 (if (== local120 0) 1 else 0)) 0) 0 else 1))
	(= temp0 (if (== local120 0) 908 else 909))
	(if (== local120 0)
		(for ((= temp2 0)) (<= temp2 8) ((++ temp2))
			(= [local139 temp2] [local121 temp2])
		)
	else
		(for ((= temp2 0)) (<= temp2 8) ((++ temp2))
			(= [local139 temp2] [local130 temp2])
		)
	)
	(localproc_2)
	(if [local139 0]
		(DrawCel temp0 0 0 (frameGuy1 x:) (frameGuy1 y:) 8)
	else
		(DrawCel 906 temp1 0 (frameGuy1 x:) (frameGuy1 y:) 8)
	)
	(if [local139 1]
		(DrawCel temp0 0 1 (frameGuy2 x:) (frameGuy2 y:) 8)
	else
		(DrawCel 906 temp1 1 (frameGuy2 x:) (frameGuy2 y:) 8)
	)
	(if [local139 2]
		(DrawCel temp0 0 2 (frameGuy3 x:) (frameGuy3 y:) 8)
	else
		(DrawCel 906 temp1 2 (frameGuy3 x:) (frameGuy3 y:) 8)
	)
	(if [local139 3]
		(DrawCel temp0 0 3 (frameGuy4 x:) (frameGuy4 y:) 8)
	else
		(DrawCel 906 temp1 3 (frameGuy4 x:) (frameGuy4 y:) 8)
	)
	(if [local139 4]
		(DrawCel temp0 0 4 (frameGuy5 x:) (frameGuy5 y:) 8)
	else
		(DrawCel 906 temp1 4 (frameGuy5 x:) (frameGuy5 y:) 8)
	)
	(if [local139 5]
		(DrawCel temp0 0 5 (frameGuy6 x:) (frameGuy6 y:) 8)
	else
		(DrawCel 906 temp1 5 (frameGuy6 x:) (frameGuy6 y:) 8)
	)
	(if [local139 6]
		(DrawCel temp0 0 6 (frameGuy7 x:) (frameGuy7 y:) 8)
	else
		(DrawCel 906 temp1 6 (frameGuy7 x:) (frameGuy7 y:) 8)
	)
	(if [local139 7]
		(DrawCel temp0 0 7 (frameGuy8 x:) (frameGuy8 y:) 8)
	else
		(DrawCel 906 temp1 7 (frameGuy8 x:) (frameGuy8 y:) 8)
	)
	(if [local139 8]
		(DrawCel temp0 0 8 (frameGuy9 x:) (frameGuy9 y:) 8)
	else
		(DrawCel 906 temp1 8 (frameGuy9 x:) (frameGuy9 y:) 8)
	)
	(PicNotValid temp3)
	(proc0_1)
)

(procedure (localproc_2)
	(if (frameGuy1 underBits:)
		(UnLoad 133 (frameGuy1 underBits:))
		(frameGuy1 underBits: 0)
	)
	(if (frameGuy2 underBits:)
		(UnLoad 133 (frameGuy2 underBits:))
		(frameGuy2 underBits: 0)
	)
	(if (frameGuy3 underBits:)
		(UnLoad 133 (frameGuy3 underBits:))
		(frameGuy3 underBits: 0)
	)
	(if (frameGuy4 underBits:)
		(UnLoad 133 (frameGuy4 underBits:))
		(frameGuy4 underBits: 0)
	)
	(if (frameGuy5 underBits:)
		(UnLoad 133 (frameGuy5 underBits:))
		(frameGuy5 underBits: 0)
	)
	(if (frameGuy6 underBits:)
		(UnLoad 133 (frameGuy6 underBits:))
		(frameGuy6 underBits: 0)
	)
	(if (frameGuy7 underBits:)
		(UnLoad 133 (frameGuy7 underBits:))
		(frameGuy7 underBits: 0)
	)
	(if (frameGuy8 underBits:)
		(UnLoad 133 (frameGuy8 underBits:))
		(frameGuy8 underBits: 0)
	)
	(if (frameGuy9 underBits:)
		(UnLoad 133 (frameGuy9 underBits:))
		(frameGuy9 underBits: 0)
	)
	(if (frameChoice1 underBits:)
		(UnLoad 133 (frameChoice1 underBits:))
		(frameChoice1 underBits: 0)
	)
	(if (frameChoice2 underBits:)
		(UnLoad 133 (frameChoice2 underBits:))
		(frameChoice2 underBits: 0)
	)
	(if (frameChoice3 underBits:)
		(UnLoad 133 (frameChoice3 underBits:))
		(frameChoice3 underBits: 0)
	)
)

(procedure (localproc_3 param1)
	(DrawCel
		906
		local120
		param1
		(= local156
			(switch param1
				(0
					(frameGuy1 x:)
				)
				(1
					(frameGuy2 x:)
				)
				(2
					(frameGuy3 x:)
				)
				(3
					(frameGuy4 x:)
				)
				(4
					(frameGuy5 x:)
				)
				(5
					(frameGuy6 x:)
				)
				(6
					(frameGuy7 x:)
				)
				(7
					(frameGuy8 x:)
				)
				(8
					(frameGuy9 x:)
				)
			)
		)
		(= local157
			(switch param1
				(0
					(frameGuy1 y:)
				)
				(1
					(frameGuy2 y:)
				)
				(2
					(frameGuy3 y:)
				)
				(3
					(frameGuy4 y:)
				)
				(4
					(frameGuy5 y:)
				)
				(5
					(frameGuy6 y:)
				)
				(6
					(frameGuy7 y:)
				)
				(7
					(frameGuy8 y:)
				)
				(8
					(frameGuy9 y:)
				)
			)
		)
		8
	)
	(= local155
		(cond
			((not (frameChoice1 occupied:)) frameChoice1)
			((not (frameChoice2 occupied:)) frameChoice2)
			((not (frameChoice3 occupied:)) frameChoice3)
		)
	)
	(local155 occupied: 1)
	(DrawCel
		(if (== local120 0) 908 else 909)
		10
		param1
		(local155 x:)
		(local155 y:)
		8
	)
)

(procedure (localproc_4 &tmp temp0)
	(for ((= temp0 0)) (!= [local10 temp0] -1) ((+= temp0 3))
		(DrawCel
			907
			[local10 temp0]
			0
			[local10 (+ temp0 1)]
			[local10 (+ temp0 2)]
			0
		)
	)
)

(procedure (localproc_5 &tmp [temp0 100] [temp100 40] [temp140 30] temp170 temp171 temp172 temp173 temp174)
	(Message msgGET 3 37 0 0 1 @temp0) ; "Crazy Eights Skill:"
	(Message msgGET 3 34 6 0 1 @temp100) ; "Chip"
	(Message msgGET 3 22 11 5 1 @temp140) ; "is an expert."
	(StrCat @temp0 @temp100)
	(StrCat @temp0 { })
	(StrCat @temp0 @temp140)
	(= temp173 15)
	(= temp170 909)
	(= temp171 10)
	(= temp172 (mod temp173 9))
	(= temp174 (Print width:))
	(Print
		width: 0
		font: 3
		mode: 1
		addIcon: temp170 temp171 temp172 105 0
		addText: @temp0
		posn: 77 87
		ticks: 15
		init: (gCurRoom script:)
		dispose:
	)
	(Print width: temp174)
)

(procedure (localproc_6) ; UNUSED
	(= local8 1)
	(proc0_5)
)

(class IconBarList of List
	(properties
		height 0
		y 0
		port 0
		underBits 0
		iconBarUp 0
		doingHelp 0
		cursorObj 0
	)

	(method (init param1 &tmp temp0 temp1)
		(= temp0 ((User curEvent:) x:))
		(= temp1 ((User curEvent:) y:))
		(if (>= argc 1)
			(= temp0 [param1 0])
			(if (>= argc 2)
				(= temp1 [param1 1])
			)
		)
		(super init: &rest)
		(if (not cursorObj)
			((= cursorObj demoCursor)
				view: 999
				loop: 0
				cel: 0
				posn: temp0 temp1
				init:
			)
		)
		(self setup:)
	)

	(method (show &tmp temp0 [temp1 2] temp3 temp4 temp5 temp6 temp7)
		(if (not iconBarUp)
			(self setCursor: 999)
			(= height
				(CelHigh
					((= temp0 (self at: 0)) view:)
					(temp0 loop:)
					(temp0 cel:)
				)
			)
			(= temp3 0)
			(= temp4 y)
			(for ((= temp5 (FirstNode elements))) temp5 ((= temp5 temp6))
				(= temp6 (NextNode temp5))
				(if (not (IsObject (= temp7 (NodeValue temp5))))
					(return)
				)
				(temp7 show: temp3 temp4)
				(= temp3 (temp7 nsRight:))
			)
			(= iconBarUp 1)
		)
	)

	(method (hide &tmp temp0)
		(if iconBarUp
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				((self at: temp0) hide: startUpd:)
			)
			(= iconBarUp 0)
			(self setCursor: 999)
		)
	)

	(method (setCursor param1 &tmp temp0 temp1)
		(= temp0 (= temp1 0))
		(if (>= argc 2)
			(= temp0 [param1 1])
			(if (>= argc 3)
				(= temp1 [param1 2])
			)
		)
		(if (not cursorObj)
			(= cursorObj demoCursor)
		)
		(cursorObj view: param1 loop: temp0 cel: temp1)
	)

	(method (setup &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(for ((= temp0 0)) (< temp0 (gTheIconBar size:)) ((++ temp0))
			(= temp1 (gTheIconBar at: temp0))
			(IconBarList
				add:
					((IconTrackingView new:)
						view: (temp1 view:)
						loop: (temp1 loop:)
						cel: (temp1 cel:)
						cursor: (temp1 cursor:)
						helpItem: (& (temp1 type:) $2000)
						modNum: (temp1 modNum:)
						noun: (temp1 noun:)
						helpVerb: (temp1 helpVerb:)
						y: y
						init:
						yourself:
					)
			)
		)
		(for ((= temp4 (FirstNode elements))) temp4 ((= temp4 temp5))
			(= temp5 (NextNode temp4))
			(if (not (IsObject (= temp1 (NodeValue temp4))))
				(return)
			)
			(temp1 x: temp3) ; UNINIT
			(= temp3 (temp1 setNowSeen:))
		)
	)
)

(class IconTrackingView of TrackingView
	(properties
		priority 15
		signal 24593
		cursor 999
		moveX 0
		moveY 0
		helpItem 0
		helpVerb 0
		noun 0
		modNum -1
	)

	(method (setNowSeen)
		(SetNowSeen self)
		(= moveX (+ nsLeft (/ (- nsRight nsLeft) 2)))
		(= moveY (- nsBottom 3))
		(return nsRight)
	)

	(method (init)
		(super init: &rest)
		(= associatedObj assocList)
		(|= signal $0008)
		(= nsRight 0)
	)

	(method (show param1 param2)
		(&= signal $fff7)
		(= x param1)
		(= y param2)
		(SetNowSeen self)
		(|= signal $0002)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)

	(method (flash param1 &tmp [temp0 2])
		(super flash:)
		(if (or helpItem (not (IconBarList doingHelp:)))
			(IconBarList setCursor: cursor)
		)
		(if helpItem
			(IconBarList doingHelp: 1)
		)
		(if argc
			(param1 cue:)
		)
	)
)

(instance demoCursor of Actor
	(properties
		view 999
		priority 15
		signal 24592
		yStep 3
		moveSpeed 2
	)

	(method (setMotion param1 param2 &tmp temp0)
		(if (IsObject (= temp0 (IconBarList at: param1)))
			(super setMotion: MoveTo (temp0 moveX:) (temp0 moveY:) param2)
		else
			(super setMotion: param1 param2 &rest)
		)
	)
)

(instance assocList of List
	(properties)
)

(class DemoChoice of TrackingView
	(properties
		view 907
		priority 8
		signal 18449
		occupied 0
		guyCel 0
		guyView 0
		guyX 0
		guyY 0
		beingUsed 0
		playerName 0
	)

	(method (init)
		(= loop 11)
		(super init: &rest)
		(= associatedObj assocList)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(DrawCel 906 0 9 x y 8)
			(if occupied
				(= occupied 0)
				(cond
					((== local120 0)
						(if (== guyView 908)
							(DrawCel 908 0 guyCel guyX guyY 8)
							(= [local121 guyCel] 1)
						else
							(= [local130 guyCel] 1)
						)
					)
					((== guyView 909)
						(DrawCel 909 0 guyCel guyX guyY 8)
						(= [local130 guyCel] 1)
					)
					(else
						(= [local121 guyCel] 1)
					)
				)
				(-- local154)
			)
		)
		(event claimed:)
	)
)

(class GuyTrackingView of TrackingView
	(properties
		view 907
		priority 9
		signal 16401
	)

	(method (init)
		(super init: &rest)
		(= associatedObj assocList)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(localproc_0 (- loop 1) self)
		)
		(event claimed:)
	)
)

(class ChooseTrackingView of IconTrackingView
	(properties
		view 903
		priority 2
		signal 2065
	)

	(method (init)
		(super init: &rest)
		(&= signal $fff7)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(class DeckTrackingView of IconTrackingView
	(properties)

	(method (flash)
		(super flash: &rest)
		(self doYourThing:)
	)

	(method (doYourThing))
)

(class DemoNamePlate of TrackingView
	(properties)

	(method (init)
		(|= signal $4811)
		(super init: &rest)
		(= associatedObj assocList)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(if (== local120 0)
				(self sierraText:)
			else
				(self classicText:)
			)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (sierraText)
		(return 1)
	)

	(method (classicText)
		(return 1)
	)
)

(instance helpDemo of Rm
	(properties
		picture 950
		style 10
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(= local9 gSpeed)
		(= gSpeed 0)
		(gTheIconBar disable:)
		(= local154 0)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(= [local121 temp0] 1)
			(= [local130 temp0] 1)
			(= [local139 9] 1)
			(if (< temp0 6)
				(= [local148 temp0] 0)
			)
		)
		(= gNormalCursor 994)
		(gGame setCursor: 994)
		(= local155 0)
		(= local156 0)
		(= local157 0)
		(= global194 3)
		(IconBarList init: 160 100)
		(SetCursor 161 191)
		(assocList
			add:
				(IconBarList cursorObj:)
				(quitButton init: addKeyMouse: yourself:)
		)
		(chooseCrazy8s init: setNowSeen:)
		(chooseOldMaid init:)
		(chooseHearts init:)
		(chooseGinRummy init:)
		(chooseCribbage init:)
		(chooseKlondike init:)
		(chooseEuchre init:)
		(chooseBridge init:)
		(chooseTitle init:)
		(self setScript: demoScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (not local8)
			(quitButton handleEvent: event)
		)
	)

	(method (newRoom)
		(= gNormalCursor 999)
		(assocList release: dispose:)
		(= gCrazy8sSortCode 0)
		(quitButton deleteKeyMouse:)
		(KeyMouse release:)
		(IconBarList dispose:)
		(gTheIconBar enable:)
		(super newRoom: &rest)
	)

	(method (dispose)
		(if (== gSpeed 0)
			(= gSpeed local9)
		)
		(super dispose:)
	)

	(method (doit)
		(Dealer doit:)
		(if (== local6 3)
			(localproc_2)
		)
		(super doit: &rest)
	)
)

(instance demoScript of Script
	(properties)

	(method (dispose)
		(chooseCrazy8s dispose: delete:)
		(chooseOldMaid dispose: delete:)
		(chooseHearts dispose: delete:)
		(chooseGinRummy dispose: delete:)
		(chooseCribbage dispose: delete:)
		(chooseKlondike dispose: delete:)
		(chooseEuchre dispose: delete:)
		(chooseBridge dispose: delete:)
		(chooseTitle dispose: delete:)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local6 1)
				(= cycles 2)
			)
			(1
				(Prints 0 0 0 1 0 0 910)
				(= cycles 1)
			)
			(2
				(Prints 0 0 0 2 0 0 910)
				(Prints 0 0 0 3 0 0 910)
				(= cycles 2)
			)
			(3
				(= local2 (IconBarList cursorObj:))
				(IconBarList show:)
				(= cycles 5)
			)
			(4
				(Prints 0 0 0 4 0 0 910)
				(= local0 5)
				(= cycles 2)
			)
			(5
				(local2 setMotion: local0 self)
			)
			(6
				(if (== local0 0)
					(IconBarList doingHelp: 0)
				)
				((IconBarList at: local0) flash: self)
			)
			(7
				(= cycles 3)
			)
			(8
				(= temp1 (IconBarList at: local0))
				(if (> local0 0)
					(-= state 4)
					(-- local0)
				)
				(Print
					font: gUserFont
					addText:
						(temp1 noun:)
						(temp1 helpVerb:)
						0
						1
						0
						0
						(temp1 modNum:)
					ticks: 20
					init: self
					dispose:
				)
			)
			(9
				(IconBarList setCursor: 999)
				(= cycles 1)
			)
			(10
				(Prints 0 0 0 5 0 0 910)
				(= cycles 2)
			)
			(11
				((IconBarList at: 0) flash: self)
			)
			(12
				(= cycles 1)
			)
			(13
				(IconBarList hide:)
				(= cycles 2)
			)
			(14
				(self setScript: controlPanelDemo self)
			)
			(15
				(= cycles 2)
			)
			(16
				(Prints 0 0 0 6 0 0 910)
				(= cycles 1)
			)
			(17
				(IconBarList show:)
				(= cycles 2)
			)
			(18
				(local2 setMotion: 4 self)
			)
			(19
				((IconBarList at: 4) flash: self)
			)
			(20
				(= cycles 1)
			)
			(21
				(IconBarList hide:)
				(= cycles 2)
			)
			(22
				(self setScript: deckDemo self)
			)
			(23
				(= cycles 2)
			)
			(24
				(Prints 0 0 0 7 0 0 910)
				(= cycles 2)
			)
			(25
				(local2
					setMotion:
						MoveTo
						(chooseCrazy8s moveX:)
						(chooseCrazy8s moveY:)
						self
				)
			)
			(26
				(chooseCrazy8s flash: self)
			)
			(27
				(client setScript: selectCharectureDemo)
			)
		)
	)
)

(instance controlPanelDemo of Script
	(properties)

	(method (dispose)
		(things dispose:)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= local6 2)
				(= local7 (= temp0 0))
				(while (< temp0 (gGameControls size:))
					(= temp1 (gGameControls at: temp0))
					(= local7 (* temp0 3))
					(= [local85 local7] (temp1 noun:))
					(= [local85 (+ local7 1)] (temp1 helpVerb:))
					(= [local85 (+ local7 2)] (temp1 modNum:))
					(++ temp0)
				)
				(things
					add:
						((View new:)
							view: 901
							loop: 0
							cel: 0
							x: 63
							y: 43
							setPri: 13
							init:
							stopUpd:
							yourself:
						)
				)
				(for ((= local7 0)) (!= [local38 local7] -1) ((++ local7))
					(= temp1 (IconTrackingView new:))
					(things
						add:
							(temp1
								view: 901
								loop: [local38 local7]
								cel: [local38 (++ local7)]
								x: (+ [local38 (++ local7)] 63)
								y: (+ 43 [local38 (++ local7)])
								setPri: 14
								init:
								signal: (& (temp1 signal:) $fff7)
								setNowSeen:
								stopUpd:
								yourself:
							)
					)
					(if (<= 1 (- (things size:) 1) 3)
						(temp1 moveY: (- (temp1 moveY:) 15))
					)
				)
				(++ local7)
				(while (!= [local38 local7] -1)
					(= temp1 (IconTrackingView new:))
					(things
						add:
							(temp1
								view: 901
								loop: [local38 local7]
								x: (+ [local38 (++ local7)] 63)
								y: (+ 43 [local38 (++ local7)])
								priority: 14
								cursor: 999
								init:
								signal: (& (temp1 signal:) $fff7)
								signal: (| (temp1 signal:) $0010)
								yourself:
							)
					)
					(temp1 setNowSeen:)
					(++ local7)
				)
				(= local0 12)
				((things at: 12) helpItem: 1 cursor: 995)
				(= cycles 1)
			)
			(1
				(= local1 (things at: 12))
				(= cycles 1)
			)
			(2
				(local2 setMotion: MoveTo (local1 moveX:) (local1 moveY:) self)
			)
			(3
				(if (> local0 6)
					(local1 flash: self)
				else
					(= ticks 2)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(if (> local0 3)
					(= temp0 (* (- local0 4) 3))
				else
					(= temp0 (* (- local0 1) 3))
				)
				(Print
					font: gUserFont
					addText:
						[local85 temp0]
						[local85 (+ temp0 1)]
						0
						1
						0
						0
						[local85 (+ temp0 2)]
					ticks: 20
					init: self
					dispose:
				)
			)
			(6
				(if (< local0 13)
					(-= state 5)
					(= local0
						(switch (= temp2 local0)
							(12 3)
							(3 2)
							(2 1)
							(1 7)
							(7 8)
							(8 9)
							(9 10)
							(10 11)
							(11
								(IconBarList doingHelp: 0)
								13
							)
						)
					)
					(= local1 (things at: local0))
				)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance deckDemo of Script
	(properties)

	(method (dispose)
		(things dispose:)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register global384)
				(things
					add:
						((= temp0 (View new:))
							view: 904
							loop: 0
							cel: 0
							setPri: 13
							x: 91
							y: 29
							init:
							stopUpd:
							yourself:
						)
						((View new:)
							view: 904
							loop: 4
							cel: global384
							x: 115
							y: 51
							setPri: 13
							init:
							yourself:
						)
						((View new:)
							view: 904
							loop: 5
							cel: global384
							x: 160
							y: 51
							setPri: 13
							init:
							yourself:
						)
						(iconDeckLeft init: yourself:)
						(iconDeckRight init: yourself:)
						(iconBoardLeft init: yourself:)
						(iconBoardRight init: yourself:)
						(deckOK init: yourself:)
				)
				(= cycles 2)
			)
			(1
				(= local0 0)
				(local2
					setMotion:
						MoveTo
						(iconDeckLeft moveX:)
						(iconDeckLeft moveY:)
						self
				)
			)
			(2
				(Prints 0 0 0 8 0 0 910)
				(= cycles 2)
			)
			(3
				(if (<= (++ local0) 3)
					(-- register)
					(iconDeckLeft flash: self)
				else
					(++ state)
					(= cycles 2)
				)
			)
			(4
				(-= state 2)
				(= cycles 40)
			)
			(5
				(= local0 0)
				(local2
					setMotion:
						MoveTo
						(iconDeckRight moveX:)
						(iconDeckRight moveY:)
						self
				)
			)
			(6
				(Prints 0 0 0 9 0 0 910)
				(= cycles 3)
			)
			(7
				(if (<= (++ local0) 4)
					(++ register)
					(iconDeckRight flash: self)
				else
					(++ state)
					(= cycles 2)
				)
			)
			(8
				(-= state 2)
				(= cycles 40)
			)
			(9
				(= register global385)
				(= local0 0)
				(local2
					setMotion:
						MoveTo
						(iconBoardLeft moveX:)
						(iconBoardLeft moveY:)
						self
				)
			)
			(10
				(Prints 0 0 0 10 0 0 910)
				(= cycles 2)
			)
			(11
				(if (<= (++ local0) 3)
					(-- register)
					(iconBoardLeft flash: self)
				else
					(++ state)
					(= cycles 2)
				)
			)
			(12
				(-= state 2)
				(= cycles 40)
			)
			(13
				(= local0 0)
				(local2
					setMotion:
						MoveTo
						(iconBoardRight moveX:)
						(iconBoardRight moveY:)
						self
				)
			)
			(14
				(Prints 0 0 0 11 0 0 910)
				(= cycles 3)
			)
			(15
				(if (<= (++ local0) 4)
					(++ register)
					(iconBoardRight flash: self)
				else
					(++ state)
					(= cycles 2)
				)
			)
			(16
				(-= state 2)
				(= cycles 40)
			)
			(17
				(= local0 0)
				(local2 setMotion: MoveTo (deckOK moveX:) (deckOK moveY:) self)
			)
			(18
				(deckOK flash: self)
			)
			(19
				(self dispose:)
			)
		)
	)
)

(instance selectCharectureDemo of Script
	(properties)

	(method (dispose)
		(things dispose:)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local6 3)
				(PicNotValid 1)
				(gCurRoom drawPic: 950 10)
				(localproc_4)
				(frameChoice1
					x: 83
					y: 145
					beingUsed: 1
					occupied: 0
					init:
					stopUpd:
				)
				(frameChoice2
					x: 135
					y: 145
					beingUsed: 1
					occupied: 0
					init:
					stopUpd:
				)
				(frameChoice3
					x: 187
					y: 145
					beingUsed: 1
					occupied: 0
					init:
					stopUpd:
				)
				(= local120 1)
				(things
					add:
						okButn
						showGuysButn
						name1
						name2
						name3
						name4
						name5
						name6
						name7
						name8
						name9
						frameGuy1
						frameGuy2
						frameGuy3
						frameGuy4
						frameGuy5
						frameGuy6
						frameGuy7
						frameGuy8
						frameGuy9
					eachElementDo: #init
				)
				(things add: frameChoice1 frameChoice2 frameChoice3)
				(localproc_2)
				(DrawCel 906 0 9 (frameChoice1 x:) (frameChoice1 y:) 8)
				(DrawCel 906 0 9 (frameChoice2 x:) (frameChoice2 y:) 8)
				(DrawCel 906 0 9 (frameChoice3 x:) (frameChoice3 y:) 8)
				(localproc_1)
				(PicNotValid 0)
				(= cycles 20)
			)
			(1
				(= local8 0)
				(Prints 0 0 0 12 0 0 910)
				(= cycles 1)
			)
			(2
				(local2 setMotion: MoveTo 194 46 self)
			)
			(3
				(frameGuy3 flash:)
				(localproc_0 (- (frameGuy3 loop:) 1) frameGuy3)
				(= cycles 10)
			)
			(4
				(local2 setMotion: MoveTo 95 115 self)
			)
			(5
				(frameGuy6 flash:)
				(localproc_0 (- (frameGuy6 loop:) 1) frameGuy6)
				(= cycles 10)
			)
			(6
				(local2 setMotion: MoveTo 45 164 self)
			)
			(7
				(Prints 0 0 0 13 0 0 910)
				(= cycles 2)
			)
			(8
				(showGuysButn flash:)
				(if (== local120 0)
					(showGuysButn setLoop: 2)
					(name1 view: 909)
					(name2 view: 909)
					(name3 view: 909)
					(name4 view: 909)
					(name5 view: 909)
					(name6 view: 909)
					(name7 view: 909)
					(name8 view: 909)
					(name9 view: 909)
					(localproc_1)
				else
					(showGuysButn setLoop: 3)
					(name1 view: 908)
					(name2 view: 908)
					(name3 view: 908)
					(name4 view: 908)
					(name5 view: 908)
					(name6 view: 908)
					(name7 view: 908)
					(name8 view: 908)
					(name9 view: 908)
					(localproc_1)
				)
				(= cycles 10)
			)
			(9
				(local2 setMotion: MoveTo 154 132 self)
			)
			(10
				(Prints 0 0 0 14 0 0 910)
				(= cycles 4)
			)
			(11
				(name7 flash:)
				(localproc_5)
			)
			(12
				(local2 setMotion: MoveTo 194 46 self)
			)
			(13
				(frameGuy3 flash:)
				(localproc_0 (- (frameGuy3 loop:) 1) frameGuy3)
				(= cycles 10)
			)
			(14
				(Prints 0 0 0 15 0 0 910)
				(= cycles 2)
			)
			(15
				(Prints 0 0 0 16 0 0 910)
				(= cycles 2)
			)
			(16
				(local2 setMotion: MoveTo 274 178 self)
			)
			(17
				(okButn flash:)
				(= cycles 2)
			)
			(18
				(things dispose:)
				(client setScript: handDemo)
			)
		)
	)
)

(instance handDemo of Script
	(properties)

	(method (dispose)
		(Deck eachElementDo: #dispose release:)
		(Dealer dispose:)
		(discardPile dispose:)
		(if gTray
			(gTray dispose:)
		)
		(if global419
			(global419 deleteKeyMouse: dispose:)
			(= global419 0)
		)
		(if register
			(register dispose:)
			(= register 0)
		)
		(if (Piles elements:)
			(Piles dispose:)
		)
		(= global395 (= global458 0))
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 4)
				(gCurRoom drawPic: 906 10)
				((= register (EventHandler new:))
					add:
						((Hand new:)
							handDirection: 1
							x: 95
							y: 146
							handNumber: 3
							faceUp: 1
							location: 3
							centerX: 160
							centerY: 175
							owner: 0
							type: 1
							yourself:
						)
						((Hand new:)
							handDirection: 1
							x: 95
							y: 10
							handNumber: 1
							faceUp: 0
							location: 1
							centerX: 160
							centerY: 25
							owner: 0
							type: 1
							yourself:
						)
				)
				(Deck sameDeck: 1 init: 0 1)
				(= global419 theStock)
				(global419 client: (register at: 0) theDiscardPile: discardPile)
				(Dealer cardsToDeal: 5)
				(= cycles 1)
			)
			(1
				(= local8 0)
				(Dealer init: (register at: 0) (register at: 1) deal: self)
			)
			(2
				(Prints 0 0 0 17 0 0 910)
				(Prints 0 0 0 18 0 0 910)
				(= cycles 4)
			)
			(3
				(Dealer curPlayer: (register at: 0))
				((Tray new:)
					x: 90
					y: 69
					maxCards: 2
					init: register (register at: 0)
				)
				((gTray theOkButton:) associatedObj: assocList)
				(= cycles 10)
			)
			(4
				(Prints 0 0 0 19 0 0 910)
				(= cycles 1)
			)
			(5
				(local2 setMotion: MoveTo 176 168 self)
			)
			(6
				((= local3 (Event new:))
					message: KEY_RETURN
					type: evKEYBOARD
					x: (local2 x:)
					y: (local2 y:)
					modifiers: $0000
					claimed: 0
					port: 0
					localize:
				)
				(= local4
					(= global458
						((register at: 0) reverseFirstTrue: 133 local3)
					)
				)
				(local3 dispose:)
				((register at: 0) moveCard: Tray self)
			)
			(7
				((register at: 0) cue:)
				(gTray setCard: global458)
				(= global395 0)
				(= cycles 2)
			)
			(8
				(Prints 0 0 0 20 0 0 910)
				(= cycles 1)
			)
			(9
				(local2 setMotion: MoveTo 125 106 self)
			)
			(10
				(= global458 local4)
				(gTray eliminateCard: global458)
				(local4
					moveBack:
						((register at: 0) calcNextX:)
						((register at: 0) calcNextY:)
						self
				)
			)
			(11
				(local4 cue:)
				((register at: 0) add: local4)
				((register at: 0) sort:)
				(= cycles 10)
			)
			(12
				(local2 setMotion: MoveTo 176 168 self)
			)
			(13
				((= local3 (Event new:))
					message: KEY_RETURN
					type: evKEYBOARD
					x: (local2 x:)
					y: (local2 y:)
					modifiers: $0000
					claimed: 0
					port: 0
					localize:
				)
				(= local4
					(= global458
						((register at: 0) reverseFirstTrue: 133 local3)
					)
				)
				(local3 dispose:)
				((register at: 0) moveCard: Tray self)
			)
			(14
				((register at: 0) cue:)
				(gTray setCard: global458)
				(= global395 0)
				(= cycles 10)
			)
			(15
				((= local3 (Event new:))
					message: KEY_RETURN
					type: evKEYBOARD
					x: (local2 x:)
					y: (local2 y:)
					modifiers: $0000
					claimed: 0
					port: 0
					localize:
				)
				(= local4
					(= global458
						((register at: 0) reverseFirstTrue: 133 local3)
					)
				)
				(local3 dispose:)
				((register at: 0) moveCard: Tray self)
			)
			(16
				((register at: 0) cue:)
				(gTray setCard: global458)
				(= global395 0)
				(= cycles 10)
			)
			(17
				(Prints 0 0 0 21 0 0 910)
				(= cycles 2)
			)
			(18
				(local2 setMotion: MoveTo 201 110 self)
			)
			(19
				((gTray theOkButton:) flash:)
				(gTray dispose:)
				(= cycles 2)
			)
			(20
				(global419 init:)
				(discardPile init:)
				(local2 setMotion: MoveTo 127 114 self)
			)
			(21
				(Prints 0 0 0 22 0 0 910)
				(Prints 0 0 0 23 0 0 910)
				(= cycles 2)
			)
			(22
				(theStock client: (register at: 0) getCard:)
			)
			(23
				(= cycles 20)
			)
			(24
				((register at: 0) sort:)
				(local2 setMotion: MoveTo 182 114 self)
			)
			(25
				(Prints 0 0 0 24 0 0 910)
				(Prints 0 0 0 25 0 0 910)
				(= cycles 2)
			)
			(26
				(local2 setMotion: MoveTo 180 168 self)
			)
			(27
				((= local3 (Event new:))
					message: KEY_RETURN
					type: evKEYBOARD
					x: (local2 x:)
					y: (local2 y:)
					modifiers: $0000
					claimed: 0
					port: 0
					localize:
				)
				(= local4
					(= global458
						((register at: 0) reverseFirstTrue: 133 local3)
					)
				)
				(local3 dispose:)
				((register at: 0) moveCard: discardPile self)
			)
			(28
				((register at: 0) cue:)
				(discardPile setCard: global458)
				(= global395 0)
				(= cycles 2)
			)
			(29
				(IconBarList show:)
				(local2 setMotion: 1 self)
			)
			(30
				(Prints 0 0 0 26 0 0 910)
				(= cycles 5)
			)
			(31
				(IconBarList hide:)
				(= cycles 2)
			)
			(32
				(Prints 0 0 0 27 0 0 910)
				(= cycles 2)
			)
			(33
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance quitButton of TrackingView
	(properties
		x 131
		y 182
		view 903
		loop 9
		priority 14
		signal 2065
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			((ScriptID 930 0) init: 913 0 1300) ; yesNo
			(if global461
				(gCurRoom newRoom: gPrevRoomNum)
			else
				(SetCursor 161 191)
			)
		)
		(event claimed:)
	)
)

(instance chooseCrazy8s of ChooseTrackingView
	(properties
		x 32
		y 50
	)
)

(instance chooseOldMaid of ChooseTrackingView
	(properties
		x 32
		y 80
		loop 1
	)
)

(instance chooseGinRummy of ChooseTrackingView
	(properties
		x 32
		y 110
		loop 3
	)
)

(instance chooseCribbage of ChooseTrackingView
	(properties
		x 32
		y 140
		loop 4
	)
)

(instance chooseHearts of ChooseTrackingView
	(properties
		x 185
		y 80
		loop 2
	)
)

(instance chooseBridge of ChooseTrackingView
	(properties
		x 185
		y 50
		loop 6
	)
)

(instance chooseKlondike of ChooseTrackingView
	(properties
		x 185
		y 140
		loop 5
	)
)

(instance chooseEuchre of ChooseTrackingView
	(properties
		x 185
		y 110
		loop 7
	)
)

(instance chooseTitle of View
	(properties
		x 160
		y 36
		view 903
		loop 8
		priority 8
		signal 2065
	)
)

(instance frameChoice1 of DemoChoice
	(properties)
)

(instance frameChoice2 of DemoChoice
	(properties)
)

(instance frameChoice3 of DemoChoice
	(properties)
)

(instance name1 of DemoNamePlate
	(properties
		view 908
		loop 1
		priority 10
	)

	(method (init)
		(self posn: 20 57)
		(super init: &rest)
		(associatedObj add: frameGuy1)
	)

	(method (dispose)
		(associatedObj delete: frameGuy1)
		(super dispose:)
	)
)

(instance name2 of DemoNamePlate
	(properties
		view 908
		loop 2
		priority 10
	)

	(method (init)
		(self posn: 96 57)
		(super init: &rest)
		(associatedObj add: frameGuy2)
	)

	(method (dispose)
		(associatedObj delete: frameGuy2)
		(super dispose:)
	)
)

(instance name3 of DemoNamePlate
	(properties
		view 908
		loop 3
		priority 10
	)

	(method (init)
		(self posn: 160 56)
		(super init: &rest)
		(associatedObj add: frameGuy3)
	)

	(method (dispose)
		(associatedObj delete: frameGuy3)
		(super dispose:)
	)
)

(instance name4 of DemoNamePlate
	(properties
		view 908
		loop 4
		priority 10
	)

	(method (init)
		(self posn: 251 64)
		(super init: &rest)
		(associatedObj add: frameGuy4)
	)

	(method (dispose)
		(associatedObj delete: frameGuy4)
		(super dispose:)
	)
)

(instance name5 of DemoNamePlate
	(properties
		view 908
		loop 8
		priority 10
	)

	(method (init)
		(self posn: 2 131)
		(super init: &rest)
		(associatedObj add: frameGuy8)
	)

	(method (dispose)
		(associatedObj delete: frameGuy9)
		(super dispose:)
	)
)

(instance name6 of DemoNamePlate
	(properties
		view 908
		loop 6
		priority 10
	)

	(method (init)
		(self posn: 71 124)
		(super init: &rest)
		(associatedObj add: frameGuy6)
	)

	(method (dispose)
		(associatedObj delete: frameGuy6)
		(super dispose:)
	)
)

(instance name7 of DemoNamePlate
	(properties
		view 908
		loop 7
		priority 10
	)

	(method (init)
		(self posn: 129 124)
		(super init: &rest)
		(associatedObj add: frameGuy7)
	)

	(method (dispose)
		(associatedObj delete: frameGuy7)
		(super dispose:)
	)
)

(instance name8 of DemoNamePlate
	(properties
		view 908
		loop 5
		priority 10
	)

	(method (init)
		(self posn: 182 124)
		(super init: &rest)
		(associatedObj add: frameGuy5)
	)

	(method (dispose)
		(associatedObj delete: frameGuy5)
		(super dispose:)
	)
)

(instance name9 of DemoNamePlate
	(properties
		view 908
		loop 9
		priority 10
	)

	(method (init)
		(self posn: 250 132)
		(super init: &rest)
		(associatedObj add: frameGuy9)
	)

	(method (dispose)
		(associatedObj delete: frameGuy9)
		(super dispose:)
	)
)

(instance frameGuy1 of GuyTrackingView
	(properties)

	(method (init)
		(self offsetY: 39 loop: 1 posn: 18 12)
		(super init: &rest)
	)
)

(instance frameGuy2 of GuyTrackingView
	(properties)

	(method (init)
		(self offsetY: 41 loop: 2 posn: 93 10)
		(super init: &rest)
	)
)

(instance frameGuy3 of GuyTrackingView
	(properties)

	(method (init)
		(self offsetY: 41 loop: 3 posn: 167 10)
		(super init: &rest)
	)
)

(instance frameGuy4 of GuyTrackingView
	(properties)

	(method (init)
		(self offsetY: 45 loop: 4 posn: 246 11)
		(super init: &rest)
	)
)

(instance frameGuy5 of GuyTrackingView
	(properties)

	(method (init)
		(self offsetY: 44 loop: 5 posn: 187 75)
		(super init: &rest)
	)
)

(instance frameGuy6 of GuyTrackingView
	(properties)

	(method (init)
		(self offsetY: 41 loop: 6 posn: 69 80)
		(super init: &rest)
	)
)

(instance frameGuy7 of GuyTrackingView
	(properties)

	(method (init)
		(self offsetY: 46 loop: 7 posn: 127 73)
		(super init: &rest)
	)
)

(instance frameGuy8 of GuyTrackingView
	(properties)

	(method (init)
		(self offsetY: 43 loop: 8 posn: 6 84)
		(super init: &rest)
	)
)

(instance frameGuy9 of GuyTrackingView
	(properties)

	(method (init)
		(self offsetY: 38 offsetX: 25 loop: 9 posn: 257 87)
		(super init: &rest)
	)
)

(instance okButn of TrackingView
	(properties)

	(method (init)
		(self
			ignoreActors:
			view: 906
			setLoop: 4
			cel: 0
			posn: 240 155
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
		(= associatedObj assocList)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
	)
)

(instance showGuysButn of TrackingView
	(properties)

	(method (init)
		(self
			ignoreActors:
			view: 906
			setLoop: 3
			cel: 0
			posn: 11 155
			setPri: 9
			stopUpd:
		)
		(super init: &rest)
		(= associatedObj assocList)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			(if (== local120 0)
				(self setLoop: 2)
				(name1 view: 909)
				(name2 view: 909)
				(name3 view: 909)
				(name4 view: 909)
				(name5 view: 909)
				(name6 view: 909)
				(name7 view: 909)
				(name8 view: 909)
				(name9 view: 909)
				(localproc_1)
			else
				(self setLoop: 3)
				(name1 view: 908)
				(name2 view: 908)
				(name3 view: 908)
				(name4 view: 908)
				(name5 view: 908)
				(name6 view: 908)
				(name7 view: 908)
				(name8 view: 908)
				(name9 view: 908)
				(localproc_1)
			)
		)
		(event claimed:)
	)
)

(instance things of List
	(properties)
)

(instance deckOK of IconTrackingView
	(properties
		view 904
		loop 3
	)

	(method (init &tmp temp0)
		(= x 133)
		(= y 119)
		(super init: &rest)
		(&= signal $fff7)
		(self setNowSeen:)
	)
)

(instance iconDeckLeft of DeckTrackingView
	(properties
		view 904
		loop 1
	)

	(method (init &tmp temp0)
		(= x 113)
		(= y 97)
		(super init: &rest)
		(&= signal $fff7)
		(self setNowSeen:)
	)

	(method (doYourThing)
		(if (< (deckDemo register:) 0)
			(deckDemo register: 8)
		)
		((things at: 1) cel: (deckDemo register:))
	)
)

(instance iconDeckRight of DeckTrackingView
	(properties
		view 904
		loop 2
	)

	(method (init &tmp temp0)
		(= x 133)
		(= y 97)
		(super init: &rest)
		(&= signal $fff7)
		(self setNowSeen:)
	)

	(method (doYourThing)
		(if (> (deckDemo register:) 8)
			(deckDemo register: 0)
		)
		((things at: 1) cel: (deckDemo register:))
	)
)

(instance iconBoardLeft of DeckTrackingView
	(properties
		view 904
		loop 1
	)

	(method (init &tmp temp0)
		(= x 158)
		(= y 97)
		(super init: &rest)
		(&= signal $fff7)
		(self setNowSeen:)
	)

	(method (doYourThing)
		(if (< (deckDemo register:) 0)
			(deckDemo register: 9)
		)
		((things at: 2) cel: (deckDemo register:))
	)
)

(instance iconBoardRight of DeckTrackingView
	(properties
		view 904
		loop 2
	)

	(method (init &tmp temp0)
		(= x 178)
		(= y 97)
		(super init: &rest)
		(&= signal $fff7)
		(self setNowSeen:)
	)

	(method (doYourThing)
		(if (> (deckDemo register:) 9)
			(deckDemo register: 0)
		)
		((things at: 2) cel: (deckDemo register:))
	)
)

(instance tempView of View ; UNUSED
	(properties)
)

(instance discardPile of DiscardPile
	(properties)

	(method (init)
		(= x 165)
		(= y 82)
		(super init:)
	)
)

(instance theStock of Stock
	(properties)

	(method (init)
		(= x 110)
		(= y 75)
		(= loop 0)
		(super init:)
	)

	(method (cue)
		(super cue:)
		(handDemo cue:)
	)
)

