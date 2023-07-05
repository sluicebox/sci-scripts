;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(class SwitchView of Prop
	(properties
		myFlag -1
		offCel 1
		dontForce 0
	)

	(method (init)
		(super init: &rest)
		(self signal: (& (self signal:) $efff))
		(self initialCel:)
	)

	(method (initialCel)
		(cond
			((self on:)
				(self cel: (self lastCel:) show:)
			)
			(offCel
				(= cel 0)
			)
			(else
				(self hide:)
			)
		)
	)

	(method (toggle param1 &tmp temp0)
		(cond
			((and argc param1)
				(= temp0 1)
			)
			((and argc (not param1))
				(= temp0 0)
			)
			((self on:)
				(= temp0 0)
			)
			(else
				(= temp0 1)
			)
		)
		(if temp0
			(if (not dontForce)
				(self cel: (self lastCel:))
			)
			(self show:)
			(if (!= myFlag -1)
				(SetFlag myFlag)
			)
			(return 1)
		else
			(if offCel
				(if (not dontForce)
					(= cel 0)
				)
			else
				(self hide:)
			)
			(if (!= myFlag -1)
				(ClearFlag myFlag)
			)
			(return 0)
		)
	)

	(method (quickToggle)
		(self toggle: setScript: (sQuickToggle new:))
	)

	(method (on)
		(return
			(if (== myFlag -1)
				0
			else
				(IsFlag myFlag)
			)
		)
	)
)

(instance sQuickToggle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(client cel: 0)
				(self dispose:)
			)
		)
	)
)

