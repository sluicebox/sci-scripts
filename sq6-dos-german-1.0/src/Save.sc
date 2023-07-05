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
	local5
	local6
	local7
	local8
	local9
	local10
	local11 = 970
	local12 = 971
	local13 = 972
	local14 = 973
	local15 = 976
	local16 = 977
	local17 = 81
	local18 = 82
)

(procedure (GetDirectory where &tmp result newDir str buf1 len p theText ret)
	(= newDir (Str new:))
	(= str (Str new:))
	(= buf1 (Str new:))
	(repeat
		(= len
			(- (Min 45 (+ (Max 29 (+ (where size:) 6)) 11)) 18)
		)
		((= p (Print new:))
			font: 71
			fore: local18
			back: 0
			addBitmap: local13 2 0
			addEdit:
				(newDir copy: where)
				len
				3
				14
				(if (< len (where size:)) {} else where)
			classButton: SRDButton
			addButtonBM: local13 0 0 1 { } 22 30
			addButtonBM: local13 1 0 0 { } 107 30
			posn: 70 7
		)
		(if (not (= result (p init:)))
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
			((Print new:)
				addBitmap: local16 0 0
				addButtonBM: local16 1 0 1 { } 33 22
				classButton: SRDButton
				posn: 101 4
				init:
			)
		)
	)
	(newDir dispose:)
	(str dispose:)
	(buf1 dispose:)
	(return ret)
)

(procedure (GetStatus)
	(if (< local2 20)
		(FileIO 17 2 (KString 9 gCurSaveDir)) ; CheckFreeSpace, StrGetData
	)
)

(procedure (HaveSpace)
	((Print new:)
		addBitmap: local15 0 0
		classButton: SRDButton
		addButtonBM: local15 1 0 1 { } 30 30
		posn: 118 7
		init:
	)
)

(class SRDialog of Dialog
	(properties)

	(method (init theComment names nums &tmp db)
		(self add:)
		(= local5 (Str with: { }))
		(= local6 (Str with: { }))
		(= local7 (Str with: { }))
		(= local8 (Str with: { }))
		(if (== gCurRoomNum 100)
			(= local11 151)
			(= local12 152)
			(= local13 153)
			(= local16 155)
			(= local17 161)
			(= local18 162)
		else
			(= local11 970)
			(= local12 971)
			(= local13 972)
			(= local16 977)
			(= local17 81)
			(= local18 82)
		)
		((= plane (gSystemPlane new:))
			init: 45 17 55 27
			back: 0
			setBitmap: (if (== gCurRoomNum 100) 151 else 970) 8 0
		)
		(if (not (self update: theComment names nums))
			(return 0)
		)
		(deleteI
			view: (if (== gCurRoomNum 100) 151 else 970)
			loop: 2
			cel: 0
			text: (KString 8 (local6 data:)) ; StrDup
			setSize:
			moveTo: 180 38
		)
		(changeDirI
			view: (if (== gCurRoomNum 100) 151 else 970)
			loop: 3
			cel: 0
			text: (KString 8 (local7 data:)) ; StrDup
			setSize:
			moveTo: 180 53
			state: (& (changeDirI state:) $fff7)
		)
		(cancelI
			view: (if (== gCurRoomNum 100) 151 else 970)
			loop: 4
			cel: 0
			text: (KString 8 (local8 data:)) ; StrDup
			setSize:
			moveTo: 180 76
			state: (& (cancelI state:) $fff7)
		)
		(self add: selectorI okI deleteI changeDirI cancelI textI)
		(super init:)
		(self setSize: center: eachElementDo: #updatePlane)
		(return 1)
	)

	(method (update theComment names nums &tmp db buf)
		(if
			(==
				(= local2
					(Save 5 (gGame name:) (names data:) (nums data:)) ; GetSaveFiles
				)
				-1
			)
			(return 0)
		)
		(switch (= local4 (NeedDescription))
			(0
				(textI view: (if (== gCurRoomNum 100) 151 else 970) loop: 9)
			)
			(1
				(textI view: (if (== gCurRoomNum 100) 151 else 970) loop: 9)
			)
			(else
				(textI view: (if (== gCurRoomNum 100) 151 else 970) loop: 10)
			)
		)
		(textI
			cel: 0
			x: 0
			y: 0
			setPri: (if (== local4 1) 0 else 50)
			moveTo: 0 0
		)
		(deleteI state: (if (not local2) 0 else 3))
		(if (not local2)
			(deleteI z: 1000)
		else
			(deleteI z: 0)
		)
		(if (== local4 1)
			(editI
				x: 0
				y: 0
				fore: local18
				back: 0
				font: 71
				text: ((theComment copy: {}) data:)
				width: 20
				setSize:
				moveTo: 8 27
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
			font: 71
			fore: local17
			back: 0
			width: 143
			setText: names
			setSize:
			moveTo: 8 42
			state: 2
		)
		(= db (local5 data:))
		(switch local4
			(0
				(okI view: (if (== gCurRoomNum 100) 151 else 970) loop: 1 cel: 0)
			)
			(1
				(okI view: (if (== gCurRoomNum 100) 151 else 970) loop: 0 cel: 0)
			)
			(else
				(okI view: (if (== gCurRoomNum 100) 151 else 970) loop: 11 cel: 0)
			)
		)
		(= local1 (+ (selectorI nsRight:) 35))
		(okI
			x: 0
			y: 0
			text: (KString 8 db) ; StrDup
			setSize:
			moveTo: 180 24
			state:
				(if (or (and (== local4 0) (not local2)) (== local4 3))
					0
				else
					3
				)
		)
		(if (and (== local4 0) (not local2))
			(okI z: 1000)
		else
			(okI z: 0)
		)
		(if (self contains: okI)
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
								font: 71
								fore: local18
								back: 0
								addBitmap: local14 0 0
								classText: oldName
								addText: theComment 3 13
								addEdit: str 20 3 43 theComment
								classButton: SRDButton
								addButtonBM: local14 1 0 1 { } 22 59
								addButtonBM: local14 2 0 0 { } 107 59
								posn: 70 7
								init:
							)
							(if (not (str size:))
								(HaveSpace)
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
							(HaveSpace)
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
										addBitmap: local12 2 0
										classButton: SRDButton
										addButtonBM: local12 0 0 1 { } 12 36
										addButtonBM: local12 1 0 0 { } 79 36
										posn: 93 7
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

	(procedure (NeedDescription)
		(return
			(cond
				((== self Restore) 0)
				((GetStatus) 1)
				(local2 2)
				(else 3)
			)
		)
	)

	(method (setSize &tmp temp0 temp1 temp2)
		(super setSize:)
		(if ((self plane:) bitmap:)
			(= temp0 (((self plane:) bitmap:) view:))
			(= temp1 (((self plane:) bitmap:) loop:))
			(= temp2 (((self plane:) bitmap:) cel:))
			(= nsRight (- (+ (CelWide temp0 temp1 temp2) nsLeft) 1))
			(= nsBottom (- (+ (CelHigh temp0 temp1 temp2) nsTop) 2))
			(if plane
				(plane setRect: nsLeft nsTop nsRight nsBottom)
			)
		)
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
		length 7
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
		width 19
	)
)

(class SRDButton of DButton
	(properties
		view 64990
		font 71
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

(instance textI of DItem
	(properties)
)

(instance oldName of DText
	(properties
		borderColor 0
	)
)

