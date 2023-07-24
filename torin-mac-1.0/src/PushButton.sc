;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64894)
(include sci.sh)
(use Main)
(use TiledBitmap)
(use n64896)
(use DEdit)
(use Str)
(use Array)
(use Actor)
(use System)

(class PushButton of View
	(properties
		oSelectNotify 0
		nSelectMethod 748
		nSelectValue 0
		oClickNotify 0
		nClickMethod 749
		oHeldNotify 0
		nHeldMethod 750
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

	(method (drawButton isHighlighted redraw)
		(if isHighlighted
			(= cel 1)
		else
			(= cel 0)
		)
		(= bIsHighlighted isHighlighted)
		(if (not bEnabled)
			(= cel 2)
		)
		(if (or (== 1 argc) (and (> 1 argc) redraw))
			(UpdateScreenItem self)
			(FrameOut)
		)
	)

	(method (stopHogging)
		(gOEventHandler unregisterEventHog: self)
		(= bImAHog 0)
		(self drawButton: 0 1)
	)

	(method (handleEvent event &tmp bOnMe)
		(if (not bEnabled)
			(return 0)
		)
		(= bOnMe (self onMe: event))
		(cond
			((== bImAHog 1)
				(if (!= bIsHighlighted bOnMe)
					(self drawButton: bOnMe 1)
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
			((and (== (event type:) evMOUSEBUTTON) bOnMe)
				(= bImAHog 1)
				(gOEventHandler registerEventHog: self)
				(self drawButton: 1 1)
				(self doClick:)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
		(event claimed:)
	)
)

(class ToggleButton of PushButton
	(properties
		bButtonDown 0
	)

	(method (setButton bDown)
		(= bButtonDown bDown)
		(self drawButton: bIsHighlighted 0)
	)

	(method (isButtonDown)
		(return bButtonDown)
	)

	(method (internalDoSelect)
		(= bButtonDown (not bButtonDown))
		(super internalDoSelect: &rest)
	)

	(method (drawButton isHighlighted redraw)
		(if isHighlighted
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
		(= bIsHighlighted isHighlighted)
		(if (or (== 1 argc) (and (> 1 argc) redraw))
			(UpdateScreenItem self)
			(FrameOut)
		)
	)
)

(class RadioButton of ToggleButton
	(properties
		oMyGroup 0
	)

	(method (setGroup loWhichGroup)
		(= oMyGroup loWhichGroup)
	)

	(method (setButton bDown)
		(if (and (not bButtonDown) oMyGroup)
			(oMyGroup doAllButMe: self 771 0)
		)
		(self realSetButton: bDown)
	)

	(method (realSetButton bDown)
		(= bButtonDown bDown)
		(self drawButton: bIsHighlighted 0)
	)

	(method (internalDoSelect)
		(if (not bButtonDown)
			(if oMyGroup
				(oMyGroup doAllButMe: self 767 0)
			)
			(super internalDoSelect: &rest)
		else
			(self drawButton: 0 1)
		)
	)
)

(class RadioGroup of List
	(properties)

	(method (doAllButMe moDont action &tmp node moThis)
		(for ((= node (self first:))) node ((= node (self next: node)))
			(if (!= (= moThis (KList 8 node)) moDont) ; NodeValue
				(moThis action: &rest)
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

	(method (init &tmp isHigh)
		(self setString: text)
		(super init: &rest)
		(self drawButton: bIsHighlighted 0)
	)

	(method (dispose &tmp bm bmOff bmOn)
		(if oPrivateText
			(oPrivateText dispose:)
			(= oPrivateText 0)
		)
		(if text
			(StringDispose text)
			(= text 0)
		)
		(= bm 0)
		(if bitmap
			(if (or (== bitmap bmpOff) (== bitmap bmpOn))
				(= bitmap 0)
			else
				(= bm bitmap)
				(= bitmap 0)
			)
		)
		(= bmOn bmpOn)
		(= bmOff bmpOff)
		(super dispose: &rest)
		(if bmOff
			(Bitmap 1 bmOff) ; Dispose
			(= bmOff 0)
		)
		(if bmOn
			(Bitmap 1 bmOn) ; Dispose
			(= bmOn 0)
		)
		(if bm
			(Bitmap 1 bm) ; Dispose
			(= bm 0)
		)
	)

	(method (setString str)
		(if oPrivateText
			(oPrivateText dispose:)
		)
		(if (and argc str)
			(= oPrivateText (Str with: (KString 9 str))) ; StrGetData
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

	(method (createBitmap &tmp textBox hlFore hlBack hlSkip normBack normFore normSkip nLeftBorder nRightBorder nTmpWidth nTmpHeight nTextWidth nTextHeight nOffX nOffY nExtraOffX bMustAddBack)
		(= bMustAddBack 0)
		(if bitmap
			(if (self isNotHidden:)
				(= bMustAddBack 1)
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
		(= textBox (IntArray new: 4))
		(Text 0 (textBox data:) (oPrivateText data:) font maxWidth 1) ; TextSize
		(= nTextWidth (+ (textBox at: 2) 1))
		(= nTextHeight (+ (textBox at: 3) 1))
		(= nWidth (+ nTextWidth border border))
		(= nHeight (- (+ nTextHeight border border) nLeading))
		(if (> nMinWidth nWidth)
			(= nExtraOffX (/ (- nMinWidth nWidth) 2))
			(= nWidth nMinWidth)
		else
			(= nExtraOffX 0)
		)
		(textBox dispose:)
		(= normFore fore)
		(= normBack back)
		(= normSkip skip)
		(= hlFore back)
		(= hlBack fore)
		(cond
			((== skip back)
				(= hlSkip fore)
			)
			((== skip fore)
				(= hlSkip back)
			)
			(else
				(= hlSkip skip)
			)
		)
		(if (!= vTileOff -1)
			(if (== back 255)
				(= normBack 254)
				(= normSkip 254)
			else
				(= normBack 255)
				(= normSkip 255)
			)
			(if (== hlBack 255)
				(= hlBack 254)
				(= hlSkip 254)
			else
				(= hlBack 254)
				(= hlSkip 254)
			)
			(if (== vTileOn -1)
				(PrintDebug
					{both vTile properties must be filled. button.sc djm}
				)
			)
			(TiledBitmap init: vTileOff nWidth nHeight 0 bTileBorder)
			(= bmpOff (TiledBitmap getBitmap: 1))
			(= nTmpWidth (TiledBitmap nWidth:))
			(= nTmpHeight (TiledBitmap nHeight:))
			(TiledBitmap init: vTileOn nWidth nHeight 0 bTileBorder)
			(= bmpOn (TiledBitmap getBitmap: 1))
			(= nOffX (+ (TiledBitmap nOffsetX:) border))
			(= nOffY (+ (TiledBitmap nOffsetY:) border))
			(= nLeftBorder (+ (TiledBitmap nLeftBorderWidth:) border))
			(= nRightBorder (+ (TiledBitmap nRightBorderWidth:) border))
			(= nWidth (TiledBitmap nWidth:))
			(= nHeight (TiledBitmap nHeight:))
			(if (or (!= nWidth nTmpWidth) (!= nHeight nTmpHeight))
				(PrintDebug
					{the on and off tiles of TextButton are not the same size}
				)
			)
		else
			(= bmpOff (Bitmap 0 nWidth nHeight normSkip normBack 640 480)) ; Create
			(Bitmap 5 bmpOff 0 0 (- nWidth 1) (- nHeight 1) normBack) ; AddRect
			(= bmpOn (Bitmap 0 nWidth nHeight hlSkip hlBack 640 480)) ; Create
			(Bitmap 5 bmpOn 0 0 (- nWidth 1) (- nHeight 1) hlBack) ; AddRect
			(= nOffX border)
			(= nOffY border)
			(= nLeftBorder border)
			(= nRightBorder border)
		)
		(cond
			((== mode 1)
				(+= nOffX nExtraOffX)
			)
			((== mode 0)
				(= nOffX nLeftBorder)
			)
			((== mode 2)
				(= nOffX (- nWidth (+ nRightBorder nTextWidth)))
			)
		)
		(Bitmap
			4 ; AddText
			bmpOff
			(oPrivateText data:)
			nOffX
			nOffY
			(- (+ nOffX nTextWidth) 1)
			(- (+ nOffY nTextHeight) 1)
			normFore
			normBack
			normSkip
			font
			mode
			normBack
			dimmed
		)
		(Bitmap
			4 ; AddText
			bmpOn
			(oPrivateText data:)
			nOffX
			nOffY
			(- (+ nOffX nTextWidth) 1)
			(- (+ nOffY nTextHeight) 1)
			hlFore
			hlBack
			hlSkip
			font
			mode
			hlBack
			dimmed
		)
		(= bitmap bmpOff)
		(if bMustAddBack
			(AddScreenItem self)
		)
	)

	(method (drawButton isHighlighted redraw &tmp [temp0 3])
		(= bIsHighlighted isHighlighted)
		(if bIsHighlighted
			(= bitmap bmpOn)
		else
			(= bitmap bmpOff)
		)
		(if (or (== 1 argc) (and (> argc 1) redraw))
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
		(self createBitmap:)
		(super init: &rest)
	)

	(method (doVerb))

	(method (draw)
		(self createBitmap:)
	)

	(method (dispose &tmp bm)
		(if text
			(StringDispose text)
			(= text 0)
		)
		(= bm 0)
		(if bitmap
			(= bm bitmap)
			(= bitmap 0)
		)
		(super dispose:)
		(if bm
			(Bitmap 1 bm) ; Dispose
		)
	)

	(method (getText)
		(if text
			(return (Str with: text))
		else
			(return 0)
		)
	)

	(method (setString str)
		(if text
			(StringDispose text)
		)
		(if (and argc str)
			(= text (Str with: (KString 9 str))) ; StrGetData
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
		(Text 0 (temp0 data:) (KString 9 text) font maxWidth 1) ; TextSize, StrGetData
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
			(= bitmap (Bitmap 0 nWidth nHeight temp6 temp4 640 480)) ; Create
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
			(KString 9 text) ; StrGetData
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

	(method (dispose &tmp bm)
		(if text
			(StringDispose text)
			(= text 0)
		)
		(= bm 0)
		(if bitmap
			(= bm bitmap)
			(= bitmap 0)
		)
		(super dispose:)
		(if bm
			(Bitmap 1 bm) ; Dispose
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

	(method (setString str)
		(if text
			(StringDispose text)
		)
		(if (and argc str)
			(= text (Str with: (KString 9 str))) ; StrGetData
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
		(Text 0 (temp0 data:) (KString 9 text) font maxWidth 1) ; TextSize, StrGetData
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
			(= bitmap (Bitmap 0 nWidth nHeight temp6 temp4 640 480)) ; Create
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
			text: (KString 8 (KString 9 text)) ; StrDup, StrGetData
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

	(method (doSelect &tmp oTmpPlane)
		(if (plane respondsTo: #value)
			(plane value: value)
		)
		(plane dispose:)
	)
)

