;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 114)
(include sci.sh)
(use Main)
(use room1)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	muggedByMarket 0
	muggedByBank 1
)

(local
	[local0 55]
	local55
)

(instance muggedByMarket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetMenu 769 112 0)
				(= local55 0)
				(gASong stop:)
				(gASoundEffect play: 20)
				(User canControl: 0)
				(willy
					init:
					posn: 31 166
					loop: 5
					setCycle: Fwd
					setMotion: MoveTo 64 141 self
				)
			)
			(1
				(willy setMotion: MoveTo 57 110 self)
			)
			(2
				(willy setLoop: 7 setCel: 1)
				(= seconds 3)
			)
			(3
				(willy
					setLoop: 3
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 17 109 self
				)
			)
			(4
				(willy setLoop: 5 setCycle: Fwd setMotion: MoveTo -10 72 self)
			)
			(5
				(willy dispose:)
				(proc0_1)
				(= global415 16)
				(User canControl: 1)
				(= global563 0)
				((ScriptID 215 0) init: 0) ; newspaper
				(newspaper dispose:)
				(proc0_1)
				(User canControl: 1)
				(= global479 register)
				(= global473 1)
				(if (== (global302 playing:) 29)
					(= global401 ((ScriptID 300) doit: global302)) ; WhereShouldIGo
				)
				(= local55 1)
				(client setScript: 0)
				(proc1_8)
				(SetMenu 769 112 1)
			)
		)
		(if local55
			(DisposeScript 114)
		)
	)
)

(instance muggedByBank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetMenu 769 112 0)
				(= local55 0)
				(gASong stop:)
				(gASoundEffect play: 20)
				(User canControl: 0)
				(willy
					init:
					posn: 17 119
					loop: 3
					setCycle: Fwd
					setMotion: MoveTo 5 125 self
				)
			)
			(1
				(willy setLoop: 4 setMotion: MoveTo 5 152 self)
			)
			(2
				(willy setLoop: 2 setMotion: MoveTo 10 152 self)
			)
			(3
				(willy setLoop: 6 setCel: 0)
				(= seconds 3)
			)
			(4
				(willy
					setLoop: 4
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 0 173 self
				)
			)
			(5
				(willy dispose:)
				(proc0_1)
				(= global415 16)
				(User canControl: 1)
				(= global563 0)
				((ScriptID 215 0) init: 0) ; newspaper
				(newspaper dispose:)
				(proc0_1)
				(User canControl: 1)
				(= global479 register)
				(= global473 1)
				(if (== (global302 playing:) 29)
					(= global401 ((ScriptID 300) doit: global302)) ; WhereShouldIGo
				)
				(= local55 1)
				(client setScript: 0)
				(proc1_8)
				(SetMenu 769 112 1)
			)
		)
		(if local55
			(DisposeScript 114)
		)
	)
)

(instance willy of Act
	(properties
		view 340
		priority 8
		ticksToDo 8
		moveSpeed 3
	)

	(method (init)
		(self setPri: priority setStep: 3 3)
		(super init:)
	)
)

(instance newspaper of Act
	(properties
		view 603
		priority 10
	)

	(method (init)
		(self posn: 159 130 setPri: priority)
		(super init:)
	)
)

