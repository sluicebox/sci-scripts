;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use ExitButton)
(use Str)
(use File)
(use System)

(class CareerID of Obj
	(properties
		dirExt 0
		idName 0
		valorCnt 0
		starCnt 0
		disServiceCnt 0
		meritServCnt 0
		commCitationCnt 0
		policeCnt 0
	)

	(method (writeData param1 &tmp temp0)
		(= temp0 (Str new:))
		(proc4_7 temp0 0 dirExt)
		(param1 write: temp0 2 write: (idName data:) 24)
		(proc4_7 temp0 0 valorCnt)
		(param1 write: temp0 2)
		(proc4_7 temp0 0 starCnt)
		(param1 write: temp0 2)
		(proc4_7 temp0 0 disServiceCnt)
		(param1 write: temp0 2)
		(proc4_7 temp0 0 meritServCnt)
		(param1 write: temp0 2)
		(proc4_7 temp0 0 commCitationCnt)
		(param1 write: temp0 2)
		(proc4_7 temp0 0 policeCnt)
		(param1 write: temp0 2)
		(temp0 dispose:)
	)

	(method (dispose)
		(if idName
			(idName dispose:)
		)
		(super dispose:)
	)
)

(class CareerIDSet of List
	(properties
		nextId 0
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (Str format: {%s%s} (gStr data:) {swatid.cat}))
		(if (= temp1 (FileIO fiEXISTS (temp0 data:)))
			(= temp3 (Str new: 10))
			(= temp5 (Str new: 30))
			((= temp2 (File new:)) name: (temp0 data:) open: 1 read: temp3 2)
			(while (!= (proc4_8 temp3 0) -1)
				(temp2 read: temp5 24)
				(self
					addToEnd:
						((= temp4 (CareerID new:))
							dirExt: (proc4_8 temp3 0)
							idName:
								((Str new: 24) copy: (temp5 data:) yourself:)
							yourself:
						)
				)
				(temp2 read: temp3 2)
				(temp4 valorCnt: (proc4_8 temp3 0))
				(temp2 read: temp3 2)
				(temp4 starCnt: (proc4_8 temp3 0))
				(temp2 read: temp3 2)
				(temp4 disServiceCnt: (proc4_8 temp3 0))
				(temp2 read: temp3 2)
				(temp4 meritServCnt: (proc4_8 temp3 0))
				(temp2 read: temp3 2)
				(temp4 commCitationCnt: (proc4_8 temp3 0))
				(temp2 read: temp3 2)
				(temp4 policeCnt: (proc4_8 temp3 0))
				(temp2 read: temp3 2)
			)
			(temp2 read: temp3 2)
			(= nextId (proc4_8 temp3 0))
			(temp3 dispose:)
			(temp5 dispose:)
			(temp2 close: dispose:)
		)
		(temp0 dispose:)
		(return temp1)
	)

	(method (add param1 &tmp temp0 temp1)
		(if (not elements)
			(= elements (KList 0)) ; New
		)
		(= temp1 (self findNextId:))
		(param1 dirExt: nextId)
		(if (not (self isDuplicate: param1))
			(if nextId
				(= temp0 (KList 15 elements (self at: (- nextId 1)))) ; FindKey
				(KList 9 elements temp0 (KList 2 param1 param1)) ; AddAfter, NewNode
			else
				(KList 10 elements (KList 2 param1 param1)) ; AddToFront, NewNode
			)
			(++ size)
		)
		(self findNextId:)
		(return temp1)
	)

	(method (createId param1 &tmp temp0 temp1)
		(if (>= size 10)
			(return -1)
		)
		(= temp0 (Str new: 24))
		(return
			(self add: ((CareerID new:) idName: (temp0 copy: param1) yourself:))
		)
	)

	(method (deleteId param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (>= param1 size)
			(return)
		)
		(= temp0 (self at: param1))
		(= temp1
			(Str
				format:
					{%s%s%03d\5c}
					(gStr data:)
					{swatdata.}
					(temp0 dirExt:)
			)
		)
		(if (FileIO 19 (temp1 data:)) ; ValidPath
			(= temp4 (File new:))
			(= temp2 (Str new: 13))
			(= temp6 (Str new:))
			(= temp5 (Str format: {%s*.*} (temp1 data:)))
			(for
				((= temp3 (FileIO fiFIND_FIRST (temp5 data:) (temp2 data:) 0)))
				temp3
				((= temp3 (FileIO fiFIND_NEXT (temp2 data:))))
				
				(temp6 format: {%s%s} (temp1 data:) (temp2 data:))
				(temp4 name: (temp6 data:) delete:)
			)
			(temp6 dispose:)
			(temp2 dispose:)
			(temp5 dispose:)
			(temp4 dispose:)
		)
		(self delete: temp0)
		(if size
			(self findNextId: write:)
		else
			(temp1 format: {%s%s} (gStr data:) {swatid.cat})
			((= temp4 (File new:)) name: (temp1 data:) delete: dispose:)
		)
		(temp1 dispose:)
	)

	(method (selectId param1 &tmp temp0 temp1)
		(if (= temp0 (self at: param1))
			(= temp1
				(Str
					format:
						{%s%s%03d\5c}
						(gStr data:)
						{swatdata.}
						(temp0 dirExt:)
				)
			)
			(if (FileIO 19 (temp1 data:)) ; ValidPath
				(gCurSaveDir copy: temp1)
				(= global111 (temp0 dirExt:))
				(= global439 (temp0 valorCnt:))
				(= global440 (temp0 starCnt:))
				(= global441 (temp0 disServiceCnt:))
				(= global442 (temp0 meritServCnt:))
				(= global443 (temp0 commCitationCnt:))
				(= global444 (temp0 policeCnt:))
			)
			(temp1 dispose:)
		)
	)

	(method (write &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6)
		(= temp0 (Str format: {%s%s} (gStr data:) {swatid.cat}))
		((= temp2 (File new:)) name: (temp0 data:) open: 2)
		(self eachElementDo: #writeData temp2)
		(= temp5 (Str new: 2))
		(= temp6 (Str new: 2))
		(temp5 at: 0 -1 -1)
		(proc4_7 temp6 0 nextId)
		(temp2 write: temp5 2 write: temp6 2 close: dispose:)
		(temp5 dispose:)
		(temp6 dispose:)
		(temp0 dispose:)
	)

	(method (findNextId &tmp temp0 temp1)
		(= nextId 0)
		(for ((= temp0 (KList 3 elements))) temp0 ((= temp0 (KList 6 temp0))) ; FirstNode, NextNode
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (!= (temp1 dirExt:) nextId)
				(break)
			)
			(++ nextId)
		)
		(return nextId)
	)

	(method (getCareerIdObj param1 &tmp temp0 temp1)
		(for ((= temp0 (KList 3 elements))) temp0 ((= temp0 (KList 6 temp0))) ; FirstNode, NextNode
			(= temp1 (KList 8 temp0)) ; NodeValue
			(if (== (temp1 dirExt:) param1)
				(break)
			)
		)
		(return temp1)
	)
)

