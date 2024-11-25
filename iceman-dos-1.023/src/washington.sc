;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Game)
(use System)

(public
	washington 0
)

(instance washington of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 17 18 19 20 21)) ; dullesAirport, pentagonFront, pentagonLobby, pentagonHall, briefingRoom
		(= initialized 0)
		(gEgo illegalBits: $8000)
		(super newRoom: &rest)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((not (gEgo has: 6)) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(event claimed: 0)
			)
			((Said 'look<in,in/earring')
				(cond
					((gEgo has: 1) ; Microfilm
						(Print 302 0) ; "The interior is hollow."
					)
					((== global143 1)
						(self setScript: taDaScript)
					)
					((== global143 2)
						(Print 302 1) ; "Inside you see a tiny roll of microfilm."
					)
					(else
						(Print 302 2) ; "It's not open."
					)
				)
			)
			((Said 'examine,look[<at]/earring')
				(Print 302 3) ; "It appears that the top of the earring can be opened."
			)
			((or (Said 'open,detach,(get<off)/top') (Said 'open/earring'))
				(if (> global143 0)
					(proc0_31) ; "It is."
				else
					(Print 302 4) ; "After carefully removing the top, you discover the earring to be hollow."
					(= global143 1)
				)
			)
			((Said 'get/film')
				(cond
					((gEgo has: 1) ; Microfilm
						(Print 302 5) ; "You already have it."
					)
					((== global143 2)
						(Print 302 6) ; "You remove the microfilm."
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
						(Print 302 7) ; "It's hard to see. It's crammed down in the earring."
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance taDaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 302 8 #at -1 5) ; "Inside the earring is a tiny roll of microfilm."
				(taDaSnd play: self)
				(Print 302 9 #dispose #width 220 #at -1 5) ; ""MERCY MERCY," you think to yourself."
				(= seconds 6)
			)
			(1
				(Print 302 10 #dispose #width 280 #at -1 5) ; "That beautiful woman is an 'UNDERCOVER' agent!"
			)
			(2
				(Print 302 11 #dispose #width 260 #at -1 5) ; ""But for whom," you wonder as an afterthought."
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
	)
)

(instance taDaSnd of Sound
	(properties
		number 99
		priority 10
	)
)

