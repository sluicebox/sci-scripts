;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6030)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm6v030 0
)

(local
	local0
	local1
)

(instance rm6v030 of ShiversRoom
	(properties
		picture 6030
	)

	(method (init)
		(= local1 1)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(hsTapestry init:)
		(hsDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 5)
		(cond
			((>= 30000 newRoomNumber 9000)
				(gSounds fadeChain:)
				(if (not local1)
					(gSounds play: 10620 0 40 0)
				)
			)
			((== newRoomNumber 38110) ; rm38v110
				(if (proc951_11 2 6000)
					(gSounds fade: 20603 0 5 16 1 0)
					(proc951_9 20601)
					(gSounds play: 20601 -1 0 0)
					(gSounds fade: 20601 10 1 30 0 0)
					(gSounds playChain: -1 -4 20602 -1)
					(gSounds adjChainVol: 34)
				)
			)
			(else
				(if local0
					(SetFlag 43)
				)
				(if (not local1)
					(gCurRoom drawPic: 6030)
					(gSounds play: 10620 0 40 0)
				)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance hsTapestry of HotSpot
	(properties)

	(method (init)
		(self createPoly: 20 70 117 70 117 145 20 145)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 145)
		(= local1 0)
		(gSounds play: 10610 0 32 0)
		(gCurRoom drawPic: 6031)
		(if (not global186)
			(efExitSecret init: 3)
		else
			(hsSecretPassage init:)
		)
		(hsTapestryDrop init:)
		(self dispose:)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9020
	)

	(method (init)
		(self createPoly: 137 142 137 42 197 42 197 143)
		(super init: &rest)
	)
)

(instance efExitSecret of ExitFeature
	(properties
		nextRoom 38110
	)

	(method (init)
		(self createPoly: 37 104 113 104 112 137 37 139)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		view 6030
		cycleSpeed 18
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 137 142 137 42 197 42 197 143)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sDoorOpens)
	)
)

(instance hsTapestryDrop of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				21
				0
				22
				142
				35
				101
				118
				101
				118
				141
				133
				141
				134
				40
				203
				39
				203
				142
				243
				142
				243
				0
		)
		(super init: &rest)
	)

	(method (doVerb)
		(= local1 1)
		(gSounds play: 10620 0 32 0)
		(gCurRoom drawPic: 6030)
		(hsTapestry init:)
		(efExitSecret dispose:)
		(self dispose:)
	)
)

(instance sDoorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pDoor init: setPri: 25 1)
				(proc951_7 10613)
				(= cycles 1)
			)
			(1
				(pDoor setCycle: End)
				(gSounds play: 10613 0 40 self)
			)
			(2
				(if (not local1)
					(= local1 1)
					(gSounds play: 10620 0 32 self)
					(gCurRoom drawPic: 6030)
					(hsTapestry init:)
					(hsTapestryDrop dispose:)
				else
					(self cue:)
				)
			)
			(3
				(gGame handsOn:)
				(efExitForward init: 3)
				(= local0 1)
				(hsDoor dispose:)
				(self dispose:)
			)
		)
	)
)

(instance hsSecretPassage of HotSpot
	(properties)

	(method (init)
		(self createPoly: 37 104 113 104 112 137 37 139)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== global186 1)
			(gCurRoom setScript: sPurchaseMe)
		)
	)
)

(instance hsDialogArea of HotSpot
	(properties
		nsRight 266
		nsBottom 143
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doVerb)
		(vDialog dispose:)
		(self dispose:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance sPurchaseMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(vDialog init:)
				(gSounds play: 35020 0 106 self)
			)
			(1
				(hsDialogArea init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance vDialog of View
	(properties
		x 58
		y 125
		priority 250
		fixPriority 1
		view 921
		cel 6
	)
)

