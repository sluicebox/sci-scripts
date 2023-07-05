;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n315)
(use n824)
(use n828)
(use Approach)
(use n954)
(use RFeature)
(use Sight)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	engineRm 0
)

(local
	local0
	local1
	local2
	[local3 3]
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40])
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 37 0 param2) ; "%d"
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
	(Print 37 1) ; "Input aborted."
)

(instance engineRm of Rm
	(properties
		picture 37
		north 38
		east 36
	)

	(method (init)
		(Load rsVIEW 37)
		(Load rsVIEW 232)
		(Load rsSOUND 3)
		(super init:)
		(gIceGlobalSound number: 3 owner: gGame priority: 1 loop: -1 play:)
		(driveShaft init:)
		(gauge init:)
		(diveUnitDoor loop: (if (gEgo has: 6) 7 else 3) init:) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
		(drawer init:)
		(drawerInset init:)
		(gEgo init:)
		(gAddToPics add: doorPV eachElementDo: #init doit:)
		(proc824_0)
		(switch gPrevRoomNum
			(north
				(gEgo view: 232 posn: 30 67 setScript: downLadderScript)
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(diveUnitDoor setScript: hasDiverScript)
				)
			)
			(else
				(gEgo posn: 310 110)
			)
		)
		(self
			setRegions: 314 ; subMarine
			setFeatures:
				ladderF
				backLadderF
				transD1
				transD2
				turbine
				generator
				engine
				pump
				whiteTank
				greyTank
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look>')
				(cond
					((Said '[<at,around][/room,scene]')
						(Print 37 2) ; "Looking around the engine room you see large turbines, generators, pumps and tanks. The drive shaft whirls amidst a maze of pipes and catwalks."
						(Print 37 3) ; "Against the far bulkhead you see a glass enclosure which houses computerized panels used to monitor and control the nuclear reactor."
						(Print 37 4) ; "Looking toward the stern, you see a ladder leading to the escape hatch."
					)
					((Said '/pipe<green')
						(Print 37 5) ; "The green pipes move oxygen."
					)
					((Said '/pipe<red')
						(Print 37 6) ; "The red pipes move steam."
					)
					((Said '/pipe<blue')
						(Print 37 7) ; "The blue pipes move water."
					)
					((Said '/pipe<purple')
						(Print 37 8) ; "The purple pipes move hydraulic fluid."
					)
					((Said '/pipe[<!*]')
						(Print 37 9) ; "The pipes are color coded indicating the particular substance which moves through them."
					)
					((Said '/pipe<*')
						(Print 37 10) ; "You don't see a pipe of that type."
					)
				)
			)
			((Said 'cycle/equipment')
				(Print 37 11) ; "The engines are functioning normally."
			)
		)
	)
)

(instance driveShaft of Prop
	(properties
		y 121
		x 62
		view 37
		loop 1
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(if (> global132 0)
			(self setCycle: Fwd)
		else
			(self stopUpd:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shaft<drive]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 12) ; "The 24" drive shaft, which is encased inside a solid steel jacket, constantly turns. The revolutions will vary depending on how fast the sub is being operated.  Noise eliminating transducers are located at various points along the shaft."
					)
					((Said 'examine')
						(Print 37 13) ; "The drive shaft is functioning properly and in good condition."
					)
				)
			)
		)
	)
)

(instance gauge of Prop
	(properties
		y 111
		x 172
		view 37
		priority 14
		signal 16400
	)

	(method (init)
		(super init:)
		(if (> global132 0)
			(self setCycle: Fwd)
		else
			(self stopUpd:)
		)
	)
)

(instance doorPV of RPicView
	(properties
		y 63
		x 274
		view 37
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 14) ; "This is the door to the engine control room."
					)
					((Said 'open,close')
						(proc0_37) ; "You can't do that."
					)
				)
			)
		)
	)
)

(instance diveUnitDoor of Prop
	(properties
		y 93
		x 90
		z 15
		view 37
		priority 4
		signal 16400
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door,bulkhead,wall,compartment,cabinet]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(cond
							((not cel)
								(Print 37 15) ; "You see what appears to be a closed compartment."
							)
							((not (gEgo has: 6)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
								(Print 37 16) ; "You see a storage compartment with a dive vehicle stowed in it."
							)
							(else
								(Print 37 17) ; "You see a storage compartment."
							)
						)
						(Print 37 18) ; "Located next to the compartment door is an electronic button."
					)
					((GoToIfSaid self event self 5 0 37 19))
					((Said 'open')
						(if cel
							(proc0_31) ; "It is."
						else
							(self setCycle: End)
						)
					)
					((Said 'close')
						(if cel
							(self setCycle: Beg)
						else
							(proc0_31) ; "It is."
						)
					)
					((Said 'look[<in]')
						(cond
							((not cel)
								(Print 37 20) ; "You need to open it first."
							)
							((gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
								(Print 37 21) ; "It's currently empty."
							)
							(else
								(Print 37 22) ; "Looking inside the compartment you see a battery operated "Diver Vehicle.""
							)
						)
					)
				)
			)
			((Said '[/button]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 23) ; "It's a simple electronic button."
					)
					((GoToIfSaid self event self 3 'push,press/*' 37 19))
					((Said 'push,press')
						(if cel
							(self setCycle: Beg)
						else
							(self setCycle: End)
						)
					)
				)
			)
			((Said '/diver,vehicle[<dive]>')
				(cond
					((gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
						(if (Said 'cycle,fix,repair')
							(Print 37 24) ; "You'll have to be more specific."
						)
					)
					((TurnIfSaid self event 'get[<!*]/*'))
					((GoToIfSaid self event self 5 'get[<!*]/*' 37 19))
					((Said 'get[<!*]/*')
						(if (not cel)
							(Print 37 25) ; "You need to open the door."
						else
							(gEgo get: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
							(self setLoop: 7 setScript: hasDiverScript)
						)
					)
				)
			)
		)
	)
)

(instance hasDiverScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (gEgo onControl: 1) 2) (== state 0))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(Print 37 26) ; "Instead of lugging the dive vehicle all over the sub, you decide to put it back into its compartment until you need it."
				(gEgo
					setAvoider: Avoid
					setMotion: Approach diveUnitDoor 5 self
				)
			)
			(2
				(if (not (diveUnitDoor cel:))
					(diveUnitDoor setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(3
				(diveUnitDoor setLoop: 3)
				(= cycles 15)
			)
			(4
				(diveUnitDoor setCycle: Beg self)
			)
			(5
				(gEgo put: 6 setAvoider: 0) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(HandsOn)
				(client setScript: 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/diver,vehicle[<dive]]>')
				(cond
					((Said 'examine,check')
						(Print 37 27) ; "You check the diver vehicle by turning it on."
						(if
							(or
								(& (subMarine roomFlags:) $0040)
								(& (subMarine roomFlags:) $0080)
							)
							(Print 37 28) ; "It runs smoothly, so you shut it off."
						else
							(Print 37 29) ; "The diver vehicle seems to be running fine except for a slight vibration."
						)
					)
					((Said 'get[<!*]/*')
						(proc0_35) ; "You already took that."
					)
					((Said 'return,(adjust<away)')
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
					(Print 37 30) ; "The vibration seems to be coming from the shaft."
				else
					(Print 37 31) ; "There is no vibration."
				)
			)
			((Said 'examine,check/shaft')
				(cond
					(
						(and
							(not (& (subMarine roomFlags:) $0040))
							(not (& (subMarine roomFlags:) $0020))
						)
						(Print 37 32) ; "A closer look at the shaft reveals that a nut and washer used to secure the prop are missing."
					)
					(
						(and
							(& (subMarine roomFlags:) $0040)
							(& (subMarine roomFlags:) $0020)
						)
						(Print 37 33) ; "The nut and washer are now in place."
						(if (not (& (subMarine roomFlags:) $0080))
							(Print 37 34) ; "The nut has been hand-tightened."
						)
					)
					((not (& (subMarine roomFlags:) $0040))
						(Print 37 35) ; "The nut used to secure the prop is not in place."
					)
					((not (& (subMarine roomFlags:) $0020))
						(Print 37 36) ; "The washer used to secure the prop is not in place."
					)
				)
			)
			((Said 'look[<at]/shaft')
				(Print 37 37) ; "The shaft is approximately three inches in length."
			)
			((Said 'measure/shaft')
				(if (not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
					(Print 37 38) ; "You don't have anything with which to measure it."
				else
					(Print 37 39) ; "With the measuring device you find the diameter to be 1/2 inch."
					(SetScore subMarine 406 8192 5)
				)
			)
			((or (Said 'install,(adjust<on)/washer') (Said 'washer<use'))
				(cond
					((& (subMarine roomFlags:) $0020)
						(Print 37 40) ; "You already did that."
					)
					((not (gEgo has: 10)) ; Sub: Washer | Tunisia: Flour_Canister
						(Print 37 41) ; "You don't have a washer."
					)
					((== (subMarine invStatus4:) 1)
						(Print 37 42) ; "The washer is too small."
					)
					((> (subMarine invStatus4:) 2)
						(Print 37 43) ; "The washer is too big."
					)
					((& (subMarine roomFlags:) $0040)
						(Print 37 44) ; "The nut is in the way."
					)
					(else
						(Print 37 45) ; "You slide the washer onto the shaft."
						(subMarine roomFlags: (| (subMarine roomFlags:) $0020))
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
						(Print 37 46) ; "The nut's in the way."
					)
					(else
						(Print 37 47) ; "You remove the washer."
						(gEgo get: 10) ; Sub: Washer | Tunisia: Flour_Canister
						(subMarine roomFlags: (& (subMarine roomFlags:) $ffdf))
						(gEgo put: 10 gCurRoom) ; Sub: Washer | Tunisia: Flour_Canister
					)
				)
			)
			((or (Said 'install,(adjust<on)/nut') (Said 'nut<use'))
				(cond
					((& (subMarine roomFlags:) $0040)
						(Print 37 40) ; "You already did that."
					)
					((not (gEgo has: 11)) ; Sub: Nut | Tunisia: Coffee_Canister
						(Print 37 48) ; "You don't have a nut."
					)
					((== (subMarine invStatus3:) 1)
						(Print 37 49) ; "The nut is too small."
					)
					((> (subMarine invStatus3:) 2)
						(Print 37 50) ; "The nut is too big."
					)
					(else
						(if (& (subMarine roomFlags:) $0020)
							(Print 37 51) ; "You hand-tighten the nut flush against the washer."
						else
							(Print 37 52) ; "You hand-tighten the nut."
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
						(Print 37 40) ; "You already did that."
					)
					((and (gEgo has: 16) (== (subMarine invStatus2:) 2)) ; Open_End_Wrench
						(Print 37 53) ; "Using the 1/2 inch wrench you securely tighten the nut down."
						(subMarine roomFlags: (| (subMarine roomFlags:) $0080))
						(gGame changeScore: 3)
					)
					((and (gEgo has: 16) (!= (subMarine invStatus2:) 2)) ; Open_End_Wrench
						(Print 37 54) ; "Your wrench is the wrong size for the 1/2" nut."
					)
					(else
						(Print 37 55) ; "You've already tigthened it as much as you can by hand and you don't have a wrench."
					)
				)
			)
			((Said 'get,detach,(get<off)/nut')
				(cond
					((gEgo has: 11) ; Sub: Nut | Tunisia: Coffee_Canister
						(Print 37 56) ; "You already have one."
					)
					((!= ((gInventory at: 11) owner:) gCurRoom) ; Sub: Nut | Tunisia: Coffee_Canister
						(event claimed: 0)
					)
					((not (& (subMarine roomFlags:) $0080))
						(Print 37 57) ; "You remove the nut from the shaft."
						(subMarine roomFlags: (& (subMarine roomFlags:) $ffbf))
						(gEgo get: 11) ; Sub: Nut | Tunisia: Coffee_Canister
					)
					((& (subMarine roomFlags:) $0080)
						(cond
							((not (gEgo has: 16)) ; Open_End_Wrench
								(Print 37 58) ; "It's too tight to do by hand."
							)
							((!= (subMarine invStatus2:) 2)
								(Print 37 54) ; "Your wrench is the wrong size for the 1/2" nut."
							)
							(else
								(Print 37 57) ; "You remove the nut from the shaft."
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
			((Said 'enter/coordinate')
				(if (not (gEgo has: 6)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(event claimed: 0)
				else
					(= local2 -1)
					(if
						(==
							(= local2
								(localproc_0 {Enter distance to waypoint #1:})
							)
							-1
						)
						(localproc_1)
						(return)
					else
						(subMarine dist1: local2)
					)
					(= local2 -1)
					(if
						(==
							(= local2
								(localproc_0 {Enter heading to waypoint #1:})
							)
							-1
						)
						(localproc_1)
						(return)
					else
						(subMarine head1: local2)
					)
					(= local2 -1)
					(if
						(==
							(= local2
								(localproc_0 {Enter distance to waypoint #2:})
							)
							-1
						)
						(localproc_1)
						(return)
					else
						(subMarine dist2: local2)
					)
					(= local2 -1)
					(if
						(==
							(= local2
								(localproc_0 {Enter heading to waypoint #2:})
							)
							-1
						)
						(localproc_1)
						(return)
					else
						(subMarine head2: local2)
					)
				)
			)
			((or (Said 'repair,fix/shaft') (Said 'use/wrench'))
				(Print 37 24) ; "You'll have to be more specific."
			)
		)
	)
)

(instance drawer of Prop
	(properties
		y 88
		x 214
		view 37
		loop 4
		priority 7
		signal 17
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/drawer]>')
				(cond
					((TurnIfSaid self event 'look[<at,in]/*'))
					((Said 'look[<at,in]')
						(Print 37 59) ; "The drawer contains necessary items used for maintenance."
						(if cel
							(drawerInset show:)
						)
					)
					((GoToIfSaid self event self 20 0 37 19))
					((Said 'open')
						(if cel
							(proc0_31) ; "It is."
						else
							(self setCycle: End self)
							(gEgo heading: 0)
							((gEgo looper:) doit: gEgo (gEgo heading:))
						)
					)
					((Said 'close')
						(if cel
							(self setCycle: Beg self)
						else
							(proc0_31) ; "It is."
						)
					)
				)
			)
			((Said '/hammer>')
				(cond
					((and (gEgo has: 15) (Said 'look[<at]')) ; Hammer
						(event claimed: 0)
					)
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look[<at]')
						(if (not cel)
							(Print 37 60) ; "Open the drawer first."
						else
							(Print 37 61) ; "You see a hammer."
						)
					)
					((GoToIfSaid self event self 20 'get[<!*]/*,adjust' 37 19))
					((Said 'get[<!*]/*')
						(cond
							((not cel)
								(Print 37 60) ; "Open the drawer first."
							)
							((gEgo has: 15) ; Hammer
								(Print 37 62) ; "You already have the hammer."
							)
							(else
								(gEgo get: 15) ; Hammer
								(drawerInset show: forceUpd:)
							)
						)
					)
					((Said 'adjust')
						(cond
							((not (gEgo has: 15)) ; Hammer
								(Print 37 63) ; "You don't have a hammer."
							)
							((not cel)
								(Print 37 60) ; "Open the drawer first."
							)
							(else
								(gEgo put: 15) ; Hammer
								(drawerInset show: forceUpd:)
							)
						)
					)
				)
			)
			((Said '/wrench>')
				(cond
					((and (gEgo has: 16) (Said 'look[<at]')) ; Open_End_Wrench
						(event claimed: 0)
					)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if (not cel)
							(Print 37 60) ; "Open the drawer first."
						else
							(Print 37 64) ; "You see various open-end wrenches."
						)
					)
					((GoToIfSaid self event self 20 'get[<!*]/*,adjust' 37 19))
					((Said 'get[<!*]/*')
						(cond
							((not cel)
								(Print 37 60) ; "Open the drawer first."
							)
							(
								(= local0
									(proc315_0
										37
										65
										150
										{ 1/4" }
										1
										150
										{ 1/2" }
										2
										150
										{ 3/4" }
										3
										150
										{  1"  }
										4
									)
								)
								(if (gEgo has: 16) ; Open_End_Wrench
									(Printf ; "You drop the wrench you have and pick up a %s" wrench."
										37
										66
										(switch local0
											(1 {1/4})
											(2 {1/2})
											(3 {3/4})
											(4 {1})
										)
									)
								else
									(Printf ; "You pick up a %s" wrench."
										37
										67
										(switch local0
											(1 {1/4})
											(2 {1/2})
											(3 {3/4})
											(4 {1})
										)
									)
								)
								(gEgo get: 16) ; Open_End_Wrench
								(subMarine invStatus2: local0)
								(drawerInset show: forceUpd:)
								(if (== local0 2)
									(SetScore subMarine 406 16384 2)
								)
							)
							(else
								(Print 37 68) ; "You don't pick up a wrench."
							)
						)
					)
					((Said 'adjust')
						(cond
							((not (gEgo has: 16)) ; Open_End_Wrench
								(Print 37 69) ; "You don't have a wrench."
							)
							((not cel)
								(Print 37 60) ; "Open the drawer first."
							)
							(else
								(gEgo put: 16) ; Open_End_Wrench
								(drawerInset show: forceUpd:)
							)
						)
					)
				)
			)
			((Said 'look[<at]/tool')
				(if (not cel)
					(Print 37 60) ; "Open the drawer first."
				else
					(Printf ; "The hand tools consist of%s end wrenches."
						37
						70
						(if (gEgo has: 15) {} else { a hammer and}) ; Hammer
					)
				)
			)
		)
	)

	(method (cue)
		(if cel
			(drawerInset show:)
		else
			(drawerInset hide:)
		)
		(self stopUpd:)
		(if cel
			(Print 37 71) ; "You open the drawer and find a small variety of hand tools."
		)
	)
)

(instance drawerInset of View
	(properties
		y 44
		x 238
		heading 180
		view 37
		loop 6
	)

	(method (init)
		(super init:)
		(self setPri: 15 hide:)
	)

	(method (show)
		(self
			cel:
				(cond
					((gEgo has: 16) ; Open_End_Wrench
						(if (gEgo has: 15) 3 else 2) ; Hammer
					)
					((gEgo has: 15) 1) ; Hammer
					(else 0)
				)
		)
		(super show:)
		(&= signal $feff)
	)

	(method (hide)
		(super hide:)
		(|= signal $0100)
	)

	(method (doit)
		(super doit:)
		(if (CantBeSeen self gEgo 180)
			(self hide:)
		)
	)
)

(instance ladderF of Feature
	(properties
		y 95
		x 30
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/ladder]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 72) ; "This is the ladder to the emergency escape hatch."
					)
					((GoToIfSaid self event self 20 'climb[<up]' 37 19))
					((Said 'climb[<up]')
						(gEgo setScript: climbLadderScript)
					)
					((Said 'climb<down')
						(Print 37 73) ; "The ladder only goes up."
					)
				)
			)
		)
	)
)

(instance backLadderF of Feature
	(properties
		y 78
		x 260
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/ladder]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 74) ; "This is the ladder to the reactor control room."
					)
				)
			)
		)
	)
)

(instance climbLadderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (!= (gEgo x:) 31) (!= (gEgo y:) 101))
					(gEgo setMotion: MoveTo 31 101 self)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOff)
				(client setMotion: MoveTo 30 100 self)
			)
			(2
				(client
					ignoreControl: -32768
					setPri: 5
					setMotion: MoveTo 30 64 self
				)
			)
			(3
				(client observeControl: -32768 setPri: -1)
				(HandsOn)
				(gCurRoom newRoom: 38) ; escapeHatchRm
			)
		)
	)
)

(instance downLadderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client
					ignoreControl: -32768
					posn: 30 67
					setPri: 5
					setMotion: MoveTo 30 100 self
					setLoop: 3
				)
			)
			(1
				(client observeControl: -32768 setPri: -1 setLoop: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance transD1 of RFeature
	(properties
		y 120
		x 88
		nsTop 103
		nsLeft 78
		nsBottom 138
		nsRight 99
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/transducer]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 75) ; "The transducers are attached to the steel casing surrounding the shaft. They pick up generated sound waves which are fed into a computer. Here, the computer creates the precise opposite sound wave which eliminates the noise. This makes for much improved silent running."
					)
					((Said 'examine')
						(Print 37 76) ; "All systems and equipment are functioning properly."
					)
				)
			)
		)
	)
)

(instance transD2 of RFeature
	(properties
		y 115
		x 46
		nsTop 103
		nsLeft 33
		nsBottom 128
		nsRight 60
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/transducer]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 75) ; "The transducers are attached to the steel casing surrounding the shaft. They pick up generated sound waves which are fed into a computer. Here, the computer creates the precise opposite sound wave which eliminates the noise. This makes for much improved silent running."
					)
					((Said 'examine')
						(Print 37 76) ; "All systems and equipment are functioning properly."
					)
				)
			)
		)
	)
)

(instance turbine of RFeature
	(properties
		y 68
		x 161
		nsTop 58
		nsLeft 150
		nsBottom 79
		nsRight 172
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/turbine]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 77) ; "The large turbine is powered by steam which is generated by the nuclear reactor. The turbine is the power source for the electric generator."
					)
					((Said 'examine')
						(Print 37 78) ; "The reactor and turbine are functioning properly."
					)
				)
			)
		)
	)
)

(instance generator of RFeature
	(properties
		y 112
		x 124
		nsTop 93
		nsLeft 112
		nsBottom 131
		nsRight 127
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/generator]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 79) ; "The generator supplies power to the main electrical engine which turns the drive shaft of the submarine."
					)
					((Said 'examine')
						(Print 37 80) ; "The generator is functioning properly."
					)
				)
			)
		)
	)
)

(instance engine of RFeature
	(properties
		y 110
		x 170
		nsTop 80
		nsLeft 127
		nsBottom 140
		nsRight 213
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/engine]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 81) ; "This powerful electric engine produces 65000 shaft horse power which can propel the USS Blackhawk in excess of 50 knots submerged."
					)
					((Said 'examine')
						(Print 37 76) ; "All systems and equipment are functioning properly."
					)
				)
			)
		)
	)
)

(instance pump of RFeature
	(properties
		y 56
		x 135
		nsTop 33
		nsLeft 124
		nsBottom 79
		nsRight 147
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/pump]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 82) ; "The pumps move water and hydraulic fluid through pipes to various systems."
					)
					((Said 'examine')
						(Print 37 76) ; "All systems and equipment are functioning properly."
					)
				)
			)
		)
	)
)

(instance whiteTank of RFeature
	(properties
		y 54
		x 229
		nsTop 44
		nsLeft 214
		nsBottom 63
		nsRight 245
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/tank]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 83) ; "This is the compressed air tank."
					)
				)
			)
		)
	)
)

(instance greyTank of RFeature
	(properties
		y 31
		x 186
		nsTop 15
		nsLeft 165
		nsBottom 42
		nsRight 208
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/tank]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 37 84) ; "This is the fresh water storage tank."
					)
				)
			)
		)
	)
)

