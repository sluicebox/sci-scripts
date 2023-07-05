;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Print)
(use IconBar)
(use GameControls)
(use Window)

(public
	theBoard 0
)

(local
	local0
	[local1 26] = [19 60 16 17 213 255 256 257 18 18 254 254 112 157 70 130 193 71 111 151 199 71 113 157 199 132]
	[local27 26] = [28 28 59 82 28 28 59 83 124 148 121 151 28 28 60 60 60 91 91 91 90 120 120 120 120 149]
	[local53 5] = [26 216 15 252 129]
	[local58 8] = [17 17 111 111 17 166 157 148]
	[local66 3] = [1 -1 -1]
	[local69 3]
	[local72 3] = [-1 -1 1]
	[local75 27]
	[local102 26] = [0 1 12 13 4 5 2 14 15 16 6 3 17 18 19 20 7 8 21 22 23 24 10 9 25 11]
	local128
)

(procedure (localproc_0 &tmp [temp0 20])
	(DrawCel 40 7 0 35 3 -1)
	(for ((= local0 0)) (< local0 5) ((++ local0))
		(DrawCel 40 6 local0 [local53 local0] [local58 local0] -1)
	)
	(for ((= local0 0)) (< local0 26) ((++ local0))
		(Message msgGET 40 3 1 0 (+ local0 1) @temp0)
		(localproc_1
			@temp0
			(- [local1 local0] 15)
			(+ [local27 local0] 12)
			1
			1
			40
			999
		)
	)
	(for ((= local0 0)) (< local0 3) ((++ local0))
		(Message msgGET 40 7 1 0 (+ local0 1) @temp0)
		(localproc_1 @temp0 51 (- 170 (* 9 local0)) 1 0 47 999)
		(Format @temp0 {%d} [global119 local0])
		(localproc_1 @temp0 98 (- 170 (* 9 local0)) 1 -1 12 999)
	)
	(Message msgGET 40 5 1 0 1 @temp0) ; "Score"
	(localproc_1 @temp0 167 152 1 0 51 999)
	(Format @temp0 {%d} gScore)
	(localproc_1 @temp0 218 152 1 -1 15 999)
	(Message msgGET 40 8 1 0 1 @temp0) ; "X-Credit"
	(localproc_1 @temp0 167 161 1 0 51 999)
	(Format @temp0 {%d} global134)
	(localproc_1 @temp0 218 161 1 -1 15 999)
	(Message msgGET 40 6 1 0 1 @temp0) ; "Hints"
	(localproc_1 @temp0 167 170 1 0 51 999)
	(Format @temp0 {%d} global115)
	(localproc_1 @temp0 218 170 1 -1 15 999)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 param6 param7)
	(Display
		param1
		dsCOORD
		param2
		param3
		dsCOLOR
		param4
		dsALIGN
		param5
		dsWIDTH
		param6
		dsFONT
		param7
	)
)

(procedure (localproc_2)
	(Graph grDRAW_LINE 0 0 0 286 22 -1 -1)
	(Graph grDRAW_LINE 14 1 14 284 18 -1 -1)
	(Graph grDRAW_LINE 15 2 15 283 26 -1 -1)
	(Graph grDRAW_LINE 1 0 181 0 21 -1 -1)
	(Graph grDRAW_LINE 15 1 180 1 18 -1 -1)
	(Graph grDRAW_LINE 16 2 179 2 26 -1 -1)
	(Graph grDRAW_LINE 1 285 181 285 21 -1 -1)
	(Graph grDRAW_LINE 15 284 180 284 18 -1 -1)
	(Graph grDRAW_LINE 16 283 179 283 26 -1 -1)
	(Graph grDRAW_LINE 181 1 181 286 22 -1 -1)
	(Graph grDRAW_LINE 180 2 180 285 18 -1 -1)
	(Graph grDRAW_LINE 179 3 179 284 26 -1 -1)
	(localproc_3 14 98 57 98 66)
	(localproc_3 14 194 57 194 18)
	(localproc_4 57 47 57 98 65)
	(localproc_4 57 194 57 236 20)
	(localproc_3 57 47 179 47 33)
	(localproc_3 57 236 179 236 36)
	(localproc_4 108 1 108 47 34)
	(localproc_4 108 236 108 284 34)
	(localproc_4 149 47 149 114 18)
	(localproc_4 149 163 149 236 33)
	(localproc_3 149 114 179 114 36)
	(localproc_3 149 163 179 163 33)
)

(procedure (localproc_3 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(cond
		((& param5 $0001)
			(= temp0 0)
		)
		((& param5 $0002)
			(= temp0 1)
		)
		((& param5 $0004)
			(= temp0 2)
		)
	)
	(= temp1 [local66 temp0])
	(= temp2 [local69 temp0])
	(= temp3 [local72 temp0])
	(cond
		((& param5 $0010)
			(= temp0 0)
		)
		((& param5 $0020)
			(= temp0 1)
		)
		((& param5 $0040)
			(= temp0 2)
		)
	)
	(= temp4 [local66 temp0])
	(= temp5 [local69 temp0])
	(= temp6 [local72 temp0])
	(Graph
		grDRAW_LINE
		(- param1 temp1)
		(- param2 1)
		(+ param3 temp4)
		(- param2 1)
		20
		-1
		-1
	)
	(Graph grDRAW_LINE (- param1 temp2) param2 (+ param3 temp5) param2 22 -1 -1)
	(Graph
		grDRAW_LINE
		(- param1 temp3)
		(+ param2 1)
		(+ param3 temp6)
		(+ param2 1)
		18
		-1
		-1
	)
)

(procedure (localproc_4 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(cond
		((& param5 $0001)
			(= temp0 0)
		)
		((& param5 $0002)
			(= temp0 1)
		)
		((& param5 $0004)
			(= temp0 2)
		)
	)
	(= temp1 [local66 temp0])
	(= temp2 [local69 temp0])
	(= temp3 [local72 temp0])
	(cond
		((& param5 $0010)
			(= temp0 0)
		)
		((& param5 $0020)
			(= temp0 1)
		)
		((& param5 $0040)
			(= temp0 2)
		)
	)
	(= temp4 [local66 temp0])
	(= temp5 [local69 temp0])
	(= temp6 [local72 temp0])
	(Graph
		grDRAW_LINE
		(- param1 1)
		(- param2 temp1)
		(- param1 1)
		(+ param4 temp4)
		21
		-1
		-1
	)
	(Graph grDRAW_LINE param1 (- param2 temp2) param3 (+ param4 temp5) 22 -1 -1)
	(Graph
		grDRAW_LINE
		(+ param1 1)
		(- param2 temp3)
		(+ param1 1)
		(+ param4 temp6)
		17
		-1
		-1
	)
)

(procedure (localproc_5 param1 param2 param3 &tmp temp0 temp1 temp2)
	(= temp1 (= temp2 (= temp0 param1)))
	(while 1
		(cond
			((and (<= temp1 param3) [local75 temp1])
				(= temp0 temp1)
				(break)
			)
			((and (>= temp2 param2) [local75 temp2])
				(= temp0 temp2)
				(break)
			)
			((and (< temp2 param2) (> temp1 param3))
				(break)
			)
		)
		(++ temp1)
		(-- temp2)
	)
	(return temp0)
)

(instance theBoard of GameControls
	(properties)

	(method (init &tmp temp0 temp1 [temp2 4])
		(= window achievWin)
		(= [temp2 0] (= [temp2 1] (= [temp2 2] (= [temp2 3] 0))))
		(= local128 0)
		(for ((= local0 0)) (< local0 26) ((++ local0))
			(= [temp2 local0] 0)
			(= temp0 0)
			(cond
				((/ (= temp1 (mod [global135 [local102 local0]] 1000)) 100)
					(= temp0 3)
				)
				((/ temp1 10)
					(= temp0 2)
				)
				(temp1
					(= temp0 1)
				)
			)
			(if temp0
				(self
					add:
						((= [local75 local0] (plaque new:))
							cel: (mod [local102 local0] 16)
							loop: (+ (/ [local102 local0] 16) (* (- temp0 1) 2))
							nsLeft: [local1 [local102 local0]]
							nsTop: [local27 [local102 local0]]
							value: (+ [local102 local0] 1)
							cursor: local0
							yourself:
						)
				)
				(= local128 1)
			)
		)
		(self add: bigDummy)
	)

	(method (show)
		(gSystemWindow eraseOnly: 1)
		(gTheIconBar select: (gTheIconBar at: 2) curIcon: (gTheIconBar at: 2))
		(gGame setCursor: 907 1)
		(super show: &rest)
		(gSystemWindow eraseOnly: 0)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2)
		(if (& (event type:) $0040) ; direction
			(= temp1
				(if (and highlightedIcon (!= highlightedIcon bigDummy))
					(highlightedIcon cursor:)
				else
					0
				)
			)
			(if local128
				(= temp2 26)
				(switch (event message:)
					(JOY_UP
						(while (not [local75 temp2])
							(cond
								((< temp1 6)
									(= temp2
										(localproc_5
											(= temp1 (+ (/ temp1 2) 23))
											23
											25
										)
									)
								)
								((< temp1 11)
									(= temp2
										(localproc_5
											(-= temp1 (if (< temp1 9) 6 else 5))
											0
											5
										)
									)
								)
								((< temp1 17)
									(= temp2
										(localproc_5
											(-=
												temp1
												(if (< temp1 14) 5 else 6)
											)
											6
											10
										)
									)
								)
								((< temp1 23)
									(= temp2 (localproc_5 (-= temp1 6) 11 16))
								)
								(else
									(= temp2
										(localproc_5
											(= temp1
												(cond
													((== temp1 23) 17)
													((== temp1 24) 19)
													(else 22)
												)
											)
											17
											22
										)
									)
								)
							)
							(= temp1 temp2)
						)
					)
					(JOY_DOWN
						(while (not [local75 temp2])
							(cond
								((< temp1 6)
									(= temp2
										(localproc_5
											(+= temp1 (if (< temp1 3) 6 else 5))
											6
											10
										)
									)
								)
								((< temp1 11)
									(= temp2
										(localproc_5
											(+= temp1 (if (< temp1 9) 5 else 6))
											11
											16
										)
									)
								)
								((< temp1 17)
									(= temp2 (localproc_5 (+= temp1 6) 17 22))
								)
								((< temp1 23)
									(= temp2
										(localproc_5
											(= temp1
												(cond
													((== temp1 17) 23)
													((< temp1 22) 24)
													(else 25)
												)
											)
											23
											25
										)
									)
								)
								(else
									(= temp2
										(localproc_5
											(= temp1 (* (- temp1 23) 2))
											0
											5
										)
									)
								)
							)
							(= temp1 temp2)
						)
					)
					(JOY_RIGHT
						(while (not [local75 (mod (++ temp1) 26)])
						)
						(= temp1 (mod temp1 26))
					)
					(JOY_LEFT
						(+= temp1 26)
						(while (not [local75 (mod (-- temp1) 26)])
						)
						(= temp1 (mod temp1 26))
					)
				)
				(= temp0 [local75 temp1])
				(proc5_9 temp0)
			)
			(event type: evNULL)
		)
		(if
			(or
				(& (event type:) $0101) ; evJOYDOWN | evMOUSEBUTTON
				(and (& (event type:) evKEYBOARD) (not (& (event type:) $0040))) ; direction
			)
			(&= state $ffdf)
			(event dispose:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (hide)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super hide: &rest)
	)
)

(instance plaque of CodeIcon
	(properties
		view 40
		noun 4
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(if param1
			(= temp7 0)
			(if (mod (= temp8 (/ (= temp4 [global135 (- value 1)]) 1000)) 5)
				(cond
					((/ (= temp4 (mod temp4 1000)) 100)
						(= temp5 (- 15 temp8))
					)
					((/ temp4 10)
						(= temp5 (- 10 temp8))
					)
					(else
						(= temp5 (- 5 temp8))
					)
				)
				(if (= temp7 (Message msgSIZE 40 9 1 0 1)) ; "|c2|But, using hints cost you |c1|%d|c2| point(s).|c|"
					(= temp1 (Memory memALLOC_CRIT temp7))
				)
				(if temp7
					(Message msgGET 40 9 1 0 1 temp1) ; "|c2|But, using hints cost you |c1|%d|c2| point(s).|c|"
				)
				(if temp7
					(= temp3 (Memory memALLOC_CRIT (+ temp7 2)))
				)
				(if temp7
					(Format temp3 temp1 temp5)
				)
			)
			(if (= temp2 (Message msgSIZE 40 noun 1 0 value))
				(= temp0 (Memory memALLOC_CRIT (+ temp2 temp7 2)))
			)
			(if temp0
				(Message msgGET 40 noun 1 0 value temp0)
			)
			(if temp7
				(StrCat temp0 temp3)
			)
			((Print new:) modeless: 1 addText: temp0 init:)
			(if temp2
				(Memory memFREE temp0)
			)
			(if temp7
				(Memory memFREE temp1)
				(Memory memFREE temp3)
			)
		)
	)

	(method (select))
)

(instance bigDummy of IconI
	(properties
		nsTop 0
		nsRight 286
		nsBottom 181
	)

	(method (highlight))

	(method (show))

	(method (select))
)

(instance achievWin of SysWindow
	(properties
		top 4
		left 10
		bottom 185
		right 296
		back 19
		priority -1
		type 128
	)

	(method (open)
		(= lsTop top)
		(= lsLeft left)
		(= lsRight (+ right 1))
		(= lsBottom (+ bottom 1))
		(super open: &rest)
		(Graph grFILL_BOX 0 0 14 286 1 20 -1 -1)
		(Graph grFILL_BOX 14 0 108 47 1 44 -1 -1)
		(Graph grFILL_BOX 14 47 57 98 1 44 -1 -1)
		(Graph grFILL_BOX 14 194 57 286 1 44 -1 -1)
		(Graph grFILL_BOX 57 236 108 286 1 44 -1 -1)
		(Graph grFILL_BOX 14 98 149 194 1 54 -1 -1)
		(Graph grFILL_BOX 57 47 149 98 1 54 -1 -1)
		(Graph grFILL_BOX 57 194 149 236 1 54 -1 -1)
		(Graph grFILL_BOX 149 114 181 163 1 54 -1 -1)
		(Graph grFILL_BOX 108 0 181 47 1 62 -1 -1)
		(Graph grFILL_BOX 108 236 181 286 1 62 -1 -1)
		(Graph grFILL_BOX 149 47 181 114 1 14 -1 -1)
		(Graph grFILL_BOX 149 163 181 236 1 14 -1 -1)
		(localproc_2)
		(Graph grUPDATE_BOX 0 0 185 296 1)
		(localproc_0)
	)
)

