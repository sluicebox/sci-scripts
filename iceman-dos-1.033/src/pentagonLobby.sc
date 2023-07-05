;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Interface)
(use washington)
(use n821)
(use n824)
(use n954)
(use LoadMany)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	pentagonLobby 0
)

(local
	local0
	local1 = 1
)

(instance pentagonLobby of Rm
	(properties
		picture 19
		south 18
	)

	(method (init)
		(super init: &rest)
		(self setRegions: 302) ; washington
		(LoadMany rsVIEW 19 19)
		(gAddToPics add: eagle stars button1 ((Clone button1) x: 81) doit:)
		(proc824_0)
		(elevator1 init:)
		(elevator2 init:)
		(blip1 init: setPri: 8 setCycle: Fwd)
		(blip2 init: setPri: 8 setCycle: Fwd)
		(guard init: setPri: 7)
		(if (== gPrevRoomNum 20) ; pentagonHall
			(gEgo init: z: 1000 setScript: leavingElevatorScript)
			(= local0 1)
		else
			(gEgo init: posn: 155 180 heading: 0)
			(DirLoop gEgo 0)
			(gEgo
				observeControl: 16400
				setMotion: MoveTo 155 146
				setScript: noAdmitScript
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 20) ; pentagonHall
			(Print 19 0) ; "Have a nice day, Sir."
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 19 1) ; "This is the main entrance to the Pentagon."
				(Print 19 2) ; "There is a guard standing at a desk and two elevators at the rear of the room."
			)
		)
	)
)

(instance noAdmitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(switch (Random 0 2)
					(0
						(Print 19 3) ; ""Halt," The guard commands."
						(Print 19 4) ; "The guard further explains, "I must check your identification.""
					)
					(1
						(Print 19 5) ; "Rather abruptly the guard says, "Hold it mister!""
						(Print 19 6) ; "No one passes without identifying himself."
					)
					(2
						(Print 19 7) ; ""Sir, you cannot use the elevators without checking with me,"    the guard says."
					)
				)
				(gEgo setMotion: 0 setAvoider: 0)
				(= cycles 1)
			)
			(2
				(HandsOff)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(3
				(HandsOn)
				(self init:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not local0)
				(or
					(< (gEgo distanceTo: elevator1) 40)
					(< (gEgo distanceTo: elevator2) 40)
				)
				(== state 0)
			)
			(self cue:)
		)
	)
)

(instance guard of View
	(properties
		y 121
		x 155
		z 1
		view 19
		loop 5
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'thank')
				(Print 19 8) ; "It's nothing"
			)
			((Said '[/guard,man]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 19 9) ; "You see a guard at his station."
					)
					((GoToIfSaid self event 156 128 'talk' 19 10))
					((Said 'talk')
						(cond
							((== gPrevRoomNum 20) ; pentagonHall
								(Print 19 11) ; "Have a nice day, Sir"
							)
							(local0
								(Print 19 12) ; "The guard looks at you and says, "My duties prohibit unnecessary conversation.""
							)
							((Random 0 1)
								(Print 19 13) ; "Sir," the guard says, "I must see proper identification before you may pass."
							)
							(else
								(Print 19 14) ; ""Your ID, please," The guard says."
							)
						)
					)
				)
			)
			((Said '/room<briefing')
				(if local0
					(Print 19 15) ; "The guard says.. "Just take the elevator, Sir""
				else
					(Print 19 16) ; ""Your ID, please," the guard says."
				)
			)
			((Said '/id,card[<id]>')
				(cond
					((GoToIfSaid self event 156 128 'show' 19 10))
					((Said 'show')
						(cond
							((not (gEgo has: 2)) ; ID_Card
								(EgoDead 918 0 0 19 17) ; "Your ID... don't leave home without it!"
							)
							(local0
								(Print 19 18) ; ""I have already seen your ID, Sir." the guard replies."
							)
							((gEgo has: 2) ; ID_Card
								(Print 19 19) ; "You hand your identification to the guard."
								(Print 19 20) ; "The guard looks at your ID, then returns it and says, "Thank you very much, Commander, you've been expected. Please pass through.""
								(= local0 1)
								(gGame changeScore: 1)
								(gEgo setScript: 0)
							)
						)
					)
				)
			)
		)
	)
)

(instance elevatorScript of Script
	(properties)

	(method (init)
		(= start 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 4)
			)
			(1
				(if register
					(elevator1 setCycle: End self)
				else
					(elevator2 setCycle: End self)
				)
			)
			(2
				(gEgo
					ignoreControl: 16400
					setAvoider: Avoid
					setMotion: MoveTo (if register 51 else 259) 86 self
				)
			)
			(3
				(gEgo setAvoider: 0 heading: 180)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 5)
			)
			(4
				(if register
					(elevator1 setCycle: Beg self)
				else
					(elevator2 setCycle: Beg self)
				)
			)
			(5
				(gCurRoom newRoom: 20) ; pentagonHall
			)
		)
	)
)

(instance elevator1 of Prop
	(properties
		y 91
		x 71
		view 19
		priority 10
		signal 16385
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door,elevator]>')
				(cond
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look')
						(Print 19 21) ; "A government approved-elevator door."
					)
					((Said 'open')
						(Print 19 22) ; "Press the button to operate the elevator."
					)
				)
			)
		)
	)
)

(instance elevator2 of Prop
	(properties
		y 91
		x 239
		view 19
		loop 1
		priority 10
		signal 16385
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door,elevator]>')
				(cond
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look')
						(Print 19 21) ; "A government approved-elevator door."
					)
					((Said 'open')
						(Print 19 22) ; "Press the button to operate the elevator."
					)
				)
			)
		)
	)
)

(instance button1 of PV
	(properties
		y 94
		x 224
		z 21
		view 19
		loop 2
		cel 2
		priority 6
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/button]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 19 23) ; "A government approved-elevator button."
					)
					((and (not local0) (Said 'push,press'))
						(Print 19 7) ; ""Sir, you cannot use the elevators without checking with me,"    the guard says."
					)
					((GoToIfSaid self event self 20 'push,press' 19 10))
					((Said 'push,press')
						(if (washington beenBriefed:)
							(Print 19 24) ; "Nothing happens as you push the button. You suspect that the guard has control over the elevators."
							(Print 19 25) ; "The guard says, "Sorry, Sir, my orders state that you are only allowed access to the elevators for your briefing.""
						else
							(if local1
								(= local1 0)
								(Print 19 26) ; "You hear the whine of the elevator as it approaches."
							)
							(gCurRoom
								setScript: elevatorScript 0 (!= self button1)
							)
						)
					)
				)
			)
		)
	)
)

(instance eagle of PV
	(properties
		y 74
		x 155
		view 19
		loop 2
		priority 6
	)
)

(instance stars of PV
	(properties
		y 35
		x 154
		view 19
		loop 2
		cel 1
		priority 6
	)
)

(instance blip1 of Prop
	(properties
		y 97
		x 101
		view 19
		loop 3
	)
)

(instance blip2 of Prop
	(properties
		y 98
		x 208
		view 19
		loop 4
	)
)

(instance leavingElevatorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 5)
			)
			(1
				(if (> (gEgo x:) 60)
					(gEgo posn: 264 84 0)
					(elevator2 setCel: 0 setCycle: End elevator2)
					(= register 1)
				else
					(gEgo posn: 48 84 0)
					(elevator1 setCel: 0 setCycle: End elevator1)
					(= register 0)
				)
				(= seconds 1)
			)
			(2
				(gEgo setMotion: MoveTo (gEgo x:) 145 self)
			)
			(3
				(gEgo observeControl: 16400)
				(if register
					(elevator2 setCycle: Beg self)
				else
					(elevator1 setCycle: Beg self)
				)
			)
			(4
				(if register
					(elevator2 stopUpd:)
				else
					(elevator1 stopUpd:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

