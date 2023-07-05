;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
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
	Room32 0
)

(synonyms
	(painting beauregard)
	(bookcase bookcase shelf)
	(room library)
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
	[local8 4] = [32 0 32 1]
)

(instance Room32 of Rm
	(properties
		picture 32
	)

	(method (init)
		(= east 33)
		(super init:)
		(if (== (& global111 $7fff) gCurRoomNum)
			(= [local8 0] [local8 2])
			(= [local8 1] [local8 3])
		)
		(gAddToPics
			add:
				mantle
				books
				chair2
				chair3
				chair4
				chair5
				chair6
				sofa1
				sofa2
				table
				tools
		)
		(lamp1 setPri: 5 setCycle: Fwd init:)
		(lamp2 setPri: 5 setCycle: Fwd init:)
		(fire loop: (/ gAct 2) setCycle: Fwd init:)
		(if (not gDetailLevel)
			(lamp1 addToPic:)
			(lamp2 addToPic:)
			(fire addToPic:)
		)
		(if (!= gPrevRoomNum 66)
			(if (!= gPrevRoomNum 49)
				(if (== gPrevRoomNum 33)
					(gEgo posn: 310 150)
				else
					(gEgo posn: 55 120)
				)
				(gEgo view: 0 illegalBits: -32768 setPri: -1)
			else
				(gEgo view: 0 illegalBits: -32768 setPri: -1 posn: 252 167)
				(= local6 1)
			)
		)
		(if (>= gAct 2)
			(Mag ignoreActors: 1 init: stopUpd:)
			(if (< gAct 3)
				(Feather setPri: 8 ignoreActors: 1 init:)
				(chair1 view: 132 loop: 2 cel: 3 y: 135)
				(tools cel: 1)
			)
			(if (and ((gInventory at: 6) ownedBy: 32) (< gAct 3)) ; poker
				(Load rsVIEW 17)
				(poker setPri: 9 stopUpd: init:)
			)
			(gAddToPics add: chair1 tools)
		)
		(self
			setRegions: 213 ; fireReg
			setFeatures:
				chair2
				chair3
				chair4
				chair5
				chair6
				chair1
				sofa1
				sofa2
				table
				Shaft
				books
				Case1
				Case2
				mantle
				Mirror
		)
		(if (not gDetailLevel)
			(self setFeatures: lamp1 lamp2 fire)
		)
		(if (and (<= (Random 1 100) 35) (> gAct 0) (< gAct 3))
			(Shadow illegalBits: 0 posn: 13 82 setPri: 1 init:)
			(Shadow setScript: shadowWalk)
		)
		(switch gAct
			(0
				(= local0 1)
				(= local7 1)
				(self setRegions: 220) ; wilbRead
			)
			(1
				(if
					(and
						(not (& gElevatorState $0020))
						(or (== gClarenceWilburState 2) (>= gClarenceWilburState 4))
					)
					(if (== gClarenceWilburState 2)
						(User canInput: 0)
					)
					(= local0 1)
					(= local7 1)
					(self setRegions: 402) ; wilbRead
				)
				(if (<= gClarenceWilburState 3)
					(gAddToPics add: chair1)
				)
			)
			(2
				(if (< global198 100)
					(= global198 100)
				)
			)
			(3
				(if
					(and
						(!= gPrevRoomNum 42)
						(< gMinute 3)
						(not (& global141 $0002))
					)
					(self setRegions: 269) ; sweeping
					(= global111 42)
				)
			)
		)
		(if (not local0)
			(= local2 (ElevGate new:))
			(local2
				chainID: chain
				elevatorID: elevator
				downID: down
				upID: up
				init:
			)
		else
			(elevGate
				cel:
					(if (& gElevatorState $0001)
						(- (NumCels elevGate) 1)
					else
						(&= gElevatorState $fffe)
					)
				setPri: 9
				init:
				stopUpd:
			)
			(gEgo init:)
		)
		(gAddToPics eachElementDo: #init doit:)
	)

	(method (doit)
		(if (and (== gAct 3) (== global373 1))
			(= local7 1)
		)
		(if (and (== gAct 3) (== global373 0))
			(= local7 0)
		)
		(if (and (not (& gElevatorState $0010)) (IsFirstTimeInRoom))
			(Print [local8 0] [local8 1])
		)
		(if local6
			(= local6 0)
			(Print 32 2) ; "The secret panel closes behind you and leaves no trace!"
		)
		(if (== global198 100)
			(= global198 101)
			(Print 32 3) ; "Something looks wrong here! A chair has been knocked over, and there are signs of a struggle on the floor!"
		)
		(if (& (gEgo onControl: 1) $0004)
			(gCurRoom newRoom: 31)
		)
		(cond
			((< (gEgo x:) 140)
				(= vertAngle 44)
			)
			((< (gEgo x:) 260)
				(= vertAngle 27)
			)
			(else
				(= vertAngle 18)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 204)
		(DisposeScript 201)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(DisposeScript 990)
			(if
				(and
					global208
					(Said
						'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>'
					)
				)
				(self setScript: (ScriptID 243 0)) ; atsgl
				((self script:) handleEvent: event)
				(if (event claimed:)
					(return)
				)
			)
			(if (== local0 1)
				(= local4 -1)
				(cond
					((or (Said '*/elevator,lift') (Said 'lift[<open][/*]'))
						(Print 32 4) ; "Currently, you don't SEE an elevator, just an elevator shaft."
					)
					((Said 'look>')
						(cond
							((Said '/archway')
								(Print 32 5) ; "The gate provides protection from the elevator as it moves between floors."
							)
							((Said '/shaft')
								(cond
									((< gCurRoomNum global111)
										(Print 32 6) ; "The elevator seems to be upstairs."
									)
									((> gCurRoomNum global111)
										(Print 32 7) ; "The elevator seems to be downstairs."
									)
									((not (& (gEgo onControl: 1) $0028))
										(NotClose) ; "You're not close enough."
									)
								)
							)
						)
					)
					((Said 'open/archway')
						(= local3 1)
						(cond
							((& gElevatorState $0001)
								(AlreadyOpen) ; "It is already open."
							)
							((& (gEgo onControl: 1) $0008)
								(= local4 3)
							)
							((& (gEgo onControl: 1) $0020)
								(= local4 2)
							)
							(else
								(NotClose) ; "You're not close enough."
							)
						)
					)
					((Said 'close/archway')
						(= local3 0)
						(cond
							((not (& gElevatorState $0001))
								(AlreadyClosed) ; "It is already closed."
							)
							((& (gEgo onControl: 1) $0008)
								(if (== (gEgo y:) (elevGate y:))
									(Print 32 8) ; "You can't; you are blocking the gate."
									(return)
								)
								(= local4 3)
							)
							((& (gEgo onControl: 1) $0020)
								(= local4 2)
							)
							(else
								(NotClose) ; "You're not close enough."
							)
						)
					)
				)
				(if (!= local4 -1)
					(elevGate setScript: GateFunc)
				)
			)
			(if (event claimed:)
				(return)
			)
			(cond
				((Said '/panel,(door<hidden)>')
					(cond
						((Said 'look')
							(if (& global175 $0001)
								(Print 32 9) ; "Even though you know where it is, you can't see it."
							else
								(Print 32 10) ; "You don't see one."
							)
						)
						((and (& global175 $0001) (Said 'open,move'))
							(if (not local7)
								(if (& (gEgo onControl: 1) $0080)
									(gCurRoom newRoom: 49)
								else
									(NotClose) ; "You're not close enough."
								)
							else
								(Print 32 11) ; "Better not while someone is in the room."
							)
						)
					)
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(cond
								((gCast contains: poker)
									(&= global166 (~ (<< $0001 gAct)))
									(Print 32 3) ; "Something looks wrong here! A chair has been knocked over, and there are signs of a struggle on the floor!"
								)
								((& (gEgo onControl: 0) $0020)
									(Print 32 12) ; "You're in the elevator shaft!"
								)
								(else
									(Print [local8 0] [local8 1])
								)
							)
						)
						((or (Said '<up') (Said '/elevator'))
							(if (& (gEgo onControl: 0) $0020)
								(Print 32 6) ; "The elevator seems to be upstairs."
							else
								(event claimed: 0)
							)
						)
						((Said '<behind,below/mirror')
							(Print 32 13) ; "There is nothing of interest behind the mirror."
						)
						((or (Said '<in/mirror') (Said '/reflection'))
							(if (< (gEgo distanceTo: fire) 70)
								(= global213 12)
								(Say 0 32 14) ; "You gaze into the mirror and appraise your appearance. A bit disheveled, perhaps, but not bad...considering the circumstances."
							else
								(NotClose) ; "You're not close enough."
							)
						)
						((Said '/mirror')
							(Print 32 15) ; "You see a dusty, old mirror hanging on the wall."
						)
						((>= gAct 2)
							(cond
								((Said '[<down][/dirt]')
									(cond
										((== gAct 2)
											(if (not (gEgo has: 6)) ; poker
												(Print 32 16) ; "A fireplace poker has been dropped on the library floor."
											)
											(Print 32 17) ; "You see some small pink feathers scattered upon the floor."
										)
										(
											(and
												(== gAct 3)
												(not (& global141 $0002))
											)
											(Print 32 17) ; "You see some small pink feathers scattered upon the floor."
										)
										(else
											(event claimed: 0)
											(return)
										)
									)
								)
								((Said '/chair')
									(if (< gAct 3)
										(Print 32 18) ; "A chair has been knocked askew."
									else
										(event claimed: 0)
									)
								)
								((Said '/nightstand')
									(Print 32 19) ; "You spy an open magazine on the library table. Why, this must be the magazine that Wilbur was reading!"
								)
								((Said '/magazine')
									(if (& (gEgo onControl:) $0040)
										(Print 32 20) ; "You read the name of the magazine. It's called, "The Racehorse Quarterly." Upon examining the open page you see a picture of a beautiful thoroughbred named "Sunny Boy." The name "Sunny Boy" has been circled in red."
									else
										(NotClose) ; "You're not close enough."
									)
								)
								((Said '/racehorse')
									(if (& (gEgo onControl:) $0040)
										(Print 32 21) ; "There are pictures of racehorses in Wilbur's magazine."
									else
										(Print 32 22) ; "You don't see any racehorses."
									)
								)
							)
						)
						((Said '/eye,(painting<eye)')
							(Print 32 23) ; "The dog's eyes are very black...almost hollow-looking."
						)
						((Said '<behind,below/painting')
							(Print 32 24) ; "You can see nothing behind the picture."
						)
						((or (Said '/painting') (Said '/painting/painting'))
							(Print 32 25) ; "Upon the wall opposite the fireplace hangs a portrait of a bloodhound (Beauregard?). Strange, the dog's eyes are very black...almost hollow-looking."
						)
					)
				)
				((Said 'move,get/painting')
					(Print 32 26) ; "The portrait is firmly attached to the wall."
				)
				((Said 'get>')
					(cond
						((Said '/fire,log')
							(Print 32 27) ; "Don't play with fire!"
						)
						((Said '/book/nightstand')
							(Print 32 28) ; "They don't look interesting."
						)
						((Said '/book')
							(Print 32 29) ; "You glance at the titles of various books, but frankly find most of them boring. You decide to pass."
						)
						((Said '/mirror')
							(Print 32 30) ; "The mirror is firmly attached to the wall."
						)
						((and (>= gAct 2) (< gAct 3))
							(cond
								((Said '/poker')
									(if (not (gEgo has: 6)) ; poker
										(if (& (gEgo onControl:) $0200)
											(self setScript: pickUp)
										else
											(NotClose) ; "You're not close enough."
										)
									else
										(AlreadyTook) ; "You already took it."
									)
								)
								((Said '/magazine')
									(Print 32 31) ; "Just another thing to carry around. Better leave it here."
								)
							)
						)
					)
				)
				((Said 'read>')
					(cond
						((Said '/book/nightstand')
							(Print 32 28) ; "They don't look interesting."
						)
						((Said '/book')
							(Print 32 29) ; "You glance at the titles of various books, but frankly find most of them boring. You decide to pass."
						)
						((and (>= gAct 2) (Said '/magazine'))
							(if (& (gEgo onControl:) $0040)
								(Print 32 20) ; "You read the name of the magazine. It's called, "The Racehorse Quarterly." Upon examining the open page you see a picture of a beautiful thoroughbred named "Sunny Boy." The name "Sunny Boy" has been circled in red."
							else
								(NotClose) ; "You're not close enough."
							)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance GateFunc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elevGate startUpd:)
				(if (== local3 1)
					(gConMusic number: 81)
					(elevGate setCycle: End)
					(|= gElevatorState $0001)
				else
					(gConMusic number: 79)
					(elevGate setCycle: Beg)
					(&= gElevatorState $fffe)
				)
				(gConMusic loop: 1 play: self)
				(if (!= local4 -1)
					(gEgo loop: local4)
				)
			)
			(1
				(elevGate ignoreActors: (elevGate cel:) stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LookAt gEgo poker)
				(= cycles 2)
			)
			(1
				(gEgo view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(Print 32 32) ; "As you retrieve the fireplace poker your eyes happen to fall upon some small pink feathers scattered upon the floor."
				(poker hide:)
				(= global182 1)
				(gEgo get: 6) ; poker
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo loop: 0 view: 0 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)

(instance shadowWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(Shadow setMotion: MoveTo 295 82 self)
			)
			(2
				(Shadow dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance mantle of RPicView
	(properties
		y 54
		x 192
		view 132
		priority 5
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {mantel})
		)
	)
)

(instance books of RPicView
	(properties
		y 120
		x 145
		view 132
		loop 1
		priority 10
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((Said 'look/book/nightstand')
				(Print 32 33) ; "You see some books on the table."
			)
			((or (MousedOn self event 3) (Said 'look/book'))
				(Print 32 33) ; "You see some books on the table."
				(event claimed: 1)
			)
		)
	)
)

(instance chair1 of RPicView
	(properties
		y 135
		x 200
		view 132
		loop 1
		cel 2
	)

	(method (handleEvent event)
		(cond
			((Said 'get,(get<up),straighten/chair')
				(if (== gAct 2)
					(Print 32 34) ; "Don't worry about it; Jeeves will get it."
				else
					(event claimed: 0)
				)
			)
			((MousedOn self event 3)
				(event claimed: 1)
				(DoLook {chair})
			)
		)
	)
)

(instance chair2 of RPicView
	(properties
		y 136
		x 108
		view 132
		loop 1
		cel 4
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair3 of RPicView
	(properties
		y 152
		x 118
		view 132
		loop 1
		cel 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair4 of RPicView
	(properties
		y 152
		x 153
		view 132
		loop 1
		cel 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair5 of RPicView
	(properties
		y 94
		x 265
		view 132
		loop 2
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance chair6 of RPicView
	(properties
		y 94
		x 118
		view 132
		loop 2
		cel 2
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {chair})
		)
	)
)

(instance sofa1 of RPicView
	(properties
		y 113
		x 131
		view 132
		loop 2
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance sofa2 of RPicView
	(properties
		y 113
		x 212
		view 132
		loop 2
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance table of RPicView
	(properties
		y 114
		x 71
		view 132
		loop 1
		cel 1
		signal 16384
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 32 35) ; "Some of these tables could use a good dusting!"
		)
	)
)

(instance tools of PV
	(properties
		y 91
		x 166
		view 132
		loop 3
	)
)

(instance fire of Prop
	(properties
		y 85
		x 191
		view 232
		priority 9
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/log'))
			(event claimed: 1)
			(DoLook {fire})
		)
	)
)

(instance poker of Prop
	(properties
		y 149
		x 189
		view 132
		loop 3
		cel 2
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 32 16) ; "A fireplace poker has been dropped on the library floor."
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 45
		x 119
		view 132
		loop 6
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lamp2 of Prop
	(properties
		y 45
		x 268
		view 132
		loop 6
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance Feather of Prop
	(properties
		y 151
		x 227
		view 132
		loop 5
	)

	(method (handleEvent event)
		(cond
			((Said 'get/feather')
				(Print 32 36) ; "You see no sense in carrying around a bunch of feathers."
			)
			((or (Said 'look/feather') (MousedOn self event 3))
				(Print 32 37) ; "You wonder how the small pink feathers got on the floor. They look like they may have come from a pillow...or...a feather boa!"
				(event claimed: 1)
			)
		)
	)
)

(instance Mag of Prop
	(properties
		y 116
		x 176
		view 132
		loop 1
		cel 5
		priority 10
		signal 16
	)

	(method (handleEvent event)
		(cond
			((Said 'open/magazine')
				(AlreadyOpen) ; "It is already open."
			)
			((or (Said 'rotate/page') (Said 'read<more/magazine'))
				(Print 32 38) ; "Except this one page, nothing else interests you about the magazine."
			)
			((or (Said 'look/magazine') (MousedOn self event 3))
				(event claimed: 1)
				(if (& (gEgo onControl:) $0040)
					(Print 32 20) ; "You read the name of the magazine. It's called, "The Racehorse Quarterly." Upon examining the open page you see a picture of a beautiful thoroughbred named "Sunny Boy." The name "Sunny Boy" has been circled in red."
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance Shaft of RFeature
	(properties
		nsTop 65
		nsLeft 281
		nsBottom 125
		nsRight 310
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {elevator})
		)
	)
)

(instance Mirror of RFeature
	(properties
		nsTop 13
		nsLeft 177
		nsBottom 41
		nsRight 211
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {mirror})
		)
	)
)

(instance Case1 of RFeature
	(properties
		nsTop 58
		nsBottom 139
		nsRight 38
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/bookcase'))
			(event claimed: 1)
			(Print 32 39) ; "The bookcases are crammed full of books."
		)
	)
)

(instance Case2 of RFeature
	(properties
		nsTop 24
		nsLeft 84
		nsBottom 76
		nsRight 107
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/bookcase'))
			(event claimed: 1)
			(Print 32 39) ; "The bookcases are crammed full of books."
		)
	)
)

(instance Shadow of Act
	(properties
		view 110
	)
)

(instance chain of Act
	(properties)
)

(instance elevator of Act
	(properties)
)

(instance down of View
	(properties)
)

(instance up of View
	(properties)
)

(instance elevGate of Prop
	(properties
		y 125
		x 283
		view 242
		loop 2
	)
)

