;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use User)
(use Actor)
(use System)

(public
	charSheet 0
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
	[local10 12]
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 [temp3 6])
	(if (!= [gEgoStats param3] [global211 param3])
		(= temp0 54)
		(= temp1 231)
	else
		(= temp0 82)
		(= temp1 231)
	)
	(if (and (== param3 16) (IsFlag 115))
		(= temp0 70)
		(= temp1 10)
	)
	(if (not param4)
		(Format @temp3 {%d} [gEgoStats param3])
	else
		(Format @temp3 &rest)
	)
	(= temp2 (if param4 60 else 22))
	(Display @temp3 dsCOORD param1 param2 dsALIGN alRIGHT dsFONT 123 dsCOLOR temp1 dsWIDTH temp2)
	(Display @temp3 dsCOORD (- param1 1) param2 dsALIGN alRIGHT dsFONT 123 dsCOLOR temp0 dsWIDTH temp2)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0 temp1 temp2 [temp3 6])
	(if (and global404 (!= [gEgoStats 14] [global211 14])) ; honor
		(= temp0 54)
		(= temp1 231)
	else
		(= temp0 82)
		(= temp1 231)
	)
	(if (not param3)
		(Format ; "%d"
			@temp3
			15
			0
			(cond
				(
					(<
						(if global404
							(- [gEgoStats 14] global404) ; honor
						)
						0
					)
					0
				)
				(global404
					(- [gEgoStats 14] global404) ; honor
				)
			)
		)
	else
		(Format @temp3 &rest)
	)
	(= temp2 (if param3 60 else 22))
	(Display @temp3 dsCOORD param1 param2 dsALIGN alRIGHT dsFONT 123 dsCOLOR temp1 dsWIDTH temp2)
	(Display @temp3 dsCOORD (- param1 1) param2 dsALIGN alRIGHT dsFONT 123 dsCOLOR temp0 dsWIDTH temp2)
)

(procedure (localproc_2)
	(gTheIconBar disable:)
	(gCast eachElementDo: #perform hideMe)
	(= local3 gCast)
	(= local4 gFeatures)
	(= local5 gMouseDownHandler)
	(= local6 gKeyDownHandler)
	(= gMouseDownHandler (= gKeyDownHandler (= gCast (= gFeatures 0))))
	((= gCast newCast) add:)
	((= gFeatures newFeatures) add:)
	(myHero
		loop:
			(switch gBaseHeroType
				(0 1) ; Fighter
				(2 2) ; Thief
				(1 0) ; Magic User
				(3 1) ; Paladin
			)
		init:
	)
	((= gMouseDownHandler newMH) add: myHero)
	((= gKeyDownHandler newKH) add: myHero)
	(DrawPic 145 100)
)

(procedure (localproc_3)
	((gTheIconBar curIcon:) cursor: local9)
	(gCast eachElementDo: #dispose eachElementDo: #delete release: dispose:)
	(gFeatures dispose:)
	(gMouseDownHandler dispose:)
	(gKeyDownHandler dispose:)
	(cond
		((== (gCurRoom style:) -1)
			(DrawPic (gCurRoom picture:) 100)
		)
		((& (gCurRoom style:) $4000)
			(DrawPic (gCurRoom picture:) (gCurRoom style:))
		)
		(else
			(DrawPic (gCurRoom picture:) 100)
		)
	)
	(= gCast local3)
	(= gFeatures local4)
	(= gMouseDownHandler local5)
	(= gKeyDownHandler local6)
	(gAddToPics doit:)
	(gCast eachElementDo: #perform showMe)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(= temp1 -32768)
	(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
		(if (& global200 temp1)
			(gTheIconBar disable: temp0)
		)
		(>>= temp1 $0001)
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

(instance charSheet of Code
	(properties)

	(method (doit &tmp [temp0 6] temp6 temp7 temp8 temp9)
		(= local8 (User canControl:))
		(HandsOff)
		(SetFlag 101)
		(= local7 gClock)
		(= local2 gUseSortedFeatures)
		(localproc_2)
		(Display
			@global157
			dsCOORD
			110
			(if (> (StrLen @global157) 12) 7 else 3)
			dsCOLOR
			231
			dsWIDTH
			172
			dsALIGN
			alLEFT
			dsFONT
			(if (> (StrLen @global157) 12) 3 else 123)
		)
		(Display
			@global157
			dsCOORD
			109
			(if (> (StrLen @global157) 12) 7 else 3)
			dsCOLOR
			82
			dsWIDTH
			175
			dsALIGN
			alLEFT
			dsFONT
			(if (> (StrLen @global157) 12) 3 else 123)
		)
		(switch gHeroType
			(0 ; Fighter
				(Message msgGET 140 2 0 0 1 @local10) ; "Fighter"
				(Display
					@local10
					dsCOORD
					113
					31
					dsWIDTH
					100
					dsALIGN
					alCENTER
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsCOLOR
					0
				)
				(Display
					@local10
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsCOORD
					112
					30
					dsALIGN
					alCENTER
					dsWIDTH
					100
					dsCOLOR
					30
				)
			)
			(1 ; Magic User
				(Message msgGET 140 3 0 0 1 @local10) ; "Wizard"
				(Display
					@local10
					dsCOORD
					113
					31
					dsWIDTH
					100
					dsALIGN
					alCENTER
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsCOLOR
					0
				)
				(Display
					@local10
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsWIDTH
					100
					dsALIGN
					alCENTER
					dsCOORD
					112
					30
					dsCOLOR
					30
				)
			)
			(2 ; Thief
				(Message msgGET 140 4 0 0 1 @local10) ; "Thief"
				(Display
					@local10
					dsCOORD
					113
					31
					dsWIDTH
					100
					dsALIGN
					alCENTER
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsCOLOR
					0
				)
				(Display
					@local10
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsWIDTH
					100
					dsALIGN
					alCENTER
					dsCOORD
					112
					30
					dsCOLOR
					30
				)
			)
			(3 ; Paladin
				(Message msgGET 140 5 0 0 1 @local10) ; "Paladin"
				(Display
					@local10
					dsCOORD
					113
					31
					dsWIDTH
					100
					dsALIGN
					alCENTER
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsCOLOR
					0
				)
				(Display
					@local10
					dsFONT
					(proc0_21 123 123 310 123 123)
					dsWIDTH
					100
					dsALIGN
					alCENTER
					dsCOORD
					112
					30
					dsCOLOR
					30
				)
			)
		)
		(localproc_0 93 (proc0_21 32 34 34 32 34) 0 0)
		(localproc_0 93 (proc0_21 49 50 50 49 50) 1 0)
		(localproc_0 93 (proc0_21 66 67 67 65 67) 2 0)
		(localproc_0 93 (proc0_21 82 83 83 82 83) 3 0)
		(localproc_0 93 (proc0_21 99 99 99 99 99) 4 0)
		(localproc_0 93 (proc0_21 116 115 115 116 115) 12 0)
		(localproc_1 93 (proc0_21 133 130 130 133 130) 0)
		(localproc_0 286 (proc0_21 30 35 35 30 35) 5 0)
		(localproc_0 286 (proc0_21 43 48 48 43 48) 6 0)
		(localproc_0 286 (proc0_21 56 60 60 56 60) 7 0)
		(localproc_0 286 (proc0_21 69 72 72 69 72) 8 0)
		(localproc_0 286 (proc0_21 82 84 84 82 84) 9 0)
		(localproc_0 286 (proc0_21 94 96 96 94 96) 10 0)
		(localproc_0 286 (proc0_21 108 108 108 108 108) 11 0)
		(localproc_0 286 (proc0_21 121 120 120 121 120) 13 0)
		(localproc_0 286 (proc0_21 134 132 132 134 132) 14 0)
		(localproc_0
			58
			(proc0_21 169 171 171 169 171)
			16
			1
			(Format @temp0 {%d/%d} [gEgoStats 16] (gEgo maxHealth:)) ; health
		)
		(localproc_0
			(proc0_21 254 250 250 250 250)
			(proc0_21 158 157 157 158 157)
			17
			1
			(Format @temp0 {%d/%d} [gEgoStats 17] (gEgo maxStamina:)) ; stamina
		)
		(localproc_0
			(proc0_21 254 250 250 250 250)
			(proc0_21 171 170 170 171 170)
			18
			1
			(Format @temp0 {%d/%d} [gEgoStats 18] (gEgo maxMana:)) ; mana
		)
		(Format @temp0 {%d} gScore)
		(if (!= global140 gScore)
			(= temp6 54)
			(= temp7 231)
		else
			(= temp6 82)
			(= temp7 231)
		)
		(Display
			@temp0
			dsCOORD
			98
			(proc0_21 157 156 156 157 156)
			dsCOLOR
			temp7
			dsWIDTH
			60
			dsALIGN
			alLEFT
			dsFONT
			123
		)
		(Display
			@temp0
			dsCOORD
			97
			(proc0_21 157 156 156 157 156)
			dsCOLOR
			temp6
			dsWIDTH
			60
			dsALIGN
			alLEFT
			dsFONT
			123
		)
		(User input: 1)
		(= local9 ((gTheIconBar curIcon:) cursor:))
		((gTheIconBar curIcon:) cursor: 999)
		(gGame setCursor: 999 1)
		(Animate (gCast elements:) 0)
		(while 1
			(= temp8 (Event new:))
			(= temp9 (temp8 type:))
			(temp8 dispose:)
			(breakif (OneOf temp9 evKEYBOARD evMOUSEBUTTON evJOYDOWN))
		)
		(self dispose:)
		(gCurRoom notify: -15)
	)

	(method (dispose &tmp temp0)
		(localproc_3)
		(= gUseSortedFeatures local2)
		(for ((= temp0 0)) (< temp0 19) ((++ temp0))
			(= [global211 temp0] [gEgoStats temp0])
		)
		(= global140 gScore)
		(if local8
			(HandsOn)
		else
			(User canControl: 0)
			(HandsOn)
		)
		(localproc_4)
		(super dispose:)
		(gGame setCursor: gTheCursor 1)
		(ClearFlag 101)
		(gTheIconBar enable:)
		(DisposeScript 15)
	)
)

(instance myHero of View
	(properties
		x 162
		y 154
		view 140
	)
)

