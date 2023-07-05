;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 325)
(include sci.sh)
(use Main)
(use dummyClient)
(use PuzzleIcon)
(use Interface)
(use LoadMany)
(use Window)
(use Sound)
(use System)

(public
	word 0
)

(local
	[local0 10] = [49 10 43 30 40 50 60 52 21 43]
	[local10 10] = [1 4 11 14 3 1 5 0 7 11]
	[local20 30] = [325 0 325 1 325 2 325 3 325 4 325 5 325 6 325 7 325 8 325 9 325 10 325 11 325 12 325 13 325 14]
	[local50 225]
	local275
	local276
	local277
	[local278 100] = [9 3 0 12 12 14 5 14 3 3 12 12 5 0 13 0 6 10 6 2 3 12 9 12 9 9 14 4 13 14 13 7 7 5 7 9 9 6 9 13 2 12 2 6 1 13 1 6 1 2 1 5 4 6 4 1 13 13 8 13 14 12 14 3 2 2 2 6 10 7 5 12 4 13 4 9 7 3 7 0 9 4 14 4 8 1 3 6 8 5 13 0 13 1 8 1 0 3 0 11]
	[local378 44] = [0 14 4 14 6 5 6 2 10 3 13 3 11 2 8 2 12 6 12 11 4 0 0 0 5 11 5 8 11 8 9 10 10 5 13 5 8 3 8 5 1 7 4 7]
	local422
	[local423 16]
	[local439 16] = [-1 1 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384]
	local455
	local456 = -1
	local457
	local458
	local459 = -1
	local460 = -100
	local461 = -100
	local462
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3)
	(Graph
		grFILL_BOX
		(= temp0 (+ 22 (* param3 9)))
		(= temp2 (+ 4 (* param2 11)))
		(= temp1 (+ temp0 8))
		(= temp3 (+ temp2 10))
		1
		param4
		-1
		-1
	)
	(Graph grUPDATE_BOX temp0 temp2 temp1 temp3 1)
	(Display
		@[local50 param1]
		dsCOORD
		(+ 5 (* param2 11))
		(+ 23 (* param3 9))
		dsFONT
		999
		dsCOLOR
		param5
	)
)

(procedure (localproc_1 param1 param2 param3 param4)
	(return
		(and
			(localproc_2 param1 param2)
			(== (localproc_6 param1) param3)
			(== (localproc_6 param2) param4)
		)
	)
)

(procedure (localproc_2 param1 param2)
	(return (or (^ (== param1 0) (== param2 0)) (== (Abs param1) (Abs param2))))
)

(procedure (localproc_3 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 15) ((++ temp0))
		(for ((= temp1 0)) (< temp1 15) ((++ temp1))
			(if (not (& [local423 temp0] [local439 (+ temp1 1)]))
				(localproc_0
					(+ (* temp0 15) temp1)
					temp1
					temp0
					[local0 2]
					[local0 1]
				)
			)
		)
	)
)

(procedure (localproc_4 &tmp [temp0 400])
	(cond
		((== local422 1)
			(Print 325 19 #at 65 6 #time 3) ; "Good going. You have found your first word."
		)
		((>= local422 local455)
			(proc5_15 sPlaySounds)
		)
		(else
			(Format ; "You have located %d words; you have %d left to go."
				@temp0
				325
				20
				local422
				(- local455 local422)
				local422
				(- local455 local422)
			)
			(Print @temp0 #at 65 6)
		)
	)
)

(procedure (localproc_5)
	(proc5_9 325 21)
	(proc5_9 325 22)
	(proc5_9 325 23)
	(switch global114
		(0
			(proc5_9 325 24)
			(= local455 18)
		)
		(1
			(= local455 22)
			(proc5_9 325 25)
		)
		(else
			(= local455 25)
			(proc5_9 325 26)
		)
	)
)

(procedure (localproc_6 param1)
	(return
		(if (== param1 0)
			0
		else
			(/ (Abs param1) param1)
		)
	)
)

(procedure (localproc_7 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 [temp4 4] temp8 temp9 temp10 [temp11 100])
	(if
		(not
			(and
				(<= 0 param1 14)
				(<= 0 param3 14)
				(<= 0 param2 14)
				(<= 0 param4 14)
			)
		)
		(localproc_3)
		(return)
	)
	(= temp0 (localproc_6 (- param3 param1)))
	(= temp1 (localproc_6 (- param4 param2)))
	(if (and temp0 temp1)
		(= temp10 (Max (Abs (- param3 param1)) (Abs (- param4 param2))))
		(if
			(or
				(!= param3 (+ param1 (* temp10 temp0)))
				(!= param4 (+ param2 (* temp10 temp1)))
			)
			(localproc_3)
		)
	)
	(= temp2 param1)
	(= temp3 param2)
	(= temp8
		(switch param5
			(1 [local0 6])
			(0 [local0 2])
			(2 [local0 8])
		)
	)
	(= temp9
		(switch param5
			(1 [local0 5])
			(0 [local0 1])
			(2 [local0 7])
		)
	)
	(repeat
		(cond
			((== param5 2)
				(|= [local423 temp3] [local439 (+ temp2 1)])
				(localproc_0 (+ (* temp3 15) temp2) temp2 temp3 temp8 temp9)
			)
			((== param5 0)
				(if (& [local423 temp3] [local439 (+ temp2 1)])
					(localproc_0
						(+ (* temp3 15) temp2)
						temp2
						temp3
						[local0 8]
						[local0 7]
					)
				else
					(localproc_0 (+ (* temp3 15) temp2) temp2 temp3 temp8 temp9)
				)
			)
			(else
				(localproc_0 (+ (* temp3 15) temp2) temp2 temp3 temp8 temp9)
			)
		)
		(breakif (and (== temp2 param3) (== temp3 param4)))
		(+= temp2 temp0)
		(+= temp3 temp1)
	)
)

(procedure (localproc_8 param1 param2 param3 param4 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 25) ((++ temp0))
		(= temp1 (* 4 temp0))
		(cond
			((and (== param1 param3) (== param2 param4))
				(return -1)
			)
			(
				(and
					(== param2 [local278 temp1])
					(== param1 [local278 (+ temp1 1)])
					(== param4 [local278 (+ temp1 2)])
					(== param3 [local278 (+ temp1 3)])
				)
				(= [local278 temp1] (- 0 [local278 temp1]))
				(= [local278 (+ temp1 1)] (- 0 [local278 (+ temp1 1)]))
				(= [local278 (+ temp1 2)] (- 0 [local278 (+ temp1 2)]))
				(= [local278 (+ temp1 3)] (- 0 [local278 (+ temp1 3)]))
				(return 1)
			)
			(
				(and
					(== (- 0 param2) [local278 temp1])
					(== (- 0 param1) [local278 (+ temp1 1)])
					(== (- 0 param4) [local278 (+ temp1 2)])
					(== (- 0 param3) [local278 (+ temp1 3)])
				)
				(return 2)
			)
			(
				(and
					(== param2 [local378 temp1])
					(== param1 [local378 (+ temp1 1)])
					(== param4 [local378 (+ temp1 2)])
					(== param3 [local378 (+ temp1 3)])
				)
				(return 3)
			)
		)
	)
	(return 0)
)

(procedure (localproc_9 param1 &tmp temp0 temp1)
	(= temp0 (param1 x:))
	(= temp1 (param1 y:))
	(if (not local457)
		(return)
	)
	(switch (param1 message:)
		(1
			(gGame setCursor: gTheCursor 1 temp0 (- temp1 9))
		)
		(8
			(if (not (or (== temp0 9) (== temp1 26)))
				(gGame setCursor: gTheCursor 1 (- temp0 11) (- temp1 9))
			)
		)
		(2
			(if (not (or (== temp0 163) (== temp1 26)))
				(gGame setCursor: gTheCursor 1 (+ temp0 11) (- temp1 9))
			)
		)
		(5
			(if (!= temp1 152)
				(gGame setCursor: gTheCursor 1 temp0 (+ temp1 9))
			)
		)
		(4
			(if (not (or (== temp0 163) (== temp1 152)))
				(gGame setCursor: gTheCursor 1 (+ temp0 11) (+ temp1 9))
			)
		)
		(6
			(if (not (or (== temp0 9) (== temp1 152)))
				(gGame setCursor: gTheCursor 1 (- temp0 11) (+ temp1 9))
			)
		)
		(7
			(cond
				((and (== temp0 9) (!= temp1 26))
					(gGame setCursor: gTheCursor 1 163 (- temp1 9))
				)
				((!= temp0 9)
					(gGame setCursor: gTheCursor 1 (- temp0 11) temp1)
				)
			)
		)
		(3
			(cond
				((and (!= temp1 152) (== temp0 163))
					(gGame setCursor: gTheCursor 1 9 (+ temp1 9))
				)
				((!= temp0 163)
					(gGame setCursor: gTheCursor 1 (+ temp0 11) temp1)
				)
			)
		)
	)
)

(procedure (localproc_10 param1 &tmp temp0 temp1)
	(= temp0 (param1 x:))
	(= temp1 (param1 y:))
	(return (and (> temp0 0) (> temp1 20) (< temp0 168) (< temp1 161)))
)

(instance word of PuzzleBar
	(properties
		puzzleHeight 169
		bottomHeight 0
		solvedFlag 10
	)

	(method (init &tmp temp0)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
				(= [local0 temp0] [local10 temp0])
			)
		)
		(= window wordWindow)
		(wordWindow back: [local0 9])
		(LoadMany rsSOUND 50 51 54 56 104 967)
		(super init: &rest)
		(self show:)
		(= local459 global114)
	)

	(method (show)
		(super show: &rest)
		(if (IsFlag 10)
			((ScriptID 377 1) init:) ; theWord
		)
	)

	(method (buyClue &tmp temp0 temp1)
		(if (super buyClue:)
			(for ((= temp0 0)) (< temp0 25) ((++ temp0))
				(if (>= [local278 (= temp1 (* 4 temp0))] 0)
					(localproc_7
						[local278 (+ temp1 1)]
						[local278 temp1]
						[local278 (+ temp1 3)]
						[local278 (+ temp1 2)]
						1
						8
					)
					(Wait 0)
					(Wait 60)
					(localproc_7
						[local278 (+ temp1 1)]
						[local278 temp1]
						[local278 (+ temp1 3)]
						[local278 (+ temp1 2)]
						2
						8
					)
					(Wait 60)
					(++ local422)
					(localproc_4)
					(= [local278 temp1] (- 0 [local278 temp1]))
					(return)
				)
			)
		)
	)

	(method (showHelp)
		(localproc_5)
		(localproc_4)
	)

	(method (animateOnce)
		(Animate (gCast elements:) 1)
		(if gModelessDialog
			(gModelessDialog check:)
		)
		(return 1)
	)

	(method (dispatchEvent event &tmp temp0 [temp1 2] temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 [temp25 24] temp49 temp50)
		(= temp0 (event type:))
		(= temp4 (event x:))
		(= temp5 (event y:))
		(if (not (localproc_10 event))
			(= local457 0)
		)
		(if (& temp0 $0040) ; direction
			(switch (event message:)
				(JOY_DOWN
					(if (not local457)
						(= local457 1)
						(gGame setCursor: gTheCursor 1 9 26)
					)
				)
				(JOY_UP
					(if (< temp5 26)
						(= local457 0)
					)
				)
			)
		)
		(if (not local457)
			(= temp3 (self firstTrue: #onMe event))
		)
		(= temp20 1)
		(= temp6 (/ (- temp4 5) 11))
		(= temp7 (/ (- temp5 23) 9))
		(cond
			((and (<= 0 temp6 14) (<= 0 temp7 14))
				(= temp8 (+ (* temp7 15) temp6))
				(if (or (& temp0 evKEYBOARD) (& temp0 $0040)) ; direction
					(if (and (not local457) (>= temp5 26))
						(= local457 1)
					)
					(if
						(not
							(and
								(not (mod (- temp4 9) 11))
								(not (mod (- temp5 26) 9))
							)
						)
						(= local462 1)
					)
					(if local462
						(gGame
							setCursor:
								gTheCursor
								1
								(= temp49 (+ 9 (* temp6 11)))
								(= temp50 (+ 26 (* temp7 9)))
						)
						(= local462 0)
						(event x: temp49 y: temp50)
					)
					(localproc_9 event)
				)
				(if (== (event message:) KEY_RETURN)
					(= temp0 evMOUSEBUTTON)
				)
				(switch temp0
					(evNULL
						(if (!= temp8 local275)
							(localproc_0
								temp8
								temp6
								temp7
								[local0 4]
								[local0 3]
							)
							(if
								(&
									[local423 local277]
									[local439 (+ local276 1)]
								)
								(localproc_0
									local275
									local276
									local277
									[local0 8]
									[local0 7]
								)
							else
								(localproc_0
									local275
									local276
									local277
									[local0 2]
									[local0 1]
								)
							)
						)
						(= local275 temp8)
						(= local276 temp6)
						(= local277 temp7)
					)
					(evMOUSEBUTTON
						(= temp12 (/ (- temp4 5) 11))
						(= temp13 (/ (- temp5 23) 9))
						(= temp16 temp12)
						(= temp17 temp13)
						(localproc_0
							(+ (* temp13 15) temp12)
							temp12
							temp13
							[local0 6]
							[local0 5]
						)
						(= temp18 (= temp19 0))
						(while
							(and
								(!= ((= temp9 (Event new:)) type:) evMOUSERELEASE)
								(!= (temp9 type:) evJOYDOWN)
								(!= (temp9 message:) KEY_RETURN)
							)
							(temp9 localize:)
							(MapKeyToDir temp9)
							(if local457
								(MapKeyToDir temp9)
								(localproc_9 temp9)
							)
							(= temp10 (temp9 x:))
							(= temp11 (temp9 y:))
							(= temp14 (/ (- temp10 5) 11))
							(= temp15 (/ (- temp11 23) 9))
							(cond
								(
									(and
										(== temp20 1)
										(or
											(!= temp14 temp12)
											(!= temp15 temp13)
										)
										(localproc_2
											(- temp14 temp12)
											(- temp15 temp13)
										)
									)
									(= temp20 0)
									(= temp18 (- temp14 temp12))
									(= temp19 (- temp15 temp13))
									(= temp16 temp14)
									(= temp17 temp15)
								)
								((not (and (<= 0 temp14 14) (<= 0 temp15 14))) 0)
								(
									(and
										(localproc_1
											(- temp14 temp16)
											(- temp15 temp17)
											temp18
											temp19
										)
										(not
											(and
												(== temp14 temp16)
												(== temp15 temp17)
											)
										)
									)
									(localproc_7
										temp16
										temp17
										temp14
										temp15
										1
										1
									)
									(= temp16 temp14)
									(= temp17 temp15)
								)
								(
									(and
										(localproc_1
											(- temp16 temp14)
											(- temp17 temp15)
											temp18
											temp19
										)
										(not
											(and
												(== temp14 temp16)
												(== temp15 temp17)
											)
										)
									)
									(if
										(and
											(== temp14 temp12)
											(== temp15 temp13)
										)
										(= temp20 1)
									)
									(localproc_7
										(+ temp14 temp18)
										(+ temp15 temp19)
										temp16
										temp17
										0
										2
									)
									(= temp16 temp14)
									(= temp17 temp15)
								)
								(
									(and
										(== temp20 0)
										(not
											(and
												(== temp14 temp16)
												(== temp15 temp17)
											)
										)
										(localproc_2
											(= temp21 (- temp14 temp12))
											(= temp22 (- temp15 temp13))
										)
									)
									(= temp23 (localproc_6 temp21))
									(= temp24 (localproc_6 temp22))
									(localproc_7
										temp12
										temp13
										temp16
										temp17
										0
										3
									)
									(localproc_7
										temp12
										temp13
										temp14
										temp15
										1
										4
									)
									(= temp18 temp23)
									(= temp19 temp24)
									(= temp16 temp14)
									(= temp17 temp15)
								)
							)
							(temp9 dispose:)
						)
						(temp9 dispose:)
						(switch (localproc_8 temp12 temp13 temp14 temp15)
							(1
								(rightSound play:)
								(++ local422)
								(localproc_4)
								(localproc_7 temp12 temp13 temp16 temp17 2 5)
							)
							(2
								(oldSound play:)
								(proc5_9 325 15)
								(localproc_7 temp12 temp13 temp16 temp17 2 5)
							)
							(3
								(squawkSound play:)
								(localproc_7 temp12 temp13 temp16 temp17 0 6)
								(proc5_9 325 16)
								(localproc_3)
							)
							(0
								(wrongSound play:)
								(localproc_7 temp12 temp13 temp16 temp17 0 6)
								(proc5_9 325 17)
								(localproc_3)
							)
						)
					)
				)
			)
			((or (!= local276 local460) (!= local277 local461))
				(localproc_7 local276 local277 local276 local277 0 7)
				(= local460 local276)
				(= local461 local277)
			)
		)
		(event claimed: 0)
		(if (not local457)
			(if (super dispatchEvent: event)
				(return 1)
			else
				(return 0)
			)
		else
			(event dispose:)
			(return 0)
		)
	)
)

(instance rightSound of Sound
	(properties
		flags 1
		number 50
	)
)

(instance wrongSound of Sound
	(properties
		flags 1
		number 56
	)
)

(instance oldSound of Sound
	(properties
		flags 1
		number 54
	)
)

(instance squawkSound of Sound
	(properties
		flags 1
		number 104
	)
)

(instance rewardSound of Sound
	(properties
		flags 1
		number 51
	)
)

(instance wordWindow of SysWindow
	(properties
		top 19
		left 79
		bottom 180
		right 247
	)

	(method (open &tmp temp0 temp1 [temp2 75] temp77 temp78 temp79 temp80)
		(super open:)
		(= temp78 5)
		(= temp79 23)
		(= temp80 0)
		(for ((= temp0 0)) (< temp0 30) ((+= temp0 2))
			(Format @temp2 [local20 temp0] [local20 (+ temp0 1)] &rest)
			(for ((= temp1 0)) (< temp1 15) ((++ temp1))
				(= temp77
					(= [local50 (+ (* 15 (/ temp0 2)) temp1)]
						(StrAt @temp2 temp1)
					)
				)
				(Display
					@temp77
					dsCOORD
					temp78
					temp79
					dsFONT
					999
					dsCOLOR
					[local0 1]
					dsBACKGROUND
					[local0 2]
				)
				(if (& [local423 (/ temp0 2)] [local439 (+ temp1 1)])
					(localproc_0
						(+ (* (/ temp0 2) 15) temp1)
						temp1
						(/ temp0 2)
						[local0 8]
						[local0 7]
					)
				)
				(+= temp78 11)
				(if (and (== temp80 0) (!= temp1 14))
					(Graph grDRAW_LINE 22 (- temp78 2) 156 (- temp78 2) [local0 0] -1 -1)
					(Graph grUPDATE_BOX 23 (- temp78 3) 156 (- temp78 1) 1)
				)
			)
			(= temp80 1)
			(= temp78 5)
			(+= temp79 9)
			(if (!= temp0 28)
				(Graph grDRAW_LINE (- temp79 2) 4 (- temp79 2) 168 [local0 0] -1 -1)
				(Graph grUPDATE_BOX (- temp79 3) 5 (- temp79 1) 168 1)
			)
		)
		(if (or (not local458) (!= local459 global114))
			(localproc_5)
			(= local458 1)
		)
		(localproc_4)
		(gGame setCursor: gTheCursor 1 9 26)
	)
)

(instance sPlaySounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rewardSound play: self)
			)
			(1
				(proc5_14 325 18 local422 local422)
				(= cycles 1)
			)
			(2
				(gCMusic2
					number: 967
					flags: 1
					setLoop: 1
					setVol: 127
					play: self
				)
			)
			(3
				(word solvePuzzle: goAway:)
				(= client 0)
				(self dispose:)
			)
		)
	)
)

