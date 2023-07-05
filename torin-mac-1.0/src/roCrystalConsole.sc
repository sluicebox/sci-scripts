;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15600)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use foEExit)
(use Array)
(use Feature)
(use Motion)
(use Actor)

(public
	roCrystalConsole 0
)

(local
	oPatternArray
	oStoneArray
	nStonesMoving
)

(procedure (DrawConsole &tmp curPattern)
	(= curPattern (oPatternArray at: goConsolePattern))
	((curPattern at: 0) posn: 209 265)
	((curPattern at: 1) posn: 273 247)
	((curPattern at: 2) posn: 342 267)
	((curPattern at: 3) posn: 409 249)
)

(procedure (ToggleStones stoneIndices &tmp i)
	(goSound1 stop:)
	(= nStonesMoving 0)
	(for ((= i 0)) (< i argc) ((++ i))
		(((oStoneArray at: goConsolePattern) at: (- [stoneIndices i] 1)) toggle:)
	)
)

(instance foPhenocryst of Feature
	(properties
		nsLeft 451
		nsRight 564
		nsBottom 150
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gMessager say: 6 1 6 0 0 15200) ; "That big crystal must be the portal to the next world."
	)
)

(instance foPodium of Feature
	(properties
		nsLeft 93
		nsTop 125
		nsRight 200
		nsBottom 154
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gMessager say: 4 1 6 0 0 15200) ; "All I have to do is lower all of those stones."
	)
)

(class StonePillar of Prop
	(properties
		flag 0
	)

	(method (init)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: flag) ; oFlags
			(self setCel: 0)
		else
			(self setCel: (self lastCel:))
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gMessager say: 4 1 6 0 0 15200) ; "All I have to do is lower all of those stones."
	)

	(method (toggle)
		(++ nStonesMoving)
		(if (not (goSound1 isPlaying:))
			(goSound1 playSound: 15201)
		)
		(if ((ScriptID 64017 0) test: flag) ; oFlags
			(self setCycle: End oTestForWin)
			((ScriptID 64017 0) clear: flag) ; oFlags
		else
			(self setCycle: Beg oTestForWin)
			((ScriptID 64017 0) set: flag) ; oFlags
		)
	)
)

(instance poStone1 of StonePillar
	(properties
		x 163
		y 127
		view 15202
		loop 4
		cycleSpeed 8
		flag 40
	)
)

(instance poStone2 of StonePillar
	(properties
		x 164
		y 125
		view 15202
		loop 5
		cycleSpeed 8
		flag 41
	)

	(method (init)
		(super init: &rest)
		(self setPri: 128)
	)
)

(instance poStone3 of StonePillar
	(properties
		x 184
		y 133
		view 15202
		loop 6
		cycleSpeed 8
		flag 42
	)
)

(instance poStone4 of StonePillar
	(properties
		x 138
		y 144
		view 15202
		loop 7
		cycleSpeed 8
		flag 43
	)
)

(instance poFont of Prop
	(properties
		x 72
		y 139
		view 15202
		loop 8
	)
)

(instance oEarlyTestForWin of CueMe
	(properties)

	(method (cue)
		(if
			(and
				((ScriptID 64017 0) test: 40) ; oFlags
				((ScriptID 64017 0) test: 41) ; oFlags
				((ScriptID 64017 0) test: 42) ; oFlags
				((ScriptID 64017 0) test: 43) ; oFlags
			)
			(gGame handsOff:)
		)
	)
)

(instance oTestForWin of CueMe
	(properties)

	(method (cue)
		(if (== (-- nStonesMoving) 0)
			(goSound1 stop:)
		)
		(if
			(and
				(== 0 (poStone1 cel:))
				(== 0 (poStone2 cel:))
				(== 0 (poStone3 cel:))
				(== 0 (poStone4 cel:))
			)
			((ScriptID 64017 0) set: 44) ; oFlags
			(gCurRoom setScript: soPuzzleSolved)
		)
	)
)

(instance soPuzzleSolved of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poFont init: setCycle: End self)
				(goSound1 playSound: 15201)
			)
			(1
				(gCurRoom newRoom: 15200) ; roPortalChamber
			)
		)
	)
)

(instance oClick of TPSound
	(properties)
)

(instance voRed of View
	(properties
		view 15202
		loop 3
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 22)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; ioConsoleShard
				(ToggleStones 1 2)
				(voShard init: x y loop)
				(oClick playSound: 15204)
				(oEarlyTestForWin cue:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voGreen of View
	(properties
		view 15202
		loop 2
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 22)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; ioConsoleShard
				(ToggleStones 1 3 4)
				(voShard init: x y loop)
				(oClick playSound: 15204)
				(oEarlyTestForWin cue:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voBlue of View
	(properties
		view 15202
		loop 1
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 22)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; ioConsoleShard
				(ToggleStones 2 3)
				(voShard init: x y loop)
				(oClick playSound: 15204)
				(oEarlyTestForWin cue:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voWhite of View
	(properties
		view 15202
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 22)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; ioConsoleShard
				(= goConsolePattern (mod (+ goConsolePattern 1) 4))
				(voShard init: x y (voRed loop:))
				(DrawConsole)
				(oClick playSound: 15204)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voShard of View
	(properties
		view 15202
	)

	(method (init nX nY nLoop &tmp nSlot)
		(= loop nLoop)
		(self posn: nX nY)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self setPri: 500)
		(cond
			((== nX 209)
				(= nSlot 0)
			)
			((== nX 273)
				(= nSlot 1)
			)
			((== nX 342)
				(= nSlot 2)
			)
			(else
				(= nSlot 3)
			)
		)
		(((ScriptID 64001 0) get: 12) moveTo: nSlot) ; oInvHandler, ioConsoleShard
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(oClick playSound: 15205)
				(((ScriptID 64001 0) get: 12) moveTo: -2) ; oInvHandler, ioConsoleShard
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foExit of CUExitFeature
	(properties
		rExitTo 15200
	)

	(method (doVerb)
		((ScriptID 64017 0) clear: 39) ; oFlags
		(super doVerb: &rest)
	)
)

(instance roCrystalConsole of TPRoom
	(properties
		picture 15600
		east 15200
		west 15200
	)

	(method (init &tmp patternA patternB patternC patternD stoneA stoneB stoneC stoneD curPattern)
		((ScriptID 64017 0) set: 39) ; oFlags
		(goMusic1 setMusic: 15600)
		(Load rsAUDIO 15204 15201)
		(= patternA (IDArray with: voRed voGreen voBlue voWhite))
		(= patternB (IDArray with: voGreen voBlue voWhite voRed))
		(= patternC (IDArray with: voBlue voWhite voRed voGreen))
		(= patternD (IDArray with: voWhite voRed voGreen voBlue))
		(= oPatternArray (IDArray with: patternA patternB patternC patternD))
		(= stoneA (IDArray with: poStone1 poStone2 poStone3 poStone4))
		(= stoneB (IDArray with: poStone4 poStone1 poStone2 poStone3))
		(= stoneC (IDArray with: poStone3 poStone4 poStone1 poStone2))
		(= stoneD (IDArray with: poStone2 poStone3 poStone4 poStone1))
		(= oStoneArray (IDArray with: stoneA stoneB stoneC stoneD))
		(super init: &rest)
		(gGame handsOn:)
		(foPhenocryst init:)
		(foPodium init:)
		(poStone1 init:)
		(poStone2 init:)
		(poStone3 init:)
		(poStone4 init:)
		(voRed init:)
		(voGreen init:)
		(voBlue init:)
		(voWhite init:)
		(foExit init:)
		(DrawConsole)
		(if (>= (((ScriptID 64001 0) get: 12) owner:) 0) ; oInvHandler, ioConsoleShard
			(= curPattern (oPatternArray at: goConsolePattern))
			(switch (((ScriptID 64001 0) get: 12) owner:) ; oInvHandler, ioConsoleShard
				(0
					(voShard init: 209 265 ((curPattern at: 0) loop:))
				)
				(1
					(voShard init: 273 247 ((curPattern at: 1) loop:))
				)
				(2
					(voShard init: 342 267 ((curPattern at: 2) loop:))
				)
				(3
					(voShard init: 409 249 ((curPattern at: 3) loop:))
				)
			)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 12)) ; oInvHandler, ioConsoleShard
	)
)

