;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64894)
(include sci.sh)
(use Main)
(use TiledBitmap)
(use soFlashCyberSniff)
(use DEdit)
(use Str)
(use Array)
(use Actor)
(use System)

(class PushButton of View
	(properties
		oSelectNotify 0
		nSelectMethod 771
		nSelectValue 0
		oClickNotify 0
		nClickMethod 772
		oHeldNotify 0
		nHeldMethod 773
		bIsHighlighted 0
		bImAHog 0
		bEnabled 1
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		(= bImAHog 0)
		(self drawButton: 0 0)
	)

	(method (dispose)
		(if bImAHog
			(gOEventHandler unregisterEventHog: self)
		)
		(super dispose:)
	)

	(method (enable)
		(= bEnabled 1)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		(self drawButton: 0 0)
	)

	(method (disable)
		(= bEnabled 0)
		(self forceCursor: 0)
		(self drawButton: 0 0)
		(gOEventHandler unregisterEventHog: self)
	)

	(method (doSelect)
		(if oSelectNotify
			(Eval oSelectNotify nSelectMethod nSelectValue)
		)
	)

	(method (internalDoSelect)
		(self drawButton: 0 1)
		(self doSelect:)
	)

	(method (doClick)
		(if oClickNotify
			(Eval oClickNotify nClickMethod nSelectValue)
		)
	)

	(method (doHeld)
		(if oHeldNotify
			(Eval oHeldNotify nHeldMethod nSelectValue)
		)
	)

	(method (drawButton param1 param2)
		(if param1
			(= cel 1)
		else
			(= cel 0)
		)
		(= bIsHighlighted param1)
		(if (not bEnabled)
			(= cel 2)
		)
		(if (or (== 1 argc) (and (> 1 argc) param2))
			(UpdateScreenItem self)
			(FrameOut)
		)
	)

	(method (stopHogging)
		(gOEventHandler unregisterEventHog: self)
		(= bImAHog 0)
		(self drawButton: 0 1)
	)

	(method (handleEvent event &tmp temp0)
		(if (not bEnabled)
			(return 0)
		)
		(= temp0 (self onMe: event))
		(cond
			((== bImAHog 1)
				(if (!= bIsHighlighted temp0)
					(self drawButton: temp0 1)
				)
				(if bIsHighlighted
					(self doHeld:)
				)
				(if (== (event type:) evMOUSERELEASE)
					(gOEventHandler unregisterEventHog: self)
					(= bImAHog 0)
					(if bIsHighlighted
						(self internalDoSelect:)
					)
				)
				(event claimed: 1)
			)
			((and (== (event type:) evMOUSEBUTTON) temp0)
				(= bImAHog 1)
				(gOEventHandler registerEventHog: self)
				(self drawButton: 1 1)
				(self doClick:)
				(event claimed: 1)
			)
			(temp0
				(event claimed: 1)
			)
		)
		(event claimed:)
	)
)

(class ToggleButton of PushButton
	(properties
		bButtonDown 0
	)

	(method (setButton param1)
		(= bButtonDown param1)
		(self drawButton: bIsHighlighted 0)
	)

	(method (isButtonDown)
		(return bButtonDown)
	)

	(method (internalDoSelect)
		(= bButtonDown (not bButtonDown))
		(super internalDoSelect: &rest)
	)

	(method (drawButton param1 param2)
		(if param1
			(= cel 1)
		else
			(= cel 0)
		)
		(if bButtonDown
			(+= cel 2)
		)
		(if (not bEnabled)
			(= cel 4)
		)
		(= bIsHighlighted param1)
		(if (or (== 1 argc) (and (> 1 argc) param2))
			(UpdateScreenItem self)
			(FrameOut)
		)
	)
)

(class RadioButton of ToggleButton
	(properties
		oMyGroup 0
	)

	(method (setGroup param1)
		(= oMyGroup param1)
	)

	(method (setButton param1)
		(if (and (not bButtonDown) oMyGroup)
			(oMyGroup doAllButMe: self 790 0)
		)
		(self realSetButton: param1)
	)

	(method (realSetButton param1)
		(= bButtonDown param1)
		(self drawButton: bIsHighlighted 0)
	)

	(method (internalDoSelect)
		(if (not bButtonDown)
			(if oMyGroup
				(oMyGroup doAllButMe: self 786 0)
			)
			(super internalDoSelect: &rest)
		else
			(self drawButton: 0 1)
		)
	)
)

(class RadioGroup of List
	(properties)

	(method (doAllButMe param1 param2 &tmp temp0 temp1)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(if (!= (= temp1 (KList 8 temp0)) param1) ; NodeValue
				(temp1 param2: &rest)
			)
		)
	)

	(method (add)
		(super add: &rest)
		(self eachElementDo: #setGroup self)
	)
)

(class TextButton of PushButton
	(properties
		text 0
		fore 0
		back 254
		skip 254
		dimmed 0
		font 0
		mode 1
		border 3
		maxWidth 0
		nMinWidth 0
		vTileOff -1
		vTileOn -1
		bTileBorder 1
		nLeading 2
		nWidth 0
		nHeight 0
		oPrivateText 0
		bmpOff 0
		bmpOn 0
	)

	(method (init &tmp temp0)
		(self setString: text)
		(super init: &rest)
		(self drawButton: bIsHighlighted 0)
	)

	(method (dispose &tmp temp0 temp1 temp2)
		(if oPrivateText
			(oPrivateText dispose:)
			(= oPrivateText 0)
		)
		(if text
			(proc64896_7 text)
			(= text 0)
		)
		(= temp0 0)
		(if bitmap
			(if (or (== bitmap bmpOff) (== bitmap bmpOn))
				(= bitmap 0)
			else
				(= temp0 bitmap)
				(= bitmap 0)
			)
		)
		(= temp2 bmpOn)
		(= temp1 bmpOff)
		(super dispose: &rest)
		(if temp1
			(Bitmap 1 temp1) ; Dispose
			(= temp1 0)
		)
		(if temp2
			(Bitmap 1 temp2) ; Dispose
			(= temp2 0)
		)
		(if temp0
			(Bitmap 1 temp0) ; Dispose
			(= temp0 0)
		)
	)

	(method (setString param1)
		(if oPrivateText
			(oPrivateText dispose:)
		)
		(if (and argc param1)
			(= oPrivateText (Str with: (KArray 9 param1))) ; ArrayGetData
		else
			(= oPrivateText (Str with: { }))
		)
		(self createBitmap:)
	)

	(method (disable)
		(= bEnabled 0)
		(self createBitmap:)
		(super disable: &rest)
	)

	(method (enable)
		(= bEnabled 1)
		(self createBitmap:)
		(super enable: &rest)
	)

	(method (createBitmap &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16)
		(= temp16 0)
		(if bitmap
			(if (self isNotHidden:)
				(= temp16 1)
				(DeleteScreenItem self)
			)
			(if bmpOff
				(= bitmap 0)
				(Bitmap 1 bmpOff) ; Dispose
				(= bmpOff 0)
				(Bitmap 1 bmpOn) ; Dispose
				(= bmpOn 0)
			else
				(Bitmap 1 bitmap) ; Dispose
				(= bitmap 0)
			)
		)
		(if (not bEnabled)
			(= dimmed 1)
		else
			(= dimmed 0)
		)
		(= temp0 (IntArray new: 4))
		(Text 0 (temp0 data:) (oPrivateText data:) font maxWidth 1)
		(= temp11 (+ (temp0 at: 2) 1))
		(= temp12 (+ (temp0 at: 3) 1))
		(= nWidth (+ temp11 border border))
		(= nHeight (- (+ temp12 border border) nLeading))
		(if (> nMinWidth nWidth)
			(= temp15 (/ (- nMinWidth nWidth) 2))
			(= nWidth nMinWidth)
		else
			(= temp15 0)
		)
		(temp0 dispose:)
		(= temp5 fore)
		(= temp4 back)
		(= temp6 skip)
		(= temp1 back)
		(= temp2 fore)
		(cond
			((== skip back)
				(= temp3 fore)
			)
			((== skip fore)
				(= temp3 back)
			)
			(else
				(= temp3 skip)
			)
		)
		(if (!= vTileOff -1)
			(if (== back 255)
				(= temp4 254)
				(= temp6 254)
			else
				(= temp4 255)
				(= temp6 255)
			)
			(if (== temp2 255)
				(= temp2 254)
				(= temp3 254)
			else
				(= temp2 254)
				(= temp3 254)
			)
			(if (== vTileOn -1)
				(PrintDebug
					{both vTile properties must be filled. button.sc djm}
				)
			)
			(TiledBitmap init: vTileOff nWidth nHeight 0 bTileBorder)
			(= bmpOff (TiledBitmap getBitmap: 1))
			(= temp9 (TiledBitmap nWidth:))
			(= temp10 (TiledBitmap nHeight:))
			(TiledBitmap init: vTileOn nWidth nHeight 0 bTileBorder)
			(= bmpOn (TiledBitmap getBitmap: 1))
			(= temp13 (+ (TiledBitmap nOffsetX:) border))
			(= temp14 (+ (TiledBitmap nOffsetY:) border))
			(= temp7 (+ (TiledBitmap nLeftBorderWidth:) border))
			(= temp8 (+ (TiledBitmap nRightBorderWidth:) border))
			(= nWidth (TiledBitmap nWidth:))
			(= nHeight (TiledBitmap nHeight:))
			(if (or (!= nWidth temp9) (!= nHeight temp10))
				(PrintDebug
					{the on and off tiles of TextButton are not the same size}
				)
			)
		else
			(= bmpOff (Bitmap 0 nWidth nHeight temp6 temp4 640 480 1)) ; Create
			(Bitmap 5 bmpOff 0 0 (- nWidth 1) (- nHeight 1) temp4) ; AddRect
			(= bmpOn (Bitmap 0 nWidth nHeight temp3 temp2 640 480 1)) ; Create
			(Bitmap 5 bmpOn 0 0 (- nWidth 1) (- nHeight 1) temp2) ; AddRect
			(= temp13 border)
			(= temp14 border)
			(= temp7 border)
			(= temp8 border)
		)
		(cond
			((== mode 1)
				(+= temp13 temp15)
			)
			((== mode 0)
				(= temp13 temp7)
			)
			((== mode 2)
				(= temp13 (- nWidth (+ temp8 temp11)))
			)
		)
		(Bitmap
			4 ; AddText
			bmpOff
			(oPrivateText data:)
			temp13
			temp14
			(- (+ temp13 temp11) 1)
			(- (+ temp14 temp12) 1)
			temp5
			temp4
			temp6
			font
			mode
			temp4
			dimmed
		)
		(Bitmap
			4 ; AddText
			bmpOn
			(oPrivateText data:)
			temp13
			temp14
			(- (+ temp13 temp11) 1)
			(- (+ temp14 temp12) 1)
			temp1
			temp2
			temp3
			font
			mode
			temp2
			dimmed
		)
		(= bitmap bmpOff)
		(if temp16
			(AddScreenItem self)
		)
	)

	(method (drawButton param1 param2 &tmp [temp0 3])
		(= bIsHighlighted param1)
		(if bIsHighlighted
			(= bitmap bmpOn)
		else
			(= bitmap bmpOff)
		)
		(if (or (== 1 argc) (and (> argc 1) param2))
			(UpdateScreenItem self)
			(FrameOut)
		)
	)

	(method (hide)
		(super hide: &rest)
		(if bitmap
			(if bmpOff
				(= bitmap 0)
				(Bitmap 1 bmpOff) ; Dispose
				(= bmpOff 0)
				(if bmpOn
					(Bitmap 1 bmpOn) ; Dispose
					(= bmpOn 0)
				)
			else
				(Bitmap 1 bitmap) ; Dispose
				(= bitmap 0)
			)
		)
	)

	(method (show)
		(if (not bitmap)
			(self createBitmap:)
		)
		(super show: &rest)
	)
)

(class TextItem of View
	(properties
		text 0
		fore 0
		back 254
		skip 254
		dimmed 0
		font 0
		mode 1
		border 3
		maxWidth 0
		nMinWidth 0
		vTile -1
		bTileBorder 1
		nLeading 2
		nWidth 0
		nHeight 0
	)

	(method (init)
		(if (not text)
			(= text (Str with: { }))
		)
		(self createBitmap:)
		(super init: &rest)
	)

	(method (doVerb))

	(method (draw)
		(self createBitmap:)
	)

	(method (dispose &tmp temp0)
		(if text
			(proc64896_7 text)
			(= text 0)
		)
		(= temp0 0)
		(if bitmap
			(= temp0 bitmap)
			(= bitmap 0)
		)
		(super dispose:)
		(if temp0
			(Bitmap 1 temp0) ; Dispose
		)
	)

	(method (getText)
		(if text
			(return (Str with: text))
		else
			(return 0)
		)
	)

	(method (setString param1)
		(if text
			(proc64896_7 text)
		)
		(if (and argc param1)
			(= text (Str with: (KArray 9 param1))) ; ArrayGetData
		else
			(= text (Str with: { }))
		)
		(self createBitmap:)
	)

	(method (createBitmap &tmp temp0 [temp1 3] temp4 temp5 temp6 temp7 temp8 [temp9 2] temp11 temp12 temp13 temp14 temp15 temp16)
		(if (= temp16 bitmap)
			(DeleteScreenItem self)
			(Bitmap 1 bitmap) ; Dispose
		)
		(= temp0 (IntArray new: 4))
		(Text 0 (temp0 data:) (KArray 9 text) font maxWidth 1) ; ArrayGetData
		(= temp11 (+ (temp0 at: 2) 1))
		(= temp12 (+ (temp0 at: 3) 1))
		(= nWidth (+ temp11 border border))
		(= nHeight (- (+ temp12 border border) nLeading))
		(if (> nMinWidth nWidth)
			(= temp15 (/ (- nMinWidth nWidth) 2))
			(= nWidth nMinWidth)
		else
			(= temp15 0)
		)
		(temp0 dispose:)
		(= temp5 fore)
		(= temp4 back)
		(= temp6 skip)
		(if (!= vTile -1)
			(TiledBitmap init: vTile nWidth nHeight 0 bTileBorder)
			(= bitmap (TiledBitmap getBitmap: 1))
			(= temp13 (+ (TiledBitmap nOffsetX:) border))
			(= temp14 (+ (TiledBitmap nOffsetY:) border))
			(= temp7 (+ (TiledBitmap nLeftBorderWidth:) border))
			(= temp8 (+ (TiledBitmap nRightBorderWidth:) border))
			(= nWidth (TiledBitmap nWidth:))
			(= nHeight (TiledBitmap nHeight:))
		else
			(= bitmap (Bitmap 0 nWidth nHeight temp6 temp4 640 480 1)) ; Create
			(Bitmap 5 bitmap 0 0 (- nWidth 1) (- nHeight 1) temp4) ; AddRect
			(= temp13 border)
			(= temp14 border)
			(= temp7 border)
			(= temp8 border)
		)
		(cond
			((== mode 1)
				(+= temp13 temp15)
			)
			((== mode 0)
				(= temp13 temp7)
			)
			((== mode 2)
				(= temp13 (- nWidth (+ temp8 temp11)))
			)
		)
		(Bitmap
			4 ; AddText
			bitmap
			(KArray 9 text) ; ArrayGetData
			temp13
			temp14
			(- (+ temp13 temp11) 1)
			(- (+ temp14 temp12) 1)
			temp5
			temp4
			temp6
			font
			mode
			temp4
			dimmed
		)
		(if temp16
			(AddScreenItem self)
		)
	)
)

(class EditItem of View
	(properties
		text 0
		fore 0
		back 254
		skip 254
		dimmed 0
		font 0
		mode 0
		border 3
		maxWidth 0
		nMinWidth 0
		vTile -1
		bTileBorder 1
		nLeading 2
		nMaxChars 0
		nWidth 0
		nHeight 0
		oDEdit 0
		nOffX 0
		nOffY 0
	)

	(method (init)
		(self createBitmap:)
		(super init: &rest)
		(if oDEdit
			(oDEdit init: (plane getMainCast:))
			(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
		)
	)

	(method (doVerb)
		(if oDEdit
			(oDEdit hilite: 1)
		)
	)

	(method (draw)
		(self createBitmap:)
	)

	(method (dispose &tmp temp0)
		(if text
			(proc64896_7 text)
			(= text 0)
		)
		(= temp0 0)
		(if bitmap
			(= temp0 bitmap)
			(= bitmap 0)
		)
		(super dispose:)
		(if temp0
			(Bitmap 1 temp0) ; Dispose
		)
	)

	(method (getText)
		(cond
			(oDEdit
				(return (Str with: (oDEdit text:)))
			)
			(text
				(return (Str with: text))
			)
			(else
				(return 0)
			)
		)
	)

	(method (setString param1)
		(if text
			(proc64896_7 text)
		)
		(if (and argc param1)
			(= text (Str with: (KArray 9 param1))) ; ArrayGetData
		else
			(= text (Str with: { }))
		)
		(self createBitmap:)
	)

	(method (createBitmap &tmp temp0 [temp1 3] temp4 temp5 temp6 temp7 temp8 [temp9 2] temp11 temp12 temp13 temp14)
		(if (= temp14 bitmap)
			(DeleteScreenItem self)
			(Bitmap 1 bitmap) ; Dispose
		)
		(if oDEdit
			(oDEdit dispose:)
			(= oDEdit 0)
		)
		(= temp0 (IntArray new: 4))
		(Text 0 (temp0 data:) (KArray 9 text) font maxWidth 1) ; ArrayGetData
		(= temp11 (+ (temp0 at: 2) 1))
		(= temp12 (+ (temp0 at: 3) 1))
		(= nWidth (+ temp11 border border))
		(= nHeight (- (+ temp12 border border) nLeading))
		(if (> nMinWidth nWidth)
			(= temp13 (/ (- nMinWidth nWidth) 2))
			(= nWidth nMinWidth)
		else
			(= temp13 0)
		)
		(temp0 dispose:)
		(= temp5 fore)
		(= temp4 back)
		(= temp6 skip)
		(if (!= vTile -1)
			(TiledBitmap init: vTile nWidth nHeight 0 bTileBorder)
			(= bitmap (TiledBitmap getBitmap: 1))
			(= nOffX (+ (TiledBitmap nOffsetX:) border))
			(= nOffY (+ (TiledBitmap nOffsetY:) border))
			(= temp7 (+ (TiledBitmap nLeftBorderWidth:) border))
			(= temp8 (+ (TiledBitmap nRightBorderWidth:) border))
			(= nWidth (TiledBitmap nWidth:))
			(= nHeight (TiledBitmap nHeight:))
		else
			(= bitmap (Bitmap 0 nWidth nHeight temp6 temp4 640 480 1)) ; Create
			(Bitmap 5 bitmap 0 0 (- nWidth 1) (- nHeight 1) temp4) ; AddRect
			(= temp7 (= nOffY (= nOffX border)))
			(= temp8 border)
		)
		(cond
			((== mode 1)
				(+= nOffX temp13)
			)
			((== mode 0)
				(= nOffX temp7)
			)
			((== mode 2)
				(= nOffX (- nWidth (+ temp8 temp11)))
			)
		)
		(= oDEdit (DEdit new:))
		(oDEdit
			x: (+ x nOffX)
			y: (+ y nOffY)
			font: font
			fore: temp5
			back: 255
			skip: 255
			borderColor: 255
			text: (KArray 8 (KArray 9 text)) ; ArrayDup, ArrayGetData
			width: nMaxChars
			setPri: (+ priority 1)
			setSize:
		)
		(if plane
			(oDEdit init: (plane getMainCast:))
		)
		(if temp14
			(AddScreenItem self)
		)
	)

	(method (posn)
		(super posn: &rest)
		(self rePosn:)
	)

	(method (setPri)
		(super setPri: &rest)
		(self rePosn:)
	)

	(method (rePosn)
		(if oDEdit
			(oDEdit posn: (+ x nOffX) (+ y nOffY) setPri: (+ priority 1))
			(UpdateScreenItem oDEdit)
		)
	)
)

(class MessageButton of TextButton
	(properties
		verb 0
		seq 1
		module -1
	)

	(method (init)
		(if (== module -1)
			(= module gCurRoomNum)
		)
		(if text
			(text dispose:)
		)
		(= text (Str newWith: 100 {}))
		(if (not (Message msgGET module noun verb case seq (text data:)))
			(PrintDebug
				{cannot find message: %d %d %d %d %d}
				module
				noun
				verb
				case
				seq
			)
			(text format: {msg: %d %d %d %d %d} module noun verb case seq)
		)
		(super init: &rest)
	)
)

(class DismissButton of PushButton
	(properties
		value 0
		bDefault 0
		bCancel 1
	)

	(method (init)
		(super init: &rest)
		(gOEventHandler registerHandsOffActive: self)
		(if (or bDefault bCancel)
			(gOEventHandler registerKeyHandler: self)
		)
	)

	(method (dispose)
		(gOEventHandler unregisterKeyHandler: self)
		(gOEventHandler unregisterHandsOffActive: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (not bEnabled)
			(return 0)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE) bCancel)
			(event claimed: 1)
			(self doSelect:)
			(return 1)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN) bDefault)
			(event claimed: 1)
			(self doSelect:)
			(return 1)
		)
		(super handleEvent: event &rest)
	)

	(method (doSelect)
		(if (plane respondsTo: #value)
			(plane value: value)
		)
		(plane dispose:)
	)
)

(class DismissTextButton of TextButton
	(properties
		value 0
		bDefault 0
		bCancel 1
	)

	(method (init)
		(super init: &rest)
		(gOEventHandler registerHandsOffActive: self)
		(if (or bDefault bCancel)
			(gOEventHandler registerKeyHandler: self)
		)
	)

	(method (dispose)
		(gOEventHandler unregisterKeyHandler: self)
		(gOEventHandler unregisterHandsOffActive: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (not bEnabled)
			(return 0)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE) bCancel)
			(event claimed: 1)
			(self doSelect:)
			(return 1)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN) bDefault)
			(event claimed: 1)
			(self doSelect:)
			(return 1)
		)
		(super handleEvent: event &rest)
	)

	(method (doSelect &tmp temp0)
		(if (plane respondsTo: #value)
			(plane value: value)
		)
		(plane dispose:)
	)
)

