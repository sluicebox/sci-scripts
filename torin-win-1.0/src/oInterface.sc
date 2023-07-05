;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64002)
(include sci.sh)
(use Main)
(use oMainMenu)
(use Indicator)
(use TPSound)
(use DialogPlane)
(use ModalPlane)
(use PushButton)
(use InventItem)
(use n64896)
(use oRotInvPlane)
(use Plane)
(use Str)
(use Array)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	oInterface 0
	oInterfacePlane 1
	SlowVideo 2
	oScoreKeeper 3
	oRewind 4
	oPause 5
	oFastForward 6
	ActivateGameInventory 7
	ActivateBoogleInventory 8
	oInvPlane 9
	oTeleprompter 10
	soTeleprompterUp 11
	soTeleprompterDown 12
	ResetHintTimer 13
	InitInterface2 14
)

(local
	oBoogleEye
	oTorinEye
)

(procedure (ResetHintTimer)
	(= gnHintTickCounter gGameTime)
	(= gnHintElapsed 0)
)

(procedure (InitInterface2 &tmp cfgBuf)
	((ScriptID 64004 0) ; oTextWindow
		picture: -2
		fore: 235
		left: 105
		right: 535
		top: 227
		bottom: 327
		init:
	)
	(voTeleprompterBg
		priority: 0
		fixPriority: 1
		y: (- ((ScriptID 64004 0) bottom:) ((ScriptID 64004 0) top:)) ; oTextWindow, oTextWindow
		init: (ScriptID 64004 0) ; oTextWindow
	)
	(oTorinInventory init: oInterfacePlane)
	(oBoogleInventory init: oInterfacePlane)
	(oInventoryGroup init: oInterfacePlane)
	(oTeleprompter init: oInterfacePlane)
	(oHelp init: oInterfacePlane)
	(oRewind init: oInterfacePlane disable:)
	(oPause init: oInterfacePlane)
	(oFastForward init: oInterfacePlane disable:)
	(foLenses init: oInterfacePlane)
	(gOEventHandler registerHandsOffActive: oRewind)
	(gOEventHandler registerHandsOffActive: oFastForward)
	(gOEventHandler registerHandsOffActive: oPause)
	(if (not gbScrollInited)
		(= gbScrollInited 1)
		(= global108 (not (SlowVideo)))
		(SavePrefs)
	)
	((ScriptID 64000 0) init:) ; oMainMenu
	((= gMessager (ScriptID 64032 1)) ; oMessager
		saveMessages: 1
		oTextSaver: (ScriptID 64004 0) ; oTextWindow
		init:
	)
	(= cfgBuf (Str new: 100))
	(GetConfig {language} cfgBuf)
	(= gnLanguage (cfgBuf asInteger:))
	(cfgBuf dispose:)
	(if (not (or (== gnLanguage 1) (== gnLanguage 33) (== gnLanguage 49)))
		(= gnLanguage 1)
	)
)

(procedure (ActivateGameInventory)
	(if (== gnInvHandler 0)
		(return)
	)
	(PutAwayEyeItem oBoogleEye)
	(= gnInvHandler 0)
	(oBooglePlane setPri: -1)
	(oInvPlane setPri: 450)
	(if (and gInventItem (== (gInventItem oMyHandler:) (ScriptID 64001 1))) ; oBoogleHandler
		(gInventItem moveTo: -3)
	)
	(oTorinInventory setButton: 1)
)

(procedure (ActivateBoogleInventory)
	(if (== gnInvHandler 1)
		(return)
	)
	(PutAwayEyeItem oTorinEye)
	(= gnInvHandler 1)
	(oBooglePlane setPri: 450)
	(oInvPlane setPri: -1)
	(if (and gInventItem (== (gInventItem oMyHandler:) (ScriptID 64001 0))) ; oInvHandler
		(gInventItem moveTo: -3)
	)
	(oBoogleInventory setButton: 1)
)

(procedure (SlowVideo)
	(return (< gnVideoSpeed 500))
)

(instance oInterfacePlane of Plane
	(properties
		priority 400
	)
)

(instance oInvPlane of Plane
	(properties
		picture -2
		priority 450
	)
)

(instance oBooglePlane of Plane
	(properties
		picture -2
	)
)

(instance oInterface of View
	(properties
		priority 1
		view 60004
	)

	(method (init &tmp [temp0 3] temp3 temp4)
		(oInterfacePlane init: 0 320 gLastScreenX gLastScreenY)
		(super init: oInterfacePlane)
		(= gbInterfaceInitted 1)
		(gThePlane setRect: 4 4 635 319)
		(if (and (gThePlane oMyFeatures:) (!= (gThePlane oMyFeatures:) gFeatures))
			((gThePlane oMyFeatures:) dispose:)
			(gThePlane oMyFeatures: gFeatures)
		)
		((ScriptID 0 1) ; oBackgroundPlane
			picture: -2
			priority: 0
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		((OpaqueFeature new:) init: oInterfacePlane)
		(topBorder init: 0 0 gLastScreenX 3)
		(leftBorder init: 0 4 3 320)
		(rightBorder init: (- gScreenWidth 4) 4 gScreenWidth 320)
		(oInvPlane init: 78 352 558 479)
		(oBooglePlane init: 78 352 558 479)
		((ScriptID 64002 3) init: oInterfacePlane) ; oScoreKeeper
		(foScore init: oInterfacePlane)
		(= gEatMice 2)
		(= temp3
			(IntArray
				newWith:
					32
					78
					65
					208
					65
					339
					65
					135
					90
					419
					90
					48
					122
					202
					122
					356
					122
					143
					65
					273
					65
					404
					65
					64
					90
					348
					90
					125
					122
					279
					122
					433
					122
			)
		)
		((ScriptID 64001 0) blankID: 60005 init: (oInvPlane getMainCast:) temp3) ; oInvHandler
		(= temp4 ((voEyePedestal new:) init: oInvPlane yourself:))
		(= oTorinEye
			(((ScriptID 64897 1) new:) init: oInvPlane inLeft: temp4 yourself:) ; voEye
		)
		(oTorinWellBG init: oInvPlane)
		((ScriptID 64001 1) ; oBoogleHandler
			blankID: 60005
			init: (oBooglePlane getMainCast:) temp3
		)
		(= temp4 ((voEyePedestal new:) init: oBooglePlane yourself:))
		(= oBoogleEye
			(((ScriptID 64897 1) new:) ; voEye
				init: oBooglePlane
				inLeft: temp4
				yourself:
			)
		)
		(oBoogleWellBG init: oBooglePlane)
		(temp3 dispose:)
		(= temp3 0)
	)
)

(instance foLenses of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Set new:)
					add:
						((Polygon new:)
							type: PTotalAccess
							init: 71 120 65 90 68 66 76 53 89 54 101 72 107 89 104 105 95 133 83 131
							yourself:
						)
						((Polygon new:)
							type: PTotalAccess
							init: 555 130 543 130 534 100 532 87 535 77 542 64 552 52 564 51 572 63 574 87 573 108
							yourself:
						)
				)
		)
		(= noun 89)
	)
)

(instance teleMove of TPSound
	(properties
		number 60008
	)
)

(instance teleDone of TPSound
	(properties
		number 60009
	)
)

(instance chime of TPSound
	(properties
		number 60002
	)
)

(instance oSpeedSound of TPSound ; UNUSED
	(properties)
)

(instance voEyePedestal of View
	(properties
		x 199
		y 73
		priority 1
		fixPriority 1
		view 60004
		loop 24
	)
)

(instance oTorinWellBG of InventWellFeature
	(properties)

	(method (init)
		(super init: &rest)
		(= oMyHandler (ScriptID 64001 0)) ; oInvHandler
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 126 51 40 431 40 480 126
					yourself:
				)
		)
	)
)

(instance oBoogleWellBG of InventWellFeature
	(properties)

	(method (init)
		(super init: &rest)
		(= oMyHandler (ScriptID 64001 1)) ; oBoogleHandler
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 126 51 40 431 40 480 126
					yourself:
				)
		)
	)
)

(instance oTorinInventory of RadioButton
	(properties
		noun 82
		x 139
		y 30
		view 60004
		loop 15
		bButtonDown 1
	)

	(method (doSelect)
		(if bButtonDown
			(ActivateGameInventory)
		)
	)
)

(instance voTeleprompterBg of View
	(properties
		view 60010
		cel 9
	)
)

(instance poTeleprompter of Prop
	(properties
		view 60010
	)
)

(instance oTeleprompterTempPlane of Plane
	(properties
		picture -2
	)
)

(instance soTeleprompter2 of Script
	(properties)
)

(instance soTeleprompterUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (ResCheck rsAUDIO 60008)
					(Load rsAUDIO 60008)
				else
					(Load 140 60008) ; WAVE
				)
				(if (ResCheck rsAUDIO 60009)
					(Load rsAUDIO 60009)
				else
					(Load 140 60009) ; WAVE
				)
				(oTeleprompterTempPlane
					priority: 1000
					init:
						((ScriptID 64004 0) left:) ; oTextWindow
						((ScriptID 64004 0) top:) ; oTextWindow
						((ScriptID 64004 0) right:) ; oTextWindow
						((ScriptID 64004 0) bottom:) ; oTextWindow
				)
				(UpdatePlane oTeleprompterTempPlane)
				(poTeleprompter
					y:
						(-
							(oTeleprompterTempPlane bottom:)
							(oTeleprompterTempPlane top:)
						)
					cel: 0
					init: oTeleprompterTempPlane
					setCycle: End self
				)
				(teleMove playSound: 60008)
			)
			(1
				(teleMove stop:)
				(oTeleprompterTempPlane dispose:)
				((ScriptID 64004 0) show:) ; oTextWindow
				(self dispose:)
			)
		)
	)
)

(instance soTeleprompterDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (ResCheck rsAUDIO 60008)
					(Load rsAUDIO 60008)
				else
					(Load 140 60008) ; WAVE
				)
				(if (ResCheck rsAUDIO 60009)
					(Load rsAUDIO 60009)
				else
					(Load 140 60009) ; WAVE
				)
				((ScriptID 64004 0) hide:) ; oTextWindow
				(oTeleprompterTempPlane
					priority: 1000
					init:
						((ScriptID 64004 0) left:) ; oTextWindow
						((ScriptID 64004 0) top:) ; oTextWindow
						((ScriptID 64004 0) right:) ; oTextWindow
						((ScriptID 64004 0) bottom:) ; oTextWindow
				)
				(UpdatePlane oTeleprompterTempPlane)
				(poTeleprompter
					y:
						(-
							(oTeleprompterTempPlane bottom:)
							(oTeleprompterTempPlane top:)
						)
					cel: 9
					init: oTeleprompterTempPlane
					setCycle: Beg self
				)
				(teleMove playSound: 60008)
			)
			(1
				(teleMove stop:)
				(teleDone playSound:)
				(oTeleprompterTempPlane dispose:)
				(self dispose:)
			)
		)
	)
)

(instance oTeleprompter of ToggleButton
	(properties
		noun 84
		x 54
		y 62
		view 60004
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 75 42 54 71 0 70 0 39 21 18 75 18
					yourself:
				)
		)
	)

	(method (doSelect)
		(if bButtonDown
			(soTeleprompterUp init: soTeleprompter2)
		else
			(soTeleprompterDown init: soTeleprompter2)
		)
	)
)

(instance poHourglass of Prop
	(properties
		x 609
		y 70
		view 60004
		loop 25
	)
)

(instance poNull47 of Prop
	(properties)
)

(instance oHelp of PushButton
	(properties
		noun 91
		x 609
		y 70
		view 60004
		loop 25
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 578 58 585 5 609 2 630 4 637 8 634 66 615 72 587 67
					yourself:
				)
		)
	)

	(method (handleEvent)
		(if (== loop 25)
			(return 0)
		else
			(super handleEvent: &rest)
			(return)
		)
	)

	(method (doSelect &tmp oStrMsg)
		(gCurRoom showHelp:)
		(chime playSound:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((== gnHintTime -1)
				(if
					(and
						(not (poNull47 script:))
						(== loop 17)
						(gUser canControl:)
					)
					(poNull47 setScript: soRaiseHourglass)
				)
			)
			((== gnHintTime -2)
				(if
					(and
						(== loop 25)
						(not (poNull47 script:))
						(gUser canControl:)
					)
					(poNull47 setScript: soLowerHourglass)
				)
			)
			(else
				(if
					(and
						(>= gnHintElapsed gnHintTime)
						(== loop 25)
						(not (poNull47 script:))
						(gUser canControl:)
					)
					(poNull47 setScript: soLowerHourglass)
				)
				(if
					(and
						(< gnHintElapsed gnHintTime)
						(== loop 17)
						(not (poNull47 script:))
						(gUser canControl:)
					)
					(poNull47 setScript: soRaiseHourglass)
				)
			)
		)
	)
)

(instance soRaiseHourglass of Script
	(properties)

	(method (changeState newState &tmp oStrMsg)
		(switch (= state newState)
			(0
				(if (ResCheck rsAUDIO 60008)
					(Load rsAUDIO 60008)
				else
					(Load 140 60008) ; WAVE
				)
				(if (ResCheck rsAUDIO 60009)
					(Load rsAUDIO 60009)
				else
					(Load 140 60009) ; WAVE
				)
				(oHelp hide:)
				(poHourglass
					cel: (poHourglass lastCel:)
					init: (oHelp plane:)
					setCycle: Beg self
				)
				(teleMove playSound: 60008)
			)
			(1
				(teleMove stop:)
				(teleDone playSound:)
				(poHourglass dispose:)
				(oHelp loop: 25 noun: 91 show:)
				(oHelp
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 578 58 585 5 609 2 630 4 637 8 634 66 615 72 587 67
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance soLowerHourglass of Script
	(properties)

	(method (changeState newState &tmp oStrMsg)
		(switch (= state newState)
			(0
				(if (ResCheck rsAUDIO 60008)
					(Load rsAUDIO 60008)
				else
					(Load 140 60008) ; WAVE
				)
				(if (ResCheck rsAUDIO 60009)
					(Load rsAUDIO 60009)
				else
					(Load 140 60009) ; WAVE
				)
				(oHelp hide:)
				(poHourglass cel: 0 init: (oHelp plane:) setCycle: End self)
				(teleMove playSound: 60008)
			)
			(1
				(teleMove stop:)
				(teleDone playSound:)
				(poHourglass dispose:)
				(oHelp loop: 17 noun: 85 show:)
				(oHelp
					setPolygon:
						((Polygon new:)
							type: PTotalAccess
							init: 579 59 591 50 615 51 632 59 635 66 613 71 586 66
							yourself:
						)
				)
				(self dispose:)
			)
		)
	)
)

(instance oBoogleInventory of RadioButton
	(properties
		noun 81
		x 179
		y 30
		view 60004
		loop 16
	)

	(method (doSelect &tmp oStrMsg)
		(if bButtonDown
			(ActivateBoogleInventory)
		)
	)
)

(instance oInventoryGroup of RadioGroup
	(properties)

	(method (init)
		(super init: &rest)
		(self add: oBoogleInventory oTorinInventory)
	)
)

(class FRButton of PushButton
	(properties
		soMyScript 0
	)

	(method (setScript soParm &tmp soTemp)
		(if (and argc (== soParm soMyScript))
			(return)
		)
		(if argc
			(= soMyScript soParm)
		else
			(= soMyScript 0)
		)
	)
)

(instance oRewind of FRButton
	(properties
		noun 75
		x 277
		y 30
		view 60004
		loop 7
	)

	(method (doSelect)
		(if soMyScript
			(soMyScript state: 9999)
			(gMessager kill:)
			(soMyScript rewind:)
			(if (soMyScript bHasFF:)
				(oFastForward enable:)
				(oFastForward setScript: soMyScript)
			)
		)
	)
)

(instance oFastForward of FRButton
	(properties
		noun 74
		x 357
		y 30
		view 60004
		loop 10
	)

	(method (doSelect)
		(if soMyScript
			(soMyScript state: 9999)
			(gMessager kill:)
			(soMyScript ff:)
		)
	)
)

(instance oPause of ToggleButton
	(properties
		noun 73
		x 317
		y 30
		view 60004
		loop 8
	)

	(method (doSelect &tmp oStrMsg)
		(if bButtonDown
			(Sound pause: 1)
			(oPausePlane init:)
			(TextDialog (MakeMessageText 0 0 2 1 0) (Str with: goDismissString))
			(self setButton: 0)
			(oPausePlane dispose:)
			(Sound pause: 0)
		else
			(oPausePlane dispose:)
			(Sound pause: 0)
		)
	)
)

(instance oPausePlane of ModalPlane
	(properties)

	(method (init &tmp oTmpPlane)
		(= picture -2)
		(= oTmpPlane (oPause plane:))
		(super init: (oTmpPlane left:) (oTmpPlane top:) (oTmpPlane right:) (oTmpPlane bottom:))
		(oPause dispose: init: oPausePlane setButton: 1)
	)

	(method (dispose)
		(super dispose: &rest)
		(oPause init: oInterfacePlane)
	)
)

(instance oScoreKeeper of PointGauge
	(properties
		sound 60010
		margin 8
		view 60007
		x 442
		y 51
	)
)

(instance foScore of Feature
	(properties
		noun 83
	)

	(method (init)
		(super init: &rest)
		(self setRect: 438 35 481 57)
	)
)

(instance topBorder of Plane
	(properties
		priority 400
		back 227
	)
)

(instance leftBorder of Plane
	(properties
		priority 400
		back 227
	)
)

(instance rightBorder of Plane
	(properties
		priority 400
		back 227
	)
)

