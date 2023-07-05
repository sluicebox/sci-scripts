;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 306)
(include sci.sh)
(use Main)
(use CardList)
(use WL)
(use PlayDealer)
(use n315)
(use n322)

(class Stock of CardList
	(properties
		timesThruStock 1
		numTimesThru 0
		cardsToTake 52
		recievers 0
		shuffleReDeals 0
		doRedeal 0
	)

	(method (init)
		(if (not recievers)
			(= recievers (WL new:))
			(if theAutoFillSource1
				(= global324 self)
			)
			(if theAutoFillSource2
				(= global325 self)
			)
			(if (or (== dir 1) (== dir 2) (== dir 0))
				(= growingDeck 0)
			)
			(gTheInputList add: self)
		)
	)

	(method (init2)
		(self reDeal:)
	)

	(method (reDeal)
		(self getCards:)
		(if (== dir 3)
			(= adjXY 6)
			(self showStock:)
		)
		(= numTimesThru 0)
	)

	(method (getCards)
		(for ((= global301 0)) (< global301 cardsToTake) ((++ global301))
			(self add: (gTheDeck getCard:))
		)
	)

	(method (addReciever param1)
		(recievers add: param1)
	)

	(method (giveUpCard param1 param2)
		(= global302 0)
		(cond
			(argc
				(for ((= global301 0)) (< global301 size) ((++ global301))
					(if
						(and
							(== ((self at: global301) rank:) param1)
							(== ((self at: global301) suit:) param2)
						)
						(= global302 (self at: global301))
						(self delete: global302)
						(return global302)
					)
				)
				(return 0)
			)
			(size
				(= global302 (self at: (- size 1)))
				(self delete: global302)
				(if (not size)
					(++ numTimesThru)
				)
				(= whenEmpty (if (!= numTimesThru timesThruStock) 2 else 1))
				(if (proc0_6 118)
					(= whenEmpty 1)
				)
				(self showStock:)
			)
		)
		(return global302)
	)

	(method (handleInput)
		(if
			(and
				(not (gTheCardToss mover:))
				(not (gTheAutoCardToss mover:))
				(not (gTheAutoCardToss2 mover:))
			)
			(cond
				(size
					(if (proc0_6 124)
						(proc315_5 self)
					)
					(= global318 0)
					(PlayDealer init: self recievers)
				)
				((== whenEmpty 2)
					(self flipDeck:)
				)
			)
		)
	)

	(method (gather))

	(method (flipDeck)
		(gTheTransferList empty:)
		(gTheInputList eachElementDo: #gather)
		(if (gTheTransferList size:)
			(gTheTransferList eachElementDo: #faceUp 0)
			(for
				((= global301 0))
				(< global301 (gTheTransferList size:))
				((++ global301))
				
				(self add: (gTheTransferList at: global301))
			)
			(gTheTransferList empty:)
			(if (proc0_6 122)
				(proc322_5 self)
			)
			(= cel 99)
			(self showUpdate:)
			(if shuffleReDeals
				(self shuffle:)
			)
			(if doRedeal
				(gCurRoom state: 0)
				(= global303 0)
				(gTheDealer init:)
			)
		)
	)

	(method (showEmpty)
		(if (not global323)
			(proc0_1 (+ 400 global679) 0 whenEmpty x y priority)
		)
	)
)

