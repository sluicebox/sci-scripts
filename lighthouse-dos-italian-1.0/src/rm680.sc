;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use LightRoom)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm680 0
)

(local
	local0
)

(instance rm680 of LightRoom
	(properties
		picture 677
	)

	(method (init &tmp temp0)
		(= temp0 (Random 60101 60103))
		(Load rsAUDIO 624 temp0)
		(gBackMusic number: temp0 play: setLoop: -1 setVol: 127)
		(super init: &rest)
		(if (== gPrevRoomNum 260)
			(self changeScene: 677 7)
		else
			(self changeScene: 685 1)
		)
		(otherDoorClose play:)
	)

	(method (newRoom)
		(gBackMusic fade:)
		(super newRoom: &rest)
	)

	(method (changeScene param1)
		(gCast eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(super changeScene: param1 &rest)
		(switch param1
			(676
				(leftForward
					init:
					resetProps:
					newPic: 679 10
					arrowStyle: 3
					nsLeft: 60
				)
				((ScriptID 1 3) newPic: 687 5) ; exitLeft
				(rightForward init: resetProps: newPic: 678 11 arrowStyle: 3)
				((ScriptID 1 2) newPic: 683 7) ; exitBack
			)
			(677
				(rightForward
					init:
					resetProps:
					newPic: 682 8
					nsRight: 439
					arrowStyle: 3
				)
				(leftForward init: newPic: 681 15 arrowStyle: 3)
				((ScriptID 1 4) newPic: 687 5) ; exitRight
				((ScriptID 1 5) init: newPic: 686 7) ; exitDown
				((ScriptID 1 2) newPic: 680 3) ; exitBack
			)
			(678
				((ScriptID 1 1) ; exitForward
					newPic: 680 3
					nsLeft: 242
					nsTop: 1
					nsRight: 347
					nsBottom: 294
				)
				(leftForward
					init:
					newPic: 682 8
					nsLeft: 141
					nsTop: 1
					nsRight: 236
					nsBottom: 293
				)
				((ScriptID 1 2) newPic: 681 15) ; exitBack
			)
			(679
				((ScriptID 1 1) newPic: 680 3) ; exitForward
				(rightForward
					init:
					newPic: 681 15
					nsLeft: 250
					nsTop: 1
					nsRight: 378
					nsBottom: 293
				)
				((ScriptID 1 4) newPic: 682 8) ; exitRight
				((ScriptID 1 3) ; exitLeft
					newPic: 687 5
					nsRight: 131
					nsTop: 0
					nsLeft: 0
					nsBottom: 293
				)
				((ScriptID 1 2) newPic: 687 5) ; exitBack
			)
			(680
				(Load rsVIEW 2189)
				(door init:)
				(if (not (IsFlag 291))
					((ScriptID 1 2) newPic: 677 7) ; exitBack
				else
					((ScriptID 1 2) init: exitCode: backFrom680) ; exitBack
				)
			)
			(681
				(rightForward init: resetProps: newPic: 683 7)
				((ScriptID 1 2) newPic: 678 11) ; exitBack
			)
			(682
				((ScriptID 1 4) newPic: 687 5) ; exitRight
				((ScriptID 1 3) newPic: 679 10) ; exitLeft
				(rightForward init: newPic: 683 7 arrowStyle: 3)
				(leftForward
					init:
					nsLeft: 146
					nsTop: 1
					nsRight: 256
					nsBottom: 291
					newPic: 678 11
				)
				((ScriptID 1 2) newPic: 687 5) ; exitBack
			)
			(683
				((ScriptID 1 6) init: nsTop: 30 newPic: 684 7) ; exitUp
				((ScriptID 1 2) newPic: 676 3) ; exitBack
			)
			(684
				((ScriptID 1 6) init: resetProps: newPic: 3632 3) ; exitUp
				((ScriptID 1 5) newPic: 683 7) ; exitDown
			)
			(685
				(leftForward init: resetProps: newPic: 679 10)
				(rightForward init: resetProps: newPic: 682 8)
				((ScriptID 1 2) newPic: 687 5) ; exitBack
			)
			(686
				(Load rsAUDIO 623)
				((ScriptID 1 6) init: resetProps: exitCode: moveUpCode) ; exitUp
				((ScriptID 1 2) init: resetProps: exitCode: backExitCode) ; exitBack
				(keyHole init:)
				(slidingPanel init:)
			)
			(687
				(Load rsAUDIO 62310)
				(otherDoor init:)
				((ScriptID 1 4) init: exitCode: rightExit687) ; exitRight
				((ScriptID 1 3) init: exitCode: leftExit687) ; exitLeft
				((ScriptID 1 2) init: exitCode: backExit687) ; exitBack
			)
			(3628
				((ScriptID 1 5) ; exitDown
					init:
					newPic: 683 7
					nsTop: 0
					nsRight: 407
					nsLeft: 148
				)
				((ScriptID 1 2) newPic: 3632 3) ; exitBack
			)
			(3630
				(if (IsFlag 265)
					(fish view: 4630 x: 265 y: 78 init: setCycle: Fwd)
				else
					(fishSpot init:)
				)
				((ScriptID 1 5) ; exitDown
					init:
					newPic: 3632 3
					nsBottom: 294
					nsLeft: 0
					nsRight: 639
				)
			)
			(3632
				(cond
					((gFeatures contains: fishSpot)
						(fishSpot dispose:)
					)
					((IsFlag 265)
						(fish view: 4632 x: 234 y: 64 init: setCycle: Fwd)
					)
				)
				((ScriptID 1 6) init: newPic: 3630 3) ; exitUp
				((ScriptID 1 2) newPic: 3628 7) ; exitBack
			)
		)
	)
)

(instance showMonster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(door hide:)
				(gMySoundFX number: 500 setLoop: 0 play:)
				(gBackMusic pause: 1)
				(KillRobot 189 4 0)
			)
			(1
				(fortDoor init: setPri: 400)
			)
			(2
				(fortDoor dispose:)
			)
			(3
				(gBackMusic pause: 0)
				(gMySoundFX number: 502 setLoop: 0 play:)
				(door show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorSound play:)
				(door setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance openPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 504)
				(gGame handsOff:)
				(keyHole dispose:)
				(keyProp init: setCycle: CT 7 1 self)
			)
			(1
				(newKeySound play:)
				(keyProp setCycle: End self)
			)
			(2
				(keyProp dispose:)
				(gunPart init:)
				(panelSound play:)
				(slidingPanel setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gunPart of View
	(properties
		x 247
		y 248
		loop 2
		view 690
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gInventory addItem: (ScriptID 9 58) deleteItem: (ScriptID 9 75)) ; invVacuumPump, invStatueKey
			(self dispose:)
		)
	)
)

(instance slidingPanel of Prop
	(properties
		x 219
		y 249
		view 690
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(dongSound play:)
		)
	)
)

(instance panelSound of Sound
	(properties
		number 623
		flags 1
	)
)

(instance keyProp of Prop
	(properties
		x 348
		y 288
		loop 1
		view 690
	)

	(method (init)
		(= cel 0)
		(super init: &rest)
	)
)

(instance fortDoor of Prop
	(properties
		x 142
		y 299
		view 2189
	)
)

(instance door of Prop
	(properties
		x 157
		y 299
		view 680
	)

	(method (cue)
		(gGame handsOn:)
		((ScriptID 1 1) newRoom: 260) ; exitForward
	)

	(method (init)
		(= local0 (= cel 0))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((not (IsFlag 291))
					(gCurRoom setScript: showMonster)
				)
				((not local0)
					(gGame handsOff:)
					(doorSound number: 62306 play:)
					(self setCycle: End self)
					(= local0 1)
				)
				(else
					(gGame handsOff:)
					(doorSound number: 62307 play:)
					(= local0 0)
					(self setCycle: Beg self)
				)
			)
		)
	)
)

(instance doorSound of Sound
	(properties
		number 62306
		flags 1
	)
)

(instance otherDoor of Prop
	(properties
		x 144
		y 299
		view 689
	)

	(method (cue)
		(gGame handsOn:)
		((ScriptID 1 1) newRoom: 630 arrowStyle: 6) ; exitForward, rmWindPower
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 5) (== cel 0)) ; Do
			(doorSound2 play:)
			(gGame handsOff:)
			(proc0_9 688 140 99)
			(self setCycle: End self)
		)
	)
)

(instance fish of Prop
	(properties)
)

(instance rightForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 7)
		(= nsLeft 299)
		(= nsTop 0)
		(= nsRight 499)
		(= nsBottom 299)
		(super init: &rest)
	)
)

(instance leftForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(= nsTop (= nsLeft 0))
		(= nsRight 140)
		(= nsBottom 299)
		(super init: &rest)
	)
)

(instance fishSpot of Feature
	(properties
		nsBottom 122
		nsLeft 196
		nsRight 304
		nsTop 19
	)

	(method (doVerb theVerb)
		(if (== theVerb 20) ; invFish
			(fish view: 4630 x: 265 y: 78 init: setCycle: Fwd)
			(SetFlag 265)
			(fishSound play:)
			(gInventory deleteItem: (ScriptID 9 68)) ; invFish
			(self dispose:)
		)
	)
)

(instance keyHole of Feature
	(properties
		nsBottom 211
		nsLeft 241
		nsRight 279
		nsTop 183
	)

	(method (doVerb theVerb)
		(if (== theVerb 86) ; invStatueKey
			(gCurRoom setScript: openPanel)
		)
	)
)

(instance backFrom680 of ExitCode
	(properties)

	(method (cue)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 677)
		(if (!= (door cel:) 0)
			(otherDoorClose play:)
			(door setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance leftExit687 of ExitCode
	(properties)

	(method (cue)
		(gGame handsOn:)
		(gCurRoom compassDir: 8)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 8 setCel: 0)
		)
		(super cue:)
	)

	(method (doit)
		(= nextScene 682)
		(gGame handsOff:)
		(if (!= (otherDoor cel:) 0)
			(otherDoorClose play:)
			(otherDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance backExit687 of ExitCode
	(properties)

	(method (cue)
		(gGame handsOn:)
		(gCurRoom compassDir: 1)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 1 setCel: 0)
		)
		(super cue:)
	)

	(method (doit)
		(= nextScene 685)
		(gGame handsOff:)
		(if (!= (otherDoor cel:) 0)
			(otherDoorClose play:)
			(otherDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance rightExit687 of ExitCode
	(properties)

	(method (cue)
		(gGame handsOn:)
		(gCurRoom compassDir: 10)
		(if (gGame compassFace:)
			((gGame compassFace:) setLoop: 10 setCel: 0)
		)
		(super cue:)
	)

	(method (doit)
		(= nextScene 679)
		(gGame handsOff:)
		(if (!= (otherDoor cel:) 0)
			(otherDoorClose play:)
			(otherDoor setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance moveUpCode of ExitCode
	(properties)

	(method (cue)
		(if (gInventory contains: (ScriptID 9 58)) ; invVacuumPump
			(gInventory deleteItem: (ScriptID 9 75)) ; invStatueKey
		)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 677)
		(gGame handsOff:)
		(if (!= (slidingPanel cel:) 0)
			(panelSound play:)
			(slidingPanel setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance backExitCode of ExitCode
	(properties)

	(method (cue)
		(if (gInventory contains: (ScriptID 9 58)) ; invVacuumPump
			(gInventory deleteItem: (ScriptID 9 75)) ; invStatueKey
		)
		(gCurRoom compassDir: 3)
		(gGame handsOn:)
		(super cue:)
	)

	(method (doit)
		(= nextScene 680)
		(gGame handsOff:)
		(if (!= (slidingPanel cel:) 0)
			(panelSound play:)
			(slidingPanel setCycle: Beg self)
		else
			(self cue:)
		)
	)
)

(instance windSound of Sound ; UNUSED
	(properties
		number 624
		flags 1
		loop -1
	)
)

(instance fishSound of Sound
	(properties
		number 503
		flags 1
	)
)

(instance dongSound of Sound
	(properties
		number 776
		flags 1
	)
)

(instance doorSound2 of Sound
	(properties
		number 62309
		flags 1
	)
)

(instance otherDoorClose of Sound
	(properties
		number 62310
		flags 1
	)
)

(instance newKeySound of Sound
	(properties
		number 504
		flags 1
	)
)

