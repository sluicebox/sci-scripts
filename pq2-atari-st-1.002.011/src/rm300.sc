;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm300 0
)

(procedure (localproc_0)
	(Print &rest #font 4 #at -1 145 #width 280)
)

(instance rm300 of Rm
	(properties
		picture 502
		style 6
	)

	(method (init)
		(Load rsVIEW 500)
		(super init:)
		(HandsOff)
		(capFace
			view: 500
			loop: 0
			cel: 0
			ignoreActors:
			posn: 109 123
			setPri: 8
			init:
		)
		(capTorso
			view: 500
			loop: 0
			cel: 1
			ignoreActors:
			posn: 113 146
			setPri: 10
			init:
		)
		(capHand
			view: 500
			loop: 0
			cel: 2
			ignoreActors:
			posn: 163 157
			setPri: 0
			init:
		)
		(capLips
			view: 500
			loop: 1
			cel: 1
			ignoreActors:
			posn: 122 107
			setPri: 14
			setScript: speak
			init:
		)
		(sonny
			view: 500
			loop: 0
			cel: 3
			ignoreActors:
			posn: 213 147
			setPri: 14
			init:
		)
		(if (== global158 1)
			(self setScript: warned)
		else
			(self setScript: suspended)
		)
	)
)

(instance warned of Script
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or (== (event type:) evKEYBOARD) (== (event type:) evMOUSEBUTTON))
				gModelessDialog
			)
			(event claimed: 1)
			(= seconds 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global158 0)
				(= cycles 1)
			)
			(1
				(localproc_0 300 0 88) ; "Hey, BOY!" says the captain..."Just in case you don't know it, we have a police department to run. Now quit MESSING around and get to work!"
				(= seconds 10)
			)
			(2
				(clr)
				(localproc_0 300 1 88) ; "Having your undivided attention, the captain says..."For your information, DETECTIVE BONDS, it would be so ducky if you could check in with me once in a while just to see if I might have something for you to do.""
				(= seconds 10)
			)
			(3
				(clr)
				(localproc_0 300 2 88) ; "After your mild reaming he says... "Consider this a warning FELLA! You can go now.""
				(= seconds 10)
			)
			(4
				(clr)
				(HandsOn)
				(++ state)
				(gCurRoom newRoom: 4)
			)
		)
	)
)

(instance suspended of Script
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or (== (event type:) evKEYBOARD) (== (event type:) evMOUSEBUTTON))
				gModelessDialog
			)
			(event claimed: 1)
			(= cycles (= seconds 0))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state (* 2 (Random 0 2)))
				(= cycles 1)
			)
			(1
				(localproc_0 300 3 88) ; "I regret having to inform you of this." says the Captain... "But refusing to obey orders is strictly against departmental policy. It's a violation called insubordination!"
				(= seconds 10)
			)
			(2
				(clr)
				(localproc_0 300 4 88) ; "Continuing he says..."According to departmental 'Standard Operating Procedure', you are hereby suspended for two days, effective immediately!!""
				(= seconds 10)
				(= state 9)
			)
			(3
				(localproc_0 300 5 88) ; "Well, Bonds, ol' buddy," says the Captain..."You've managed to earn yourself a couple days off without PAY!"
				(= seconds 10)
			)
			(4
				(clr)
				(localproc_0 300 6 88) ; "Continuing he says..."Failing to carry out your assignments will land you in the `stuff' every time. Try and remember that when you return to work.""
				(= seconds 10)
				(= state 9)
			)
			(5
				(localproc_0 300 7 88) ; "The Captain isn't very happy as he says..."Well, here you are again Sonny! You seem to have difficulty following orders.""
				(= seconds 10)
			)
			(6
				(clr)
				(localproc_0 300 8 88) ; "Another two days off with no pay!" he rants..."You keep this up and you're gonna wind up owing the department your whole pay check!!"
				(= seconds 10)
				(= state 9)
			)
			(10
				(clr)
				(EgoDead 300 9) ; "Even the hottest detective needs to follow orders."
			)
		)
	)
)

(instance speak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Fwd)
				(= seconds (Random 1 2))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= seconds (Random 1 2))
				(= state -1)
			)
		)
	)
)

(instance capFace of View
	(properties)
)

(instance capTorso of View
	(properties)
)

(instance capHand of View
	(properties)
)

(instance capLips of Prop
	(properties)
)

(instance sonny of View
	(properties)
)

