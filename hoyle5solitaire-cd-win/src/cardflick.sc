;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6029)
(include sci.sh)
(use Main)
(use KeyMouse)
(use InvisibleWindow)
(use TrackingView)
(use h5Messager)
(use Str)
(use GameControls)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	cardflick 0
	roomScript 3
	proc6029_4 4
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29 = 15
	local30
	local31
	local32 = 1
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
)

(procedure (proc6029_4 param1) ; UNUSED
	(if argc
		(= local2 param1)
	else
		(return local2)
	)
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: {%s} param1))
	(= temp2 (((cardflick plane:) casts:) at: 0))
	(for ((= temp0 (- (temp2 size:) 1))) (>= temp0 0) ((-- temp0))
		(if
			(and
				((temp2 at: temp0) name:)
				(temp1 compare: ((temp2 at: temp0) name:))
			)
			((temp2 at: temp0) dispose:)
		)
	)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 param6 &tmp temp0)
	(if (and (< argc 4) (not param1))
		(return)
	)
	(if (< param1 0)
		(= temp0 1)
		(*= param1 -1)
	else
		(= temp0 0)
	)
	(cond
		((>= param1 1000)
			(proc0_10
				680
				2
				(mod (/ param1 1000) 10)
				(+ param2 30)
				param3
				15
				param6
				param5
			)
			(proc0_10
				680
				2
				(mod (/ param1 100) 10)
				(+ param2 39)
				param3
				15
				param6
				param5
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				param6
				param5
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				param6
				param5
			)
		)
		((>= param1 100)
			(proc0_10
				680
				2
				(mod (/ param1 100) 10)
				(+ param2 39)
				param3
				15
				param6
				param5
			)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				param6
				param5
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				param6
				param5
			)
		)
		((>= param1 10)
			(proc0_10
				680
				2
				(mod (/ param1 10) 10)
				(+ param2 48)
				param3
				15
				param6
				param5
			)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				param6
				param5
			)
		)
		((>= param1 0)
			(proc0_10
				680
				2
				(mod param1 10)
				(+ param2 57)
				param3
				15
				param6
				param5
			)
		)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (Str format: {%s} param1))
	(= temp2 ((param2 casts:) at: 0))
	(for ((= temp0 (- (temp2 size:) 1))) (>= temp0 0) ((-- temp0))
		(if
			(and
				((temp2 at: temp0) name:)
				(temp1 compare: ((temp2 at: temp0) name:))
			)
			((temp2 at: temp0) dispose:)
		)
	)
	(temp1 dispose:)
)

(procedure (localproc_3)
	(cond
		((< -1 (- (flickCard x:) local16) 1)
			(= local14 1)
		)
		((< -3 (- (flickCard x:) local16) 2)
			(if (< (= local12 (Random 1 5)) 4)
				(= local14 1)
			else
				(= local14 (Random 1 6))
			)
		)
		(else
			(= local14 (Random 1 6))
		)
	)
	(if
		(and
			(== gPrevRoomNum 975) ; chooseGame
			(not local44)
			(== local32 3)
			(< -5 (flickCard x:) 5)
			(== 1 (Random 1 2))
		)
		(Load rsVIEW 1010)
		(Load 140 3070) ; WAVE
		(Load 140 3090) ; WAVE
		(= local44 1)
		(= local14 18)
		(= local25 0)
		(+= local24 5)
		(= local21 0)
		(= local22 0)
		(= local23 0)
	)
	(if
		(and
			(== gPrevRoomNum 975) ; chooseGame
			(== local32 2)
			(< -5 (flickCard x:) 5)
			(== 1 (Random 1 3))
		)
		(= local14 19)
		(= local25 0)
		(if (> local24 1)
			(-= local24 2)
		else
			(= local24 0)
		)
		(= local21 0)
		(= local22 0)
		(= local23 0)
	)
	(if
		(and
			(== gPrevRoomNum 975) ; chooseGame
			(== local32 4)
			(< -5 (flickCard x:) 5)
			(== 1 (Random 1 2))
		)
		(= local14 20)
		(= local25 0)
		(if (> local24 1)
			(-= local24 1)
		else
			(= local24 0)
		)
		(= local21 0)
		(= local22 0)
		(= local23 0)
	)
	(switch local14
		(1
			(= local21 (+ local15 320))
			(= local22 (+ local15 316))
			(= local23 (+ local15 326))
		)
		(2
			(= local21 (+ local15 268))
			(= local22 (+ local15 253))
			(= local23 (+ local15 280))
		)
		(3
			(= local21 (+ local15 406))
			(= local22 (+ local15 388))
			(= local23 (+ local15 423))
		)
		(4
			(= local21 (+ local15 322))
			(= local22 (+ local15 307))
			(= local23 (+ local15 337))
		)
		(5
			(= local21 (+ local15 322))
			(= local22 (+ local15 307))
			(= local23 (+ local15 335))
		)
		(6
			(= local21 (+ local15 377))
			(= local22 (+ local15 359))
			(= local23 (+ local15 394))
		)
	)
	(= local37 0)
	(cond
		((and (< local17 local21) (< local21 local18))
			(switch local32
				(3
					(= local14 14)
				)
				(4
					(= local14 16)
				)
				(else
					(= local14 8)
				)
			)
			(= local25 0)
		)
		((and (< local19 local21) (< local21 local20))
			(switch local32
				(3
					(= local14 15)
				)
				(4
					(= local14 17)
				)
				(else
					(= local14 7)
				)
			)
			(= local25 0)
		)
		((and (<= local18 local21) (<= local21 local19))
			(= local25 1)
			(++ local24)
			(cond
				((< local22 (+ local16 local34))
					(= local37 20)
				)
				((> local23 (+ local16 local35))
					(= local37 -15)
				)
			)
		)
		(else
			(= local25 0)
		)
	)
	(if (and (== local14 3) local25)
		(= local14 11)
	)
	(if (and (== local14 6) local25)
		(= local14 12)
	)
	(if (and local25 (or (== local14 18) (== local14 19) (== local14 20)))
		(= local25 0)
	)
	(if (and (== local32 1) (== (Random 1 150) 50) (== gPrevRoomNum 975)) ; chooseGame
		(= local14 13)
		(if local25
			(-- local24)
		)
		(= local25 0)
	)
)

(procedure (localproc_4)
	(= local3 gGameControls)
	((= gGameControls flickingOptions)
		plane: flickOptionsWindow
		okIconItem: iconOkay
		curIcon: (if (not (HaveMouse)) iconOkay else 0)
		add:
			(volumeSliderToo theObj: gGame selector: #masterVolume yourself:)
			(iconVolumeHot theObj: iconVolumeHot selector: #doit yourself:)
			(handSpeedSlider
				theObj: animationSpeedCode
				selector: #doit
				yourself:
			)
			(coffeeLevelSlider
				theObj: coffeeLevelCode
				selector: #doit
				yourself:
			)
			(iconCoffeeLevelHot
				theObj: iconCoffeeLevelHot
				selector: #doit
				yourself:
			)
			(iconSpeedHot theObj: iconSpeedHot selector: #doit yourself:)
			(iconBackGMusic theObj: iconBackGMusic selector: #doit yourself:)
			(iconReset theObj: iconReset selector: #doit yourself:)
			(iconOkay theObj: iconOkay selector: #doit yourself:)
		okIconItem: iconOkay
		curIcon: (if (not (HaveMouse)) iconOkay else 0)
	)
	(gGameControls show:)
)

(procedure (localproc_5 param1 param2 param3)
	(if (< param2 param1)
		(= param2 param1)
	)
	(if (> param2 param3)
		(= param2 param3)
	)
	(return param2)
)

(instance cardflick of HoyleRoom
	(properties
		style 14
	)

	(method (init)
		(DisableCursor)
		(if global921
			(= global896 0)
			(= global916 1)
		)
		(= local0 0)
		(= local2 0)
		((= global929 flkcard_opt) doit:)
		(= local13 global385)
		(cond
			((== gPrevRoomNum 975) ; chooseGame
				(= global385 (+ 18 local32))
			)
			((== global221 28)
				(= global385 (+ 18 (= local32 5)))
			)
			(else
				(= local12 (Random 1 4))
				(= global385 (+ 18 (= local32 local12)))
			)
		)
		(if (and (!= gPrevRoomNum 975) (not global527)) ; chooseGame
			(switch local32
				(1
					(Load rsVIEW 987)
				)
				(2
					(Load rsVIEW 991)
				)
				(3
					(Load rsVIEW 992)
				)
				(4
					(Load rsVIEW 993)
				)
				(5
					(Load rsVIEW 981)
				)
			)
		)
		(gChar1 active: 1)
		(gChar2 active: 0)
		(gChar3 active: 0)
		(gTheKeyMouseList release:)
		(KeyMouse setList: gTheKeyMouseList)
		(gGame setCursor: 999)
		(= picture (+ global877 global385))
		(= local27 1)
		(= local28 0)
		(vBackgrnd init:)
		(super init:)
		(if (== gPrevRoomNum 975) ; chooseGame
			(resignButton setPri: 255 init:)
			((KeyMouse objList:) add: resignButton)
			(handleEventList add: resignButton)
			(optionsButton setPri: 256 init:)
			((KeyMouse objList:) add: optionsButton)
			(handleEventList add: optionsButton)
			(statusWindow init:)
		)
		(gChar1 view: 0 active: 1 setLoop: 2)
		(if global921
			((gChar1 face:) view: 0 loop: 4 cel: 0)
			(gChar1 x: -50 y: -50)
		else
			((gChar1 face:) view: 0)
			(gChar1 posn: -50 -50)
		)
		(if global921
			(gChar1 view: 0 loop: 4 cel: 0)
		)
		(gChar1 show: init:)
		(Characters init:)
		(= global394 0)
		(= global265 0)
		(handleEventList add:)
		(switch local32
			(1
				(= local33 277)
				(= local34 302)
				(= local35 349)
				(= local36 375)
			)
			(2
				(= local33 294)
				(= local34 294)
				(= local35 362)
				(= local36 362)
			)
			(3
				(= local33 292)
				(= local34 292)
				(= local35 361)
				(= local36 361)
			)
			(4
				(= local33 256)
				(= local34 295)
				(= local35 365)
				(= local36 400)
			)
			(5
				(= local33 283)
				(= local34 302)
				(= local35 356)
				(= local36 377)
			)
		)
		(= local31 0)
		(if (== (= local12 (Random 1 2)) 1)
			(= local7 1)
			(= local8 0)
		else
			(= local7 0)
			(= local8 1)
		)
		(self setScript: roomScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (handleEventList handleEvent: event)
			(event claimed: 1)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose &tmp temp0)
		(if (and (!= gPrevRoomNum 975) (not global527)) ; chooseGame
			(switch local32
				(1
					(UnLoad 128 987)
					(DisposeScript 6092)
				)
				(2
					(UnLoad 128 991)
					(DisposeScript 6093)
				)
				(3
					(UnLoad 128 992)
					(DisposeScript 6094)
				)
				(4
					(UnLoad 128 994)
					(DisposeScript 6095)
				)
				(5
					(UnLoad 128 981)
					(DisposeScript 6091)
				)
			)
		)
		(= local0 0)
		(= global418 0)
		(gDelayCast release:)
		(= global458 0)
		((KeyMouse objList:) release:)
		(vHat dispose:)
		(vFrontHat dispose:)
		(vShadow dispose:)
		(handleEventList release: dispose:)
		(if (== gPrevRoomNum 975) ; chooseGame
			(resignButton dispose:)
			(optionsButton dispose:)
			(statusWindow dispose:)
		)
		(gSong stop:)
		(= local42 (gGame masterVolume:))
		(DisposeScript 6091)
		(= global385 local13)
		(super dispose:)
	)
)

(instance flkcard_opt of File
	(properties
		name {flkcard.opt}
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(= temp0 (Str new:))
					(self
						writeString:
							(temp0 format: {%d%d%d} local2 global282 global283)
						close:
					)
					(temp0 dispose:)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= temp1 (Str new:))
				(self readString: temp1 2)
				(= local2 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global282 (temp1 asInteger:))
				(self readString: temp1 2)
				(= global283 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(return 0)
			)
			(else
				(= local2 0)
				(= global282 0)
				(= global283 5)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(cond
			((and local0 (== state 2) local9)
				(if (not local11)
					(if
						(and
							(== local32 5)
							(== gPrevRoomNum 975) ; chooseGame
							(== (pCobra cel:) 0)
							(== (Random 1 50) 25)
						)
						(pCobra
							x: (vHat x:)
							setPri: (+ (vHat priority:) 1)
							show:
							setCycle: End
						)
						(= local40 1)
					)
					(if
						(and
							(== local32 5)
							(== gPrevRoomNum 975) ; chooseGame
							(== (Random 1 5) 2)
							(== (pCobra cel:) (pCobra lastCel:))
						)
						(pCobra setCycle: Beg)
						(= local40 0)
					)
					(if
						(and
							(== local32 5)
							(== gPrevRoomNum 975) ; chooseGame
							(not local40)
							(== (pCobra cel:) 0)
						)
						(pCobra hide:)
					)
					(if (> (flickCard x:) 260)
						(= local7 0)
						(= local8 1)
					)
					(if (< (flickCard x:) -260)
						(= local8 0)
						(= local7 1)
					)
					(if (and (== gPrevRoomNum 975) (!= global282 0)) ; chooseGame
						(switch global282
							(1
								(= local39 200)
							)
							(2
								(= local39 150)
							)
							(3
								(= local39 100)
							)
							(4
								(= local39 60)
							)
							(5
								(= local39 50)
							)
							(6
								(= local39 40)
							)
							(7
								(= local39 30)
							)
							(8
								(= local39 10)
							)
							(9
								(= local39 5)
							)
						)
						(if (== (Random 1 local39) 2)
							(= temp1 local7)
							(= local7 local8)
							(= local8 temp1)
						)
					)
					(if local7
						(flickCard x: (+ (flickCard x:) (* global283 3)))
						(UpdateScreenItem flickCard)
					)
					(if local8
						(flickCard x: (- (flickCard x:) (* global283 3)))
						(UpdateScreenItem flickCard)
					)
				)
				(if (and (not local11) (not local1))
					(if (== evMOUSEBUTTON ((= temp0 (Event new:)) type:))
						(cond
							(
								(and
									(<=
										(resignButton nsLeft:)
										(temp0 x:)
										(- (resignButton nsRight:) 1)
									)
									(<=
										(resignButton nsTop:)
										(temp0 y:)
										(resignButton nsBottom:)
									)
								)
								(temp0 type: (| (temp0 type:) evMOUSEBUTTON))
								(temp0 type: (| (temp0 type:) evVERB))
								(resignButton handleEvent: temp0)
								(temp0 dispose:)
							)
							(
								(and
									(<=
										(optionsButton nsLeft:)
										(temp0 x:)
										(- (optionsButton nsRight:) 1)
									)
									(<=
										(optionsButton nsTop:)
										(temp0 y:)
										(optionsButton nsBottom:)
									)
								)
								(temp0 type: (| (temp0 type:) evMOUSEBUTTON))
								(temp0 type: (| (temp0 type:) evVERB))
								(optionsButton handleEvent: temp0)
								(temp0 dispose:)
							)
							(else
								(= local11 1)
								(temp0 dispose:)
								(++ local26)
								(= local15 (flickCard x:))
								(flickCard setScript: sFlickCard)
							)
						)
					else
						(temp0 dispose:)
					)
				)
			)
			((and local10 (not local9))
				(if (== (flickCard y:) 0)
					(if (and (== local32 5) (!= gPrevRoomNum 975)) ; chooseGame
						(= local15 (flickCard x:))
						(flickCard setScript: sFlickCard)
					else
						(= local9 1)
						(EnableCursor)
					)
				else
					(flickCard y: (- (flickCard y:) 4))
				)
			)
		)
		(if (and (not local0) (== state 1))
			(cond
				(local27
					(if (<= (vBackgrnd y:) -480)
						(vBackgrnd dispose:)
						(roomScript changeState: 2)
					else
						(vBackgrnd y: (- (vBackgrnd y:) 40))
						(UpdateScreenItem vBackgrnd)
						(if (== (vBackgrnd y:) -40)
							(if
								(and
									(== gPrevRoomNum 975) ; chooseGame
									(!= (gGame masterVolume:) 0)
								)
								(PlaySong play: 96)
								(gSong setLoop: -1)
							)
							(if (< (= local12 (Random 1 200)) 100)
								(= local12 (- 0 local12))
							else
								(-= local12 100)
							)
							(vHat init: x: local12 setPri: 50 show:)
							(vFrontHat init: x: local12 setPri: 150 show:)
							(cond
								((== local32 1)
									(vShadow init: x: local12 setPri: 1 show:)
								)
								(vShadow
									(vShadow hide: dispose:)
								)
							)
							(= local16 local12)
							(= local17 (+ local33 local16))
							(= local18 (+ local34 local16))
							(= local19 (+ local35 local16))
							(= local20 (+ local36 local16))
						)
					)
				)
				((== (vBackgrnd y:) 0)
					(localproc_0 {card})
					(if local30
						(if (== local32 4)
							(= local44 0)
							(aBuzzBoard dispose:)
							(aDust dispose:)
							(aWreckage dispose:)
						)
						(if (== local32 5)
							(aTorch dispose:)
						)
						(= global385 (+ 18 local32))
						(+= local29 5)
						(gSound2 play: 3010)
					else
						(gSound2 play: 3040)
					)
					(localproc_2 {hits} statusWindow)
					(localproc_1 0 12 5 1 {hits} statusWindow)
					(localproc_2 {left} statusWindow)
					(localproc_1 52 159 5 1 {left} statusWindow)
					(localproc_2 {target} statusWindow)
					(localproc_1 local29 255 5 1 {target} statusWindow)
					(= local27 1)
				)
				(else
					(vBackgrnd y: (+ (vBackgrnd y:) 40))
					(UpdateScreenItem vBackgrnd)
				)
			)
		)
	)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(= local0 0)
				(= seconds 3)
			)
			(1
				(if (and (!= gPrevRoomNum 975) (!= global221 28)) ; chooseGame
					(EnableCursor)
				else
					(DisableCursor)
				)
				(= local40 0)
				(pCobra init: x: (vHat x:) hide:)
				(= local26 0)
				(= local24 0)
				(= local5 2)
				(= local9 0)
				(= global243 0)
				(= local0 0)
			)
			(2
				(if (!= gPrevRoomNum 975) ; chooseGame
					(= global282 0)
					(= global283 3)
				)
				(= local0 1)
				(= local1 0)
				(= local30 0)
				(EnableCursor)
				(if (< (= local12 (Random 1 500)) 250)
					(= local12 (- 0 local12))
				else
					(-= local12 250)
				)
				(= local10 1)
				(if (and (== local32 5) (!= gPrevRoomNum 975)) ; chooseGame
					(= global283 0)
					(flickCard init: x: local16)
				else
					(flickCard init: x: local12)
				)
			)
			(3
				(if local41
					(= local41 0)
					(= local29 10)
					(pCobra hide: dispose:)
					(gSong stop:)
					(PlaySong play: (+ 90 local32))
					(gSong setLoop: 1)
				)
				(= cycles 1)
			)
			(4
				(= local0 0)
				(if
					(or
						(!= gPrevRoomNum 975) ; chooseGame
						(and (== local32 5) (== gPrevRoomNum 975)) ; chooseGame
					)
					(vHat hide: dispose:)
					(vFrontHat hide: dispose:)
					(if (== local32 1)
						(vShadow hide: dispose:)
					)
				)
				(if (!= gPrevRoomNum 975) ; chooseGame
					(PlaySong play: (+ 90 local32))
					(gSong setLoop: 1)
				)
				(switch local32
					(1
						(self setScript: (ScriptID 6092 0) self) ; cowScript
					)
					(2
						(self setScript: (ScriptID 6093 0) self) ; kingScript
					)
					(3
						(self setScript: (ScriptID 6094 0) self) ; baseScript
					)
					(4
						(self setScript: (ScriptID 6095 0) self) ; poolScript
					)
					(5
						(self setScript: (ScriptID 6091 0) self) ; peaScript
					)
				)
			)
			(5
				(if (!= gPrevRoomNum 975) ; chooseGame
					(gCurRoom newRoom: gCardGameScriptNumber)
				else
					(= local27 0)
					(vBackgrnd init:)
					(= local30 1)
					(= local32 1)
					(= local33 277)
					(= local34 302)
					(= local35 349)
					(= local36 375)
					(roomScript changeState: 0)
				)
			)
			(6
				(gSound2 play: 3080)
				(= seconds 3)
			)
			(7
				(gCurRoom newRoom: gCardGameScriptNumber)
			)
		)
	)
)

(instance sFlickCard of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(DisableCursor)
				(= local10 0)
				(= cycles 1)
			)
			(1
				(gSound2 play: 908)
				(flickCard setCycle: End self)
			)
			(2
				(vArm init: (flickCard x:) (flickCard y:) setPri: 255 show:)
				(localproc_3)
				(if (== local14 18)
					(gSound play: 3030)
				)
				(if (and (not local25) (== local14 1))
					(= local14 5)
				)
				(if (and (not local25) (!= local32 5))
					(= local45 (vHat priority:))
					(= local46 (vFrontHat priority:))
					(vHat setPri: (+ local5 1))
					(vFrontHat setPri: (+ local5 2))
				)
				(flickCard
					setLoop: (+ local14 2)
					setCel: 0
					x: (+ (flickCard x:) local37)
					setPri: 145
				)
				(if (== local14 13)
					(flickCard setPri: 255)
				)
				(if (== local14 19)
					(gSound play: 3050)
				)
				(flickCard setCycle: End self)
			)
			(3
				(cond
					((!= gPrevRoomNum 975) ; chooseGame
						(flickCard hide:)
					)
					(local25
						(flickCard hide:)
					)
				)
				(if (and (not local25) (!= local32 5))
					(vHat setPri: local45)
					(vFrontHat setPri: local46)
				)
				(if (== local14 20)
					(aTorch init:)
					(gSound play: 3060)
					(aTorch setScript: sFlameTorch)
				)
				(if (== local14 18)
					(aBuzzBoard init:)
					(gSound play: 3070)
					(aBuzzBoard setScript: sCutBoard sFlickCard)
				else
					(= cycles 10)
				)
			)
			(4
				(if (or (== local14 18) (== local14 19) (== local14 20))
					(localproc_2 {hits} statusWindow)
					(localproc_1 local24 12 5 1 {hits} statusWindow)
				)
				(cond
					(local25
						(if (== gPrevRoomNum 975) ; chooseGame
							(localproc_2 {hits} statusWindow)
							(localproc_1 local24 12 5 1 {hits} statusWindow)
						)
						(switch local32
							(1
								(gSound play: 6901)
							)
							(2
								(gSound play: 909)
							)
							(3
								(gSound play: 2901)
							)
							(4
								(gSound play: 2902)
							)
							(5
								(gSound play: 2903)
							)
						)
					)
					((== local14 13)
						(switch local32
							(1
								(gSound play: 9007)
							)
						)
					)
				)
				(if (== gPrevRoomNum 975) ; chooseGame
					(localproc_2 {left} statusWindow)
					(localproc_1 (- 52 local26) 159 5 1 {left} statusWindow)
				)
				(if (or (< local21 local17) (> local21 local20))
					(cond
						((== local32 1)
							(if (> (= local12 (Random 1 11)) 5)
								(-= local12 11)
							)
						)
						((== local32 3)
							(= local12 (+ 35 (Random 1 8)))
						)
						((> (= local12 (Random 1 7)) 3)
							(-= local12 7)
						)
					)
					(+= local12 (flickCard y:))
				else
					(= local12 (flickCard y:))
				)
				(cond
					((!= local14 1)
						(if (and (== local25 0) (!= local14 13))
							(cond
								(
									(and
										(!= local14 7)
										(!= local14 8)
										(not (>= local14 14))
									)
									(cond
										((== local14 3)
											(if
												(or
													(==
														(= temp0 (Random 1 3))
														1
													)
													(== temp0 2)
												)
												(proc0_10
													982
													11
													(- temp0 1)
													(+ (flickCard x:) 78)
													(+ local12 20)
													local5
													(cardflick plane:)
													{card}
												)
											else
												(proc0_10
													982
													12
													0
													(flickCard x:)
													local12
													local5
													(cardflick plane:)
													{card}
												)
											)
										)
										((== local14 2)
											(proc0_10
												982
												12
												(- local14 1)
												(flickCard x:)
												local12
												local5
												(cardflick plane:)
												{card}
											)
										)
										(else
											(proc0_10
												982
												12
												(- local14 2)
												(flickCard x:)
												local12
												local5
												(cardflick plane:)
												{card}
											)
										)
									)
								)
								((== local14 18)
									(proc0_10
										982
										(+ local14 2)
										(flickCard lastCel:)
										(flickCard x:)
										(flickCard y:)
										local5
										(cardflick plane:)
										{card}
									)
								)
								((and (!= local14 19) (!= local14 20))
									(proc0_10
										982
										(+ local14 2)
										(flickCard lastCel:)
										(flickCard x:)
										local12
										local5
										(cardflick plane:)
										{card}
									)
								)
							)
						)
					)
					((and local25 (== gPrevRoomNum 975)) ; chooseGame
						(if
							(and
								(< 10 local24 20)
								(> local21 (+ local16 local34 5))
								(< local21 (+ local16 (- local35 5)))
							)
							(proc0_10
								982
								(+ local14 2)
								(flickCard lastCel:)
								(flickCard x:)
								local12
								5
								(cardflick plane:)
								{card}
							)
						)
					)
					((not local25)
						(= temp0 (Random 1 2))
						(proc0_10
							982
							11
							(- temp0 1)
							(flickCard x:)
							local12
							local5
							(cardflick plane:)
							{card}
						)
					)
				)
				(++ local5)
				(vArm hide:)
				(if (== gPrevRoomNum 975) ; chooseGame
					(flickCard
						setLoop: 2
						setCel: 0
						x: 0
						y: 100
						setPri: 250
						show:
					)
				)
				(if (< (= local12 (Random 1 500)) 250)
					(= local12 (- 0 local12))
				else
					(-= local12 250)
				)
				(flickCard x: local12)
				(if (== (= local12 (Random 1 2)) 1)
					(= local7 1)
					(= local8 0)
				else
					(= local7 0)
					(= local8 1)
				)
				(= local9 0)
				(= local11 0)
				(if (== gPrevRoomNum 975) ; chooseGame
					(cond
						((or (== local26 52) (>= local24 local29))
							(flickCard hide:)
							(= local10 0)
							(if (>= local24 local29)
								(if (== local32 5)
									(= local41 1)
								else
									(= local30 1)
									(if (> (++ local32) 5)
										(= local32 1)
									)
									(switch local32
										(1
											(= local33 277)
											(= local34 302)
											(= local35 349)
											(= local36 375)
										)
										(2
											(= local33 294)
											(= local34 294)
											(= local35 362)
											(= local36 362)
										)
										(3
											(= local33 292)
											(= local34 292)
											(= local35 361)
											(= local36 361)
										)
										(4
											(= local33 256)
											(= local34 295)
											(= local35 365)
											(= local36 400)
										)
										(5
											(= local33 283)
											(= local34 302)
											(= local35 356)
											(= local36 377)
										)
									)
								)
							)
							(if (and (== local32 5) (== gPrevRoomNum 975) local41) ; chooseGame
								(localproc_0 {card})
								(roomScript changeState: 3)
							else
								(= local27 0)
								(vBackgrnd init:)
								(roomScript changeState: 0)
							)
						)
						((== local14 18)
							(aDust init:)
							(aDust setScript: sDustCloud)
						)
						(else
							(= local10 1)
						)
					)
				)
				(if (!= gPrevRoomNum 975) ; chooseGame
					(flickCard dispose:)
					(cond
						(local25
							(roomScript changeState: 3)
						)
						((not local25)
							(roomScript changeState: 6)
						)
						(else
							(roomScript changeState: 5)
						)
					)
				)
				(if (!= local14 18)
					(self dispose:)
				)
			)
		)
	)
)

(instance vBackgrnd of View
	(properties)

	(method (init)
		(= view (+ 700 local13))
		(= x (= cel (= loop 0)))
		(if local27
			(= y 0)
		else
			(= y 64896)
		)
		(self setPri: 253)
		(super init: &rest)
	)
)

(instance flickCard of Actor
	(properties)

	(method (init)
		(self
			view: 982
			setLoop: 2
			setCel: 0
			x: 0
			y: 100
			cycleSpeed: 5
			moveSpeed: 3
			setPri: 250
			setStep: 3 3
		)
		(super init:)
		(self show:)
	)
)

(instance pCobra of Prop
	(properties)

	(method (init)
		(self
			view: 983
			setLoop: 7
			setCel: 0
			x: (vHat x:)
			y: 0
			setPri: (+ (vHat priority:) 1)
		)
		(super init:)
		(self show:)
	)
)

(instance vShadow of View
	(properties
		view 983
		cel 2
	)

	(method (init)
		(self setPri: 1)
		(super init: &rest)
	)
)

(instance vHat of View
	(properties
		view 983
		cel 1
	)

	(method (init)
		(= view 983)
		(switch local32
			(1
				(= loop 0)
			)
			(2
				(= loop 1)
			)
			(3
				(= loop 2)
			)
			(4
				(= loop 3)
			)
			(5
				(= loop 4)
			)
		)
		(= cel 1)
		(= y (= x 0))
		(super init: &rest)
	)
)

(instance vFrontHat of View
	(properties
		view 983
	)

	(method (init)
		(= view 983)
		(switch local32
			(1
				(= loop 0)
			)
			(2
				(= loop 1)
			)
			(3
				(= loop 2)
			)
			(4
				(= loop 3)
			)
			(5
				(= loop 4)
			)
		)
		(= y (= x (= cel 0)))
		(super init: &rest)
	)
)

(instance vArm of View
	(properties
		view 982
		loop 1
	)

	(method (init param1 param2)
		(= x param1)
		(= y param2)
		(super init: &rest)
	)
)

(instance resignButton of TrackingView
	(properties
		x 532
		y 458
		priority 256
		view 660
		loop 3
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(event claimed: 1)
			((ScriptID 930 0) init: 9131 3 gCurRoomNum) ; yesNo
			(DisposeScript 930)
			(if global748
				(gCurRoom newRoom: 975) ; chooseGame
			)
		)
	)
)

(instance optionsButton of TrackingView
	(properties
		x 421
		y 458
		priority 256
		view 660
		loop 4
	)

	(method (handleEvent event &tmp temp0)
		(if (super handleEvent: event)
			(event claimed: 1)
			(= local1 1)
			(handleEventList delete: optionsButton resignButton)
			(localproc_4)
		)
	)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance statusWindow of InvisibleWindow
	(properties
		top 458
		right 420
		bottom 480
	)

	(method (init &tmp [temp0 2])
		(= priority 250)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 660 5 0 0 0 5 self)
		(localproc_1 0 12 5 1 {hits} statusWindow)
		(localproc_1 52 159 5 1 {left} statusWindow)
		(localproc_1 local29 255 5 1 {target} statusWindow)
	)
)

(instance flickOptionsWindow of InvisibleWindow
	(properties)

	(method (init &tmp [temp0 2])
		(self
			top: (/ (- gScreenHeight 256) 2)
			left: (/ (- gScreenWidth 228) 2)
			bottom: (+ (/ (- gScreenHeight 256) 2) 256)
			right: (+ (/ (- gScreenWidth 228) 2) 228)
		)
		(= priority 250)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 661 0 0 0 0 8 self)
	)
)

(instance flickingOptions of HoyleGameControls
	(properties)
)

(instance volumeSliderToo of ControlIcon
	(properties
		noun 10
		modNum 14
		nsLeft 47
		nsTop 51
		x 47
		y 51
		signal 128
		mainView 661
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (init &tmp temp0)
		(self setPri: 255)
		(if local43
			(= local43 0)
			(PlaySong play: 96)
			(gSong setLoop: -1)
		)
		(= local42 (gGame masterVolume:))
		(= temp0 14)
		(= y (+ (* (- 8 (gGame masterVolume:)) temp0) 51))
		(if (> (gGame masterVolume:) 7)
			(= y 51)
		)
		(if (< (gGame masterVolume:) 1)
			(= y 167)
		)
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(= temp3 14)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(self y: (+ (* (- 8 (gGame masterVolume:)) temp3) 51))
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 y:))
			(self y: (localproc_5 51 temp1 167))
			(if (!= temp2 (self y:))
				(gGame masterVolume: (- 8 (/ (- (self y:) 51) temp3)))
				(= local42 (gGame masterVolume:))
				(gSong setVol: (* 12 (gGame masterVolume:)))
				(= temp2 (self y:))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (== (temp0 type:) evMOUSERELEASE)
				(break)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)
)

(instance coffeeLevelSlider of ControlIcon
	(properties
		noun 22
		modNum 14
		nsLeft 157
		nsTop 51
		x 157
		y 51
		signal 128
		mainView 661
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (init &tmp temp0)
		(self setPri: 255)
		(= temp0 12)
		(= y (+ (* (- 9 global282) temp0) 51))
		(if (> global282 8)
			(= y 51)
		)
		(if (< global282 1)
			(= y 167)
		)
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(= temp3 12)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(self y: (+ (* (- 9 global282) temp3) 51))
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 y:))
			(self y: (localproc_5 51 temp1 167))
			(if (!= temp2 (self y:))
				(= global282 (- 9 (/ (- (self y:) 51) temp3)))
				(= temp2 (self y:))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (== (temp0 type:) evMOUSERELEASE)
				(break)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)
)

(instance handSpeedSlider of ControlIcon
	(properties
		noun 11
		modNum 14
		nsLeft 102
		nsTop 51
		x 102
		y 51
		signal 128
		mainView 661
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (init &tmp temp0)
		(self setPri: 255)
		(= temp0 11)
		(= y (+ (* (- 10 global283) temp0) 51))
		(if (> global283 9)
			(= y 51)
		)
		(if (< global283 1)
			(= y 167)
		)
		(super init: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(= temp3 11)
		(= temp2 temp1) ; UNINIT
		(self setPri: 255)
		(self y: (+ (* (- 10 global283) temp3) 51))
		(UpdateScreenItem self)
		(FrameOut)
		(repeat
			(= temp0 (Event new:))
			(temp0 localize: plane)
			(= temp1 (temp0 y:))
			(self y: (localproc_5 51 temp1 167))
			(if (!= temp2 (self y:))
				(= global283 (- 10 (/ (- (self y:) 51) temp3)))
				(= temp2 (self y:))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (== (temp0 type:) evMOUSERELEASE)
				(break)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
	)
)

(instance iconBackGMusic of ControlIcon
	(properties
		noun 12
		modNum 14
		nsLeft 19
		nsTop 188
		x 19
		y 188
		signal 387
		mainView 661
		mainLoop 7
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if global527
			(= mainCel 3)
		else
			(switch global919
				(1
					(= mainCel 0)
				)
				(0
					(= mainCel 2)
				)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(if (not global527)
			(switch global919
				(1
					(= mainCel 2)
					(= global919 0)
					(PlaySong play: 0)
					(gSong mute: 1)
				)
				(0
					(= mainCel 0)
					(= global919 1)
					(gSong mute: 0)
					(PlaySong play: 96)
				)
			)
			(self show:)
			(FrameOut)
			(UpdateScreenItem self)
		)
	)
)

(instance iconReset of ControlIcon
	(properties
		nsLeft 19
		nsTop 218
		x 19
		y 218
		signal 387
		mainView 661
		mainLoop 1
		highlightColor -1
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit)
		(DisableCursor)
		(= local47 1)
		(iconOkay doit:)
	)
)

(instance iconOkay of ControlIcon
	(properties
		noun 1
		modNum 14
		nsLeft 119
		nsTop 218
		x 119
		y 218
		signal 387
		mainView 661
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if global921
			(= y (= nsTop 173))
		)
		(super init: &rest)
	)

	(method (doit)
		(gGame panelObj: 0 panelSelector: 0)
		(if (== local42 0)
			(= local43 1)
			(gSong stop:)
		)
		(= local1 0)
		(handleEventList add: resignButton optionsButton)
		(= local38 global385)
		(= global385 local13)
		(gGame_opt doit: 3)
		(= global385 local38)
		(flkcard_opt doit: 3)
		(gGameControls hide:)
		(RedrawCast)
		(if local47
			(= local47 0)
			(flickCard init: y: 200)
			(UpdateScreenItem flickCard)
			(= local10 0)
			(= local27 0)
			(vBackgrnd init:)
			(roomScript changeState: 0)
		)
		(= gGameControls local3)
	)
)

(instance iconVolumeHot of ControlIcon
	(properties
		noun 10
		modNum 14
		nsLeft 27
		nsTop 19
		x 27
		y 19
		signal 387
		mainView 901
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (doit))
)

(instance iconSpeedHot of ControlIcon
	(properties
		noun 11
		modNum 14
		nsLeft 84
		nsTop 19
		x 84
		y 19
		signal 387
		mainView 901
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (doit))
)

(instance iconCoffeeLevelHot of ControlIcon
	(properties
		noun 22
		modNum 14
		nsLeft 130
		nsTop 19
		x 130
		y 19
		signal 387
		mainView 901
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (doit))
)

(instance animationSpeedCode of Code
	(properties)

	(method (doit param1)
		(return
			(if argc
				(= global283 param1)
			else
				global283
			)
		)
	)
)

(instance coffeeLevelCode of Code
	(properties)

	(method (doit param1)
		(return
			(if argc
				(= global282 param1)
			else
				global282
			)
		)
	)
)

(instance aBuzzBoard of Actor
	(properties
		view 1010
	)

	(method (init)
		(self setPri: 2 setCel: 0 cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance sCutBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(aBuzzBoard setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance aTorch of Actor
	(properties
		view 801
	)

	(method (init)
		(self setPri: 2 setCel: 0 cycleSpeed: 15)
		(super init: &rest)
	)
)

(instance sFlameTorch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(aTorch setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance aDust of Actor
	(properties
		view 803
	)

	(method (init)
		(self setPri: 2 setCel: 0 cycleSpeed: 12)
		(super init: &rest)
	)
)

(instance sDustCloud of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(gSound2 play: 3090)
				(aDust setCycle: End self)
			)
			(2
				(aDust hide:)
				(aDust setScript: sCarWreck)
			)
		)
	)
)

(instance aWreckage of Actor
	(properties
		view 804
	)

	(method (init)
		(self setPri: 2 setCel: 0 cycleSpeed: 10)
		(super init: &rest)
	)
)

(instance sCarWreck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(aWreckage init:)
				(aWreckage setCycle: End self)
			)
			(2
				(= local10 1)
				(aWreckage hide:)
				(self dispose:)
				(sDustCloud dispose:)
				(sFlickCard dispose:)
			)
		)
	)
)

