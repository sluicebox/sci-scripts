;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64990)
(include sci.sh)
(use Main)
(use LineSelector)
(use DEditStruct)
(use Str)
(use Array)
(use Cel)
(use PlaneManager)
(use Sight)
(use TextField)
(use Button)
(use File)
(use Menu)

(class SRPlane of Window
	(properties
		state 2
		type -1
		left 0
		top 0
		right 639
		bottom 479
		saveName 0
		number -1
	)

	(method (init param1 param2 param3 &tmp temp0 temp1 temp2)
		(= saveName param1)
		(= type (if (> argc 1) param2 else 0))
		(= temp1 (if (== type 1) 20 else 21))
		(= cast (if (> argc 2) param3 else SRCast))
		(= priority (+ 1 (GetHighPlanePri)))
		(= borderWidth 0)
		(super init: left top right bottom)
		(if (= temp0 (cast init: self))
			(self dispose:)
			(return temp0)
		)
		(global250 subHog: self)
		(global250 doit:)
		(FrameOut)
		(= temp0 number)
		(self dispose:)
		(return temp0)
	)

	(method (dispose)
		(= type (= number -1))
		(= saveName 0)
		(super dispose: &rest)
	)

	(method (done param1 &tmp temp0)
		(if (and argc param1)
			(= number (param1 number:))
			(saveName format: ((param1 text:) data:))
		)
		(if (== number -4)
			(switch type
				(0
					(global250 delayScratch: 0 doSave: 1 subHog: 0)
				)
				(1
					(global250 delayScratch: 0 doRestore: 1 subHog: 0)
				)
			)
		else
			(global250 subHog: 0)
		)
	)

	(method (handleEvent event)
		(self doit:)
		(if (self onMe: event)
			(event localize: self)
			(cast handleEvent: event self)
			(FrameOut)
			(if (event type:)
				(super handleEvent: event)
			)
		)
	)
)

(class SRCast of Cast
	(properties
		okButton 0
		delButton 0
		dirButton 0
		canButton 0
		editItem 0
		selectBox 0
		usageItem 0
	)

	(method (init param1 &tmp temp0)
		(super init: param1)
		(if usageItem
			(usageItem init: param1)
		)
		(if okButton
			(okButton init: param1)
		)
		(if delButton
			(delButton init: param1)
		)
		(if dirButton
			(dirButton init: param1)
		)
		(if canButton
			(canButton init: param1)
		)
		(if selectBox
			(= temp0 (selectBox init: param1))
		)
		(if temp0
			(if (& $0001 (editItem info:))
				(DisposeClone editItem)
			)
			(return temp0)
		)
		(if editItem
			(editItem init: param1)
		)
		(return 0)
	)
)

(class GameItem of TextView
	(properties
		back 0
		number -1
		fore 255
	)

	(method (init param1)
		(self draw:)
		(= plane
			(cond
				(argc param1)
				(plane plane)
				(else gThePlane)
			)
		)
		((plane cast:) add: self)
	)

	(method (draw param1 &tmp [temp0 4] temp4)
		(= temp4 bitmap)
		(if (not (not (& state $0002)))
			(= borderColor fore)
			(text fore: back back: borderColor)
		else
			(= borderColor back)
			(text fore: fore back: borderColor)
		)
		(super draw:)
		(if (and argc param1)
			(PrintDebug {Update %d (%x->%x)} self temp4 bitmap)
			(self update:)
		)
	)

	(method (hilite param1)
		(if (and argc (^ param1 (not (not (& state $0002)))))
			(if param1
				(|= state $0002)
			else
				(&= state $fffd)
			)
			(self draw: 1)
		)
		(return (not (not (& state $0002))))
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSERELEASE)
			(((plane cast:) editItem:) resetText: (text data:) number)
			(event claimed: 1)
			(return)
		)
	)

	(method (usesNumber param1)
		(return (== param1 number))
	)
)

(class GamesList of List
	(properties
		plane 0
		back 0
		manager 0
		startY -1
		startX -1
		fore 32
		skip 1
		font 2608
		width 200
	)

	(method (init param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(super init:)
		(= temp8 GameItem)
		(if argc
			(= manager param1)
			(if (> argc 1)
				(= plane param2)
				(if (> argc 2)
					(= temp8 param3)
				)
			)
		)
		(= temp0 (Font 0 font)) ; PointSize
		(manager lineHeight: temp0)
		(= temp7 startY)
		(= temp3 (Str new: 720))
		(= temp4 (IntArray new: 21))
		(if
			(or
				(<
					(= temp1
						(Save 5 (gGame name:) (temp3 data:) (temp4 data:)) ; GetSaveFiles
					)
					0
				)
				(and (== temp1 20) (== 0 (plane type:)))
			)
			(temp3 dispose:)
			(temp4 dispose:)
			(if (> temp1 0) -3 else -2)
			(return)
		)
		(if temp1
			(for ((= temp2 0)) (temp3 at: temp2) ((+= temp2 36))
				((= temp5 (TextField new: 37))
					copyToFrom: 0 temp3 temp2 36
					at: 36 0
					font: font
					fore: fore
					back: back
					skip: skip
					width: width
				)
				((= temp6 (temp8 new:))
					fore: fore
					back: back
					text: temp5
					setSize:
					posn: startX temp7
					number: (temp4 at: size)
				)
				(self addToEnd: temp6)
				(temp6 init: plane)
				(+= temp7 temp0)
			)
		)
		(temp3 dispose:)
		(temp4 dispose:)
		(return 0)
	)

	(method (dispose)
		(self release:)
		(super dispose:)
	)

	(method (getNumber &tmp temp0)
		(for ((= temp0 0)) (< temp0 20) ((++ temp0))
			(if (not (self firstTrue: #usesNumber temp0))
				(break)
			)
		)
		(if (< temp0 20)
			(return temp0)
		)
		(PrintDebug {Error: No new savegame number})
		(return -1)
	)
)

(class GamesBox of LineSelector
	(properties
		plane 0
		pageSize 8
		boxRect 0
		curItem 0
	)

	(method (init param1 param2 param3 &tmp temp0 temp1)
		(= plane param1)
		(self tracksMouse: 1)
		(plane add: self)
		(= temp0 (if (> argc 2) param3 else GameItem))
		(= items
			(if (> argc 1)
				(if (param2 isClass:)
					(param2 new:)
				else
					param2
				)
			else
				(GamesList new:)
			)
		)
		(if (= temp1 (items init: self plane temp0))
			(return temp1)
		)
		(self setRect: param3)
		(super init:)
		(return 0)
	)

	(method (dispose)
		(if (and boxRect (not ((plane cast:) contains: boxRect)))
			(boxRect dispose:)
		)
		(= boxRect (= plane (= curItem 0)))
		(super dispose:)
	)

	(method (setRect param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if boxRect
			(boxRect dispose:)
		)
		(= temp5 (param1 celWidth:))
		(= temp6 (items width:))
		(= temp4 (if (> temp5 temp6) temp5 else temp6))
		(= temp0 (items startX:))
		(= temp1 (items startY:))
		(= temp2 (+ temp0 temp4 -1))
		(= temp3 (+ temp1 (* pageSize lineHeight) -1))
		(= boxRect
			((SRBox new: temp0 temp1 temp2 temp3 (items back:))
				setPri: 1
				init: plane
				yourself:
			)
		)
	)

	(method (track param1 &tmp temp0)
		(cond
			((and boxRect (boxRect onMe: param1))
				(if
					(and
						(= temp0 (items firstTrue: #onMe param1))
						(!= temp0 curItem)
					)
					(if curItem
						(curItem hilite: 0)
					)
					(if temp0
						(temp0 hilite: 1)
					)
					(= curItem temp0)
				)
			)
			(curItem
				(curItem hilite: 0)
				(= curItem 0)
			)
		)
	)
)

(class SREdit of DEdit
	(properties
		value 0
		celWidth 240
		number -1
	)

	(method (init param1 &tmp temp0 temp1 temp2)
		(= plane param1)
		(if
			(and
				(= temp0 ((plane cast:) selectBox:))
				(= temp1 (temp0 items:))
				(temp1 size:)
			)
			(= temp2 (temp1 at: 0))
			(= number (temp2 number:))
			(self setText: ((temp2 text:) data:))
			(= value 1)
			(((param1 cast:) okButton:) enable: 1)
		)
		(if (not text)
			(self setText: {})
			(= value 0)
			(((param1 cast:) okButton:) enable: 0)
		)
		(self setSize:)
		(super init: param1)
	)

	(method (action)
		(if (!= (plane type:) 0)
			(return)
		)
		(super action: &rest)
		(cond
			((text size:)
				(if (not value)
					(= value 1)
					(((plane cast:) okButton:) enable: 1)
				)
				(= number ((((plane cast:) selectBox:) items:) getNumber:))
			)
			(value
				(= value 0)
				(((plane cast:) okButton:) enable: 0)
			)
		)
	)

	(method (resetText param1 param2)
		(if (> argc 1)
			(= number param2)
		)
		(self setText: param1 setSize: draw: 1)
		(cond
			((text size:)
				(if (not value)
					(= value 1)
					(((plane cast:) okButton:) enable: 1)
				)
			)
			(value
				(= value 0)
				(((plane cast:) okButton:) enable: 0)
			)
		)
	)

	(method (update)
		(if (== (plane type:) 0)
			(super update:)
		else
			(= bitmap (bitmaps at: 0))
			(UpdateScreenItem self)
			(self setRect:)
		)
	)

	(method (setText param1 &tmp temp0 temp1 temp2 temp3)
		(super setText: param1)
		(if (and plane (== (plane type:) 0))
			(= temp3 (= temp0 (= temp1 (= temp2 0))))
			(= temp0 (Str with: {placeholder}))
			(Message msgGET 0 0 0 22 1 (temp0 data:)) ; "<PROTECTED>"
			(= temp2 (Str with: param1))
			(if (!= -1 (= temp1 (text strIndex: temp0)))
				(= temp3 temp2)
				(= temp2 (temp3 getLeft: temp1))
				(temp3 dispose:)
			)
			(= temp3 temp2)
			(= temp2 (temp3 getLeft: 36 32))
			(temp3 dispose:)
			(= temp3 0)
			(temp0 dispose:)
			(= temp0 0)
			(text dispose:)
			(= text 0)
			(super setText: (temp2 data:))
			(temp2 dispose:)
		)
	)
)

(class SRButton of TextButton
	(properties)

	(method (init param1 &tmp temp0)
		(= plane param1)
		(self setText: {} setSize:)
		(= temp0 (super init: &rest))
	)

	(method (confirm)
		(return 1)
	)

	(method (press param1)
		(if (and argc param1)
			(self hilite: 1)
			(|= state $0002)
		)
		(super press: param1 &rest)
	)

	(method (handleEvent event)
		(if responder
			(responder handleEvent: event)
		else
			(cond
				((not (not (& state $0020)))
					(event localize: plane)
					(self track: event)
					(if (& evMOUSERELEASE (event type:))
						(self press: 0)
						((gUser hogs:) pop:)
						(if (not (not (& state $0002)))
							(self action:)
						)
					)
					(FrameOut)
				)
				((& evMOUSEBUTTON (event type:))
					(self press: 1)
					((gUser hogs:) push: self 1)
					(gUser doit:)
				)
			)
			(event claimed: self)
		)
		(event claimed:)
	)
)

(class SROKButton of SRButton
	(properties)

	(method (action &tmp temp0)
		(= temp0 ((plane cast:) editItem:))
		(if (temp0 value:)
			(plane done: temp0)
		)
	)

	(method (setText)
		(cond
			(argc
				(super setText: &rest)
			)
			((and plane (plane respondsTo: #type))
				(switch (plane type:)
					(0
						(super setText: 64990 28 0 0 1)
					)
					(1
						(super setText: 64990 26 0 0 1)
					)
					(2
						(super setText: 64990 25 0 0 1)
					)
					(else
						(PrintDebug {Error, unknown plane type})
						(Empty self)
					)
				)
			)
			(else
				(PrintDebug {Error: no text to set})
				(Empty self)
			)
		)
	)
)

(class SRCancelButton of SRButton
	(properties)

	(method (action &tmp temp0)
		(plane number: -1 done:)
	)

	(method (setText)
		(if argc
			(super setText: &rest)
		else
			(super setText: 64990 22 0 0 1)
		)
	)
)

(class SRDeleteButton of SRButton
	(properties)

	(method (action &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp0 ((plane cast:) editItem:))
		(if (temp0 value:)
			(= temp2 (Str new:))
			(Save 6 (KArray 9 temp2) (gGame name:)) ; MakeSaveCatName, ArrayGetData
			((= temp3 (File new:)) name: (KArray 9 temp2) open: 2) ; ArrayGetData
			(= temp1 (((plane cast:) selectBox:) items:))
			(= temp7 (temp0 number:))
			(= temp0 (temp1 firstTrue: #usesNumber temp7))
			(= temp6 (temp1 indexOf: temp0))
			(= temp4 (temp1 size:))
			(= temp9 (Str new: 36))
			(for ((= temp5 0)) (< temp5 temp4) ((++ temp5))
				(if (!= temp5 temp6)
					(= temp0 (temp1 at: temp5))
					(= temp8 (temp0 number:))
					(temp3 writeWord: temp8)
					(temp9 copyToFrom: 0 ((temp0 text:) data:) 0 36)
					(temp3 write: (KArray 9 temp9) 36) ; ArrayGetData
				)
			)
			(temp9 dispose:)
			(temp3 writeWord: -1 close: dispose:)
			(Save 7 (temp2 data:) (gGame name:) temp7) ; MakeSaveFileName
			(FileIO fiUNLINK (temp2 data:))
			(temp2 dispose:)
			(plane number: -4 done:)
		)
	)

	(method (setText)
		(if argc
			(super setText: &rest)
		else
			(super setText: 64990 24 0 0 1)
		)
	)
)

(instance SRTitle of TitleBar ; UNUSED
	(properties
		celHeight 16
	)
)

(class SRUsage of TextView
	(properties
		x 10
		y 30
		celWidth 240
	)

	(method (init param1)
		(= plane param1)
		(self needsDoits: 0 needsEvents: 0)
		(self setText:)
		(self setSize:)
		(super init: param1)
	)

	(method (setText &tmp temp0)
		(if argc
			(super setText: &rest)
		else
			(= temp0
				(switch (plane type:)
					(0 11)
					(1 10)
					(2 30)
				)
			)
			(super setText: 64990 temp0 0 0 1)
		)
		(text width: 230 skip: borderColor back: borderColor)
	)
)

(class SRBox of Cel
	(properties)

	(method (new param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (+ 1 (- param3 param1)))
		(= temp1 (+ 1 (- param4 param2)))
		(= temp2 (super new:))
		(= temp3 (Bitmap 0 temp0 temp1 (not param5) param5)) ; Create
		(temp2
			x: param1
			y: param2
			left: param1
			top: param2
			right: param3
			bottom: param4
			bitmap: temp3
		)
		(return temp2)
	)
)

