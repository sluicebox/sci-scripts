;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n821)
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
						(Print 38 0) ; "Maybe you should enter the room."
					)
					((== (subMarine suitRoom:) 38)
						(Print 38 1) ; "There is some scuba gear and a button in the corner."
					)
					(else
						(Print 38 2) ; "You see a little red button in the corner."
					)
				)
			)
		)
	)

	(method (dispose)
		(if (>= gNewRoomNum 50) ; launchDiver
			(DisposeScript 806)
			(DisposeScript 817)
		)
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
				(self dispose:)
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
				(Print 38 3 #at 5 6) ; "As the hatch begins to fill with water you prepare yourself for the task ahead."
				(= cycles 1)
			)
			(4
				(water setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(Print 38 4 #at 2 102) ; "You wait as the hatch completely fills and the pressure equalizes to the water outside."
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
				(Print 38 5 #at 150 100) ; "You reach up and open the exit hatch which gives you access to the Mediterranean Sea."
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
				(gEgo setPri: -1 illegalBits: $8000 setStep: 3 4 put: 0 1) ; Envelope
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
				(EgoDead 918 0 0 38 6) ; "Well, now you know what this room is for!"
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
				(self dispose:)
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
					illegalBits: $8000
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
				(gEgo setMotion: MoveTo 140 187 self)
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
						(Print 38 7) ; "The door to the tank."
					)
					((Said 'open')
						(if (== local0 0)
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
						(Print 38 8) ; "The door to the outside."
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
						(Print 38 9) ; "It's just a ladder."
					)
					((Said 'climb')
						(gCurRoom setScript: climbDownLadder)
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
							(Print 38 10) ; "Some scuba gear."
						else
							(event claimed: 1)
							(proc0_40) ; "You don't see that."
						)
					)
					((GoToIfSaid self event self 10 0 38 11))
					((Said 'get,wear,(place<on)')
						(if (== (subMarine suitRoom:) 38)
							(Print 38 12) ; "You put on the scuba gear and press the button."
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
						(Print 38 13) ; "A button."
					)
					((GoToIfSaid self event self 10 0 38 11))
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

