;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46790)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use n1111)
(use chap7Timer)
(use Str)
(use Print)
(use Feature)
(use Window)
(use System)

(public
	rm46790 0
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
)

(instance rm46790 of ScaryRoom
	(properties
		picture 8995
		stepSound 4
	)

	(method (cue)
		(if (not (gCurRoom script:))
			(= local5 1)
			(gCurRoom setScript: caughtScript)
		)
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(cond
			((IsFlag 135))
			((== gPrevRoomNum 900)
				((ScriptID 45951 2) open: 0) ; chase_dat
			)
			(else
				(= temp0 (Str newWith: 2 {15}))
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
				(temp0 dispose:)
			)
		)
		(southExit init: 12 approachVerbs: 0)
		(if (IsFlag 150)
			(global114 stop: 1)
		)
		(= temp3 0)
		(cond
			((IsFlag 135)
				(if (IsFlag 150)
					(= picture -1)
				)
				(if (== gPrevRoomNum 46910)
					(= picture 8890)
				)
				(= temp3 playBack)
			)
			((IsFlag 151)
				(= picture -1)
				(if (== gPrevRoomNum 900)
					((ScriptID 45951 2) seek: -2 2) ; chase_dat
					(= global179 0)
					(for ((= temp2 0)) (< temp2 3) ((++ temp2))
						(while (!= global179 99)
							(proc45951_3)
							((ScriptID 45951 2) seek: -4 1) ; chase_dat
						)
					)
					(proc45951_3)
					(proc45951_3)
					(= temp0 (Str newWith: 9 {\r\n15021614}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
					(= local7 1)
					(= temp3 entityEmerges)
				else
					(PlayVMD 16 1) ; ShowCursor
					(= temp3 dead)
				)
			)
			((IsFlag 150)
				(= picture -1)
				(if (== gPrevRoomNum 900)
					((ScriptID 45951 2) seek: -2 2) ; chase_dat
					(= global179 0)
					(for ((= temp2 0)) (< temp2 3) ((++ temp2))
						(while (!= global179 99)
							(proc45951_3)
							((ScriptID 45951 2) seek: -4 1) ; chase_dat
						)
					)
					(proc45951_3)
					(proc45951_3)
					(= temp0 (Str newWith: 3 {\r\n15}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
				)
				(proc1111_6 0 0)
				(= temp3 caughtScript)
			)
			((== gPrevRoomNum 46770)
				(= global165 14)
				(= temp3 enterRoom)
			)
			((== gPrevRoomNum 46910)
				(= picture 8890)
				(= temp3 fromMakeUp)
			)
			(else
				(switch global165
					(15
						(= picture -1)
						(= temp3 caughtScript)
					)
					(else
						(= global165 15)
						(= temp3 enterRoom)
					)
				)
			)
		)
		(if (IsFlag 390)
			(= picture -1)
		)
		(super init: &rest)
		(door init: 1)
		(secretPanel init: 4)
		(if temp3
			(self setScript: temp3)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if (not (OneOf newRoomNumber 45950 46780 40100 900 91)) ; saveRest
			(global114 play: 10671)
		)
		(if (not local9)
			(SetFlag 133)
		)
		(cond
			((== newRoomNumber 91) ; saveRest
				((ScriptID 45951 2) close:) ; chase_dat
			)
			((and (not local6) (not (IsFlag 135)))
				(= temp0 (Str newWith: 3 {99\r\n}))
				((ScriptID 45951 2) writeString: temp0 close:) ; chase_dat
				(temp0 dispose:)
			)
			((not (IsFlag 135))
				((ScriptID 45951 2) close:) ; chase_dat
			)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance playBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local4
					(= local4 0)
				else
					(proc45951_3)
				)
				(switch global179
					(1
						(self setScript: sHarriet self)
					)
					(2
						(self setScript: caughtScript self)
					)
					(3
						(self setScript: dead self)
					)
					(4
						(self setScript: sExitToPassage self)
					)
					(5
						(self setScript: sTheatreDoor self)
					)
					(6
						(self setScript: sToMakeup self)
					)
					(7
						(self setScript: hammerScript self)
					)
					(8
						(self setScript: pokerScript self)
					)
					(9
						(self setScript: shardScript self)
					)
					(10
						(self setScript: handScript self)
					)
					(11
						(self setScript: killSelf self)
					)
					(12
						(self setScript: enterRoom self)
					)
					(13
						(self setScript: fromMakeUp self)
					)
					(14
						(self setScript: giveSnowMan self)
					)
					(15
						(self setScript: caughtMakeUp self)
					)
					(16
						(self setScript: doChairScene self)
					)
					(17
						(self setScript: adrienneGetsAxed self)
					)
					(18
						(self setScript: ripFaceAtDoor self)
					)
					(19
						(self setScript: entityEmerges self)
					)
					(99
						(gCurRoom setScript: playNextRoom)
					)
				)
			)
			(1
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance playNextRoom of Script
	(properties)

	(method (changeState)
		(proc45951_3)
		(proc45951_3)
		(switch global179
			(1
				(gCurRoom newRoom: 45950)
			)
			(2
				(gCurRoom newRoom: 46030)
			)
			(3
				(gCurRoom newRoom: 46040)
			)
			(4
				(gCurRoom newRoom: 46050)
			)
			(5
				(gCurRoom newRoom: 46100)
			)
			(6
				(gCurRoom newRoom: 46290)
			)
			(7
				(gCurRoom newRoom: 46320)
			)
			(8
				(gCurRoom newRoom: 46340)
			)
			(9
				(gCurRoom newRoom: 46570)
			)
			(10
				(gCurRoom newRoom: 46620)
			)
			(11
				(gCurRoom newRoom: 46630)
			)
			(13
				(gCurRoom newRoom: 46720)
			)
			(14
				(gCurRoom newRoom: 46770)
			)
			(16
				(gCurRoom newRoom: 46910)
			)
			(17
				(gCurRoom newRoom: 46980)
			)
			(18
				(gCurRoom newRoom: 47020)
			)
			(19
				(gCurRoom newRoom: 47180)
			)
			(20
				(gCurRoom newRoom: 46780)
			)
		)
	)
)

(instance fromMakeUp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(= local4 1)
			(proc45951_3)
			(if (== global179 2)
				(cond
					((IsFlag 143)
						(= global159 46790)
					)
					((== gPrevRoomNum 46910)
						(= global159 46910)
					)
					(else
						(= global159 46630)
						(= local8 1)
					)
				)
				(SetFlag 150)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {13}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(door nsLeft: 20 nsTop: 28 nsRight: 46 nsBottom: 80)
					(proc1111_7 9250 0 0 0)
				)
				(1
					(if (IsFlag 135)
						(= local4 1)
						(proc45951_3)
						(if (!= global179 2)
							(self dispose:)
						)
					else
						(gGame handsOn:)
					)
				)
				(2
					(gGame handsOff:)
				)
				(3
					(cond
						((IsFlag 143)
							(= global159 46790)
						)
						((== gPrevRoomNum 46910)
							(= global159 46910)
						)
						(else
							(= global159 46630)
							(= local8 1)
						)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(SetFlag 150)
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {12}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if (IsFlag 133)
						(proc1111_7 9711 81 13 0)
					else
						(proc1111_7 9710 -24 -41 0)
					)
				)
				(1
					(gCurRoom drawPic: 8890)
					(cond
						((IsFlag 135)
							(self dispose:)
						)
						((IsFlag 133)
							(gCurRoom setScript: fromMakeUp)
						)
						(else
							(gCurRoom setScript: sHarriet)
						)
					)
				)
			)
		)
	)
)

(instance sHarriet of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(= local4 1)
			(proc45951_3)
			(if (== global179 2)
				(if (IsFlag 143)
					(= global159 46790)
				else
					(ClearFlag 133)
					(= global159 46630)
					(= local8 1)
				)
				(SetFlag 150)
			)
			(= global165 15)
			(= local3 1)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {01}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= global165 15)
					(= local3 1)
					(proc1111_7 6820 -12 -12 0)
				)
				(1
					(global114 pause:)
					(proc1111_7 6821 -40 -50 0)
					(gCurRoom drawPic: 8900)
				)
				(2
					(global114 endPause:)
					(proc1111_7 6822 76 25 0)
					(gCurRoom drawPic: 8890)
				)
				(3
					(gGDacSound number: 8070 play:)
					(if (IsFlag 63)
						(gCurRoom drawPic: 8930)
					else
						(gCurRoom drawPic: 8931)
					)
					(= seconds 5)
				)
				(4
					(gGDacSound stop:)
					(proc1111_7 6830 22 -24 0)
					(gCurRoom drawPic: 8920)
				)
				(5
					(if (IsFlag 135)
						(= local4 1)
						(proc45951_3)
						(if (!= global179 2)
							(self dispose:)
						)
					else
						(gGame handsOn:)
					)
				)
				(6
					(gGame handsOff:)
				)
				(7
					(if (IsFlag 143)
						(= global159 46790)
					else
						(ClearFlag 133)
						(= global159 46630)
						(= local8 1)
					)
					(SetFlag 150)
					(= local5 1)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance caughtScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(= temp0 (= temp1 0))
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 135))
					(= temp2 (Str newWith: 2 {02}))
					((ScriptID 45951 2) writeString: temp2) ; chase_dat
					(temp2 dispose:)
				)
				(if local2
					(proc1111_7 6830 44 45 0)
					(if local5
						(gCurRoom drawPic: 8890)
					)
				else
					(= cycles 2)
				)
			)
			(1
				(proc1111_6 0 0)
				(gCurRoom drawPic: -1)
				(if (IsFlag 135)
					(proc1111_6 0 0)
					(self dispose:)
				else
					(gCurRoom setScript: doChairScene)
				)
			)
		)
	)
)

(instance doChairScene of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			((ScriptID 45951 1) doit:) ; checkInv
			(if (IsFlag 143)
				(= global159 46790)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {16}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					((ScriptID 45951 1) doit:) ; checkInv
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1000.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1000 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(door dispose:)
					(secretPanel dispose:)
					(southExit dispose:)
					(PlayVMD 0 {1010.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(donFeature init: setHotspot: 4 3 10 27 11 25) ; Do, Move, invPoker, invCutter, invHammer, invXmasOrn
						(lever init: setHotspot: 4 3) ; Do, Move
						((ScriptID 26 2) ; myHotSet
							add:
								(donRect setRect: donFeature)
								(leverRect setRect: lever)
							activate:
						)
						(gGame handsOn:)
					else
						(= local4 1)
						(proc45951_3)
					)
					(proc26_0 1010 self 1)
				)
				(4
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(if (IsFlag 135)
						(if (!= global179 3)
							(self dispose:)
						else
							(= cycles 2)
						)
					else
						(= cycles 2)
					)
				)
				(5
					(PlayVMD 0 {1014.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1014 self)
				)
				(6
					(if (IsFlag 143)
						(= global159 46790)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance giveSnowMan of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(gEgo put: 17) ; invXmasOrn
			(SetFlag 410)
			(if (IsFlag 143)
				(= global159 46790)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local1 1)
					(gEgo put: 17) ; invXmasOrn
					(SetFlag 410)
					((ScriptID 26 2) dispose:) ; myHotSet
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {14}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
						(gGame handsOn:)
					)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1100.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1100 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(if (IsFlag 135)
						(= local4 1)
						(proc45951_3)
						(PlayVMD 0 {1110.vmd} 0) ; Open
						(proc26_0 1110 self 1)
					else
						(PlayVMD 0 {1110.vmd} 0) ; Open
						(donFeature
							nsLeft: 86
							nsTop: 11
							nsRight: 139
							nsBottom: 123
						)
						(lever
							x: 188
							y: 25
							nsLeft: 165
							nsTop: 12
							nsRight: 202
							nsBottom: 39
						)
						((ScriptID 26 2) ; myHotSet
							add:
								(donRect setRect: donFeature)
								(leverRect setRect: lever)
							activate:
						)
						(gGame handsOn:)
						(PlayVMD 16 1) ; ShowCursor
						(proc26_0 1110 self 1)
					)
				)
				(4
					(if (and (IsFlag 135) (!= global179 3))
						(self dispose:)
					else
						(= cycles 2)
					)
				)
				(5
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(PlayVMD 0 {1111.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1111 self)
				)
				(6
					(if (IsFlag 143)
						(= global159 46790)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance entityEmerges of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 151)
			(if (IsFlag 143)
				(= global159 46790)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {19}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(SetFlag 151)
					(donFeature dispose:)
					(lever dispose:)
					((ScriptID 26 2) dispose:) ; myHotSet
					(= cycles 2)
				)
				(1
					(if local7
						(self cue:)
					else
						(PlayVMD 0 {1200.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1200 self)
					)
				)
				(2
					(if local7
						(self cue:)
					else
						(= cycles 2)
					)
				)
				(3
					(if (IsFlag 135)
						(= local4 1)
						(proc45951_3)
						(if (!= global179 3)
							(SetFlag 151)
							(self dispose:)
						else
							(PlayVMD 0 {1205.vmd} 0) ; Open
							(proc26_0 1205 self 1)
						)
					else
						(PlayVMD 0 {1205.vmd} 0) ; Open
						(secretPanel
							nsLeft: 221
							nsTop: 53
							nsRight: 248
							nsBottom: 83
							init: 1
						)
						(southExit
							nsLeft: 54
							nsTop: 38
							nsRight: 117
							nsBottom: 91
							init: 1
						)
						(SetFlag 151)
						((ScriptID 26 2) ; myHotSet
							add:
								(panelRect setRect: secretPanel)
								(southRect setRect: southExit)
							activate:
						)
						(gGame handsOn:)
						(proc26_0 1205 self 1)
					)
				)
				(4
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(= cycles 2)
				)
				(5
					(PlayVMD 0 {9020.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 9020 self)
				)
				(6
					(if (IsFlag 143)
						(= global159 46790)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance dead of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(ClearFlag 390)
				(= local9 1)
				(if (== (gGame script:) (ScriptID 26 1)) ; movieScr
					((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				)
				(gGame handsOn:)
				(if global161
					(global161 owner: -1)
					(gEgo get: (gInventory indexOf: global161))
					(gUser message: (gUser dftMessage:))
					(= global161 0)
					(gGame setCursor: gNormalCursor 1)
					(gCurrentControl select: 3 gNormalCursor)
				)
				(gUser canControl: 0 input: 0)
				(if (not (IsFlag 135))
					(= temp1 (Str newWith: 2 {03}))
					((ScriptID 45951 2) writeString: temp1) ; chase_dat
					(temp1 dispose:)
				)
				(if (IsFlag 135)
					(ClearFlag 135)
					(SetFlag 121)
				)
				(global114 stop:)
				(gGDacSound stop:)
				(gUser canControl: 1 input: 1)
				(= temp0 (Str newWith: 15 {You have expired.}))
				(= local0
					(Print
						addTitle: temp0
						addText: {Would you like to try again?} 2 5
						addButton: 1 {Yes} 5 15
						addButton: 0 {Quit} 44 15
						addButton: 2 {Review} 82 15
						init:
					)
				)
				(temp0 dispose:)
				((ScriptID 0 11) priority: (- ((gCurRoom plane:) priority:) 1)) ; overlayPlane
				(UpdatePlane (ScriptID 0 11)) ; overlayPlane
				(switch local0
					(0
						(proc45951_5)
						(= local6 1)
						(gCurRoom newRoom: 91) ; saveRest
					)
					(1
						(gGame handsOff:)
						(= cycles 2)
					)
					(else
						(SetFlag 135)
						(ClearFlag 130)
						(ClearFlag 131)
						(ClearFlag 132)
						(ClearFlag 133)
						(ClearFlag 140)
						(ClearFlag 141)
						(ClearFlag 142)
						(ClearFlag 143)
						(ClearFlag 148)
						(ClearFlag 149)
						(ClearFlag 150)
						(ClearFlag 219)
						(ClearFlag 157)
						(ClearFlag 212)
						(ClearFlag 213)
						(ClearFlag 224)
						(ClearFlag 227)
						(ClearFlag 154)
						(ClearFlag 151)
						(ClearFlag 67)
						(ClearFlag 410)
						(ClearFlag 414)
						(ClearFlag 415)
						(if (gEgo has: 16) ; invSpellBook
							(gEgo put: 16) ; invSpellBook
						)
						(if (and (not (IsFlag 354)) (gEgo has: 15)) ; invBeads
							(gEgo put: 15) ; invBeads
						)
						(if (and (not (IsFlag 304)) (gEgo has: 19)) ; invCutter
							(gEgo put: 19) ; invCutter
						)
						(if (and (not (IsFlag 355)) (gEgo has: 17)) ; invXmasOrn
							(gEgo put: 17) ; invXmasOrn
						)
						(if (and (not (IsFlag 356)) (gEgo has: 14)) ; invCrucifix
							(gEgo put: 14) ; invCrucifix
						)
						((ScriptID 45951 2) close:) ; chase_dat
						(gCurRoom newRoom: 45950)
					)
				)
			)
			(1
				(if (and (== global159 47180) (gEgo has: 15)) ; invBeads
					(gEgo put: 15) ; invBeads
				)
				(if (== global159 47020)
					(= global159 46630)
					(= local8 1)
				)
				(cond
					((== global159 46340)
						(= global159 46040)
						(= global179 0)
						(while (!= global179 99)
							((ScriptID 45951 2) seek: -4 1) ; chase_dat
							(proc45951_3)
						)
						((ScriptID 45951 2) seek: 1 1) ; chase_dat
						(gCurRoom newRoom: global159)
					)
					((!= global159 gCurRoomNum)
						(if (OneOf global159 46780 46910)
							(ClearFlag 151)
						)
						(if (== global159 46100)
							(= local8 1)
							(ClearFlag 140)
						)
						(if local1
							(gEgo get: 17) ; invXmasOrn
						)
						(if local8
							(while (!= global179 99)
								((ScriptID 45951 2) seek: -4 1) ; chase_dat
								(proc45951_3)
							)
							((ScriptID 45951 2) seek: 1 1) ; chase_dat
						)
						(SetFlag 150)
						(if (not (OneOf global159 45950 46780 40100))
							(global114 play: 10671)
						)
						(if (not (OneOf global159 46790 40100))
							(ClearFlag 151)
						)
						(gCurRoom newRoom: global159)
					)
					((IsFlag 151)
						(= global108 46790)
						(= local6 1)
						(gCurRoom newRoom: 900)
					)
					((== global159 gCurRoomNum)
						(if (IsFlag 143)
							(gEgo get: 17) ; invXmasOrn
						)
						(= global108 46790)
						(= local6 1)
						(gCurRoom newRoom: 900)
					)
					((not (IsFlag 143))
						(= global159 gPrevRoomNum)
						(if (not (OneOf global159 45950 46780 40100))
							(global114 play: 10761)
						)
						(gCurRoom newRoom: global159)
					)
					(else
						(ClearFlag 151)
						(gEgo get: 17) ; invXmasOrn
						(= global108 46790)
						(if (not (OneOf global159 45950 46780 40100))
							(global114 play: 10761)
						)
						(= local6 1)
						(gCurRoom newRoom: 900)
					)
				)
			)
		)
	)
)

(instance sExitToPassage of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(ClearFlag 141)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {04}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if local3
						(proc1111_7 6824 -73 -22 0)
						(gCurRoom drawPic: 8890)
					else
						(= cycles 2)
					)
				)
				(1
					(proc1111_7 9712 -8 -44 0 -1 1)
					(gCurRoom drawPic: 8995)
				)
				(2
					(ClearFlag 141)
					((ScriptID 26 2) dispose:) ; myHotSet
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46770)
					)
				)
			)
		)
	)
)

(instance sTheatreDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(cond
				((IsFlag 143)
					(= global159 46790)
				)
				((== gPrevRoomNum 46910)
					(= global159 46910)
				)
				(else
					(= global159 gPrevRoomNum)
				)
			)
			(SetFlag 150)
			(= local5 1)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {05}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if local3
						(proc1111_7 6826 -17 14 0)
						(gCurRoom drawPic: 8890)
					else
						(self cue:)
					)
				)
				(1
					(proc1111_7 9720 -12 -44 0 -1 1)
					(gCurRoom drawPic: 8210)
				)
				(2
					(cond
						((IsFlag 143)
							(= global159 46790)
						)
						((== gPrevRoomNum 46910)
							(= global159 46910)
						)
						(else
							(= global159 gPrevRoomNum)
						)
					)
					(SetFlag 150)
					(= local5 1)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance sToMakeup of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {06}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(if local3
						(proc1111_7 6825 -31 0 0 -1 1)
						(gCurRoom drawPic: 8890)
					else
						(= cycles 2)
					)
				)
				(1
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 46910)
					)
				)
			)
		)
	)
)

(instance hammerScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(if (IsFlag 143)
				(= global159 46790)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {07}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= cycles 2)
				)
				(1
					(if local1
						(PlayVMD 0 {1130.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1130 self)
					else
						(PlayVMD 0 {1030.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1030 self)
					)
				)
				(2
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(if (IsFlag 143)
						(= global159 46790)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance adrienneGetsAxed of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(if (IsFlag 143)
				(= global159 46790)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {17}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(if (IsFlag 143)
						(= global159 46790)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance pokerScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(if (IsFlag 143)
				(= global159 46790)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {08}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= cycles 2)
				)
				(1
					(if local1
						(PlayVMD 0 {1120.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1120 self)
					else
						(PlayVMD 0 {1020.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1020 self)
					)
				)
				(2
					(if (IsFlag 143)
						(= global159 46790)
					)
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance shardScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(if (IsFlag 143)
				(= global159 46790)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {09}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= cycles 2)
				)
				(1
					(if local1
						(PlayVMD 0 {1140.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1140 self)
					else
						(PlayVMD 0 {1040.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1040 self)
					)
				)
				(2
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(if (IsFlag 143)
						(= global159 46790)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance handScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(if (IsFlag 143)
				(= global159 46790)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {10}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= cycles 2)
				)
				(1
					(if local1
						(PlayVMD 0 {1150.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1150 self)
					else
						(PlayVMD 0 {1050.vmd} 0) ; Open
						(PlayVMD 16 0) ; ShowCursor
						(proc26_0 1050 self)
					)
				)
				(2
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(if (IsFlag 143)
						(= global159 46790)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance killSelf of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(if (IsFlag 143)
				(= global159 46790)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {11}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1060.vmd} 0) ; Open
					(proc26_0 1060 self)
				)
				(2
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(if (IsFlag 143)
						(= global159 46790)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance caughtMakeUp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(= global159 46630)
			(= local8 1)
			(SetFlag 408)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {15}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(proc1111_7 9731 -12 -46 0)
					(gCurRoom drawPic: 27250)
				)
				(1
					(= local5 1)
					(= global159 46630)
					(= local8 1)
					(SetFlag 408)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: caughtScript)
					)
				)
			)
		)
	)
)

(instance ripFaceAtDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(cond
				((IsFlag 143)
					(= global159 46790)
				)
				((== gPrevRoomNum 46910)
					(= global159 46910)
				)
				(else
					(= global159 gPrevRoomNum)
				)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					((ScriptID 26 2) dispose:) ; myHotSet
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {18}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1400.vmd} 0) ; Open
					(PlayVMD 16 0) ; ShowCursor
					(proc26_0 1400 self)
				)
				(2
					(cond
						((IsFlag 143)
							(= global159 46790)
						)
						((== gPrevRoomNum 46910)
							(= global159 46910)
						)
						((!= gPrevRoomNum 45950)
							(= global159 gPrevRoomNum)
						)
						(else
							(= global159 gPrevRoomNum)
						)
					)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: dead)
					)
				)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 92
		nsTop 53
		nsRight 124
		nsBottom 89
		sightAngle 40
		approachX 171
		approachY 89
		x 160
		y 65
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (gEgo has: 17) ; invXmasOrn
				(gCurRoom setScript: caughtMakeUp)
			else
				(gCurRoom setScript: sToMakeup)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance secretPanel of ExitFeature
	(properties
		nsLeft 0
		nsTop 5
		nsRight 28
		nsBottom 125
		approachX 277
		approachY 54
		x 277
		y 54
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(if (IsFlag 151)
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				((ScriptID 26 2) dispose:) ; myHotSet
				(gCurRoom newRoom: 46780)
			else
				(gCurRoom setScript: sExitToPassage)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance donFeature of Feature
	(properties
		nsLeft 102
		nsTop 39
		nsRight 179
		nsBottom 124
		y 130
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: handScript)
			)
			(27 ; invCutter
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: shardScript)
			)
			(11 ; invHammer
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: hammerScript)
			)
			(10 ; invPoker
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: pokerScript)
			)
			(25 ; invXmasOrn
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: giveSnowMan)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lever of Feature
	(properties
		nsLeft 165
		nsTop 12
		nsRight 202
		nsBottom 39
		x 188
		y 25
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			((ScriptID 26 1) caller: 0 dispose:) ; movieScr
			(if local1
				(gCurRoom setScript: entityEmerges)
			else
				(gCurRoom setScript: killSelf)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 4
		nsTop 100
		nsRight 315
		nsBottom 134
		appYOffset 20
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			((ScriptID 26 1) caller: 0 dispose:) ; movieScr
			(if (IsFlag 151)
				(gCurRoom setScript: ripFaceAtDoor)
			else
				(gCurRoom setScript: sTheatreDoor)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance donRect of HotRectangle
	(properties)
)

(instance panelRect of HotRectangle
	(properties)
)

(instance leverRect of HotRectangle
	(properties)
)

(instance doorRect of HotRectangle ; UNUSED
	(properties)
)

(instance southRect of HotRectangle
	(properties)
)

