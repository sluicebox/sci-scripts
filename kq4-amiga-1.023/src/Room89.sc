;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 89)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room89 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 0)
	(for
		((= local4 (gInventory first:)))
		local4
		((= local4 (gInventory next: local4)))
		
		(if (and (= local5 (NodeValue local4)) (== (local5 owner:) 89))
			(= temp0 1)
		)
	)
	(return temp0)
)

(instance Room89 of Rm
	(properties
		picture 89
		style 16
	)

	(method (init)
		(Load rsVIEW 606)
		(Load rsVIEW 649)
		(Load rsVIEW 634)
		(Load rsVIEW 512)
		(self setRegions: 604) ; regBFCastle
		(super init:)
		((View new:)
			view: 634
			loop: 1
			cel: 0
			posn: 57 88
			setPri: 6
			init:
			addToPic:
		)
		(if gNight
			((Prop new:)
				view: 512
				loop: 0
				posn: 59 76
				setPri: 6
				init:
				setCycle: Fwd
			)
			((View new:)
				view: 649
				loop: 2
				cel: 0
				posn: 264 105
				setPri: 7
				init:
				addToPic:
			)
		)
		((= local0 (Prop new:))
			view: 606
			loop: 0
			posn: 241 108
			init:
			setPri: 8
			stopUpd:
		)
		((= local1 (Prop new:))
			view: 606
			posn: 76 108
			loop: 1
			init:
			setPri: 8
			stopUpd:
		)
		((= local2 (View new:))
			view: 606
			posn: 222 108
			loop: 2
			cel: 0
			ignoreActors: 1
			init:
			stopUpd:
		)
		(if (not (= local7 (localproc_0)))
			(local2 cel: 2 forceUpd:)
		)
		((= local3 (View new:))
			view: 606
			posn: 96 108
			loop: 2
			cel: 1
			ignoreActors: 1
			init:
			stopUpd:
		)
		(if (or (== gPrevRoomNum 91) (== gPrevRoomNum 0))
			(gEgo posn: 38 151 view: 4 xStep: 4 yStep: 2 init:)
			(if global175
				(= global175 0)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 91)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					(
						(or
							(Said 'look[<around][/!*]')
							(Said 'look/room,castle,kitchen')
						)
						(Print 89 0) ; "You have discovered the castle's kitchen. Not a very pleasant kitchen, but a kitchen nonetheless. Against the back wall, two cabinets flank a cold stone fireplace. You see a long table under the one small window."
					)
					((Said 'look>')
						(cond
							((Said '<in/cabinet')
								(if
									(or
										(< (gEgo distanceTo: local0) 25)
										(< (gEgo distanceTo: local1) 25)
									)
									(if (< (gEgo distanceTo: local0) 25)
										(if (== (local0 cel:) 0)
											(local0 setCycle: End rightCabinet)
										)
										(if local7
											(Print 89 1) ; "Here are all of your possessions!"
										else
											(Print 89 2) ; "The cabinet is empty."
										)
									)
									(if (< (gEgo distanceTo: local1) 25)
										(if (== (local1 cel:) 0)
											(local1 setCycle: End leftCabinet)
										)
										(Print 89 3) ; "The cabinet is full of dishes."
									)
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							((Said '/cabinet')
								(Print 89 4) ; "You see two cabinets; one on each side of the stone fireplace."
							)
							((Said '<under/table')
								(Print 89 5) ; "There's nothing under the table."
							)
							((Said '/table')
								(Print 89 6) ; "Nothing on the table interests you."
							)
							((Said '/fireplace')
								(Print 89 7) ; "The fireplace is unlit and cold. An empty iron pot sits in it."
							)
							((Said '/caldron')
								(Print 89 8) ; "The iron pot in the fireplace is empty."
							)
							((Said '/barrel')
								(Print 89 9) ; "There is nothing of interest in the barrel."
							)
							((Said '/wall')
								(Print 89 10) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 89 11) ; "There is nothing of importance on the floor."
							)
							((Said '/window')
								(if (gEgo inRect: 220 124 282 146)
									(Print 89 12) ; "You see the mountain out the window."
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							((Said '/door')
								(Print 89 13) ; "You see an open doorway before you."
							)
						)
					)
					((Said 'open>')
						(cond
							((Said '/barrel')
								(Print 89 14) ; "There is nothing in the barrel."
							)
							((Said '/window')
								(Print 89 15) ; "The windows do not open."
							)
							((Said '/cabinet,door')
								(cond
									((gEgo inRect: 210 123 249 133)
										(if (== (local0 cel:) 0)
											(local0 setCycle: End rightCabinet)
											(if local7
												(Print 89 16) ; "Here are all your possessions!"
											else
												(Print 89 2) ; "The cabinet is empty."
											)
										else
											(Print 89 17) ; "It appears open already."
										)
									)
									((gEgo inRect: 74 122 100 133)
										(if (== (local1 cel:) 0)
											(local1 setCycle: End leftCabinet)
											(Print 89 3) ; "The cabinet is full of dishes."
										else
											(Print 89 17) ; "It appears open already."
										)
									)
									(else
										(Print 800 1) ; "You're not close enough."
									)
								)
							)
						)
					)
					((Said 'close/cabinet,door')
						(cond
							((< (gEgo distanceTo: local0) 25)
								(if (local0 cel:)
									(local0 setCycle: Beg rightCabinet)
								else
									(Print 89 18) ; "It already is closed."
								)
							)
							((< (gEgo distanceTo: local1) 25)
								(if (local1 cel:)
									(local1 setCycle: Beg leftCabinet)
								else
									(Print 89 18) ; "It already is closed."
								)
							)
							(else
								(Print 800 1) ; "You're not close enough."
							)
						)
					)
					((Said 'break/window')
						(Print 89 19) ; "That would not accomplish anything."
					)
					((Said 'get>')
						(cond
							((Said '/caldron')
								(Print 89 20) ; "You don't need it."
							)
							((Said '/dish')
								(if (not (local1 cel:))
									(Print 89 21) ; "The cabinet is closed."
								else
									(Print 89 22) ; "You have no need of dishes."
								)
							)
							((Said '/all,possessions,inventory')
								(cond
									((not local7)
										(Print 89 2) ; "The cabinet is empty."
									)
									((not (local0 cel:))
										(Print 89 21) ; "The cabinet is closed."
									)
									((> (gEgo distanceTo: local0) 25)
										(Print 800 1) ; "You're not close enough."
									)
									(else
										(= local6 1)
										(for
											((= local4 (gInventory first:)))
											local4
											((= local4 (gInventory next: local4)))
											
											(if
												(and
													(= local5
														(NodeValue local4)
													)
													(== (local5 owner:) 89)
												)
												(local5 owner: gEgo)
												(= local6 0)
											)
										)
										(if (not local6)
											(gGame changeScore: 4)
											(local2
												loop: 2
												cel: 2
												startUpd:
												forceUpd:
											)
											(= global182 1)
											(= local7 0)
										else
											(Print 89 2) ; "The cabinet is empty."
										)
										(local2 stopUpd:)
									)
								)
							)
							(
								(and
									local7
									(< (gEgo distanceTo: local0) 25)
									(!= (local0 cel:) (- (NumCels local0) 1))
								)
								(Print 89 23) ; "Why don't you get everything?"
								(event claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance rightCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0 stopUpd:)
				(= state -1)
			)
		)
	)
)

(instance leftCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 stopUpd:)
				(= state -1)
			)
		)
	)
)

