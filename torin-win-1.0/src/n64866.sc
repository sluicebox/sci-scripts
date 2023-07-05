;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64866)
(include sci.sh)
(use Main)
(use DialogPlane)
(use TPSelector)
(use TiledBitmap)
(use PushButton)
(use n64896)
(use Str)
(use Array)
(use File)
(use System)

(public
	SaveAs 0
	Open 1
	OpenSaveDialog 2
)

(local
	oSaveTextItem
	oComment
	nSaveID
	nDialogType
)

(procedure (OpenSaveDialog nType &tmp oBtnOK nTotClientWidth nTotClientHeight nSelectorHeight nSelectorWidth nDialogWidth nDialogHeight voBG voSelectBG oDialogPlane oTitle nPosX nPosY nOffX nOffY [unused 2] nMaxTextWidth oSaveName strYes strCancel strDelete strTitle strTmp nMinBtnWidth nTextItemWidth nSelect)
	(= oDialogPlane (DialogPlane new:))
	(oDialogPlane init: 0 0 1 1)
	(if argc
		(= nDialogType nType)
	else
		(= nDialogType 0)
	)
	(= nMaxTextWidth (* (GetTextWidth {M} gnDialogFont 0) 36))
	(if (== nDialogType 0)
		(= strYes (MakeMessageText 26 0 0 1 64990))
	else
		(= strYes (MakeMessageText 28 0 0 1 64990))
	)
	(= strCancel (MakeMessageText 22 0 0 1 64990))
	(= strDelete (MakeMessageText 24 0 0 1 64990))
	(= nMinBtnWidth
		(+
			(= nMinBtnWidth
				(Max
					(GetTextWidth strYes gnButtonFont 0)
					(GetTextWidth strCancel gnButtonFont 0)
					(GetTextWidth strDelete gnButtonFont 0)
				)
			)
			10
		)
	)
	(oBtnYes
		font: gnButtonFont
		nLeading: gnButtonLeading
		fore: gnButtonUpColor
		back: gnButtonDownColor
		text: (Str with: strYes)
		bTileBorder: 1
		vTileOff: gvButtonUpTile
		vTileOn: gvButtonDownTile
		nMinWidth: nMinBtnWidth
		value: 1
		bDefault: 1
		init: oDialogPlane
	)
	(oBtnUp
		font: gnButtonFont
		nLeading: gnButtonLeading
		fore: gnButtonUpColor
		back: gnButtonDownColor
		text: (MakeMessageText 39 0 0 1 64990)
		bTileBorder: 1
		vTileOff: gvButtonUpTile
		vTileOn: gvButtonDownTile
		init: oDialogPlane
	)
	(oBtnDown
		font: gnButtonFont
		nLeading: gnButtonLeading
		fore: gnButtonUpColor
		back: gnButtonDownColor
		text: (MakeMessageText 40 0 0 1 64990)
		bTileBorder: 1
		vTileOff: gvButtonUpTile
		vTileOn: gvButtonDownTile
		init: oDialogPlane
	)
	(oBtnCancel
		font: gnButtonFont
		nLeading: gnButtonLeading
		fore: gnButtonUpColor
		back: gnButtonDownColor
		text: (Str with: strCancel)
		bTileBorder: 1
		vTileOff: gvButtonUpTile
		vTileOn: gvButtonDownTile
		nMinWidth: nMinBtnWidth
		value: 0
		init: oDialogPlane
	)
	(oBtnDelete
		font: gnButtonFont
		nLeading: gnButtonLeading
		fore: gnButtonUpColor
		back: gnButtonDownColor
		text: (Str with: strDelete)
		bTileBorder: 1
		vTileOff: gvButtonUpTile
		vTileOn: gvButtonDownTile
		nMinWidth: nMinBtnWidth
		init: oDialogPlane
	)
	(StringDispose strYes)
	(StringDispose strCancel)
	(StringDispose strDelete)
	(oSelector
		font: gnDialogFont
		fore: gnButtonUpColor
		back: gnButtonDownColor
		length: 12
		width: 300
		init: (oDialogPlane getMainCast:)
	)
	(FillFileSelector oSelector)
	(= nSelectorHeight (oSelector getHeight:))
	(= nSelectorWidth (oSelector getWidth:))
	(= voSelectBG (TiledView new:))
	(voSelectBG view: gvButtonDownTile init: nSelectorWidth nSelectorHeight 0 1 oDialogPlane)
	(= nTextItemWidth (+ (voSelectBG nWidth:) 10 (oBtnYes nWidth:) (oBtnUp nWidth:)))
	(if (== nDialogType 0)
		(= oSaveName (TextItem new:))
		(oSaveName
			font: gnDialogFont
			nLeading: gnDialogLeading
			fore: gnTextColor
			back: 255
			skip: 255
			mode: 0
			nMinWidth: nTextItemWidth
			text: (Str with: { })
			init: oDialogPlane
		)
	else
		(= oSaveName (EditItem new:))
		(oSaveName
			font: gnDialogFont
			nLeading: gnDialogLeading
			fore: gnTextColor
			back: 255
			skip: 255
			mode: 0
			nMinWidth: (- nTextItemWidth 12)
			border: 3
			nMaxChars: 36
			text: (Str with: { })
			bTileBorder: 1
			vTile: gvButtonDownTile
			init: oDialogPlane
		)
	)
	(= oSaveTextItem oSaveName)
	(= nTotClientHeight (+ (voSelectBG nHeight:) 15 (oSaveName nHeight:)))
	(= nTotClientWidth
		(Max
			(+ (oSaveName nWidth:) 10)
			(+ (voSelectBG nWidth:) 20 (oBtnYes nWidth:) (oBtnUp nWidth:))
		)
	)
	(= voBG (TiledView new:))
	(voBG view: 60019 init: nTotClientWidth nTotClientHeight 0 1 oDialogPlane)
	(= nDialogWidth (voBG nWidth:))
	(= nDialogHeight (voBG nHeight:))
	(if (== nDialogType 0)
		(= strTitle (MakeMessageText 20 0 0 1 64990))
	else
		(= strTitle (MakeMessageText 21 0 0 1 64990))
	)
	(= oTitle (TextItem new:))
	(oTitle
		font: gnDialogFont
		nLeading: gnDialogLeading
		maxWidth: (- nDialogWidth 10)
		nMinWidth: nDialogWidth
		fore: gnTextColor
		back: 255
		skip: 255
		text: strTitle
		border: 5
		bTileBorder: 0
		vTile: 60020
		init: oDialogPlane
	)
	(+= nDialogHeight (oTitle nHeight:))
	(= nPosX (+ (gThePlane left:) (/ (- (gThePlane getWidth:) nDialogWidth) 2)))
	(= nPosY (+ (gThePlane top:) (/ (- (gThePlane getHeight:) nDialogHeight) 2)))
	(oDialogPlane setRect: nPosX nPosY (- (+ nPosX nDialogWidth) 1) (- (+ nPosY nDialogHeight) 1))
	(UpdatePlane oDialogPlane)
	(= nOffX (voBG nOffsetX:))
	(= nOffY (voBG nOffsetY:))
	(voBG posn: (voBG x:) (+ (voBG y:) (oTitle nHeight:)))
	(UpdateScreenItem voBG)
	(+= nOffY (oTitle nHeight:))
	(oSaveName posn: (+ nOffX 5) (+ nOffY 5))
	(UpdateScreenItem oSaveName)
	(voSelectBG posn: (+ nOffX 5) (+ nOffY 10 (oSaveName nHeight:)))
	(UpdateScreenItem voSelectBG)
	(oSelector
		posn: (+ (voSelectBG x:) (voSelectBG nOffsetX:)) (+ (voSelectBG y:) (voSelectBG nOffsetY:))
	)
	(oBtnUp posn: (+ (voSelectBG x:) (voSelectBG nWidth:) 5) (voSelectBG y:))
	(UpdateScreenItem oBtnUp)
	(oBtnDown
		posn:
			(oBtnUp x:)
			(- (+ (voSelectBG y:) (voSelectBG nHeight:)) (oBtnDown nHeight:))
	)
	(UpdateScreenItem oBtnDown)
	(oBtnYes posn: (+ (oBtnUp x:) (oBtnUp nWidth:) 5) (voSelectBG y:))
	(UpdateScreenItem oBtnYes)
	(oBtnCancel posn: (oBtnYes x:) (+ (oBtnYes y:) (oBtnYes nHeight:) 5))
	(UpdateScreenItem oBtnCancel)
	(oBtnDelete
		posn: (oBtnCancel x:) (+ (oBtnCancel y:) (oBtnCancel nHeight:) 5)
	)
	(UpdateScreenItem oBtnDelete)
	(if (oSelector nItems:)
		(oBtnDelete enable:)
		(if global114
			(if (!= (= nSelect (oSelector find: global114)) -1)
				(oSelector doSelect: nSelect)
			else
				(oSelector doSelect: (oSelector current:))
			)
		else
			(oSelector doSelect: (oSelector current:))
		)
	else
		(oBtnDelete disable:)
	)
	(CheckScrollButtons)
	(if (and (>= (oSelector nItems:) 20) (== nDialogType 1))
		(TextDialog (MakeMessageText 0 0 35 1 0) (Str with: goDismissString))
		(oBtnYes disable:)
	)
	(if (and (<= (oSelector nItems:) 0) (== nDialogType 0))
		(oBtnYes disable:)
	)
	(if (== nDialogType 1)
		(oSaveName doVerb:)
	)
	(oDialogPlane sitNSpin:)
)

(procedure (Open)
	(if (OpenSaveDialog 0)
		(FrameOut)
		(gGame restoreThis: nSaveID oComment)
	)
	(if oComment
		(StringDispose oComment)
		(= oComment 0)
	)
	(DisposeScript 64866)
)

(procedure (SaveAs)
	(if (OpenSaveDialog 1)
		(FrameOut)
		(gGame saveThis: nSaveID oComment)
	)
	(if oComment
		(StringDispose oComment)
		(= oComment 0)
	)
	(DisposeScript 64866)
)

(procedure (CheckScrollButtons)
	(if (oSelector canScrollUp:)
		(oBtnUp enable:)
	else
		(oBtnUp disable:)
	)
	(if (oSelector canScrollDown:)
		(oBtnDown enable:)
	else
		(oBtnDown disable:)
	)
)

(procedure (WriteCatalog oSelectItem &tmp strTmp i nGames nGameID strFile oFile)
	(if (or (not argc) (not oSelectItem))
		(PrintDebug {Bad call of FillFileSelector})
		(return)
	)
	(= strFile (Str new: 100))
	(Save 6 (strFile data:) (gGame name:)) ; MakeSaveCatName
	((= oFile (File new:)) name: (strFile data:) open: 2)
	(if (not oFile)
		(PrintDebug {Can't create file directory in WriteCatalog})
		(return)
	)
	(= nGames (oSelectItem nItems:))
	(for ((= i 0)) (< i nGames) ((++ i))
		(= nGameID (oSelectItem getData: i))
		(if (= strTmp (oSelectItem getText: i))
			(oFile writeWord: nGameID)
			(oFile write: (strTmp data:) 36)
			(StringDispose strTmp)
			(= strTmp 0)
		)
	)
	(oFile writeWord: -1 close: dispose:)
	(StringDispose strFile)
)

(procedure (FillFileSelector oSelectItem &tmp strTmp oNames oNums nGames i)
	(if (or (not argc) (not oSelectItem))
		(return (PrintDebug {Bad call of FillFileSelector}))
	)
	(= oNames (Str new: 720))
	(= oNums (IntArray new: 21))
	(if (<= (= nGames (Save 5 (gGame name:) (oNames data:) (oNums data:))) 0) ; GetSaveFiles
		(return 0)
	)
	(for ((= i 0)) (< i nGames) ((++ i))
		(= strTmp (oNames subStr: (* i 36) 36))
		(oSelectItem addItem: strTmp (oNums at: i))
		(strTmp dispose:)
	)
	(oNames dispose:)
	(return (oNums dispose:))
)

(instance oSelector of TPSelector
	(properties)

	(method (doSelect &tmp strTmp)
		(super doSelect: &rest)
		(if oSaveTextItem
			(if (= strTmp (self getText:))
				(oSaveTextItem setString: strTmp)
				(StringDispose strTmp)
			else
				(oSaveTextItem setString: { })
			)
		)
	)

	(method (doDouble)
		(oBtnYes doSelect:)
	)

	(method (delete)
		(super delete: &rest)
		(CheckScrollButtons)
	)
)

(instance oBtnYes of DismissTextButton
	(properties)

	(method (doSelect &tmp nSelect)
		(= oComment 0)
		(if oSaveTextItem
			(= oComment (oSaveTextItem getText:))
		)
		(if (or (not oComment) (<= (oComment size:) 0) (oComment compare: { }))
			(TextDialog (MakeMessageText 3 0 0 1 64990) (Str with: goDismissString))
			(return)
		)
		(if (== nDialogType 1)
			(= nSelect (oSelector find: oComment))
			(if (!= -1 nSelect)
				(= nSaveID (oSelector getData: nSelect))
				(PrintDebug {name exists})
			else
				(for ((= nSaveID 0)) 1 ((++ nSaveID))
					(if (== -1 (oSelector findData: nSaveID))
						(break)
					)
				)
			)
		else
			(= nSelect (oSelector getSelectNum:))
			(= nSaveID (oSelector getData: nSelect))
		)
		(if (and (== nDialogType 1) (not (FileIO 17 2 (KString 9 gCurSaveDir)))) ; CheckFreeSpace, StrGetData
			(TextDialog (MakeMessageText 30 0 0 1 64990) (Str with: goDismissString))
			(oBtnCancel doSelect:)
			(return)
		)
		(super doSelect: &rest)
	)
)

(instance oBtnCancel of DismissTextButton
	(properties)
)

(instance oBtnUp of TextButton
	(properties)

	(method (doSelect)
		(oSelector scrollUp:)
		(CheckScrollButtons)
	)
)

(instance oBtnDown of TextButton
	(properties)

	(method (doSelect)
		(oSelector scrollDown:)
		(CheckScrollButtons)
	)
)

(instance oBtnDelete of TextButton
	(properties)

	(method (doSelect &tmp strName nGame nSelect strFile nGames)
		(if
			(not
				(YesNoDialog
					(MakeMessageText 12 0 0 1 64990)
					(MakeMessageText 32 0 0 1 64990)
					(MakeMessageText 31 0 0 1 64990)
				)
			)
			(return)
		)
		(if (= strName (oSelector getText:))
			(= nSelect (oSelector getSelectNum:))
			(= nGame (oSelector getData: nSelect))
			(oSelector delete: nSelect)
			(= strFile (Str new: 100))
			(Save 7 (strFile data:) (gGame name:) nGame) ; MakeSaveFileName
			(FileIO fiUNLINK (strFile data:))
			(WriteCatalog oSelector)
		)
		(if (not (= nGames (oSelector nItems:)))
			(if (== nDialogType 0)
				(oBtnYes disable:)
			)
			(self disable:)
		)
		(if (and (== nDialogType 1) (< nGames 20))
			(oBtnYes enable:)
		)
	)
)

