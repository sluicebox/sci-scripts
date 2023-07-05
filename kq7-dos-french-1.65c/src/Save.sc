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
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
)

(procedure (GetStatus)
	(return
		(cond
			((== self Restore) 0)
			((HaveSpace) 1)
			(local2 2)
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
			fore: local11
			back: local10
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
					fore: local11
					back: local10
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
				fore: local11
				back: local10
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
	(if (< local2 20)
		(CheckFreeSpace (KString 9 gCurSaveDir) 2) ; StrGetData
	)
)

(procedure (NeedDescription)
	((Print new:)
		font: 999
		fore: local11
		back: local10
		addText: 3 0 0 1 0 0 64990
		classButton: SRDButton
		addButton: 1 27 0 0 1 0 15 64990
		init:
	)
)

(class SRDialog of Dialog
	(properties)

	(method (init theComment names nums &tmp db)
		(self add:)
		(= local5 (Str new:))
		(= local6 (Str new:))
		(= local7 (Str new:))
		(= local8 (Str new:))
		((= plane (gSystemPlane new:)) back: local10)
		(if (not (self update: theComment names nums))
			(return 0)
		)
		(Message msgGET 64990 24 0 0 1 (local6 data:)) ; "Delete"
		(deleteI
			text: (KString 8 (local6 data:)) ; StrDup
			setSize:
			moveTo: local1 (+ (okI nsBottom:) 2)
		)
		(Message msgGET 64990 23 0 0 1 (local7 data:)) ; "Change Directory"
		(changeDirI
			text: (KString 8 (local7 data:)) ; StrDup
			setSize:
			moveTo: local1 (+ (deleteI nsBottom:) 2)
			state: (& (changeDirI state:) $fff7)
		)
		(Message msgGET 64990 22 0 0 1 (local8 data:)) ; "Cancel"
		(cancelI
			text: (KString 8 (local8 data:)) ; StrDup
			setSize:
			moveTo: local1 (+ (changeDirI nsBottom:) 2)
			state: (& (cancelI state:) $fff7)
		)
		(self add: selectorI okI deleteI changeDirI cancelI textI)
		(super init:)
		(self setSize: center: eachElementDo: #updatePlane setSize:)
		(return 1)
	)

	(method (update theComment names nums &tmp db buf)
		(if
			(==
				(= local2
					(GetSaveFiles (gGame name:) (names data:) (nums data:))
				)
				-1
			)
			(return 0)
		)
		(= local4 (GetStatus))
		(= buf (Str new:))
		(switch local4
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
			fore: local11
			x: 0
			y: 0
			setSize: 240
			moveTo: 4 4
		)
		(buf dispose:)
		(deleteI state: (if (not local2) 0 else 3))
		(if (== local4 1)
			(editI
				x: 0
				y: 0
				back: local10
				fore: local11
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
			back: 255
			width: 158
			setText: names
			setSize:
			moveTo: 4 44
			state: 2
		)
		(= db (local5 data:))
		(switch local4
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
		(= local1 (+ (selectorI nsRight:) 35))
		(okI
			x: 0
			y: 0
			text: (KString 8 db) ; StrDup
			setSize:
			moveTo: local1 (selectorI nsTop:)
			state:
				(if (or (and (== local4 0) (not local2)) (== local4 3))
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
		(= local10 (Palette 3 127 127 127)) ; PalMatch
		(= local11 (Palette 3 0 0 0)) ; PalMatch
		(= ret 0)
		(if (and (== self Restore) argc theComment)
			(str format: {%ssg.cat} (gGame name:))
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
				(= local0
					(switch local4
						(0
							(if local2 okI else changeDirI)
						)
						(1 editI)
						(2 okI)
						(else changeDirI)
					)
				)
				(= local1 (super doit: local0))
				(= local3 (selectorI current:))
				(if (== local1 changeDirI)
					(if
						(and
							(GetDirectory gCurSaveDir)
							(not (self update: theComment names nums))
						)
						(= ret -2)
						(break)
					)
				else
					(if (and (== local4 2) (== local1 okI))
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
								fore: local11
								back: local10
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
							(= ret (nums at: local3))
							(break)
						)
						(continue)
					)
					(if (and (== local4 1) (OneOf local1 okI editI))
						(theComment copy: (editI text:))
						(if (not (theComment size:))
							(NeedDescription)
							(continue)
						)
						(= ret -1)
						(for ((= local1 0)) (< local1 local2) ((++ local1))
							(= tmpStr (Str new: 36))
							(tmpStr copyToFrom: 0 names (* local1 36) 36)
							(= ret (theComment compare: tmpStr))
							(tmpStr dispose:)
							(breakif ret)
						)
						(if ret
							(= ret (nums at: local1))
							(break)
						)
						(if (== local2 20)
							(= ret (nums at: local3))
							(break)
						)
						(for ((= ret 0)) 1 ((++ ret))
							(for ((= local1 0)) (< local1 local2) ((++ local1))
								(breakif (== ret (nums at: local1)))
							)
							(if (== local1 local2)
								(break)
							)
						)
						(break)
					)
					(cond
						((== local1 deleteI)
							(if
								(not
									((Print new:)
										font: 999
										fore: local11
										back: local10
										addText: 12 0 0 1 0 0 64990
										classButton: SRDButton
										addButton: 0 31 0 0 1 0 35 64990
										addButton: 1 32 0 0 1 50 35 64990
										init:
									)
								)
							else
								(MakeSaveCatName (str data:) (gGame name:))
								((= fd (File new:))
									name: (str data:)
									open: 2
								)
								(for
									((= local1 0))
									(< local1 local2)
									((++ local1))
									
									(if (!= local1 local3)
										(= ret (nums at: local1))
										(str
											at: 0 (& ret $00ff)
											at: 1 (& (>> ret $0008) $00ff)
											at: 2 0
										)
										(fd write: (str data:) 2)
										(= tmpStr (Str new: 36))
										(tmpStr
											copyToFrom: 0 names (* local1 36) 36
										)
										(fd write: (tmpStr data:) 36)
										(tmpStr dispose:)
									)
								)
								(str at: 0 255 at: 1 255)
								(fd write: (str data:) 2 close: dispose:)
								(MakeSaveFileName
									(str data:)
									(gGame name:)
									(nums at: local3)
								)
								(FileIO fiUNLINK (str data:))
								(self update: theComment names nums)
							)
						)
						((== local1 okI)
							(= ret (nums at: local3))
							(break)
						)
						((or (== local1 -1) (== local1 cancelI))
							(= ret -1)
							(break)
						)
						(else
							(== local4 1)
						)
					)
				)
			)
		)
		(local5 dispose:)
		(local6 dispose:)
		(local7 dispose:)
		(local8 dispose:)
		(local9 dispose:)
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
		(= local9 (Str new:))
		(Message msgGET 64990 20 0 0 1 (local9 data:)) ; "Restore a Game"
		(= text (local9 data:))
		(super init: &rest)
	)
)

(class Save of SRDialog
	(properties)

	(method (init)
		(= local9 (Str new:))
		(Message msgGET 64990 21 0 0 1 (local9 data:)) ; "Save a Game"
		(= text (local9 data:))
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
		width 29
	)
)

(class SRDButton of DButton
	(properties
		view 64990
		font 999
	)

	(method (init)
		(super init: &rest)
		(= fore local11)
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

