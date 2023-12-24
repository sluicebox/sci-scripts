;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use dummyClient)
(use PuzzleIcon)
(use Window)
(use System)

(public
	word 0
)

(local
	[local0 10] = [49 10 121 30 40 50 146 52 91 112]
	local10
	local11
	local12
	[local13 225]
	local238
	local239
	local240
	local241
	local242
	local243
	local244
	[local245 16] = [-1 1 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384]
	local261
	local262 = -1
	local263
	local264
	local265 = -1
	local266 = -100
	local267 = -100
	local268
)

(procedure (localproc_0 param1 param2 &tmp [temp0 15])
	(Message
		msgGET
		190
		1
		0
		(switch (/ (WordAt local12 param1) 36)
			(0 1)
			(1 3)
			(2 5)
		)
		(+ 1 (mod (WordAt local12 param1) 36))
		@temp0
	)
	(Display @temp0 dsCOORD 166 (+ 22 (* param1 7)) dsFONT 888 dsCOLOR param2)
	(Message
		msgGET
		190
		1
		0
		(switch (+ local241 (/ (WordAt local12 param1) 36))
			(0 8)
			(1 10)
			(2 15)
			(3 7)
			(4 12)
			(5 13)
			(6 6)
			(7 11)
			(8 14)
		)
		(+ 1 (mod (WordAt local12 param1) 36))
		@temp0
	)
	(Display @temp0 dsCOORD 243 (+ 22 (* param1 7)) dsFONT 888 dsCOLOR param2)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3)
	(Graph
		grFILL_BOX
		(= temp0 (+ 24 (* param3 9)))
		(= temp2 (+ 0 (* param2 11)))
		(= temp1 (+ temp0 8))
		(= temp3 (+ temp2 10))
		1
		param4
		-1
		-1
	)
	(Graph grUPDATE_BOX temp0 temp2 temp1 temp3 1)
	(Display
		@[local13 param1]
		dsCOORD
		(+ 1 (* param2 11))
		(+ 25 (* param3 9))
		dsFONT
		888
		dsCOLOR
		param5
	)
)

(procedure (localproc_2 param1 param2 param3 param4)
	(return
		(and
			(localproc_3 param1 param2)
			(== (localproc_6 param1) param3)
			(== (localproc_6 param2) param4)
		)
	)
)

(procedure (localproc_3 param1 param2)
	(return (or (^ (== param1 0) (== param2 0)) (== (Abs param1) (Abs param2))))
)

(procedure (localproc_4 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 15) ((++ temp0))
		(for ((= temp1 0)) (< temp1 15) ((++ temp1))
			(if (not (& (WordAt local244 temp0) [local245 (+ temp1 1)]))
				(localproc_1
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

(procedure (localproc_5 &tmp [temp0 100])
	(cond
		((== (Memory memPEEK local243) 1)
			(sayIt doit: 2 0 4)
		)
		((== (Memory memPEEK local243) local261)
			(proc5_14 sPlaySounds)
		)
		((< (Memory memPEEK local243) local261)
			(Message msgGET (word msgModule:) 2 0 13 1 @temp0)
			(proc15_4
				word
				99
				@temp0
				(Memory memPEEK local243)
				(- local261 (Memory memPEEK local243))
			)
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
		(localproc_4)
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
			(localproc_4)
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
				(Memory
					memPOKE
					(+ local244 (* 2 temp3))
					(| (WordAt local244 temp3) [local245 (+ temp2 1)])
				)
				(localproc_1 (+ (* temp3 15) temp2) temp2 temp3 temp8 temp9)
			)
			((== param5 0)
				(if (& (WordAt local244 temp3) [local245 (+ temp2 1)])
					(localproc_1
						(+ (* temp3 15) temp2)
						temp2
						temp3
						[local0 8]
						[local0 7]
					)
				else
					(localproc_1 (+ (* temp3 15) temp2) temp2 temp3 temp8 temp9)
				)
			)
			(else
				(localproc_1 (+ (* temp3 15) temp2) temp2 temp3 temp8 temp9)
			)
		)
		(breakif (and (== temp2 param3) (== temp3 param4)))
		(+= temp2 temp0)
		(+= temp3 temp1)
	)
)

(procedure (localproc_8 param1 param2 param3 param4 &tmp temp0 temp1 [temp2 15] temp17 temp18 temp19 temp20 temp21 temp22)
	(for ((= temp0 0)) (< temp0 20) ((++ temp0))
		(= temp1 (* 4 temp0))
		(cond
			((and (== param1 param3) (== param2 param4))
				(return -1)
			)
			(
				(and
					(== param2 (WordAt local11 temp1))
					(== param1 (WordAt local11 (+ temp1 1)))
					(== param4 (WordAt local11 (+ temp1 2)))
					(== param3 (WordAt local11 (+ temp1 3)))
				)
				(Memory
					memPOKE
					(+ local11 (* 2 temp1))
					(| $8000 (WordAt local11 temp1))
				)
				(Memory
					memPOKE
					(+ local11 (* 2 (+ temp1 1)))
					(| $8000 (WordAt local11 (+ temp1 1)))
				)
				(Memory
					memPOKE
					(+ local11 (* 2 (+ temp1 2)))
					(| $8000 (WordAt local11 (+ temp1 2)))
				)
				(Memory
					memPOKE
					(+ local11 (* 2 (+ temp1 3)))
					(| $8000 (WordAt local11 (+ temp1 3)))
				)
				(return temp0)
			)
			(
				(and
					(== (| $8000 param2) (WordAt local11 temp1))
					(== (| $8000 param1) (WordAt local11 (+ temp1 1)))
					(== (| $8000 param4) (WordAt local11 (+ temp1 2)))
					(== (| $8000 param3) (WordAt local11 (+ temp1 3)))
				)
				(return -2)
			)
			(
				(Message
					msgGET
					190
					1
					0
					(switch (+ local241 (/ (WordAt local12 temp0) 36))
						(0 8)
						(1 10)
						(2 15)
						(3 7)
						(4 12)
						(5 13)
						(6 6)
						(7 11)
						(8 14)
					)
					(+ 1 (mod (WordAt local12 temp0) 36))
					@temp2
				)
				(= temp22
					(Max (Abs (- param3 param1)) (Abs (- param4 param2)))
				)
				(= temp17 0)
				(= temp18 param1)
				(= temp19 param2)
				(= temp20 (localproc_6 (- param3 param1)))
				(= temp21 (localproc_6 (- param4 param2)))
				(while (<= temp17 temp22)
					(if
						(or
							(!=
								(StrAt @temp2 temp17)
								[local13 (+ (* 15 temp19) temp18)]
							)
							(not (StrAt @temp2 temp17))
						)
						(break)
					)
					(+= temp18 temp20)
					(+= temp19 temp21)
					(++ temp17)
				)
				(if (and (> temp17 temp22) (not (StrAt @temp2 temp17)))
					(if (& (WordAt local11 temp1) $8000)
						(return -2)
					else
						(Memory memPOKE (+ local11 (* 2 temp1)) (| $8000 param2))
						(Memory
							memPOKE
							(+ local11 (* 2 (+ temp1 1)))
							(| $8000 param1)
						)
						(Memory
							memPOKE
							(+ local11 (* 2 (+ temp1 2)))
							(| $8000 param4)
						)
						(Memory
							memPOKE
							(+ local11 (* 2 (+ temp1 3)))
							(| $8000 param3)
						)
						(return temp0)
					)
				)
			)
		)
	)
	(return -4)
)

(procedure (localproc_9 param1 &tmp temp0 temp1)
	(= temp0 (param1 x:))
	(= temp1 (param1 y:))
	(if (not local263)
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
		solvedFlag 24
		noun 2
		personalID 4
	)

	(method (init param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= local10 param1)
		(= local11 param2)
		(= local12 param3)
		(= local244 param4)
		(= local243 param5)
		(= local242 param6)
		(= local241 (Memory memPEEK local242))
		(= window wordWindow)
		(wordWindow back: [local0 9])
		(super init: &rest)
		(= local265 gDifficulty)
	)

	(method (buyClue &tmp temp0)
		(if (super buyClue:)
			(for ((= temp0 0)) (< temp0 80) ((+= temp0 4))
				(if (>= (WordAt local11 temp0) 0)
					(localproc_7
						(WordAt local11 (+ temp0 1))
						(WordAt local11 temp0)
						(WordAt local11 (+ temp0 3))
						(WordAt local11 (+ temp0 2))
						1
						8
					)
					(localproc_0 (/ temp0 4) [local0 7])
					(Wait 0)
					(Wait 40)
					(localproc_7
						(WordAt local11 (+ temp0 1))
						(WordAt local11 temp0)
						(WordAt local11 (+ temp0 3))
						(WordAt local11 (+ temp0 2))
						2
						8
					)
					(Wait 10)
					(Memory memPOKE local243 (+ 1 (Memory memPEEK local243)))
					(localproc_5)
					(localproc_0
						(localproc_8
							(WordAt local11 (+ temp0 1))
							(WordAt local11 temp0)
							(WordAt local11 (+ temp0 3))
							(WordAt local11 (+ temp0 2))
						)
						[local0 5]
					)
					(return)
				)
			)
		)
	)

	(method (showHelp)
		(= local261
			(switch gDifficulty
				(0 10) ; Novice
				(1 15) ; Standard
				(else 20)
			)
		)
		(super showHelp: &rest)
		(localproc_5)
	)

	(method (animateOnce)
		(if gModelessDialog
			(gModelessDialog check:)
		)
		(return 1)
	)

	(method (dispatchEvent event &tmp temp0 [temp1 2] temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 [temp25 24] temp49 temp50 temp51)
		(= temp0 (event type:))
		(= temp4 (event x:))
		(= temp5 (event y:))
		(if (not (localproc_10 event))
			(= local263 0)
		)
		(if (& temp0 $0040) ; direction
			(switch (event message:)
				(JOY_DOWN
					(if (not local263)
						(= local263 1)
						(gGame setCursor: gTheCursor 1 9 26)
					)
				)
				(JOY_UP
					(if (< temp5 26)
						(= local263 0)
					)
				)
			)
		)
		(if (not local263)
			(= temp3 (self firstTrue: #onMe event))
		)
		(= temp20 1)
		(= temp6 (/ (- temp4 1) 11))
		(= temp7 (/ (- temp5 25) 9))
		(cond
			((and (<= 0 temp6 14) (<= 0 temp7 14))
				(= temp8 (+ (* temp7 15) temp6))
				(if (or (& temp0 evKEYBOARD) (& temp0 $0040)) ; direction
					(if (and (not local263) (>= temp5 26))
						(= local263 1)
					)
					(if
						(not
							(and
								(not (mod (- temp4 9) 11))
								(not (mod (- temp5 26) 9))
							)
						)
						(= local268 1)
					)
					(if local268
						(gGame
							setCursor:
								gTheCursor
								1
								(= temp49 (+ 9 (* temp6 11)))
								(= temp50 (+ 26 (* temp7 9)))
						)
						(= local268 0)
						(event x: temp49 y: temp50)
					)
					(localproc_9 event)
				)
				(if (== (event message:) KEY_RETURN)
					(= temp0 evMOUSEBUTTON)
				)
				(switch temp0
					(evNULL
						(if (!= temp8 local238)
							(localproc_1
								temp8
								temp6
								temp7
								[local0 4]
								[local0 3]
							)
							(if
								(&
									(WordAt local244 local240)
									[local245 (+ local239 1)]
								)
								(localproc_1
									local238
									local239
									local240
									[local0 8]
									[local0 7]
								)
							else
								(localproc_1
									local238
									local239
									local240
									[local0 2]
									[local0 1]
								)
							)
						)
						(= local238 temp8)
						(= local239 temp6)
						(= local240 temp7)
					)
					(evMOUSEBUTTON
						(= temp12 (/ (- temp4 1) 11))
						(= temp13 (/ (- temp5 25) 9))
						(= temp16 temp12)
						(= temp17 temp13)
						(localproc_1
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
							(if local263
								(MapKeyToDir temp9)
								(localproc_9 temp9)
							)
							(= temp10 (temp9 x:))
							(= temp11 (temp9 y:))
							(= temp14 (/ (- temp10 1) 11))
							(= temp15 (/ (- temp11 25) 9))
							(cond
								(
									(and
										(== temp20 1)
										(or
											(!= temp14 temp12)
											(!= temp15 temp13)
										)
										(localproc_3
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
										(localproc_2
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
										(localproc_2
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
										(localproc_3
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
						(switch
							(= temp51 (localproc_8 temp12 temp13 temp14 temp15))
							(-2
								(gCSoundFX number: 145 loop: 1 play:)
								(sayIt doit: 2 0 1)
								(localproc_7 temp12 temp13 temp16 temp17 2 5)
							)
							(-4
								(gCSoundFX number: 136 loop: 1 play:)
								(localproc_7 temp12 temp13 temp16 temp17 0 6)
								(sayIt doit: 2 0 3)
								(localproc_4)
							)
							(-1 0)
							(else
								(gCSoundFX number: 135 loop: 1 play:)
								(Memory memPOKE local243 (+ 1 (Memory memPEEK local243)))
								(localproc_0 temp51 [local0 7])
								(localproc_5)
								(localproc_7 temp12 temp13 temp16 temp17 2 5)
								(localproc_0 temp51 [local0 5])
							)
						)
					)
				)
			)
			((or (!= local239 local266) (!= local240 local267))
				(localproc_7 local239 local240 local239 local240 0 7)
				(= local266 local239)
				(= local267 local240)
			)
		)
		(event claimed: 0)
		(if (not local263)
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

(instance wordWindow of SysWindow
	(properties
		top 19
		left 2
		bottom 183
		right 317
		priority -1
	)

	(method (open &tmp temp0 temp1 [temp2 15] temp17 temp18 temp19 temp20)
		(super open:)
		(= temp18 1)
		(= temp19 25)
		(= temp20 0)
		(Graph grFILL_BOX 0 0 21 315 1 53 -1 -1)
		(Graph grUPDATE_BOX 0 0 21 315 1)
		(Graph grFILL_BOX 24 1 158 164 1 [local0 2] -1 -1)
		(for ((= temp0 0)) (< temp0 30) ((+= temp0 2))
			(StrCpy @temp2 (+ local10 (* temp0 8) 16))
			(for ((= temp1 0)) (< temp1 15) ((++ temp1))
				(= temp17
					(= [local13 (+ (* 15 (/ temp0 2)) temp1)]
						(StrAt @temp2 temp1)
					)
				)
				(Display
					@temp17
					dsCOORD
					temp18
					temp19
					dsFONT
					888
					dsCOLOR
					[local0 1]
					dsBACKGROUND
					[local0 2]
				)
				(if (& (WordAt local244 (/ temp0 2)) [local245 (+ temp1 1)])
					(localproc_1
						(+ (* (/ temp0 2) 15) temp1)
						temp1
						(/ temp0 2)
						[local0 8]
						[local0 7]
					)
				)
				(+= temp18 11)
				(if (and (== temp20 0) (!= temp1 14))
					(Graph grDRAW_LINE 24 (- temp18 2) 157 (- temp18 2) [local0 0] -1 -1)
				)
			)
			(= temp20 1)
			(= temp18 1)
			(+= temp19 9)
			(Graph grDRAW_LINE (- temp19 2) 0 (- temp19 2) 164 [local0 0] -1 -1)
		)
		(Graph grDRAW_LINE 23 0 23 164 [local0 0] -1 -1)
		(= temp18 164)
		(Graph grDRAW_LINE 24 164 157 164 [local0 0] -1 -1)
		(Graph grUPDATE_BOX 23 1 161 165 1)
		(gGame setCursor: gTheCursor 1 9 26)
		(for ((= temp0 0)) (< temp0 20) ((++ temp0))
			(localproc_0
				temp0
				[local0 (if (>= (WordAt local11 (* 4 temp0)) 0) 1 else 5)]
			)
		)
	)
)

(instance sPlaySounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: 902)
				(if (!= (gCSoundFX prevSignal:) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(gCSoundFX number: 106 loop: 1 play: self)
			)
			(2
				(word solvePuzzle: gDifficulty 6)
				(Memory memPOKE local242 -1)
				(gGame setCursor: 900)
				(self dispose:)
			)
		)
	)
)

(instance sayIt of Code
	(properties)

	(method (doit &tmp temp0)
		(gMessager say: &rest)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if gFastCast
			(while gFastCast
				(gFastCast eachElementDo: #doit)
				(if (and ((= temp0 (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: #handleEvent temp0)
				)
				(temp0 dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
			)
			(SetPort (word thisPort:))
		)
	)
)

