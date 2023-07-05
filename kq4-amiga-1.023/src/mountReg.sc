;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 511)
(include sci.sh)
(use Interface)
(use Game)

(public
	mountReg 0
)

(instance mountReg of Rgn
	(properties)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look/cliff')
					(Print 511 0) ; "The rocky mountains rise sharply to the east."
				)
				((Said 'climb,cross/cliff')
					(Print 511 1) ; "These craggy mountains are much too steep to climb."
				)
			)
		)
	)
)

