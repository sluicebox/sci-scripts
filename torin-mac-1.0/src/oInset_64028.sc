;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64028)
(include sci.sh)
(use Main)
(use oMainMenu)
(use ScrollBar)
(use TPSound)
(use TiledBitmap)
(use CueMe)
(use ModalPlane)
(use PushButton)
(use n64896)
(use Actor)

(public
	oInset 0
)

(local
	nSaveSFXVol = -1
	nSaveMusicVol = -1
)

(instance voInsetFrame of View ; UNUSED
	(properties
		fixPriority 1
		view 60006
		cel 1
	)
)

(instance foMove of MoveFeature
	(properties)
)

(instance oInset of ModalPlane
	(properties)

	(method (init &tmp oMainCast nOffX nOffY nClientWidth nClientHeight nScrollBarWidth nScrollBarHeight voBG oTitle nDialogHeight nDialogWidth nButtonPosX nButtonPosY oAudioTitle oSFXTitle oMusicTitle)
		(super init: &rest)
		(= oMainCast (self getMainCast:))
		(= nScrollBarWidth (CelWide 60016 0 0))
		(= nScrollBarHeight (CelHigh 60016 1 0))
		(= nClientWidth (+ nScrollBarWidth 10))
		(oClose init: oMainCast)
		(oReset init: oMainCast)
		(= nClientHeight (+ (* 3 nScrollBarHeight) (oReset nHeight:) 25))
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
			text: (MakeMessageText 0 0 10 1 0)
			setPri: 50
			init: self
		)
		(+= nDialogHeight (oTitle nHeight:))
		(if (== gnVolumePosX -1)
			(= gnVolumePosX
				(+ (gThePlane left:) (/ (- (gThePlane getWidth:) nDialogWidth) 2))
			)
			(= gnVolumePosY
				(+ (gThePlane top:) (/ (- (gThePlane getHeight:) nDialogHeight) 2))
			)
		)
		(self
			setRect:
				gnVolumePosX
				gnVolumePosY
				(- (+ gnVolumePosX nDialogWidth) 1)
				(- (+ gnVolumePosY nDialogHeight) 1)
		)
		(UpdatePlane self)
		(= nOffX (voBG nOffsetX:))
		(= nOffY (voBG nOffsetY:))
		(voBG posn: (voBG x:) (+ (voBG y:) (oTitle nHeight:)))
		(+= nOffY (oTitle nHeight:))
		(= oMusicTitle (TextItem new:))
		(oMusicTitle
			font: gnDialogFont
			nLeading: gnDialogLeading
			maxWidth: nScrollBarWidth
			nMinWidth: nScrollBarWidth
			fore: gnTextColor
			back: 255
			skip: 255
			text: (MakeMessageText 0 0 10 3 0)
			border: 0
			bTileBorder: 0
			setPri: 50
			init: self
			posn: (+ nOffX 5) (+ nOffY 5)
		)
		(oMusicScroll
			maxPosn: 100
			init: oMainCast
			posn: (+ nOffX 5) (+ nOffY 25)
			setPos: gMusicVol
		)
		(= oSFXTitle (TextItem new:))
		(oSFXTitle
			font: gnDialogFont
			nLeading: gnDialogLeading
			maxWidth: nScrollBarWidth
			nMinWidth: nScrollBarWidth
			fore: gnTextColor
			back: 255
			skip: 255
			text: (MakeMessageText 0 0 10 4 0)
			border: 0
			bTileBorder: 0
			setPri: 50
			init: self
			posn: (+ nOffX 5) (+ nOffY nScrollBarHeight 10)
		)
		(oSFXScroll
			maxPosn: 100
			init: oMainCast
			posn: (+ nOffX 5) (+ nOffY nScrollBarHeight 30)
			setPos: gSFXVol
		)
		(= oAudioTitle (TextItem new:))
		(oAudioTitle
			font: gnDialogFont
			nLeading: gnDialogLeading
			maxWidth: nScrollBarWidth
			nMinWidth: nScrollBarWidth
			fore: gnTextColor
			back: 255
			skip: 255
			text: (MakeMessageText 0 0 10 2 0)
			border: 0
			bTileBorder: 0
			setPri: 50
			init: self
			posn: (+ nOffX 5) (+ nOffY 15 nScrollBarHeight nScrollBarHeight)
		)
		(oAudioScroll
			maxPosn: 100
			init: oMainCast
			posn: (+ nOffX 5) (+ nOffY 35 nScrollBarHeight nScrollBarHeight)
			setPos: gAudioVol
		)
		(= nButtonPosX (/ (- nDialogWidth (oReset nWidth:)) 2))
		(= nButtonPosY (+ nOffY 20 (* 3 nScrollBarHeight)))
		(oReset posn: nButtonPosX nButtonPosY)
		(UpdateScreenItem voBG)
		(UpdateScreenItem oAudioTitle)
		(UpdateScreenItem oSFXTitle)
		(UpdateScreenItem oMusicTitle)
		(UpdateScreenItem oAudioScroll)
		(UpdateScreenItem oSFXScroll)
		(UpdateScreenItem oMusicScroll)
		(UpdateScreenItem (oAudioScroll oThumb:))
		(UpdateScreenItem (oSFXScroll oThumb:))
		(UpdateScreenItem (oMusicScroll oThumb:))
		(UpdateScreenItem oReset)
		(foMove init: self)
		(foMove makeTopBorder: (oTitle nHeight:))
	)

	(method (dispose)
		(oVolumeSound dispose:)
		(if (!= nSaveMusicVol -1)
			(SetSFXVol nSaveSFXVol)
			(SetMusicVol nSaveMusicVol)
			(= nSaveMusicVol -1)
			(= nSaveSFXVol -1)
		)
		(= gnVolumePosX left)
		(= gnVolumePosY top)
		(SavePrefs)
		(super dispose: &rest)
		(DisposeScript 64028)
	)
)

(instance oReset of MessageButton
	(properties
		case 30
		fore 234
		back 210
		font 2510
		vTileOff 60013
		vTileOn 60014
		nLeading 3
		module 0
	)

	(method (doSelect &tmp nSpeed)
		(oMusicScroll setPos: 40 scrolled:)
		(oSFXScroll setPos: 60 scrolled:)
		(oAudioScroll setPos: 100 scrolled:)
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
)

(instance oMusicScroll of ScrollBar
	(properties
		priority 100
		fixPriority 1
		view 60016
		type 1
		vThumbView 60016
		lThumbLoop 2
	)

	(method (scrolled)
		(SetMusicVol (self getPos:))
	)
)

(instance oSFXScroll of ScrollBar
	(properties
		priority 100
		fixPriority 1
		view 60016
		type 1
		vThumbView 60016
		lThumbLoop 3
	)

	(method (scrolled)
		(SetSFXVol (self getPos:))
	)

	(method (stopThumb)
		(oVolumeSound playSound: 60010)
	)
)

(instance oAudioScroll of ScrollBar
	(properties
		priority 100
		fixPriority 1
		view 60016
		type 1
		vThumbView 60016
		lThumbLoop 1
	)

	(method (scrolled)
		(SetAudioVol (self getPos:))
	)

	(method (stopThumb)
		(if (== nSaveSFXVol -1)
			(= nSaveSFXVol gSFXVol)
			(= nSaveMusicVol gMusicVol)
			(SetMusicVol (MulDiv 35 gMusicVol 100))
			(SetSFXVol (MulDiv 35 gSFXVol 100))
		)
		(oVolumeSound playMessage: 0 0 10 6 coResetVolumes 0)
	)
)

(instance coResetVolumes of CueMe
	(properties)

	(method (cue)
		(if (!= nSaveMusicVol -1)
			(SetSFXVol nSaveSFXVol)
			(SetMusicVol nSaveMusicVol)
			(= nSaveMusicVol -1)
			(= nSaveSFXVol -1)
		)
	)
)

(instance oVolumeSound of TPSound
	(properties)
)

