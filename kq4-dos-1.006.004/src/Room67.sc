;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	Room67 0
)

(local
	local0
	local1
)

(instance Room67 of Rm
	(properties
		picture 67
		style 16
	)

	(method (init)
		(Load rsVIEW 510)
		(self setRegions: 603) ; regHauntedHouse
		(super init:)
		(= gIndoors 1)
		(if gNight
			((Prop new:)
				view: 536
				loop: 1
				cel: 0
				ignoreActors: 1
				posn: 205 129
				init:
				setPri: 12
				setCycle: Fwd
			)
		)
		(if (== gPrevRoomNum 66)
			(gEgo posn: 85 123 view: 4 xStep: 4 yStep: 2 init:)
		)
		(if (== gPrevRoomNum 68)
			(gEgo posn: 264 130 view: 4 xStep: 4 yStep: 2 init:)
		)
		(if (== ((gInventory at: 18) owner:) 67) ; Shakespeare_Book
			((= local0 (View new:))
				view: 510
				loop: 0
				cel: 0
				posn: 207 74
				stopUpd:
				init:
			)
		)
		((= local1 (Prop new:))
			view: 510
			loop: 2
			cel: 0
			ignoreActors: 1
			stopUpd:
			posn: 74 101
			init:
			setPri: 8
		)
		(if global131
			(local1 setCel: 255 stopUpd:)
			(gEgo illegalBits: -32768)
		else
			(gEgo illegalBits: -32764)
		)
		(if (and (< 0 global134 255) (== global133 gCurRoomNum))
			(Notify 603 -1)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gEgo illegalBits: -32768)
			(gCurRoom newRoom: 68)
		)
		(if (and (& (gEgo onControl: 1) $0004) global131)
			(gEgo illegalBits: -32768)
			(gCurRoom newRoom: 66)
		)
		(if (and (& (gEgo onControl:) $0020) global131)
			(gEgo setPri: 8)
		else
			(gEgo setPri: -1)
		)
	)

	(method (newRoom newRoomNumber)
		(gEgo setPri: -1)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((or (Said 'look[<around][/!*]') (Said 'look/room,parlor'))
						(Print 67 0) ; "Considering the disarray of the rest of the house, the parlor looks in relatively good order. However, the fireplace is cold and unused, the bookshelves are almost bare, and the old furnishings are dusty."
					)
					((Said 'look>')
						(cond
							((and (gEgo has: 18) (Said '/book')) ; Shakespeare_Book
								((gInventory at: 18) showSelf:) ; Shakespeare_Book
							)
							((Said '/book,shelf,bookshelf')
								(if (> (gEgo x:) 160)
									(if (== ((gInventory at: 18) owner:) 67) ; Shakespeare_Book
										(Print 67 1) ; "You examine the few remaining books on the bookshelves. Only one catches your attention; it is entitled "The Compleat Works of William Shakespeare.""
										(= global128 1)
									else
										(Print 67 2) ; "You examine the few remaining books on the bookshelves. None interest you."
									)
								else
									(Print 67 3) ; "You examine the books on this side of the room. None of these books are up the quality of reading you're used to..."
								)
							)
							((Said '<behind,under/painting')
								(Print 67 4) ; "The portrait is firmly attached to the wall."
							)
							((Said '/painting')
								(Print 67 5) ; "An interesting portrait of a young girl hangs above the fireplace. You gaze at it intently, and notice that her eyes seem to stare at the left wall of the parlor."
								(= global129 1)
							)
							((Said '/wall<left')
								(cond
									(global131
										(Print 67 6) ; "You see a secret door in the left wall."
									)
									(global129
										(Print 67 7) ; "You examine the left wall very closely and notice a little latch."
										(= global130 1)
									)
									(else
										(Print 67 8) ; "You see nothing special on the wall."
									)
								)
							)
							((Said '/wall<right')
								(Print 67 9) ; "You see the doorway to the foyer."
							)
							((Said '/wall')
								(cond
									(global131
										(Print 67 6) ; "You see a secret door in the left wall."
									)
									(global129
										(Print 67 7) ; "You examine the left wall very closely and notice a little latch."
										(= global130 1)
									)
									(else
										(Print 67 10) ; "You see a portrait hanging above the fireplace."
									)
								)
							)
							((Said '/latch')
								(cond
									(global131
										(Print 67 11) ; "You don't see it now."
									)
									(global129
										(if global130
											(if (& (gEgo onControl:) $0020)
												(Print 67 12) ; "You could try flipping the little latch in the left wall."
											else
												(Print 67 13) ; "From there, you can barely see the latch in the wall."
											)
										)
									)
									(else
										(Print 67 14) ; "You don't see a latch."
									)
								)
							)
							((Said '<in/fireplace')
								(Print 67 15) ; "The fireplace is empty."
							)
							((Said '/fireplace')
								(Print 67 16) ; "The fireplace hasn't been used in years."
							)
							((Said '/chandelier')
								(Print 67 17) ; "The lamp is old and dusty."
							)
							((Said '/couch')
								(Print 67 18) ; "The old divan is still in pretty good shape; a bit dusty, though."
							)
							((Said '/door')
								(if global131
									(Print 67 19) ; "You have discovered a secret door in the left wall!"
								else
									(Print 67 20) ; "You see no special doors."
								)
							)
							((Said '/cabinet,cabinet')
								(Print 67 21) ; "There is nothing of interest in the dusty old cabinet."
							)
							((Said '/table,chair,chest,furniture')
								(Print 67 22) ; "The furniture is old and dusty."
							)
							((or (Said '/dirt,carpet,carpet') (Said '<down'))
								(Print 67 23) ; "An old oriental carpet lies on the floor."
							)
						)
					)
					((Said 'find/door')
						(if global131
							(Print 67 19) ; "You have discovered a secret door in the left wall!"
						else
							(Print 67 20) ; "You see no special doors."
						)
					)
					((Said 'sit')
						(Print 67 24) ; "You don't have time for that!"
					)
					((or (Said 'get/book') (Said 'get/shakespeare'))
						(cond
							((gEgo inRect: 83 119 127 127)
								(Print 67 25) ; "There are no books here you need."
							)
							((& (gEgo onControl:) $0010)
								(cond
									((!= ((gInventory at: 18) owner:) 67) ; Shakespeare_Book
										(Print 67 26) ; "None of the other books interest you."
									)
									(global128
										(Print 67 27) ; "You remove the Shakespeare book from the shelf and carry it with you."
										(gEgo get: 18) ; Shakespeare_Book
										(gGame changeScore: 2)
										(local0 dispose:)
										(= global182 1)
									)
									(else
										(Print 67 28) ; "You examine the few remaining books on the bookshelves. Only one catches your attention; it is entitled "The Compleat Works of William Shakespeare." You remove it from the shelf and carry it with you."
										(gEgo get: 18) ; Shakespeare_Book
										(= global182 1)
										(gGame changeScore: 2)
										(local0 dispose:)
									)
								)
							)
							(else
								(Print 800 1) ; "You're not close enough."
							)
						)
					)
					((Said 'get/painting')
						(Print 67 4) ; "The portrait is firmly attached to the wall."
					)
					((Said 'open/door')
						(if global131
							(Print 67 29) ; "The secret door is already open."
						else
							(Print 67 30) ; "You don't see a door to open."
						)
					)
					((Said 'open/cabinet,cabinet')
						(Print 67 21) ; "There is nothing of interest in the dusty old cabinet."
					)
					((Said 'close/door')
						(if global131
							(Print 67 31) ; "You don't need to close the door."
						else
							(Print 67 32) ; "There is no door to close!"
						)
					)
					((Said 'flip,pull,lift/latch')
						(if global130
							(cond
								(global131
									(Print 67 33) ; "There's no need for that."
								)
								((& (gEgo onControl:) $0020)
									(Print 67 34) ; "You flip the latch in the wall--and behold!--you have discovered a secret door!"
									(gEgo setMotion: 0)
									(local1 setCycle: End)
									(= global131 1)
									(gGame changeScore: 4)
									(gEgo illegalBits: -32768)
								)
								(else
									(Print 800 1) ; "You're not close enough."
								)
							)
						else
							(Print 67 14) ; "You don't see a latch."
						)
					)
				)
			)
		)
	)
)

