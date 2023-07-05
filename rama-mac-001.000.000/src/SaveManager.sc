;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use n1111)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Save)
(use File)
(use System)

(class SaveManager of Obj
	(properties
		dirFileName 0
		saveFilePtr 0
	)

	(method (save &tmp temp0 temp1)
		(if (FileIO 19 gCurSaveDir) ; ValidPath
			(gCurSaveDir data: (Save 2)) ; GetSaveDir
		)
		(CatalogFile init: gCurSaveDir)
		(Load rsFONT gSmallFont)
		(Save init:)
		(= temp0 (Save doit:))
		(Save dispose:)
		(= temp1 0)
		(switch temp0
			(-1
				(= temp1 0)
			)
			(-2
				(= temp1 0)
			)
			(else
				(if (= saveFilePtr (CatalogFile open: temp0 2))
					(saveFilePtr writeWord: 19)
					(gGame serialize: 0)
					(saveFilePtr close: dispose:)
					(= temp1 1)
				else
					(= temp1 0)
				)
			)
		)
		(CatalogFile dispose:)
		(DisposeScript 64990)
		(return temp1)
	)

	(method (restore &tmp temp0 temp1)
		(if (FileIO 19 gCurSaveDir) ; ValidPath
			(gCurSaveDir data: (Save 2)) ; GetSaveDir
		)
		(CatalogFile init: gCurSaveDir)
		(Load rsFONT gSmallFont)
		(Restore init:)
		(= temp0 (Restore doit:))
		(Restore dispose:)
		(= temp1 0)
		(switch temp0
			(-1
				(= temp1 0)
			)
			(-2
				(= temp1 0)
			)
			(else
				(if (= saveFilePtr (CatalogFile open: temp0 1))
					(if (== (self readWord:) 19)
						(gGame serialize: 1)
						(= temp1 1)
					else
						(= temp1 0)
						(Printf
							{Incompatible Save Game File. Save Game Version has changed.}
						)
					)
					(saveFilePtr close: dispose:)
				else
					(= temp1 0)
				)
			)
		)
		(CatalogFile dispose:)
		(DisposeScript 64990)
		(return temp1)
	)

	(method (autoSave param1 &tmp temp0)
		(= temp0 (Str new:))
		(if argc
			(temp0 format: {%s%d%s} (Save 2) param1 {.sg}) ; GetSaveDir
			(= global178 param1)
		else
			(temp0 format: {%s%s} (Save 2) {autorama.sg}) ; GetSaveDir
			(= global178 0)
		)
		((= saveFilePtr (File new:)) name: (temp0 data:))
		(if (saveFilePtr open: 2)
			(saveFilePtr writeWord: 19)
			(gGame serialize: 0)
			(saveFilePtr close:)
		)
		(saveFilePtr dispose:)
		(temp0 dispose:)
	)

	(method (autoRestore &tmp temp0)
		(= temp0 (Str new:))
		(if global178
			(temp0 format: {%s%d%s} (Save 2) global178 {.sg}) ; GetSaveDir
		else
			(temp0 format: {%s%s} (Save 2) {autorama.sg}) ; GetSaveDir
		)
		((= saveFilePtr (File new:)) name: (temp0 data:))
		(if (saveFilePtr open: 1)
			(if (== (self readWord:) 19)
				(gGame serialize: 1)
			else
				(Printf
					{Incompatible Save Game File. Save Game Version has changed.}
				)
			)
			(saveFilePtr close:)
		)
		(saveFilePtr dispose:)
		(temp0 dispose:)
	)

	(method (writeWord param1)
		(saveFilePtr writeWord: param1)
	)

	(method (readWord &tmp temp0 temp1)
		(= temp1 (Str newWith: 2 {}))
		(saveFilePtr read: temp1 2)
		(= temp0 (proc1111_22 temp1 0))
		(temp1 dispose:)
		(return temp0)
	)

	(method (saveScript param1 param2 param3)
		(saveFilePtr writeWord: param2)
		(saveFilePtr writeWord: param3)
		(saveFilePtr writeWord: (param1 state:))
		(saveFilePtr writeWord: (param1 cycles:))
		(saveFilePtr writeWord: (param1 seconds:))
		(saveFilePtr writeWord: (param1 lastSeconds:))
		(saveFilePtr writeWord: (param1 ticks:))
		(saveFilePtr writeWord: (param1 lastTicks:))
		(saveFilePtr writeWord: (param1 register:))
	)

	(method (restoreScript &tmp temp0 temp1 temp2)
		(= temp1 (self readWord:))
		(= temp2 (self readWord:))
		(= temp0 (ScriptID temp1 temp2))
		(temp0 state: (self readWord:))
		(temp0 cycles: (self readWord:))
		(temp0 seconds: (self readWord:))
		(temp0 lastSeconds: (self readWord:))
		(temp0 ticks: (self readWord:))
		(temp0 lastTicks: (self readWord:))
		(temp0 register: (self readWord:))
		(return temp0)
	)

	(method (saveTimer param1 param2 param3)
		(saveFilePtr writeWord: param2)
		(saveFilePtr writeWord: param3)
		(saveFilePtr writeWord: (param1 cycleCnt:))
		(saveFilePtr writeWord: (param1 seconds:))
		(saveFilePtr writeWord: (param1 ticks:))
		(saveFilePtr writeWord: (param1 lastTime:))
	)

	(method (restoreTimer &tmp temp0 temp1 temp2)
		(= temp1 (self readWord:))
		(= temp2 (self readWord:))
		(= temp0 (ScriptID temp1 temp2))
		(temp0 cycleCnt: (self readWord:))
		(temp0 seconds: (self readWord:))
		(temp0 ticks: (self readWord:))
		(temp0 lastTime: (self readWord:))
		(return temp0)
	)
)

(class CatalogEntry of Obj
	(properties
		description 0
		fileName 0
		fileNumber -1
	)

	(method (dispose)
		(if description
			(description dispose:)
			(= description 0)
		)
		(if fileName
			(fileName dispose:)
			(= fileName 0)
		)
		(super dispose:)
	)

	(method (serialize param1 param2 &tmp temp0)
		(if param2
			(if description
				(description dispose:)
			)
			(if fileName
				(fileName dispose:)
			)
			(= description (Str new: 25))
			(= fileName (Str new: 13))
			(param1 read: (fileName data:) 12)
			(param1 read: (description data:) 20)
			(= temp0 (Str newWith: 2 {}))
			(param1 read: temp0 2)
			(self fileNumber: (proc1111_22 temp0 0))
			(temp0 dispose:)
		else
			(param1 write: (fileName data:) 12)
			(param1 write: (description data:) 20)
			(param1 writeWord: fileNumber)
		)
	)

	(method (descriptionMatch param1)
		(return (not ((self description:) weigh: param1)))
	)
)

(class CatalogFile of List
	(properties
		catFilePtr 0
		catDir 0
		availableNames 0
	)

	(method (init param1 &tmp temp0)
		(super init:)
		(= catDir (Str newWith: 128 param1))
		(= temp0 (Str newWith: 128 param1))
		(temp0 cat: {ramasg.cat})
		((= catFilePtr (File new:)) name: (KArray 8 (temp0 data:))) ; ArrayDup
		(temp0 dispose:)
		(= gCatalogFile self)
		((= availableNames (IntArray newWith: 100)) init: 1)
		(self serialize: 1)
	)

	(method (dispose)
		(self serialize: 0)
		(if catFilePtr
			(catFilePtr close: dispose:)
		)
		(if catDir
			(catDir dispose:)
		)
		(super dispose:)
	)

	(method (changeDir param1)
		(self dispose:)
		(self init: param1)
	)

	(method (delete param1 &tmp temp0 temp1 temp2)
		(if (< param1 (self size:))
			(= temp1 (self at: param1))
			(availableNames at: (temp1 fileNumber:) 1)
			(= temp2 (Str newWith: 132 catDir))
			(temp2 cat: (temp1 fileName:))
			((= temp0 (File new:)) name: (temp2 data:))
			(temp0 delete:)
			(temp0 dispose:)
			(super delete: temp1)
			(temp1 dispose:)
			(self serialize: 0)
			(temp2 dispose:)
		)
	)

	(method (rename param1 param2 &tmp temp0)
		(if (< param1 (self size:))
			(= temp0 (self at: param1))
			((temp0 description:) copy: param2)
			(self serialize: 0)
		)
	)

	(method (addFile param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 (availableNames indexOf: 1))
		(cond
			((and size (= temp4 (self firstTrue: #descriptionMatch param1)))
				(return (self indexOf: temp4))
			)
			((== temp3 -1)
				(return -1)
			)
			((< temp3 100)
				(= temp1 (Str new: 13))
				(temp1 format: {ramasg.%d} temp3)
				((= temp0 (CatalogEntry new:))
					fileName: (Str newWith: 13 temp1)
					description: (Str newWith: 21 param1)
					fileNumber: temp3
					init:
				)
				(self addToFront: temp0)
				(self serialize: 0)
				(availableNames at: temp3 0)
				(return 0)
			)
			(else
				(return -1)
			)
		)
		(temp1 dispose:) ; UNINIT
		(return (temp2 dispose:)) ; UNINIT
	)

	(method (open param1 param2 &tmp temp0 temp1)
		(if (< param1 (self size:))
			(= temp1 (Str newWith: 132 catDir))
			(temp1 cat: ((self at: param1) fileName:))
			(if (not ((= temp0 (File new:)) name: (temp1 data:) open: param2))
				(= temp0 0)
				((Print new:)
					plane: tmpPlane
					mode: 0
					font: 999
					fore: 202
					skip: 250
					back: 250
					addBitmap: 209 22 0
					addButtonBM: 209 15 0 27 {} 158 97
					init:
				)
			)
			(temp1 dispose:)
		else
			(= temp0 0)
		)
		(return temp0)
	)

	(method (serialize param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(return
			(if (and argc param1)
				(if (self size:)
					(self eachElementDo: #dispose release:)
				)
				(if (not (catFilePtr open: 1))
					(return 0)
				)
				(= temp2 (Str newWith: 2 {}))
				(catFilePtr read: temp2 2)
				(= temp3 (proc1111_22 temp2 0))
				(temp2 dispose:)
				(for ((= temp0 0)) (< temp0 temp3) ((++ temp0))
					(= temp1 (CatalogEntry new:))
					(temp1 serialize: catFilePtr param1)
					(= temp4 (Str newWith: 128 catDir))
					(temp4 cat: (temp1 fileName:))
					(if (FileIO fiEXISTS (temp4 data:))
						(self add: temp1)
					else
						(temp1 dispose:)
					)
					(temp4 dispose:)
				)
				(for ((= temp0 0)) (< temp0 100) ((++ temp0))
					(= temp2 (Str newWith: 2 {}))
					(catFilePtr read: temp2 2)
					(= temp3 (proc1111_22 temp2 0))
					(availableNames at: temp0 temp3)
					(temp2 dispose:)
				)
				(catFilePtr close:)
			else
				(if (not (catFilePtr open: 2))
					(return 0)
				)
				(catFilePtr writeWord: (self size:))
				(for ((= temp0 0)) (< temp0 (self size:)) ((++ temp0))
					((self at: temp0) serialize: catFilePtr param1)
				)
				(for ((= temp0 0)) (< temp0 100) ((++ temp0))
					(catFilePtr writeWord: (availableNames at: temp0))
				)
				(catFilePtr writeWord: -1)
				(catFilePtr close:)
			)
		)
	)
)

(instance tmpPlane of Plane
	(properties
		picture -2
	)
)

