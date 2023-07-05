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
	(= str (Str newWith: (KString 8 (KArray 9 ctrlString)) {})) ; StrLen, ArrayGetData
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
		back -1
		caller 0
		plane 0
		x -1
		y -1
		margin 4
		onScreen 1
		ticks 0
		modeless 0
		dialog 0
		retValue 0
		saveCursor 0
		classButton 0
		classEdit 0
		classIcon 0
		classText 0
		bitmap 0
		font -1
		fore 255
		mode 0
		skip -1
		width 0
		first 0
		title 0
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
			(= theText (KArray 8 (KArray 9 [args 0]))) ; ArrayDup, ArrayGetData
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
		(return theButton)
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

	(method (addFSelector theX theY maxLen theMask &tmp ret d)
		(if (not dialog)
			(= dialog (Dialog new:))
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
								(KArray 8 (KArray 9 theMask)) ; ArrayDup, ArrayGetData
							else
								(KArray 8 {*.*}) ; ArrayDup
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

	(method (addSlider)
		(return 0)
	)

	(method (addText args &tmp noun verb case seq theX theY module theText theArray ret t textClass)
		(if (not dialog)
			(= dialog (Dialog new:))
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
							fore: fore
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
			(theText copy: (KArray 9 [args 0])) ; ArrayGetData
			(dialog
				add:
					(= ret
						((textClass new:)
							text: (theText data:)
							font: font
							mode: mode
							fore: fore
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
				(= title (KArray 8 (theText data:))) ; ArrayDup
				(theText data: 0 dispose:)
			else
				(= title (KArray 8 (KArray 9 [args 0]))) ; ArrayDup, ArrayGetData
			)
		)
	)

	(method (dispose)
		(if (gPrints contains: self)
			(gPrints delete: self)
		)
		(plane dispose:)
		(= width
			(= mode
				(= ticks
					(= title (= first (= saveCursor (= plane (= bitmap 0)))))
				)
			)
		)
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
		(FrameOut)
		(if (== modeless 0)
			(gSounds pause: 1)
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
			(if (and saveCursor gTheIconBar)
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

