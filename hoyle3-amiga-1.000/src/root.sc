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
	(Print @temp0 #at 10 180)
)

(class Tree of List
	(properties
		fromSqr 0
		toSqr 0
		capSqr 0
		capChkr 0
		value -1000
	)

	(method (newNode param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp0 (Tree new:))
		(temp0 add:)
		(temp0 fromSqr: param1 toSqr: param2 capSqr: param3 capChkr: param4)
		(++ global256)
		(self add: temp0)
		(return temp0)
	)

	(method (alphaBeta &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
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
		(if (and (<= global249 1) (!= ((ScriptID 200 6) skill:) 0)) ; player1
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
			((ScriptID 201 0) doit:) ; book
			(self compuMove:)
			(return 1)
		)
		(root generate: 1)
		(= local0 0)
		(= global243 (root at: 0))
		(if (== (root size:) 0)
			(return 0)
		)
		(root eachElementDo: #value 1000)
		(for ((= temp1 0)) (< temp1 (root size:)) ((++ temp1))
			(= global240 (root at: temp1))
			(if (!= ((ScriptID 200 6) skill:) 0) ; player1
				(if local10
					((ScriptID 203 0) doit:) ; endGame1
				)
				(if local11
					((ScriptID 203 3) doit:) ; endGame4
				)
			)
			(if local12
				(chaseCode doit: global240)
			)
			(if (== ((ScriptID 200 6) skill:) 0) ; player1
				(= global242 1)
			)
			(self changeBoard: global240)
			(if (global240 capSqr:)
				(self multiJmp: (global240 toSqr:) 1 1 lev1Lst)
			)
			(global240 generate: -1)
			(global240 eachElementDo: #value -1000)
			(= global242 0)
			(if (!= ((ScriptID 200 6) skill:) 0) ; player1
				(for ((= temp2 0)) (< temp2 (global240 size:)) ((++ temp2))
					(= global241 (global240 at: temp2))
					(self changeBoard: global241)
					(if (global241 capSqr:)
						(self multiJmp: (global241 toSqr:) -1 1 lev2Lst)
					)
					(global241 generate: 1)
					(global241 eachElementDo: #value 1000)
					(for ((= temp3 0)) (< temp3 (global241 size:)) ((++ temp3))
						(proc0_6)
						(= global255 (global241 at: temp3))
						(if
							(or
								(== ((ScriptID 200 6) skill:) 1) ; player1
								(and
									(or
										(not (global241 capSqr:))
										(not (global255 capSqr:))
									)
									(> local17 8)
								)
							)
							(= global242 1)
						)
						(self changeBoard: global255)
						(if (global255 capSqr:)
							(self multiJmp: (global255 toSqr:) 1 1 lev3Lst)
						)
						(global255 generate: -1)
						(if
							(and
								(== ((ScriptID 200 6) skill:) 2) ; player1
								(or
									(<= local17 8)
									(and
										(global255 capSqr:)
										(global241 capSqr:)
									)
								)
							)
							(global255 eachElementDo: #value -1000)
							(for
								((= temp5 0))
								(< temp5 (global255 size:))
								((++ temp5))
								
								(proc0_6)
								(= global257 (global255 at: temp5))
								(self changeBoard: global257)
								(if (global257 capSqr:)
									(self
										multiJmp:
											(global257 toSqr:)
											-1
											1
											lev44Lst
									)
								)
								(global257 generate: 1)
								(global257 eachElementDo: #value 1000)
								(for
									((= temp6 0))
									(< temp6 (global257 size:))
									((++ temp6))
									
									(= global258 (global257 at: temp6))
									(= global242 1)
									(self changeBoard: global258)
									(if (global258 capSqr:)
										(self
											multiJmp:
												(global258 toSqr:)
												1
												1
												lev5Lst
										)
									)
									(global258 generate: -1)
									(= global242 0)
									(if
										(>
											(global258 value:)
											(global257 value:)
										)
										(global257 value: (global258 value:))
									)
									(if (lev5Lst isEmpty:)
										(self changeBack: global258)
									else
										(for
											((= temp4 (- (lev5Lst size:) 1)))
											(>= temp4 0)
											((-- temp4))
											
											(self
												changeBack: (lev5Lst at: temp4)
											)
										)
										(self changeBack: global258)
										(lev5Lst freeNodes: lev5Lst)
										(lev5Lst release:)
									)
									(if
										(>=
											(global257 value:)
											(global255 value:)
										)
										(break)
									)
								)
								(if (< (global257 value:) (global255 value:))
									(global255 value: (global257 value:))
								)
								(if (lev44Lst isEmpty:)
									(self changeBack: global257)
								else
									(for
										((= temp4 (- (lev44Lst size:) 1)))
										(>= temp4 0)
										((-- temp4))
										
										(self changeBack: (lev44Lst at: temp4))
									)
									(self changeBack: global257)
									(lev44Lst freeNodes: lev44Lst)
									(lev44Lst release:)
								)
								(self freeNodes: global257)
								(if (<= (global255 value:) (global241 value:))
									(break)
								)
							)
						)
						(= global242 0)
						(if (> (global255 value:) (global241 value:))
							(global241 value: (global255 value:))
						)
						(if (lev3Lst isEmpty:)
							(self changeBack: global255)
						else
							(for
								((= temp4 (- (lev3Lst size:) 1)))
								(>= temp4 0)
								((-- temp4))
								
								(self changeBack: (lev3Lst at: temp4))
							)
							(self changeBack: global255)
							(lev3Lst freeNodes: lev3Lst)
							(lev3Lst release:)
						)
						(self freeNodes: global255)
						(if (>= (global241 value:) (global240 value:))
							(break)
						)
					)
					(if (< (global241 value:) (global240 value:))
						(global240 value: (global241 value:))
					)
					(if (lev2Lst isEmpty:)
						(self changeBack: global241)
					else
						(for
							((= temp4 (- (lev2Lst size:) 1)))
							(>= temp4 0)
							((-- temp4))
							
							(self changeBack: (lev2Lst at: temp4))
						)
						(self changeBack: global241)
						(lev2Lst freeNodes: lev2Lst)
						(lev2Lst release:)
					)
					(self freeNodes: global241)
				)
			)
			(if (lev1Lst isEmpty:)
				(self changeBack: global240)
			else
				(for ((= temp4 (- (lev1Lst size:) 1))) (>= temp4 0) ((-- temp4))
					(self changeBack: (lev1Lst at: temp4))
				)
				(self changeBack: global240)
				(lev1Lst freeNodes: lev1Lst)
				(lev1Lst release:)
			)
			(cond
				((or (<= global249 18) (<= local2 3))
					(if
						(and
							(== (global240 value:) (global243 value:))
							(not (copyMove doit:))
						)
						(movLst add: global240)
					)
					(if
						(and
							(> (global240 value:) (global243 value:))
							(not (copyMove doit:))
						)
						(= global243 global240)
						(movLst release:)
						(movLst add: global243)
					)
				)
				((or (not global268) (< global249 15))
					(if (> (global240 value:) (global243 value:))
						(= global243 global240)
					)
				)
				((== (global240 value:) (global243 value:))
					(if
						(and
							(not (copyMove doit:))
							(!= ([global200 (global243 fromSqr:)] checker:) 1)
							(!= ([global200 (global240 fromSqr:)] checker:) 2)
						)
						(= global243 global240)
					)
				)
				(
					(and
						(not (copyMove doit:))
						(> (global240 value:) (global243 value:))
					)
					(= global243 global240)
				)
			)
			(self freeNodes: global240)
		)
		(if (or (<= global249 18) (<= local2 3))
			(= temp0 (Random 0 (- (movLst size:) 1)))
			(= global243 (movLst at: temp0))
			(movLst release: dispose:)
		)
		(if (!= ((ScriptID 200 6) skill:) 0) ; player1
			(if (<= global249 1)
				((ScriptID 201 0) doit:) ; book
			)
			(if (<= global249 3)
				(if (not (global243 capSqr:))
					((ScriptID 201 0) doit:) ; book
				else
					(= global267 1)
				)
			)
			(if (and (not (global243 capSqr:)) (<= global249 5) (not global267))
				((ScriptID 201 0) doit:) ; book
			)
		)
		(if global268
			(= local8 local6)
			(= local9 local7)
			(= local6 (global243 toSqr:))
			(= local7 (global243 fromSqr:))
		)
		(if
			(and
				global264
				global265
				(or local10 local11)
				(not (global243 capSqr:))
			)
			(global243 fromSqr: global264)
			(global243 toSqr: global265)
			(global243 capSqr: 0)
		)
		(self compuMove:)
		(return 1)
	)

	(method (cue)
		(if (== global266 250)
			(gSound play: 208)
			(global253 cel: 0 loop: 2)
			(proc0_1)
			(global253 setCycle: 0)
		else
			(gSound play: 200)
		)
		(if (and (< (global243 toSqr:) 5) (not global245))
			(if (!= (global253 type:) 2)
				(= global273 1)
			)
			(if (== global269 1)
				(= global269 2)
			)
			(if (== global266 200)
				(global253 type: 2 cel: 3 hiCel: 2)
			else
				(global253 type: 2)
				(cond
					((== (global253 view:) 250)
						(global253 view: 251)
					)
					((== (global253 view:) 252)
						(global253 view: 253)
					)
				)
			)
		)
		((gCurRoom script:) cue:)
	)

	(method (compuMove &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= global246 0)
		(= global245 0)
		(= temp0 ((ScriptID 200 1) firstTrue: #findPiece (global243 fromSqr:))) ; pieces
		(temp0 sqrNum: (global243 toSqr:))
		(= temp2 (global243 toSqr:))
		(if (< (global243 toSqr:) 5)
			(if (== (temp0 type:) 1)
				(= temp1 1)
			)
			([global200 (global243 toSqr:)] checker: 2)
		else
			([global200 (global243 toSqr:)]
				checker: ([global200 (global243 fromSqr:)] checker:)
			)
		)
		([global200 (global243 fromSqr:)] checker: 0)
		(if (global243 capSqr:)
			(= global246 1)
			([global200 (global243 capSqr:)] checker: 0)
			(= global250
				((ScriptID 200 1) firstTrue: #findPiece (global243 capSqr:)) ; pieces
			)
			(if (not temp1)
				(= global245 (self moreJmps:))
			else
				(= global245 0)
			)
		)
		(= global253 temp0)
		(if (== global266 200)
			(temp0
				setPri: 15
				setMotion:
					MoveTo
					(+ ([global200 temp2] nsLeft:) 14)
					(+ ([global200 temp2] nsTop:) 12)
					self
			)
		else
			(temp0
				setPri: 15
				setMotion:
					MoveToEndLoop
					(+ ([global200 temp2] nsLeft:) 14)
					(+ ([global200 temp2] nsTop:) 12)
					self
			)
		)
	)

	(method (changeBoard param1)
		([global200 (param1 toSqr:)]
			checker: ([global200 (param1 fromSqr:)] checker:)
		)
		([global200 (param1 fromSqr:)] checker: 0)
		(if (param1 capSqr:)
			([global200 (param1 capSqr:)] checker: 0)
		)
	)

	(method (changeBack param1)
		([global200 (param1 fromSqr:)]
			checker: ([global200 (param1 toSqr:)] checker:)
		)
		([global200 (param1 toSqr:)] checker: 0)
		(if (param1 capSqr:)
			([global200 (param1 capSqr:)] checker: (param1 capChkr:))
		)
	)

	(method (freeNodes param1 &tmp temp0 temp1)
		(for ((= temp0 (- (param1 size:) 1))) (>= temp0 0) ((-- temp0))
			(= temp1 (param1 at: temp0))
			(if (temp1 isEmpty:)
				(param1 delete: temp1)
				(-- global256)
				(temp1 dispose:)
			)
		)
	)

	(method (generate param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 2])
		(if (and (not local16) (> (- (GetTime) global247) 200))
			(= local16 1)
		)
		(if local16
			(if (HaveMouse)
				(gGame setCursor: (+ 100 local15))
			else
				(gGame setCursor: (+ 100 local15) 1 305 185)
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
					(switch ([global200 temp2] checker:)
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
										(== ([global200 14] checker:) 2)
										(== ([global200 1] checker:) 2)
									)
									(and
										(== temp2 7)
										(== ([global200 18] checker:) 2)
										(== ([global200 1] checker:) 2)
									)
									(and
										(== temp2 13)
										(== ([global200 10] checker:) 2)
										(== ([global200 5] checker:) 2)
									)
									(and
										(== temp2 17)
										(== ([global200 15] checker:) 2)
										(== ([global200 5] checker:) 2)
									)
									(and
										(== temp2 20)
										(== ([global200 23] checker:) 2)
										(== ([global200 28] checker:) 2)
									)
									(and
										(== temp2 16)
										(== ([global200 28] checker:) 2)
										(== ([global200 18] checker:) 2)
									)
									(and
										(== temp2 31)
										(== ([global200 19] checker:) 2)
										(== ([global200 32] checker:) 2)
									)
									(and
										(== temp2 26)
										(== ([global200 15] checker:) 2)
										(== ([global200 32] checker:) 2)
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
				(if (> ([global200 temp2] checker:) 0)
					(for
						((= temp3 0))
						(<=
							temp3
							(if (== ([global200 temp2] checker:) 1) 1 else 3)
						)
						((++ temp3))
						
						(= temp0 ([global200 temp2] sqrOn: temp3))
						(= temp1 ([global200 temp0] sqrOn: temp3))
						(if
							(and
								(< ([global200 temp0] checker:) 0)
								(== ([global200 temp1] checker:) 0)
							)
							(= temp5 ([global200 temp0] checker:))
							(= temp4 1)
							(if (not global242)
								(self newNode: temp2 temp1 temp0 temp5)
							else
								(self shortEval: temp2 temp0 temp1 param1)
								(if (> global252 (global241 value:))
									(global241 value: global252)
									(if
										(>=
											(global241 value:)
											(global240 value:)
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
					((ScriptID 203 1) doit:) ; endGame2
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
					((ScriptID 203 2) doit:) ; endGame3
				)
				((and (> local3 0) (> local5 0))
					(= local12 1)
				)
			)
			(if (not temp4)
				(= temp1 0)
				(for ((= temp2 1)) (< temp2 33) ((++ temp2))
					(if (> ([global200 temp2] checker:) 0)
						(for
							((= temp3 0))
							(<=
								temp3
								(if (== ([global200 temp2] checker:) 1)
									1
								else
									3
								)
							)
							((++ temp3))
							
							(= temp0 ([global200 temp2] sqrOn: temp3))
							(if (== ([global200 temp0] checker:) 0)
								(if (not global242)
									(self newNode: temp2 temp0 0 0)
								else
									(self shortEval: temp2 temp0 0 param1)
									(if (> global252 (global241 value:))
										(global241 value: global252)
										(if
											(>=
												(global241 value:)
												(global240 value:)
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
				(if (< ([global200 temp2] checker:) 0)
					(for
						((= temp3 3))
						(>=
							temp3
							(if (== ([global200 temp2] checker:) -1) 2 else 0)
						)
						((-- temp3))
						
						(= temp0 ([global200 temp2] sqrOn: temp3))
						(= temp1 ([global200 temp0] sqrOn: temp3))
						(if
							(and
								(> ([global200 temp0] checker:) 0)
								(== ([global200 temp1] checker:) 0)
							)
							(= temp5 ([global200 temp0] checker:))
							(= temp4 1)
							(if (not global242)
								(= temp6
									(self newNode: temp2 temp1 temp0 temp5)
								)
							else
								(self shortEval: temp2 temp0 temp1 param1)
								(cond
									(
										(and
											(== ((ScriptID 200 6) skill:) 2) ; player1
											(or
												(<= local17 8)
												(and
													(global241 capSqr:)
													(global255 capSqr:)
												)
											)
										)
										(if (< global252 (global258 value:))
											(global258 value: global252)
											(if
												(<=
													(global258 value:)
													(global257 value:)
												)
												(return)
											)
										)
									)
									((!= ((ScriptID 200 6) skill:) 0) ; player1
										(if (< global252 (global255 value:))
											(global255 value: global252)
											(if
												(<=
													(global255 value:)
													(global241 value:)
												)
												(return)
											)
										)
									)
									((< global252 (global240 value:))
										(global240 value: global252)
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
					(if (< ([global200 temp2] checker:) 0)
						(for
							((= temp3 3))
							(>=
								temp3
								(if (== ([global200 temp2] checker:) -1)
									2
								else
									0
								)
							)
							((-- temp3))
							
							(= temp0 ([global200 temp2] sqrOn: temp3))
							(if (== ([global200 temp0] checker:) 0)
								(if (not global242)
									(self newNode: temp2 temp0 0 0)
								else
									(self shortEval: temp2 temp0 0 param1)
									(cond
										(
											(and
												(== ((ScriptID 200 6) skill:) 2) ; player1
												(or
													(<= local17 8)
													(and
														(global241 capSqr:)
														(global255 capSqr:)
													)
												)
											)
											(if (< global252 (global258 value:))
												(global258 value: global252)
												(if
													(<=
														(global258 value:)
														(global257 value:)
													)
													(return)
												)
											)
										)
										((!= ((ScriptID 200 6) skill:) 0) ; player1
											(if (< global252 (global255 value:))
												(global255 value: global252)
												(if
													(<=
														(global255 value:)
														(global241 value:)
													)
													(return)
												)
											)
										)
										((< global252 (global240 value:))
											(global240 value: global252)
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

	(method (shortEval param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(if (== param3 0)
			([global200 param2] checker: ([global200 param1] checker:))
		else
			([global200 param3] checker: ([global200 param1] checker:))
			(= temp2 ([global200 param2] checker:))
			([global200 param2] checker: 0)
			(self multiJmp: param3 -1 1 lev4Lst)
		)
		([global200 param1] checker: 0)
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
				(!= ((ScriptID 200 6) skill:) 0) ; player1
				(not (global240 capSqr:))
				(global241 capSqr:)
				(not (global255 capSqr:))
			)
			(-= global252 200)
		)
		(for ((= temp1 1)) (<= temp1 32) ((++ temp1))
			(switch ([global200 temp1] checker:)
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
							(== ([global200 temp1] sqrOn: 1) 1)
							(==
								([global200 ([global200 temp1] sqrOn: 1)]
									sqrOn: 1
								)
								1
							)
						)
						(++ global252)
					)
					(if
						(and
							(== ([global200 temp1] sqrOn: 0) 1)
							(==
								([global200 ([global200 temp1] sqrOn: 0)]
									sqrOn: 0
								)
								1
							)
						)
						(++ global252)
					)
					(if (== ((ScriptID 200 6) skill:) 2) ; player1
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
									(== ([global200 17] checker:) -1)
									(== ([global200 18] checker:) -1)
									(== ([global200 21] checker:) -1)
									(== ([global200 22] checker:) -1)
								)
								(++ global252)
							)
						)
						(if (== temp1 32)
							(+= global252 3)
							(if
								(or
									(== ([global200 19] checker:) -1)
									(== ([global200 20] checker:) -1)
									(== ([global200 23] checker:) -1)
									(== ([global200 24] checker:) -1)
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
								(== ((ScriptID 200 3) sqrNum:) 29) ; R29
								(== (global240 fromSqr:) 29)
								(== (global240 toSqr:) 25)
							)
							(+= global252 3)
						)
						(if
							(and
								(== ((ScriptID 200 4) sqrNum:) 25) ; R25
								(== (global240 fromSqr:) 25)
								(== (global240 toSqr:) 22)
							)
							(+= global252 3)
						)
						(if
							(and
								(== ((ScriptID 200 5) sqrNum:) 22) ; R22
								(== (global240 fromSqr:) 22)
								(== (global240 toSqr:) 18)
							)
							(+= global252 3)
						)
						(if (== ([global200 temp1] sqrOn: 0) 0)
							(++ global252)
						)
						(if (== ([global200 temp1] sqrOn: 1) 0)
							(++ global252)
						)
						(if (== ([global200 temp1] sqrOn: 2) 1)
							(+= global252 2)
						)
						(if (== ([global200 temp1] sqrOn: 3) 1)
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
							([global200 ([global200 temp1] sqrOn: 2)] checker:)
							-1
						)
						(++ global252)
					)
					(if
						(==
							([global200 ([global200 temp1] sqrOn: 3)] checker:)
							-1
						)
						(++ global252)
					)
					(if (== ((ScriptID 200 6) skill:) 2) ; player1
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
							(kingPath doit: temp1)
						)
						(-= global252 15)
					)
					(if (> temp1 28)
						(-= global252 60)
					else
						(-= global252 40)
					)
					(if (== ((ScriptID 200 6) skill:) 2) ; player1
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
					(if (== ((ScriptID 200 6) skill:) 2) ; player1
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
		(if (== ((ScriptID 200 6) skill:) 2) ; player1
			(if
				(and
					(< global249 10)
					(or
						(== (global240 fromSqr:) 26)
						(== (global240 fromSqr:) 27)
					)
					(global240 capSqr:)
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
					(global241 capSqr:)
					(>= temp7 (+ temp8 3))
					(global255 capSqr:)
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
						(== ([global200 26] checker:) 1)
						(== ([global200 7] checker:) 1)
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
			(self problity:)
		)
		(cond
			((== param3 0)
				([global200 param1] checker: ([global200 param2] checker:))
				([global200 param2] checker: 0)
			)
			((lev4Lst isEmpty:)
				([global200 param1] checker: ([global200 param3] checker:))
				([global200 param2] checker: temp2)
				([global200 param3] checker: 0)
			)
			(else
				(for
					((= temp13 (- (lev4Lst size:) 1)))
					(>= temp13 0)
					((-- temp13))
					
					(self changeBack: (lev4Lst at: temp13))
				)
				([global200 param1] checker: ([global200 param3] checker:))
				([global200 param2] checker: temp2)
				([global200 param3] checker: 0)
				(lev4Lst freeNodes: lev4Lst)
				(lev4Lst release:)
			)
		)
	)

	(method (moreJmps &tmp temp0 temp1 temp2)
		(= local18 0)
		(= local19 0)
		(for
			((= temp0 0))
			(<=
				temp0
				(if (== ([global200 (global243 toSqr:)] checker:) 1) 1 else 3)
			)
			((++ temp0))
			
			(= temp1 ([global200 (global243 toSqr:)] sqrOn: temp0))
			(= temp2 ([global200 temp1] sqrOn: temp0))
			(if
				(and
					(< ([global200 temp1] checker:) 0)
					(== ([global200 temp2] checker:) 0)
				)
				(cond
					((== local18 0)
						(= local18 temp1)
						(= local19 temp2)
					)
					((self multiJmp: temp2 1 0)
						(= local18 temp1)
						(= local19 temp2)
					)
					((== ([global200 temp1] checker:) -2)
						(= local18 temp1)
						(= local19 temp2)
					)
				)
			)
		)
		(if local18
			(global243 fromSqr: (global243 toSqr:))
			(global243 toSqr: local19)
			(global243 capSqr: local18)
			(return 1)
		else
			(return 0)
		)
	)

	(method (multiJmp param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== param2 1)
			(for
				((= temp0 0))
				(<= temp0 (if (== ([global200 param1] checker:) 1) 1 else 3))
				((++ temp0))
				
				(= temp1 ([global200 param1] sqrOn: temp0))
				(= temp2 ([global200 temp1] sqrOn: temp0))
				(if
					(and
						(< ([global200 temp1] checker:) 0)
						(== ([global200 temp2] checker:) 0)
					)
					(if param3
						(= temp3 ([global200 temp1] checker:))
						(= temp4 (param4 newNode: param1 temp2 temp1 temp3))
						(self changeBoard: temp4)
						(self multiJmp: temp2 1 1 param4)
					)
					(return 1)
				)
			)
		else
			(for
				((= temp0 3))
				(>= temp0 (if (== ([global200 param1] checker:) -1) 2 else 0))
				((-- temp0))
				
				(= temp1 ([global200 param1] sqrOn: temp0))
				(= temp2 ([global200 temp1] sqrOn: temp0))
				(if
					(and
						(> ([global200 temp1] checker:) 0)
						(== ([global200 temp2] checker:) 0)
					)
					(if param3
						(= temp3 ([global200 temp1] checker:))
						(= temp4 (param4 newNode: param1 temp2 temp1 temp3))
						(self changeBoard: temp4)
						(self multiJmp: temp2 -1 1 param4)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (problity)
		(if
			(or
				(and (== (global240 fromSqr:) 29) (== (global240 toSqr:) 25))
				(and (== (global240 fromSqr:) 25) (== (global240 toSqr:) 22))
				(and (== (global240 fromSqr:) 24) (== (global240 toSqr:) 19))
				(and (== (global240 fromSqr:) 22) (== (global240 toSqr:) 18))
				(and (== (global240 fromSqr:) 17) (== (global240 toSqr:) 14))
				(and (== (global240 fromSqr:) 17) (== (global240 toSqr:) 13))
			)
			(++ global252)
		)
		(if
			(and
				(> global249 10)
				(or
					(and (== (global240 fromSqr:) 11) (== (global240 toSqr:) 8))
					(and
						(== (global240 fromSqr:) 15)
						(== (global240 toSqr:) 10)
					)
					(and (== (global240 fromSqr:) 11) (== (global240 toSqr:) 7))
					(and (== (global240 fromSqr:) 7) (== (global240 toSqr:) 2))
				)
			)
			(++ global252)
		)
		(if
			(and
				(> global249 20)
				(!= ([global200 (global240 fromSqr:)] checker:) 2)
				(or
					(and
						(== (global240 fromSqr:) 27)
						(== (global240 toSqr:) 23)
					)
					(and
						(== (global240 fromSqr:) 25)
						(== (global240 toSqr:) 21)
					)
					(and
						(== (global240 fromSqr:) 23)
						(== (global240 toSqr:) 18)
					)
					(and
						(== (global240 fromSqr:) 22)
						(== (global240 toSqr:) 17)
					)
					(and (== (global240 fromSqr:) 10) (== (global240 toSqr:) 6))
					(and (== (global240 fromSqr:) 6) (== (global240 toSqr:) 2))
					(and (== (global240 fromSqr:) 8) (== (global240 toSqr:) 3))
					(and
						(== (global240 fromSqr:) 16)
						(== (global240 toSqr:) 11)
					)
					(and
						(== (global240 fromSqr:) 15)
						(== (global240 toSqr:) 11)
					)
					(and (== (global240 fromSqr:) 12) (== (global240 toSqr:) 8))
					(and (== (global240 fromSqr:) 10) (== (global240 toSqr:) 7))
					(and (== (global240 fromSqr:) 9) (== (global240 toSqr:) 6))
					(and (== (global240 fromSqr:) 8) (== (global240 toSqr:) 4))
					(and (== (global240 fromSqr:) 7) (== (global240 toSqr:) 3))
					(and (== (global240 fromSqr:) 6) (== (global240 toSqr:) 1))
					(and (== (global240 fromSqr:) 5) (== (global240 toSqr:) 1))
				)
			)
			(++ global252)
		)
	)
)

(instance copyMove of Code
	(properties)

	(method (doit)
		(if
			(and
				(> local1 0)
				(== local9 local6)
				(== local8 local7)
				(== (global240 fromSqr:) local6)
				(== (global240 toSqr:) local7)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance root of Tree
	(properties)
)

(instance lev1Lst of Tree
	(properties)
)

(instance lev2Lst of Tree
	(properties)
)

(instance lev3Lst of Tree
	(properties)
)

(instance lev4Lst of Tree
	(properties)
)

(instance lev5Lst of Tree
	(properties)
)

(instance lev44Lst of Tree
	(properties)
)

(instance movLst of List
	(properties)
)

(instance chaseCode of Code
	(properties)

	(method (doit param1)
		(= local14 0)
		(cond
			(
				(and
					(>
						([global200 local13] row:)
						([global200 (param1 fromSqr:)] row:)
					)
					(>
						([global200 local13] col:)
						([global200 (param1 fromSqr:)] col:)
					)
				)
				(if
					(==
						(param1 toSqr:)
						([global200 (param1 fromSqr:)] bacLeft:)
					)
					(+= local14 1)
				)
			)
			(
				(and
					(<
						([global200 local13] row:)
						([global200 (param1 fromSqr:)] row:)
					)
					(<
						([global200 local13] col:)
						([global200 (param1 fromSqr:)] col:)
					)
				)
				(if
					(==
						(param1 toSqr:)
						([global200 (param1 fromSqr:)] fwdRight:)
					)
					(+= local14 1)
				)
			)
			(
				(and
					(<=
						([global200 local13] row:)
						([global200 (param1 fromSqr:)] row:)
					)
					(>=
						([global200 local13] col:)
						([global200 (param1 fromSqr:)] col:)
					)
				)
				(if
					(==
						(param1 toSqr:)
						([global200 (param1 fromSqr:)] fwdLeft:)
					)
					(+= local14 1)
				)
			)
			(
				(and
					(>=
						([global200 local13] row:)
						([global200 (param1 fromSqr:)] row:)
					)
					(<=
						([global200 local13] col:)
						([global200 (param1 fromSqr:)] col:)
					)
					(==
						(param1 toSqr:)
						([global200 (param1 fromSqr:)] bacRight:)
					)
				)
				(+= local14 1)
			)
		)
	)
)

(instance kingPath of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(if (> param1 28)
			(if (== ([global200 param1] checker:) 0)
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
						(== ([global200 param1] checker:) 0)
					)
					(or
						(and
							(==
								([global200 ([global200 param1] sqrOn: 2)]
									checker:
								)
								0
							)
							(==
								([global200 ([global200 param1] sqrOn: 3)]
									checker:
								)
								0
							)
						)
						(and
							(>
								([global200 ([global200 param1] sqrOn: 2)]
									checker:
								)
								0
							)
							(!=
								([global200 ([global200 param1] sqrOn: 1)]
									checker:
								)
								0
							)
							(!= ([global200 param1] sqrOn: 1) local20)
							(>
								([global200 ([global200 param1] sqrOn: 3)]
									checker:
								)
								0
							)
							(!=
								([global200 ([global200 param1] sqrOn: 0)]
									checker:
								)
								0
							)
							(!= ([global200 param1] sqrOn: 0) local20)
						)
						(== param1 28)
						(== param1 21)
					)
				)
				(= temp1 ([global200 param1] sqrOn: temp0))
				(if (kingPath doit: temp1)
					(return 1)
				)
			)
		)
		(return 0)
	)
)

