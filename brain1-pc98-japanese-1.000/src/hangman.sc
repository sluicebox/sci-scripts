;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Language)
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
	[local3 3]
	local6
	local7 = {---------------------}
	local8 = {--------------------}
	[local9 26]
	local35
	local36
	local37 = 10
	local38
	local39
	local40 = 1
	local41
	local42
	local43
	[local44 4]
	local48 = 1
	local49 = 1
	local50
	local51
	local52
	[local53 3] = [{first} {second} {last}]
	[local56 7] = [10 34 52 13 18 43 50]
	[local63 7] = [4 0 0 4 6 7 1]
	[local70 19] = [{ELEVATOR} {HONEST} {ANTELOPE} {ENTRANCE} {TRAIN} {SESSION} {PATTERN} {DENTIST} {DOCTOR} {RESISTANCE} {RENTAL} {PASSWORD} {BRAINS} {COMPLETE} {EDITORIAL} {NEWSPAPER} {MAGAZINE} {WESTERN} {EXCELLENT}]
	local89
	[local90 19] = [{ELEVATOR} {HONEST} {ANTELOPE} {ENTRANCE} {TRAIN} {SESSION} {PATTERN} {DENTIST} {DOCTOR} {RESISTANCE} {RENTAL} {PASSWORD} {BRAINS} {COMPLETE} {EDITORIAL} {NEWSPAPER} {MAGAZINE} {WESTERN} {EXCELLENT}]
	[local109 10] = [17 12 1 40 10 25 1 50 12 26]
	[local119 10] = [58 85 90 87 114 114 119 122 170 170]
	[local129 26] = [{A} {B} {C} {D} {E} {F} {G} {H} {I} {J} {K} {L} {M} {N} {O} {P} {Q} {R} {S} {T} {U} {V} {W} {X} {Y} {Z}]
	[local155 26] = [15 25 35 45 55 65 75 85 95 93 93 93 93 93 93 93 93 93 93 93 93 93 50 59 68 77]
	[local181 26] = [41 41 41 41 41 41 41 41 41 56 66 76 86 96 106 116 126 136 146 156 166 176 56 65 74 83]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 0)
	(= temp1 7)
	(= temp2 24)
	(while (< temp0 local38)
		(if (== (= temp3 (StrAt local7 temp0)) 45)
			(DrawCel 387 2 0 temp1 temp2 15)
		else
			(DrawCel 387 2 1 temp1 temp2 15)
			(proc5_8
				[local129 (- temp3 65)]
				[local56 1]
				(+ temp1 1)
				(+ temp2 2)
			)
		)
		(++ temp0)
		(+= temp1 10)
	)
	(= temp4 4)
	(for ((= temp0 0)) (< temp0 local35) ((++ temp0))
		(DrawCel 387 3 temp0 [local109 temp0] [local119 temp0] 15)
		(if (and (== global114 2) (< 1 temp0 6))
			(DrawCel
				387
				3
				(= temp4 (+ temp0 4))
				[local109 temp4]
				[local119 temp4]
				15
			)
		)
		(if (and (== global114 1) (< 3 temp0 6))
			(DrawCel
				387
				3
				(= temp4 (+ temp0 4))
				[local109 temp4]
				[local119 temp4]
				15
			)
		)
	)
	(cond
		((== local36 local38)
			(= temp5 0)
		)
		((== local35 local39)
			(= temp5 5)
		)
		((>= local35 (- local39 2))
			(= temp5 4)
		)
		((> local35 local36)
			(= temp5 3)
		)
		((> local36 (+ local35 1))
			(= temp5 1)
		)
		(else
			(= temp5 2)
		)
	)
	(if local35
		(DrawCel 387 1 temp5 17 58 15)
	)
	(Graph grUPDATE_BOX 0 170 189 285 1)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2)
	(= temp2 (- (/ (- @local89 @local70) 2) 1))
	(= temp0 0)
	(while (not temp0)
		(for ((= temp1 0)) (< temp1 3) ((++ temp1))
			(= [local3 temp1] (Random 0 temp2))
		)
		(if
			(*
				(- [local3 1] [local3 0])
				(- [local3 2] [local3 0])
				(- [local3 2] [local3 1])
			)
			(= temp0 1)
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(= [local0 temp0] (localproc_6 [local3 temp0]))
	)
)

(procedure (localproc_3 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 local38) ((++ temp0))
		(if (== (StrAt local6 temp0) param1)
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_4 param1)
	(= local35 (= local36 0))
	(= local6 [local0 (- local40 1)])
	(= local38 (StrLen local6))
	(StrCpy local7 local8)
	(if param1
		(hangman enable:)
	)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2 temp3)
	(gCMusic2 number: 50 setLoop: 1 play:)
	(DrawCel 387 1 0 17 58 15)
	(= temp0 0)
	(= temp1 7)
	(= temp2 24)
	(while (< temp0 local38)
		(gCMusic2 number: 61 setLoop: 1 play:)
		(DrawCel 387 2 2 temp1 temp2 15)
		(= temp3 (StrAt local7 temp0))
		(proc5_8 [local129 (- temp3 65)] [local56 2] (+ temp1 1) (+ temp2 2))
		(Graph grUPDATE_BOX 0 170 189 285 1)
		(Wait 15)
		(++ temp0)
		(+= temp1 10)
	)
)

(procedure (localproc_6 param1)
	(if (or (== (gGame printLang:) 1) (== (gGame printLang:) 81))
		(return [local70 param1])
	else
		(return [local90 param1])
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
				(= [local56 temp0] [local63 temp0])
			)
		)
		(if local48
			(arms init: hide:)
			(dummy init: stopUpd:)
			(nooseLoop init: hide:)
			(rope init: stopUpd:)
			(ropeKnot init: setLoop: 3 setCel: 1 stopUpd:)
		else
			(dummy x: 238 y: 84)
			(ropeKnot x: 242 y: 40)
		)
		(localproc_1)
		(= local41 0)
		(= local40 1)
		(localproc_4 0)
		(= local50 iconHeight)
		(= local39 (- 10 (* global114 2)))
		(= local52 global114)
		(hngmnWindow back: [local56 5])
		(= window hngmnWindow)
		(for ((= temp1 65)) (<= temp1 90) ((++ temp1))
			(= temp0 (- temp1 65))
			(self
				add:
					((= [local9 temp0] (letterIcon new:))
						value: temp1
						nsLeft: [local155 temp0]
						nsTop: [local181 temp0]
						text: [local129 temp0]
						textColor: [local56 6]
						highlightColor: [local56 3]
						lowlightColor: [local56 4]
						yourself:
					)
			)
		)
		(= local48 0)
		(super init: &rest)
	)

	(method (show)
		(if local41
			(++ local40)
			(= local41 0)
			(localproc_4 1)
		)
		(localproc_2)
		(localproc_4)
		(super show: &rest)
		(if local41
			(return local40)
		else
			(return 0)
		)
	)

	(method (buyClue &tmp temp0 temp1)
		(if (super buyClue: &rest)
			(for ((= temp0 0)) (!= (StrAt local7 temp0) 45) ((++ temp0))
			)
			(= temp1 [local9 (- (StrAt local6 temp0) 65)])
			(hangman select: temp1 0)
		)
	)

	(method (showHelp)
		(proc5_9 385 0)
		(proc5_9 385 1)
		(proc5_9 385 2)
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
			(= temp2 [local9 (- temp0 65)])
			(hangman select: temp2 0)
		)
		(super dispatchEvent: event)
	)

	(method (animateOnce)
		(if local51
			(Animate (gCast elements:) 1)
			(= local51 0)
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
			(if (localproc_3 value)
				(for ((= temp0 0)) (< temp0 local38) ((++ temp0))
					(if (== (StrAt local6 temp0) value)
						(StrAt local7 temp0 value)
						(++ local36)
					)
				)
				(theMusic3 number: 58 setLoop: 1 play:)
				(localproc_0)
			else
				(theMusic3 number: 61 setLoop: 1 play:)
				(++ local35)
				(localproc_0)
			)
			(cond
				((== local35 local39)
					(= local41 1)
					(= local40 -1)
					(Wait 120)
					(hangman goAway:)
				)
				((== local36 local38)
					(localproc_5)
					(= local41 1)
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
		(DrawCel 387 0 0 0 local50 15)
		(DrawCel 387 3 0 [local109 0] [local119 0] 15)
		(DrawCel 387 3 0 17 58 15)
		(localproc_0)
		(if local49
			(hangman showHelp:)
			(= local49 0)
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

	(method (findPosn))

	(method (doVerb theVerb)
		(if (!= theVerb 3)
			(super doVerb: theVerb &rest)
		else
			(if (!= local52 global114)
				(hangman dispose:)
				(hangman init:)
				(= local51 1)
				(= local52 global114)
			)
			(cond
				((> (= local42 (hangman show:)) 0)
					(rope setScript: dummyLower)
				)
				((< local42 0)
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
				(ropeKnot stopUpd:)
				(dummy stopUpd:)
				(gCMusic2 stop:)
				(if (< [global116 (- local42 1)] 1000)
					(= [global116 (- local42 1)] (Random 1000 9999))
				)
				(if 1
					(= global408 (Memory memALLOC_CRIT (StrLen [local53 (- local42 1)])))
					(= global409 (Memory memALLOC_CRIT (StrLen [local53 (- local42 1)])))
					(StrSplitInTwo global408 global409 [local53 (- local42 1)])
					(proc5_14
						385
						3
						global408
						[global116 (- local42 1)]
						global409
						[global116 (- local42 1)]
					)
					(Memory memFREE global408)
					(Memory memFREE global409)
				)
				(if (< local42 3)
					(self dispose:)
				else
					(= ticks 1)
				)
			)
			(2
				(ropeKnot dispose:)
				(nooseLoop show: stopUpd:)
				(dummy x: 238 y: 121 loop: 3 setCel: 3 ignoreActors: stopUpd:)
				(arms show: ignoreActors: setCycle: End self)
			)
			(3
				(arms stopUpd:)
				(gCMusic2 number: 53 setLoop: 1 play: self)
			)
			(4
				(proc5_9 385 4)
				(= ticks 1)
			)
			(5
				(dummy dispose:)
				(hangman solvePuzzle:)
				(hangman dispose:)
				(arms dispose:)
				(= local43 1)
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
				(proc5_9 385 5)
				(= ticks 1)
			)
			(7
				(gCMusic2 number: 956 setLoop: 1 play:)
				(dummy x: 238 y: 84 setCycle: Beg self)
			)
			(8
				(dummy stopUpd:)
				(rope show: stopUpd:)
				(ropeKnot y: 40 show: stopUpd:)
				(localproc_1)
				(= local40 1)
				(localproc_4 1)
				(= local41 0)
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

