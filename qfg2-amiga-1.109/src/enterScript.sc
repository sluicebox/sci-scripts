;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 367)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use Talker)
(use rm360)
(use Timer)
(use Motion)

(public
	enterScript 0
)

(local
	birdCount
)

(instance enterScript of HandsOffScript
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== gInnState 7)
				(cond
					((Said 'no')
						(client setScript: birdScript 0 0)
					)
					((Said 'yes')
						(client setScript: birdScript 0 1)
					)
					(else
						(Say (ScriptID 360 1) 367 0) ; "Just tell me if you have the bird!", ferrari
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 160 250
					setCycle: gEgoStopWalk 4
					setMotion: MoveTo 160 180 self
					init:
				)
			)
			(1
				(switch gInnState
					(0
						(SetFlag 113)
						(HighPrint 367 1) ; "Of all the djinn joints in all the world, you had to walk into this one."
						(HighPrint 367 2) ; "A hush comes over the bar as people notice you and eye you sullenly."
						(= cycles 1)
					)
					(2
						(SetFlag 113)
						(Say (ScriptID 360 1) self 367 3) ; "Come join me here, my dear sir. You are still a novelty in Raseir, and I take a vested interest in all things new. It is time we discussed some things together, you and I.", ferrari
					)
					(5
						(if (IsFlag 99)
							(SetFlag 113)
						else
							(ClearFlag 113)
						)
						(if (not (SetFlag 119))
							(Say (ScriptID 360 1) self 367 4 367 5 367 6) ; "It is a pity about our friend Ugarte, is it not? I can see you are as broken up by the affair as I am.", ferrari
						else
							(= cycles 1)
						)
					)
					(7
						(DontTalk 0)
						(Say (ScriptID 360 1) 367 7) ; "Do you have it? Do you have the bird?", ferrari
						(StartTimer birdTimer 10)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(switch gInnState
					(0
						(Say (ScriptID 360 2) self 367 8) ; "Will you look what crawled in from the desert? He has been out in the sun so long, his hair has gone yellow!", bartender
					)
					(5
						(if (IsFlag 99)
							(Say (ScriptID 360 1) self 367 9) ; "If you wish to discuss something to our mutual advantage, come sit down.", ferrari
						else
							(= cycles 1)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(switch gInnState
					(0
						(Say (ScriptID 360 1) self 367 10 367 11) ; "Now, now, Wilmer, he is a stranger to our fair city. You wouldn't want to give the wrong opinion about the hospitality of Raseir.", ferrari
						(StartTimer (ScriptID 360 5) 60) ; waitTimer
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance birdScript of HandsOffScript
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sat')
				(birdTimer dispose:)
				(event claimed: 0)
			)
			((or (Said 'give/bird') (Said 'give[/ferrari,man]/bird'))
				(HighPrint 367 12) ; "You give Signor Ferrari the bird. A puzzled look crosses his face, and suddenly you realize that he was referring to the Black Falcon."
				(birdTimer dispose:)
				(client setScript: (ScriptID 360 6)) ; seatEgo
			)
			((Said 'no')
				(= birdCount 3)
				(birdTimer cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontTalk 0)
				(if register
					(Say (ScriptID 360 1) 367 13) ; "Bring it here, quickly. Give it to me!", ferrari
					(= birdCount 2)
					(SetFlag 113)
					(StartTimer birdTimer 10)
				else
					(Say (ScriptID 360 1) self 367 14) ; "No? No? What do you mean, "No?"", ferrari
				)
			)
			(1
				(HighPrint 367 15) ; "You leave Ferrari a sorely disappointed man."
				(ClearFlag 113)
				(self dispose:)
			)
		)
	)
)

(instance birdTimer of Timer
	(properties)

	(method (cue)
		(switch (++ birdCount)
			(1
				(Say (ScriptID 360 1) 367 16) ; "Perhaps you did not hear me. I asked if you have the bird.", ferrari
				(StartTimer self 10)
			)
			(3
				(Say (ScriptID 360 1) 367 17) ; "I said give me the bird!", ferrari
				(StartTimer self 5)
			)
			(else
				(if (gEgo has: 47) ; Bird
					(KillEgo 4 {You give him the bird})
				else
					(KillEgo 5 {He still don't got it})
				)
			)
		)
	)
)

