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
(use RFeature)
(use Sight)
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
	[local24 5] = [96 251 188 95 65]
	[local29 5] = [65 91 83 71 71]
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
)

(instance torpedoRm of Rm
	(properties
		picture 33
		north 32
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
		(if (not (& (subMarine roomFlags:) $1000))
			(= local37 1)
			(torpedoMan init: setCycle: Walk setScript: torpedoManIntro)
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
		(self setFeatures: cotterPin explosives flares setRegions: 314) ; subMarine
		(if (& (subMarine roomFlags:) $0400)
			(self setFeatures: roomHammer)
		)
		(proc824_0)
		(gEgo
			init:
			illegalBits: 0
			ignoreActors: 0
			view: 232
			posn: 9 52
			setScript: egoScript
		)
		(if (& (subMarine roomFlags:) $2000)
			(= local41 1)
		)
		(if (& (subMarine roomFlags:) $0800)
			(messedUpEquipment doit:)
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
				(if
					(or
						(not (< (gEgo distanceTo: roomHammer) 20))
						(gEgo has: 15) ; Hammer
						(not (& (subMarine roomFlags:) $0400))
					)
					(Print 33 4) ; "You see the well-polished floor below."
				else
					(Print 33 5) ; "You see a hammer lying on the floor."
				)
			)
		)
	)
)

(instance torpedoMan of Act
	(properties
		y 104
		x 80
		view 132
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/man<old]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 6) ; "Chief Petty Officer Patrick Hawkins."
					)
					((GoToIfSaid self event self 30 0 33 7))
					((Said 'talk')
						(cond
							(local40
								(Print 33 8) ; "You are a great man. Nobody but you could fix that."
							)
							((and (== local39 1) (== local40 0))
								(Print 33 9) ; "I think you should finish the job, sir."
							)
							((and (== local34 1) (== local40 0) (== local39 0))
								(Print 33 10) ; "The old man has better things to do with his time than to continue talking with you."
							)
							(else
								(torpedoManIntro
									setScript: talkToManScript self
								)
							)
						)
					)
				)
			)
		)
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
			(entryDoor setScript: leaveRoomScript)
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
			((Said '[/control,panel,equipment]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]/control,panel')
						(Print 33 11) ; "The control panel for the equipment in this area."
					)
					((GoToIfSaid self event 261 84 'cycle/equipment' 33 7))
					((Said 'cycle')
						(conveyorBelt setScript: cycleEquipment)
					)
				)
			)
		)
	)
)

(instance conveyorBelt of Act
	(properties
		y 89
		x 100
		view 233
		loop 5
		priority 8
		signal 18449
		illegalBits 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/conveyor,(belt<conveyor),equipment]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 33 12) ; "The conveyor is used to load or unload weapons."
					)
					((GoToIfSaid self event 261 84 'cycle/equipment' 33 7))
					((Said 'cycle')
						(conveyorBelt setScript: cycleEquipment)
					)
					((GoToIfSaid self event 143 85 0 33 7))
					((Said 'measure')
						(if (gEgo has: 13) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
							(Print 33 13) ; "Measuring the area of the conveyor where the missing part fits, you determine the replacement pin needs to be 6 inches long."
						else
							(Print 33 14) ; "You have nothing to measure with!"
						)
					)
					((Said 'check,examine,examine')
						(if (and local38 (not local39))
							(conveyorBelt setScript: foundShearedPin)
						else
							(Print 33 15) ; "You inspect the equipment which appears to be functional."
						)
					)
					((Said 'stop')
						(Print 33 16) ; "The equipment is not cycling, and therefore cannot be stopped."
					)
					((Said 'fix')
						(cond
							(local40
								(Print 33 17) ; "You need not fix it again."
							)
							((and local39 (not local40))
								(Print 33 18) ; "You will need you use a hammer to install the cotter pin."
							)
							((not (gEgo has: 15)) ; Hammer
								(Print 33 19) ; "You don't have anything to fix the conveyor with."
							)
							((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 33 20) ; "You do not have a replacement pin."
							)
							((!= (subMarine invStatus1:) 3)
								(Print 33 21) ; "The replacement pin is not long enough."
							)
							((!= (subMarine cylDiam:) 1)
								(Print 33 22) ; "The replacement pin is too big."
							)
							((not (& (subMarine roomFlags:) $0004))
								(Print 33 23) ; "You need to smooth off the end of that pin."
							)
							((not (subMarine holeSize:))
								(Print 33 24) ; "There is no hole in the cylinder for the cotter pin."
							)
							((< (subMarine holeSize:) 4)
								(Print 33 25) ; "The hole is too small for the cotter pin to fit."
							)
							((> (subMarine holeSize:) 4)
								(Print 33 26) ; "The hole is too large for the cotter pin to fit."
							)
							(else
								(theSound number: (proc0_5 33) loop: 4 play:)
								(Print 33 27) ; "Using the hammer, you pound the pin into place."
								(Print 33 28) ; "Thinking to yourself... "Well, so much for the pin.""
								(gEgo put: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(subMarine
									roomFlags: (| (subMarine roomFlags:) $1000)
								)
								(= local39 1)
								(gGame changeScore: 1)
							)
						)
					)
				)
			)
		)
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
						(Print 33 29) ; "The hydraulic arms are used to transfer the weapons to the conveyor."
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
						(Print 33 29) ; "The hydraulic arms are used to transfer the weapons to the conveyor."
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
						(Print 33 29) ; "The hydraulic arms are used to transfer the weapons to the conveyor."
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
						(Print 33 30) ; "The "Harpoon" delivers its destructive payload through the air at subsonic speeds."
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
						(Print 33 31) ; "The "Sting Ray" torpedo is equipped with a low yield nuclear warhead that delivers the equivalent of 500 pounds of TNT at a speed of 90 knots."
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
						(Print 33 30) ; "The "Harpoon" delivers its destructive payload through the air at subsonic speeds."
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
						(Print 33 32) ; "The "Emerson 92" decoy is designed to emit an acoustical signature identical to that of the USS Blackhawk."
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
						(Print 33 33) ; "The "LX 185" torpedo is equipped with a low yield nuclear warhead that delivers the equivalent of 500 pounds of TNT at a speed of 45 knots."
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
						(Print 33 30) ; "The "Harpoon" delivers its destructive payload through the air at subsonic speeds."
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
						(Print 33 32) ; "The "Emerson 92" decoy is designed to emit an acoustical signature identical to that of the USS Blackhawk."
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
						(Print 33 32) ; "The "Emerson 92" decoy is designed to emit an acoustical signature identical to that of the USS Blackhawk."
					)
				)
			)
		)
	)
)

(instance conveyorStand of Act
	(properties
		y 114
		x 106
		view 233
		cel 3
		priority 7
		signal 18449
		illegalBits 0
	)
)

(instance explosives of RFeature
	(properties
		y 11
		x 37
		nsTop 11
		nsLeft 37
		nsBottom 11
		nsRight 37
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bomb]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((GoToIfSaid self event self 30 0 33 7))
					((Said 'look[<at]')
						(if (gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
							(event claimed: 0)
						else
							(Print 33 34) ; "Plastic explosives used for underwater demolition."
						)
					)
					((Said 'get')
						(if (gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
							(proc0_35) ; "You already took that."
						else
							(Print 33 35) ; "You take a plastic type explosive possessing a charge equivalent to 500 lbs. of TNT."
							(gEgo get: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						)
					)
				)
			)
		)
	)
)

(instance flares of RFeature
	(properties
		y 12
		x 38
		nsTop 12
		nsLeft 38
		nsBottom 12
		nsRight 38
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/flare]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if (>= global103 8)
							(event claimed: 0)
						else
							(Print 33 36) ; "Underwater flares."
						)
					)
					((GoToIfSaid self event self 30 0 33 7))
					((Said 'get')
						(cond
							((== global103 0)
								(+= global103 4)
								(gEgo get: 7) ; Sub: Flare | Tunisia: Duct_Tape
								(Print 33 37) ; "You pick up a box of flares."
							)
							((== global103 4)
								(+= global103 4)
								(gGame changeScore: 1)
								(Print 33 38) ; "You pick up the second box of flares."
							)
							(else
								(proc0_40) ; "You don't see that."
							)
						)
					)
				)
			)
		)
	)
)

(instance cotterPin of RFeature
	(properties
		y 108
		x 124
		nsTop 119
		nsLeft 104
		nsBottom 130
		nsRight 113
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'use/pin<cotter')
				(if (gEgo has: 9) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
					(Print 33 39) ; "What do you want to do with it?"
				else
					(proc0_38) ; "You don't have that."
				)
			)
			((Said 'insert,install/pin<cotter')
				(gEgo setScript: installGoodCotterPin)
			)
			((Said '[/pin[<sheared]]>')
				(cond
					((TurnIfSaid self event 'examine,examine,look[<at]/*'))
					((Said 'examine,examine,look[<at]')
						(cond
							((and local35 (not (gEgo has: 12))) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 33 40) ; "A pin with a hole in one end which was secured by a cotter pin."
							)
							((and (not local35) (not (gEgo has: 12))) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 33 41) ; "It looks O.K."
							)
							((gEgo has: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								((gInventory at: 12) showSelf:) ; Sub: Metal_Cylinder | Tunisia: Business_Card
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((GoToIfSaid self event self 40 0 33 7))
					((Said 'insert')
						(if (gEgo has: 9) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
							(Print 33 42) ; "You need to "fix" the equipment."
						else
							(event claimed: 0)
						)
					)
					((Said 'get,remove,replace/*')
						(cond
							((and local35 local37 (not local36))
								(= local36 1)
								(torpedoMan setScript: replacePin)
							)
							((not local35)
								(Print 33 43) ; "The current pin is fine."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'repair,fix')
						(cond
							(local36
								(Print 33 44) ; "It is more complicated than that, Commander."
							)
							((not local35)
								(Print 33 43) ; "The current pin is fine."
							)
							(else
								(Print 33 45) ; "You need to "remove" the pin first."
							)
						)
					)
					((Said 'measure')
						(cond
							((not local35)
								(Print 33 46) ; "You don't have a pin."
							)
							((not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
								(Print 33 47) ; "You have nothing in your possession to measure with."
							)
							((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
								(Print 33 46) ; "You don't have a pin."
							)
							(else
								(Print 33 48) ; "You measure the diameter of the sheared pin to be 1 inch, the length to be 6 inches, and the hole for the cotter pin to be one-quarter of an inch."
								(if local37
									(Print 33 49) ; "You watch as Chief Petty Officer Hawkins leaves the room."
									(SetScore subMarine 406 32 5)
									(torpedoMan setScript: firstLeaving)
								)
							)
						)
					)
				)
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
							(openExplosivesDoorScript
								setScript: lookInExplosivesDoorScript
							)
						else
							(Print 33 50) ; "Walk up to the door."
						)
					)
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'close')
						(proc0_37) ; "You can't do that."
					)
					((Said 'look[<at]')
						(Print 33 51) ; "This door is labelled "Explosives"."
					)
					((Said 'open')
						(Print 33 52) ; "Just walk up to it."
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
		(theSound number: (proc0_5 19) play:)
	)
)

(instance roomHammer of RFeature
	(properties
		y 70
		x 255
		nsTop 70
		nsLeft 255
		nsBottom 70
		nsRight 255
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look<below/panel<control')
				(cond
					((not (< (gEgo distanceTo: roomHammer) 20))
						(proc0_34) ; "You're not close enough."
					)
					((gEgo has: 15) ; Hammer
						(proc0_36) ; "You see nothing special."
					)
					(else
						(Print 33 5) ; "You see a hammer lying on the floor."
					)
				)
			)
			((Said '[/hammer]>')
				(cond
					((Said 'look[<at]')
						(if (> (gEgo distanceTo: roomHammer) 20)
							(proc0_40) ; "You don't see that."
						else
							(Print 33 53) ; "A typical hammer."
						)
					)
					((Said 'get')
						(cond
							((not (< (gEgo distanceTo: roomHammer) 20))
								(proc0_40) ; "You don't see that."
							)
							((gEgo has: 15) ; Hammer
								(proc0_35) ; "You already took that."
							)
							(else
								(Print 33 54) ; "You reach down and pick the hammer up off the floor."
								(gEgo get: 15) ; Hammer
							)
						)
					)
					((Said 'find,look[<for]')
						(Print 33 55) ; "Find it yourself."
					)
					((Said 'use')
						(gEgo setScript: installGoodCotterPin)
					)
				)
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

(instance messedUpEquipment of Obj
	(properties)

	(method (doit)
		(conveyorBelt posn: 91 93 setPri: 8 setScript: 0 stopUpd:)
		(conveyorStand posn: 97 117 setPri: 7 stopUpd:)
		(missileGrabber setCel: 11 setPri: 4)
		(if (not local41)
			(missileOne posn: 130 71 setPri: 9 setScript: 0 stopUpd:)
		)
		(missileTube posn: 220 134 stopUpd:)
		(= local38 1)
		(if (& (subMarine roomFlags:) $1000)
			(= local39 1)
		else
			(= local35 1)
			(torpedoMan setLoop: -1 setScript: torpedoManIntro)
		)
		(if (& (Submarine flags:) $0100)
			(= local40 1)
		)
	)
)

(instance replacePin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 33 56) ; "You instruct the torpedoman to remove the broken pin."
				(Print 33 57) ; "Aye sir" he says..."I'll need a couple of tools"
				(= cycles 1)
			)
			(1
				(torpedoMan
					setLoop: -1
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 10 60 self
				)
			)
			(2
				(entryDoor setMotion: MoveTo 0 7 self)
			)
			(3
				(entryDoor stopUpd:)
				(torpedoMan setMotion: MoveTo 10 52 self)
			)
			(4
				(entryDoor setMotion: MoveTo 0 58 self)
			)
			(5
				(entryDoor stopUpd:)
				(torpedoMan setLoop: 0)
				(torpedoMan setLoop: -1 stopUpd:)
				(= seconds 6)
			)
			(6
				(entryDoor setMotion: MoveTo 0 7 self)
			)
			(7
				(entryDoor stopUpd:)
				(torpedoMan setMotion: MoveTo 34 65 self)
			)
			(8
				(entryDoor setMotion: MoveTo 0 58 self)
			)
			(9
				(entryDoor stopUpd:)
				(torpedoMan setMotion: Approach cotterPin 40 self)
			)
			(10
				(= seconds 4)
			)
			(11
				(torpedoMan setMotion: Approach gEgo 25 self)
			)
			(12
				(torpedoMan ignoreActors: 0 illegalBits: $8000)
				(Print 33 58) ; "Handing you the sheared pin he says..."Here ya are sir. We most definitely will need a new part before we're capable of loading me weapons.""
				(gEgo get: 12) ; Sub: Metal_Cylinder | Tunisia: Business_Card
				(subMarine invStatus1: 0)
				(torpedoMan setScript: torpedoManIntro)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance chiefLeaving of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(torpedoMan
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 10 60 self
				)
			)
			(1
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
				(HandsOn)
				(entryDoor stopUpd:)
				(= local37 0)
				(torpedoMan hide:)
				(self dispose:)
			)
		)
	)
)

(instance egoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors: setMotion: MoveTo 53 81)
				(= cycles 10)
			)
			(1
				(entryDoor setMotion: MoveTo 0 58 self)
			)
			(2
				(entryDoor stopUpd:)
				(gEgo illegalBits: $8000 ignoreActors: 0)
				(HandsOn)
				(= cycles 1)
			)
			(3
				(if (and (& (subMarine roomFlags:) $0400) local37)
					(torpedoMan setScript: 0)
					(torpedoMan setScript: torpedoManLostHammerScript)
				)
				(self dispose:)
			)
		)
	)
)

(instance foundShearedPin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: Approach cotterPin 60 self)
			)
			(1
				(Print 33 59) ; "Inspecting the conveyor you find a sheared pin."
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
					((and local38 (not local40))
						(Print 33 60) ; "The conveyor belt is not yet fixed."
						(self dispose:)
					)
					(local41
						(Print 33 61) ; "You need not cycle the equipment again."
						(self dispose:)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(HandsOff)
				(if local37
					(self setScript: getManOutOfWayScript self)
				else
					(= cycles 1)
				)
			)
			(2
				(if local40
					(self setScript: cycleEquipmentPartTwoScript)
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
				(theSound number: (proc0_5 86) play:)
				(= cycles 6)
			)
			(7
				(theSound number: (proc0_5 48) play:)
				(missileGrabber setCycle: End self)
			)
			(8
				(theSound number: (proc0_5 86) play: self)
			)
			(9
				(if (not local40)
					(Print 33 62 #at 190 120) ; "You watch as the powerful hydraulic arms pick up the torpedo and transfers it onto the conveyor."
				)
				(= cycles 1)
			)
			(10
				(missileOne setMotion: MoveTo 190 29 self)
			)
			(11
				(missileGrabber stopUpd:)
				(theSound number: (proc0_5 85) play:)
				(conveyorBelt setMotion: MoveTo 154 61 self)
				(missileOne setMotion: Track conveyorBelt 36 -20)
			)
			(12
				(theSound number: (proc0_5 86) play: self)
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
				(if (not local40)
					(Print 33 63 #at 5 6) ; "You continue to watch as the conveyor feeds the weapon toward the open torpedo tube."
				)
				(= cycles 1)
			)
			(15
				(theSound number: (proc0_5 88) play:)
				(missileTube setMotion: MoveTo 220 134 self)
			)
			(16
				(self setScript: cycleEquipmentPartTwoScript)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (< state 9) (not local40) (not script))
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
				(if local40
					(Print 33 64 #at 0 113) ; "Again you watch. This time the conveyor successfully feeds the weapon into the torpedo tube."
				else
					(Print 33 65 #at 0 113) ; "With a loud ratcheting sound, the conveyor comes to a stop failing to complete its cycle."
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
				(= local38 1)
				(subMarine roomFlags: (| (subMarine roomFlags:) $0800))
				(if local40
					(missileOne setMotion: 0)
					(self setScript: goodConveyorScript)
				else
					(= local35 1)
					(missileOne setMotion: 0)
					(self setScript: messedUpConveyorScript self)
				)
			)
			(2
				(missileOne setScript: 0 stopUpd:)
				(conveyorBelt setScript: 0 stopUpd:)
				(theSound stop:)
				(torpedoMan setPri: -1 setLoop: -1 setScript: torpedoManIntro)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 ignoreActors:)
				(torpedoMan setScript: 0 stopUpd:)
				(entryDoor setMotion: MoveTo 0 7 self)
			)
			(1
				(entryDoor stopUpd:)
				(gEgo setMotion: MoveTo 10 52 self)
			)
			(2
				(gEgo illegalBits: $8000 ignoreActors: 0 setPri: -1)
				(gCurRoom newRoom: 42) ; bHatchTubeRm
			)
		)
	)
)

(instance torpedoManIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(torpedoMan
					illegalBits: $8000
					ignoreActors: 0
					setMotion: MoveTo [local24 register] [local29 register]
				)
				(= seconds 6)
			)
			(1
				(if (== (++ register) 5)
					(= register 0)
				)
				(self init:)
			)
		)
	)
)

(instance torpedoManLostHammerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(torpedoMan illegalBits: 0 setMotion: Approach gEgo 20 self)
			)
			(1
				(Print 33 66) ; "The torpedoman says to you..."Shiver me timbers mate! I've misplaced me hammer somewhere. It's as frustrating as chasing an elusive wench!""
				(Print 33 67) ; "Continuing he says..."I'll return in a jiffy Commander.""
				(torpedoMan setScript: chiefLeaving)
			)
		)
	)
)

(instance openExplosivesDoorScript of Script
	(properties)

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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(explosivesDoor setCycle: End self)
			)
			(1
				(explosivesDoor stopUpd:)
				(cond
					((and (not (gEgo has: 3)) (== global103 0)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 33 68) ; "You open the door marked explosives. Inside you see plastic type explosives used in underwater demolition, two boxes of flares, and some other things that do not interest you."
					)
					((and (not (gEgo has: 3)) (== global103 4)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 33 69) ; "You open the door marked explosives. Inside you see plastic type explosives used in underwater demolition, one box of flares, and some other things that do not interest you."
					)
					((not (gEgo has: 3)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 33 70) ; "You open the door marked explosives. Inside you see plastic type explosives used in underwater demolition and some other things that do not interest you."
					)
					((== global103 0)
						(Print 33 71) ; "You open the door marked explosives. Inside you see two boxes of flares and some other things that do not interest you."
					)
					((== global103 4)
						(Print 33 72) ; "You open the door marked explosives. Inside you see one box of flares and some other things that do not interest you."
					)
					(else
						(Print 33 73) ; "You open the door marked explosives. Inside you see nothing of interest."
					)
				)
				(HandsOn)
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
				(missileOne setPri: 11 setMotion: MoveTo 293 124 self)
			)
			(1
				(HandsOn)
				(torpedoMan setScript: torpedoManIntro)
				(subMarine roomFlags: (| (subMarine roomFlags:) $2000))
				(conveyorBelt setCycle: 0 stopUpd:)
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
				(self dispose:)
			)
		)
	)
)

(instance getManOutOfWayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(torpedoMan setScript: 0)
				(if (== (torpedoMan onControl: 1) 8192)
					(torpedoMan illegalBits: 0 ignoreActors:)
					(torpedoMan setMotion: MoveTo 68 71 self)
				else
					(= cycles 1)
				)
			)
			(1
				(torpedoMan setLoop: 4)
				(= cycles 2)
			)
			(2
				(torpedoMan setLoop: -1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance bringManInRoomScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(torpedoMan show:)
				(entryDoor setMotion: MoveTo 0 7 self)
			)
			(1
				(entryDoor stopUpd:)
				(= local37 1)
				(torpedoMan setLoop: -1 setMotion: MoveTo 55 67 self)
			)
			(2
				(entryDoor setMotion: MoveTo 0 58 self)
			)
			(3
				(torpedoMan setMotion: MoveTo 68 71 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance firstLeaving of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(torpedoMan setScript: chiefLeaving self)
			)
			(1
				(Print 33 74) ; "You think to yourself.."Valuable time is passing by...I'll try fixing the conveyor myself.""
				(self dispose:)
			)
		)
	)
)

(instance lookInExplosivesDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(explosivesDoor stopUpd:)
				(cond
					((and (not (gEgo has: 3)) (== global103 0)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 33 75) ; "You look in the door marked explosives. Inside you see plastic type explosives used in underwater demolition, two boxes of flares, and some other things that do not interest you."
					)
					((and (not (gEgo has: 3)) (== global103 4)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 33 76) ; "You look in the door marked explosives. Inside you see plastic type explosives used in underwater demolition, one box of flares, and some other things that do not interest you."
					)
					((not (gEgo has: 3)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 33 77) ; "You look in the door marked explosives. Inside you see plastic type explosives used in underwater demolition and some other things that do not interest you."
					)
					((== global103 0)
						(Print 33 78) ; "You look in the door marked explosives. Inside you see two boxes of flares and some other things that do not interest you."
					)
					((== global103 4)
						(Print 33 79) ; "You look in the door marked explosives. Inside you see one box of flares and some other things that do not interest you."
					)
					((and (gEgo has: 3) (== global103 8)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 33 80) ; "You look in the door marked explosives. Inside you see nothing of interest."
					)
					(self species)
				)
			)
		)
	)
)

(instance talkToManScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(torpedoMan
					heading:
						(GetAngle
							(torpedoMan x:)
							(torpedoMan y:)
							(gEgo x:)
							(gEgo y:)
						)
				)
				(= cycles 1)
			)
			(1
				(Print 33 81) ; "The old man looks at you and says... "I cycled the equipment this morning and it sounded a little strange. There could be problems.""
				(= local34 1)
				(self dispose:)
			)
		)
	)
)

(instance installGoodCotterPin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (gEgo has: 9)) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
						(Print 33 82) ; "You don't have a cotter pin."
						(self dispose:)
					)
					((not local39)
						(Print 33 83) ; "You haven't installed the correct pin."
						(self dispose:)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(HandsOff)
				(gEgo setMotion: Approach conveyorBelt 60 self)
			)
			(2
				(Print 33 84) ; "You install the cotter pin which completes the repair."
				(gEgo put: 9) ; Sub: Cotter_pin | Tunisia: Sugar_Canister
				(= local40 1)
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

