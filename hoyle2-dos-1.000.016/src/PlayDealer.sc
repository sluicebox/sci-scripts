;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 311)
(include sci.sh)
(use Main)
(use System)

(class PlayDealer of Obj
	(properties
		currentlyActive 0
		dealFrom 0
		dealToList 0
		indexIntoList 0
	)

	(method (init param1 param2)
		(= currentlyActive 1)
		(= dealFrom param1)
		(= dealToList param2)
		(= global320 (= indexIntoList 0))
		(if (not (dealToList size:))
			(self cue:)
		)
	)

	(method (doit)
		(if (not global320)
			(if (= global302 (dealFrom giveUpCard:))
				(global302
					faceUp: ((dealToList at: indexIntoList) playDealFaceUp:)
				)
				(++ global320)
				(gTheTransferList empty: add: global302)
				(gTheCardToss init: dealFrom (dealToList at: indexIntoList))
			else
				(= indexIntoList (dealToList size:))
				(self cue:)
			)
		)
	)

	(method (cue)
		(= global320 0)
		(if (>= (++ indexIntoList) (dealToList size:))
			(= currentlyActive 0)
			(= global318 1)
		)
	)
)

