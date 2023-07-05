;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm460 0
)

(local
	seenMsg
	msgVar
)

(instance rm460 of Rm
	(properties
		picture 460
		north 470
		west 400
	)

	(method (init)
		(Load rsVIEW (+ 715 (* 100 gEgoIsPatti)))
		(Load rsSCRIPT 969)
		(Load rsSOUND 460)
		(Load rsSOUND 461)
		(super init:)
		(gAddToPics add: atpDoor doit:)
		(if (not gEgoIsPatti)
			(aMan init:)
		)
		(aButton setPri: 9 init: stopUpd:)
		(aLightLeft setScript: (LightScript new:) init:)
		(aLightRight setScript: (LightScript new:) init:)
		(aDoor setCel: 0 ignoreActors: init: stopUpd:)
		(self setLocales: (+ 80 gEgoIsPatti) setScript: RoomScript)
		(NormalEgo)
		(if (== gPrevRoomNum 470)
			(HandsOff)
			(gEgo illegalBits: 0 posn: 70 133 loop: 2 init:)
			(aDoor setCel: 255)
			(aLightLeft setCel: 0)
			(RoomScript changeState: 13)
		else
			(gEgo posn: 1 164 init:)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'pull')
					(Said 'get,use/elevator')
					(Said 'board,open/elevator,door')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0002))
						(Print 460 0) ; "You couldn't reach the elevator's pushbutton from here."
					)
					(else
						(RoomScript changeState: 1)
					)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '/palm')
						(Print 460 1) ; "You always appreciate a fine ficus benjamina."
					)
					((Said '/carpet,carpet')
						(Print 460 2) ; "Isn't it wonderful? The linoleum industry has made such advances recently!"
					)
					((Said '/elevator,door,burn,burn')
						(Printf ; "The left elevator is currently on floor %d and the right elevator is on floor %d.%"
							460
							3
							(+ 1 (aLightLeft cel:))
							(+ 1 (aLightRight cel:))
							(+ 1 (aLightLeft cel:))
							(+ 1 (aLightRight cel:))
						)
					)
					(
						(and
							gEgoIsPatti
							(or
								(Said '/buffet,man,attendant,arnold')
								(Said '//buffet,man,attendant,arnold')
							)
						)
						(Print 460 4) ; "It's too late at night! Arnold has gone to bed until tomorrow morning's shift. Deal with him later, Patti. What he doesn't know, won't hurt him tonight!"
					)
					((Said '[/area,area,hotel]')
						(Printf ; "You are in the lobby of the casino hotel. %s There are two elevators here.%"
							460
							5
							(if gEgoIsPatti
								{}
							else
								{A clerk stands bored behind the counter.}
							)
							(if gEgoIsPatti
								{}
							else
								{Dort hinter im Empfang steht gelangweilt ein Angestellter.}
							)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(= gEgoState 15)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 94 139 self
				)
			)
			(2
				(gEgo
					cycleSpeed: 1
					view: (+ 715 (* 100 gEgoIsPatti))
					setLoop: 2
					setCycle: End self
				)
			)
			(3
				(aButton setCel: 1 stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(4
				(NormalEgo 3)
				(HandsOff)
				((aLightLeft script:) changeState: 3)
			)
			(5
				(= seconds 0)
			)
			(6
				(aLightLeft setScript: 0)
				(gSoundFX number: 460 loop: 1 play:)
				(aDoor setCycle: End self)
			)
			(7
				(aDoor stopUpd:)
				(= cycles 10)
			)
			(8
				(gEgo illegalBits: 0 setMotion: MoveTo 70 135 self)
			)
			(9
				(gEgo setMotion: MoveTo 72 128 self)
			)
			(10
				(gEgo setLoop: 2)
				(= cycles 14)
			)
			(11
				(gSoundFX number: 461 loop: 1 play:)
				(aDoor setCycle: Beg)
				(= seconds 3)
			)
			(12
				(gMusic fade:)
				(gCurRoom newRoom: 470)
			)
			(13
				(gEgo setMotion: MoveTo 70 154 self)
			)
			(14
				(gSoundFX number: 461 loop: 1 play:)
				(aDoor setCycle: Beg self)
			)
			(15
				(aDoor stopUpd:)
				(NormalEgo)
				(= gEgoState 0)
			)
		)
	)
)

(instance ManScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said '/casino,gamble,gambling')
					(Said '//casino,gamble,gambling')
				)
				(Print 460 6) ; "Hey, buddy! How do you get into that casino?"
				(ManScript changeState: 5 register: 102)
			)
			((Said 'talk,talk')
				(cond
					((& (gEgo onControl:) $0008)
						(Print 460 7) ; "He can't hear you from way back here."
					)
					((& (gEgo onControl:) $0004)
						(Print 460 8) ; "You attempt to catch the clerk's attention, "Excuse me.""
						(ManScript changeState: 5)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			(
				(and
					(not (Said 'look,look>'))
					(or
						(Said '/key,penthouse,area')
						(Said 'enroll')
						(Said '//key,penthouse,area')
					)
				)
				(Print 460 9) ; ""Excuse me, clerk. May I rent a room here?" you say."
				(ManScript changeState: 5 register: 101)
			)
			((Said 'look,look/arnold,man,buffet,attendant')
				(Print 460 10) ; "The desk clerk eagerly awaits your every request."
				(Print 460 11 #at -1 144) ; "(If you are a registered guest!)"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 8))
			)
			(1
				(aMan
					illegalBits: 0
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 257 162 self
				)
			)
			(2
				(= seconds (Random 4 8))
			)
			(3
				(aMan setMotion: MoveTo 233 140 self)
			)
			(4
				(self changeState: 0)
			)
			(5
				(aMan setMotion: MoveTo 249 155 self)
			)
			(6
				(aMan cycleSpeed: 4 setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(aMan setCel: 0)
				(= cycles 2)
			)
			(8
				(cond
					(register
						(switch register
							(101
								(Print 460 12) ; "Say, you're that Laffer guy that used to work around here," he replies. "Your money's no good here. Literally!"
							)
							(102
								(Print 460 13) ; "There's no need for you to go to the casino."
							)
						)
					)
					(gEgoIsPatti
						(switch msgVar
							(0
								(Print 460 14) ; "Hello, Patti."
							)
							(1
								(Print 460 15) ; "May I help you, Patti?"
							)
							(2
								(Print 460 16) ; "Hello, miss."
							)
							(3
								(Print 460 17) ; "Good evening, Patti. How may I help you?"
							)
						)
						(if (> (++ msgVar) 3)
							(= msgVar 0)
						)
					)
					(else
						(switch msgVar
							(0
								(Print 460 18) ; "I'm sorry sir, but this is a private hotel!"
							)
							(1
								(Print 460 19) ; "Yes? May I help you?"
							)
							(2
								(Print 460 20) ; "Would you like me to call security, bub?"
							)
							(3
								(Print 460 21) ; "How may I help you?"
							)
						)
						(if (> (++ msgVar) 3)
							(= msgVar 0)
						)
					)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance aButton of Prop
	(properties
		y 117
		x 102
		view 460
		loop 1
	)
)

(instance aLightLeft of Prop
	(properties
		x 69
	)
)

(instance aLightRight of Prop
	(properties
		x 135
	)
)

(instance aDoor of Prop
	(properties
		y 132
		x 69
		view 460
		priority 9
	)
)

(instance atpDoor of PV
	(properties
		y 132
		x 135
		view 460
		priority 9
	)
)

(instance aMan of Act
	(properties
		y 140
		x 233
		view 462
		loop 1
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 4 setCycle: Walk setScript: ManScript)
	)
)

(instance LightScript of Script
	(properties)

	(method (changeState newState &tmp destCel)
		(switch (= state newState)
			(0
				(client
					view: 460
					setCel: (Random 2 9)
					setLoop: 2
					cycleSpeed: (/ gMachineSpeed 2)
					setPri: 9
					y: 60
				)
				(= seconds 3)
			)
			(1
				(= seconds (Random 4 10))
			)
			(2
				(for
					((= destCel (client cel:)))
					(== (client cel:) destCel)
					((= destCel (Random 1 8)))
				)
				(client
					setCycle:
						CT
						destCel
						(if (> destCel (client cel:)) 1 else -1)
						self
				)
				(= state 0)
			)
			(3
				(if (== (client cel:) 0)
					(client setCel: 0)
					(= state 5)
				)
				(= seconds 3)
			)
			(4
				(client cycleSpeed: (/ gMachineSpeed 2) setCycle: CT 0 -1 self)
			)
			(5
				(= seconds 3)
			)
			(6
				(RoomScript changeState: 6)
			)
		)
	)
)

