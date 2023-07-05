;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 699)
(include sci.sh)
(use Interface)
(use Game)

(public
	rm699 0
)

(instance rm699 of Locale
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'talk,talk/man,couple,woman')
				(Print 699 0) ; "No one here is interested in talking to you."
			)
			((Said 'drain,(get<off)/sandal')
				(Print 699 1) ; "You'd love to, but you'd rip your nylons!"
			)
			((Said '(look,look<up),look,look[/ceiling]')
				(Print 699 2) ; "The ceiling here reflects this building's industrial heritage."
			)
			((Said 'look,look/building,area')
				(Print 699 3) ; "Who decorated these sets, any way?"
			)
		)
	)
)

