;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 317)
(include sci.sh)
(use Main)
(use Interface)
(use n822)
(use Sound)
(use System)

(public
	earRingFeat 0
)

(instance earRingFeat of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look<in,in/earring')
				(cond
					((gEgo has: 1) ; Microfilm
						(Print 317 0) ; "The interior is hollow."
					)
					((== global143 1)
						(proc822_0 gGame self)
					)
					((== global143 2)
						(Print 317 1) ; "Inside the earring is a tiny roll of microfilm."
					)
					(else
						(Print 317 2) ; "It's not open."
					)
				)
			)
			((Said 'examine,look[<at]/earring')
				(Print 317 3) ; "It appears that the top of the earring can be opened."
			)
			((or (Said 'open,detach,(get<off)/top') (Said 'open/earring'))
				(if (> global143 0)
					(proc0_31) ; "It is."
				else
					(Print 317 4) ; "After carefully removing the top, you discover that the earring is hollow."
					(= global143 1)
				)
			)
			((Said 'get/film')
				(cond
					((gEgo has: 1) ; Microfilm
						(Print 317 5) ; "You already have it."
					)
					((== global143 2)
						(Print 317 6) ; "You remove the microfilm."
						(gEgo get: 1) ; Microfilm
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'look/film')
				(cond
					((gEgo has: 1) ; Microfilm
						(event claimed: 0)
					)
					((== global143 2)
						(Print 317 7) ; "It's hard to see. It's crammed down in the earring."
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
		(if (not client)
			(DisposeScript 317)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 317 1 #at -1 5) ; "Inside the earring is a tiny roll of microfilm."
				(taDaSnd play: self)
				(Print 317 8 #dispose #width 220 #at -1 5) ; ""MERCY MERCY," you think to yourself."
				(= seconds 6)
			)
			(1
				(Print 317 9 #dispose #width 280 #at -1 5) ; "That beautiful woman is an 'UNDERCOVER' agent!"
			)
			(2
				(Print 317 10 #dispose #width 260 #at -1 5) ; ""But for whom," you wonder as an afterthought."
			)
			(3
				(gGame changeScore: 1)
				(= global143 2)
				(taDaSnd dispose:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (< state 3) (== (taDaSnd prevSignal:) -1))
			(self cue:)
		)
	)

	(method (dispose)
		(proc0_3)
		(HandsOn)
		(super dispose:)
		(DisposeScript 317)
		(DisposeScript 822)
	)
)

(instance taDaSnd of Sound
	(properties
		number 99
		priority 10
	)
)

