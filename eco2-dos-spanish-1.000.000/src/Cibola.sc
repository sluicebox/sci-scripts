;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 599)
(include sci.sh)
(use Main)
(use invSetupCode)
(use Flags)
(use Game)
(use System)

(public
	Cibola 0
	cibolaFlags 1
)

(class Cibola of Rgn
	(properties
		keep 1
		monitorOne 0
		monitorTwo 0
		timesCaptured 0
	)

	(method (init)
		(super init:)
		((ScriptID 93 0) init:) ; loadCode4
		((ScriptID 94 0) init:) ; loadCode5
		(gInventory
			add:
				padlockKey
				birdSeed
				metalAx
				racquet
				topSheet
				bottomSheet
				dustBuster
				suspenders
				organizer
		)
		((ScriptID 99 0) doit: 118) ; invSetupCode
		(= gCurrentRegionFlags cibolaFlags)
		((ScriptID 99 1) init:) ; invBitCode
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 530 560 500 501 580 590))
			(self keep: 0)
			((ScriptID 99 1) doit:) ; invBitCode
			((ScriptID 93 0) dispose:) ; loadCode4
			((ScriptID 94 0) dispose:) ; loadCode5
			(gInventory
				delete:
					padlockKey
					birdSeed
					metalAx
					racquet
					topSheet
					bottomSheet
					dustBuster
					suspenders
					organizer
			)
			(cibolaFlags dispose:)
		)
	)
)

(instance cibolaFlags of Flags
	(properties
		size 36
	)
)

(instance padlockKey of EcoInvI
	(properties
		loop 2
		cel 7
		message 29
		noun 28
		flag 31
	)
)

(instance birdSeed of EcoInvI
	(properties
		loop 4
		cel 3
		message 39
		noun 38
		flag 34
	)
)

(instance metalAx of EcoInvI
	(properties
		loop 4
		cel 4
		message 40
		noun 20
		flag 35
	)
)

(instance racquet of EcoInvI
	(properties
		loop 4
		cel 5
		message 41
		noun 40
		flag 36
	)
)

(instance topSheet of EcoInvI
	(properties
		loop 4
		message 37
		noun 36
		flag 32
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 38) (== message 37)) ; bottomSheet
			(gInventory hide:)
			(self cel: 2 name: {rope (was topSheet)} message: 5 noun: 53)
			(gCurrentRegionFlags set: 8)
			(gGame points: 5)
			(gEgo put: 18)
			(gInventory showSelf:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bottomSheet of EcoInvI
	(properties
		loop 4
		cel 1
		message 38
		noun 37
		flag 33
	)

	(method (doVerb theVerb)
		(if (== theVerb 37) ; topSheet
			(gInventory hide:)
			(topSheet message: 5 noun: 53 name: {rope} cel: 2)
			(gCurrentRegionFlags set: 8)
			(gGame points: 5)
			(gEgo put: 18)
			(gInventory showSelf:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dustBuster of EcoInvI
	(properties
		loop 6
		cel 10
		message 68
		noun 65
		flag 21
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if
				(and
					(gCurrentRegionFlags test: 18)
					(not (gCurrentRegionFlags test: 20))
					(not (gEgo has: 14))
				)
				(gInventory hide:)
				(gEgo get: 14)
				(gGame points: 1)
				(gInventory showSelf:)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance suspenders of EcoInvI
	(properties
		loop 8
		cel 4
		message 71
		noun 66
		flag 23
	)
)

(instance organizer of EcoInvI
	(properties
		loop 2
		cel 6
		message 28
		noun 27
		flag 24
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gInventory hide:)
			(gCurRoom setInset: (ScriptID 505)) ; anOrganizer
		else
			(super doVerb: theVerb)
		)
	)
)

