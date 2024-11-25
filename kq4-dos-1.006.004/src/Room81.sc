;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
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
	Room81 0
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
	local8
	local9
	local10
)

(instance theMusic of Sound
	(properties
		number 43
	)
)

(instance doorOpenMusic of Sound
	(properties
		number 300
	)
)

(instance Room81 of Rm
	(properties
		picture 81
		style 16
	)

	(method (init)
		(super init:)
		(self setRegions: 604) ; regBFCastle
		((View new:) view: 633 loop: 2 cel: 0 posn: 122 70 setPri: 3 addToPic:)
		((View new:) view: 633 loop: 2 cel: 0 posn: 196 71 setPri: 3 addToPic:)
		(if gNight
			((= local5 (Prop new:))
				view: 646
				loop: 1
				cel: 0
				posn: 225 94
				init:
				stopUpd:
			)
			((= local6 (Prop new:))
				view: 646
				loop: 0
				cel: 0
				posn: 91 91
				init:
				stopUpd:
			)
			((View new:)
				view: 633
				loop: 0
				cel: 3
				posn: 20 179
				setPri: 14
				addToPic:
			)
			((Prop new:)
				view: 633
				loop: 0
				cel: 4
				posn: 122 60
				setPri: 2
				init:
				setCycle: Fwd
			)
			((Prop new:)
				view: 633
				loop: 1
				cel: 3
				posn: 197 61
				setPri: 2
				init:
				setCycle: Fwd
			)
		)
		(= local7 0)
		(= local8 0)
		(theMusic init:)
		(doorOpenMusic init:)
		((= local3 (Prop new:))
			view: 604
			posn: 58 151
			cel: 0
			ignoreActors:
			setPri: 12
			init:
			stopUpd:
		)
		(if (or (== gPrevRoomNum 85) (== gPrevRoomNum 0))
			(gEgo
				posn: 68 163
				view: 4
				setStep: 4 2
				illegalBits: $c000
				init:
			)
		)
		(if (and (== gPrevRoomNum 92) (not global175))
			(User canControl: 0 canInput: 0)
			(gEgo
				posn: 83 165
				view: 4
				xStep: 4
				yStep: 2
				setPri: -1
				illegalBits: 0
				ignoreActors: 1
				init:
				setCycle: Walk
				setMotion: 0
			)
			((= local1 (Act new:))
				view: 141
				posn: 98 175
				setStep: 4 2
				ignoreActors: 1
				init:
				setCycle: Walk
			)
			((= local2 (Act new:))
				view: 141
				posn: 115 181
				setStep: 4 2
				ignoreActors: 1
				init:
				setCycle: Walk
			)
			(local3 cel: 4)
			(self setScript: lockUp)
		)
		(if global175
			(= global175 0)
			(User canControl: 0 canInput: 0)
			(gEgo
				posn: 83 165
				view: 4
				illegalBits: $c000
				setStep: 4 2
				setPri: -1
				init:
				setCycle: Walk
			)
			((= local1 (Act new:))
				view: 141
				posn: 115 181
				setStep: 4 2
				ignoreActors: 1
				illegalBits: 0
				init:
				setCycle: Walk
			)
			(local3 cel: 4)
			(self setScript: lockUpLast)
		)
		(= global205 0)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 85)
		)
		(if (and (gEgo inRect: 61 144 84 157) ((gInventory at: 34) ownedBy: 81)) ; Rose
			(Print 81 0 #font gSmallFont #icon 409 0 0 #at -1 20) ; "What's this?! Why, a beautiful red rose has been pushed under your door! You pick it up and carry it with you."
			(= global182 1)
			(gEgo get: 34) ; Rose
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((not (& (gEgo onControl: 0) $0800))
						(cond
							(
								(or
									(Said 'look[<around][/!*]')
									(Said 'look/castle,tower,room,bedroom')
								)
								(Print 81 1) ; "Normally, this is Edgar's tower bedroom. Actually, for being in such an awful castle, it looks quite comfortable; but you're in no mood to care."
							)
							((Said 'look>')
								(cond
									((Said '<under/bed')
										(Print 81 2) ; "There is nothing under the bed."
									)
									((Said '/bed')
										(Print 81 3) ; "This is a most unusual, four-poster bed."
									)
									((Said '/window')
										(if
											(or
												(gEgo
													inRect: 201 117 238 126
												)
												(gEgo inRect: 79 113 116 123)
											)
											(Print 81 4) ; "You see the mountain out the window."
										else
											(Print 800 1) ; "You're not close enough."
										)
									)
									(
										(or
											(Said '<in/chest,dresser')
											(Said '<in/drawer[<chest]')
										)
										(Print 81 5) ; "It's private."
									)
									((Said '/chest,dresser')
										(Print 81 6) ; "You see a chest of drawers, with a mirror on top."
									)
									((or (Said '/dirt') (Said '<down'))
										(if (== ((gInventory at: 34) owner:) 81) ; Rose
											(Print 81 7) ; "You see a beautiful rose lying by the door."
										else
											(Print 81 8) ; "There is nothing of interest on the floor."
										)
									)
									((Said '/mirror')
										(if (gEgo inRect: 218 135 272 154)
											(Print 81 9) ; "You look in the mirror and see the reflection of a poor, but beautiful, peasant girl."
										else
											(Print 800 1) ; "You're not close enough."
										)
									)
									((Said '/carpet')
										(Print 81 10) ; "A small rug lies on the floor by the bed."
									)
									((Said '/stair')
										(Print 81 11) ; "How can you even see the stairs from here?"
									)
									((Said '/door')
										(Print 81 12) ; "It's just a plain wooden door."
									)
									((Said '/key')
										(if
											(and
												(gEgo has: 34) ; Rose
												(not (gEgo has: 32)) ; Gold_Key
											)
											(Print 81 13) ; "It is attached to the rose."
										else
											(event claimed: 0)
										)
									)
								)
							)
							((and (gCast contains: local4) (Said 'talk'))
								(Print 81 14) ; "Edgar does not respond to you."
							)
							(
								(and
									((gInventory at: 34) ownedBy: 81) ; Rose
									(Said 'get/rose')
								)
								(NotClose) ; "You're not close enough."
							)
							(
								(or
									(Said 'lay,sleep,get/bed')
									(Said 'sleep')
									(Said 'lay<down,sleep')
								)
								(Print 81 15) ; "You don't have time for that!"
							)
							(
								(or
									(Said 'open/chest')
									(Said 'open/drawer[<chest]')
								)
								(Print 81 5) ; "It's private."
							)
							((Said 'open/window')
								(Print 81 16) ; "The windows do not open."
							)
							((Said 'break/window')
								(Print 81 17) ; "That would not accomplish anything."
							)
							((Said '[use]/key<skeleton')
								(cond
									((not (gEgo has: 20)) ; Skeleton_Key
										(DontHave) ; "You don't have it."
									)
									((not local8)
										(Print 81 18) ; "The door is unlocked."
									)
									(else
										(Print 81 19) ; "The skeleton key does not fit the lock."
									)
								)
							)
							((Said 'unlatch/door')
								(cond
									((== gPrevRoomNum 85)
										(Print 81 20) ; "You just got out of there! Why go back in?"
									)
									((not local8)
										(Print 81 21) ; "It already is."
									)
									((not (gEgo inRect: 70 150 84 157))
										(Print 800 1) ; "You're not close enough."
									)
									((gEgo has: 32) ; Gold_Key
										(= local8 0)
										(Print 81 22) ; "Using the little gold key you quickly unlock the door."
										(gGame changeScore: 2)
									)
									(else
										(Print 81 23) ; "How can you do that without a key?"
									)
								)
							)
							((or (Said '[use]/key<gold') (Said 'gold'))
								(cond
									((not (gEgo inRect: 70 150 84 157))
										(Print 800 1) ; "You're not close enough."
									)
									((not (gEgo has: 32)) ; Gold_Key
										(Print 800 2) ; "You don't have it."
									)
									((not local8)
										(Print 81 24) ; "The door is already unlocked."
									)
									((or local7 (not (gEgo has: 20))) ; Skeleton_Key
										(Print 81 22) ; "Using the little gold key you quickly unlock the door."
										(= local8 0)
										(gGame changeScore: 2)
									)
									(else
										(Print 81 25) ; "Use it for what?"
									)
								)
							)
							((Said 'open/door')
								(cond
									((not (gEgo inRect: 70 150 84 157))
										(Print 800 1) ; "You're not close enough."
									)
									(local8
										(Print 81 26) ; "Unlock it first."
									)
									((== (local3 cel:) 0)
										(local3 startUpd: setCycle: End doDoor)
										(User canControl: 0 canInput: 0)
										(gEgo
											posn: (gEgo x:) 146
											illegalBits: $8000
										)
										(doorOpenMusic play:)
									)
									(else
										(Print 81 27) ; "It is already is open."
									)
								)
							)
							((Said 'close/door')
								(if (== (local3 cel:) 0)
									(Print 81 21) ; "It already is."
								else
									(Print 81 28) ; "You don't need to."
								)
							)
							((Said 'get,untie,detach/key')
								(if
									(and
										(gEgo has: 34) ; Rose
										(not (gEgo has: 32)) ; Gold_Key
									)
									(Print 81 29) ; "You remove the little gold key from the red rose."
									(= global182 1)
									(gEgo get: 32) ; Gold_Key
									(gGame changeScore: 2)
									((gInventory at: 34) ; Rose
										description:
											{What a beautiful red rose!}
										loop: 1
										cel: 0
									)
								else
									(event claimed: 0)
								)
							)
						)
					)
					((or (Said 'look[<around][/!*]') (Said 'look/room'))
						(Print 81 30) ; "You see Edgar's bedroom door, and a winding stairway leading down the tower."
					)
					((Said 'look/stair')
						(Print 81 31) ; "The stone stairway leads down the tower."
					)
					((Said 'look/door')
						(Print 81 12) ; "It's just a plain wooden door."
					)
					((Said 'look/wall')
						(Print 81 32) ; "There is nothing of importance on the walls."
					)
					((Said 'close/door')
						(Print 81 28) ; "You don't need to."
					)
					((Said 'open/door')
						(cond
							((not (gEgo inRect: 57 155 84 165))
								(Print 800 1) ; "You're not close enough."
							)
							((== (local3 cel:) 0)
								(local3 startUpd: setCycle: End doDoor)
								(User canControl: 0 canInput: 0)
								(gEgo illegalBits: $8000 setMotion: 0)
								(doorOpenMusic play:)
							)
							(else
								(Print 81 33) ; "It already is open."
							)
						)
					)
					((Said 'unlatch/*')
						(Print 81 34) ; "It already is unlocked."
					)
				)
			)
		)
	)
)

(instance doDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3 stopUpd:)
				(User canControl: 1 canInput: 1)
			)
		)
	)
)

(instance lockUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 setLoop: -1 setMotion: MoveTo 68 165 self)
				(local1 setMotion: Follow gEgo 10)
				(local2 setMotion: Follow gEgo 25)
			)
			(1
				(local1 setMotion: 0)
				(local2 setMotion: 0)
				(gEgo setMotion: MoveTo 70 150 self)
			)
			(2
				(gEgo setMotion: MoveTo 106 139 self)
				(= local8 1)
				(local3 setCycle: Beg)
			)
			(3
				(gEgo illegalBits: $c000)
				(local2 illegalBits: 0 setMotion: MoveTo 145 235 self)
				(local1 illegalBits: 0 setMotion: MoveTo 145 239)
			)
			(4
				(User canControl: 1 canInput: 1)
				(local3 stopUpd:)
				(local1 dispose:)
				(local2 dispose:)
				((ScriptID 0 4) setReal: self 2) ; timer1
			)
			(5
				(Print 81 35 #at -1 30 #time 5) ; "You think to yourself, NOW WHAT!!"
				((ScriptID 0 4) setReal: self 30) ; timer1
			)
			(6
				(theMusic play:)
				((= local4 (Act new:))
					view: 131
					loop: 1
					posn: 158 215
					illegalBits: 0
					init:
					setCycle: Walk
					setMotion: MoveTo 68 162 self
				)
			)
			(7
				(= local0 (Print 81 36 #at -1 25 #dispose)) ; "You hear something at the door!"
				(local4 cycleSpeed: 7 setLoop: 0 cel: 255 setCycle: CT 10 1)
				((ScriptID 0 4) setReal: self 3) ; timer1
			)
			(8
				(local4 setCycle: End self)
			)
			(9
				(cls)
				((gInventory at: 34) moveTo: 81) ; Rose
				(local4
					view: 130
					setLoop: -1
					illegalBits: 0
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 190 249 self
				)
			)
			(10
				(local4 dispose:)
				(theMusic client: 0 stop:)
				(= seconds 120)
			)
			(11
				(HandsOff)
				(gEgo loop: 0)
				(if gNight
					(local5 cycleSpeed: 7 cel: 255 setCycle: End self)
					(local6 cycleSpeed: 7 cel: 255 setCycle: End)
				)
			)
			(12
				(Print 81 37 #at -1 10 #width 260) ; "It looks like you're destined to be...Mrs. Edgar!"
				(= seconds 12)
			)
			(13
				(= global204 0)
				(= global205 1)
				((ScriptID 604) keep: 0) ; regBFCastle
				(gCurRoom newRoom: 692)
			)
		)
	)
)

(instance lockUpLast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(for
					((= local10 (gInventory first:)))
					local10
					((= local10 (gInventory next: local10)))
					
					(if
						(and
							(= local9 (NodeValue local10))
							(== (local9 owner:) gEgo)
						)
						(local9 owner: 89)
					)
				)
				(gEgo setMotion: 0 illegalBits: 0)
				(local1 setMotion: Follow gEgo 10)
				(gEgo setLoop: -1 setMotion: MoveTo 68 165 self)
			)
			(1
				(local1 setMotion: 0)
				(gEgo setMotion: MoveTo 70 150 self)
			)
			(2
				(gEgo setMotion: MoveTo 106 139 self)
				(= local8 1)
				(local3 setCycle: Beg)
			)
			(3
				(local1 ignoreActors: 1 setMotion: MoveTo 150 225 self)
			)
			(4
				(gEgo setMotion: MoveTo 182 147 self)
				(local3 stopUpd:)
				(local1 dispose:)
			)
			(5
				(gEgo setMotion: MoveTo 216 124 self)
			)
			(6
				(gEgo loop: 0)
				(if gNight
					(local5 cycleSpeed: 7 cel: 255 setCycle: End self)
					(local6 cycleSpeed: 7 cel: 255 setCycle: End)
				)
			)
			(7
				(Print 81 38 #at -1 10 #width 260 #time 10) ; "The henchmen have taken your rose and you no longer have the gold key! It looks like you're destined to be...Mrs. Edgar!"
				(gEgo setMotion: MoveTo 160 149 self)
			)
			(8
				(gEgo loop: 2)
				(= seconds 3)
			)
			(9
				(= global205 1)
				(= global204 0)
				((ScriptID 604) keep: 0) ; regBFCastle
				(gCurRoom newRoom: 692)
				(= global189 0)
			)
		)
	)
)

