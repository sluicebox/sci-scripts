;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64990)
(include sci.sh)
(use Main)
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

(procedure (GetStatus)
	(return
		(cond
			((== self Restore) 0)
			((HaveSpace) 1)
			(numGames 2)
			(else 3)
		)
	)
)

(procedure (GetDirectory where &tmp result newDir str buf1 len p theText ret)
	(= newDir (Str new:))
	(= str (Str new:))
	(= buf1 (Str new:))
	(repeat
		(= len (Min 45 (+ (Max 29 (+ (where size:) 6)) 11)))
		((= p (Print new:))
			font: 999
			fore: 0
			back: 255
			skip: 255
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
					font: 999
					fore: 0
					back: 255
					skip: 255
					setSize:
					moveTo: 19 14
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
			(GetCWD (newDir data:))
		)
		(if (ValidPath (newDir data:))
			(where copy: newDir)
			(= ret 1)
			(break)
		else
			(Message msgGET 64990 29 0 0 1 (buf1 data:)) ; "%s is not a valid directory."
			(str format: (buf1 data:) newDir)
			((Print new:)
				font: 999
				fore: 0
				back: 255
				largeAlp: 0
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

(procedure (HaveSpace)
	(if (< numGames 20)
		(CheckFreeSpace (KString 9 gCurSaveDir) 2) ; StrGetData
	)
)

(procedure (NeedDescription)
	((Print new:)
		font: 999
		fore: 0
		back: 255
		largeAlp: 0
		addText: 3 0 0 1 0 0 64990
		classButton: SRDButton
		addButton: 1 27 0 0 1 0 15 64990
		init:
	)
)

(class SRDialog of Dialog
	(properties)

	(method (init theComment names nums)
		(self add:)
		(= butbuf1 (Str new:))
		(= butbuf2 (Str new:))
		(= butbuf3 (Str new:))
		(= butbuf4 (Str new:))
		((= plane (gSystemPlane new:)) picture: -2 back: 255)
		(if (not (self update: theComment names nums))
			(return 0)
		)
		(Message msgGET 64990 24 0 0 1 (butbuf2 data:)) ; "Delete"
		(deleteI
			text: (KString 8 (butbuf2 data:)) ; StrDup
			setSize:
			moveTo: i (+ (okI nsBottom:) 2)
		)
		(Message msgGET 64990 23 0 0 1 (butbuf3 data:)) ; "Change Directory"
		(changeDirI
			text: (KString 8 (butbuf3 data:)) ; StrDup
			setSize:
			moveTo: i (+ (deleteI nsBottom:) 2)
			state: (& (changeDirI state:) $fff7)
		)
		(Message msgGET 64990 22 0 0 1 (butbuf4 data:)) ; "Cancel"
		(cancelI
			text: (KString 8 (butbuf4 data:)) ; StrDup
			setSize:
			moveTo: i (+ (changeDirI nsBottom:) 2)
			state: (& (cancelI state:) $fff7)
		)
		(self add: selectorI okI deleteI changeDirI cancelI textI)
		(super init:)
		(self setSize: center: eachElementDo: #updatePlane)
		(plane
			setRect:
				(- (plane left:) 15)
				(- (plane top:) 5)
				(+ (plane right:) 15)
				(+ (plane bottom:) 15)
				1
			setBitmap: 935 0 0 1
		)
		(return 1)
	)

	(method (update theComment names nums &tmp db buf)
		(if
			(==
				(= numGames
					(GetSaveFiles (gGlory name:) (names data:) (nums data:))
				)
				-1
			)
			(return 0)
		)
		(= theStatus (GetStatus))
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
		(textI
			text: (KString 8 (buf data:)) ; StrDup
			x: 13
			y: 12
			setSize: 240
			moveTo: 4 4
		)
		(buf dispose:)
		(deleteI state: (if (not numGames) 0 else 3))
		(if (== theStatus 1)
			(editI
				x: 13
				y: 5
				back: 255
				skip: 255
				font: gSmallFont
				text: ((theComment copy: {}) data:)
				width: 26
				setSize:
				moveTo: 4 30
			)
			(if (not (self contains: editI))
				(self add: editI)
				(if (self contains: okI)
					(editI plane: (self plane:))
					(editI draw:)
					(AddScreenItem editI)
				)
			)
		else
			(editI text: 0)
			(if (self contains: editI)
				(self delete: editI)
				(DeleteScreenItem editI)
				(if (editI bitmap:)
					(Bitmap 1 (editI bitmap:)) ; Dispose
					(editI bitmap: 0)
				)
			)
		)
		(if (and (selectorI textList:) ((selectorI textList:) size:))
			(selectorI setText: 0)
		)
		(selectorI
			current: 0
			font: gSmallFont
			width: 158
			setText: names
			setSize:
			moveTo: 4 44
			state: 2
		)
		(= db (butbuf1 data:))
		(switch theStatus
			(0
				(Message msgGET 64990 26 0 0 1 db) ; "Restore"
			)
			(1
				(Message msgGET 64990 28 0 0 1 db) ; "Save"
			)
			(else
				(Message msgGET 64990 25 0 0 1 db) ; "Replace"
			)
		)
		(= i (+ (selectorI nsRight:) 55))
		(okI
			x: 0
			y: 0
			text: (KString 8 db) ; StrDup
			setSize:
			moveTo: i (selectorI nsTop:)
			state:
				(if (or (and (== theStatus 0) (not numGames)) (== theStatus 3))
					0
				else
					3
				)
		)
		(if (self contains: okI)
			(textI draw:)
			(okI draw:)
			(selectorI draw:)
			(deleteI draw:)
			(UpdateScreenItem okI)
			(UpdateScreenItem textI)
			(UpdateScreenItem selectorI)
			(UpdateScreenItem deleteI)
			(FrameOut)
		)
		(return 1)
	)

	(method (doit theComment &tmp fd ret names nums str dir p tmpStr)
		(= names (Str new: 720))
		(= str (Str new:))
		(= dir (Str new:))
		(= nums (IntArray new: 21))
		(= saveColGray (Palette 3 127 127 127)) ; PalMatch
		(= ret 0)
		(if (and (== self Restore) argc theComment)
			(str format: {%ssg.cat} (gGlory name:))
			(if (== (= fd (FileIO fiOPEN (str data:))) -1)
				(return)
			)
			(FileIO fiCLOSE fd)
		)
		(if (not (self init: theComment names nums))
			(= ret -2)
		)
		(if (not ret)
			(repeat
				(= default
					(switch theStatus
						(0
							(if numGames okI else changeDirI)
						)
						(1 editI)
						(2 okI)
						(else changeDirI)
					)
				)
				(= i (super doit: default))
				(= selected (selectorI current:))
				(if (== i changeDirI)
					(if
						(and
							(GetDirectory gCurSaveDir)
							(not (self update: theComment names nums))
						)
						(= ret -2)
						(break)
					)
				else
					(if (and (== theStatus 2) (== i okI))
						(theComment
							copy:
								(((selectorI textList:)
										at: (selectorI current:)
									)
									text:
								)
						)
						(if
							((Print new:)
								font: 999
								fore: 0
								back: 255
								skip: 255
								largeAlp: 0
								addText: 33 0 0 1 0 0 64990
								addText: 34 0 0 1 0 30 64990
								classText: oldName
								addText: theComment 0 15
								addEdit: str 30 0 45 theComment
								classButton: SRDButton
								addButton: 1 33 0 0 1 0 60 64990
								addButton: 0 38 0 0 1 55 60 64990
								init:
							)
							(if (not (str size:))
								(NeedDescription)
								(continue)
							)
							(theComment copy: str)
							(= ret (nums at: selected))
							(break)
						)
						(continue)
					)
					(if (and (== theStatus 1) (OneOf i okI editI))
						(theComment copy: (editI text:))
						(if (not (theComment size:))
							(NeedDescription)
							(continue)
						)
						(= ret -1)
						(for ((= i 0)) (< i numGames) ((++ i))
							(= tmpStr (Str new: 36))
							(tmpStr copyToFrom: 0 names (* i 36) 36)
							(= ret (theComment compare: tmpStr))
							(tmpStr dispose:)
							(breakif ret)
						)
						(if ret
							(= ret (nums at: i))
							(break)
						)
						(if (== numGames 20)
							(= ret (nums at: selected))
							(break)
						)
						(for ((= ret 0)) 1 ((++ ret))
							(for ((= i 0)) (< i numGames) ((++ i))
								(breakif (== ret (nums at: i)))
							)
							(if (== i numGames)
								(break)
							)
						)
						(break)
					)
					(cond
						((== i deleteI)
							(if
								(not
									((Print new:)
										font: 999
										fore: 0
										back: 255
										skip: 255
										largeAlp: 0
										addText: 12 0 0 1 0 0 64990
										classButton: SRDButton
										addButton: 0 31 0 0 1 0 35 64990
										addButton: 1 32 0 0 1 50 35 64990
										init:
									)
								)
							else
								(MakeSaveCatName (str data:) (gGlory name:))
								((= fd (File new:))
									name: (str data:)
									open: 2
								)
								(for
									((= i 0))
									(< i numGames)
									((++ i))
									
									(if (!= i selected)
										(= ret (nums at: i))
										(str
											at: 0 (& ret $00ff)
											at: 1 (& (>> ret $0008) $00ff)
											at: 2 0
										)
										(fd write: (str data:) 2)
										(= tmpStr (Str new: 36))
										(tmpStr
											copyToFrom: 0 names (* i 36) 36
										)
										(fd write: (tmpStr data:) 36)
										(tmpStr dispose:)
									)
								)
								(str at: 0 255 at: 1 255)
								(fd write: (str data:) 2 close: dispose:)
								(MakeSaveFileName
									(str data:)
									(gGlory name:)
									(nums at: selected)
								)
								(FileIO fiUNLINK (str data:))
								(self update: theComment names nums)
							)
						)
						((== i okI)
							(= ret (nums at: selected))
							(break)
						)
						((or (== i -1) (== i cancelI))
							(= ret -1)
							(break)
						)
						(else
							(== theStatus 1)
						)
					)
				)
			)
		)
		(butbuf1 dispose:)
		(butbuf2 dispose:)
		(butbuf3 dispose:)
		(butbuf4 dispose:)
		(SRbuf dispose:)
		(names dispose:)
		(str dispose:)
		(dir dispose:)
		(nums dispose:)
		(DisposeScript 64993)
		(= p plane)
		(self dispose:)
		(p dispose:)
		(FrameOut)
		(DisposeScript 64990 ret)
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

	(method (updatePlane &tmp temp0 temp1 temp2)
		(listPlane posn: (listPlane left:) (listPlane top:) plane)
		(UpdatePlane listPlane)
		(= temp0
			(-
				(+
					(/ (- (listPlane bottom:) (listPlane top:)) 2)
					(listPlane top:)
				)
				(plane top:)
			)
		)
		(= temp1 (+ (- (listPlane right:) (plane left:)) 19))
		(= temp2 (CelHigh (upButton view:) (upButton loop:) (upButton cel:)))
		(upButton moveTo: temp1 (- temp0 (+ temp2 4)))
		(UpdateScreenItem upButton)
		(downButton moveTo: temp1 (+ temp0 4))
		(UpdateScreenItem downButton)
	)
)

(instance editI of DEdit
	(properties
		width 29
	)
)

(class SRDButton of DButton
	(properties
		view 64990
		fore 0
		font 999
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
		font 999
	)
)

(instance oldName of DText
	(properties
		borderColor 0
	)
)

