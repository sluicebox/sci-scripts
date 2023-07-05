;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 499)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	rm499 0
)

(instance rm499 of Locale
	(properties)

	(method (init)
		(super init:)
		(if (not (OneOf gPrevRoomNum 400 410 415 416 420 460))
			(gMusic number: 499 loop: gBgMusicLoops play:)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'talk,talk/man,couple,woman')
				(Print 499 0) ; "No one here is interested in talking to you."
			)
			((Said 'drain,(get<off)/sandal')
				(Printf ; "You'd love to, but you'd %s!%"
					499
					1
					(and
						gEgoIsPatti
						{rip your nylons else \{get those white socks dirty}
					)
					(if gEgoIsPatti
						{Deine Str\81mpfe zerrei\e1en}
					else
						{Deine wei\e1en Socken schmutzig werden}
					)
				)
			)
			((Said 'gamble')
				(Print 499 2) ; "Nah, you'd just lose!"
			)
			((Said '/art,art')
				(Print 499 3) ; "This place is ostentatious enough for even YOUR taste."
			)
			((Said '(look,look<up),look,look[/ceiling]')
				(Print 499 4) ; "The ceiling in the casino is just as garish as the floor."
			)
			((Said '/casino,gambling,building')
				(Print 499 5) ; "You have no desire to gamble after your experiences in "Leisure Suit Larry in the Land of the Lounge Lizards.""
			)
			((Said 'look,look>')
				(cond
					((Said '/building,casino,area')
						(Print 499 6) ; "You are so sorry you didn't hire this interior decorator when you built your home!"
					)
					((Said '/auto,camp')
						(Print 499 7) ; "How nice it is that automobiles were never allowed here on the island! Everyone does aerobic walking all the time!"
					)
					((Said '/carpet')
						(Print 499 8) ; "This carpet was handmade by island virgins."
						(Print 499 9 #at -1 144) ; "(That's why it's now old and threadbare!)"
					)
				)
			)
			((Said '/casino')
				(Print 499 10) ; "Isn't this a fun place?"
			)
		)
	)
)

