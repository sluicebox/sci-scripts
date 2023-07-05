;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use Inset)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	lookDashScript 0
)

(instance lookDashScript of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 430)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: -1 setMotion: PolyPath 123 185 self)
			)
			(1
				(gEgo
					view: 7
					x: 109
					y: 185
					setLoop: 2
					setCel: 8
					setCycle: Beg self
				)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 0 3 4 5)
				(gCurRoom setInset: dashInset self)
			)
			(3
				(HandsOff)
				(gEgo setCycle: End self)
			)
			(4
				(NormalEgo)
				(gEgo x: 123 y: 185 loop: 3)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bookInsetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bookInset init:)
				(= ticks 60)
			)
			(1
				(gMessager say: 2 1 0 0 self) ; "Flipping through the book, you see many notes and entries. You decide to wait and examine it more thoroughly after it's been booked into evidence. You put it back in the glove box."
			)
			(2
				(bookInset dispose:)
			)
		)
	)
)

(instance licenseInsetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= (gLongSong2 number:) 434)
					(gLongSong pause: 1)
					(gLongSong2 number: 434 loop: 1 play: self)
				else
					(= cycles 2)
				)
			)
			(1
				(gLongSong pause: 0)
				(HandsOn)
				(gTheIconBar disable: 0 3 4 5)
				(licenseInset init:)
				(= ticks 10)
			)
			(2
				(HandsOff)
				(gMessager say: 11 1 3 0 self) ; "PQ176203 Marvin Hoffman 331 W 104th St. Chicago, IL"
			)
			(3
				(gMessager say: 13 1 3 0 self) ; "SM823491 Leroy Pierson 11134 Beach St. Newport, CA"
			)
			(4
				(gMessager say: 12 0 4 0 self) ; "You put the licenses back in the glove box, to be impounded with the car."
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 0 3 4 5)
				(licenseInset dispose:)
			)
		)
	)
)

(instance dashInset of Inset
	(properties
		view 370
		x 19
		y 58
		disposeNotOnMe 1
	)

	(method (init)
		(SetScore 160 5)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(
						(InRect
							(+ x 35)
							(+ y 29)
							(+ x 54)
							(+ y 42)
							gMouseX
							gMouseY
						)
						(gMessager say: 4 1) ; "A button is concealed inside the glove box."
					)
					(
						(InRect
							(+ x 55)
							(+ y 35)
							(+ x 83)
							(+ y 58)
							gMouseX
							gMouseY
						)
						(self setScript: bookInsetScript)
					)
					(
						(InRect
							(+ x 67)
							(+ y 60)
							(+ x 105)
							(+ y 77)
							gMouseX
							gMouseY
						)
						(self setScript: licenseInsetScript)
					)
					(else
						(gMessager say: 16 1 6) ; "There are no keys in the ignition. The suspect evidently hotwired the car."
					)
				)
			)
			(4 ; Do
				(cond
					(
						(InRect
							(+ x 35)
							(+ y 29)
							(+ x 54)
							(+ y 42)
							gMouseX
							gMouseY
						)
						(= global244 1)
						(gLongSong2 number: 902 loop: 1 play:)
						(gMessager say: 4 4) ; "You press the button, and hear a muffled thud from behind you. Your heart leaps. You turn around, only to discover that you've released the trunk latch. Whew!"
					)
					(
						(InRect
							(+ x 55)
							(+ y 35)
							(+ x 83)
							(+ y 58)
							gMouseX
							gMouseY
						)
						(self setScript: bookInsetScript)
					)
					(
						(InRect
							(+ x 67)
							(+ y 60)
							(+ x 105)
							(+ y 77)
							gMouseX
							gMouseY
						)
						(self setScript: licenseInsetScript)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bookInset of Prop
	(properties
		x 69
		y 78
		view 370
		loop 1
		priority 15
		signal 16
	)

	(method (handleEvent event)
		(if
			(and
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not script)
				(not (event modifiers:))
			)
			(bookInsetScript cue:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance licenseInset of Prop
	(properties
		x 99
		y 118
		view 370
		loop 2
		priority 15
		signal 16
	)

	(method (handleEvent event)
		(if
			(and
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not script)
				(not (event modifiers:))
			)
			(bookInsetScript cue:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

