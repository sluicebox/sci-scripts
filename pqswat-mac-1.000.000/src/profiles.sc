;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Button)
(use PQSlider)
(use DSelector)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	profiles 0
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
)

(procedure (localproc_0 param1 param2 param3 param4 param5 &tmp temp0)
	(if (not (Message msgGET param4 param1 param2 param3 1))
		(return)
	)
	(= temp0 (Str new: 400))
	(Message msgGET param4 param1 param2 param3 1 (temp0 data:))
	(param5 copy: (temp0 data:))
	(while (Message msgNEXT (temp0 data:))
		(param5 cat: (temp0 data:))
	)
	(temp0 dispose:)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp1 (Str new: 50))
	(switch local1
		(0
			(= temp2 5)
		)
		(1
			(= temp2 6)
		)
		(2
			(= temp2 3)
		)
		(3
			(= temp2 4)
		)
		(4
			(= temp2 4)
		)
	)
	(if (= temp3 ((profileItems at: local1) noun:))
		(for ((= temp0 1)) (<= temp0 temp2) ((++ temp0))
			(localproc_0 temp3 21 temp0 130 temp1)
			(param1 setText: temp1)
		)
	)
	(temp1 dispose:)
	(param1 textList:)
)

(procedure (localproc_2 param1 param2 param3 &tmp temp0 temp1 temp2)
	(= local0 param1)
	(cond
		((and gAutoRobot (== local5 param1)))
		((and local4 (== local5 param1))
			(proc4_6 param1 param2 param3 local3 0 -1 1)
		)
		((and (== (gCurRoom script:) sFastForward) (== param1 local5))
			(= temp0 (IntArray new: 4))
			(= temp1 (- (Robot 2 (temp0 data:)) 1)) ; FrameInfo
			(= temp2 (- (Robot 11) 1)) ; FrameNum
			(= local5 global128)
			(proc4_5)
			(sFastForward dispose:)
			(if (< temp2 temp1)
				(proc4_6 param1 param2 param3 temp2 0 -1 1)
			else
				(WalkieTalkie showFrame: local5 temp1 69 67)
				(= global128 local5)
			)
		)
		((and (== (gCurRoom script:) sRewind) (== param1 local5))
			(= temp2 (- (Robot 11) 1)) ; FrameNum
			(= local5 global128)
			(proc4_5)
			(sRewind dispose:)
			(if (> temp2 6)
				(proc4_6 param1 param2 param3 temp2 0 -1 1)
			else
				(WalkieTalkie showFrame: local5 6 69 67)
				(= global128 local5)
			)
		)
		(else
			(cond
				((== (gCurRoom script:) sFastForward)
					(sFastForward dispose:)
					(proc4_5)
				)
				((== (gCurRoom script:) sRewind)
					(sRewind dispose:)
					(proc4_5)
				)
			)
			(proc4_6 param1 param2 param3 0 0 -1 1)
			(= local5 global128)
		)
	)
)

(procedure (localproc_3 param1)
	(cond
		((not (playButn active:))
			(playButn setActive: 1)
		)
		((not (rewindButn active:))
			(rewindButn setActive: 1)
		)
		((not (forwardButn active:))
			(forwardButn setActive: 1)
		)
		((not (stopButn active:))
			(stopButn setActive: 1)
		)
	)
	(param1 setActive: 0)
)

(class ProfileButton of Button
	(properties)

	(method (trace param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp1 0)
		(= temp7 0)
		(= temp6 (= temp8 0))
		(while 1
			(= temp5 temp1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(param1 type: 0 message: 0 modifiers: 0 y: 0 x: 0 plane: 0)
			(GetEvent evMOUSE param1)
			(param1 localize: plane)
			(if (& (param1 type:) $0002)
				(break)
			else
				(= temp2 view)
				(= temp3 loop)
				(= temp4 cel)
				(if (self onMe: param1)
					(self view: downView loop: downLoop cel: downCel)
					(= temp1 1)
					(if
						(and
							doVerbCalled
							(or
								(not temp8)
								(and
									(< temp6 60)
									(= temp6 (Abs (- temp8 gGameTime)))
									0
								)
								(and (>= temp6 60) (<= (-- temp7) 0))
							)
						)
						(= temp8 gGameTime)
						(= temp7 20)
						(self doVerb: 29)
					)
				else
					(self view: upView loop: upLoop cel: upCel)
					(= temp1 0)
				)
			)
			(if (or (!= temp2 view) (!= temp3 loop) (!= temp4 cel))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (!= temp5 temp1)
				(= temp5 temp1)
				(if temp1
					(buttonSound number: 1 loop: 1 play:)
					(continue)
				)
			else
				(continue)
			)
			(buttonSound number: 2 loop: 1 play:)
		)
		(if (and temp1 (not doVerbCalled))
			(self doVerb: 29)
		)
		(if active
			(self view: upView loop: upLoop cel: upCel)
			(buttonSound number: 2 loop: 1 play:)
			(UpdateScreenItem self)
			(FrameOut)
		)
		(param1 claimed: 1)
	)
)

(instance buttonSound of Sound
	(properties)
)

(instance profiles of PQRoom
	(properties
		picture 130
		infoRoomSignal 1
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 13000)
		(Load rsAUDIO 13001)
		(prevButn init:)
		(interviewButn init:)
		(nextButn init:)
		(door init:)
		(rewindButn init: setActive: 0)
		(playButn init: setActive: 0)
		(stopButn init: setActive: 0)
		(forwardButn init: setActive: 0)
		(scrollUpButn init: setActive: 0)
		(scrollDownButn init: setActive: 0)
		(sliderObj init: active: 0)
		(profileItems
			addToFront: sgtAlbanese sgtLamprey sgtWaldron sgtBrannon sgtPreciado
			eachElementDo: #init
		)
		((profileItems at: local1) show:)
		(gBackMusic number: 13000 loop: -1 play:)
		(gGame handsOn:)
	)

	(method (dispose)
		(profileItems release: dispose:)
		(proc4_5)
		(blank dispose:)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(gBackMusic fade: 0 2 21 1)
		(if (and (OneOf newRoomNumber 6000 15) (door cel:)) ; mainMenu
			(blank init:)
			(proc4_5)
			(gCurRoom setScript: closeDoor 0 newRoomNumber)
		else
			(if (and (OneOf newRoomNumber 6000 15) (== gNumCD 2)) ; mainMenu
				(gGame getDisc: 1 1)
			)
			(blank init:)
			(proc4_5)
			(Palette 2 0 254 100) ; PalIntensity
			(FrameOut)
			(super newRoom: newRoomNumber)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: 13001 loop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(localproc_1 ourSelector)
				(rewindButn setActive: 1)
				(playButn setActive: 1)
				(stopButn setActive: 1)
				(forwardButn setActive: 1)
				(scrollUpButn setActive: 1)
				(scrollDownButn setActive: 1)
				(ourSelector init: updatePlane: draw:)
				(sliderObj setup: active: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: 13001 loop: 1 play:)
				(rewindButn setActive: 0)
				(playButn setActive: 0)
				(stopButn setActive: 0)
				(forwardButn setActive: 0)
				(scrollUpButn setActive: 0)
				(scrollDownButn setActive: 0)
				(ourSelector dispose:)
				(sliderObj y: (sliderObj topY:) active: 0 setup:)
				(door setCycle: Beg self)
				(if local13
					(local13 dispose:)
					(= local13 0)
				)
			)
			(1
				(door cel: 0)
				(if register
					(gCurRoom newRoom: register)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFastForward of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local4 0)
				(= temp0 (IntArray new: 4))
				(= local7 (- (Robot 2 (temp0 data:)) 1)) ; FrameInfo
				(temp0 dispose:)
				(= local6 (- (Robot 11) 1)) ; FrameNum
				(self cue:)
			)
			(1
				(+= local6 10)
				(proc4_5)
				(if (< local6 local7)
					(WalkieTalkie showFrame: local5 local6 69 67)
					(= global128 local5)
				else
					(WalkieTalkie showFrame: local5 local7 69 67)
					(forwardButn setActive: 1)
					(= global128 local5)
					(self dispose:)
				)
				(= cycles 1)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance sRewind of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 (- (Robot 11) 1)) ; FrameNum
				(= local4 0)
				(self cue:)
			)
			(1
				(-= local6 10)
				(proc4_5)
				(if (> local6 6)
					(WalkieTalkie showFrame: local5 local6 69 67)
					(= global128 local5)
				else
					(WalkieTalkie showFrame: local5 6 69 67)
					(rewindButn setActive: 1)
					(= global128 local5)
					(self dispose:)
				)
				(= cycles 1)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance ourSelector of DSelector
	(properties
		font 20071
		length 21
		width 234
		fore 28
		back 0
		leading 15
	)

	(method (init)
		(= upButton (= downButton -1))
		(gMouseDownHandler add: self)
		(= x (= y (= nsLeft (= nsTop (= nsRight (= nsBottom 0))))))
		(self current: 0 setSize: 1 moveTo: 306 76)
		(super init: gCast &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (draw)
		(super draw: &rest)
		(sliderObj dataCur: current)
		(UpdateScreenItem sliderObj)
		(sliderObj positionThumb:)
	)

	(method (setNSRect param1 param2 param3)
		(= nsLeft param1)
		(= nsTop param2)
		(= nsRight param3)
		(= nsBottom 188)
		(= length (/ nsBottom textHeight))
	)
)

(instance door of Prop
	(properties
		x 300
		y 60
		priority 480
		fixPriority 1
		view 1300
	)
)

(instance blank of Prop
	(properties
		x 69
		y 67
		priority 480
		fixPriority 1
		view 1338
	)
)

(instance prevButn of ProfileButton
	(properties
		x 56
		y 266
		view 1300
		loop 1
	)

	(method (doVerb &tmp temp0)
		(if (door cel:)
			(gCurRoom setScript: closeDoor 0 0)
			(interviewButn setActive:)
		)
		((profileItems at: local1) hide:)
		(if (< (-- local1) 0)
			(= local1 (- (profileItems size:) 1))
		)
		(if (or gAutoRobot (Robot 6)) ; Exists
			(proc4_5)
		)
		((profileItems at: local1) show:)
	)
)

(instance interviewButn of ProfileButton
	(properties
		x 80
		y 268
		view 1300
		loop 1
		cel 2
		upCel 2
		downCel 3
	)

	(method (doVerb)
		(self setActive: 0)
		(if (and (> local1 1) (!= gNumCD 2))
			(gGame getDisc: 2 1)
		)
		(Palette 2 0 254 100) ; PalIntensity
		(FrameOut)
		(gCurRoom setScript: openDoor)
	)
)

(instance nextButn of ProfileButton
	(properties
		x 208
		y 266
		view 1300
		loop 1
		cel 4
		upCel 4
		downCel 5
	)

	(method (doVerb)
		(if (door cel:)
			(gCurRoom setScript: closeDoor 0 0)
			(interviewButn setActive:)
		)
		((profileItems at: local1) hide:)
		(if (> (++ local1) (- (profileItems size:) 1))
			(= local1 0)
		)
		(if (or gAutoRobot (Robot 6)) ; Exists
			(proc4_5)
		)
		((profileItems at: local1) show:)
	)
)

(instance playButn of ProfileButton
	(properties
		x 368
		y 269
		view 1300
		loop 2
		cel 2
		upCel 2
		downCel 3
	)

	(method (cue param1)
		(= local11 0)
		(if (OneOf (gGame printLang:) 49 33)
			(= local11 1)
		)
		(if local11
			(if local13
				(local13 dispose:)
				(= local13 0)
			)
			(if (!= -1 param1)
				(= local9
					(cond
						((OneOf local0 1311 1312 1313 1314 1315 1316) 2)
						((OneOf local0 1317 1318 1320) 5)
						((OneOf local0 1323 1324 1325 1326) 4)
						((OneOf local0 1327 1330 1331 1332) 1)
						((OneOf local0 1333 1334 1335 1336 1337) 6)
					)
				)
				(= local10
					(cond
						((OneOf local0 1311 1317 1323 1330 1333) 1)
						((OneOf local0 1312 1318 1324 1327 1336) 2)
						((OneOf local0 1314 1320 1325 1331 1335) 3)
						((OneOf local0 1313 1326 1332 1337) 4)
						((OneOf local0 1315 1334) 5)
						((OneOf local0 1316) 6)
					)
				)
				(= local12 (Print new:))
				(local12
					fore: 255
					x: 42
					y: 312
					width: 545
					font: 20071
					modeless: 2
					addText: local9 187 local10 param1 0 0 130
					init:
				)
				(= local13 (local12 dialog:))
				(gPrints delete: local12)
			)
		)
		(super cue: param1 &rest)
	)

	(method (doVerb)
		(localproc_3 self)
		(switch local1
			(0
				(switch (ourSelector current:)
					(0
						(localproc_2 1333 69 67)
					)
					(1
						(localproc_2 1336 69 67)
					)
					(2
						(localproc_2 1335 69 67)
					)
					(3
						(localproc_2 1337 69 67)
					)
					(4
						(localproc_2 1334 69 67)
					)
				)
			)
			(1
				(switch (ourSelector current:)
					(0
						(localproc_2 1311 69 67)
					)
					(1
						(localproc_2 1312 69 67)
					)
					(2
						(localproc_2 1314 69 67)
					)
					(3
						(localproc_2 1313 69 67)
					)
					(4
						(localproc_2 1315 69 67)
					)
					(5
						(localproc_2 1316 69 67)
					)
				)
			)
			(2
				(switch (ourSelector current:)
					(0
						(localproc_2 1317 69 67)
					)
					(1
						(localproc_2 1318 69 67)
					)
					(2
						(localproc_2 1320 69 67)
					)
				)
			)
			(3
				(switch (ourSelector current:)
					(0
						(localproc_2 1330 69 67)
					)
					(1
						(localproc_2 1327 69 67)
					)
					(2
						(localproc_2 1331 69 67)
					)
					(3
						(localproc_2 1332 69 67)
					)
				)
			)
			(4
				(switch (ourSelector current:)
					(0
						(localproc_2 1323 69 67)
					)
					(1
						(localproc_2 1324 69 67)
					)
					(2
						(localproc_2 1325 69 67)
					)
					(3
						(localproc_2 1326 69 67)
					)
				)
			)
		)
		(= local4 0)
	)
)

(instance stopButn of ProfileButton
	(properties
		x 436
		y 269
		view 1300
		loop 2
		cel 4
		upCel 4
		downCel 5
	)

	(method (doVerb &tmp temp0 temp1)
		(playButn setActive: 1)
		(cond
			((== (gCurRoom script:) sFastForward)
				(localproc_3 self)
				(= temp1 (IntArray new: 4))
				(= temp0 (- (Robot 2 (temp1 data:)) 1)) ; FrameInfo
				(= local3 (- (Robot 11) 1)) ; FrameNum
				(= local5 global128)
				(proc4_5)
				(sFastForward dispose:)
				(if (< local3 temp0)
					(if local13
						(local13 dispose:)
						(= local13 0)
					)
					(= local4 1)
					(WalkieTalkie showFrame: local5 local3 69 67)
				else
					(= local4 0)
					(stopButn setActive: 1)
					(WalkieTalkie showFrame: local5 temp0 69 67)
				)
				(= global128 local5)
			)
			((== (gCurRoom script:) sRewind)
				(localproc_3 self)
				(= local3 (- (Robot 11) 1)) ; FrameNum
				(= local5 global128)
				(proc4_5)
				(sRewind dispose:)
				(if (> local3 6)
					(if local13
						(local13 dispose:)
						(= local13 0)
					)
					(= local4 1)
					(WalkieTalkie showFrame: local5 local3 69 67)
				else
					(= local4 0)
					(stopButn setActive: 1)
					(WalkieTalkie showFrame: local5 6 69 67)
				)
				(= global128 local5)
			)
			(gAutoRobot
				(localproc_3 self)
				(= local3 (- (Robot 11) 1)) ; FrameNum
				(= local5 global128)
				(if local13
					(local13 dispose:)
					(= local13 0)
				)
				(= local4 1)
				(proc4_5)
				(WalkieTalkie showFrame: local5 local3 69 67)
				(= global128 local5)
			)
			((self active:)
				(self setActive: 1)
			)
		)
	)
)

(instance forwardButn of ProfileButton
	(properties
		x 500
		y 269
		view 1300
		loop 2
		cel 6
		upCel 6
		downCel 7
	)

	(method (doVerb)
		(localproc_3 self)
		(if (or gAutoRobot (Robot 6)) ; Exists
			(gCurRoom setScript: sFastForward)
		)
	)
)

(instance rewindButn of ProfileButton
	(properties
		x 330
		y 269
		view 1300
		loop 2
	)

	(method (doVerb)
		(localproc_3 self)
		(if (or gAutoRobot (Robot 6)) ; Exists
			(gCurRoom setScript: sRewind)
		)
	)
)

(instance sliderObj of PQSlider
	(properties
		x 543
		view 1300
		loop 4
		topY 87
		bottomY 238
	)

	(method (setup)
		(super setup:)
		(if (ourSelector textList:)
			(= dataBottom (Max 0 (- ((ourSelector textList:) size:) 1)))
		)
		(= dataStep 1)
	)

	(method (updateData &tmp temp0 temp1)
		(super updateData: &rest)
		(ourSelector current: dataCur)
		(= temp1 (ourSelector textList:))
		(= temp0 (- (- (temp1 size:) 1) (ourSelector length:)))
		(ourSelector
			first:
				(if (< temp0 (ourSelector current:) (- (temp1 size:) 1))
					temp0
				else
					(ourSelector current:)
				)
		)
		(ourSelector draw:)
	)
)

(instance scrollUpButn of ProfileButton
	(properties
		x 546
		y 69
		view 1300
		loop 3
		cel 2
		upCel 2
		downCel 3
	)

	(method (doVerb)
		(ourSelector scrollUp: 1)
	)
)

(instance scrollDownButn of ProfileButton
	(properties
		x 546
		y 249
		view 1300
		loop 3
	)

	(method (doVerb)
		(ourSelector scrollDown: 1)
	)
)

(instance profileItems of Set
	(properties)
)

(instance profileItemName of View
	(properties
		x 64
		y 230
	)
)

(class ProfileItem of View
	(properties
		x 70
		y 67
		nameLoop 1
		nameCel 0
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (onMe)
		(return 0)
	)

	(method (display param1)
		(if (or (not argc) param1)
			(self show:)
		else
			(self hide:)
		)
	)

	(method (show &tmp temp0)
		(profileItemName view: view loop: nameLoop cel: nameCel)
		(if (not local2)
			(= local2 1)
			(profileItemName init:)
		)
		(UpdateScreenItem profileItemName)
		(super show: &rest)
	)
)

(instance sgtAlbanese of ProfileItem
	(properties
		noun 6
		view 1310
	)
)

(instance sgtLamprey of ProfileItem
	(properties
		noun 2
		view 1304
	)
)

(instance sgtWaldron of ProfileItem
	(properties
		noun 5
		view 1308
	)
)

(instance sgtBrannon of ProfileItem
	(properties
		noun 1
		view 1306
	)
)

(instance sgtPreciado of ProfileItem
	(properties
		noun 4
		view 1302
	)
)

(instance showSub of Script ; UNUSED
	(properties)

	(method (cue param1)
		(if (== 1 param1)
			(SetDebug)
		)
		(super cue: &rest)
	)
)

(instance thisDialog of Dialog ; UNUSED
	(properties)

	(method (dispose)
		(= local13 0)
		(super dispose: &rest)
	)
)

