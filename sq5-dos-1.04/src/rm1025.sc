;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1025)
(include sci.sh)
(use Main)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1025 0
)

(instance rm1025 of Rm
	(properties
		noun 1
		picture 133
	)

	(method (init)
		(LoadMany rsVIEW 679)
		(= gGoliathFloorNum 2)
		(= global135 26)
		(bigarrow init: setCycle: Fwd)
		(shieldSwitch init:)
		(light init:)
		(super init:)
		(gWalkHandler addToFront: self)
		(gGame handsOn:)
		(gTheIconBar select: (gTheIconBar at: 2))
		(gGame setCursor: 982)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb 0 0) ; "This corridor is slightly different from all the others you have encountered up to this point."
			)
			(else
				(gCurRoom newRoom: 1020)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose: &rest)
	)
)

(instance sFlipSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shieldSwitch setCel: 0)
				(light dispose:)
				(arrow init: setCycle: Fwd)
				(SetScore 248 20)
				(= seconds 2)
			)
			(1
				(gCurRoom newRoom: 1020)
				(self dispose:)
			)
		)
	)
)

(instance arrow of Prop
	(properties
		x 126
		y 116
		noun 3
		view 679
		loop 1
		cycleSpeed 8
	)
)

(instance bigarrow of Prop
	(properties
		x 150
		y 73
		noun 3
		view 679
	)
)

(instance shieldSwitch of View
	(properties
		x 160
		y 108
		noun 2
		view 679
		loop 2
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sFlipSwitch)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance light of View
	(properties
		x 198
		y 117
		noun 3
		view 679
		loop 3
	)
)

