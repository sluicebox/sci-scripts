;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm80 0
)

(instance rm80 of Locale
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said '/hair')
				(Print 80 0) ; "You see a man with dark hair."
			)
			((Said '/entertainer')
				(Print 80 1) ; "He can't help you with Patti."
				(if (>= gFilthLevel 3)
					(Print 80 2 #at -1 144) ; "(...although he has had her!)"
				)
			)
			((Said 'give')
				(Printf 80 3 gEgoName gEgoName) ; "The clerk is not interested in anything you have to offer, %s.%"
			)
			((or (Said '//buffet,buffet') (Said '/buffet,buffet'))
				(Print 80 4) ; "There is a clerk behind the counter."
			)
			((Said '/man')
				(Print 80 5) ; "He seems to really enjoy his job."
				(Print 80 6 #at -1 144) ; "(You remember feeling that way once!)"
			)
			((Said '/face,eye')
				(Print 80 7) ; "He's an ugly dude."
			)
		)
	)
)

