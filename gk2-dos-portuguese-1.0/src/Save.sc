;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64990)
(include sci.sh)
(use Main)
(use DButton)
(use DSelector)
(use DEdit)
(use DText)
(use DItem)
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
	[local5 4]
	local9
	local10
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
			font: 50
			fore: 11
			back: 4
			addEdit: (newDir copy: where) len 0 20 where
			classButton: SRDButton
			addButton: 1 27 0 0 1 0 42 64990
			addButton: 0 38 0 0 1 100 42 64990
		)
		(= theText (Str new:))
		(Message msgGET 64990 1 0 0 1 (theText data:)) ; "New save-game directory:"
		((p dialog:)
			add:
				((DText new:)
					text: (KString 8 (theText data:)) ; StrDup
					font: gUserFont
					fore: 11
					back: 4
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
				font: 50
				fore: 11
				back: 4
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
		(FileIO 17 2 (KString 9 gCurSaveDir)) ; CheckFreeSpace, StrGetData
	)
)

(procedure (NeedDescription)
	((Print new:)
		font: 50
		fore: 11
		back: 4
		addText: 3 0 0 1 0 0 64990
		classButton: SRDButton
		addButton: 1 27 0 0 1 0 36 64990
		init:
	)
)

(instance srBack of DItem
	(properties)
)

(class SRDialog of Dialog
	(properties)

	(method (init theComment names nums &tmp db)
		(self add:)
		(= plane (gSystemPlane new:))
		(if (not (self update: theComment names nums))
			(return 0)
		)
		(srBack view: (if (== local4 0) 146 else 145))
		(plane priority: 200)
		(if (== local4 0)
			(deleteI view: 146 loop: 2 x: 338 y: 227)
			(changeDirI view: 146 loop: 1 x: 338 y: 193)
			(cancelI view: 146 loop: 3 x: 338 y: 261)
		else
			(deleteI view: 145 loop: 4 x: 338 y: 131)
			(changeDirI view: 145 loop: 3 x: 338 y: 97)
			(cancelI view: 145 loop: 5 x: 338 y: 165)
		)
		(changeDirI state: (& (changeDirI state:) $fff7))
		(cancelI state: (& (cancelI state:) $fff7))
		(self add: selectorI okI deleteI changeDirI cancelI srBack)
		(super init:)
		(if (== local4 0)
			(= nsTop 24)
			(= nsLeft 20)
			(= nsRight 604)
			(= nsBottom 329)
			(self moveTo: 27 26)
		else
			(= nsTop 24)
			(= nsLeft 20)
			(= nsRight 409)
			(= nsBottom 329)
			(self moveTo: 124 26)
		)
		(plane setRect: nsLeft nsTop nsRight nsBottom)
		(self eachElementDo: #updatePlane)
		(return 1)
	)

	(method (update theComment names nums &tmp [temp0 2])
		(if
			(==
				(= local2
					(Save 5 (gGame name:) (names data:) (nums data:)) ; GetSaveFiles
				)
				-1
			)
			(return 0)
		)
		(= local4 (GetStatus))
		(deleteI state: (if (not local2) 0 else 3))
		(if (== local4 1)
			(editI
				x: 0
				y: 0
				fore: 15
				back: 0
				font: gUserFont
				text: ((theComment copy: {}) data:)
				width: 20
				setSize:
				moveTo: 24 37
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
				(if (gUser BAD_SELECTOR:)
					((gUser BAD_SELECTOR:) delete: editI)
				)
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
			font: gUserFont
			fore: 12
			back: 0
			width: 265
			setText: names
			setSize:
			moveTo: 24 71
			state: 2
		)
		(switch local4
			(0
				(okI view: 146 loop: 7 x: 338 y: 159)
			)
			(1
				(okI view: 145 loop: 2 x: 338 y: 63)
			)
			(else
				(okI view: 145 loop: 10 x: 338 y: 63)
			)
		)
		(okI
			state:
				(if (or (and (== local4 0) (not local2)) (== local4 3))
					0
				else
					3
				)
		)
		(if (self contains: okI)
			(okI draw:)
			(selectorI draw:)
			(deleteI draw:)
			(UpdateScreenItem okI)
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
								font: 50
								fore: 11
								back: 4
								addText: 33 0 0 1 0 0 64990
								addText: 34 0 0 1 0 72 64990
								classText: oldName
								addText: theComment 0 36
								addEdit: str 30 0 108 theComment
								classButton: SRDButton
								addButton: 1 33 0 0 1 0 144 64990
								addButton: 0 38 0 0 1 110 144 64990
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
						(cond
							(ret
								(= ret (nums at: local1))
							)
							((== local2 20)
								(= ret (nums at: local3))
							)
							(else
								(for ((= ret 0)) 1 ((++ ret))
									(for
										((= local1 0))
										(< local1 local2)
										((++ local1))
										
										(breakif (== ret (nums at: local1)))
									)
									(if (== local1 local2)
										(break)
									)
								)
							)
						)
						(break)
					)
					(cond
						((== local1 deleteI)
							(if
								(not
									((Print new:)
										font: 50
										fore: 11
										back: 4
										addText: 12 0 0 1 0 0 64990
										classButton: SRDButton
										addButton: 0 31 0 0 1 0 42 64990
										addButton: 1 32 0 0 1 100 42 64990
										init:
									)
								)
							else
								(Save 6 (str data:) (gGame name:)) ; MakeSaveCatName
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
								(Save
									7 ; MakeSaveFileName
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
		length 16
	)

	(method (init)
		(if (== local4 0)
			(= upButton myRestoreUpButt)
			(= downButton myRestoreDownButt)
		else
			(= upButton mySaveUpButt)
			(= downButton mySaveDownButt)
		)
		(super init: &rest)
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

(instance okI of DButton
	(properties)
)

(instance cancelI of DButton
	(properties)
)

(instance deleteI of DButton
	(properties)
)

(instance changeDirI of DButton
	(properties)
)

(instance oldName of DText
	(properties
		borderColor 0
	)
)

(instance mySaveUpButt of DButton
	(properties
		x 302
		y 63
		view 145
		loop 6
	)
)

(instance mySaveDownButt of DButton
	(properties
		x 302
		y 278
		view 145
		loop 7
	)
)

(instance myRestoreUpButt of DButton
	(properties
		x 302
		y 63
		view 146
		loop 4
	)
)

(instance myRestoreDownButt of DButton
	(properties
		x 302
		y 278
		view 146
		loop 5
	)
)

(class SRDButton of DButton
	(properties
		view 64990
		fore 0
		font 50
	)
)

