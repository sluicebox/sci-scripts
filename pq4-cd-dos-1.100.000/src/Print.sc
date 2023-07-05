;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64921)
(include sci.sh)
(use Main)
(use DButton)
(use DIcon)
(use DSelector)
(use DEdit)
(use DText)
(use Str)
(use Array)
(use Dialog)
(use System)

(public
	Prints 0
	Printf 1
	GetInput 2
	FindFormatLen 3
)

(procedure (Prints &tmp p)
	(= p (Print new:))
	(p addText: &rest init:)
)

(procedure (Printf &tmp p)
	(= p (Print new:))
	(p addTextF: &rest init:)
)

(procedure (GetInput str maxLen prompt theFont)
	(if
		((Print new:)
			font: (= gInputFont (if (> argc 3) theFont else gUserFont))
			addText: (if (and (> argc 2) prompt) prompt else {})
			addEdit: str maxLen 0 12 str
			init:
		)
		(str size:)
	)
)

(procedure (FindFormatLen ctrlString args &tmp finalLen len parmCount i str argStr)
	(= str (Str newWith: (KString 10 (KString 9 ctrlString)) {})) ; StrLen, StrGetData
	(str copy: ctrlString)
	(= finalLen (= len (str size:)))
	(= parmCount 0)
	(for ((= i 0)) (< i len) ((++ i))
		(if (== (str at: i) 37)
			(switch (str at: (++ i))
				(100
					(+= finalLen 5)
				)
				(120
					(+= finalLen 4)
				)
				(115
					(= argStr (Str with: [args parmCount]))
					(+= finalLen (argStr size:))
					(argStr dispose:)
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
		plane 0
		title 0
		mode 0
		font -1
		width 0
		fore 0
		back 11
		skip -1
		x -1
		y -1
		margin 4
		ticks 0
		caller 0
		retValue 0
		modeless 0
		first 0
		saveCursor 0
		bitmap 0
		onScreen 1
		classButton 0
		classEdit 0
		classIcon 0
		classText 0
		shadowText 0
		shadowColor 0
	)

	(method (addBitmap v l c)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(= bitmap (DIcon new:))
		(dialog
			add:
				(bitmap
					view: v
					loop: l
					cel: c
					setSize:
					moveTo: 0 0
					yourself:
				)
		)
		(= width (- (CelWide v l c) (* margin 2)))
		(return bitmap)
	)

	(method (addButton val args &tmp noun verb case seq theX theY module theText ret buttonClass)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(= buttonClass (if classButton classButton else DButton))
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
			(= theText (Str new:))
			(if
				(or
					(not (Message msgSIZE module noun verb case seq))
					(not
						(Message msgGET module noun verb case seq (theText data:))
					)
				)
				(theText dispose:)
				(return 0)
			)
			(dialog
				add:
					(= ret
						((buttonClass new:)
							value: val
							font: font
							fore: fore
							back:
								(if (== back -1)
									(buttonClass back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(buttonClass skip:)
								else
									skip
								)
							text: (theText data:)
							setSize:
							moveTo: (+ margin theX) (+ margin theY)
							yourself:
						)
					)
			)
			(theText data: 0 dispose:)
		else
			(= theX 0)
			(= theY 0)
			(if (> argc 2)
				(= theX [args 1])
				(if (> argc 3)
					(= theY [args 2])
				)
			)
			(= theText (KString 8 (KString 9 [args 0]))) ; StrDup, StrGetData
			(dialog
				add:
					(= ret
						((buttonClass new:)
							value: val
							font: font
							fore: fore
							back:
								(if (== back -1)
									(buttonClass back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(buttonClass skip:)
								else
									skip
								)
							text: theText
							setSize:
							moveTo: (+ margin theX) (+ margin theY)
							yourself:
						)
					)
			)
		)
		(return ret)
	)

	(method (addButtonBM v l c &tmp theButton)
		(= theButton (self addButton: &rest))
		(if (!= v -1)
			(theButton view: v loop: l cel: c setSize:)
		else
			(theButton view: 64990 loop: 0 cel: 0 setSize:)
		)
	)

	(method (addEdit buf maxSize theX theY default &tmp eX eY ret editClass)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gInputFont)
		)
		(= editClass (if classEdit classEdit else DEdit))
		(if (> argc 4)
			(buf copy: default)
		)
		(if (> argc 2)
			(= eX theX)
			(if (> argc 3)
				(= eY theY)
			)
		)
		(dialog
			add:
				(= ret
					((editClass new:)
						text: (buf data:)
						width: maxSize
						fore: fore
						font: font
						back:
							(if (== back -1)
								(editClass back:)
							else
								back
							)
						skip:
							(if (== skip -1)
								(editClass skip:)
							else
								skip
							)
						setSize:
						moveTo: (+ eX margin) (+ eY margin)
						yourself:
					)
				)
		)
		(return ret)
	)

	(method (addIcon theViewOrObj theLoop theCel theX theY &tmp iX iY ret iconClass)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (> argc 3)
			(= iX theX)
			(= iY theY)
		else
			(= iX (= iY 0))
		)
		(= iconClass (if classIcon classIcon else DIcon))
		(if (== theLoop -1)
			(dialog
				add:
					(= ret
						(theViewOrObj
							setSize:
							moveTo: (+ iX margin) (+ iY margin)
							yourself:
						)
					)
			)
		else
			(dialog
				add:
					(= ret
						((iconClass new:)
							view: theViewOrObj
							loop: theLoop
							cel: theCel
							setSize:
							moveTo: (+ iX margin) (+ iY margin)
							yourself:
						)
					)
			)
		)
		(return ret)
	)

	(method (addSelector theX theY maxLen theText &tmp ret d)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		((= d (DSelector new:)) font: font)
		(dialog
			add:
				(= ret
					(d
						setText: theText &rest
						length: (if (!= maxLen -1) maxLen else 0)
						setSize:
						moveTo: (+ theX margin) (+ theY margin)
						yourself:
					)
				)
		)
		(return ret)
	)

	(method (addText args &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(if (> argc 3)
			(= temp0 [args 0])
			(= temp1 [args 1])
			(= temp2 [args 2])
			(= temp3 (if [args 3] [args 3] else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (>= argc 5)
				(= temp4 [args 4])
				(if (>= argc 6)
					(= temp5 [args 5])
					(if (>= argc 7)
						(= temp6 [args 6])
					)
				)
			)
			(= temp10 1)
			(= temp7 (Str new:))
			(if
				(or
					(not (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
					(not
						(Message msgGET temp6 temp0 temp1 temp2 temp3 (temp7 data:))
					)
				)
				(return 0)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (>= argc 2)
				(= temp4 [args 1])
				(if (>= argc 3)
					(= temp5 [args 2])
				)
			)
			(= temp7 (KString 8 (KString 9 [args 0]))) ; StrDup, StrGetData
			(= temp10 0)
		)
		(dialog
			add:
				(= temp9
					(((if classText classText else DText) new:)
						text:
							(if temp10
								(temp7 data:)
							else
								temp7
							)
						font: font
						mode: mode
						fore: fore
						back: skip
						skip: skip
						setSize: width
						fixPriority: 1
						priority: 300
						yourself:
					)
				)
			setSize:
		)
		(= temp14 (IntArray with: 0 0 0 0))
		(TextSize
			(temp14 data:)
			(if temp10
				(temp7 data:)
			else
				temp7
			)
			font
			0
		)
		(if (and (not bitmap) (<= (temp14 at: 3) (temp9 textBottom:)))
			(= temp13 1)
		else
			(= temp13 0)
		)
		(temp14 dispose:)
		(if (and (== mode 1) (not temp13))
			(= temp11 (- (temp9 nsRight:) (temp9 nsLeft:)))
			(temp9 moveTo: (+ temp4 (/ (- width temp11) 2)) (+ 4 temp5))
		else
			(temp9 moveTo: (+ 4 temp4) (+ 4 temp5))
		)
		(if temp10
			(temp7 data: 0 dispose:)
		)
		(dialog setSize:)
		(return temp9)
	)

	(method (addTextBM v l c &tmp theText)
		(= theText (self addText: &rest))
		(if (!= v -1)
			(theText view: v loop: l cel: c setSize:)
		else
			(theText view: 1234 loop: 2 cel: 0 setSize:)
		)
	)

	(method (addTextF &tmp len buffer)
		(= len (FindFormatLen &rest))
		(= buffer (Str newWith: len {}))
		(buffer format: &rest)
		(self addText: (buffer data:))
		(buffer dispose:)
	)

	(method (addTitle args &tmp temp0 temp1 temp2 temp3 temp4)
		(if (> argc 1)
			(= temp0 [args 0])
			(= temp1 [args 1])
			(= temp2 [args 2])
			(= temp3 [args 3])
			(= temp4 [args 4])
			(if
				(or
					(not (Message msgSIZE temp4 temp0 temp1 temp2 temp3))
					(not (Message msgGET temp4 temp0 temp1 temp2 temp3 title))
				)
				(return 0)
			)
		else
			(= title (KString 8 (KString 9 [args 0]))) ; StrDup, StrGetData
		)
	)

	(method (dispose)
		(if (gPrints contains: self)
			(gPrints delete: self)
		)
		(plane dispose:)
		(= width
			(= mode (= title (= first (= saveCursor (= plane (= bitmap 0))))))
		)
		(= x (= y -1))
		(= modeless 0)
		(gSounds eachElementDo: #pause 0)
		(super dispose:)
	)

	(method (cue &tmp theCaller)
		(= theCaller caller)
		(= dialog 0)
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
		(self showSelf:)
	)

	(method (doit)
		(dialog doit:)
	)

	(method (handleEvent event)
		(if (dialog handleEvent: event)
			(dialog dispose:)
			(return 1)
		)
	)

	(method (showSelf &tmp default i theX theY p ret)
		(FrameOut)
		(if saveCursor
			(gGame setCursor: gNormalCursor)
		)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		((= plane
				(if plane
					(plane new:)
				else
					(gSystemPlane new:)
				)
			)
			back: (if (== back -1) 0 else back)
		)
		(dialog
			plane: plane
			name: {PODialog}
			caller: self
			text: title
			ticks: ticks
			margin: margin
			modeless: modeless
			onScreen: onScreen
			init:
		)
		(if bitmap
			(dialog
				nsLeft: (bitmap nsLeft:)
				nsTop: (bitmap nsTop:)
				nsRight: (bitmap nsRight:)
				nsBottom: (bitmap nsBottom:)
			)
		else
			(dialog setSize:)
		)
		(if title
			((dialog plane:) setTitle: title)
			(dialog
				nsLeft: ((dialog plane:) left:)
				nsTop: ((dialog plane:) top:)
				nsRight: ((dialog plane:) right:)
				nsBottom: ((dialog plane:) bottom:)
			)
		)
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
		(dialog moveTo: theX theY eachElementDo: #updatePlane)
		(if (== modeless 0)
			(gSounds eachElementDo: #pause 1)
			(if (not (= default first))
				(if
					(and
						(= default (dialog firstTrue: #checkState 1))
						(not (dialog firstTrue: #checkState 2))
					)
					(default state: (| (default state:) $0002))
				)
			else
				(= default (dialog at: default))
			)
			(= retValue (dialog doit: default))
			(switch retValue
				(-1
					(= retValue 0)
				)
				(-2
					(= retValue 1)
				)
				(0
					(= retValue 1)
				)
				(else
					(if (retValue object:)
						(gGame
							panelObj: (retValue object:)
							panelSelector: (retValue selector:)
						)
					)
					(if (retValue isKindOf: DEdit)
						(= retValue (retValue text:))
					else
						(= retValue (retValue value:))
					)
				)
			)
			(if saveCursor
				(gGame setCursor: (gTheIconBar getCursor:))
			)
			(= ret retValue)
			(dialog dispose:)
			(return ret)
		else
			(gPrints addToFront: self)
		)
	)

	(method (isModeless checkFor)
		(return
			(if argc
				(== modeless checkFor)
			else
				modeless
			)
		)
	)
)

