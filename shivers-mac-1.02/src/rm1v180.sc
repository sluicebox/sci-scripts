;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1180)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm1v180 0
)

(instance rm1v180 of ShiversRoom
	(properties
		picture 1182
	)

	(method (init &tmp temp0 temp1)
		(if (IsFlag 0)
			(efExitForward init: 9)
		)
		(water init:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
		(= temp1 (Random 1 30))
		(= temp0 (Random 5 10))
		(cond
			((< 0 temp1 4)
				(gSounds playChain: -1 temp0 10116 0)
				(gSounds adjChainVol: 42)
			)
			((< 3 temp1 7)
				(gSounds playChain: -1 temp0 10117 0)
				(gSounds adjChainVol: 42)
			)
			((< 6 temp1 10)
				(gSounds playChain: -1 temp0 10118 0)
				(gSounds adjChainVol: 42)
			)
			((< 9 temp1 13)
				(gSounds playChain: -1 temp0 10120 0)
				(gSounds adjChainVol: 42)
			)
			((< 12 temp1 16)
				(gSounds playChain: -1 temp0 10121 0)
				(gSounds adjChainVol: 42)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1181
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1181
	)

	(method (init)
		(self createPoly: 242 0 262 0 262 75 242 75 242 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1190
	)

	(method (init)
		(self
			createPoly: 167 130 194 121 232 110 221 81 263 81 263 132 229 143 166 141
		)
		(super init: &rest)
	)
)

(instance water of Prop
	(properties
		priority 255
		fixPriority 1
		view 1182
		loop 1
	)

	(method (init)
		(if (IsFlag 0)
			(self loop: 0)
		)
		(self cycleSpeed: 14 setCycle: Fwd)
		(super init: &rest)
	)
)

