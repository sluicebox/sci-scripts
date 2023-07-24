;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 427)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use LoadMany)
(use Window)
(use Sound)

(public
	concentrate 0
	proc427_1 1
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
	local10
	local11
	local12
	[local13 16]
	[local29 16] = [431 431 431 431 430 430 430 430 433 433 433 433 432 432 432 432]
	[local45 16] = [1 1 1 1 2 2 2 2 1 1 1 1 2 2 2 2]
	[local61 16] = [0 1 2 3 0 1 2 3 4 5 6 7 4 5 6 7]
	[local77 16] = [0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15]
	[local93 16]
	local109
	local110
	local111
	local112
	local113
	[local114 34] = [427 0 427 1 427 2 427 3 427 4 427 5 427 6 427 7 427 8 427 9 427 10 427 11 427 12 427 13 427 14 427 15 0 0]
	local148
	local149
	local150
	local151
	local152
	local153
	local154
	local155
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 250])
	(= temp0 (GetPort))
	(SetPort 0)
	(= temp3 (localproc_1 param1 param2))
	(= temp1 (if (== param3 1) 7 else 223))
	(= temp2 92)
	(proc5_19
		0
		(proc0_3 3 300 3003 300 300)
		82
		[local114 (* 2 temp3)]
		[local114 (+ (* 2 temp3) 1)]
	)
	(= temp5 (- temp1 3))
	(= temp7 (+ temp1 3 global177))
	(= temp6 (- temp2 3))
	(= temp8 (+ temp2 3 global178))
	(= temp4 (Graph grSAVE_BOX temp6 temp5 temp8 temp7 1))
	(Graph grFILL_BOX temp6 temp5 temp8 temp7 1 0 -1 -1)
	(Graph grUPDATE_BOX temp6 temp5 temp8 temp7 1)
	(Display
		[local114 (* 2 temp3)]
		[local114 (+ (* 2 temp3) 1)]
		dsWIDTH
		82
		dsCOORD
		temp1
		temp2
		dsFONT
		(proc0_3 3 300 3003 300 300)
		dsCOLOR
		(proc0_1 29 14 global135)
	)
	(if (== param3 1)
		(= local0 temp4)
		(= local2 temp5)
		(= local3 temp7)
		(= local4 temp6)
		(= local5 temp8)
	else
		(= local1 temp4)
		(= local6 temp5)
		(= local7 temp7)
		(= local8 temp6)
		(= local9 temp8)
	)
	(SetPort temp0)
)

(procedure (localproc_1 param1 param2 &tmp temp0)
	(= temp0 (- param1 430))
	(return (+ (* 4 temp0) param2))
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 [temp4 16])
	(= temp1 15)
	(for ((= temp0 0)) (< temp0 16) ((++ temp0))
		(= [temp4 temp0] temp0)
	)
	(for ((= temp0 0)) (< temp0 16) ((++ temp0))
		(= [local77 temp0] [temp4 (= temp3 (Random 0 temp1))])
		(for ((= temp2 temp3)) (< temp2 temp1) ((++ temp2))
			(= [temp4 temp2] [temp4 (+ temp2 1)])
		)
		(-- temp1)
	)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 16) ((++ temp0))
		(if (not [local93 temp0])
			(return 0)
		)
	)
	(return 1)
)

(procedure (proc427_1)
	(if (IsObject concentrate)
		(concentrate dispose:)
	)
	(if (IsObject cardSound)
		(cardSound dispose:)
	)
	(if (IsObject rewardSound)
		(rewardSound dispose:)
	)
)

(procedure (localproc_4 param1 param2 &tmp temp0)
	(if (< param2 param1)
		(= temp0 param1)
		(= param1 param2)
		(= param2 temp0)
	)
	(return
		(or
			(and (== param1 430) (== param2 431))
			(and (== param1 432) (== param2 433))
		)
	)
)

(procedure (localproc_5 &tmp temp0)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph grRESTORE_BOX local0)
	(Graph grRESTORE_BOX local1)
	(Graph grRESTORE_BOX local148)
	(Graph grRESTORE_BOX local149)
	(Graph grUPDATE_BOX local4 local2 local5 local3 1)
	(Graph grUPDATE_BOX local8 local6 local9 local7 1)
	(Graph grUPDATE_BOX 0 13 (+ 0 local154) (+ 13 local155) 1)
	(Graph grUPDATE_BOX 0 216 (+ 0 local154) (+ 216 local155) 1)
	(SetPort temp0)
)

(instance concentrate of PuzzleBar
	(properties
		puzzleHeight 169
		bottomHeight 0
		solvedFlag 36
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= window alienWindow)
		(= local155 (CelWide 435 3 0))
		(= local154 (CelHigh 435 3 0))
		(gGame setCursor: gWaitCursor)
		(LoadMany rsVIEW 430 431 432 433 435)
		(if (not local11)
			(= temp1 0)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(= temp4 2)
				(for ((= temp3 0)) (< temp3 4) ((++ temp3))
					(if (not local11)
						(= temp2 (alienIcon new:))
						(temp2
							view: 435
							nsLeft: temp4
							nsTop: (+ temp1 24)
							value: (+ (* 4 temp0) temp3)
							loop: 0
							cel: 0
						)
						(self add: temp2)
					)
					(+= temp4 30)
				)
				(+= temp1 40)
			)
			(localproc_2)
			(super init: &rest)
		)
		(self show:)
	)

	(method (show &tmp [temp0 6])
		(= highlightedIcon (self at: (- size 3)))
		((ScriptID 420 4) stopUpd:) ; Globespinning
		(gGame setCursor: 8)
		(super show: &rest)
		((ScriptID 420 4) startUpd:) ; Globespinning
		(= local11 1)
		(= local12 0)
		(= local109 0)
		(if (== local110 1)
			(Animate (gCast elements:) 0)
			(Graph grRESTORE_BOX local0)
			(Graph grUPDATE_BOX local4 local2 local5 local3 1)
			(= local111 0)
		)
		(= local110 0)
		(localproc_5)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if (and (<= local110 1) (super buyClue:))
			(if (== local110 1)
				(= temp5 [local29 (= temp3 [local77 (local111 value:)])])
				(= temp6 [local13 temp3])
				(= temp7 (mod temp3 4))
			else
				(for ((= temp0 0)) (< temp0 16) ((++ temp0))
					(= temp1 (concentrate at: temp0))
					(if (!= [local93 (temp1 value:)] 1)
						(= temp2 (+ temp0 1))
						(= temp5 [local29 (= temp3 [local77 (temp1 value:)])])
						(= temp6 [local13 temp3])
						(= temp7 (mod temp3 4))
						(temp1 select:)
						(break)
					)
				)
			)
			(for ((= temp0 temp2)) (< temp0 16) ((++ temp0))
				(= temp1 (concentrate at: temp0))
				(= temp4 [local77 (temp1 value:)])
				(if
					(and
						(localproc_4 temp5 [local29 temp4])
						(== temp7 (mod temp4 4))
					)
					(temp1 select:)
					(break)
				)
			)
		)
	)

	(method (showHelp)
		(proc5_9 427 16) ; "These aliens have lost their homes. Pick any two face-down cards and try to match an alien with its home planet. When you make a successful match, the cards will turn face-up."
		(proc5_9 427 17) ; "Inserting a hint coin will buy you one match."
	)

	(method (animateOnce)
		(Animate (gCast elements:) 1)
		(return 1)
	)

	(method (dispatchEvent event &tmp temp0 [temp1 3] temp4 temp5 temp6 temp7 temp8)
		(if (and local11 (not local12))
			(for ((= temp4 0)) (< temp4 16) ((++ temp4))
				(= temp5 (concentrate at: temp4))
				(= temp6 [local77 (temp5 value:)])
				(if [local93 temp4]
					(DrawCel
						435
						[local45 temp6]
						[local61 temp6]
						(temp5 nsLeft:)
						(temp5 nsTop:)
						-1
					)
				)
			)
			(= local12 1)
		)
		(if (not local109)
			(proc5_9 427 16) ; "These aliens have lost their homes. Pick any two face-down cards and try to match an alien with its home planet. When you make a successful match, the cards will turn face-up."
			(= local109 1)
		)
		(= temp0 (event type:))
		(= temp7 (self indexOf: highlightedIcon))
		(if (& temp0 $0040) ; direction
			(switch (event message:)
				(JOY_DOWN
					(if (highlightedIcon isKindOf: CodeIcon)
						(if (< temp7 12)
							(= temp8 (self at: (+ temp7 4)))
						else
							(= temp8 (self at: (- size 3)))
						)
					else
						(= temp8 (self at: 0))
					)
					(proc5_20 temp8)
					(self highlight: temp8)
				)
				(JOY_UP
					(if (highlightedIcon isKindOf: CodeIcon)
						(if (>= temp7 4)
							(= temp8 (self at: (- temp7 4)))
						else
							(= temp8 (self at: (- size 3)))
						)
					else
						(= temp8 (self at: (- size 5)))
					)
					(proc5_20 temp8)
					(self highlight: temp8)
				)
			)
		)
		(event claimed: 0)
		(if (super dispatchEvent: event)
			(return 1)
		else
			(return 0)
		)
	)

	(method (goAway)
		(super goAway: &rest)
	)
)

(instance alienWindow of SysWindow
	(properties
		top 2
		left 95
		bottom 187
		right 215
		back 0
	)
)

(instance cardSound of Sound
	(properties
		flags 1
		number 61
	)
)

(instance rewardSound of Sound
	(properties
		flags 1
		number 50
	)
)

(instance alienIcon of CodeIcon
	(properties
		view 426
		cursor 999
		helpStr {This icon selects picture.}
		highlightColor 7
	)

	(method (highlight)
		(if (!= [local93 value] 1)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if
			(and
				(< local110 2)
				(!= self local111)
				(!= [local93 value] 1)
				(super select: &rest)
			)
			(++ local110)
			(cardSound play:)
			(if (== local110 2)
				(= local112 self)
				(= local151 [local29 (= temp2 [local77 value])])
				(= temp4 [local13 temp2])
				(= local153 (mod temp2 4))
				(= temp6 (GetPort))
				(SetPort 0)
				(= local149
					(Graph grSAVE_BOX 0 216 (+ 0 local154) (+ 216 local155) 1 -1)
				)
				(DrawCel 435 3 0 216 0 -1)
				(DrawCel local151 temp4 local153 220 3 -1)
				(SetPort temp6)
				(DrawCel
					435
					[local45 temp2]
					[local61 temp2]
					(local112 nsLeft:)
					(local112 nsTop:)
					-1
				)
				(localproc_0 local151 local153 2)
				(Animate (gCast elements:) 0)
				(if (and (localproc_4 local150 local151) (== local152 local153))
					(= [local93 (local111 value:)] 1)
					(= [local93 value] 1)
					(proc5_15 match)
					(if local10
						(= local10 0)
						(gCurRoom setScript: (ScriptID 420 5)) ; monoAppears
					)
				else
					(proc5_15 noMatch)
					(self show:)
					(local113 show:)
				)
				(= local113 0)
			else
				(= local111 self)
				(= local113 self)
				(= local150 [local29 (= temp1 [local77 (local111 value:)])])
				(= temp4 [local13 temp1])
				(= local152 (mod temp1 4))
				(= temp6 (GetPort))
				(SetPort 0)
				(= local148 (Graph grSAVE_BOX 0 13 (+ 0 local154) (+ 13 local155) 1 -1))
				(DrawCel 435 3 0 13 0 -1)
				(DrawCel local150 temp4 local152 17 3 -1)
				(SetPort temp6)
				(DrawCel
					435
					[local45 temp1]
					[local61 temp1]
					(local111 nsLeft:)
					(local111 nsTop:)
					-1
				)
				(Animate (gCast elements:) 0)
				(localproc_0 local150 local152 1)
			)
		)
	)
)

(instance noMatch of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc5_11 427 18) ; "That match won't work out. Please try again."
				(= cycles 1)
			)
			(1
				(localproc_5)
				(Animate (gCast elements:) 0)
				(= cycles 1)
			)
			(2
				(= local110 0)
				(= local111 0)
				(= local112 0)
				(= client 0)
				(self dispose:)
			)
		)
	)
)

(instance match of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 3] temp3 temp4)
		(switch (= state newState)
			(0
				(rewardSound play:)
				(proc5_11 427 19) ; "Great! You have matched the creature with his home. He'll be much happier now."
				(= cycles 1)
			)
			(1
				(localproc_5)
				(Animate (gCast elements:) 0)
				(= cycles 1)
			)
			(2
				(= temp3 [local77 (local111 value:)])
				(= temp4 [local77 (local112 value:)])
				(DrawCel
					435
					[local45 temp3]
					[local61 temp3]
					(local111 nsLeft:)
					(local111 nsTop:)
					-1
				)
				(DrawCel
					435
					[local45 temp4]
					[local61 temp4]
					(local112 nsLeft:)
					(local112 nsTop:)
					-1
				)
				(= cycles 1)
			)
			(3
				(if (localproc_3)
					(Wait 0)
					(Wait 60)
					(rewardSound number: 52 play:)
					(proc5_9 427 20) ; "Well done! You've performed a major feat of intergalactic diplomacy by helping all the aliens return home. You are awarded the Star Medal, 1st Class."
					(gEgo get: 24)
					(concentrate solvePuzzle: 2 goAway:)
					(= local10 1)
				)
				(= local110 0)
				(= client 0)
			)
		)
	)
)

