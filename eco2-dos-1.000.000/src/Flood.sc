;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 799)
(include sci.sh)
(use Main)
(use invSetupCode)
(use LoadMany)
(use Flags)
(use Sound)
(use Game)
(use System)

(public
	Flood 0
	floodFlags 1
)

(class Flood of Rgn
	(properties
		keep 1
	)

	(method (init)
		(super init:)
		((ScriptID 93 0) init:) ; loadCode4
		((ScriptID 94 0) init:) ; loadCode5
		((ScriptID 95 0) init:) ; loadCode6
		((ScriptID 96 0) init:) ; loadCode7
		((ScriptID 90 0) init:) ; loadCode1
		(gInventory add: fruit)
		((ScriptID 99 0) doit: 118) ; invSetupCode
		((ScriptID 99 1) init:) ; invBitCode
		(= gCurrentRegionFlags floodFlags)
		(LoadMany rsVIEW 10 13)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 700 701 702 730))
			(self keep: 0)
			((ScriptID 99 1) doit:) ; invBitCode
			(gInventory delete: fruit)
			((ScriptID 93 0) dispose:) ; loadCode4
			((ScriptID 94 0) dispose:) ; loadCode5
			((ScriptID 95 0) dispose:) ; loadCode6
			((ScriptID 96 0) dispose:) ; loadCode7
			((ScriptID 90 0) dispose:) ; loadCode1
			(Lock rsVIEW 10 0)
			(Lock rsVIEW 13 0)
			(floodFlags dispose:)
		)
	)

	(method (onMe)
		(if (gFeatures contains: (ScriptID 98 0)) ; debugRm
			(gFeatures delete: (ScriptID 98 0)) ; debugRm
			((ScriptID 98 0) dispose:) ; debugRm
		)
		(if
			(not
				(or
					(gAddToPics firstTrue: #onMe gMouseX gMouseY)
					(gCast firstTrue: #onMe gMouseX gMouseY)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 14))
			(self perform: gCheckEcorderIcon self)
		)
		(cond
			((IsFlag 5) 0)
			((== gCurRoomNum 730)
				(if (gCurRoom picture:)
					(Palette palANIMATE 72 77 2)
				else
					(Palette palANIMATE 77 84 4)
				)
			)
			(else
				(Palette palANIMATE 72 79 2 80 87 3)
			)
		)
		(if (not (gCurrentRegionFlags test: 12))
			(if (not (gEgo mover:))
				(gEgo cycleSpeed: (Max 6 global136))
			else
				(gEgo cycleSpeed: global136)
			)
		)
		(if
			(and
				(not (gCurRoom script:))
				(gEgo mover:)
				(OneOf (gEgo view:) 10 702)
				(OneOf (gEgo cel:) 0 3)
			)
			(sFX stop: number: 714 setLoop: 1 play:)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (IsEcorderFlag 14))
			(self perform: gWriteEcorderData theVerb 14)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fruit of EcoInvI
	(properties
		loop 8
		cel 7
		message 12
		noun 13
	)
)

(instance floodFlags of Flags
	(properties
		size 36
	)
)

(instance sFX of Sound
	(properties)
)

