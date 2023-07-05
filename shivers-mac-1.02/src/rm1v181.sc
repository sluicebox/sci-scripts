;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1181)
(include sci.sh)
(use Main)

(public
	rm1v181 0
)

(instance rm1v181 of ShiversRoom
	(properties
		picture 1181
	)

	(method (init &tmp temp0 temp1)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
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
		nextRoom 1180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1151
	)

	(method (init)
		(self
			createPoly:
				180
				142
				149
				120
				135
				80
				85
				80
				80
				103
				22
				95
				22
				106
				95
				126
				105
				142
		)
		(super init: &rest)
	)
)

