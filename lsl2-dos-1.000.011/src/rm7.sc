;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Interface)
(use Sound)
(use Game)
(use Actor)

(public
	rm7 0
)

(instance rm7 of Rgn
	(properties)

	(method (init)
		(super init:)
		((View new:)
			view: 232
			loop: 0
			cel: 0
			posn: 102 147
			setPri: 8
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 232
			loop: 0
			cel: 1
			posn: 220 147
			setPri: 8
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 232
			loop: 1
			cel: 2
			posn: 119 124
			setPri: 8
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 232
			loop: 1
			cel: 3
			posn: 203 124
			setPri: 8
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 232
			loop: 1
			cel: 1
			posn: 127 112
			setPri: 7
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 232
			loop: 0
			cel: 2
			posn: 100 102
			setPri: 1
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 232
			loop: 0
			cel: 3
			posn: 208 106
			setPri: 1
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 232
			loop: 1
			cel: 4
			posn: 162 93
			setPri: 1
			ignoreActors:
			addToPic:
		)
		(Load rsSOUND 107)
		(theSound play:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/man,man,woman,children')
				(Print 7 0) ; "Nah. You've seen one barber, you've seen 'em all!"
			)
			(if (Said '/barstool')
				(Print 7 1) ; "It's a barber chair. Try sitting in it."
			)
			(if (Said '/buffet')
				(Print 7 2) ; "The tables have nothing but old, dirty magazines lying on them."
			)
			(if (Said '/cosmo')
				(Print 7 3) ; "Don't look. They're filled with pictures of naked women."
			)
			(if (Said '/carpet')
				(Print 7 4) ; "You see lots of hair."
			)
			(if (Said '/art,woman,art,brick')
				(Print 7 5) ; "You don't know much about art, but you know what you like!"
			)
			(if (Said '/mirror')
				(Print 7 6) ; "You see a barber shop. .pohs rebrab a ees uoY"
			)
			(if (Said '[/building,building,buffet,carpet,ceiling,airport]')
				(Print 7 7) ; "Don't all barber shops look the same?"
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 107
	)
)

