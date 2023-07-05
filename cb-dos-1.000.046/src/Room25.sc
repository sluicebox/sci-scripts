;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use Wander)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room25 0
)

(synonyms
	(bird owl)
)

(local
	local0
	local1
	local2
	local3
)

(instance Room25 of Rm
	(properties
		picture 25
	)

	(method (init)
		(= horizon 84)
		(= east 26)
		(= north 13)
		(super init:)
		(Load rsSOUND 82)
		(if gDetailLevel
			(owlHead setScript: owl init:)
			(light1 setScript: showers init:)
			(light2 init:)
			(light3 init:)
			(flyCage left: -2 right: 82 bottom: 155 top: 100 init:)
			(Fly
				setLoop: 5
				cel: 0
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly2
				setLoop: 5
				cel: 1
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly3
				setLoop: 5
				cel: 2
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
			(Fly4
				setLoop: 5
				cel: 3
				setStep: 3 3
				observeBlocks: flyCage
				ignoreHorizon: 1
				setCycle: Fwd
				cycleSpeed: 2
				setMotion: Wander 5
				init:
			)
		else
			(owlHead loop: 4 cel: 2 addToPic:)
		)
		(self setRegions: 205 207 setFeatures: owlBody Barn House) ; swampReg, fenceReg
		(Load rsVIEW 35)
		(Thunder number: 17 loop: 0)
		(gAddToPics add: owlBody eachElementDo: #init doit:)
		(if (and (>= gAct 2) (< gAct 4))
			(self setRegions: 202) ; EthelDrunk
		)
		(if
			(or
				(and (== gAct 3) (!= global114 10))
				(and (== gAct 6) (not (& gMustDos $0002)))
			)
			(self setRegions: 281) ; rudywand
		)
		(if (>= gAct 4)
			(Foot ignoreActors: 1 init: stopUpd:)
		)
		(if (and (>= gAct 4) (== ((gInventory at: 4) owner:) 25)) ; rolling_pin
			(Pin init: stopUpd:)
		)
		(switch gPrevRoomNum
			(20
				(gEgo posn: 305 119)
			)
			(13
				(gEgo posn: 171 119)
			)
		)
		(gEgo view: 0 illegalBits: -32768 init:)
		(HandsOn)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 25 0) ; "You are at the southwest edge of the bayou island. The old road and fence have been overtaken by the rising swamp water."
		)
		(if (& (gEgo onControl: 0) $0002)
			(gCurRoom newRoom: 20)
		)
		(if (& (gEgo onControl: 0) $0004)
			(gCurRoom newRoom: 13)
		)
		(if (and (& (gEgo onControl: 1) $0008) (== local0 0))
			(= local0 1)
			(self setScript: sink)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 976)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(DisposeScript 990)
			(if (Said 'look>')
				(cond
					((Said '[<around,at][/room]')
						(Print 25 0) ; "You are at the southwest edge of the bayou island. The old road and fence have been overtaken by the rising swamp water."
					)
					((Said '/drive')
						(Print 25 1) ; "A dirt driveway leads from the carriage house to the old road."
					)
					((Said '/bootprint')
						(if (== gAct 4)
							(Print 25 2) ; "You closely examine the footprint and decide that it is the print of a boot."
						else
							(event claimed: 0)
						)
					)
					((or (Said '/dirt') (Said '<down'))
						(cond
							((gCast contains: Pin)
								(Print 25 3) ; "That's odd. There is a rolling pin lying on the ground."
							)
							((== gAct 4)
								(Print 25 4) ; "You can see a footprint in the mud."
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
		)
	)
)

(instance showers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (= state 3))
			)
			(1
				(light1 setCycle: Fwd)
				(light2 setCycle: Fwd)
				(light3 setCycle: Fwd)
				(= cycles 7)
			)
			(2
				(light1 setCycle: End)
				(light2 setCycle: End)
				(light3 setCycle: End self)
			)
			(3
				(Thunder loop: 1 play: self)
			)
			(4
				(if (< (Random 1 100) 20)
					(= state 0)
				)
				(= cycles 7)
			)
			(5
				(= state 3)
				(= seconds 5)
			)
		)
	)
)

(instance sink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(myMusic number: 82 loop: 1 play:)
				(gEgo
					view: 35
					cel: 0
					xStep: 1
					setMotion:
						MoveTo
						(switch (gEgo loop:)
							(0
								(+ (gEgo x:) 10)
							)
							(1
								(- (gEgo x:) 10)
							)
							(else
								(gEgo x:)
							)
						)
						(switch (gEgo loop:)
							(2
								(+ (gEgo y:) 3)
							)
							(3
								(- (gEgo y:) 3)
							)
							(else
								(gEgo y:)
							)
						)
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 3)
			)
			(2
				(= global128 myIcon)
				(= global129 5)
				(= global130 0)
				(= global132 1)
				(EgoDead 25 5) ; "Have you ever had that sinking feeling?"
			)
		)
	)
)

(instance owl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 7))
			)
			(1
				(if (== (owlHead cel:) 0)
					(owlHead setCycle: End self)
					(= local2 (Random 0 3))
				else
					(owlHead setCycle: Beg self)
					(= state -1)
				)
			)
			(2
				(if local2
					(= cycles 1)
				else
					(= seconds (Random 2 5))
				)
			)
			(3
				(if local2
					(owlHead loop: 4)
					(= seconds (Random 2 5))
				else
					(= state 0)
					(= cycles 1)
				)
			)
			(4
				(owlHead loop: 3)
				(= cycles 5)
			)
			(5
				(if (-- local2)
					(= state 2)
				else
					(= state 0)
				)
				(= cycles 1)
			)
		)
	)
)

(instance lookFoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo loop:) 3)
					(gEgo view: 125 cel: 0 loop: 7 setCycle: End self)
				else
					(gEgo view: 125 cel: 0 loop: 6 setCycle: End self)
				)
			)
			(1
				(Print 25 6 #icon 640 0 0) ; "Using Wilbur's monocle as a magnifying glass, you carefully examine the muddy impression and can see that it is definitely a bootprint. Aha! There on the sole is...an insignia of an eagle!"
				(SetFlag 4)
				(= cycles 1)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: 0 setCycle: Walk)
				(HandsOn)
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
				(LookAt gEgo Pin)
				(= cycles 2)
			)
			(1
				(if (== (gEgo loop:) 3)
					(gEgo view: 125 cel: 0 loop: 7 setCycle: End self)
				else
					(gEgo view: 125 cel: 0 loop: 6 setCycle: End self)
				)
			)
			(2
				(Print 25 7) ; "As you pick up the rolling pin you notice a muddy footprint nearby."
				(Pin hide:)
				(= global182 1)
				(gEgo get: 4) ; rolling_pin
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo view: 0 setCycle: Walk)
				(client dispose: setScript: 0)
			)
		)
	)
)

(instance owlBody of RPicView
	(properties
		y 117
		x 88
		view 125
		loop 4
		cel 1
		priority 15
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {owl})
		)
	)
)

(instance light1 of Prop
	(properties
		y 47
		x 28
		view 125
		cel 1
	)
)

(instance light2 of Prop
	(properties
		y 102
		x 28
		view 125
		loop 1
		cel 1
	)
)

(instance light3 of Prop
	(properties
		y 68
		x 106
		view 125
		loop 2
		cel 1
	)
)

(instance owlHead of Prop
	(properties
		y 93
		x 96
		view 125
		loop 3
		priority 15
		signal 16
		cycleSpeed 2
	)

	(method (handleEvent event)
		(cond
			((Said 'give,feed,show>')
				(if (or (Said '/*<bird') (Said '/bird') (Said '/*/bird'))
					(event claimed: 1)
					(if global219
						(if global224
							(Print 25 8) ; "The owl prefers small varmints that scurry around in the darkness."
						else
							(DontHave) ; "You don't have it."
						)
					else
						(Print 25 8) ; "The owl prefers small varmints that scurry around in the darkness."
					)
				)
			)
			((Said 'talk/bird')
				(Print 25 9) ; "Hoo, hoo."
			)
			((Said 'capture,get/bird')
				(Print 25 10) ; "You couldn't get close enough to the owl to get it."
			)
			((or (MousedOn self event 3) (Said 'look/bird'))
				(event claimed: 1)
				(Print 25 11) ; "The owl is on his nightly rodent patrol. He pays little attention to you."
			)
		)
	)
)

(instance Foot of Prop
	(properties
		y 128
		x 210
		view 125
		loop 8
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(Said 'look<use<monocle/bootprint')
					(Said '(look<at),look/bootprint/monocle<with')
				)
				(if (gEgo has: 1) ; monocle
					(if (< (gEgo distanceTo: Foot) 10)
						(if (>= gAct 4)
							(HandsOff)
							(= local3 1)
							(self setScript: lookFoot)
						else
							(Print 25 12) ; "You see no footprints."
						)
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(DontHave) ; "You don't have it."
				)
			)
			((or (MousedOn self event 3) (Said 'look/bootprint'))
				(event claimed: 1)
				(Print 25 4) ; "You can see a footprint in the mud."
			)
		)
	)
)

(instance Pin of Prop
	(properties
		y 128
		x 190
		view 125
		loop 4
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/pin<rolling'))
				(event claimed: 1)
				(Print 25 13) ; "You see a rolling pin and some muddy footprints."
			)
			((Said 'get/pin<rolling')
				(if (< (gEgo distanceTo: Pin) 20)
					(self setScript: pickUp)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance Thunder of Sound
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance myIcon of DCIcon
	(properties
		view 13
		loop 5
	)

	(method (init)
		((= cycler (End new:)) init: self)
	)
)

(instance Fly of Act
	(properties
		y 123
		x 74
		view 125
	)
)

(instance Fly2 of Act
	(properties
		y 150
		x 37
		view 125
	)
)

(instance Fly3 of Act
	(properties
		y 139
		x 17
		view 125
	)
)

(instance Fly4 of Act
	(properties
		y 130
		x 67
		view 125
	)
)

(instance flyCage of Cage
	(properties)
)

(instance Barn of RFeature
	(properties
		nsTop 47
		nsLeft 101
		nsBottom 76
		nsRight 144
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/barn'))
			(event claimed: 1)
			(Print 25 14) ; "You see the old stable in the distance to the north."
		)
	)
)

(instance House of RFeature
	(properties
		nsTop 63
		nsLeft 292
		nsBottom 93
		nsRight 319
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/cabin'))
			(event claimed: 1)
			(Print 25 15) ; "You notice the carriage house in the distance to the north."
		)
	)
)

