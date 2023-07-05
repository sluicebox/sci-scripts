;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Game)

(public
	rm8 0
)

(local
	seenMessage
)

(instance rm8 of Rgn
	(properties)

	(method (init)
		(Load rsSOUND 105)
		(theSound init:)
		(super init:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (== gHenchOnScreen 0) (event claimed:))
			(return)
		)
		(if (Said 'talk')
			(Print 8 0) ; "Ooh, Larry. I think I love you. Why don't you come with me and we'll head back to my place!"
			(Print 8 1 #at -1 152) ; "(You wonder how she knows your name.)"
		)
		(if (Said 'fuck,(nap<using),(enjoy<make),(bone<hop),(fuck<up)')
			(Print 8 2) ; "I could be interested in that; but only with you, my studly hero!"
		)
		(if (Said 'look>')
			(if (Said '/woman')
				(Print 8 3) ; "She's a knockout, isn't she, Larry?"
			)
			(if (Said '/boob')
				(Print 8 4) ; "What a pair, eh?"
			)
			(if (Said '/ass')
				(Print 8 5) ; "It's tight and firm; not at all like yours, Larry."
			)
			(if (Said '/ear')
				(Print 8 6) ; "Her eyes bring fire to your heart."
			)
			(if (Said '/dress')
				(Print 8 7) ; "It's almost as beautiful as what's in it."
			)
		)
	)

	(method (notify loopCnt)
		(theSound loop: loopCnt play:)
	)
)

(instance theSound of Sound
	(properties
		number 105
	)
)

