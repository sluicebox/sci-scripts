;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40100)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use chap7Timer)
(use Str)
(use Print)
(use Feature)
(use Window)
(use System)

(public
	rm40100 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm40100 of ScaryRoom
	(properties)

	(method (init &tmp temp0)
		(if (not (IsFlag 143))
			(= local5 1)
		)
		(super init: &rest)
		(= temp0 (Str newWith: 2 {12}))
		(cond
			((IsFlag 135))
			((== gPrevRoomNum 900)
				(proc45951_4)
				((ScriptID 45951 2) writeString: temp0) ; chase_dat
			)
			(else
				((ScriptID 45951 2) open: 0 writeString: temp0) ; chase_dat
			)
		)
		(temp0 dispose:)
		(if (IsFlag 135)
			(gCurRoom setScript: playBack)
		else
			(gCurRoom setScript: enterRoom)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(cond
			((== newRoomNumber 91) ; saveRest
				((ScriptID 45951 2) close:) ; chase_dat
			)
			((not (IsFlag 135))
				(= temp0 (Str newWith: 3 {99\0d\n}))
				((ScriptID 45951 2) writeString: temp0 close:) ; chase_dat
				(temp0 dispose:)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(gGame handsOff:)
		(gCurRoom setScript: killedScr)
	)
)

(instance playBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local6
					(= local6 0)
				else
					(proc45951_3)
				)
				(switch global179
					(1
						(self setScript: enterRoom self)
					)
					(2
						(self setScript: barDoor self)
					)
					(3
						(self setScript: downTheStairs self)
					)
					(4
						(self setScript: getStone self)
					)
					(5
						(self setScript: putBook self)
					)
					(6
						(self setScript: stoneOnBook self)
					)
					(7
						(self setScript: cutSelf self)
					)
					(8
						(self setScript: crossOnBook self)
					)
					(9
						(self setScript: beadsOnBook self)
					)
					(10
						(self setScript: killedScr self)
					)
					(11
						(self setScript: downStairsOops self)
					)
					(12
						(self setScript: unbarDoor self)
					)
					(13
						(self setScript: broochScript self)
					)
					(14
						(self setScript: openDoor self)
					)
					(15
						(self setScript: backUpStairs self)
					)
					(16
						(self setScript: toTheAltar self)
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
		(gCurRoom newRoom: 47480)
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
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {01}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1910.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(doorBar init: setHotspot: 4 3) ; Do, Move
						(stairs
							nsLeft: 5
							nsRight: 315
							nsTop: 100
							nsBottom: 130
							init: 12
						)
						(door init: 1)
						((ScriptID 26 2) ; myHotSet
							add:
								(barRect setRect: doorBar)
								(stairRect setRect: stairs)
								(doorRect setRect: door)
							activate:
						)
						(gGame handsOn:)
					)
					(proc26_0 1910 self 1)
				)
				(2
					(= cycles 2)
				)
				(3
					(gGame handsOff:)
					(if (IsFlag 135)
						(= local6 1)
						(proc45951_3)
						(if (!= global179 10)
							((ScriptID 26 2) dispose:) ; myHotSet
							(self dispose:)
						else
							(PlayVMD 0 {9080.vmd} 0) ; Open
							(proc26_0 9080 self)
						)
					else
						(PlayVMD 0 {9080.vmd} 0) ; Open
						(proc26_0 9080 self)
					)
				)
				(4
					((ScriptID 26 2) dispose:) ; myHotSet
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance downStairsOops of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
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
					((ScriptID 26 2) dispose:) ; myHotSet
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1930.vmd} 0) ; Open
					(proc26_0 1930 self)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 212)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {14}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					((ScriptID 26 2) dispose:) ; myHotSet
					(SetFlag 212)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {1920.vmd} 0) ; Open
					(proc26_0 1920 self)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance barDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 212)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {02}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					((ScriptID 26 2) dispose:) ; myHotSet
					(SetFlag 212)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2000.vmd} 0) ; Open
					(proc26_0 2000 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(PlayVMD 0 {2010.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(stairs
							nsLeft: 5
							nsRight: 315
							nsTop: 100
							nsBottom: 130
							init: 12
						)
						(doorBar
							nsLeft: 106
							nsTop: 51
							nsRight: 187
							nsBottom: 68
							y: 130
						)
						((ScriptID 26 2) ; myHotSet
							add:
								(stairRect setRect: stairs)
								(barRect setRect: doorBar)
							activate:
						)
						(gGame handsOn:)
					)
					(proc26_0 2010 self 1)
				)
				(4
					(= cycles 2)
				)
				(5
					(gGame handsOff:)
					(if (IsFlag 135)
						(= local6 1)
						(proc45951_3)
						(if (!= global179 10)
							((ScriptID 26 2) dispose:) ; myHotSet
							(self dispose:)
						else
							(PlayVMD 0 {9080.vmd} 0) ; Open
							(proc26_0 9080 self)
						)
					else
						(PlayVMD 0 {9080.vmd} 0) ; Open
						(proc26_0 9080 self)
					)
				)
				(6
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance unbarDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {12}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					((ScriptID 26 2) dispose:) ; myHotSet
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2020.vmd} 0) ; Open
					(proc26_0 2020 self)
				)
				(2
					(gGame handsOff:)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance downTheStairs of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 414)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {03}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					((ScriptID 26 2) dispose:) ; myHotSet
					(stairs dispose:)
					(doorBar dispose:)
					(door dispose:)
					(SetFlag 414)
					(= local3 1)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2101.vmd} 0) ; Open
					(proc26_0 2101 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(PlayVMD 0 {2110.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(altar
							nsLeft: 114
							nsTop: 70
							nsRight: 181
							nsBottom: 110
							init:
							setHotspot: 4 3 ; Do, Move
						)
						(stairs
							nsLeft: 204
							nsTop: 7
							nsRight: 271
							nsBottom: 50
							init: 1
						)
						((ScriptID 26 2) ; myHotSet
							add:
								(altarRect setRect: altar)
								(stairRect setRect: stairs)
							activate:
						)
						(gGame handsOn:)
					)
					(proc26_0 2110 self 1)
				)
				(4
					(= cycles 2)
				)
				(5
					(gGame handsOff:)
					(if (IsFlag 135)
						(= local6 1)
						(proc45951_3)
						(if (!= global179 10)
							((ScriptID 26 2) dispose:) ; myHotSet
							(self dispose:)
						else
							(PlayVMD 0 {9090.vmd} 0) ; Open
							(proc26_0 9090 self)
						)
					else
						(PlayVMD 0 {9090.vmd} 0) ; Open
						(proc26_0 9090 self)
					)
				)
				(6
					((ScriptID 26 2) dispose:) ; myHotSet
					(gGame handsOff:)
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance toTheAltar of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 415)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {16}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(= local4 1)
					(SetFlag 415)
					((ScriptID 26 2) dispose:) ; myHotSet
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2200.vmd} 0) ; Open
					(proc26_0 2200 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(PlayVMD 0 {2210.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(altar
							nsLeft: 114
							nsTop: 70
							nsRight: 181
							nsBottom: 110
							init:
							setHotspot: 0 23 ; invSpellBook
						)
						(stairs
							nsLeft: 204
							nsTop: 7
							nsRight: 271
							nsBottom: 50
							init: 1
						)
						((ScriptID 26 2) ; myHotSet
							add:
								(altarRect setRect: altar)
								(stairRect setRect: stairs)
							activate:
						)
						(gGame handsOn:)
					)
					(proc26_0 2210 self 1)
				)
				(4
					(= cycles 2)
				)
				(5
					(if (IsFlag 135)
						(= local6 1)
						(proc45951_3)
						(if (!= global179 10)
							((ScriptID 26 2) dispose:) ; myHotSet
							(self dispose:)
						else
							(PlayVMD 0 {9090.vmd} 0) ; Open
							(proc26_0 9090 self)
						)
					else
						(PlayVMD 0 {9090.vmd} 0) ; Open
						(proc26_0 9090 self)
					)
				)
				(6
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance getStone of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(ClearFlag 213)
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
					((ScriptID 26 2) dispose:) ; myHotSet
					(ClearFlag 213)
					(carno dispose:)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2400.vmd} 0) ; Open
					(proc26_0 2400 self 0)
				)
				(2
					(= cycles 2)
				)
				(3
					(gEgo get: 18) ; invStone
					(PlayVMD 0 {2410.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(altar
							nsLeft: 2
							nsTop: 72
							nsRight: 291
							nsBottom: 129
							setHotspot: 0 26 ; invStone
						)
						(stairs
							nsLeft: 102
							nsTop: 29
							nsRight: 192
							nsBottom: 50
							init: 1
						)
						((ScriptID 26 2) ; myHotSet
							add:
								(altarRect setRect: altar)
								(stairRect setRect: stairs)
							activate:
						)
						(gGame handsOn:)
					)
					(proc26_0 2410 self 1)
				)
				(4
					(= cycles 2)
				)
				(5
					(if (IsFlag 135)
						(= local6 1)
						(proc45951_3)
						(if (!= global179 10)
							((ScriptID 26 2) dispose:) ; myHotSet
							(self dispose:)
						else
							(PlayVMD 0 {9100.vmd} 0) ; Open
							(proc26_0 9100 self)
						)
					else
						(gGame handsOff:)
						(PlayVMD 0 {9100.vmd} 0) ; Open
						(proc26_0 9100 self)
					)
				)
				(6
					(gGame handsOff:)
					((ScriptID 26 2) dispose:) ; myHotSet
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance putBook of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(if (not (gEgo has: 18)) ; invStone
				(SetFlag 213)
			)
			(gEgo put: 16) ; invSpellBook
			(= local1 1)
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
					(if (not (gEgo has: 18)) ; invStone
						(SetFlag 213)
					)
					(gEgo put: 16) ; invSpellBook
					(= local1 1)
					(altar
						nsBottom: 129
						nsTop: 52
						nsLeft: 37
						nsRight: 239
						setHotspot: 0
						setHotspot: 0 26 ; invStone
					)
					((ScriptID 26 2) dispose:) ; myHotSet
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2300.vmd} 0) ; Open
					(proc26_0 2300 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(PlayVMD 0 {2310.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(if (not (IsFlag 213))
							((ScriptID 26 2) ; myHotSet
								add:
									(altarRect setRect: altar)
									(stairRect setRect: stairs)
								activate:
							)
						else
							(carno
								nsLeft: 118
								nsTop: 57
								nsRight: 140
								nsBottom: 119
								init:
								setHotspot: 4 3 ; Do, Move
							)
							(stairs
								nsLeft: 204
								nsTop: 7
								nsRight: 271
								nsBottom: 50
							)
							((ScriptID 26 2) ; myHotSet
								add:
									(stairRect setRect: stairs)
									(carnoRect setRect: carno)
								activate:
							)
						)
						(gGame handsOn:)
					)
					(proc26_0 2310 self 1)
				)
				(4
					(= cycles 2)
				)
				(5
					(if (IsFlag 135)
						(= local6 1)
						(proc45951_3)
						(if (!= global179 10)
							((ScriptID 26 2) dispose:) ; myHotSet
							(self dispose:)
						else
							(PlayVMD 0 {9100.vmd} 0) ; Open
							(proc26_0 9100 self)
						)
					else
						(gGame handsOff:)
						(PlayVMD 0 {9100.vmd} 0) ; Open
						(proc26_0 9100 self)
					)
				)
				(6
					((ScriptID 26 2) dispose:) ; myHotSet
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance stoneOnBook of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(= local2 1)
			(SetFlag 219)
			(gEgo put: 18) ; invStone
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= local2 1)
					(SetFlag 219)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 2 {06}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					((ScriptID 26 2) dispose:) ; myHotSet
					(carno dispose:)
					(gEgo put: 18) ; invStone
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2500.vmd} 0) ; Open
					(proc26_0 2500 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(PlayVMD 0 {2510.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(altar
							nsLeft: 2
							nsTop: 52
							nsRight: 291
							nsBottom: 129
							setHotspot: 0 27 37 ; invCutter, ???
						)
						(stairs
							nsLeft: 102
							nsTop: 29
							nsRight: 192
							nsBottom: 50
							init: 1
						)
						((ScriptID 26 2) ; myHotSet
							add:
								(altarRect setRect: altar)
								(stairRect setRect: stairs)
							activate:
						)
						(gGame handsOn:)
					)
					(proc26_0 2510 self 1)
				)
				(4
					(= cycles 2)
				)
				(5
					(if (IsFlag 135)
						(= local6 1)
						(proc45951_3)
						(if (!= global179 10)
							((ScriptID 26 2) dispose:) ; myHotSet
							(self dispose:)
						else
							(PlayVMD 0 {9100.vmd} 0) ; Open
							(proc26_0 9100 self)
						)
					else
						(PlayVMD 0 {9100.vmd} 0) ; Open
						(proc26_0 9100 self)
					)
				)
				(6
					((ScriptID 26 2) dispose:) ; myHotSet
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance cutSelf of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 224)
			(= local0 1)
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
					((ScriptID 26 2) dispose:) ; myHotSet
					(SetFlag 224)
					(= local0 1)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2540.vmd} 0) ; Open
					(proc26_0 2540 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(PlayVMD 0 {2610.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(altar
							nsLeft: 2
							nsTop: 52
							nsRight: 291
							nsBottom: 129
							setHotspot: 0 20 22 ; invCrucifix, invBeads
						)
						(stairs nsLeft: 102 nsTop: 29 nsRight: 192 nsBottom: 50)
						((ScriptID 26 2) ; myHotSet
							add:
								(altarRect setRect: altar)
								(stairRect setRect: stairs)
							activate:
						)
						(gGame handsOn:)
					)
					(proc26_0 2610 self 1)
				)
				(4
					(gGame handsOff:)
					(= cycles 2)
				)
				(5
					(if (IsFlag 135)
						(= local6 1)
						(proc45951_3)
						(if (!= global179 10)
							((ScriptID 26 2) dispose:) ; myHotSet
							(self dispose:)
						else
							(PlayVMD 0 {9100.vmd} 0) ; Open
							(proc26_0 9100 self)
						)
					else
						(PlayVMD 0 {9100.vmd} 0) ; Open
						(proc26_0 9100 self)
					)
				)
				(6
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance broochScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(SetFlag 224)
			(= local0 1)
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
					((ScriptID 26 2) dispose:) ; myHotSet
					(SetFlag 224)
					(= local0 1)
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2530.vmd} 0) ; Open
					(proc26_0 2530 self)
				)
				(2
					(= cycles 2)
				)
				(3
					(PlayVMD 0 {2610.vmd} 0) ; Open
					(if (not (IsFlag 135))
						(altar
							nsLeft: 2
							nsTop: 52
							nsRight: 291
							nsBottom: 129
							setHotspot: 0
							setHotspot: 0 20 22 ; invCrucifix, invBeads
						)
						(stairs nsLeft: 102 nsTop: 29 nsRight: 192 nsBottom: 50)
						((ScriptID 26 2) ; myHotSet
							add:
								(altarRect setRect: altar)
								(stairRect setRect: stairs)
							activate:
						)
						(gGame handsOn:)
					)
					(proc26_0 2610 self 1)
				)
				(4
					(gGame handsOff:)
					(= cycles 2)
				)
				(5
					(if (IsFlag 135)
						(= local6 1)
						(proc45951_3)
						(if (!= global179 10)
							((ScriptID 26 2) dispose:) ; myHotSet
							(self dispose:)
						else
							(PlayVMD 0 {9100.vmd} 0) ; Open
							(proc26_0 9100 self)
						)
					else
						(PlayVMD 0 {9100.vmd} 0) ; Open
						(proc26_0 9100 self)
					)
				)
				(6
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance crossOnBook of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(gEgo put: 14) ; invCrucifix
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
					(gEgo put: 14) ; invCrucifix
					((ScriptID 26 2) dispose:) ; myHotSet
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2640.vmd}) ; Open
					(proc26_0 2640 self)
				)
				(2
					((ScriptID 26 2) dispose:) ; myHotSet
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 47480)
					)
				)
			)
		)
	)
)

(instance beadsOnBook of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
			(gEgo put: 15) ; invBeads
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (not (IsFlag 135))
						(= temp0 (Str newWith: 0 {09}))
						((ScriptID 45951 2) writeString: temp0) ; chase_dat
						(temp0 dispose:)
					)
					(gEgo put: 15) ; invBeads
					((ScriptID 26 2) dispose:) ; myHotSet
					(= cycles 2)
				)
				(1
					(PlayVMD 0 {2630.vmd} 0) ; Open
					(proc26_0 2630 self)
				)
				(2
					((ScriptID 26 2) dispose:) ; myHotSet
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom newRoom: 47480)
					)
				)
			)
		)
	)
)

(instance backUpStairs of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 390)
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
					(= cycles 2)
				)
				(1
					(cond
						(local2
							(PlayVMD 0 {2420.vmd} 0) ; Open
							(proc26_0 2420 self)
						)
						(local1
							(PlayVMD 0 {2320.vmd} 0) ; Open
							(proc26_0 2320 self)
						)
						(else
							(PlayVMD 0 {2120.vmd} 0) ; Open
							(proc26_0 2120 self)
						)
					)
				)
				(2
					(if (IsFlag 135)
						(self dispose:)
					else
						(gCurRoom setScript: killedScr)
					)
				)
			)
		)
	)
)

(instance killedScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(if (not (IsFlag 135))
					(= temp0 (Str newWith: 2 {10}))
					((ScriptID 45951 2) writeString: temp0) ; chase_dat
					(temp0 dispose:)
				)
				(if global161
					(global161 owner: -1)
					(gEgo get: (gInventory indexOf: global161))
					(gUser message: (gUser dftMessage:))
					(= global161 0)
					(gGame setCursor: gNormalCursor 1)
					(gCurrentControl select: 3 gNormalCursor)
				)
				(ClearFlag 390)
				(if (gCast contains: carno)
					(carno hide:)
				)
				((ScriptID 26 2) dispose:) ; myHotSet
				(if (gGame script:)
					((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				)
				(= temp2
					(Print
						mode: 1
						addText: 0 0 0 1 1 1 40000 ; MISSING MESSAGE
						addText: 0 0 0 2 1 7 40000 ; MISSING MESSAGE
						addButton: 1 0 0 0 3 1 15 1 40000 ; MISSING MESSAGE
						addButton: 0 0 0 0 5 1 25 1 40000 ; MISSING MESSAGE
						addButton: 2 0 0 0 4 1 35 1 40000 ; MISSING MESSAGE
						init:
					)
				)
				((ScriptID 0 11) priority: (- ((gCurRoom plane:) priority:) 1)) ; overlayPlane
				(UpdatePlane (ScriptID 0 11)) ; overlayPlane
				(switch temp2
					(0
						(proc45951_5)
						(gCurRoom newRoom: 91) ; saveRest
					)
					(1
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
						(ClearFlag 67)
						(ClearFlag 410)
						(ClearFlag 219)
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
						((ScriptID 26 2) dispose:) ; myHotSet
						(gCurRoom newRoom: 45950)
					)
				)
			)
			(1
				(ClearFlag 212)
				(ClearFlag 415)
				(ClearFlag 414)
				(ClearFlag 213)
				((ScriptID 26 2) dispose:) ; myHotSet
				(if local5
					(ClearFlag 135)
					(SetFlag 121)
					(ClearFlag 415)
					(ClearFlag 219)
					(ClearFlag 414)
					(ClearFlag 213)
					(if (gEgo has: 18) ; invStone
						(gEgo put: 18) ; invStone
					)
					(if (gEgo has: 15) ; invBeads
						(SetFlag 354)
					)
					(if (gEgo has: 14) ; invCrucifix
						(SetFlag 356)
					)
					(if (gEgo has: 19) ; invCutter
						(SetFlag 304)
					)
					(SetFlag 355)
					(gEgo get: 17) ; invXmasOrn
					(if local1
						(gEgo get: 16) ; invSpellBook
					)
					(ClearFlag 150)
					(SetFlag 151)
					(gCurRoom newRoom: 46030)
				else
					(ClearFlag 135)
					(SetFlag 121)
					(= global108 40100)
					(gEgo get: 16) ; invSpellBook
					(ClearFlag 212)
					(ClearFlag 224)
					(ClearFlag 219)
					(ClearFlag 415)
					(ClearFlag 414)
					(ClearFlag 213)
					(if (gEgo has: 18) ; invStone
						(gEgo put: 18) ; invStone
					)
					(= temp0 (Str newWith: 3 {99\0d\n}))
					((ScriptID 45951 2) writeString: temp0 close:) ; chase_dat
					(temp0 dispose:)
					(gCurRoom newRoom: 900)
				)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 112
		nsTop 6
		nsRight 167
		nsBottom 114
		approachX 217
		approachY 112
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: openDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carno of Feature
	(properties
		approachX 88
		approachY 110
		x 82
		y 107
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: getStone)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorBar of Feature
	(properties
		nsLeft 80
		nsRight 103
		nsBottom 65
		x 140
		y 55
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			(if (IsFlag 212)
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: unbarDoor)
			else
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: barDoor)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance stairs of ExitFeature
	(properties
		nsLeft 5
		nsTop 120
		nsRight 314
		nsBottom 136
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			((ScriptID 26 1) caller: 0 dispose:) ; movieScr
			(cond
				(local3
					(gCurRoom setScript: backUpStairs)
				)
				((not (IsFlag 212))
					(gCurRoom setScript: downStairsOops)
				)
				(else
					(gCurRoom setScript: downTheStairs)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance altar of Feature
	(properties
		nsLeft 114
		nsTop 70
		nsRight 183
		nsBottom 111
		approachX 136
		approachY 105
		x 156
		y 105
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local4
					(super doVerb: theVerb)
				else
					(= local4 1)
					((ScriptID 26 1) caller: 0 dispose:) ; movieScr
					(gCurRoom setScript: toTheAltar)
				)
			)
			(23 ; invSpellBook
				(gGame handsOff:)
				((ScriptID 26 1) caller: 0 dispose:) ; movieScr
				(gCurRoom setScript: putBook)
			)
			(20 ; invCrucifix
				(if local0
					((ScriptID 26 1) caller: 0 dispose:) ; movieScr
					(gCurRoom setScript: crossOnBook)
				else
					(super doVerb: theVerb)
				)
			)
			(22 ; invBeads
				(if local0
					((ScriptID 26 1) caller: 0 dispose:) ; movieScr
					(gCurRoom setScript: beadsOnBook)
				else
					(super doVerb: theVerb)
				)
			)
			(37 ; ???
				(if (not local2)
					(super doVerb: theVerb)
				else
					((ScriptID 26 1) caller: 0 dispose:) ; movieScr
					(gCurRoom setScript: broochScript)
				)
			)
			(27 ; invCutter
				(if (not local2)
					(super doVerb: theVerb)
				else
					((ScriptID 26 1) caller: 0 dispose:) ; movieScr
					(gCurRoom setScript: cutSelf)
				)
			)
			(26 ; invStone
				(if (gEgo has: 16) ; invSpellBook
					(super doVerb: theVerb)
				else
					(gGame handsOff:)
					((ScriptID 26 1) caller: 0 dispose:) ; movieScr
					(gCurRoom setScript: stoneOnBook)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barRect of HotRectangle
	(properties)
)

(instance doorRect of HotRectangle
	(properties)
)

(instance carnoRect of HotRectangle
	(properties)
)

(instance altarRect of HotRectangle
	(properties)
)

(instance stairRect of HotRectangle
	(properties)
)

