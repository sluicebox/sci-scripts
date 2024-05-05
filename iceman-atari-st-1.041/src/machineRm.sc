;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n315)
(use n824)
(use n828)
(use Approach)
(use n954)
(use LoadMany)
(use RFeature)
(use Sight)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	machineRm 0
	machNoise 1
	dial1 2
	dial2 3
	dial3 4
	shaft 5
)

(local
	local0
	local1
	local2
	[local3 3] = [127 175 265]
	[local6 3] = [134 136 120]
	[local9 3] = [127 175 265]
	[local12 15] = [140 142 124 48 88 254 93 92 88 74 139 287 101 98 97]
)

(procedure (localproc_0)
	(Print 34 0) ; "You need to open the cabinet first."
)

(procedure (localproc_1) ; UNUSED
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
		(willie init: setCycle: Walk setAvoider: Avoid setScript: willieScript)
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
		(gEgo illegalBits: -32768)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(DisposeScript 315)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene,equipment]')
				(Print 34 2) ; "You see a fully equipped machinery compartment with lathe, drill press and grinder. Other systems and pumps are housed in this area also."
				(Print 34 3) ; "On the side of the machinery compartment you see a cabinet."
			)
			((Said 'cycle/equipment')
				(Print 34 4) ; "All the equipment is working properly."
			)
			((Said 'examine,look[<at]/cylinder')
				(if (not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
					(Print 34 5) ; "You don't have a cylinder."
				else
					((gInventory at: 12) showSelf:) ; Sub: Metal_Cylinder | Tunisia: Business_Card
				)
			)
			((Said 'measure/cylinder')
				(cond
					((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
						(Print 34 5) ; "You don't have a cylinder."
					)
					((not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
						(Print 34 6) ; "You have nothing to measure it with."
					)
					((== (subMarine invStatus1:) 4)
						(Print 34 7) ; "The diameter of the sheared cylinder is 1", and the hole for the cotter pin is 1/4". You can't tell how long it was because it has been sheared off."
					)
					(else
						(Printf ; "The cylinder is %s" long."
							34
							8
							(switch (subMarine invStatus1:)
								(1 {3})
								(2 {4})
								(3 {6})
							)
						)
						(if (subMarine cylDiam:)
							(Printf ; "It has been milled to a diameter of %s."
								34
								9
								(switch (subMarine cylDiam:)
									(1 {1"})
									(2 {1.5"})
									(3 {2"})
								)
							)
						)
						(if (subMarine holeSize:)
							(Printf ; "It has a %s hole drilled near one end."
								34
								10
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
							(Print 34 11) ; "The rough edges have been ground smooth."
						else
							(Print 34 12) ; "It has rough edges."
						)
					)
				)
			)
		)
	)
)

(instance willieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(if (== register 3)
					(= start 4)
					(self init:)
				else
					(client
						setMotion:
							MoveTo
							[local3 register]
							[local6 register]
							self
					)
				)
			)
			(2
				(client
					setMotion: MoveTo [local9 register] [local12 register] self
				)
				(++ register)
			)
			(3
				(self init:)
			)
			(4
				(client setMotion: MoveTo 300 95 self)
			)
			(5
				(tubeDoor setCel: (tubeDoor lastCel:) setCycle: Beg self)
			)
			(6
				(tubeDoor stopUpd:)
				(client
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 325 84 self
				)
			)
			(7
				(tubeDoor setCycle: End self)
			)
			(8
				(tubeDoor stopUpd:)
				(client dispose:)
			)
		)
	)
)

(instance willie of Act
	(properties
		y 150
		x 76
		view 534
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look,talk/man,johnson'))
			((Said 'look[<at][/man,johnson]')
				(Print 34 13) ; "This is Willie Johnson."
			)
			((Said 'talk/man,johnson')
				(if (& (subMarine roomFlags:) $0008)
					(Print 34 14) ; "Good day, Sir. I hope you're having a pleasant trip."
				else
					(Print 34 15) ; "Machinist Mate 2nd Class Willie Johnson says, "Hello, Commander, it's a pleasure to have you aboard!""
					(Print 34 16) ; "Continuing, Petty Officer Johnson says, "I need to get back to doing my inventory Commander, please feel free to look around all you want.""
					(subMarine roomFlags: (| (subMarine roomFlags:) $0008))
				)
			)
			((GoToIfSaid self event self 20 'get/key' 34 17))
			((Said 'get/key')
				(cond
					((gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
						(Print 34 18) ; "You already have it."
					)
					((>= ((subMarine script:) state:) 15)
						(Print 34 19) ; "Aye aye, Commander!" says Johnson, "Here you are, Sir."
						(gEgo get: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
					)
					(else
						(Print 34 20) ; "Well, Sir, I seem to have misplaced that key.  If I find it, I'll see to it that you get it."
					)
				)
			)
		)
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
						(Print 34 21) ; "The lathe is used to reduce the diameter of cylindrical objects."
					)
					((GoToIfSaid self event self 10 0 34 17))
					((Said 'use')
						(cond
							((== (subMarine cylDiam:) 1)
								(Print 34 22) ; "You've already turned the metal cylinder. The lathe can't be set any smaller."
							)
							((& local1 $0001)
								(Print 34 23) ; "The metal cylinder is secured in the chuck."
							)
							((gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 34 24) ; "You insert the metal cylinder into the chuck and secure it."
								(shaft init:)
								(|= local1 $0001)
								(gEgo put: 12 gCurRoom) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							)
							(else
								(Print 34 25) ; "You have no reason to use the lathe."
							)
						)
					)
					((Said 'adjust')
						(cond
							((& local1 $0002)
								(Print 34 26) ; "The lathe is already set."
							)
							(
								(not
									(= local0
										(proc315_0
											34
											27
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
								(Print 34 28) ; "You'll have to set the lathe diameter before you can use it."
							)
							(
								(and
									(< (subMarine cylDiam:) local0)
									(subMarine cylDiam:)
								)
								(Print 34 29) ; "You've already turned the cylinder to a smaller diameter."
							)
							((== (subMarine cylDiam:) local0)
								(Print 34 30) ; "You've already turned the cylinder to that diameter."
							)
							(else
								(|= local1 $0002)
								(switch local0
									(1
										(Print 34 31) ; "You set the lathe diameter to 1"."
										(SetScore subMarine 406 256 2)
									)
									(2
										(Print 34 32) ; "You set the lathe diameter to 1.5"."
									)
									(3
										(Print 34 33) ; "You set the lathe diameter to 2"."
									)
								)
							)
						)
					)
					((Said 'start,(turn<on)')
						(cond
							((and (& local1 $0002) (& local1 $0001))
								(blade setScript: (ScriptID 388 0)) ; latheScript
								(subMarine cylDiam: local0)
								(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(= local1 (& (&= local1 $fffd) $fffe))
							)
							((and (& local1 $0002) (not (& local1 $0001)))
								(Print 34 24) ; "You insert the metal cylinder into the chuck and secure it."
								(shaft init:)
								(blade setScript: (ScriptID 388 0)) ; latheScript
								(subMarine cylDiam: local0)
								(= local1 (& (&= local1 $fffd) $fffe))
							)
							((and (not (& local1 $0002)) (& local1 $0001))
								(Print 34 34) ; "The lathe has not been set."
							)
							((and (not (& local1 $0002)) (not (& local1 $0001)))
								(Print 34 35) ; "There's nothing secured in the lathe, nor is the lathe set."
							)
						)
					)
				)
			)
			(
				(or
					(Said '/cylinder<chuck,lathe')
					(Said 'adjust,secure<in/cylinder/lathe')
					(Said 'turn/cylinder')
				)
				(gEgo setScript: walkLatheScript)
			)
			((Said 'get,detach/cylinder')
				(if (!= local1 1)
					(event claimed: 0)
				else
					(gEgo setScript: getCylScript 0 0)
				)
			)
		)
	)
)

(instance walkLatheScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid setMotion: Approach lathe 10 self)
			)
			(1
				(cond
					((== (subMarine cylDiam:) 1)
						(Print 34 22) ; "You've already turned the metal cylinder. The lathe can't be set any smaller."
					)
					((& local1 $0001)
						(Print 34 23) ; "The metal cylinder is secured in the chuck."
					)
					((gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
						(Print 34 24) ; "You insert the metal cylinder into the chuck and secure it."
						(shaft init:)
						(|= local1 $0001)
						(gEgo put: 12 gCurRoom) ; Sub: Metal_Cylinder | Tunisia: Business_Card
					)
					(else
						(Print 34 25) ; "You have no reason to use the lathe."
					)
				)
				(gEgo setAvoider: 0)
				(HandsOn)
				(self dispose:)
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
			((or (Said '[/drill,press,hole]>') (Said 'drill,press[/cylinder]>'))
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 34 36) ; "It's a normal upright drilling machine used to bore holes in metal."
					)
					((GoToIfSaid self event 79 97 '<use' 34 17))
					(
						(GoToIfSaid
							self
							event
							79
							97
							'drill,press,start,(turn<on)'
							34
							17
						))
					((GoToIfSaid self event 79 97 0 34 17))
					((or (Said '<use') (Said '/hole,cylinder'))
						(cond
							((& local2 $0001)
								(Print 34 37) ; "You've already secured the cylinder to the press."
							)
							((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 34 38) ; "You have no reason to use the drill press."
							)
							((== (subMarine holeSize:) 7)
								(Print 34 39) ; "You've already drilled the largest hole possible.  More drilling would be futile."
							)
							(else
								(Print 34 40) ; "You secure the metal cylinder to the press in preparation for drilling."
								(|= local2 $0001)
								(gEgo put: 12 gCurRoom) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							)
						)
					)
					((Said 'start,(turn<on)')
						(cond
							((and (& local2 $0002) (& local2 $0001))
								(drillHead setScript: (ScriptID 388 1)) ; drillScript
								(if (== local0 4)
									(SetScore subMarine 406 2048 1)
								)
								(subMarine holeSize: local0)
								(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(= local2 (& (&= local2 $fffd) $fffe))
							)
							((and (& local2 $0002) (not (& local2 $0001)))
								(Print 34 40) ; "You secure the metal cylinder to the press in preparation for drilling."
								(drillHead setScript: (ScriptID 388 1)) ; drillScript
								(if (== local0 4)
									(SetScore subMarine 406 2048 1)
								)
								(subMarine holeSize: local0)
								(= local2 (& (&= local2 $fffd) $fffe))
							)
							((and (not (& local2 $0002)) (& local2 $0001))
								(Print 34 41) ; "You need to select the bit to use."
							)
							((and (not (& local2 $0002)) (not (& local2 $0001)))
								(Print 34 42) ; "You haven't secured anything to the drill press, nor have you selected a bit."
							)
						)
					)
				)
			)
			((Said '/bit,(size<bit)>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 34 43) ; "A collection of drill bits."
					)
					((GoToIfSaid self event 79 97 'get,choose,pick' 34 17))
					((Said 'get,choose,pick')
						(cond
							(
								(not
									(= local0
										(proc315_0
											34
											44
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
								(Print 34 45) ; "You don't select a bit after all."
							)
							((> (subMarine holeSize:) local0)
								(Print 34 46) ; "You've already drilled a hole bigger than that in the cylinder."
							)
							((== (subMarine holeSize:) local0)
								(Print 34 47) ; "You've already drilled a hole that size in the cylinder."
							)
							(else
								(Print 34 48) ; "After selecting the bit size, you insert it into the chuck and tighten it."
								(|= local2 $0002)
								(if (== local0 4)
									(SetScore subMarine 406 1024 2)
								)
							)
						)
					)
				)
			)
			((Said 'get,detach/cylinder')
				(if (!= local2 1)
					(event claimed: 0)
				else
					(gEgo setScript: getCylScript 0 1)
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 34 49) ; "This grinder is used to smooth rough edges."
					)
					((GoToIfSaid self event self 10 'use,start,(turn<on)' 34 17))
					((Said 'use,start,(turn<on)')
						(cond
							((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 34 50) ; "You have nothing in your possession that needs grinding."
							)
							((& (subMarine roomFlags:) $0004)
								(Print 34 51) ; "You've already ground the rough edges off the cylinder."
							)
							(else
								(Print 34 52) ; "You hold the cylinder close to the grinder in preparation for grinding."
								(drillHead setScript: (ScriptID 388 2)) ; grindScript
							)
						)
					)
				)
			)
		)
	)
)

(instance getCylScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if register
					(gEgo
						setAvoider: Avoid
						setMotion: Approach drill 10 self
					)
				else
					(gEgo
						setAvoider: Avoid
						setMotion: Approach lathe 10 self
					)
				)
			)
			(1
				(Print 34 53) ; "You grab the cylinder from the machine."
				(if (not register)
					(shaft dispose:)
				)
				(&= local2 $fffe)
				(&= local1 $fffe)
				(gEgo setAvoider: 0 get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
				(HandsOn)
				(self dispose:)
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 34 54) ; "They are computerized trim and drain pumps used to move water for the stability of the submarine."
					)
					((Said 'turn<on,operate')
						(Print 34 55) ; "Don't worry about that. It's done automatically with computers."
					)
					((Said 'examine')
						(Print 34 56) ; "All systems and equipment are functioning properly."
					)
				)
			)
			((Said 'move/water')
				(Print 34 55) ; "Don't worry about that. It's done automatically with computers."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 34 57) ; "The boat's air-conditioning system, and a system that extracts oxygen from sea water are housed in this compartment."
					)
					((Said 'turn<on,operate')
						(Print 34 58) ; "No need to bother with that."
					)
					((Said 'examine')
						(Print 34 56) ; "All systems and equipment are functioning properly."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 34 59) ; "The door to the access tube."
					)
					((Said 'close')
						(Print 34 60) ; "It does that by itself."
					)
					((GoToIfSaid self event self 20 0 34 17))
					((Said 'open')
						(HandsOff)
						(gEgo illegalBits: 0 setMotion: MoveTo 320 84)
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

	(method (cue)
		(if (!= (self cel:) 0)
			(Print 34 61) ; "You open the cabinet door and see bins with various sized metal cylinders, bolts, washers, nuts, and cotter pins."
		)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/cabinet]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at,in]')
						(if (== (self cel:) 0)
							(Print 34 62) ; "A cabinet equipped with spare parts."
						else
							(Print 34 63) ; "A cabinet containing bins with various sized metal cylinders, bolts, washers, nuts, and cotter pins."
						)
					)
					((GoToIfSaid self event 256 95 0 34 17))
					((Said 'open')
						(if (!= (self cel:) 0)
							(Print 34 64) ; "It's already open."
						else
							(self setCycle: End self)
						)
						(gEgo heading: 90)
						((gEgo looper:) doit: gEgo (gEgo heading:))
					)
					((Said 'close')
						(if (== (self cel:) 0)
							(Print 34 65) ; "You already did that."
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
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 66) ; "The bins contain various sized metal cylinders, bolts, washers, nuts, and cotter pins."
						)
					)
					((GoToIfSaid self event 256 95 0 34 17))
					((Said 'get[<!*]/*')
						(if (== (self cel:) 0)
							(localproc_0)
						else
							(Print 34 67) ; "The bins themselves are securely welded to the inside of the cabinet."
						)
					)
				)
			)
			((Said '[/cylinder]>')
				(cond
					((and (CantBeSeen self gEgo 180 50) (Said 'look[<at]'))
						(event claimed: 0)
					)
					((TurnIfSaid self event 'examine,look[<at]/*'))
					((Said 'examine,look[<at]')
						(if (not cel)
							(localproc_0)
						else
							(Print 34 68) ; "The metal cylinders come in three different lengths:   3", 4", 6" However, they're all about 2 1/2" in diameter."
						)
					)
					(
						(and
							(or (& local1 $0001) (& local2 $0001))
							(Said 'get[<!*]/*')
						)
						(event claimed: 0)
					)
					((GoToIfSaid self event 256 95 'get[<!*]/*' 34 17))
					((Said 'get[<!*]/*')
						(cond
							((not cel)
								(localproc_0)
							)
							(
								(= local0
									(proc315_0
										34
										69
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
								(if (gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
									(Printf ; "You toss the cylinder you have and pick up a %d" cylinder."
										34
										70
										(+ (* local0 2) (== local0 1))
									)
								else
									(Printf ; "You pick up a %d" cylinder."
										34
										71
										(+ (* local0 2) (== local0 1))
									)
								)
								(subMarine cylDiam: 0)
								(subMarine holeSize: 0)
								(subMarine
									roomFlags: (& (subMarine roomFlags:) $fffb)
								)
								(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(subMarine invStatus1: local0)
								(if (== local0 3)
									(SetScore subMarine 406 64 1)
								)
							)
							(else
								(Print 34 72) ; "You don't pick up any cylinders."
							)
						)
					)
				)
			)
			((Said '[/bolt]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (not cel)
							(localproc_0)
						else
							(Print 34 73) ; "There are many bolts in the bin."
						)
					)
					((GoToIfSaid self event 256 95 0 34 17))
					((Said 'get[<!*]/*')
						(if (not cel)
							(localproc_0)
						else
							(Print 34 74) ; "You don't need any bolts."
						)
					)
				)
			)
			((Said '[/nut]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (not cel)
							(localproc_0)
						else
							(Print 34 75) ; "The nuts are:   1/4"   1/2"   3/4"   1""
						)
					)
					((GoToIfSaid self event 256 95 'get[<!*]/*' 34 17))
					((Said 'get[<!*]/*')
						(cond
							((not cel)
								(localproc_0)
							)
							(
								(= local0
									(proc315_0
										34
										69
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
								(if (gEgo has: 11) ; Sub: Nut | Tunisia: Coffee_Canister
									(Printf ; "You drop the nut you are carrying and pick up a %s" nut."
										34
										76
										(switch local0
											(1 {1/4})
											(2 {1/2})
											(3 {3/4})
											(4 {1})
										)
									)
								else
									(Printf ; "You pick up a %s" nut."
										34
										77
										(switch local0
											(1 {1/4})
											(2 {1/2})
											(3 {3/4})
											(4 {1})
										)
									)
								)
								(gEgo get: 11) ; Sub: Nut | Tunisia: Coffee_Canister
								(subMarine invStatus3: local0)
							)
							(else
								(Print 34 78) ; "You don't pick up any nuts."
							)
						)
					)
				)
			)
			((Said '[/washer]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (not cel)
							(localproc_0)
						else
							(Print 34 79) ; "The washers are:   1/4"   1/2"   3/4"   1""
						)
					)
					((GoToIfSaid self event 256 95 'get[<!*]/*' 34 17))
					((Said 'get[<!*]/*')
						(cond
							((not cel)
								(localproc_0)
							)
							(
								(= local0
									(proc315_0
										34
										69
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
								(if (gEgo has: 10) ; Sub: Washer | Tunisia: Flour_Canister
									(Printf ; "You drop the washer you are carrying and pick up a %s" washer."
										34
										80
										(switch local0
											(1 {1/4})
											(2 {1/2})
											(3 {3/4})
											(4 {1})
										)
									)
								else
									(Printf ; "You pick up a %s" washer."
										34
										81
										(switch local0
											(1 {1/4})
											(2 {1/2})
											(3 {3/4})
											(4 {1})
										)
									)
								)
								(gEgo get: 10) ; Sub: Washer | Tunisia: Flour_Canister
								(subMarine invStatus4: local0)
							)
							(else
								(Print 34 82) ; "You don't pick up any washers."
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
								(Print 34 83) ; "You don't have a cotter pin."
							)
							((not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
								(Print 34 6) ; "You have nothing to measure it with."
							)
							(else
								(Print 34 84) ; "After measuring the cotter pin, you find it to be two inches long and will fit a quarter inch hole."
								(SetScore subMarine 406 128 1)
							)
						)
					)
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (not cel)
							(localproc_0)
						else
							(Print 34 85) ; "A standard cotter pin."
						)
					)
					((GoToIfSaid self event 256 95 0 34 17))
					((Said 'get[<!*]/*')
						(if (not cel)
							(localproc_0)
						else
							(Print 34 86) ; "You pick up a cotter pin."
							(gEgo get: 9) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
						)
					)
				)
			)
		)
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
		(if (== x 115)
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

