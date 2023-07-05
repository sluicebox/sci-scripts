;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use ElevGate)
(use Interface)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room42 0
)

(synonyms
	(mantel shelf)
	(drawer chest dresser)
	(armoire armoire closet)
	(boy painting)
	(room bedroom)
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(= global213 10)
	(Say 1 &rest)
)

(instance Room42 of Rm
	(properties
		picture 42
	)

	(method (init)
		(= horizon 0)
		(= east 43)
		(super init:)
		(gAddToPics
			add: bed table1 table2 table3 sofa mirror stand vase flower cannon
		)
		(if gDetailLevel
			(lamp1 setCycle: Fwd init:)
			(lamp2 setPri: 11 setCycle: Fwd init:)
			(logs setCycle: Fwd init:)
		else
			(logs init: stopUpd:)
			(lamp1 init: stopUpd:)
			(lamp2 setPri: 11 init: stopUpd:)
		)
		(gAddToPics eachElementDo: #init doit:)
		(self
			setRegions: 213 ; fireReg
			setFeatures:
				table1
				table2
				table3
				bed
				sofa
				cannon
				vase
				flower
				mirror
				Armoire
				SDress
				Shaft
		)
		(if (& gCorpseFlags $0040) ; Lillian
			(Dbag init: stopUpd:)
			(gAddToPics add: Chair eachElementDo: #init doit:)
			(self setFeatures: Chair)
		)
		(switch gPrevRoomNum
			(41
				(gEgo posn: 56 121)
			)
			(43
				(gEgo posn: 315 149)
			)
			(49
				(gEgo posn: 252 167)
			)
		)
		(gEgo view: 0 illegalBits: -32768 setPri: -1)
		(= global193 0)
		(if (not (& gElevatorState $0030))
			(cond
				((== gAct 0)
					(= global193 1)
					(if (and (not (& gSpyFlags $0040)) (!= [gCycleTimers 3] 1))
						(self setRegions: 231) ; kisscolo
					else
						(self setRegions: 240) ; coloroom
					)
				)
				(
					(or
						(IsFlag 38)
						(and
							(< gMinute 3)
							(not (& gCorpseFlags $0040)) ; Lillian
							(not (IsFlag 37))
						)
					)
					(= global193 1)
					(self
						setRegions:
							(switch gAct
								(4 270)
								(else 240)
							)
					)
				)
				((and (== gAct 4) (== gMinute 3))
					(LoadMany rsFONT 4 41)
					(LoadMany rsSOUND 29 94 95 96)
					(Load rsVIEW 642)
					(Load rsSCRIPT 406)
					(gAddToPics add: Chair eachElementDo: #init doit:)
					(self setFeatures: Chair setScript: missColo)
				)
			)
		)
		(if global193
			(= global111 42)
			(= local0 (PV new:))
			(local0 view: 242 loop: 0 cel: 0 x: 296 y: 126)
			(= local1 (PV new:))
			(local1 view: 242 loop: 2 cel: 0 x: 283 y: 126)
			(gAddToPics add: local0 local1 doit:)
			(gEgo init:)
			(&= gElevatorState $fff7)
		else
			(if (and (not (& gElevatorState $0030)) (not (& gCorpseFlags $0040))) ; Lillian
				(= global111
					(switch (Random 1 3)
						(1 32)
						(2 42)
						(3 75)
					)
				)
				(if (== gAct 1)
					(= global111 75)
				)
			)
			(= local1 (ElevGate new:))
			(local1
				chainID: chain
				elevatorID: elevator
				downID: down
				upID: up
				init:
			)
		)
	)

	(method (doit)
		(if (and (IsFirstTimeInRoom) (not (& gElevatorState $0010)))
			(if (== global111 gCurRoomNum)
				(Print 42 0) ; "This elegant room must be the Colonel's! You notice there is an elevator here."
			else
				(Print 42 1) ; "This elegant room must be the Colonel's! You notice there is an elevator shaft here."
			)
		)
		(if (& (gEgo onControl: 1) $0004)
			(gCurRoom newRoom: 41)
		)
		(if (not (& gElevatorState $0020))
			(if (gEgo inRect: 137 144 176 161)
				(gEgo setPri: 14)
			else
				(gEgo setPri: -1)
			)
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
		(DisposeScript 201)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 41) (== global201 200))
			(++ global201)
			(|= gCorpseFlags $0020) ; Clarence
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
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
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(if (== global111 gCurRoomNum)
								(Print 42 0) ; "This elegant room must be the Colonel's! You notice there is an elevator here."
							else
								(Print 42 1) ; "This elegant room must be the Colonel's! You notice there is an elevator shaft here."
							)
						)
						((Said '/mantel')
							(Print 42 2) ; "A miniature replica of a cannon from the Spanish-American War sits in the center of the mantel above the fireplace."
						)
						((Said '<in/elevator,lift')
							(if (not (& gElevatorState $0010))
								(Print 42 3) ; "It looks like an average elevator."
							else
								(event claimed: 0)
							)
						)
						((Said '/elevator,lift')
							(Print 42 4) ; "It's odd to see a new-fangled elevator in this old-fashioned house; but how else would the Colonel go up and down the stairs?"
						)
						((Said '/archway')
							(Print 42 5) ; "The gate protects passengers from falling out of the elevator."
						)
						((Said '/blind')
							(Print 42 6) ; "There are only cobwebs and dust behind the heavy shutters."
						)
						((and global193 (Said '/wheelchair'))
							(Print 42 7) ; "It appears the Colonel needs a wheelchair to get around."
						)
						((Said '/eye,(boy<eye)')
							(Print 42 8) ; "The eyes of the little boy have a strange, vacant look to them."
						)
						((Said '<behind,below/boy')
							(Print 42 9) ; "You can see nothing behind the picture."
						)
						((or (Said '/boy') (Said 'look/boy/boy'))
							(Print 42 10) ; "On the wall opposite the fireplace you notice a portrait of two children. Oddly, the eyes of the little boy have a strange, vacant look to them."
						)
					)
				)
				((Said 'move,get/boy')
					(Print 42 11) ; "The portrait is firmly attached to the wall."
				)
				((and (not global193) (Said 'get,move,press/wheelchair'))
					(Print 42 12) ; "There is no reason for you to move the wheelchair."
				)
				((Said 'get>')
					(cond
						((Said '/key[<brass]')
							(cond
								((not ((gInventory at: 18) ownedBy: 42)) ; brass_key
									(AlreadyTook) ; "You already took it."
								)
								((& (gEgo onControl: 1) $0020)
									(if ((gInventory at: 18) ownedBy: 42) ; brass_key
										(if (!= global193 1)
											(= global182 1)
											(gEgo get: 18) ; brass_key
											(Print 42 13) ; "You remove the key from the barrel of the cannon and take it with you."
										else
											(localproc_0 42 14)
										)
									else
										(NotHere) ; "You don't see it here."
									)
								)
								(else
									(NotClose) ; "You're not close enough."
								)
							)
						)
						((Said '/cannon')
							(Print 42 15) ; "The Colonel would notice if it were gone."
						)
					)
				)
				((and (not global193) (Said 'sit/wheelchair'))
					(Print 42 16) ; "You have better things to do than that!"
				)
				(global193
					(cond
						(
							(Said
								'open,enter,go/archway,elevator,lift[<elevator,lift]'
							)
							(localproc_0 42 17)
						)
						((Said 'smoke/butt')
							(Print 42 18) ; "You don't smoke!"
						)
						((Said 'sit[<down,in<in]/wheelchair')
							(Print 42 19) ; "In case you haven't noticed, the wheelchair is already occupied."
						)
						((Said 'press,move/wheelchair,colonel')
							(Print 42 20) ; "The Colonel wouldn't like that."
						)
					)
				)
			)
		)
	)
)

(instance missColo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0004))
						(|= gMustDos $0004)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(SetFlag 37)
				(client setScript: 0)
			)
		)
	)
)

(instance bed of RPicView
	(properties
		y 167
		x 121
		view 142
		loop 1
		cel 2
		signal 16384
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look[<!*]/bed'))
			(Print 42 21) ; "The Colonel has a very elegant canopy bed."
			(event claimed: 1)
		)
	)
)

(instance table1 of RPicView
	(properties
		y 167
		x 148
		view 142
		loop 1
		cel 3
		priority 15
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance table2 of RPicView
	(properties
		y 167
		x 69
		view 142
		loop 1
		cel 3
		priority 15
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance sofa of RPicView
	(properties
		y 125
		x 158
		view 142
		loop 1
		priority 8
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {couch})
		)
	)
)

(instance mirror of RPicView
	(properties
		y 141
		x 41
		view 142
		loop 1
		cel 1
		priority 9
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((or (Said 'look[<at]/reflection') (Said 'look<in/mirror'))
				(if (< (gEgo distanceTo: mirror) 60)
					(= global213 12)
					(Say 0 42 22) ; "You gaze into the mirror and appraise your appearance. A bit disheveled, perhaps, but not bad... considering the circumstances."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'look<behind,below/mirror')
				(Print 42 23) ; "There is nothing of interest behind the mirror."
			)
			((Said 'get,move/mirror')
				(Print 42 24) ; "The mirror is firmly attached to the dressing table."
			)
			((Said 'look/mirror')
				(Print 42 25) ; "The oval-framed mirror is attached to the dressing table."
			)
			((Said 'open,(look<in)/vanity,(nightstand<dressing)')
				(Print 42 26) ; "Don't be such a snoop, Laura!"
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/vanity,(nightstand<dressing)')
				)
				(Print 42 27) ; "A dressing table sits against the wall with a large mirror attached to it."
				(event claimed: 1)
			)
		)
	)
)

(instance table3 of RPicView
	(properties
		y 123
		x 202
		view 142
		loop 1
		cel 4
		priority 8
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance cannon of RPicView
	(properties
		y 52
		x 190
		view 142
		loop 1
		cel 5
	)

	(method (handleEvent event)
		(cond
			((Said 'search,(look<(in,in,in))/cannon,barrel')
				(if (& (gEgo onControl: 1) $0020)
					(if ((gInventory at: 18) ownedBy: 42) ; brass_key
						(Print 42 28) ; "You see a tarnished, brass key hidden inside the barrel of the cannon."
					else
						(Print 42 29) ; "You see nothing inside the barrel of the cannon."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'attach/key/cannon')
				(Print 42 30) ; "You better keep it. It may come in handy."
			)
			((or (MousedOn self event 3) (Said 'look/cannon'))
				(event claimed: 1)
				(Print 42 31) ; "It is a miniature replica of a cannon from the Spanish-American War rendered in pewter and wood."
			)
		)
	)
)

(instance vase of RPicView
	(properties
		y 52
		x 210
		view 142
		loop 1
		cel 7
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {vase})
		)
	)
)

(instance flower of RPicView
	(properties
		y 52
		x 170
		view 142
		loop 1
		cel 8
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {vase})
		)
	)
)

(instance Chair of RPicView
	(properties
		y 150
		x 217
		view 142
		loop 1
		cel 9
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/wheelchair'))
			(event claimed: 1)
			(Print 42 32) ; "Hmmmm...the Colonel's wheelchair sits empty in the middle of the room."
		)
	)
)

(instance stand of PV
	(properties
		y 90
		x 169
		view 142
		loop 1
		cel 6
	)
)

(instance logs of Prop
	(properties
		y 86
		x 189
		view 142
		loop 2
		priority 5
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/oak,log'))
			(event claimed: 1)
			(DoLook {fire})
		)
	)
)

(instance lamp1 of Prop
	(properties
		y 44
		x 80
		view 142
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
		y 76
		x 15
		view 142
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance Dbag of Prop
	(properties
		y 120
		x 220
		view 142
		loop 1
		cel 10
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(cond
			((Said 'get/bag')
				(Print 42 33) ; "It would be wise to leave it alone."
			)
			((Said 'open/bag')
				(AlreadyOpen) ; "It is already open."
			)
			((Said 'look<in/bag')
				(if (< (gEgo distanceTo: Dbag) 10)
					(Print 42 34) ; "The contents are a mess inside. It looks as if someone has hurriedly searched through it."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			(
				(or
					(MousedOn self event 3)
					(Said 'look/bag,dirt')
					(Said 'look<down')
				)
				(event claimed: 1)
				(Print 42 35) ; "Someone has left the Doctor's bag open on the floor."
			)
		)
		(if (event claimed:)
			(SetFlag 32)
		)
	)
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

(instance Shaft of RFeature
	(properties
		nsTop 65
		nsLeft 284
		nsBottom 126
		nsRight 311
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {elevator})
		)
	)
)

(instance SDress of RFeature
	(properties
		nsTop 53
		nsLeft 92
		nsBottom 87
		nsRight 124
	)

	(method (handleEvent event)
		(cond
			((Said '(look<in),open/drawer')
				(Print 42 36) ; "There is nothing of interest in the chest of drawers."
			)
			((or (MousedOn self event 3) (Said 'look/drawer'))
				(event claimed: 1)
				(Print 42 37) ; "A large chest of drawers occupies a corner of the room."
			)
		)
	)
)

(instance Armoire of RFeature
	(properties
		nsTop 67
		nsLeft 256
		nsBottom 127
		nsRight 274
	)

	(method (handleEvent event)
		(cond
			((Said '/panel,(door<hidden)>')
				(cond
					((Said 'look')
						(if (& global175 $0010)
							(Print 42 38) ; "Even though you know where it is, you can't see it."
						else
							(Print 42 39) ; "You don't see one."
						)
					)
					((and (& global175 $0010) (Said 'open,move'))
						(if (not global193)
							(if (& (gEgo onControl: 1) $0080)
								(gCurRoom newRoom: 49)
							else
								(NotClose) ; "You're not close enough."
							)
						else
							(Print 42 40) ; "Better not while someone is in the room."
						)
					)
				)
			)
			((Said 'move/armoire')
				(Print 42 41) ; "It's too heavy to move."
			)
			(
				(or
					(Said 'look<(in,in,in)/armoire')
					(Said 'open/armoire,(door<armoire)')
				)
				(Print 42 42) ; "There is nothing of interest in the armoire."
			)
			((or (MousedOn self event 3) (Said 'look/armoire'))
				(event claimed: 1)
				(Print 42 43) ; "You see the Colonel's armoire against the side wall."
			)
		)
	)
)

