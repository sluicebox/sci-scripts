;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64990)
(include sci.sh)
(use Main)
(use MedalID)
(use DButton)
(use DSelector)
(use DEdit)
(use DText)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use File)
(use System)

(public
	GetDirectory 0
)

(local
	default
	i
	numGames
	selected
	theStatus
	butbuf1
	butbuf2
	butbuf3
	butbuf4
	SRbuf
	saveColGray
)

(procedure (GetDirectory where &tmp result newDir str buf1 len p theText ret)
	(= newDir (Str new:))
	(= str (Str new:))
	(= buf1 (Str new:))
	(repeat
		(= len (Min 45 (+ (Max 29 (+ (where size:) 6)) 11)))
		((= p (Print new:))
			font: 20071
			fore: 0
			back: saveColGray
			addEdit: (newDir copy: where) len 0 20 where
			classButton: SRDButton
			addButton: 1 27 0 0 1 0 34 64990
			addButton: 0 38 0 0 1 50 34 64990
		)
		(= theText (Str new:))
		(Message msgGET 64990 1 0 0 1 (theText data:)) ; "New save-game directory:"
		((p dialog:)
			add:
				((DText new:)
					text: (KString 8 (theText data:)) ; StrDup
					font: 20071
					fore: 0
					back: saveColGray
					skip: 254
					setSize:
					moveTo: 4 4
					yourself:
				)
		)
		(= result (p init:))
		(theText dispose:)
		(if (not result)
			(= ret 0)
			(break)
		)
		(if (not (newDir size:))
			(FileIO 18 (newDir data:)) ; GetCWD
		)
		(if (FileIO 19 (newDir data:)) ; ValidPath
			(where copy: newDir)
			(= ret 1)
			(break)
		else
			(Message msgGET 64990 29 0 0 1 (buf1 data:)) ; "%s is not a valid directory."
			(str format: (buf1 data:) newDir)
			((Print new:)
				font: 20071
				fore: 0
				back: saveColGray
				addText: (str data:)
				init:
			)
		)
	)
	(newDir dispose:)
	(str dispose:)
	(buf1 dispose:)
	(return ret)
)

(procedure (localproc_0)
	(if (< numGames 20)
		(FileIO 17 2 (KString 9 gCurSaveDir)) ; CheckFreeSpace, StrGetData
	)
)

(procedure (localproc_1)
	((Print new:)
		addBitmap: 207 0 0
		classButton: SRDButton
		addButtonBM: 207 1 0 {} 2 85 109
		init:
	)
)

(class SRDialog of Dialog
	(properties
		selectorObj 0
		editObj 0
		deleteObj 0
		changeDirObj 0
		okObj 0
		cancelObj 0
		textObj 0
		back 0
		fore 255
		buttonMargin 2
		useMsgFile 1
	)

	(method (init theComment names nums &tmp db)
		(self add:)
		(self initStrs:)
		((= plane (gSystemPlane new:)) back: (self back:))
		(if (not (self update: theComment names nums))
			(return 0)
		)
		(self initItems:)
		(if selectorObj
			(self add: selectorObj)
		)
		(if okObj
			(self add: okObj)
		)
		(if deleteObj
			(self add: deleteObj)
		)
		(if changeDirObj
			(self add: changeDirObj)
		)
		(if cancelObj
			(self add: cancelObj)
		)
		(if textObj
			(self add: textObj)
		)
		(super init:)
		(self setSize: center: eachElementDo: #updatePlane)
		(return 1)
	)

	(method (initStrs)
		(= butbuf1 (Str new:))
		(= butbuf2 (Str new:))
		(= butbuf3 (Str new:))
		(= butbuf4 (Str new:))
	)

	(method (initItems param1)
		(if argc
			(= i param1)
		)
		(if useMsgFile
			(Message msgGET 64990 24 0 0 1 (butbuf2 data:)) ; "Delete"
			(deleteObj text: (KString 8 (butbuf2 data:))) ; StrDup
		)
		(deleteObj setSize:)
		(self moveItems: 5)
		(if changeDirObj
			(if useMsgFile
				(Message msgGET 64990 23 0 0 1 (butbuf3 data:)) ; "Change Directory"
				(changeDirObj text: (KString 8 (butbuf3 data:))) ; StrDup
			)
			(changeDirObj setSize: state: (& (changeDirObj state:) $fff7))
			(self moveItems: 6)
		)
		(if useMsgFile
			(Message msgGET 64990 22 0 0 1 (butbuf4 data:)) ; "Cancel"
			(cancelObj text: (KString 8 (butbuf4 data:))) ; StrDup
		)
		(cancelObj setSize: state: (& (cancelObj state:) $fff7))
		(self moveItems: 4)
	)

	(method (update theComment names nums &tmp db buf)
		(if
			(==
				(= numGames
					(Save 5 (gGame name:) (names data:) (nums data:)) ; GetSaveFiles
				)
				-1
			)
			(return 0)
		)
		(= theStatus (self getStatus:))
		(if textObj
			(if useMsgFile
				(= buf (Str new:))
				(switch theStatus
					(0
						(Message msgGET 64990 10 0 0 1 (buf data:)) ; "Select the game that you would like to restore."
					)
					(1
						(Message msgGET 64990 11 0 0 1 (buf data:)) ; "Type the description of this saved game."
					)
					(else
						(Message msgGET 64990 30 0 0 1 (buf data:)) ; "This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk."
					)
				)
			)
			(textObj
				text:
					(if useMsgFile
						(KString 8 (buf data:)) ; StrDup
					else
						0
					)
				x: 0
				y: 0
				setSize: 240
			)
			(self moveItems: 7)
			(if useMsgFile
				(buf dispose:)
			)
		)
		(deleteObj state: (if (not numGames) 0 else 3))
		(if editObj
			(editObj
				x: 0
				y: 0
				back: (self back:)
				fore: (self fore:)
				font: 20071
				text: ((theComment copy: {}) data:)
				width: 20
				setSize:
			)
			(self moveItems: 1)
			(if (not (self contains: editObj))
				(self add: editObj)
				(if (self contains: okObj)
					(editObj plane: (self plane:))
					(editObj draw:)
				)
			)
		)
		(if (and (selectorObj textList:) ((selectorObj textList:) size:))
			(selectorObj setText: 0)
		)
		(selectorObj
			current: 0
			font: 20071
			back: (self back:)
			fore: (self fore:)
			width: 158
			setText: names
			setSize:
			state: 2
		)
		(self moveItems: 2)
		(self setupOkButn: theStatus)
		(okObj
			x: 0
			y: 0
			text:
				(if useMsgFile
					(KString 8 db) ; StrDup, UNINIT
				else
					0
				)
			setSize:
			state:
				(if (or (and (== theStatus 0) (not numGames)) (== theStatus 3))
					0
				else
					3
				)
		)
		(self moveItems: 3)
		(if (self contains: okObj)
			(if textObj
				(textObj draw:)
				(UpdateScreenItem textObj)
			)
			(okObj draw:)
			(selectorObj draw:)
			(deleteObj draw:)
			(UpdateScreenItem okObj)
			(UpdateScreenItem selectorObj)
			(UpdateScreenItem deleteObj)
			(FrameOut)
		)
		(return 1)
	)

	(method (setupOkButn param1 &tmp temp0)
		(if useMsgFile
			(= temp0 (butbuf1 data:))
			(switch param1
				(0
					(Message msgGET 64990 26 0 0 1 temp0) ; "Restore"
				)
				(1
					(Message msgGET 64990 28 0 0 1 temp0) ; "Save"
				)
				(else
					(Message msgGET 64990 25 0 0 1 temp0) ; "Replace"
				)
			)
		)
	)

	(method (setupObjs)
		(= selectorObj selectorI)
		(= editObj editI)
		(= deleteObj deleteI)
		(= changeDirObj changeDirI)
		(= okObj okI)
		(= cancelObj cancelI)
		(= textObj textI)
	)

	(method (doit theComment &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(self setupObjs:)
		(= temp2 (Str new: 720))
		(= temp4 (Str new:))
		(= temp5 (Str new:))
		(= temp3 (IntArray new: 21))
		(= saveColGray (Palette 3 127 127 127)) ; PalMatch
		(= temp1 0)
		(if (and (== (self getStatus:) 0) argc theComment)
			(temp4 format: {%ssg.cat} (gGame name:))
			(if (== (= temp0 (FileIO fiOPEN (temp4 data:))) -1)
				(return)
			)
			(FileIO fiCLOSE temp0)
		)
		(if (not (self init: theComment temp2 temp3))
			(= temp1 -2)
		)
		(if (not temp1)
			(repeat
				(= default (self getDefaultItem: theStatus numGames))
				(= i (super doit: default))
				(= selected (selectorObj current:))
				(if (and changeDirObj (== i changeDirObj))
					(if
						(and
							(GetDirectory gCurSaveDir)
							(not (self update: theComment temp2 temp3))
						)
						(= temp1 -2)
						(break)
					)
					(continue)
				)
				(if (and (== theStatus 2) (== i okObj))
					(temp4 copy: (editObj text:))
					(theComment
						copy:
							(((selectorI textList:) at: (selectorI current:))
								text:
							)
					)
					(if (self displayReplaceMsg: theComment temp4)
						(if (not (temp4 size:))
							(localproc_1)
							(continue)
						)
						(theComment copy: temp4)
						(= temp1 (temp3 at: selected))
						((= temp8 (MedalList new:))
							init:
							deleteID: temp1
							add: temp1
							write:
							dispose:
						)
						(break)
					)
					(continue)
				)
				(if (and (== theStatus 1) (OneOf i okObj editObj))
					(theComment copy: (editObj text:))
					(if (not (theComment size:))
						(localproc_1)
						(continue)
					)
					(= temp1 -1)
					(for ((= i 0)) (< i numGames) ((++ i))
						(= temp7 (Str new: 36))
						(temp7 copyToFrom: 0 temp2 (* i 36) 36)
						(= temp1 (theComment compare: temp7))
						(temp7 dispose:)
						(breakif temp1)
					)
					(if temp1
						(= temp1 (temp3 at: i))
						(break)
					)
					(if (== numGames 20)
						(PrintDebug {ERROR: (== numGame MAXGAMES)})
						(= temp1 (temp3 at: selected))
						(break)
					)
					(for ((= temp1 0)) 1 ((++ temp1))
						(for ((= i 0)) (< i numGames) ((++ i))
							(breakif (== temp1 (temp3 at: i)))
						)
						(if (== i numGames)
							(break)
						)
					)
					(break)
				)
				(cond
					((== i deleteObj)
						(if (not (self displayDeleteMsg:))
						else
							(Save 6 (temp4 data:) (gGame name:)) ; MakeSaveCatName
							((= temp0 (File new:)) name: (temp4 data:) open: 2)
							(for ((= i 0)) (< i numGames) ((++ i))
								(if (!= i selected)
									(= temp1 (temp3 at: i))
									(temp4
										at: 0 (& temp1 $00ff)
										at: 1 (& (>> temp1 $0008) $00ff)
										at: 2 0
									)
									(temp0 write: (temp4 data:) 2)
									(= temp7 (Str new: 36))
									(temp7 copyToFrom: 0 temp2 (* i 36) 36)
									(temp0 write: (temp7 data:) 36)
									(temp7 dispose:)
								)
							)
							(temp4 at: 0 255 at: 1 255)
							(temp0 write: (temp4 data:) 2 close: dispose:)
							(Save
								7 ; MakeSaveFileName
								(temp4 data:)
								(gGame name:)
								(temp3 at: selected)
							)
							(FileIO fiUNLINK (temp4 data:))
							((= temp8 (MedalList new:))
								init:
								deleteID: (temp3 at: selected)
								dispose:
							)
							(self update: theComment temp2 temp3)
						)
					)
					((== i okObj)
						(= temp1 (temp3 at: selected))
						(break)
					)
					((or (== i -1) (== i cancelObj))
						(= temp1 -1)
						(break)
					)
					(else
						(== theStatus 1)
					)
				)
			)
		)
		(if useMsgFile
			(butbuf1 dispose:)
			(butbuf2 dispose:)
			(butbuf3 dispose:)
			(butbuf4 dispose:)
			(SRbuf dispose:)
		)
		(temp2 dispose:)
		(temp4 dispose:)
		(temp5 dispose:)
		(temp3 dispose:)
		(DisposeScript 64993)
		(= temp6 plane)
		(self dispose:)
		(temp6 dispose:)
		(FrameOut)
		(return temp1)
	)

	(method (moveItems param1)
		(if (and textObj (or (== param1 0) (== param1 7)))
			(textObj moveTo: 4 4)
		)
		(if (and editObj (or (== param1 0) (== param1 1)))
			(editObj moveTo: 4 30)
		)
		(if (and selectorObj (or (== param1 0) (== param1 2)))
			(selectorObj moveTo: 4 44)
		)
		(= i (+ (selectorObj nsRight:) 35))
		(if (and okObj (or (== param1 0) (== param1 3)))
			(okObj moveTo: i (selectorObj nsTop:))
		)
		(if (and deleteObj (or (== param1 0) (== param1 5)))
			(deleteObj moveTo: i (+ (okObj nsBottom:) buttonMargin))
		)
		(if (and changeDirObj (or (== param1 0) (== param1 6)))
			(changeDirObj moveTo: i (+ (deleteObj nsBottom:) buttonMargin))
		)
		(if (and cancelObj (or (== param1 0) (== param1 4)))
			(cancelObj
				moveTo:
					i
					(if changeDirObj
						(+ (changeDirObj nsBottom:) buttonMargin)
					else
						(+ (deleteObj nsBottom:) buttonMargin)
					)
			)
		)
	)

	(method (getDefaultItem param1 param2)
		(return
			(switch theStatus
				(0
					(if param2 okObj else changeDirObj)
				)
				(1 editObj)
				(2 okObj)
				(else changeDirObj)
			)
		)
	)

	(method (displayReplaceMsg param1 param2)
		((Print new:)
			font: 20071
			fore: 0
			back: (self back:)
			fore: (self fore:)
			addText: 33 0 0 1 0 0 64990
			addText: 34 0 0 1 0 30 64990
			classText: oldName
			addText: param1 0 15
			addEdit: param2 24 0 45 param1
			classButton: SRDButton
			addButton: 1 33 0 0 1 0 60 64990
			addButton: 0 38 0 0 1 55 60 64990
			init:
		)
	)

	(method (displayDeleteMsg)
		((Print new:)
			font: 20071
			fore: 0
			back: (self back:)
			fore: (self fore:)
			addText: 12 0 0 1 0 0 64990
			classButton: SRDButton
			addButton: 0 31 0 0 1 0 35 64990
			addButton: 1 32 0 0 1 50 35 64990
			init:
		)
	)

	(method (getStatus)
		(return
			(cond
				((== self Restore) 0)
				((localproc_0) 1)
				(numGames 2)
				(else 3)
			)
		)
	)
)

(class Restore of SRDialog
	(properties)

	(method (init)
		(= SRbuf (Str new:))
		(Message msgGET 64990 20 0 0 1 (SRbuf data:)) ; "Restore a Game"
		(= text (SRbuf data:))
		(super init: &rest)
	)
)

(class Save of SRDialog
	(properties)

	(method (init)
		(= SRbuf (Str new:))
		(Message msgGET 64990 21 0 0 1 (SRbuf data:)) ; "Save a Game"
		(= text (SRbuf data:))
		(super init: &rest)
	)
)

(instance selectorI of DSelector
	(properties
		length 8
	)

	(method (setText theText &tmp idx str bm oldData)
		(if (and theText (theText size:))
			(for ((= idx 0)) (theText at: idx) ((+= idx 36))
				(super setText: (= str (theText subStr: idx 36)))
				(str dispose:)
			)
		else
			(super setText: 0)
		)
		(if (and theText (editI text:) (editI bitmap:))
			(= str (Str new:))
			(= oldData (str data:))
			(str data: (editI text:))
			(if (not (textList size:))
				(str format: {})
			else
				(str format: {%s} ((textList at: current) text:))
			)
			(editI text: (str data:) draw:)
			(str data: oldData dispose:)
		)
	)

	(method (draw &tmp oldData str)
		(super draw: &rest)
		(if (and (editI text:) (textList size:) (editI bitmap:))
			(= str (Str new:))
			(= oldData (str data:))
			(str data: (editI text:))
			(str format: {%s} ((textList at: current) text:))
			(editI text: (str data:) draw:)
			(str data: oldData dispose:)
		)
	)
)

(instance editI of DEdit
	(properties
		width 23
	)
)

(class SRDButton of DButton
	(properties
		view 64990
		font 20071
	)
)

(instance okI of SRDButton
	(properties)
)

(instance cancelI of SRDButton
	(properties)
)

(instance deleteI of SRDButton
	(properties)
)

(instance changeDirI of SRDButton
	(properties
		loop 1
	)
)

(instance textI of DText
	(properties
		font 20071
	)
)

(instance oldName of DText
	(properties
		borderColor 0
	)
)

