;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64994)
(include sci.sh)
(use Main)
(use P2View)
(use Plane)
(use Str)
(use PolyEdit)
(use WriteFeature)
(use PlaneManager)
(use Sound)
(use User)
(use Menu)
(use System)

(class Game of Obj
	(properties
		num 0
		comment 0
		handsOffCode 0
		handsOnCode 0
		panelObj 0
		panelSelector 0
		printLang 1
	)

	(method (init)
		(= gLastScreenX (- gScreenWidth 1))
		(= gLastScreenY (- gScreenHeight 1))
		(= gCurSaveDir (Str new:))
		(KArray 4 (gCurSaveDir data:)) ; ArrayFree
		(gCurSaveDir data: (Save 2)) ; GetSaveDir
		(if (not gUser)
			((= gUser (User new:)) init:)
		)
		(if (not gPlanes)
			(= gPlanes (PlaneManager new:))
		)
		(if (not gThePlane)
			((= gThePlane (Plane new:)) priority: 10 init: 0 0 gLastScreenX gLastScreenY)
		)
		(if (not gCast)
			(= gCast (Set new:))
		)
		(if (not gSounds)
			(= gSounds (SoundManager new:))
		)
	)

	(method (doit &tmp temp0 temp1)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if panelObj
			(= temp0 panelObj)
			(= temp1 panelSelector)
			(= panelObj (= panelSelector 0))
			(Eval temp0 temp1)
		)
		(gPlanes doit:)
		(gCast doit:)
		(FrameOut)
		(gUser doit:)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
	)

	(method (gameLoop)
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (handsOff)
		(if handsOffCode
			(handsOffCode doit: &rest)
		else
			(gUser canInput: 0)
		)
	)

	(method (handsOn)
		(if handsOnCode
			(handsOnCode doit: &rest)
		else
			(gUser canInput: 1)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(PalCycle 4) ; Off
		(RemapColors 0) ; Off
		(if gCurRoom
			(= temp0 (gCurRoom purge:))
			(if (gCurRoom dispose:)
				(DisposeScript gCurRoomNum)
			)
			(Purge temp0)
		)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum newRoomNumber)
		(= gNewRoomNum newRoomNumber)
		(self startRoom: gCurRoomNum)
		(gUser flushEvents:)
	)

	(method (panelSend param1 param2)
		(if panelObj
			(return 0)
		else
			(= panelObj param1)
			(= panelSelector param2)
		)
		(return 1)
	)

	(method (play)
		(= gGame self)
		(self init:)
		(self gameLoop:)
	)

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(for
			((= temp3 (gPlanes first:)))
			temp3
			((= temp3 (gPlanes next: temp3)))
			
			(= temp1 (gPlanes value: temp3))
			(AddPlane temp1)
			(= temp2 ((temp1 cast:) itemList:))
			(for
				((= temp4 (temp2 first:)))
				temp4
				((= temp4 (temp2 next: temp4)))
				
				(= temp6 (temp2 value: temp4))
				(if (& (temp6 info:) $0010)
					(AddScreenItem temp6)
				)
			)
			(= temp7 (temp1 cast:))
			(for
				((= temp8 (temp7 first:)))
				temp8
				((= temp8 (temp7 next: temp8)))
				
				(= temp9 (temp7 value: temp8))
				(if (temp9 isKindOf: P2View)
					(cond
						(
							(and
								(= temp10 (temp9 target:))
								(temp10 isKindOf: View)
							)
							(temp10 signal: (| (temp10 signal:) $0010))
							(AddScreenItem temp10)
						)
						((and temp10 (temp10 isKindOf: OnMeList))
							(for
								((= temp11 (temp10 first:)))
								temp11
								((= temp11 (temp10 next: temp11)))
								
								(= temp12 (temp10 value: temp11))
								(if (& (temp12 signal:) $0010)
									(AddScreenItem temp12)
								)
							)
						)
					)
				)
			)
		)
		(DoSound sndRESTORE)
		(gSounds pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(self gameLoop:)
	)

	(method (restore &tmp temp0 [temp1 9] temp10 [temp11 6] temp17 temp18 [temp19 3])
		(= temp0 0)
		(if (not (FileIO 19 (KArray 9 gCurSaveDir))) ; ValidPath, ArrayGetData
			(PrintDebug {"%s" is an invalid path} (KArray 9 gCurSaveDir)) ; ArrayGetData
			(return 0)
		)
		(= temp10 (Str new: 36))
		(for
			((= temp0 -4))
			(< temp0 -3)
			((= temp0 ((ScriptID global41 0) init: temp10 1)))
		)
		(= temp18 1)
		(= temp17 (Str format: { }))
		(Message msgGET 0 0 0 22 1 (temp17 data:)) ; "<PROTECTED>"
		(if (!= -1 (temp10 strIndex: temp17))
			(= temp18 0)
		)
		(if
			(and
				(== temp18 0)
				(or (== gCurRoomNum 62999) (!= global207 0)) ; p2IntroRm
				(!= 1 ((ScriptID 0 5) new: (not global250))) ; IntensityPassWordWindow
			)
			(= temp0 -1)
		)
		(temp17 dispose:)
		(temp10 dispose:)
		(if (< temp0 0)
			(return 0)
		)
		(= num temp0)
		(return (self panelSend: self 312))
	)

	(method (reallyRestore &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(= temp0 num)
		(gSounds pause: 1)
		(for
			((= temp2 (gPlanes first:)))
			temp2
			((= temp2 (gPlanes next: temp2)))
			
			(= temp1 (gPlanes value: temp2))
			(= temp3 ((temp1 cast:) itemList:))
			(for
				((= temp4 (temp3 first:)))
				temp4
				((= temp4 (temp3 next: temp4)))
				
				(= temp5 (temp3 value: temp4))
				(if (= temp6 (& (temp5 signal:) $0010))
					(DeleteScreenItem temp5)
					(temp5 signal: (| (temp5 signal:) temp6))
				)
			)
			(= temp7 (temp1 cast:))
			(for
				((= temp8 (temp7 first:)))
				temp8
				((= temp8 (temp7 next: temp8)))
				
				(= temp9 (temp7 value: temp8))
				(if (temp9 isKindOf: P2View)
					(cond
						(
							(and
								(= temp10 (temp9 target:))
								(temp10 isKindOf: View)
								(& (temp10 signal:) $0010)
							)
							(DeleteScreenItem temp10)
							(temp10 signal: (| (temp10 signal:) $0010))
						)
						((and temp10 (temp10 isKindOf: OnMeList))
							(for
								((= temp11 (temp10 first:)))
								temp11
								((= temp11 (temp10 next: temp11)))
								
								(= temp12 (temp10 value: temp11))
								(if (& (temp12 signal:) $0010)
									(DeleteScreenItem temp12)
									(temp12 signal: (| (temp12 signal:) $0010))
								)
							)
						)
					)
				)
			)
			(DeletePlane temp1)
			(((temp1 cast:) eventList:) eachElementDo: #dispose)
			(((temp1 cast:) doitList:) eachElementDo: #dispose)
		)
		(if (Save 3 name temp0 (KArray 9 gVersion)) ; CheckSaveGame, ArrayGetData
			(gGame getDisc: (CD 1)) ; GetSaveCD
			(PrintDebug {About to call restore})
			(Save 1 name temp0 (KArray 9 gVersion)) ; RestoreGame, ArrayGetData
			(PrintDebug {Restore has failed mysteriously})
		else
			(for
				((= temp2 (gPlanes first:)))
				temp2
				((= temp2 (gPlanes next: temp2)))
				
				(= temp1 (gPlanes value: temp2))
				(AddPlane temp1)
				(= temp3 ((temp1 cast:) itemList:))
				(for
					((= temp4 (temp3 first:)))
					temp4
					((= temp4 (temp3 next: temp4)))
					
					(= temp5 (temp3 value: temp4))
					(if (& (temp5 signal:) $0010)
						(AddScreenItem temp5)
					)
				)
			)
			(= temp7 (temp1 cast:))
			(for
				((= temp8 (temp7 first:)))
				temp8
				((= temp8 (temp7 next: temp8)))
				
				(= temp9 (temp7 value: temp8))
				(if (temp9 isKindOf: P2View)
					(cond
						(
							(and
								(= temp10 (temp9 target:))
								(temp10 isKindOf: View)
							)
							(temp10 signal: (| (temp10 signal:) $0010))
							(AddScreenItem temp10)
						)
						((and temp10 (temp10 isKindOf: OnMeList))
							(for
								((= temp11 (temp10 first:)))
								temp11
								((= temp11 (temp10 next: temp11)))
								
								(= temp12 (temp10 value: temp11))
								(if (& (temp12 signal:) $0010)
									(AddScreenItem temp12)
								)
							)
						)
					)
				)
			)
			(PrintDebug {Incompatible version or interp})
		)
		(gSounds pause: 0)
	)

	(method (save &tmp temp0 [temp1 5])
		(= num -4)
		(= comment (Str new: 36))
		(if (not (FileIO 19 (KArray 9 gCurSaveDir))) ; ValidPath, ArrayGetData
			(PrintDebug {"%s" is an invalid path} (KArray 9 gCurSaveDir)) ; ArrayGetData
			(return 0)
		)
		(while (< num -2)
			(= temp0 (if (== num -3) 2 else 0))
			(= num ((ScriptID global41 0) init: comment temp0))
		)
		(if (< num 0)
			(comment dispose:)
			(return 0)
		)
		(comment scratch: num)
		(return (self panelSend: self 311))
	)

	(method (reallySave &tmp temp0 temp1 temp2)
		(gSounds pause: 1)
		(= temp0 (= temp1 (= temp2 0)))
		(= temp0 (Str format: { }))
		(Message msgGET 0 0 0 22 (+ global207 1) (temp0 data:))
		(if (= temp2 (== -1 (comment strIndex: temp0)))
			(= temp1 comment)
			(= comment (temp1 getLeft: (- 36 (temp0 size:))))
			(comment cat: temp0)
		)
		(temp0 dispose:)
		(if (Save 0 name num (comment data:) (KArray 9 gVersion)) ; SaveGame, ArrayGetData
			(PrintDebug {Game saved.})
		else
			(PrintDebug {Save game failed.})
		)
		(gSounds pause: 0)
		(if temp1
			(temp1 dispose:)
		)
		(comment dispose:)
	)

	(method (startRoom roomNum)
		(NewRoom gNewRoomNum)
		(if gDebugOn
			(SetDebug roomNum)
		)
		(= gCurRoom (ScriptID roomNum))
		(gCurRoom init:)
	)
)

