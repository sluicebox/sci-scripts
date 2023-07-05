;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 272)
(include sci.sh)
(use Main)
(use Conversation)
(use Motion)
(use Actor)
(use System)

(public
	poemShelfScr 0
)

(local
	local0 = -1
	local1
)

(instance roomConv of Conversation
	(properties)
)

(instance turnPageScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 1 -1 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(= cycles 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance poemShelfScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gEgo loop:) 3)
					(gEgo loop: 3)
				)
				(= cycles 2)
			)
			(1
				(gEgo
					setSpeed: 6
					view: 279
					loop: 0
					cel: 0
					normal: 0
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(if (!= ((gInventory at: 47) owner:) 270) ; poem
					(= register 1)
					(roomConv
						add: -1 13 5 18 1 ; "Alexander looks at the love poem book again. He reads:"
						add: -1 13 5 18 2 ; "Thy hair, thy lips, thy beauteous face, and all thy studied female grace, have won for thee anon a place, within this broken breast."
						add: -1 13 5 18 3 ; "And another...."
						add: turnPageScr
						add: -1 13 5 18 4 ; "Upon the shore the lilies bend, untouched by worldly care. Where shadow they her earthly bed, Oh, that she were not there!"
						add: -1 13 5 18 5 ; "Alexander returns the love poem book to the shelf."
						init: self
					)
				else
					(roomConv
						add: -1 13 5 17 1 ; "Thinking of Cassima, Alexander decides to leaf through one of the volumes of love poetry. He reads:"
						add: -1 13 5 17 2 ; "Thy hair, thy lips, thy beauteous face, and all thy studied female grace, have won for thee anon a place, within this broken breast."
						add: -1 13 5 17 3 ; "Not bad. And another...."
						add: turnPageScr
						add: -1 13 5 17 4 ; "Upon the shore the lilies bend, untouched by worldly care. Where shadow they her earthly bed, Oh, that she were not there!"
						add: -1 13 5 17 5 ; "Yikes! And another...."
						add: turnPageScr
						add: -1 13 5 17 6 ; "What was it when I looked at you? What pow'r has chained me through and through? And binds my heart with links so tight, I cannot live without the sight of you?"
						add: turnPageScr
						add: -1 13 5 17 7 ; "What nameless thing has captured me? And made me powerless to flee? What thing is it without a name, that brings my mind e're back the same to thee?"
						add: turnPageScr
						add: -1 13 5 17 8 ; "The name of 'love' cannot apply. It's commonness does not descry, the haunted, hunted, painful cry that my heart makes for you.  That ere my soul eternal makes for you."
						add: -1 13 5 17 9 ; "Hmmm. A little close to home, that one."
						add: -1 13 5 17 10 ; "Alexander returns the love poem book to the shelf."
						init: self
					)
				)
			)
			(4
				(if (not register)
					((gInventory at: 47) owner: -1) ; poem
					(poem
						view: 279
						loop: 2
						cel: 0
						posn: 303 92
						init:
						setCycle: Fwd
						setMotion: MoveTo 281 120 poem
					)
				)
				(= cycles 2)
			)
			(5
				(gEgo loop: 0 cel: (gEgo lastCel:))
				(= cycles 2)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo reset: 3)
				(if (not register)
					(gGame givePoints: 1)
				)
				(= cycles 1)
			)
			(8
				(if (and (not local1) (not register))
					(-- state)
					(= ticks 12)
				else
					(= cycles 2)
				)
			)
			(9
				(UnLoad 128 279)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= register 0)
		(super dispose:)
	)
)

(instance takePoemScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame givePoints: 1)
				(gEgo
					setSpeed: 6
					view: 2701
					loop: 0
					cel: 0
					normal: 0
					setCycle: End self
				)
			)
			(1
				(poem dispose:)
				(gEgo get: 47) ; poem
				(= cycles 1)
			)
			(2
				(gEgo reset: 7)
				(= cycles 2)
			)
			(3
				(UnLoad 128 2701)
				(gMessager say: 6 5 0 1 self) ; "Alexander picks up the fallen page."
			)
			(4
				(gMessager say: 6 5 0 2 self) ; "It's the love poem he particularly liked. It must have fallen out of the poetry book."
			)
			(5
				(gMessager say: 6 5 0 3 self) ; "I see that old volume has lost another page. You may keep it if you like, sir. I have glued the stubborn thing back in place two times already!"
			)
			(6
				(gEgo setHeading: 180 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(gMessager say: 6 5 0 4 self) ; "I do rather like it. Thank you, merchant."
			)
			(9
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 272)
			)
		)
	)
)

(instance poem of Actor
	(properties
		x 281
		y 120
		noun 6
		approachX 292
		approachY 128
		view 270
		loop 2
		cel 1
		priority 1
		signal 18449
	)

	(method (cue)
		(if (not (++ local0))
			(self setCycle: End self)
		else
			(self view: 270 setLoop: 2 cel: 1)
			(= local1 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: takePoemScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)
)

