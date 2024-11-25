;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room51 0
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

(instance keyholeMusic of Sound
	(properties
		number 61
		priority 15
	)
)

(instance Room51 of Rm
	(properties
		picture 51
		style 16
	)

	(method (init)
		(= gIndoors 1)
		(= global189 1)
		(Load rsVIEW 2)
		(Load rsVIEW 614)
		(Load rsVIEW 647)
		(self setRegions: 602) ; regOgreHouse
		(super init:)
		(keyholeMusic init:)
		(if (and (gEgo has: 33) (< global165 5)) ; Magic_Hen
			(= global165 4)
		)
		(if (or (== gPrevRoomNum 49) (== gPrevRoomNum 0))
			(gEgo
				view: 2
				setStep: 3 2
				posn: 156 139
				illegalBits: $8000
				init:
			)
			((= local0 (Prop new:))
				view: 614
				loop: 0
				setCel: 255
				posn: 177 132
				ignoreActors: 0
				setPri: 8
				init:
				setCycle: Beg
			)
			((= local1 (View new:))
				view: 614
				setLoop: 1
				posn: 165 105
				init:
				hide:
			)
			(if (and global165 (< global165 5))
				(local1
					cel:
						(switch global165
							(1 0)
							(2 1)
							(3
								(if (gEgo has: 33) 3 else 2) ; Magic_Hen
							)
							(4 0)
						)
					setPri: 2
					show:
				)
			)
			(gEgo loop: 2 setMotion: 0)
		)
	)

	(method (dispose)
		(= global189 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'look>')
						(cond
							((Said '/keyhole')
								(if (== (local0 cel:) 0)
									(cond
										((not global166)
											(if
												(and
													(> global165 0)
													(!= global165 5)
												)
												(self setScript: theKeyhole)
											else
												(self setScript: emptyHole)
											)
										)
										((!= script theKeyhole)
											(self setScript: emptyHole)
										)
										(else
											(Print 51 0) ; "You're wasting time, Rosella."
										)
									)
								else
									(Print 51 1) ; "Why not just look out the open door?"
								)
							)
							((Said '/door')
								(Print 51 2) ; "There is a large keyhole under the doorknob of the closet door."
							)
							((Said '/wall')
								(Print 51 3) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 51 4) ; "There is nothing of importance on the floor."
							)
							((Said '[<around,at][/room,cottage,closet]')
								(Print 51 5) ; "You have found yourself inside the ogres' small closet. For a closet, it's surprisingly empty. You notice a large keyhole under the doorknob of the closet door."
							)
						)
					)
					((Said 'open/door,closet')
						(if (== (local0 cel:) 0)
							(if (or global166 (== global165 0) (== global165 5))
								(if (gEgo inRect: 134 131 169 141)
									(local0 setScript: doorOpen)
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(Print 51 6) ; "That would not be a good idea right now."
							)
						else
							(Print 51 7) ; "It's already open."
						)
					)
					((Said 'close/door')
						(if (local0 cel:)
							(local0 ignoreActors: 0 setCycle: Beg)
							(local1 hide:)
						else
							(Print 51 8) ; "It's already closed."
						)
					)
				)
			)
		)
	)
)

(instance theKeyhole of Script
	(properties)

	(method (init param1)
		(Load rsVIEW 70)
		(Load rsVIEW 251)
		(Load rsVIEW 252)
		(Load rsVIEW 253)
		(Load rsVIEW 254)
		(Load rsVIEW 255)
		(Load rsVIEW 647)
		(Load rsPIC 52)
		((= local2 (Prop new:))
			view: 251
			loop: 0
			cel: 1
			posn: 152 89
			init:
			hide:
		)
		((= local3 (Prop new:)) view: 251 loop: 1 posn: 175 65 init: hide:)
		((= local4 (View new:))
			view: 251
			loop: 0
			cel: 0
			posn: 162 115
			init:
			hide:
		)
		((= local5 (Prop new:))
			view: 253
			loop: 0
			cel: 0
			posn: 134 88
			init:
			hide:
		)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 144 134 self)
			)
			(1
				(gEgo view: 70 loop: 0 cel: 255 setCycle: End self)
			)
			(2
				(gEgo hide:)
				(local1 hide:)
				(local0 hide:)
				(gCurRoom drawPic: 52 15)
				(= global166 1)
				(if gNight
					((View new:) view: 647 loop: 3 posn: 184 87 addToPic:)
				)
				(local2 show:)
				(local3
					setPri: (+ (local2 priority:) 1)
					show:
					cycleSpeed: 1
					setCycle: Fwd
				)
				(local4 show: stopUpd:)
				(keyholeMusic play:)
				(= local7 (Print 51 9 #font gSmallFont #at -1 5 #time 12)) ; "The ogre roars, "Fe, fi, fo, fum! I smell the blood of a...""
				(= seconds 2)
			)
			(3
				(local3 setCycle: 0 stopUpd:)
				(Print 51 10 #font gSmallFont #at -1 15 #width 290 #dispose) ; "Quiet, you old goat!" interrupts the ogress. "That's just a deer you smell! You know how you get when you're hungry. Here! Eat!"
				(local3 dispose:)
				(local2 view: 252 loop: 0 cel: 255 posn: 152 88 setCycle: End)
				(= seconds 2)
			)
			(4
				(local2 loop: 1 cel: 0 cycleSpeed: 2 setCycle: Fwd)
				(= seconds 10)
			)
			(5
				(cls)
				(local2 loop: 1 cel: 0)
				(= seconds 2)
			)
			(6
				(local2 loop: 1 cel: 255 setCycle: End self)
			)
			(7
				(local2 loop: 0 cel: 0)
				(local5 show: setCycle: End)
				(= seconds 3)
			)
			(8
				(Print 51 11 #font gSmallFont #at -1 10 #time 10) ; "Wife!" shouts the ogre. "Bring me my hen!"
				(= seconds 3)
			)
			(9
				(local5 loop: 1 cel: 255 setCycle: End)
				((gInventory at: 33) moveTo: 49) ; Magic_Hen
				(= seconds 3)
			)
			(10
				(Print 51 12 #font gSmallFont #at -1 20 #draw #time 5) ; ""Lay!" orders the ogre."
				(Print 51 13 #font gSmallFont #at -1 15 #width 290 #dispose) ; "With excitement, you watch the hen lay a golden egg, which the ogre takes. He yawns, then falls asleep on the table. Soon, his snoring rattles the walls."
				(= seconds 5)
			)
			(11
				(local5 dispose:)
				(local2
					view: 254
					loop: 0
					cel: 255
					ignoreActors: 1
					cycleSpeed: 2
					setCycle: End
				)
				(= seconds 5)
			)
			(12
				(local2
					view: 255
					loop: 0
					cel: 255
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(13
				(local2 loop: 1 cel: 0 cycleSpeed: 2 setCycle: Fwd)
				(= seconds 5)
			)
			(14
				(cls)
				(= global165 3)
				(= seconds 5)
			)
			(15
				(local2 dispose:)
				(local4 dispose:)
				(gCurRoom drawPic: 51 15)
				(HandsOn)
				(local0 show:)
				(gEgo show: setCycle: Beg self)
			)
			(16
				(gEgo view: 2 loop: 3 setMotion: 0 setCycle: Walk)
				(HandsOn)
				(= seconds 60)
			)
			(17
				(Print 51 14) ; "You hear the ogre leaving."
				(= global165 5)
				(client setScript: 0)
			)
		)
	)
)

(instance emptyHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 144 134 self)
			)
			(1
				(gEgo view: 70 loop: 0 cel: 255 setCycle: End self)
			)
			(2
				(gEgo hide:)
				(local1 hide:)
				(local0 hide:)
				(gCurRoom drawPic: 52 15)
				(if gNight
					((View new:) view: 647 loop: 3 posn: 184 87 addToPic:)
				)
				(keyholeMusic play:)
				(if (== global165 3)
					((= local2 (Prop new:))
						view: 255
						loop: 1
						cel: 0
						posn: 152 89
						init:
						cycleSpeed: 2
						setCycle: Fwd
					)
					((= local4 (View new:))
						view: 251
						loop: 0
						cel: 0
						posn: 162 115
						addToPic:
					)
					(= local7 (Print 51 15 #at -1 10 #draw #dispose)) ; "He's still there..."
				)
				(= seconds 5)
			)
			(3
				(cls)
				(if (IsObject local2)
					(local2 dispose:)
				)
				(gCurRoom drawPic: 51 15)
				(local0 show:)
				(gEgo view: 70 loop: 0 setCycle: Beg self show:)
			)
			(4
				(gEgo view: 2 loop: 3 setCycle: Walk)
				(HandsOn)
			)
		)
	)
)

(instance doorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> global165 1) (< global165 5))
					(local1
						cel:
							(switch global165
								(1 0)
								(2 1)
								(3
									(if (gEgo has: 33) 3 else 2) ; Magic_Hen
								)
								(4 0)
							)
						setPri: 2
						show:
					)
				else
					(local1 hide:)
				)
				(client ignoreActors: 1 setCycle: End self)
			)
			(1
				(RedrawCast)
				(HandsOn)
				(gCurRoom newRoom: 49)
			)
		)
	)
)

