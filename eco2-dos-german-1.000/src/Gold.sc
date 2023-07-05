;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 899)
(include sci.sh)
(use Main)
(use invSetupCode)
(use Flags)
(use Game)
(use System)

(public
	Gold 0
	goldFlags 1
)

(class Gold of Rgn
	(properties
		keep 1
		puz0Stat 0
		puz1Stat 0
		puz2Stat 0
		puz3Stat 0
		puz4Stat 0
		puz5Stat 0
		puz6Stat 0
		puz7Stat 0
		puz8Stat 0
		panelStat 0
	)

	(method (init)
		(super init:)
		((ScriptID 93 0) init:) ; loadCode4
		((ScriptID 94 0) init:) ; loadCode5
		((ScriptID 95 0) init:) ; loadCode6
		((ScriptID 90 0) init:) ; loadCode1
		(gInventory add: discPile magnifier diadem pipes seedling goldDust chalice)
		((ScriptID 99 0) doit: 118) ; invSetupCode
		((ScriptID 99 1) init:) ; invBitCode
		(= gCurrentRegionFlags goldFlags)
		(= puz0Stat (Random 0 2))
		(= puz1Stat (Random 0 2))
		(= puz2Stat (Random 0 2))
		(= puz3Stat (Random 0 2))
		(= puz4Stat (Random 0 2))
		(= puz5Stat (Random 0 2))
		(= puz6Stat (Random 0 2))
		(= puz7Stat (Random 0 2))
		(= puz8Stat (Random 0 2))
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 800 840 820 860 870 880))
			(self keep: 0)
			((ScriptID 99 1) doit:) ; invBitCode
			(gInventory delete: diadem pipes seedling chalice)
			((ScriptID 93 0) dispose:) ; loadCode4
			((ScriptID 94 0) dispose:) ; loadCode5
			((ScriptID 95 0) dispose:) ; loadCode6
			((ScriptID 90 0) dispose:) ; loadCode1
			(goldFlags dispose:)
		)
	)
)

(instance diadem of EcoInvI
	(properties
		loop 6
		cel 2
		message 49
		noun 48
	)
)

(instance pipes of EcoInvI
	(properties
		loop 6
		cel 3
		message 50
		noun 49
	)
)

(instance seedling of EcoInvI
	(properties
		loop 6
		cel 4
		message 51
		noun 50
	)
)

(instance discPile of EcoInvI
	(properties
		loop 8
		cel 2
		message 9
		noun 51
	)
)

(instance magnifier of EcoInvI
	(properties
		loop 8
		cel 9
		message 10
		noun 47
	)
)

(instance goldDust of EcoInvI
	(properties
		loop 6
		message 22
		noun 59
	)
)

(instance chalice of EcoInvI
	(properties
		loop 8
		message 64
		noun 62
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((and (gCurrentRegionFlags test: 3) (gCurrentRegionFlags test: 4))
						(gMessager say: noun theVerb 2 1 0 99) ; "The stone cup has a yellowish stain inside."
					)
					((gCurrentRegionFlags test: 3)
						(gMessager say: noun theVerb 3 1 0 99) ; "The stone cup has a yellowish stain inside. There is also a crumbled blossom inside."
					)
					((gCurrentRegionFlags test: 4)
						(gMessager say: noun theVerb 4 1 0 99) ; MISSING MESSAGE
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(27 ; goldenBlossom
				(gCurRoom setScript: chaliceScript 0 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goldFlags of Flags
	(properties
		size 36
	)
)

(instance chaliceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 4)
				(gCurrentRegionFlags set: 3)
				(gGame points: 5)
				(gMessager say: 62 27 0 0 self 99) ; "Adam carefully puts the dry blossom in the cup. When it touches the rough surface of the stone, it crumbles to a powder."
			)
			(1
				(gInventory hide:)
				(gInventory curIcon: (gInventory selectIcon:))
				(gGame setCursor: ((gInventory curIcon:) cursor:))
				(gInventory show:)
				(self dispose:)
			)
		)
	)
)

