;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n315)
(use Submarine_806)
(use n824)
(use n828)
(use n954)
(use LoadMany)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	machineRm 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 3] = [75 119 251]
	[local9 3] = [100 100 100]
	[local12 3] = [75 119 256]
	[local15 3] = [97 97 95]
	[local18 3] = [48 88 254]
	[local21 3] = [93 92 88]
	[local24 3] = [74 139 287]
	[local27 3] = [101 98 97]
)

(procedure (localproc_0)
	(Print 34 0) ; "You need to open the cabinet first."
)

(procedure (localproc_1)
	(Print 34 1) ; "I'll be out of your way in just a second, Sir."
)

(instance machineRm of Rm
	(properties
		picture 34
		east 41
		south 35
		west 36
	)

	(method (init)
		(LoadMany rsVIEW 34 232 434 534)
		(LoadMany rsSOUND 13 213 19 219 30 230 31 231 17 217)
		(ScriptID 315)
		(super init:)
		(gAddToPics add: lathe drill grinder eachElementDo: #init doit:)
		(proc824_0)
		(self setRegions: 314 setFeatures: pump system) ; subMarine
		(tubeDoor init:)
		(cabDoor init:)
		(drillHead init:)
		(blade
			init:
			illegalBits: 0
			setLoop: 0
			setCel: 1
			setStep: 1 1
			moveSpeed: 1
		)
		(dial1 init:)
		(dial2 init:)
		(dial3 init:)
		(if
			(or
				(& (subMarine roomFlags:) $0004)
				(not (& (subMarine roomFlags:) $0010))
			)
			(willie
				init:
				setCycle: Walk
				setAvoider: Avoid
				setScript: willieScript
			)
		)
		(switch gPrevRoomNum
			(west
				(tubeDoor setCel: (tubeDoor lastCel:))
				(gEgo posn: 5 121)
			)
			(else
				(gEgo posn: 297 98 loop: 1)
				(tubeDoor setCel: 0 setCycle: End tubeDoor)
			)
		)
		(gEgo init:)
	)

	(method (newRoom newRoomNumber)
		(HandsOn)
		(gEgo illegalBits: $8000)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(DisposeScript 315)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((super handleEvent: event))
			((and (Said 'look[<at]>') (Said '[<around][/room,scene,equipment]'))
				(Print 34 2) ; "You see a fully equipped machinery compartment with lathe, drill press and grinder. Other systems and pumps are housed in this area also."
				(Print 34 3) ; "On the side of the machinery compartment you see a cabinet."
			)
		)
	)
)

(instance latheScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 34 4) ; "The lathe starts turning, slowly reducing the diameter of the metal cylinder."
				(dial1 setCycle: Fwd)
				(dial2 setCycle: Fwd)
				(dial3 setCycle: Fwd)
				(shaft setCycle: Fwd)
				(blade setMotion: MoveTo 115 93 blade)
				(= local2 1)
				(machNoise number: (proc0_5 30) loop: 1 play:)
			)
			(1
				(Print 34 5) ; "The lathe shuts down after milling the cylinder to the proper diameter. You remove it from the lathe."
				(= local2 0)
				(dial1 stopUpd:)
				(dial2 stopUpd:)
				(dial3 stopUpd:)
				(shaft dispose:)
				(blade setMotion: 0 stopUpd:)
				(HandsOn)
				(SetScore subMarine 406 512 1)
				(subMarine cylDiam: local0)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (machNoise prevSignal:) -1)
			(self cue:)
		)
	)
)

(instance drillScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo heading: 0)
				((gEgo looper:) doit: gEgo (gEgo heading:) self)
			)
			(1
				(gEgo view: 434 setLoop: 0 setCel: 4 setCycle: Beg self)
			)
			(2
				(gEgo setCycle: End self)
				(drillHead setCycle: End)
			)
			(3
				(Print 34 6) ; "You slowly drill a hole in the end of the metal cylinder."
				(machNoise number: (proc0_5 31) loop: 1 play:)
			)
			(4
				(gEgo setCycle: Beg self)
				(drillHead setCycle: Beg)
			)
			(5
				(drillHead stopUpd:)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					view: 232
					loop: 3
					setLoop: -1
					setCycle: Walk
					setAvoider: 0
				)
				(HandsOn)
				(if (== local0 4)
					(SetScore subMarine 406 2048 1)
				)
				(subMarine holeSize: local0)
				(= local3 0)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (machNoise prevSignal:) -1)
			(self cue:)
		)
	)
)

(instance grindScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 34 7) ; "Carefully, you grind the rough edges off the metal cylinder."
				(gEgo view: 434 loop: 1 cel: 0 cycleSpeed: 3 setCycle: Fwd)
				(machNoise number: (proc0_5 17) loop: 1 play:)
			)
			(1
				(Print 34 8) ; "Satisfied, you shut off the grinder."
				(gEgo view: 232 loop: 3 cycleSpeed: 0 setCycle: Walk)
				(SetScore subMarine 406 4096 1)
				(subMarine roomFlags: (| (subMarine roomFlags:) $0004))
				(= local4 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (machNoise prevSignal:) -1)
			(self cue:)
		)
	)
)

(instance willieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
				(++ local5)
			)
			(1
				(if
					(gEgo
						inRect:
							[local18 register]
							[local21 register]
							[local24 register]
							[local27 register]
					)
					(+= register 1)
				)
				(if (> register 2)
					(= start 7)
					(self init:)
				else
					(client
						setMotion:
							MoveTo
							[local6 register]
							[local9 register]
							self
					)
					(++ local5)
				)
			)
			(2
				(client
					setMotion: MoveTo [local12 register] [local15 register] self
				)
				(++ register)
			)
			(3
				(if (== register 3)
					(= cycles 1)
				else
					(self init:)
				)
			)
			(4
				(if (not (cabDoor cel:))
					(cabDoor setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(5
				(cabDoor stopUpd:)
				(= local5 (= seconds 7))
			)
			(6
				(cabDoor setCycle: Beg self)
			)
			(7
				(cabDoor stopUpd:)
				(client
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 304 95 self
				)
				(= local5 8)
			)
			(8
				(tubeDoor setCel: (tubeDoor lastCel:) setCycle: Beg self)
			)
			(9
				(tubeDoor stopUpd:)
				(client setMotion: MoveTo 325 84 self)
			)
			(10
				(tubeDoor setCycle: End self)
			)
			(11
				(tubeDoor stopUpd:)
				(client dispose:)
			)
		)
	)
)

(instance willie of Act
	(properties
		y 102
		x 35
		view 534
		loop 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look,talk/man,johnson'))
			((Said 'look[<at][/man,johnson]')
				(Print 34 9) ; "This is Willie Johnson."
			)
			((Said 'talk/man,johnson')
				(if (& (subMarine roomFlags:) $0008)
					(Print 34 10) ; "Good day, Sir. I hope you're having a pleasant trip."
				else
					(Print 34 11) ; "Machinist Mate 2nd Class Willie Johnson says, "Hello Commander, it's a pleasure to have you aboard!""
					(Print 34 12) ; "Continuing, Petty Officer Johnson says, "I need to get back to doing my inventory commander, please feel free to look around all you want.""
					(subMarine roomFlags: (| (subMarine roomFlags:) $0008))
				)
			)
			((GoToIfSaid self event self 20 'get/key' 34 13))
			((Said 'get/key')
				(cond
					((gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(Print 34 14) ; "You already have it."
					)
					((>= ((subMarine script:) state:) 14)
						(Print 34 15) ; "Aye aye, Commander!" says Johnson, "Here you are, sir."
						(gEgo get: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
					)
					(else
						(Print 34 16) ; "Petty Officer Johnson answers and says, "I think the chief cook has that key right now Commander. He should be bringing it back any time.""
					)
				)
			)
		)
	)
)

(instance tubeDoor of Prop
	(properties
		y 85
		x 316
		view 34
		loop 5
		cel 6
		signal 16384
	)

	(method (doit)
		(super doit:)
		(if (and (== (gEgo onControl: 1) 2) (not (self cycler:)) cel)
			(HandsOff)
			(self setCycle: Beg self)
			(gEgo illegalBits: 0 setMotion: MoveTo 320 84)
		)
	)

	(method (setCycle)
		(super setCycle: &rest)
		(doorSound number: (proc0_5 13) play:)
	)

	(method (cue)
		(self stopUpd:)
		(doorSound number: (proc0_5 19) play:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 34 17) ; "The door to the access tube."
					)
					((Said 'close')
						(Print 34 18) ; "It does that by itself."
					)
					((GoToIfSaid self event self 20 0 34 13))
					((Said 'open')
						(HandsOff)
						(gEgo setMotion: MoveTo 320 84)
					)
				)
			)
		)
	)
)

(instance cabDoor of Prop
	(properties
		y 88
		x 271
		view 34
		loop 6
		signal 16385
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/cabinet]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at,in]')
						(if (== (self cel:) 0)
							(Print 34 19) ; "A cabinet equipped with spare parts."
						else
							(Print 34 20) ; "A cabinet containing bins with various size metal cylinders, bolts, washers, nuts, and cotter pins."
						)
					)
					((and (== local5 7) (or (Said 'open') (Said 'close')))
						(localproc_1)
					)
					((GoToIfSaid self event 256 95 0 34 13))
					((Said 'open')
						(if (!= (self cel:) 0)
							(Print 34 21) ; "It's already open."
						else
							(self setCycle: End self)
						)
						(gEgo heading: 90)
						((gEgo looper:) doit: gEgo (gEgo heading:))
					)
					((Said 'close')
						(if (== (self cel:) 0)
							(Print 34 22) ; "You already did that."
						else
							(self setCycle: Beg self)
						)
						(gEgo heading: 90)
						((gEgo looper:) doit: gEgo (gEgo heading:))
					)
				)
			)
			((Said '[/bin]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 23) ; "The bins contain various size metal cylinders, bolts, washers, nuts, and cotter pins."
						)
					)
					((and (== local5 7) (Said 'get'))
						(localproc_1)
					)
					((GoToIfSaid self event 256 95 0 34 13))
					((Said 'get')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 24) ; "The bins themselves are securely welded to the inside of the cabinet."
						)
					)
				)
			)
			((Said '[/cylinder[<metal]]>')
				(cond
					((Said 'measure')
						(cond
							((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(event claimed: 0)
							)
							((not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
								(Print 34 25) ; "You don't have anything to measure it with."
							)
							(else
								(Printf ; "The cylinder is %s inches long."
									34
									26
									(switch (subMarine invStatus1:)
										(1 {3})
										(2 {4})
										(3 {6})
									)
								)
							)
						)
					)
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (not cel)
							(localproc_0)
						else
							(Print 34 27) ; "The metal cylinders come in three different lengths:   3"   4"   6" However, they're all about 2 1/2" in diameter."
						)
					)
					((and (== local5 7) (Said 'get'))
						(localproc_1)
					)
					((GoToIfSaid self event 256 95 0 34 13))
					((Said 'get')
						(cond
							((== (self cel:) 0)
								(localproc_0)
							)
							(
								(or
									(& (subMarine roomFlags:) $1000)
									(& (Submarine flags:) $0100)
								)
								(Print 34 28) ; "You've already installed a cylinder in the conveyor. There's no need to get another one."
							)
							(
								(= local0
									(proc315_0
										34
										29
										150
										{ 3" }
										1
										150
										{ 4" }
										2
										150
										{ 6" }
										3
									)
								)
								(if
									(and
										(gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
										(or
											(subMarine cylDiam:)
											(subMarine holeSize:)
											(& (subMarine roomFlags:) $0004)
										)
									)
									(if
										(Print ; "If you get a new cylinder, you will lose the one you currently have. Is this OK?"
											34
											30
											150
											{Yes}
											1
											150
											{ No }
											0
										)
										(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
										(subMarine invStatus1: local0)
										(subMarine cylDiam: 0)
										(subMarine holeSize: 0)
										(subMarine
											roomFlags:
												(& (subMarine roomFlags:) $fffb)
										)
										(Printf ; "You pick up a %d" cylinder."
											34
											31
											(+ (* local0 2) (== local0 1))
										)
										(if (== local0 3)
											(SetScore subMarine 406 64 1)
										)
									else
										(Print 34 32) ; "You don't pick up any cylinders."
									)
								else
									(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
									(subMarine invStatus1: local0)
									(Printf ; "You pick up a %d" cylinder."
										34
										31
										(+ (* local0 2) (== local0 1))
									)
									(if (== local0 3)
										(SetScore subMarine 406 64 1)
									)
								)
							)
							(else
								(Print 34 32) ; "You don't pick up any cylinders."
							)
						)
					)
				)
			)
			((Said '[/bolt]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 33) ; "There are many bolts in the bin."
						)
					)
					((and (== local5 7) (Said 'get'))
						(localproc_1)
					)
					((GoToIfSaid self event 256 95 0 34 13))
					((Said 'get')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 34) ; "You don't need any bolts."
						)
					)
				)
			)
			((Said '[/nut]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 35) ; "The nuts are:   1/4"   1/2"   3/4"   1""
						)
					)
					((and (== local5 7) (Said 'get'))
						(localproc_1)
					)
					((GoToIfSaid self event 256 95 'get' 34 13))
					((Said 'get')
						(cond
							((== (self cel:) 0)
								(localproc_0)
							)
							(
								(= local0
									(proc315_0
										34
										29
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
										{__1"__}
										4
									)
								)
								(gEgo get: 11) ; Sub: Nut | Tunisia: Coffee_Canister
								(subMarine invStatus3: local0)
								(Printf ; "You pick up a %s" nut."
									34
									36
									(switch local0
										(1 {1/4})
										(2 {1/2})
										(3 {3/4})
										(4 {1})
									)
								)
							)
							(else
								(Print 34 37) ; "You don't pick up any nuts."
							)
						)
					)
				)
			)
			((Said '[/washer]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 38) ; "The washers are:   1/4"   1/2"   3/4"   1""
						)
					)
					((and (== local5 7) (Said 'get'))
						(localproc_1)
					)
					((GoToIfSaid self event 256 95 'get' 34 13))
					((Said 'get')
						(cond
							((== (self cel:) 0)
								(localproc_0)
							)
							(
								(= local0
									(proc315_0
										34
										29
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
										{__1"__}
										4
									)
								)
								(gEgo get: 10) ; Sub: Washer | Tunisia: Flour_Canister
								(subMarine invStatus4: local0)
								(Printf ; "You pick up a %s" washer."
									34
									39
									(switch local0
										(1 {1/4})
										(2 {1/2})
										(3 {3/4})
										(4 {1})
									)
								)
							)
							(else
								(Print 34 40) ; "You don't pick up any washers."
							)
						)
					)
				)
			)
			((Said '[/pin<cotter]>')
				(cond
					((Said 'measure')
						(cond
							((not (gEgo has: 9)) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
								(Print 34 41) ; "You don't have a cotter pin."
							)
							((not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
								(Print 34 42) ; "You have nothing to measure it with."
							)
							(else
								(Print 34 43) ; "After measuring the cotter pin, you find it to be two inches long and will fit a quarter inch hole."
								(SetScore subMarine 406 128 1)
							)
						)
					)
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 44) ; "A standard cotter pin."
						)
					)
					((and (== local5 7) (Said 'get'))
						(localproc_1)
					)
					((GoToIfSaid self event 256 95 0 34 13))
					((Said 'get')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 45) ; "You pick up a cotter pin."
							(gEgo get: 9) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
						)
					)
				)
			)
		)
	)

	(method (cue)
		(if (!= (self cel:) 0)
			(Print 34 46) ; "You open the cabinet door and see bins with various size metal cylinders, bolts, washers, nuts, and cotter pins."
		)
		(self stopUpd:)
	)
)

(instance drillHead of Prop
	(properties
		y 57
		x 67
		view 34
		loop 3
		priority 6
		signal 1
	)
)

(instance blade of Act
	(properties
		y 93
		x 104
		z 17
		view 34
		cel 1
		signal 16385
	)

	(method (cue)
		(if (== (self x:) 115)
			(self setMotion: MoveTo 104 93 self)
		else
			(self setMotion: MoveTo 115 93 self)
		)
	)
)

(instance dial1 of Prop
	(properties
		y 93
		x 98
		z 17
		view 34
		loop 2
		cel 3
		signal 1
	)
)

(instance dial2 of Prop
	(properties
		y 93
		x 98
		z 6
		view 34
		loop 2
		cel 3
		signal 1
	)
)

(instance dial3 of Prop
	(properties
		y 93
		x 132
		z 18
		view 34
		loop 2
		cel 3
		signal 1
	)
)

(instance shaft of Prop
	(properties
		y 68
		x 100
		view 34
		loop 1
	)
)

(instance lathe of RPicView
	(properties
		y 92
		x 113
		view 34
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/lathe]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 34 47) ; "The lathe is used to reduce the diameter of cylindrical objects."
					)
					(
						(and
							(== local5 5)
							(or
								(Said 'use')
								(Said 'place')
								(Said 'turn<on')
								(Said 'start')
							)
						)
						(localproc_1)
					)
					((GoToIfSaid self event self 10 0 34 13))
					((Said 'use')
						(cond
							((== (subMarine cylDiam:) 1)
								(Print 34 48) ; "You've already milled the metal cylinder. The lathe can't be set any smaller."
							)
							((== local2 2)
								(Print 34 49) ; "You've already secured the metal cylinder."
							)
							((gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 34 50) ; "You insert the metal cylinder into the chuck and secure it."
								(shaft init:)
								(= local2 2)
							)
							(else
								(Print 34 51) ; "You have no reason to use the lathe."
							)
						)
					)
					((Said 'place')
						(cond
							((== local2 3)
								(Print 34 52) ; "The lathe is already set."
							)
							((!= local2 2)
								(Print 34 53) ; "You have to "use" the lathe before you set it."
							)
							(
								(not
									(= local0
										(proc315_0
											34
											54
											150
											{__1"__}
											1
											150
											{ 1.5" }
											2
											150
											{__2"__}
											3
										)
									)
								)
								(Print 34 55) ; "You'll have to set the lathe before you can use it."
							)
							(
								(and
									(< (subMarine cylDiam:) local0)
									(subMarine cylDiam:)
								)
								(Print 34 56) ; "You've already milled the cylinder to a smaller diameter than that."
							)
							((== (subMarine cylDiam:) local0)
								(Print 34 57) ; "You've already milled the cylinder to that diameter."
							)
							(else
								(= local2 3)
								(switch local0
									(1
										(Print 34 58) ; "You set the lathe diameter to 1"."
										(subMarine
											roomFlags:
												(| (subMarine roomFlags:) $0400)
										)
										(SetScore subMarine 406 256 2)
									)
									(2
										(Print 34 59) ; "You set the lathe diameter to 1.5"."
									)
									(3
										(Print 34 60) ; "You set the lathe diameter to 2"."
									)
								)
							)
						)
					)
					((Said 'start,(turn<on)')
						(if (!= local2 3)
							(Print 34 61) ; "You need to "set" the lathe first."
						else
							(blade setScript: latheScript)
						)
					)
					((Said 'turn<off')
						(Print 34 62) ; "The lathe isn't on."
					)
				)
			)
		)
	)
)

(instance drill of RPicView
	(properties
		y 94
		x 60
		view 34
		cel 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said '[/drill]>') (Said '[/press<drill]>'))
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 34 63) ; "It's a normal upright drilling machine used to bore holes in metal."
					)
					(
						(and
							(== local5 3)
							(or (Said 'use') (Said 'turn<on') (Said 'start'))
						)
						(localproc_1)
					)
					((GoToIfSaid self event 79 97 0 34 13))
					((Said 'use')
						(cond
							((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 34 64) ; "You don't have a reason to use the drill press."
							)
							((not (subMarine cylDiam:))
								(Print 34 65) ; "You need to lathe the cylinder before drilling it."
							)
							((== local3 2)
								(Print 34 66) ; "You've already secured the cylinder onto the press."
							)
							((== (subMarine holeSize:) 7)
								(Print 34 67) ; "You've already drilled the largest hole possible.  More drilling would be futile."
							)
							(else
								(Print 34 68) ; "You secure the metal cylinder onto the press in preparation for drilling."
								(= local3 2)
							)
						)
					)
					((Said 'start,(turn<on)')
						(if (!= local3 3)
							(Print 34 69) ; "You need to select the bit you want to use."
						else
							(drillHead setScript: drillScript)
						)
					)
				)
			)
			((Said '/hole<drill')
				(if (!= local3 3)
					(Print 34 69) ; "You need to select the bit you want to use."
				else
					(drillHead setScript: drillScript)
				)
			)
			((Said 'select/bit,(size<bit)')
				(cond
					((!= local3 2)
						(Print 34 70) ; "You need to "use" the drill first."
					)
					(
						(not
							(= local0
								(proc315_0
									34
									71
									150
									{ 1/32" }
									1
									150
									{ 1/16" }
									2
									150
									{ 1/8" }
									3
									150
									{ 1/4" }
									4
									150
									{ 1/2" }
									5
									150
									{ 3/4" }
									6
									150
									{__1"__}
									7
								)
							)
						)
						(Print 34 72) ; "You'll have to select a bit before you can use the drill."
					)
					((> (subMarine holeSize:) local0)
						(Print 34 73) ; "You've already drilled a hole bigger than that in the cylinder."
					)
					((== (subMarine holeSize:) local0)
						(Print 34 74) ; "You've already drilled a hole that size in the cylinder."
					)
					(else
						(Print 34 75) ; "After selecting the bit size, you insert it into the chuck and tighten it."
						(= local3 3)
						(if (== local0 4)
							(SetScore subMarine 406 1024 2)
						)
					)
				)
			)
		)
	)
)

(instance grinder of RPicView
	(properties
		y 96
		x 31
		view 34
		loop 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/grinder]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 34 76) ; "This grinder is used to smooth rough edges."
					)
					((and (== local5 1) (or (Said 'use') (Said 'turn<on')))
						(localproc_1)
					)
					((GoToIfSaid self event self 10 0 34 13))
					((Said 'use')
						(cond
							((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 34 77) ; "You have nothing in possession that needs grinding."
							)
							((& (subMarine roomFlags:) $0004)
								(Print 34 78) ; "You've already ground the rough edges off the cylinder."
							)
							((not (subMarine holeSize:))
								(Print 34 79) ; "You need to drill the cylinder before you grind the rough edges."
							)
							(else
								(Print 34 80) ; "You hold the cylinder close to the grinder in preparation for grinding."
								(= local4 2)
							)
						)
					)
					((Said 'start,(turn<on)')
						(if (!= local4 2)
							(Print 34 81) ; "You have to "use" the grinder first."
						else
							(drillHead setScript: grindScript)
						)
					)
				)
			)
		)
	)
)

(instance pump of RFeature
	(properties
		y 136
		x 114
		nsTop 105
		nsLeft 91
		nsBottom 168
		nsRight 138
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/pump]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 34 82) ; "They are computerized trim and drain pumps used to move water for the stability of the submarine."
					)
					((Said 'turn<on')
						(Print 34 83) ; "Don't worry yourself with trying to do that. It's done automatically with computers."
					)
					((Said 'examine')
						(Print 34 84) ; "All systems and equipment are functioning properly."
					)
				)
			)
			((Said 'move/water')
				(Print 34 83) ; "Don't worry yourself with trying to do that. It's done automatically with computers."
			)
		)
	)
)

(instance system of RFeature
	(properties
		y 67
		x 218
		nsTop 48
		nsLeft 191
		nsBottom 86
		nsRight 245
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/system]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 34 85) ; "The boats air-conditioning system, and a system that extracts oxygen from sea water is housed in this compartment."
					)
					((Said 'turn<on,operate')
						(Print 34 86) ; "No need to bother yourself with that."
					)
					((Said 'examine')
						(Print 34 84) ; "All systems and equipment are functioning properly."
					)
				)
			)
		)
	)
)

(instance doorSound of Sound
	(properties
		number 19
		priority 2
	)
)

(instance machNoise of Sound
	(properties
		priority 3
	)
)

