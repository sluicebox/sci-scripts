;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 285)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use LoadMany)
(use Window)
(use Actor)
(use System)

(public
	bookCase 0
)

(local
	local0 = 3
	local1
	local2
	local3
	local4 = 13
	[local5 15]
	[local20 3]
	[local23 6]
	[local29 3]
	local32
	local33
	local34
	[local35 27]
	[local62 20]
	[local82 3] = [281 282 283]
	local85
	[local86 10]
	[local96 10]
	[local106 150]
	[local256 3] = [33 85 137]
	[local259 3] = [76 128 180]
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1)
	(while (& (<< $0001 (= temp0 (Random param2 param3))) param1)
	)
	(return temp0)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 [temp3 30])
	(= local85 (= temp1 0))
	(= temp0 [local82 gDifficulty])
	(while (Message msgGET temp0 (+ local85 2) 7 0 1 @temp3)
		(= [local96 local85] temp1)
		(++ local85)
		(for
			((= temp2 1))
			(Message msgGET temp0 (+ local85 1) 7 0 temp2 @temp3)
			((++ temp2))
			
			(= [local106 temp1] (ReadNumber @temp3))
			(++ temp1)
		)
		(= [local86 (- local85 1)] (- temp2 1))
	)
)

(instance bookCase of PuzzleBar
	(properties
		solvedFlag 10
		noun 13
		msgModule 280
		personalID 9
	)

	(method (init &tmp temp0)
		(localproc_1)
		(= local32 (= local34 (= local2 0)))
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [local23 temp0] 0)
		)
		(switch gDifficulty
			(0 ; Novice
				(= local1 9)
				(= local0 3)
			)
			(1 ; Standard
				(= local1 12)
				(= local0 2)
			)
			(2 ; Expert
				(= local1 15)
				(= local0 2)
			)
		)
		(= window puz2Window)
		(= local3 (Random 0 (- local85 1)))
		(bookCase showCast: 0)
		(= puzzleCast (Set new:))
		(puzzleCast add: bookProp)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(self add: ((= [local20 temp0] (shelf new:)) init: temp0 yourself:))
		)
		(for ((= temp0 0)) (< temp0 local1) ((++ temp0))
			(self
				addToFront:
					((= [local5 temp0] (book new:))
						cel: 2
						init: temp0
						yourself:
					)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(if (not (bookCase showCast:))
			(bookProp hide:)
		else
			(gGame setCursor: 996)
		)
		(super doit: &rest)
		(gGame setCursor: 900)
	)

	(method (solvePuzzle &tmp temp0)
		(Wait 0)
		(= puzzleStatus 1)
		(for ((= temp0 (- local1 1))) (>= temp0 0) ((-- temp0))
			(gCSoundFX number: 248 setLoop: 1 play:)
			((self at: temp0) highlight: 0)
			(Wait 10)
		)
		(super solvePuzzle: &rest)
	)

	(method (show)
		(= local33 0)
		(= local4 0)
		(LoadMany rsSOUND 104 144 207 236 243 248 249)
		(super show: &rest)
	)

	(method (showHelp)
		(super showHelp: &rest)
		(Say self (+ local3 2) 1 0 1 0 [local82 gDifficulty])
	)

	(method (hide)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super hide: &rest)
	)

	(method (buyClue &tmp temp0 temp1 temp2 [temp3 20] [temp23 30])
		(if (super buyClue: &rest)
			(if showCast
				(= temp1 showCast)
			else
				(for ((= temp0 0)) (< temp0 local1) ((++ temp0))
					(= temp1 [local5 temp0])
					(if (!= (temp1 value:) (temp1 cursor:))
						(break)
					)
				)
			)
			(= temp2 [local20 (temp1 value:)])
			(Message
				msgGET
				[local82 gDifficulty]
				1
				4
				(temp1 message:)
				(temp1 modifiers:)
				@temp3
			)
			(Message msgGET [local82 gDifficulty] 1 1 (temp2 message:) 1 @local62)
			(Message msgGET msgModule 13 4 7 1 @temp23)
			(Printf @temp23 @temp3 @local62)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(cond
			((not showCast) 0)
			((< eventY 21)
				(gGame setCursor: 900)
				(bookProp hide:)
			)
			(else
				(gGame setCursor: 996)
				(bookProp show:)
			)
		)
		(if (& (event type:) $0040) ; direction
			(= temp0 (/ local4 10))
			(= temp1 (mod local4 10))
			(= temp5
				(if highlightedIcon
					(self indexOf: highlightedIcon)
				else
					0
				)
			)
			(switch (event message:)
				(JOY_UP
					(cond
						((> temp5 (- size 4))
							(= local4 24)
							(= temp5 0)
						)
						((== temp0 0)
							(= temp5 (- size 2))
						)
						((= temp5 0))
						(else
							(-= local4 10)
						)
					)
				)
				(JOY_DOWN
					(cond
						((> temp5 (- size 4))
							(= local4 4)
							(= temp5 0)
						)
						((= temp5 0))
						((< temp0 2)
							(+= local4 10)
						)
						(else
							(= temp5 (- size 2))
						)
					)
				)
				(JOY_RIGHT
					(cond
						((> temp5 (- size 4))
							(if (>= (++ temp5) size)
								(= temp5 (- size 3))
							)
						)
						((= temp5 0))
						(else
							(= local4 (+ (* temp0 10) (mod (++ temp1) 8)))
						)
					)
				)
				(JOY_LEFT
					(cond
						((> temp5 (- size 4))
							(if (< (-- temp5) (- size 3))
								(= temp5 (- size 1))
							)
						)
						((= temp5 0))
						(else
							(= local4 (+ (* temp0 10) (mod (+ temp1 7) 8)))
						)
					)
				)
			)
			(if temp5
				(= temp4 (self at: temp5))
				(proc5_9 temp4)
			else
				(= temp2 (+ 16 (* 16 (mod local4 10))))
				(= temp3 (+ 54 (* (/ local4 10) 52)))
				(gGame setCursor: gTheCursor 1 temp2 temp3)
			)
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
		left 60
		bottom 189
		right 204
	)

	(method (open)
		(super open: &rest)
		(DrawCel 286 0 0 0 21 15)
	)
)

(instance book of CodeIcon
	(properties
		view 286
		loop 1
		cursor 0
		message 0
		noun 16
	)

	(method (init param1 &tmp temp0 temp1)
		(= value (/ param1 (/ local1 3)))
		(= message ([local20 value] message:))
		(while
			(&
				(<< $0001 (mod (= modifiers (Random 1 [local29 value])) 16))
				[local23 (+ (* value 2) (/ modifiers 16))]
			)
		)
		(|=
			[local23 (+ (* value 2) (/ modifiers 16))]
			(<< $0001 (mod modifiers 16))
		)
		(= temp0 1)
		(while temp0
			(if
				(not
					(&
						[local35 (/ (= temp1 (mod (Random 0 480) 24)) 8)]
						(<< $0001 (mod temp1 8))
					)
				)
				(|= [local35 (/ temp1 8)] (<< $0001 (mod temp1 8)))
				(= nsTop [local256 (/ temp1 8)])
				(= nsLeft (+ 8 (* 16 (mod temp1 8))))
				(= nsBottom (+ nsTop 41))
				(= nsRight (+ nsLeft 16))
				(= temp0 0)
				(= cursor (/ temp1 8))
				(if (== cursor value)
					(++ local2)
				)
			)
		)
		(= loop (localproc_0 local34 1 15))
		(|= local34 (<< $0001 loop))
	)

	(method (select &tmp temp0)
		(cond
			((bookCase showCast:)
				(gCSoundFX number: 249 setLoop: 1 play:)
			)
			((== (bookCase puzzleStatus:) 1)
				(gMessager say: noun 4 6 0) ; "Now that you've solved this puzzle and the books are in their proper places, you no longer need to sort them."
			)
			((super select: &rest)
				(gCSoundFX number: 144 setLoop: 1 play:)
				(bookCase showCast: self)
				(if (IsObject gModelessDialog)
					(gModelessDialog dispose:)
				)
				(if (== cursor value)
					(-- local2)
				)
				(bookProp x: (+ nsLeft 7) y: (+ nsTop 21) loop: loop show:)
				(gGame setCursor: 996 1 (+ nsLeft 7) (+ nsTop 21))
				(DrawCel 286 0 (Random 1 3) nsLeft nsTop -1)
				(= nsTop 300)
				(= temp0 (/ (- nsLeft 8) 16))
				(&= [local35 cursor] (~ (<< $0001 temp0)))
			)
		)
	)

	(method (highlight param1)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(cond
			((bookCase showCast:) 0)
			(param1
				(super highlight: param1 &rest)
				(Print
					modeless: 1
					x: (+ nsLeft 80)
					y: (+ nsTop 14)
					addText: 1 4 message modifiers 0 0 [local82 gDifficulty]
					init:
				)
			)
			((bookCase puzzleStatus:)
				(DrawCel view 0 13 nsLeft nsTop -1)
			)
			(else
				(super highlight: param1 &rest)
			)
		)
	)
)

(instance shelf of CodeIcon
	(properties
		nsLeft 8
		nsRight 133
		message 0
	)

	(method (select &tmp temp0)
		(if (bookCase showCast:)
			(cond
				((< (= temp0 (/ (- (bookCase eventX:) nsLeft) 16)) 0)
					(= temp0 0)
				)
				((>= temp0 8)
					(gCSoundFX number: 144 setLoop: 1 play:)
					(= temp0 7)
				)
			)
			(if (not (& modifiers (<< $0001 temp0)))
				(gCSoundFX number: 243 setLoop: 1 play:)
				((bookCase showCast:)
					cel: 2
					nsTop: nsTop
					nsLeft: (+ nsLeft (* temp0 16))
					nsBottom: (+ nsTop 41)
					nsRight: (+ nsLeft (* temp0 16) 16)
					cursor: value
					show:
				)
				(if (== ((bookCase showCast:) value:) value)
					(++ local2)
				)
				(|= [local35 value] (<< $0001 temp0))
				(bookProp hide:)
				(bookCase animateOnce:)
				(bookCase showCast: 0)
				(gGame setCursor: 900)
				(if (>= local2 local1)
					(bookCase solvePuzzle:)
				)
			else
				(gCSoundFX number: 248 setLoop: 1 play:)
			)
		)
	)

	(method (init param1 &tmp temp0 temp1)
		(= temp0 (localproc_0 local32 0 (- [local86 local3] 1)))
		(|= local32 (<< $0001 temp0))
		(= message [local106 (+ [local96 local3] temp0)])
		(self
			value: param1
			nsTop: [local256 param1]
			nsBottom: (+ [local256 param1] 41)
		)
		(for ((= temp1 (= modifiers 0))) (< temp1 local0) ((++ temp1))
			(= temp0 (localproc_0 modifiers 0 8))
			(|= modifiers (<< $0001 temp0))
		)
		(= [local35 param1] modifiers)
		(= [local29 param1] (proc15_6 [local82 gDifficulty] 1 4 message))
		(= [local20 param1] self)
	)

	(method (show &tmp temp0 temp1 temp2 [temp3 10] temp13)
		(= temp2 nsTop)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(= temp1 (+ nsLeft (* temp0 16)))
			(cond
				((& modifiers (<< $0001 temp0))
					(DrawCel
						286
						0
						(= temp13 (localproc_0 local33 4 12))
						temp1
						temp2
						-1
					)
					(|= local33 (<< $0001 temp13))
				)
				((not (& [local35 value] (<< $0001 temp0)))
					(DrawCel 286 0 (Random 1 3) temp1 nsTop -1)
				)
			)
		)
		(Message msgGET [local82 gDifficulty] 1 1 message 1 @temp3)
		(Display @temp3 dsCOORD 17 [local259 value] dsWIDTH 118 dsALIGN alCENTER dsFONT 999)
	)

	(method (highlight))
)

(instance bookProp of Actor
	(properties
		view 286
		cel 2
		priority 15
		signal 19
	)

	(method (doit)
		(= x (+ (bookCase eventX:) 60))
		(= y (+ (bookCase eventY:) 0))
		(super doit: &rest)
	)
)

