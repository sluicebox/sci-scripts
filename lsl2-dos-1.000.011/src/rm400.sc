;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm400 0
)

(instance rm400 of Rgn
	(properties)

	(method (init)
		(super init:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if
			(and
				(gEgo has: 18) ; Soap
				(or (Said 'clean,clean') (Said 'apply/soap'))
			)
			(Print 400 0) ; "You're already clean."
			(Print 400 1 #at -1 152) ; "(It's your mind that's dirty!)"
		)
		(if (and (gEgo has: 20) (Said 'smell/bush,flower')) ; Flower
			(Print 400 2) ; "It smells of native, ornithological, organic fertilizers."
		)
		(if (Said 'look>')
			(if (Said '/up,overhead,cloud')
				(Print 400 3) ; "Isn't the air here wonderful?"
			)
			(if (Said '/children,man,woman')
				(Print 400 4) ; "Everyone here appears to be even more wealthy than you, Larry."
			)
			(if (Said '/palm,bush,bush')
				(Print 400 5) ; "They are everywhere. Lush growth. Huge flowers."
				(Print 400 6) ; "This resort is really a beautiful place."
			)
		)
	)
)

