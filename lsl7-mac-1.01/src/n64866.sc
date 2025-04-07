;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64866)
(include sci.sh)
(use Main)
(use DialogPlane)
(use TPSelector)
(use TiledBitmap)
(use PushButton)
(use soFlashCyberSniff)
(use Str)
(use Array)
(use File)
(use System)

(public
	proc64866_0 0
	proc64866_1 1
	proc64866_2 2
)

(local
	local0
	local1
	local2
	local3
)

(procedure (proc64866_2 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 [temp15 2] temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26)
	(= temp9 (DialogPlane new:))
	(temp9 init: 0 0 1 1)
	(if argc
		(= local3 param1)
	else
		(= local3 0)
	)
	(= temp17 (* (GetTextWidth {M} global268 0) 36))
	(if (== local3 0)
		(= temp19 (MakeMessageText 26 0 0 1 64990)) ; "Restore"
	else
		(= temp19 (MakeMessageText 28 0 0 1 64990)) ; "Save"
	)
	(= temp20 (MakeMessageText 22 0 0 1 64990)) ; "Cancel"
	(= temp21 (MakeMessageText 24 0 0 1 64990)) ; "Delete"
	(= temp24
		(+
			(= temp24
				(Max
					(GetTextWidth temp19 global270 0)
					(GetTextWidth temp20 global270 0)
					(GetTextWidth temp21 global270 0)
				)
			)
			10
		)
	)
	(oBtnYes
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (Str with: temp19)
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp24
		value: 1
		bDefault: 1
		init: temp9
	)
	(oBtnUp
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (MakeMessageText 39 0 0 1 64990) ; "\1d"
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		init: temp9
	)
	(oBtnDown
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (MakeMessageText 40 0 0 1 64990) ; "\1e"
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		init: temp9
	)
	(oBtnCancel
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (Str with: temp20)
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp24
		value: 0
		init: temp9
	)
	(oBtnDelete
		font: global270
		nLeading: global271
		fore: global272
		back: global273
		text: (Str with: temp21)
		bTileBorder: 1
		vTileOff: global276
		vTileOn: global277
		nMinWidth: temp24
		init: temp9
	)
	(proc64896_7 temp19)
	(proc64896_7 temp20)
	(proc64896_7 temp21)
	(oSelector
		font: global268
		fore: global272
		back: global273
		length: 12
		width: 300
		init: (temp9 getMainCast:)
	)
	(localproc_2 oSelector)
	(= temp3 (oSelector getHeight:))
	(= temp4 (oSelector getWidth:))
	(= temp8 (TiledView new:))
	(temp8 view: global277 init: temp4 temp3 0 1 temp9)
	(= temp25 (+ (temp8 nWidth:) 10 (oBtnYes nWidth:) (oBtnUp nWidth:)))
	(if (== local3 0)
		(= temp18 (TextItem new:))
		(temp18
			font: global268
			nLeading: global269
			fore: global274
			back: 255
			skip: 255
			mode: 0
			nMinWidth: temp25
			text: (Str with: { })
			init: temp9
		)
	else
		(= temp18 (EditItem new:))
		(temp18
			font: global268
			nLeading: global269
			fore: global274
			back: 255
			skip: 255
			mode: 0
			nMinWidth: (- temp25 12)
			border: 3
			nMaxChars: 36
			text: (Str with: { })
			bTileBorder: 1
			vTile: global277
			init: temp9
		)
	)
	(= local0 temp18)
	(= temp2 (+ (temp8 nHeight:) 15 (temp18 nHeight:)))
	(= temp1
		(Max
			(+ (temp18 nWidth:) 10)
			(+ (temp8 nWidth:) 20 (oBtnYes nWidth:) (oBtnUp nWidth:))
		)
	)
	(= temp7 (TiledView new:))
	(temp7 view: 60019 init: temp1 temp2 0 1 temp9)
	(= temp5 (temp7 nWidth:))
	(= temp6 (temp7 nHeight:))
	(if (== local3 0)
		(= temp22 (MakeMessageText 20 0 0 1 64990)) ; "Restore a Game"
	else
		(= temp22 (MakeMessageText 21 0 0 1 64990)) ; "Save a Game"
	)
	(= temp10 (TextItem new:))
	(temp10
		font: global268
		nLeading: global269
		maxWidth: (- temp5 18)
		nMinWidth: (- temp5 12)
		fore: global274
		back: 255
		skip: 255
		text: temp22
		border: 3
		bTileBorder: 1
		vTile: 60020
		init: temp9
	)
	(+= temp6 (temp10 nHeight:))
	(= temp11 (+ (gThePlane left:) (/ (- (gThePlane getWidth:) temp5) 2)))
	(= temp12 (+ (gThePlane top:) (/ (- (gThePlane getHeight:) temp6) 2)))
	(temp9 setRect: temp11 temp12 (- (+ temp11 temp5) 1) (- (+ temp12 temp6) 1))
	(UpdatePlane temp9)
	(= temp13 (temp7 nOffsetX:))
	(= temp14 (temp7 nOffsetY:))
	(temp7 posn: (temp7 x:) (+ (temp7 y:) (temp10 nHeight:)))
	(UpdateScreenItem temp7)
	(+= temp14 (temp10 nHeight:))
	(temp18 posn: (+ temp13 5) (+ temp14 5))
	(UpdateScreenItem temp18)
	(temp8 posn: (+ temp13 5) (+ temp14 10 (temp18 nHeight:)))
	(UpdateScreenItem temp8)
	(oSelector
		posn: (+ (temp8 x:) (temp8 nOffsetX:)) (+ (temp8 y:) (temp8 nOffsetY:))
	)
	(oBtnUp posn: (+ (temp8 x:) (temp8 nWidth:) 5) (temp8 y:))
	(UpdateScreenItem oBtnUp)
	(oBtnDown
		posn:
			(oBtnUp x:)
			(- (+ (temp8 y:) (temp8 nHeight:)) (oBtnDown nHeight:))
	)
	(UpdateScreenItem oBtnDown)
	(oBtnYes posn: (+ (oBtnUp x:) (oBtnUp nWidth:) 5) (temp8 y:))
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
			(if (!= (= temp26 (oSelector find: global114)) -1)
				(oSelector doSelect: temp26)
			else
				(oSelector doSelect: (oSelector current:))
			)
		else
			(oSelector doSelect: (oSelector current:))
		)
	else
		(oBtnDelete disable:)
	)
	(localproc_0)
	(if (and (>= (oSelector nItems:) 20) (== local3 1))
		(TextDialog (MakeMessageText 0 0 35 1 14) (Str with: global288)) ; "That's as many games as you can save in one directory. Delete a game before saving another. Besides, you can't "die" in this game, and we automatically save your position when you quit, so you don't need so many games after all."
		(oBtnYes disable:)
	)
	(if (and (<= (oSelector nItems:) 0) (== local3 0))
		(oBtnYes disable:)
	)
	(FrameOut)
	(if (== local3 1)
		(temp18 doVerb:)
	)
	(temp9 sitNSpin:)
)

(procedure (proc64866_1)
	(if (proc64866_2 0)
		(FrameOut)
		(gGame restoreThis: local2 local1)
	)
	(if local1
		(proc64896_7 local1)
		(= local1 0)
	)
	(DisposeScript 64866)
)

(procedure (proc64866_0)
	(if (proc64866_2 1)
		(FrameOut)
		(gGame saveThis: local2 local1)
	)
	(if local1
		(proc64896_7 local1)
		(= local1 0)
	)
	(DisposeScript 64866)
)

(procedure (localproc_0)
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

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(if (or (not argc) (not param1))
		(PrintDebug {Bad call of FillFileSelector})
		(return)
	)
	(= temp4 (Str new: 100))
	(Save 6 (temp4 data:) (gGame name:)) ; MakeSaveCatName
	((= temp5 (File new:)) name: (temp4 data:) open: 2)
	(if (not temp5)
		(return)
	)
	(= temp2 (param1 nItems:))
	(for ((= temp1 0)) (< temp1 temp2) ((++ temp1))
		(= temp3 (param1 getData: temp1))
		(if (= temp0 (param1 getText: temp1))
			(temp5 writeWord: temp3)
			(temp5 write: (temp0 data:) 36)
			(proc64896_7 temp0)
			(= temp0 0)
		)
	)
	(temp5 writeWord: -1 close: dispose:)
	(proc64896_7 temp4)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(if (or (not argc) (not param1))
		(return (PrintDebug {Bad call of FillFileSelector}))
	)
	(= temp1 (Str new: 720))
	(= temp2 (IntArray new: 21))
	(if (<= (= temp3 (Save 5 (gGame name:) (temp1 data:) (temp2 data:))) 0) ; GetSaveFiles
		(return 0)
	)
	(for ((= temp4 0)) (< temp4 temp3) ((++ temp4))
		(= temp0 (temp1 subStr: (* temp4 36) 36))
		(param1 addItem: temp0 (temp2 at: temp4))
		(temp0 dispose:)
	)
	(temp1 dispose:)
	(return (temp2 dispose:))
)

(instance oSelector of TPSelector
	(properties)

	(method (doSelect &tmp temp0)
		(if (== nItems 0)
			(return)
		)
		(super doSelect: &rest)
		(if local0
			(if (= temp0 (self getText:))
				(local0 setString: temp0)
				(proc64896_7 temp0)
			else
				(local0 setString: { })
			)
		)
	)

	(method (doDouble)
		(if (oBtnYes bEnabled:)
			(oBtnYes doSelect:)
		)
	)

	(method (delete)
		(super delete: &rest)
		(localproc_0)
	)
)

(instance oBtnYes of DismissTextButton
	(properties)

	(method (doSelect &tmp temp0)
		(= local1 0)
		(if local0
			(= local1 (local0 getText:))
		)
		(if (or (not local1) (<= (local1 size:) 0) (local1 compare: { }))
			(TextDialog (MakeMessageText 3 0 0 1 64990) (Str with: global288)) ; "You must type a description for the game."
			(return)
		)
		(if (== local3 1)
			(= temp0 (oSelector find: local1))
			(if (!= -1 temp0)
				(= local2 (oSelector getData: temp0))
			else
				(for ((= local2 0)) 1 ((++ local2))
					(if (== -1 (oSelector findData: local2))
						(break)
					)
				)
			)
		else
			(= temp0 (oSelector getSelectNum:))
			(= local2 (oSelector getData: temp0))
		)
		(if (and (== local3 1) (not (FileIO 17 2 (KArray 9 gCurSaveDir)))) ; CheckFreeSpace, ArrayGetData
			(TextDialog (MakeMessageText 30 0 0 1 64990) (Str with: global288)) ; "This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk."
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
		(localproc_0)
	)
)

(instance oBtnDown of TextButton
	(properties)

	(method (doSelect)
		(oSelector scrollDown:)
		(localproc_0)
	)
)

(instance oBtnDelete of TextButton
	(properties)

	(method (doSelect &tmp temp0 temp1 temp2 temp3 temp4)
		(if
			(not
				(YesNoDialog
					(MakeMessageText 12 0 0 1 64990) ; "Are you sure you want to delete this saved game?"
					(MakeMessageText 32 0 0 1 64990) ; "Yes"
					(MakeMessageText 31 0 0 1 64990) ; "No"
				)
			)
			(return)
		)
		(if (= temp0 (oSelector getText:))
			(= temp2 (oSelector getSelectNum:))
			(= temp1 (oSelector getData: temp2))
			(oSelector delete: temp2)
			(= temp3 (Str new: 100))
			(Save 7 (temp3 data:) (gGame name:) temp1) ; MakeSaveFileName
			(FileIO fiUNLINK (temp3 data:))
			(localproc_1 oSelector)
		)
		(if (not (= temp4 (oSelector nItems:)))
			(if (== local3 0)
				(oBtnYes disable:)
			)
			(self disable:)
		)
		(if (and (== local3 1) (< temp4 20))
			(oBtnYes enable:)
		)
	)
)

