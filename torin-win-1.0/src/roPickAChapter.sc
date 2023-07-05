;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61100)
(include sci.sh)
(use Main)
(use oMainMenu)
(use oInterface)
(use n64011)
(use oHandsOnWhenCued)
(use DialogPlane)
(use n64866)
(use ModalPlane)
(use PushButton)
(use n64896)
(use Plane)
(use Str)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	roPickAChapter 0
)

(local
	line1
	line2
	line3
	line4
	line5
)

(procedure (TipOfTheDay &tmp oTipStr)
	(if gbTipOfTheDay
		(if (= oTipStr (MakeMessageText 0 0 1 gnNextTip 110))
			(TextDialog oTipStr (Str with: goDismissString) (MakeMessageText 0 0 3 1 110))
			(= oTipStr 0)
		)
		(++ gnNextTip)
		(if (= oTipStr (MakeMessageText 0 0 1 gnNextTip 110))
			(StringDispose oTipStr)
			(= oTipStr 0)
		else
			(= gnNextTip 1)
		)
		(SavePrefs)
	)
)

(instance oRoomChosen of Obj
	(properties)

	(method (doit aChapter)
		(if (not gbInterfaceInitted)
			((ScriptID 64002 0) init:) ; oInterface
			(InitInterface2)
			((ScriptID 64000 0) disable:) ; oMainMenu
		)
		(goMusic1 stop:)
		(= gnChapter 1)
		(switch aChapter
			(1
				(= gnChapter 0)
			)
			(2
				(= gnChapter 1)
			)
			(3
				(= gnChapter 2)
				(gEgo get: ((ScriptID 64001 1) get: 0)) ; oBoogleHandler, ioBoogleBox
				(gEgo get: ((ScriptID 64001 1) get: 1)) ; oBoogleHandler, ioBoogleWorm
				(gEgo get: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
				(gEgo get: ((ScriptID 64001 0) get: 8)) ; oInvHandler, ioShard
				(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
			)
			(4
				(= gnChapter 3)
				(gEgo get: ((ScriptID 64001 1) get: 0)) ; oBoogleHandler, ioBoogleBox
				(gEgo get: ((ScriptID 64001 1) get: 3)) ; oBoogleHandler, ioBoogleShovel
				(gEgo get: ((ScriptID 64001 1) get: 1)) ; oBoogleHandler, ioBoogleWorm
				(gEgo get: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
				(gEgo get: ((ScriptID 64001 1) get: 2)) ; oBoogleHandler, ioBoogleYoYo
				(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
				(gEgo get: ((ScriptID 64001 0) get: 31)) ; oInvHandler, ioLocket
			)
			(5
				(= gnChapter 4)
				(gEgo get: ((ScriptID 64001 1) get: 0)) ; oBoogleHandler, ioBoogleBox
				(gEgo get: ((ScriptID 64001 1) get: 3)) ; oBoogleHandler, ioBoogleShovel
				(gEgo get: ((ScriptID 64001 1) get: 1)) ; oBoogleHandler, ioBoogleWorm
				(gEgo get: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
				(gEgo get: ((ScriptID 64001 1) get: 2)) ; oBoogleHandler, ioBoogleYoYo
				(gEgo get: ((ScriptID 64001 1) get: 5)) ; oBoogleHandler, ioBoogleRedCross
				(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
				(gEgo get: ((ScriptID 64001 0) get: 34)) ; oInvHandler, ioKnife
			)
			(6
				(= gnChapter 5)
				(gEgo get: ((ScriptID 64001 1) get: 0)) ; oBoogleHandler, ioBoogleBox
				(gEgo get: ((ScriptID 64001 1) get: 3)) ; oBoogleHandler, ioBoogleShovel
				(gEgo get: ((ScriptID 64001 1) get: 1)) ; oBoogleHandler, ioBoogleWorm
				(gEgo get: ((ScriptID 64001 1) get: 4)) ; oBoogleHandler, ioBoogleLantern
				(gEgo get: ((ScriptID 64001 1) get: 2)) ; oBoogleHandler, ioBoogleYoYo
				(gEgo get: ((ScriptID 64001 1) get: 5)) ; oBoogleHandler, ioBoogleRedCross
				(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
				(gEgo get: ((ScriptID 64001 0) get: 35)) ; oInvHandler, ioAmmonia
				(gEgo get: ((ScriptID 64001 0) get: 34)) ; oInvHandler, ioKnife
			)
			(7
				(= gnChapter 6)
				(gCurRoom newRoom: 51500) ; roCredits
				(return)
			)
			(9
				(gCurRoom setScript: soResume)
				(return)
			)
			(10
				(gCurRoom setScript: soRestore)
				(return)
			)
			(8
				(= gQuit 1)
				(return)
			)
		)
		(if (and (< 0 gnChapter 6) (or gbTeleport gbDebugTeleport))
			(= gbTeleport 0)
			(gCurRoom newRoom: (RoomTeleport gnChapter))
		else
			(switch aChapter
				(1
					(gCurRoom newRoom: 8000) ; roPrologue1
				)
				(2
					(gCurRoom newRoom: 10000) ; roChapter1
				)
				(3
					(gCurRoom newRoom: 20000) ; roChapter2
				)
				(4
					(gCurRoom newRoom: 30000) ; roChapter3
				)
				(5
					(gCurRoom newRoom: 40000) ; roChapter4
				)
				(6
					(gCurRoom newRoom: 50000) ; roChapter5
				)
				(else
					(= gQuit 1)
				)
			)
		)
	)
)

(instance foBlackOpaque of OpaqueFeature
	(properties)
)

(instance oBlackPlane of Plane
	(properties
		priority 610
	)

	(method (init)
		(super init: &rest)
		(foBlackOpaque init: self)
	)
)

(instance soFadeToTip of Script
	(properties)

	(method (changeState newState &tmp oTipStr)
		(switch (= state newState)
			(0
				(FadeToBlack 1 15 self 1)
			)
			(1
				(oBlackPlane init: 0 0 gLastScreenX gLastScreenY)
				(= ticks 1)
			)
			(2
				(FadeToBlack 0 100 self 1)
			)
			(3
				(TipOfTheDay)
				(self dispose:)
			)
		)
	)
)

(instance soResume of Script
	(properties)

	(method (changeState newState &tmp oTipStr)
		(switch (= state newState)
			(0
				(self setScript: soFadeToTip self)
			)
			(1
				(gGame autorestore:)
				(oBlackPlane dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soRestore of Script
	(properties)

	(method (changeState newState &tmp oTipStr)
		(switch (= state newState)
			(0
				(self setScript: soFadeToTip self)
			)
			(1
				(Open)
				(oBlackPlane dispose:)
				(self dispose:)
			)
		)
	)
)

(instance oIntroButton of MessageButton
	(properties
		noun 1
		x 480
		y 96
		nSelectMethod 69
		nSelectValue 1
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(super init: &rest)
	)
)

(instance oResumeButton of MessageButton
	(properties
		noun 9
		x 252
		y 440
		nSelectMethod 69
		nSelectValue 9
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(= x (- 639 (+ (oExitButton x:) (oExitButton nWidth:))))
		(= x (Max 5 x))
		(super init: &rest)
	)
)

(instance oRestoreButton of MessageButton
	(properties
		noun 10
		x 100
		y 440
		nSelectMethod 69
		nSelectValue 10
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(super init: &rest)
		(= x (- 316 (/ nWidth 2)))
		(UpdateScreenItem self)
	)
)

(instance oChapter1Button of MessageButton
	(properties
		noun 2
		x 480
		y 132
		nSelectMethod 69
		nSelectValue 2
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(super init: &rest)
		(= line1 (AddLine oPickAChapter 434 (+ y 14) x (+ y 14) 200 227 0 0 2))
	)
)

(instance oChapter2Button of MessageButton
	(properties
		noun 3
		x 480
		y 168
		nSelectMethod 69
		nSelectValue 3
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(super init: &rest)
		(= line2 (AddLine oPickAChapter 413 (+ y 14) x (+ y 14) 200 227 0 0 2))
	)
)

(instance oChapter3Button of MessageButton
	(properties
		noun 4
		x 480
		y 204
		nSelectMethod 69
		nSelectValue 4
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(super init: &rest)
		(= line3 (AddLine oPickAChapter 389 (+ y 14) x (+ y 14) 200 227 0 0 2))
	)
)

(instance oChapter4Button of MessageButton
	(properties
		noun 5
		x 480
		y 240
		nSelectMethod 69
		nSelectValue 5
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(super init: &rest)
		(= line4 (AddLine oPickAChapter 346 (+ y 14) x (+ y 14) 200 227 0 0 2))
	)
)

(instance oChapter5Button of MessageButton
	(properties
		noun 6
		x 480
		y 276
		nSelectMethod 69
		nSelectValue 6
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(super init: &rest)
		(= line5 (AddLine oPickAChapter 275 (+ y 14) x (+ y 14) 200 227 0 0 2))
	)
)

(instance oEpilogueButton of MessageButton
	(properties
		noun 7
		x 480
		y 312
		nSelectMethod 69
		nSelectValue 7
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(super init: &rest)
	)
)

(instance oExitButton of MessageButton
	(properties
		noun 8
		x 480
		y 440
		nSelectMethod 69
		nSelectValue 8
		font 2510
		nMinWidth 130
		vTileOff 60013
		vTileOn 60014
		module 200
	)

	(method (init)
		(= back gnButtonDownColor)
		(= fore gnButtonUpColor)
		(super init: &rest)
	)
)

(instance oTwinkle1 of Prop
	(properties
		x 2
		y 313
		view 61100
	)
)

(instance oTwinkle2 of Prop
	(properties
		x 609
		y 279
		view 61100
		loop 1
	)
)

(instance oTwinkle3 of Prop
	(properties
		x 30
		y 30
		view 61100
		loop 2
	)
)

(instance oTwinkle4 of Prop
	(properties
		x 516
		y 50
		view 61100
		loop 3
	)
)

(instance oTwinkle5 of Prop
	(properties
		x 464
		y 196
		view 61100
	)
)

(instance oTwinkle6 of Prop
	(properties
		x 420
		y 429
		view 61100
		loop 2
	)
)

(instance oTwinkle7 of Prop
	(properties
		x 122
		y 394
		view 61100
		loop 3
	)
)

(instance voText of View ; UNUSED
	(properties)
)

(instance voLogo of View ; UNUSED
	(properties
		x 48
		y 231
		view 60015
	)
)

(instance foAll of OpaqueFeature
	(properties)
)

(instance oPickAChapter of Plane
	(properties)

	(method (dispose)
		(if line1
			(DeleteLine line1 self)
			(= line1 0)
		)
		(if line2
			(DeleteLine line2 self)
			(= line2 0)
		)
		(if line3
			(DeleteLine line3 self)
			(= line3 0)
		)
		(if line4
			(DeleteLine line4 self)
			(= line4 0)
		)
		(if line5
			(DeleteLine line5 self)
			(= line5 0)
		)
		(super dispose: &rest)
	)
)

(instance roPickAChapter of TPRoom
	(properties
		picture 61100
	)

	(method (dispose)
		((ScriptID 64000 0) enable: 1) ; oMainMenu
		(super dispose: &rest)
	)

	(method (init &tmp fp oTipStr pathName)
		(Palette 1 999) ; PalLoad
		(oPickAChapter priority: 609 init: 0 0 gLastScreenX gLastScreenY)
		(= plane oPickAChapter)
		(super init: &rest)
		(goMusic1 playSound: 60015)
		(= gnChapter 0)
		(oIntroButton oSelectNotify: oRoomChosen init: oPickAChapter)
		(oChapter1Button oSelectNotify: oRoomChosen init: oPickAChapter)
		(oChapter2Button oSelectNotify: oRoomChosen init: oPickAChapter)
		(oChapter3Button oSelectNotify: oRoomChosen init: oPickAChapter)
		(oChapter4Button oSelectNotify: oRoomChosen init: oPickAChapter)
		(oChapter5Button oSelectNotify: oRoomChosen init: oPickAChapter)
		(oEpilogueButton oSelectNotify: oRoomChosen init: oPickAChapter)
		(oExitButton oSelectNotify: oRoomChosen init: oPickAChapter)
		(= pathName (Str new:))
		(pathName format: {%s%s} gCurSaveDir {torinsg.cat})
		(= fp (FileIO fiOPEN (pathName data:) 1))
		(pathName dispose:)
		(if (!= fp -1)
			(oRestoreButton oSelectNotify: oRoomChosen init: oPickAChapter)
			(FileIO fiCLOSE fp)
		)
		(foAll init:)
		(if
			(or
				(!= (= fp (FileIO fiOPEN {autosave.cat} 1)) -1)
				(Save 3 {Autosave} 0 (KString 9 gVersion)) ; CheckSaveGame, StrGetData
			)
			(oResumeButton oSelectNotify: oRoomChosen init: oPickAChapter)
		)
		(if (!= fp -1)
			(FileIO fiCLOSE fp)
		)
		(oTwinkle1 init: cycleSpeed: (Random 7 17) setCycle: Fwd)
		(oTwinkle2 init: cycleSpeed: (Random 7 17) setCycle: RandCycle)
		(oTwinkle3 init: cycleSpeed: (Random 7 17) setCycle: RandCycle)
		(oTwinkle4 init: cycleSpeed: (Random 7 17) setCycle: RandCycle)
		(oTwinkle5 init: cycleSpeed: (Random 7 17) setCycle: Fwd)
		(oTwinkle6 init: cycleSpeed: (Random 7 17) setCycle: RandCycle)
		(oTwinkle7 init: cycleSpeed: (Random 7 17) setCycle: RandCycle)
		(FadeToBlack 0 15 (ScriptID 64020 0) 1) ; oHandsOnWhenCued
		((ScriptID 64000 0) disable:) ; oMainMenu
	)
)

