;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use LightRoom)
(use PanelPlane)
(use Feature)
(use Sound)
(use Motion)
(use Actor)

(public
	rm600 0
)

(instance rm600 of LightRoom
	(properties
		picture 603
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(Load rsAUDIO 60104 604)
		(gBackMusic number: 60104 play: setLoop: -1 setVol: 127)
		(gMySoundFX number: 604 setVol: 127 play: setLoop: -1)
		(if (== gPrevRoomNum 610) ; rmWoodshop
			(doorCloseSound play:)
			(if (== global226 3)
				(self changeScene: 609 3)
			else
				(self changeScene: 4609 3)
			)
		else
			(self changeScene: 603 1)
		)
	)

	(method (dispose)
		(gBackMusic fade:)
		(gMySoundFX fade:)
		(super dispose:)
	)

	(method (changeScene param1)
		(gCast eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(super changeScene: param1 &rest)
		(switch param1
			(601
				(proc0_9 601)
				(pole601 init:)
				(if (== global226 3)
					((ScriptID 1 4) newPic: 608 3) ; exitRight
				)
				((ScriptID 1 3) newPic: 607 7) ; exitLeft
				(poleFeature
					nsLeft: 187
					nsTop: 19
					nsRight: 287
					nsBottom: 192
					init:
				)
			)
			(602
				(door init:)
				((ScriptID 1 3) init: exitCode: doorExitCode) ; exitLeft
			)
			(603
				(proc0_9 603)
				((ScriptID 1 5) newRoom: 212) ; exitDown
				((ScriptID 1 4) newPic: 604 7) ; exitRight
				((ScriptID 1 3) newPic: 606 3) ; exitLeft
				((ScriptID 1 2) newPic: 605 5) ; exitBack
			)
			(604
				((ScriptID 1 5) ; exitDown
					init:
					nsLeft: 61
					nsTop: 166
					nsBottom: 297
					nsRight: 210
					newRoom: 212
				)
				(proc0_9 604)
				((ScriptID 1 4) newPic: 605 5) ; exitRight
				((ScriptID 1 3) newPic: 603 1) ; exitLeft
				((ScriptID 1 2) newPic: 606 3) ; exitBack
				((ScriptID 1 1) newPic: 607 7) ; exitForward
			)
			(605
				(fishingPole605 init:)
				(proc0_9 605)
				((ScriptID 1 4) newPic: 606 3) ; exitRight
				((ScriptID 1 3) newPic: 604 7) ; exitLeft
				((ScriptID 1 2) newPic: 603 1) ; exitBack
			)
			(606
				(proc0_9 606)
				((ScriptID 1 5) ; exitDown
					init:
					newRoom: 212
					nsLeft: 262
					nsTop: 173
					nsRight: 490
					nsBottom: 295
				)
				((ScriptID 1 4) newPic: 603 1) ; exitRight
				((ScriptID 1 3) newPic: 605 5) ; exitLeft
				((ScriptID 1 2) newPic: 604 7) ; exitBack
			)
			(607
				(proc0_9 607)
				((ScriptID 1 1) newPic: 602 8) ; exitForward
				(if (== global226 3)
					((ScriptID 1 2) newPic: 608 3) ; exitBack
				)
				((ScriptID 1 4) newPic: 601 5) ; exitRight
			)
			(608
				((ScriptID 1 3) newPic: 601 5) ; exitLeft
				(proc0_9 608)
				((ScriptID 1 1) newPic: 606 3) ; exitForward
				((ScriptID 1 2) newPic: 607 7) ; exitBack
			)
			(609
				(proc0_9 609)
				(fishingPole609 init:)
				((ScriptID 1 1) arrowStyle: 7 newPic: 608 3 nsRight: 451) ; exitForward
				((ScriptID 1 2) newPic: 602 8) ; exitBack
			)
			(4609
				(proc0_9 4609)
				(fishingPole4609 init:)
				((ScriptID 1 2) newPic: 602 8) ; exitBack
				((ScriptID 1 3) newPic: 601 5) ; exitLeft
			)
		)
	)
)

(instance poleInset of PanelProp
	(properties
		view 4634
		loop 1
	)

	(method (cue)
		(gInventory addItem: (ScriptID 9 68)) ; invFish
		(fishSound play:)
		(gGame handsOn:)
		(pole601 setCycle: 0 setCel: 0)
		(polePanel dispose:)
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(approachX hotVerbs: 0)
	)
)

(instance pole601 of Prop
	(properties
		x 225
		y 195
		view 601
	)

	(method (init)
		(super init: &rest)
		(self
			setPri: 500
			setCycle:
				(if (or (IsFlag 265) (gInventory contains: (ScriptID 9 68))) ; invFish
					0
				else
					Fwd
				)
		)
		(approachX hotVerbs: 0)
	)
)

(instance fishingPole605 of Prop
	(properties
		x 72
		y 168
		view 4631
	)

	(method (init)
		(super init: &rest)
		(self
			setPri: 500
			setCycle:
				(if (or (IsFlag 265) (gInventory contains: (ScriptID 9 68))) ; invFish
					0
				else
					Fwd
				)
		)
		(approachX hotVerbs: 0)
	)
)

(instance fishingPole609 of Prop
	(properties
		x -1
		y 173
		view 4633
	)

	(method (init)
		(super init: &rest)
		(self
			setPri: 500
			setCycle:
				(if (or (IsFlag 265) (gInventory contains: (ScriptID 9 68))) ; invFish
					0
				else
					Fwd
				)
		)
		(approachX hotVerbs: 0)
	)
)

(instance fishingPole4609 of Prop
	(properties
		x -1
		y 173
		view 4609
	)

	(method (init)
		(super init: &rest)
		(self
			setPri: 500
			setCycle:
				(if (or (IsFlag 265) (gInventory contains: (ScriptID 9 68))) ; invFish
					0
				else
					Fwd
				)
		)
		(approachX hotVerbs: 0)
	)
)

(instance door of Prop
	(properties
		x 227
		y 275
		view 610
	)

	(method (cue)
		(gGame handsOn:)
		((ScriptID 1 1) ; exitForward
			init:
			nsLeft: 210
			nsTop: 34
			nsRight: 302
			nsBottom: 235
			newRoom: 610 ; rmWoodshop
		)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (== cel 0)) ; Do
			(gGame handsOff:)
			(doorOpenSound play:)
			(self setCycle: End self)
		)
	)
)

(instance poleFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 5) ; Do
				(not (IsFlag 265))
				(not (gInventory contains: (ScriptID 9 68))) ; invFish
			)
			(polePanel init:)
		)
	)
)

(instance reel of PanelFeature
	(properties
		nsLeft 10
		nsTop 128
		nsRight 47
		nsBottom 170
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
		(global105 delete: approachX)
		(global105 addToFront: approachX)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(reelSound play:)
			(poleInset setLoop: 0 setCel: 0 setCycle: End poleInset)
		)
	)
)

(instance forwardLeft of ExitFeature ; UNUSED
	(properties)

	(method (init)
		(= arrowStyle 8)
		(= nsTop (= nsLeft 0))
		(= nsBottom 200)
		(= nsRight 170)
		(super init: &rest)
	)
)

(instance forwardRight of ExitFeature ; UNUSED
	(properties)

	(method (init)
		(= arrowStyle 7)
		(= nsTop 0)
		(= nsLeft 299)
		(= nsBottom 200)
		(= nsRight 499)
		(super init: &rest)
	)
)

(instance polePanel of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 606 503)
		(poleInset init: self 1 0)
		(reel init: self 1 1)
	)
)

(instance doorExitCode of ExitCode
	(properties)

	(method (cue)
		(gCurRoom compassDir: 3)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(if (== global226 3)
			(= nextScene 609)
		else
			(= nextScene 4609)
		)
		(gGame handsOff:)
		(if (!= (door cel:) 0)
			(doorCloseSound play:)
			(door setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance reelSound of Sound
	(properties
		flags 1
		number 606
	)
)

(instance doorOpenSound of Sound
	(properties
		flags 1
		number 60401
	)
)

(instance doorCloseSound of Sound
	(properties
		flags 1
		number 60402
	)
)

(instance fishSound of Sound
	(properties
		flags 1
		number 503
	)
)

