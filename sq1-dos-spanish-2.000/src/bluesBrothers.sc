;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Interface)
(use Osc)
(use Motion)
(use Actor)
(use System)

(public
	bluesBrothers 0
	jakeBlue 1
	elwoodBlue 2
)

(instance bluesBrothers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: register cel: 0 setCycle: Fwd)
				(= cycles (Random 45 150))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setLoop: (+ register 1) cel: 0 setCycle: End self)
			)
			(3
				(if (not register)
					(gLongSong send: 5 78 0)
				else
					(gLongSong send: 4 78 0)
				)
				(client
					setLoop: (+ register 2)
					cel: 0
					setCycle: Osc (Random 2 15) self
				)
			)
			(4
				(if (not register)
					(gLongSong send: 5 78 1)
				else
					(gLongSong send: 4 78 1)
				)
				(= state -1)
				(client
					setLoop: (+ register 1)
					cel: (if (not register) 2 else 3)
					setCycle: Beg self
				)
			)
		)
	)
)

(instance jakeBlue of Prop
	(properties
		x 136
		y 95
		description {humanoids}
		lookStr {There are a couple of non-galactic looking humanoids cranking out some unfamiliar sounding tunes. They seem interested solely in the music they are performing.}
		view 434
		priority 6
		signal 18448
		cycleSpeed 4
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 300 0) ; "You wish you could sing like that."
			)
			(11 ; Taste
				(Print 300 1) ; "They may look like a couple of geeks, but they have good taste in music."
			)
			(12 ; Smell
				(Print 300 2) ; "Don't they ever wash those suits."
			)
			(5 ; Talk
				(Print 300 3) ; "They don't have the time to talk to you, they're on a mission from God."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 300 4) ; "Unlike any band you've ever seen, these guys aren't interested in tips."
					)
					(0 ; Cartridge
						(Print 300 5) ; "he isn't interested in the data cartridge."
					)
					(15 ; Widget
						(Print 300 6) ; "He doesn't seem interested in the widget."
					)
					(2 ; Gadget
						(Print 300 7) ; "The lyrics of this song are gibberish, even translated."
					)
					(4 ; Knife
						(Print 300 8) ; "You could wind up outside with a microphone stand wrapped around your neck."
					)
					(5 ; Dehydrated_Water
						(Print 300 9) ; "They look like they get plenty to drink."
					)
					(11 ; Jetpack
						(Print 300 10) ; "You decide not to offer him your jet pack - he's already flying."
					)
					(17 ; Bar_Coupon
						(Print 300 11) ; "There's no discount on the band. Sorry."
					)
					(18 ; Droids-B-Us_coupon
						(Print 300 11) ; "There's no discount on the band. Sorry."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance elwoodBlue of Prop
	(properties
		x 163
		y 90
		description {humanoids}
		lookStr {There are a couple of non-galactic looking humanoids cranking out some unfamiliar sounding tunes. They seem interested solely in the music they are performing.}
		view 434
		loop 3
		priority 6
		signal 18448
		cycleSpeed 4
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 300 12) ; "You don't want to disturb them."
			)
			(11 ; Taste
				(Print 300 1) ; "They may look like a couple of geeks, but they have good taste in music."
			)
			(12 ; Smell
				(Print 300 2) ; "Don't they ever wash those suits."
			)
			(5 ; Talk
				(Print 300 13) ; "They don't have the time to talk to you."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 300 4) ; "Unlike any band you've ever seen, these guys aren't interested in tips."
					)
					(0 ; Cartridge
						(Print 300 5) ; "he isn't interested in the data cartridge."
					)
					(15 ; Widget
						(Print 300 6) ; "He doesn't seem interested in the widget."
					)
					(2 ; Gadget
						(Print 300 7) ; "The lyrics of this song are gibberish, even translated."
					)
					(4 ; Knife
						(Print 300 8) ; "You could wind up outside with a microphone stand wrapped around your neck."
					)
					(5 ; Dehydrated_Water
						(Print 300 9) ; "They look like they get plenty to drink."
					)
					(11 ; Jetpack
						(Print 300 10) ; "You decide not to offer him your jet pack - he's already flying."
					)
					(17 ; Bar_Coupon
						(Print 300 11) ; "There's no discount on the band. Sorry."
					)
					(18 ; Droids-B-Us_coupon
						(Print 300 11) ; "There's no discount on the band. Sorry."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

