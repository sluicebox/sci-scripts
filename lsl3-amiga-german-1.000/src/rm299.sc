;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 299)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	rm299 0
)

(instance rm299 of Locale
	(properties)

	(method (init)
		(super init:)
		(if
			(not
				(OneOf
					gPrevRoomNum
					200
					203
					210
					213
					216
					220
					230
					235
					240
					245
					250
					253
					300
					305
					310
				)
			)
			(gMusic stop: number: 299 loop: gBgMusicLoops play:)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'talk,talk/man,couple,woman')
				(Print 299 0) ; "No one here is interested in talking to you."
			)
			((Said 'cut,cut,get,get/blade')
				(Print 299 1) ; "This grass is unsuitable for your needs."
			)
			((Said '/cab')
				(Print 299 2) ; "There are no taxis in this "Leisure Suit Larry.""
			)
			((Said '/auto,auto')
				(Print 299 3) ; "At least "Natives, Inc.\05" did something right: to "maintain that native island feeling" they banned vehicular traffic from the island; everyone walks everywhere."
				(Print 299 4 #at -1 144) ; "Including you!)"
			)
			((Said 'climb/palm')
				(Print 299 5) ; "These ARE wonderful trees, but that's not something you should do right now."
			)
			((Said 'drain,(get<off)/sandal')
				(Printf ; "You'd love to, but you'd %s!"
					299
					6
					(if gEgoIsPatti
						{rip your nylons}
					else
						{get your white socks dirty}
					)
					(if gEgoIsPatti
						{die Str\81mpfe zerrei\e1en}
					else
						{die wei\e1en Socken schmutzig machen}
					)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '/up,air')
						(Print 299 7) ; "The air blows in off the lagoon crisp and clean, bringing a slight taste of salt and the aroma of diesel slicks."
					)
					((Said '/auto,camp')
						(Print 299 8) ; "How nice it is that automobiles were never allowed here on the island! Everyone does aerobic walking all the time!"
					)
					((Said '/carpet')
						(Print 299 9) ; "The bare dirt feels good under your feet."
					)
					((Said '/palm,bush')
						(Print 299 10) ; "This warm tropical weather makes everything grow."
					)
				)
			)
		)
	)
)

