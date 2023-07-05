;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Interface)
(use Game)

(public
	passReg 0
)

(synonyms
	(room passage)
)

(instance passReg of Rgn
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '/ceiling')
					(Print 212 0) ; "You see nothing special on the ceiling."
				)
				((Said '/wall')
					(Print 212 1) ; "Upon examining the walls of this secret chamber, you notice two close-set holes in each of two opposing walls. You can also see two secret panels, one in each wall."
				)
				((or (Said '/dirt') (Said '<down'))
					(Print 212 2) ; "You see a small, raised platform in the center of the secret room."
				)
				((Said '/stair')
					(Print 212 3) ; "A step leads up to a small, raised platform in the center of the room."
				)
				((Said '/platform')
					(Print 212 4) ; "The small platform seems to be centered right under two sets of two close-set holes in the walls."
				)
				((Said '/panel')
					(Print 212 5) ; "You notice two secret panels in the chamber walls."
				)
			)
		)
	)
)

