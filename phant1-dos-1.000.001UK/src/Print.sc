;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64921)
(include sci.sh)
(use Main)
(use BorderedPlane)
(use DButton)
(use DIcon)
(use DSelector)
(use DEdit)
(use DText)
(use Str)
(use Dialog)
(use FileSelector)
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
	(str dispose:)
	(++ finalLen)
)

(class Print of Obj
	(properties
		dialog 0
		plane 0
		title 0
		border 9808
		mode 0
		font -1
		width 0
		borderColor -1
		hiliteColor -1
		fore -1
		back -1
		skip -1
		x -1
		y -1
		margin 4
		ticks 0
		caller 0
		retValue 0
		modeless 0
		first 0
		saveCursor 1
		bitmap 0
		onScreen 1
		classButton 0
		classEdit 0
		classIcon 0
		classText 0
	)

	(method (addBitmap v l c)
		(if (not dialog)
			(= dialog (Dialog new:))
			(if border
				(= margin (+ 4 (CelWide border 4 0)))
			)
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

	(method (addButton val args &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if (not dialog)
			(= dialog (Dialog new:))
			(if border
				(= margin (+ 4 (CelWide border 4 0)))
			)
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(= temp11 (if classButton classButton else DButton))
		(if (> argc 5)
			(= temp0 [args 0])
			(= temp1 [args 1])
			(= temp2 [args 2])
			(= temp3 (if [args 3] [args 3] else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 0)
			(= temp7 gCurRoomNum)
			(if (> argc 5)
				(= temp4 [args 4])
				(if (> argc 6)
					(= temp5 [args 5])
					(if (> argc 7)
						(= temp6 [args 6])
						(if (> argc 8)
							(= temp7 [args 7])
						)
					)
				)
			)
			(= temp9 (Str new:))
			(if
				(or
					(not (Message msgSIZE temp7 temp0 temp1 temp2 temp3))
					(not
						(Message msgGET temp7 temp0 temp1 temp2 temp3 (temp9 data:))
					)
				)
				(temp9 dispose:)
				(return 0)
			)
			(dialog
				add:
					(= temp10
						((temp11 new:)
							value: val
							font: font
							mode: temp6
							hiliteColor:
								(if (== hiliteColor -1)
									(temp11 hiliteColor:)
								else
									hiliteColor
								)
							borderColor:
								(if (== borderColor -1)
									(temp11 borderColor:)
								else
									borderColor
								)
							fore:
								(if (== fore -1)
									(temp11 fore:)
								else
									fore
								)
							back:
								(if (== back -1)
									(temp11 back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(temp11 skip:)
								else
									skip
								)
							text: (temp9 data:)
							setSize:
							moveTo: (+ margin temp4) (+ margin temp5)
							yourself:
						)
					)
			)
			(temp9 data: 0 dispose:)
		else
			(= temp4 0)
			(= temp5 0)
			(= temp6 0)
			(if (> argc 2)
				(= temp4 [args 1])
				(if (> argc 3)
					(= temp5 [args 2])
					(if (> argc 4)
						(= temp6 [args 3])
					)
				)
			)
			(= temp9 (KString 8 (KString 9 [args 0]))) ; StrDup, StrGetData
			(dialog
				add:
					(= temp10
						((temp11 new:)
							value: val
							font: font
							mode: temp6
							hiliteColor:
								(if (== hiliteColor -1)
									(temp11 hiliteColor:)
								else
									hiliteColor
								)
							borderColor:
								(if (== borderColor -1)
									(temp11 borderColor:)
								else
									borderColor
								)
							fore:
								(if (== fore -1)
									(temp11 fore:)
								else
									fore
								)
							back:
								(if (== back -1)
									(temp11 back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(temp11 skip:)
								else
									skip
								)
							text: temp9
							setSize:
							moveTo: (+ margin temp4) (+ margin temp5)
							yourself:
						)
					)
			)
		)
		(return temp10)
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
			(if border
				(= margin (+ 4 (CelWide border 4 0)))
			)
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
						font: font
						borderColor:
							(if (== borderColor -1)
								(editClass borderColor:)
							else
								borderColor
							)
						fore:
							(if (== fore -1)
								(editClass fore:)
							else
								fore
							)
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

	(method (addFSelector theX theY maxLen theMask &tmp ret d)
		(if (not dialog)
			(= dialog (Dialog new:))
			(if border
				(= margin (+ 4 (CelWide border 4 0)))
			)
		)
		(if (== font -1)
			(= font gUserFont)
		)
		((= d (FileSelector new:)) font: font)
		(dialog
			add:
				(= ret
					(d
						setText:
						mask:
							(if (> argc 3)
								(KString 8 (KString 9 theMask)) ; StrDup, StrGetData
							else
								(KString 8 {*.*}) ; StrDup
							)
						sort: 0
						length: (if (!= maxLen -1) maxLen else 0)
						setSize:
						moveTo: (+ theX margin) (+ theY margin)
						yourself:
					)
				)
		)
		(return ret)
	)

	(method (addIcon theViewOrObj theLoop theCel theX theY &tmp iX iY ret iconClass)
		(if (not dialog)
			(= dialog (Dialog new:))
			(if border
				(= margin (+ 4 (CelWide border 4 0)))
			)
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
			(if border
				(= margin (+ 4 (CelWide border 4 0)))
			)
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

	(method (addText args &tmp noun verb case seq theX theY module theText theArray ret t textClass)
		(if (not dialog)
			(= dialog (Dialog new:))
			(if border
				(= margin (+ 4 (CelWide border 4 0)))
			)
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(= textClass (if classText classText else DText))
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
			(= theText (Str new:))
			(if
				(or
					(not (Message msgSIZE module noun verb case seq))
					(not
						(Message msgGET module noun verb case seq (theText data:))
					)
				)
				(return 0)
			)
			(dialog
				add:
					(= ret
						((textClass new:)
							text: (theText data:)
							font: font
							mode: mode
							fore:
								(if (== fore -1)
									(textClass fore:)
								else
									fore
								)
							back:
								(if (== back -1)
									(textClass back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(textClass skip:)
								else
									skip
								)
							setSize: width
							moveTo: (+ margin theX) (+ margin theY)
							yourself:
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
			(= theText (Str new:))
			(theText copy: (KString 9 [args 0])) ; StrGetData
			(dialog
				add:
					(= ret
						((textClass new:)
							text: (theText data:)
							font: font
							mode: mode
							fore:
								(if (== fore -1)
									(textClass fore:)
								else
									fore
								)
							back:
								(if (== back -1)
									(textClass back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(textClass skip:)
								else
									skip
								)
							setSize: width
							moveTo: (+ margin theX) (+ margin theY)
							yourself:
						)
					)
			)
		)
		(theText data: 0 dispose:)
		(return ret)
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

	(method (addTitle args &tmp noun verb case seq module theText)
		(if border
			(= margin (+ 4 (CelWide border 4 0)))
		)
		(return
			(if (> argc 1)
				(= noun [args 0])
				(= verb [args 1])
				(= case [args 2])
				(= seq [args 3])
				(= module [args 4])
				(= theText (Str new:))
				(if
					(or
						(not (Message msgSIZE module noun verb case seq))
						(not
							(Message
								msgGET
								module
								noun
								verb
								case
								seq
								(theText data:)
							)
						)
					)
					(theText dispose:)
					(return 0)
				)
				(= title (KString 8 (theText data:))) ; StrDup
				(theText data: 0 dispose:)
			else
				(= title (KString 8 (KString 9 [args 0]))) ; StrDup, StrGetData
			)
		)
	)

	(method (dispose)
		(if (gPrints contains: self)
			(gPrints delete: self)
		)
		(plane dispose:)
		(= width (= mode (= title (= first (= plane (= bitmap 0))))))
		(= x (= y -1))
		(= modeless 0)
		(gSounds pause: 0)
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
		(if border
			(= margin (+ 4 (CelWide border 4 0)))
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

	(method (showSelf &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(if saveCursor
			(= temp7 gTheCursor)
			(gNormalCursor cel: 1)
			(gGame setCursor: gNormalCursor 1)
		)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		((= plane
				(cond
					(border
						(= plane (BorderedPlane new:))
					)
					(plane
						(plane new:)
					)
					(else
						(gSystemPlane new:)
					)
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
		(= temp8 (/ (- (dialog nsRight:) (dialog nsLeft:)) 2))
		(for ((= temp1 (dialog first:))) temp1 ((= temp1 (dialog next: temp1)))
			(= temp2 (KList 8 temp1)) ; NodeValue
			(if (and (temp2 respondsTo: #mode) (== (temp2 mode:) 1))
				(= temp9 (/ (- (temp2 nsRight:) (temp2 nsLeft:)) 2))
				(= temp10 (- temp8 temp9))
				(temp2 moveTo: temp10 (temp2 y:))
				(if (not bitmap)
					(dialog setSize:)
					(= temp10
						(-
							(= temp8
								(/ (- (dialog nsRight:) (dialog nsLeft:)) 2)
							)
							temp9
						)
					)
					(temp2 moveTo: temp10 (temp2 y:))
				)
				(temp2 draw:)
			)
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
		(if border
			((dialog plane:) addBorder: border)
		)
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
		(dialog moveTo: temp3 temp4 eachElementDo: #updatePlane)
		(FrameOut)
		(if (== modeless 0)
			(gSounds pause: 1)
			(if (not (= temp0 first))
				(if
					(and
						(= temp0 (dialog firstTrue: #checkState 1))
						(not (dialog firstTrue: #checkState 2))
					)
					(temp0 state: (| (temp0 state:) $0002))
				)
			else
				(= temp0 (dialog at: temp0))
			)
			(= retValue (dialog doit: temp0))
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
					(cond
						((retValue isKindOf: DEdit)
							(= retValue (retValue text:))
						)
						((retValue isKindOf: DSelector)
							(= retValue (retValue getText:))
						)
						(else
							(= retValue (retValue value:))
						)
					)
				)
			)
			(if saveCursor
				(gGame setCursor: temp7 1)
			)
			(= temp6 retValue)
			(dialog dispose:)
			(return temp6)
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

