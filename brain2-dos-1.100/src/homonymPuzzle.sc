;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use IconSentence)
(use Print)
(use Window)
(use System)

(public
	homonymPuzzle 0
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
	[local8 70]
	[local78 9]
	[local87 9] = [{              0} {              1} {              2} {              3} {              4} {              5} {              6} {              7} {              8}]
	local96
	local97
	[local98 3]
	[local101 8]
	[local109 3] = [13 16 17]
	local112
	local113
	[local114 2]
)

(procedure (localproc_0 &tmp temp0 [temp1 10])
	(for
		((= temp0 0))
		(Message msgGET 262 (+ temp0 1) [local109 gDifficulty] 2 1)
		((++ temp0))
	)
	(return temp0)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0)
	(while (& (<< $0001 (= temp0 (Random param2 param3))) param1)
	)
	(return temp0)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp2 0)
	(= temp1 (mod param1 10))
	(if (not (/ param1 10))
		(+= temp1 10)
	)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(if
			(and
				[local101 temp0]
				((= temp3 [local101 temp0]) modifiers:)
				(== (temp3 value:) temp1)
				(== ((temp3 modifiers:) value:) temp1)
			)
			(= temp2 temp3)
		)
	)
	(return temp2)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1 temp2)
	(for ((= temp2 0)) (< temp2 param2) ((++ temp2))
		(= temp0 (WordAt param1 temp2))
		(if
			(or
				(not (temp0 modifiers:))
				(!= (temp0 value:) ((temp0 modifiers:) value:))
			)
			(break)
		)
	)
	(return (if (== param2 temp2) param2 else 0))
)

(procedure (localproc_4)
	(DrawCel 264 0 0 0 22 -1)
	(DrawCel 264 0 0 95 22 -1)
	(DrawCel 264 0 0 190 22 -1)
	(Graph grFILL_BOX 91 0 131 284 1 6 -1 -1)
	(Graph grUPDATE_BOX 91 0 131 284 1)
	(local5 showSentence:)
	(local6 showSentence:)
)

(instance homonymPuzzle of PuzzleBar
	(properties
		hintFlag 46
		solvedFlag 12
		noun 13
		personalID 7
	)

	(method (init)
		(= window puz2Window)
		(= local97 (localproc_0))
		(= local3
			(= local0
				(= [local98 0]
					(= [local98 1] (= [local98 2] (= local5 (= local6 0))))
				)
			)
		)
		(= local1 1)
		(self resetPuzzle:)
		(super init: &rest)
	)

	(method (resetPuzzle &tmp temp0 temp1 temp2 temp3 temp4)
		(if (IsObject local5)
			(local5 dispose:)
		)
		(if (IsObject local6)
			(local6 dispose:)
		)
		(if size
			(self eachElementDo: #dispose release:)
		)
		(= local96 (= local4 (= local2 0)))
		(for ((= temp3 (= highlightedIcon 0))) (< temp3 8) ((++ temp3))
			(= [local101 temp3] 0)
		)
		(while
			(&
				[local98 (/ (= local113 (Random 1 (- local97 1))) 16)]
				(<< $0001 (mod local113 16))
			)
		)
		(= [local98 (/ local113 16)]
			(| [local98 (/ local113 16)] (<< $0001 (mod local113 16)))
		)
		((= local5 (IconSentence new:))
			theWidth: 279
			nsLeft: 3
			nsTop: 93
			iconInstance: aWord
			lineHeight: 8
			fillColor: 6
			numberOfLines: 2
			wordsArray: @local101
			theHeight: 16
			init: 262 local113 [local109 gDifficulty] 2 0 260
		)
		((= local6 (IconSentence new:))
			theWidth: 279
			theHeight: 16
			nsLeft: 3
			iconInstance: aWord
			fillColor: 6
			numberOfLines: 2
			wordsArray: @[local101 4]
			lineHeight: 8
			nsTop: 113
			init: 262 local113 [local109 gDifficulty] 3 1 260
		)
		(= temp0 (proc15_6 262 local113 [local109 gDifficulty] 1))
		(= temp1 (= local7 (+ (local5 numWords:) (local6 numWords:))))
		(if temp0
			(++ temp1)
		)
		(= [local114 0] temp1)
		(for ((= temp3 0)) (< temp3 (local5 wordCount:)) ((++ temp3))
			(= temp2 (localproc_1 local96 0 local7))
			(|= local96 (<< $0001 temp2))
			(Message
				msgGET
				262
				local113
				[local109 gDifficulty]
				4
				(+ temp3 1)
				[local87 temp2]
			)
			(= [local78 temp2] (+ temp3 1))
		)
		(= [local114 1] (+ (local5 wordCount:) temp1))
		(for ((= temp3 0)) (< temp3 (local6 wordCount:)) ((++ temp3))
			(= temp2 (localproc_1 local96 0 local7))
			(|= local96 (<< $0001 temp2))
			(Message
				msgGET
				262
				local113
				[local109 gDifficulty]
				5
				(+ temp3 1)
				[local87 temp2]
			)
			(= [local78 temp2] (+ 11 temp3))
		)
		(if temp0
			(= temp2 (localproc_1 local96 0 local7))
			(|= local96 (<< $0001 temp2))
			(= local112 (Random 1 temp0))
			(Message
				msgGET
				262
				local113
				[local109 gDifficulty]
				1
				local112
				[local87 temp2]
			)
			(= [local78 temp2] 0)
		)
		(for ((= temp3 0)) (< temp3 temp1) ((++ temp3))
			(self
				add:
					((corn new:)
						text: [local87 temp3]
						value: [local78 temp3]
						nsTop: (+ 27 (* 22 (/ temp3 3)))
						nsLeft: (+ 3 (* 96 (mod temp3 3)))
						yourself:
					)
			)
		)
		(for ((= temp3 0)) (< temp3 8) ((++ temp3))
			(if [local101 temp3]
				(self add: [local101 temp3])
			)
		)
		(if local0
			(= temp4 (- (window right:) (window left:)))
			(self
				add:
					(ScriptID 15 1) ; puzzleCoin
					((ScriptID 15 2) nsLeft: (/ (- temp4 40) 2) yourself:) ; puzzleOK
					((ScriptID 15 3) nsLeft: (- temp4 31) yourself:) ; puzzleHelp
			)
		)
	)

	(method (dispose)
		(if (IsObject local5)
			(local5 dispose:)
		)
		(if (IsObject local6)
			(local6 dispose:)
		)
		(super dispose: &rest)
	)

	(method (animateOnce &tmp temp0)
		(if (== local0 local1)
			(++ local1)
			(Wait 0)
			(for ((= temp0 0)) (< temp0 8) ((++ temp0))
				(if [local101 temp0]
					(gCSoundFX number: 243 setLoop: 1 play:)
					([local101 temp0] textColor: 0 show:)
					(Wait 15)
				)
			)
			(if (== local0 3)
				(self solvePuzzle:)
			else
				(self resetPuzzle:)
				(localproc_4 1)
				(self eachElementDo: #show)
			)
		)
	)

	(method (buyClue &tmp temp0 temp1 [temp2 50] temp52)
		(if (super buyClue: &rest)
			(= temp52 0)
			(= temp0 (Memory memALLOC_CRIT (+ 400 (* 200 gDifficulty))))
			(StrAt temp0 0 0)
			(for ((= temp1 0)) (< temp1 local7) ((++ temp1))
				(if
					(Message
						msgGET
						263
						local113
						[local109 gDifficulty]
						1
						(+ temp1 1)
						@temp2
					)
					(StrCat temp0 @temp2)
					(StrCat temp0 {\n})
					(++ temp52)
				)
				(if (> temp52 7)
					(proc15_4 self 99 temp0)
					(StrAt temp0 0 0)
					(= temp52 0)
				)
			)
			(if
				(Message
					msgGET
					263
					local113
					[local109 gDifficulty]
					1
					(+ temp1 local112)
					@temp2
				)
				(StrCat temp0 @temp2)
				(StrCat temp0 {\n})
				(++ temp52)
			)
			(if temp52
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
						((< temp1 3)
							(+= temp1 (- size 3))
						)
						((< temp1 [local114 0])
							(-= temp1 3)
						)
						((< temp1 [local114 1])
							(= temp1 (* (/ local7 3) 3))
						)
						((< temp1 (- size 3))
							(-= temp1 (- [local114 1] [local114 0]))
						)
						(else
							(= temp1 [local114 1])
						)
					)
				)
				(JOY_DOWN
					(cond
						((< (/ temp1 3) (/ local7 3))
							(if (> (+= temp1 3) local7)
								(= temp1 local7)
							)
						)
						((< temp1 [local114 0])
							(= temp1 [local114 0])
						)
						((< temp1 [local114 1])
							(= temp1 [local114 1])
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
						((< (/ temp1 3) (/ local7 3))
							(if (not (mod (++ temp1) 3))
								(-= temp1 3)
							)
						)
						((<= temp1 local7)
							(if (> (++ temp1) local7)
								(= temp1 (* (/ local7 3) 3))
							)
						)
						((< temp1 [local114 1])
							(if (>= (++ temp1) [local114 1])
								(= temp1 [local114 0])
							)
						)
						((< temp1 (- size 3))
							(if (>= (++ temp1) (- size 3))
								(= temp1 [local114 1])
							)
						)
						((>= (++ temp1) size)
							(= temp1 (- size 3))
						)
					)
				)
				(JOY_LEFT
					(cond
						((< (/ temp1 3) (/ local7 3))
							(if (not (mod temp1 3))
								(+= temp1 2)
							else
								(-- temp1)
							)
						)
						((< temp1 [local114 0])
							(if (< (/ (-- temp1) 3) (/ local7 3))
								(= temp1 local7)
							)
						)
						((< temp1 [local114 1])
							(if (< (-- temp1) [local114 0])
								(= temp1 (- [local114 1] 1))
							)
						)
						((< temp1 (- size 3))
							(if (< (-- temp1) [local114 1])
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
		right 294
		back 27
		priority -1
	)

	(method (open &tmp [temp0 5])
		(super open: &rest)
		(localproc_4 0)
	)
)

(instance corn of TextIcon
	(properties
		view 264
		loop 1
		cursor 0
		upClick 0
	)

	(method (showText param1)
		(Display
			text
			dsCOORD
			(+ nsLeft 7)
			(+ nsTop 5)
			dsWIDTH
			53
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
					(= loop 2)
					(self show:)
				)
				((== local2 self)
					(gCSoundFX number: 242 setLoop: 1 play:)
					(= local2 0)
					(= loop (if cursor 3 else 1))
					(self show:)
				)
				(else
					(gCSoundFX number: 207 setLoop: 1 play:)
					(local2 loop: (if (local2 cursor:) 3 else 1) show:)
					(= local2 self)
					(= loop 2)
					(self show:)
				)
			)
		)
	)
)

(instance aWord of IconWord
	(properties
		view 264
		loop 4
		upClick 0
	)

	(method (select &tmp temp0 temp1 temp2)
		(cond
			((& signal $4000) 0)
			((not (or text (super select: &rest))) 0)
			((not local2)
				(gCSoundFX number: 242 setLoop: 1 play:)
			)
			((== local2 modifiers))
			(else
				(gCSoundFX number: 244 setLoop: 1 play:)
				(if text
					(modifiers cursor: (- (modifiers cursor:) 1))
					(if (not (modifiers cursor:))
						(modifiers loop: 1 show:)
					)
					(if (== (modifiers value:) value)
						(-- local4)
					)
				)
				(local2 cursor: (+ (local2 cursor:) 1) loop: 3 show:)
				(= modifiers local2)
				(= text (modifiers text:))
				(= local2 0)
				(parent showSentence:)
				(homonymPuzzle eachElementDo: #show)
				(if (== (modifiers value:) value)
					(if (and (== gDifficulty 0) (= temp0 (localproc_2 value))) ; Novice
						(Wait 0)
						(Wait 15)
						(gCSoundFX number: 247 setLoop: 1 play:)
						(self signal: (| signal $4000) textColor: 59 show:)
						(Wait 15)
						(gCSoundFX number: 247 setLoop: 1 play:)
						(temp0
							signal: (| (temp0 signal:) $4000)
							textColor: 59
							show:
						)
					)
					(if
						(and
							(< gDifficulty 2) ; Expert
							(= temp1
								(localproc_3
									(parent wordsArray:)
									(parent numWords:)
								)
							)
						)
						(Wait 0)
						(for ((= temp2 0)) (< temp2 temp1) ((++ temp2))
							(= temp0 (WordAt (parent wordsArray:) temp2))
							(Wait 15)
							(gCSoundFX number: 247 setLoop: 1 play:)
							(temp0
								signal: (| (temp0 signal:) $4000)
								textColor: 59
								show:
							)
						)
					)
					(if (>= (++ local4) local7)
						(++ local0)
					)
				)
			)
		)
	)

	(method (dispose)
		(homonymPuzzle delete: self)
		(super dispose: &rest)
	)
)

