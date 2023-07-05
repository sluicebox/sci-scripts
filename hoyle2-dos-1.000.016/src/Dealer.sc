;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 309)
(include sci.sh)
(use Main)
(use WL)

(class Dealer of WL
	(properties
		nextReciever 0
		originalReciever 0
		currentStage 1
		currentlyActive 0
		skipRemovedCards 0
	)

	(method (init)
		(= currentStage (= currentlyActive 1))
		(if originalReciever
			(= nextReciever originalReciever)
			(self rotate: delete: nextReciever addToFront: nextReciever)
		else
			(= originalReciever (self at: 0))
		)
	)

	(method (dealNextCard &tmp temp0 temp1 temp2 temp3)
		(if (gTheStock size:)
			(= temp3 (= nextReciever (self setNextReciever:)))
			(if (gTheFoundations size:)
				(if
					(= nextReciever
						(gTheFoundations
							firstTrue:
								#checkRemoveDuringDeal
								(gTheStock at: (- (gTheStock size:) 1))
						)
					)
					(if skipRemovedCards
						(temp3 skippedOver: (+ (temp3 skippedOver:) 1))
					else
						(self rotate: temp3)
					)
					(self moveCard:)
					(return 1)
				else
					(= nextReciever temp3)
				)
			)
			(if nextReciever
				(self rotate: moveCard:)
				(return 1)
			)
			(= temp0 0)
			(for ((= global301 0)) (< global301 size) ((++ global301))
				(if (> (= temp1 ((self at: global301) stage:)) currentStage)
					(if temp0
						(if (< temp1 temp0)
							(= temp0 temp1)
						)
					else
						(= temp0 temp1)
					)
				)
			)
			(if (= currentStage temp0)
				(= nextReciever (self setNextReciever:))
				(if nextReciever
					(self rotate: moveCard:)
					(return 1)
				)
			)
		)
		(return (= currentlyActive 0))
	)

	(method (setNextReciever)
		(for ((= global301 0)) (< global301 size) ((++ global301))
			(if
				(and
					(== currentStage ((self at: global301) stage:))
					(<
						(+
							((self at: global301) size:)
							((self at: global301) skippedOver:)
						)
						((self at: global301) layoutRecieves:)
					)
				)
				(return (self at: global301))
			)
		)
		(return 0)
	)

	(method (rotate param1 &tmp temp0)
		(while (!= (self at: (- size 1)) (if argc param1 else nextReciever))
			(= temp0 (self at: 0))
			(self delete: temp0 add: temp0)
		)
	)

	(method (moveCard)
		(gTheTransferList empty: add: (gTheStock giveUpCard:))
		((gTheTransferList at: 0)
			faceUp: (>= (nextReciever size:) (nextReciever numFaceDown:))
		)
		(gTheCardToss init: gTheStock nextReciever)
	)
)

