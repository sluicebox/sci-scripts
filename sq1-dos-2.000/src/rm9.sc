;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm9 0
)

(instance rm9 of SQRoom
	(properties
		lookStr {This place looks like a monument to Soviet computer hardware miniaturization. At one time, it served as a development facility for the Star Generator. But that was in the early phase of the project.}
		picture 9
		east 10
		west 8
	)

	(method (init)
		(Load rsVIEW 6 109 411 410)
		(= global166 2)
		(= style (if (== gPrevRoomNum west) 12 else 11))
		(star setCycle: Fwd init:)
		(if (> global172 30)
			(tv1 init:)
			(tv2 init:)
		)
		(if (>= (gGame detailLevel:) (tv1 detailLevel:))
			(tv1 setScript: tv1Script)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 72 298 67 268 65 207 50 170 46 133 46 133 62 58 77 113 101 114 109 106 117 73 128 44 129 0 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 186 319 186 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 277 153 205 177 135 149 206 125
					yourself:
				)
		)
		((ScriptID 700 0) ; arcadaRegion
			sarienEntryDir: 1
			s1startY: 140
			s2startY: 158
			s1gotoX: 24
			s1gotoY: 136
			s2gotoX: 33
			s2gotoY: 159
			safeCode: egoSafe
			checkFootCode: timeToHearGuards
			checkEntryCode: callTheGuards
		)
		(self setRegions: 700) ; arcadaRegion
		(gEgo init:)
		(super init:)
		(gFeatures
			add: joystick mouse screen wires keyboard cords
			eachElementDo: #init
		)
		(if (and (== gPrevRoomNum 10) (IsFlag 16))
			(sarien1 init: setScript: fireUponEgo)
			(sarien2 init:)
			(if (>= (gEgo y:) 140)
				(sarien2 posn: 142 166)
				(sarien1 posn: 103 181)
			)
		else
			(HandsOn)
		)
	)
)

(instance fireUponEgo of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(or
				(and
					(== (sarien1 view:) 411)
					(or
						(and (<= (sarien1 loop:) 3) (== (sarien1 cel:) 5))
						(and (> (sarien1 loop:) 3) (== (sarien1 cel:) 6))
					)
				)
				(and
					(== (sarien1 view:) 412)
					(or
						(and (<= (sarien1 loop:) 1) (== (sarien1 cel:) 4))
						(and (> (sarien1 loop:) 1) (== (sarien1 cel:) 5))
					)
				)
				(and (== (sarien1 view:) 413) (== (sarien1 cel:) 5))
			)
			(gSoundEffects number: 312 loop: 1 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 288 (gEgo y:) self)
			)
			(1
				(sarien1 setCycle: End self)
			)
			(2
				(sarien1 setCycle: Beg)
				(if (IsFlag 16)
					(gEgo view: 48 setLoop: 0 cel: 0 setCycle: End self)
				else
					(gEgo
						view: 6
						setLoop: (if (>= (gEgo y:) 140) 3 else 2)
						cel: 0
						setCycle: End self
					)
				)
			)
			(3
				(EgoDead 940 (if (IsFlag 16) 1 else 0) 0 9 0) ; "Hey, flow through ventilation! You'd best avoid those guys in the future."
				(self dispose:)
			)
		)
	)
)

(instance tv1Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(tv1 setCycle: Beg self)
			)
			(1
				(= seconds (Random 2 5))
			)
			(2
				(tv1 setCycle: Fwd)
				(= seconds (Random 1 4))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance egoSafe of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 0)
		(if (or (& (gEgo onControl:) $0004) (& (gEgo onControl:) $0002))
			(= temp0 1)
		)
		(return temp0)
	)
)

(instance timeToHearGuards of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 0)
		(if (and (!= gPrevRoomNum 10) (> (gEgo x:) 80))
			(= temp0 1)
		)
		(return temp0)
	)
)

(instance callTheGuards of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 0)
		(if (and (!= gPrevRoomNum 10) (> (gEgo x:) 160))
			(= temp0 1)
		)
		(return temp0)
	)
)

(instance tv2 of View
	(properties
		x 248
		y 103
		sightAngle 45
		view 109
		loop 2
		priority 14
		signal 24592
	)

	(method (doit)
		(self cel: (tv1 cel:) forceUpd:)
		(super doit:)
	)

	(method (doVerb theVerb)
		(tv1 doVerb: theVerb &rest)
	)
)

(instance star of Prop
	(properties
		x 10
		y 20
		description {star}
		sightAngle 45
		lookStr {A relatively nearby star blazes.}
		view 109
		loop 3
		signal 24592
		cycleSpeed 12
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 9 1) ; "It's a star. You don't do anything with it. If you get close enough though, it will do anything it wants to you."
			)
			(5 ; Talk
				(Print 9 2) ; "If you want to talk to a star, call the Elvis hotline."
			)
			(12 ; Smell
				(Print 9 3) ; "It's a TV picture, remember?"
			)
			(11 ; Taste
				(Print 9 3) ; "It's a TV picture, remember?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tv1 of Prop
	(properties
		x 157
		y 95
		description {tv1}
		sightAngle 45
		lookStr {On the screen is some green dude you've never seen the likes of. He seems to be talking, but the audio is out in this area of the ship.}
		view 109
		loop 1
		priority 14
		signal 24592
		cycleSpeed 8
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 9 4) ; "It's tuned as well as it will come in. Let's face it, that guy's gonna be ugly no matter how you adjust it."
			)
			(5 ; Talk
				(Print 9 5) ; "Alas, it is speechless."
			)
			(12 ; Smell
				(Print 9 3) ; "It's a TV picture, remember?"
			)
			(11 ; Taste
				(Print 9 3) ; "It's a TV picture, remember?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sarien1 of Prop
	(properties
		x 99
		y 124
		description {sarien}
		lookStr {These guys look scary. But then, don't most other beings packing weapons?}
		view 411
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 9 6) ; "Sure. Just go up and do any old thing you want. They look friendly."
			)
			(5 ; Talk
				(Print 9 7) ; "These guys carry weapons. How wise do you think that is?"
			)
			(12 ; Smell
				(Print 9 8) ; "You'd need to be closer for that."
			)
			(11 ; Taste
				(Print 9 8) ; "You'd need to be closer for that."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sarien2 of Prop
	(properties
		x 135
		y 113
		description {sarien}
		lookStr {These guys look scary. But then, don't most other beings packing weapons?}
		view 410
		loop 1
		cel 2
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(sarien1 doVerb: theVerb &rest)
	)
)

(instance joystick of Feature
	(properties
		description {joystick}
		onMeCheck 10
		lookStr {The architects must have been low on oxygen when they came up with the design scheme for this compartment. It's a giant tribute to an ancient, but still functional, control device.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 9 9) ; "Sorry. It's just an incredible facsimile and not capable of functioning!"
			)
			(5 ; Talk
				(Print 9 10) ; "Boy, you're lonely!"
			)
			(12 ; Smell
				(Print 9 11) ; "I don't think it's a good idea to be doing that kind of thing to someone else's joystick."
			)
			(11 ; Taste
				(Print 9 12) ; "Hey, you don't know were this thing has been!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mouse of Feature
	(properties
		description {mouse}
		onMeCheck 20
		lookStr {Here, we have a nice chunk of floor space dedicated to a cursor control device named after an annoying rodent. What were they thinking?}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 9 13) ; "Though you've been known to have a fondness for manipulating small rodents, this one is obviously decorative (at least in someone's mind)."
			)
			(5 ; Talk
				(Print 9 14) ; "I'm glad, for your sake, that no can see what you're trying to do."
			)
			(12 ; Smell
				(Print 9 15) ; "Funny, it doesn't smell like a rodent."
			)
			(11 ; Taste
				(Print 9 16) ; "Good thing that isn't a real mouse or you'd be hacking up furballs."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screen of Feature
	(properties
		description {screen}
		onMeCheck 64
		lookStr {The view screens offer a glimpse of the surroundings from outboard cameras. They came in handy during the testing phase of the Star Generator.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 9 17) ; "Do you know how many hours you've spent cleaning view screens because of acts like that!"
			)
			(5 ; Talk
				(Print 9 18) ; "BOING! Right back in your face those words did come."
			)
			(12 ; Smell
				(Print 9 19) ; "Smells like viewdex with pneumonia-f."
			)
			(11 ; Taste
				(Print 9 20) ; "Unfortunately, it tastes like viewdex with pneumonia-f!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wires of Feature
	(properties
		description {wires}
		onMeCheck 32
		lookStr {Big, phony wiring from the giant control devices attempts to complete the decorative effect.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 9 21) ; "These wires are way out of reach. Besides, you don't need them."
			)
			(5 ; Talk
				(Print 9 22) ; "Still looking for someone to understand you and see you for what you really are?"
			)
			(12 ; Smell
				(Print 9 23) ; "You can't smell them way up there."
			)
			(11 ; Taste
				(Print 9 24) ; "They're too far away to taste."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyboard of Feature
	(properties
		description {keyboard}
		onMeCheck 512
		lookStr {This keyboard was used in the development of the Star Generator. It has since been placed here to be out of the way. It has no function.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 9 25) ; "As much as you feel like pounding out a colonically stimulating version of 'chopsticks', you realize that it's time to get serious about surviving. (At least, we think you do.)"
			)
			(5 ; Talk
				(Print 9 26) ; "The keyboard has no sampler. That is what you meant to try, wasn't it?"
			)
			(12 ; Smell
				(Print 9 27) ; "It smells like lots of fingers pressed around this thing."
			)
			(11 ; Taste
				(Print 9 28) ; "It tastes like lots of unclean fingers pressed around this thing."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cords of Feature
	(properties
		description {cords}
		onMeCheck 1024
		lookStr {Big, phony wiring from the giant control devices attempts to complete the decorative effect.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 9 29) ; "The incredibly huge cords are affixed to the deck and can't be moved."
			)
			(5 ; Talk
				(Print 9 30) ; "Come to your senses."
			)
			(12 ; Smell
				(Print 9 31) ; "It smells like vinyl-encased wiring."
			)
			(11 ; Taste
				(Print 9 32) ; "You must have something more important to do than going around sucking on vinyl insulation."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

