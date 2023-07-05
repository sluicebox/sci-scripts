;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room63 0
)

(local
	local0
	local1
	local2
	local3
)

(instance Room63 of Rm
	(properties
		picture 63
		style 16
	)

	(method (init)
		(Load rsPIC 60)
		(Load rsVIEW 44)
		(Load rsVIEW 40)
		(Load rsVIEW 77)
		(Load rsVIEW 42)
		(Load rsVIEW 537)
		(Load rsVIEW 529)
		(Load rsVIEW 648)
		(Load rsSCRIPT 991)
		(Load rsSOUND 52)
		(self setRegions: 603) ; regHauntedHouse
		(super init:)
		((View new:) view: 648 loop: 5 cel: 0 posn: 280 105 setPri: 6 addToPic:)
		((Prop new:)
			view: 536
			loop: 1
			cel: 0
			posn: 224 124
			init:
			setPri: 15
			setCycle: Fwd
		)
		((View new:) view: 537 loop: 3 cel: 0 posn: 167 126 addToPic:)
		((= local1 (Prop new:))
			view: 537
			loop: 0
			cel: 0
			posn: 167 116
			init:
			stopUpd:
		)
		((View new:)
			view: 537
			loop: 1
			cel: 0
			posn: 165 158
			setPri: 11
			ignoreActors: 1
			addToPic:
		)
		(if (== global134 5)
			(Load rsVIEW 209)
		)
		(gEgo setScript: climbIn)
		(if (and (< 0 global134 255) (== global133 gCurRoomNum))
			(Notify 603 -1)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl: 1) $0004) (not (gEgo script:)))
			(gEgo setScript: fallDead)
		)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said '/box')
						(Print 63 0) ; "There is nothing of interest in the old boxes."
					)
					((Said 'get,open,look/birdcage,birdcage')
						(Print 63 1) ; "It's just an old bird cage...nothing interesting there."
					)
					((Said 'look>')
						(cond
							((Said '<in/chest')
								(if (gEgo inRect: 141 120 193 129)
									(gEgo setMotion: 0)
									(cond
										((not local0)
											(if (== global134 5)
												(Print 63 2) ; "The top of the wooden chest is currently occupied by a naughty little ghost."
											else
												(Print 63 3) ; "The wooden chest is not open."
											)
										)
										((== ((gInventory at: 26) owner:) 63) ; Sheet_Music
											(Print 63 4) ; "You peek into the open chest, and find...an old set of sheet music! You take the sheet music and carry it with you."
											(gEgo get: 26) ; Sheet_Music
											(= global182 1)
											(gGame changeScore: 2)
										)
										(else
											(Print 63 5) ; "You peek into the open chest, and find...nothing."
										)
									)
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							((Said '/chest')
								(if (== global134 5)
									(Print 63 2) ; "The top of the wooden chest is currently occupied by a naughty little ghost."
								else
									(Print 63 6) ; "An interesting wooden chest catches your attention."
								)
							)
							((Said '<in/trapdoor')
								(if (gEgo inRect: 135 138 182 148)
									(Print 63 7) ; "You can see into the room below. There's nothing there."
								else
									(Print 63 8) ; "You can't see from here."
								)
							)
							((or (Said '/trapdoor') (Said '<down'))
								(Print 63 9) ; "The trapdoor in the attic floor is open. From it, a ladder leads to the room below."
							)
							((Said '/ladder')
								(Print 63 10) ; "A ladder descends from the open trapdoor into the room below."
							)
							((Said '/window')
								(Print 63 11) ; "You see the cemetery out the window."
							)
							((Said '/junk')
								(Print 63 12) ; "The old junk is useless."
							)
							((Said '/wall')
								(Print 63 13) ; "There is nothing of importance on the walls."
							)
							((Said '/dirt')
								(Print 63 14) ; "There is nothing of interest on the floor."
							)
							((Said '/ghost')
								(if (== global133 gCurRoomNum)
									(Print 63 15) ; "The little boy ghost laughs, and refuses to budge from his seat on top of the chest. It might help if he had a toy to play with."
								else
									(Print 63 16) ; "What ghost?"
								)
							)
							((Said '[<around][/room]')
								(Print 63 17) ; "After adjusting your eyes to the gloom, you soon see that you have stumbled upon the musty attic of the old house. The trapdoor in the floor is open, and from it, a ladder leads down to the room below. Useless junk and boxes clutter the room. There is an interesting chest near the open trapdoor."
							)
						)
					)
					((Said 'climb[/ladder,down]')
						(if (gEgo inRect: 131 138 205 159)
							(gEgo setScript: climbDown)
						else
							(Print 800 1) ; "You're not close enough."
						)
					)
					((Said 'close/trapdoor')
						(Print 63 18) ; "There is no need to do that."
					)
					((Said 'open/trapdoor')
						(Print 63 19) ; "The trapdoor is already open."
					)
					((Said 'get/chest')
						(Print 63 20) ; "The chest is too heavy. You cannot carry it."
					)
					((Said 'get,pull,detach/ghost')
						(if (== global133 gCurRoomNum)
							(Print 63 21) ; "You're afraid to get too near the ghost."
						else
							(Print 63 16) ; "What ghost?"
						)
					)
					((Said 'close/chest')
						(if local0
							(local1 setCycle: Beg)
							(= local0 0)
						else
							(Print 63 22) ; "The chest is already closed."
						)
					)
					((Said 'open/chest')
						(cond
							(local0
								(Print 63 23) ; "The chest is already open."
							)
							((== global134 5)
								(Print 63 24) ; "The boy ghost laughs and teases, and refuses to leave his spot on top of the chest."
							)
							((gEgo inRect: 141 120 193 129)
								(gEgo setMotion: 0)
								(local1 setCycle: End)
								(= local0 1)
							)
							(else
								(Print 800 1) ; "You're not close enough."
							)
						)
					)
				)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 196 149 self)
			)
			(1
				(gEgo
					setMotion: 0
					view: 40
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo view: 77 loop: 2 cel: 0 setPri: 12 setCycle: End self)
			)
			(3
				(= global204 0)
				(= global205 1)
				(gCurRoom newRoom: 60)
			)
		)
	)
)

(instance climbIn of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 196 151
					view: 77
					loop: 2
					setStep: 4 3
					setPri: 12
					setCycle: Beg self
					init:
				)
			)
			(1
				(gEgo
					view: 40
					loop: 1
					setStep: 4 1
					setPri: -1
					setCel: 255
					setCycle: Beg self
				)
			)
			(2
				(gEgo view: 4 setCycle: Walk illegalBits: -32768)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance fallDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((Sound new:) number: 52 play:)
				(gEgo
					view: 44
					illegalBits: 0
					ignoreActors: 1
					setPri:
						(if (>= (gEgo priority:) 12)
							11
						else
							(gEgo priority:)
						)
					setCycle: Fwd
					setStep: 5 5
					setLoop: (if (> (gEgo x:) 155) 1 else 0)
					setMotion: MoveTo 155 155 self
				)
			)
			(1
				(gEgo
					setLoop: (+ 2 (gEgo loop:))
					setMotion: MoveTo 155 222 self
				)
			)
			(2
				(gAddToPics eachElementDo: #dispose)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 60 6)
				((= local2 (View new:))
					view: 529
					loop: 1
					cel: 0
					posn: 161 138
					ignoreActors: 1
					addToPic:
				)
				((= local3 (View new:))
					view: 529
					loop: 0
					cel: 0
					posn: 161 34
					setPri: (- (local2 priority:) 1)
					addToPic:
				)
				(if gNight
					((View new:)
						view: 648
						loop: 1
						posn: 163 91
						setPri: 5
						addToPic:
					)
					((Prop new:)
						view: 536
						loop: 2
						posn: 267 76
						init:
						setPri: 13
						setCycle: Fwd
					)
				)
				(gEgo
					posn: 156 60
					setStep: 1 10
					show:
					setMotion: MoveTo 161 150 self
				)
			)
			(3
				(gEgo view: 40 setLoop: (- 2 (gEgo loop:)) setCel: 2)
				(= cycles 1)
			)
			(4
				(gSounds eachElementDo: #dispose)
				(gEgo view: 42)
				(RedrawCast)
				(ShakeScreen 10)
				(= seconds 5)
			)
			(5
				(= gDeathFlag 1)
			)
		)
	)
)

