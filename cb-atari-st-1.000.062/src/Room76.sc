;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room76 0
)

(synonyms
	(room attic)
)

(local
	local0
)

(instance Room76 of Rm
	(properties
		picture 76
	)

	(method (init)
		(= horizon 95)
		(= north 75)
		(= east 74)
		(= global61 0)
		(super init:)
		(Load rsSOUND 117)
		(if (not gAtticFirstTime)
			(= gAtticFirstTime (| (<< gHour $0008) (* gMinute 15)))
		)
		(switch gAct
			(2
				(= local0 1)
			)
			(4
				(= local0 2)
			)
			(6
				(= local0 4)
			)
		)
		(self setFeatures: Junk)
		(trunk init: stopUpd:)
		(Elevator
			cel:
				(cond
					((== global111 75) 1)
					((not (& gElevatorState $0004)) 2)
					(else 3)
				)
			init:
			stopUpd:
		)
		(if (== gPrevRoomNum 75)
			(gEgo posn: 268 96)
		else
			(gEgo posn: 309 117)
		)
		(gEgo init:)
		(Killer init: hide:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 76 0) ; "It's DARK back here in the attic! The moonlight from the large windows doesn't light this part of the attic very well. Through the gloom you can see piles of uninteresting boxes and old junk. However, there is an old trunk that does interest you."
		)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 1) $4000)
				(not script)
				(not (IsFlag 46))
				(< gAct 7)
			)
			(self setScript: Strangle)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 76 0) ; "It's DARK back here in the attic! The moonlight from the large windows doesn't light this part of the attic very well. Through the gloom you can see piles of uninteresting boxes and old junk. However, there is an old trunk that does interest you."
						)
						((Said '/garbage,possession')
							(Print 76 1) ; "Most of the stuff up here is nothing but old junk."
						)
						((Said '<in/box')
							(Print 76 2) ; "There's nothing that would interest you in any of these boxes."
						)
						((Said '/box')
							(Print 76 3) ; "Some stuff is stored in old boxes and crates."
						)
						((Said '/dormer')
							(Print 76 4) ; "There is nothing special in the dormer."
						)
						((Said '/cloth')
							(Print 76 5) ; "There are old army clothes in the open trunk."
						)
						((Said '/possession,garbage')
							(Print 76 6) ; "You see thirty year old army items in the open trunk."
						)
						((Said '/window')
							(Print 76 7) ; "Moonlight streams in through the big attic windows."
						)
						((Said '/elevator')
							(if (== global111 gCurRoomNum)
								(Print 76 8) ; "You see an elevator at the back of the attic."
							else
								(Print 76 9) ; "You see an elevator shaft at the back of the attic."
							)
						)
						(local0
							(cond
								((Said '/cape')
									(switch local0
										(4
											(Print 76 10) ; "The cape is the type worn by an army officer of thirty years ago. To your horror, you see that there are wet blood stains on it!"
										)
										(else
											(Print 76 11) ; "The cape is the type worn by an army officer of thirty years ago."
										)
									)
								)
								((Said '/glove')
									(switch local0
										(4
											(Print 76 12) ; "Even though the leather gloves are cracked and worn, they still look very sturdy. Frighteningly, they have wet blood stains on them!"
										)
										(else
											(Print 76 13) ; "Even though the leather gloves are cracked and worn, they still look very sturdy."
										)
									)
								)
								((Said '/boot')
									(switch local0
										(1
											(Print 76 14) ; "This is a pair of large, old army boots. You notice an insignia on the boot heels."
										)
										(else
											(Print 76 15) ; "This is a pair of large, old army boots. You happen to notice mud on the soles."
										)
									)
								)
								((Said '/hat')
									(Print 76 16) ; "This is a dandy-looking Colonel's hat!"
								)
								((Said '/heel,insignia')
									(switch local0
										(1
											(Print 76 17) ; "You see an insignia of an eagle on the heels of the army boots."
										)
										(else
											(Print 76 18) ; "Upon examining the muddy boot sole, you notice an insignia of an eagle on the heel."
										)
									)
								)
							)
							(if (event claimed:)
								(SetFlag 46)
							)
						)
						((Said '/cape,hat,heel')
							(Print 76 19) ; "It isn't here."
						)
						((Said '/glove,boot')
							(Print 76 20) ; "They aren't here."
						)
					)
				)
				((Said 'open>')
					(cond
						((Said '/box')
							(Print 76 2) ; "There's nothing that would interest you in any of these boxes."
						)
						((Said '/chest')
							(Print 76 21) ; "The trunk is already open."
						)
					)
				)
				((Said 'get>')
					(cond
						((Said '/cloth')
							(Print 76 22) ; "They don't belong to you."
						)
						((Said '/possession,garbage')
							(Print 76 22) ; "They don't belong to you."
						)
						(local0
							(cond
								((Said '/cape')
									(Print 76 23) ; "You have no use for an army officer's cape."
								)
								((Said '/glove')
									(Print 76 24) ; "You can't think of a use for leather gloves."
								)
								((Said '/hat')
									(Print 76 25) ; "The hat wouldn't fit you. Better leave it here."
								)
								((Said '/boot')
									(Print 76 26) ; "These boots are much too big for your feet!"
								)
							)
							(if (event claimed:)
								(SetFlag 46)
							)
						)
					)
				)
				((Said 'wear,(attach<on)>')
					(cond
						((Said '/cloth')
							(Print 76 27) ; "You wouldn't look good in them, Laura!"
						)
						(local0
							(cond
								((Said '/cape')
									(Print 76 23) ; "You have no use for an army officer's cape."
								)
								((Said '/glove')
									(Print 76 24) ; "You can't think of a use for leather gloves."
								)
								((Said '/hat')
									(Print 76 25) ; "The hat wouldn't fit you. Better leave it here."
								)
								((Said '/boot')
									(Print 76 26) ; "These boots are much too big for your feet!"
								)
							)
							(if (event claimed:)
								(SetFlag 46)
							)
						)
					)
				)
				((Said 'close/chest')
					(Print 76 28) ; "The hinges are broken. It would be difficult to close it."
				)
			)
		)
	)
)

(instance Strangle of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== (myMusic prevSignal:) -1)
				(== state 3)
				(== (gEgo cel:) (- (NumCels gEgo) 1))
			)
			(myMusic prevSignal: 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(myMusic prevSignal: 0 number: 117 loop: 1 play:)
				(Killer show: setCycle: End self)
			)
			(1
				(Killer loop: 1 cycleSpeed: 1 setCycle: Fwd)
				(gEgo cel: 0 hide:)
				(= cycles 5)
			)
			(2
				(Killer loop: 4)
				(= seconds 3)
			)
			(3
				(Killer loop: 2 cel: 0 setCycle: End)
				(gEgo
					show:
					view: 62
					loop: 3
					cel: 0
					posn: 155 92
					setCycle: End
				)
			)
			(4
				(= global128 62)
				(= global129 5)
				(= global130 0)
				(EgoDead 76 29) ; "What a cruel choke!"
				(client setScript: 0)
			)
		)
	)
)

(instance trunk of Prop
	(properties
		y 157
		x 72
		view 176
	)

	(method (handleEvent event)
		(cond
			((Said 'get,move/box')
				(Print 76 30) ; "You couldn't do that!"
			)
			((Said 'get,move/chest')
				(Print 76 31) ; "The trunk is much too heavy to move."
			)
			(
				(or
					(Said 'search,(look<in)/chest')
					(Said 'search,(look<in)/cloth')
				)
				(if (< (gEgo distanceTo: trunk) 30)
					(if (not local0)
						(Print 76 32) ; "Peering into the open trunk, you see old army clothing and various paraphernalia. This must be where the Colonel keeps his old army gear."
					else
						(SetFlag 46)
						(switch local0
							(1
								(Printf 76 33 76 32 76 34) ; "%s %s"
							)
							(2
								(Printf 76 35 76 32 76 34 76 36) ; "%s %s %s"
							)
							(else
								(Printf 76 35 76 32 76 34 76 37) ; "%s %s %s"
							)
						)
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/chest'))
				(event claimed: 1)
				(Print 76 38) ; "The trunk is open and you see old army clothes strewn about."
			)
		)
	)
)

(instance Elevator of Prop
	(properties
		y 50
		x 271
		view 176
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {elevator})
		)
	)
)

(instance Junk of RFeature
	(properties
		nsTop 30
		nsLeft 266
		nsBottom 129
		nsRight 319
	)

	(method (handleEvent event)
		(if
			(or
				(MousedOn self event 3)
				(Said 'look/garbage,possession,furniture')
			)
			(Print 76 38) ; "The trunk is open and you see old army clothes strewn about."
			(event claimed: 1)
		)
	)
)

(instance Killer of Prop
	(properties
		y 74
		x 177
		view 62
	)
)

(instance myMusic of Sound
	(properties)
)

