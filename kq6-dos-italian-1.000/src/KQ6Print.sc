;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use Interface)
(use Kq6Talker)
(use Print)
(use Dialog)
(use System)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance myDialog of Dialog
	(properties)

	(method (check)
		(if (or (super check:) (== (DoAudio audPOSITION) -1))
			(return 1)
		)
	)

	(method (handleEvent)
		(if (== (DoAudio audPOSITION) -1)
			(return -2)
		else
			(super handleEvent: &rest)
			(return)
		)
	)

	(method (dispose)
		(if (not (== (DoAudio audPOSITION) -1))
			(DoAudio audSTOP)
		)
		(super dispose: &rest)
	)
)

(class KQ6Print of Print
	(properties
		repressText 0
	)

	(method (say param1 param2 &tmp temp0 temp1)
		(if (& gMsgType $0002)
			(= local1 [param2 0])
			(= local2 [param2 1])
			(= local3 [param2 2])
			(= local4 (if [param2 3] [param2 3] else 1))
			(= temp0 0)
			(= temp1 0)
			(= local0 gCurRoomNum)
			(if (>= argc 5)
				(= temp0 [param2 4])
				(if (>= argc 6)
					(= temp1 [param2 5])
					(if (>= argc 7)
						(= local0 [param2 6])
					)
				)
			)
			(if (== param1 1)
				(self addText: param2 &rest)
			else
				(= repressText 1)
			)
		else
			(self addText: param2 &rest)
		)
	)

	(method (init param1)
		(= caller 0)
		(if argc
			(= caller param1)
		)
		(if (> argc 1)
			(self addText: &rest)
		)
		(if (not modeless)
			(if (not (IsObject gPrints))
				(= gPrints ((EventHandler new:) name: {prints}))
			)
			(gPrints add: self)
		)
		(if (& gMsgType $0002)
			(DoAudio audPLAY local0 local1 local2 local3 local4)
		)
		(if modeless
			(gTheIconBar disable: 6)
		)
		(self showSelf:)
	)

	(method (dispose)
		(if modeless
			(gTheIconBar enable: 6)
		)
		(= repressText 0)
		(if (& gMsgType $0002)
			(DoAudio audSTOP)
		)
		(super dispose: &rest)
	)

	(method (addText param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(= repressText 0)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(if (> argc 3)
			(= temp0 [param1 0])
			(= temp1 [param1 1])
			(= temp2 [param1 2])
			(= temp3 (if [param1 3] [param1 3] else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (>= argc 5)
				(= temp4 [param1 4])
				(if (>= argc 6)
					(= temp5 [param1 5])
					(if (>= argc 7)
						(= temp6 [param1 6])
					)
				)
			)
			(if (= temp8 (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if (Message msgGET temp6 temp0 temp1 temp2 temp3 temp7)
					(= temp9 (StrAt temp7 0))
					(if (>= 90 temp9 65)
						(StrAt temp7 0 9)
						(= temp10 (+ 0 (/ (- temp9 65) 13)))
						(= temp11 (mod (- temp9 65) 13))
						(dialog
							add:
								((DText new:)
									text: temp7
									font: font
									mode: mode
									setSize: width
									moveTo: (+ 4 temp4) (+ 4 temp5 7)
									yourself:
								)
							add:
								((DIcon new:)
									view: (Kq6Narrator strView:)
									loop: temp10
									cel: temp11
									setSize:
									moveTo: (+ temp4 4) (+ temp5 4)
									yourself:
								)
							setSize:
						)
					else
						(dialog
							add:
								((DText new:)
									text: temp7
									font: font
									mode: mode
									setSize: width
									moveTo: (+ 4 temp4) (+ 4 temp5)
									yourself:
								)
							setSize:
						)
					)
				)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (>= argc 2)
				(= temp4 [param1 1])
				(if (>= argc 3)
					(= temp5 [param1 2])
				)
			)
			(= temp7 (Memory memALLOC_CRIT (+ (StrLen [param1 0]) 1)))
			(StrCpy temp7 [param1 0])
			(dialog
				add:
					((DText new:)
						text: temp7
						font: font
						mode: mode
						setSize: width
						moveTo: (+ 4 temp4) (+ 4 temp5)
						yourself:
					)
				setSize:
			)
		)
	)

	(method (showSelf &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if
			(and
				(= temp6
					(if repressText
						(& gMsgType $0002)
					)
				)
				(gGame isHandsOn:)
			)
			(= temp5 gTheCursor)
			(gGame setCursor: gWaitCursor)
		else
			(= temp5 0)
		)
		(if saveCursor
			(gGame setCursor: 999)
		)
		(if (not dialog)
			(if temp6
				(= dialog myDialog)
			else
				(= dialog (Dialog new:))
			)
		)
		(dialog
			window: (if window window else gSystemWindow)
			name: {PODialog}
			caller: self
		)
		(dialog text: title time: ticks setSize:)
		(dialog center:)
		(= temp3
			(if (== x -1)
				(dialog nsLeft:)
			else
				x
			)
		)
		(= temp4
			(if (== y -1)
				(dialog nsTop:)
			else
				y
			)
		)
		(dialog moveTo: temp3 temp4)
		(= temp1 (GetPort))
		(if (not repressText)
			(dialog open: (if title 4 else 0) 15)
		)
		(if modeless
			(= gModelessPort (GetPort))
			(SetPort temp1)
			(= gModelessDialog dialog)
			(if temp5
				(gGame handsOn:)
			)
		else
			(gSounds pause: 1)
			(cond
				((not (= temp0 first))
					(if
						(and
							(= temp0 (dialog firstTrue: #checkState 1))
							(not (dialog firstTrue: #checkState 2))
						)
						(temp0 state: (| (temp0 state:) $0002))
					)
				)
				((not (IsObject temp0))
					(= temp0 (dialog at: temp0))
				)
			)
			(= retValue (dialog doit: temp0))
			(SetPort temp1)
			(cond
				((== retValue -1)
					(= retValue 0)
				)
				((and (IsObject retValue) (retValue isKindOf: DButton))
					(= retValue (retValue value:))
				)
				((not (dialog theItem:))
					(= retValue 1)
				)
			)
			(if saveCursor
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			(dialog dispose:)
			(if temp5
				(gGame setCursor: temp5)
			)
			(return retValue)
		)
	)
)

