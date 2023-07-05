;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64033)
(include sci.sh)
(use Main)
(use TiledBitmap)
(use ModalPlane)
(use PushButton)
(use n64896)
(use Actor)
(use System)

(public
	TextDialog 0
	SetDialogFont 1
	SetButtonFont 2
	SetDialogColors 3
	SetDialogViews 4
	YesNoDialog 5
)

(procedure (SetDialogFont nFont nLeading) ; UNUSED
	(if (< argc 2)
		(PrintDebug {illegal set of dialog font. gendialg.sc DJM})
		(return)
	)
	(= gnDialogFont nFont)
	(= gnDialogLeading nLeading)
)

(procedure (SetButtonFont nFont nLeading) ; UNUSED
	(if (< argc 2)
		(PrintDebug {illegal set of button font. gendialg.sc DJM})
		(return)
	)
	(= gnButtonFont nFont)
	(= gnButtonLeading nLeading)
)

(procedure (SetDialogColors nText nButtonUp nButtonDown) ; UNUSED
	(if (< argc 3)
		(PrintDebug {illegal set of dialog colors. gendialg.sc DJM})
		(return)
	)
	(= gnTextColor nText)
	(= gnButtonUpColor nButtonUp)
	(= gnButtonDownColor nButtonDown)
)

(procedure (SetDialogViews vDialogTile vButtonUpTile vButtonDownTile) ; UNUSED
	(if (< argc 3)
		(PrintDebug {illegal set of dialog colors. gendialg.sc DJM})
		(return)
	)
	(= gvDialogTile vDialogTile)
	(= gvButtonUpTile vButtonUpTile)
	(= gvButtonDownTile vButtonDownTile)
)

(procedure (TextDialog strText strButton strTitleParm nPosXParm nPosYParm nWidParm &tmp strTitle nMaxWidth nPosX nPosY nTextWidth nTextHeight nBtnWidth nBtnHeight nTotClientWidth nTotClientHeight oDialogPlane voBG oBtnOK oTitle nDialogWidth nDialogHeight nOffX nOffY nButtonPosX nButtonPosY oText vMyDialogBG)
	(if (or (< argc 2) (not strText) (not strButton))
		(if strText
			(StringDispose strText)
		)
		(if strButton
			(StringDispose strButton)
		)
		(PrintDebug {illegal call of TextDialog. gendialg.sc DJM})
		(return)
	)
	(if (< argc 3)
		(= strTitle 0)
	else
		(= strTitle strTitleParm)
	)
	(if (< argc 4)
		(= nPosX -2)
	else
		(= nPosX nPosXParm)
	)
	(if (< argc 5)
		(= nPosY -2)
	else
		(= nPosY nPosYParm)
	)
	(if (< argc 6)
		(= nMaxWidth 300)
	else
		(= nMaxWidth nWidParm)
	)
	(= oDialogPlane (DialogPlane new:))
	(oDialogPlane init: 0 0 1 1)
	(= oText (TextItem new:))
	(oText
		font: gnDialogFont
		nLeading: gnDialogLeading
		maxWidth: nMaxWidth
		fore: gnTextColor
		back: 255
		skip: 255
		text: (KString 8 (KString 9 strText)) ; StrDup, StrGetData
		border: 0
		mode: 0
		bTileBorder: 0
		init: oDialogPlane
	)
	(= nTextWidth (oText nWidth:))
	(= nTextHeight (oText nHeight:))
	(= oBtnOK (DismissTextButton new:))
	(oBtnOK
		font: gnButtonFont
		nLeading: gnButtonLeading
		fore: gnButtonUpColor
		back: gnButtonDownColor
		text: (KString 8 (KString 9 strButton)) ; StrDup, StrGetData
		bTileBorder: 1
		vTileOff: gvButtonUpTile
		vTileOn: gvButtonDownTile
		bDefault: 1
		init: oDialogPlane
	)
	(= nBtnWidth (oBtnOK nWidth:))
	(= nBtnHeight (oBtnOK nHeight:))
	(= nTotClientWidth (+ (Max nTextWidth nBtnWidth) 10))
	(= nTotClientHeight (+ nTextHeight nBtnHeight 15))
	(if strTitle
		(= vMyDialogBG 60019)
	else
		(= vMyDialogBG gvDialogTile)
	)
	(= voBG (TiledView new:))
	(voBG view: vMyDialogBG init: nTotClientWidth nTotClientHeight 0 1 oDialogPlane)
	(= nDialogWidth (voBG nWidth:))
	(= nDialogHeight (voBG nHeight:))
	(if strTitle
		(= oTitle (TextItem new:))
		(oTitle
			font: gnDialogFont
			nLeading: gnDialogLeading
			maxWidth: (- nDialogWidth 10)
			nMinWidth: nDialogWidth
			fore: gnTextColor
			back: 255
			skip: 255
			text: (KString 8 (KString 9 strTitle)) ; StrDup, StrGetData
			border: 5
			bTileBorder: 0
			vTile: 60020
			init: oDialogPlane
		)
		(+= nDialogHeight (oTitle nHeight:))
	else
		(= oTitle 0)
	)
	(switch nPosX
		(-1
			(= nPosX (/ (- gScreenWidth nDialogWidth) 2))
		)
		(-2
			(= nPosX (+ (gThePlane left:) (/ (- (gThePlane getWidth:) nDialogWidth) 2)))
		)
	)
	(switch nPosY
		(-1
			(= nPosY (/ (- gScreenHeight nDialogHeight) 2))
		)
		(-2
			(= nPosY (+ (gThePlane top:) (/ (- (gThePlane getHeight:) nDialogHeight) 2)))
		)
	)
	(oDialogPlane setRect: nPosX nPosY (- (+ nPosX nDialogWidth) 1) (- (+ nPosY nDialogHeight) 1))
	(UpdatePlane oDialogPlane)
	(= nOffX (voBG nOffsetX:))
	(= nOffY (voBG nOffsetY:))
	(if oTitle
		(voBG posn: (voBG x:) (+ (voBG y:) (oTitle nHeight:)))
		(+= nOffY (oTitle nHeight:))
	)
	(oText posn: (+ nOffX 5) (+ nOffY 5))
	(= nButtonPosX (/ (- nDialogWidth nBtnWidth) 2))
	(= nButtonPosY (+ nOffY 10 nTextHeight))
	(oBtnOK posn: nButtonPosX nButtonPosY)
	(if strText
		(StringDispose strText)
	)
	(if strButton
		(StringDispose strButton)
	)
	(if strTitle
		(StringDispose strTitle)
	)
	(oDialogPlane sitNSpin:)
)

(procedure (YesNoDialog strText strYesButton strNoButton strTitleParm nPosXParm nPosYParm nWidParm &tmp strTitle nMaxWidth nPosX nPosY nTextWidth nTextHeight nBtnWidth nBtnHeight nTotClientWidth nTotClientHeight oDialogPlane voBG oBtnYes oBtnNo nDialogWidth nDialogHeight nOffX nOffY nButtonPosX nButtonPosY oText oTitle nMinBtnWidth vMyDialogBG)
	(if (or (< argc 3) (not strText) (not strYesButton) (not strNoButton))
		(if strText
			(StringDispose strText)
		)
		(if strNoButton
			(StringDispose strYesButton)
		)
		(if strYesButton
			(StringDispose strNoButton)
		)
		(PrintDebug {illegal call of YesNoDialog. gendialg.sc DJM})
		(return 0)
	)
	(if (< argc 4)
		(= strTitle 0)
	else
		(= strTitle strTitleParm)
	)
	(if (< argc 5)
		(= nPosX -2)
	else
		(= nPosX nPosXParm)
	)
	(if (< argc 6)
		(= nPosY -2)
	else
		(= nPosY nPosYParm)
	)
	(if (< argc 7)
		(= nMaxWidth 300)
	else
		(= nMaxWidth nWidParm)
	)
	(= oDialogPlane (DialogPlane new:))
	(oDialogPlane init: 0 0 1 1)
	(= oText (TextItem new:))
	(oText
		font: gnDialogFont
		nLeading: gnDialogLeading
		maxWidth: nMaxWidth
		fore: gnTextColor
		back: 255
		skip: 255
		text: (KString 8 (KString 9 strText)) ; StrDup, StrGetData
		mode: 0
		border: 0
		bTileBorder: 0
		init: oDialogPlane
	)
	(= nTextWidth (oText nWidth:))
	(= nTextHeight (oText nHeight:))
	(= nMinBtnWidth
		(+
			(= nMinBtnWidth
				(Max
					(GetTextWidth strYesButton gnButtonFont 0)
					(GetTextWidth strNoButton gnButtonFont 0)
				)
			)
			10
		)
	)
	(= oBtnYes (DismissTextButton new:))
	(oBtnYes
		font: gnButtonFont
		nLeading: gnButtonLeading
		fore: gnButtonUpColor
		back: gnButtonDownColor
		text: (KString 8 (KString 9 strYesButton)) ; StrDup, StrGetData
		bTileBorder: 1
		vTileOff: gvButtonUpTile
		vTileOn: gvButtonDownTile
		nMinWidth: nMinBtnWidth
		value: 1
		bDefault: 1
		init: oDialogPlane
	)
	(= oBtnNo (DismissTextButton new:))
	(oBtnNo
		font: gnButtonFont
		nLeading: gnButtonLeading
		fore: gnButtonUpColor
		back: gnButtonDownColor
		text: (KString 8 (KString 9 strNoButton)) ; StrDup, StrGetData
		bTileBorder: 1
		vTileOff: gvButtonUpTile
		vTileOn: gvButtonDownTile
		nMinWidth: nMinBtnWidth
		value: 0
		init: oDialogPlane
	)
	(= nBtnWidth (oBtnNo nWidth:))
	(= nBtnHeight (oBtnNo nHeight:))
	(= nTotClientWidth (+ (Max nTextWidth (+ nBtnWidth 5 nBtnWidth)) 10))
	(= nTotClientHeight (+ nTextHeight nBtnHeight 15))
	(if strTitle
		(= vMyDialogBG 60019)
	else
		(= vMyDialogBG gvDialogTile)
	)
	(= voBG (TiledView new:))
	(voBG view: vMyDialogBG init: nTotClientWidth nTotClientHeight 0 1 oDialogPlane)
	(= nDialogWidth (voBG nWidth:))
	(= nDialogHeight (voBG nHeight:))
	(if strTitle
		(= oTitle (TextItem new:))
		(oTitle
			font: gnDialogFont
			nLeading: gnDialogLeading
			maxWidth: (- nDialogWidth 10)
			nMinWidth: nDialogWidth
			fore: gnTextColor
			back: 255
			skip: 255
			text: (KString 8 (KString 9 strTitle)) ; StrDup, StrGetData
			border: 5
			bTileBorder: 0
			vTile: 60020
			init: oDialogPlane
		)
		(+= nDialogHeight (oTitle nHeight:))
	else
		(= oTitle 0)
	)
	(switch nPosX
		(-1
			(= nPosX (/ (- gScreenWidth nDialogWidth) 2))
		)
		(-2
			(= nPosX (+ (gThePlane left:) (/ (- (gThePlane getWidth:) nDialogWidth) 2)))
		)
	)
	(switch nPosY
		(-1
			(= nPosY (/ (- gScreenHeight nDialogHeight) 2))
		)
		(-2
			(= nPosY (+ (gThePlane top:) (/ (- (gThePlane getHeight:) nDialogHeight) 2)))
		)
	)
	(oDialogPlane setRect: nPosX nPosY (- (+ nPosX nDialogWidth) 1) (- (+ nPosY nDialogHeight) 1))
	(UpdatePlane oDialogPlane)
	(= nOffX (voBG nOffsetX:))
	(= nOffY (voBG nOffsetY:))
	(if oTitle
		(voBG posn: (voBG x:) (+ (voBG y:) (oTitle nHeight:)))
		(+= nOffY (oTitle nHeight:))
	)
	(oText posn: (+ nOffX 5) (+ nOffY 5))
	(= nButtonPosX (/ (- nDialogWidth (+ nBtnWidth nBtnWidth 5)) 2))
	(= nButtonPosY (+ nOffY 10 nTextHeight))
	(oBtnYes posn: nButtonPosX nButtonPosY)
	(oBtnNo posn: (+ nButtonPosX nBtnWidth 5) nButtonPosY)
	(if strText
		(StringDispose strText)
	)
	(if strYesButton
		(StringDispose strYesButton)
	)
	(if strNoButton
		(StringDispose strNoButton)
	)
	(if strTitle
		(StringDispose strTitle)
	)
	(return (oDialogPlane sitNSpin:))
)

(instance poNull of Prop ; UNUSED
	(properties)
)

(instance soDelayDispose of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(register dispose:)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(class DialogPlane of ModalPlane
	(properties
		picture -2
		priority 610
		bSpinning 0
		value 0
	)

	(method (dispose)
		(if bSpinning
			(= bSpinning 0)
			(return)
		)
		(super dispose: &rest)
	)

	(method (sitNSpin &tmp oEvent nReturn)
		(= bSpinning 1)
		(while bSpinning
			((self getMainCast:) doit:)
			(FrameOut)
			(= oEvent ((gUser curEvent:) new:))
			(gOEventHandler handleEvent: oEvent)
			(oEvent dispose:)
		)
		(= nReturn value)
		(self dispose:)
		(return nReturn)
	)
)

