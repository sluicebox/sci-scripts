;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Interface)
(use Game)

(public
	rm70 0
)

(instance rm70 of Locale
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'embrace')
					(Said '/embrace')
					(Said '//embrace')
					(Said '/coconut')
					(Said '//coconut')
					(Said '/boob')
					(Said '//boob')
				)
				(Print 70 0) ; "That's ONE thing you're hoping for!"
			)
			((Said '/ass')
				(Print 70 1) ; "Round, firm, fully-packed! So easy on the draw!"
			)
			((Said '/bracelet')
				(Print 70 2) ; "Her hands are lovely, but it's not her hands you're interested in!"
			)
			((Said '/body')
				(Print 70 3) ; "Another perfect 10! How can all the women on this island be so beautiful?"
			)
			((Said '/ankle')
				(Print 70 4) ; "You dream of starting there and working your way to the top!"
			)
			((Said '/hair')
				(Print 70 5) ; "You wonder if it smells as good as it looks!"
			)
			((Said '/ear')
				(Print 70 6) ; "You can picture yourself whispering sweet nothings into that beautiful, shell-shaped orifice!"
			)
			((Said '/nose')
				(Print 70 7) ; "It busily exchanges moisture-laden carbon dioxide for fresh oxygen-enriched atmosphere."
				(Print 70 8 #at -1 144) ; "(In other words, she's still breathing, Larry!)"
			)
			((Said '/lip,lip')
				(Print 70 9) ; "You imagine your tongue winding its way around those pearly whites!"
			)
			((Said '/eye')
				(Print 70 10) ; "You stare deeply into her eyes. She loves it."
			)
			((Said '/dicklicker')
				(Print 70 11) ; "You love the way her tongue moves around her lips."
			)
		)
	)
)

