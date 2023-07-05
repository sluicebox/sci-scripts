;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n821)
(use n828)
(use n954)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	escapeHatchRm 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40])
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 38 0 param2) ; "%d"
	)
	(return
		(if (GetInput @temp0 10 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(procedure (localproc_1)
	(Print 38 1) ; "Input aborted."
)

(procedure (localproc_2)
	(= local1 -1)
	(if (== (= local1 (localproc_0 {Enter distance to waypoint #1:})) -1)
		(localproc_1)
		(return)
	else
		(subMarine dist1: local1)
	)
	(= local1 -1)
	(if (== (= local1 (localproc_0 {Enter heading to waypoint #1:})) -1)
		(localproc_1)
		(return)
	else
		(subMarine head1: local1)
	)
	(= local1 -1)
	(if (== (= local1 (localproc_0 {Enter distance to waypoint #2:})) -1)
		(localproc_1)
		(return)
	else
		(subMarine dist2: local1)
	)
	(= local1 -1)
	(if (== (= local1 (localproc_0 {Enter heading to waypoint #2:})) -1)
		(localproc_1)
		(return)
	else
		(subMarine head2: local1)
	)
)

(instance escapeHatchRm of Rm
	(properties
		picture 38
		north 50
		south 37
	)

	(method (init)
		(super init:)
		(HandsOff)
		(LoadMany rsVIEW 238 138 438 232 38)
		(Load rsSOUND 59)
		(gEgo
			illegalBits: 0
			init:
			setPri: 8
			posn: 137 187
			view: 238
			heading: 0
		)
		(sideDoor init: setPri: 9)
		(ladder init: setPri: 1)
		(topHatchDoor init:)
		(if (== (subMarine suitRoom:) 38)
			(self setFeatures: scubaGear)
		)
		(self setFeatures: waterButton setRegions: 314) ; subMarine
		(gEgo setScript: roomScript)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<around,at][/room,scene]')
				(cond
					((not local0)
						(Print 38 2) ; "Maybe you should enter the room."
					)
					((== (subMarine suitRoom:) 38)
						(Print 38 3) ; "There is some scuba gear and a button in the corner."
					)
					(else
						(Print 38 4) ; "You see a little red button in the corner."
					)
				)
			)
		)
	)

	(method (dispose)
		(if (>= gNewRoomNum 50) ; launchDiver
			(DisposeScript 806)
			(DisposeScript 817)
			(gEgo put: 5 9 10 11 12 13 14 15 16 17) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
		)
		(gEgo ignoreActors: 0)
		(super dispose:)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 11)
				(= cycles 1)
			)
			(1
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 137 170 self
				)
			)
			(2
				(= local0 0)
				(User canInput: 1 canControl: 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((not (gEgo has: 6))) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			((Said '[/diver,vehicle[<dive]]>')
				(cond
					((Said 'examine,check')
						(Print 38 5) ; "You check the diver vehicle by turning it on."
						(if
							(or
								(& (subMarine roomFlags:) $0040)
								(& (subMarine roomFlags:) $0080)
							)
							(Print 38 6) ; "It runs smoothly, so you shut it off."
						else
							(Print 38 7) ; "The diver vehicle seems to be running fine except for a slight vibration."
						)
					)
					((Said 'program')
						(localproc_2)
					)
					((Said 'get[<!*]/*')
						(proc0_35) ; "You already took that."
					)
					((Said 'return,replace,drop,(adjust[<away])')
						(self cue:)
						(event claimed: 1)
					)
				)
			)
			((Said 'examine,check/vibration')
				(if
					(and
						(not (& (subMarine roomFlags:) $0040))
						(not (& (subMarine roomFlags:) $0080))
					)
					(Print 38 8) ; "The vibration seems to be coming from the shaft."
				else
					(Print 38 9) ; "There is no vibration."
				)
			)
			((Said 'examine,check/shaft')
				(cond
					(
						(and
							(not (& (subMarine roomFlags:) $0040))
							(not (& (subMarine roomFlags:) $0020))
						)
						(Print 38 10) ; "A closer look at the shaft reveals that a nut and washer used to secure the prop are missing."
					)
					(
						(and
							(& (subMarine roomFlags:) $0040)
							(& (subMarine roomFlags:) $0020)
						)
						(Print 38 11) ; "The nut and washer are now in place."
						(if (not (& (subMarine roomFlags:) $0080))
							(Print 38 12) ; "The nut has been hand-tightened."
						)
					)
					((not (& (subMarine roomFlags:) $0040))
						(Print 38 13) ; "The nut used to secure the prop is not in place."
					)
					((not (& (subMarine roomFlags:) $0020))
						(Print 38 14) ; "The washer used to secure the prop is not in place."
					)
				)
			)
			((Said 'look[<at]/shaft')
				(Print 38 15) ; "The shaft is approximately three inches in length."
			)
			((Said 'measure/shaft')
				(if (not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					(Print 38 16) ; "You don't have anything with which to measure it."
				else
					(Print 38 17) ; "With the measuring device you find the diameter to be 1/2 inch."
					(SetScore subMarine 406 8192 5)
				)
			)
			((Said '/prop>')
				(cond
					((Said 'look[<at]')
						(Print 38 18) ; "A standard propeller."
					)
					((Said 'examine,check')
						(Print 38 19) ; "It's fine."
					)
					((Said 'measure')
						(proc0_39) ; "You don't need to do that."
					)
					((Said 'fix,install')
						(proc0_39) ; "You don't need to do that."
					)
					((Said 'tighten')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
			((or (Said 'install,(adjust<on)/washer') (Said 'washer<use'))
				(cond
					((& (subMarine roomFlags:) $0020)
						(Print 38 20) ; "You already did that."
					)
					((not (gEgo has: 10)) ; Sub: Washer | Tunisia: Flour_Canister
						(Print 38 21) ; "You don't have a washer."
					)
					((== (subMarine invStatus4:) 1)
						(Print 38 22) ; "The washer is too small."
					)
					((> (subMarine invStatus4:) 2)
						(Print 38 23) ; "The washer is too big."
					)
					((& (subMarine roomFlags:) $0040)
						(Print 38 24) ; "The nut is in the way."
					)
					(else
						(Print 38 25) ; "You slide the washer onto the shaft."
						(subMarine roomFlags: (| (subMarine roomFlags:) $0020))
						(SetScore subMarine 407 2048 1)
						(gEgo put: 10) ; Sub: Washer | Tunisia: Flour_Canister
					)
				)
			)
			((Said 'get,detach,(get<off)/washer')
				(cond
					((!= ((gInventory at: 10) owner:) gCurRoom) ; Sub: Washer | Tunisia: Flour_Canister
						(event claimed: 0)
					)
					((& (subMarine roomFlags:) $0040)
						(Print 38 26) ; "The nut's in the way."
					)
					(else
						(Print 38 27) ; "You remove the washer."
						(gEgo get: 10) ; Sub: Washer | Tunisia: Flour_Canister
						(subMarine roomFlags: (& (subMarine roomFlags:) $ffdf))
						(gEgo put: 10 gCurRoom) ; Sub: Washer | Tunisia: Flour_Canister
					)
				)
			)
			((or (Said 'install,(adjust<on)/nut') (Said 'nut<use'))
				(cond
					((& (subMarine roomFlags:) $0040)
						(Print 38 20) ; "You already did that."
					)
					((not (gEgo has: 11)) ; Sub: Nut | Tunisia: Coffee_Canister
						(Print 38 28) ; "You don't have a nut."
					)
					((== (subMarine invStatus3:) 1)
						(Print 38 29) ; "The nut is too small."
					)
					((> (subMarine invStatus3:) 2)
						(Print 38 30) ; "The nut is too big."
					)
					(else
						(if (& (subMarine roomFlags:) $0020)
							(Print 38 31) ; "You hand-tighten the nut flush against the washer."
						else
							(Print 38 32) ; "You hand-tighten the nut."
						)
						(subMarine roomFlags: (| (subMarine roomFlags:) $0040))
						(gEgo put: 11 gCurRoom) ; Sub: Nut | Tunisia: Coffee_Canister
					)
				)
			)
			((Said 'tighten/nut')
				(cond
					((not (& (subMarine roomFlags:) $0040))
						(event claimed: 0)
					)
					((& (subMarine roomFlags:) $0080)
						(Print 38 20) ; "You already did that."
					)
					((and (gEgo has: 16) (== (subMarine invStatus2:) 2)) ; Open_End_Wrench
						(Print 38 33) ; "Using the 1/2 inch wrench you securely tighten the nut down."
						(subMarine roomFlags: (| (subMarine roomFlags:) $0080))
						(gGame changeScore: 3)
					)
					((and (gEgo has: 16) (!= (subMarine invStatus2:) 2)) ; Open_End_Wrench
						(Print 38 34) ; "Your wrench is the wrong size for the 1/2" nut."
					)
					(else
						(Print 38 35) ; "You've already tigthened it as much as you can by hand and you don't have a wrench."
					)
				)
			)
			((Said 'get,detach,(get<off)/nut')
				(cond
					((gEgo has: 11) ; Sub: Nut | Tunisia: Coffee_Canister
						(Print 38 36) ; "You already have one."
					)
					((!= ((gInventory at: 11) owner:) gCurRoom) ; Sub: Nut | Tunisia: Coffee_Canister
						(event claimed: 0)
					)
					((not (& (subMarine roomFlags:) $0080))
						(Print 38 37) ; "You remove the nut from the shaft."
						(subMarine roomFlags: (& (subMarine roomFlags:) $ffbf))
						(gEgo get: 11) ; Sub: Nut | Tunisia: Coffee_Canister
					)
					((& (subMarine roomFlags:) $0080)
						(cond
							((not (gEgo has: 16)) ; Open_End_Wrench
								(Print 38 38) ; "It's too tight to do by hand."
							)
							((!= (subMarine invStatus2:) 2)
								(Print 38 34) ; "Your wrench is the wrong size for the 1/2" nut."
							)
							(else
								(Print 38 37) ; "You remove the nut from the shaft."
								(subMarine
									roomFlags: (& (subMarine roomFlags:) $ff7f)
								)
								(subMarine
									roomFlags: (& (subMarine roomFlags:) $ffbf)
								)
								(gEgo get: 11) ; Sub: Nut | Tunisia: Coffee_Canister
							)
						)
					)
				)
			)
			((Said 'enter,program/heading,distance,coordinate')
				(localproc_2)
			)
			((or (Said 'repair,fix/shaft') (Said 'use/wrench'))
				(Print 38 39) ; "You'll have to be more specific."
			)
		)
	)
)

(instance waterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(subMarine cue: 1)
				(gEgo ignoreActors: view: 138 setLoop: 0 setCel: 0)
				(= cycles 20)
			)
			(1
				(gEgo x: 187 y: 130 setCycle: End self)
			)
			(2
				(water init:)
				(water setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(Print 38 40 #at 5 6) ; "As the hatch begins to fill with water you prepare yourself for the task ahead."
				(= cycles 1)
			)
			(4
				(water setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(Print 38 41 #at 2 102) ; "You wait as the hatch completely fills and the pressure equalizes to the water outside."
				(= cycles 1)
			)
			(6
				(gEgo setPri: 10 setLoop: 3 setCel: 0)
				(water setLoop: 4 setCel: 0)
				(= cycles 1)
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(gEgo x: 188 y: 82 setLoop: 3 setCel: 0)
				(= cycles 4)
			)
			(9
				(Print 38 42 #at 150 100) ; "You reach up and open the exit hatch which gives you access to the Mediterranean Sea."
				(= cycles 1)
			)
			(10
				(topHatchDoor setCycle: End self)
			)
			(11
				(gEgo
					loop: 5
					cel: 0
					setStep: 3 6
					illegalBits: 0
					posn: 181 86
					setMotion: MoveTo 181 -12 self
				)
			)
			(12
				(gEgo setPri: -1 illegalBits: -32768 setStep: 3 4 put: 0 1) ; Envelope
				(HandsOn)
				(gCurRoom newRoom: 50) ; launchDiver
			)
		)
	)
)

(instance deadWaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 187 130 self
				)
			)
			(1
				(gEgo setCel: 0 setLoop: 3 setPri: 8)
				(= cycles 1)
			)
			(2
				(deathWater init: setPri: 7)
				(gEgo posn: 159 125)
				(deathWater setLoop: 1 setCel: 0 setCycle: End)
				(gurgle play:)
			)
			(3
				(deathWater setLoop: 2 setCel: 0 cycleSpeed: 1 setCycle: End)
			)
			(4
				(gEgo
					view: 438
					setLoop: 3
					setCel: 0
					setMotion: MoveTo 196 116 self
				)
			)
			(5
				(gEgo setMotion: MoveTo 222 90)
			)
			(6
				(EgoDead 926 0 0 38 43) ; "Well, now you know what this room is for!"
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(or
				(and (== (gurgle prevSignal:) 10) (== state 2))
				(and (== (gurgle prevSignal:) 20) (== state 3))
				(== (gurgle prevSignal:) -1)
			)
			(self cue:)
		)
	)
)

(instance openDoorFromInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors:)
				(= cycles 1)
			)
			(1
				(sideDoor setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 137 130 self)
			)
			(3
				(= local0 0)
				(gEgo
					setPri: 11
					view: 238
					x: 137
					y: 130
					setMotion: MoveTo 137 170 self
				)
			)
			(4
				(sideDoor setCycle: Beg self)
			)
			(5
				(User canInput: 1)
				(if register
					(self setScript: climbDownLadder)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance openDoorFromOutside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(sideDoor setCycle: End self)
			)
			(2
				(gEgo setPri: 11 setMotion: MoveTo 137 130 self)
			)
			(3
				(gEgo
					view: 232
					setPri: 8
					illegalBits: -32768
					ignoreActors: 0
				)
				(= cycles 1)
			)
			(4
				(gEgo setMotion: MoveTo 188 122 self)
			)
			(5
				(sideDoor setCycle: Beg self)
			)
			(6
				(= local0 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbDownLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 137 187 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance sideDoor of Prop
	(properties
		y 119
		x 148
		view 38
		loop 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/hatch,door>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 38 44) ; "The door to the tank."
					)
					((Said 'open')
						(if (not local0)
							(gCurRoom setScript: openDoorFromOutside)
						else
							(gCurRoom setScript: openDoorFromInside)
						)
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
		)
	)
)

(instance topHatchDoor of Prop
	(properties
		y 23
		x 160
		view 38
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/hatch,door>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 38 45) ; "The door to the outside."
					)
				)
			)
		)
	)
)

(instance ladder of Prop
	(properties
		y 172
		x 137
		view 38
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/ladder]>')
				(cond
					((Said 'look[<at]')
						(Print 38 46) ; "It's just a ladder."
					)
					((Said 'climb')
						(if local0
							(gCurRoom setScript: openDoorFromInside 0 1)
						else
							(gCurRoom setScript: climbDownLadder)
						)
					)
				)
			)
		)
	)
)

(instance scubaGear of RFeature
	(properties
		y 118
		x 107
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/gear,scuba,coat,wetsuit,equipment]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if (== (subMarine suitRoom:) 38)
							(Print 38 47) ; "Some scuba gear."
						else
							(event claimed: 1)
							(proc0_40) ; "You don't see that."
						)
					)
					((GoToIfSaid self event self 10 0 38 48))
					((Said 'get,wear,(adjust<on)')
						(if (== (subMarine suitRoom:) 38)
							(Print 38 49) ; "You put on the scuba gear and press the button."
							(gGame changeScore: 1)
							(gCurRoom setScript: waterScript)
						else
							(event claimed: 1)
							(proc0_40) ; "You don't see that."
						)
					)
				)
			)
		)
	)
)

(instance waterButton of RFeature
	(properties
		y 118
		x 108
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/button>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 38 50) ; "A button."
					)
					((GoToIfSaid self event self 10 0 38 48))
					((Said 'press,push')
						(gCurRoom setScript: deadWaterScript)
					)
					(else
						(proc0_37) ; "You can't do that."
					)
				)
			)
		)
	)
)

(instance water of Prop
	(properties
		y 130
		x 187
		view 138
		cycleSpeed 2
	)
)

(instance deathWater of Prop
	(properties
		y 130
		x 187
		view 438
		cycleSpeed 2
	)
)

(instance gurgle of Sound
	(properties
		number 59
		priority 2
	)
)

