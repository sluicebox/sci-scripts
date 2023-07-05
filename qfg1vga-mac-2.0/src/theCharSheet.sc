;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
(include sci.sh)
(use Main)
(use n814)
(use User)
(use Actor)
(use System)

(public
	theCharSheet 0
)

(local
	[local0 2] = [10000 0]
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 [temp3 6])
	(if (!= [gEgoStats param3] [global201 param3])
		(= temp0 54)
		(= temp1 57)
	else
		(= temp0 91)
		(= temp1 (if (< param1 190) 215 else 192))
	)
	(if (not param4)
		(Format @temp3 {%d} [gEgoStats param3])
	else
		(Format @temp3 &rest)
	)
	(= temp2 (if param4 60 else 22))
	(Display @temp3 dsCOORD param1 param2 dsALIGN alLEFT dsFONT 123 dsCOLOR temp1 dsWIDTH temp2)
	(Display @temp3 dsCOORD (- param1 1) param2 dsALIGN alLEFT dsFONT 123 dsCOLOR temp0 dsWIDTH temp2)
)

(procedure (localproc_1)
	(if (== gNight 1)
		(PalVary pvUNINIT)
	)
	(= local9 ((gTheIconBar curIcon:) cursor:))
	(gGame setCursor: 999)
	(gCast eachElementDo: #perform hideMe)
	(= local3 gCast)
	(= local4 gFeatures)
	(= local5 gMouseDownHandler)
	(= local6 gKeyDownHandler)
	(= gMouseDownHandler (= gKeyDownHandler (= gCast (= gFeatures 0))))
	((= gCast newCast) add:)
	((= gFeatures newFeatures) add:)
	(myHero cel: gHeroType init:)
	((= gMouseDownHandler newMH) add: myHero)
	((= gKeyDownHandler newKH) add: myHero)
	(Platform 0 4 3 -1)
	(DrawPic 904 100)
)

(procedure (localproc_2)
	(gCast eachElementDo: #dispose eachElementDo: #delete release: dispose:)
	(gFeatures dispose:)
	(gMouseDownHandler dispose:)
	(gKeyDownHandler dispose:)
	(if (== (gCurRoom picture:) 425)
		(DrawPic 14 100)
	else
		(DrawPic (gCurRoom picture:) 100)
	)
	(= gCast local3)
	(= gFeatures local4)
	(= gMouseDownHandler local5)
	(= gKeyDownHandler local6)
	(gAddToPics doit:)
	(gCast eachElementDo: #perform showMe)
	(ClearFlag 359)
	(ClearFlag 360)
	(Platform 0 4 2 -1)
	(gGame setCursor: local9)
	(if (== gNight 1)
		(PalVary pvINIT (gCurRoom picture:) 0)
	)
)

(instance newCast of EventHandler
	(properties)
)

(instance newFeatures of EventHandler
	(properties)
)

(instance newMH of EventHandler
	(properties)
)

(instance newKH of EventHandler
	(properties)
)

(instance hideMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (+ (param1 z:) 1000))
	)
)

(instance showMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (- (param1 z:) 1000))
	)
)

(instance theCharSheet of Code
	(properties)

	(method (doit &tmp [temp0 8])
		(ClearFlag 328)
		(= local7 (User input:))
		(= local8 (User controls:))
		(HandsOff)
		(= local2 gUseSortedFeatures)
		(localproc_1)
		(Display @global428 dsCOORD 145 22 dsCOLOR 215 dsWIDTH 172 dsALIGN alLEFT dsFONT 123)
		(Display @global428 dsCOORD 144 22 dsCOLOR 91 dsWIDTH 175 dsALIGN alLEFT dsFONT 123)
		(localproc_0 175 40 0 0)
		(localproc_0 175 52 1 0)
		(localproc_0 175 64 2 0)
		(localproc_0 175 76 3 0)
		(localproc_0 175 88 4 0)
		(localproc_0 175 100 12 0)
		(localproc_0 288 40 5 0)
		(localproc_0 288 52 6 0)
		(localproc_0 288 64 7 0)
		(localproc_0 288 76 8 0)
		(localproc_0 288 88 9 0)
		(localproc_0 288 100 10 0)
		(localproc_0 288 112 11 0)
		(localproc_0 200 141 13 1 (Format @temp0 {%d} [gEgoStats 13])) ; experience
		(localproc_0
			200
			153
			14
			1
			(Format
				@temp0
				{%d / %d}
				(/ (+ [gEgoStats 14] 1) 2) ; health
				(/ (+ (MaxHealth) 1) 2)
			)
		)
		(localproc_0
			200
			165
			15
			1
			(Format
				@temp0
				{%d / %d}
				(/ (+ [gEgoStats 15] 3) 4) ; stamina
				(/ (+ (MaxStamina) 3) 4)
			)
		)
		(localproc_0
			200
			177
			16
			1
			(Format @temp0 {%d / %d} [gEgoStats 16] (MaxMana)) ; mana
		)
	)

	(method (dispose &tmp temp0)
		(localproc_2)
		(= gUseSortedFeatures local2)
		(for ((= temp0 0)) (< temp0 25) ((++ temp0))
			(= [global201 temp0] [gEgoStats temp0])
		)
		(= global424 gScore)
		(HandsOn)
		(User canInput: local7 canControl: local8)
		(super dispose:)
		(gGame setCursor: gTheCursor 1)
		(DisposeScript 204)
		(SetFlag 328)
		(if (== gCurRoomNum 95)
			(gTheIconBar disable: 6)
		)
		(if (and (== gCurRoomNum 54) (IsFlag 278))
			(gTheIconBar disable: 6)
		)
	)
)

(instance myHero of View
	(properties
		x 51
		y 145
		view 802
	)

	(method (handleEvent event)
		(event claimed: 1)
		(if
			(or
				(and (== (event type:) evKEYBOARD) (OneOf (event message:) KEY_RETURN KEY_ESCAPE))
				(== (event type:) evMOUSEBUTTON)
			)
			(theCharSheet dispose:)
		)
	)
)

