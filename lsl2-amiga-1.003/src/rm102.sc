;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 102)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm102 0
)

(local
	work
	doorIsOpen
	aProducer
)

(instance rm102 of Rm
	(properties
		picture 102
	)

	(method (init)
		(Load rsVIEW 202)
		(Load rsVIEW 206)
		(Load rsVIEW 217)
		(super init:)
		(gAddToPics add: aView1 aView2 doit:)
		(aTVwest setCycle: Fwd isExtra: 1 init:)
		(aTVeast setCycle: Fwd isExtra: 1 init:)
		(self setScript: rm102Script)
		(NormalEgo)
		(gEgo observeControl: 16384 8192)
		(aDoorWest init:)
		(aDoorEast init:)
		(if (== gPrevRoomNum 103)
			(aDoorWest setCel: 255)
			(gEgo posn: 67 122 observeControl: 8192 ignoreActors:)
			(rm102Script changeState: 12)
		else
			(gEgo posn: 163 153)
			(rm102Script changeState: 1)
		)
		(gEgo init:)
	)
)

(instance rm102Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== gCurrentStatus 1009) (or (== state 20) (== state 1)))
			(self cue:)
		)
		(if (== doorIsOpen 8192)
			(gEgo ignoreControl: 8192)
		)
		(if (== doorIsOpen 16384)
			(gEgo ignoreControl: 16384)
		)
		(if (& (gEgo onControl:) $0004)
			(gCurRoom newRoom: 103)
		)
		(if (& (gEgo onControl:) $0020)
			(gCurRoom newRoom: 104)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'open/door')
			(if doorIsOpen
				(ItIs) ; "It is."
			else
				(Print 102 0) ; "You can't. They are all locked. And, there's no key!"
				(Print 102 1) ; "Just be patient. Have a seat. Kick back. Relax."
			)
		)
		(if (Said 'look>')
			(if (Said '/art,brick')
				(Print 102 2) ; "That Skirvin guy sure can draw horses!"
			)
			(if (Said '/door')
				(if doorIsOpen
					(Print 102 3) ; "There's one door that's open."
					(Print 102 4 #at -1 130) ; "(Why aren't you walking through it?)"
				else
					(Print 102 5) ; "There are doors to the east, west and south, which are all locked. Tight. And, there's no key."
					(Print 102 6 #at -1 130) ; "(Looks like you're trapped in here until someone comes to your rescue, Larry!)"
				)
			)
			(if (Said '/krod,woman,computer')
				(Print 102 7) ; "One monitor shows a lovely young lady; the other, just static."
			)
			(if (Said '/barstool')
				(Print 102 8) ; "It looks comfortable."
			)
			(if (Said '[/airport,krod,lobby,building]')
				(Print 102 9) ; "You wonder why the receptionist called this a green room, when there's no green in it at all! There are two television monitors, a bench, some art posters, a lovely modern painting and three doors."
			)
		)
		(if (Said 'bath')
			(cond
				((== gCurrentStatus 1009)
					(YouAre) ; "You are."
				)
				((not (gEgo inRect: 101 90 255 99))
					(NotClose) ; "You're not close enough."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(else
					(if (not gScoredRm102Sit)
						(= gScoredRm102Sit 1)
						(gGame changeScore: 1)
					)
					(Ok) ; "Ok."
					(gEgo setScript: sittingScript)
					(sittingScript changeState: 0)
				)
			)
		)
		(if (or (Said 'new,(new<up),(get<up)') (Said 'disembark[/barstool]'))
			(cond
				((== gCurrentStatus 0)
					(YouAre) ; "You are."
				)
				((!= gCurrentStatus 1009)
					(NotNow) ; "Not now!"
				)
				(else
					(Ok) ; "Ok."
					(gEgo setScript: sittingScript)
					(sittingScript changeState: 5)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOn)
				(gEgo observeControl: 16384 8192)
			)
			(2
				(= seconds (Random 10 30))
			)
			(3
				(if (!= gCurrentStatus 1009)
					(-- state)
					(= seconds 3)
				else
					(HandsOff)
					(= doorIsOpen 16384)
					(aDoorWest setCycle: End self)
				)
			)
			(4
				((= aProducer (Act new:))
					view: 206
					loop: 0
					illegalBits: 0
					ignoreActors: 0
					setCycle: Walk
					posn: 60 119
					init:
					setMotion: MoveTo 80 120 self
				)
			)
			(5
				(aProducer
					setLoop: 2
					cel: 0
					setCycle: End
					setMotion: MoveTo 97 120 self
				)
			)
			(6
				(aProducer setLoop: 3 cel: 0 setCycle: End self)
			)
			(7
				(aProducer setLoop: 4 setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(Print 102 10 #at -1 20) ; "Oh, thay, you! Poo Poo," cries the man, "You're late! Where have you been, you thilly little dickenth?! We've justh been worried thick about you."
				(= seconds 2)
			)
			(9
				(Print 102 11 #at -1 20) ; "Before you can answer him, he tells you: "Hurry up, Honey, you're ON!!""
				(aProducer setLoop: 5 cycleSpeed: 2 setCycle: End self)
			)
			(10
				(User canInput: 1)
				(if (!= gCurrentStatus 1009)
					(User canControl: 1)
				)
				(aProducer
					setLoop: 1
					setCycle: Walk
					cycleSpeed: 0
					ignoreActors: 1
					setMotion: MoveTo 60 120
				)
			)
			(11
				(aProducer dispose:)
			)
			(12
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 120 123 self)
			)
			(13
				((= aProducer (Act new:))
					view: 206
					loop: 0
					setCycle: Walk
					illegalBits: 0
					ignoreActors:
					posn: 60 119
					init:
					setMotion: MoveTo 80 120 self
				)
				(gEgo illegalBits: $8000 observeControl: 16384 8192 loop: 1)
			)
			(14
				(aProducer
					setLoop: 2
					cel: 0
					setCycle: End
					setMotion: MoveTo 97 120 self
				)
			)
			(15
				(aProducer setLoop: 3 cel: 0 setCycle: End self)
			)
			(16
				(aProducer setLoop: 4 cycleSpeed: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(17
				(Print 102 12 #at -1 15 #width 280) ; "The assistant producer looks at you with disdain, "Well, Laffer, I musth admit none of usth in the control room exthpected you to win. I'm thure you're not proud of the outcome, but, ruleths are ruleths I thuppoth.""
				(Print 102 13 #at -1 20) ; "Here is your cruithe thip ticket. All of usth here at 'The Dating Connecthion' wisth you the besth of luck."
				(Print 102 14 #at -1 20) ; "You'll need it!"
				(gEgo get: 3) ; Cruise_Ticket
				(gGame changeScore: 6)
				(aProducer setLoop: 5 setCycle: End self)
			)
			(18
				(aProducer
					setLoop: 1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 36 120 self
				)
			)
			(19
				(aProducer posn: 264 121)
				(aDoorWest setCycle: Beg self)
			)
			(20
				(HandsOn)
				(aDoorWest stopUpd:)
				(= gCurrentStatus 0)
			)
			(21
				(= seconds (Random 11 33))
			)
			(22
				(if (!= gCurrentStatus 1009)
					(-- state)
					(= seconds 3)
				else
					(HandsOff)
					(= doorIsOpen 8192)
					(aDoorEast setCycle: End self)
				)
			)
			(23
				(aProducer view: 217 setCycle: Walk setMotion: MoveTo 219 122 self)
			)
			(24
				(aProducer loop: (+ (aProducer loop:) 2) setCycle: Fwd)
				(= seconds 3)
			)
			(25
				(Print 102 15) ; "Hey, you!" cries the woman, "Where have you been? We've been looking all over for you."
				(Print 102 16 #at -1 20) ; ""I just won 'The Dating Connection,'" you reply."
				(Print 102 17) ; "Big deal. You were supposed to wait here. Now hurry and follow me!"
				(aProducer loop: 0 setMotion: MoveTo 264 122 self)
			)
			(26
				(User canInput: 1)
				(if (== gCurrentStatus 0)
					(User canControl: 1)
				)
				(aProducer dispose:)
				(Print 102 18 #at -1 130) ; "(Oh no, Larry. Here we go again!)"
			)
		)
	)
)

(instance sittingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds (= cycles 0))
				(cond
					((< (gEgo x:) 123)
						(gEgo setMotion: MoveTo 123 (gEgo y:) self)
					)
					((> (gEgo x:) 200)
						(gEgo setMotion: MoveTo 200 (gEgo y:) self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 92 self)
			)
			(2
				(gEgo
					view: 101
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gEgo setCel: setMotion: 0 stopUpd:)
				(= gCurrentStatus 1009)
				(User canInput: 1)
				(= seconds (Random 2 6))
			)
			(4
				(gEgo setLoop: (Random 1 2))
				(if (== (gEgo cel:) 0)
					(gEgo setCycle: End)
				else
					(gEgo setCycle: Beg)
				)
				(-- state)
				(= seconds (Random 2 6))
			)
			(5
				(HandsOff)
				(= seconds (= cycles 0))
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self setMotion: 0)
			)
			(6
				(NormalEgo 2)
				(gEgo observeControl: 16384 8192)
			)
		)
	)
)

(instance aView1 of PV
	(properties
		y 126
		x 59
		view 202
		loop 4
		priority 9
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 128
		x 262
		view 202
		loop 4
		cel 1
		priority 9
		signal 16384
	)
)

(instance aTVwest of Prop
	(properties
		y 94
		x 96
		view 202
		loop 2
		priority 4
	)
)

(instance aTVeast of Prop
	(properties
		y 95
		x 228
		view 202
		loop 3
		cel 1
		priority 4
	)
)

(instance aDoorWest of Prop
	(properties
		y 115
		x 83
		view 202
		priority 4
	)
)

(instance aDoorEast of Prop
	(properties
		y 116
		x 250
		view 202
		loop 1
		priority 4
	)
)

