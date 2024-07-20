;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1202)
(include sci.sh)
(use Main)
(use MoveToEndLoop)
(use Print)
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

(procedure (localproc_0 &tmp temp0 [temp1 499]) ; UNUSED
	(temp0 format: &rest) ; UNINIT
	(Print temp0: 75 10 180)
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
		(++ global822)
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
		(= global830 0)
		(= global831 0)
		(= local11 0)
		(= local12 0)
		(= local13 0)
		(= local0 1)
		(= local1 0)
		(= local2 0)
		(= local3 0)
		(= local4 0)
		(= local5 0)
		(if (and (<= global815 1) (!= ((ScriptID 1200 6) skill:) 0)) ; player1
			((ScriptID 1201 0) doit:) ; book
			(self compuMove:)
			(return 1)
		)
		(root generate: 1)
		(= local0 0)
		(= global809 (root at: 0))
		(if (== (root size:) 0)
			(return 0)
		)
		(root eachElementDo: #value 1000)
		(for ((= temp1 0)) (< temp1 (root size:)) ((++ temp1))
			(= global806 (root at: temp1))
			(if (!= ((ScriptID 1200 6) skill:) 0) ; player1
				(if local10
					((ScriptID 1203 0) doit:) ; endGame1
				)
				(if local11
					((ScriptID 1203 3) doit:) ; endGame4
				)
			)
			(if local12
				(chaseCode doit: global806)
			)
			(if (== ((ScriptID 1200 6) skill:) 0) ; player1
				(= global808 1)
			)
			(self changeBoard: global806)
			(if (global806 capSqr:)
				(self multiJmp: (global806 toSqr:) 1 1 lev1Lst)
			)
			(global806 generate: -1)
			(if (and global806 (global806 size:))
				(global806 eachElementDo: #value -1000)
			)
			(= global808 0)
			(if (!= ((ScriptID 1200 6) skill:) 0) ; player1
				(for ((= temp2 0)) (< temp2 (global806 size:)) ((++ temp2))
					(= global807 (global806 at: temp2))
					(self changeBoard: global807)
					(if (global807 capSqr:)
						(self multiJmp: (global807 toSqr:) -1 1 lev2Lst)
					)
					(global807 generate: 1)
					(if (and global807 (global807 size:))
						(global807 eachElementDo: #value 1000)
					)
					(for ((= temp3 0)) (< temp3 (global807 size:)) ((++ temp3))
						(proc0_6)
						(= global821 (global807 at: temp3))
						(if
							(or
								(== ((ScriptID 1200 6) skill:) 1) ; player1
								(and
									(or
										(not (global807 capSqr:))
										(not (global821 capSqr:))
									)
									(> local17 8)
								)
							)
							(= global808 1)
						)
						(self changeBoard: global821)
						(if (global821 capSqr:)
							(self multiJmp: (global821 toSqr:) 1 1 lev3Lst)
						)
						(global821 generate: -1)
						(if
							(and
								(== ((ScriptID 1200 6) skill:) 2) ; player1
								(or
									(<= local17 8)
									(and
										(global821 capSqr:)
										(global807 capSqr:)
									)
								)
							)
							(if (and global821 (global821 size:))
								(global821 eachElementDo: #value -1000)
							)
							(for
								((= temp5 0))
								(< temp5 (global821 size:))
								((++ temp5))
								
								(proc0_6)
								(= global823 (global821 at: temp5))
								(self changeBoard: global823)
								(if (global823 capSqr:)
									(self
										multiJmp:
											(global823 toSqr:)
											-1
											1
											lev44Lst
									)
								)
								(global823 generate: 1)
								(if (and global823 (global823 size:))
									(global823 eachElementDo: #value 1000)
								)
								(for
									((= temp6 0))
									(< temp6 (global823 size:))
									((++ temp6))
									
									(= global824 (global823 at: temp6))
									(= global808 1)
									(self changeBoard: global824)
									(if (global824 capSqr:)
										(self
											multiJmp:
												(global824 toSqr:)
												1
												1
												lev5Lst
										)
									)
									(global824 generate: -1)
									(= global808 0)
									(if
										(>
											(global824 value:)
											(global823 value:)
										)
										(global823 value: (global824 value:))
									)
									(if (lev5Lst isEmpty:)
										(self changeBack: global824)
									else
										(for
											((= temp4 (- (lev5Lst size:) 1)))
											(>= temp4 0)
											((-- temp4))
											
											(self
												changeBack: (lev5Lst at: temp4)
											)
										)
										(self changeBack: global824)
										(lev5Lst freeNodes: lev5Lst)
										(lev5Lst release:)
									)
									(if
										(>=
											(global823 value:)
											(global821 value:)
										)
										(break)
									)
								)
								(if (< (global823 value:) (global821 value:))
									(global821 value: (global823 value:))
								)
								(if (lev44Lst isEmpty:)
									(self changeBack: global823)
								else
									(for
										((= temp4 (- (lev44Lst size:) 1)))
										(>= temp4 0)
										((-- temp4))
										
										(self changeBack: (lev44Lst at: temp4))
									)
									(self changeBack: global823)
									(lev44Lst freeNodes: lev44Lst)
									(lev44Lst release:)
								)
								(self freeNodes: global823)
								(if (<= (global821 value:) (global807 value:))
									(break)
								)
							)
						)
						(= global808 0)
						(if (> (global821 value:) (global807 value:))
							(global807 value: (global821 value:))
						)
						(if (lev3Lst isEmpty:)
							(self changeBack: global821)
						else
							(for
								((= temp4 (- (lev3Lst size:) 1)))
								(>= temp4 0)
								((-- temp4))
								
								(self changeBack: (lev3Lst at: temp4))
							)
							(self changeBack: global821)
							(lev3Lst freeNodes: lev3Lst)
							(lev3Lst release:)
						)
						(self freeNodes: global821)
						(if (>= (global807 value:) (global806 value:))
							(break)
						)
					)
					(if (< (global807 value:) (global806 value:))
						(global806 value: (global807 value:))
					)
					(if (lev2Lst isEmpty:)
						(self changeBack: global807)
					else
						(for
							((= temp4 (- (lev2Lst size:) 1)))
							(>= temp4 0)
							((-- temp4))
							
							(self changeBack: (lev2Lst at: temp4))
						)
						(self changeBack: global807)
						(lev2Lst freeNodes: lev2Lst)
						(lev2Lst release:)
					)
					(self freeNodes: global807)
				)
			)
			(if (lev1Lst isEmpty:)
				(self changeBack: global806)
			else
				(for ((= temp4 (- (lev1Lst size:) 1))) (>= temp4 0) ((-- temp4))
					(self changeBack: (lev1Lst at: temp4))
				)
				(self changeBack: global806)
				(lev1Lst freeNodes: lev1Lst)
				(lev1Lst release:)
			)
			(cond
				((or (<= global815 18) (<= local2 3))
					(if
						(and
							(== (global806 value:) (global809 value:))
							(not (copyMove doit:))
						)
						(movLst add: global806)
					)
					(if
						(and
							(> (global806 value:) (global809 value:))
							(not (copyMove doit:))
						)
						(= global809 global806)
						(movLst release:)
						(movLst add: global809)
					)
				)
				((or (not global834) (< global815 15))
					(if (> (global806 value:) (global809 value:))
						(= global809 global806)
					)
				)
				((== (global806 value:) (global809 value:))
					(if
						(and
							(not (copyMove doit:))
							(!= ([global841 (global809 fromSqr:)] checker:) 1)
							(!= ([global841 (global806 fromSqr:)] checker:) 2)
						)
						(= global809 global806)
					)
				)
				(
					(and
						(not (copyMove doit:))
						(> (global806 value:) (global809 value:))
					)
					(= global809 global806)
				)
			)
			(self freeNodes: global806)
		)
		(if (or (<= global815 18) (<= local2 3))
			(= temp0 (Random 0 (- (movLst size:) 1)))
			(= global809 (movLst at: temp0))
			(movLst release:)
		)
		(if (!= ((ScriptID 1200 6) skill:) 0) ; player1
			(if (<= global815 1)
				((ScriptID 1201 0) doit:) ; book
			)
			(if (<= global815 3)
				(if (not (global809 capSqr:))
					((ScriptID 1201 0) doit:) ; book
				else
					(= global833 1)
				)
			)
			(if (and (not (global809 capSqr:)) (<= global815 5) (not global833))
				((ScriptID 1201 0) doit:) ; book
			)
		)
		(if global834
			(= local8 local6)
			(= local9 local7)
			(= local6 (global809 toSqr:))
			(= local7 (global809 fromSqr:))
		)
		(if
			(and
				global830
				global831
				(or local10 local11)
				(not (global809 capSqr:))
			)
			(global809 fromSqr: global830)
			(global809 toSqr: global831)
			(global809 capSqr: 0)
		)
		(self compuMove:)
		(return 1)
	)

	(method (cue)
		(if (== global832 250)
			(gSound play: 806)
			(global819 cel: 0 loop: 2)
			(RedrawCast)
			(global819 setCycle: 0)
		else
			(gSound play: 801)
		)
		(if (and (< (global809 toSqr:) 5) (not global811))
			(if (!= (global819 type:) 2)
				(gChar1
					sayReg: 1200 (+ (gChar1 view:) 1) 116 0 (Random 1 2)
				)
				(= global839 1)
			)
			(if (== global835 1)
				(= global835 2)
			)
			(if (== global832 200)
				(global819 type: 2 cel: 3 hiCel: 2)
			else
				(global819 type: 2)
				(cond
					((== (global819 view:) 1250)
						(global819 view: 1251)
					)
					((== (global819 view:) 1252)
						(global819 view: 1253)
					)
				)
			)
		)
		((gCurRoom script:) cue:)
	)

	(method (compuMove &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= global812 0)
		(= global811 0)
		(= temp0 ((ScriptID 1200 1) firstTrue: #findPiece (global809 fromSqr:))) ; pieces
		(temp0 sqrNum: (global809 toSqr:))
		(= temp2 (global809 toSqr:))
		(if (< (global809 toSqr:) 5)
			(if (== (temp0 type:) 1)
				(= temp1 1)
			)
			([global841 (global809 toSqr:)] checker: 2)
		else
			([global841 (global809 toSqr:)]
				checker: ([global841 (global809 fromSqr:)] checker:)
			)
		)
		([global841 (global809 fromSqr:)] checker: 0)
		(if (global809 capSqr:)
			(= global812 1)
			([global841 (global809 capSqr:)] checker: 0)
			(= global816
				((ScriptID 1200 1) firstTrue: #findPiece (global809 capSqr:)) ; pieces
			)
			(if (not temp1)
				(= global811 (self moreJmps:))
			else
				(= global811 0)
			)
		)
		(= global819 temp0)
		(if (== global832 200)
			(temp0
				setPri: 15
				setSpeed: global898
				setMotion:
					MoveTo
					(+ ([global841 temp2] nsLeft:) 33)
					(+ ([global841 temp2] nsTop:) 33)
					self
			)
		else
			(temp0
				setPri: 15
				setSpeed: global898
				setMotion:
					MoveToEndLoop
					(+ ([global841 temp2] nsLeft:) 33)
					(+ ([global841 temp2] nsTop:) 33)
					self
			)
		)
	)

	(method (changeBoard param1)
		([global841 (param1 toSqr:)]
			checker: ([global841 (param1 fromSqr:)] checker:)
		)
		([global841 (param1 fromSqr:)] checker: 0)
		(if (param1 capSqr:)
			([global841 (param1 capSqr:)] checker: 0)
		)
	)

	(method (changeBack param1)
		([global841 (param1 fromSqr:)]
			checker: ([global841 (param1 toSqr:)] checker:)
		)
		([global841 (param1 toSqr:)] checker: 0)
		(if (param1 capSqr:)
			([global841 (param1 capSqr:)] checker: (param1 capChkr:))
		)
	)

	(method (freeNodes param1 &tmp temp0 temp1)
		(for ((= temp0 (- (param1 size:) 1))) (>= temp0 0) ((-- temp0))
			(= temp1 (param1 at: temp0))
			(if (temp1 isEmpty:)
				(param1 delete: temp1)
				(-- global822)
				(temp1 dispose:)
			)
		)
	)

	(method (generate param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 [temp10 2])
		(= temp9 0)
		(= temp8 0)
		(= temp7 0)
		(= temp4 0)
		(if (== param1 1)
			(for ((= temp2 1)) (< temp2 33) ((++ temp2))
				(if local0
					(switch ([global841 temp2] checker:)
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
										(== ([global841 14] checker:) 2)
										(== ([global841 1] checker:) 2)
									)
									(and
										(== temp2 7)
										(== ([global841 18] checker:) 2)
										(== ([global841 1] checker:) 2)
									)
									(and
										(== temp2 13)
										(== ([global841 10] checker:) 2)
										(== ([global841 5] checker:) 2)
									)
									(and
										(== temp2 17)
										(== ([global841 15] checker:) 2)
										(== ([global841 5] checker:) 2)
									)
									(and
										(== temp2 20)
										(== ([global841 23] checker:) 2)
										(== ([global841 28] checker:) 2)
									)
									(and
										(== temp2 16)
										(== ([global841 28] checker:) 2)
										(== ([global841 18] checker:) 2)
									)
									(and
										(== temp2 31)
										(== ([global841 19] checker:) 2)
										(== ([global841 32] checker:) 2)
									)
									(and
										(== temp2 26)
										(== ([global841 15] checker:) 2)
										(== ([global841 32] checker:) 2)
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
				(if (> ([global841 temp2] checker:) 0)
					(for
						((= temp3 0))
						(<=
							temp3
							(if (== ([global841 temp2] checker:) 1) 1 else 3)
						)
						((++ temp3))
						
						(= temp0 ([global841 temp2] sqrOn: temp3))
						(= temp1 ([global841 temp0] sqrOn: temp3))
						(if
							(and
								(< ([global841 temp0] checker:) 0)
								(== ([global841 temp1] checker:) 0)
							)
							(= temp5 ([global841 temp0] checker:))
							(= temp4 1)
							(if (not global808)
								(self newNode: temp2 temp1 temp0 temp5)
							else
								(self shortEval: temp2 temp0 temp1 param1)
								(if (> global818 (global807 value:))
									(global807 value: global818)
									(if
										(>=
											(global807 value:)
											(global806 value:)
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
					((ScriptID 1203 1) doit:) ; endGame2
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
					((ScriptID 1203 2) doit:) ; endGame3
				)
				((and (> local3 0) (> local5 0))
					(= local12 1)
				)
			)
			(if (not temp4)
				(= temp1 0)
				(for ((= temp2 1)) (< temp2 33) ((++ temp2))
					(if (> ([global841 temp2] checker:) 0)
						(for
							((= temp3 0))
							(<=
								temp3
								(if (== ([global841 temp2] checker:) 1)
									1
								else
									3
								)
							)
							((++ temp3))
							
							(= temp0 ([global841 temp2] sqrOn: temp3))
							(if (== ([global841 temp0] checker:) 0)
								(if (not global808)
									(self newNode: temp2 temp0 0 0)
								else
									(self shortEval: temp2 temp0 0 param1)
									(if (> global818 (global807 value:))
										(global807 value: global818)
										(if
											(>=
												(global807 value:)
												(global806 value:)
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
				(if (< ([global841 temp2] checker:) 0)
					(for
						((= temp3 3))
						(>=
							temp3
							(if (== ([global841 temp2] checker:) -1) 2 else 0)
						)
						((-- temp3))
						
						(= temp0 ([global841 temp2] sqrOn: temp3))
						(= temp1 ([global841 temp0] sqrOn: temp3))
						(if
							(and
								(> ([global841 temp0] checker:) 0)
								(== ([global841 temp1] checker:) 0)
							)
							(= temp5 ([global841 temp0] checker:))
							(= temp4 1)
							(if (not global808)
								(= temp6
									(self newNode: temp2 temp1 temp0 temp5)
								)
							else
								(self shortEval: temp2 temp0 temp1 param1)
								(cond
									(
										(and
											(== ((ScriptID 1200 6) skill:) 2) ; player1
											(or
												(<= local17 8)
												(and
													(global807 capSqr:)
													(global821 capSqr:)
												)
											)
										)
										(if (< global818 (global824 value:))
											(global824 value: global818)
											(if
												(<=
													(global824 value:)
													(global823 value:)
												)
												(return)
											)
										)
									)
									((!= ((ScriptID 1200 6) skill:) 0) ; player1
										(if (< global818 (global821 value:))
											(global821 value: global818)
											(if
												(<=
													(global821 value:)
													(global807 value:)
												)
												(return)
											)
										)
									)
									((< global818 (global806 value:))
										(global806 value: global818)
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
					(if (< ([global841 temp2] checker:) 0)
						(for
							((= temp3 3))
							(>=
								temp3
								(if (== ([global841 temp2] checker:) -1)
									2
								else
									0
								)
							)
							((-- temp3))
							
							(= temp0 ([global841 temp2] sqrOn: temp3))
							(if (== ([global841 temp0] checker:) 0)
								(if (not global808)
									(self newNode: temp2 temp0 0 0)
								else
									(self shortEval: temp2 temp0 0 param1)
									(cond
										(
											(and
												(==
													((ScriptID 1200 6) skill:) ; player1
													2
												)
												(or
													(<= local17 8)
													(and
														(global807 capSqr:)
														(global821 capSqr:)
													)
												)
											)
											(if (< global818 (global824 value:))
												(global824 value: global818)
												(if
													(<=
														(global824 value:)
														(global823 value:)
													)
													(return)
												)
											)
										)
										((!= ((ScriptID 1200 6) skill:) 0) ; player1
											(if (< global818 (global821 value:))
												(global821 value: global818)
												(if
													(<=
														(global821 value:)
														(global807 value:)
													)
													(return)
												)
											)
										)
										((< global818 (global806 value:))
											(global806 value: global818)
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
			([global841 param2] checker: ([global841 param1] checker:))
		else
			([global841 param3] checker: ([global841 param1] checker:))
			(= temp2 ([global841 param2] checker:))
			([global841 param2] checker: 0)
			(self multiJmp: param3 -1 1 lev4Lst)
		)
		([global841 param1] checker: 0)
		(= temp12 0)
		(= global818 0)
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
				(!= ((ScriptID 1200 6) skill:) 0) ; player1
				(not (global806 capSqr:))
				(global807 capSqr:)
				(not (global821 capSqr:))
			)
			(-= global818 200)
		)
		(for ((= temp1 1)) (<= temp1 32) ((++ temp1))
			(switch ([global841 temp1] checker:)
				(1
					(if (< temp1 5)
						(+= global818 60)
					else
						(+= global818 40)
					)
					(if (or (> temp1 29) (== temp1 26))
						(++ temp5)
					)
					(if (< 12 temp1 17)
						(++ global818)
					)
					(if (< 8 temp1 13)
						(+= global818 1)
					)
					(if (< 4 temp1 9)
						(+= global818 2)
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
						(++ global818)
					)
					(if
						(and
							(== ([global841 temp1] sqrOn: 1) 1)
							(==
								([global841 ([global841 temp1] sqrOn: 1)]
									sqrOn: 1
								)
								1
							)
						)
						(++ global818)
					)
					(if
						(and
							(== ([global841 temp1] sqrOn: 0) 1)
							(==
								([global841 ([global841 temp1] sqrOn: 0)]
									sqrOn: 0
								)
								1
							)
						)
						(++ global818)
					)
					(if (== ((ScriptID 1200 6) skill:) 2) ; player1
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
							(+= global818 3)
							(if
								(or
									(== ([global841 17] checker:) -1)
									(== ([global841 18] checker:) -1)
									(== ([global841 21] checker:) -1)
									(== ([global841 22] checker:) -1)
								)
								(++ global818)
							)
						)
						(if (== temp1 32)
							(+= global818 3)
							(if
								(or
									(== ([global841 19] checker:) -1)
									(== ([global841 20] checker:) -1)
									(== ([global841 23] checker:) -1)
									(== ([global841 24] checker:) -1)
								)
								(++ global818)
							)
						)
						(if
							(and
								(< 10 global815 25)
								(or (== temp1 9) (== temp1 13))
							)
							(++ global818)
						)
						(if
							(and
								(< global815 14)
								(or
									(== temp1 14)
									(== temp1 15)
									(== temp1 18)
									(== temp1 19)
								)
							)
							(++ global818)
						)
						(if
							(and
								(== ((ScriptID 1200 3) sqrNum:) 29) ; R29
								(== (global806 fromSqr:) 29)
								(== (global806 toSqr:) 25)
							)
							(+= global818 3)
						)
						(if
							(and
								(== ((ScriptID 1200 4) sqrNum:) 25) ; R25
								(== (global806 fromSqr:) 25)
								(== (global806 toSqr:) 22)
							)
							(+= global818 3)
						)
						(if
							(and
								(== ((ScriptID 1200 5) sqrNum:) 22) ; R22
								(== (global806 fromSqr:) 22)
								(== (global806 toSqr:) 18)
							)
							(+= global818 3)
						)
						(if (== ([global841 temp1] sqrOn: 0) 0)
							(++ global818)
						)
						(if (== ([global841 temp1] sqrOn: 1) 0)
							(++ global818)
						)
						(if (== ([global841 temp1] sqrOn: 2) 1)
							(+= global818 2)
						)
						(if (== ([global841 temp1] sqrOn: 3) 1)
							(+= global818 2)
						)
					)
				)
				(2
					(= global834 1)
					(= temp10 1)
					(+= global818 60)
					(if
						(==
							([global841 ([global841 temp1] sqrOn: 2)] checker:)
							-1
						)
						(++ global818)
					)
					(if
						(==
							([global841 ([global841 temp1] sqrOn: 3)] checker:)
							-1
						)
						(++ global818)
					)
					(if (== ((ScriptID 1200 6) skill:) 2) ; player1
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
							(++ global818)
						)
						(if
							(or
								(== temp1 14)
								(== temp1 15)
								(== temp1 18)
								(== temp1 19)
							)
							(++ global818)
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
						(-= global818 15)
					)
					(if (> temp1 28)
						(-= global818 60)
					else
						(-= global818 40)
					)
					(if (== ((ScriptID 1200 6) skill:) 2) ; player1
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
							(-- global818)
						)
						(if (< 20 temp1 25)
							(-= global818 2)
						)
						(if (< 24 temp1 29)
							(-= global818 4)
						)
						(if
							(or
								(== temp1 14)
								(== temp1 15)
								(== temp1 18)
								(== temp1 19)
							)
							(-- global818)
						)
					)
				)
				(-2
					(-= global818 60)
					(= temp10 1)
					(if (== ((ScriptID 1200 6) skill:) 2) ; player1
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
							(-= global818 2)
						)
						(if
							(or
								(== temp1 14)
								(== temp1 15)
								(== temp1 18)
								(== temp1 19)
							)
							(-- global818)
						)
					)
				)
			)
		)
		(if (== ((ScriptID 1200 6) skill:) 2) ; player1
			(if
				(and
					(< global815 10)
					(or
						(== (global806 fromSqr:) 26)
						(== (global806 fromSqr:) 27)
					)
					(global806 capSqr:)
				)
				(-= global818 5)
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
				(+= global818 3)
			)
			(if (and (== temp4 1) (== temp6 0))
				(-= global818 3)
			)
			(if
				(and
					(global807 capSqr:)
					(>= temp7 (+ temp8 3))
					(global821 capSqr:)
				)
				(if (> local2 3)
					(+= global818 0)
				else
					(+= global818 8)
				)
			else
				(-= global818 2)
			)
			(if (== temp8 0)
				(+= global818 999)
			)
			(if (and (< (+ temp7 temp8) 24) (== (mod temp9 2) 1))
				(if temp11
					(+= global818 8)
				else
					(+= global818 3)
				)
			)
			(if
				(and
					(not temp10)
					(or
						(== ([global841 26] checker:) 1)
						(== ([global841 7] checker:) 1)
					)
				)
				(+= global818 2)
			)
			(if temp11
				(+= global818 temp12)
			)
			(if local10
				(+= global818 global829)
			)
			(if local11
				(+= global818 global829)
			)
		)
		(if local12
			(+= global818 local14)
		)
		(if (and (not temp10) (< global815 31))
			(self problity:)
		)
		(cond
			((== param3 0)
				([global841 param1] checker: ([global841 param2] checker:))
				([global841 param2] checker: 0)
			)
			((lev4Lst isEmpty:)
				([global841 param1] checker: ([global841 param3] checker:))
				([global841 param2] checker: temp2)
				([global841 param3] checker: 0)
			)
			(else
				(for
					((= temp13 (- (lev4Lst size:) 1)))
					(>= temp13 0)
					((-- temp13))
					
					(self changeBack: (lev4Lst at: temp13))
				)
				([global841 param1] checker: ([global841 param3] checker:))
				([global841 param2] checker: temp2)
				([global841 param3] checker: 0)
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
				(if (== ([global841 (global809 toSqr:)] checker:) 1) 1 else 3)
			)
			((++ temp0))
			
			(= temp1 ([global841 (global809 toSqr:)] sqrOn: temp0))
			(= temp2 ([global841 temp1] sqrOn: temp0))
			(if
				(and
					(< ([global841 temp1] checker:) 0)
					(== ([global841 temp2] checker:) 0)
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
					((== ([global841 temp1] checker:) -2)
						(= local18 temp1)
						(= local19 temp2)
					)
				)
			)
		)
		(if local18
			(global809 fromSqr: (global809 toSqr:))
			(global809 toSqr: local19)
			(global809 capSqr: local18)
			(return 1)
		else
			(return 0)
		)
	)

	(method (multiJmp param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== param2 1)
			(for
				((= temp0 0))
				(<= temp0 (if (== ([global841 param1] checker:) 1) 1 else 3))
				((++ temp0))
				
				(= temp1 ([global841 param1] sqrOn: temp0))
				(= temp2 ([global841 temp1] sqrOn: temp0))
				(if
					(and
						(< ([global841 temp1] checker:) 0)
						(== ([global841 temp2] checker:) 0)
					)
					(if param3
						(= temp3 ([global841 temp1] checker:))
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
				(>= temp0 (if (== ([global841 param1] checker:) -1) 2 else 0))
				((-- temp0))
				
				(= temp1 ([global841 param1] sqrOn: temp0))
				(= temp2 ([global841 temp1] sqrOn: temp0))
				(if
					(and
						(> ([global841 temp1] checker:) 0)
						(== ([global841 temp2] checker:) 0)
					)
					(if param3
						(= temp3 ([global841 temp1] checker:))
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
				(and (== (global806 fromSqr:) 29) (== (global806 toSqr:) 25))
				(and (== (global806 fromSqr:) 25) (== (global806 toSqr:) 22))
				(and (== (global806 fromSqr:) 24) (== (global806 toSqr:) 19))
				(and (== (global806 fromSqr:) 22) (== (global806 toSqr:) 18))
				(and (== (global806 fromSqr:) 17) (== (global806 toSqr:) 14))
				(and (== (global806 fromSqr:) 17) (== (global806 toSqr:) 13))
			)
			(++ global818)
		)
		(if
			(and
				(> global815 10)
				(or
					(and (== (global806 fromSqr:) 11) (== (global806 toSqr:) 8))
					(and
						(== (global806 fromSqr:) 15)
						(== (global806 toSqr:) 10)
					)
					(and (== (global806 fromSqr:) 11) (== (global806 toSqr:) 7))
					(and (== (global806 fromSqr:) 7) (== (global806 toSqr:) 2))
				)
			)
			(++ global818)
		)
		(if
			(and
				(> global815 20)
				(!= ([global841 (global806 fromSqr:)] checker:) 2)
				(or
					(and
						(== (global806 fromSqr:) 27)
						(== (global806 toSqr:) 23)
					)
					(and
						(== (global806 fromSqr:) 25)
						(== (global806 toSqr:) 21)
					)
					(and
						(== (global806 fromSqr:) 23)
						(== (global806 toSqr:) 18)
					)
					(and
						(== (global806 fromSqr:) 22)
						(== (global806 toSqr:) 17)
					)
					(and (== (global806 fromSqr:) 10) (== (global806 toSqr:) 6))
					(and (== (global806 fromSqr:) 6) (== (global806 toSqr:) 2))
					(and (== (global806 fromSqr:) 8) (== (global806 toSqr:) 3))
					(and
						(== (global806 fromSqr:) 16)
						(== (global806 toSqr:) 11)
					)
					(and
						(== (global806 fromSqr:) 15)
						(== (global806 toSqr:) 11)
					)
					(and (== (global806 fromSqr:) 12) (== (global806 toSqr:) 8))
					(and (== (global806 fromSqr:) 10) (== (global806 toSqr:) 7))
					(and (== (global806 fromSqr:) 9) (== (global806 toSqr:) 6))
					(and (== (global806 fromSqr:) 8) (== (global806 toSqr:) 4))
					(and (== (global806 fromSqr:) 7) (== (global806 toSqr:) 3))
					(and (== (global806 fromSqr:) 6) (== (global806 toSqr:) 1))
					(and (== (global806 fromSqr:) 5) (== (global806 toSqr:) 1))
				)
			)
			(++ global818)
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
				(== (global806 fromSqr:) local6)
				(== (global806 toSqr:) local7)
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
						([global841 local13] row:)
						([global841 (param1 fromSqr:)] row:)
					)
					(>
						([global841 local13] col:)
						([global841 (param1 fromSqr:)] col:)
					)
				)
				(if
					(==
						(param1 toSqr:)
						([global841 (param1 fromSqr:)] bacLeft:)
					)
					(+= local14 1)
				)
			)
			(
				(and
					(<
						([global841 local13] row:)
						([global841 (param1 fromSqr:)] row:)
					)
					(<
						([global841 local13] col:)
						([global841 (param1 fromSqr:)] col:)
					)
				)
				(if
					(==
						(param1 toSqr:)
						([global841 (param1 fromSqr:)] fwdRight:)
					)
					(+= local14 1)
				)
			)
			(
				(and
					(<=
						([global841 local13] row:)
						([global841 (param1 fromSqr:)] row:)
					)
					(>=
						([global841 local13] col:)
						([global841 (param1 fromSqr:)] col:)
					)
				)
				(if
					(==
						(param1 toSqr:)
						([global841 (param1 fromSqr:)] fwdLeft:)
					)
					(+= local14 1)
				)
			)
			(
				(and
					(>=
						([global841 local13] row:)
						([global841 (param1 fromSqr:)] row:)
					)
					(<=
						([global841 local13] col:)
						([global841 (param1 fromSqr:)] col:)
					)
					(==
						(param1 toSqr:)
						([global841 (param1 fromSqr:)] bacRight:)
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
			(if (== ([global841 param1] checker:) 0)
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
						(== ([global841 param1] checker:) 0)
					)
					(or
						(and
							(==
								([global841 ([global841 param1] sqrOn: 2)]
									checker:
								)
								0
							)
							(==
								([global841 ([global841 param1] sqrOn: 3)]
									checker:
								)
								0
							)
						)
						(and
							(>
								([global841 ([global841 param1] sqrOn: 2)]
									checker:
								)
								0
							)
							(!=
								([global841 ([global841 param1] sqrOn: 1)]
									checker:
								)
								0
							)
							(!= ([global841 param1] sqrOn: 1) local20)
							(>
								([global841 ([global841 param1] sqrOn: 3)]
									checker:
								)
								0
							)
							(!=
								([global841 ([global841 param1] sqrOn: 0)]
									checker:
								)
								0
							)
							(!= ([global841 param1] sqrOn: 0) local20)
						)
						(== param1 28)
						(== param1 21)
					)
				)
				(= temp1 ([global841 param1] sqrOn: temp0))
				(if (kingPath doit: temp1)
					(return 1)
				)
			)
		)
		(return 0)
	)
)

