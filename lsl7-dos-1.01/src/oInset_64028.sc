;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64028)
(include sci.sh)
(use Main)
(use oMainMenu)
(use ScrollBar)
(use TPSound)
(use TiledBitmap)
(use ModalPlane)
(use PushButton)
(use soFlashCyberSniff)
(use Actor)
(use System)

(public
	oInset 0
)

(local
	[local0 2] = [-1 -1]
	local2
	local3
	local4
)

(instance voInsetFrame of View ; UNUSED
	(properties
		cel 1
		view 60006
		fixPriority 1
	)
)

(instance foMove of MoveFeature
	(properties)
)

(instance oInset of ModalPlane
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18)
		(super init: &rest)
		(= temp4 (CelWide 60016 0 0))
		(= temp5 (CelHigh 60016 1 0))
		(= temp15 (+ temp4 10))
		(oReset init: self)
		(oOK init: self)
		(oCancel init: self)
		(= local3 global227)
		(= local2 global228)
		(= local4 global229)
		(= temp18 (+ 20 (oReset nWidth:) (oOK nWidth:) (oCancel nWidth:)))
		(= temp2 (Max temp15 temp18))
		(= temp3 (+ (* 3 temp5) (oReset nHeight:) 25))
		(= temp6 (TiledView new:))
		(temp6 view: 60019 init: temp2 temp3 0 1 self)
		(= temp9 (temp6 nWidth:))
		(= temp8 (temp6 nHeight:))
		(= temp7 (TextItem new:))
		(temp7
			font: global268
			nLeading: global269
			maxWidth: (- temp9 18)
			nMinWidth: (- temp9 12)
			fore: global274
			back: 255
			skip: 255
			border: 5
			bTileBorder: 1
			vTile: 60020
			text: (MakeMessageText 0 0 6 1 14)
			setPri: 50
			init: self
		)
		(+= temp8 (temp7 nHeight:))
		(if (== global304 -1)
			(= global304
				(+ (gThePlane left:) (/ (- (gThePlane getWidth:) temp9) 2))
			)
			(= global305
				(+ (gThePlane top:) (/ (- (gThePlane getHeight:) temp8) 2))
			)
		)
		(self
			setRect:
				global304
				global305
				(- (+ global304 temp9) 1)
				(- (+ global305 temp8) 1)
		)
		(UpdatePlane self)
		(= temp0 (temp6 nOffsetX:))
		(= temp1 (temp6 nOffsetY:))
		(temp6 posn: (temp6 x:) (+ (temp6 y:) (temp7 nHeight:)))
		(+= temp1 (temp7 nHeight:))
		(= temp16 (+ temp0 (/ (- temp2 temp15) 2)))
		(= temp17 (+ temp0 (/ (- temp2 temp18) 2)))
		(= temp14 (TextItem new:))
		(temp14
			font: global268
			nLeading: global269
			maxWidth: temp4
			nMinWidth: temp4
			fore: global274
			back: 255
			skip: 255
			text: (MakeMessageText 0 0 6 3 14)
			border: 0
			bTileBorder: 0
			setPri: 50
			init: self
			posn: (+ temp16 5) (+ temp1 5)
		)
		(oMusicScroll
			maxPosn: 100
			init: (self getMainCast:)
			posn: (+ temp16 5) (+ temp1 25)
			setPos: global227
		)
		(= temp13 (TextItem new:))
		(temp13
			font: global268
			nLeading: global269
			maxWidth: temp4
			nMinWidth: temp4
			fore: global274
			back: 255
			skip: 255
			text: (MakeMessageText 0 0 6 4 14)
			border: 0
			bTileBorder: 0
			setPri: 50
			init: self
			posn: (+ temp16 5) (+ temp1 temp5 10)
		)
		(oSFXScroll
			maxPosn: 100
			init: (self getMainCast:)
			posn: (+ temp16 5) (+ temp1 temp5 30)
			setPos: global228
		)
		(= temp12 (TextItem new:))
		(temp12
			font: global268
			nLeading: global269
			maxWidth: temp4
			nMinWidth: temp4
			fore: global274
			back: 255
			skip: 255
			text: (MakeMessageText 0 0 6 2 14)
			border: 0
			bTileBorder: 0
			setPri: 50
			init: self
			posn: (+ temp16 5) (+ temp1 15 temp5 temp5)
		)
		(oAudioScroll
			maxPosn: 100
			init: (self getMainCast:)
			posn: (+ temp16 5) (+ temp1 35 temp5 temp5)
			setPos: global229
		)
		(= temp10 (+ temp17 5))
		(= temp11 (+ temp1 20 (* 3 temp5)))
		(oReset posn: temp10 temp11)
		(+= temp10 (+ (oReset nWidth:) 5))
		(oCancel posn: temp10 temp11)
		(+= temp10 (+ (oCancel nWidth:) 5))
		(oOK posn: temp10 temp11)
		(UpdateScreenItem temp6)
		(UpdateScreenItem temp12)
		(UpdateScreenItem temp13)
		(UpdateScreenItem temp14)
		(UpdateScreenItem oAudioScroll)
		(UpdateScreenItem oSFXScroll)
		(UpdateScreenItem oMusicScroll)
		(UpdateScreenItem (oAudioScroll oThumb:))
		(UpdateScreenItem (oSFXScroll oThumb:))
		(UpdateScreenItem (oMusicScroll oThumb:))
		(UpdateScreenItem oReset)
		(UpdateScreenItem oCancel)
		(UpdateScreenItem oOK)
		(foMove init: self)
		(foMove makeTopBorder: (temp7 nHeight:))
	)

	(method (dispose)
		(oVolumeSound dispose:)
		(oMessageSound dispose:)
		(= global304 left)
		(= global305 top)
		(proc64000_3)
		(super dispose: &rest)
		(DisposeScript 64028)
	)
)

(instance oReset of TextButton
	(properties
		font 2510
		vTileOff 60013
		vTileOn 60014
		nLeading 3
	)

	(method (init)
		(= fore global272)
		(= back global273)
		(= text (MakeMessageText 0 0 5 1 14))
		(super init: &rest)
	)

	(method (doSelect &tmp temp0)
		(oMusicScroll setPos: 65 scrolled:)
		(oSFXScroll setPos: 60 scrolled:)
		(oAudioScroll setPos: 100 scrolled:)
	)
)

(instance oOK of DismissTextButton
	(properties
		font 2510
		vTileOff 60013
		vTileOn 60014
		nLeading 3
		bDefault 1
	)

	(method (init)
		(= fore global272)
		(= back global273)
		(= text (MakeMessageText 0 0 17 1 14))
		(super init: &rest)
	)
)

(instance oCancel of DismissTextButton
	(properties
		font 2510
		vTileOff 60013
		vTileOn 60014
		nLeading 3
	)

	(method (init)
		(= fore global272)
		(= back global273)
		(= text (MakeMessageText 0 0 51 1 14))
		(super init: &rest)
	)

	(method (doSelect)
		(proc64031_0 local3)
		(proc64031_1 local2)
		(proc64031_2 local4)
		(super doSelect: &rest)
	)
)

(instance oClose of DismissButton ; UNUSED
	(properties
		priority 100
		x 10
		y 10
		loop 4
		view 60017
		fixPriority 1
		bDefault 1
	)
)

(instance oMusicScroll of ScrollBar
	(properties
		priority 100
		view 60016
		fixPriority 1
		type 1
		vThumbView 60016
		lThumbLoop 2
	)

	(method (scrolled)
		(proc64031_0 (self getPos:))
	)
)

(instance oSFXScroll of ScrollBar
	(properties
		priority 100
		view 60016
		fixPriority 1
		type 1
		vThumbView 60016
		lThumbLoop 3
	)

	(method (scrolled)
		(proc64031_1 (self getPos:))
	)

	(method (stopThumb)
		(if (Random 0 1)
			(oVolumeSound playSound: 106)
		else
			(oVolumeSound playSound: 107)
		)
	)
)

(instance oAudioScroll of ScrollBar
	(properties
		priority 100
		view 60016
		fixPriority 1
		type 1
		vThumbView 60016
		lThumbLoop 1
	)

	(method (scrolled)
		(proc64031_2 (self getPos:))
	)

	(method (stopThumb)
		(oMessageSound playMessage: 0 0 6 6 0 14)
	)
)

(instance oVolumeSound of TPSound
	(properties)
)

(instance oMessageSound of TPSound
	(properties
		type 2
	)
)

