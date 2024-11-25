;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 740)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Wander)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm740 0
)

(local
	doitCounter
	partCounter
	lSeconds
	thisLSeconds
	lastLSeconds
	missTime = 1
	grabs
	wrestleSeconds
)

(instance rm740 of LLRoom
	(properties
		picture 740
	)

	(method (init)
		(LoadMany rsSOUND 742 742 752 753 754 752 753 754)
		(Load rsSCRIPT 970)
		(super init:)
		(HandsOn)
		(User canControl: 0)
		(gTheIconBar disable: 0 3 6 7)
		(larry init:)
		(gTheMusic number: 740 setLoop: -1 flags: 1 play: 127)
		(self setScript: sRoom)
	)

	(method (doit)
		(super doit:)
		(if (gCast contains: bodyPart)
			(= thisLSeconds (GetTime 1)) ; SysTime12
			(if (!= lastLSeconds thisLSeconds)
				(= lastLSeconds thisLSeconds)
				(++ wrestleSeconds)
				(if (< missTime 1000)
					(++ missTime)
				)
				(cond
					((== wrestleSeconds 30)
						(TPrint 740 0) ; "Hang in there, Larry. She looks like she's slowing down!"
					)
					((not (mod wrestleSeconds 8))
						(cond
							((not grabs)
								(TPrint 740 1) ; "Hint: click the hand on any body part you can reach."
							)
							((and (> wrestleSeconds 19) (< grabs 5))
								(TPrint 740 2) ; "Ha, ha, Larry!" Lana cries, "I knew I could take you!"
							)
						)
					)
				)
			)
		)
	)

	(method (doVerb)
		(return 1)
	)

	(method (dispose)
		(DisposeScript 970)
		(super dispose:)
	)
)

(instance sRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(TPrint 740 3) ; "Gosh, Larry! Are you sure you want to go through with this? Why, your leisure suit might even get muddy!"
				(= seconds 2)
			)
			(2
				(larry
					cycleSpeed: 6
					moveSpeed: 6
					observeControl: 4
					setCycle: Fwd
					setMotion: Wander
				)
				(= seconds 3)
			)
			(3
				(TPrint 740 4) ; "She must be waiting for you to take the offensive. You decide to grab whatever parts of her body you can!"
				(TPrint 740 5 #at -1 185) ; "(Heh, heh, heh!)"
				(larry setMotion: 0)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(Animate (gCast elements:) 0)
				(bodyPart init: perform: findWhere)
				(gCurRoom setScript: sRoar)
			)
		)
	)
)

(instance sRoar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 4))
			)
			(1
				(soundFX number: 742 play:)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sFadeout of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(larry
					illegalBits: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 147 78 self
				)
			)
			(1
				(larry setMotion: MoveTo 131 56 self)
			)
			(2
				(gTheMusic fade: 80 10 10 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom newRoom: 750)
			)
		)
	)
)

(instance bodyPart of Actor
	(properties
		description {her}
		view 740
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(switch cel
					(1
						(TPrint 740 6) ; "It's her arm! Grab it!"
					)
					(0
						(TPrint 740 6) ; "It's her arm! Grab it!"
					)
					(3
						(TPrint 740 7) ; "It's her leg! Grab it!"
					)
					(2
						(TPrint 740 8) ; "It's her leg! Grab it!"
					)
					(4
						(TPrint 740 9) ; "It's her head! Grab it!"
					)
					(5
						(TPrint 740 10) ; "It's her... WHOA! Yeah, grab that!"
					)
					(6
						(TPrint 740 11) ; "You'd love to grab her there!"
					)
				)
			)
			(3 ; Do
				(larry cue: 1)
				(self perform: findWhere)
				(switch cel
					(1
						(TPrint ; "Oh!"
							740
							12
							#at
							-1
							185
							#title
							{The Audience}
							#mode
							1
							#dispose
						)
					)
					(0
						(TPrint ; "Wow!"
							740
							13
							#at
							-1
							185
							#title
							{The Audience}
							#mode
							1
							#dispose
						)
					)
					(3
						(TPrint ; "Ooh!"
							740
							14
							#at
							-1
							185
							#title
							{The Audience}
							#mode
							1
							#dispose
						)
					)
					(2
						(TPrint ; "Woah!"
							740
							15
							#at
							-1
							185
							#title
							{The Audience}
							#mode
							1
							#dispose
						)
					)
					(4
						(TPrint ; "Eeee!"
							740
							16
							#at
							-1
							185
							#title
							{The Audience}
							#mode
							1
							#dispose
						)
					)
					(5
						(TPrint ; "Ahhhhh!"
							740
							17
							#at
							-1
							185
							#title
							{The Audience}
							#mode
							1
							#dispose
						)
					)
					(6
						(TPrint ; "Gasp!"
							740
							18
							#at
							-1
							185
							#title
							{The Audience}
							#mode
							1
							#dispose
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (self onMe: (User curEvent:)) (not (Random 0 missTime)))
			(= partCounter 1)
		)
		(if (and (not (-- partCounter)) (!= (gCurRoom script:) sFadeout))
			(self perform: findWhere)
		)
	)
)

(instance findWhere of Code
	(properties)

	(method (doit who &tmp theX theY)
		(while
			(==
				(OnControl
					CONTROL
					(= theX (Random 10 310))
					(= theY (Random 10 170))
				)
				2
			)
		)
		(who setCel: (Random 0 6) posn: theX theY)
		(= partCounter (* missTime (Random 5 15)))
	)
)

(instance larry of Actor
	(properties
		x 160
		y 100
		description {you and Lana}
		lookStr {That's you and Lana wrestling, but you can't touch you from way up here!}
		view 743
		signal 18432
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 740 19) ; "Don't grab you and Lana. Grab those flying body parts instead!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (init)
		(super init:)
		(self setCycle: End)
	)

	(method (cue cueType &tmp theAng theX theY)
		(switch cueType
			(0
				(self setCycle: 0)
			)
			(1
				(if (> grabs 9)
					(HandsOff)
					(gCurRoom setScript: sFadeout)
				else
					(patFX number: (+ 752 (/ grabs 2)) play:)
					(++ grabs)
					(cond
						((< (= theAng (GetAngle x y 153 84)) 90)
							(= theX (+ x (Random 10 40)))
							(= theY (- y (Random 10 40)))
						)
						((< theAng 180)
							(= theX (+ x (Random 10 40)))
							(= theY (+ y (Random 10 40)))
						)
						((< theAng 270)
							(= theX (- x (Random 10 40)))
							(= theY (+ y (Random 10 40)))
						)
						(else
							(= theX (- x (Random 10 40)))
							(= theY (- y (Random 10 40)))
						)
					)
					(self
						setLoop: 0
						setCycle: Fwd
						setMotion: MoveTo theX theY self
					)
				)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance patFX of Sound
	(properties
		flags 1
	)
)

