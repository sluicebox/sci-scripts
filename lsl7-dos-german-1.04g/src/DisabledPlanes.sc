;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64888)
(include sci.sh)
(use Main)
(use oMainMenu)
(use DialogPlane)
(use n64866)
(use NewUser)
(use soFlashCyberSniff)
(use Str)
(use Sound)
(use System)

(public
	DisabledPlanes 0
	proc64888_1 1
	proc64888_2 2
	proc64888_3 3
	proc64888_4 4
	proc64888_5 5
	proc64888_6 6
	proc64888_7 7
	proc64888_8 8
	oPlaneStack 9
)

(procedure (proc64888_1 &tmp temp0 temp1)
	(= temp1 (gDisabledPlanes size:))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		((gDisabledPlanes at: 0) enable:)
	)
)

(procedure (proc64888_2 &tmp temp0 temp1)
	(= temp1 (gPlanes size:))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		((gPlanes at: 0) disable:)
	)
)

(procedure (proc64888_3 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
		([param1 temp0] enable:)
	)
)

(procedure (proc64888_4 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
		([param1 temp0] disable:)
	)
)

(procedure (proc64888_5) ; UNUSED
	(proc64888_2)
	(proc64888_3 &rest)
)

(procedure (proc64888_6) ; UNUSED
	(proc64888_1)
	(proc64888_4 &rest)
)

(procedure (proc64888_7 &tmp temp0)
	(oPlaneStack addToFront: 0)
	(for ((= temp0 0)) (< temp0 (gPlanes size:)) ((++ temp0))
		(oPlaneStack addToFront: (gPlanes at: temp0))
	)
)

(procedure (proc64888_8 &tmp temp0)
	(if (oPlaneStack isEmpty:)
		(PrintDebug {Tried to restore plane when none saved on stack.})
		(return)
	)
	(while (= temp0 (oPlaneStack at: 0))
		(temp0 enable:)
		(oPlaneStack delete: temp0)
	)
	(oPlaneStack delete: 0)
)

(instance DisabledPlanes of Set
	(properties)

	(method (eachElementDo param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (KList 3 elements))) temp0 ((= temp0 nextNode)) ; FirstNode
			(= nextNode (KList 6 temp0)) ; NextNode
			(= temp1 ((KList 8 temp0) casts:)) ; NodeValue
			(for
				((= temp0 (KList 3 (temp1 elements:)))) ; FirstNode
				temp0
				((= temp0 (temp1 nextNode:)))
				
				(temp1 nextNode: (KList 6 temp0)) ; NextNode
				(= temp2 (KList 8 temp0)) ; NodeValue
				(temp2 eachElementDo: param1 &rest)
			)
		)
	)
)

(instance oPlaneStack of List
	(properties)
)

(class NewGame of DoitChangedGame
	(properties
		nGameSpeed 7
	)

	(method (init)
		((= gDisabledPlanes DisabledPlanes) add:)
		((= gOPlaneStack oPlaneStack) add:)
		(super init: &rest)
	)

	(method (newRoom)
		(self handsOff:)
		(super newRoom: &rest)
	)

	(method (startRoom &tmp temp0)
		(if ((ScriptID 64017 0) test: 158) ; oFlags
			((ScriptID 90 0) dispose:) ; oTravelScreen
		)
		(if ((ScriptID 64040 2) oPlane:) ; L7TalkWindow
			((ScriptID 64040 2) dispose:) ; L7TalkWindow
		)
		(if global202
			(= temp0
				(Str
					format:
						{Just disposed, room %hd, about to init room: %hd}
						gPrevRoomNum
						gCurRoomNum
				)
			)
			(DumpClones (temp0 data:))
			(temp0 dispose:)
		)
		(super startRoom: &rest)
	)

	(method (masterVolume param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (autosave param1 param2 &tmp temp0 [temp1 2] temp3 temp4 temp5)
		(if (> argc 1)
			(= temp0 param2)
		else
			(= temp0 0)
		)
		(= temp5 (Str new:))
		(temp5 copy: gCurSaveDir)
		(gCurSaveDir copy: global115)
		(if (FileIO 19 (KArray 9 gCurSaveDir)) ; ValidPath, ArrayGetData
			(= temp3 (self setCursor: gWaitCursor 1))
			(if argc
				(if param1
					(Save 0 {Autosv} temp0 (param1 data:) (KArray 9 gVersion)) ; SaveGame, ArrayGetData
				else
					(Save 0 {Autosv} temp0 {A Fresh Game} (KArray 9 gVersion)) ; SaveGame, ArrayGetData
				)
			else
				(Save
					0 ; SaveGame
					{Autosv}
					temp0
					{Where I last left off...}
					(KArray 9 gVersion) ; ArrayGetData
				)
			)
			(self setCursor: temp3 (HaveMouse))
		)
		(gCurSaveDir copy: temp5)
		(temp5 dispose:)
	)

	(method (autorestore param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(if argc
			(= temp0 param1)
		else
			(= temp0 0)
		)
		(= temp12 (Str new:))
		(temp12 copy: gCurSaveDir)
		(gCurSaveDir copy: global115)
		(if (not (Save 3 {Autosv} temp0 (KArray 9 gVersion))) ; CheckSaveGame, ArrayGetData
			(if temp0
				(TextDialog (MakeMessageText 0 0 2 1 14) (Str with: global288))
				(= gQuit 1)
			)
			(gCurSaveDir copy: temp12)
			(temp12 dispose:)
			(return)
		)
		(= temp2 (Str new:))
		(= temp3 (Str new:))
		(= temp1 (Str new:))
		(Sound pause: 1)
		(for
			((= temp4 (KList 3 (gPlanes elements:)))) ; FirstNode
			temp4
			((= temp4 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 temp4)) ; NextNode
			(= temp7 (KList 8 temp4)) ; NodeValue
			(for
				((= temp5 (KList 3 ((temp7 casts:) elements:)))) ; FirstNode
				temp5
				((= temp5 ((temp7 casts:) nextNode:)))
				
				((temp7 casts:) nextNode: (KList 6 temp5)) ; NextNode
				(= temp8 (KList 8 temp5)) ; NodeValue
				(for
					((= temp6 (KList 3 (temp8 elements:)))) ; FirstNode
					temp6
					((= temp6 (temp8 nextNode:)))
					
					(temp8 nextNode: (KList 6 temp6)) ; NextNode
					(= temp9 (KList 8 temp6)) ; NodeValue
					(if (= temp10 (& (temp9 Info:) $0010))
						(DeleteScreenItem temp9)
					)
				)
			)
			(DeletePlane temp7)
		)
		(for
			((= temp4 (KList 3 (gDisabledPlanes elements:)))) ; FirstNode
			temp4
			((= temp4 (gDisabledPlanes nextNode:)))
			
			(gDisabledPlanes nextNode: (KList 6 temp4)) ; NextNode
			(= temp7 (KList 8 temp4)) ; NodeValue
			(for
				((= temp5 (KList 3 ((temp7 casts:) elements:)))) ; FirstNode
				temp5
				((= temp5 ((temp7 casts:) nextNode:)))
				
				((temp7 casts:) nextNode: (KList 6 temp5)) ; NextNode
				(= temp8 (KList 8 temp5)) ; NodeValue
				(for
					((= temp6 (KList 3 (temp8 elements:)))) ; FirstNode
					temp6
					((= temp6 (temp8 nextNode:)))
					
					(temp8 nextNode: (KList 6 temp6)) ; NextNode
					(= temp9 (KList 8 temp6)) ; NodeValue
					(if (= temp10 (& (temp9 Info:) $0010))
						(DeleteScreenItem temp9)
					)
				)
			)
			(DeletePlane temp7)
		)
		(self setCursor: gWaitCursor 1)
		(Save 1 {Autosv} temp0 (KArray 9 gVersion)) ; RestoreGame, ArrayGetData
		(TextDialog (MakeMessageText 0 0 2 1 14) (Str with: global288))
		(= gQuit 1)
		(self setCursor: temp11 (HaveMouse)) ; UNINIT
		(Sound pause: 0)
		(temp2 dispose:)
		(temp3 dispose:)
		(temp1 dispose:)
		(gCurSaveDir copy: temp12)
		(temp12 dispose:)
	)

	(method (save &tmp [temp0 6])
		(proc64866_0)
	)

	(method (saveThis param1 param2 &tmp temp0 [temp1 3])
		(if gNumCD
			(self getDisc: gNumCD)
		)
		(= temp0 (self setCursor: gWaitCursor 1))
		(global114 copy: param2)
		(if (not (Save 0 name param1 (param2 data:) (KArray 9 gVersion))) ; SaveGame, ArrayGetData
			(TextDialog (MakeMessageText 10 0 0 1 64994) (Str with: global288))
		else
			(= global113 param1)
			(self autosave: param2)
			(global114 copy: param2)
		)
		(self setCursor: temp0 (HaveMouse))
	)

	(method (restore &tmp [temp0 12])
		(proc64866_1)
	)

	(method (restoreThis param1 &tmp [temp0 4] temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(if (not (Save 3 name param1 (KArray 9 gVersion))) ; CheckSaveGame, ArrayGetData
			(TextDialog (MakeMessageText 3 0 0 1 64994) (Str with: global288))
			(return)
		)
		(for
			((= temp8 (KList 3 (gPlanes elements:)))) ; FirstNode
			temp8
			((= temp8 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 temp8)) ; NextNode
			(= temp4 (KList 8 temp8)) ; NodeValue
			(for
				((= temp9 (KList 3 ((temp4 casts:) elements:)))) ; FirstNode
				temp9
				((= temp9 ((temp4 casts:) nextNode:)))
				
				((temp4 casts:) nextNode: (KList 6 temp9)) ; NextNode
				(= temp5 (KList 8 temp9)) ; NodeValue
				(for
					((= temp10 (KList 3 (temp5 elements:)))) ; FirstNode
					temp10
					((= temp10 (temp5 nextNode:)))
					
					(temp5 nextNode: (KList 6 temp10)) ; NextNode
					(= temp6 (KList 8 temp10)) ; NodeValue
					(if (= temp7 (& (temp6 Info:) $0010))
						(DeleteScreenItem temp6)
					)
				)
			)
			(DeletePlane temp4)
		)
		(for
			((= temp8 (KList 3 (gDisabledPlanes elements:)))) ; FirstNode
			temp8
			((= temp8 (gDisabledPlanes nextNode:)))
			
			(gDisabledPlanes nextNode: (KList 6 temp8)) ; NextNode
			(= temp4 (KList 8 temp8)) ; NodeValue
			(for
				((= temp9 (KList 3 ((temp4 casts:) elements:)))) ; FirstNode
				temp9
				((= temp9 ((temp4 casts:) nextNode:)))
				
				((temp4 casts:) nextNode: (KList 6 temp9)) ; NextNode
				(= temp5 (KList 8 temp9)) ; NodeValue
				(for
					((= temp10 (KList 3 (temp5 elements:)))) ; FirstNode
					temp10
					((= temp10 (temp5 nextNode:)))
					
					(temp5 nextNode: (KList 6 temp10)) ; NextNode
					(= temp6 (KList 8 temp10)) ; NodeValue
					(if (= temp7 (& (temp6 Info:) $0010))
						(DeleteScreenItem temp6)
					)
				)
			)
			(DeletePlane temp4)
		)
		(self setCursor: gWaitCursor 1)
		(Save 1 name param1 (KArray 9 gVersion)) ; RestoreGame, ArrayGetData
	)

	(method (replay &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= global113 -1)
		(Palette 1 999) ; PalLoad
		(for
			((= temp4 (KList 3 (gPlanes elements:)))) ; FirstNode
			temp4
			((= temp4 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 temp4)) ; NextNode
			(= temp1 (KList 8 temp4)) ; NodeValue
			(AddPlane temp1)
			(for
				((= temp5 (KList 3 ((temp1 casts:) elements:)))) ; FirstNode
				temp5
				((= temp5 ((temp1 casts:) nextNode:)))
				
				((temp1 casts:) nextNode: (KList 6 temp5)) ; NextNode
				(= temp2 (KList 8 temp5)) ; NodeValue
				(for
					((= temp6 (KList 3 (temp2 elements:)))) ; FirstNode
					temp6
					((= temp6 (temp2 nextNode:)))
					
					(temp2 nextNode: (KList 6 temp6)) ; NextNode
					(= temp3 (KList 8 temp6)) ; NodeValue
					(if (& (temp3 Info:) $0010)
						(AddScreenItem temp3)
					)
				)
			)
			(temp1 replay:)
		)
		(for
			((= temp4 (KList 3 (gDisabledPlanes elements:)))) ; FirstNode
			temp4
			((= temp4 (gDisabledPlanes nextNode:)))
			
			(gDisabledPlanes nextNode: (KList 6 temp4)) ; NextNode
			(= temp1 (KList 8 temp4)) ; NodeValue
			(AddPlane temp1)
			(for
				((= temp5 (KList 3 ((temp1 casts:) elements:)))) ; FirstNode
				temp5
				((= temp5 ((temp1 casts:) nextNode:)))
				
				((temp1 casts:) nextNode: (KList 6 temp5)) ; NextNode
				(= temp2 (KList 8 temp5)) ; NodeValue
				(for
					((= temp6 (KList 3 (temp2 elements:)))) ; FirstNode
					temp6
					((= temp6 (temp2 nextNode:)))
					
					(temp2 nextNode: (KList 6 temp6)) ; NextNode
					(= temp3 (KList 8 temp6)) ; NodeValue
					(if (& (temp3 Info:) $0010)
						(AddScreenItem temp3)
					)
				)
			)
			(temp1 replay:)
		)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gGame setCursor: gWaitCursor 1)
		(= temp0
			(if (not (OneOf (gCurRoom style:) -1 16 17 18 19))
				(gCurRoom style:)
			else
				0
			)
		)
		(cond
			((and (not (gUser canControl:)) (not (gUser canInput:)))
				(gGame setCursor: gWaitCursor)
			)
			((and gTheIconBar (gTheIconBar curIcon:))
				(gGame setCursor: (gTheIconBar getCursor:))
			)
			(else
				(gGame setCursor: gNormalCursor)
			)
		)
		(if (IsHiRes)
			(Font 1 640 480) ; SetFontRes
		)
		(= temp7 (gSounds size:))
		(for ((= temp9 0)) (< temp9 temp7) ((++ temp9))
			(if (and (= temp8 (gSounds at: temp9)) (!= (temp8 audTicks:) -1))
				(temp8 audTicks: 0)
			)
		)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(proc64000_4)
		(while (not gQuit)
			(self doit:)
		)
	)
)

