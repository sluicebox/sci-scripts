;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2330)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm2v33 0
)

(local
	local0
)

(instance rm2v33 of ShiversRoom
	(properties
		picture 2330
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(hsDoorArea init:)
		(= local0 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 2320) local0) ; rm2v32
			(SetFlag 43)
		)
		(if (== newRoomNumber 3020) ; rm3v020
			(gSounds fade: 20204 0 5 15 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2320
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3020
	)

	(method (init)
		(self
			createPoly: 115 28 98 36 90 42 86 48 81 57 80 66 80 84 81 142 174 143 174 78 170 55 167 44 159 37 151 30 141 27
		)
		(super init: &rest)
	)
)

(instance hsDoorArea of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 115 28 98 36 90 42 86 48 81 57 80 66 80 84 81 142 174 143 174 78 170 55 167 44 159 37 151 30 141 27
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sOpenDoor)
	)
)

(instance spDoor of Prop
	(properties
		view 2330
		cycleSpeed 36
	)

	(method (init)
		(self setPri: 25)
		(super init: &rest)
	)
)

(instance spBat of Prop
	(properties
		view 2331
		cycleSpeed 9
	)

	(method (init param1)
		(= loop param1)
		(switch loop
			(0
				(self posn: 81 50)
			)
			(1
				(self posn: 150 56)
			)
			(2
				(self posn: 134 73)
			)
			(3
				(self posn: 98 76)
			)
		)
		(super init: &rest)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gSounds play: 10217 0 82 0)
				(spDoor init: setCycle: End self)
				(if (Random 0 2)
					(+= state 4)
				)
			)
			(2
				(gSounds play: 10216 0 82 0)
				((spBat new:) init: 0 setCycle: End yourself:)
				(= cycles 18)
			)
			(3
				((spBat new:) init: 1 setCycle: End yourself:)
				((spBat new:) init: 2 setCycle: End yourself:)
				(= cycles 27)
			)
			(4
				((spBat new:) init: 3 setCycle: End self yourself:)
			)
			(5
				(= seconds 2)
			)
			(6
				(hsDoorArea dispose:)
				(= local0 1)
				(efExitForward init: 9)
				(gGame handsOn:)
				(gSounds stop: 10217)
				(self dispose:)
			)
		)
	)
)

