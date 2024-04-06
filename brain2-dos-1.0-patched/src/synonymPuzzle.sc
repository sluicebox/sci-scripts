;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 265)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use IconSentence)
(use Print)
(use Window)

(public
	synonymPuzzle 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4]
	local9
	[local10 9]
	local19
	[local20 9] = [{              0} {              1} {              2} {              3} {              4} {              5} {              6} {              7} {              8}]
	[local29 8] = [{             0} {             1} {             2} {             3} {             4} {             5} {             6} {             7}]
	local37
	local38
	[local39 3]
	[local42 4]
	[local46 8]
	[local54 3] = [13 14 15]
	[local57 2] = [1 2]
	[local59 4] = [4 5 6 7]
	[local63 3] = [2 1 1]
	[local66 3] = [4 6 8]
	[local69 4] = [94 102 113 121]
	[local73 4] = [1 0 3 2]
	local77
	[local78 2]
	[local80 2]
	[local82 2]
)

(procedure (localproc_0 &tmp temp0 [temp1 10])
	(for
		((= temp0 0))
		(Message msgGET 266 (+ temp0 1) [local54 gDifficulty] 1 1)
		((++ temp0))
	)
	(return temp0)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0)
	(while (& (<< $0001 (= temp0 (Random param2 param3))) param1)
	)
	(return temp0)
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(= temp0 (- (synonymPuzzle indexOf: param1) local19))
	(= temp1 (synonymPuzzle at: (+ local19 [local73 temp0])))
	(return
		(if
			(and
				(temp1 modifiers:)
				(== (temp1 value:) ((temp1 modifiers:) value:))
			)
			temp1
		else
			0
		)
	)
)

(procedure (localproc_3)
	(DrawCel 262 0 0 0 21 -1)
	(DrawCel 262 0 0 94 21 -1)
	(DrawCel 262 0 0 188 21 -1)
	(Graph grDRAW_LINE 21 0 21 280 11 -1 -1)
	(Graph grDRAW_LINE 21 0 91 0 11 -1 -1)
	(Graph grDRAW_LINE 91 0 91 280 11 -1 -1)
	(Graph grDRAW_LINE 21 279 91 279 11 -1 -1)
	(Graph grFILL_BOX 92 0 133 280 1 6 -1 -1)
	(Graph grUPDATE_BOX 0 0 133 280 1)
	(local5 showSentence:)
	([local5 1] showSentence:)
	([local5 2] showSentence:)
	([local5 3] showSentence:)
)

(instance synonymPuzzle of PuzzleBar
	(properties
		hintFlag 47
		solvedFlag 11
		noun 12
		msgModule 260
		personalID 5
	)

	(method (init)
		(= window puz2Window)
		(= local3
			(= local0
				(= [local39 0]
					(= [local39 1]
						(= [local39 2]
							(= [local5 0]
								(= [local5 1] (= [local5 2] (= [local5 3] 0)))
							)
						)
					)
				)
			)
		)
		(= local1 2)
		(= local38 (localproc_0))
		(self resetPuzzle:)
		(super init: &rest)
	)

	(method (resetPuzzle &tmp temp0 temp1 temp2 temp3 [temp4 2] temp6 temp7 temp8 temp9 temp10 temp11)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(if (and local5 (IsObject local5))
			(local5 dispose:)
			([local5 1] dispose:)
			([local5 2] dispose:)
			([local5 3] dispose:)
		)
		(if size
			(self eachElementDo: #dispose release:)
		)
		(= local37 (= local4 (= local2 0)))
		(for ((= temp3 (= highlightedIcon 0))) (< temp3 8) ((++ temp3))
			(= [local46 temp3] 0)
		)
		(for ((= temp3 0)) (< temp3 2) ((++ temp3))
			(while
				(&
					[local39 (/ (= temp0 (Random 1 (- local38 1))) 16)]
					(<< $0001 (mod temp0 16))
				)
			)
			(|= [local39 (/ temp0 16)] (<< $0001 (mod temp0 16)))
			(= [local42 temp3] temp0)
			(for ((= temp6 0)) (< temp6 2) ((++ temp6))
				(= temp11 (+ (* temp3 2) temp6))
				(= [local5 temp11]
					((IconSentence new:)
						theWidth: 277
						nsLeft: 2
						nsTop: [local69 temp11]
						iconInstance: aWord
						lineHeight: 8
						fillColor: 6
						numberOfLines: 1
						wordsArray: @[local46 (* temp11 2)]
						theHeight: 8
						init:
							266
							temp0
							[local54 gDifficulty]
							[local57 (mod temp11 2)]
							(/ temp11 2)
							260
						yourself:
					)
				)
			)
		)
		(= [local80 0]
			(+
				(= local77
					(-
						(= temp1
							(+
								(= local9 [local66 gDifficulty])
								[local63 gDifficulty]
							)
						)
						1
					)
				)
				1
			)
		)
		(= [local80 1] (+ [local80 0] 2 gDifficulty)) ; Expert
		(for ((= temp6 0)) (< temp6 2) ((++ temp6))
			(= temp0 [local42 temp6])
			(for ((= temp3 0)) (< temp3 (+ 2 gDifficulty)) ((++ temp3)) ; Expert
				(= temp2 (localproc_1 local37 0 (- temp1 1)))
				(|= local37 (<< $0001 temp2))
				(if
					(not
						(Message
							msgGET
							266
							temp0
							[local54 gDifficulty]
							[local59 temp3]
							2
							[local20 temp2]
						)
					)
					(Printf {theSet: %d theWord: %d} temp0 [local59 temp3])
				)
				(= [local10 temp2] (+ temp3 1 (* temp6 10)))
			)
		)
		(= [local82 0] (proc15_6 266 [local42 0] [local54 gDifficulty] 3))
		(= [local82 1] (proc15_6 266 [local42 1] [local54 gDifficulty] 3))
		(= temp7 (+ [local82 0] [local82 1]))
		(= temp8 0)
		(for ((= temp3 0)) (< temp3 [local63 gDifficulty]) ((++ temp3))
			(= temp9 (localproc_1 temp8 1 temp7))
			(|= temp8 (<< $0001 temp9))
			(if (<= temp9 [local82 0])
				(= temp6 0)
				(= [local78 temp3] temp9)
			else
				(= temp6 1)
				(= [local78 temp3] (+ (-= temp9 [local82 0]) 100))
			)
			(= temp2 (localproc_1 local37 0 (- temp1 1)))
			(|= local37 (<< $0001 temp2))
			(= temp0 [local42 temp6])
			(if
				(not
					(Message
						msgGET
						266
						temp0
						[local54 gDifficulty]
						3
						temp9
						[local20 temp2]
					)
				)
				(Printf {theSet: %d availHerring: %d} temp0 temp9)
			)
			(= [local10 temp2] 0)
		)
		(for ((= temp3 0)) (< temp3 temp1) ((++ temp3))
			(self
				add:
					((apple new:)
						text: [local20 temp3]
						value: [local10 temp3]
						nsTop: (+ 25 (* 22 (/ temp3 3)))
						nsLeft: (+ 3 (* 92 (mod temp3 3)))
						yourself:
					)
			)
		)
		(= local19 size)
		(= temp6 0)
		(for ((= temp3 0)) (< temp3 8) ((++ temp3))
			(if [local46 temp3]
				(self add: ([local46 temp3] init: temp6 yourself:))
				(++ temp6)
			)
		)
		(if local0
			(= temp10 (- (window right:) (window left:)))
			(self
				add:
					(ScriptID 15 1) ; puzzleCoin
					((ScriptID 15 2) nsLeft: (/ (- temp10 40) 2) yourself:) ; puzzleOK
					((ScriptID 15 3) nsLeft: (- temp10 31) yourself:) ; puzzleHelp
			)
		)
	)

	(method (dispose)
		(if (IsObject local5)
			(local5 dispose:)
			([local5 1] dispose:)
			([local5 2] dispose:)
			([local5 3] dispose:)
		)
		(super dispose: &rest)
	)

	(method (animateOnce &tmp temp0)
		(if (== local0 local1)
			(+= local1 2)
			(Wait 0)
			(Wait 15)
			(for ((= temp0 0)) (< temp0 8) ((++ temp0))
				(if [local46 temp0]
					(gCSoundFX number: 243 setLoop: 1 play:)
					([local46 temp0] textColor: 0 show:)
					(Wait 15)
				)
			)
			(if (== local0 6)
				(self solvePuzzle:)
			else
				(self resetPuzzle:)
				(localproc_3)
				(self eachElementDo: #show)
			)
		)
	)

	(method (buyClue &tmp temp0 temp1 [temp2 50] temp52 temp53 temp54 temp55 temp56)
		(if (super buyClue: &rest)
			(= temp56 0)
			(= temp1 (Memory memALLOC_CRIT (+ 400 (* 200 gDifficulty))))
			(StrAt temp1 0 0)
			(for ((= temp0 0)) (< temp0 2) ((++ temp0))
				(for ((= temp55 0)) (< temp55 4) ((++ temp55))
					(if
						(Message
							msgGET
							267
							[local42 temp0]
							[local54 gDifficulty]
							1
							(+ temp55 1)
							@temp2
						)
						(StrCat temp1 @temp2)
						(StrCat temp1 {\n})
						(++ temp56)
					)
				)
			)
			(if (> temp56 7)
				(proc15_4 self 99 temp1)
				(StrAt temp1 0 0)
				(= temp56 0)
			)
			(for ((= temp0 0)) (< temp0 [local63 gDifficulty]) ((++ temp0))
				(if (/ [local78 temp0] 100)
					(= temp52 1)
					(= temp53 (- [local78 temp0] 100))
				else
					(= temp52 0)
					(= temp53 [local78 temp0])
				)
				(if
					(Message
						msgGET
						267
						[local42 temp52]
						[local54 gDifficulty]
						1
						(+ 4 temp53)
						@temp2
					)
					(StrCat temp1 @temp2)
					(StrCat temp1 {\n})
					(++ temp56)
				)
				(if (> temp56 7)
					(proc15_4 self 99 temp1)
					(StrAt temp1 0 0)
					(= temp56 0)
				)
			)
			(if gDifficulty
				(for ((= temp0 0)) (< temp0 2) ((++ temp0))
					(= temp55 0)
					(for
						((= temp53 (+ 5 [local82 temp0])))
						(< temp55 (* gDifficulty 2))
						((++ temp53))
						
						(if
							(Message
								msgGET
								267
								[local42 temp0]
								[local54 gDifficulty]
								1
								temp53
								@temp2
							)
							(StrCat temp1 @temp2)
							(StrCat temp1 {\n})
							(++ temp56)
						)
						(if (> temp56 7)
							(proc15_4 self 99 temp1)
							(StrAt temp1 0 0)
							(= temp56 0)
						)
						(++ temp55)
					)
				)
			)
			(if temp56
				(Prints temp1)
			)
			(Memory memFREE temp1)
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
						((< temp1 3)
							(+= temp1 (- size 3))
						)
						((< temp1 [local80 0])
							(-= temp1 3)
						)
						((< temp1 [local80 1])
							(= temp1 (* (/ local77 3) 3))
						)
						((< temp1 (- size 3))
							(-= temp1 (- [local80 1] [local80 0]))
						)
						(else
							(= temp1 [local80 1])
						)
					)
				)
				(JOY_DOWN
					(cond
						((< (/ temp1 3) (/ local77 3))
							(if (> (+= temp1 3) local77)
								(= temp1 local77)
							)
						)
						((< temp1 [local80 0])
							(= temp1 [local80 0])
						)
						((< temp1 [local80 1])
							(= temp1 [local80 1])
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
						((< (/ temp1 3) (/ local77 3))
							(if (not (mod (++ temp1) 3))
								(-= temp1 3)
							)
						)
						((<= temp1 local77)
							(if (> (++ temp1) local77)
								(= temp1 (* (/ local77 3) 3))
							)
						)
						((< temp1 [local80 1])
							(if (>= (++ temp1) [local80 1])
								(= temp1 [local80 0])
							)
						)
						((< temp1 (- size 3))
							(if (>= (++ temp1) (- size 3))
								(= temp1 [local80 1])
							)
						)
						((>= (++ temp1) size)
							(= temp1 (- size 3))
						)
					)
				)
				(JOY_LEFT
					(cond
						((< (/ temp1 3) (/ local77 3))
							(if (not (mod temp1 3))
								(+= temp1 2)
							else
								(-- temp1)
							)
						)
						((< temp1 [local80 0])
							(if (< (/ (-- temp1) 3) (/ local77 3))
								(= temp1 local77)
							)
						)
						((< temp1 [local80 1])
							(if (< (-- temp1) [local80 0])
								(= temp1 (- [local80 1] 1))
							)
						)
						((< temp1 (- size 3))
							(if (< (-- temp1) [local80 1])
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
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)
)

(instance puz2Window of SysWindow
	(properties
		top 20
		left 10
		bottom 153
		right 290
		back 36
		priority -1
	)

	(method (open &tmp [temp0 5])
		(super open: &rest)
		(localproc_3)
	)
)

(instance apple of TextIcon
	(properties
		view 262
		loop 1
		cursor 0
	)

	(method (showText param1)
		(Display
			text
			dsCOORD
			(+ nsLeft 5)
			(+ nsTop 6)
			dsWIDTH
			81
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
			(= cel 2)
			(cond
				((not local2)
					(gCSoundFX number: 207 setLoop: 1 play:)
					(= local2 self)
					(= loop 3)
					(self show:)
				)
				((== local2 self)
					(gCSoundFX number: 242 setLoop: 1 play:)
					(= local2 0)
					(= loop (if cursor 4 else 1))
					(self show:)
				)
				(else
					(gCSoundFX number: 207 setLoop: 1 play:)
					(local2 loop: (if (local2 cursor:) 4 else 1) show:)
					(= local2 self)
					(= loop 3)
					(self show:)
				)
			)
		)
	)
)

(instance aWord of IconWord
	(properties
		view 262
		loop 2
		cursor 0
	)

	(method (init param1 &tmp temp0 temp1)
		(= text (= cursor [local29 param1]))
		(= temp0 [local42 (/ value 10)])
		(= temp1 [local59 (- (mod value 10) 1)])
		(if (not (Message msgGET 266 temp0 [local54 gDifficulty] temp1 1 text))
			(Printf {theSet: %d theword: %d} temp0 temp1)
		)
	)

	(method (select &tmp temp0 temp1)
		(cond
			((& signal $4000) 0)
			((not (or text (super select: &rest))) 0)
			((not local2)
				(gCSoundFX number: 242 setLoop: 1 play:)
			)
			((== local2 modifiers) 0)
			(else
				(gCSoundFX number: 248 setLoop: 1 play:)
				(if modifiers
					(modifiers cursor: (- (modifiers cursor:) 1))
					(if (not (modifiers cursor:))
						(modifiers loop: 1 show:)
					)
					(if (== (modifiers value:) value)
						(-- local4)
					)
				)
				(local2 cursor: (+ (local2 cursor:) 1) loop: 4 show:)
				(= modifiers local2)
				(= text (modifiers text:))
				(= local2 0)
				(= textColor 35)
				(parent showSentence:)
				(synonymPuzzle eachElementDo: #show)
				(if (== (modifiers value:) value)
					(if (and (== gDifficulty 0) (= temp0 (localproc_2 self))) ; Novice
						(Wait 0)
						(Wait 15)
						(gCSoundFX number: 247 setLoop: 1 play:)
						(self signal: (| signal $4000) textColor: 61 show:)
						(Wait 20)
						(gCSoundFX number: 247 setLoop: 1 play:)
						(temp0
							signal: (| (temp0 signal:) $4000)
							textColor: 61
							show:
						)
					)
					(if (>= (++ local4) local9)
						(+= local0 2)
					)
				)
			)
		)
	)

	(method (dispose)
		(synonymPuzzle delete: self)
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
						x: 40
						y: 20
						addTextF: {was: %s} cursor
						init:
					)
				)
			)
		)
	)
)

