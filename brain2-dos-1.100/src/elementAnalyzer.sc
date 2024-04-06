;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 268)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use LoadMany)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	elementAnalyzer 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 3] = [148 178 208]
	[local10 26] = [{00} {01} {02} {03} {04} {05} {06} {07} {08} {09} {10} {11} {12} {13} {14} {15} {16} {17} {18} {19} {20} {21} {22} {23} {24} {Tr Elems.}]
	[local36 5] = [{              0} {              1} {              2} {              3} {              4}]
	[local41 3] = [35 48 68]
	[local44 3] = [104 80 104]
	[local47 26] = [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 27 28 29 30 33 34]
	[local73 26]
	[local99 26]
	[local125 5]
	local130
	[local131 3] = [13 14 15]
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0) ; UNUSED
	(while (& (<< $0001 (= temp0 (Random param2 param3))) param1)
	)
	(return temp0)
)

(procedure (localproc_1 param1 &tmp temp0)
	(if param1
		(for ((= temp0 0)) (< temp0 local5) ((++ temp0))
			([local125 temp0] dispose:)
			(elementAnalyzer delete: [local125 temp0])
		)
		(= local5 0)
		(= local6 0)
		(DrawCel 268 0 1 22 102 -1)
	)
	(Graph grFILL_BOX 159 14 183 227 1 32 -1 -1)
	(Graph grUPDATE_BOX 159 14 183 227 1)
)

(procedure (localproc_2 &tmp temp0 [temp1 10])
	(for
		((= temp0 0))
		(Message msgGET 268 (+ 3 temp0) [local131 gDifficulty] 21 1 @temp1)
		((++ temp0))
	)
	(return temp0)
)

(instance elementAnalyzer of PuzzleBar
	(properties
		solvedFlag 18
		noun 6
		personalID 1
		showCast 1
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 2] [temp8 2] temp10)
		(= local3
			(= local4
				(= local2
					(= [temp8 0]
						(= [temp8 1]
							(= [temp6 0]
								(= [temp6 1] (= local0 (= local1 (= local5 0))))
							)
						)
					)
				)
			)
		)
		(= window puz2Window)
		(= puzzleCast (Set new:))
		(puzzleCast add: rayBeam moveProp)
		(= temp5 (localproc_2))
		(self
			add:
				(testBed
					view: (testBed maskView:)
					loop: (testBed maskLoop:)
					cel: (testBed maskCel:)
					yourself:
				)
		)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(while
				(&
					[temp6 (/ (= temp1 (Random 0 (- temp5 1))) 16)]
					(<< $0001 (mod temp1 16))
				)
			)
			(|= [temp6 (/ temp1 16)] (<< $0001 (mod temp1 16)))
			(self
				add:
					((anItem new:)
						loop: (+ (* gDifficulty 2) (/ temp1 16))
						cel: (mod temp1 16)
						nsTop: [local41 temp0]
						nsLeft: [local44 temp0]
						maskCel: temp0
						value: (+ temp1 3)
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 25) ((++ temp0))
			(= [local73 temp0] 0)
		)
		(= temp5 24)
		(= temp10 0)
		(for ((= temp0 0)) (< temp0 25) ((++ temp0))
			(while
				(&
					[temp8 (/ (= temp4 (Random 0 temp5)) 16)]
					(<< $0001 (mod temp4 16))
				)
			)
			(|= [temp8 (/ temp4 16)] (<< $0001 (mod temp4 16)))
			(= [local73 temp0] temp4)
		)
		(= [local73 25] 25)
		(for ((= temp0 0)) (<= temp0 25) ((++ temp0))
			(= temp2 (proc15_6 268 1 [local131 gDifficulty] [local47 temp0]))
			(Message msgGET 268 1 1 [local47 [local73 temp0]] 2 [local10 temp0])
			(self
				add:
					((= [local99 temp0] (anElement new:))
						nsTop: (+ 29 (* (/ temp0 3) 14))
						nsLeft: [local7 (mod temp0 3)]
						text: [local10 temp0]
						value: [local47 [local73 temp0]]
						modifiers: (Random 1 temp2)
						cursor: [local73 temp0]
						yourself:
					)
			)
		)
		([local99 25] loop: 6)
		(super init: &rest)
		(= local130 size)
	)

	(method (show &tmp temp0)
		(= temp0 gTheCursor)
		(if local2
			(gGame setCursor: 996)
		)
		(LoadMany rsSOUND 104 144 145 170 207 236)
		(super show: &rest)
		(gGame setCursor: temp0)
		(return puzzleStatus)
	)

	(method (buyClue &tmp temp0 temp1 temp2)
		(cond
			(puzzleStatus 0)
			((not local3)
				(gMessager say: 38 4 32 0 0 268) ; "You must place an item in the Analyzer before a clue can be given."
			)
			((& (local3 signal:) $4000)
				(gMessager say: 38 4 38 0 0 268) ; "This item has already been solved!"
			)
			((not (super buyClue: &rest)) 0)
			(else
				(if (== (local4 cursor:) [local47 (local4 value:)])
					(local4 textColor: 7 show:)
					(for ((= temp2 0)) (< temp2 local5) ((++ temp2))
						(= local4 [local125 temp2])
						(if (!= (local4 cursor:) [local47 (local4 value:)])
							(break)
						)
					)
					(gCSoundFX number: 104 setLoop: 1 play:)
					(local4 textColor: 15 show:)
					(Wait 0)
					(Wait 15)
				)
				(if (== (= temp1 [local47 (local4 value:)]) 34)
					(Message msgGET 268 1 1 37 1 (local4 text:)) ; "TR ELMNT"
				else
					(Message msgGET 268 1 1 temp1 1 (local4 text:))
				)
				(gCSoundFX number: 207 setLoop: 1 play:)
				(local4 cursor: temp1 show:)
				(if (>= (++ local6) local5)
					(++ local0)
				)
			)
		)
	)

	(method (doit)
		(rayBeam hide:)
		(if (not local2)
			(moveProp hide:)
		)
		(super doit: &rest)
	)

	(method (animateOnce)
		(super animateOnce: &rest)
		(if (> local0 local1)
			(= local1 local0)
			(local3 signal: (| (local3 signal:) $4000))
			(if (>= local0 3)
				(self solvePuzzle:)
			else
				(gMessager say: 2 27 0 local0 0 268)
			)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2)
		(if (& (event type:) $0040) ; direction
			(= temp1
				(if highlightedIcon
					(self indexOf: highlightedIcon)
				else
					0
				)
			)
			(switch (event message:)
				(JOY_UP
					(cond
						((< temp1 2)
							(= temp1 (- local130 2))
						)
						((< temp1 4)
							(-= temp1 1)
						)
						((< temp1 7)
							(= temp1 (- local130 1))
						)
						((< temp1 30)
							(-= temp1 3)
						)
						((< temp1 local130) 0)
						((< temp1 (+ local130 1))
							(= temp1 3)
						)
						(else
							(-= temp1 1)
						)
					)
				)
				(JOY_DOWN
					(cond
						((< temp1 1)
							(if (> size local130)
								(= temp1 local130)
							else
								(= temp1 (- local130 3))
							)
						)
						((< temp1 3)
							(+= temp1 1)
						)
						((< temp1 4)
							(if (> size local130)
								(= temp1 local130)
							else
								(= temp1 (- local130 2))
							)
						)
						((< temp1 27)
							(+= temp1 3)
						)
						((< temp1 28)
							(+= temp1 2)
						)
						((< temp1 (- local130 3))
							(= temp1 (- local130 1))
						)
						((< temp1 (- local130 2))
							(= temp1 0)
						)
						((< temp1 (- local130 1))
							(= temp1 1)
						)
						((< temp1 local130)
							(= temp1 4)
						)
						((< temp1 (- size 1))
							(+= temp1 1)
						)
						(else
							(= temp1 (- local130 2))
						)
					)
				)
				(JOY_RIGHT
					(cond
						((< temp1 1)
							(= temp1 2)
						)
						((< temp1 4)
							(= temp1 (+ (* (- temp1 1) 6) 4))
						)
						((< temp1 28)
							(if (== (mod (++ temp1) 3) 1)
								(-= temp1 3)
							)
						)
						((< temp1 30)
							(if (not (mod (++ temp1) 3))
								(-= temp1 2)
							)
						)
						((< temp1 local130)
							(if (>= (++ temp1) local130)
								(= temp1 (- local130 3))
							)
						)
						((< temp1 37)
							(= temp1 (+ (* (- temp1 local130) 3) 19))
						)
						(else
							(= temp1 28)
						)
					)
				)
				(JOY_LEFT
					(cond
						((< temp1 1)
							(= temp1 9)
						)
						((< temp1 4)
							(= temp1 0)
						)
						((< temp1 30)
							(cond
								((!= (mod temp1 3) 1)
									(-= temp1 1)
								)
								((< temp1 19)
									(= temp1 (+ (/ (- temp1 4) 6) 1))
								)
								(
									(<
										(= temp2
											(+ (/ (- temp1 19) 3) local130)
										)
										size
									)
									(= temp1 temp2)
								)
								((> size local130)
									(= temp1 (- size 1))
								)
								((< temp1 28)
									(+= temp1 2)
								)
								(else
									(+= temp1 1)
								)
							)
						)
						((< temp1 local130)
							(if (< (-- temp1) (- local130 3))
								(+= temp1 3)
							)
						)
						((< temp1 local130)
							(if (>= (++ temp1) local130)
								(= temp1 (- local130 3))
							)
						)
						((< temp1 37)
							(= temp1 (+ (* (- temp1 local130) 3) 21))
						)
						(else
							(= temp1 29)
						)
					)
				)
			)
			(= temp0 (self at: temp1))
			(proc5_9 temp0)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)
)

(instance puz2Window of SysWindow
	(properties
		top 2
		left 60
		bottom 190
		right 301
		priority -1
	)

	(method (open)
		(super open: &rest)
		(DrawCel 268 0 0 0 21 -1)
		(DrawCel 268 0 2 0 93 -1)
		(DrawCel 268 0 1 22 102 -1)
	)
)

(instance analyzeItem of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 [temp2 4])
		(switch (= state newState)
			(0
				(= ticks 10)
				(elementAnalyzer pHandsOff: 1)
			)
			(1
				(gCSoundFX number: 170 setLoop: 1 play:)
				(rayBeam show: setCycle: Fwd)
				(= ticks 30)
			)
			(2
				(rayBeam hide:)
				(= cycles 1)
			)
			(3
				(localproc_1 1)
				(= local4 0)
				(= local5 (proc15_6 268 register [local131 gDifficulty] 26))
				(for ((= temp0 0)) (< temp0 local5) ((++ temp0))
					(Message
						msgGET
						268
						register
						[local131 gDifficulty]
						26
						(+ temp0 1)
						@temp2
					)
					(= temp1 (- (ReadNumber @temp2) 1))
					(if (& (local3 signal:) $4000)
						(if (== [local47 temp1] 34)
							(Message msgGET 268 1 1 37 1 [local36 temp0]) ; "TR ELMNT"
						else
							(Message
								msgGET
								268
								1
								1
								[local47 temp1]
								1
								[local36 temp0]
							)
						)
					else
						(StrCpy [local36 temp0] {Element})
					)
					(elementAnalyzer
						add:
							((= [local125 temp0] (anEntry new:))
								nsLeft: 117
								nsTop: (+ 103 (* temp0 11))
								nsRight: 123
								nsBottom: (+ 109 (* temp0 11))
								modifiers: (+ temp0 1)
								value: temp1
								text: [local36 temp0]
								show:
								yourself:
							)
					)
				)
				(= local4 [local125 0])
				(local4 textColor: 15 show:)
				(client script: 0)
				(elementAnalyzer pHandsOff: 0)
			)
		)
	)
)

(instance anEntry of TextIcon
	(properties
		view 268
		loop 1
		cursor 0
		textColor 7
	)

	(method (show &tmp [temp0 75])
		(DrawCel view loop cel nsLeft nsTop -1)
		(Message msgGET 268 (local3 value:) [local131 gDifficulty] 25 modifiers @temp0)
		(Display @temp0 dsCOORD 24 (+ nsTop 0) dsWIDTH 21 dsALIGN alRIGHT dsCOLOR textColor dsFONT 999)
		(Graph grFILL_BOX (+ nsTop 0) 55 (+ nsTop 8) 109 1 0 -1 -1)
		(Graph grUPDATE_BOX (+ nsTop 0) 55 (+ nsTop 8) 109 1)
		(Display text dsCOORD 55 (+ nsTop 0) dsWIDTH 54 dsALIGN alCENTER dsCOLOR textColor dsFONT 999)
		(if (== local4 self)
			(localproc_1 0)
			(Message
				msgGET
				268
				1
				[local131 gDifficulty]
				[local47 value]
				([local99 value] modifiers:)
				@temp0
			)
			(Display @temp0 dsCOORD 14 160 dsWIDTH 213 dsALIGN alLEFT dsCOLOR 53 dsFONT 999)
		)
	)

	(method (showText))

	(method (highlight param1)
		(if param1
			(DrawCel view loop 0 nsLeft nsTop -1)
		else
			(DrawCel view loop cel nsLeft nsTop -1)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(cond
				((not local4)
					(= local4 self)
					(= textColor 15)
					(self show:)
				)
				((== local4 self) 0)
				(else
					(= temp0 local4)
					(= local4 self)
					(temp0 textColor: 7 show:)
					(= textColor 15)
					(self show:)
				)
			)
		)
	)

	(method (onMe)
		(if local2
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)
)

(instance anElement of TextIcon
	(properties
		view 268
		loop 2
		cursor 0
		noun 1
	)

	(method (select &tmp temp0)
		(cond
			((not local3)
				(gMessager say: noun 4 32 1 0 268) ; "You must first place an item into the element analyzer."
			)
			((not local4)
				(gMessager say: noun 4 31 1 0 268) ; "Please click on a button beside an element blank first"
			)
			((== (elementAnalyzer puzzleStatus:) 1)
				(gMessager say: noun 4 36 0 0 268) ; "Now that you have solve the puzzle, there is no need to change this element."
			)
			((& (local3 signal:) $4000)
				(gMessager say: noun 4 35 0 0 268) ; "You have already found the correct elements for this item. Try the next item."
			)
			((super select: &rest temp0) ; UNINIT
				(if (== value 34)
					(Message msgGET 268 1 1 37 1 (local4 text:)) ; "TR ELMNT"
				else
					(Message msgGET 268 1 1 [local47 cursor] 1 (local4 text:))
				)
				(= temp0 (local4 cursor:))
				(local4 cursor: value show:)
				(if (== temp0 [local47 (local4 value:)])
					(-- local6)
				)
				(if (== value [local47 (local4 value:)])
					(++ local6)
				)
				(if (>= local6 local5)
					(++ local0)
				)
			)
		)
	)

	(method (highlight param1)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super highlight: param1 &rest)
		(if (and param1 (== gDifficulty 0)) ; Novice
			((Print new:)
				modeless: 1
				x: 195
				y: 0
				addText: 1 1 [local47 cursor] 1 0 0 268
				init:
			)
		)
	)

	(method (onMe)
		(if local2
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (showText param1)
		(proc5_8 text param1 (+ nsLeft 2) (+ nsTop 3))
	)
)

(instance anItem of CodeIcon
	(properties
		view 269
		maskView 268
		maskLoop 4
		highlightColor 1
		lowlightColor 106
	)

	(method (select &tmp temp0)
		(self highlight: 0)
		(cond
			((not local2)
				(gCSoundFX number: 144 setLoop: 1 play:)
				(= local2 self)
				(gGame setCursor: 996 1 (+ nsLeft 11) (+ nsTop 11))
				(moveProp
					view: view
					loop: loop
					cel: cel
					x: (+ nsLeft 11)
					y: (+ nsTop 11)
					show:
				)
				(DrawCel maskView maskLoop maskCel nsLeft nsTop -1)
			)
			((== local2 self)
				(gCSoundFX number: 145 setLoop: 1 play:)
				(= local2 0)
				(moveProp hide:)
				(gGame setCursor: 900)
				(elementAnalyzer animateOnce:)
				(self show:)
			)
			(else
				(gCSoundFX number: 145 setLoop: 1 play:)
				(= temp0 local2)
				(= local2 self)
				(temp0 show:)
				(gGame setCursor: 996 1 (+ nsLeft 11) (+ nsTop 11))
				(moveProp
					loop: loop
					cel: cel
					x: (+ nsLeft 11)
					y: (+ nsTop 11)
					show:
				)
				(DrawCel maskView maskLoop maskCel nsLeft nsTop -1)
				(gCSoundFX number: 144 setLoop: 1 play:)
			)
		)
	)

	(method (show)
		(if (and (!= local3 self) (!= local2 self))
			(super show: &rest)
		)
	)

	(method (onMe)
		(if (== local3 self)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (highlight param1 &tmp [temp0 5])
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(if (and param1 (!= local3 self) (!= local2 self))
			((Print new:)
				modeless: 1
				x: (+ nsLeft 85)
				y: (+ nsTop 2)
				addText: value [local131 gDifficulty] 21 0 0 0 268
				init:
			)
		)
	)
)

(instance testBed of CodeIcon
	(properties
		view 268
		loop 4
		cel 3
		nsLeft 29
		nsTop 66
		maskView 268
		maskLoop 4
		maskCel 3
		noun 18
	)

	(method (highlight param1)
		(cond
			((not local2)
				(cond
					((and local3 param1)
						((Print new:)
							modeless: 1
							x: (+ nsLeft 85)
							y: (+ nsTop 2)
							addText:
								(local3 value:)
								[local131 gDifficulty]
								21
								0
								0
								0
								268
							init:
						)
					)
					((IsObject gModelessDialog)
						(gModelessDialog dispose:)
					)
				)
			)
			(param1
				(DrawCel 268 5 0 36 41 -1)
			)
			(else
				(DrawCel 268 5 1 36 41 -1)
			)
		)
	)

	(method (select &tmp temp0)
		(cond
			(local2
				(DrawCel maskView maskLoop maskCel nsLeft nsTop -1)
				(moveProp hide:)
				(gGame setCursor: 900)
				(elementAnalyzer animateOnce:)
				(= view (local2 view:))
				(= loop (local2 loop:))
				(= cel (local2 cel:))
				(DrawCel view loop cel nsLeft nsTop -1)
				(= temp0 local3)
				(= local3 local2)
				(if temp0
					(temp0 show:)
				)
				(= local2 0)
				(elementAnalyzer setScript: analyzeItem 0 (local3 value:))
			)
			((not local3)
				(gMessager say: noun 4 4) ; "We're sorry, but the machine won't allow you to analyze the cursor."
			)
			(else
				(= local2 local3)
				(= local3 0)
				(= view maskView)
				(= loop maskLoop)
				(= cel maskCel)
				(DrawCel maskView maskLoop cel nsLeft nsTop -1)
				(localproc_1 1)
				(gGame setCursor: 996 1 (+ nsLeft 11) (+ nsTop 11))
				(moveProp
					loop: (local2 loop:)
					cel: (local2 cel:)
					x: (+ nsLeft 11)
					y: (+ nsTop 11)
					show:
				)
			)
		)
	)
)

(instance moveProp of Actor
	(properties
		view 269
		priority 15
		signal 27
	)

	(method (doit)
		(if local2
			(= x (+ (elementAnalyzer eventX:) 60))
			(= y (+ (elementAnalyzer eventY:) 2))
			(super doit: &rest)
		)
	)
)

(instance rayBeam of Prop
	(properties
		x 79
		y 50
		view 268
		loop 3
		priority 15
		signal 27
	)
)

