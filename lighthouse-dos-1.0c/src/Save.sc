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
(use Sound)
(use File)
(use Actor)
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

(procedure (GetDirectory where &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 2])
	(= temp1 (Str new:))
	(= temp2 (Str new:))
	(= temp3 (Str new:))
	(repeat
		(= temp4 (Min 45 (- (Max 29 (where size:)) 0)))
		(= temp5 (Print new:))
		(temp5 margin: 0)
		((temp5 addIcon: 1207 15 0 0 0) state: 0)
		(temp5 font: 20071 addEdit: (temp1 copy: where) temp4 8 72 where)
		((temp5 addButtonBM: 1207 16 0 1 {} 37 108) value: 1 state: -9)
		((temp5 addButtonBM: 1207 17 0 0 {} 149 108) value: 0 state: -9)
		(if (not (= temp0 (temp5 init:)))
			(= temp7 0)
			(break)
		)
		(if (not (temp1 size:))
			(FileIO 18 (temp1 data:)) ; GetCWD
		)
		(if (FileIO 19 (temp1 data:)) ; ValidPath
			(where copy: temp1)
			(= temp7 1)
			(break)
		else
			(= temp5 (Print new:))
			(temp5 margin: 0)
			((temp5 addIcon: 1207 7 0 0 0) state: 0)
			((temp5 addButtonBM: 1207 8 0 1 {} 48 69) value: 1 state: -9)
			(temp5 init:)
		)
	)
	(temp1 dispose:)
	(temp2 dispose:)
	(temp3 dispose:)
	(return temp7)
)

(procedure (localproc_1)
	(if (< local2 20)
		(FileIO 17 2 (KArray 9 gCurSaveDir)) ; CheckFreeSpace, ArrayGetData
	)
)

(procedure (localproc_2 &tmp temp0)
	(= temp0 (Print new:))
	(temp0 margin: 0)
	((temp0 addIcon: 1207 5 0 0 0) state: 0)
	((temp0 addButtonBM: 1207 6 0 1 {} 50 70) value: 1 state: -9)
	(temp0 init:)
)

(class SRDialog of Dialog
	(properties
		saving 0
	)

	(method (init theComment names nums)
		(self add:)
		(= saving 0)
		((= plane (gSystemPlane new:)) back: 0)
		(if (not (self update: theComment names nums))
			(return 0)
		)
		(self add: saveView)
		(deleteI view: 1203 loop: 8 x: 89 y: 198 setForeign: 1203 12030 12031)
		(changeDirI
			view: 1203
			loop: 10
			x: 242
			y: 199
			state: (& (changeDirI state:) $fff7)
			setForeign: 1203 12030 12031
		)
		(cancelI
			view: 1203
			loop: 9
			x: 165
			y: 198
			state: (& (cancelI state:) $fff7)
			setForeign: 1203 12030 12031
		)
		(self add: selectorI okI deleteI changeDirI cancelI)
		(if saving
			(self add: saveDialogView)
		)
		(super init:)
		(self setSize: moveTo: 205 169 eachElementDo: #updatePlane)
		(return 1)
	)

	(method (setSize &tmp temp0 temp1 temp2)
		(= temp2 (IntArray with: 0 0 0 0))
		(if text
			(Text 0 (temp2 data:) text font 0) ; TextSize
			(= nsLeft (temp2 at: 0))
			(= nsTop (temp2 at: 1))
			(= nsRight (temp2 at: 2))
			(= nsBottom (temp2 at: 3))
		else
			(= nsBottom (= nsRight (= nsTop (= nsLeft 0))))
		)
		(temp2 dispose:)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (< (temp1 nsLeft:) nsLeft)
				(= nsLeft (temp1 nsLeft:))
			)
			(if (< (temp1 nsTop:) nsTop)
				(= nsTop (temp1 nsTop:))
			)
			(if (> (temp1 nsRight:) nsRight)
				(= nsRight (temp1 nsRight:))
			)
			(if (> (temp1 nsBottom:) nsBottom)
				(= nsBottom (temp1 nsBottom:))
			)
		)
		(if plane
			(plane setRect: nsLeft nsTop nsRight nsBottom)
		)
	)

	(method (update theComment names nums &tmp temp0)
		(if
			(==
				(= local2
					(Save 5 (gGame name:) (names data:) (nums data:)) ; GetSaveFiles
				)
				-1
			)
			(return 0)
		)
		(= local4 (localproc_0))
		(= temp0 (Str new:))
		(switch local4
			(0
				(Message msgGET 64990 10 0 0 1 (temp0 data:)) ; "Select the game that you would like to restore."
			)
			(1
				(if (self contains: saveDialogView)
					(UpdateScreenItem (saveDialogView setCel: 1 yourself:))
				)
				(Message msgGET 64990 11 0 0 1 (temp0 data:)) ; "Type the description of this saved game."
			)
			(else
				(if (self contains: saveDialogView)
					(UpdateScreenItem (saveDialogView setCel: 2 yourself:))
				)
				(Message msgGET 64990 30 0 0 1 (temp0 data:)) ; "This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk."
			)
		)
		(temp0 dispose:)
		(deleteI state: (if (not local2) 0 else 3))
		(if (or (== local4 1) (== local4 0))
			(editI
				fore: 235
				back: 0
				font: 20071
				text: ((theComment copy: {}) data:)
				width: 36
				setSize:
			)
			(if (not local7)
				(editI moveTo: 29 64)
				(= local7 (editI nsLeft:))
			)
			(if (not (self contains: editI))
				(self add: editI)
				(if (self contains: okI)
					(editI plane: (self plane:) setSize:)
					(editI draw: setSize:)
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
			font: 20071
			back: 0
			fore: 235
			width: 310
			setText: names
			setSize:
			moveTo: 27 98
			state: 2
		)
		(switch local4
			(0
				(okI loop: 6 y: 198)
			)
			(1
				(okI loop: 7 y: 200)
				(= saving 1)
			)
			(else
				(= saving 1)
				(okI loop: 13 y: 200)
			)
		)
		(= local1 (+ (selectorI nsRight:) 35))
		(okI
			x: 0
			state:
				(if (or (and (== local4 0) (not local2)) (== local4 3))
					0
				else
					3
				)
			setForeign: 1203 12030 12031
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

	(method (doit theComment &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 2] temp10)
		(= temp10
			(if argc
				theComment
			else
				(Str new:)
			)
		)
		(= temp2 (Str new: 720))
		(= temp4 (Str new:))
		(= temp5 (Str new:))
		(= temp3 (IntArray new: 21))
		(= local6 (Palette 3 127 127 127)) ; PalMatch
		(= temp1 0)
		(if (and (== self Restore) argc temp10)
			(temp4 format: {%ssg.cat} (gGame name:))
			(if (== (= temp0 (FileIO fiOPEN (temp4 data:))) -1)
				(if (not argc)
					(temp10 dispose:)
				)
				(temp2 dispose:)
				(temp4 dispose:)
				(temp5 dispose:)
				(temp3 dispose:)
				(if (not argc)
					(temp10 dispose:)
				)
				(return)
			)
			(FileIO fiCLOSE temp0)
		)
		(if (not (self init: temp10 temp2 temp3))
			(= temp1 -2)
		)
		(if (not temp1)
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
							(not (self update: temp10 temp2 temp3))
						)
						(= temp1 -2)
						(break)
					)
				else
					(if (and (== local4 2) (== local1 okI))
						(temp10
							copy:
								(((selectorI textList:)
										at: (selectorI current:)
									)
									text:
								)
						)
						(= temp6 (Print new:))
						(temp6 margin: 0)
						((temp6 addIcon: 1207 2 0 0 0) state: 0)
						(temp6
							font: 20071
							classText: oldName
							fore: 235
							back: 0
							addText: temp10 21 35
							addEdit: temp4 36 21 81 temp10
						)
						((temp6 addButtonBM: 1207 3 0 1 {} 85 108)
							value: 1
							state: -9
						)
						((temp6 addButtonBM: 1207 4 0 0 {} 195 108)
							value: 0
							state: -9
						)
						(if (temp6 init:)
							(if (not (temp4 size:))
								(localproc_2)
								(continue)
							)
							(temp10 copy: temp4)
							(= temp1 (temp3 at: local3))
							(break)
						)
						(continue)
					)
					(if (and (== local4 1) (OneOf local1 okI editI))
						(temp10 copy: (editI text:))
						(if (not (temp10 size:))
							(localproc_2)
							(continue)
						)
						(= temp1 -1)
						(for ((= local1 0)) (< local1 local2) ((++ local1))
							(= temp7 (Str new: 36))
							(temp7 copyToFrom: 0 temp2 (* local1 36) 36)
							(= temp1 (temp10 compare: temp7))
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
							(= temp6 (Print new:))
							(temp6 margin: 0)
							((temp6 addIcon: 1207 9 0 0 0) state: 0)
							((temp6 addButtonBM: 1207 11 0 0 {} 106 70)
								value: 0
								state: -9
							)
							((temp6 addButtonBM: 1207 10 0 1 {} 26 71)
								value: 1
								state: -9
							)
							(if (not (temp6 init:))
							else
								(if (self contains: saveDialogView)
									(UpdateScreenItem
										(saveDialogView setCel: 1 yourself:)
									)
								)
								(Save 6 (temp4 data:) (gGame name:)) ; MakeSaveCatName
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
								(Save
									7 ; MakeSaveFileName
									(temp4 data:)
									(gGame name:)
									(temp3 at: local3)
								)
								(FileIO fiUNLINK (temp4 data:))
								(self update: temp10 temp2 temp3)
							)
						)
						((== local1 okI)
							(= temp1 (temp3 at: local3))
							(break)
						)
						((or (== local1 -1) (== local1 cancelI))
							(saveDialogView dispose:)
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
		(temp2 dispose:)
		(temp4 dispose:)
		(temp5 dispose:)
		(temp3 dispose:)
		(saveDialogView dispose:)
		(if (not argc)
			(temp10 dispose:)
		)
		(DisposeScript 64993)
		(= temp6 plane)
		(self dispose:)
		(temp6 dispose:)
		(FrameOut)
		(DisposeScript 64990 temp1)
	)
)

(class Restore of SRDialog
	(properties)
)

(class Save of SRDialog
	(properties)
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
		width 36
	)
)

(class SRDButton of DButton
	(properties
		view 1203
		font 999
		fore 0
	)
)

(instance okI of SRDButton
	(properties)

	(method (draw)
		(if scratch
			(switch (gGame language:)
				(1
					(if (!= (self view:) ((self scratch:) at: 0))
						(self view: ((self scratch:) at: 0))
					)
				)
				(33
					(if (!= (self view:) ((self scratch:) at: 1))
						(self view: ((self scratch:) at: 1))
					)
				)
				(49
					(if (!= (self view:) ((self scratch:) at: 2))
						(self view: ((self scratch:) at: 2))
					)
				)
			)
		)
		(= dimmed (not (& state $0001)))
		(super draw:)
	)
)

(instance cancelI of SRDButton
	(properties)

	(method (draw)
		(if scratch
			(switch (gGame language:)
				(1
					(if (!= (self view:) ((self scratch:) at: 0))
						(self view: ((self scratch:) at: 0))
					)
				)
				(33
					(if (!= (self view:) ((self scratch:) at: 1))
						(self view: ((self scratch:) at: 1))
					)
				)
				(49
					(if (!= (self view:) ((self scratch:) at: 2))
						(self view: ((self scratch:) at: 2))
					)
				)
			)
		)
		(= dimmed (not (& state $0001)))
		(super draw:)
	)
)

(instance deleteI of SRDButton
	(properties)

	(method (draw)
		(if scratch
			(switch (gGame language:)
				(1
					(if (!= (self view:) ((self scratch:) at: 0))
						(self view: ((self scratch:) at: 0))
					)
				)
				(33
					(if (!= (self view:) ((self scratch:) at: 1))
						(self view: ((self scratch:) at: 1))
					)
				)
				(49
					(if (!= (self view:) ((self scratch:) at: 2))
						(self view: ((self scratch:) at: 2))
					)
				)
			)
		)
		(= dimmed (not (& state $0001)))
		(super draw:)
	)
)

(instance changeDirI of SRDButton
	(properties
		loop 1
	)

	(method (draw)
		(if scratch
			(switch (gGame language:)
				(1
					(if (!= (self view:) ((self scratch:) at: 0))
						(self view: ((self scratch:) at: 0))
					)
				)
				(33
					(if (!= (self view:) ((self scratch:) at: 1))
						(self view: ((self scratch:) at: 1))
					)
				)
				(49
					(if (!= (self view:) ((self scratch:) at: 2))
						(self view: ((self scratch:) at: 2))
					)
				)
			)
		)
		(= dimmed (not (& state $0001)))
		(super draw:)
	)
)

(instance oldName of DText
	(properties
		borderColor 0
	)

	(method (setSize param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (if (!= borderColor -1) 3 else 0))
		(= temp4
			(cond
				((!= view -1)
					(- (CelWide view loop cel) (* temp1 2))
				)
				(argc param1)
				(else 0)
			)
		)
		(= textTop (= textLeft 0))
		(= temp0 (IntArray with: 0 0 0 0))
		(Text 0 (temp0 data:) text font temp4) ; TextSize
		(= textRight (temp0 at: 2))
		(if (> temp4 textRight)
			(= textRight temp4)
		)
		(= textBottom (temp0 at: 3))
		(temp0 dispose:)
		(= nsTop (= nsLeft 0))
		(if (== view -1)
			(+= textLeft temp1)
			(+= textTop temp1)
			(= textRight 305)
			(+= textBottom temp1)
			(= nsRight (+ textRight temp1))
			(= nsBottom (+ textBottom temp1))
		else
			(= temp2 (CelWide view loop cel))
			(= temp3 (CelHigh view loop cel))
			(= nsRight (+ nsLeft (- temp2 1)))
			(= nsBottom (+ nsTop (- temp3 1)))
			(= temp1 (/ (- temp2 (+ (- textRight textLeft) 1)) 2))
			(+= textLeft temp1)
			(+= textRight temp1)
			(= temp1 (/ (- temp3 (+ (- textBottom textTop) 1)) 2))
			(+= textTop temp1)
			(+= textBottom temp1)
		)
	)
)

(instance saveView of DIcon
	(properties
		loop 5
		view 1203
	)
)

(class myView of View
	(properties)

	(method (updatePlane))

	(method (cycle))
)

(instance saveDialogView of myView
	(properties
		loop 5
		cel 1
		view 1203
	)

	(method (init)
		(self setForeign: 1203 12030 12031 setPri: (+ (saveView priority:) 1))
		(switch (localproc_0)
			(1
				(self setCel: 1)
			)
			(0
				(self setCel: 1)
			)
			(else
				(self setCel: 2)
			)
		)
		(super init: &rest)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance saveSound of Sound ; UNUSED
	(properties
		number 14
	)
)

