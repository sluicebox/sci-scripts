;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use Submarine_806)
(use n824)
(use n828)
(use Approach)
(use n954)
(use Track)
(use LoadMany)
(use Grooper)
(use RFeature)
(use Sight)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	torpedoRm 0
)

(synonyms
	(floor down)
	(torpedo gun)
)

(local
	[local0 12] = [198 196 193 192 189 189 190 189 190 188 187 187]
	[local12 12] = [16 17 17 18 19 19 21 22 24 26 28 28]
	local24
)

(procedure (localproc_0)
	(explosivesDoor stopUpd:)
	(cond
		((and (not (gEgo has: 3)) (== global103 0)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
			(Print 33 68) ; "Inside the cabinet you see plastic explosives used in underwater demolition, two boxes of flares, and some other things that don't interest you."
		)
		((and (not (gEgo has: 3)) (== global103 4)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
			(Print 33 69) ; "Inside the cabinet you see plastic explosives used in underwater demolition, one box of flares, and some other things that don't interest you."
		)
		((not (gEgo has: 3)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
			(Print 33 70) ; "Inside the cabinet you see plastic explosives used in underwater demolition and some other things that don't interest you."
		)
		((== global103 0)
			(Print 33 71) ; "Inside the cabinet you see two boxes of flares and some other things that don't interest you."
		)
		((== global103 4)
			(Print 33 72) ; "Inside the cabinet you see one box of flares and some other things that don't interest you."
		)
		(else
			(Print 33 73) ; "You see nothing of interest inside the cabinet."
		)
	)
	(HandsOn)
)

(instance torpedoRm of Rm
	(properties
		picture 33
		west 42
	)

	(method (init)
		(super init:)
		(User x: 13 y: 140)
		(LoadMany
			rsSOUND
			13
			213
			19
			219
			33
			233
			87
			287
			86
			286
			48
			248
			85
			285
			88
			288
			24
			224
		)
		(entryDoor init:)
		(missileTube init:)
		(firstMissileHolder init:)
		(explosivesDoor init:)
		(missileOne init:)
		(missileGrabber init:)
		(conveyorBelt init:)
		(conveyorStand init:)
		(if (not (& (subMarine roomFlags:) $0400))
			(subMarine roomFlags: (| (subMarine roomFlags:) $0400))
			(torpedoMan
				init:
				setLoop: -1
				loop: 3
				heading: 0
				setCycle: Walk
				setLoop: Grooper
				setScript: torpedoManScript
			)
		)
		(if (>= (Submarine torpedosLeft:) 2)
			(gAddToPics add: missileTwo)
			(if (>= (Submarine torpedosLeft:) 3)
				(gAddToPics add: missileThree)
				(if (>= (Submarine torpedosLeft:) 4)
					(gAddToPics add: missileFour)
					(if (>= (Submarine torpedosLeft:) 5)
						(gAddToPics add: missileFive)
						(if (>= (Submarine torpedosLeft:) 6)
							(gAddToPics add: missileSix)
							(if (>= (Submarine torpedosLeft:) 7)
								(gAddToPics add: missileSeven)
								(if (>= (Submarine torpedosLeft:) 8)
									(gAddToPics add: missileEight)
								)
							)
						)
					)
				)
			)
		)
		(gAddToPics
			add: secondMissileHolder thirdMissileHolder panel
			eachElementDo: #init
			doit:
		)
		(self setRegions: 314) ; subMarine
		(proc824_0)
		(gEgo init: illegalBits: 0 ignoreActors: 0 view: 232 posn: 9 52)
		(doorScript register: 1)
		(if (& (subMarine roomFlags:) $0800)
			(conveyorBelt posn: 91 93 setPri: 8 setScript: 0 stopUpd:)
			(conveyorStand posn: 97 117 setPri: 7 stopUpd:)
			(missileGrabber setCel: 11 setPri: 4)
			(if (not (& (subMarine roomFlags:) $2000))
				(missileOne posn: 130 71 setPri: 9 setScript: 0 stopUpd:)
			)
			(missileTube posn: 220 134 stopUpd:)
		)
	)

	(method (newRoom newRoomNumber)
		(User x: -1 y: -1)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene]')
				(Print 33 0) ; "Looking around the torpedo room you see a full complement of torpedoes, missiles and decoys secured against the bulkhead."
				(Print 33 1) ; "Hydraulic arms and conveyors are used to move the weapons."
				(Print 33 2) ; "Located on the forward bulkhead are the torpedo tube doors."
				(Print 33 3) ; "You also see a small door marked "Explosives.""
			)
			((Said 'look/floor')
				(Print 33 4) ; "You see the well-polished floor below."
			)
		)
	)
)

(instance torpedoMan of Act
	(properties
		y 55
		x 116
		view 132
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/man<old]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 5) ; "Chief Petty Officer Jacob Flanagan."
					)
					((GoToIfSaid self event self 30 0 33 6))
					((Said 'ask,get/name[<man]')
						(Print 33 7) ; "Me name is Jacob Flanagan, sir."
					)
					((Said 'talk')
						(if local24
							(Print 33 8) ; "Flanagan doesn't have much else to say right now."
						else
							(Print 33 9) ; "The Old Salt says, "I cycled me equipment early this morning, Commander, and it sounded a wee bit strange. There could be a problem.""
							(= local24 1)
						)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance torpedoManScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(torpedoMan heading: 180)
				((torpedoMan looper:) doit: torpedoMan (torpedoMan heading:))
				(= cycles 5)
			)
			(2
				(torpedoMan cel: 5)
				(Print 33 10) ; "Good day, Commander."
				(= seconds 30)
			)
			(3
				(torpedoMan setScript: saltOutScript)
			)
		)
	)
)

(instance saltOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(Print 33 11 #time 5 #dispose) ; "If ya won't be needin' me, sir, I'll be on me way."
				(torpedoMan
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 10 60 self
				)
			)
			(1
				(proc0_3)
				(entryDoor setMotion: MoveTo 0 7 self)
			)
			(2
				(entryDoor stopUpd:)
				(torpedoMan setMotion: MoveTo 10 52 self)
			)
			(3
				(entryDoor setMotion: MoveTo 0 58 self)
			)
			(4
				(if (not (conveyorBelt script:))
					(HandsOn)
				)
				(entryDoor stopUpd:)
				(torpedoMan cue:)
				(self dispose:)
			)
		)
	)
)

(instance panel of RPicView
	(properties
		y 67
		x 280
		view 233
		loop 6
		cel 2
		priority 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/control,panel]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 12) ; "The control panel for the weapons conveyor has a button for cycling the equipment."
					)
				)
			)
			((Said '/button>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 13) ; "The button that cycles the equipment."
					)
					((GoToIfSaid self event 261 84 'push,press' 33 6))
					((Said 'push,press,(turn<on)')
						(conveyorBelt setScript: cycleEquipment)
					)
				)
			)
		)
	)
)

(instance conveyorBelt of Act
	(properties
		y 93
		x 91
		view 233
		loop 5
		priority 8
		signal 18449
		illegalBits 0
	)

	(method (cue)
		(super cue:)
		(HandsOn)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/conveyor,belt,(belt<conveyor),equipment,machine,hole]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 14) ; "The conveyor is used to load or unload weapons."
					)
					(
						(GoToIfSaid
							self
							event
							261
							84
							'cycle,check,start,(turn<on)'
							33
							6
						))
					((Said 'cycle,check,start,(turn<on)')
						(conveyorBelt setScript: cycleEquipment)
					)
					((GoToIfSaid self event 105 95 0 33 6))
					((Said 'measure')
						(HandsOff)
						(gEgo heading: 180)
						((gEgo looper:)
							doit: gEgo (gEgo heading:) self
						)
						(cond
							((not (& (subMarine roomFlags:) $0800))
								(Print 33 15) ; "You see no reason to do that."
							)
							((not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
								(Print 33 16) ; "You have nothing to measure with."
							)
							((not (& (subMarine roomFlags:) $4000))
								(Print 33 17) ; "Measuring the hole on the conveyor where the malfunction occurred is impossible since a sheared cylinder is in the way."
							)
							((not (& (subMarine roomFlags:) $1000))
								(Print 33 18) ; "Measuring the hole on the conveyor where the malfunction occurred, you determine the replacement cylinder must be 6" long and 1" in diameter."
							)
							(else
								(Print 33 19) ; "You've installed the new cylinder. There's no need for that."
							)
						)
					)
					((Said 'check,examine,examine')
						(cond
							(
								(and
									(& (subMarine roomFlags:) $0800)
									(not (& (subMarine roomFlags:) $1000))
									(not (& (subMarine roomFlags:) $4000))
								)
								(Print 33 20) ; "Inspecting the conveyor you find a sheared cylinder. You reach down and remove it."
								(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(subMarine invStatus1: 4)
								(subMarine
									roomFlags: (| (subMarine roomFlags:) $4000)
								)
							)
							(
								(and
									(not (& (subMarine roomFlags:) $1000))
									(& (subMarine roomFlags:) $4000)
								)
								(Print 33 21) ; "You see the hole from which you removed the sheared cylinder."
							)
							((& (subMarine roomFlags:) $1000)
								(Print 33 22) ; "You see the new cylinder that you installed."
							)
							(else
								(Print 33 23) ; "You inspect the equipment which appears to be functional."
							)
						)
					)
					((Said 'stop')
						(Print 33 24) ; "The equipment is not cycling, and, therefore, cannot be stopped."
					)
					((Said 'fix,repair')
						(gEgo setScript: fixEquipment)
					)
				)
			)
			((Said 'use/pin')
				(if (gEgo has: 9) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
					(Print 33 25) ; "You'll have to be more specific."
				else
					(proc0_38) ; "You don't have that."
				)
			)
			(
				(GoToIfSaid
					self
					event
					105
					95
					'insert,install,(adjust[<in,on])/pin[/conveyor,equipment]'
					33
					6
				))
			((Said 'insert,install,(adjust[<in,on])/pin[/conveyor,equipment]')
				(gEgo setScript: installGoodCotterPin)
			)
			((Said '/cylinder>')
				(cond
					((Said 'measure')
						(cond
							((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 33 26) ; "You don't have a cylinder."
							)
							((not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
								(Print 33 27) ; "You have nothing to measure it with."
							)
							(
								(and
									(gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
									(!= (subMarine invStatus1:) 4)
								)
								(Printf ; "The cylinder is %s" long."
									33
									28
									(switch (subMarine invStatus1:)
										(1 {3})
										(2 {4})
										(3 {6})
									)
								)
								(if (subMarine cylDiam:)
									(Printf ; "It has been turned to a diameter of %s."
										33
										29
										(switch (subMarine cylDiam:)
											(1 {1"})
											(2 {1.5"})
											(3 {2"})
										)
									)
								)
								(if (subMarine holeSize:)
									(Printf ; "It has a %s hole drilled near one end."
										33
										30
										(switch (subMarine holeSize:)
											(1 {1/32"})
											(2 {1/16"})
											(3 {1/8"})
											(4 {1/4"})
											(5 {1/2"})
											(6 {3/4"})
											(7 {1"})
										)
									)
								)
								(if (& (subMarine roomFlags:) $0004)
									(Print 33 31) ; "The rough edges have been ground smooth."
								else
									(Print 33 32) ; "It has rough edges."
								)
							)
							(else
								(Print 33 33) ; "The diameter of the sheared cylinder is 1", and the cotter pin hole is 1/4". You can't tell how long the cylinder was because it has been sheared off."
								(SetScore subMarine 406 32 5)
							)
						)
					)
					((TurnIfSaid self event 'examine,examine,look[<at]/*'))
					((Said 'examine,examine,look[<at]')
						(cond
							((not (& (subMarine roomFlags:) $4000))
								(Print 33 34) ; "A cylinder with a hole in one end for a cotter pin."
							)
							((& (Submarine flags:) $0100)
								(Print 33 35) ; "You see the cylinder and cotter pin you installed."
							)
							((& (subMarine roomFlags:) $1000)
								(Print 33 36) ; "You see the cylinder you installed."
							)
							(else
								((gInventory at: 12) showSelf:) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							)
						)
					)
					((GoToIfSaid self event 105 95 0 33 6))
					((Said 'get,detach,replace/*')
						(HandsOff)
						(gEgo heading: 180)
						((gEgo looper:)
							doit: gEgo (gEgo heading:) self
						)
						(cond
							((not (& (subMarine roomFlags:) $0800))
								(Print 33 15) ; "You see no reason to do that."
							)
							((& (Submarine flags:) $0100)
								(Print 33 37) ; "You've already completed the repair. Don't undo all your work."
							)
							((& (subMarine roomFlags:) $1000)
								(Print 33 38) ; "You remove the cylinder."
								(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(subMarine
									roomFlags: (& (subMarine roomFlags:) $efff)
								)
							)
							(
								(and
									(gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
									(== (subMarine invStatus1:) 4)
								)
								(Print 33 39) ; "You already have the sheared cylinder."
							)
							(else
								(Print 33 40) ; "You remove the sheared cylinder."
								(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(subMarine invStatus1: 4)
								(subMarine
									roomFlags: (| (subMarine roomFlags:) $4000)
								)
							)
						)
					)
					((Said '(adjust<in,on),repair,fix,install,insert')
						(gEgo setScript: fixEquipment)
					)
				)
			)
		)
	)
)

(instance fixEquipment of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (& (subMarine roomFlags:) $0800))
						(Print 33 15) ; "You see no reason to do that."
					)
					((& (Submarine flags:) $0100)
						(Print 33 41) ; "You need not fix the conveyor again."
					)
					(
						(and
							(& (subMarine roomFlags:) $1000)
							(not (& (Submarine flags:) $0100))
						)
						(Print 33 42) ; "You will need to install a cotter pin."
					)
					(
						(or
							(not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							(and
								(gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(== (subMarine invStatus1:) 4)
							)
						)
						(Print 33 43) ; "You do not have a replacement cylinder."
					)
					((!= (subMarine invStatus1:) 3)
						(Print 33 44) ; "The replacement cylinder is not long enough."
					)
					((!= (subMarine cylDiam:) 1)
						(Print 33 45) ; "The replacement cylinder is too big around."
					)
					((not (& (subMarine roomFlags:) $0004))
						(Print 33 46) ; "You need to smooth the cylinder's rough edges."
					)
					(else
						(Print 33 47) ; "You slide the cylinder into the conveyor."
						(Print 33 48) ; ""Well, so much for the cylinder," you think."
						(gEgo put: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
						(subMarine roomFlags: (| (subMarine roomFlags:) $1000))
						(SetScore subMarine 407 1024 1)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance installGoodCotterPin of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 1)
				(HandsOff)
				(gEgo heading: 180)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(cond
					((not (gEgo has: 9)) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
						(Print 33 49) ; "You don't have a cotter pin."
						(= temp0 0)
					)
					((& (Submarine flags:) $0100)
						(Print 33 50) ; "You've already installed one."
						(= temp0 0)
					)
					((not (& (subMarine roomFlags:) $1000))
						(Print 33 51) ; "You haven't installed a new cylinder."
						(= temp0 0)
					)
					((not (gEgo has: 15)) ; Hammer
						(Print 33 52) ; "You'll need a hammer to properly install the cotter pin."
						(= temp0 0)
					)
					((not (subMarine holeSize:))
						(Print 33 53) ; "There is no hole in the cylinder for the cotter pin."
						(= temp0 0)
					)
					((< (subMarine holeSize:) 4)
						(Print 33 54) ; "The hole is too small for the cotter pin."
						(= temp0 0)
					)
					((> (subMarine holeSize:) 4)
						(Print 33 55) ; "The hole is too large for the cotter pin."
						(= temp0 0)
					)
				)
				(if temp0
					(= cycles 1)
				else
					(self dispose:)
					(HandsOn)
				)
			)
			(1
				(gEgo
					setAvoider: Avoid
					setMotion: Approach conveyorBelt 60 self
				)
			)
			(2
				(theSound number: (proc0_5 33) loop: 4 play:)
				(Print 33 56) ; "Using the hammer, you pound the cotter pin into place."
				(gEgo setAvoider: 0 put: 9) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
				(gGame changeScore: 1)
				(subMarine cylDiam: 0)
				(subMarine holeSize: 0)
				(subMarine roomFlags: (& (subMarine roomFlags:) $fffb))
				(Submarine flags: (| (Submarine flags:) $0100))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cycleEquipment of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(
						(and
							(& (subMarine roomFlags:) $0800)
							(not (& (subMarine roomFlags:) $1000))
						)
						(Print 33 57) ; "The conveyor has not been fixed."
						(self dispose:)
					)
					(
						(and
							(& (subMarine roomFlags:) $0800)
							(& (subMarine roomFlags:) $1000)
							(not (& (Submarine flags:) $0100))
						)
						(Print 33 58) ; "The cylinder has been installed, but not the cotter pin."
						(self dispose:)
					)
					((& (subMarine roomFlags:) $2000)
						(Print 33 59) ; "You need not cycle the equipment again."
						(self dispose:)
					)
					(else
						(HandsOff)
						(gEgo heading: 225)
						((gEgo looper:) doit: gEgo (gEgo heading:))
						(= cycles 5)
					)
				)
			)
			(1
				(if (& (Submarine flags:) $0100)
					(self setScript: cycleEquipmentPartTwoScript)
				else
					(= cycles 1)
				)
			)
			(2
				(if
					(and
						(gCast contains: torpedoMan)
						(!= (torpedoMan script:) saltOutScript)
					)
					(torpedoMan setScript: saltOutScript self)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo setPri: 4 stopUpd:)
				(missileOne setPri: 6)
				(conveyorStand setPri: 4)
				(conveyorBelt setPri: 5)
				(missileGrabber setPri: 7)
				(theSound number: (proc0_5 87) loop: -1 play:)
				(conveyorBelt setMotion: MoveTo 154 61 self)
				(conveyorStand setMotion: Track conveyorBelt 6 24)
			)
			(4
				(= seconds 2)
			)
			(5
				(conveyorStand setMotion: 0)
				(theSound number: (proc0_5 85) loop: 1 play:)
				(conveyorBelt setMotion: MoveTo 154 49 self)
			)
			(6
				(theSound number: (proc0_5 86) loop: 1 play:)
				(= cycles 6)
			)
			(7
				(theSound number: (proc0_5 48) loop: 1 play:)
				(missileGrabber setCycle: End self)
			)
			(8
				(theSound number: (proc0_5 86) loop: 1 play: self)
			)
			(9
				(if (not (& (Submarine flags:) $0100))
					(Print 33 60 #at 190 120) ; "You watch as the powerful hydraulic arms pick up the torpedo and transfer it onto the conveyor."
				)
				(= cycles 1)
			)
			(10
				(missileOne setMotion: MoveTo 190 29 self)
			)
			(11
				(missileGrabber stopUpd:)
				(theSound number: (proc0_5 85) loop: 1 play:)
				(conveyorBelt setMotion: MoveTo 154 61 self)
				(missileOne setMotion: Track conveyorBelt 36 -20)
			)
			(12
				(theSound number: (proc0_5 86) loop: 1 play: self)
			)
			(13
				(theSound number: (proc0_5 87) loop: -1 play:)
				(conveyorBelt setMotion: MoveTo 91 93 self)
				(conveyorStand setMotion: Track conveyorBelt 6 24)
				(missileOne setMotion: Track conveyorBelt 36 -20)
			)
			(14
				(theSound number: (proc0_5 86) loop: 1 play:)
				(conveyorStand stopUpd:)
				(missileOne setMotion: 0 posn: 130 71)
				(if (not (& (Submarine flags:) $0100))
					(Print 33 61 #at 5 6) ; "You continue to watch as the conveyor feeds the weapon towards the open torpedo tube."
				)
				(= cycles 1)
			)
			(15
				(theSound number: (proc0_5 88) loop: 1 play:)
				(missileTube setMotion: MoveTo 220 134 self)
			)
			(16
				(self setScript: cycleEquipmentPartTwoScript)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (< 2 state 9) (not (& (Submarine flags:) $0100)) (not script))
			(missileOne
				posn:
					[local0 (missileGrabber cel:)]
					[local12 (missileGrabber cel:)]
			)
		)
	)
)

(instance cycleEquipmentPartTwoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theSound stop:)
				(if (& (Submarine flags:) $0100)
					(Print 33 62 #at 0 113) ; "Again you watch. This time the conveyor successfully feeds the weapon into the torpedo tube."
				else
					(theSound number: (proc0_5 24) loop: -1 play:)
				)
				(= cycles 1)
			)
			(1
				(conveyorBelt setPri: 8)
				(conveyorStand setPri: (- (conveyorBelt priority:) 1))
				(missileGrabber setPri: (+ (firstMissileHolder priority:) 1))
				(missileOne setPri: (+ (conveyorBelt priority:) 1))
				(missileTube stopUpd:)
				(gEgo setPri: -1 ignoreActors: 0 stopUpd:)
				(HandsOn)
				(subMarine roomFlags: (| (subMarine roomFlags:) $0800))
				(if (& (Submarine flags:) $0100)
					(missileOne setMotion: 0)
					(self setScript: goodConveyorScript)
				else
					(missileOne setMotion: 0)
					(self setScript: messedUpConveyorScript self)
				)
			)
			(2
				(missileOne setScript: 0 stopUpd:)
				(conveyorBelt setScript: 0 stopUpd:)
				(theSound stop:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goodConveyorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(conveyorBelt setCycle: Fwd)
				(missileOne setPri: 11 setMotion: MoveTo 241 107 self)
			)
			(1
				(conveyorBelt setCycle: 0 stopUpd:)
				(missileOne setMotion: MoveTo 293 124 self)
			)
			(2
				(HandsOn)
				(subMarine roomFlags: (| (subMarine roomFlags:) $2000))
				(missileOne stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance messedUpConveyorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(missileOne posn: (+ (missileOne x:) 2) (+ (missileOne y:) 2))
				(conveyorBelt
					posn: (- (conveyorBelt x:) 1) (- (conveyorBelt y:) 1)
				)
				(conveyorBelt setCycle: CT 3 1 self)
			)
			(1
				(missileOne posn: (- (missileOne x:) 2) (- (missileOne y:) 2))
				(conveyorBelt
					posn: (+ (conveyorBelt x:) 1) (+ (conveyorBelt y:) 1)
				)
				(conveyorBelt setCycle: CT 0 -1 self)
			)
			(2
				(if (> (++ register) 3)
					(= cycles 1)
				else
					(self init:)
				)
			)
			(3
				(Print 33 63 #at 0 113) ; "With a loud ratcheting sound, the conveyor comes to a stop, failing to complete its cycle."
				(self dispose:)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		priority 2
	)
)

(instance missileTube of Act
	(properties
		y 147
		x 274
		view 233
		loop 7
		priority 10
		signal 18449
		illegalBits 0
	)
)

(instance firstMissileHolder of Prop
	(properties
		y 68
		x 240
		view 233
		signal 17
		nsTop 19
		nsLeft 183
		nsBottom 60
		nsRight 244
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/arm<hydraulic]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 64) ; "The hydraulic arms are used to transfer the weapons to the conveyor."
					)
				)
			)
		)
	)
)

(instance secondMissileHolder of RPicView
	(properties
		y 43
		x 141
		view 233
		priority 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/arm<hydraulic]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 64) ; "The hydraulic arms are used to transfer the weapons to the conveyor."
					)
				)
			)
		)
	)
)

(instance thirdMissileHolder of RPicView
	(properties
		y 148
		x 75
		view 233
		cel 2
		priority 11
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/arm<hydraulic]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 64) ; "The hydraulic arms are used to transfer the weapons to the conveyor."
					)
				)
			)
		)
	)
)

(instance missileGrabber of Act
	(properties
		y 16
		x 197
		view 233
		loop 1
		priority 1
		signal 18449
		illegalBits 0
	)
)

(instance missileOne of Act
	(properties
		y 16
		x 198
		yStep 1
		view 233
		loop 4
		cel 3
		priority 1
		signal 18449
		illegalBits 0
		xStep 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/missile]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 65) ; "The "Harpoon" delivers its destructive payload through the air at subsonic speeds."
					)
				)
			)
		)
	)
)

(instance missileTwo of RPicView
	(properties
		y 37
		x 192
		view 233
		loop 4
		cel 1
		priority 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/torpedo]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 66) ; "The "Emerson 92" decoy is designed to emit an acoustical signature identical to that of the USS Blackhawk."
					)
				)
			)
		)
	)
)

(instance missileThree of RPicView
	(properties
		y -10
		x 103
		view 233
		loop 4
		priority 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/missile]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 65) ; "The "Harpoon" delivers its destructive payload through the air at subsonic speeds."
					)
				)
			)
		)
	)
)

(instance missileFour of RPicView
	(properties
		y 35
		x 118
		view 233
		loop 4
		cel 2
		priority 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/decoy]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 67) ; "The "Sting Ray" torpedo is equipped with a low yield nuclear warhead that delivers the equivalent of 500 pounds of TNT at a speed of 90 knots."
					)
				)
			)
		)
	)
)

(instance missileFive of RPicView
	(properties
		y 109
		x 96
		view 233
		loop 4
		cel 1
		priority 11
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/torpedo]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 66) ; "The "Emerson 92" decoy is designed to emit an acoustical signature identical to that of the USS Blackhawk."
					)
				)
			)
		)
	)
)

(instance missileSix of RPicView
	(properties
		y 129
		x 106
		view 233
		loop 4
		priority 9
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/missile]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 65) ; "The "Harpoon" delivers its destructive payload through the air at subsonic speeds."
					)
				)
			)
		)
	)
)

(instance missileSeven of RPicView
	(properties
		y 123
		x 6
		view 233
		loop 4
		cel 2
		priority 11
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/decoy]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 67) ; "The "Sting Ray" torpedo is equipped with a low yield nuclear warhead that delivers the equivalent of 500 pounds of TNT at a speed of 90 knots."
					)
				)
			)
		)
	)
)

(instance missileEight of RPicView
	(properties
		y 104
		x 13
		view 233
		loop 4
		cel 2
		priority 11
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/decoy]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 67) ; "The "Sting Ray" torpedo is equipped with a low yield nuclear warhead that delivers the equivalent of 500 pounds of TNT at a speed of 90 knots."
					)
				)
			)
		)
	)
)

(instance conveyorStand of Act
	(properties
		y 117
		x 97
		view 233
		cel 3
		priority 7
		signal 18449
		illegalBits 0
	)
)

(instance entryDoor of Act
	(properties
		y 3
		view 233
		cel 4
		priority 2
		signal 26641
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(User controls:)
				(== (gEgo onControl: 1) 4)
				(not (self script:))
			)
			(HandsOff)
			(entryDoor setScript: doorScript)
		)
	)

	(method (setMotion)
		(super setMotion: &rest)
		(theSound number: (proc0_5 13) loop: 1 play:)
	)

	(method (stopUpd)
		(super stopUpd: &rest)
		(theSound number: (proc0_5 19) loop: 1 play:)
	)

	(method (cue)
		(super cue: &rest)
		(self stopUpd:)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 ignoreActors:)
				(entryDoor setMotion: MoveTo 0 7 self)
			)
			(1
				(if register
					(gEgo setMotion: MoveTo 27 73 self)
				else
					(gEgo setMotion: MoveTo 10 52 self)
				)
			)
			(2
				(entryDoor setMotion: MoveTo 0 58 entryDoor)
				(gEgo illegalBits: $8000 ignoreActors: 0 setPri: -1)
				(if (not register)
					(gCurRoom newRoom: 42) ; bHatchTubeRm
				)
				(= register 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance explosivesDoor of Prop
	(properties
		y 23
		x 37
		view 233
		loop 8
		priority 4
		signal 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door,compartment,closet,cabinet]>')
				(cond
					((Said 'look<in')
						(if (== (gEgo onControl: 1) 2048)
							(localproc_0)
						else
							(Print 33 74) ; "Walk up to the door."
						)
					)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'close')
						(proc0_39) ; "You don't need to do that."
					)
					((Said 'look[<at]')
						(Print 33 75) ; "This door is labelled "Explosives"."
					)
					((GoToIfSaid self event self 10 'open' 33 6))
					((Said 'open')
						(gEgo setMotion: MoveTo 39 31)
					)
				)
			)
			((Said '/flare>')
				(cond
					((not cel)
						(event claimed: 1)
						(proc0_40) ; "You don't see that."
					)
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look[<at]')
						(if (>= global103 8)
							(event claimed: 0)
						else
							(Print 33 76) ; "Underwater flares."
						)
					)
					((Said 'get')
						(cond
							((not global103)
								(+= global103 4)
								(gEgo get: 7) ; Sub: Flare | Tunisia: Duct_Tape
								(Print 33 77) ; "You pick up a box of flares."
							)
							((== global103 4)
								(+= global103 4)
								(gGame changeScore: 1)
								(Print 33 78) ; "You pick up the second box of flares."
							)
							(else
								(proc0_40) ; "You don't see that."
							)
						)
					)
				)
			)
			((Said '/bomb>')
				(cond
					((not cel)
						(event claimed: 1)
						(proc0_40) ; "You don't see that."
					)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if (gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
							(event claimed: 0)
						else
							(Print 33 79) ; "Plastic explosives used for underwater demolition."
						)
					)
					((Said 'get')
						(if (gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
							(proc0_35) ; "You already took that."
						else
							(Print 33 80) ; "You take a plastic explosive possessing a charge equivalent to 500 lbs. of TNT."
							(gEgo get: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== (gEgo onControl: 1) 2048)
				(not (CantBeSeen self gEgo))
				(not (self script:))
			)
			(explosivesDoor setScript: openExplosivesDoorScript self)
		)
	)

	(method (cue)
		(super cue: &rest)
		(self setScript: 0 stopUpd:)
	)

	(method (stopUpd)
		(super stopUpd: &rest)
		(theSound number: (proc0_5 19) loop: 1 play:)
	)
)

(instance openExplosivesDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(explosivesDoor setCycle: End self)
			)
			(1
				(localproc_0)
			)
		)
	)

	(method (doit)
		(if
			(and
				(!= (gEgo onControl: 1) 2048)
				(client cel:)
				(not (client cycler:))
				(CantBeSeen client gEgo 180 20)
			)
			(client setCycle: Beg client)
		)
		(super doit:)
	)
)

