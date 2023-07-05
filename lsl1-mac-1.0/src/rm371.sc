;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Feature)

(public
	rm371 0
)

(local
	triedOnce
)

(procedure (InitDollFeas)
	(doll init:)
	(herMouth init:)
	(fLeftNipple init:)
	(fRightNipple init:)
	(fLeftTit init:)
	(fRightTit init:)
)

(instance rm371 of LLRoom
	(properties
		picture 375
	)

	(method (init)
		(InitDollFeas)
		(gEgo init: z: 1000 hide:)
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (gEgo mover:)
			(HandsOff)
			(gCurRoom newRoom: 370)
		)
	)
)

(instance herMouth of Feature
	(properties
		x 156
		y 81
		nsTop 71
		nsLeft 142
		nsBottom 91
		nsRight 171
		description {her mouth}
		sightAngle 40
		lookStr {Her mouth reminds you of something.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Printf 371 0 (self lookStr:)) ; "%s"
			)
			(else
				(doll doVerb: theVerb invItem)
			)
		)
	)
)

(instance fRightNipple of Feature
	(properties
		x 156
		y 172
		nsTop 166
		nsLeft 144
		nsBottom 179
		nsRight 169
		description {her right nipple}
		sightAngle 40
		lookStr {You used this to inflate half of her.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Printf 371 0 (self lookStr:)) ; "%s"
			)
			(11 ; Taste/Smell
				(Print 371 1) ; "If you inflate her any more, she'll pop!"
			)
			(else
				(doll doVerb: theVerb invItem)
			)
		)
	)
)

(instance fLeftNipple of Feature
	(properties
		x 250
		y 136
		nsTop 126
		nsLeft 238
		nsBottom 141
		nsRight 262
		description {her left nipple}
		lookStr {You used this to inflate half of her.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Printf 371 0 (self lookStr:)) ; "%s"
			)
			(11 ; Taste/Smell
				(Print 371 1) ; "If you inflate her any more, she'll pop!"
			)
			(else
				(doll doVerb: theVerb invItem)
			)
		)
	)
)

(instance fRightTit of Feature
	(properties
		x 157
		y 164
		nsTop 140
		nsLeft 122
		nsBottom 189
		nsRight 193
		description {that latex breast}
		sightAngle 40
		lookStr {At this particular moment, you feel her right breast is the best.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Printf 371 0 (self lookStr:)) ; "%s"
			)
			(3 ; Do
				(Print 371 2) ; "She feels so life-like--for latex!"
			)
			(else
				(doll doVerb: theVerb invItem)
			)
		)
	)
)

(instance fLeftTit of Feature
	(properties
		x 239
		y 135
		nsTop 114
		nsLeft 199
		nsBottom 162
		nsRight 279
		description {that latex breast}
		sightAngle 40
		lookStr {At this particular moment, you feel her left breast is the best.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Printf 371 0 (self lookStr:)) ; "%s"
			)
			(3 ; Do
				(Print 371 2) ; "She feels so life-like--for latex!"
			)
			(else
				(doll doVerb: theVerb invItem)
			)
		)
	)
)

(instance doll of Feature
	(properties
		x 162
		y 30
		nsLeft 39
		nsBottom 189
		nsRight 285
		description {the doll}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 371 3) ; "There's nothing more for you to see!"
			)
			(3 ; Do
				(Print 371 4) ; "You're not sure, but you think she just smiled!"
			)
			(10 ; Zipper
				(if triedOnce
					(Points 58 8)
					(Print 371 5) ; "All right, you asked for it. In fact, you've asked for it twice! Here we go..."
					(Print 371 6) ; "Selecting your own personal favorite from the three available openings, you shyly try out the doll. This has to be the kinkiest thing you've done yet, Larry."
					(Print 371 7) ; "You gradually increase your tempo as you lose your inhibitions (not to mention your self-esteem). Faster and faster you go, until suddenly, there's a loud, flatulent sound..."
					(HandsOff)
					(gCurRoom newRoom: 370)
				else
					(= triedOnce 1)
					(Print 371 8) ; "Geez, Larry. Do we have to?"
				)
			)
			(5 ; Talk
				(Print 371 9) ; "Foreplay is not really necessary with inanimate objects."
				(Print 371 10 #at -1 140) ; "(Besides, you find it difficult to establish a meaningful relationship with latex!)"
			)
			(11 ; Taste/Smell
				(Print 371 9) ; "Foreplay is not really necessary with inanimate objects."
				(Print 371 10 #at -1 140) ; "(Besides, you find it difficult to establish a meaningful relationship with latex!)"
			)
			(4 ; Inventory
				(switch invItem
					(17 ; graffiti
						(Print 371 11) ; "Ken was here, too!"
					)
					(11 ; pocketKnife
						(Print 371 12) ; "Oops! Bad idea, Larry!"
						(HandsOff)
						(gCurRoom newRoom: 370)
					)
					(else
						(Print 371 13) ; "That's not the item she expects you to use!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

