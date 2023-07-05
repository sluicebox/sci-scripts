;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29030)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm29v030 0
)

(instance rm29v030 of ShiversRoom
	(properties
		picture 29030
	)

	(method (init &tmp temp0 temp1)
		(= temp1 ((Prop new:) view: 29030 setPri: 40 1 loop: 1 init: yourself:))
		(if (IsFlag 86)
			(temp1 cel: 1)
		else
			(temp1 cel: 0)
		)
		(efExitShip init: 3)
		(efExitCamera init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (IsFlag 68)
			(= temp0 ((Prop new:) view: 29030 setPri: 30 1 init: yourself:))
			(if (== gPrevRoomNum 29045) ; rm29v045
				(gSounds play: 12901 0 82 0)
				(temp0 setCycle: End)
			else
				(temp0 cel: (temp0 lastCel:))
			)
			(UpdateScreenItem temp0)
			(UpdateScreenItem temp1)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29040
	)
)

(instance efExitShip of ExitFeature
	(properties
		nextRoom 29080
	)

	(method (init)
		(self
			createPoly:
				17
				69
				28
				63
				39
				62
				51
				62
				62
				68
				70
				81
				78
				83
				95
				90
				113
				97
				119
				103
				109
				110
				95
				117
				44
				123
				18
				125
				18
				70
		)
		(super init: &rest)
	)
)

(instance efExitCamera of ExitFeature
	(properties
		nextRoom 29520
	)

	(method (init)
		(self
			createPoly: 116 138 123 126 139 126 155 135 155 143 116 143 116 138
		)
		(super init: &rest)
	)
)

