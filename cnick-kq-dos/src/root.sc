;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use MoveToEndLoop)
(use Interface)
(use Motion)
(use System)

(public
	root 0
	lev1Lst 1
	lev2Lst 2
	lev3Lst 3
	lev4Lst 4
	movLst 5
	lev44Lst 6
	lev5Lst 7
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
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
)

(procedure (localproc_0 &tmp [temp0 500]) ; UNUSED
	(Format @temp0 &rest)
	(Print @temp0 64 10 180)
)

(class Tree of List
	(properties
		sel_20 {Tree}
		sel_584 0
		sel_585 0
		sel_586 0
		sel_587 0
		sel_74 -1000
	)

	(method (sel_588 param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp0 (Tree sel_109:))
		(temp0 sel_118:)
		(temp0 sel_584: param1 sel_585: param2 sel_586: param3 sel_587: param4)
		(++ global256)
		(self sel_118: temp0)
		(return temp0)
	)

	(method (sel_589 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(proc0_6)
		(proc0_6)
		(proc0_6)
		(proc0_6)
		(proc0_6)
		(proc0_6)
		(= local15 0)
		(= local16 0)
		(= global264 0)
		(= global265 0)
		(= local11 0)
		(= local12 0)
		(= local13 0)
		(= local0 1)
		(= local1 0)
		(= local2 0)
		(= local3 0)
		(= local4 0)
		(= local5 0)
		(if (and (<= global249 1) (!= ((ScriptID 200 6) sel_527:) 0)) ; player1
			(Wait 1)
			(Wait 20)
			(proc0_6)
			(Wait 20)
			(proc0_6)
			(Wait 20)
			(proc0_6)
			(Wait 20)
			(proc0_6)
			(Wait 100)
			((ScriptID 201 0) sel_57:) ; book
			(self sel_596:)
			(return 1)
		)
		(root sel_590: 1)
		(= local0 0)
		(= global243 (root sel_64: 0))
		(if (== (root sel_86:) 0)
			(return 0)
		)
		(root sel_119: 74 1000)
		(for ((= temp1 0)) (< temp1 (root sel_86:)) ((++ temp1))
			(= global240 (root sel_64: temp1))
			(if (!= ((ScriptID 200 6) sel_527:) 0) ; player1
				(if local10
					((ScriptID 203 0) sel_57:) ; endGame1
				)
				(if local11
					((ScriptID 203 3) sel_57:) ; endGame4
				)
			)
			(if local12
				(chaseCode sel_57: global240)
			)
			(if (== ((ScriptID 200 6) sel_527:) 0) ; player1
				(= global242 1)
			)
			(self sel_592: global240)
			(if (global240 sel_586:)
				(self sel_595: (global240 sel_585:) 1 1 lev1Lst)
			)
			(global240 sel_590: -1)
			(global240 sel_119: 74 -1000)
			(= global242 0)
			(if (!= ((ScriptID 200 6) sel_527:) 0) ; player1
				(for ((= temp2 0)) (< temp2 (global240 sel_86:)) ((++ temp2))
					(= global241 (global240 sel_64: temp2))
					(self sel_592: global241)
					(if (global241 sel_586:)
						(self sel_595: (global241 sel_585:) -1 1 lev2Lst)
					)
					(global241 sel_590: 1)
					(global241 sel_119: 74 1000)
					(for
						((= temp3 0))
						(< temp3 (global241 sel_86:))
						((++ temp3))
						
						(proc0_6)
						(= global255 (global241 sel_64: temp3))
						(if
							(or
								(== ((ScriptID 200 6) sel_527:) 1) ; player1
								(and
									(or
										(not (global241 sel_586:))
										(not (global255 sel_586:))
									)
									(> local17 8)
								)
							)
							(= global242 1)
						)
						(self sel_592: global255)
						(if (global255 sel_586:)
							(self sel_595: (global255 sel_585:) 1 1 lev3Lst)
						)
						(global255 sel_590: -1)
						(if
							(and
								(== ((ScriptID 200 6) sel_527:) 2) ; player1
								(or
									(<= local17 8)
									(and
										(global255 sel_586:)
										(global241 sel_586:)
									)
								)
							)
							(global255 sel_119: 74 -1000)
							(for
								((= temp5 0))
								(< temp5 (global255 sel_86:))
								((++ temp5))
								
								(proc0_6)
								(= global257 (global255 sel_64: temp5))
								(self sel_592: global257)
								(if (global257 sel_586:)
									(self
										sel_595:
											(global257 sel_585:)
											-1
											1
											lev44Lst
									)
								)
								(global257 sel_590: 1)
								(global257 sel_119: 74 1000)
								(for
									((= temp6 0))
									(< temp6 (global257 sel_86:))
									((++ temp6))
									
									(= global258 (global257 sel_64: temp6))
									(= global242 1)
									(self sel_592: global258)
									(if (global258 sel_586:)
										(self
											sel_595:
												(global258 sel_585:)
												1
												1
												lev5Lst
										)
									)
									(global258 sel_590: -1)
									(= global242 0)
									(if
										(>
											(global258 sel_74:)
											(global257 sel_74:)
										)
										(global257 sel_74: (global258 sel_74:))
									)
									(if (lev5Lst sel_123:)
										(self sel_593: global258)
									else
										(for
											((= temp4 (- (lev5Lst sel_86:) 1)))
											(>= temp4 0)
											((-- temp4))
											
											(self
												sel_593: (lev5Lst sel_64: temp4)
											)
										)
										(self sel_593: global258)
										(lev5Lst sel_577: lev5Lst)
										(lev5Lst sel_125:)
									)
									(if
										(>=
											(global257 sel_74:)
											(global255 sel_74:)
										)
										(break)
									)
								)
								(if (< (global257 sel_74:) (global255 sel_74:))
									(global255 sel_74: (global257 sel_74:))
								)
								(if (lev44Lst sel_123:)
									(self sel_593: global257)
								else
									(for
										((= temp4 (- (lev44Lst sel_86:) 1)))
										(>= temp4 0)
										((-- temp4))
										
										(self sel_593: (lev44Lst sel_64: temp4))
									)
									(self sel_593: global257)
									(lev44Lst sel_577: lev44Lst)
									(lev44Lst sel_125:)
								)
								(self sel_577: global257)
								(if (<= (global255 sel_74:) (global241 sel_74:))
									(break)
								)
							)
						)
						(= global242 0)
						(if (> (global255 sel_74:) (global241 sel_74:))
							(global241 sel_74: (global255 sel_74:))
						)
						(if (lev3Lst sel_123:)
							(self sel_593: global255)
						else
							(for
								((= temp4 (- (lev3Lst sel_86:) 1)))
								(>= temp4 0)
								((-- temp4))
								
								(self sel_593: (lev3Lst sel_64: temp4))
							)
							(self sel_593: global255)
							(lev3Lst sel_577: lev3Lst)
							(lev3Lst sel_125:)
						)
						(self sel_577: global255)
						(if (>= (global241 sel_74:) (global240 sel_74:))
							(break)
						)
					)
					(if (< (global241 sel_74:) (global240 sel_74:))
						(global240 sel_74: (global241 sel_74:))
					)
					(if (lev2Lst sel_123:)
						(self sel_593: global241)
					else
						(for
							((= temp4 (- (lev2Lst sel_86:) 1)))
							(>= temp4 0)
							((-- temp4))
							
							(self sel_593: (lev2Lst sel_64: temp4))
						)
						(self sel_593: global241)
						(lev2Lst sel_577: lev2Lst)
						(lev2Lst sel_125:)
					)
					(self sel_577: global241)
				)
			)
			(if (lev1Lst sel_123:)
				(self sel_593: global240)
			else
				(for
					((= temp4 (- (lev1Lst sel_86:) 1)))
					(>= temp4 0)
					((-- temp4))
					
					(self sel_593: (lev1Lst sel_64: temp4))
				)
				(self sel_593: global240)
				(lev1Lst sel_577: lev1Lst)
				(lev1Lst sel_125:)
			)
			(cond
				((or (<= global249 18) (<= local2 3))
					(if
						(and
							(== (global240 sel_74:) (global243 sel_74:))
							(not (copyMove sel_57:))
						)
						(movLst sel_118: global240)
					)
					(if
						(and
							(> (global240 sel_74:) (global243 sel_74:))
							(not (copyMove sel_57:))
						)
						(= global243 global240)
						(movLst sel_125:)
						(movLst sel_118: global243)
					)
				)
				((or (not global268) (< global249 15))
					(if (> (global240 sel_74:) (global243 sel_74:))
						(= global243 global240)
					)
				)
				((== (global240 sel_74:) (global243 sel_74:))
					(if
						(and
							(not (copyMove sel_57:))
							(!= ([global200 (global243 sel_584:)] sel_574:) 1)
							(!= ([global200 (global240 sel_584:)] sel_574:) 2)
						)
						(= global243 global240)
					)
				)
				(
					(and
						(not (copyMove sel_57:))
						(> (global240 sel_74:) (global243 sel_74:))
					)
					(= global243 global240)
				)
			)
			(self sel_577: global240)
		)
		(if (or (<= global249 18) (<= local2 3))
			(= temp0 (Random 0 (- (movLst sel_86:) 1)))
			(= global243 (movLst sel_64: temp0))
			(movLst sel_125: sel_111:)
		)
		(if (!= ((ScriptID 200 6) sel_527:) 0) ; player1
			(if (<= global249 1)
				((ScriptID 201 0) sel_57:) ; book
			)
			(if (<= global249 3)
				(if (not (global243 sel_586:))
					((ScriptID 201 0) sel_57:) ; book
				else
					(= global267 1)
				)
			)
			(if
				(and
					(not (global243 sel_586:))
					(<= global249 5)
					(not global267)
				)
				((ScriptID 201 0) sel_57:) ; book
			)
		)
		(if global268
			(= local8 local6)
			(= local9 local7)
			(= local6 (global243 sel_585:))
			(= local7 (global243 sel_584:))
		)
		(if
			(and
				global264
				global265
				(or local10 local11)
				(not (global243 sel_586:))
			)
			(global243 sel_584: global264)
			(global243 sel_585: global265)
			(global243 sel_586: 0)
		)
		(self sel_596:)
		(return 1)
	)

	(method (sel_144)
		(if (== global266 250)
			(gSound sel_39: 208)
			(global253 sel_4: 0 sel_3: 2)
			(proc0_1)
			(global253 sel_153: 0)
		else
			(gSound sel_39: 200)
		)
		(if (and (< (global243 sel_585:) 5) (not global245))
			(if (!= (global253 sel_31:) 2)
				(= global273 1)
			)
			(if (== global269 1)
				(= global269 2)
			)
			(if (== global266 200)
				(global253 sel_31: 2 sel_4: 3 sel_454: 2)
			else
				(global253 sel_31: 2)
				(cond
					((== (global253 sel_2:) 250)
						(global253 sel_2: 251)
					)
					((== (global253 sel_2:) 252)
						(global253 sel_2: 253)
					)
				)
			)
		)
		((gCurRoom sel_141:) sel_144:)
	)

	(method (sel_596 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= global246 0)
		(= global245 0)
		(= temp0 ((ScriptID 200 1) sel_120: 568 (global243 sel_584:))) ; pieces
		(temp0 sel_566: (global243 sel_585:))
		(= temp2 (global243 sel_585:))
		(if (< (global243 sel_585:) 5)
			(if (== (temp0 sel_31:) 1)
				(= temp1 1)
			)
			([global200 (global243 sel_585:)] sel_574: 2)
		else
			([global200 (global243 sel_585:)]
				sel_574: ([global200 (global243 sel_584:)] sel_574:)
			)
		)
		([global200 (global243 sel_584:)] sel_574: 0)
		(if (global243 sel_586:)
			(= global246 1)
			([global200 (global243 sel_586:)] sel_574: 0)
			(= global250 ((ScriptID 200 1) sel_120: 568 (global243 sel_586:))) ; pieces
			(if (not temp1)
				(= global245 (self sel_594:))
			else
				(= global245 0)
			)
		)
		(= global253 temp0)
		(if (== global266 200)
			(temp0
				sel_63: 15
				sel_296:
					MoveTo
					(+ ([global200 temp2] sel_7:) 14)
					(+ ([global200 temp2] sel_6:) 12)
					self
			)
		else
			(temp0
				sel_63: 15
				sel_296:
					MoveToEndLoop
					(+ ([global200 temp2] sel_7:) 14)
					(+ ([global200 temp2] sel_6:) 12)
					self
			)
		)
	)

	(method (sel_592 param1)
		([global200 (param1 sel_585:)]
			sel_574: ([global200 (param1 sel_584:)] sel_574:)
		)
		([global200 (param1 sel_584:)] sel_574: 0)
		(if (param1 sel_586:)
			([global200 (param1 sel_586:)] sel_574: 0)
		)
	)

	(method (sel_593 param1)
		([global200 (param1 sel_584:)]
			sel_574: ([global200 (param1 sel_585:)] sel_574:)
		)
		([global200 (param1 sel_585:)] sel_574: 0)
		(if (param1 sel_586:)
			([global200 (param1 sel_586:)] sel_574: (param1 sel_587:))
		)
	)

	(method (sel_577 param1 &tmp temp0 temp1)
		(for ((= temp0 (- (param1 sel_86:) 1))) (>= temp0 0) ((-- temp0))
			(= temp1 (param1 sel_64: temp0))
			(if (temp1 sel_123:)
				(param1 sel_81: temp1)
				(-- global256)
				(temp1 sel_111:)
			)
		)
	)

	(method (sel_590 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 2])
		(if (and (not local16) (> (- (GetTime) global247) 200))
			(= local16 1)
		)
		(if local16
			(if (HaveMouse)
				(gGame sel_191: (+ 983 local15))
			else
				(gGame sel_191: (+ 983 local15) 1 305 185)
			)
			(if (> (++ local15) 7)
				(= local15 0)
			)
		)
		(= temp9 0)
		(= temp8 0)
		(= temp7 0)
		(= temp4 0)
		(if (== param1 1)
			(for ((= temp2 1)) (< temp2 33) ((++ temp2))
				(if local0
					(switch ([global200 temp2] sel_574:)
						(1
							(++ local2)
							(+= local1 2)
						)
						(2
							(++ local3)
							(+= local1 3)
						)
						(-1
							(++ local4)
							(-= local1 2)
						)
						(-2
							(= local13 temp2)
							(++ local5)
							(-= local1 3)
							(if
								(or
									(== temp2 24)
									(== temp2 27)
									(== temp2 28)
									(== temp2 32)
									(== temp2 1)
									(== temp2 5)
									(== temp2 6)
									(== temp2 9)
								)
								(= temp7 1)
							)
							(if
								(or
									(and
										(== temp2 2)
										(== ([global200 14] sel_574:) 2)
										(== ([global200 1] sel_574:) 2)
									)
									(and
										(== temp2 7)
										(== ([global200 18] sel_574:) 2)
										(== ([global200 1] sel_574:) 2)
									)
									(and
										(== temp2 13)
										(== ([global200 10] sel_574:) 2)
										(== ([global200 5] sel_574:) 2)
									)
									(and
										(== temp2 17)
										(== ([global200 15] sel_574:) 2)
										(== ([global200 5] sel_574:) 2)
									)
									(and
										(== temp2 20)
										(== ([global200 23] sel_574:) 2)
										(== ([global200 28] sel_574:) 2)
									)
									(and
										(== temp2 16)
										(== ([global200 28] sel_574:) 2)
										(== ([global200 18] sel_574:) 2)
									)
									(and
										(== temp2 31)
										(== ([global200 19] sel_574:) 2)
										(== ([global200 32] sel_574:) 2)
									)
									(and
										(== temp2 26)
										(== ([global200 15] sel_574:) 2)
										(== ([global200 32] sel_574:) 2)
									)
								)
								(= temp7 1)
							)
							(if
								(or
									(== temp2 1)
									(== temp2 5)
									(== temp2 6)
									(== temp2 9)
								)
								(= temp8 1)
							)
							(if
								(and
									temp8
									(or
										(== temp2 24)
										(== temp2 27)
										(== temp2 28)
										(== temp2 32)
									)
								)
								(= temp9 1)
							)
						)
					)
				)
				(if (> ([global200 temp2] sel_574:) 0)
					(for
						((= temp3 0))
						(<=
							temp3
							(if (== ([global200 temp2] sel_574:) 1) 1 else 3)
						)
						((++ temp3))
						
						(= temp0 ([global200 temp2] sel_575: temp3))
						(= temp1 ([global200 temp0] sel_575: temp3))
						(if
							(and
								(< ([global200 temp0] sel_574:) 0)
								(== ([global200 temp1] sel_574:) 0)
							)
							(= temp5 ([global200 temp0] sel_574:))
							(= temp4 1)
							(if (not global242)
								(self sel_588: temp2 temp1 temp0 temp5)
							else
								(self sel_591: temp2 temp0 temp1 param1)
								(if (> global252 (global241 sel_74:))
									(global241 sel_74: global252)
									(if
										(>=
											(global241 sel_74:)
											(global240 sel_74:)
										)
										(return)
									)
								)
							)
						)
					)
				)
			)
			(= local17 (+ local4 local2 local5 local3))
			(cond
				(
					(and
						temp7
						(== local3 2)
						(== local2 0)
						(== local5 1)
						(== local4 0)
					)
					(= local10 1)
					((ScriptID 203 1) sel_57:) ; endGame2
				)
				(
					(and
						temp9
						(== local3 3)
						(== local2 0)
						(== local5 2)
						(== local4 0)
					)
					(= local11 1)
					((ScriptID 203 2) sel_57:) ; endGame3
				)
				((and (> local3 0) (> local5 0))
					(= local12 1)
				)
			)
			(if (not temp4)
				(= temp1 0)
				(for ((= temp2 1)) (< temp2 33) ((++ temp2))
					(if (> ([global200 temp2] sel_574:) 0)
						(for
							((= temp3 0))
							(<=
								temp3
								(if (== ([global200 temp2] sel_574:) 1)
									1
								else
									3
								)
							)
							((++ temp3))
							
							(= temp0 ([global200 temp2] sel_575: temp3))
							(if (== ([global200 temp0] sel_574:) 0)
								(if (not global242)
									(self sel_588: temp2 temp0 0 0)
								else
									(self sel_591: temp2 temp0 0 param1)
									(if (> global252 (global241 sel_74:))
										(global241 sel_74: global252)
										(if
											(>=
												(global241 sel_74:)
												(global240 sel_74:)
											)
											(return)
										)
									)
								)
							)
						)
					)
				)
			)
		else
			(for ((= temp2 1)) (< temp2 33) ((++ temp2))
				(if (< ([global200 temp2] sel_574:) 0)
					(for
						((= temp3 3))
						(>=
							temp3
							(if (== ([global200 temp2] sel_574:) -1) 2 else 0)
						)
						((-- temp3))
						
						(= temp0 ([global200 temp2] sel_575: temp3))
						(= temp1 ([global200 temp0] sel_575: temp3))
						(if
							(and
								(> ([global200 temp0] sel_574:) 0)
								(== ([global200 temp1] sel_574:) 0)
							)
							(= temp5 ([global200 temp0] sel_574:))
							(= temp4 1)
							(if (not global242)
								(= temp6
									(self sel_588: temp2 temp1 temp0 temp5)
								)
							else
								(self sel_591: temp2 temp0 temp1 param1)
								(cond
									(
										(and
											(== ((ScriptID 200 6) sel_527:) 2) ; player1
											(or
												(<= local17 8)
												(and
													(global241 sel_586:)
													(global255 sel_586:)
												)
											)
										)
										(if (< global252 (global258 sel_74:))
											(global258 sel_74: global252)
											(if
												(<=
													(global258 sel_74:)
													(global257 sel_74:)
												)
												(return)
											)
										)
									)
									((!= ((ScriptID 200 6) sel_527:) 0) ; player1
										(if (< global252 (global255 sel_74:))
											(global255 sel_74: global252)
											(if
												(<=
													(global255 sel_74:)
													(global241 sel_74:)
												)
												(return)
											)
										)
									)
									((< global252 (global240 sel_74:))
										(global240 sel_74: global252)
									)
								)
							)
						)
					)
				)
			)
			(if (not temp4)
				(= temp1 0)
				(for ((= temp2 1)) (< temp2 33) ((++ temp2))
					(if (< ([global200 temp2] sel_574:) 0)
						(for
							((= temp3 3))
							(>=
								temp3
								(if (== ([global200 temp2] sel_574:) -1)
									2
								else
									0
								)
							)
							((-- temp3))
							
							(= temp0 ([global200 temp2] sel_575: temp3))
							(if (== ([global200 temp0] sel_574:) 0)
								(if (not global242)
									(self sel_588: temp2 temp0 0 0)
								else
									(self sel_591: temp2 temp0 0 param1)
									(cond
										(
											(and
												(==
													((ScriptID 200 6) sel_527:) ; player1
													2
												)
												(or
													(<= local17 8)
													(and
														(global241 sel_586:)
														(global255 sel_586:)
													)
												)
											)
											(if
												(<
													global252
													(global258 sel_74:)
												)
												(global258 sel_74: global252)
												(if
													(<=
														(global258 sel_74:)
														(global257 sel_74:)
													)
													(return)
												)
											)
										)
										((!= ((ScriptID 200 6) sel_527:) 0) ; player1
											(if
												(<
													global252
													(global255 sel_74:)
												)
												(global255 sel_74: global252)
												(if
													(<=
														(global255 sel_74:)
														(global241 sel_74:)
													)
													(return)
												)
											)
										)
										((< global252 (global240 sel_74:))
											(global240 sel_74: global252)
										)
									)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (sel_591 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(if (== param3 0)
			([global200 param2] sel_574: ([global200 param1] sel_574:))
		else
			([global200 param3] sel_574: ([global200 param1] sel_574:))
			(= temp2 ([global200 param2] sel_574:))
			([global200 param2] sel_574: 0)
			(self sel_595: param3 -1 1 lev4Lst)
		)
		([global200 param1] sel_574: 0)
		(= temp12 0)
		(= global252 0)
		(= temp5 0)
		(= temp3 0)
		(= temp6 0)
		(= temp4 0)
		(= temp7 0)
		(= temp8 0)
		(= temp9 0)
		(= temp10 0)
		(= temp11 1)
		(if
			(and
				(!= ((ScriptID 200 6) sel_527:) 0) ; player1
				(not (global240 sel_586:))
				(global241 sel_586:)
				(not (global255 sel_586:))
			)
			(-= global252 200)
		)
		(for ((= temp1 1)) (<= temp1 32) ((++ temp1))
			(switch ([global200 temp1] sel_574:)
				(1
					(if (< temp1 5)
						(+= global252 60)
					else
						(+= global252 40)
					)
					(if (or (> temp1 29) (== temp1 26))
						(++ temp5)
					)
					(if (< 12 temp1 17)
						(++ global252)
					)
					(if (< 8 temp1 13)
						(+= global252 1)
					)
					(if (< 4 temp1 9)
						(+= global252 2)
					)
					(if
						(and
							(> local2 4)
							(or
								(== temp1 14)
								(== temp1 15)
								(== temp1 18)
								(== temp1 19)
								(== temp1 23)
								(== temp1 28)
								(== temp1 24)
								(== temp1 27)
							)
						)
						(++ global252)
					)
					(if
						(and
							(== ([global200 temp1] sel_575: 1) 1)
							(==
								([global200 ([global200 temp1] sel_575: 1)]
									sel_575: 1
								)
								1
							)
						)
						(++ global252)
					)
					(if
						(and
							(== ([global200 temp1] sel_575: 0) 1)
							(==
								([global200 ([global200 temp1] sel_575: 0)]
									sel_575: 0
								)
								1
							)
						)
						(++ global252)
					)
					(if (== ((ScriptID 200 6) sel_527:) 2) ; player1
						(+= temp7 2)
						(= temp11 0)
						(if
							(or
								(<= 5 temp1 8)
								(<= 13 temp1 16)
								(<= 21 temp1 24)
								(<= 29 temp1 32)
							)
							(++ temp9)
						)
						(if (== temp1 30)
							(+= global252 3)
							(if
								(or
									(== ([global200 17] sel_574:) -1)
									(== ([global200 18] sel_574:) -1)
									(== ([global200 21] sel_574:) -1)
									(== ([global200 22] sel_574:) -1)
								)
								(++ global252)
							)
						)
						(if (== temp1 32)
							(+= global252 3)
							(if
								(or
									(== ([global200 19] sel_574:) -1)
									(== ([global200 20] sel_574:) -1)
									(== ([global200 23] sel_574:) -1)
									(== ([global200 24] sel_574:) -1)
								)
								(++ global252)
							)
						)
						(if
							(and
								(< 10 global249 25)
								(or (== temp1 9) (== temp1 13))
							)
							(++ global252)
						)
						(if
							(and
								(< global249 14)
								(or
									(== temp1 14)
									(== temp1 15)
									(== temp1 18)
									(== temp1 19)
								)
							)
							(++ global252)
						)
						(if
							(and
								(== ((ScriptID 200 3) sel_566:) 29) ; R29
								(== (global240 sel_584:) 29)
								(== (global240 sel_585:) 25)
							)
							(+= global252 3)
						)
						(if
							(and
								(== ((ScriptID 200 4) sel_566:) 25) ; R25
								(== (global240 sel_584:) 25)
								(== (global240 sel_585:) 22)
							)
							(+= global252 3)
						)
						(if
							(and
								(== ((ScriptID 200 5) sel_566:) 22) ; R22
								(== (global240 sel_584:) 22)
								(== (global240 sel_585:) 18)
							)
							(+= global252 3)
						)
						(if (== ([global200 temp1] sel_575: 0) 0)
							(++ global252)
						)
						(if (== ([global200 temp1] sel_575: 1) 0)
							(++ global252)
						)
						(if (== ([global200 temp1] sel_575: 2) 1)
							(+= global252 2)
						)
						(if (== ([global200 temp1] sel_575: 3) 1)
							(+= global252 2)
						)
					)
				)
				(2
					(= global268 1)
					(= temp10 1)
					(+= global252 60)
					(if
						(==
							([global200 ([global200 temp1] sel_575: 2)]
								sel_574:
							)
							-1
						)
						(++ global252)
					)
					(if
						(==
							([global200 ([global200 temp1] sel_575: 3)]
								sel_574:
							)
							-1
						)
						(++ global252)
					)
					(if (== ((ScriptID 200 6) sel_527:) 2) ; player1
						(+= temp7 3)
						(if
							(or
								(<= 5 temp1 8)
								(<= 13 temp1 16)
								(<= 21 temp1 24)
								(<= 29 temp1 32)
							)
							(++ temp9)
						)
						(if (> temp1 8)
							(++ global252)
						)
						(if
							(or
								(== temp1 14)
								(== temp1 15)
								(== temp1 18)
								(== temp1 19)
							)
							(++ global252)
						)
					)
				)
				(-1
					(if
						(and
							(> 29 temp1 20)
							(= local20 temp1)
							(kingPath sel_57: temp1)
						)
						(-= global252 15)
					)
					(if (> temp1 28)
						(-= global252 60)
					else
						(-= global252 40)
					)
					(if (== ((ScriptID 200 6) sel_527:) 2) ; player1
						(+= temp8 2)
						(= temp11 0)
						(if
							(or
								(<= 5 temp1 8)
								(<= 13 temp1 16)
								(<= 21 temp1 24)
								(<= 29 temp1 32)
							)
							(++ temp9)
						)
						(if (or (< temp1 4) (== temp1 7))
							(++ temp3)
						)
						(if (< 16 temp1 21)
							(-- global252)
						)
						(if (< 20 temp1 25)
							(-= global252 2)
						)
						(if (< 24 temp1 29)
							(-= global252 4)
						)
						(if
							(or
								(== temp1 14)
								(== temp1 15)
								(== temp1 18)
								(== temp1 19)
							)
							(-- global252)
						)
					)
				)
				(-2
					(-= global252 60)
					(= temp10 1)
					(if (== ((ScriptID 200 6) sel_527:) 2) ; player1
						(+= temp8 3)
						(if
							(or
								(<= 5 temp1 8)
								(<= 13 temp1 16)
								(<= 21 temp1 24)
								(<= 29 temp1 32)
							)
							(++ temp9)
						)
						(if (not local11)
							(if
								(or
									(== temp1 1)
									(== temp1 5)
									(== temp1 7)
									(== temp1 11)
									(== temp1 16)
									(== temp1 17)
									(== temp1 22)
									(== temp1 26)
									(== temp1 28)
									(== temp1 32)
								)
								(++ temp12)
							)
							(if
								(or
									(== temp1 2)
									(== temp1 13)
									(== temp1 20)
									(== temp1 31)
								)
								(+= temp12 2)
							)
							(if
								(or
									(== temp1 3)
									(== temp1 8)
									(== temp1 12)
									(== temp1 21)
									(== temp1 25)
									(== temp1 30)
								)
								(+= temp12 4)
							)
							(if (or (== temp1 4) (== temp1 29))
								(+= temp12 8)
							)
						)
						(if (< temp1 29)
							(-= global252 2)
						)
						(if
							(or
								(== temp1 14)
								(== temp1 15)
								(== temp1 18)
								(== temp1 19)
							)
							(-- global252)
						)
					)
				)
			)
		)
		(if (== ((ScriptID 200 6) sel_527:) 2) ; player1
			(if
				(and
					(< global249 10)
					(or
						(== (global240 sel_584:) 26)
						(== (global240 sel_584:) 27)
					)
					(global240 sel_586:)
				)
				(-= global252 5)
			)
			(if (== temp3 4)
				(= temp4 1)
			else
				(= temp4 0)
			)
			(if (== temp5 4)
				(= temp6 1)
			else
				(= temp6 0)
			)
			(if (and (== temp4 0) (== temp6 1))
				(+= global252 3)
			)
			(if (and (== temp4 1) (== temp6 0))
				(-= global252 3)
			)
			(if
				(and
					(global241 sel_586:)
					(>= temp7 (+ temp8 3))
					(global255 sel_586:)
				)
				(if (> local2 3)
					(+= global252 0)
				else
					(+= global252 8)
				)
			else
				(-= global252 2)
			)
			(if (== temp8 0)
				(+= global252 999)
			)
			(if (and (< (+ temp7 temp8) 24) (== (mod temp9 2) 1))
				(if temp11
					(+= global252 8)
				else
					(+= global252 3)
				)
			)
			(if
				(and
					(not temp10)
					(or
						(== ([global200 26] sel_574:) 1)
						(== ([global200 7] sel_574:) 1)
					)
				)
				(+= global252 2)
			)
			(if temp11
				(+= global252 temp12)
			)
			(if local10
				(+= global252 global263)
			)
			(if local11
				(+= global252 global263)
			)
		)
		(if local12
			(+= global252 local14)
		)
		(if (and (not temp10) (< global249 31))
			(self sel_597:)
		)
		(cond
			((== param3 0)
				([global200 param1] sel_574: ([global200 param2] sel_574:))
				([global200 param2] sel_574: 0)
			)
			((lev4Lst sel_123:)
				([global200 param1] sel_574: ([global200 param3] sel_574:))
				([global200 param2] sel_574: temp2)
				([global200 param3] sel_574: 0)
			)
			(else
				(for
					((= temp13 (- (lev4Lst sel_86:) 1)))
					(>= temp13 0)
					((-- temp13))
					
					(self sel_593: (lev4Lst sel_64: temp13))
				)
				([global200 param1] sel_574: ([global200 param3] sel_574:))
				([global200 param2] sel_574: temp2)
				([global200 param3] sel_574: 0)
				(lev4Lst sel_577: lev4Lst)
				(lev4Lst sel_125:)
			)
		)
	)

	(method (sel_594 &tmp temp0 temp1 temp2)
		(= local18 0)
		(= local19 0)
		(for
			((= temp0 0))
			(<=
				temp0
				(if (== ([global200 (global243 sel_585:)] sel_574:) 1) 1 else 3)
			)
			((++ temp0))
			
			(= temp1 ([global200 (global243 sel_585:)] sel_575: temp0))
			(= temp2 ([global200 temp1] sel_575: temp0))
			(if
				(and
					(< ([global200 temp1] sel_574:) 0)
					(== ([global200 temp2] sel_574:) 0)
				)
				(cond
					((== local18 0)
						(= local18 temp1)
						(= local19 temp2)
					)
					((self sel_595: temp2 1 0)
						(= local18 temp1)
						(= local19 temp2)
					)
					((== ([global200 temp1] sel_574:) -2)
						(= local18 temp1)
						(= local19 temp2)
					)
				)
			)
		)
		(if local18
			(global243 sel_584: (global243 sel_585:))
			(global243 sel_585: local19)
			(global243 sel_586: local18)
			(return 1)
		else
			(return 0)
		)
	)

	(method (sel_595 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== param2 1)
			(for
				((= temp0 0))
				(<= temp0 (if (== ([global200 param1] sel_574:) 1) 1 else 3))
				((++ temp0))
				
				(= temp1 ([global200 param1] sel_575: temp0))
				(= temp2 ([global200 temp1] sel_575: temp0))
				(if
					(and
						(< ([global200 temp1] sel_574:) 0)
						(== ([global200 temp2] sel_574:) 0)
					)
					(if param3
						(= temp3 ([global200 temp1] sel_574:))
						(= temp4 (param4 sel_588: param1 temp2 temp1 temp3))
						(self sel_592: temp4)
						(self sel_595: temp2 1 1 param4)
					)
					(return 1)
				)
			)
		else
			(for
				((= temp0 3))
				(>= temp0 (if (== ([global200 param1] sel_574:) -1) 2 else 0))
				((-- temp0))
				
				(= temp1 ([global200 param1] sel_575: temp0))
				(= temp2 ([global200 temp1] sel_575: temp0))
				(if
					(and
						(> ([global200 temp1] sel_574:) 0)
						(== ([global200 temp2] sel_574:) 0)
					)
					(if param3
						(= temp3 ([global200 temp1] sel_574:))
						(= temp4 (param4 sel_588: param1 temp2 temp1 temp3))
						(self sel_592: temp4)
						(self sel_595: temp2 -1 1 param4)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (sel_597)
		(if
			(or
				(and (== (global240 sel_584:) 29) (== (global240 sel_585:) 25))
				(and (== (global240 sel_584:) 25) (== (global240 sel_585:) 22))
				(and (== (global240 sel_584:) 24) (== (global240 sel_585:) 19))
				(and (== (global240 sel_584:) 22) (== (global240 sel_585:) 18))
				(and (== (global240 sel_584:) 17) (== (global240 sel_585:) 14))
				(and (== (global240 sel_584:) 17) (== (global240 sel_585:) 13))
			)
			(++ global252)
		)
		(if
			(and
				(> global249 10)
				(or
					(and
						(== (global240 sel_584:) 11)
						(== (global240 sel_585:) 8)
					)
					(and
						(== (global240 sel_584:) 15)
						(== (global240 sel_585:) 10)
					)
					(and
						(== (global240 sel_584:) 11)
						(== (global240 sel_585:) 7)
					)
					(and
						(== (global240 sel_584:) 7)
						(== (global240 sel_585:) 2)
					)
				)
			)
			(++ global252)
		)
		(if
			(and
				(> global249 20)
				(!= ([global200 (global240 sel_584:)] sel_574:) 2)
				(or
					(and
						(== (global240 sel_584:) 27)
						(== (global240 sel_585:) 23)
					)
					(and
						(== (global240 sel_584:) 25)
						(== (global240 sel_585:) 21)
					)
					(and
						(== (global240 sel_584:) 23)
						(== (global240 sel_585:) 18)
					)
					(and
						(== (global240 sel_584:) 22)
						(== (global240 sel_585:) 17)
					)
					(and
						(== (global240 sel_584:) 10)
						(== (global240 sel_585:) 6)
					)
					(and
						(== (global240 sel_584:) 6)
						(== (global240 sel_585:) 2)
					)
					(and
						(== (global240 sel_584:) 8)
						(== (global240 sel_585:) 3)
					)
					(and
						(== (global240 sel_584:) 16)
						(== (global240 sel_585:) 11)
					)
					(and
						(== (global240 sel_584:) 15)
						(== (global240 sel_585:) 11)
					)
					(and
						(== (global240 sel_584:) 12)
						(== (global240 sel_585:) 8)
					)
					(and
						(== (global240 sel_584:) 10)
						(== (global240 sel_585:) 7)
					)
					(and
						(== (global240 sel_584:) 9)
						(== (global240 sel_585:) 6)
					)
					(and
						(== (global240 sel_584:) 8)
						(== (global240 sel_585:) 4)
					)
					(and
						(== (global240 sel_584:) 7)
						(== (global240 sel_585:) 3)
					)
					(and
						(== (global240 sel_584:) 6)
						(== (global240 sel_585:) 1)
					)
					(and
						(== (global240 sel_584:) 5)
						(== (global240 sel_585:) 1)
					)
				)
			)
			(++ global252)
		)
	)
)

(instance copyMove of Code
	(properties
		sel_20 {copyMove}
	)

	(method (sel_57)
		(if
			(and
				(> local1 0)
				(== local9 local6)
				(== local8 local7)
				(== (global240 sel_584:) local6)
				(== (global240 sel_585:) local7)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance root of Tree
	(properties
		sel_20 {root}
	)
)

(instance lev1Lst of Tree
	(properties
		sel_20 {lev1Lst}
	)
)

(instance lev2Lst of Tree
	(properties
		sel_20 {lev2Lst}
	)
)

(instance lev3Lst of Tree
	(properties
		sel_20 {lev3Lst}
	)
)

(instance lev4Lst of Tree
	(properties
		sel_20 {lev4Lst}
	)
)

(instance lev5Lst of Tree
	(properties
		sel_20 {lev5Lst}
	)
)

(instance lev44Lst of Tree
	(properties
		sel_20 {lev44Lst}
	)
)

(instance movLst of List
	(properties
		sel_20 {movLst}
	)
)

(instance chaseCode of Code
	(properties
		sel_20 {chaseCode}
	)

	(method (sel_57 param1)
		(= local14 0)
		(cond
			(
				(and
					(>
						([global200 local13] sel_576:)
						([global200 (param1 sel_584:)] sel_576:)
					)
					(>
						([global200 local13] sel_582:)
						([global200 (param1 sel_584:)] sel_582:)
					)
				)
				(if
					(==
						(param1 sel_585:)
						([global200 (param1 sel_584:)] sel_580:)
					)
					(+= local14 1)
				)
			)
			(
				(and
					(<
						([global200 local13] sel_576:)
						([global200 (param1 sel_584:)] sel_576:)
					)
					(<
						([global200 local13] sel_582:)
						([global200 (param1 sel_584:)] sel_582:)
					)
				)
				(if
					(==
						(param1 sel_585:)
						([global200 (param1 sel_584:)] sel_579:)
					)
					(+= local14 1)
				)
			)
			(
				(and
					(<=
						([global200 local13] sel_576:)
						([global200 (param1 sel_584:)] sel_576:)
					)
					(>=
						([global200 local13] sel_582:)
						([global200 (param1 sel_584:)] sel_582:)
					)
				)
				(if
					(==
						(param1 sel_585:)
						([global200 (param1 sel_584:)] sel_578:)
					)
					(+= local14 1)
				)
			)
			(
				(and
					(>=
						([global200 local13] sel_576:)
						([global200 (param1 sel_584:)] sel_576:)
					)
					(<=
						([global200 local13] sel_582:)
						([global200 (param1 sel_584:)] sel_582:)
					)
					(==
						(param1 sel_585:)
						([global200 (param1 sel_584:)] sel_581:)
					)
				)
				(+= local14 1)
			)
		)
	)
)

(instance kingPath of Code
	(properties
		sel_20 {kingPath}
	)

	(method (sel_57 param1 &tmp temp0 temp1)
		(if (> param1 28)
			(if (== ([global200 param1] sel_574:) 0)
				(return 1)
			else
				(return 0)
			)
		)
		(for ((= temp0 3)) (>= temp0 2) ((-- temp0))
			(if
				(and
					(!= param1 0)
					(or
						(== param1 local20)
						(== ([global200 param1] sel_574:) 0)
					)
					(or
						(and
							(==
								([global200 ([global200 param1] sel_575: 2)]
									sel_574:
								)
								0
							)
							(==
								([global200 ([global200 param1] sel_575: 3)]
									sel_574:
								)
								0
							)
						)
						(and
							(>
								([global200 ([global200 param1] sel_575: 2)]
									sel_574:
								)
								0
							)
							(!=
								([global200 ([global200 param1] sel_575: 1)]
									sel_574:
								)
								0
							)
							(!= ([global200 param1] sel_575: 1) local20)
							(>
								([global200 ([global200 param1] sel_575: 3)]
									sel_574:
								)
								0
							)
							(!=
								([global200 ([global200 param1] sel_575: 0)]
									sel_574:
								)
								0
							)
							(!= ([global200 param1] sel_575: 0) local20)
						)
						(== param1 28)
						(== param1 21)
					)
				)
				(= temp1 ([global200 param1] sel_575: temp0))
				(if (kingPath sel_57: temp1)
					(return 1)
				)
			)
		)
		(return 0)
	)
)

