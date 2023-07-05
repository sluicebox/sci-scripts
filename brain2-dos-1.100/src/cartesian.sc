;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 165)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use IconBar)
(use LoadMany)
(use Window)

(public
	cartesian 0
)

(local
	[local0 3] = [0 2 8]
	[local3 3] = [2 6 7]
	[local6 15] = [1 1 1 1 0 1 -1 0 1 0 4 2 1 0 -4]
	[local21 15] = [43 175 9 43 79 141 175 211 9 43 79 109 141 183 219]
	[local36 4] = [9 231 9 231]
	[local40 4] = [29 29 141 141]
	[local44 7] = [{00} {01} {02} {03} {04} {05} {06}]
	[local51 7]
	[local58 7]
	[local65 256]
	[local321 128]
	local449
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	(Graph grFILL_BOX 24 42 153 203 1 38 -1 -1)
	(for ((= temp1 0)) (< temp1 16) ((++ temp1))
		(for ((= temp2 0)) (< temp2 16) ((++ temp2))
			(if (= temp3 [local65 (+ (* 16 temp1) temp2)])
				(DrawCel
					162
					(+ (>> (& temp3 $0018) $0003) 3)
					(& temp3 $0007)
					(+ 44 (* temp2 10))
					(+ 26 (* temp1 8))
					-1
				)
			)
		)
	)
	(Graph grDRAW_LINE 88 42 88 203 41 -1 -1)
	(Graph grDRAW_LINE 24 122 153 122 41 -1 -1)
	(for ((= temp0 1)) (< temp0 9) ((++ temp0))
		(Graph grDRAW_LINE (- 88 (* temp0 8)) 120 (- 88 (* temp0 8)) 124 41 -1 -1)
		(Graph grDRAW_LINE (+ 88 (* temp0 8)) 120 (+ 88 (* temp0 8)) 124 41 -1 -1)
		(Graph grDRAW_LINE 86 (- 122 (* temp0 10)) 90 (- 122 (* temp0 10)) 41 -1 -1)
		(Graph grDRAW_LINE 86 (+ 122 (* temp0 10)) 90 (+ 122 (* temp0 10)) 41 -1 -1)
	)
	(switch global114
		(0
			(localproc_2 51 [local51 0])
			(localproc_2 11 0 [local51 1])
		)
		(1
			(localproc_2 51 [local51 0] [local51 1] [local51 2])
			(localproc_2 11 [local51 3] [local51 4] [local51 5])
		)
		(2
			(localproc_2 51 [local51 0] [local51 1] [local51 2])
			(localproc_2 11 [local51 3] [local51 4] [local51 5] [local51 6])
		)
	)
	(Graph grUPDATE_BOX 24 42 153 203 1)
	(if (and (= temp4 (localproc_1)) (!= (cartesian puzzleStatus:) 1))
		(cartesian solvePuzzle:)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(switch global114
		(0
			(= temp1
				(and (== [local51 0] [local58 0]) (== [local51 1] [local58 1]))
			)
		)
		(1
			(= temp1 1)
			(for ((= temp5 0)) (and temp1 (< temp5 local449)) ((++ temp5))
				(= temp0
					(/
						(+
							(>>
								(&
									[local65
										(= temp6 (& [local321 temp5] $00ff))
									]
									$0018
								)
								$0003
							)
							1
						)
						2
					)
				)
				(= temp2 (>> [local321 temp5] $0008))
				(= temp4 (+ 26 (* (>> temp6 $0004) 8)))
				(= temp3 (+ 44 (* (& temp6 $000f) 10)))
				(= temp1
					(if
						(and
							(if (& temp2 $0001)
								(== temp0 (localproc_4 temp3 temp4))
							else
								1
							)
							(if (& temp2 $0002)
								(== temp0 (localproc_4 (+ temp3 5) temp4))
							else
								1
							)
							(if (& temp2 $0004)
								(== temp0 (localproc_4 (+ temp3 5) (+ temp4 5)))
							else
								1
							)
						)
						(if (& temp2 $0008)
							(== temp0 (localproc_4 temp3 (+ temp4 5)))
						else
							1
						)
					)
				)
			)
		)
		(2
			(= temp1 1)
			(for ((= temp5 0)) (and temp1 (< temp5 local449)) ((++ temp5))
				(= temp0
					(>>
						(& [local65 (= temp6 (& [local321 temp5] $00ff))] $0018)
						$0003
					)
				)
				(= temp2 (>> [local321 temp5] $0008))
				(= temp4 (+ 26 (* (>> temp6 $0004) 8)))
				(= temp3 (+ 44 (* (& temp6 $000f) 10)))
				(= temp1
					(if
						(and
							(if (& temp2 $0001)
								(== temp0 (localproc_5 temp3 temp4))
							else
								1
							)
							(if (& temp2 $0002)
								(== temp0 (localproc_5 (+ temp3 5) temp4))
							else
								1
							)
							(if (& temp2 $0004)
								(== temp0 (localproc_5 (+ temp3 5) (+ temp4 5)))
							else
								1
							)
						)
						(if (& temp2 $0008)
							(== temp0 (localproc_5 temp3 (+ temp4 5)))
						else
							1
						)
					)
				)
			)
		)
	)
	(return temp1)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(cond
		((== argc 2)
			(= temp2 (- 88 (* param2 8)))
			(= temp4 (- 88 (* param2 8)))
			(= temp1 202)
			(= temp3 42)
			(Graph grDRAW_LINE temp2 temp1 temp4 42 param1 -1 -1)
		)
		((== argc 3)
			(= temp2 152)
			(= temp4 24)
			(= temp1 (+ 122 (* param3 10)))
			(= temp3 (+ 122 (* param3 10)))
			(Graph grDRAW_LINE temp2 temp1 temp4 temp3 param1 -1 -1)
		)
		((== argc 4)
			(if (or param2 param3)
				(if (>= (* param2 param3) 0)
					(if
						(and
							param3
							(>= 8 (/ (- (* -8 param2) param4) param3) -8)
						)
						(= temp1
							(+ 122 (/ (* (- (* -8 param2) param4) 10) param3))
						)
						(= temp2 152)
					else
						(= temp1 42)
						(= temp2
							(- 88 (/ (* (- param4 (* 8 param3)) 8) param2))
						)
					)
					(if
						(and
							param3
							(>= 8 (/ (- (* 8 param2) param4) param3) -8)
						)
						(= temp3
							(+ 122 (/ (* (- (* 8 param2) param4) 10) param3))
						)
						(= temp4 24)
					else
						(= temp3 202)
						(= temp4
							(- 88 (/ (* (+ param4 (* 8 param3)) 8) param2))
						)
					)
				else
					(if (>= 8 (/ (- param4 (* 8 param3)) param2) -8)
						(= temp1 42)
						(= temp2
							(- 88 (/ (* (- param4 (* 8 param3)) 8) param2))
						)
					else
						(= temp1
							(+ 122 (/ (* (- (* 8 param2) param4) 10) param3))
						)
						(= temp2 24)
					)
					(if (>= 8 (/ (- (* -8 param2) param4) param3) -8)
						(= temp3
							(+ 122 (/ (* (- (* -8 param2) param4) 10) param3))
						)
						(= temp4 152)
					else
						(= temp3 202)
						(= temp4
							(- 88 (/ (* (+ param4 (* param3 8)) 8) param2))
						)
					)
				)
				(Graph grDRAW_LINE temp2 temp1 temp4 temp3 param1 -1 -1)
			)
		)
		((and (== argc 5) param2)
			(= temp7 0)
			(= temp5 (/ (* (= temp0 -81) 16) 10))
			(= temp6
				(/
					(+
						(* param3 (/ (* temp5 temp5) 16))
						(* param4 temp5)
						(* param5 16)
					)
					param2
				)
			)
			(= temp1 (+ 122 temp0))
			(if (>= temp6 4095)
				(= temp2 (- 88 (* (/ temp6 16) 8)))
			else
				(= temp2 (- 88 (/ (* temp6 8) 16)))
			)
			(for ((= temp0 -80)) (< temp0 80) ((++ temp0))
				(= temp5 (/ (* temp0 16) 10))
				(= temp6
					(/
						(+
							(* param3 (/ (* temp5 temp5) 16))
							(* param4 temp5)
							(* param5 16)
						)
						param2
					)
				)
				(= temp3 (+ 122 temp0))
				(if (>= temp6 4095)
					(= temp4 (* (/ temp6 16) 8))
				else
					(= temp4 (/ (* temp6 8) 16))
				)
				(cond
					((<= (Abs temp4) 64)
						(= temp4 (- 88 temp4))
						(if (not temp7)
							(cond
								((< temp2 24)
									(if (> (- 24 temp2) (- temp4 24))
										(= temp1 temp3)
									)
									(= temp2 24)
								)
								((> temp2 153)
									(if (> (- temp2 153) (- 153 temp4))
										(= temp1 temp3)
									)
									(= temp2 153)
								)
							)
						)
						(Graph grDRAW_LINE temp2 temp1 temp4 temp3 param1 -1 -1)
						(= temp7 1)
					)
					(temp7
						(= temp7 0)
						(cond
							((< (= temp4 (- 88 temp4)) 24)
								(if (> (- 24 temp4) (- temp2 24))
									(= temp1 temp3)
								)
								(= temp4 24)
							)
							((> temp4 153)
								(if (> (- temp4 153) (- 153 temp2))
									(= temp1 temp3)
								)
								(= temp4 153)
							)
						)
						(Graph grDRAW_LINE temp2 temp1 temp4 temp3 param1 -1 -1)
					)
					(else
						(= temp4 (- 88 temp4))
					)
				)
				(= temp2 temp4)
				(= temp1 temp3)
			)
		)
	)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1)
	(switch global114
		(0
			(= temp0 (< param2 (- 88 (* [local58 0] 8))))
			(= temp1 (> param1 (+ 122 (* [local58 1] 10))))
		)
		(1
			(= temp0
				(localproc_6 param1 param2 [local58 0] [local58 1] [local58 2])
			)
			(= temp1
				(localproc_6 param1 param2 [local58 3] [local58 4] [local58 5])
			)
		)
		(2
			(= temp0
				(localproc_6 param1 param2 [local58 0] [local58 1] [local58 2])
			)
			(= temp1
				(localproc_6
					param1
					param2
					[local58 3]
					[local58 4]
					[local58 5]
					[local58 6]
				)
			)
		)
	)
	(return (+ (<< temp0 $0001) temp1))
)

(procedure (localproc_4 param1 param2 &tmp temp0 temp1)
	(= temp0 (localproc_6 param1 param2 [local51 0] [local51 1] [local51 2]))
	(= temp1 (localproc_6 param1 param2 [local51 3] [local51 4] [local51 5]))
	(return (+ temp0 temp1))
)

(procedure (localproc_5 param1 param2 &tmp temp0 temp1)
	(= temp0 (localproc_6 param1 param2 [local51 0] [local51 1] [local51 2]))
	(= temp1
		(localproc_6
			param1
			param2
			[local51 3]
			[local51 4]
			[local51 5]
			[local51 6]
		)
	)
	(return (+ (<< temp0 $0001) temp1))
)

(procedure (localproc_6 param1 param2 param3 param4 param5 param6 &tmp temp0)
	(= param1 (/ (* (- param1 122) 16) 10))
	(= param2 (/ (* (- 88 param2) 16) 8))
	(cond
		((== argc 6)
			(if param3
				(= temp0
					(/
						(+
							(* param4 (/ (* param1 param1) 16))
							(* param5 param1)
							(* param6 16)
						)
						param3
					)
				)
			else
				(return 0)
			)
		)
		(param3
			(= temp0 (/ (+ (* param4 param1) (* param5 16)) param3))
		)
		(param4
			(return (> param1 (/ (* (- param5) 16) param4)))
		)
		(else
			(return 0)
		)
	)
	(return (> param2 temp0))
)

(procedure (localproc_7)
	(switch global114
		(0
			(while (== [local51 0] (= [local58 0] (- (Random 0 14) 7)))
			)
			(while (== [local51 0] (= [local58 1] (- (Random 0 14) 7)))
			)
		)
		(1
			(= [local58 1] (- (Random 0 8) 4))
			(if [local58 1]
				(= [local58 0] (Random 1 4))
			else
				(= [local58 0] 1)
			)
			(if (== (Abs [local58 0]) (Abs [local58 1]))
				(= [local58 0] (if (> [local58 0] 0) 1 else -1))
				(= [local58 1] (if (> [local58 1] 0) 1 else -1))
			)
			(= [local58 2] (- (Random 0 14) 7))
			(= [local58 3] (Random 0 4))
			(if [local58 3]
				(= [local58 4]
					(if (Random 0 1)
						(- (Random 1 4))
					else
						(Random 1 4)
					)
				)
			else
				(= [local58 4] 1)
			)
			(if (== (Abs [local58 3]) (Abs [local58 4]))
				(= [local58 3] (if (> [local58 3] 0) 1 else -1))
				(= [local58 4] (if (> [local58 4] 0) 1 else -1))
			)
			(= [local58 5] (- (Random 0 14) 7))
		)
		(2
			(= [local58 0] (Random 0 6))
			(if [local58 0]
				(= [local58 1] (- (Random 0 12) 6))
			else
				(= [local58 1] 1)
			)
			(if (not [local58 1])
				(= [local58 0] 1)
			)
			(if (== (Abs [local58 0]) (Abs [local58 1]))
				(= [local58 0] (if (> [local58 0] 0) 1 else -1))
				(= [local58 1] (if (> [local58 1] 0) 1 else -1))
			)
			(= [local58 2] (- (Random 0 14) 7))
			(= [local58 3] (Random 2 4))
			(= [local58 4]
				(if (Random 0 1)
					(- (Random 1 [local58 3]))
				else
					(Random 1 [local58 3])
				)
			)
			(if (== (Abs [local58 3]) (Abs [local58 4]))
				(= [local58 3] (if (> [local58 3] 0) 1 else -1))
				(= [local58 4] (if (> [local58 4] 0) 1 else -1))
			)
			(= [local58 5] (- (Random 0 10) 5))
			(= [local58 6] (- (Random 0 12) 6))
		)
	)
)

(procedure (localproc_8 param1 param2 param3 param4)
	(if (and (>= 15 param3 0) (>= 15 param4 0))
		(return
			(!=
				(& [local65 (+ (* 16 param1) param2)] $0038)
				(& [local65 (+ (* 16 param3) param4)] $0038)
			)
		)
	else
		(return 0)
	)
)

(instance cartesian of PuzzleBar
	(properties
		solvedFlag 7
		noun 11
		msgModule 160
		personalID 14
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(gGame setCursor: 997 1)
		(gCSoundFX number: 22 setLoop: -1 play:)
		(= window puzzleWindow)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(self
				add:
					((critter new:)
						loop: (+ temp0 3)
						nsLeft: [local36 temp0]
						nsTop: [local40 temp0]
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 [local3 global114]) ((++ temp0))
			(= temp10
				(if (or (not temp0) (and global114 (< temp0 3))) 14 else 1)
			)
			(self
				add:
					((upButton new:)
						loop: temp10
						nsLeft: [local21 (+ [local0 global114] temp0)]
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 [local3 global114]) ((++ temp0))
			(= temp10
				(if (or (not temp0) (and global114 (< temp0 3))) 15 else 2)
			)
			(self
				add:
					((= temp1 (downButton new:))
						loop: temp10
						nsLeft: [local21 (+ [local0 global114] temp0)]
						value: temp0
						text: [local44 temp0]
						textColor:
							(if
								(or
									(> temp0 2)
									(and (not global114) (> temp0 0))
								)
								11
							else
								51
							)
						yourself:
					)
			)
			(= [local51 temp0] [local6 (+ [local0 global114] temp0)])
			((self at: (+ temp0 4)) cursor: temp1)
		)
		(for ((= temp9 1)) temp9 ((= temp9 (localproc_1)))
			(localproc_7)
			(for ((= temp3 0)) (< temp3 16) ((++ temp3))
				(for ((= temp4 0)) (< temp4 16) ((++ temp4))
					(= temp5
						(localproc_3 (+ 44 (* temp4 10)) (+ 26 (* temp3 8)))
					)
					(= temp6
						(localproc_3 (+ 50 (* temp4 10)) (+ 26 (* temp3 8)))
					)
					(= temp7
						(localproc_3 (+ 44 (* temp4 10)) (+ 31 (* temp3 8)))
					)
					(= temp8
						(localproc_3 (+ 50 (* temp4 10)) (+ 31 (* temp3 8)))
					)
					(if (== temp5 temp6 temp7 temp8)
						(= [local65 (+ (* 16 temp3) temp4)]
							(+ 32 (<< temp5 $0003) (Random 0 4))
						)
					else
						(= [local65 (+ (* 16 temp3) temp4)] 0)
					)
				)
			)
			(if global114
				(= local449 0)
				(for ((= temp3 0)) (< temp3 16) ((++ temp3))
					(for ((= temp4 0)) (< temp4 16) ((++ temp4))
						(if [local65 (+ (* 16 temp3) temp4)]
							(= temp5
								(localproc_8 temp3 temp4 (- temp3 1) temp4)
							)
							(= temp6
								(localproc_8 temp3 temp4 (+ temp3 1) temp4)
							)
							(= temp7
								(localproc_8 temp3 temp4 temp3 (- temp4 1))
							)
							(= temp8
								(localproc_8 temp3 temp4 temp3 (+ temp4 1))
							)
							(if (or temp5 temp6 temp7 temp8)
								(= [local321 local449] (+ (* 16 temp3) temp4))
								(= [local65 (+ (* 16 temp3) temp4)]
									(+
										(&
											[local65 (+ (* 16 temp3) temp4)]
											$fff8
										)
										(Random 0 3)
									)
								)
								(+=
									[local321 local449]
									(<<
										(|
											(|
												(|
													(if temp5 3 else 0)
													(if temp6 12 else 0)
												)
												(if temp7 9 else 0)
											)
											(if temp8 6 else 0)
										)
										$0008
									)
								)
								(++ local449)
							)
						)
					)
				)
			)
		)
		(self add: dummyIcon)
		(super init: &rest)
		(gGame setCursor: 900 1)
		(gCSoundFX setLoop: 1 stop:)
	)

	(method (show)
		(= highlightedIcon 0)
		(LoadMany rsSOUND 104 236 240 242)
		(super show: &rest)
	)

	(method (hide)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super hide: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(if (& (event type:) $0040) ; direction
			(if (IsObject highlightedIcon)
				(= temp1 (self indexOf: highlightedIcon))
			else
				(= temp1 0)
			)
			(switch (event message:)
				(JOY_DOWN
					(cond
						((< temp1 2)
							(+= temp1 2)
						)
						((< temp1 3)
							(= temp1 4)
						)
						((< temp1 3)
							(= temp1 (+ [local3 global114] 3))
						)
						((< temp1 (+ [local3 global114] 4))
							(+= temp1 [local3 global114])
						)
						((< temp1 (+ (* [local3 global114] 2) 4))
							(= temp1 (- size 4))
						)
						((< temp1 (- size 3))
							(= temp1 (- size 2))
						)
						(else
							(= temp1 0)
						)
					)
				)
				(JOY_UP
					(cond
						((< temp1 2)
							(= temp1 (- size 2))
						)
						((< temp1 4)
							(-= temp1 2)
						)
						((< temp1 (+ (/ [local3 global114] 2) 4))
							(= temp1 2)
						)
						((< temp1 (+ [local3 global114] 4))
							(= temp1 3)
						)
						((< temp1 (+ (* [local3 global114] 2) 4))
							(-= temp1 [local3 global114])
						)
						((< temp1 (- size 3))
							(-- temp1)
						)
						(else
							(= temp1 (- size 4))
						)
					)
				)
				(JOY_RIGHT
					(cond
						((< temp1 2)
							(if (>= (++ temp1) 2)
								(= temp1 0)
							)
						)
						((< temp1 4)
							(if (>= (++ temp1) 4)
								(= temp1 2)
							)
						)
						((< temp1 (+ [local3 global114] 4))
							(if (>= (++ temp1) (+ [local3 global114] 4))
								(= temp1 4)
							)
						)
						((< temp1 (+ (* [local3 global114] 2) 4))
							(if (>= (++ temp1) (+ (* [local3 global114] 2) 4))
								(= temp1 (+ [local3 global114] 4))
							)
						)
						((< temp1 (- size 3)) 0)
						((>= (++ temp1) size)
							(= temp1 (- size 3))
						)
					)
				)
				(JOY_LEFT
					(cond
						((< temp1 2)
							(if (< (-- temp1) 0)
								(= temp1 1)
							)
						)
						((< temp1 4)
							(if (< (-- temp1) 2)
								(= temp1 3)
							)
						)
						((< temp1 (+ [local3 global114] 4))
							(if (< (-- temp1) 4)
								(= temp1 (+ [local3 global114] 3))
							)
						)
						((< temp1 (+ (* [local3 global114] 2) 4))
							(if (< (-- temp1) (+ [local3 global114] 4))
								(= temp1 (+ (* [local3 global114] 2) 3))
							)
						)
						((< temp1 (- size 3)) 0)
						((< (-- temp1) (- size 3))
							(= temp1 (- size 1))
						)
					)
				)
			)
			(= temp0 (self at: temp1))
			(proc5_9 temp0)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (super buyClue: &rest)
			(= temp1 1)
			(cond
				((and (not global114) (== [local51 0] [local58 0]))
					(= temp1 0)
				)
				(
					(and
						(not [local58 0])
						(== [local51 1] [local58 1])
						(== (/ [local51 2] temp0) [local58 2]) ; UNINIT
					)
					(= temp1 0)
				)
				(
					(or
						(not [local58 0])
						(not (= temp0 (/ [local51 0] [local58 0])))
					)
					0
				)
				(
					(and
						(== (/ [local51 1] temp0) [local58 1])
						(== (/ [local51 2] temp0) [local58 2])
					)
					(= temp1 0)
				)
			)
			(if temp1
				(= temp2 0)
				(= temp3 (if global114 2 else 0))
			else
				(= temp2 (if global114 3 else 1))
				(= temp3
					(if (not global114)
						1
					else
						(+ 4 global114)
					)
				)
			)
			(Wait 0)
			(for ((= temp4 temp2)) (<= temp4 temp3) ((++ temp4))
				(if (<= [local51 temp4] [local58 temp4])
					(= temp5 (self at: (+ 4 temp4)))
				else
					(= temp5 (self at: (+ 4 [local3 global114] temp4)))
				)
				(while (!= [local51 temp4] [local58 temp4])
					(self select: temp5 0)
					(Wait 15)
				)
			)
		)
	)
)

(instance puzzleWindow of SysWindow
	(properties
		top 1
		left 30
		bottom 188
		right 275
		priority -1
	)

	(method (open)
		(super open: &rest)
		(DrawCel 162 0 0 0 21 -1)
		(DrawCel 162 0 1 120 21 -1)
		(DrawCel 162 0 2 0 156 -1)
		(DrawCel 162 0 3 120 156 -1)
		(switch global114
			(0
				(DrawCel 162 9 0 28 165 -1)
				(DrawCel 162 10 0 158 165 -1)
			)
			(1
				(DrawCel 162 11 0 9 165 -1)
				(DrawCel 162 11 0 141 165 -1)
			)
			(2
				(DrawCel 162 11 0 9 165 -1)
				(DrawCel 162 12 0 109 163 -1)
			)
		)
		(localproc_0)
	)
)

(instance upButton of CodeIcon
	(properties
		view 162
		loop 1
		nsTop 157
		upClick 0
	)

	(method (select)
		(if (super select: &rest)
			(if (< [local51 (cursor value:)] 8)
				(gCSoundFX number: 242 setLoop: 1 play:)
				(++ [local51 (cursor value:)])
				(cursor showText:)
				(localproc_0)
			else
				(gCSoundFX number: 240 setLoop: 1 play:)
			)
		)
	)
)

(instance downButton of TextIcon
	(properties
		view 162
		loop 2
		nsTop 175
		upClick 0
	)

	(method (select)
		(if (super select: &rest)
			(if (> [local51 value] -8)
				(gCSoundFX number: 239 setLoop: 1 play:)
				(-- [local51 value])
				(self showText:)
				(localproc_0)
			else
				(gCSoundFX number: 240 setLoop: 1 play:)
			)
		)
	)

	(method (showText)
		(Format text {%d} [local51 value])
		(DrawCel view loop 3 (+ nsLeft 1) (- nsTop 9) -1)
		(if (>= [local51 value] 0)
			(proc5_8 text textColor (+ nsLeft 6) (- nsTop 8))
		else
			(proc5_8 text textColor (+ nsLeft 3) (- nsTop 8))
		)
	)
)

(instance critter of IconI
	(properties
		view 162
		cel 0
		signal 129
	)

	(method (select))

	(method (highlight param1)
		(cond
			(param1
				(Print
					modeless: 1
					addText: 10 1 1 (+ (- loop 3) 1) 70
					addIcon: view loop 5 0 0
					init:
				)
			)
			((IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
		)
	)
)

(instance dummyIcon of IconI
	(properties
		nsLeft 42
		nsTop 24
		nsRight 202
		nsBottom 147
		noun 19
	)

	(method (highlight)
		(return 0)
	)

	(method (show)
		(return 0)
	)

	(method (select)
		(gMessager say: noun 4) ; "You can't move the lines by clicking on this display. Remember to click on the |c2|up and down arrows|c| below."
	)
)

