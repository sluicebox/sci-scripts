;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64888)
(include sci.sh)
(use Main)
(use oMainMenu)
(use DialogPlane)
(use n64866)
(use NewUser)
(use n64896)
(use Str)
(use Sound)
(use System)

(public
	DisabledPlanes 0
	EnableAllPlanes 1
	DisableAllPlanes 2
	EnablePlanes 3
	DisablePlanes 4
	EnableJustPlanes 5
	DisableJustPlanes 6
	SavePlanes 7
	RestorePlanes 8
	oPlaneStack 9
)

(procedure (EnableAllPlanes &tmp i nSize)
	(= nSize (gDisabledPlanes size:))
	(for ((= i 0)) (< i nSize) ((++ i))
		((gDisabledPlanes at: 0) enable:)
	)
)

(procedure (DisableAllPlanes &tmp i nSize)
	(= nSize (gPlanes size:))
	(for ((= i 0)) (< i nSize) ((++ i))
		((gPlanes at: 0) disable:)
	)
)

(procedure (EnablePlanes oList &tmp i)
	(for ((= i 0)) (< i argc) ((++ i))
		([oList i] enable:)
	)
)

(procedure (DisablePlanes oList &tmp i)
	(for ((= i 0)) (< i argc) ((++ i))
		([oList i] disable:)
	)
)

(procedure (EnableJustPlanes) ; UNUSED
	(DisableAllPlanes)
	(EnablePlanes &rest)
)

(procedure (DisableJustPlanes) ; UNUSED
	(EnableAllPlanes)
	(DisablePlanes &rest)
)

(procedure (SavePlanes &tmp i)
	(oPlaneStack addToFront: 0)
	(for ((= i 0)) (< i (gPlanes size:)) ((++ i))
		(oPlaneStack addToFront: (gPlanes at: i))
	)
)

(procedure (RestorePlanes &tmp oPlane)
	(if (oPlaneStack isEmpty:)
		(PrintDebug {Tried to restore plane when none saved on stack.})
		(return)
	)
	(while (= oPlane (oPlaneStack at: 0))
		(oPlane enable:)
		(oPlaneStack delete: oPlane)
	)
	(oPlaneStack delete: 0)
)

(instance DisabledPlanes of Set
	(properties)

	(method (eachElementDo action &tmp node aCastList obj)
		(for ((= node (KList 3 elements))) node ((= node nextNode)) ; FirstNode
			(= nextNode (KList 6 node)) ; NextNode
			(= aCastList ((KList 8 node) casts:)) ; NodeValue
			(for
				((= node (KList 3 (aCastList elements:)))) ; FirstNode
				node
				((= node (aCastList nextNode:)))
				
				(aCastList nextNode: (KList 6 node)) ; NextNode
				(= obj (KList 8 node)) ; NodeValue
				(obj eachElementDo: action &rest)
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

	(method (masterVolume newVol)
		(if argc
			(DoSound sndMASTER_VOLUME newVol)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (autosave comment n &tmp temp0 [temp1 2] temp3 temp4 temp5)
		(if (> argc 1)
			(= temp0 n)
		else
			(= temp0 0)
		)
		(= temp5 (Str new:))
		(temp5 copy: gCurSaveDir)
		(gCurSaveDir copy: global115)
		(if (FileIO 19 (KString 9 gCurSaveDir)) ; ValidPath, StrGetData
			(= temp3 (self setCursor: gWaitCursor 1))
			(if argc
				(if comment
					(Save
						0 ; SaveGame
						{Autosave}
						temp0
						(comment data:)
						(KString 9 gVersion) ; StrGetData
					)
				else
					(Save
						0 ; SaveGame
						{Autosave}
						temp0
						{A Fresh Game}
						(KString 9 gVersion) ; StrGetData
					)
				)
			else
				(Save
					0 ; SaveGame
					{Autosave}
					temp0
					{Where I last left off...}
					(KString 9 gVersion) ; StrGetData
				)
			)
			(self setCursor: temp3 (HaveMouse))
		)
		(gCurSaveDir copy: temp5)
		(temp5 dispose:)
	)

	(method (autorestore n &tmp nSaveNum str buf1 buf2 node1 node2 node3 aPlane aList obj bit oldCur strSaveDir)
		(if argc
			(= nSaveNum n)
		else
			(= nSaveNum 0)
		)
		(= strSaveDir (Str new:))
		(strSaveDir copy: gCurSaveDir)
		(gCurSaveDir copy: global115)
		(if (not (Save 3 {Autosave} nSaveNum (KString 9 gVersion))) ; CheckSaveGame, StrGetData
			(if nSaveNum
				(TextDialog (MakeMessageText 0 0 36 1 0) (Str with: goDismissString))
				(= gQuit 1)
			)
			(gCurSaveDir copy: strSaveDir)
			(strSaveDir dispose:)
			(return)
		)
		(= buf1 (Str new:))
		(= buf2 (Str new:))
		(= str (Str new:))
		(Sound pause: 1)
		(for
			((= node1 (KList 3 (gPlanes elements:)))) ; FirstNode
			node1
			((= node1 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 node1)) ; NextNode
			(= aPlane (KList 8 node1)) ; NodeValue
			(for
				((= node2 (KList 3 ((aPlane casts:) elements:)))) ; FirstNode
				node2
				((= node2 ((aPlane casts:) nextNode:)))
				
				((aPlane casts:) nextNode: (KList 6 node2)) ; NextNode
				(= aList (KList 8 node2)) ; NodeValue
				(for
					((= node3 (KList 3 (aList elements:)))) ; FirstNode
					node3
					((= node3 (aList nextNode:)))
					
					(aList nextNode: (KList 6 node3)) ; NextNode
					(= obj (KList 8 node3)) ; NodeValue
					(if (= bit (& (obj -info-:) $0010))
						(DeleteScreenItem obj)
						(obj -info-: (| (obj -info-:) bit))
					)
				)
			)
			(DeletePlane aPlane)
		)
		(for
			((= node1 (KList 3 (gDisabledPlanes elements:)))) ; FirstNode
			node1
			((= node1 (gDisabledPlanes nextNode:)))
			
			(gDisabledPlanes nextNode: (KList 6 node1)) ; NextNode
			(= aPlane (KList 8 node1)) ; NodeValue
			(for
				((= node2 (KList 3 ((aPlane casts:) elements:)))) ; FirstNode
				node2
				((= node2 ((aPlane casts:) nextNode:)))
				
				((aPlane casts:) nextNode: (KList 6 node2)) ; NextNode
				(= aList (KList 8 node2)) ; NodeValue
				(for
					((= node3 (KList 3 (aList elements:)))) ; FirstNode
					node3
					((= node3 (aList nextNode:)))
					
					(aList nextNode: (KList 6 node3)) ; NextNode
					(= obj (KList 8 node3)) ; NodeValue
					(if (= bit (& (obj -info-:) $0010))
						(DeleteScreenItem obj)
						(obj -info-: (| (obj -info-:) bit))
					)
				)
			)
			(DeletePlane aPlane)
		)
		(self setCursor: gWaitCursor 1)
		(self getDisc: (CD 1)) ; GetSaveCD
		(Save 1 {Autosave} nSaveNum (KString 9 gVersion)) ; RestoreGame, StrGetData
		(TextDialog (MakeMessageText 0 0 36 1 0) (Str with: goDismissString))
		(= gQuit 1)
		(self setCursor: oldCur (HaveMouse)) ; UNINIT
		(Sound pause: 0)
		(buf1 dispose:)
		(buf2 dispose:)
		(str dispose:)
		(gCurSaveDir copy: strSaveDir)
		(strSaveDir dispose:)
	)

	(method (save &tmp [temp0 6])
		(SaveAs)
	)

	(method (saveThis num comment &tmp temp0 [temp1 3])
		(if gNumCD
			(self getDisc: gNumCD)
		)
		(= temp0 (self setCursor: gWaitCursor 1))
		(global114 copy: comment)
		(if (not (Save 0 name num (comment data:) (KString 9 gVersion))) ; SaveGame, StrGetData
			(TextDialog (MakeMessageText 10 0 0 1 64994) (Str with: goDismissString))
		else
			(= global113 num)
			(self autosave: comment)
			(global114 copy: comment)
		)
		(self setCursor: temp0 (HaveMouse))
	)

	(method (restore &tmp [temp0 12])
		(Open)
	)

	(method (restoreThis num &tmp [unused 4] aPlane aList obj bit node1 node2 node3)
		(if (not (Save 3 name num (KString 9 gVersion))) ; CheckSaveGame, StrGetData
			(TextDialog (MakeMessageText 3 0 0 1 64994) (Str with: goDismissString))
			(return)
		)
		(for
			((= node1 (KList 3 (gPlanes elements:)))) ; FirstNode
			node1
			((= node1 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 node1)) ; NextNode
			(= aPlane (KList 8 node1)) ; NodeValue
			(for
				((= node2 (KList 3 ((aPlane casts:) elements:)))) ; FirstNode
				node2
				((= node2 ((aPlane casts:) nextNode:)))
				
				((aPlane casts:) nextNode: (KList 6 node2)) ; NextNode
				(= aList (KList 8 node2)) ; NodeValue
				(for
					((= node3 (KList 3 (aList elements:)))) ; FirstNode
					node3
					((= node3 (aList nextNode:)))
					
					(aList nextNode: (KList 6 node3)) ; NextNode
					(= obj (KList 8 node3)) ; NodeValue
					(if (= bit (& (obj -info-:) $0010))
						(DeleteScreenItem obj)
						(obj -info-: (| (obj -info-:) bit))
					)
				)
			)
			(DeletePlane aPlane)
		)
		(for
			((= node1 (KList 3 (gDisabledPlanes elements:)))) ; FirstNode
			node1
			((= node1 (gDisabledPlanes nextNode:)))
			
			(gDisabledPlanes nextNode: (KList 6 node1)) ; NextNode
			(= aPlane (KList 8 node1)) ; NodeValue
			(for
				((= node2 (KList 3 ((aPlane casts:) elements:)))) ; FirstNode
				node2
				((= node2 ((aPlane casts:) nextNode:)))
				
				((aPlane casts:) nextNode: (KList 6 node2)) ; NextNode
				(= aList (KList 8 node2)) ; NodeValue
				(for
					((= node3 (KList 3 (aList elements:)))) ; FirstNode
					node3
					((= node3 (aList nextNode:)))
					
					(aList nextNode: (KList 6 node3)) ; NextNode
					(= obj (KList 8 node3)) ; NodeValue
					(if (= bit (& (obj -info-:) $0010))
						(DeleteScreenItem obj)
						(obj -info-: (| (obj -info-:) bit))
					)
				)
			)
			(DeletePlane aPlane)
		)
		(self setCursor: gWaitCursor 1)
		(self getDisc: (CD 1)) ; GetSaveCD
		(Save 1 name num (KString 9 gVersion)) ; RestoreGame, StrGetData
	)

	(method (replay &tmp theStyle aPlane aList obj node1 node2 node3)
		(= global113 -1)
		(Palette 1 999) ; PalLoad
		(switch gnChapter
			(1
				(Palette 1 10000) ; PalLoad
			)
			(2
				(Palette 1 20000) ; PalLoad
			)
			(3
				(Palette 1 30000) ; PalLoad
			)
			(4
				(Palette 1 40000) ; PalLoad
			)
			(5
				(Palette 1 50000) ; PalLoad
			)
		)
		(for
			((= node1 (KList 3 (gPlanes elements:)))) ; FirstNode
			node1
			((= node1 (gPlanes nextNode:)))
			
			(gPlanes nextNode: (KList 6 node1)) ; NextNode
			(= aPlane (KList 8 node1)) ; NodeValue
			(AddPlane aPlane)
			(for
				((= node2 (KList 3 ((aPlane casts:) elements:)))) ; FirstNode
				node2
				((= node2 ((aPlane casts:) nextNode:)))
				
				((aPlane casts:) nextNode: (KList 6 node2)) ; NextNode
				(= aList (KList 8 node2)) ; NodeValue
				(for
					((= node3 (KList 3 (aList elements:)))) ; FirstNode
					node3
					((= node3 (aList nextNode:)))
					
					(aList nextNode: (KList 6 node3)) ; NextNode
					(= obj (KList 8 node3)) ; NodeValue
					(if (& (obj -info-:) $0010)
						(AddScreenItem obj)
					)
				)
			)
			(aPlane replay:)
		)
		(for
			((= node1 (KList 3 (gDisabledPlanes elements:)))) ; FirstNode
			node1
			((= node1 (gDisabledPlanes nextNode:)))
			
			(gDisabledPlanes nextNode: (KList 6 node1)) ; NextNode
			(= aPlane (KList 8 node1)) ; NodeValue
			(AddPlane aPlane)
			(for
				((= node2 (KList 3 ((aPlane casts:) elements:)))) ; FirstNode
				node2
				((= node2 ((aPlane casts:) nextNode:)))
				
				((aPlane casts:) nextNode: (KList 6 node2)) ; NextNode
				(= aList (KList 8 node2)) ; NodeValue
				(for
					((= node3 (KList 3 (aList elements:)))) ; FirstNode
					node3
					((= node3 (aList nextNode:)))
					
					(aList nextNode: (KList 6 node3)) ; NextNode
					(= obj (KList 8 node3)) ; NodeValue
					(if (& (obj -info-:) $0010)
						(AddScreenItem obj)
					)
				)
			)
			(aPlane replay:)
		)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gGame setCursor: gWaitCursor 1)
		(= theStyle
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
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(LoadPrefs)
		(while (not gQuit)
			(self doit:)
		)
	)
)

