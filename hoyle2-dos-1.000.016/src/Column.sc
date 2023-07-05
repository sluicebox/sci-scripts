;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 304)
(include sci.sh)
(use Main)
(use CardList)
(use BowlingScoreSheet)
(use n315)
(use n322)
(use theSliders)

(public
	proc304_0 0
)

(procedure (proc304_0 param1)
	(param1 isMemberOf: Column)
)

(class Column of CardList
	(properties
		dontPlayAmongSelves 0
		dontFillBlanksAmongSelves 0
	)

	(method (init)
		(if active
			(super init:)
		)
	)

	(method (handleInput param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(if (and (proc0_6 126) (self isMemberOf: Column))
			(for ((= temp7 (= temp8 0))) (< temp7 25) ((++ temp7))
				(if ((gTheColumns at: temp7) size:)
					(++ temp8)
				)
			)
			(if (== temp8 24)
				((gTheWastePiles at: 0) autoFill: 0)
			)
		)
		(if (and (proc0_6 127) (self isMemberOf: Column))
			(for ((= temp7 (= temp8 0))) (< temp7 16) ((++ temp7))
				(if ((gTheColumns at: temp7) size:)
					(++ temp8)
				)
			)
			(if (== temp8 15)
				(= global682 1)
			)
		)
		(if (and (proc0_6 119) (self isThereADimmedObject: 1))
			(cond
				((self isMemberOf: Column)
					(= temp9 (if (< global337 400) 1 else 0))
					(if (== (gTheColumns at: 0) self)
						(if (== size (+ 2 temp9))
							(proc0_5 (Format @global100 304 0 (+ 2 temp9))) ; "Move not allowed. Only %d cards allowed."
							(return 0)
						)
						(if (== size (+ 1 temp9))
							((global418 at: (- global417 1)) doit:)
						)
					else
						(if (!= ((gTheColumns at: 0) size:) (+ 2 temp9))
							(proc0_5 (Format @global100 304 1)) ; "Must finish the 1st ball first."
							(return 0)
						)
						(if (== size (+ 1 temp9))
							((global418 at: (- global417 1)) doit:)
							(= global420 1)
						)
					)
				)
				((proc314_4 self)
					(return 0)
				)
			)
		)
		(if (proc0_6 122)
			(return (proc322_0 self))
		)
		(if (proc0_6 118)
			(return (proc323_1 self))
		)
		(return
			(if size
				(if (not ((self lastCard:) faceUp:))
					((self lastCard:) flip:)
					(self showUpdate:)
				else
					(if (and (proc0_6 124) (proc315_2 self))
						(return 0)
					)
					(if (= dimmedObj (self isThereADimmedObject: 1))
						(if (= temp5 (self numDimmed:))
							(= param1 (self limitDigDown: param1))
							(if ((self at: param1) faceUp:)
								(self dim: param1)
							else
								(self dim: (self firstFaceUp: 1))
							)
							(if (== (self numDimmed:) temp5)
								(self whiten:)
							)
						else
							(if (and (proc0_6 124) (proc315_3 self))
								(return)
							)
							(cond
								(
									(and
										(> (= temp4 (self moveOK:)) 0)
										(or
											(not (proc0_6 124))
											(and
												(proc0_6 124)
												(== dimmedObj (gTheWastePiles at: 0))
											)
										)
									)
									(= temp3 (dimmedObj firstDimmed:))
									(dimmedObj giveUpCards:)
									(gTheCardToss init: temp3 self 418)
								)
								(
									(or
										(not temp4)
										(and
											(proc0_6 124)
											(!= dimmedObj (gTheWastePiles at: 0))
										)
									)
									(= temp6 (self howManyDimmedObjects:))
									(cond
										((== global407 1)
											(dimmedObj whiten:)
											(self dim: param1)
										)
										((== temp6 global407)
											(proc0_5
												(Format ; "Only %d cards may be selected at a time."
													@global100
													304
													2
													global407
												)
											)
										)
										(else
											(self dim: param1)
										)
									)
								)
							)
						)
					else
						(self dim: param1)
					)
				)
			else
				(= dimmedObj (self isThereADimmedObject: 1))
				(if
					(and
						(not (proc0_6 124))
						dimmedObj
						(or
							(not dontFillBlanksAmongSelves)
							(not (gTheColumns contains: dimmedObj))
						)
					)
					(if
						(>
							(+ (= temp0 (dimmedObj numDimmed:)) size)
							maxCardsAllowed
						)
						(proc0_5 (Format @global100 304 3)) ; "Move not allowed. Over Maximum."
						(return 0)
					)
					(= temp1 (dimmedObj firstDimRank:))
					(= temp2 0)
					(if
						(= temp2
							(switch fillEmptyWith
								(13
									(if (== temp1 13) 1 else 0)
								)
								(1 1)
								(2
									(if
										(and
											(global317 active:)
											(or
												(not (global317 startingRank:))
												(==
													(+ temp1 1)
													(global317 startingRank:)
												)
												(and
													wrap
													(== temp1 13)
													(==
														(global317
															startingRank:
														)
														1
													)
												)
											)
										)
										1
									else
										0
									)
								)
							)
						)
						(= temp3 (dimmedObj firstDimmed:))
						(dimmedObj giveUpCards:)
						(gTheCardToss init: temp3 self 418)
					else
						(proc0_5 (Format @global100 304 4)) ; "Not a Valid Move."
					)
				else
					(proc0_5 (Format @global100 304 4)) ; "Not a Valid Move."
				)
			)
		)
	)

	(method (whiten)
		(for
			((= global301 (self firstDimmed: 1)))
			(< global301 size)
			((++ global301))
			
			((self at: global301) whiten:)
		)
		(self showUpdate:)
	)

	(method (dim param1 &tmp temp0 temp1)
		(switch dimRule
			(0
				(if ((self lastCard:) dimmed:)
					((self lastCard:) whiten:)
				else
					((self lastCard:) dim:)
				)
			)
			(1
				(= temp0 (self firstFaceUp: 1))
				(if (not ((self at: param1) faceUp:))
					(= param1 temp0)
				)
				(= param1 (self limitDigDown: param1))
				(for ((= global301 temp0)) (< global301 size) ((++ global301))
					(if (== global301 param1)
						((self at: global301) dim:)
					else
						((self at: global301) whiten:)
					)
				)
			)
			(2
				(for
					((= global301 (= param1 (self limitDigDown: param1))))
					(< global301 size)
					((++ global301))
					
					(if ((self at: global301) faceUp:)
						((self at: global301) dim:)
					)
				)
			)
			(3
				(if (== param1 (- size 1))
					((self lastCard:) dim:)
				else
					(= param1 (self firstFaceUp: 1))
					(for
						((= global301 (= param1 (self limitDigDown: param1))))
						(< global301 size)
						((++ global301))
						
						((self at: global301) dim:)
					)
				)
			)
			(4
				(if (== param1 (- size 1))
					((self lastCard:) dim:)
				else
					(= param1 (self firstFaceUp: 1))
					(for
						((= global301 (= param1 (self limitDigDown: param1))))
						(< global301 size)
						((++ global301))
						
						((self at: global301) dim:)
					)
				)
			)
			(5
				(if (== param1 (- size 1))
					((self lastCard:) dim:)
				else
					(for
						((= global301 (- size 1)))
						(and
							(>= global301 (- size (+ digDown 1)))
							(>= global301 1)
							((self at: global301) faceUp:)
							((self at: (- global301 1)) faceUp:)
							(self
								moveOK2:
									(self at: global301)
									(self at: (- global301 1))
							)
						)
						((-- global301))
						
						((self at: global301) dim:)
						((self at: (- global301 1)) dim:)
						0
					)
					((self lastCard:) dim:)
				)
			)
			(6
				(if (== param1 (- size 1))
					((self lastCard:) dim:)
				else
					(for
						((= global301 (- size 1)))
						(>= global301 (- size (+ digDown 1)))
						((-- global301))
						
						(if (>= global301 1)
							(if ((self at: global301) faceUp:)
								(if ((self at: (- global301 1)) faceUp:)
									(if
										(self
											moveOK2:
												(self at: global301)
												(self at: (- global301 1))
										)
										((self at: global301) dim:)
										((self at: (- global301 1)) dim:)
										0
									else
										(break)
									)
								else
									(break)
								)
							else
								(break)
							)
						else
							(break)
						)
						((self lastCard:) dim:)
					)
					((self lastCard:) dim:)
				)
			)
			(7
				(if (== param1 (- size 1))
					((self lastCard:) dim:)
				else
					(for
						((= global301 (- size 1)))
						(and
							(>= global301 (- size (+ digDown 1)))
							(>= global301 1)
							((self at: global301) faceUp:)
							((self at: (- global301 1)) faceUp:)
							(==
								((self at: global301) suit:)
								((self at: (- global301 1)) suit:)
							)
							(self
								moveOK2:
									(self at: global301)
									(self at: (- global301 1))
							)
						)
						((-- global301))
						
						((self at: global301) dim:)
						((self at: (- global301 1)) dim:)
						0
					)
					((self lastCard:) dim:)
				)
			)
		)
		(self showUpdate:)
	)

	(method (moveOK &tmp temp0)
		(if
			(and
				(> (+ (= temp0 (dimmedObj numDimmed:)) size) maxCardsAllowed)
				(== (self howManyDimmedObjects:) global407)
			)
			(proc0_5 (Format @global100 304 3)) ; "Move not allowed. Over Maximum."
			(return -1)
		)
		(if
			(and
				(self moveOK2: (dimmedObj firstDimmed:) (self lastCard:) 0)
				(or
					(!= dimRule 3)
					(>= (dimmedObj numDimmed:) 2)
					(== (dimmedObj numFaceUp:) 1)
					(not (gTheColumns contains: dimmedObj))
				)
				(or
					(not dontPlayAmongSelves)
					(not (gTheColumns contains: dimmedObj))
				)
				(or
					(!= dimRule 5)
					(>= (dimmedObj numDimmed:) 2)
					(== (dimmedObj numFaceUp:) 1)
					(not
						(self
							moveOK2:
								(dimmedObj lastCard:)
								(dimmedObj at: (- (dimmedObj size:) 2))
								0
						)
					)
				)
				(or
					(!= dimRule 7)
					(>= (dimmedObj numDimmed:) 2)
					(== (dimmedObj numFaceUp:) 1)
					(not
						(self
							moveOK2:
								(dimmedObj lastCard:)
								(dimmedObj at: (- (dimmedObj size:) 2))
								0
						)
					)
				)
			)
			(return 1)
		)
		(return 0)
	)

	(method (moveOK2 param1 param2)
		(if (> (+ size 1) maxCardsAllowed)
			(return 0)
		)
		(self setOrigDest: param1 param2)
		(if
			(and
				(self buildMannerOK:)
				(or
					(and
						(== buildDirection 0)
						(or
							(and (== global633 -1) (== global634 0))
							(== global631 (+ global634 1))
							(and
								wrap
								(== global631 global316)
								(== global634 13)
							)
						)
					)
					(and
						(== buildDirection 1)
						(or
							(and (== global633 -1) (== global634 0))
							(== global631 (- global634 1))
							(and
								wrap
								(== global631 13)
								(== global634 global316)
							)
						)
					)
					(and
						(== buildDirection 2)
						(or
							(and (== global633 -1) (== global634 0))
							(== global631 (+ global634 1))
							(== global631 (- global634 1))
							(and
								wrap
								(== global631 global316)
								(== global634 13)
							)
							(and
								wrap
								(== global631 13)
								(== global634 global316)
							)
						)
					)
					(and (proc0_6 119) (== global631 global634))
					(== buildDirection 14)
				)
			)
			(if (and global335 (== global335 global634))
				(proc0_5 (Format @global100 304 5)) ; "Wrapping past starting foundation rank is not allowed."
				(return 0)
			else
				(return 1)
			)
		)
		(return 0)
	)
)

