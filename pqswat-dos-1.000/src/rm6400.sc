;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6400)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Button)
(use SwatFile)
(use LashInterface)
(use Inset)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm6400 0
)

(local
	local0
	local1
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(= temp0 (Event new:))
	(= temp1 0)
	(= temp2 0)
	(PlayVMD 0 {1810.vmd} 1024) ; Open
	(PlayVMD 1 108 65) ; Put
	(while (not temp2)
		(cond
			((== (= temp1 (PlayVMD 14 35 2)) 1) ; WaitEvent
				(PlayVMD 6) ; Close
				(= temp2 1)
			)
			((== temp1 2)
				(PlayVMD 6) ; Close
				(= temp2 1)
			)
			(else
				(temp0
					type:
						(temp0
							message:
								(temp0
									modifiers:
										(temp0
											y:
												(temp0
													x:
														(temp0
															claimed:
																(temp0 plane: 0)
														)
												)
										)
								)
						)
				)
				(GetEvent 4 temp0)
				(if (and (& (temp0 type:) evKEYBOARD) (== (temp0 message:) KEY_SPACE))
					(= temp2 1)
					(= local1 1)
					(PlayVMD 6) ; Close
				)
			)
		)
	)
)

(procedure (localproc_1)
	(lashBackground init:)
	(openButn init:)
	(closedButn init:)
	(lockedButn init:)
	(frontButn init:)
	(backButn init:)
	(initiateButn init:)
	(yesButn init:)
	(noButn init:)
	(upButn init:)
	(downButn init:)
	(doorButn init:)
	(windowButn init:)
	(coverButn init:)
	(pull_backButn init:)
	(clearButn init:)
	(containmentButn init:)
	(compromisedButn init:)
	(closetButn init:)
	(entry_teamButn init:)
	(trailerButn init:)
	(in_positionButn init:)
	(in_controlButn init:)
	(leftButn init:)
	(rightButn init:)
	(suspectButn init:)
	(hostageButn init:)
	(coming_outButn init:)
	(gasButn init:)
	(ramButn init:)
	(high_groundButn init:)
	(l_oneButn init:)
	(l_twoButn init:)
	(l_threeButn init:)
	(l_fourButn init:)
	(l_fiveButn init:)
	(s_oneButn init:)
	(s_twoButn init:)
	(s_threeButn init:)
	(s_fourButn init:)
	(transmitButn init:)
	(leftFlash init:)
	(rightFlash init:)
)

(procedure (localproc_2)
	(openButn dispose:)
	(closedButn dispose:)
	(lockedButn dispose:)
	(frontButn dispose:)
	(backButn dispose:)
	(initiateButn dispose:)
	(yesButn dispose:)
	(noButn dispose:)
	(upButn dispose:)
	(downButn dispose:)
	(doorButn dispose:)
	(windowButn dispose:)
	(coverButn dispose:)
	(pull_backButn dispose:)
	(clearButn dispose:)
	(containmentButn dispose:)
	(compromisedButn dispose:)
	(closetButn dispose:)
	(entry_teamButn dispose:)
	(trailerButn dispose:)
	(in_positionButn dispose:)
	(in_controlButn dispose:)
	(leftButn dispose:)
	(rightButn dispose:)
	(suspectButn dispose:)
	(hostageButn dispose:)
	(coming_outButn dispose:)
	(gasButn dispose:)
	(ramButn dispose:)
	(high_groundButn dispose:)
	(l_oneButn dispose:)
	(l_twoButn dispose:)
	(l_threeButn dispose:)
	(l_fourButn dispose:)
	(l_fiveButn dispose:)
	(s_oneButn dispose:)
	(s_twoButn dispose:)
	(s_threeButn dispose:)
	(s_fourButn dispose:)
	(transmitButn dispose:)
	(leftFlash dispose:)
	(rightFlash dispose:)
	(lashBackground dispose:)
)

(instance rm6400 of PQRoom
	(properties
		modNum 6004
		picture 6400
	)

	(method (init)
		(Palette 2 42 254 0) ; PalIntensity
		(SetFlag 111)
		(gKeyDownHandler addToFront: self)
		(= global432 holdIt)
		(rooker view: 60103 posn: 224 222 setPri: 200 init:)
		(gEgo view: 60015 loop: 0 cel: 0 posn: 414 353 setPri: 300 init:)
		(chalkBoard init:)
		(tvAndVCR init:)
		(chalkBoardTraining init:)
		(cond
			((IsFlag 29)
				(= local0 1)
				(gCurRoom setScript: rookerTrains1)
			)
			((IsFlag 30)
				(= local0 1)
				(rooker hide:)
				(gEgo hide:)
				(chalkBoardTraining hide:)
				(= picture 181)
				(self setScript: rookerTrains4 0 1)
			)
			(else
				(responseTimer cue:)
			)
		)
		(ClearFlag 75)
		(super init: &rest)
	)

	(method (handleEvent event &tmp [temp0 4])
		(if (and (& (event type:) evKEYBOARD) (IsFlag 111) (not local1))
			(if (== (event message:) KEY_SPACE)
				(gGame handsOff:)
				(event claimed: 1)
				(= local1 1)
				(proc4_5)
				(if (IsFlag 12)
					(ClearFlag 12)
					(gSwatInterface closeInvWindow:)
				)
				(gCast eachElementDo: #dispose)
				(gEgo view: 0)
				(rooker view: 0)
				(chalkBoardTraining view: 0)
				(gSwatInterface startAlert:)
			)
			(event claimed:)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (newRoom newRoomNumber)
		(Palette 2 42 254 0) ; PalIntensity
		(FrameOut)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(if (gCast contains: lashBackground)
			(Palette 2 42 254 0) ; PalIntensity
			(localproc_2)
		)
		(= gNewRoomNum newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (setInset param1 param2 param3)
		(Palette 2 42 254 0) ; PalIntensity
		(super setInset: param1 param2 param3)
	)

	(method (dispose)
		(proc4_5)
		(Lock rsAUDIO 1 0)
		(Lock rsVIEW 10 0)
		(Lock rsVIEW 52 0)
		(Lock rsVIEW 53 0)
		(Lock rsVIEW 54 0)
		(Lock rsVIEW 56 0)
		(Lock rsVIEW 57 0)
		(Lock rsVIEW 59 0)
		(Lock rsVIEW 64007 0)
		((gSwatInterface curSwatButn:) reset:)
		((gSwatInterface curSwatButn:) setActive: 1)
		(gSwatInterface showHandAni: 0)
		(gSwatInterface hideCursor: 0)
		(if (and (IsFlag 12) (not local1))
			(ClearFlag 12)
			(gSwatInterface closeInvWindow:)
		)
		(if (gTimers contains: responseTimer)
			(responseTimer dispose: delete:)
		)
		(if (gKeyDownHandler contains: iBlackBoard)
			(gKeyDownHandler delete: iBlackBoard)
		)
		(= global432 0)
		(super dispose:)
	)
)

(instance holdIt of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

(instance rookerTrains1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rooker hide:)
				(WalkieTalkie showFrame: 60103 0 163 90)
				(= global128 60103)
				(= cycles 3)
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(proc4_6 60103 163 90 0 0 100)
			)
			(2
				(proc4_5)
				(rooker view: 60103 posn: 189 222 show:)
				(responseTimer setReal: responseTimer 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rookerTrains2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 28)
				(rooker hide:)
				(Lock rsVIEW 55 0)
				(proc4_6 60113 163 90 0 0 200)
			)
			(1
				(proc4_5)
				(gCurRoom setInset: iTV self 1)
			)
			(2
				(= cycles 5)
			)
			(3
				(Lock rsVIEW 55 1)
				(Palette 2 42 254 100) ; PalIntensity
				(if local1
					(gSwatInterface startAlert:)
				else
					(self cue:)
				)
			)
			(4
				(proc4_6 60116 163 90 0 0 200)
			)
			(5
				(proc4_5)
				(switch local0
					(1
						(rooker view: 60113 posn: 194 103 show:)
					)
					(2
						(rooker view: 60113 posn: 194 103 show:)
					)
					(3
						(rooker view: 60104 posn: 217 222 show:)
					)
					(4
						(rooker view: 60114 loop: 0 posn: 213 222 show:)
					)
				)
				(responseTimer setReal: responseTimer 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rookerTrains3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 10)
				(Load rsVIEW 64007)
				(Load rsAUDIO 1)
				(= cycles 10)
			)
			(1
				(rooker hide:)
				(proc4_6 60104 143 91 0 0 200)
			)
			(2
				(SetFlag 12)
				(gSwatInterface newInvLevel: 3 1)
			)
			(3
				(tvAnim init:)
				(gFxSound number: 1 loop: 1 play:)
				((ScriptID 16 2) setActive: 0) ; slicePieButn
				(= ticks 60)
			)
			(4
				(tvAnim posn: 31 154 loop: 1 setCycle: End self)
				((ScriptID 16 2) setActive: 1) ; slicePieButn
			)
			(5
				(tvAnim cel: 0 loop: 0 cycleSpeed: 20 setCycle: End self)
			)
			(6
				(= ticks 120)
			)
			(7
				(tvAnim loop: 1 cel: 4 setCycle: Beg)
			)
			(8
				(tvAnim dispose:)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(9
				(proc4_5)
				(if (IsFlag 27)
					(rooker view: 60114 posn: 213 222 show:)
				else
					(rooker view: 60104 posn: 217 222 show:)
				)
				(= cycles 2)
			)
			(10
				(Lock rsVIEW 10 64007 0)
				(responseTimer setReal: responseTimer 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rookerTrains4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 181)
				(Lock rsVIEW 181 1)
				(= cycles 2)
			)
			(1
				(rooker hide:)
				(SetFlag 27)
				(gCurRoom setInset: iBlackBoard self 1)
			)
			(2
				(= cycles 5)
			)
			(3
				(Palette 2 42 254 100) ; PalIntensity
				(if (not local1)
					(self cue:)
				)
			)
			(4
				(responseTimer setReal: responseTimer 5)
				(self dispose:)
			)
		)
	)
)

(instance rookerTrains5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Lock rsAUDIO 1 1)
				(Load rsVIEW 10)
				(Load rsVIEW 52)
				(Load rsVIEW 53)
				(Load rsVIEW 54)
				(Load rsVIEW 56)
				(Load rsVIEW 57)
				(Load rsVIEW 59)
				(Load rsVIEW 999)
				(Load rsVIEW 17)
				(Lock rsVIEW 17 1)
				(= cycles 3)
			)
			(1
				(rooker hide:)
				(proc4_6 60124 143 91 0 0 200 1)
			)
			(2
				(localproc_1)
				(wait init:)
				(gSwatInterface hideCursor: 1)
				(gGame handsOff:)
			)
			(3
				(trailerButn cel: 1)
				(= ticks 60)
			)
			(4
				(coverButn cel: 1)
				(= ticks 60)
			)
			(5
				(windowButn cel: 1)
				(= ticks 60)
			)
			(6
				(transmitButn cel: 1)
				(leftFlash setCycle: Fwd)
				(rightFlash setCycle: Fwd)
				(= ticks 120)
			)
			(7
				(trailerButn cel: 0)
				(coverButn cel: 0)
				(windowButn cel: 0)
				(transmitButn cel: 0)
				(leftFlash setCycle: End)
				(rightFlash setCycle: End)
				(= ticks 300)
			)
			(8
				(high_groundButn cel: 1)
				(= ticks 120)
			)
			(9
				(in_positionButn cel: 1)
				(= ticks 120)
			)
			(10
				(transmitButn cel: 1)
				(leftFlash setCycle: Fwd)
				(rightFlash setCycle: Fwd)
				(= ticks 120)
			)
			(11
				(high_groundButn cel: 0)
				(in_positionButn cel: 0)
				(transmitButn cel: 0)
				(leftFlash setCycle: End)
				(rightFlash setCycle: End)
				(= ticks 120)
			)
			(12
				(gSwatInterface hideCursor: 0)
				(wait dispose:)
				(localproc_2)
				(Lock rsVIEW 17 0)
				(Lock rsVIEW 10 52 53 54 56 57 59 1)
				(gGame handsOff:)
			)
			(13
				(SetFlag 12)
				(gSwatInterface newInvLevel: 2 1)
			)
			(14
				(gFxSound number: 1 loop: 1 play:)
				((ScriptID 16 8) setActive: 0) ; holdButn
				(gSwatInterface showHandAni: 4)
				(= ticks 60)
			)
			(15
				((ScriptID 16 8) setActive: 1) ; holdButn
			)
			(16
				(gFxSound number: 1 loop: 1 play:)
				((ScriptID 16 4) setActive: 0) ; coverButn
				(gSwatInterface showHandAni: 3)
				(= ticks 60)
			)
			(17
				((ScriptID 16 4) setActive: 1) ; coverButn
			)
			(18
				(gFxSound number: 1 loop: 1 play:)
				((ScriptID 16 5) setActive: 0) ; hurryButn
				(gSwatInterface showHandAni: 5)
				(= ticks 60)
			)
			(19
				((ScriptID 16 5) setActive: 1) ; hurryButn
			)
			(20
				(gFxSound number: 1 loop: 1 play:)
				((ScriptID 16 6) setActive: 0) ; suspectButn
				(gSwatInterface showHandAni: 7)
				(= ticks 60)
			)
			(21
				((ScriptID 16 6) setActive: 1) ; suspectButn
			)
			(22
				(gFxSound number: 1 loop: 1 play:)
				((ScriptID 16 7) setActive: 0) ; attentionButn
				(gSwatInterface showHandAni: 2)
				(= ticks 60)
			)
			(23
				((ScriptID 16 7) setActive: 1) ; attentionButn
			)
			(24
				(gFxSound number: 1 loop: 1 play:)
				((ScriptID 16 3) setActive: 0) ; lookButn
				(gSwatInterface showHandAni: 1)
				(= ticks 60)
			)
			(25
				((ScriptID 16 3) setActive: 1) ; lookButn
			)
			(26
				(gFxSound number: 1 loop: 1 play:)
				((ScriptID 16 9) setActive: 0) ; clearButn
				(gSwatInterface showHandAni: 6)
				(= ticks 60)
			)
			(27
				((ScriptID 16 9) setActive: 1) ; clearButn
			)
			(28
				(gFxSound number: 1 loop: 1 play:)
				((ScriptID 16 10) setActive: 0) ; stopButn
				(gSwatInterface showHandAni: 8)
				(= ticks 180)
			)
			(29
				((ScriptID 16 10) setActive: 1) ; stopButn
			)
			(30
				((gSwatInterface curSwatButn:) reset:)
				((gSwatInterface curSwatButn:) setActive: 1)
				(gSwatInterface showHandAni: 0)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(31
				(Lock rsAUDIO 1 0)
				(Lock rsVIEW 10 52 53 54 56 57 59 0)
				(SetFlag 111)
				(SwatFile writeIt: 0 1)
				(if (IsFlag 42)
					(gGame handsOff:)
					(gSwatInterface startAlert:)
					(self dispose:)
				else
					(gCurRoom newRoom: 100)
				)
			)
		)
	)
)

(instance sWatchDog of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (Robot 11) 445) ; FrameNum
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(proc4_5)
				(WalkieTalkie showFrame: 60124 440 143 91)
				(self dispose:)
			)
		)
	)
)

(instance playerAsks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: End self)
			)
			(1
				(++ local0)
				(if (and (IsFlag 27) (== local0 4))
					(++ local0)
				)
				(if (and (IsFlag 28) (== local0 2))
					(++ local0)
				)
				(switch local0
					(2
						(self next: rookerTrains2)
						(gMessager say: 2 29 16 0 self 6000) ; "Sergeant Rooker, what type of situations does D Platoon normally encounter?"
						(= cycles 1)
					)
					(3
						(self next: rookerTrains3)
						(gMessager say: 2 29 17 0 self 6000) ; "Are there certain room entry techniques we should employ?"
						(= cycles 1)
					)
					(4
						(self next: rookerTrains4)
						(gMessager say: 2 29 18 0 self 6000) ; "Is there a specific set of codes, similar to the Apco Code or to the Radio call letters, used for communicating during a call-up?"
						(= cycles 1)
					)
					(5
						(Load rsVIEW 17)
						(Load rsAUDIO 1)
						(self next: rookerTrains5)
						(gMessager say: 2 29 19 0 self 6000) ; "What about comunication between different teams, or teams and brass?"
						(= cycles 1)
					)
				)
			)
			(2
				(gEgo setCycle: Beg)
			)
			(3
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance front of View
	(properties
		x 85
		y 265
		view 181
	)
)

(instance side1 of View
	(properties
		x 48
		y 216
		view 181
		cel 1
	)
)

(instance corner1_2 of View
	(properties
		name {corner1&2}
		x 10
		y 185
		view 181
		cel 2
	)
)

(instance side2 of View
	(properties
		x 6
		y 127
		view 181
		cel 3
	)
)

(instance corner2_3 of View
	(properties
		name {corner2&3}
		x 11
		y 109
		view 181
		cel 4
	)
)

(instance side3 of View
	(properties
		x 53
		y 99
		view 181
		cel 5
	)
)

(instance corner3_4 of View
	(properties
		name {corner3&4}
		x 137
		y 117
		view 181
		cel 6
	)
)

(instance side4 of View
	(properties
		x 179
		y 133
		view 181
		cel 7
	)
)

(instance corner1_4 of View
	(properties
		name {corner1&4}
		view 181
		cel 8
	)

	(method (init)
		(self setPri: 200)
		(super init: &rest)
	)
)

(instance level1 of View
	(properties
		x 489
		y 222
		view 181
		loop 1
	)

	(method (init)
		(self setPri: 100)
		(super init: &rest)
	)
)

(instance level2 of View
	(properties
		x 486
		y 176
		view 181
		loop 1
		cel 1
	)
)

(instance level3 of View
	(properties
		x 487
		y 130
		view 181
		loop 1
		cel 2
	)
)

(instance level4 of View
	(properties
		view 181
		loop 1
		cel 3
	)

	(method (init)
		(self setPri: 100)
		(super init: &rest)
	)
)

(instance building of View
	(properties
		x 281
		y 66
		view 181
		loop 1
		cel 4
	)
)

(instance door of View
	(properties
		x 356
		y 221
		view 181
		loop 1
		cel 6
	)
)

(instance win1 of View
	(properties
		x 305
		y 222
		view 181
		loop 1
		cel 5
	)
)

(instance win3 of View
	(properties
		x 410
		y 219
		view 181
		loop 1
		cel 7
	)
)

(instance win4 of View
	(properties
		x 309
		y 179
		view 181
		loop 1
		cel 8
	)
)

(instance win5 of View
	(properties
		x 362
		y 178
		view 181
		loop 1
		cel 9
	)
)

(instance win6 of View
	(properties
		x 416
		y 176
		view 181
		loop 1
		cel 10
	)
)

(instance win7 of View
	(properties
		x 307
		y 132
		view 181
		loop 1
		cel 11
	)
)

(instance win8 of View
	(properties
		x 356
		y 131
		view 181
		loop 1
		cel 12
	)
)

(instance win9 of View
	(properties
		x 421
		y 133
		view 181
		loop 1
		cel 13
	)
)

(instance win10 of View
	(properties
		x 302
		y 85
		view 181
		loop 1
		cel 14
	)
)

(instance win11 of View
	(properties
		x 363
		y 84
		view 181
		loop 1
		cel 15
	)
)

(instance win12 of View
	(properties
		x 419
		y 83
		view 181
		loop 1
		cel 16
	)
)

(instance lashBackground of View
	(properties
		x 80
		y 37
		view 17
	)

	(method (init &tmp temp0 temp1)
		(= temp0 (CelWide view loop cel))
		(= temp1 (CelHigh view loop cel))
		(self setPri: 400)
		(super init: &rest)
	)
)

(instance openButn of LashButton
	(properties
		loop 1
		enumType 1
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance closedButn of LashButton
	(properties
		loop 2
		enumType 2
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance lockedButn of LashButton
	(properties
		loop 3
		enumType 3
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance frontButn of LashButton
	(properties
		loop 4
		enumType 4
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance backButn of LashButton
	(properties
		loop 5
		enumType 5
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance initiateButn of LashButton
	(properties
		loop 6
		enumType 6
		buttVerb 59
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 50))
		(super init: &rest)
	)
)

(instance yesButn of LashButton
	(properties
		loop 7
		enumType 7
		buttVerb 145
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance noButn of LashButton
	(properties
		loop 8
		enumType 8
		buttVerb 146
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance upButn of LashButton
	(properties
		loop 9
		enumType 9
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance downButn of LashButton
	(properties
		loop 10
		enumType 10
		buttVerb 140
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance doorButn of LashButton
	(properties
		loop 11
		enumType 11
		buttVerb 88
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance windowButn of LashButton
	(properties
		loop 12
		enumType 12
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 72))
		(super init: &rest)
	)
)

(instance coverButn of LashButton
	(properties
		loop 13
		enumType 14
		buttVerb 95
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance pull_backButn of LashButton
	(properties
		loop 14
		enumType 15
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance clearButn of LashButton
	(properties
		loop 15
		enumType 16
		buttVerb 98
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance containmentButn of LashButton
	(properties
		loop 16
		enumType 17
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance compromisedButn of LashButton
	(properties
		loop 17
		enumType 18
		buttVerb 87
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance closetButn of LashButton
	(properties
		loop 18
		enumType 13
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 93))
		(super init: &rest)
	)
)

(instance entry_teamButn of LashButton
	(properties
		loop 19
		enumType 19
		buttVerb 136
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance trailerButn of LashButton
	(properties
		loop 20
		enumType 20
		buttVerb 101
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance in_positionButn of LashButton
	(properties
		loop 21
		enumType 43
		buttVerb 77
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance in_controlButn of LashButton
	(properties
		loop 22
		enumType 42
		buttVerb 139
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance leftButn of LashButton
	(properties
		loop 23
		enumType 78
		buttVerb 134
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance rightButn of LashButton
	(properties
		loop 24
		enumType 79
		buttVerb 135
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 115))
		(super init: &rest)
	)
)

(instance suspectButn of LashButton
	(properties
		loop 25
		enumType 21
		buttVerb 89
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance hostageButn of LashButton
	(properties
		loop 26
		enumType 22
		buttVerb 90
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance coming_outButn of LashButton
	(properties
		loop 27
		enumType 23
		buttVerb 141
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance gasButn of LashButton
	(properties
		loop 28
		enumType 24
		buttVerb 67
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance ramButn of LashButton
	(properties
		loop 29
		enumType 25
		buttVerb 66
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance high_groundButn of LashButton
	(properties
		loop 30
		enumType 26
		buttVerb 37
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 139))
		(super init: &rest)
	)
)

(instance l_oneButn of LashButton
	(properties
		loop 31
		enumType 28
		buttVerb 156
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 84))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)
)

(instance l_twoButn of LashButton
	(properties
		loop 32
		enumType 29
		buttVerb 157
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 160))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)
)

(instance l_threeButn of LashButton
	(properties
		loop 33
		enumType 30
		buttVerb 158
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 236))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)
)

(instance l_fourButn of LashButton
	(properties
		loop 34
		enumType 31
		buttVerb 159
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 312))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)
)

(instance l_fiveButn of LashButton
	(properties
		loop 35
		enumType 32
		buttVerb 160
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 388))
		(= y (+ (lashBackground y:) 163))
		(super init: &rest)
	)
)

(instance s_oneButn of LashButton
	(properties
		loop 36
		enumType 34
		buttVerb 156
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 122))
		(= y (+ (lashBackground y:) 184))
		(super init: &rest)
	)
)

(instance s_twoButn of LashButton
	(properties
		loop 37
		enumType 35
		buttVerb 157
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 198))
		(= y (+ (lashBackground y:) 184))
		(super init: &rest)
	)
)

(instance s_threeButn of LashButton
	(properties
		loop 38
		enumType 36
		buttVerb 158
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 274))
		(= y (+ (lashBackground y:) 184))
		(super init: &rest)
	)
)

(instance s_fourButn of LashButton
	(properties
		loop 39
		enumType 37
		buttVerb 159
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 350))
		(= y (+ (lashBackground y:) 184))
		(super init: &rest)
	)
)

(instance transmitButn of Button
	(properties
		view 17
		loop 40
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 196))
		(= y (+ (lashBackground y:) 206))
		(super init: &rest)
	)
)

(instance leftFlash of Prop
	(properties
		view 17
		loop 42
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 8))
		(= y (+ (lashBackground y:) 9))
		(super init:)
	)
)

(instance rightFlash of Prop
	(properties
		view 17
		loop 43
	)

	(method (init)
		(self setPri: 400)
		(= x (+ (lashBackground x:) 446))
		(= y (+ (lashBackground y:) 9))
		(super init:)
	)
)

(instance rooker of Prop
	(properties
		x 400
		y 216
		view 6000
	)

	(method (doVerb)
		(if (gTimers contains: responseTimer)
			(responseTimer dispose: delete:)
		)
		(Load rsVIEW 6000)
		(gCurRoom setScript: playerAsks)
	)
)

(instance hancock of Prop ; UNUSED
	(properties
		x 240
		y 216
		view 6000
		cel 2
	)
)

(instance chalkBoardTraining of View
	(properties
		x 174
		y 84
		view 64900
	)

	(method (onMe)
		(return 0)
	)
)

(instance charmichael of Prop ; UNUSED
	(properties
		x 6
		y 366
		priority 330
		fixPriority 1
		view 60033
	)
)

(instance tony of Prop ; UNUSED
	(properties
		x 167
		y 368
		priority 300
		fixPriority 1
		view 60034
	)
)

(instance denton of Prop ; UNUSED
	(properties
		x 270
		y 352
		priority 260
		fixPriority 1
		view 60035
	)
)

(instance wixell of Prop ; UNUSED
	(properties
		x 108
		y 275
		priority 260
		fixPriority 1
		view 60036
	)
)

(instance wait of Actor
	(properties
		x 300
		y 300
		view 997
	)

	(method (init)
		(self setPri: 500)
		(super init: &rest)
	)
)

(instance tvAnim of Prop
	(properties
		x 31
		y 154
		view 64007
		loop 2
	)

	(method (init)
		(self setPri: 300)
		(super init: &rest)
	)
)

(instance responseTimer of Timer
	(properties)

	(method (cue)
		(++ local0)
		(if (and (IsFlag 27) (== local0 4))
			(++ local0)
		)
		(if (and (IsFlag 28) (== local0 2))
			(++ local0)
		)
		(switch local0
			(1
				(gCurRoom setScript: rookerTrains1)
			)
			(2
				(gCurRoom setScript: rookerTrains2)
			)
			(3
				(gCurRoom setScript: rookerTrains3)
			)
			(4
				(gCurRoom setScript: rookerTrains4)
			)
			(5
				(gCurRoom setScript: rookerTrains5)
			)
			(else
				(gCurRoom setScript: playerAsks)
			)
		)
	)
)

(instance chalkBoard of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 84 79 518 69 514 194 104 182 102 153 84 153
					yourself:
				)
		)
	)

	(method (doVerb)
		(responseTimer dispose: delete:)
		(gCurRoom setScript: rookerTrains4)
	)
)

(instance tvAndVCR of Feature
	(properties
		y 10
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 34 213 32 153 104 153 104 201 164 201 164 213 142 216
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 554 0 554 43 640 40 640 0
					yourself:
				)
		)
	)

	(method (doVerb)
		(responseTimer dispose: delete:)
		(gCurRoom setScript: rookerTrains2)
	)
)

(instance iBlackBoard of Inset
	(properties
		picture 181
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(self setScript: sBlkBrdRookerTrains4)
	)

	(method (handleEvent event &tmp [temp0 4])
		(if (and (& (event type:) evKEYBOARD) (IsFlag 111))
			(if (== (event message:) KEY_SPACE)
				(event claimed: 1)
				(if (self script:)
					(sBlkBrdRookerTrains4 dispose:)
				)
				(Palette 2 42 254 0) ; PalIntensity
				(= local1 1)
				(gGame handsOn:)
				(gSwatInterface startAlert:)
				(self dispose:)
			)
			(event claimed:)
			(return)
		else
			(super handleEvent: event)
			(return)
		)
	)

	(method (dispose)
		(Palette 2 42 254 0) ; PalIntensity
		(gCurRoom drawPic: 6400)
		(if (gKeyDownHandler contains: self)
			(gKeyDownHandler delete: self)
		)
		(switch local0
			(1
				(rooker view: 60103 posn: 189 222 show:)
			)
			(2
				(rooker view: 60103 posn: 189 222 show:)
			)
			(3
				(rooker view: 60113 posn: 194 103 show:)
			)
			(4
				(rooker view: 60104 posn: 217 222 show:)
			)
			(5
				(rooker view: 60114 loop: 0 posn: 213 222 show:)
			)
		)
		(responseTimer setReal: responseTimer 5)
		(gEgo show:)
		(chalkBoardTraining show:)
		(gGame handsOn:)
		(Lock rsVIEW 181 0)
		(super dispose: &rest)
	)
)

(instance sBlkBrdRookerTrains4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(Palette 2 42 254 100) ; PalIntensity
				(gMessager say: 0 0 5 1 self 6004) ; "Communication is key to our success as a team. Consequently, agreed upon terminology exists in this organization. I expect all of you to understand and utilize this terminology. When observing and relaying information concerning a structure, you will refer to it by numbers, not geographical designations. The front of the building is always side one. Moving clockwise, the numbers increase: two, three, four, etc. Corners are referred to by their intersecting sides. In the example I have here, you can see the bottom left corner is referred to as the one/two corner. So remember, the front of the building is always side one and you move clockwise and number accordingly."
				(= ticks 1480)
			)
			(2
				(front init:)
				(side1 init:)
				(= ticks 240)
			)
			(3
				(side2 init:)
				(= ticks 60)
			)
			(4
				(side3 init:)
				(= ticks 30)
			)
			(5
				(side4 init:)
				(= ticks 180)
			)
			(6
				(front dispose:)
				(side1 dispose:)
				(side2 dispose:)
				(side3 dispose:)
				(side4 dispose:)
				(= ticks 90)
			)
			(7
				(corner1_2 init:)
				(= ticks 500)
			)
			(8
				(corner1_2 dispose:)
				(= ticks 40)
			)
			(9
				(front init:)
				(side1 init:)
				(= ticks 45)
			)
			(10
				(corner1_2 init:)
				(= ticks 45)
			)
			(11
				(side2 init:)
				(= ticks 45)
			)
			(12
				(corner2_3 init:)
				(= ticks 45)
			)
			(13
				(side3 init:)
				(= ticks 45)
			)
			(14
				(corner3_4 init:)
				(= ticks 45)
			)
			(15
				(side4 init:)
				(= ticks 45)
			)
			(16
				(corner1_4 init:)
				(= ticks 45)
			)
			(17
				(if (gTalkers isEmpty:)
					(self cue:)
				)
			)
			(18
				(gMessager say: 0 0 5 2 self 6004) ; "Here we have a four story building. The concept of numbering still applies. Numbers are assigned to all openings and all levels. Each opening is numbered, beginning from the left to the right, bottom to the top. Each level is numbered from the bottom up. Consequently, looking at the example here, the door would be referred to as level one, opening two. If you have suspect information to relay, you will do so using this technique. Is that clear?"
				(building init:)
				(= ticks 540)
			)
			(19
				(self setScript: sHighLightWin)
				(= ticks 340)
			)
			(20
				(level1 init:)
				(= ticks 30)
			)
			(21
				(level2 init:)
				(= ticks 30)
			)
			(22
				(level3 init:)
				(= ticks 30)
			)
			(23
				(level4 init:)
				(= ticks 120)
			)
			(24
				(win1 dispose:)
				(door dispose:)
				(win3 dispose:)
				(win4 dispose:)
				(win5 dispose:)
				(win6 dispose:)
				(win7 dispose:)
				(win8 dispose:)
				(win9 dispose:)
				(win10 dispose:)
				(win11 dispose:)
				(win12 dispose:)
				(level1 dispose:)
				(level2 dispose:)
				(level3 dispose:)
				(level4 dispose:)
				(= ticks 60)
			)
			(25
				(level1 init:)
				(door init:)
				(if (gTalkers isEmpty:)
					(self cue:)
				)
			)
			(26
				(iBlackBoard dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sHighLightWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(win1 init:)
				(= ticks 30)
			)
			(1
				(door init:)
				(= ticks 30)
			)
			(2
				(win3 init:)
				(= ticks 30)
			)
			(3
				(win4 init:)
				(= ticks 30)
			)
			(4
				(win5 init:)
				(= ticks 30)
			)
			(5
				(win6 init:)
				(= ticks 30)
			)
			(6
				(win7 init:)
				(= ticks 30)
			)
			(7
				(win8 init:)
				(= ticks 30)
			)
			(8
				(win9 init:)
				(= ticks 30)
			)
			(9
				(win10 init:)
				(= ticks 30)
			)
			(10
				(win11 init:)
				(= ticks 30)
			)
			(11
				(win12 init:)
				(= ticks 30)
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance iTV of Inset
	(properties
		picture 182
	)

	(method (init)
		(super init: &rest)
		(Palette 2 42 254 100) ; PalIntensity
		(fuzz init:)
		(self setScript: sTVRookerTrains2)
	)

	(method (dispose)
		(Palette 2 42 254 0) ; PalIntensity
		(gEgo show:)
		(WalkieTalkie showFrame: 60116 0 163 90)
		(= global128 60116)
		(super dispose: &rest)
	)
)

(instance sTVRookerTrains2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(vcrLight init:)
				(fuzz setCycle: End self)
			)
			(2
				(= cycles 2)
			)
			(3
				(localproc_0)
				(= cycles 1)
			)
			(4
				(fuzz cel: 4 setCycle: Beg self)
			)
			(5
				(= ticks 15)
			)
			(6
				(fuzz dispose:)
				(vcrLight dispose:)
				(iTV dispose:)
				(self dispose:)
			)
		)
	)
)

(instance fuzz of Prop
	(properties
		x 110
		y 63
		view 182
		loop 2
	)
)

(instance brownBackgrnd of Prop ; UNUSED
	(properties
		x 95
		y 40
		view 182
		loop 1
	)
)

(instance vcrLight of Prop
	(properties
		x 473
		y 357
		view 182
		loop 3
		cel 1
	)

	(method (init)
		(self setPri: 600)
		(super init: &rest)
	)
)

