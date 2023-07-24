;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 285)
(include sci.sh)
(use Main)
(use dummyClient)
(use PuzzleIcon)
(use Interface)
(use LoadMany)
(use Window)

(public
	maze 0
	mWindow 1
)

(local
	[local0 5] = [29 30 25 23 30]
	[local5 24] = [29 30 25 23 30 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	[local43 10] = [{} {MOVE FORWARD} {MOVE LEFT} {MOVE BACKWARD} {MOVE RIGHT} {TURN ON} {TURN OFF} {BEGIN} {END} {}]
	[local53 3] = [1 3 2]
	[local56 3] = [24 25 26]
	[local59 9] = [0 3 4 1 2 6 5 7 8]
	[local68 20] = [0 0 3 0 1 4 1 0 0 0 3 3 3 4 0 1 4 3 0 4]
	[local88 20] = [0 0 6 0 0 0 -1 0 0 0 0 14 0 0 -10 17 0 -14 0 0]
	[local108 10] = [0 17 -17 16 -17 0 0 0 18 -18]
	[local118 10] = [0 -11 -11 -11 -11 0 0 -14 0 0]
	[local128 10] = [0 -3 -16 0 -20 0 0 -3 0 -12]
	[local138 10] = [0 -14 -14 -11 -11 0 0 -14 -3 -3]
	[local148 10] = [0 3 4 4 3 0 0 3 4 3]
	[local158 10] = [0 0 0 1 1 0 0 4 3 3]
	local168
	local169
	local170
	[local171 3] = [2 3 2]
	[local174 3] = [946 947 946]
	[local177 9] = [4 44 4 44 4 14 4 4 4]
	[local186 9] = [30 30 45 45 60 70 85 97 109]
	[local195 6] = [{HEAD:} {ARM:} {PROGRAM STATUS:} {SYSTEMS ALL CHECK} {ABORT OPERATION} {PROGRAM ERROR}]
	[local201 20] = [-12 -5 0 -5 -12 -5 0 -5 -12 -4 0 -4 -12 -5 0 -5 -16 -3 0 -4]
	[local221 20] = [-5 -12 0 0 -5 -12 0 0 -4 -12 0 0 -4 -12 0 0 -3 -16 0 0]
	[local241 20] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 2 0 2]
	[local261 5] = [5 6 7 11 12]
	[local266 12] = [-6 -21 0 12 -6 -19 0 8 -7 -15 0 7]
	[local278 20] = [-19 -5 0 -5 -18 -3 0 -5 -14 -5 0 -6 13 10 0 10 10 13 0 13]
	[local298 3] = [{iron plaque} {plastic clue sheet} {blue book}]
	[local301 3] = [21 19 18]
	[local304 12] = [-12 -6 0 -6 -18 -6 0 -6 -19 -6 0 -6]
	[local316 12] = [-6 -12 0 0 -6 -18 0 0 -6 -19 0 0]
	[local328 12] = [13 13 0 13 13 19 0 19 13 20 0 20]
	[local340 12] = [13 13 0 13 19 13 0 13 20 13 0 13]
	[local352 12] = [2 1 0 0 5 4 0 3 8 7 0 6]
	[local364 3] = [4 7 5]
	[local367 3] = [1 10 9]
	[local370 3] = [16 5 13]
	local373 = 19
	local374
	[local375 16] = [7 2 -1 1 4 9 0 -1 0 0 0 0 3 -1 0 8]
)

(procedure (localproc_0)
	(Graph grFILL_BOX 92 4 124 106 1 [local0 2] -1 -1)
	(Graph grUPDATE_BOX 92 4 124 106 1)
)

(procedure (localproc_1) ; UNUSED
	(Print &rest #at -1 150)
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(if (>= argc 1)
		(= temp1 param1)
	else
		(= temp1 2)
	)
	(while (>= (= local38 (localproc_9)) temp1)
		(Wait 0)
		(Wait 10)
		(if (= temp0 (localproc_9))
			(localproc_10 local38 temp0 0)
		)
		(if (or (== local38 4) (== local38 12) (== local38 15))
			(localproc_3 0)
		)
	)
)

(procedure (localproc_3 param1)
	(if param1
		(DrawCel 287 0 0 112 22 -1)
		(DrawCel 287 0 3 0 22 -1)
	)
	(if (and (not (IsFlag [local56 0])) (!= local35 1) (!= local39 1))
		(DrawCel 287 8 4 122 50 -1)
	)
	(if (and (not (IsFlag [local56 1])) (!= local35 2) (!= local39 2))
		(DrawCel 287 9 4 199 72 -1)
	)
	(if (and (not (IsFlag [local56 2])) (!= local35 3) (!= local39 3))
		(DrawCel 287 10 4 160 100 -1)
	)
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(if param1
		(switch local38
			(5
				(localproc_5 -22 1)
				(= local170 3)
			)
			(13
				(localproc_5 0 2)
				(= local170 4)
			)
			(16
				(localproc_6)
			)
		)
	else
		(gCMusic2 number: 943 setLoop: -1 play:)
		(= temp1 (+ local169 [local304 local34]))
		(= temp2 (+ local168 [local316 local34]))
		(= temp3 [local328 local34])
		(= temp4 [local340 local34])
		(= temp0 0)
		(= temp5 0)
		(while (< temp0 7)
			(if temp0
				(Graph
					grFILL_BOX
					temp1
					temp2
					(+ temp1 temp4)
					(+ temp2 temp3)
					1
					[local0 0]
					-1
					-1
				)
				(Graph grUPDATE_BOX temp1 temp2 (+ temp1 temp4) (+ temp2 temp3) 1)
				(localproc_3 0)
			)
			(DrawCel 291 [local352 local34] temp5 temp2 temp1 -1)
			(Graph grUPDATE_BOX temp1 temp2 (+ temp1 temp4) (+ temp2 temp3) 1)
			(Wait 0)
			(Wait 5)
			(if (< (++ temp0) 4)
				(++ temp5)
			else
				(-- temp5)
			)
		)
		(gCMusic2 stop:)
	)
)

(procedure (localproc_5 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (+ local168 param1))
	(= temp2 (- local169 6))
	(gCMusic2 number: 943 setLoop: -1 play:)
	(for ((= temp0 0)) (< temp0 [local364 param2]) ((++ temp0))
		(DrawCel 291 [local367 param2] temp0 temp1 temp2 -1)
		(if (== temp0 [local171 param2])
			((ScriptID 280 2) number: [local174 param2] setLoop: 1 play:) ; altS
		)
		(Wait 0)
		(Wait 5)
		(Graph grFILL_BOX temp2 temp1 (+ temp2 12) (+ temp1 23) 1 [local0 0] -1 -1)
		(Graph grUPDATE_BOX temp2 temp1 (+ temp2 12) (+ temp1 23) 1)
	)
	(gCMusic2 stop:)
	(localproc_11)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp5 1)
	(= temp1 (- local168 12))
	(= temp2 (- local169 6))
	(= temp3 (- local168 29))
	(= temp4 (- local169 5))
	(gCMusic2 number: 948 setLoop: -1 play:)
	(for ((= temp0 0)) (< temp0 [local364 2]) ((++ temp0))
		(DrawCel 291 [local367 0] temp0 temp1 temp2 -1)
		(Wait 0)
		(Wait 2)
		(Graph grFILL_BOX temp2 temp1 (+ temp2 12) (+ temp1 12) 1 [local0 0] -1 -1)
		(Graph grUPDATE_BOX temp2 temp1 (+ temp2 12) (+ temp1 12) 1)
	)
	(for ((= temp0 (- [local364 2] 1))) (>= temp0 0) ((-- temp0))
		(Graph grFILL_BOX temp2 temp1 (+ temp2 12) (+ temp1 12) 1 [local0 0] -1 -1)
		(Graph grUPDATE_BOX temp2 temp1 (+ temp2 12) (+ temp1 12) 1)
		(DrawCel 291 [local367 0] temp0 temp1 temp2 -1)
		(Wait 0)
		(Wait 5)
		(DrawCel 287 13 4 (+ temp3 1) temp4 -1)
		(if temp5
			(= temp5 0)
			(+= temp3 1)
		else
			(+= temp3 2)
		)
		(DrawCel 287 8 1 temp3 temp4 -1)
	)
	((ScriptID 280 2) number: 946 setLoop: 1 play:) ; altS
	(gCMusic2 stop:)
	(localproc_11)
)

(procedure (localproc_7 param1)
	(if (>= local170 3)
		(localproc_13)
		(= local170 global365)
		(localproc_11)
		(Wait 0)
		(Wait 5)
	)
	(if param1
		(+= [global360 global364] 1)
		(SetFlag [local56 (- local35 1)])
		(gEgo get: [local301 (- local35 1)])
		(= [local370 global365] 0)
		((ScriptID 280 1) loop: 0 hide:) ; presentArm
		(= global354 0)
		(localproc_12)
		(localproc_15 {ITEM DELIVERED} 8 [local0 4] 5)
		(= local42 (- local35 1))
		([global356 local42] signal: (| ([global356 local42] signal:) $0004))
		(proc5_21 285 4 [local298 local42]) ; "You see the %s in the pocket and pick it up."
		(localproc_13)
		(= local35 0)
		(localproc_11)
		(maze goAway:)
	else
		(= local39 local35)
		(= local35 0)
		(localproc_0)
		(localproc_15 {INVALID DROP SPOT} 7 [local0 4] 4)
		(localproc_15 {PROGRAM ABORTED} 8 [local0 4] 4)
		(maze goAway:)
	)
)

(procedure (localproc_8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
	(= temp1 1)
	(= temp2 0)
	(= temp0 0)
	(switch local35
		(1
			(cond
				((< 2 local38 6)
					(= temp0 2)
				)
				((< 11 local38 14)
					(= temp0 11)
				)
				((> local38 16)
					(= temp0 15)
				)
			)
			(= temp2 1)
			(= temp3 16)
			(= temp9 0)
		)
		(2
			(cond
				((< 2 local38 6)
					(= temp0 2)
				)
				((> local38 13)
					(= temp0 10)
				)
			)
			(= temp3 13)
			(= temp7 0)
			(= temp8 2)
			(= temp9 2)
		)
		(3
			(if (> local38 5)
				(= temp0 2)
			)
			(= temp1 0)
			(= temp3 5)
			(= temp7 -22)
			(= temp9 1)
			(= temp8 1)
		)
	)
	(if temp0
		(localproc_2 temp0)
		(= local38 temp0)
	)
	(= temp10 (localproc_9))
	(while (!= local38 temp3)
		(cond
			((and (== local38 2) temp1)
				(= local38 6)
			)
			((and (== local38 11) temp2)
				(= local38 14)
			)
		)
		(localproc_10 local38 temp10 1)
		(Wait 0)
		(Wait 10)
		(= temp10 local38)
		(++ local38)
	)
	(if (or (== local35 2) (== local35 3))
		(= temp4 (+ local168 temp7))
		(= temp5 (- local169 6))
		(gCMusic2 number: 943 setLoop: -1 play:)
		(for ((= temp6 (- [local364 temp8] 1))) (>= temp6 0) ((-- temp6))
			(DrawCel 291 [local367 temp8] temp6 temp4 temp5 -1)
			(if (== temp6 [local171 temp8])
				((ScriptID 280 2) number: [local174 temp8] setLoop: 1 play:) ; altS
			)
			(Wait 0)
			(Wait 5)
			(Graph grFILL_BOX temp5 temp4 (+ temp5 12) (+ temp4 23) 1 [local0 0] -1 -1)
			(Graph grUPDATE_BOX temp5 temp4 (+ temp5 12) (+ temp4 23) 1)
		)
		(= local35 0)
		(= local170 temp9)
		(gCMusic2 stop:)
		(localproc_11)
	else
		(= temp4 (- local168 12))
		(= temp5 (- local169 6))
		(= temp11 (- local168 21))
		(= temp12 (- local169 5))
		(gCMusic2 number: 948 setLoop: -1 play:)
		(for ((= temp6 0)) (< temp6 [local364 2]) ((++ temp6))
			(DrawCel 291 [local367 0] temp6 temp4 temp5 -1)
			(Wait 0)
			(Wait 2)
			(Graph grFILL_BOX temp5 temp4 (+ temp5 12) (+ temp4 12) 1 [local0 0] -1 -1)
			(Graph grUPDATE_BOX temp5 temp4 (+ temp5 12) (+ temp4 12) 1)
		)
		(for ((= temp6 (- [local364 2] 1))) (>= temp6 0) ((-- temp6))
			(Graph grFILL_BOX temp5 temp4 (+ temp5 12) (+ temp4 12) 1 [local0 0] -1 -1)
			(Graph grUPDATE_BOX temp5 temp4 (+ temp5 12) (+ temp4 12) 1)
			(DrawCel 291 [local367 0] temp6 temp4 temp5 -1)
			(Wait 0)
			(Wait 5)
			(DrawCel 287 13 4 (+ temp11 1) temp12 -1)
			(if (< temp6 3)
				(-= temp11 1)
			else
				(-= temp11 2)
			)
			(DrawCel 287 8 1 temp11 temp12 -1)
		)
		(= local35 0)
		(= local170 temp9)
		(gCMusic2 stop:)
		(localproc_11)
	)
	(localproc_3 0)
)

(procedure (localproc_9 &tmp temp0)
	(if (< [local88 local38] 0)
		(= temp0 (- 0 [local88 local38]))
	else
		(= temp0 (- local38 1))
	)
	(return temp0)
)

(procedure (localproc_10 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(gCMusic2 number: 942 setLoop: 1 play:)
	(= temp1 [local68 param1])
	(= temp4
		[local148
			(= temp2 [local375 (+ (* (= temp0 [local68 param2]) 4) temp1)])
		]
	)
	(= temp3 [local158 temp2])
	(localproc_13)
	(if param3
		(= temp7 local168)
		(= temp8 local169)
		(+= local168 [local108 temp2])
		(+= local169 [local118 temp2])
		(= local33 temp1)
	else
		(= temp7 (-= local168 [local108 temp2]))
		(= temp8 (-= local169 [local118 temp2]))
		(+= temp3 5)
		(= local33 temp0)
	)
	(= temp5 (+ temp8 [local138 temp2]))
	(= temp6 (+ temp7 [local128 temp2]))
	(DrawCel 287 temp4 temp3 temp6 temp5 -1)
	(localproc_11)
)

(procedure (localproc_11 &tmp temp0 temp1)
	(if local35
		(= local41 local33)
		(= temp0 (+ (* (- local35 1) 4) local41))
		(= local32 (+ local169 [local278 temp0]))
		(= local31 (+ local168 [local266 temp0]))
		(DrawCel 287 (+ local35 7) local41 local31 local32 -1)
	)
	(= local34 (+ (* local170 4) local33))
	(= local29 (+ local168 [local221 local34]))
	(= local30 (+ local169 [local201 local34]))
	(= temp1 [local261 local170])
	(DrawCel 287 temp1 local33 local29 local30 -1)
	(if local39
		(= temp0 (+ (* (- local35 1) 4) local41))
		(DrawCel 287 (+ local39 7) local41 local31 local32 -1)
	)
)

(procedure (localproc_12 &tmp temp0 temp1)
	(= temp0 [local261 local170])
	(for ((= temp1 11)) (>= temp1 6) ((-- temp1))
		(localproc_13)
		(DrawCel 287 0 1 192 23 -1)
		(DrawCel 287 (+ local35 7) temp1 local31 local32 -1)
		(DrawCel 287 temp0 local33 local29 local30 -1)
		(Wait 0)
		(Wait 5)
	)
	((ScriptID 280 2) number: 960 setLoop: 1 play:) ; altS
	(Wait 0)
	(Wait 30)
)

(procedure (localproc_13 &tmp temp0)
	(= temp0 [local241 local34])
	(DrawCel 287 13 temp0 local29 local30 -1)
	(if local35
		(= temp0 (if local41 4 else 3))
		(DrawCel 287 13 temp0 local31 local32 -1)
	)
	(if (== local38 (- local373 1))
		(DrawCel 287 0 1 193 23 -1)
	)
)

(procedure (localproc_14 &tmp temp0 temp1)
	(= temp1 1)
	(localproc_15 [local195 0] 0)
	(if global355
		(if global363
			(= temp0 {BROKEN})
			(= temp1 0)
		else
			(= temp0 {PRESENT})
		)
	else
		(= temp0 {MISSING})
		(= temp1 0)
	)
	(localproc_15 temp0 1)
	(localproc_15 [local195 1] 2)
	(if global354
		(= temp0 {PRESENT})
	else
		(= temp0 {MISSING})
		(= temp1 0)
	)
	(localproc_15 temp0 3)
	(localproc_15 [local195 2] 4)
	(if (== [global301 2] 8)
		(= temp0 {NO ENTRIES})
		(= temp1 0)
	else
		(= temp0 {READY})
	)
	(localproc_15 temp0 5)
	(if temp1
		(localproc_15 [local195 3] 6)
	else
		(localproc_15 [local195 4] 6)
		(Wait 0)
		(Wait 120)
	)
	(if temp1
		(= local374 1)
		(SetFlag 60)
	)
	(return temp1)
)

(procedure (localproc_15 param1 param2 param3 param4 &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 [temp7 4] temp11 temp12)
	(if (>= argc 3)
		(= temp11 param3)
	else
		(= temp11 [local0 1])
	)
	(if (>= argc 4)
		(= temp12 param4)
	else
		(= temp12 local374)
	)
	(= temp5 (StrLen param1))
	(= temp3 [local177 param2])
	(= temp4 [local186 param2])
	(for ((= temp2 0)) (< temp2 temp5) ((++ temp2))
		(= temp6 (StrAt param1 temp2))
		(if (localproc_16 temp6)
			(gCMusic2 number: 945 setLoop: 1 play:)
		else
			(gCMusic2 stop:)
		)
		(proc5_8 (Format @temp0 {%c} temp6) temp11 temp3 temp4)
		(TextSize @[temp7 0] @temp0 gUserFont)
		(+= temp3 (+ [temp7 3] 1))
		(Wait 0)
		(Wait temp12)
	)
	(gCMusic2 stop:)
	(Wait (* temp12 6))
)

(procedure (localproc_16 param1)
	(if (<= 65 param1 90)
		(return 1)
	else
		(return 0)
	)
)

(instance maze of PuzzleBar
	(properties
		puzzleHeight 157
		bottomHeight 0
		solvedFlag 43
	)

	(method (init &tmp temp0)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 5) ((++ temp0))
				(= [local0 temp0] [local5 temp0])
			)
		)
		(LoadMany rsSOUND 942 943 945 946 948 960)
		(LoadMany rsVIEW 291 287)
		(if (IsFlag 60)
			(= local374 1)
		else
			(= local374 5)
		)
		(= window mWindow)
		(super init: &rest)
	)

	(method (animateOnce &tmp temp0 temp1 [temp2 3] temp5 temp6 temp7 [temp8 20])
		(cond
			((and (not local36) (!= (= temp1 [global301 local37]) 9))
				(Graph grFILL_BOX 131 8 143 103 1 [local0 2] -1 -1)
				(Graph grUPDATE_BOX 131 8 143 103 1)
				(if temp1
					(Format @temp8 285 0 local37 [local43 temp1]) ; "%d : %s"
				else
					(Format @temp8 285 1 local37) ; "%d : NO ENTRY"
				)
				(proc5_8 @temp8 [local0 3] 10 134)
				(switch global364
					(0
						(if (mod local37 2)
							(= temp1 [local59 temp1])
						)
					)
					(2
						(= temp1 [local59 temp1])
					)
				)
				(cond
					((== temp1 5)
						(cond
							(local35
								(localproc_0)
								(localproc_15 [local195 5] 7 [local0 4] 5)
								(localproc_15 {HAND ALREADY ON} 8 [local0 4] 5)
							)
							((== local38 [local370 global365])
								(localproc_0)
								(localproc_15 {HAND TURNED ON} 7 [local0 4] 5)
								(= local35 [local53 global365])
								(localproc_4 1)
								(switch local35
									(2
										(= local170 4)
									)
									(3
										(= local170 3)
									)
								)
							)
							(else
								(localproc_0)
								(localproc_15 {HAND TURNED ON} 7 [local0 4] 5)
								(localproc_4 0)
							)
						)
					)
					((== temp1 6)
						(cond
							((== local38 local373)
								(localproc_0)
								(localproc_0)
								(localproc_15 {HAND TURNED OFF} 7 [local0 4] 5)
								(if local35
									(= local40 1)
									(localproc_7 1)
								else
									(localproc_15
										{NO ITEM DROPPED}
										8
										[local0 4]
										5
									)
								)
							)
							((not local35)
								(localproc_0)
								(localproc_15 {HAND TURNED OFF} 7 [local0 4] 5)
								(localproc_7 0)
							)
							(else
								(localproc_0)
								(localproc_15 {INVALID TURNOFF} 7 [local0 4] 5)
								(localproc_15 {RETURN ITEM} 8 [local0 4] 5)
								(localproc_8)
								(localproc_2)
								(maze goAway:)
							)
						)
					)
					((== temp1 7)
						(if global354
							(localproc_11)
						)
						(if (not (= temp7 (localproc_14)))
							(maze goAway:)
						)
					)
					((== temp1 8)
						(localproc_0)
						(localproc_15 {END OF PROGRAM} 7 [local0 4] 5)
						(localproc_15 {ENCOUNTERED} 8 [local0 4] 5)
						(Wait 0)
						(Wait 60)
						(if local35
							(localproc_0)
							(localproc_15 {ITEM IN HAND} 7 [local0 4] 5)
							(localproc_15 {RETURN ITEM} 8 [local0 4] 5)
							(localproc_8)
						)
						(localproc_2)
						(maze goAway:)
					)
					((not temp1) 0)
					(else
						(= temp6 (localproc_9))
						(cond
							((== (-- temp1) [local68 local38])
								(localproc_10 local38 temp6 1)
								(++ local38)
							)
							(
								(and
									(> (= temp0 [local88 local38]) 0)
									(== temp1 [local68 temp0])
								)
								(= local38 temp0)
								(localproc_10 local38 temp6 1)
								(++ local38)
							)
							(
								(and
									(==
										(mod (+ temp1 2) 4)
										(= temp5 [local68 temp6])
									)
									(> temp6 1)
								)
								(= local38 temp6)
								(= temp6 (localproc_9))
								(localproc_10 local38 temp6 0)
							)
							(
								(and
									(< [local88 local38] 0)
									(== (mod (+ temp1 2) 4) [local68 local38])
									(== [local68 (- 1 [local88 local38])] temp1)
								)
								(= local38 (+ temp6 1))
								(localproc_10 local38 temp6 1)
								(++ local38)
							)
							(
								(and
									(< [local88 local38] 0)
									(== temp1 [local68 (+ temp6 1)])
								)
								(= local38 (+ temp6 1))
								(localproc_10 local38 temp6 1)
								(++ local38)
							)
							(else
								(= local36 1)
							)
						)
					)
				)
				(++ local37)
				(Wait 0)
				(Wait 20)
			)
			(local36
				(localproc_0)
				(localproc_15 [local195 5] 7 [local0 4] 5)
				(localproc_15 {INVALID DIRECTION} 8 [local0 4] 5)
				(Wait 0)
				(Wait 60)
				(if local35
					(localproc_0)
					(localproc_15 {ITEM IN HAND} 7 [local0 4] 5)
					(localproc_15 {RETURN ITEM} 8 [local0 4] 5)
					(localproc_8)
				)
				(localproc_2)
				(maze goAway:)
			)
			((== local37 2)
				(localproc_0)
				(localproc_15 {PROGRAM REQUIRED} 7 [local0 4] 5)
				(maze goAway:)
			)
			(else
				(if local35
					(localproc_0)
					(localproc_15 {ITEM IN HAND} 7 [local0 4] 5)
					(localproc_15 {RETURN ITEM} 8 [local0 4] 5)
					(localproc_8)
				)
				(localproc_2)
				(maze goAway:)
			)
		)
		(localproc_3 0)
		(localproc_11)
		(if local39
			(DrawCel 287 (+ local39 7) local41 local31 local32 -1)
		)
		(return 1)
	)

	(method (show &tmp temp0)
		(LoadMany rsVIEW 287 291)
		(LoadMany rsSOUND 942 943 945 946 948 960)
		(= local40 0)
		(= local37 1)
		(= local168 167)
		(= local169 138)
		(= local33 0)
		(= local38 2)
		(= local36 0)
		(= local35 0)
		(= local39 0)
		(= local170 global365)
		(super show:)
		(if (and (IsFlag 24) (IsFlag 26) (IsFlag 25))
			(self solvePuzzle:)
		)
		(gTheIconBar select: (gTheIconBar at: 1) curIcon: (gTheIconBar at: 1))
		(gGame setCursor: 8)
		(return local40)
	)

	(method (goAway)
		(if local35
			(localproc_8)
		)
		(localproc_2)
		(super goAway: &rest)
	)

	(method (buyClue)
		(proc5_11 285 2) ; "This coin slot seems to be out of order. Try the one on the robot computer."
	)

	(method (showHelp)
		(proc5_11 285 3) ; "The robot will follow the instructions you program using the "Robocomp" computer. That is, it will if the robot was correctly designed."
	)
)

(instance mWindow of SysWindow
	(properties
		top 10
		left 50
		bottom 187
		right 274
		back 43
		priority -1
	)

	(method (open)
		(super open:)
		(localproc_3 1)
	)
)

