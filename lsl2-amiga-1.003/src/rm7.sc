;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
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
		(gAddToPics
			add:
				aSeat1
				aSeat2
				aTable1
				aTable2
				aCoatRack
				aPainting
				aCalendar
				aCounter
			doit:
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

(instance aSeat1 of PV
	(properties
		y 146
		x 102
		view 232
		priority 8
		signal 16384
	)
)

(instance aSeat2 of PV
	(properties
		y 146
		x 220
		view 232
		cel 1
		priority 8
		signal 16384
	)
)

(instance aTable1 of PV
	(properties
		y 123
		x 119
		view 232
		loop 1
		cel 2
		priority 8
		signal 16384
	)
)

(instance aTable2 of PV
	(properties
		y 123
		x 203
		view 232
		loop 1
		cel 3
		priority 8
		signal 16384
	)
)

(instance aCoatRack of PV
	(properties
		y 111
		x 127
		view 232
		loop 1
		cel 1
		priority 7
		signal 16384
	)
)

(instance aPainting of PV
	(properties
		y 101
		x 100
		view 232
		cel 2
		priority 1
		signal 16384
	)
)

(instance aCalendar of PV
	(properties
		y 105
		x 208
		view 232
		cel 3
		priority 1
		signal 16384
	)
)

(instance aCounter of PV
	(properties
		y 92
		x 162
		view 232
		loop 1
		cel 4
		priority 1
		signal 16384
	)
)

