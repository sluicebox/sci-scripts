;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 156)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	office 0
)

(instance office of Locale
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'look,read/board')
				(Print 156 0) ; "Looking at the bulletin board you think, "Humm, nothing of interest here.""
			)
			((Said 'look>')
				(cond
					((Said '/file,cabinet')
						(Print 156 1) ; "The file cabinet contains many reports, case histories, and other police stuff."
					)
					((Said '[<(through,out)]/pane')
						(Print 156 2) ; "You note fair weather as you look through the window."
					)
					((Said '/map')
						(Print 156 3) ; "A map of Lytton hangs on the wall."
					)
					(
						(or
							(Said '[<below][/desk]')
							(Said '[<up,at][/ceiling]')
							(Said '[<down,at][/floor]')
							(Said '/man,woman')
						)
						(Print 156 4) ; "You don't see anything interesting."
					)
					((Said '/phone')
						(Print 156 5) ; "It's just a standard office phone."
					)
					((Said '/bench')
						(Print 156 6) ; "Not the best, but it beats sitting on the floor."
					)
					((Said '/wall')
						(Print 156 7) ; "You see a bulletin board and map."
					)
					(
						(Said
							'/book,(bookcase<book),(briefcase<book),bookcase,bookcase'
						)
						(Print 156 8) ; "The bookshelf is filled with volumes of departmental manuals. The material would bore you to tears."
					)
					((Said '/flyer,painting')
						(Print 156 9) ; "Looking at the peaceful, relaxing poster of the South Sea Isles almost throws your brain into neutral."
					)
				)
			)
			((Said '/hello[/!*]')
				(Print 156 10) ; "Hi, Sonny."
			)
			((Said 'turn<on/lamp,light')
				(Print 156 11) ; "There's plenty of light in here already."
			)
			((Said 'use,dial,pick[<up]/phone')
				(Print 156 12) ; "Go to your desk to use a phone."
			)
			((Said 'answer/phone')
				(Print 156 13) ; "It isn't ringing."
			)
			((Said 'turn/lamp')
				(Print 156 14) ; "You're wasting your time."
			)
			((Said 'climb/desk')
				(Print 156 15) ; "There is no reason to climb the desk"
			)
			((Said 'sat[<on]/bench,desk')
				(Print 156 16) ; "There is a chair and desk especially designated for you, but this isn't it."
			)
			((Said 'open/pane')
				(Print 156 17) ; "The air conditioner works fine."
			)
			((Said 'get/flyer,painting,book,newspaper,garbage,book')
				(Print 156 18) ; "It wouldn't help you."
			)
			((or (Said 'talk') (Said '/hello'))
				(proc0_7) ; "You're not close enough."
			)
		)
	)
)

