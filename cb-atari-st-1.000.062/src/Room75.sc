;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use ElevGate)
(use Interface)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room75 0
)

(synonyms
	(newspaper letter)
	(room attic)
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(Print &rest #at 10 125 #font 4 #width 250 #mode 1 #dispose)
)

(instance Room75 of Rm
	(properties
		picture 75
	)

	(method (init)
		(= global61 0)
		(super init:)
		(if (not gAtticFirstTime)
			(= gAtticFirstTime (| (<< gHour $0008) (* gMinute 15)))
		)
		(self setFeatures: Window1 Shaft Junk)
		(if (& gCorpseFlags $0040) ; Lillian
			(User canControl: 0 canInput: 1)
			(= global190 1)
			(self setRegions: 290) ; killrudy
		else
			(head init: hide: stopUpd:)
			(arms init: hide: stopUpd:)
		)
		(if (!= gPrevRoomNum 66)
			(if (== gPrevRoomNum 74)
				(gEgo posn: 230 188)
			else
				(if (== gPrevRoomNum 42)
					(ClearFlag 46)
				)
				(gEgo posn: 80 188)
			)
			(gEgo view: 0 illegalBits: -32768)
		)
		(paper init: stopUpd:)
		((= gGate gate)
			chainID: chain
			elevatorID: elevator
			downID: down
			upID: up
			msgID:
				{What a dark and creepy attic! It helps to have the moonlight shining in through those big windows. Among all the junk, a stack of old newspapers catches your eye.}
			init:
		)
	)

	(method (doit)
		(if (and (not (& gCorpseFlags $0040)) (not (& gElevatorState $0010)) (IsFirstTimeInRoom)) ; Lillian
			(Print 75 0) ; "What a dark and creepy attic! It helps to have the moonlight shining in through those big windows. Among all the junk, a stack of old newspapers catches your eye."
		)
		(if (== (gEgo edgeHit:) EDGE_BOTTOM)
			(if (< (gEgo x:) 189)
				(gCurRoom newRoom: 76)
			else
				(gCurRoom newRoom: 74)
			)
		)
		(cond
			((< (gEgo x:) 130)
				(= vertAngle 30)
			)
			((< (gEgo x:) 190)
				(= vertAngle 0)
			)
			(else
				(= vertAngle 150)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 201)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'get,move/box')
					(Print 75 1) ; "You couldn't do that!"
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(if (& gCorpseFlags $0040) ; Lillian
								(Print 75 2) ; "Oh, no!! Colonel Dijon and Rudy are in the midst of a fierce struggle! You see a hypodermic needle between them and it's impossible to tell which of the two men is the aggressor. This is indeed a dangerous situation!"
							else
								(Print 75 0) ; "What a dark and creepy attic! It helps to have the moonlight shining in through those big windows. Among all the junk, a stack of old newspapers catches your eye."
							)
						)
						((Said '<in/box')
							(Print 75 3) ; "There's nothing that would interest you in any of these boxes."
						)
						((Said '/box')
							(Print 75 4) ; "Some stuff is stored in old boxes and crates."
						)
						((Said '<in/chest')
							(Print 75 5) ; "There is nothing you would want in the trunk."
						)
						((Said '/chest')
							(Print 75 6) ; "You see an old, uninteresting trunk."
						)
						((Said '[<at]/window')
							(Print 75 7) ; "Moonlight streams in through the big attic windows."
						)
					)
				)
				((Said 'open>')
					(cond
						((Said '/box')
							(Print 75 3) ; "There's nothing that would interest you in any of these boxes."
						)
						((Said '/chest')
							(Print 75 5) ; "There is nothing you would want in the trunk."
						)
					)
				)
			)
		)
	)
)

(instance readNewspaper of Script
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(== (event type:) evMOUSEBUTTON)
					(== (event type:) evKEYBOARD)
					(== (event type:) $0040) ; direction
				)
				(== state 4)
			)
			(if (!= (event type:) $0040) ; direction
				(= seconds 0)
				(= cycles 1)
			)
			(event claimed: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 32 127 self)
			)
			(1
				(gEgo
					view: 61
					cel: 0
					loop: 1
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(paper hide: forceUpd:)
				(gEgo loop: 2 cel: 0)
				(head posn: (+ (gEgo x:) 4) (- (gEgo y:) 38) show:)
				(arms posn: (- (gEgo x:) 3) (- (gEgo y:) 26) show:)
				(= cycles 2)
			)
			(3
				(Print 75 8) ; "This seems to be an old stack of 1890's editions of "The Times Democrat." As you look through them, an October 18th, 1898 edition catches your interest. You begin reading..."
				(= cycles 1)
			)
			(4
				(++ local1)
				(head setCycle: Fwd)
				(switch local1
					(1
						(localproc_0 75 9) ; "New Orleans, Louisiana Colonel Henri Dijon came home today after spending several months in the hospital following injuries in the recent Spanish-American War."
					)
					(2
						(localproc_0 75 10) ; "Colonel Dijon took several bullets to his pelvic and shoulder areas as he attempted to carry a seriously injured fellow soldier to safety."
					)
					(3
						(localproc_0 75 11) ; "Incredibly, though injured himself, he managed to make it safely behind American lines. Colonel Dijon was duly decorated and discharged with honor by the U. S. Army. New Orleans welcomes home a true American war hero!"
					)
				)
			)
			(5
				(cls)
				(if (< local1 3)
					(= state 3)
					(arms setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(6
				(paper show: forceUpd:)
				(gEgo loop: 1)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
				(head hide: forceUpd:)
				(arms hide: forceUpd:)
			)
			(7
				(Print 75 12) ; "Is that why the Colonel's in a wheelchair? you wonder."
				(= local0 1)
				(HandsOn)
				(gEgo
					view: 0
					loop: 1
					cycleSpeed: 0
					illegalBits: -32768
					setCycle: Walk
				)
				(head dispose:)
				(arms dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance paper of Prop
	(properties
		y 127
		x 17
		view 61
	)

	(method (handleEvent event)
		(if (or (Said 'get,read,look/newspaper') (MousedOn self event 3))
			(event claimed: 1)
			(cond
				((& gElevatorState $0010)
					(Print 75 13) ; "You need to leave the elevator first."
				)
				(local0
					(Print 75 14) ; "You've already gone through the newspapers. Only one article interested you."
				)
				((< (gEgo distanceTo: paper) 50)
					(Room75 setScript: readNewspaper)
				)
				(else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance head of Prop
	(properties
		view 61
		loop 3
		cycleSpeed 3
	)
)

(instance arms of Prop
	(properties
		view 61
		loop 4
		cycleSpeed 1
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 16
		nsLeft 97
		nsBottom 82
		nsRight 207
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Shaft of RFeature
	(properties
		nsTop 52
		nsLeft 38
		nsBottom 113
		nsRight 66
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
			(Print 75 15) ; "Most of the stuff up here is nothing but old junk."
			(event claimed: 1)
		)
	)
)

(instance gate of ElevGate
	(properties)
)

(instance chain of Act
	(properties)
)

(instance elevator of Act
	(properties
		y -10
	)
)

(instance down of View
	(properties)
)

(instance up of View
	(properties)
)

