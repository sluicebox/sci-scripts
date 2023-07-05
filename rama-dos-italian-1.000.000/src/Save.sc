;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64990)
(include sci.sh)
(use Main)
(use Button)
(use DButton)
(use DIcon)
(use DSelector)
(use DEdit)
(use DText)
(use Plane)
(use Str)
(use Print)
(use Dialog)
(use System)

(public
	GetDirectory 0
)

(local
	local0
	local1
)

(procedure (GetDirectory where &tmp result newDir str buf1 len p theText ret)
	(= newDir (Str new:))
	(= str (Str new:))
	(= buf1 (Str new:))
	(repeat
		(= len 38)
		((= p (Print new:))
			plane: tmpPlane
			mode: 0
			font: 999
			fore: 202
			skip: 255
			back: 255
			addEdit: (newDir copy: where) len 54 75
			classButton: DButton
			addBitmap: 209 11 0
			addButtonBM: 209 13 0 27 {} 72 104
			addButtonBM: 209 12 0 38 {} 229 104
		)
		(if (or (not (= result (p init:))) (== result 38))
			(= ret 0)
			(break)
		)
		(if (not (newDir size:))
			(FileIO 18 (newDir data:)) ; GetCWD
		)
		(if (!= (newDir at: (- (newDir size:) 1)) 92)
			(newDir cat: {\5c})
		)
		(if (FileIO 19 (newDir data:)) ; ValidPath
			(where copy: newDir)
			(= ret 1)
			(break)
		else
			((Print new:)
				plane: tmpPlane
				mode: 0
				font: 999
				fore: 202
				skip: 255
				back: 255
				addBitmap: 209 14 0
				addButtonBM: 209 15 0 27 {} 158 97
				init:
			)
		)
	)
	(changeDirI cel: 0)
	(newDir dispose:)
	(str dispose:)
	(buf1 dispose:)
	(return ret)
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2)
	(= temp0 (Str new:))
	(= temp1 (Str newWith: 20))
	(temp0 copy: (((selectorI textList:) at: (selectorI current:)) text:))
	(= temp2 -1)
	(repeat
		(if
			((Print new:)
				plane: tmpPlane
				font: 999
				fore: 202
				skip: 255
				back: 255
				classText: oldName
				addText: temp0 55 95
				addEdit: temp1 11 55 149 temp0
				classButton: DButton
				addBitmap: 209 20 0
				addButtonBM: 209 13 0 27 {} 75 185
				addButtonBM: 209 12 0 38 {} 231 185
				init:
			)
			(if (temp1 size:)
				(temp0 copy: temp1)
				(gCatalogFile rename: param1 temp0)
				(= temp2 param1)
				(break)
			)
		else
			(break)
		)
	)
	(return temp2)
)

(procedure (localproc_1 &tmp temp0)
	(= temp0 (Str new:))
	(temp0 copy: (editI text:))
	(if (not (temp0 size:))
		(localproc_3)
		(return -1)
	else
		(return (gCatalogFile addFile: temp0))
	)
)

(procedure (localproc_2)
	(return
		(and
			gCatalogFile
			(< (gCatalogFile size:) 100)
			(> (FileIO 17 1 (gCurSaveDir data:)) 10) ; CheckFreeSpace
		)
	)
)

(procedure (localproc_3)
	((Print new:)
		plane: tmpPlane
		mode: 0
		font: 999
		fore: 202
		skip: 255
		back: 255
		addBitmap: 209 21 0
		addButtonBM: 209 15 0 27 {} 158 97
		init:
	)
)

(class SRDialog of Dialog
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(= local0 (Palette 3 127 127 127)) ; PalMatch
		(self add:)
		(= nsLeft (= nsTop (= nsRight (= nsBottom 0))))
		((= plane (gSystemPlane new:)) back: 0 picture: -2)
		(if (not (self update:))
			(return 0)
		)
		(= temp1 (Str new:))
		(changeDirI moveTo: 233 120 state: 3)
		(deleteI moveTo: 233 146)
		(cancelI moveTo: 233 172 state: 3)
		(self add: selectorI okI changeDirI deleteI cancelI)
		(super init:)
		(plane addCast: buttonCast)
		(self setSize: center: eachElementDo: #updatePlane)
		(selectUp init: buttonCast)
		(selectDown init: buttonCast)
		(selectorI upButton: selectUp downButton: selectDown)
		(return 1)
	)

	(method (dispose &tmp temp0)
		(= temp0 plane)
		(buttonCast dispose:)
		(super dispose:)
		(temp0 dispose:)
		(FrameOut)
	)

	(method (update &tmp temp0 temp1)
		(if (= temp0 (gCatalogFile size:))
			(deleteI enable: 1 cel: 0)
		else
			(deleteI enable: 0 cel: 3)
		)
		(if (and (selectorI textList:) ((selectorI textList:) size:))
			(selectorI setText: 0)
		)
		(selectorI
			current: 0
			font: 999
			fore: 202
			back: 0
			width: 154
			upButton: -1
			downButton: -1
		)
		(if temp0
			(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
				(selectorI setText: ((gCatalogFile at: temp1) description:) 1)
			)
		else
			(selectorI setText: 0)
		)
		(selectorI setSize: 20 moveTo: 54 73 state: 3)
		(okI setSize:)
		(if (self contains: okI)
			(okI draw:)
			(selectorI draw: 1)
			(deleteI draw:)
			(UpdateScreenItem okI)
			(UpdateScreenItem selectorI)
			(UpdateScreenItem deleteI)
			(UpdateScreenItem saveView)
			(FrameOut)
		)
		(return 1)
	)

	(method (deleteGame param1 &tmp temp0)
		((= temp0 (Print new:))
			plane: tmpPlane
			mode: 2
			fore: 202
			skip: 255
			back: 255
			addBitmap: 209 16 0
			addButtonBM: 209 17 0 27 {} 68 96
			addButtonBM: 209 18 0 38 {} 266 96
		)
		(if (== (temp0 init:) 27)
			(gCatalogFile delete: param1)
		)
	)

	(method (changeDir)
		(if (GetDirectory gCurSaveDir)
			(gCatalogFile changeDir: gCurSaveDir)
		)
		(self dispose: init:)
	)

	(method (handleEvent event)
		(buttonCast handleEvent: event)
		(if (not (event claimed:))
			(super handleEvent: event)
			(return)
		else
			(return 1)
		)
	)
)

(class Restore of SRDialog
	(properties)

	(method (init &tmp temp0)
		(= temp0 (Str new:))
		(Message msgGET 64990 20 0 0 1 (temp0 data:)) ; "Restore a Game"
		(= text (temp0 data:))
		(super init: &rest)
		(self delete: editI)
		(temp0 dispose:)
	)

	(method (update)
		(= local0 (Palette 3 127 127 127)) ; PalMatch
		(self add: saveView)
		(saveView loop: 6)
		(super update:)
		(okI x: 0 y: 0 loop: 1 moveTo: 233 94)
		(if (gCatalogFile size:)
			(okI enable: 1 loop: 1)
		else
			(okI enable: 0 loop: 19)
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (if (gCatalogFile size:) okI else changeDirI))
		(repeat
			(self update:)
			(= temp2 (super doit: temp0))
			(= temp1 (selectorI current:))
			(switch temp2
				(changeDirI
					(self changeDir:)
				)
				(okI
					(return temp1)
				)
				(deleteI
					(self deleteGame: temp1)
				)
				(else
					(return -1)
				)
			)
		)
	)

	(method (dispose)
		(saveView dispose:)
		(super dispose: &rest)
	)
)

(class Save of SRDialog
	(properties)

	(method (init &tmp temp0)
		(= temp0 (Str new:))
		(= local1 (Str newWith: 20))
		(Message msgGET 64990 21 0 0 1 (temp0 data:)) ; "Save a Game"
		(= text (temp0 data:))
		(super init: &rest)
		(temp0 dispose:)
	)

	(method (update)
		(= local0 (Palette 3 127 127 127)) ; PalMatch
		(self add: saveView)
		(if (localproc_2)
			(saveView loop: 7)
		else
			(saveView loop: 6)
		)
		(super update:)
		(if (localproc_2)
			(saveView loop: 7)
			(okI loop: 2 x: 0 y: 0 moveTo: 233 94)
			(editI
				x: 0
				y: 0
				fore: 202
				skip: 0
				back: 0
				font: 999
				text: (local1 data:)
				width: 20
				setSize:
				moveTo: 54 40
			)
			(if (not (self contains: editI))
				(self add: editI)
				(if (self contains: okI)
					(editI plane: (self plane:))
					(editI draw:)
					(AddScreenItem editI)
				)
			)
			(okI enable: 1)
		else
			(saveView loop: 6)
			(okI loop: 5 x: 0 y: 0 moveTo: 233 94)
			(editI
				x: 0
				y: 0
				fore: 202
				skip: 0
				back: 0
				font: 999
				text: (local1 data:)
				width: 20
				setSize:
				moveTo: 54 40
			)
			(if (self contains: editI)
				(self delete: editI)
				(DeleteScreenItem editI)
				(if (editI bitmap:)
					(Bitmap 1 (editI bitmap:)) ; Dispose
					(editI bitmap: 0)
				)
			)
			(if (gCatalogFile size:)
				(okI enable: 1)
			else
				(okI enable: 0)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(repeat
			(self update: local1)
			(if (localproc_2)
				(= temp0 editI)
			else
				(= temp0 okI)
			)
			(= temp2 (super doit: temp0))
			(= temp1 (selectorI current:))
			(switch temp2
				(changeDirI
					(self changeDir:)
				)
				(okI
					(cond
						((localproc_2)
							(return (localproc_1))
						)
						((!= (localproc_0 temp1) -1)
							(return temp1)
						)
					)
				)
				(editI
					(return (localproc_1))
				)
				(deleteI
					(self deleteGame: temp1)
				)
				(cancelI
					(return -1)
				)
			)
		)
	)

	(method (dispose)
		(saveView dispose:)
		(local1 dispose:)
		(super dispose:)
	)
)

(class selectorI of DSelector
	(properties
		length 15
	)

	(method (setText param1 param2)
		(super setText: param1)
		(if (and (> argc 1) (not param2))
			(return)
		)
		(self updateEdit:)
	)

	(method (draw param1)
		(super draw:)
		(if (and argc (not param1))
			(return)
		)
		(self updateEdit:)
	)

	(method (updateEdit &tmp temp0 temp1)
		(if (and (editI text:) (textList size:) (editI bitmap:))
			(= temp0 (Str new:))
			(= temp1 (temp0 data:))
			(temp0 data: (editI text:))
			(temp0 format: {%s} ((textList at: current) text:))
			(editI text: (temp0 data:) draw:)
			(temp0 data: temp1 dispose:)
		)
	)
)

(instance editI of DEdit
	(properties
		loop 10
		view 209
	)
)

(instance saveView of DIcon
	(properties
		loop 7
		view 209
	)
)

(instance okI of DButton
	(properties
		loop 1
		view 209
	)
)

(instance cancelI of DButton
	(properties
		loop 3
		view 209
	)
)

(instance deleteI of DButton
	(properties
		view 209
	)
)

(instance changeDirI of DButton
	(properties
		loop 4
		view 209
	)
)

(instance textI of DText ; UNUSED
	(properties
		font 999
	)
)

(instance oldName of DText
	(properties
		borderColor 0
	)
)

(instance selectUp of Button
	(properties
		x 141
		y 216
		loop 8
		view 209
		doVerbCalled 1
	)

	(method (init)
		(&= signal $efff)
		(super init: &rest)
		(= nsLeft x)
		(= nsTop y)
		(= nsRight (+ x 28))
		(= nsBottom (+ y 38))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(selectorI scrollUp:)
				(UpdateScreenItem selectorI)
				(FrameOut)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance selectDown of Button
	(properties
		x 175
		y 216
		loop 9
		view 209
		doVerbCalled 1
	)

	(method (init)
		(&= signal $efff)
		(super init: &rest)
		(= nsLeft x)
		(= nsTop y)
		(= nsRight (+ x 28))
		(= nsBottom (+ y 38))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(selectorI scrollDown:)
				(UpdateScreenItem selectorI)
				(FrameOut)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buttonCast of Cast
	(properties)
)

(instance tmpPlane of Plane
	(properties
		picture -2
	)
)

