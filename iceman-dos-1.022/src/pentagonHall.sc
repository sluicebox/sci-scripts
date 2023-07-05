;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Interface)
(use n824)
(use n954)
(use LoadMany)
(use Follow)
(use Chase)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	pentagonHall 0
)

(local
	local0
)

(instance pentagonHall of Rm
	(properties
		picture 20
	)

	(method (init)
		(super init: &rest)
		(self setRegions: 302) ; washington
		(LoadMany rsVIEW 20 120)
		(gAddToPics add: chair ashTray button1 button2 doit:)
		(proc824_0)
		(door init:)
		(elevator1 init:)
		((= local0 (Clone elevator1)) signal: 16385 posn: 31 108 loop: 1 init:)
		(guard init: loop: 3 setScript: guardScript)
		(gEgo init:)
		(if (!= gPrevRoomNum 21) ; briefingRoom
			(gEgo z: 1000 setScript: leavingElevator)
		else
			(gIceGlobalSound number: (proc0_5 67) priority: 1 loop: -1 play:)
			(gEgo posn: 309 83 setScript: exitBriefScript)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 20 0) ; "The Pentagon has many conference rooms just as plain as this one."
			)
			((Said 'read/order')
				(if (== gPrevRoomNum 21) ; briefingRoom
					(Print 20 1) ; "These orders are not to be opened until you're aboard the plane to Hawaii."
				else
					(event claimed: 0)
				)
			)
		)
	)
)

(instance exitBriefScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door ignoreActors: 1 setCycle: End self)
			)
			(1
				(gEgo posn: 309 83 setMotion: MoveTo 309 93 self)
			)
			(2
				(door ignoreActors: 0 setCycle: Beg)
				(gEgo setMotion: MoveTo 309 109 self)
			)
			(3
				(gEgo ignoreActors: 0 illegalBits: -12288)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance elevator1 of Prop
	(properties
		y 96
		x 109
		view 20
		priority 5
		signal 16401
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/elevator]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 20 2) ; "A government-approved elevator."
					)
					((Said 'open')
						(Print 20 3) ; "Press the button to operate the elevator."
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
				(client setCycle: End self)
			)
			(2
				(gEgo illegalBits: -32768 setAvoider: Avoid)
				(if register
					(gEgo setMotion: MoveTo 3 105 self)
				else
					(gEgo setMotion: MoveTo 118 93 self)
				)
			)
			(3
				(gEgo setAvoider: 0 heading: 180)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 5)
			)
			(4
				(client setCycle: Beg self)
			)
			(5
				(gCurRoom newRoom: 19) ; pentagonLobby
			)
		)
	)
)

(instance guard of Act
	(properties
		y 162
		x 112
		view 120
	)

	(method (init)
		(super init:)
		(self setCycle: Walk)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((super handleEvent: event))
			((or (Said '/id,card>') (Said '//id,card>'))
				(cond
					((TurnIfSaid self event 'examine,check,look[<at]/*'))
					((Said 'examine,check,look[<at]')
						(cond
							(
								(and
									(gEgo has: 2) ; ID_Card
									(== ((gInventory at: 2) cel:) 1) ; ID_Card
								)
								(Print 20 4) ; "You look at the ID given to you by the guard. The name on the ID is "Major General Marcus J. Hood"."
							)
							((gEgo has: 2) ; ID_Card
								(Print 20 5) ; "The name on the ID card is "Commander John B. Westland""
							)
							((== ((gInventory at: 2) owner:) gCurRoomNum) ; ID_Card
								(Print 20 6) ; "You have given your ID to the guard."
							)
						)
					)
					((GoToIfSaid self event self 20 0 20 7))
					((Said 'show,give')
						(cond
							(
								(and
									(gEgo has: 2) ; ID_Card
									(== ((gInventory at: 2) cel:) 0) ; ID_Card
									(== gPrevRoomNum 21) ; briefingRoom
								)
								(Print 20 8) ; "I have already seen your ID, Sir."
							)
							(
								(and
									(gEgo has: 2) ; ID_Card
									(== ((gInventory at: 2) cel:) 0) ; ID_Card
								)
								(Print 20 9) ; "You hand your identification to the guard."
								(Print 20 10) ; "The guard looks at your ID then shoves it in his pocket and says, "Thank you very much, Commander, you may pass through.""
								(gEgo put: 2 gCurRoomNum) ; ID_Card
								(gGame changeScore: 1)
								(guard setMotion: MoveTo 112 166 guardScript)
								(HandsOn)
							)
							(
								(and
									(gEgo has: 2) ; ID_Card
									(== ((gInventory at: 2) cel:) 1) ; ID_Card
								)
								(Print 20 11) ; "The guard looks at the ID he gave you and realizes that he has given you the wrong one."
								(Print 20 12) ; "The guard exchanges your ID for the one you have."
								(Print 20 13) ; ""I'm very sorry, Sir," he says."
								((gInventory at: 2) cel: 0) ; ID_Card
								(gGame changeScore: 1)
							)
							((== ((gInventory at: 2) owner:) gCurRoomNum) ; ID_Card
								(Print 20 14) ; "You've already shown your ID."
							)
						)
					)
					(
						(or
							(Said 'get,get,return')
							(Said 'ask/guard')
							(Said 'ask/')
						)
						(cond
							(
								(and
									(gEgo has: 2) ; ID_Card
									(== ((gInventory at: 2) cel:) 0) ; ID_Card
								)
								(Print 20 15) ; "You have your ID."
							)
							(
								(and
									(gEgo has: 2) ; ID_Card
									(== ((gInventory at: 2) cel:) 1) ; ID_Card
								)
								(Print 20 16) ; "The guard looks at the ID he gave you and realizes that he has given you the wrong ID."
								(Print 20 12) ; "The guard exchanges your ID for the one you have."
								(Print 20 17) ; ""I'm very sorry, sir." he says."
								((gInventory at: 2) cel: 0) ; ID_Card
								(gGame changeScore: 1)
							)
							((and (not (gEgo has: 2)) (== gPrevRoomNum 21)) ; ID_Card, briefingRoom
								(Print 20 18) ; "The guard quickly fumbles through his pockets, pulls out an ID and hands it to you."
								((gInventory at: 2) cel: 1) ; ID_Card
								(gEgo get: 2) ; ID_Card
							)
							((not (gEgo has: 2)) ; ID_Card
								(Print 20 19) ; "The guard says, "I must keep your ID until after the briefing.""
							)
						)
					)
				)
			)
			((Said '[/guard,man]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 20 20) ; "You see a guard at his station."
					)
					((GoToIfSaid self event self 20 0 20 7))
					((Said 'talk')
						(cond
							(
								(and
									(!= gPrevRoomNum 21) ; briefingRoom
									(not (== ((gInventory at: 2) owner:) gCurRoomNum)) ; ID_Card
								)
								(if (Random 0 1)
									(Print 20 21) ; "Sir," the guard says, "I must see proper identification before you may pass."
								else
									(Print 20 22) ; ""Your ID please," the guard says."
								)
							)
							((== gPrevRoomNum 21) ; briefingRoom
								(Print 20 23) ; "Your car is waiting, Sir."
							)
							(else
								(Print 20 24) ; "I'm not to chat while on duty, Sir."
							)
						)
					)
				)
			)
		)
	)
)

(instance guardScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(guard setMotion: Chase gEgo 25 self)
			)
			(2
				(Print 20 25) ; "Sir! I must see proper identification before you may pass."
				(gEgo setMotion: Follow guard 15)
				(= cycles 5)
			)
			(3
				(HandsOn)
			)
			(4
				(guard setMotion: MoveTo 112 162 guardScript)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 86
		x 305
		view 20
		loop 4
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 20 26) ; "This is the door to the Briefing Room."
					)
					((GoToIfSaid self event self 20 0 20 7))
					((Said 'knock')
						(if (== gPrevRoomNum 21) ; briefingRoom
							(Print 20 27) ; "There is no response to your knock."
						else
							(Print 20 28) ; "Just open the door, you're expected."
						)
					)
					((Said 'open')
						(cond
							((== gPrevRoomNum 21) ; briefingRoom
								(Print 20 29) ; "The door is locked."
							)
							((gEgo has: 2) ; ID_Card
								(Print 20 30) ; "Sir," the guard says, "I must see your identification before you can enter the briefing room!"
								(guard loop: 0)
							)
							(else
								(self setScript: openDoorScript)
							)
						)
					)
				)
			)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door setPri: 2 ignoreActors: 1 setCycle: End self)
			)
			(1
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 310 86 self
				)
			)
			(2
				(gCurRoom newRoom: 21) ; briefingRoom
			)
		)
	)
)

(instance ashTray of PV
	(properties
		y 105
		x 91
		view 20
		loop 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/ashtray]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 20 31) ; "A government-approved ashtray."
					)
					((Said 'use')
						(Print 20 32) ; "You don't smoke."
					)
				)
			)
		)
	)
)

(instance chair of PV
	(properties
		y 108
		x 73
		view 20
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/chair]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 20 33) ; "A government-approved chair."
					)
					((Said 'sit')
						(Print 20 34) ; "You really don't have time to be sitting around."
					)
				)
			)
		)
	)
)

(instance button1 of PV
	(properties
		y 78
		x 99
		z 1
		view 20
		loop 2
		cel 1
		priority 6
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/button]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 20 35) ; "A government approved-elevator button."
					)
					((GoToIfSaid self event self 30 'push,press' 20 7))
					((Said 'push,press')
						(Print 20 36) ; "You hear the whine of the elevator as it approaches."
						(elevator1 setScript: elevatorScript 0 0)
					)
				)
			)
		)
	)
)

(instance button2 of PV
	(properties
		y 82
		x 43
		view 20
		loop 2
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/button]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 20 35) ; "A government approved-elevator button."
					)
					((GoToIfSaid self event self 30 'push,press' 20 7))
					((Said 'push,press')
						(Print 20 36) ; "You hear the whine of the elevator as it approaches."
						(local0 setScript: elevatorScript 0 1)
					)
				)
			)
		)
	)
)

(instance leavingElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 5)
			)
			(1
				(if (> (gEgo x:) 159)
					(gEgo posn: 118 94 0)
					(elevator1 setCel: 0 setCycle: End elevator1)
					(= register 1)
				else
					(gEgo posn: 13 104 0)
					(local0 setCel: 0 setCycle: End local0)
					(= register 0)
				)
				(= seconds 1)
			)
			(2
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 4)
						(+ (gEgo y:) 24)
						self
				)
			)
			(3
				(gEgo observeControl: 20480)
				(if register
					(elevator1 setCycle: Beg self)
				else
					(local0 setCycle: Beg self)
				)
			)
			(4
				(= seconds 1)
			)
			(5
				(guardScript cue:)
				(= cycles 10)
			)
			(6
				(if register
					(elevator1 stopUpd:)
				else
					(local0 stopUpd:)
				)
				(self dispose:)
			)
		)
	)
)

