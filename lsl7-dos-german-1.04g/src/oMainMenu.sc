;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64000)
(include sci.sh)
(use Main)
(use oDildo)
(use ro371)
(use DialogPlane)
(use n64866)
(use ModalPlane)
(use NewUser)
(use MenuItem)
(use soFlashCyberSniff)
(use Plane)
(use Str)
(use Feature)
(use File)

(public
	oMainMenu 0
	oMenuPopupPlane 1
	moHelp 2
	proc64000_3 3
	proc64000_4 4
	moGetHelp 5
	moScore 6
	moMap 7
	moInventory 8
	moSave 9
	moBoss 10
)

(local
	local0
)

(procedure (proc64000_4 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (Str with: global115))
	(temp0 cat: {get_hard})
	(if (not (FileIO fiEXISTS (temp0 data:)))
		((ScriptID 64017 0) set: 285) ; oFlags
		(PrintDebug {It's like butter.})
	else
		((ScriptID 64017 0) clear: 285) ; oFlags
		(TextDialog (Str with: {It's getting harder...}) (Str with: global288))
		(FrameOut)
	)
	(temp0 dispose:)
	(= temp0 (Str with: global115))
	(temp0 cat: {larry7.prf})
	(if (!= (temp0 weigh: (oFile name:)) 0)
		(oFile name: (KArray 8 (temp0 data:))) ; ArrayDup
	)
	(temp0 dispose:)
	(if
		(or
			(not (= temp1 (oFile open: 1)))
			(!= 18247 (= temp3 (oFile readWord:)))
			(!= 7 (= temp4 (oFile readWord:)))
		)
		(if temp1
			(oFile close:)
		)
		(= global296 1)
		(= global314 1)
		(= global227 65)
		(= global228 60)
		(= global229 100)
		(= global294 0)
		(= global108 1)
		(gGame nGameSpeed: 3)
		(gEgo setSpeed: 3)
		(= gMsgType 2)
		(= global328 0)
		(= global212 1)
		(proc64000_3)
	else
		(= global296 (oFile readWord:))
		(= global314 (oFile readWord:))
		(= global227 (oFile readWord:))
		(= global228 (oFile readWord:))
		(= global229 (oFile readWord:))
		(= global294 (oFile readWord:))
		(= global108 (oFile readWord:))
		(= temp2 (oFile readWord:))
		(gGame nGameSpeed: temp2)
		(gEgo setSpeed: temp2)
		(= gMsgType (oFile readWord:))
		(= global111 (oFile readWord:))
		(= global328 (oFile readWord:))
		(= global212 (oFile readWord:))
		(oFile close:)
	)
)

(procedure (proc64000_3 &tmp temp0)
	(= temp0 (Str with: global115))
	(temp0 cat: {larry7.prf})
	(if (!= (temp0 weigh: (oFile name:)) 0)
		(oFile name: (KArray 8 (temp0 data:))) ; ArrayDup
	)
	(temp0 dispose:)
	(if (not (oFile open: 2))
		(PrintDebug {Unable to create prefs file.})
		(return)
	)
	(oFile writeWord: 18247)
	(oFile writeWord: 7)
	(oFile writeWord: global296)
	(oFile writeWord: global314)
	(oFile writeWord: global227)
	(oFile writeWord: global228)
	(oFile writeWord: global229)
	(oFile writeWord: global294)
	(oFile writeWord: global108)
	(oFile writeWord: (gGame nGameSpeed:))
	(oFile writeWord: gMsgType)
	(oFile writeWord: global111)
	(oFile writeWord: global328)
	(oFile writeWord: global212)
	(oFile close:)
)

(instance oFile of File
	(properties)
)

(instance oMenuPopupPlane of Plane
	(properties
		priority 600
		picture -2
	)
)

(instance oMenuPopupFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= nsTop (= nsLeft 0))
		(= nsRight ((ScriptID 64000 0) getWidth:)) ; oMainMenu
		(= nsBottom ((ScriptID 64000 0) getHeight:)) ; oMainMenu
	)

	(method (handleEvent event)
		(if (self onMe: event)
			((ScriptID 64000 0) show:) ; oMainMenu
		)
		(return 0)
	)
)

(instance oKillMenuCheck of EventCode
	(properties)

	(method (handleEvent event &tmp temp0 temp1)
		(if (not (ScriptID 64000 0)) ; oMainMenu
			(return 0)
		)
		(= temp1 0)
		(= temp0 (Clone event))
		(temp0 localize: (oMenuPopupFeat plane:))
		(if
			(and
				(gUser canControl:)
				(not (oMenuPopupFeat onMe: temp0))
				((ScriptID 64000 0) isVisible:) ; oMainMenu
				(not ((ScriptID 64000 0) isHilited:)) ; oMainMenu
			)
			((ScriptID 64000 0) hide:) ; oMainMenu
			(= temp1 1)
		)
		(temp0 dispose:)
		(return temp1)
	)
)

(instance oMainMenu of MenuHandler
	(properties
		nLeading 1
		nStyle 1
		nHBorder 7
		nUnhilitedBack 237
		nHilitedBack 238
		nUnhilitedFore 87
		nFont 2510
		nHilitedFore 64
		vCheck 60002
	)

	(method (addItems)
		(oChildren addToEnd: moFile moGame moHelp)
	)

	(method (init)
		(super init: &rest)
		(gOEventHandler registerGlobalHandler: oKillMenuCheck)
		(oMenuPopupPlane
			init:
				0
				0
				((ScriptID 64000 0) getWidth:) ; oMainMenu
				((ScriptID 64000 0) getHeight:) ; oMainMenu
		)
		(oMenuPopupFeat init: oMenuPopupPlane)
	)

	(method (hide &tmp temp0)
		(super hide: &rest)
		(if ((ScriptID 64000 1) oMyFeatures:) ; oMenuPopupPlane
			(= temp0 ((ScriptID 64000 1) priority:)) ; oMenuPopupPlane
			((ScriptID 64000 1) setPri: 1) ; oMenuPopupPlane
			(UpdatePlane (ScriptID 64000 1)) ; oMenuPopupPlane
			((ScriptID 64000 1) setPri: temp0) ; oMenuPopupPlane
			(UpdatePlane (ScriptID 64000 1)) ; oMenuPopupPlane
		)
	)
)

(instance moFile of MenuItem
	(properties
		nModule 14
		nCase 12
	)

	(method (addItems)
		(oChildren addToEnd: moNew moOpen moSave moExit)
	)
)

(instance moGame of MenuItem
	(properties
		nModule 14
		nCase 12
		nSeq 2
	)

	(method (addItems)
		(oChildren
			addToEnd:
				moMap
				moInventory
				moScore
				moVolume
				moBoss
				moSpeed
				moFilthUp
				moFilthDown
				moStabilizer
				moText
		)
	)
)

(instance moHelp of MenuItem
	(properties
		nModule 14
		nCase 12
		nSeq 3
	)

	(method (addItems)
		(oChildren addToEnd: moGetHelp moHints moSupport moAbout)
	)
)

(instance moNew of MenuItem
	(properties
		chShortcut 14
		nModule 14
		nCase 13
	)

	(method (doSelect)
		(if
			(YesNoDialog
				(MakeMessageText 0 0 23 1 14)
				(MakeMessageText 0 0 24 1 14)
				(MakeMessageText 0 0 18 1 14)
			)
			(gGame autorestore: 1)
			(= gQuit 1)
		)
	)
)

(instance moOpen of MenuItem
	(properties
		chShortcut 15
		nModule 14
		nCase 13
		nSeq 2
	)

	(method (doSelect)
		(proc64866_1)
	)
)

(instance moSave of MenuItem
	(properties
		chShortcut 19
		nModule 14
		nCase 13
		nSeq 3
	)

	(method (doSelect)
		(if (== gCurRoomNum 371) ; ro371
			(proc371_1)
		else
			(gGame panelObj: gGame panelSelector: 638)
		)
	)
)

(instance moExit of MenuItem
	(properties
		chShortcut 17
		nModule 14
		nCase 13
		nSeq 4
	)

	(method (doSelect)
		(if (and (== gCurRoomNum 371) (gEgo has: ((ScriptID 64037 0) get: 19))) ; ro371, oInvHandler, ioLegalDice
			(proc371_2)
		else
			(if
				(not
					(YesNoDialog
						(MakeMessageText 0 0 22 1 14)
						(MakeMessageText 0 0 21 1 14)
						(MakeMessageText 0 0 18 1 14)
					)
				)
				(return)
			)
			(gGame autosave:)
			(= gQuit 1)
		)
	)
)

(instance moMap of MenuItem
	(properties
		chShortcut 13
		nModule 14
		nCase 14
	)

	(method (doSelect)
		(cond
			((< gCurRoomNum 200) ; ro200
				(TextDialog (MakeMessageText 0 0 60 1 14) (Str with: global288))
			)
			(((ScriptID 64017 0) test: 158) ; oFlags
				((ScriptID 90 0) dispose:) ; oTravelScreen
			)
			(else
				((ScriptID 90 0) init:) ; oTravelScreen
			)
		)
	)
)

(instance moVolume of MenuItem
	(properties
		chShortcut 1
		nModule 14
		nCase 14
		nSeq 2
	)

	(method (doSelect)
		((ScriptID 64028 0) init:) ; oInset
	)
)

(instance moText of MenuItem
	(properties
		chShortcut 20
		nModule 14
		nCase 14
		nSeq 6
	)

	(method (checkStatus)
		(if (& gMsgType $0001)
			(self check:)
		else
			(self uncheck:)
		)
	)

	(method (doSelect)
		(if (not (& gMsgType $0001))
			(= gMsgType 3)
			(TextDialog (MakeMessageText 0 0 30 1 14) (Str with: global288))
		else
			(= gMsgType 2)
			(TextDialog (MakeMessageText 0 0 29 1 14) (Str with: global288))
		)
		(proc64000_3)
	)
)

(instance moSpeed of MenuItem
	(properties
		nModule 14
		nCase 14
		nSeq 3
	)

	(method (doSelect)
		((ScriptID 64015 0) init:) ; oInset
	)
)

(instance moFilthUp of MenuItem
	(properties
		chShortcut 6
		nModule 14
		nCase 14
		nSeq 7
	)

	(method (init)
		(= global207 (Str new:))
		(super init: &rest)
	)

	(method (doSelect &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 (MakeMessageText 0 0 39 1 14))
		(= temp1 (MakeMessageText 0 0 39 2 14))
		(= temp2 (GetNumMessages 14 0 0 48))
		(= temp3 (GetRandomNumber 1 temp2))
		(= temp4 (MakeMessageText 0 0 48 temp3 14))
		(global207 cat: temp4)
		(global207 cat: { })
		(temp0 cat: global207)
		(temp0 cat: temp1)
		(TextDialog temp0 (Str with: global288))
		(proc64896_7 temp1)
		(proc64896_7 temp4)
	)
)

(instance moFilthDown of MenuItem
	(properties
		chShortcut 4
		nModule 14
		nCase 14
		nSeq 8
	)

	(method (doSelect)
		(TextDialog (MakeMessageText 0 0 55 1 14) (Str with: global288))
	)
)

(instance moBoss of MenuItem
	(properties
		chShortcut 2
		nModule 14
		nCase 14
		nSeq 9
	)

	(method (doSelect)
		(if (== (Platform 0) 1)
			(oDOSBoss init:)
		else
			(Minimize)
		)
	)
)

(instance moScore of MenuItem
	(properties
		chShortcut 16
		nModule 14
		nCase 14
		nSeq 5
	)

	(method (doSelect &tmp temp0 temp1)
		(= temp0 (MakeMessageText 0 0 58 1 14))
		(= temp1 (Str format: (temp0 data:) global201))
		(temp0 dispose:)
		(TextDialog temp1 (Str with: global288))
		(if global264
			(proc50_3)
		)
	)
)

(instance moStabilizer of MenuItem
	(properties
		chShortcut 8
		nModule 14
		nCase 14
		nSeq 10
	)

	(method (checkStatus)
		(if global212
			(self uncheck:)
		else
			(self check:)
		)
	)

	(method (doSelect)
		(if global212
			(= global212 0)
			(TextDialog (MakeMessageText 0 0 56 1 14) (Str with: global288))
		else
			(= global212 1)
			(TextDialog (MakeMessageText 0 0 57 1 14) (Str with: global288))
		)
		(proc64000_3)
	)
)

(instance moInventory of MenuItem
	(properties
		chShortcut 9
		nModule 14
		nCase 14
		nSeq 4
	)

	(method (doSelect)
		(if (== ((ScriptID 64037 2) priority:) 450) ; oInvPlane
			((ScriptID 64037 2) setPri: -1) ; oInvPlane
		else
			((ScriptID 64037 2) setPri: 450) ; oInvPlane
		)
		(UpdatePlane (ScriptID 64037 2)) ; oInvPlane
	)
)

(instance moGetHelp of MenuItem
	(properties
		chShortcut 15104
		nModifiers 0
		nModule 14
		nCase 15
	)

	(method (doSelect &tmp [temp0 3])
		(DisplayMsgSequence 0 0 9 14)
	)
)

(instance moHints of MenuItem
	(properties
		chShortcut 15104
		nModifiers 0
		nModule 14
		nCase 15
		nSeq 3
	)

	(method (doSelect &tmp [temp0 3])
		(DisplayMsgSequence 0 0 41 14)
	)
)

(instance moSupport of MenuItem
	(properties
		nModule 14
		nCase 15
		nSeq 4
	)

	(method (doSelect &tmp [temp0 4])
		(TextDialog (MakeMessageText 0 0 4 1 14) (Str with: global288))
	)
)

(instance moAbout of MenuItem
	(properties
		nModule 14
		nCase 15
		nSeq 5
	)

	(method (doSelect &tmp [temp0 4])
		((ScriptID 15 0) init:) ; oAboutScreen
	)
)

(instance oDOSBoss of ModalPlane
	(properties
		picture 16000
	)

	(method (init)
		(= priority 501)
		(super init: 0 0 639 479)
		(gSounds eachElementDo: #pause)
		(foScreen init: self)
	)

	(method (dispose)
		(gSounds eachElementDo: #pause 0)
		(super dispose: &rest)
	)
)

(instance foScreen of Feature
	(properties
		nsBottom 479
		nsRight 639
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (doVerb)
		(oDOSBoss dispose:)
	)
)

