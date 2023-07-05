;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use PuzzleIcon)
(use Window)
(use System)

(public
	pattern 0
)

(local
	[local0 10]
	[local10 10]
	[local20 16]
	local36
	local37
	local38
	[local39 4] = [3 2 1 0]
	[local43 4]
	[local47 4] = [1 1 1 1]
	local51 = 410
	[local52 33] = [410 0 3 410 4 7 410 8 15 411 0 3 411 4 15 412 0 3 412 4 15 413 0 15 416 0 3 416 4 15 417 0 15]
)

(procedure (localproc_0 param1 &tmp temp0)
	(Wait 0)
	(Wait param1)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2)
	(for ((= temp0 (WordAt param1 0))) (> temp0 1) ((-- temp0))
		(= temp2 (Random 1 temp0))
		(= temp1 (WordAt param1 temp2))
		(Memory memPOKE (+ param1 (* 2 temp2)) (WordAt param1 temp0))
		(Memory memPOKE (+ param1 (* 2 temp0)) temp1)
	)
)

(procedure (localproc_2 &tmp temp0)
	(if (or (not (-- local37)) (== global114 0))
		(for ((= temp0 1)) (<= temp0 local10) ((++ temp0))
			(cond
				(
					(and
						([local10 temp0] value:)
						(== (([local10 temp0] value:) value:) [local10 temp0])
					)
					(-- local38)
				)
				((and (== global114 0) ([local10 temp0] value:))
					(([local10 temp0] value:) mask: 0)
					([local10 temp0] view: 0 value: 0 show: 2)
					(++ local37)
				)
			)
		)
		(if (not local38)
			(pattern solvePuzzle:)
		else
			(= local38 local10)
			(if (== global114 2)
				(for ((= temp0 1)) (<= temp0 local10) ((++ temp0))
					(([local10 temp0] value:) mask: 0)
					([local10 temp0] view: 0 value: 0 show: 2)
				)
				(= local37 local10)
			)
		)
	)
)

(instance pattern of PuzzleBar
	(properties
		state 8
		puzzleHeight 169
		solvedFlag 22
		noun 2
		personalID 25
	)

	(method (init &tmp temp0 temp1 temp2 [temp3 17])
		(= window ptrnWin)
		(= local51 [local52 (= temp1 (* 3 (Random 0 10)))])
		(= temp3 0)
		(for
			((= temp2 [local52 (+ temp1 1)]))
			(<= temp2 [local52 (+ temp1 2)])
			((++ temp2))
			
			(= [temp3 (++ temp3)] temp2)
		)
		(localproc_1 @temp3)
		(for ((= temp2 0)) (< temp2 4) ((++ temp2))
			(= [local39 temp2] [temp3 (+ temp2 1)])
			(if (Random 0 1)
				(= [local43 temp2] 3)
				(= [local47 temp2] -1)
			)
		)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= temp1 (Random 0 3))
			((= [local10 (++ local10)]
					(= [local20 (+ (* temp0 4) temp1)] (part new:))
				)
				nsLeft: (+ 12 (* temp1 29))
				nsTop: (+ 32 (* temp0 25))
				nsRight: (+ 37 (* temp1 29))
				nsBottom: (+ 53 (* temp0 25))
				yourself:
			)
			((= [local0 (++ local0)] (part new:))
				view: local51
				loop: [local39 temp0]
				cel: (+ [local43 temp0] (* temp1 [local47 temp0]))
				value: [local10 (+ local10 0)]
			)
			(++ local37)
		)
		(= local38 local37)
		(while (< local0 8)
			(= temp0 [temp3 (Random 1 temp3)])
			(= temp1 (Random 0 3))
			(for ((= temp2 1)) (<= temp2 local0) ((++ temp2))
				(if
					(and
						(== ([local0 temp2] loop:) temp0)
						(== ([local0 temp2] cel:) temp1)
					)
					(break)
				)
			)
			(if (> temp2 local0)
				((= [local0 (++ local0)] (part new:))
					view: local51
					loop: temp0
					cel: temp1
					value: 0
				)
			)
		)
		(localproc_1 @local0)
		(for ((= temp0 1)) (<= temp0 local10) ((++ temp0))
			(self
				add:
					[local10 temp0]
					([local0 (- (* temp0 2) 1)]
						nsLeft: 139
						nsTop: (+ 8 (* temp0 24))
						yourself:
					)
					([local0 (* temp0 2)]
						nsLeft: 177
						nsTop: (+ 8 (* temp0 24))
						yourself:
					)
			)
		)
		(super init: &rest)
	)

	(method (solvePuzzle &tmp temp0 temp1 temp2)
		(gCSoundFX number: 106 loop: 1 play:)
		(gGame setCursor: gTheCursor)
		(for ((= temp0 0)) (< temp0 33) ((++ temp0))
			(for ((= temp2 0)) (< temp2 4) ((++ temp2))
				(for ((= temp1 0)) (< temp1 4) ((++ temp1))
					(DrawCel
						local51
						[local39 temp2]
						(+
							[local43 temp2]
							(* (& (+ temp1 temp0) $0003) [local47 temp2])
						)
						(+ 12 (* temp1 29))
						(+ 32 (* temp2 25))
						-1
					)
				)
			)
			(localproc_0 6)
		)
		(localproc_0 30)
		(super solvePuzzle:)
	)

	(method (highlight param1 param2 &tmp temp0)
		(cond
			((and (IsObject param1) (< (param1 nsTop:) 21))
				(gGame setCursor: gTheCursor)
			)
			((IsObject local36)
				(SetCursor (local36 view:) (local36 loop:) (local36 cel:))
			)
		)
		(super highlight: param1)
		(if
			(and
				(>= argc 2)
				param2
				(IsObject highlightedIcon)
				(not (& (param1 signal:) $0004))
				(not pHandsOff)
			)
			(SetCursor
				(+
					(param1 nsLeft:)
					(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
				)
				(- (param1 nsBottom:) 3)
			)
		)
	)

	(method (dispatchEvent event)
		(if (& (event type:) $0040) ; direction
			(self
				advance:
					(switch (event message:)
						(JOY_UP -3)
						(JOY_DOWN 3)
						(JOY_RIGHT 1)
						(JOY_LEFT -1)
					)
			)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $0305)) ; evJOYUP | evJOYDOWN | evMOUSEKEYBOARD
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (advance param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 (self indexOf: highlightedIcon))
		(for
			((= temp1 (= temp2 (if argc param1 else 1))))
			(<= (Abs temp1) size)
			((+= temp1 temp2))
			
			(if argc
				(cond
					((and (== param1 1) (not (mod (+ temp1 temp3) 3)))
						(+= temp1 (- size 3))
					)
					((and (== param1 -1) (not (mod (+ temp1 temp3 1) 3)))
						(-= temp1 (- size 3))
					)
				)
			)
			(= temp0 (self at: (mod (+ temp1 temp3) size)))
			(breakif (not (& (temp0 signal:) $0004)))
		)
		(self highlight: temp0 (& state $0020))
	)

	(method (doit)
		(if (IsObject local36)
			(SetCursor (local36 view:) (local36 loop:) (local36 cel:))
		)
		(super doit: &rest)
		(gGame setCursor: gTheCursor)
	)

	(method (buyClue &tmp temp0)
		(if (super buyClue: &rest)
			(if
				(and
					local36
					(local36 value:)
					(!= ((local36 value:) value:) local36)
				)
				(self highlight: (local36 value:) 1)
				(self select: (local36 value:))
			else
				(for ((= temp0 1)) (<= temp0 local0) ((++ temp0))
					(if
						(and
							([local0 temp0] value:)
							(!= (([local0 temp0] value:) value:) [local0 temp0])
						)
						(break)
					)
				)
				(self highlight: [local0 temp0] 1)
				(self select: [local0 temp0])
			)
		)
	)
)

(instance ptrnWin of SysWindow
	(properties
		top 15
		left 8
		bottom 162
		right 233
		back 53
		priority -1
	)

	(method (open &tmp temp0 temp1)
		(super open: &rest)
		(DrawCel 414 0 0 0 21 -1)
		(for ((= temp1 0)) (< temp1 4) ((++ temp1))
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(if (not [local20 (+ (* temp1 4) temp0)])
					(DrawCel
						local51
						[local39 temp1]
						(+ [local43 temp1] (* temp0 [local47 temp1]))
						(+ 12 (* temp0 29))
						(+ 32 (* temp1 25))
						-1
					)
				)
			)
		)
	)
)

(instance part of CodeIcon
	(properties
		view 0
		loop 0
		signal 417
		maskView 414
		maskLoop 1
		highlightColor 6
		lowlightColor 133
	)

	(method (select &tmp temp0)
		(if (and local36 (< nsLeft 125))
			(= downClick 145)
			(= upClick 0)
		else
			(= downClick 104)
			(= upClick 207)
		)
		(if (super select: &rest)
			(cond
				(local36
					(self highlight: 0)
					(if (< nsLeft 125)
						(if value
							(++ local37)
							(value mask: 0)
						)
						(= view (local36 view:))
						(= loop (local36 loop:))
						(= cel (local36 cel:))
						(= value local36)
						(self show:)
						(localproc_2)
					else
						(local36 mask: 0)
						(if (!= local36 self)
							(SetCursor view loop cel)
							(= local36 self)
							(local36 mask: 1)
							(return)
						)
					)
					(= local36 0)
					(gGame setCursor: gTheCursor)
				)
				((> nsLeft 125)
					(self mask: 1)
					(SetCursor view loop cel)
					(= local36 self)
				)
				(value
					(self highlight: 0)
					(SetCursor view loop cel)
					(= local36 value)
					(= value (= view 0))
					(++ local37)
				)
			)
		)
	)

	(method (show param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (if argc param1 else cel))
		(if view
			(if argc
				(if (< nsLeft 125)
					(= lowlightColor 166)
				)
				(= temp5
					(cond
						((not (and argc (!= param1 2))) lowlightColor)
						(param1 52)
						(else highlightColor)
					)
				)
				(= temp1 (- nsTop 1))
				(= temp2 (- nsLeft 1))
				(= temp3 nsBottom)
				(= temp4 nsRight)
				(Graph grDRAW_LINE temp1 temp2 temp1 temp4 temp5 -1 -1)
				(Graph grDRAW_LINE temp1 temp4 temp3 temp4 temp5 -1 -1)
				(Graph grDRAW_LINE temp3 temp4 temp3 temp2 temp5 -1 -1)
				(Graph grDRAW_LINE temp3 temp2 temp1 temp2 temp5 -1 -1)
				(Graph grUPDATE_BOX temp1 temp2 (+ nsBottom 1) (+ nsRight 1) 1)
			else
				(super show: temp0 &rest)
			)
		else
			(Graph
				grFILL_BOX
				nsTop
				nsLeft
				nsBottom
				nsRight
				1
				(switch (= cel temp0)
					(0 6)
					(1 52)
					(2 4)
					(3 45)
				)
			)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		)
	)

	(method (mask param1)
		(if (== global114 0)
			(if (or (not argc) param1)
				(|= signal $0004)
				(super mask: param1)
			else
				(&= signal $fffb)
				(self show:)
			)
		)
	)
)

