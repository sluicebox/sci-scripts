;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room94 0
)

(local
	local0
	local1
	local2
)

(instance block1 of Blk
	(properties
		top 137
		left 58
		bottom 146
		right 152
	)
)

(instance block2 of Blk
	(properties
		top 136
		left 161
		bottom 146
		right 248
	)
)

(instance Room94 of Rm
	(properties
		picture 94
		style 16
	)

	(method (init)
		(Load rsVIEW 380)
		(Load rsVIEW 386)
		(Load rsVIEW 609)
		(horseSound init:)
		(gateSound init:)
		(super init:)
		(= gIndoors 1)
		(gEgo
			posn: 149 166
			view: 2
			setStep: 2 1
			observeBlocks: block1 block2
			init:
		)
		((= local1 (Prop new:))
			view: 609
			loop: 0
			cel: 0
			posn: 154 120
			setPri: 10
			init:
			stopUpd:
		)
		((= local2 (Prop new:))
			view: 609
			loop: 1
			cel: 0
			posn: 245 120
			setPri: 10
			init:
			stopUpd:
		)
		(if (== gUnicornState 99)
			((= local0 (Act new:))
				view: 380
				loop: 0
				cel: 0
				posn: 203 144
				illegalBits: 0
				cycleSpeed: 2
				setPri: 9
				init:
				setScript: uniStuff
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 80)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((!= (event type:) evSAID)
				(return 1)
			)
			((Said 'open/gate')
				(cond
					((!= (local2 cel:) 0)
						(Print 94 0) ; "It's already open."
					)
					((not (gEgo inRect: 150 144 163 158))
						(Print 800 1) ; "You're not close enough."
					)
					(else
						(gEgo ignoreControl: 16)
						(gateSound play:)
						(local2 ignoreActors: 1 setCycle: End gateScript)
						(if (== gUnicornState 99)
							(uniStuff changeState: 4)
						else
							(gEgo ignoreBlocks: block2)
						)
					)
				)
			)
			((Said 'close/gate')
				(cond
					((== (local2 cel:) 0)
						(Print 94 1) ; "It's already closed."
					)
					((not (gEgo inRect: 232 149 248 158))
						(Print 800 1) ; "You're not close enough."
					)
					(else
						(gEgo observeControl: 16)
						(gateSound play:)
						(local2 ignoreActors: 0 setCycle: Beg gateScript)
					)
				)
			)
			((Said 'talk[/unicorn,horse]')
				(if (or (!= gUnicornState 99) (not (gCast contains: local0)))
					(Print 94 2) ; "To whom?"
				else
					(Print 94 3) ; "The unicorn rolls back its eyes. It obviously doesn't trust you any more."
				)
			)
			((Said 'kiss')
				(if (== gUnicornState 99)
					(Print 94 4) ; "The unicorn doesn't want you to."
				else
					(Print 94 5) ; "What unicorn?"
				)
			)
			((Said '/unicorn,horse>')
				(cond
					((!= gUnicornState 99)
						(Print 94 5) ; "What unicorn?"
						(event claimed: 1)
					)
					((Said 'look/*')
						(if (== gUnicornState 99)
							(Print 94 6) ; "The unicorn looks at you with sadness."
							(Print 94 7) ; "It needs to be free..."
						else
							(Print 94 8) ; "The unicorn is not here."
						)
					)
					((Said 'pat')
						(Print 94 9) ; "You reach out to pet the unicorn's nose, but it won't let you."
					)
					((Said 'mount')
						(Print 94 10) ; "The unicorn doesn't trust you; it backs away."
					)
					((Said 'get,capture,guide')
						(Print 94 11) ; "You should free the unicorn."
					)
					((Said 'free,help')
						(Print 94 12) ; "Just open the gate and let the unicorn go!"
					)
					(else
						(Print 94 13) ; "That would not be a good idea."
						(event claimed: 1)
					)
				)
			)
			((Said 'look>')
				(cond
					((Said '/gate')
						(Print 94 14) ; "You see two stable gates."
					)
					((Said '/wall')
						(Print 94 15) ; "You see nothing of importance on the walls."
					)
					((Said '[<around][/room,barn]')
						(Print 94 16) ; "You have entered Lolotte's stable... and, it looks like an ordinary stable at that."
						(if (== gUnicornState 99)
							(Print 94 17) ; "The poor unicorn has been imprisoned here!!"
						)
					)
				)
			)
		)
	)
)

(instance gateScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(local2 stopUpd:)
				(= state 0)
			)
		)
	)
)

(instance uniStuff of Script
	(properties)

	(method (doit)
		(switch (Random 1 100)
			(1
				(horseSound play:)
			)
		)
		(super doit:)
	)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0 setCycle: End self)
			)
			(1
				(local0 setCycle: End self)
			)
			(2
				(= state -1)
				(if (not (local2 cel:))
					(= seconds (Random 2 5))
				)
			)
			(4
				(HandsOff)
				(= seconds 1)
			)
			(5
				(User canControl: 0)
				(gEgo loop: 0)
				(gGame changeScore: 4)
				(local0
					view: 386
					loop: 0
					cel: 255
					cycleSpeed: 0
					setCycle: End self
				)
				(Print 94 18 #at -1 15 #width 290) ; "As soon as you open the gate, the splendid wild unicorn impatiently leaves its hated prison. It quickly trots out the open stable door to freedom."
			)
			(6
				(local0
					setLoop: 2
					illegalBits: 0
					setCycle: Fwd
					setMotion: MoveTo 150 230 self
				)
			)
			(7
				(gEgo ignoreBlocks: block2)
				(HandsOn)
				(local0 dispose:)
				(= gUnicornState 999)
				(= gUnicornRoom 27)
			)
		)
	)
)

(instance gateSound of Sound
	(properties
		number 601
		priority 15
	)
)

(instance horseSound of Sound
	(properties
		number 603
		priority 15
	)
)

