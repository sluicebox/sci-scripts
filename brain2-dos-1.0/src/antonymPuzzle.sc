;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 275)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use IconSentence)
(use Print)
(use Window)

(public
	antonymPuzzle 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 3]
	local8
	[local9 12]
	local21
	[local22 12] = [{______________0} {______________1} {______________2} {______________3} {______________4} {______________5} {______________6} {______________7} {______________8} {______________9} {_____________10} {_____________11}]
	[local34 9] = [{_____________0} {_____________1} {_____________2} {_____________3} {_____________4} {_____________5} {_____________6} {_____________7} {_____________8}]
	local43
	local44
	[local45 3]
	[local48 3]
	[local51 9]
	[local60 3] = [13 16 19]
	local63 = 3
	[local64 11] = [4 6 8 125 133 144 152 1 0 4 3]
	[local75 3]
	local78
	[local79 3]
)

(procedure (localproc_0 &tmp temp0 [temp1 10])
	(for
		((= temp0 0))
		(Message msgGET 264 (+ temp0 1) [local60 gDifficulty] 3 1)
		((++ temp0))
	)
	(return temp0)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0)
	(while (& (<< $0001 (= temp0 (Random param2 param3))) param1)
	)
	(return temp0)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2)
	(= temp0 (* (/ (param1 value:) 10) 3))
	(for ((= temp1 0)) (< temp1 (+ gDifficulty 1)) ((++ temp1)) ; Standard
		(= temp2 [local51 temp0])
		(++ temp0)
		(if
			(or
				(not (temp2 modifiers:))
				(!= (temp2 value:) ((temp2 modifiers:) value:))
			)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_3 param1)
	(if param1
		(Graph grFILL_BOX 45 2 125 268 1 27 -1 -1)
		(Graph grUPDATE_BOX 45 2 125 268 1)
	)
	(DrawCel 266 1 0 0 44 -1)
	(DrawCel 266 2 0 135 44 -1)
	(Graph grFILL_BOX 123 0 177 270 1 6 -1 -1)
	(Graph grUPDATE_BOX 123 0 177 270 1)
	(local5 showSentence:)
	([local5 1] showSentence:)
	([local5 2] showSentence:)
)

(instance antonymPuzzle of PuzzleBar
	(properties
		hintFlag 48
		solvedFlag 13
		noun 15
		personalID 6
	)

	(method (init)
		(= window puz2Window)
		(= local44 (localproc_0))
		(= local3
			(= local0
				(= [local45 0]
					(= [local45 1]
						(= [local45 2]
							(= [local5 0] (= [local5 1] (= [local5 2] 0)))
						)
					)
				)
			)
		)
		(= local1 3)
		(self resetPuzzle:)
		(super init: &rest)
	)

	(method (resetPuzzle &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(if (IsObject local5)
			(local5 dispose:)
			([local5 1] dispose:)
			([local5 2] dispose:)
		)
		(if size
			(self eachElementDo: #dispose release:)
		)
		(= local43 (= local4 (= local2 0)))
		(for ((= temp3 (= highlightedIcon 0))) (< temp3 9) ((++ temp3))
			(= [local51 temp3] 0)
		)
		(for ((= temp3 0)) (< temp3 3) ((++ temp3))
			(while
				(&
					[local45 (/ (= temp0 (Random 1 local44)) 16)]
					(<< $0001 (mod temp0 16))
				)
			)
			(|= [local45 (/ temp0 16)] (<< $0001 (mod temp0 16)))
			(= [local48 temp3] temp0)
			(= [local5 temp3]
				((IconSentence new:)
					theWidth: 266
					nsLeft: 3
					nsTop: (+ 125 (* 17 temp3))
					iconInstance: aWord
					lineHeight: 8
					fillColor: 6
					wordsArray: @[local51 (* temp3 3)]
					theHeight: 17
					numberOfLines: 2
					init: 264 temp0 [local60 gDifficulty] 3 temp3 260
					yourself:
				)
			)
		)
		(= [local79 0]
			(+
				(= local78
					(- (= temp1 (+ (= local8 (* 3 (+ gDifficulty 1))) local63)) 1) ; Standard
				)
				1
			)
		)
		(= [local79 1] (+ [local79 0] gDifficulty 1)) ; Standard
		(= [local79 2] (+ [local79 1] gDifficulty 1)) ; Standard
		(for ((= temp4 0)) (< temp4 3) ((++ temp4))
			(= temp0 [local48 temp4])
			(for ((= temp3 0)) (< temp3 (+ 1 gDifficulty)) ((++ temp3)) ; Standard
				(= temp2 (localproc_1 local43 0 (- temp1 1)))
				(|= local43 (<< $0001 temp2))
				(if
					(not
						(Message
							msgGET
							264
							temp0
							[local60 gDifficulty]
							4
							(+ temp3 1)
							[local22 temp2]
						)
					)
					(Printf
						{can't find good words** theSet: %d theWord: %d}
						temp0
						temp3
					)
				)
				(= [local9 temp2] (+ temp3 1 (* temp4 10)))
			)
		)
		(for ((= temp3 0)) (< temp3 3) ((++ temp3))
			(= temp0 [local48 temp3])
			(= temp5 (proc15_6 264 temp0 [local60 gDifficulty] 2))
			(= [local75 temp3] (Random 1 temp5))
			(= temp2 (localproc_1 local43 0 (- temp1 1)))
			(|= local43 (<< $0001 temp2))
			(if
				(not
					(Message
						msgGET
						264
						temp0
						[local60 gDifficulty]
						2
						[local75 temp3]
						[local22 temp2]
					)
				)
				(Printf
					{Can't find red herrings** theSet: %d theHerring: %d}
					temp0
					[local75 temp3]
				)
			)
			(= [local9 temp2] 0)
		)
		(for ((= temp3 0)) (< temp3 temp1) ((++ temp3))
			(self
				add:
					((ant new:)
						text: [local22 temp3]
						loop: (- 4 (mod (/ temp3 4) 2))
						value: [local9 temp3]
						nsTop: (+ 46 (* 26 (/ temp3 4)))
						nsLeft: (+ 8 (* 64 (mod temp3 4)))
						yourself:
					)
			)
		)
		(= local21 size)
		(for ((= temp3 0)) (< temp3 9) ((++ temp3))
			(if [local51 temp3]
				(self add: ([local51 temp3] init: temp3 yourself:))
			)
		)
		(if local0
			(= temp6 (- (window right:) (window left:)))
			(self
				add:
					(ScriptID 15 1) ; puzzleCoin
					((ScriptID 15 2) nsLeft: (/ (- temp6 40) 2) yourself:) ; puzzleOK
					((ScriptID 15 3) nsLeft: (- temp6 31) yourself:) ; puzzleHelp
			)
		)
	)

	(method (dispose)
		(if (IsObject local5)
			(local5 dispose:)
			([local5 1] dispose:)
			([local5 2] dispose:)
		)
		(super dispose: &rest)
	)

	(method (animateOnce &tmp temp0)
		(if (== local0 local1)
			(+= local1 3)
			(Wait 0)
			(for ((= temp0 0)) (< temp0 9) ((++ temp0))
				(if [local51 temp0]
					(gCSoundFX number: 243 setLoop: 1 play:)
					([local51 temp0] textColor: 0 show:)
					(Wait 15)
				)
			)
			(if (== local0 6)
				(self solvePuzzle:)
			else
				(self resetPuzzle:)
				(localproc_3 1)
				(self eachElementDo: #show)
			)
		)
	)

	(method (buyClue &tmp temp0 temp1 temp2 [temp3 50] temp53 temp54 temp55 temp56)
		(if (super buyClue: &rest)
			(= temp56 0)
			(= temp0 (Memory memALLOC_CRIT (+ 400 (* 200 gDifficulty))))
			(StrAt temp0 0 0)
			(= temp55 (* 2 (+ gDifficulty 1))) ; Standard
			(= temp54 [local60 gDifficulty])
			(for ((= temp1 0)) (< temp1 3) ((++ temp1))
				(for ((= temp2 0)) (< temp2 temp55) ((++ temp2))
					(if
						(Message
							msgGET
							265
							[local48 temp1]
							temp54
							1
							(+ temp2 1)
							@temp3
						)
						(StrCat temp0 @temp3)
						(StrCat temp0 {\n})
						(++ temp56)
					)
					(if (> temp56 7)
						(proc15_4 self 99 temp0)
						(StrAt temp0 0 0)
						(= temp56 0)
					)
				)
			)
			(for ((= temp1 0)) (< temp1 3) ((++ temp1))
				(= temp53 (+ temp55 [local75 temp1]))
				(if
					(Message
						msgGET
						265
						[local48 temp1]
						[local60 gDifficulty]
						1
						temp53
						@temp3
					)
					(StrCat temp0 @temp3)
					(StrCat temp0 {\n})
					(++ temp56)
				)
				(if (> temp56 7)
					(proc15_4 self 99 temp0)
					(StrAt temp0 0 0)
					(= temp56 0)
				)
			)
			(if temp56
				(Prints temp0)
			)
			(Memory memFREE temp0)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
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
						((< temp1 4)
							(+= temp1 (- size 3))
						)
						((< temp1 [local79 0])
							(-= temp1 4)
						)
						((< temp1 [local79 1])
							(= temp1 (* (/ local78 4) 4))
						)
						((< temp1 [local79 2])
							(-= temp1 (- [local79 1] [local79 0]))
						)
						((< temp1 (- size 3))
							(-= temp1 (- [local79 2] [local79 1]))
						)
						(else
							(= temp1 [local79 2])
						)
					)
				)
				(JOY_DOWN
					(cond
						((< (/ temp1 4) (/ local78 4))
							(if (> (+= temp1 4) local78)
								(= temp1 local78)
							)
						)
						((< temp1 [local79 0])
							(= temp1 [local79 0])
						)
						((< temp1 [local79 1])
							(= temp1 [local79 1])
						)
						((< temp1 [local79 2])
							(= temp1 [local79 2])
						)
						((< temp1 (- size 3))
							(= temp1 (- size 2))
						)
						(else
							(-= temp1 (- size 3))
						)
					)
				)
				(JOY_RIGHT
					(cond
						((< (/ temp1 4) (/ local78 4))
							(if (not (mod (++ temp1) 4))
								(-= temp1 4)
							)
						)
						((<= temp1 local78)
							(if (> (++ temp1) local78)
								(= temp1 (* (/ local78 4) 4))
							)
						)
						((< temp1 [local79 1])
							(if (>= (++ temp1) [local79 1])
								(= temp1 [local79 0])
							)
						)
						((< temp1 [local79 2])
							(if (>= (++ temp1) [local79 2])
								(= temp1 [local79 1])
							)
						)
						((< temp1 (- size 3))
							(if (>= (++ temp1) (- size 3))
								(= temp1 [local79 2])
							)
						)
						((>= (++ temp1) size)
							(= temp1 (- size 3))
						)
					)
				)
				(JOY_LEFT
					(cond
						((< (/ temp1 4) (/ local78 4))
							(if (not (mod temp1 4))
								(+= temp1 3)
							else
								(-- temp1)
							)
						)
						((< temp1 [local79 0])
							(if (< (/ (-- temp1) 4) (/ local78 3))
								(= temp1 local78)
							)
						)
						((< temp1 [local79 1])
							(if (< (-- temp1) [local79 0])
								(= temp1 (- [local79 1] 1))
							)
						)
						((< temp1 [local79 2])
							(if (< (-- temp1) [local79 1])
								(= temp1 (- [local79 2] 1))
							)
						)
						((< temp1 (- size 3))
							(if (< (-- temp1) [local79 2])
								(= temp1 (- size 4))
							)
						)
						((< (-- temp1) (- size 3))
							(= temp1 (- size 1))
						)
					)
				)
			)
			(= temp0 (self at: temp1))
			(proc5_9 temp0)
			(self highlight: temp0)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)
)

(instance puz2Window of SysWindow
	(properties
		top 10
		left 25
		bottom 189
		right 295
		back 27
		priority -1
	)

	(method (open &tmp [temp0 5])
		(super open: &rest)
		(DrawCel 266 0 0 0 21 -1)
		(localproc_3 0)
	)
)

(instance ant of TextIcon
	(properties
		view 266
		loop 1
		cursor 0
	)

	(method (showText param1)
		(Display
			text
			dsCOORD
			(+ nsLeft 3)
			(+ nsTop 2)
			dsWIDTH
			61
			dsFONT
			260
			dsALIGN
			alCENTER
			dsCOLOR
			param1
		)
	)

	(method (select)
		(if (super select: &rest)
			(cond
				((not local2)
					(gCSoundFX number: 207 setLoop: 1 play:)
					(= local2 self)
					(= loop (- 6 (mod loop 2)))
					(self show:)
				)
				((== local2 self)
					(gCSoundFX number: 242 setLoop: 1 play:)
					(= local2 0)
					(= loop (- (if cursor 8 else 4) (mod loop 2)))
					(self show:)
				)
				(else
					(gCSoundFX number: 207 setLoop: 1 play:)
					(local2
						loop:
							(-
								(if (local2 cursor:) 8 else 4)
								(mod (local2 loop:) 2)
							)
						show:
					)
					(= local2 self)
					(= loop (- 6 (mod loop 2)))
					(self show:)
				)
			)
		)
	)
)

(instance aWord of IconWord
	(properties
		view 266
		loop 2
		cursor 0
		downClick 0
		upClickOff 0
	)

	(method (init param1 &tmp temp0)
		(= text (= cursor [local34 param1]))
		(= temp0 [local48 (/ value 10)])
		(if
			(not
				(Message
					msgGET
					264
					temp0
					[local60 gDifficulty]
					1
					(+ (mod param1 3) 1)
					text
				)
			)
			(Printf
				{Can't find sentence word** theSet: %d number: %d}
				temp0
				(+ (mod param1 3) 1)
			)
		)
	)

	(method (select &tmp temp0 temp1 temp2)
		(cond
			((& signal $4000) 0)
			((not (or text (super select: &rest))) 0)
			((not local2)
				(gCSoundFX number: 242 setLoop: 1 play:)
			)
			((== local2 modifiers) 0)
			(else
				(gCSoundFX number: 245 setLoop: 1 play:)
				(if modifiers
					(modifiers cursor: (- (modifiers cursor:) 1))
					(if (not (modifiers cursor:))
						(modifiers loop: (- 4 (mod (modifiers loop:) 2)) show:)
					)
					(if (== (modifiers value:) value)
						(-- local4)
					)
				)
				(local2
					cursor: (+ (local2 cursor:) 1)
					loop: (- 8 (mod (local2 loop:) 2))
					show:
				)
				(= modifiers local2)
				(= text (modifiers text:))
				(= textColor 35)
				(parent showSentence:)
				(antonymPuzzle eachElementDo: #show)
				(if (== (modifiers value:) value)
					(if (and (< gDifficulty 2) (localproc_2 self)) ; Expert
						(= temp0 (* (/ value 10) 3))
						(Wait 0)
						(for
							((= temp1 0))
							(< temp1 (+ gDifficulty 1)) ; Standard
							((++ temp1))
							
							(gCSoundFX number: 247 setLoop: 1 play:)
							(= temp2 [local51 temp0])
							(temp2
								signal: (| (temp2 signal:) $4000)
								textColor: 61
								show:
							)
							(Wait 20)
							(++ temp0)
						)
					)
					(if (>= (++ local4) local8)
						(+= local0 3)
					)
				)
			)
		)
	)

	(method (dispose)
		(antonymPuzzle delete: self)
		(super dispose: &rest)
	)

	(method (highlight param1)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(return
			(if (& signal $4000)
				0
			else
				(super highlight: param1 &rest)
				(if (and modifiers param1)
					((Print new:)
						modeless: 1
						x: 35
						y: 32
						addTextF: {Was: %s} cursor
						init:
					)
				)
			)
		)
	)
)

