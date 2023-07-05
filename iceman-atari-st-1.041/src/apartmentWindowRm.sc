;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Interface)
(use tunisia)
(use LoadMany)
(use Grooper)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	apartmentWindowRm 0
)

(instance apartmentWindowRm of Rm
	(properties
		picture 85
		horizon 1
		south 84
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 81 487 787)
		(self setRegions: 310) ; tunisia
		(gIceGlobalSound number: 63 owner: gGame priority: 1 loop: -1 play:)
		(gAddToPics add: arch guardLeft doit:)
		(door init:)
		(guardRight init:)
		(if
			(and
				(== (tunisia vanWas:) 0)
				(== (tunisia bagTimer:) 10000)
				(not (& (tunisia flags:) $0002))
			)
			(LoadMany rsVIEW 184 185 485)
			(van init:)
			(vanDoor init: setScript: roomScript)
		else
			(self setScript: lookScript)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 85 0) ; "You see the entrance to the compound below. Somewhere inside is the Ambassador."
			)
			((Said 'look/door')
				(Print 85 1) ; "The door into the compound."
			)
			((Said 'look/guard')
				(Print 85 2) ; "The thought of tangling with those automatic weapons doesn't exactly thrill you."
			)
			((Said 'shoot/guard')
				(Print 85 3) ; "Though the glass? Better think of another plan."
			)
			((Said 'exit')
				(gIceGlobalSound fade:)
				(gCurRoom newRoom: 84) ; agentApartmentRm
			)
		)
	)
)

(instance lookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(= seconds 10)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 84) ; agentApartmentRm
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tunisia vanWas: 1)
				(van setLoop: 0 setStep: 8 8 setMotion: MoveTo 206 112)
				(= cycles 8)
			)
			(1
				(van setStep: 6 6)
				(= cycles 5)
			)
			(2
				(van setStep: 4 4)
				(= cycles 11)
			)
			(3
				(van setStep: 2 2 setMotion: MoveTo 206 112 self)
			)
			(4
				(van stopUpd:)
				(vanDoor setPri: (+ (van priority:) 1) setCycle: End self)
			)
			(5
				(vanDoor setLoop: 3 stopUpd:)
				((ScriptID 310 4) ; bagdad
					view: 184
					loop: 3
					setLoop: Grooper
					posn: (- (van x:) 8) (+ (van y:) 3)
					setPri: (+ (van priority:) 1)
					illegalBits: 0
					init:
				)
				(= cycles 5)
			)
			(6
				((ScriptID 310 4) heading: 270 cycleSpeed: 1) ; bagdad
				(((ScriptID 310 4) looper:) ; bagdad
					doit: ((ScriptID 310 4)) ((ScriptID 310 4) heading:) ; bagdad, bagdad
				)
				(= cycles 4)
			)
			(7
				((ScriptID 310 4) ; bagdad
					cycleSpeed: 0
					setCycle: Walk
					setStep: 3 2
					setMotion: MoveTo (- (van x:) 70) (+ (van y:) 3) self
				)
			)
			(8
				((ScriptID 310 4) ; bagdad
					setPri: -1
					setMotion:
						MoveTo
						((ScriptID 310 4) x:) ; bagdad
						(- ((ScriptID 310 4) y:) 20) ; bagdad
						self
				)
			)
			(9
				((ScriptID 310 4) ; bagdad
					setMotion:
						MoveTo
						(+ ((ScriptID 310 4) x:) 40) ; bagdad
						((ScriptID 310 4) y:) ; bagdad
						self
				)
			)
			(10
				((ScriptID 310 4) ; bagdad
					setMotion:
						MoveTo
						((ScriptID 310 4) x:) ; bagdad
						(- ((ScriptID 310 4) y:) 3) ; bagdad
				)
				(guardRight
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setMotion:
						MoveTo
						((ScriptID 310 4) x:) ; bagdad
						(+ ((ScriptID 310 4) y:) 7) ; bagdad
						self
				)
			)
			(11
				(guardRight
					setMotion: MoveTo (guardRight x:) (- (guardRight y:) 2) self
				)
			)
			(12
				(guardRight view: 485 loop: 0 cycleSpeed: 1 setCycle: End self)
			)
			(13
				(guardRight setCycle: Beg self)
			)
			(14
				(guardRight view: 787 cycleSpeed: 0 setCycle: Walk loop: 3)
				(door setCycle: End)
				((ScriptID 310 4) ; bagdad
					setMotion:
						MoveTo
						((ScriptID 310 4) x:) ; bagdad
						(- ((ScriptID 310 4) y:) 15) ; bagdad
						self
				)
			)
			(15
				(guardRight
					setMotion:
						MoveTo
						(guardRight x:)
						(- ((ScriptID 310 4) y:) 15) ; bagdad
						self
				)
				((ScriptID 310 4) dispose:) ; bagdad
			)
			(16
				(guardRight dispose:)
				(door setCycle: Beg self)
			)
			(17
				(User canInput: 1)
				(= seconds 5)
			)
			(18
				(HandsOn)
				(gCurRoom newRoom: 84) ; agentApartmentRm
			)
		)
	)
)

(instance arch of PV
	(properties
		y 86
		x 187
		view 81
		loop 1
		signal 16384
	)
)

(instance guardLeft of PV
	(properties
		y 95
		x 154
		view 487
		loop 2
		priority 6
		signal 16384
	)
)

(instance door of Prop
	(properties
		y 86
		x 155
		view 81
		signal 16385
	)
)

(instance van of Act
	(properties
		y 112
		x 329
		view 185
	)
)

(instance vanDoor of Prop
	(properties
		view 185
		loop 1
	)

	(method (doit)
		(super doit:)
		(self x: (- (van x:) 2) y: (- (van y:) 10))
	)
)

(instance guardRight of Act
	(properties
		y 95
		x 223
		view 787
		loop 2
	)
)

