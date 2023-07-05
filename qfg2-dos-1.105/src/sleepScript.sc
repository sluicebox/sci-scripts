;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 368)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use Talker)
(use Motion)

(public
	sleepScript 0
)

(instance sleepScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 70 136
					setCycle: gEgoStopWalk 4
					setMotion: MoveTo 102 129 self
					init:
				)
			)
			(1
				(HighPrint 368 0) ; "You slept fitfully, dreaming of rat-like monsters pulling at you. In your dream, you felt cruelly exposed, but you re-covered."
				(switch gInnState
					(4
						(Say (ScriptID 360 2) self 368 1) ; "Signor Ferrari sends his regrets, but he had some rather disturbing news. He will talk to you this evening.", bartender
					)
					(9
						(HighPrint 368 2) ; "As you enter, the sounds of the bar go still."
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if (== gInnState 9)
					(Say (ScriptID 360 1) self 368 3) ; "It has been a pleasure dealing with you, my dear sir.", ferrari
				)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

