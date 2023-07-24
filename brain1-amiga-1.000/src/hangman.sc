;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Window)
(use Sound)
(use Motion)
(use Actor)

(public
	hangman 0
	rope 1
	nooseLoop 2
)

(local
	[local0 3]
	local3
	local4 = {---------------------}
	local5 = {--------------------}
	[local6 26]
	local32
	local33
	local34 = 10
	local35
	local36
	local37 = 1
	local38
	local39
	local40
	[local41 4]
	local45 = 1
	local46 = 1
	local47
	local48
	local49
	[local50 3] = [{first} {second} {last}]
	[local53 7] = [30 17 17 30 30 29 23]
	[local60 7] = [30 17 17 30 30 29 23]
	[local67 19] = [{ELEVATOR} {HONEST} {ANTELOPE} {ENTRANCE} {TRAIN} {SESSION} {PATTERN} {DENTIST} {DOCTOR} {RESISTANCE} {RENTAL} {PASSWORD} {BRAINS} {COMPLETE} {EDITORIAL} {NEWSPAPER} {MAGAZINE} {WESTERN} {EXCELLENT}]
	local86
	[local87 10] = [17 12 1 40 10 25 1 50 12 26]
	[local97 10] = [58 85 90 87 114 114 119 122 170 170]
	[local107 26] = [{A} {B} {C} {D} {E} {F} {G} {H} {I} {J} {K} {L} {M} {N} {O} {P} {Q} {R} {S} {T} {U} {V} {W} {X} {Y} {Z}]
	[local133 26] = [15 25 35 45 55 65 75 85 95 93 93 93 93 93 93 93 93 93 93 93 93 93 50 59 68 77]
	[local159 26] = [41 41 41 41 41 41 41 41 41 56 66 76 86 96 106 116 126 136 146 156 166 176 56 65 74 83]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 0)
	(= temp1 7)
	(= temp2 24)
	(while (< temp0 local35)
		(if (== (= temp3 (StrAt local4 temp0)) 45)
			(DrawCel 387 2 0 temp1 temp2 15)
		else
			(DrawCel 387 2 1 temp1 temp2 15)
			(proc5_8
				[local107 (- temp3 65)]
				[local53 1]
				(+ temp1 1)
				(+ temp2 2)
			)
		)
		(++ temp0)
		(+= temp1 10)
	)
	(= temp4 4)
	(for ((= temp0 0)) (< temp0 local32) ((++ temp0))
		(DrawCel 387 3 temp0 [local87 temp0] [local97 temp0] 15)
		(if (and (== global114 2) (< 1 temp0 6))
			(DrawCel
				387
				3
				(= temp4 (+ temp0 4))
				[local87 temp4]
				[local97 temp4]
				15
			)
		)
		(if (and (== global114 1) (< 3 temp0 6))
			(DrawCel
				387
				3
				(= temp4 (+ temp0 4))
				[local87 temp4]
				[local97 temp4]
				15
			)
		)
	)
	(cond
		((== local33 local35)
			(= temp5 0)
		)
		((== local32 local36)
			(= temp5 5)
		)
		((>= local32 (- local36 2))
			(= temp5 4)
		)
		((> local32 local33)
			(= temp5 3)
		)
		((> local33 (+ local32 1))
			(= temp5 1)
		)
		(else
			(= temp5 2)
		)
	)
	(if local32
		(DrawCel 387 1 temp5 17 58 15)
	)
	(Graph grUPDATE_BOX 0 170 189 285 1)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2)
	(= temp2 (- (/ (- @local86 @local67) 2) 1))
	(= temp0 0)
	(while (not temp0)
		(for ((= temp1 0)) (< temp1 3) ((++ temp1))
			(= [local0 temp1] [local67 (Random 0 temp2)])
		)
		(if
			(*
				(- [local0 1] [local0 0])
				(- [local0 2] [local0 0])
				(- [local0 2] [local0 1])
			)
			(= temp0 1)
		)
	)
)

(procedure (localproc_2 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 local35) ((++ temp0))
		(if (== (StrAt local3 temp0) param1)
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_3 param1)
	(= local32 (= local33 0))
	(= local3 [local0 (- local37 1)])
	(= local35 (StrLen local3))
	(StrCpy local4 local5)
	(if param1
		(hangman enable:)
	)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2 temp3)
	(gCMusic2 number: 50 setLoop: 1 play:)
	(DrawCel 387 1 0 17 58 15)
	(= temp0 0)
	(= temp1 7)
	(= temp2 24)
	(while (< temp0 local35)
		(gCMusic2 number: 61 setLoop: 1 play:)
		(DrawCel 387 2 2 temp1 temp2 15)
		(= temp3 (StrAt local4 temp0))
		(proc5_8 [local107 (- temp3 65)] [local53 2] (+ temp1 1) (+ temp2 2))
		(Graph grUPDATE_BOX 0 170 189 285 1)
		(Wait 15)
		(++ temp0)
		(+= temp1 10)
	)
)

(instance hangman of PuzzleBar
	(properties
		puzzleHeight 185
		bottomHeight 0
		solvedFlag 6
	)

	(method (init &tmp temp0 temp1)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 7) ((++ temp0))
				(= [local53 temp0] [local60 temp0])
			)
		)
		(if local45
			(arms init: hide:)
			(dummy init:)
			(nooseLoop init: hide:)
			(rope init:)
			(ropeKnot init: setLoop: 3 setCel: 1)
		else
			(dummy x: 238 y: 84)
			(ropeKnot x: 242 y: 40)
		)
		(localproc_1)
		(= local38 0)
		(= local37 1)
		(localproc_3 0)
		(= local47 iconHeight)
		(= local36 (- 10 (* global114 2)))
		(= local49 global114)
		(hngmnWindow back: [local53 5])
		(= window hngmnWindow)
		(for ((= temp1 65)) (<= temp1 90) ((++ temp1))
			(= temp0 (- temp1 65))
			(self
				add:
					((= [local6 temp0] (letterIcon new:))
						value: temp1
						nsLeft: [local133 temp0]
						nsTop: [local159 temp0]
						text: [local107 temp0]
						textColor: [local53 6]
						highlightColor: [local53 3]
						lowlightColor: 28
						yourself:
					)
			)
		)
		(= local45 0)
		(super init: &rest)
	)

	(method (show)
		(if local38
			(++ local37)
			(= local38 0)
			(localproc_3 1)
		)
		(super show: &rest)
		(if local38
			(return local37)
		else
			(return 0)
		)
	)

	(method (buyClue &tmp temp0 temp1)
		(if (super buyClue: &rest)
			(for ((= temp0 0)) (!= (StrAt local4 temp0) 45) ((++ temp0))
			)
			(= temp1 [local6 (- (StrAt local3 temp0) 65)])
			(hangman select: temp1 0)
		)
	)

	(method (showHelp)
		(proc5_9 385 0) ; "The dummy is about to be hung, probably for the crime of being stupid. You can save the dummy by being smart enough to guess three words."
		(proc5_9 385 1) ; "Guess the words by choosing one letter at a time (either click on the letters on the hanging post, or type them). If your guess is correct, the letters will appear in the word above the dummy. But if you get too many wrong, the dummy will hang."
		(proc5_9 385 2) ; "If you get stuck, you can use a Hint Coin to buy a correct letter that you haven't yet guessed. Each time you guess a word, the dummy will give you a clue to the cabinet lock. After you rescue the dummy, you can review the clues by clicking the Eye on the hanging post."
	)

	(method (enable &tmp temp0 temp1)
		(= temp0 0)
		(for
			((= temp1 (self at: 0)))
			(< temp0 size)
			((= temp1 (self at: temp0)))
			
			(temp1 signal: (& (temp1 signal:) $fffb))
			(++ temp0)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3)
		(if
			(and
				(== (= temp3 (event type:)) evKEYBOARD)
				(or
					(and (>= (= temp0 (event message:)) KEY_a) (<= temp0 KEY_z))
					(and (>= temp0 KEY_A) (<= temp0 KEY_Z))
				)
			)
			(if (and (>= temp0 KEY_a) (<= temp0 KEY_z))
				(= temp0 (+ (- temp0 97) 65))
			)
			(= temp2 [local6 (- temp0 65)])
			(hangman select: temp2 0)
		)
		(super dispatchEvent: event)
	)

	(method (animateOnce)
		(if local48
			(Animate (gCast elements:) 1)
			(= local48 0)
		else
			(super animateOnce: &rest)
		)
	)

	(method (dispose)
		(if (IsObject theMusic3)
			(theMusic3 dispose:)
		)
		(super dispose: &rest)
	)
)

(instance letterIcon of TextIcon
	(properties
		view 387
		loop 4
		cel 0
		maskView 387
		maskLoop 4
		maskCel 1
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(self signal: (| signal $0004) show:)
			(if (localproc_2 value)
				(for ((= temp0 0)) (< temp0 local35) ((++ temp0))
					(if (== (StrAt local3 temp0) value)
						(StrAt local4 temp0 value)
						(++ local33)
					)
				)
				(theMusic3 number: 58 setLoop: 1 play:)
				(localproc_0)
			else
				(theMusic3 number: 61 setLoop: 1 play:)
				(++ local32)
				(localproc_0)
			)
			(cond
				((== local32 local36)
					(= local38 1)
					(= local37 -1)
					(Wait 120)
					(hangman goAway:)
				)
				((== local33 local35)
					(localproc_4)
					(= local38 1)
					(hangman goAway:)
				)
			)
		)
	)

	(method (showText param1)
		(proc5_8 text param1 (+ nsLeft 1) (+ nsTop 2) -1 999)
	)
)

(instance hngmnWindow of SysWindow
	(properties
		left 170
		bottom 189
		right 285
		back 43
		priority 14
	)

	(method (open)
		(super open:)
		(DrawCel 387 0 0 0 local47 15)
		(DrawCel 387 3 0 [local87 0] [local97 0] 15)
		(DrawCel 387 3 0 17 58 15)
		(localproc_0)
		(if local46
			(hangman showHelp:)
			(= local46 0)
		)
	)
)

(instance rope of Prop
	(properties
		x 242
		y 76
		description {rope}
		view 386
		loop 3
		signal 16384
	)
)

(instance dummy of Actor
	(properties
		x 238
		y 84
		description {dummy}
		lookStr {This guy looks like a real dummy. But is that any reason to hang him? Apparently, to Dr. Brain it is!}
		view 386
		loop 2
		priority 14
	)

	(method (doVerb theVerb)
		(if (!= theVerb 3)
			(super doVerb: theVerb &rest)
		else
			(if (!= local49 global114)
				(hangman dispose:)
				(hangman init:)
				(= local48 1)
				(= local49 global114)
			)
			(cond
				((> (= local39 (hangman show:)) 0)
					(rope setScript: dummyLower)
				)
				((< local39 0)
					(self setScript: hangDummy)
				)
			)
		)
	)
)

(instance arms of Actor
	(properties
		x 237
		y 123
		view 386
		loop 1
		priority 13
		signal 16
		cycleSpeed 10
	)
)

(instance ropeKnot of Actor
	(properties
		x 242
		y 40
		view 386
		priority 14
		signal 16
	)
)

(instance nooseLoop of Actor
	(properties
		x 242
		y 66
		description {noose}
		view 386
		loop 3
		cel 2
	)
)

(instance dummyLower of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCMusic2 number: 924 setLoop: 1 play:)
				(ropeKnot setMotion: MoveTo (ropeKnot x:) (+ (ropeKnot y:) 12))
				(dummy
					cycleSpeed: 0
					setMotion: MoveTo (dummy x:) (+ (dummy y:) 12) self
				)
			)
			(1
				(gCMusic2 stop:)
				(if (< [global116 (- local39 1)] 1000)
					(= [global116 (- local39 1)] (Random 1000 9999))
				)
				(proc5_14 ; "The dummy says, "Thank you. That feels much better. By the way, the %s number of the cabinet combination is %d"."
					385
					3
					[local50 (- local39 1)]
					[global116 (- local39 1)]
				)
				(if (< local39 3)
					(self dispose:)
				else
					(= ticks 1)
				)
			)
			(2
				(ropeKnot dispose:)
				(nooseLoop show:)
				(dummy x: 239 y: 121 loop: 3 setCel: 3)
				(arms show: setCycle: End self)
			)
			(3
				(gCMusic2 number: 53 setLoop: 1 play: self)
			)
			(4
				(proc5_9 385 4) ; "Just before he leaves, the dummy adds, "I'm free! Thank you! By the way, you'll need some things from Dr. Brain's safe before you take the elevator up into the tower.""
				(= ticks 1)
			)
			(5
				(dummy dispose:)
				(hangman solvePuzzle:)
				(hangman dispose:)
				(arms dispose:)
				(= local40 1)
				(self dispose:)
			)
		)
	)
)

(instance hangDummy of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCMusic2 number: 57 setLoop: 1 play:)
				(dummy loop: 0 cycleSpeed: 8 setCycle: End self)
			)
			(1
				(dummy setCycle: Beg self)
			)
			(2
				(dummy cycleSpeed: 20 setCycle: End self)
			)
			(3
				(dummy setCycle: Beg self)
			)
			(4
				(dummy cycleSpeed: 36 setCycle: End self)
			)
			(5
				(rope hide:)
				(ropeKnot hide:)
				(gCMusic2 number: 955 setLoop: 1 play: self)
				(dummy loop: 2 cel: 0 cycleSpeed: 4 setCycle: End)
			)
			(6
				(proc5_9 385 5) ; "One more dummy lost to the world. You'd better hope you're smart enough not to let it happen to you. (You might start by guessing the next word correctly!)"
				(= ticks 1)
			)
			(7
				(gCMusic2 number: 956 setLoop: 1 play:)
				(dummy x: 238 y: 84 setCycle: Beg self)
			)
			(8
				(rope show:)
				(ropeKnot y: 40 show:)
				(localproc_1)
				(= local37 1)
				(localproc_3 1)
				(= local38 0)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (> (gCMusic2 prevSignal:) 0)
			(Printf 385 6 (gCMusic2 prevSignal:)) ; "prevSig in doit = %d"
		)
		(super doit: &rest)
	)
)

(instance theMusic3 of Sound
	(properties
		flags 1
	)
)

