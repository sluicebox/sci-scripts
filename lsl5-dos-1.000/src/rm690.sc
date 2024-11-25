;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 690)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm690 0
)

(local
	soundPlayed
)

(instance rm690 of LLRoom
	(properties
		picture 1
		style 12
	)

	(method (init)
		(gTheIconBar disable:)
		(LoadMany rsPIC 690)
		(LoadMany rsVIEW 690)
		(LoadMany rsFONT gNiceFont)
		(LoadMany rsSOUND 691)
		(super init:)
		(self setScript: sFBI)
	)
)

(instance sFBI of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(CenterDisplay 3 gColVLRed 690 0)
				(= seconds 5)
			)
			(1
				(sonarScreen init:)
				(sweep init: setCycle: Fwd)
				(blip init: setCycle: Fwd)
				(gCurRoom drawPic: 690 12)
				(= seconds 5)
			)
			(2
				(gTheIconBar enable:)
				(TPrint 690 1 #at -1 20 #title {Inspector Desmond} #dispose self) ; "What's she doing now, Agent Smith?"
			)
			(3
				(= seconds 3)
			)
			(4
				(if (IsFlag 20) ; fChampagneSolution
					(TPrint 690 2 #at -1 20 #title {Agent Smith} #dispose self) ; "Well, I dunno, Inspector Desmond, it's kinda hard to figure out. Either I'm picking up a lot of RF interference, or she's consuming way too much fluid!"
				else
					(TPrint 690 3 #at -1 20 #title {Agent Smith} #dispose self) ; "Well, I dunno, Inspector Desmond, it's kinda hard to figure out. Either she's in a tunnel somewhere near Baltimore, or she's dilated 3 cm!"
				)
			)
			(5
				(= seconds 3)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sweep dispose:)
				(blip dispose:)
				(gCurRoom drawPic: 1 6)
				(= seconds 3)
			)
			(7
				(if (IsFlag 20) ; fChampagneSolution
					(TPrint 690 4) ; "After getting Reverse Biaz totally sloshed (then finishing off the bottle yourself), you slip out of the control room, through the studio, down the elevator and back to your limo."
				else
					(TPrint 690 5) ; "After "sacrificing" yourself for your country, you slip out of the control room, through the studio, down the elevator and back to your limo."
				)
				(= seconds 3)
			)
			(8
				(gCurRoom newRoom: 200 7)
				(self dispose:)
			)
		)
	)
)

(instance sonarScreen of View
	(properties
		x 163
		y 114
		view 690
		priority 1
		signal 16400
	)
)

(instance sweep of Prop
	(properties
		x 161
		y 86
		view 690
		loop 2
		priority 12
		signal 16
		cycleSpeed 12
	)

	(method (doit)
		(super doit:)
		(cond
			(cel
				(= soundPlayed 0)
			)
			((not soundPlayed)
				(sonarPing play:)
				(= soundPlayed 1)
			)
		)
	)
)

(instance blip of Prop
	(properties
		x 170
		y 96
		view 690
		loop 1
		priority 12
		signal 16
		cycleSpeed 12
	)
)

(instance sonarPing of Sound
	(properties
		number 691
	)
)

