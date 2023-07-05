;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64000)
(include sci.sh)
(use Main)
(use DialogPlane)
(use n64866)
(use NewUser)
(use MenuItem)
(use n64896)
(use Plane)
(use Str)
(use Feature)
(use File)

(public
	oMainMenu 0
	oMenuPopupPlane 1
	moHelp 2
	SavePrefs 3
	LoadPrefs 4
)

(local
	oStrMsg
)

(procedure (LoadPrefs &tmp oStrName nFile nSpeed)
	(= oStrName (Str with: global115))
	(oStrName cat: {torin.prf})
	(if
		(or
			(not (= nFile (oFile name: (oStrName data:) open: 1)))
			(!= 18247 (oFile readWord:))
			(!= 4 (oFile readWord:))
		)
		(if nFile
			(oFile close:)
		)
		(= gbTipOfTheDay 1)
		(= gnNextTip 1)
		(= gMusicVol 40)
		(= gSFXVol 60)
		(= gAudioVol 100)
		(= gnVideoSpeed 0)
		(= global108 1)
		(gGame nGameSpeed: 6)
		(gEgo setSpeed: 6)
		((ScriptID 64018 0) setSpeed: 6) ; oBoogle
		(= gnHintTime 5)
		(= gMsgType 2)
		(= global111 1)
		(= gbScrollInited 0)
		(SavePrefs)
	else
		(= gbTipOfTheDay (oFile readWord:))
		(= gnNextTip (oFile readWord:))
		(= gMusicVol (oFile readWord:))
		(= gSFXVol (oFile readWord:))
		(= gAudioVol (oFile readWord:))
		(= gnVideoSpeed (oFile readWord:))
		(= global108 (oFile readWord:))
		(= nSpeed (oFile readWord:))
		(gGame nGameSpeed: nSpeed)
		(gEgo setSpeed: nSpeed)
		((ScriptID 64018 0) setSpeed: nSpeed) ; oBoogle
		(= gnHintTime (oFile readWord:))
		(= gMsgType (oFile readWord:))
		(= global111 (oFile readWord:))
		(= gbScrollInited (oFile readWord:))
		(oFile close:)
	)
	(oStrName dispose:)
)

(procedure (SavePrefs &tmp oStrName)
	(= oStrName (Str with: global115))
	(oStrName cat: {torin.prf})
	(if (not (oFile name: (oStrName data:) open: 2))
		(PrintDebug {Unable to create prefs file.})
		(return)
	)
	(oFile writeWord: 18247)
	(oFile writeWord: 4)
	(oFile writeWord: gbTipOfTheDay)
	(oFile writeWord: gnNextTip)
	(oFile writeWord: gMusicVol)
	(oFile writeWord: gSFXVol)
	(oFile writeWord: gAudioVol)
	(oFile writeWord: gnVideoSpeed)
	(oFile writeWord: global108)
	(oFile writeWord: (gGame nGameSpeed:))
	(oFile writeWord: gnHintTime)
	(oFile writeWord: gMsgType)
	(oFile writeWord: global111)
	(oFile writeWord: gbScrollInited)
	(oFile close:)
	(oStrName dispose:)
)

(instance oFile of File
	(properties)
)

(instance oMenuPopupPlane of Plane
	(properties
		picture -2
		priority 600
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

	(method (handleEvent event &tmp oEventClone retVal)
		(if (not (ScriptID 64000 0)) ; oMainMenu
			(return 0)
		)
		(= retVal 0)
		(= oEventClone (Clone event))
		(oEventClone localize: (oMenuPopupFeat plane:))
		(if
			(and
				(gUser canControl:)
				(not (oMenuPopupFeat onMe: oEventClone))
				((ScriptID 64000 0) isVisible:) ; oMainMenu
				(not ((ScriptID 64000 0) isHilited:)) ; oMainMenu
			)
			((ScriptID 64000 0) hide:) ; oMainMenu
			(= retVal 1)
		)
		(oEventClone dispose:)
		(return retVal)
	)
)

(instance oMainMenu of MenuHandler
	(properties
		nStyle 1
		nUnhilitedBack 237
		nHilitedBack 238
		nHilitedFore 210
		nUnhilitedFore 235
		nFont 2510
		nLeading 1
		nHBorder 7
		vCheck 60002
		cCheck 2
	)

	(method (addItems)
		(oChildren addToEnd: moFile moGame moHelp)
	)

	(method (init)
		(super init: &rest)
		(gOEventHandler registerGlobalHandler: oKillMenuCheck)
		(oMenuPopupPlane
			init:
				4
				4
				(+ ((ScriptID 64000 0) getWidth:) 4) ; oMainMenu
				(+ ((ScriptID 64000 0) getHeight:) 4) ; oMainMenu
		)
		(oMenuPopupFeat init: oMenuPopupPlane)
	)

	(method (hide &tmp nPriTmp)
		(super hide: &rest)
		(if ((ScriptID 64000 1) oMyFeatures:) ; oMenuPopupPlane
			(= nPriTmp ((ScriptID 64000 1) priority:)) ; oMenuPopupPlane
			((ScriptID 64000 1) setPri: 1) ; oMenuPopupPlane
			(UpdatePlane (ScriptID 64000 1)) ; oMenuPopupPlane
			((ScriptID 64000 1) setPri: nPriTmp) ; oMenuPopupPlane
			(UpdatePlane (ScriptID 64000 1)) ; oMenuPopupPlane
		)
	)
)

(instance moFile of MenuItem
	(properties
		x 4
		y 4
		nModule 0
		nCase 12
	)

	(method (addItems)
		(oChildren addToEnd: moNew moOpen moSave moExit)
	)
)

(instance moGame of MenuItem
	(properties
		nModule 0
		nCase 12
		nSeq 2
	)

	(method (addItems)
		(oChildren addToEnd: moVolume moSpeed moHintTimer moScrolling moText)
	)
)

(instance moHelp of MenuItem
	(properties
		nModule 0
		nCase 12
		nSeq 3
	)

	(method (addItems)
		(oChildren
			addToEnd: moGetHelp moToolHelp moTipOfTheDay moSupport moAbout
		)
	)
)

(instance moNew of MenuItem
	(properties
		chShortcut 14
		nModule 0
		nCase 13
	)

	(method (doSelect)
		(if
			(YesNoDialog
				(MakeMessageText 0 0 23 1 0)
				(MakeMessageText 0 0 26 1 0)
				(MakeMessageText 0 0 7 1 0)
			)
			(gGame autorestore: 1)
			(= gQuit 1)
		)
	)
)

(instance moOpen of MenuItem
	(properties
		chShortcut 111
		nModule 0
		nCase 13
		nSeq 2
	)

	(method (doSelect)
		(Open)
	)
)

(instance moSave of MenuItem
	(properties
		chShortcut 115
		nModule 0
		nCase 13
		nSeq 3
	)

	(method (doSelect)
		(SaveAs)
	)
)

(instance moExit of MenuItem
	(properties
		chShortcut 113
		nModule 0
		nCase 13
		nSeq 4
	)

	(method (doSelect)
		(if
			(not
				(YesNoDialog
					(MakeMessageText 0 0 9 1 0)
					(MakeMessageText 0 0 8 1 0)
					(MakeMessageText 0 0 7 1 0)
				)
			)
			(return)
		)
		(gGame autosave:)
		(= gQuit 1)
	)
)

(instance moScrolling of MenuItem
	(properties
		nModule 0
		nCase 14
		nSeq 5
	)

	(method (init)
		(super init: &rest)
	)

	(method (checkStatus)
		(if global108
			(self check:)
		else
			(self uncheck:)
		)
	)

	(method (doSelect)
		(if global108
			(= global108 0)
			(TextDialog (MakeMessageText 0 0 3 1 0) (Str with: goDismissString))
		else
			(= global108 1)
			(TextDialog (MakeMessageText 0 0 4 1 0) (Str with: goDismissString))
		)
		(SavePrefs)
	)
)

(instance moVolume of MenuItem
	(properties
		chShortcut 109
		nModule 0
		nCase 14
	)

	(method (doSelect)
		((ScriptID 64028 0) init:) ; oInset
	)
)

(instance moText of MenuItem
	(properties
		nModule 0
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
			(TextDialog (MakeMessageText 0 0 6 1 0) (Str with: goDismissString))
		else
			(= gMsgType 2)
			(TextDialog (MakeMessageText 0 0 5 1 0) (Str with: goDismissString))
		)
		(SavePrefs)
	)
)

(instance moHintTimer of MenuItem
	(properties
		chShortcut 8
		nModule 0
		nCase 14
		nSeq 3
	)

	(method (doSelect)
		((ScriptID 64035 0) init:) ; oHintTimer
	)
)

(instance moSpeed of MenuItem
	(properties
		nModule 0
		nCase 14
		nSeq 2
	)

	(method (doSelect)
		((ScriptID 64015 0) init:) ; oInset
	)
)

(instance moGetHelp of MenuItem
	(properties
		chShortcut 15104
		nModifiers 0
		nModule 0
		nCase 15
	)

	(method (doSelect &tmp bKeepGoing nMessage oStrTmp)
		(for
			((= nMessage 1))
			(and 1 (= oStrTmp (MakeMessageText 0 0 19 nMessage 0)))
			((++ nMessage))
			
			(if
				(not
					(YesNoDialog
						oStrTmp
						(MakeMessageText 0 0 1 1 0)
						(MakeMessageText 0 0 8 1 0)
					)
				)
				(break)
			)
		)
	)
)

(instance moSupport of MenuItem
	(properties
		nModule 0
		nCase 15
		nSeq 4
	)

	(method (doSelect &tmp bKeepGoing nMessage oStrTmp)
		(for
			((= nMessage 1))
			(and 1 (= oStrTmp (MakeMessageText 0 0 1 nMessage 2)))
			((++ nMessage))
			
			(if
				(not
					(YesNoDialog
						oStrTmp
						(MakeMessageText 0 0 1 1 0)
						(MakeMessageText 0 0 8 1 0)
					)
				)
				(break)
			)
		)
	)
)

(instance moAbout of MenuItem
	(properties
		nModule 0
		nCase 15
		nSeq 5
	)

	(method (doSelect &tmp temp0 [temp1 3])
		(if (not (= temp0 (MakeMessageText 0 0 18 1 0)))
			(= temp0 (Str with: {Version: }))
		)
		(if gVersion
			(temp0 cat: {\n\n})
			(temp0 cat: gVersion)
		)
		(TextDialog temp0 (Str with: goDismissString))
	)
)

(instance moToolHelp of MenuItem
	(properties
		nModule 0
		nCase 15
		nSeq 2
	)

	(method (checkStatus)
		(if global111
			(self check:)
		else
			(self uncheck:)
		)
	)

	(method (doSelect)
		(if (= global111 (not global111))
			(TextDialog (MakeMessageText 0 0 21 1 0) (Str with: goDismissString))
		else
			(TextDialog (MakeMessageText 0 0 20 1 0) (Str with: goDismissString))
		)
		(SavePrefs)
	)
)

(instance moTipOfTheDay of MenuItem
	(properties
		nModule 0
		nCase 15
		nSeq 3
	)

	(method (checkStatus)
		(if gbTipOfTheDay
			(self check:)
		else
			(self uncheck:)
		)
	)

	(method (doSelect)
		(if (= gbTipOfTheDay (not gbTipOfTheDay))
			(TextDialog (MakeMessageText 0 0 25 1 0) (Str with: goDismissString))
		else
			(TextDialog (MakeMessageText 0 0 24 1 0) (Str with: goDismissString))
		)
		(SavePrefs)
	)
)

