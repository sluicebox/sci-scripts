;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm81 0
)

(instance rm81 of Locale
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said '/hair')
				(Print 81 0) ; "You'd like to run your fingers thru his hair!"
			)
			((Said '/larry')
				(Print 81 1) ; "The clerk doesn't know where Larry is any more than you do, Patti!"
			)
			((Said 'give')
				(Printf 81 2 gEgoName gEgoName) ; "The clerk is not interested in anything you have to offer, %s."
			)
			((or (Said '//buffet,buffet') (Said '/buffet,buffet'))
				(Print 81 3) ; "There is a clerk behind the counter."
			)
			((Said '/face,eye')
				(Print 81 4) ; "You remember his lips against your's."
			)
		)
	)
)

