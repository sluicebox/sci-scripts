;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64035)
(include sci.sh)
(use Main)
(use oMainMenu)
(use ScrollBar)
(use TiledBitmap)
(use ModalPlane)
(use PushButton)
(use n64896)
(use Str)

(public
	oHintTimer 0
)

(local
	oTimeText
)

(instance foMove of MoveFeature
	(properties)
)

(instance oHintTimer of ModalPlane
	(properties)

	(method (init &tmp oMainCast nOffX nOffY nClientWidth nClientHeight nScrollBarWidth nScrollBarHeight voBG oTitle nDialogHeight nDialogWidth nScrollPos)
		(super init: &rest)
		(= oMainCast (self getMainCast:))
		(= nScrollBarWidth (CelWide 60018 0 0))
		(= nScrollBarHeight (CelHigh 60018 1 0))
		(= nClientWidth (+ nScrollBarWidth 10))
		(oClose init: oMainCast)
		(= oTimeText (TextItem new:))
		(oTimeText
			font: gnDialogFont
			nLeading: gnDialogLeading
			maxWidth: nScrollBarWidth
			nMinWidth: nScrollBarWidth
			fore: gnTextColor
			back: 255
			skip: 255
			text: (Str with: { })
			border: 0
			bTileBorder: 0
			setPri: 50
			init: self
		)
		(= nClientHeight (+ nScrollBarHeight (oTimeText nHeight:) 15))
		(= voBG (TiledView new:))
		(voBG view: 60019 init: nClientWidth nClientHeight 0 1 self)
		(= nDialogWidth (voBG nWidth:))
		(= nDialogHeight (voBG nHeight:))
		(= oTitle (TextItem new:))
		(oTitle
			font: gnDialogFont
			nLeading: gnDialogLeading
			maxWidth: (- nDialogWidth 10)
			nMinWidth: nDialogWidth
			fore: gnTextColor
			back: 255
			skip: 255
			border: 5
			bTileBorder: 0
			vTile: 60020
			text: (MakeMessageText 0 0 17 1 0)
			setPri: 50
			init: self
		)
		(+= nDialogHeight (oTitle nHeight:))
		(if (== gnHintTimerPosX -1)
			(= gnHintTimerPosX
				(+ (gThePlane left:) (/ (- (gThePlane getWidth:) nDialogWidth) 2))
			)
			(= gnHintTimerPosY
				(+ (gThePlane top:) (/ (- (gThePlane getHeight:) nDialogHeight) 2))
			)
		)
		(self
			setRect:
				gnHintTimerPosX
				gnHintTimerPosY
				(- (+ gnHintTimerPosX nDialogWidth) 1)
				(- (+ gnHintTimerPosY nDialogHeight) 1)
		)
		(UpdatePlane self)
		(= nOffX (voBG nOffsetX:))
		(= nOffY (voBG nOffsetY:))
		(voBG posn: (voBG x:) (+ (voBG y:) (oTitle nHeight:)))
		(+= nOffY (oTitle nHeight:))
		(cond
			((== gnHintTime -2)
				(= nScrollPos 0)
			)
			((== gnHintTime -1)
				(= nScrollPos 31)
			)
			(else
				(= nScrollPos gnHintTime)
			)
		)
		(oHintScroll
			maxPosn: 31
			init: oMainCast
			posn: (+ nOffX 5) (+ nOffY 5 (/ nScrollBarHeight 2))
			setPos: nScrollPos
			scrolled:
		)
		(oTimeText posn: (+ nOffX 5) (+ nOffY 10 nScrollBarHeight))
		(UpdateScreenItem voBG)
		(UpdateScreenItem oTimeText)
		(UpdateScreenItem oHintScroll)
		(UpdateScreenItem (oHintScroll oThumb:))
		(foMove init: self)
		(foMove makeTopBorder: (oTitle nHeight:))
	)

	(method (dispose)
		(= gnHintTimerPosX left)
		(= gnHintTimerPosY top)
		(= oTimeText 0)
		(super dispose: &rest)
	)
)

(instance oClose of DismissButton
	(properties
		x 10
		y 5
		priority 100
		fixPriority 1
		view 60017
		loop 4
		bDefault 1
	)

	(method (doSelect)
		(SavePrefs)
		(super doSelect: &rest)
	)
)

(instance oHintScroll of ScrollBar
	(properties
		priority 100
		fixPriority 1
		view 60018
		type 1
		vThumbView 60018
		lThumbLoop 1
	)

	(method (scrolled &tmp strTmp strTmp2 nPos)
		(cond
			((== (= nPos (self getPos:)) 0)
				(oTimeText setString: (MakeMessageText 0 0 17 4 0))
				(= gnHintTime -2)
			)
			((== nPos 31)
				(oTimeText setString: (MakeMessageText 0 0 17 3 0))
				(= gnHintTime -1)
			)
			(else
				(= gnHintTime nPos)
				(= strTmp (Str format: {%d } gnHintTime))
				(if (== gnHintTime 1)
					(= strTmp2 (MakeMessageText 0 0 17 5 0))
				else
					(= strTmp2 (MakeMessageText 0 0 17 2 0))
				)
				(strTmp cat: strTmp2)
				(strTmp2 dispose:)
				(oTimeText setString: strTmp)
			)
		)
	)
)

