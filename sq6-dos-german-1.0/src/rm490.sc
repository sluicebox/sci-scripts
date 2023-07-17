;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use SQRoom)
(use rm300)
(use DText)
(use Str)
(use Array)
(use Print)
(use Inset)
(use Talker)
(use ROsc)
(use Osc)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm490 0
	tkrKielbasa 1
	Manuel_Auxveride 2
	Roger 3
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 param1 param2 param3 param4 param5)
	([global159 param1] dispose:)
	(= [global159 param1] 0)
	(if (== [global164 param1] param4)
		(= [global164 param1] 0)
	else
		(++ [global164 param1])
	)
	(if (and (gCast contains: currentText) (!= [global164 4] 0))
		(currentText hide:)
	else
		(currentText show:)
	)
	(localproc_1 param1 param2 param3 param5)
)

(procedure (localproc_1 param1 param2 param3 param4)
	(Message msgGET 490 param2 0 0 (+ [global164 param1] 1) (local0 data:))
	((= [global159 param1] (DText new:))
		text: (KString 8 (local0 data:)) ; StrDup
		fore: 117
		font: param4
		x: (if (== param1 4) 166 else 163)
		y: param3
		setPri: 50
		setSize: 300
		init:
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(if [global159 temp0]
			([global159 temp0] dispose:)
			(= [global159 temp0] 0)
		)
	)
)

(procedure (localproc_3)
	(if
		(and
			(== [global164 0] 8)
			(== [global164 1] 0)
			(== [global164 2] 8)
			(== [global164 3] 0)
			(== [global164 4] 0)
		)
		(SetFlag 97)
	else
		(ClearFlag 97)
	)
)

(procedure (localproc_4 param1 param2 param3 param4)
	(if (< argc 4)
		(= param4 0)
	)
	(Message msgGET 490 param1 param2 param3 1 (local0 data:))
	(= local1 (IntArray with: 0 0 0 0))
	(Text 0 (local1 data:) (local0 data:) (if (== param4 1) 60 else 490) 82)
	((= local2 (DText new:))
		text: (KString 8 (local0 data:)) ; StrDup
		fore: 117
		font: (if (== param4 1) 60 else 490)
		mode: 1
		x: (- 160 (/ (local1 at: 2) 2))
		y: (if (== param4 1) 79 else 75)
		setPri: 50
		setSize: 82
		init:
	)
)

(procedure (localproc_5)
	(cond
		((IsFlag 75)
			(ClearFlag 75)
			(if (IsFlag 51)
				(local2 dispose:)
			else
				(button_1 dispose:)
				(button_2 dispose:)
				(button_3 dispose:)
				(button_4 dispose:)
				(button_5 dispose:)
				(currentText dispose:)
				(localproc_2)
				(intermixDisplay dispose:)
			)
			(icdButton cel: 0)
		)
		((IsFlag 76)
			(ClearFlag 76)
			(local2 dispose:)
			(movieButton cel: 0)
		)
		((IsFlag 77)
			(ClearFlag 77)
			(local2 dispose:)
			(gamesButton cel: 0)
		)
		((IsFlag 73)
			(ClearFlag 73)
			(if (== (gCurRoom script:) sReadyForLaunch)
				(scanner setCycle: 0 dispose:)
				((gCurRoom script:) dispose:)
			)
			(local2 dispose:)
			(launchButton cel: 0)
		)
		((IsFlag 74)
			(ClearFlag 74)
			(local2 dispose:)
			(ptsLight dispose:)
			(ptsButton cel: 0)
			(ptsScreen cel: 0 setCycle: 0)
		)
		((IsFlag 78)
			(ClearFlag 78)
			(SetFlag 198)
			(if local4
				(spcCd init:)
				(= local4 0)
			)
			(bodyMap dispose:)
		)
		((IsFlag 79)
			(ClearFlag 79)
			(navScreen cel: 0)
			(local2 dispose:)
		)
	)
)

(procedure (localproc_6)
	(cond
		((IsFlag 75)
			(icdButton cel: 1)
			(if (IsFlag 51)
				(localproc_4 42 4 10)
			else
				(intermixDisplay init:)
			)
		)
		((IsFlag 76)
			(movieButton cel: 1)
			(localproc_4 49 0 0)
		)
		((IsFlag 77)
			(gamesButton cel: 1)
			(localproc_4 48 0 0)
		)
		((IsFlag 73)
			(launchButton cel: 1)
			(localproc_3)
			(if (IsFlag 97)
				(if (or (IsFlag 139) (IsFlag 158) (IsFlag 51))
					(localproc_4 10 4 10)
				else
					(localproc_4 57 0 0)
				)
			else
				(localproc_4 44 0 0)
			)
		)
		((IsFlag 74)
			(ptsButton cel: 1)
			(ptsLight init:)
			(ptsScreen cel: (ptsScreen lastCel:))
			(if (IsFlag 94)
				(cond
					((IsFlag 86)
						(localproc_4 55 0 0)
					)
					((IsFlag 85)
						(localproc_4 54 0 0)
					)
					(else
						(localproc_4 31 0 0)
					)
				)
			else
				(localproc_4 59 0 0)
			)
		)
		((IsFlag 78)
			(cond
				((and (IsFlag 98) (IsFlag 127))
					(bodyMap loop: 6 cel: 0 init:)
				)
				((IsFlag 98)
					(bodyMap loop: 5 cel: 0 init:)
				)
				(else
					(bodyMap loop: 4 cel: 0 init:)
				)
			)
			(= local4 1)
		)
		((IsFlag 79)
			(navScreen cel: (navScreen lastCel:))
			(localproc_4 61 0 0)
		)
	)
)

(procedure (localproc_7)
	(fakeArm view: 492 loop: 0 cel: 1 cycleSpeed: 6 posn: 22 83)
)

(procedure (localproc_8)
	(gGame handsOn:)
	(gTheIconBar curIcon: (gTheIconBar at: 2) setupExit: 1 enable: 0)
)

(procedure (localproc_9) ; UNUSED
	(if (and (== (ptsPicture loop:) 6) (== (ptsPicture cel:) 0))
		(gCurRoom setScript: sGoToPolysorbate)
	)
)

(instance rm490 of SQRoom
	(properties
		noun 1
		picture 490
	)

	(method (init)
		(= local0 (Str newWith: 80 {}))
		(Load rsVIEW 491 492 496 4920 9612 9613 9614 9615)
		(Load rsFONT 50 490 491 492)
		(Load rsMESSAGE 490)
		(Load rsSOUND 492)
		(Load rsSCRIPT 64929)
		(Load rsHEAP 64929)
		(if (not (IsFlag 157))
			(Load rsVIEW 4930)
			(Load rsMESSAGE 490)
		)
		(super init:)
		(gGame handsOff:)
		(pts init:)
		(leftSeat init:)
		(rightSeat init:)
		(trunkLatch init:)
		(hoodLatch init:)
		(spcSlotLeft init:)
		(spcSlotRight init:)
		(leftSpc init:)
		(rightSpc init:)
		(mainScreen init:)
		(retScanner init:)
		(icdButton init:)
		(ptsButton init:)
		(gamesButton init:)
		(movieButton init:)
		(powerButton init:)
		(launchButton init:)
		(manualButton init:)
		(fakeEgo init:)
		(fakeArm init:)
		(gloveLid init:)
		(powerLights1 init:)
		(powerLights2 init:)
		(powerLights3 init:)
		(leftHandle init:)
		(rightHandle init:)
		(ptsScreen init:)
		(navScreen init:)
		(rightScreen init:)
		(littleScreen init:)
		(weaponsScreen init:)
		(if (IsFlag 50)
			(powerLights1 setCycle: Fwd)
			(powerLights2 setCycle: Fwd)
			(powerLights3 setCycle: CT 8 1 powerLights3)
			(powerButton cel: (powerButton lastCel:))
			(rightHandle cel: (rightHandle lastCel:))
			(leftHandle cel: (leftHandle lastCel:))
			(littleScreen cel: (littleScreen lastCel:))
			(rightScreen cel: (rightScreen lastCel:))
			(weaponsScreen cel: (weaponsScreen lastCel:))
			(localproc_6)
		)
		(if (IsFlag 87)
			(photo init: cel: (photo lastCel:))
		)
		(if (IsFlag 96)
			(shuttleHood init:)
		)
		(if (not (OneOf gShuttleRoomNum 470 0))
			(cockpitView init:)
		)
		(if (IsFlag 198)
			(spcCd init:)
		)
		(if (== gPrevRoomNum 610)
			(SetFlag 157)
			(SetFlag 158)
		)
		(cond
			((and (IsFlag 100) (IsFlag 103))
				(ptsPicture loop: 6 cel: 0 init:)
			)
			((and (IsFlag 102) (IsFlag 101))
				(ptsPicture loop: 6 cel: 1 init:)
			)
			((IsFlag 100)
				(ptsPicture loop: 5 cel: 0 init:)
			)
			((IsFlag 101)
				(ptsPicture loop: 7 cel: 0 init:)
			)
			((IsFlag 102)
				(ptsPicture loop: 5 cel: 1 init:)
			)
			((IsFlag 103)
				(ptsPicture loop: 7 cel: 1 init:)
			)
		)
		(if (== gPrevRoomNum 455)
			(gGSound2 number: 493 play: setVol: 80)
			(gCurRoom setScript: sLaunchTheShuttle)
		else
			(localproc_8)
			(if (IsFlag 94)
				(manualOveride init: setScript: sManualSpeaks)
			)
		)
	)
)

(instance sManualGoAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(buttonSound number: 921 play: self)
			)
			(1
				(ClearFlag 94)
				(buttonSound number: 4901 play: self)
				(manualOveride setCycle: Beg manualOveride)
				(if (and (not (IsFlag 158)) (IsFlag 157))
					(client setCycle: Fwd)
				else
					(client setCycle: Beg)
				)
			)
			(2
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sPopTheHood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 4906)
				(= cycles 1)
			)
			(1
				(fakeArm view: 4991 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(if (IsFlag 96)
					(gMessager say: 6 4 14 0 self) ; "The hood is already open."
				else
					(buttonSound number: 497 play:)
					(SetFlag 96)
					(shuttleHood init:)
					(= cycles 1)
				)
				(fakeArm setCycle: Beg self)
			)
			(3)
			(4
				(gGame points: 3 511)
				(= cycles 5)
			)
			(5
				(localproc_7)
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sPopTheTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(fakeArm view: 4991 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(if (IsFlag 95)
					(gMessager say: 5 4 14 0 self) ; "The trunk is already open."
				else
					(buttonSound number: 497 play: self)
				)
				(fakeArm setCycle: Beg self)
			)
			(3)
			(4
				(= cycles 10)
			)
			(5
				(if (IsFlag 95)
					(= cycles 1)
				else
					(SetFlag 95)
					(gMessager say: 5 4 1 0 self) ; "You pull the handle and hear something release on the outside of the shuttle."
				)
			)
			(6
				(gGame points: 3 512)
				(= cycles 5)
			)
			(7
				(localproc_7)
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToManual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar setupExit: 0)
				(gGame handsOff:)
				(Load rsSCRIPT 64912)
				(Load rsHEAP 64912)
				(= cycles 10)
			)
			(1
				(DoAudio audPLAY 490 40 0 24 3) ; "What may I do for you, Sir?"
				(gGame setCursor: gNormalCursor 1)
				(if
					((Print new:)
						addBitmap: 4954 0 0
						addButtonBM: 4954 1 0 1 { } 4 3
						addButtonBM: 4954 2 0 0 { } 31 15
						init:
					)
					(gGame setCursor: gWaitCursor 1)
					(= cycles 1)
				else
					(DoAudio audSTOP 490 40 0 24 3) ; "What may I do for you, Sir?"
					(localproc_8)
					(gGame setCursor: (gTheIconBar getCursor:))
					(self dispose:)
				)
			)
			(2
				(DoAudio audSTOP 490 40 0 24 3) ; "What may I do for you, Sir?"
				(= cycles 1)
			)
			(3
				(gMessager say: 0 0 37 0 self) ; "Step over to the transport pad and I will beam you down to the surface of Polysorbate."
			)
			(4
				(SetFlag 185)
				(gCurRoom newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance sSetUpManual of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(buttonSound number: 921 play: self)
			)
			(1
				(= ticks 60)
			)
			(2
				(Fade 1 1 self)
			)
			(3
				(gCurRoom setInset: inManualArrives self)
			)
			(4
				(= cycles 10)
			)
			(5
				(manualOveride cel: (manualOveride lastCel:) init:)
				(= cycles 1)
			)
			(6
				(Fade 0 1 self)
			)
			(7
				(gGame points: 5 418)
				(= cycles 5)
			)
			(8
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sShowMovies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (gloveLid cel:) 1)
					(gloveLid doVerb: 4)
				)
				(= ticks 45)
			)
			(1
				(rightHandle cel: 0)
				(local2 dispose:)
				(= ticks 45)
			)
			(2
				(gGame setCursor: gNormalCursor 1)
				(gTheIconBar clearInvItem:)
				(switch
					(Print
						font: gUserFont
						addTitle: {Let's Make Some Movie Magic}
						addButton: 1 {Shuttle Leave Deepship} 31 0
						addButton:
							2
							{Shuttle Get's Sucked Into Anti-Anomaly}
							0
							13
						addButton: 3 {Shuttle Travels in Space} 28 26
						addButton: 4 {Leaving Delta Burksilon} 30 39
						addButton: 5 {Deepship Into The Sunset} 28 52
						addButton: 0 {Enough Already} 47 75
						init:
					)
					(0
						(rightHandle cel: 1)
						(localproc_4 49 0 0)
						(gGame handsOn:)
						(gGame setCursor: (gTheIconBar getCursor:))
						(self dispose:)
					)
					(1
						(if (<= gHowFast 3)
							(PlayVMD 0 {450.vmd}) ; Open
							(PlayVMD 1 0 0) ; Put
						else
							(PlayVMD 0 {1450.vmd}) ; Open
							(PlayVMD 1 109 57) ; Put
						)
						(= cycles 1)
					)
					(2
						(if (<= gHowFast 3)
							(PlayVMD 0 {490.vmd}) ; Open
							(PlayVMD 1 0 0) ; Put
						else
							(PlayVMD 0 {1490.vmd}) ; Open
							(PlayVMD 1 109 57) ; Put
						)
						(= cycles 1)
					)
					(3
						(if (<= gHowFast 3)
							(PlayVMD 0 {491.vmd}) ; Open
							(PlayVMD 1 0 0) ; Put
						else
							(PlayVMD 0 {1491.vmd}) ; Open
							(PlayVMD 1 109 57) ; Put
						)
						(= cycles 1)
					)
					(4
						(if (<= gHowFast 3)
							(PlayVMD 0 {500.vmd}) ; Open
							(PlayVMD 1 0 0) ; Put
						else
							(PlayVMD 0 {1500.vmd}) ; Open
							(PlayVMD 1 109 57) ; Put
						)
						(= cycles 1)
					)
					(5
						(gTheIconBar hide: 1)
						(if (<= gHowFast 3)
							(PlayVMD 0 {540.vmd}) ; Open
							(PlayVMD 1 0 0) ; Put
						else
							(PlayVMD 0 {1540.vmd}) ; Open
							(PlayVMD 1 109 57) ; Put
						)
						(= cycles 1)
					)
				)
			)
			(3
				(PlayVMD 21 0 0 320 138) ; Black
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 1)
			)
			(4
				(self changeState: 2)
			)
		)
	)
)

(instance sDoTheSounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 15)
			)
			(1
				(buttonSound number: 354 play: self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sInsertSpc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 354 355 498) ; WAVE
				(fakeArm
					view: 4920
					loop: 1
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(gEgo put: 103) ; Subroutine_Card
				(buttonSound number: 498 play: self)
				(localproc_5)
				(localproc_7)
				(SetFlag 78)
				(= local4 1)
				(localproc_4 30 0 0)
			)
			(2
				(= ticks 240)
			)
			(3
				(local2 dispose:)
				(bodyMap loop: 2 cel: 0 init: setCycle: End self)
				(self setScript: sDoTheSounds)
			)
			(4
				(self setScript: 0)
				(sDoTheSounds dispose:)
				(= ticks 120)
			)
			(5
				(bodyMap loop: 3 cel: 0 show:)
				(= cycles 30)
			)
			(6
				(cond
					((and (IsFlag 98) (IsFlag 127))
						(bodyMap loop: 6 cel: 0 show:)
					)
					((IsFlag 98)
						(bodyMap loop: 5 cel: 0 show:)
					)
					(else
						(bodyMap loop: 4 cel: 0 show:)
					)
				)
				(buttonSound number: 355 play: self)
			)
			(7
				(gGame points: 3 400)
				(= cycles 5)
			)
			(8
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sNoFuel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_5)
				(SetFlag 73)
				(localproc_4 10 4 10)
				(= ticks 60)
			)
			(1
				(gMessager say: 10 4 34 0 self) ; "I guess I won't get far without fuel."
			)
			(2
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sNoDisc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_4 10 4 10)
				(= ticks 60)
			)
			(1
				(gMessager say: 10 4 35 0 self) ; "Perhaps I'd get farther if I kept the Subroutine Disc in its slot."
			)
			(2
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sTravelToBrain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar setupExit: 0)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(bodyMap dispose:)
				(localproc_4 10 4 28)
				(buttonSound number: 491 play:)
				(= ticks 200)
			)
			(2
				(SetFlag 78)
				(= gShuttleStatus 3)
				(= gShuttleRoomNum 740)
				(gCurRoom newRoom: 610)
				(self dispose:)
			)
		)
	)
)

(instance sTravelToStomach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar setupExit: 0)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(bodyMap dispose:)
				(localproc_4 10 4 36)
				(buttonSound number: 491 play:)
				(= ticks 200)
			)
			(2
				(SetFlag 78)
				(= gShuttleStatus 2)
				(= gShuttleRoomNum 610)
				(gCurRoom newRoom: 740)
				(self dispose:)
			)
		)
	)
)

(instance sGoToPolysorbate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(localproc_4 10 4 38)
				(buttonSound number: 491 play: self)
			)
			(2
				(= cycles 20)
			)
			(3
				(localproc_5)
				(if (<= gHowFast 3)
					(PlayVMD 0 {492.vmd}) ; Open
					(PlayVMD 1 0 0) ; Put
				else
					(PlayVMD 0 {1492.vmd}) ; Open
					(PlayVMD 1 109 57) ; Put
				)
				(PlayVMD 21 0 0 320 138) ; Black
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 1)
			)
			(4
				(= ticks 120)
			)
			(5
				(SetFlag 186)
				(gTheIconBar setupExit: 1)
				(localproc_8)
				(gGame setCursor: (gTheIconBar getCursor:))
				(self dispose:)
			)
		)
	)
)

(instance sGoToDelta of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar setupExit: 0)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(localproc_4 10 4 38)
				(buttonSound number: 491 play: self)
			)
			(2
				(Fade 1 1 self)
			)
			(3
				(localproc_5)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: -1 0)
				(gTheIconBar clearInvItem:)
				(= cycles 1)
			)
			(4
				(gGSound1 stop:)
				(Fade 0 1 self)
			)
			(5
				(if (<= gHowFast 3)
					(PlayVMD 0 {491.vmd}) ; Open
					(PlayVMD 1 0 0) ; Put
				else
					(PlayVMD 0 {1491.vmd}) ; Open
					(PlayVMD 1 109 57) ; Put
				)
				(PlayVMD 21 0 0 320 138) ; Black
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 1)
			)
			(6
				(= gShuttleRoomNum 500)
				(ClearFlag 139)
				(ClearFlag 186)
				(SetFlag 171)
				(gCurRoom style: 0)
				(gCurRoom newRoom: 495)
				(self dispose:)
			)
		)
	)
)

(instance sManualSpeaks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(buttonSound number: 921 play: self)
				else
					(= cycles 1)
				)
			)
			(1
				(if register
					(buttonSound number: 499 play: self)
					(manualOveride init: setCycle: End self)
				else
					(manualOveride cel: (manualOveride lastCel:) init:)
					(self changeState: 3)
				)
			)
			(2)
			(3
				(cond
					(
						(and
							(IsFlag 190)
							(not (IsFlag 206))
							(gCast contains: ptsPicture)
						)
						(SetFlag 206)
						(gMessager say: 40 0 32 0 self) ; "The PTS is on-line and working. We can now launch to Polysorbate."
					)
					((and (IsFlag 187) (not (IsFlag 194)) (not (IsFlag 190)))
						(SetFlag 194)
						(gMessager say: 40 2 9 0 self) ; "Sir, I believe I may be able to tap myself into the PTS and perform a limited set of functions."
					)
					(
						(and
							(not (IsFlag 195))
							(not (IsFlag 186))
							(not (IsFlag 187))
							(not (IsFlag 51))
							(IsFlag 420)
							(IsFlag 82)
						)
						(SetFlag 195)
						(gMessager say: 40 2 15 0 self) ; "Good work, Sir. I believe I can now follow the ion trail of DeepShip 86 back to Delta Burksilon V."
					)
					(else
						(gMessager say: 40 0 24 (RandomNumber 1 5) self)
					)
				)
			)
			(4
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sRemovePhoto of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(fakeArm
					view: 498
					loop: 2
					cel: 0
					posn: 23 84
					setCycle: CT 4 1 self
				)
			)
			(2
				(photo dispose:)
				(ClearFlag 87)
				(if (IsFlag 86)
					(gEgo get: 97) ; Second_Photo
				else
					(gEgo get: 49) ; First_Photo
				)
				(fakeArm setCycle: End self)
			)
			(3
				(localproc_7)
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sRemovePosFromScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(fakeArm view: 498 loop: 3)
				(fakeArm
					cel: (fakeArm lastCel:)
					posn: 23 84
					setCycle: CT 3 -1 self
				)
			)
			(2
				(cond
					((IsFlag 101)
						(ptsPicture loop: 7 cel: 0 init:)
					)
					((IsFlag 103)
						(ptsPicture loop: 7 cel: 1 init:)
					)
					(else
						(ptsPicture hide:)
					)
				)
				(fakeArm setCycle: Beg self)
			)
			(3
				(localproc_7)
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sRemoveNegFromScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(fakeArm view: 498 loop: 4)
				(fakeArm
					cel: (fakeArm lastCel:)
					posn: 23 84
					setCycle: CT 3 -1 self
				)
			)
			(2
				(cond
					((IsFlag 100)
						(ptsPicture loop: 5 cel: 0 show:)
					)
					((IsFlag 102)
						(ptsPicture loop: 5 cel: 1 show:)
					)
					(else
						(ptsPicture hide:)
					)
				)
				(fakeArm setCycle: Beg self)
			)
			(3
				(localproc_7)
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sPlacePosOnScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(fakeArm
					view: 498
					loop: 3
					cel: 0
					posn: 23 84
					setCycle: CT 3 1 self
				)
			)
			(2
				(if register
					(gEgo put: 50) ; First_Positive
				else
					(gEgo put: 98) ; Second_Positive
				)
				(ptsPicture
					loop: (if (or (IsFlag 103) (IsFlag 101)) 6 else 5)
					cel: (if register 0 else 1)
					init:
				)
				(fakeArm setCycle: End self)
			)
			(3
				(if
					(or
						(and (IsFlag 101) (IsFlag 102))
						(and (IsFlag 103) (IsFlag 100))
					)
					(buttonSound number: 325 play:)
					(ptsPicture loop: 9 cel: 0 setCycle: End self)
					(SetFlag 190)
					(ClearFlag 100)
					(ClearFlag 102)
					(ClearFlag 101)
					(ClearFlag 103)
					(gEgo put: 48) ; First_Negative
					(gEgo put: 50) ; First_Positive
					(gEgo put: 96) ; Second_Negative
					(gEgo put: 98) ; Second_Positive
				else
					(= cycles 1)
				)
			)
			(4
				(if (IsFlag 190)
					(ptsPicture dispose:)
				)
				(if (and (IsFlag 190) (IsFlag 94))
					(SetFlag 206)
					(gMessager say: 40 0 32 0 self) ; "The PTS is on-line and working. We can now launch to Polysorbate."
				else
					(= cycles 1)
				)
			)
			(5
				(if (IsFlag 190)
					(gGame points: 5)
				)
				(= cycles 5)
			)
			(6
				(localproc_7)
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sPlaceNegOnScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(fakeArm
					view: 498
					loop: 4
					cel: 0
					posn: 23 84
					setCycle: CT 3 1 self
				)
			)
			(2
				(ptsPicture
					loop: (if (or (IsFlag 102) (IsFlag 100)) 6 else 7)
					cel: (if register 0 else 1)
					init:
				)
				(if register
					(gEgo put: 48) ; First_Negative
				else
					(gEgo put: 96) ; Second_Negative
				)
				(fakeArm setCycle: End self)
			)
			(3
				(if
					(or
						(and (IsFlag 101) (IsFlag 102))
						(and (IsFlag 103) (IsFlag 100))
					)
					(buttonSound number: 325 play:)
					(ptsPicture loop: 9 cel: 0 setCycle: End self)
					(SetFlag 190)
					(ClearFlag 100)
					(ClearFlag 102)
					(ClearFlag 101)
					(ClearFlag 103)
					(gEgo put: 48) ; First_Negative
					(gEgo put: 50) ; First_Positive
					(gEgo put: 96) ; Second_Negative
					(gEgo put: 98) ; Second_Positive
				else
					(= cycles 1)
				)
			)
			(4
				(if (IsFlag 190)
					(ptsPicture dispose:)
				)
				(if (and (IsFlag 190) (IsFlag 94))
					(SetFlag 206)
					(gMessager say: 40 0 32 0 self) ; "The PTS is on-line and working. We can now launch to Polysorbate."
				else
					(= cycles 1)
				)
			)
			(5
				(if (IsFlag 190)
					(gGame points: 5)
				)
				(= cycles 5)
			)
			(6
				(localproc_7)
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sPushPtsButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(buttonSound number: 919 play: self)
				(ptsLight cel: 0)
			)
			(1
				(buttonSound number: 47001 play: self)
				(photo init: cel: 0 setCycle: End self)
			)
			(2)
			(3
				(ptsLight cel: 1)
				(if (IsFlag 86)
					(local2 dispose:)
					(localproc_4 55 0 0)
				else
					(local2 dispose:)
					(localproc_4 54 0 0)
				)
				(SetFlag 87)
				(= cycles 10)
			)
			(4
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance scanner of Prop
	(properties
		x 136
		y 48
		view 492
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(108 ; Sidney_Eye
				(if
					(and
						(== (gCurRoom script:) sReadyForLaunch)
						(== ((gCurRoom script:) state:) 2)
					)
					((gCurRoom script:) seconds: 0)
					((gCurRoom script:) changeState: 5)
				else
					(gMessager say: noun theVerb 3)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sReadyForLaunch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_4 45 0 0)
				(scanner init: setCycle: End self)
			)
			(1
				(scanner loop: 4 setCycle: Fwd)
				(= cycles 5)
			)
			(2
				(localproc_8)
				(= seconds 15)
			)
			(3
				(gTheIconBar enable:)
				(gGame handsOff:)
				(scanner setCycle: 0 dispose:)
				(local2 dispose:)
				(localproc_4 57 0 0)
				(buttonSound number: 490 play:)
				(= ticks 300)
			)
			(4
				(localproc_5)
				(localproc_8)
				(self dispose:)
			)
			(5
				(gGame handsOff: points: 7 408)
				(gEgo put: 101) ; Sidney_Eye
				(gEgo put: 100) ; Sidney_Arm
				(= ticks 60)
			)
			(6
				(gMessager say: 32 108 0 0 self) ; "Let's see if this sucker works."
			)
			(7
				(= ticks 30)
			)
			(8
				(gGame points: 3)
				(fakeArm view: 492 loop: 2 cel: 0 setCycle: End self)
			)
			(9
				(= ticks 180)
			)
			(10
				(fakeArm setCycle: Beg self)
			)
			(11
				(localproc_7)
				(local2 dispose:)
				(scanner setCycle: 0 dispose:)
				(localproc_4 56 0 0)
				(buttonSound number: 491 play:)
				(= ticks 180)
			)
			(12
				(SetFlag 139)
				(gCurRoom newRoom: 455)
				(self dispose:)
			)
		)
	)
)

(instance sLaunchTheShuttle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(Load 140 363 917) ; WAVE
			)
			(1
				(RemapColors 2 244 175) ; ByPercent
				(PalCycle 0 200 235 -1 5) ; Start
				(if (== (gloveLid cel:) 1)
					(gloveLid doVerb: 4)
				)
				(= cycles 10)
			)
			(2
				(buttonSound number: 363 play: self)
				(kielbasaScreen init: setCycle: End self)
			)
			(3)
			(4
				(= ticks 120)
			)
			(5
				(kielbasaStatic init: setCycle: Fwd)
				(kielbasaScreen loop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gMessager sayRange: 60 0 0 1 11 self) ; "Janitor Wilco, what are you doing?! You have no authorization to take that shuttle. To make matters worse, you have launched into the middle of a Super Double Reverse Anti-Anomaly!"
			)
			(7
				(kielbasaScreen loop: 2 cel: 0)
				(= ticks 120)
			)
			(8
				(kielbasaStatic dispose:)
				(buttonSound number: 917 play: self)
				(kielbasaScreen setCycle: End self)
			)
			(9)
			(10
				(RemapColors 0) ; Off
				(= ticks 45)
			)
			(11
				(Fade 1 1 self)
			)
			(12
				(localproc_5)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: -1 0)
				(= cycles 1)
			)
			(13
				(gMessager say: 60 0 0 12 self) ; "Just then the shuttle is sucked into the anti-anomaly. Communication with the DeepShip has been disrupted."
			)
			(14
				(gGSound2 stop:)
				(gGSound1 stop:)
				(Fade 0 1 self)
			)
			(15
				(PalCycle 4) ; Off
				(if (<= gHowFast 3)
					(PlayVMD 0 {490.vmd}) ; Open
					(PlayVMD 1 0 0) ; Put
				else
					(PlayVMD 0 {1490.vmd}) ; Open
					(PlayVMD 1 109 57) ; Put
				)
				(PlayVMD 21 0 0 320 138) ; Black
				(PlayVMD 14 7) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 3)
			)
			(16
				(Fade 1 1 self)
			)
			(17
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 490 0)
				(= gShuttleRoomNum 470)
				(powerLights1 setCycle: 0 cel: 0)
				(powerLights2 setCycle: 0 cel: 0)
				(powerLights3 setCycle: 0 cel: 0)
				(rightHandle setCycle: 0 cel: 0)
				(leftHandle setCycle: 0 cel: 0)
				(littleScreen setCycle: 0 cel: 0)
				(rightScreen setCycle: 0 cel: 0)
				(weaponsScreen setCycle: 0 cel: 0)
				(localproc_5)
				(powerButton cel: 0)
				(manualButton setCycle: Fwd)
				(ClearFlag 50)
				(SetFlag 51)
				(SetFlag 157)
				(= cycles 5)
			)
			(18
				(Fade 0 1 self)
			)
			(19
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance sButtonAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(buttonSound number: 921 play: self)
				(client setCycle: End self)
			)
			(1)
			(2
				(client setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance bodyMap of Prop
	(properties
		noun 1
		x 116
		y 70
		priority 49
		fixPriority 1
		view 4920
		loop 2
	)
)

(instance navScreen of Prop
	(properties
		noun 11
		x 41
		y 87
		view 491
		loop 20
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(fakeArm view: 4921 loop: 0 cel: 0 setCycle: End self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (== (fakeArm cel:) 0)
			(localproc_7)
			(localproc_8)
		else
			(cond
				((not (IsFlag 50))
					(gMessager say: 50) ; "The power is not currently on."
				)
				((IsFlag 79)
					(buttonSound number: 921 play:)
					(ClearFlag 79)
					(self cel: 0 setCycle: 0)
					(local2 dispose:)
				)
				(else
					(buttonSound number: 921 play:)
					(localproc_5)
					(SetFlag 79)
					(self cel: 0 setCycle: End)
					(localproc_4 61 0 0)
				)
			)
			(fakeArm setCycle: Beg self)
		)
	)
)

(instance photo of Prop
	(properties
		x 162
		y 64
		view 498
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sRemovePhoto)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance kielbasaScreen of Prop
	(properties
		x 116
		y 70
		view 4930
	)
)

(instance kielbasaStatic of Prop
	(properties
		x 116
		y 70
		priority 201
		fixPriority 1
		view 493
		loop 3
		cycleSpeed 5
	)
)

(instance button_1 of Prop
	(properties
		name {button#1}
		x 156
		y 77
		view 491
		loop 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== cel 0)
					(self setScript: (sButtonAction new:))
					(localproc_0 0 34 77 11 492)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance button_2 of Prop
	(properties
		name {button#2}
		x 156
		y 83
		view 491
		loop 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== cel 0)
					(self setScript: (sButtonAction new:))
					(localproc_0 1 35 84 11 490)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance button_3 of Prop
	(properties
		name {button#3}
		x 156
		y 89
		view 491
		loop 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== cel 0)
					(self setScript: (sButtonAction new:))
					(localproc_0 2 36 90 11 490)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance button_4 of Prop
	(properties
		name {button#4}
		x 156
		y 95
		view 491
		loop 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== cel 0)
					(self setScript: (sButtonAction new:))
					(localproc_0 3 37 96 11 491)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance button_5 of Prop
	(properties
		name {button#5}
		x 158
		y 104
		view 491
		loop 19
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== cel 0)
					(self setScript: (sButtonAction new:))
					(localproc_0 4 46 105 3 490)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ptsButton of Prop
	(properties
		noun 58
		x 85
		y 89
		view 497
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(fakeArm view: 498 loop: 0 cel: 0 setCycle: End self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (== (fakeArm cel:) 0)
			(localproc_7)
			(localproc_8)
		else
			(cond
				((or (IsFlag 51) (not (IsFlag 50)))
					(gMessager say: 50) ; "The power is not currently on."
				)
				((IsFlag 74)
					(buttonSound number: 920 play:)
					(ClearFlag 74)
					(ptsScreen cel: 0)
					(ptsLight dispose:)
					(local2 dispose:)
					(= cel 0)
				)
				(else
					(buttonSound number: 920 play:)
					(localproc_5)
					(SetFlag 74)
					(ptsLight init:)
					(ptsScreen cel: 0 setCycle: End)
					(if (IsFlag 187)
						(cond
							((IsFlag 86)
								(localproc_4 55 0 0)
							)
							((IsFlag 85)
								(localproc_4 54 0 0)
							)
							(else
								(localproc_4 31 0 0)
							)
						)
					else
						(localproc_4 59 0 0)
					)
					(= cel 1)
				)
			)
			(fakeArm setCycle: Beg self)
		)
	)
)

(instance icdButton of Prop
	(properties
		noun 42
		x 84
		y 96
		view 491
		loop 8
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(fakeArm view: 4920 loop: 0 cel: 0 setCycle: End self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (== (fakeArm cel:) 0)
			(localproc_7)
			(localproc_8)
		else
			(cond
				((or (IsFlag 51) (not (IsFlag 50)))
					(gMessager say: 50) ; "The power is not currently on."
				)
				((IsFlag 75)
					(buttonSound number: 920 play:)
					(ClearFlag 75)
					(button_1 dispose:)
					(button_2 dispose:)
					(button_3 dispose:)
					(button_4 dispose:)
					(button_5 dispose:)
					(currentText dispose:)
					(intermixDisplay dispose:)
					(localproc_2)
					(= cel 0)
				)
				(else
					(buttonSound number: 920 play:)
					(localproc_5)
					(SetFlag 75)
					(intermixDisplay init:)
					(= cel 1)
				)
			)
			(fakeArm setCycle: Beg self)
		)
	)
)

(instance powerButton of Prop
	(properties
		noun 9
		x 71
		y 73
		view 491
		loop 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(fakeArm view: 492 loop: 1 cel: 0 setCycle: End self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(cond
			((== (fakeArm cel:) 0)
				(if local5
					(= local5 0)
					(gMessager say: 9 4 0 0 self) ; "Swell! There's not enough power to restart the engines!"
				else
					(localproc_7)
					(localproc_8)
				)
			)
			((IsFlag 51)
				(= local5 1)
				(fakeArm setCycle: Beg self)
			)
			((SetFlag 50)
				(buttonSound number: 921 play:)
				(gGSound1 stop:)
				(ClearFlag 50)
				(powerLights1 setCycle: 0 cel: 0)
				(powerLights2 setCycle: 0 cel: 0)
				(powerLights3 setCycle: 0 cel: 0)
				(rightHandle setCycle: 0 cel: 0)
				(leftHandle setCycle: 0 cel: 0)
				(littleScreen setCycle: 0 cel: 0)
				(rightScreen setCycle: 0 cel: 0)
				(weaponsScreen setCycle: 0 cel: 0)
				(localproc_5)
				(= cel 0)
				(fakeArm setCycle: Beg self)
			)
			(else
				(buttonSound number: 917 play:)
				(gGSound1 number: 492 loop: 0 play:)
				(SetFlag 50)
				(powerLights1 setCycle: Fwd)
				(powerLights2 setCycle: Fwd)
				(powerLights3 setCycle: CT 8 1 powerLights3)
				(rightHandle setCycle: End)
				(leftHandle setCycle: End)
				(littleScreen setCycle: End)
				(rightScreen setCycle: End)
				(weaponsScreen setCycle: End)
				(localproc_6)
				(= cel 1)
				(fakeArm setCycle: Beg self)
			)
		)
	)
)

(instance ptsPicture of Prop
	(properties
		x 94
		y 71
		view 498
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 100)
						(ClearFlag 100)
						(gEgo get: 50) ; First_Positive
						(self setScript: sRemovePosFromScreen 0 1)
					)
					((IsFlag 102)
						(ClearFlag 102)
						(gEgo get: 98) ; Second_Positive
						(self setScript: sRemovePosFromScreen 0 0)
					)
					((IsFlag 101)
						(ClearFlag 101)
						(gEgo get: 48) ; First_Negative
						(self setScript: sRemoveNegFromScreen 0 1)
					)
					((IsFlag 103)
						(ClearFlag 103)
						(gEgo get: 96) ; Second_Negative
						(self setScript: sRemoveNegFromScreen 0 0)
					)
				)
			)
			(119 ; First_Negative
				(if (not (IsFlag 103))
					(SetFlag 101)
					(gCurRoom setScript: sPlaceNegOnScreen 0 1)
				else
					(super doVerb: theVerb)
				)
			)
			(120 ; Second_Negative
				(if (not (IsFlag 101))
					(SetFlag 103)
					(gCurRoom setScript: sPlaceNegOnScreen 0 0)
				else
					(super doVerb: theVerb)
				)
			)
			(157 ; First_Positive
				(if (not (IsFlag 102))
					(SetFlag 100)
					(gCurRoom setScript: sPlacePosOnScreen 0 1)
				else
					(super doVerb: theVerb)
				)
			)
			(158 ; Second_Positive
				(if (not (IsFlag 100))
					(SetFlag 102)
					(gCurRoom setScript: sPlacePosOnScreen 0 0)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ptsScreen of Prop
	(properties
		noun 15
		x 90
		y 70
		view 497
		loop 2
	)

	(method (doVerb theVerb)
		(if
			(and
				(IsFlag 74)
				(not (IsFlag 101))
				(not (IsFlag 102))
				(not (IsFlag 103))
				(not (IsFlag 100))
			)
			(switch theVerb
				(157 ; First_Positive
					(SetFlag 100)
					(gCurRoom setScript: sPlacePosOnScreen 0 1)
				)
				(158 ; Second_Positive
					(SetFlag 102)
					(gCurRoom setScript: sPlacePosOnScreen 0 0)
				)
				(119 ; First_Negative
					(SetFlag 101)
					(gCurRoom setScript: sPlaceNegOnScreen 0 1)
				)
				(120 ; Second_Negative
					(SetFlag 103)
					(gCurRoom setScript: sPlaceNegOnScreen 0 0)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(gMessager say: noun 0 13) ; "You might want to fire up the sucker before you try that."
		)
	)
)

(instance fakeArm of Prop
	(properties
		noun 43
		x 22
		y 83
		priority 100
		fixPriority 1
		view 492
		cel 1
		signal 20513
	)
)

(instance ptsLight of Prop
	(properties
		noun 13
		x 153
		y 62
		view 497
		loop 1
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(fakeArm view: 498 loop: 8 cel: 0 setCycle: End self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (== (fakeArm cel:) 0)
			(localproc_7)
			(if (not (self script:))
				(localproc_8)
			)
		else
			(fakeArm setCycle: Beg self)
			(if (IsFlag 187)
				(cond
					((IsFlag 87)
						(gMessager say: noun 4 12) ; "You must remove the current photo before you attempt another shot."
					)
					((IsFlag 86)
						(gMessager say: noun 4 11) ; "There are no more pictures available for snapping."
					)
					((IsFlag 85)
						(SetFlag 86)
						(self setScript: sPushPtsButton)
					)
					(else
						(SetFlag 85)
						(self setScript: sPushPtsButton)
					)
				)
			else
				(gMessager say: noun 4) ; "You can't snap a picture if the PTS is off-line."
			)
		)
	)
)

(instance powerLights1 of Prop
	(properties
		noun 1
		x 129
		y 66
		view 491
		loop 2
	)
)

(instance powerLights2 of Prop
	(properties
		noun 1
		x 182
		y 67
		view 491
		loop 3
	)
)

(instance powerLights3 of Prop
	(properties
		noun 1
		x 41
		y 87
		view 491
		loop 6
	)

	(method (cue)
		(self setCycle: ROsc -1 9 16)
	)
)

(instance weaponsScreen of Prop
	(properties
		noun 22
		x 239
		y 71
		view 491
		loop 4
		signal 20513
	)
)

(instance rightScreen of Prop
	(properties
		noun 19
		x 208
		y 70
		view 491
		loop 5
		signal 20513
	)
)

(instance littleScreen of Prop
	(properties
		noun 23
		x 239
		y 83
		view 491
		loop 7
		signal 20513
	)
)

(instance manualButton of Prop
	(properties
		noun 12
		x 79
		y 99
		view 491
		loop 12
		signal 20513
		cycleSpeed 15
	)

	(method (init)
		(cond
			((IsFlag 94)
				(= cel 1)
			)
			((and (IsFlag 157) (not (IsFlag 158)))
				(self setCycle: Fwd)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(fakeArm view: 4921 loop: 2 cel: 0 setCycle: End self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (== (fakeArm cel:) 0)
			(localproc_7)
			(if (not (self script:))
				(localproc_8)
			)
		else
			(fakeArm setCycle: Beg self)
			(cond
				((IsFlag 158)
					(gMessager say: 12 4 27) ; "Oh, that's right, Manuel is off-line in here. He can't help me now."
				)
				((== gShuttleRoomNum 450)
					(gMessager say: 12 4 3) ; "Nothing happens. That button must not work at this time."
				)
				((IsFlag 94)
					(self setScript: sManualGoAway)
				)
				(else
					(if
						(and
							(not (IsFlag 418))
							(not (IsFlag 186))
							(not (IsFlag 187))
							(not (IsFlag 420))
							(not (IsFlag 82))
							(not (IsFlag 124))
						)
						(self setScript: sSetUpManual)
					else
						(self setScript: sManualSpeaks 0 1)
					)
					(localproc_5)
					(SetFlag 94)
					(self setCycle: End)
				)
			)
		)
	)
)

(instance leftHandle of Prop
	(properties
		noun 17
		x 68
		y 117
		priority 90
		fixPriority 1
		view 491
		loop 13
		cel 1
		signal 20513
	)
)

(instance rightHandle of Prop
	(properties
		noun 18
		x 246
		y 118
		priority 90
		fixPriority 1
		view 491
		loop 14
		cel 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (IsFlag 77) (IsFlag 45))
						(self setScript: sRememberingJosho)
					)
					((and (IsFlag 76) (IsFlag 45))
						(self setScript: sShowMovies)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spcCd of Prop
	(properties
		x 22
		y 83
		view 4920
		loop 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(fakeArm view: 4920 loop: 1 cycleSpeed: 10)
				(fakeArm cel: (fakeArm lastCel:) setCycle: Beg self)
				(ClearFlag 198)
				(gEgo get: 103) ; Subroutine_Card
				(self hide:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(localproc_7)
		(localproc_8)
		(self dispose:)
	)
)

(instance shuttleHood of View
	(properties
		priority 10
		fixPriority 1
		view 4906
	)
)

(instance movieButton of View
	(properties
		noun 20
		x 206
		y 88
		view 491
		loop 9
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 50))
						(gMessager say: 50) ; "The power is not currently on."
					)
					((IsFlag 76)
						(buttonSound number: 920 play:)
						(ClearFlag 76)
						(local2 dispose:)
						(= cel 0)
					)
					(else
						(buttonSound number: 920 play:)
						(localproc_5)
						(SetFlag 76)
						(localproc_4 49 0 0)
						(= cel 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gamesButton of View
	(properties
		noun 21
		x 206
		y 97
		view 491
		loop 10
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 50))
						(gMessager say: 50) ; "The power is not currently on."
					)
					((IsFlag 77)
						(buttonSound number: 920 play:)
						(ClearFlag 77)
						(local2 dispose:)
						(= cel 0)
					)
					(else
						(buttonSound number: 920 play:)
						(localproc_5)
						(SetFlag 77)
						(localproc_4 48 0 0)
						(= cel 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance launchButton of Prop
	(properties
		noun 10
		x 80
		y 79
		view 491
		loop 11
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(fakeArm view: 4921 loop: 0 cel: 0 setCycle: End self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (== (fakeArm cel:) 0)
			(localproc_7)
			(if (not (gCurRoom script:))
				(localproc_8)
			)
		else
			(fakeArm setCycle: Beg self)
			(cond
				((or (IsFlag 51) (not (IsFlag 50)))
					(gMessager say: 50) ; "The power is not currently on."
				)
				((IsFlag 73)
					(buttonSound number: 918 play:)
					(ClearFlag 73)
					(local2 dispose:)
					(= cel 0)
					(if (== (gCurRoom script:) sReadyForLaunch)
						(scanner setCycle: 0 dispose:)
						((gCurRoom script:) dispose:)
					)
				)
				(else
					(buttonSound number: 918 play:)
					(if (not local4)
						(localproc_5)
						(SetFlag 73)
					)
					(localproc_3)
					(if (IsFlag 97)
						(cond
							((IsFlag 158)
								(cond
									((not local4)
										(gCurRoom setScript: sNoDisc)
									)
									((== gShuttleRoomNum 610)
										(if (IsFlag 128)
											(gCurRoom setScript: sTravelToBrain)
										else
											(gCurRoom setScript: sNoFuel)
										)
									)
									(else
										(gCurRoom setScript: sTravelToStomach)
									)
								)
							)
							((IsFlag 186)
								(gCurRoom setScript: sWhereToNow)
							)
							((and (IsFlag 187) (not (IsFlag 190)))
								(localproc_4 10 4 10)
							)
							((IsFlag 187)
								(gCurRoom setScript: sWhereToNow)
							)
							((and (IsFlag 420) (not (IsFlag 51)) (IsFlag 82))
								(ClearFlag 139)
								(gCurRoom setScript: sGoToDelta)
							)
							((IsFlag 139)
								(localproc_4 10 4 10)
							)
							(else
								(gCurRoom setScript: sReadyForLaunch)
							)
						)
					else
						(localproc_4 44 0 0)
					)
					(= cel 1)
				)
			)
		)
	)
)

(instance cockpitView of View
	(properties
		priority 5
		fixPriority 1
		signal 20513
	)

	(method (init)
		(switch gShuttleRoomNum
			(450
				(self view: 490 noun: 28)
			)
			(500
				(self view: 4901 noun: 63)
			)
			(610
				(self view: 4901 noun: 27)
			)
			(740
				(self view: 4903 noun: 26)
			)
		)
		(super init:)
	)
)

(instance fakeEgo of View
	(properties
		noun 43
		x 22
		y 83
		priority 99
		fixPriority 1
		view 492
		signal 20513
	)
)

(instance manualOveride of Prop
	(properties
		noun 40
		x 264
		y 85
		priority 99
		fixPriority 1
		view 496
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((IsFlag 186)
						(self setScript: sTalkToManual)
					)
					(
						(and
							(IsFlag 139)
							(not (IsFlag 420))
							(IsFlag 51)
							(not (IsFlag 82))
						)
						(gMessager say: noun theVerb 16) ; "Sir, we are unable to proceed with the Divalium crystal off-line, a lack of power to restart the engines, and with a potential engine blockage."
					)
					(
						(and
							(IsFlag 139)
							(not (IsFlag 420))
							(IsFlag 51)
							(IsFlag 82)
						)
						(gMessager say: noun theVerb 17) ; "Sir, the Divalium crystal seems to be in proper configuration, but I'm afraid we'll need a power boost to restart the engines. I'm sensing that we may also have some sort of engine inlet blockage as well."
					)
					(
						(and
							(IsFlag 139)
							(IsFlag 420)
							(IsFlag 51)
							(not (IsFlag 82))
						)
						(gMessager say: noun theVerb 18) ; "Sir, the Divalium crystal is still off-line, and we'll need a power boost as well once that's repaired."
					)
					(
						(and
							(IsFlag 139)
							(not (IsFlag 420))
							(not (IsFlag 51))
							(not (IsFlag 82))
						)
						(gMessager say: noun theVerb 19) ; "Sir, there still seems to a potential engine blockage, and the Divalium crystal is off-line."
					)
					(
						(and
							(IsFlag 139)
							(IsFlag 420)
							(not (IsFlag 51))
							(not (IsFlag 82))
						)
						(gMessager say: noun theVerb 22) ; "Sir, I believe the Divalium crystal is still off-line."
					)
					(
						(and
							(IsFlag 139)
							(not (IsFlag 420))
							(not (IsFlag 51))
							(IsFlag 82)
						)
						(gMessager say: noun theVerb 20) ; "Sir, there seems to be a problem with one of the engine intakes."
					)
					((and (IsFlag 139) (IsFlag 420) (IsFlag 51) (IsFlag 82))
						(gMessager say: noun theVerb 21) ; "Sir, all seems to be ready, but I'm afraid we'll need a jump to restart the engines."
					)
					(
						(and
							(not (IsFlag 195))
							(not (IsFlag 186))
							(not (IsFlag 187))
							(not (IsFlag 51))
							(IsFlag 420)
							(IsFlag 82)
						)
						(SetFlag 195)
						(gMessager say: noun theVerb 15) ; "Good work, Sir. I believe I can now follow the ion trail of DeepShip 86 back to Delta Burksilon V."
					)
					(else
						(gMessager say: 40 0 24 (RandomNumber 1 4))
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance currentText of View
	(properties
		noun 14
		x 170
		y 102
		view 491
		cel 1
		signal 20513
	)
)

(instance gloveLid of View
	(properties
		noun 33
		x 163
		y 119
		view 499
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 45)
					(buttonSound number: 495 play:)
					(ClearFlag 45)
					(if (gCast contains: gluzall)
						(gluzall dispose:)
					)
					(if (gCast contains: handPump)
						(handPump dispose:)
					)
					(if (gCast contains: ductTape)
						(ductTape dispose:)
					)
					(= cel 0)
				else
					(buttonSound number: 495 play:)
					(SetFlag 45)
					(if (not (IsFlag 456))
						(gluzall init:)
					)
					(if (not (IsFlag 458))
						(handPump init:)
					)
					(if (not (IsFlag 457))
						(ductTape init:)
					)
					(= cel 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(if (IsFlag 45)
			(= cel 1)
			(if (not (IsFlag 456))
				(gluzall init:)
			)
			(if (not (IsFlag 458))
				(handPump init:)
			)
			(if (not (IsFlag 457))
				(ductTape init:)
			)
		)
		(super init:)
	)
)

(instance gluzall of View
	(properties
		noun 53
		x 160
		y 128
		z 3
		view 499
		loop 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 456)
				(gEgo get: 40) ; Elmo_Gluzall
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance handPump of View
	(properties
		noun 51
		x 147
		y 127
		view 499
		loop 1
		cel 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 458)
				(gEgo get: 54) ; Hand_Pump
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ductTape of View
	(properties
		noun 52
		x 178
		y 126
		view 499
		loop 1
		cel 2
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 457)
				(gEgo get: 33) ; Duct_Tape
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance intermixDisplay of View
	(properties
		noun 14
		x 116
		y 70
		priority 49
		fixPriority 1
		view 491
		signal 20513
	)

	(method (init)
		(button_1 init:)
		(button_2 init:)
		(button_3 init:)
		(button_4 init:)
		(button_5 init:)
		(currentText init:)
		(localproc_1 0 34 77 492)
		(localproc_1 1 35 84 490)
		(localproc_1 2 36 90 490)
		(localproc_1 3 37 96 491)
		(localproc_1 4 46 105 490)
		(super init:)
	)
)

(instance retScanner of Feature
	(properties
		noun 32
		sightAngle 40
		x 139
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 137 63 137 55 133 52 133 48 140 45 144 46 146 48 146 63
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(108 ; Sidney_Eye
				(gMessager say: noun theVerb 3) ; "That won't be of any help at this time."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pts of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 144 63 147 66 176 66 179 63 186 63 186 48 183 47 178 47 174 48 165 48 165 45 169 45 169 44 165 44 165 41 169 41 169 40 155 40 155 41 159 41 159 44 155 44 155 45 159 45 159 48 147 48 145 46 139 45 134 48 134 52 137 55 137 63
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftSeat of Feature
	(properties
		noun 3
		y 138
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 27 5 27 7 25 33 25 35 27 35 73 32 76 14 76 14 84 60 92 63 95 66 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightSeat of Feature
	(properties
		noun 4
		y 138
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 138 253 138 256 95 258 92 305 84 305 76 287 76 284 73 284 27 287 24 311 24 314 27 319 27
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance trunkLatch of Feature
	(properties
		noun 5
		nsLeft 74
		nsTop 129
		nsRight 89
		nsBottom 133
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 157))
						(gMessager say: 0 0 33) ; "Well, I guess this isn't going to help me now."
					)
					((and (IsFlag 431) (IsFlag 419))
						(gMessager say: noun theVerb 23) ; "The trunk is empty, you really don't need to open it again."
					)
					((IsFlag 51)
						(gCurRoom setScript: sPopTheTrunk)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hoodLatch of Feature
	(properties
		noun 6
		nsLeft 92
		nsTop 129
		nsRight 108
		nsBottom 133
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 157))
						(gMessager say: 0 0 33) ; "Well, I guess this isn't going to help me now."
					)
					((IsFlag 51)
						(gCurRoom setScript: sPopTheHood)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spcSlotLeft of Feature
	(properties
		noun 7
		nsLeft 85
		nsTop 111
		nsRight 115
		nsBottom 115
	)

	(method (doVerb theVerb)
		(switch theVerb
			(130 ; Subroutine_Card
				(if (IsFlag 50)
					(gCurRoom setScript: sInsertSpc)
				else
					(gMessager say: 50) ; "The power is not currently on."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spcSlotRight of Feature
	(properties
		noun 8
		nsLeft 210
		nsTop 111
		nsRight 239
		nsBottom 115
	)
)

(instance leftSpc of Feature
	(properties
		noun 24
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 83 103 83 110 116 110 116 103
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightSpc of Feature
	(properties
		noun 25
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 207 103 207 110 239 110 239 103
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance mainScreen of Feature
	(properties
		noun 16
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 123 70 119 74 117 108 121 112 203 112 207 108 204 74 200 70
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance buttonSound of Sound
	(properties)
)

(instance sRememberingJosho of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (gloveLid cel:) 1)
					(gloveLid doVerb: 4)
				)
				(= ticks 45)
			)
			(1
				(rightHandle cel: 0)
				(local2 dispose:)
				(= cycles 1)
			)
			(2
				(joshoBorder init: setCycle: End self)
			)
			(3
				(josho init: setCycle: End self)
			)
			(4
				(joshoSound play: self)
			)
			(5
				(josho setCycle: Beg self)
			)
			(6
				(josho dispose:)
				(= ticks 45)
			)
			(7
				(localproc_4 62 0 0 1)
				(= ticks 180)
			)
			(8
				(local2 dispose:)
				(joshoBorder setCycle: Beg self)
			)
			(9
				(joshoBorder dispose:)
				(rightHandle cel: 1)
				(= ticks 45)
			)
			(10
				(localproc_4 48 0 0)
				(localproc_8)
				(self dispose:)
			)
		)
	)
)

(instance joshoBorder of Prop
	(properties
		x 162
		y 91
		priority 100
		fixPriority 1
		view 4999
	)
)

(instance josho of Prop
	(properties
		x 162
		y 91
		priority 100
		fixPriority 1
		view 4999
		loop 1
	)
)

(instance joshoSound of Sound
	(properties
		number 4999
	)
)

(instance inManualArrives of Inset
	(properties
		picture 495
	)

	(method (init)
		(Load rsVIEW 4950 4951 4952)
		(super init: &rest)
		(engines init: setCycle: Fwd)
		(self setScript: sManualArrives)
	)
)

(instance sManualArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Fade 0 1 self)
			)
			(1
				(buttonSound number: 499 play: self)
				(bigManual init: setCycle: End self)
			)
			(2)
			(3
				(bigManual view: 4951 loop: 2 cel: 0)
				(rogerHead init:)
				(= ticks 60)
			)
			(4
				(bigManualTeath init: setCycle: End self)
			)
			(5
				(= ticks 60)
			)
			(6
				(bigManualTeath dispose:)
				(bigManual view: 4952 loop: 0 cel: 0 setCycle: Osc 1 self)
			)
			(7
				(= cycles 5)
			)
			(8
				(gMessager say: 40 2 8 0 self) ; "Sir, I am unable to access the navigational computer. I am guessing that it may have overloaded just as the Divalium crystal somehow went off-line. Once repairs have been made and the shuttle engines have been re-fired, I believe I can follow the DeepShip's ion trail back to Delta Burksilon V."
			)
			(9
				(rogerHead dispose:)
				(bigManual view: 4950 loop: 0)
				(bigManual cel: (bigManual lastCel:))
				(= ticks 60)
			)
			(10
				(Fade 1 1 self)
			)
			(11
				(self dispose:)
				(inManualArrives dispose:)
			)
		)
	)
)

(instance rogerHead of View
	(properties
		x 257
		y 99
		view 4953
	)
)

(instance bigManual of Prop
	(properties
		x 64
		y 139
		view 4950
	)
)

(instance bigManualTeath of Prop
	(properties
		x 63
		y 77
		priority 140
		fixPriority 1
		view 4951
		loop 3
	)
)

(instance engines of Prop
	(properties
		x 148
		y 67
		view 495
		cel 15
	)
)

(instance tkrKielbasa of Talker
	(properties
		disposeWhenDone 0
	)

	(method (init)
		(switch (gGame printLang:)
			(33
				(= name {Commandeur Kielbasa})
			)
			(49
				(= name {Kommander Kielbasa})
			)
			(else
				(= name {Commander Kielbasa})
			)
		)
		(super init: kielbasaMouth kielbasaBust kielbasaEyes)
	)
)

(instance Manuel_Auxveride of Talker
	(properties
		name {Manuel Auxveride}
		disposeWhenDone 0
	)

	(method (init)
		(if (gCurRoom inset:)
			(super init: bigManualMouth bigManualBust bigManualEyes)
		else
			(self bustPri: 100 eyePri: 101 mouthPri: 102)
			(super init: manualMouth manualBust manualEyes)
		)
	)
)

(instance Roger of Talker
	(properties
		disposeWhenDone 0
	)

	(method (init)
		(if (gCurRoom inset:)
			(super init: bigRogerMouth bigRogerBust bigRogerEyes)
		else
			(self bustPri: 100 eyePri: 101 mouthPri: 102)
			(super init: rogerMouth rogerBust rogerEyes)
		)
	)
)

(instance bigManualBust of Prop
	(properties
		x 64
		y 139
		view 4952
	)
)

(instance bigManualMouth of Prop
	(properties
		x 61
		y 70
		view 4952
		loop 1
	)
)

(instance bigManualEyes of Prop
	(properties
		x 71
		y 58
		view 4952
		loop 2
	)
)

(instance manualBust of Prop
	(properties
		x 264
		y 85
		view 496
		loop 1
	)
)

(instance manualMouth of Prop
	(properties
		x 264
		y 85
		view 496
		loop 1
	)
)

(instance manualEyes of Prop
	(properties
		x 264
		y 85
		view 496
		loop 1
	)
)

(instance kielbasaMouth of Prop
	(properties
		x 116
		y 70
		view 493
		loop 1
	)
)

(instance kielbasaBust of Prop
	(properties
		x 116
		y 70
		view 493
	)
)

(instance kielbasaEyes of Prop
	(properties
		x 146
		y 89
		view 493
		loop 2
	)
)

(instance bigRogerBust of Prop
	(properties
		x 257
		y 99
		view 4953
	)
)

(instance bigRogerMouth of Prop
	(properties
		x 249
		y 72
		view 4953
		loop 1
	)
)

(instance bigRogerEyes of Prop
	(properties
		x 248
		y 61
		view 4953
		loop 2
	)
)

(instance rogerBust of Prop
	(properties
		x 22
		y 83
		view 492
	)
)

(instance rogerMouth of Prop
	(properties
		x 22
		y 83
		view 492
	)
)

(instance rogerEyes of Prop
	(properties
		x 22
		y 83
		view 492
	)
)

(instance choiceDialog of View
	(properties
		x 116
		y 70
		priority 200
		fixPriority 1
		view 4980
	)
)

(instance deltaButton of ChooseButton
	(properties
		x 131
		y 83
		priority 201
		fixPriority 1
		view 4980
		loop 2
		value 1
	)
)

(instance polyButton of ChooseButton
	(properties
		x 135
		y 92
		priority 201
		fixPriority 1
		view 4980
		loop 1
		value 2
	)
)

(instance abortButton of ChooseButton
	(properties
		x 141
		y 102
		priority 201
		fixPriority 1
		view 4980
		loop 3
	)
)

(instance sWhereToNow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== (gloveLid cel:) 1)
					(gloveLid doVerb: 4)
				)
				(= ticks 60)
			)
			(1
				(= cycles 3)
			)
			(2
				(= register gTheCursor)
				(gGame setCursor: gNormalCursor)
				(Load rsVIEW 4980)
				(choiceDialog init:)
				(abortButton init: self)
				(if (and (IsFlag 190) (not (IsFlag 186)))
					(deltaButton x: 131 y: 83 init: self)
					(polyButton init: self)
				else
					(deltaButton x: 131 y: 87 init: self)
				)
				(= scratch 10)
				(while (== scratch 10)
					(gGame doit:)
					(FrameOut)
				)
				(choiceDialog dispose:)
				(deltaButton dispose:)
				(abortButton dispose:)
				(if (and (IsFlag 190) (not (IsFlag 186)))
					(polyButton dispose:)
				)
				(= register 0)
				(= cycles 5)
			)
			(3
				(cond
					((== scratch 1)
						(if (IsFlag 187)
							(gGame setCursor: gWaitCursor 1)
							(SetFlag 171)
							(gCurRoom newRoom: 495)
						else
							(gGame setCursor: gWaitCursor 1)
							(ClearFlag 186)
							(= next sGoToDelta)
						)
					)
					((== scratch 2)
						(if (IsFlag 186)
							(ClearFlag 73)
							(launchButton cel: 0)
							(localproc_8)
							(gGame setCursor: (gTheIconBar getCursor:))
						else
							(gGame setCursor: gWaitCursor 1)
							(ClearFlag 187)
							(= next sGoToPolysorbate)
						)
					)
					(else
						(ClearFlag 73)
						(launchButton cel: 0)
						(localproc_8)
						(gGame setCursor: (gTheIconBar getCursor:))
					)
				)
				(self dispose:)
			)
		)
	)
)

