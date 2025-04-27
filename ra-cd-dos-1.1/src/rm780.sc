;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 780)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use LoadMany)
(use Sound)
(use Actor)
(use System)

(public
	rm780 0
)

(instance rm780 of LBRoom
	(properties
		picture 780
		style 10
	)

	(method (init)
		(LoadMany rsSOUND 795)
		(super init:)
		(wrapMusic init: 1 795 1312 (if (== global106 32) 310 else 314) 311) ; mClosingMedley, mBar3, mBar1, mBar1notMT32, mBar2
		(gGame handsOff:)
		(gTheIconBar disable:)
		(gGame setCursor: 996 1)
		(self setScript: runTheCredits)
	)
)

(instance runTheCredits of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 782 0) self) ; runCredits
			)
			(1
				(= cycles 2)
			)
			(2
				(DisposeScript 782)
				(= cycles 2)
			)
			(3
				(self setScript: (ScriptID 781 0) self) ; runVoiceCredits
			)
			(4
				(= cycles 2)
			)
			(5
				(DisposeScript 781)
				(= seconds 2)
			)
			(6
				(= cycles 2)
			)
			(7
				(gCurRoom setInset: daggerInset self)
			)
			(8
				(= seconds 3)
			)
			(9
				(= gQuit 1)
			)
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties)

	(method (init)
		(= wrapSound creditSound)
		(super init: &rest)
	)
)

(instance creditSound of Sound
	(properties)
)

(instance daggerEnd of View
	(properties
		x 88
		y 85
		view 401
		cel 1
	)

	(method (doVerb)
		(daggerInset doVerb: &rest)
	)
)

(instance daggerInset of Inset
	(properties
		picture 401
	)

	(method (handleEvent event)
		(gGame handsOff:)
		(event claimed: 1)
		(daggerEnd dispose:)
		(self dispose:)
	)

	(method (init)
		(super init: &rest)
		(daggerEnd init:)
		(gGame handsOn:)
		(gTheIconBar enable:)
	)
)

