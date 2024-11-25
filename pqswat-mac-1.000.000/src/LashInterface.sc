;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use ExitButton)
(use Button)
(use Plane)
(use Sound)
(use System)

(class LashInterface of Set
	(properties
		oldCast 0
		lashPlane 0
		multiple 0
		responding 0
		curIdx 0
		dispScript 0
		giveDefault 0
	)

	(method (init &tmp temp0)
		(if global112
			((ScriptID 71 0) pausePath: 1) ; crisisRegion
		)
		(if gAutoRobot
			(Robot 10) ; Pause
		)
		(= oldCast 0)
		(= gLashInterface self)
		(if (gCurRoom inset:)
			(if (== (gCurRoom inset:) (ScriptID 27 0)) ; mp5Selector
				((ScriptID 27 0) dispose:) ; mp5Selector
			else
				((gCurRoom inset:) dispose:)
			)
		)
		(if lashPlane
			(lashPlane dispose:)
			(= lashPlane 0)
		)
		(= oldCast gCast)
		((= lashPlane (Plane new:))
			setRect: 0 0 (gThePlane right:) (gThePlane bottom:)
			back: 0
			picture: -2
			priority: 1000
			init:
			addCast: (= gCast (Cast new:))
		)
		(self add:)
		(self clearFlags:)
		(= multiple (= responding 0))
		(self addItems:)
		(lashPlane setSize: posn: -1 -1)
		(FrameOut)
		(gNormalCursor view: 999 loop: 0)
		(gGame setCursor: gNormalCursor 1)
		(while ((= temp0 (Event new:)) type:)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)

	(method (dispose)
		(if size
			(self release:)
		)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1)
		(if (not elements)
			(self init:)
		)
		(while elements
			(= gGameTime (+ gTickOffset (GetTime)))
			(if ((= temp0 (Event new: evMOUSE)) type:)
				(gCast eachElementDo: #handleEvent temp0)
			)
			(self buttonDoits:)
			(= temp1 0)
			(if
				(or
					(and (not (gTalkers isEmpty:)) (= temp1 gTalkers))
					(and (not (gPrints isEmpty:)) (= temp1 gPrints))
				)
				(temp0 dispose:)
				(while ((= temp0 (Event new:)) type:)
					(temp0 dispose:)
				)
				(self processMsg: temp1 temp0)
			)
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(gSounds eachElementDo: #check)
			(temp0 dispose:)
			(FrameOut)
		)
		(gCast dispose:)
		(= gCast oldCast)
		(gSwatInterface setCursor:)
		(lashPlane dispose:)
		(= gLashInterface (= oldCast (= lashPlane 0)))
		(lashSound dispose:)
		(if gAutoRobot
			(Robot 4) ; Play
		)
		(if global112
			((ScriptID 71 0) pausePath: 0) ; crisisRegion
		)
		(if dispScript
			(dispScript cue:)
			(= dispScript 0)
		)
	)

	(method (processMsg param1 param2)
		(repeat
			(= gGameTime (+ gTickOffset (GetTime)))
			(param1 eachElementDo: #doit firstTrue: #handleEvent param2)
			(gSounds eachElementDo: #check)
			(self flashDoits:)
			(FrameOut)
			(breakif (param1 isEmpty:))
			(param2
				type: 0
				message: 0
				modifiers: 0
				y: 0
				x: 0
				claimed: 0
				plane: 0
			)
			(GetEvent gEventMask param2)
		)
	)

	(method (clear)
		(= curIdx (= multiple 0))
		(self eachElementDo: #select 0 0 release:)
	)

	(method (transmit &tmp temp0)
		(= global149 size)
		(if (proc4_11 44)
			(-- global149)
		)
		(if (proc4_11 61)
			(-- global149)
		)
		(if
			(or
				(proc4_11 28)
				(proc4_11 29)
				(proc4_11 30)
				(proc4_11 31)
				(proc4_11 32)
			)
			(-- global149)
		)
		(if (or (proc4_11 34) (proc4_11 35) (proc4_11 36) (proc4_11 37))
			(-- global149)
		)
		(if
			(or
				(proc4_11 86)
				(proc4_11 87)
				(proc4_11 88)
				(proc4_11 89)
				(proc4_11 90)
				(proc4_11 91)
				(proc4_11 92)
				(proc4_11 93)
				(proc4_11 94)
				(proc4_11 95)
				(proc4_11 96)
				(proc4_11 97)
				(proc4_11 98)
				(proc4_11 99)
				(proc4_11 100)
				(proc4_11 101)
				(proc4_11 102)
				(proc4_11 103)
				(proc4_11 104)
				(proc4_11 105)
			)
			(-- global149)
		)
		(lashSound number: 5 setLoop: 1 play: self)
		(if global149
			(= temp0 (gCurRoom lashNotify:))
		)
		(cond
			((== temp0 -1)
				(= giveDefault 1)
				(if size
					(= multiple 1)
				)
			)
			((== temp0 -2)
				(if size
					(= multiple 1)
				)
			)
			(else
				(= multiple 0)
			)
		)
	)

	(method (parse)
		(return 0)
	)

	(method (sayMultiple &tmp temp0)
		(gMessager
			say:
				((self at: curIdx) buttNoun:)
				((self at: curIdx) buttVerb:)
				((self at: curIdx) buttCase:)
				((self at: curIdx) buttSeq:)
				self
				0
		)
		(++ curIdx)
	)

	(method (sayMessage)
		(self cue:)
	)

	(method (sayResponse)
		(if giveDefault
			(= giveDefault 0)
			(gMessager say: 7 144 0 0 self 0) ; "Pup! The LASH is not a toy! Confine your comments to the situation at hand!"
		else
			(= multiple 0)
			(self cue:)
		)
	)

	(method (cue)
		(cond
			((and multiple (< curIdx size))
				(self sayMultiple:)
			)
			((or (not responding) (and multiple responding))
				(if (not responding)
					(= responding 1)
				)
				(self sayResponse:)
			)
			(else
				(self clear:)
				(self dispose:)
			)
		)
	)

	(method (flashDoits))

	(method (buttonDoits))

	(method (clearFlags &tmp temp0)
		(for ((= temp0 0)) (< temp0 106) ((++ temp0))
			(proc4_13 temp0)
		)
		(= global147 (= global148 (= global149 0)))
	)

	(method (demoDispose)
		(gCast dispose:)
		(= gCast oldCast)
		(gSwatInterface setCursor:)
		(lashPlane dispose:)
		(= gLashInterface (= oldCast (= lashPlane 0)))
		(self dispose:)
	)
)

(class LashButton of Button
	(properties
		view 17
		enumType 0
		buttNoun 8
		buttVerb 0
		buttCase 11
		buttSeq 1
	)

	(method (trace param1)
		(if (& (param1 type:) $0001)
			(param1 claimed: 1)
			(self doVerb:)
		)
	)

	(method (doVerb)
		(if (not (gLashInterface contains: self))
			(self select: 1 1)
		else
			(self select: 0 1)
		)
	)

	(method (select param1 param2)
		(if (or (not argc) param1)
			(self view: downView loop: downLoop cel: downCel)
			(if (and (> argc 1) param2)
				(proc4_12 enumType)
				(gLashInterface add: self)
			)
		else
			(self view: upView loop: upLoop cel: upCel)
			(if (and (> argc 1) param2)
				(proc4_13 enumType)
				(gLashInterface delete: self)
			)
		)
		(UpdateScreenItem self)
	)
)

(instance lashSound of Sound
	(properties)
)

