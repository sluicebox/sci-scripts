;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use scaryInvInit)
(use n1111)
(use chap7Timer)
(use Str)
(use File)
(use System)

(class SaveManager of Obj
	(properties
		dirFileName 0
	)

	(method (init param1)
		(= dirFileName (Str newWith: 128 gCurSaveDir))
		(dirFileName cat: param1)
	)

	(method (save param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (Str newWith: 10 {}))
		(= temp5 (Str newWith: 128 gCurSaveDir))
		(if (OneOf gCurRoomNum 902 901) ; nameGameRoom, selectGameRoom
			(if (self dirExists:)
				(proc0_7 temp2 0 global124)
				((= temp3 (File new:))
					name: (KString 8 (dirFileName data:)) ; StrDup
					open:
					seek: -3 2
					write: temp2 2
				)
			else
				(= global124 0)
				(proc0_7 temp2 0 0)
				((= temp3 (File new:))
					name: (KString 8 (dirFileName data:)) ; StrDup
					open:
					write: temp2 2
				)
			)
			(temp3 writeString: (temp2 format: {%s\n} param1))
			(proc0_7 temp2 0 -1)
			(temp2 at: 2 global124)
			(temp3 write: temp2 3 dispose:)
		)
		(temp5 cat: ((temp2 format: {phantsg.%d} global124) data:))
		((= temp4 (File new:)) name: (KString 8 (temp5 data:)) open: 2) ; StrDup
		(proc0_7 temp2 0 global124)
		(temp4 write: temp2 2)
		(if (== gCurRoomNum 902) ; nameGameRoom
			(proc0_7 temp2 0 global108)
		else
			(proc0_7 temp2 0 gCurRoomNum)
		)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 gChapter)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 global184)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 global167)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 global172)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 global205)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 global225)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 global169)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 global125)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 global204)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 global164)
		(temp4 write: temp2 2)
		(= temp1 28)
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(proc0_7 temp2 0 [global250 temp0])
			(temp4 write: temp2 2)
		)
		(if
			(and
				(not
					(OneOf
						(gEgo view:)
						0
						1
						2
						3
						4
						5
						6
						7
						610
						611
						612
						613
						614
						615
						616
						617
					)
				)
				(== (gEgo script:) (ScriptID 30 1)) ; fidgetScript
			)
			(= temp6 ((ScriptID 30) hldEgoView:)) ; FidgetCode
		else
			(= temp6 (gEgo view:))
		)
		(proc0_7 temp2 0 temp6)
		(proc0_7 temp2 2 (gEgo x:))
		(proc0_7 temp2 4 (gEgo y:))
		(if (== gCurRoomNum 902) ; nameGameRoom
			(proc0_7 temp2 6 6)
		else
			(proc0_7 temp2 6 (gEgo moveSpeed:))
		)
		(temp4 write: temp2 8)
		(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
			(if (gEgo has: temp0)
				(proc0_7 temp2 0 -2)
			else
				(proc0_7 temp2 0 ((gInventory at: temp0) owner:))
			)
			(temp4 write: temp2 2)
		)
		(proc0_7 temp2 0 gNumCD)
		(temp4 write: temp2 2)
		(if (gGDacSound handle:)
			(proc0_7 temp2 0 (gGDacSound number:))
		else
			(proc0_7 temp2 0 -1)
		)
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 (gGDacSound vol:))
		(temp4 write: temp2 2)
		(proc0_7 temp2 0 (gGDacSound loop:))
		(temp4 write: temp2 2)
		(global114 save: temp4)
		(proc0_7 temp2 0 -1)
		(temp4 write: temp2 2)
		(temp4 dispose:)
		(temp2 dispose:)
		(temp5 dispose:)
	)

	(method (restore param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 2] temp9 temp10 temp11 temp12 temp13 temp14)
		(gGDacSound stop:)
		(global114 stop: 1)
		(= global111 0)
		(= global115 0)
		(= global118 0)
		(= global125 0)
		(= global159 0)
		(= global161 0)
		(= global162 0)
		(= global163 0)
		(= global164 0)
		(= global165 0)
		(= global167 0)
		(= global170 0)
		(= global171 0)
		(= global172 0)
		(= global173 0)
		(= global174 0)
		(= global175 0)
		(= global176 0)
		(= global177 0)
		(= global181 0)
		(= global182 0)
		(= global183 0)
		(= global184 0)
		(= global185 0)
		(= global186 0)
		(= global201 0)
		(= global205 0)
		(= global207 0)
		(= global225 0)
		(= global229 0)
		(if (IsFlag 34)
			(= temp5 1)
		else
			(= temp5 0)
		)
		(gGame setCursor: gWaitCursor 1)
		(= temp3 (Str newWith: 10 {}))
		(= temp6 (Str newWith: 128 gCurSaveDir))
		(temp6 cat: ((temp3 format: {phantsg.%d} param1) data:))
		((= temp4 (File new:))
			name: (KString 8 (temp6 data:)) ; StrDup
			open: 1
			read: temp3 4
		)
		(= temp2 (proc0_8 temp3 2))
		(temp4 read: temp3 2)
		(= gChapter (proc0_8 temp3 0))
		(temp4 read: temp3 2)
		(= global184 (proc0_8 temp3 0))
		(temp4 read: temp3 2)
		(= global167 (proc0_8 temp3 0))
		(temp4 read: temp3 2)
		(= global172 (proc0_8 temp3 0))
		(temp4 read: temp3 2)
		(= global205 (proc0_8 temp3 0))
		(temp4 read: temp3 2)
		(= global225 (proc0_8 temp3 0))
		(temp4 read: temp3 2)
		(= global169 (proc0_8 temp3 0))
		(temp4 read: temp3 2)
		(= global125 (proc0_8 temp3 0))
		(temp4 read: temp3 2)
		(= global204 (proc0_8 temp3 0))
		(temp4 read: temp3 2)
		(= global164 (proc0_8 temp3 0))
		(= temp9 (IsFlag 63))
		(proc1111_15)
		(for ((= temp0 0)) (< temp0 446) ((++ temp0))
			(ClearFlag temp0)
		)
		(= temp1 28)
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(temp4 read: temp3 2)
			(= [global250 temp0] (proc0_8 temp3 0))
		)
		(if temp9
			(SetFlag 63)
		else
			(ClearFlag 63)
		)
		(proc1111_16)
		(temp4 read: temp3 8)
		(gEgo
			view: (proc0_8 temp3 0)
			x: (proc0_8 temp3 2)
			y: (proc0_8 temp3 4)
			moveSpeed: (proc0_8 temp3 6)
			cycleSpeed: (proc0_8 temp3 6)
		)
		(if (IsFlag 362)
			(ClearFlag 362)
			(gEgo y: (+ (gEgo y:) 1000))
		)
		(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
			(= temp14 (gInventory at: temp0))
			(temp14 owner: -1)
			(proc28_3 temp14)
		)
		(for ((= temp0 0)) (< temp0 (gInventory size:)) ((++ temp0))
			(temp4 read: temp3 2)
			(if (== (proc0_8 temp3 0) -2)
				((gInventory at: temp0) owner: gEgo)
			else
				((gInventory at: temp0) owner: (proc0_8 temp3 0))
			)
		)
		(temp4 read: temp3 2)
		(= gNumCD (proc0_8 temp3 0))
		(if (!= temp2 44)
			(if temp5
				(= gNumCD 7)
			)
			(if
				(or
					(and
						gNumCD
						(!= (= temp13 (gGame getDisc: gNumCD)) 99)
					)
					(not gNumCD)
				)
				(temp4 read: temp3 2)
				(= temp10 (proc0_8 temp3 0))
				(temp4 read: temp3 2)
				(= temp12 (proc0_8 temp3 0))
				(temp4 read: temp3 2)
				(= temp11 (proc0_8 temp3 0))
				(if (> temp10 0)
					(gGDacSound number: temp10 setVol: temp12 setLoop: temp11)
					(gGDacSound play:)
				)
				(global114 restore: temp4)
				(temp4 dispose:)
				(temp3 dispose:)
				(temp6 dispose:)
				(proc28_2)
				(if temp5
					(proc45951_6)
					(ClearFlag 34)
					(SetFlag 135)
					(= temp2 45950)
				)
			)
			(if (== temp13 99)
				(= temp2 91)
			)
		)
		(= global108 temp2)
		(gCurRoom newRoom: 900)
	)

	(method (saveFileCnt &tmp temp0 temp1 temp2)
		(= temp2 (= temp0 (= temp1 0)))
		(if (self dirExists:)
			((= temp0 (File new:))
				name: (KString 8 (dirFileName data:)) ; StrDup
				open: 1
			)
			(= temp1 (Str newWith: 40 {}))
			(temp0 read: temp1 2)
			(while (!= (temp1 at: 0) 255)
				(++ temp2)
				(temp0 readString: temp1 20)
				(temp0 read: temp1 2)
			)
			(temp0 dispose:)
			(temp1 dispose:)
		)
		(return temp2)
	)

	(method (nextSaveSlot &tmp temp0 temp1 temp2 temp3 [temp4 10])
		(= temp1 (= temp2 (= temp3 0)))
		(if (self dirExists:)
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
				(= [temp4 temp0] -1)
			)
			((= temp1 (File new:))
				name: (KString 8 (dirFileName data:)) ; StrDup
				open: 1
			)
			(= temp2 (Str newWith: 40 {}))
			(temp1 read: temp2 2)
			(= temp0 0)
			(while (!= (temp2 at: 0) 255)
				(= [temp4 (temp2 at: 0)] (temp2 at: 0))
				(temp1 readString: temp2 20)
				(temp1 read: temp2 2)
			)
			(temp2 dispose:)
			(temp1 dispose:)
			(for ((= temp0 0)) (< temp0 10) ((++ temp0))
				(if (== [temp4 temp0] -1)
					(= temp3 temp0)
					(break)
				)
			)
		)
		(return temp3)
	)

	(method (getSaveType param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 -1)
		(= temp1 (Str newWith: 40 {}))
		(= temp2 (Str newWith: 128 gCurSaveDir))
		(= temp3 (Str newWith: 128 gCurSaveDir))
		(temp2 cat: ((temp1 format: {phantsg.%d} param1) data:))
		(temp3 cat: ((temp1 format: {chasedun.%d} param1) data:))
		(if (not (self dirExists:))
			(= temp0 -1)
		else
			(= temp0 0)
			(if (FileIO fiEXISTS (temp2 data:))
				(|= temp0 $0001)
			)
			(if (FileIO fiEXISTS (temp3 data:))
				(|= temp0 $0002)
			)
		)
		(temp1 dispose:)
		(temp2 dispose:)
		(temp3 dispose:)
		(return temp0)
	)

	(method (saveFileName param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 -1)
		(= temp2 0)
		(if (self dirExists:)
			((= temp2 (File new:))
				name: (KString 8 (dirFileName data:)) ; StrDup
				open: 1
			)
			(= temp3 (Str newWith: 40 {}))
			(temp2 read: temp3 2)
			(while (!= (temp3 at: 0) 255)
				(= temp1 (proc0_8 temp3 0))
				(temp2 readString: temp3 20)
				(if (== temp1 param1)
					(= temp0 temp3)
					(break)
				)
				(temp2 read: temp3 2)
			)
			(if (!= temp1 param1)
				(temp3 dispose:)
			)
		)
		(if temp2
			(temp2 dispose:)
		)
		(return temp0)
	)

	(method (uniqueSaveName param1 &tmp temp0 temp1 temp2)
		(= temp0 (Str newWith: 20 {}))
		(= temp2 0)
		(if (self dirExists:)
			((= temp1 (File new:))
				name: (KString 8 (dirFileName data:)) ; StrDup
				open: 1
				read: temp0 2
			)
			(while (!= (proc0_8 temp0 0) -1)
				(temp1 readString: temp0 20)
				(if (param1 compare: temp0)
					(= temp2 1)
					(break)
				)
				(temp1 read: temp0 2)
			)
			(temp1 dispose:)
		)
		(temp0 dispose:)
		(return (not temp2))
	)

	(method (testFlag param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(= temp1 (Str newWith: 10 {}))
		(= temp2 (Str newWith: 128 gCurSaveDir))
		(if (FileIO fiEXISTS (temp2 data:))
			(temp2 cat: ((temp1 format: {phantsg.%d} param1) data:))
			((= temp3 (File new:))
				name: (KString 8 (temp2 data:)) ; StrDup
				open: 1
				seek: 8
			)
			(temp3 seek: (/ param2 16) 1 read: temp1 2)
			(= temp0 (proc0_8 temp1 0))
			(temp3 dispose:)
		)
		(temp1 dispose:)
		(temp2 dispose:)
		(return (& temp0 (>> $8000 (mod param2 16))))
	)

	(method (setCurrentSave param1 &tmp temp0 temp1)
		(= temp0 (Str new: 2))
		(temp0 at: 0 param1)
		(if (self dirExists:)
			((= temp1 (File new:))
				name: (KString 8 (dirFileName data:)) ; StrDup
				open:
				seek: -1 2
				write: temp0 1
				dispose:
			)
		)
		(temp0 dispose:)
	)

	(method (getCurrentSave &tmp temp0 temp1 temp2)
		(= temp0 -1)
		(= temp1 (Str new: 2))
		(if (self dirExists:)
			((= temp2 (File new:))
				name: (KString 8 (dirFileName data:)) ; StrDup
				open:
				seek: -1 2
				read: temp1 1
				dispose:
			)
			(= temp0 (proc0_8 temp1 0))
		)
		(temp1 dispose:)
		(return temp0)
	)

	(method (delete param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(= temp1 (Str newWith: 40 {}))
		(= temp2 (Str newWith: 40 {}))
		(= temp3 (Str newWith: 40 {}))
		(= temp4 (Str newWith: 128 gCurSaveDir))
		(temp4 cat: ((temp1 format: {phantsg.%d} param1) data:))
		(= temp8 (Str newWith: 128 gCurSaveDir))
		(temp8 cat: ((temp1 format: {chasedun.%d} param1) data:))
		(if (FileIO fiEXISTS (temp4 data:))
			((= temp7 (File new:))
				name: (KString 8 (temp4 data:)) ; StrDup
				delete:
				dispose:
			)
		)
		(if (FileIO fiEXISTS (temp8 data:))
			((= temp7 (File new:))
				name: (KString 8 (temp8 data:)) ; StrDup
				delete:
				dispose:
			)
		)
		(= temp5 (Str newWith: 128 gCurSaveDir))
		(temp5 cat: {xyz.tmp})
		(if (!= (self saveFileCnt:) 1)
			((= temp6 (File new:))
				name: (KString 8 (dirFileName data:)) ; StrDup
				open: 1
			)
			((= temp9 (File new:)) name: (KString 8 (temp5 data:)) open: 2) ; StrDup
			(temp6 read: temp1 2)
			(while (!= (proc0_8 temp1 0) -1)
				(temp6 readString: temp2 20)
				(if (!= (proc0_8 temp1 0) param1)
					(temp9
						write: temp1 2
						writeString: (temp3 format: {%s\n} temp2)
					)
				)
				(temp6 read: temp1 2)
			)
			(temp6 delete: dispose:)
			(proc0_7 temp1 0 -1)
			(if (!= (= temp10 (self getCurrentSave:)) param1)
				(proc0_7 temp1 2 temp10)
			else
				(for ((= temp0 0)) (< temp0 10) ((++ temp0))
					(if (!= (self getSaveType: temp0) -1)
						(proc0_7 temp1 2 temp0)
						(break)
					)
				)
			)
			(temp9 write: temp1 3 dispose:)
			(FileIO fiRENAME (temp5 data:) (dirFileName data:))
		else
			((= temp6 (File new:))
				name: (KString 8 (dirFileName data:)) ; StrDup
				delete:
				dispose:
			)
		)
		(temp4 dispose:)
		(temp8 dispose:)
		(temp5 dispose:)
		(temp1 dispose:)
		(temp2 dispose:)
		(temp3 dispose:)
	)

	(method (dirExists)
		(FileIO fiEXISTS (dirFileName data:))
	)
)

