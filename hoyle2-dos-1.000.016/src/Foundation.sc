;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 303)
(include sci.sh)
(use Main)
(use CardList)
(use n315)
(use n320)
(use n321)

(class Foundation of CardList
	(properties
		whenEmpty 3
		buildManner 3
		buildDirection 0
		startingRank 1
		preRemoveRank 0
		preRemoveSuit 0
		firstPlayedStarts 0
		duringDealRemoveRank 0
		duringDealRemoveSuit 0
	)

	(method (init param1 &tmp temp0)
		(if argc
			(super init: param1)
		else
			(super init:)
		)
		(= temp0 0)
		(if preRemoveRank
			(= temp0 (gTheStock giveUpCard: preRemoveRank preRemoveSuit))
		)
		(if temp0
			(self add: temp0)
		)
	)

	(method (init2)
		(if size
			(proc0_1 ((self at: 0) suit:) 0 ((self at: 0) rank:) x y priority)
		else
			(proc0_1 202 0 0 x y priority)
		)
	)

	(method (checkRemoveDuringDeal param1)
		(return
			(if
				(and
					(or
						(== duringDealRemoveRank -1)
						(and
							(== duringDealRemoveRank (param1 rank:))
							(or
								(== duringDealRemoveSuit -1)
								(== duringDealRemoveSuit (param1 suit:))
							)
						)
					)
					(self moveOK2: param1 (self lastCard:) 0)
				)
				self
			else
				0
			)
		)
	)

	(method (cue param1 &tmp temp0)
		(if (and firstPlayedStarts (self allFoundationsEmpty:))
			(for ((= temp0 0)) (< temp0 (gTheFoundations size:)) ((++ temp0))
				((gTheFoundations at: temp0) startingRank: ((gTheTransferList at: 0) rank:))
			)
			(if global336
				(= global335 ((gTheTransferList at: 0) rank:))
			)
		)
		(if (proc0_6 125)
			(proc321_1)
		)
		(gTheSound number: (if (>= (DoSound sndCHECK_DRIVER) 3) 41 else 213) play:)
		(+= global400 1)
		(proc0_4)
		(super cue: (if (and argc param1) param1 else 0))
		(proc0_2)
	)

	(method (allFoundationsEmpty &tmp temp0)
		(for ((= temp0 0)) (< temp0 (gTheFoundations size:)) ((++ temp0))
			(if ((gTheFoundations at: temp0) size:)
				(return 0)
			)
		)
		(return 1)
	)

	(method (moveOK &tmp temp0)
		(if (> (+ (= temp0 (dimmedObj numDimmed:)) size) maxCardsAllowed)
			(proc0_5 (Format @global100 303 0)) ; "Move not allowed. Over Maximum."
			(return 0)
		)
		(return
			(self moveOK2: (dimmedObj firstDimmed:) (self lastCard:) dimmedObj)
		)
	)

	(method (moveOK2 param1 param2 param3)
		(if (> (+ size 1) maxCardsAllowed)
			(return 0)
		)
		(if
			(and
				firstPlayedStarts
				(self allFoundationsEmpty:)
				(or
					(gTheDealer currentlyActive:)
					(and param3 (== (param3 numDimmed:) 1))
				)
				(not (proc0_6 121))
			)
			(gTheFoundations eachElementDo: #startingRank global631)
			(if global336
				(= global335 global631)
			)
			(return 1)
		else
			(self setOrigDest: param1 (self lastCard:))
			(if
				(and
					(or
						(gTheDealer currentlyActive:)
						(not param3)
						(== (param3 numDimmed:) 1)
					)
					(self buildMannerOK:)
					(or
						(and
							(== buildDirection 0)
							(or
								(and global634 (== global631 (+ global634 1)))
								(and
									global634
									wrap
									(== global631 global316)
									(== global634 13)
								)
								(and
									(not global634)
									(or
										(== global631 startingRank)
										(not startingRank)
									)
								)
							)
						)
						(and
							(== buildDirection 11)
							(or
								(and global634 (== global631 (+ global634 2)))
								(and
									global634
									(== global631 2)
									(== global634 13)
								)
								(and
									global634
									(== global631 1)
									(== global634 12)
								)
								(and
									(not global634)
									(or
										(== global631 startingRank)
										(not startingRank)
									)
								)
							)
						)
						(and
							(== buildDirection 12)
							(or
								(and global634 (== global631 (+ global634 3)))
								(and
									global634
									(== global631 3)
									(== global634 13)
								)
								(and
									global634
									(== global631 2)
									(== global634 12)
								)
								(and
									global634
									(== global631 1)
									(== global634 11)
								)
								(and
									(not global634)
									(or
										(== global631 startingRank)
										(not startingRank)
									)
								)
							)
						)
						(and
							(== buildDirection 13)
							(or
								(and global634 (== global631 (+ global634 4)))
								(and
									global634
									(== global631 4)
									(== global634 13)
								)
								(and
									global634
									(== global631 3)
									(== global634 12)
								)
								(and
									global634
									(== global631 2)
									(== global634 11)
								)
								(and
									global634
									(== global631 1)
									(== global634 10)
								)
								(and
									(not global634)
									(or
										(== global631 startingRank)
										(not startingRank)
									)
								)
							)
						)
						(and
							(== buildDirection 1)
							(or
								(and global634 (== global631 (- global634 1)))
								(and
									global634
									wrap
									(== global631 13)
									(== global634 global316)
								)
								(and
									(not global634)
									(or
										(== global631 startingRank)
										(not startingRank)
									)
								)
							)
						)
						(and
							(== buildDirection 2)
							(or
								(and global634 (== global631 (- global634 1)))
								(and global634 (== global631 (+ global634 1)))
								(and
									global634
									wrap
									(== global631 global316)
									(== global634 13)
								)
								(and
									global634
									wrap
									(== global631 13)
									(== global634 global316)
								)
								(and
									(not global634)
									(or
										(== global631 startingRank)
										(not startingRank)
									)
								)
							)
						)
						(and (== buildDirection 14) (not (proc0_6 121)))
						(and (proc0_6 121) param1 (proc320_0 gTheColumns param1))
					)
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (handleInput &tmp temp0 temp1 [temp2 2] temp4 temp5)
		(if
			(and
				dontBuildFoundationsYet
				(or (gTheStock size:) ((gTheWastePiles at: 0) size:))
			)
			(proc0_5 (Format @global100 303 1)) ; "Plays to Foundations not allowed until the Stock and Waste Pile are empty."
			(return)
		)
		(if (= dimmedObj (self isThereADimmedObject: 1))
			(cond
				((== global407 1)
					(if (self moveOK:)
						(= temp0 (dimmedObj firstDimmed:))
						(dimmedObj giveUpCards:)
						(gTheCardToss init: temp0 self)
					else
						(proc0_5 (Format @global100 303 2)) ; "Not a Valid Move."
					)
				)
				((== global407 2)
					(if (proc0_6 120)
						(if
							(and
								(= temp4 (self isThereADimmedObject: 2))
								(==
									((dimmedObj lastCard:) rank:)
									((temp4 lastCard:) rank:)
								)
							)
							(= temp0 (dimmedObj firstDimmed:))
							(dimmedObj giveUpCards:)
							(gTheCardToss init: temp0 self)
							(= temp1 (temp4 firstDimmed:))
							(temp4 giveUpCards: gTheTransferList2)
							(gTheAutoCardToss init: temp1 self)
						else
							(proc0_5 (Format @global100 303 3)) ; "Not a Valid Move. Must Be a Pair."
						)
					else
						(proc315_6 self dimmedObj)
					)
				)
				((== global407 3)
					(proc321_2 self dimmedObj)
				)
			)
		else
			(proc0_5 (Format @global100 303 4)) ; "No Valid Moves."
		)
	)
)

