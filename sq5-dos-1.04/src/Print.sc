;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 921)
(include sci.sh)
(use Main)
(use DColorButton)
(use Interface)
(use Dialog)
(use System)

(public
	Prints 0
	Printf 1
	GetInput 2
	FindFormatLen 3
)

(procedure (Prints)
	(Print addText: &rest init:)
)

(procedure (Printf)
	(Print addTextF: &rest init:)
)

(procedure (GetInput str maxLen prompt theFont)
	(if
		(Print
			font: (if (> argc 3) theFont else gUserFont)
			addText: (if (and (> argc 2) prompt) prompt else {})
			addEdit: str maxLen 0 12 str
			init:
		)
		(StrLen str)
	)
)

(procedure (FindFormatLen ctrlString args &tmp finalLen len parmCount i)
	(= finalLen (= len (StrLen ctrlString)))
	(= parmCount 0)
	(for ((= i 0)) (< i len) ((++ i))
		(if (== (StrAt ctrlString i) 37)
			(switch (StrAt ctrlString (++ i))
				(100
					(+= finalLen 5)
				)
				(120
					(+= finalLen 4)
				)
				(115
					(+= finalLen (StrLen [args parmCount]))
				)
			)
			(++ parmCount)
		)
	)
	(++ finalLen)
)

(class Print of Obj
	(properties
		dialog 0
		window 0
		title 0
		mode 0
		font -1
		width 0
		x -1
		y -1
		ticks 0
		caller 0
		retValue 0
		modeless 0
		first 0
		saveCursor 0
	)

	(method (addButton val args &tmp noun verb case seq theX theY module theText s)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(if (> argc 4)
			(= noun [args 0])
			(= verb [args 1])
			(= case [args 2])
			(= seq (if [args 3] [args 3] else 1))
			(= theX 0)
			(= theY 0)
			(= module gCurRoomNum)
			(if (> argc 5)
				(= theX [args 4])
				(if (> argc 6)
					(= theY [args 5])
					(if (> argc 7)
						(= module [args 6])
					)
				)
			)
			(if (= s (Message msgSIZE module noun verb case seq))
				(= theText (Memory memALLOC_CRIT s))
				(if (not (Message msgGET module noun verb case seq theText))
					(= theText 0)
				)
			)
		else
			(= theX 0)
			(= theY 0)
			(if (> argc 2)
				(= theX [args 1])
				(if (> argc 3)
					(= theY [args 2])
				)
			)
			(= theText (Memory memALLOC_CRIT (+ (StrLen [args 0]) 1)))
			(StrCpy theText [args 0])
		)
		(if theText
			(dialog
				add:
					((DButton new:)
						value: val
						font: font
						text: theText
						setSize:
						moveTo: (+ 4 theX) (+ 4 theY)
						yourself:
					)
				setSize:
			)
		)
	)

	(method (addColorButton param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(= temp9 0)
		(= temp11 15)
		(= temp13 31)
		(= temp10 5)
		(= temp12 5)
		(= temp14 5)
		(if (< (Abs [param2 0]) 1000)
			(= temp0 [param2 0])
			(= temp1 [param2 1])
			(= temp2 [param2 2])
			(= temp3 (if [param2 3] [param2 3] else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (> argc 5)
				(= temp4 [param2 4])
				(if (> argc 6)
					(= temp5 [param2 5])
					(if (> argc 7)
						(= temp6 [param2 6])
						(if (> argc 8)
							(= temp9 [param2 7])
							(if (> argc 9)
								(= temp11 [param2 8])
								(if (> argc 10)
									(= temp13 [param2 9])
									(if (> argc 11)
										(= temp10 [param2 10])
										(if (> argc 12)
											(= temp12 [param2 11])
											(if (> argc 13)
												(= temp14 [param2 12])
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(if (= temp8 (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
				(= temp7 (Memory memALLOC_CRIT temp8))
				(if (not (Message msgGET temp6 temp0 temp1 temp2 temp3 temp7))
					(= temp7 0)
				)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (> argc 2)
				(= temp4 [param2 1])
				(if (> argc 3)
					(= temp5 [param2 2])
					(if (> argc 4)
						(= temp9 [param2 3])
						(if (> argc 5)
							(= temp11 [param2 4])
							(if (> argc 6)
								(= temp13 [param2 5])
								(if (> argc 7)
									(= temp10 [param2 6])
									(if (> argc 8)
										(= temp12 [param2 7])
										(if (> argc 9)
											(= temp14 [param2 8])
										)
									)
								)
							)
						)
					)
				)
			)
			(= temp7 (Memory memALLOC_CRIT (+ (StrLen [param2 0]) 1)))
			(StrCpy temp7 [param2 0])
		)
		(if temp7
			(dialog
				add:
					((DColorButton new:)
						value: param1
						font: font
						text: temp7
						mode: mode
						nfc: temp9
						nbc: temp10
						sfc: temp13
						sbc: temp14
						hfc: temp11
						hbc: temp12
						setSize: width
						moveTo: (+ 4 temp4) (+ 4 temp5)
						yourself:
					)
				setSize:
			)
		)
	)

	(method (addEdit buf maxSize theX theY default &tmp eX eY)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(StrCpy buf (if (> argc 4) default else {}))
		(if (> argc 2)
			(= eX theX)
			(if (> argc 3)
				(= eY theY)
			)
		)
		(dialog
			add:
				((DEdit new:)
					text: buf
					max: maxSize
					setSize:
					moveTo: (+ eX 4) (+ eY 4)
					yourself:
				)
			setSize:
		)
	)

	(method (addIcon theViewOrObj theLoop theCel theX theY &tmp iX iY)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (> argc 3)
			(= iX theX)
			(= iY theY)
		else
			(= iX (= iY 0))
		)
		(if (IsObject theViewOrObj)
			(dialog
				add: (theViewOrObj setSize: moveTo: (+ iX 4) (+ iY 4) yourself:)
				setSize:
			)
		else
			(dialog
				add:
					((DIcon new:)
						view: theViewOrObj
						loop: theLoop
						cel: theCel
						setSize:
						moveTo: (+ iX 4) (+ iY 4)
						yourself:
					)
				setSize:
			)
		)
	)

	(method (addText args &tmp noun verb case seq theX theY module theText s)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(if (> argc 3)
			(= noun [args 0])
			(= verb [args 1])
			(= case [args 2])
			(= seq (if [args 3] [args 3] else 1))
			(= theX 0)
			(= theY 0)
			(= module gCurRoomNum)
			(if (>= argc 5)
				(= theX [args 4])
				(if (>= argc 6)
					(= theY [args 5])
					(if (>= argc 7)
						(= module [args 6])
					)
				)
			)
			(if (= s (Message msgSIZE module noun verb case seq))
				(= theText (Memory memALLOC_CRIT s))
				(if (Message msgGET module noun verb case seq theText)
					(dialog
						add:
							((DText new:)
								text: theText
								font: font
								mode: mode
								setSize: width
								moveTo: (+ 4 theX) (+ 4 theY)
								yourself:
							)
						setSize:
					)
				)
			)
		else
			(= theX 0)
			(= theY 0)
			(if (>= argc 2)
				(= theX [args 1])
				(if (>= argc 3)
					(= theY [args 2])
				)
			)
			(= theText (Memory memALLOC_CRIT (+ (StrLen [args 0]) 1)))
			(StrCpy theText [args 0])
			(dialog
				add:
					((DText new:)
						text: theText
						font: font
						mode: mode
						setSize: width
						moveTo: (+ 4 theX) (+ 4 theY)
						yourself:
					)
				setSize:
			)
		)
	)

	(method (addTextF &tmp len buffer)
		(= len (FindFormatLen &rest))
		(= buffer (Memory memALLOC_CRIT len))
		(Format buffer &rest)
		(self addText: buffer)
		(Memory memFREE buffer)
	)

	(method (addTitle args &tmp noun verb case seq module s)
		(if (> argc 1)
			(= noun [args 0])
			(= verb [args 1])
			(= case [args 2])
			(= seq [args 3])
			(= module [args 4])
			(if (= s (Message msgSIZE module noun verb case seq))
				(= title (Memory memALLOC_CRIT s))
				(Message msgGET module noun verb case seq title)
			)
		else
			(= title (Memory memALLOC_CRIT (+ (StrLen [args 0]) 1)))
			(StrCpy title [args 0])
		)
	)

	(method (dispose)
		(if (and gPrints (gPrints contains: self))
			(gPrints delete: self)
			(if (gPrints isEmpty:)
				(gPrints dispose:)
				(= gPrints 0)
			)
		)
		(if title
			(Memory memFREE title)
		)
		(= width (= mode (= title (= first (= saveCursor (= window 0))))))
		(= x (= y -1))
		(= modeless 0)
		(gSounds pause: 0)
		(super dispose:)
	)

	(method (cue &tmp theCaller)
		(= theCaller caller)
		(= dialog 0)
		(if window
			(window dispose:)
		)
		(self dispose:)
		(if theCaller
			(theCaller cue:)
		)
	)

	(method (posn theX theY)
		(= x theX)
		(= y theY)
	)

	(method (init whoCares)
		(= caller 0)
		(if argc
			(= caller whoCares)
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
		(self showSelf:)
	)

	(method (doit)
		(dialog eachElementDo: #doit)
	)

	(method (handleEvent event)
		(if (dialog handleEvent: event)
			(dialog dispose:)
		)
	)

	(method (showSelf &tmp default curPort i theX theY)
		(if saveCursor
			(gGame setCursor: 999)
		)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(dialog
			window: (if window window else gSystemWindow)
			name: {PODialog}
			caller: self
		)
		(dialog text: title time: ticks setSize:)
		(dialog center:)
		(= theX
			(if (== x -1)
				(dialog nsLeft:)
			else
				x
			)
		)
		(= theY
			(if (== y -1)
				(dialog nsTop:)
			else
				y
			)
		)
		(dialog moveTo: theX theY)
		(= curPort (GetPort))
		(dialog open: (if title 4 else 0) 15)
		(if modeless
			(= gModelessPort (GetPort))
			(SetPort curPort)
			(= gModelessDialog dialog)
		else
			(gSounds pause: 1)
			(cond
				((not (= default first))
					(if
						(and
							(= default (dialog firstTrue: #checkState 1))
							(not (dialog firstTrue: #checkState 2))
						)
						(default state: (| (default state:) $0002))
					)
				)
				((not (IsObject default))
					(= default (dialog at: default))
				)
			)
			(= retValue (dialog doit: default))
			(SetPort curPort)
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
			(return retValue)
		)
	)
)

