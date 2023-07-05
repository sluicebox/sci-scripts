;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64990)
(include sci.sh)
(use Main)
(use DButton)
(use DIcon)
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

(procedure (localproc_0)
	(return
		(cond
			((== self Restore) 0)
			((localproc_1) 1)
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
		(= len (Min 45 (+ (Max 22 (+ (where size:) 6)) 11)))
		((= p (Print new:))
			font: 999
			fore: 0
			margin: 12
			width: 60
			skip: 2
			back: 2
			addBitmap: 917 4 0
			addEdit: (newDir copy: where) 33 0 40 where
			addButton: 1 27 0 0 1 50 70 64990
			addButton: 0 38 0 0 1 150 70 64990
		)
		(= theText (Str new:))
		(Message msgGET 64990 1 0 0 1 (theText data:)) ; "New save-game directory:"
		((p dialog:)
			add:
				((DText new:)
					text: (KString 8 (theText data:)) ; StrDup
					font: gUserFont
					fore: 0
					skip: 254
					setSize:
					moveTo: 40 22
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
			((Print new:)
				font: gUserFont
				fore: 0
				margin: 13
				addBitmap: 917 4 0
				mode: 0
				addText: {is not a valid directory} 0 50
				addText: (newDir data:) 0 22
				init:
			)
		)
	)
	(newDir dispose:)
	(str dispose:)
	(buf1 dispose:)
	(return ret)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(= temp0 (Str new:))
	(FileIO 18 (temp0 data:)) ; GetCWD
	(= temp1
		(if (< local2 20)
			(FileIO 17 1 (temp0 data:) 4) ; CheckFreeSpace
		)
	)
	(temp0 dispose:)
	(return temp1)
)

(procedure (localproc_2)
	((Print new:)
		font: gUserFont
		fore: 0
		skip: 2
		back: 2
		margin: 13
		addBitmap: 917 4 0
		addText: 3 0 0 1 15 10 64990
		addButton: 1 27 0 0 1 117 60 64990
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
		(= plane (gSystemPlane new:))
		(plane back: -1)
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
			state: 0
		)
		(if (!= gCardGameScriptNumber 1100)
			(changeDirI state: (& (changeDirI state:) $0000))
		)
		(Message msgGET 64990 22 0 0 1 (local8 data:)) ; "Cancel"
		(cancelI
			text: (KString 8 (local8 data:)) ; StrDup
			setSize:
			moveTo: local1 (+ (changeDirI nsBottom:) 2)
			state: (& (cancelI state:) $fff7)
		)
		(self add: selectorI okI deleteI changeDirI cancelI textI iconI)
		(super init:)
		(self margin: 0 setSize: center: eachElementDo: #updatePlane setSize:)
		(return 1)
	)

	(method (update theComment names nums &tmp db buf)
		(cond
			((== local11 1100)
				(= local2 (Save 5 {poker} (names data:) (nums data:))) ; GetSaveFiles
			)
			((== local11 700)
				(= local2 (Save 5 {bridge} (names data:) (nums data:))) ; GetSaveFiles
			)
		)
		(if (== local2 -1)
			(return 0)
		)
		(= local4 (localproc_0))
		(= buf (Str new:))
		(switch local4
			(0
				(Message msgGET 64990 10 0 0 1 (buf data:)) ; "Select the game that you would like to restore."
				(if (== gCardGameScriptNumber 700)
					(buf
						copy: {Select the hand that you would like to restore.}
					)
				)
				(textI x: 13 y: 20)
			)
			(1
				(Message msgGET 64990 11 0 0 1 (buf data:)) ; "Type the description of this saved game."
				(if (== gCardGameScriptNumber 700)
					(buf copy: {Type the description of this saved hand.})
				)
				(textI x: 13 y: 20)
			)
			(else
				(Message msgGET 64990 30 0 0 1 (buf data:)) ; "This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk."
				(textI x: 13 y: 10)
			)
		)
		(textI text: (KString 8 (buf data:)) setSize: 400) ; StrDup
		(buf dispose:)
		(deleteI state: (if (not local2) 0 else 3))
		(if (== local4 1)
			(editI
				x: 0
				y: 0
				font: gUserFont
				text: ((theComment copy: {}) data:)
				width: 26
				setSize:
				moveTo: 13 48
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
			font: gUserFont
			back: 223
			width: 250
			setText: names
			setSize:
			moveTo: 24 72
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

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= local11 param2)
		(= temp2 (Str new: 720))
		(= temp4 (Str new:))
		(= temp5 (Str new:))
		(= temp3 (IntArray new: 21))
		(= local10 (Palette 3 127 127 127)) ; PalMatch
		(= temp1 0)
		(if (and (== self Restore) argc param1)
			(if (== local11 1100)
				(temp4 format: {%ssg.cat} {poker})
			else
				(temp4 format: {%ssg.cat} {bridge})
			)
			(if (FileIO fiEXISTS (temp4 data:))
				(= temp0 (FileIO fiOPEN (temp4 data:)))
				(FileIO fiCLOSE temp0)
			else
				(= temp8 -2)
			)
		)
		(if (not (self init: param1 temp2 temp3))
			(= temp1 -2)
		)
		(if (not temp1)
			(repeat
				(= local0
					(switch local4
						(0
							(if local2 okI else okI)
						)
						(1 editI)
						(2 okI)
						(else okI)
					)
				)
				(= local1 (super doit: local0))
				(= local3 (selectorI current:))
				(if (== local1 changeDirI)
					(if
						(and
							(GetDirectory gCurSaveDir)
							(not (self update: param1 temp2 temp3))
						)
						(= temp1 -2)
						(break)
					)
				else
					(if (and (== local4 2) (== local1 okI))
						(param1
							copy:
								(((selectorI textList:)
										at: (selectorI current:)
									)
									text:
								)
						)
						(if
							((Print new:)
								font: gUserFont
								fore: 0
								skip: 2
								back: 2
								margin: 13
								addBitmap: 917 4 0
								addText: 33 0 0 1 0 0 64990
								addText: 34 0 0 1 0 37 64990
								classText: oldName
								addText: param1 0 14
								addEdit: temp4 17 0 48 param1
								addButton: 1 33 0 0 1 30 68 64990
								addButton: 0 38 0 0 1 95 68 64990
								init:
							)
							(if (not (temp4 size:))
								(localproc_2)
								(continue)
							)
							(param1 copy: temp4)
							(= temp1 (temp3 at: local3))
							(break)
						)
						(continue)
					)
					(if (and (== local4 1) (OneOf local1 okI editI))
						(param1 copy: (editI text:))
						(if (not (param1 size:))
							(localproc_2)
							(continue)
						)
						(= temp1 -1)
						(for ((= local1 0)) (< local1 local2) ((++ local1))
							(= temp7 (Str new: 36))
							(temp7 copyToFrom: 0 temp2 (* local1 36) 36)
							(= temp1 (param1 compare: temp7))
							(temp7 dispose:)
							(breakif temp1)
						)
						(if temp1
							(= temp1 (temp3 at: local1))
							(break)
						)
						(if (== local2 20)
							(= temp1 (temp3 at: local3))
							(break)
						)
						(for ((= temp1 0)) 1 ((++ temp1))
							(for ((= local1 0)) (< local1 local2) ((++ local1))
								(breakif (== temp1 (temp3 at: local1)))
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
										font: gUserFont
										skip: 2
										back: 2
										fore: 0
										margin: 10
										width: 200
										addBitmap: 917 4 0
										addText:
											{Are you sure you wish to delete this saved game?}
											15
											15
										addButton: 0 {No} 80 60
										addButton: 1 {Yes} 150 60
										init:
									)
								)
							else
								(if (== local11 1100)
									(Save 6 (temp4 data:) {poker}) ; MakeSaveCatName
								else
									(Save 6 (temp4 data:) {bridge}) ; MakeSaveCatName
								)
								((= temp0 (File new:))
									name: (temp4 data:)
									open: 2
								)
								(for
									((= local1 0))
									(< local1 local2)
									((++ local1))
									
									(if (!= local1 local3)
										(= temp1 (temp3 at: local1))
										(temp4
											at: 0 (& temp1 $00ff)
											at: 1 (& (>> temp1 $0008) $00ff)
											at: 2 0
										)
										(temp0 write: (temp4 data:) 2)
										(= temp7 (Str new: 36))
										(temp7
											copyToFrom: 0 temp2 (* local1 36) 36
										)
										(temp0 write: (temp7 data:) 36)
										(temp7 dispose:)
									)
								)
								(temp4 at: 0 255 at: 1 255)
								(temp0 write: (temp4 data:) 2 close: dispose:)
								(if (== local11 1100)
									(Save
										7 ; MakeSaveFileName
										(temp4 data:)
										{poker}
										(temp3 at: local3)
									)
								else
									(Save
										7 ; MakeSaveFileName
										(temp4 data:)
										{bridge}
										(temp3 at: local3)
									)
								)
								(FileIO fiUNLINK (temp4 data:))
								(self update: param1 temp2 temp3)
							)
						)
						((== local1 okI)
							(= temp1 (temp3 at: local3))
							(break)
						)
						((or (== local1 -1) (== local1 cancelI))
							(= temp1 -1)
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
		(temp2 dispose:)
		(temp4 dispose:)
		(temp5 dispose:)
		(temp3 dispose:)
		(= temp6 plane)
		(self dispose:)
		(temp6 dispose:)
		(FrameOut)
		(DisposeScript 64990 temp1)
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
		font 2107
		width 16
	)
)

(instance iconI of DIcon
	(properties
		view 27
	)
)

(class SRDButton of DButton
	(properties
		view 64990
		fore 0
		font 2107
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
		font 2107
	)
)

(instance oldName of DText
	(properties
		font 2107
		borderColor 130
	)
)

