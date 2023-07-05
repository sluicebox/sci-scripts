;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 421)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use PolyPath)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rmHomo 0
	earl 1
)

(local
	local0
)

(procedure (localproc_0)
	(HandsOn)
	(if (not (gEgo normal:))
		(gTheIconBar disable: 0)
	)
)

(instance rmHomo of Rgn
	(properties
		keep 1
	)

	(method (init)
		(newsPaperSound init:)
		(super init:)
		(switch gDay
			(2
				(earl posn: 80 93 init: setScript: earlRandom)
				(self setScript: turnPage)
			)
			(5
				(earl view: 247 cel: 0 setPri: 3 posn: 81 104 init:)
			)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
		(super doit:)
	)
)

(instance earlTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(earl setScript: 0)
				(if (== (gEgo normal:) 1)
					(gEgo setMotion: PolyPath 110 101 self)
				else
					(= cycles 1)
				)
			)
			(1
				(= save1 1)
				(Print 421 0 #at 10 10 #dispose) ; "You interrupt Earl's reading..."
				(= seconds 3)
			)
			(2
				(= save1 1)
				((ScriptID 21 1) init:) ; sonnyInset
				(Say (ScriptID 21 1) 421 1) ; sonnyInset, "What's new in the local rag, Earl?"
				(= seconds 4)
			)
			(3
				(= save1 1)
				((ScriptID 21 1) dispose:) ; sonnyInset
				(Say
					earl
					{There's a good article in here about the newspaper helping another department find a witness to a shooting.}
				)
				(= seconds 8)
			)
			(4
				(earl setScript: earlRandom)
				(localproc_0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance earlRandom of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 50)
			)
			(1
				(earl setCycle: End)
				(newsPaperSound play:)
				(if (not (gCurRoom script:))
					(HandsOff)
					(gCurRoom setScript: eRan)
					(self dispose:)
				else
					(= state -1)
					(= cycles 1)
				)
			)
		)
	)
)

(instance eRan of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(HandsOff)
				(switch local0
					(0
						(Say earl 421 2) ; "Hey, look! There's some lady offerin' a reward for information on the whereabouts of her dog, 'Lucky'."
						(= seconds 8)
					)
					(1
						(Say earl 421 3) ; "Too bad I missed that Pink Mongoloid concert last week!"
						(= seconds 5)
					)
					(2
						(Say earl 421 4) ; "Here's one for ya, Sonny. A chick lost her gold-plated breast-cones at Spunky's last night. Says here she took them off so that they wouldn't rust during the 'wet t-shirt contest'."
						(= seconds 10)
					)
				)
			)
			(1
				(= save1 1)
				(switch local0
					(0
						(Say earl 421 5) ; "You ain't happened to of seen a three-legged, one-eyed, appendix-scarred, deaf, toothless, poodle-mix mutt wanderin' around the nuclear plant, have ya?"
						(= seconds 10)
					)
					(1
						(Say earl 421 6) ; "They're offerin' a reward for witnesses to those twenty people being trampled to death. Geez, and to think I missed all the fun!"
						(= seconds 10)
					)
					(2
						(Say earl 421 7) ; "$100.00 to the lucky finder. Of course, it'd be worth it just to keep 'em if they fit."
						(= seconds 7)
					)
				)
			)
			(2
				(localproc_0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (!= local0 2)
					(++ local0)
					(earl setScript: earlRandom)
				)
				(self dispose:)
			)
		)
	)
)

(instance turnPage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(earl setCycle: End)
				(newsPaperSound play:)
				(= state -1)
				(= seconds (Random 10 15))
			)
		)
	)
)

(instance earlTalk2 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo normal:) 1)
					(gEgo setMotion: PolyPath 110 101 self)
				else
					(= cycles 1)
				)
			)
			(1
				(= save1 1)
				(earl setScript: 0)
				((ScriptID 21 1) init:) ; sonnyInset
				(Say (ScriptID 21 1) 421 8) ; sonnyInset, "Looks like you're getting bored Hanks."
				(= seconds 4)
			)
			(2
				(= save1 1)
				((ScriptID 21 1) dispose:) ; sonnyInset
				(Say earl 421 9) ; "Nope, I'm just trying to see if there's a particular pattern to these homicides by marking the locations."
				(= seconds 8)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(localproc_0)
				(if (not (gEgo normal:))
					(gTheIconBar disable: 0)
				)
				(earl setScript: wadPaper)
				(self dispose:)
			)
		)
	)
)

(instance wadPaper of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(if (not (gCurRoom script:))
					(= save1 1)
					(HandsOff)
					(Print 421 10 #dispose #at 10 10) ; "Not listening to what your saying Earl mumbles to himself..."
					(earl setCycle: End)
				else
					(-- state)
				)
				(= seconds 5)
			)
			(2
				(= save1 1)
				(Say earl 421 11) ; "I just may have to get on that dang computer to work this out."
				(= seconds 5)
			)
			(3
				(localproc_0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance earl of Prop
	(properties
		x 90
		y 103
		lookStr {Officer Hanks is soft-featured but hardly soft-spoken.}
		view 243
		signal 16385
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(switch gDay
					(2
						(switch local0
							(0
								(++ local0)
								(HandsOff)
								(self setScript: 0)
								(gCurRoom setScript: earlTalk)
							)
							(else
								(Print 421 12) ; "Earl seems lost in thought."
							)
						)
					)
					(5
						(switch local0
							(0
								(HandsOff)
								(gCurRoom setScript: earlTalk2)
								(++ local0)
							)
							(else
								(Print 421 12) ; "Earl seems lost in thought."
							)
						)
					)
				)
			)
			(3 ; Do
				(if (== gDay 2)
					(Print 421 13) ; "Earl is very possesive about his newspaper."
				else
					(Print 421 14) ; "Earl does not wish to dance."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance newsPaperSound of Sound
	(properties
		number 211
	)
)

