;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64038)
(include sci.sh)
(use Main)
(use DialogPlane)
(use NewUser)
(use MenuItem)
(use soFlashCyberSniff)
(use Plane)
(use Str)
(use System)

(public
	oPopupMenuHandler 0
	AddDefaultVerbs 1
	proc64038_2 2
	proc64038_3 3
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5 = 1
	local6
	local7
)

(procedure (proc64038_2 param1) ; UNUSED
	(if (or (< argc 1) param1)
		(= local4 1)
	else
		(= local4 0)
	)
)

(procedure (proc64038_3 param1)
	(if (or (< argc 1) param1)
		(= local5 1)
	else
		(= local5 0)
	)
)

(procedure (AddDefaultVerbs param1)
	(if (not param1)
		(PrintDebug {Adding default verbs to NULL object. DJM popmenu.sc})
		(return)
	)
	(param1 addHotspotVerb: 1 3 12)
)

(instance oRightClickHandler of EventCode
	(properties)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if
			(and
				(gUser canControl:)
				(== (event type:) evMOUSEBUTTON)
				(& (event modifiers:) emSHIFT)
				(gCurRoom plane:)
				((gCurRoom plane:) isEnabled:)
			)
			(if local6
				(= local7 0)
			else
				(= local7 1)
			)
			(event claimed: 1)
			(return 1)
		)
		(if
			(and
				(gUser canControl:)
				(== (event type:) evMOUSERELEASE)
				(& (event modifiers:) emSHIFT)
				(gCurRoom plane:)
				((gCurRoom plane:) isEnabled:)
			)
			(if (not local4)
				(event claimed:)
				(return)
			)
			(event claimed: 1)
			(if (not local7)
				(return 1)
			)
			(= local7 0)
			(= temp0 (event x:))
			(= temp1 (event y:))
			(= temp3 (Plane new:))
			(temp3 init: 0 0 639 479)
			(temp3 setPri: 5000)
			(= temp2 (temp3 getMainCast:))
			(= temp4 (MenuHandler new:))
			(temp4
				bPopup: 1
				nStyle: 1
				nHilitedBack: 238
				nUnhilitedBack: 237
				nHilitedFore: 64
				nUnhilitedFore: 87
				nHeaderBack: 82
				nHeaderFore: 0
				init: temp2
				hide:
			)
			(if (not (= temp6 (MakeMessageText 0 0 50 6 14)))
				(= temp6 (Str with: {(Shortcuts)}))
			)
			(temp4 addChild: ((MenuHeader new:) oText: temp6 yourself:))
			(if local5
				(temp4
					addChild:
						((MenuItem new:)
							oText: (MakeMessageText 0 0 50 2 14)
							userData: 1
							yourself:
						)
				)
			)
			(temp4
				addChild:
					((MenuItem new:)
						oText: (MakeMessageText 0 0 50 1 14)
						userData: 0
						yourself:
					)
			)
			(temp4
				addChild:
					((MenuItem new:)
						oText: (MakeMessageText 0 0 50 5 14)
						userData: 4
						yourself:
					)
			)
			(temp4
				addChild:
					((MenuItem new:)
						oText: (MakeMessageText 0 0 50 3 14)
						userData: 3
						yourself:
					)
			)
			(temp4
				addChild:
					((MenuItem new:)
						oText: (MakeMessageText 0 0 50 4 14)
						userData: 2
						yourself:
					)
			)
			(temp4 posnAt: 1)
			(= local6 1)
			(= temp5 (temp4 showPopup:))
			(if (== gCurRoomNum 110) ; ro110
				(gCurRoom notify: 10)
			)
			(= local6 0)
			(switch temp5
				(0
					((ScriptID 64000 8) doSelect:) ; moInventory
				)
				(1
					((ScriptID 64000 7) doSelect:) ; moMap
				)
				(2
					((ScriptID 64000 10) doSelect:) ; moBoss
				)
				(4
					((ScriptID 64000 6) doSelect:) ; moScore
				)
				(3
					((ScriptID 64000 9) doSelect:) ; moSave
				)
			)
		)
		(event claimed:)
	)
)

(class L7PopupMenuHandler of Obj
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(gOEventHandler registerGlobalHandler: oRightClickHandler)
		(= local0 (List new:))
		(= local1 (List new:))
		(= local2 0)
		(for ((= temp0 0)) (< temp0 255) ((++ temp0))
			(= temp1 1)
			(while (and 1 (= temp2 (MakeMessageText 0 temp0 0 temp1 13 1)))
				(local0 addToEnd: temp2)
				(local1 addToEnd: temp0)
				(++ temp1)
				(++ local2)
			)
		)
		(= local3 (Set new:))
		(super init: &rest)
	)

	(method (dispose)
		(gOEventHandler unregisterGlobalHandler: oRightClickHandler)
		(if local0
			(local0 dispose:)
			(= local0 0)
		)
		(if local1
			(local1 release: dispose:)
			(= local1 0)
		)
		(if local3
			(local3 release: dispose:)
			(= local3 0)
		)
		(super dispose: &rest)
	)

	(method (handleFeature param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27)
		(= temp0 gMouseX)
		(= temp1 gMouseY)
		(if (not param1)
			(PrintDebug {Attempt to handle NULL feature. DJM POPMENU.SC})
			(return -1)
		)
		(if (param1 respondsTo: #ioMine)
			(= temp16 11)
			(= temp23 ((param1 ioMine:) verb:))
		else
			(= temp16 gCurRoomNum)
			(= temp23 -1)
		)
		(if (== gCurRoomNum 110) ; ro110
			(gCurRoom notify: 0)
		)
		(= temp2 (Plane new:))
		(temp2 init: 0 0 639 479)
		(temp2 setPri: 5000)
		(= temp3 (temp2 getMainCast:))
		(= temp4 (MenuHandler new:))
		(temp4
			bPopup: 1
			nStyle: 1
			nHilitedBack: 238
			nUnhilitedBack: 237
			nHilitedFore: 64
			nUnhilitedFore: 87
			nHeaderBack: 82
			nHeaderFore: 0
			init: temp3
			hide:
		)
		(if (not (= temp6 (param1 getHotspotVerbList:)))
			(PrintDebug {No verb list for feature %d} param1)
			(return -1)
		)
		(if (not (= temp17 (param1 getName:)))
			(= temp17 (Str with: {An Unnamed Object}))
		)
		(temp4 addChild: ((= temp5 (MenuHeader new:)) oText: temp17 yourself:))
		(= temp10 0)
		(= temp11 0)
		(for ((= temp7 (temp6 first:))) temp7 ((= temp7 (temp6 next: temp7)))
			(if (and (== (= temp9 (KList 8 temp7)) 12) local3 (local3 size:)) ; NodeValue
				(= temp8 (MakeMessageText 0 temp9 0 2 13))
			else
				(= temp8 (MakeMessageText 0 temp9 0 1 13))
			)
			(if (not temp8)
				(= temp8 (Str with: {Missing Verb}))
			)
			(if (or (== temp9 3) (and (== temp9 12) local3 (local3 size:)))
				(temp8 cat: {|\10})
			)
			(= temp5 ((MenuItem new:) oText: temp8 userData: temp9 yourself:))
			(switch temp9
				(3
					(= temp10 temp5)
				)
				(12
					(= temp11 temp5)
				)
				(else
					(temp4 addChild: temp5)
				)
			)
		)
		(if temp10
			(= temp12 ((ScriptID 64037 0) oAllHandledItems:)) ; oInvHandler
			(= temp13 (temp12 size:))
			(= temp27 0)
			(for ((= temp15 0)) (< temp15 temp13) ((++ temp15))
				(if (and (= temp14 (temp12 at: temp15)) (temp14 ownedBy: -3))
					(if (== (= temp9 (temp14 verb:)) temp23)
					else
						(if (not temp27)
							(temp4 addChild: temp10)
							(= temp27 1)
						)
						(if (not (= temp8 (MakeMessageText 0 temp9 0 1 11)))
							(= temp8 (Str with: {Missing Inventory Name}))
						)
						(temp10
							addChild:
								((= temp5 (MenuItem new:))
									oText: temp8
									userData: temp9
									yourself:
								)
						)
					)
				)
			)
			(if (not temp27)
				(temp10 dispose:)
			)
		)
		(if temp11
			(temp4 addChild: temp11)
			(if (and local3 (local3 size:))
				(if (not (= temp8 (MakeMessageText 0 12 0 1 13)))
					(= temp8 (Str with: {Missing MSG}))
				)
				(temp11
					addChild:
						((= temp5 (MenuItem new:))
							oText: temp8
							userData: 12
							yourself:
						)
				)
				(= temp24 (local3 size:))
				(for ((= temp15 0)) (< temp15 temp24) ((++ temp15))
					(= temp25 (local3 at: temp15))
					(= temp9 (local1 at: temp25))
					(= temp8 (Str with: (local0 at: temp25)))
					(temp11
						addChild:
							((= temp5 (MenuItem new:))
								oText: temp8
								userData: temp9
								yourself:
							)
					)
				)
			)
		)
		(temp4 posnAt: 1)
		(= local6 1)
		(= temp9 (temp4 showPopup:))
		(= local6 0)
		(while (== temp9 12)
			(= temp20 (MakeMessageText 0 0 52 1 14))
			(= temp17 (param1 getName:))
			(= temp21 (Str format: temp20 temp17))
			(proc64896_7 temp20)
			(proc64896_7 temp17)
			(if
				(not
					(= temp19
						(proc64033_6
							temp21
							(MakeMessageText 0 0 17 1 14)
							(MakeMessageText 0 0 18 1 14)
							20
						)
					)
				)
				(return -1)
			)
			(temp19 lower:)
			(for ((= temp15 0)) (< temp15 local2) ((++ temp15))
				(= temp8 (Str with: (local0 at: temp15)))
				(temp8 lower:)
				(= temp26 (temp8 size:))
				(= temp22 (Min temp26 (temp19 size:)))
				(= temp18 (temp19 left: temp22))
				(if (== (temp8 weigh: temp18) 0)
					(proc64896_7 temp18)
					(proc64896_7 temp8)
					(= temp9 (local1 at: temp15))
					(local3 addToEnd: temp15)
					(while (> (local3 size:) 20)
						(local3 delete: (local3 at: 0))
					)
					(break)
				)
				(proc64896_7 temp18)
				(proc64896_7 temp8)
			)
			(proc64896_7 temp19)
			(if (== temp9 12)
				(if (< global326 3)
					(++ global326)
					(DisplayMsgSequence 0 0 73 14)
					(continue)
				)
				(if
					(not
						(YesNoDialog
							(MakeMessageText 0 0 54 1 14)
							(MakeMessageText 0 0 17 1 14)
							(MakeMessageText 0 0 18 1 14)
						)
					)
					(return -1)
				)
			)
		)
		(if (and (== gCurRoomNum 110) (!= temp9 -1) (== temp9 1)) ; ro110
			(gCurRoom notify: 1)
			(if (== temp16 11)
				(gCurRoom notify: 5)
			)
		)
		(return temp9)
	)
)

(instance oPopupMenuHandler of L7PopupMenuHandler
	(properties)
)

