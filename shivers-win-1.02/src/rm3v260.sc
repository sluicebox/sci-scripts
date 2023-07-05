;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3260)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm3v260 0
)

(instance rm3v260 of ShiversRoom
	(properties
		picture 3260
	)

	(method (init)
		(gPBoatView setView: 0 nextRoom: 3260)
		(super init: &rest)
		(if (proc951_11 0 3000)
			(self setScript: sAttack)
		else
			(efExitLeft init: 2)
			(efExitRight init: 1)
			(gPBoatView nextRoom: 3300)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 910) ; shiversLogo
			(gPBoatView dispose:)
			(= gPBoatView 0)
			(gSounds stop: 20303)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3270
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc925_1 50030 self)
			)
			(1
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(gPBoatView nextRoom: 3300)
				(self dispose:)
			)
		)
	)
)

