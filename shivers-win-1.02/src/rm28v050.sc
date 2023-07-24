;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28050)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm28v050 0
)

(local
	local0
)

(instance rm28v050 of ShiversRoom
	(properties
		picture 28050
	)

	(method (init)
		(efBack init: 8)
		(hsCoinReturn init:)
		(hsCoinSlot init:)
		(spCoin init:)
		(= local0 0)
		(coinCursor init: hide:)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties)

	(method (init)
		(self
			nextRoom: 28010
			createPoly: 0 143 0 0 263 0 263 143 126 143 126 123 243 123 243 20 20 20 20 123 125 123 125 143
		)
		(super init: &rest)
	)
)

(instance hsCoinSlot of HotSpot
	(properties)

	(method (init)
		(self createPoly: 199 96 189 95 195 82 209 82 203 92)
		(super init: &rest)
	)

	(method (doVerb)
		(if local0
			(proc951_16 163)
			(gCurRoom setScript: sDropCoin)
		)
	)
)

(instance hsCoinReturn of HotSpot
	(properties)

	(method (init)
		(self createPoly: 185 122 165 116 177 104 203 104 206 116 196 121)
		(super init: &rest)
	)

	(method (doVerb)
		(if local0
			(= local0 0)
			(coinCursor hide:)
			(spCoin show:)
			(gNormalCursor show:)
		else
			(= local0 1)
			(coinCursor show:)
			(spCoin hide:)
			(gNormalCursor hide:)
		)
	)
)

(instance spCoin of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 28053
		loop 2
		cel 1
	)

	(method (doVerb)
		(self hide:)
		(= local0 1)
		(gNormalCursor hide:)
		(coinCursor show:)
	)
)

(instance coinCursor of Prop
	(properties
		view 28053
		cel 1
	)

	(method (doit)
		(if local0
			(= x (- gMouseX 27))
			(= y (- gMouseY 7))
			(UpdateScreenItem self)
		)
	)

	(method (init)
		(super init: &rest)
		(self setPri: 255 1)
		(self hide:)
	)
)

(instance fortuneArm of Prop
	(properties
		view 28050
	)
)

(instance fortune of ShiversProp
	(properties
		x 123
		y 64
		view 28051
	)

	(method (doVerb)
		(sDropCoin cue:)
	)
)

(instance sDropCoin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hsCoinReturn dispose:)
				(hsCoinSlot dispose:)
				(= local0 0)
				(coinCursor hide:)
				(gNormalCursor show:)
				(= cycles 1)
			)
			(1
				(gSounds play: 12804 0 82 0)
				(spCoin loop: 1 cel: 1 setPri: 25 setCycle: End show:)
				(= seconds 2)
			)
			(2
				(spCoin loop: 2 hide:)
				(gSounds play: 12806 0 82 0)
				(fortuneArm init: cel: 0 setPri: 25 1 setCycle: End self)
			)
			(3
				(if (IsFlag 69)
					(fortune loop: (Random 0 9))
				else
					(SetFlag 69)
				)
				(fortune init: setPri: 125 1)
				(gGame handsOn:)
			)
			(4
				(gGame handsOff:)
				(fortune dispose:)
				(fortuneArm setCycle: Beg self)
			)
			(5
				(fortuneArm dispose:)
				(gSounds play: 12805 0 82 0)
				(spCoin cel: 0 setCycle: End show:)
				(gGame handsOn:)
				(hsCoinReturn init:)
				(hsCoinSlot init:)
				(self dispose:)
			)
		)
	)
)

