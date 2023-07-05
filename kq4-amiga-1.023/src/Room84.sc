;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room84 0
)

(local
	local0
	local1
)

(instance chickenMusic of Sound
	(properties
		number 79
		priority 15
		loop -1
	)
)

(instance Room84 of Rm
	(properties
		picture 84
		style 16
	)

	(method (init)
		(self setRegions: 604) ; regBFCastle
		(Load rsVIEW 360)
		(Load rsVIEW 519)
		(Load rsVIEW 649)
		(Load rsVIEW 634)
		(Load rsVIEW 512)
		(Load rsVIEW 40)
		(Load rsSOUND 79)
		(super init:)
		((View new:)
			view: 634
			loop: 1
			cel: 0
			posn: 31 77
			setPri: 4
			init:
			addToPic:
		)
		((View new:)
			view: 634
			loop: 1
			cel: 0
			posn: 71 78
			setPri: 4
			init:
			addToPic:
		)
		(if gNight
			((View new:)
				view: 649
				loop: 1
				posn: 102 66
				setPri: 3
				init:
				addToPic:
			)
			((View new:)
				view: 649
				loop: 1
				posn: 138 66
				setPri: 3
				init:
				addToPic:
			)
			((View new:)
				view: 649
				loop: 1
				posn: 177 66
				setPri: 3
				init:
				addToPic:
			)
			((View new:)
				view: 649
				loop: 1
				posn: 215 66
				setPri: 3
				init:
				addToPic:
			)
			((Prop new:)
				view: 512
				loop: 0
				posn: 33 65
				setPri: 3
				init:
				setCycle: Fwd
			)
			((Prop new:)
				view: 512
				loop: 0
				posn: 73 66
				setPri: 3
				init:
				setCycle: Fwd
			)
		)
		(if (== ((gInventory at: 4) owner:) 84) ; Pandora_s_Box
			((= local0 (View new:))
				view: 519
				ignoreActors: 0
				posn: 200 135
				init:
			)
		)
		(if (== ((gInventory at: 33) owner:) 84) ; Magic_Hen
			((= local1 (Act new:))
				view: 360
				illegalBits: 0
				posn: 80 133
				init:
				setScript: henPacing
			)
			(chickenMusic init: play:)
		)
		(if (or (== gPrevRoomNum 87) (== gPrevRoomNum 0))
			(gEgo posn: 157 162 view: 4 xStep: 4 yStep: 2 init:)
			(if global175
				(= global175 0)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 87)
		)
	)

	(method (handleEvent event &tmp [temp0 80])
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((or (Said 'look[<around][/!*]') (Said 'look/room'))
						(Print 84 0) ; "This seems to be some sort of storage room."
						(cond
							(
								(and
									(== ((gInventory at: 4) owner:) 84) ; Pandora_s_Box
									(== ((gInventory at: 33) owner:) 84) ; Magic_Hen
								)
								(Print 84 1) ; "And guess what's stored here... Yes, Pandora's Box and the magic hen!!"
							)
							((== ((gInventory at: 33) owner:) 84) ; Magic_Hen
								(Print 84 2) ; "And guess what's stored here... Yes, the magic hen!"
							)
							((== ((gInventory at: 4) owner:) 84) ; Pandora_s_Box
								(Print 84 3) ; "And guess what's stored here... Yes, Pandora's Box!"
							)
							(else
								(Print 84 4) ; "What did you come in here for?"
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/box')
								(Print 84 5) ; "There is nothing of interest in the boxes."
							)
							((Said '/barrel')
								(Print 84 6) ; "There is nothing of interest in the barrels."
							)
							((Said '/chest')
								(Print 84 7) ; "There is nothing of interest in the chest."
							)
							((Said '/shelf')
								(Print 84 8) ; "There is nothing useful on the shelves."
							)
							((Said '/bone')
								(Print 84 9) ; "You don't need any bones now."
							)
							((Said '/window')
								(Print 84 10) ; "The windows are too high."
							)
							((Said '/wall')
								(Print 84 11) ; "There is nothing of interest on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 84 12) ; "There is nothing of interest on the floor."
							)
							((Said '/chicken')
								(if (== ((gInventory at: 33) owner:) 84) ; Magic_Hen
									(Print 84 13) ; "The hen is wandering around the room."
								else
									(Print 84 14 #at -1 10) ; "There's no hen here."
								)
							)
						)
					)
					((Said 'get>')
						(cond
							((Said '/box<pandora')
								(cond
									((gEgo has: 4) ; Pandora_s_Box
										(Print 800 0) ; "You already took it."
									)
									((!= ((gInventory at: 4) owner:) 84) ; Pandora_s_Box
										(Print 84 15) ; "It's not here."
									)
									((< (gEgo distanceTo: local0) 20)
										(gEgo get: 4) ; Pandora_s_Box
										(gGame changeScore: 2)
										(egoPickUp changeState: 0)
										(local0 dispose:)
									)
									(else
										(Print 800 1) ; "You're not close enough."
									)
								)
							)
							((Said '/chicken')
								(cond
									((gEgo has: 33) ; Magic_Hen
										(Print 84 16) ; "You already have it."
									)
									((!= ((gInventory at: 33) owner:) 84) ; Magic_Hen
										(Print 84 15) ; "It's not here."
									)
									((< (gEgo distanceTo: local1) 20)
										(chickenMusic dispose:)
										(gEgo get: 33) ; Magic_Hen
										(gGame changeScore: 2)
										(egoPickUp changeState: 0)
										(local1 dispose:)
									)
									(else
										(Print 800 1) ; "You're not close enough."
									)
								)
							)
							((Said '/box')
								(Print 84 5) ; "There is nothing of interest in the boxes."
							)
							((Said '/chest')
								(Print 84 7) ; "There is nothing of interest in the chest."
							)
							((Said 'open/window')
								(Print 84 17) ; "The windows do not open."
							)
							((Said 'break/window')
								(Print 84 18) ; "That would not accomplish anything."
							)
							((Said '/bone')
								(Print 84 9) ; "You don't need any bones now."
							)
						)
					)
					((Said 'open>')
						(cond
							((Said '/box<pandora')
								(event claimed: 0)
							)
							((Said '/box')
								(Print 84 5) ; "There is nothing of interest in the boxes."
							)
							((Said '/barrel')
								(Print 84 6) ; "There is nothing of interest in the barrels."
							)
							((Said '/chest')
								(Print 84 7) ; "There is nothing of interest in the chest."
							)
						)
					)
				)
			)
		)
	)
)

(instance egoPickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global182 1)
				(User canControl: 0 canInput: 0)
				(gEgo view: 40 cel: 255 setMotion: 0 setCycle: End self)
			)
			(1
				(gEgo view: 4 setCycle: Walk)
				(User canControl: 1 canInput: 1)
			)
		)
	)
)

(instance henPacing of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCast contains: local1)
					(local1 loop: (+ (local1 loop:) 2) setCycle: End self)
				)
			)
			(1
				(if (gCast contains: local1)
					(local1
						setCycle: Walk
						setMotion:
							MoveTo
							(if (> (local1 x:) 87)
								(Random 67 85)
							else
								(Random 90 120)
							)
							134
							self
					)
				)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

