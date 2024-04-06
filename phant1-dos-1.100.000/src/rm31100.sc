;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm31100 0
)

(local
	local0
	local1 = -1
	local2 = -1
)

(instance rm31100 of ScaryRoom
	(properties
		picture 31400
		west 31200
		stepSound 4
	)

	(method (init)
		(= global115 0)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gPrevRoomNum 34225)
			(Load rsAUDIO 31020)
		)
		(gEgo init: setScaler: Scaler 136 100 130 108 normalize:)
		(storeMan init: setHotspot: 4 3 hide:) ; Do, Move
		(door init:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
				(canister init:)
				(storeMan show:)
			)
			(31200
				(gGame handsOn:)
				(canister init:)
				(storeMan show:)
				(gEgo view: 0 posn: 98 125 setScaler: Scaler 136 100 130 108)
			)
			(else
				(gEgo view: 5 posn: 224 123)
				(gGDacSound number: 31020 loop: -1 setVol: 30 play:)
				(DoAudio 12 0) ; AudMixCheck
				(if (and (>= global170 3) (!= global171 gChapter))
					(= global171 gChapter)
					(= global170 1)
				)
				(cond
					((== global170 0)
						(+= global170 1)
						(= global171 gChapter)
						(gCurRoom setScript: firstEntryScr)
					)
					(
						(or
							(> global170 2)
							(< (Random 1 100) 50)
							(and (== global170 2) (== gChapter 2))
							(and (== global170 2) (> gChapter 3))
						)
						(= picture 31460)
						(door hide:)
						(gCurRoom setScript: egoEnterScr)
					)
					((== global170 1)
						(gEgo hide:)
						(+= global170 1)
						(WalkieTalkie showFrame: 2720 0 0 0)
						(gCurRoom setScript: sCustomer2)
					)
					((== global170 2)
						(+= global170 1)
						(gEgo hide:)
						(WalkieTalkie showFrame: 2730 0 0 0)
						(gCurRoom setScript: sCustomer3)
					)
				)
			)
		)
		(doorExit init: 2)
		(westExit init: 4)
		(super init: &rest)
		(if (and (not script) (!= gPrevRoomNum 900))
			(gEgo setScript: (ScriptID 0 5) 0 5) ; takeLastStep
		)
	)
)

(instance firstEntryScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 233)
					(DoRobot 2710 0 0)
				)
				(1
					(door hide:)
				)
				(2
					(door show:)
				)
				(3
					(storeMan show:)
					(gEgo
						posn: 169 116
						setScaler: Scaler 136 100 130 108
						show:
						normalize: 1
					)
					(gCurRoom drawPic: 31400)
					(canister init:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(SetFlag 233)
					(storeMan show:)
					(door show:)
					(canister init:)
					(gEgo
						posn: 169 116
						setScaler: Scaler 136 100 130 108
						show:
						normalize: 1
					)
					(gCurRoom drawPic: 31400)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance egoEnterScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 2700 0 0)
				)
				(1)
				(2
					(door show:)
					(gEgo
						posn: 169 116
						setScaler: Scaler 136 100 130 108
						show:
						normalize: 1
						setScript: (ScriptID 0 5) self 10 ; takeLastStep
					)
					(storeMan show:)
					(canister init:)
					(gCurRoom drawPic: 31400)
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(SetFlag 233)
					(storeMan show:)
					(door show:)
					(gEgo
						posn: 169 116
						setScaler: Scaler 136 100 130 108
						show:
						normalize: 1
					)
					(canister init:)
					(= global115 0)
					(gCurRoom drawPic: 31400)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sCustomer2 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(KillRobot)
					(DoRobot 2720 0 0)
				)
				(1
					(door hide:)
				)
				(2)
				(3)
				(4
					(door show:)
				)
				(5
					(storeMan show:)
					(gEgo
						posn: 172 116
						setScaler: Scaler 136 100 130 108
						show:
						normalize: 1
					)
					(canister init:)
					(door show:)
					(gCurRoom drawPic: 31400)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(storeMan show:)
					(door show:)
					(gEgo
						posn: 172 116
						setScaler: Scaler 136 100 130 108
						show:
						normalize: 1
					)
					(canister init:)
					(gCurRoom drawPic: 31400)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sCustomer3 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 2)
				)
				(1
					(KillRobot)
					(DoRobot 2730)
				)
				(2
					(door hide:)
				)
				(3
					(door show:)
				)
				(4
					(door hide:)
				)
				(5
					(door show:)
				)
				(6
					(storeMan show:)
					(gEgo
						posn: 172 116
						setScaler: Scaler 136 100 130 108
						show:
						normalize: 1
					)
					(door show:)
					(gCurRoom drawPic: 31400)
					(canister init:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(storeMan show:)
					(door show:)
					(gEgo
						posn: 172 116
						setScaler: Scaler 136 100 130 108
						show:
						normalize: 1
					)
					(canister init:)
					(gCurRoom drawPic: 31400)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLookAtCanister of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(door hide:)
					(storeMan hide:)
					(DoRobot 2770 -6 -40 gEgo 200)
					(gCurRoom drawPic: 31410)
				)
				(1
					(gCurRoom drawPic: 31420)
					(= seconds 4)
				)
				(2
					(gEgo hide:)
					(DoRobot 2771 -6 -40 gEgo 200)
					(gCurRoom drawPic: 31410)
				)
				(3
					(gEgo posn: 160 116 show: normalize: 1)
					(storeMan show:)
					(door show:)
					(gCurRoom drawPic: 31400)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo posn: 160 116 show: normalize: 1)
					(storeMan show:)
					(door show:)
					(gCurRoom drawPic: 31400)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sDoDonations of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(storeMan hide:)
					(door hide:)
					(DoRobot 2780 -9 -40 gEgo 200)
					(gCurRoom drawPic: 31410)
				)
				(1
					(door show:)
					(gEgo show: posn: 160 116 normalize: 1)
					(storeMan show:)
					(gCurRoom drawPic: 31400)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(door show:)
					(gEgo show: posn: 160 116 normalize: 1)
					(gCurRoom drawPic: 31400)
					(storeMan show:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTalkKeeper of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (storeMan cycler:)
						(storeMan setCycle: Beg self)
					else
						(storeMan show:)
						(self cue:)
					)
				)
				(1
					(storeMan dispose:)
					(door dispose:)
					(gCurRoom drawPic: 31440)
					(DoRobot 2791 0 -31)
				)
				(2
					(canisterCU view: 31430 posn: 38 147 init:)
					(DoRobot 2792 80 2)
					(gCurRoom drawPic: 31430)
				)
				(3
					(canisterCU dispose:)
					(if (gEgo has: 1) ; invMoney
						(storeMan init:)
						(if (gCast contains: door)
							(door show:)
						else
							(door init:)
						)
						(gCurRoom drawPic: 31400)
						(self cue:)
					else
						(DoRobot 2800 -57 -31)
						(gCurRoom drawPic: 31110)
					)
				)
				(4
					(storeMan init: setHotspot: 4 3 show:) ; Do, Move
					(if (gCast contains: door)
						(door show:)
					else
						(door init:)
					)
					(gCurRoom drawPic: 31400)
					(SetFlag 238)
					(gEgo
						show:
						normalize: 3
						posn: 145 116
						setScaler: Scaler 136 100 130 108
					)
					(if (not (gEgo has: 1)) ; invMoney
						(gGame handsOn:)
						(self dispose:)
					else
						(gGame handsOn:)
						(gCurRoom setScript: theWaitScript)
					)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (gCast contains: canisterCU)
						(canisterCU dispose:)
					)
					(SetFlag 238)
					(if (not (gCast contains: storeMan))
						(storeMan init: setHotspot: 4 3 show:) ; Do, Move
					else
						(storeMan show:)
					)
					(if (gCast contains: door)
						(door show:)
					else
						(door init:)
					)
					(gCurRoom drawPic: 31400)
					(= global115 0)
					(gGame handsOn:)
					(gEgo
						show:
						normalize: 3
						posn: 145 116
						setScaler: Scaler 136 100 130 108
					)
					(if (gEgo has: 1) ; invMoney
						(gCurRoom setScript: theWaitScript)
					else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance theWaitScript of Script
	(properties)

	(method (dispose)
		(ClearFlag 121)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 121)
				(storeMan
					view: 2811
					setLoop: 0
					setCel: 0
					setCycle: 0
					posn: 119 75
					show:
					setHotspot: 4 3 6 ; Do, Move, invMoney
				)
				(= seconds 10)
			)
			(1
				(storeMan setHotspot: 4 3) ; Do, Move
				(gCurRoom setScript: sPutUp)
			)
		)
	)
)

(instance sPutUp of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(storeMan view: 2701 posn: 121 75 hide:)
					(DoRobot 2810 63 20 storeMan)
				)
				(1
					(storeMan show:)
					(= local0 1)
					(storeMan doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= local0 1)
					(storeMan show:)
					(storeMan doit:)
					(if (Robot 6) ; Exists
						(KillRobot 0 storeMan)
					)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance talkAgainNoCash of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (storeMan cycler:)
						(storeMan setCycle: Beg self)
					else
						(self cue:)
					)
				)
				(1
					(storeMan hide:)
					(door hide:)
					(DoRobot 2820 69 1)
					(gCurRoom drawPic: 31430)
				)
				(2
					(DoRobot 2821 -7 -11)
					(gCurRoom drawPic: 31440)
				)
				(3
					(storeMan hide:)
					(DoRobot 2822 81 -2)
					(gCurRoom drawPic: 31430)
				)
				(4
					(storeManBig dispose:)
					(door show:)
					(gEgo normalize: 3 show:)
					(storeMan show:)
					(gGame handsOn:)
					(= local0 1)
					(storeMan doit:)
					(gCurRoom drawPic: 31400)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= local0 1)
					(KillRobot)
					(gEgo normalize: 3 show:)
					(door show:)
					(storeMan show:)
					(storeMan doit:)
					(gCurRoom drawPic: 31400)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTalkAgain of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(= register 0)
					(gGame handsOff:)
					(if (storeMan cycler:)
						(storeMan setCycle: Beg self)
					else
						(self cue:)
					)
				)
				(1
					(storeMan hide:)
					(door hide:)
					(= register gEgo)
					(DoRobot 2799 -2 -30)
					(gCurRoom drawPic: 31440)
				)
				(2
					(door show:)
					(gEgo
						posn: 145 116
						setScaler: Scaler 136 100 130 108
						normalize: 3
						show:
					)
					(gCurRoom drawPic: 31400)
					(= register storeMan)
					(DoRobot 2812 55 20 storeMan)
				)
				(3
					(storeMan hide:)
					(door hide:)
					(= register gEgo)
					(DoRobot 2793 39 -3)
					(gCurRoom drawPic: 31440)
				)
				(4
					(storeMan show:)
					(door show:)
					(gGame handsOn:)
					(gEgo
						posn: 145 116
						setScaler: Scaler 136 100 130 108
						normalize: 3
					)
					(gCurRoom drawPic: 31400)
					(gCurRoom setScript: theWaitScript)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot 0 register)
					(door show:)
					(gEgo show:)
					(storeMan show:)
					(= global115 0)
					(gGame handsOn:)
					(gEgo
						posn: 145 116
						setScaler: Scaler 136 100 130 108
						normalize: 3
					)
					(gCurRoom drawPic: 31400)
					(gCurRoom setScript: theWaitScript)
				)
			)
		)
	)
)

(instance cashRegSound of Sound
	(properties
		number 31027
	)
)

(instance sBuyCleaner of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 162)
					(storeMan hide:)
					(door hide:)
					(DoRobot 2840 20 -1)
					(gCurRoom drawPic: 31110)
				)
				(1
					(cashRegSound play:)
					(DoRobot 2841 -7 -9)
					(gCurRoom drawPic: 31440)
				)
				(2
					(canisterCU view: 31430 posn: 38 147 init:)
					(DoRobot 2842)
					(gCurRoom drawPic: 31430)
				)
				(3
					(canisterCU dispose:)
					(DoRobot 2843 11 -8)
					(gCurRoom drawPic: 31440)
				)
				(4
					(canisterCU view: 31430 posn: 38 147 init:)
					(DoRobot 2844)
					(gCurRoom drawPic: 31430)
				)
				(5
					(canisterCU dispose:)
					(DoRobot 2845 19 -1)
					(gCurRoom drawPic: 31110)
				)
				(6
					(DoRobot 2846)
					(gCurRoom drawPic: 31440)
				)
				(7
					(DoRobot 2847 -48 -29)
					(gCurRoom drawPic: 31110)
				)
				(8
					(canisterCU view: 31430 posn: 38 147 init:)
					(DoRobot 2848 31 6)
					(gCurRoom drawPic: 31430)
				)
				(9
					(door show:)
					(canisterCU dispose:)
					(DoRobot 2849 69 21)
					(gCurRoom drawPic: 31400)
				)
				(10
					(if (gCast contains: canisterCU)
						(canisterCU dispose:)
					)
					(storeMan dispose:)
					(door dispose:)
					(gEgo hide:)
					(gCurRoom drawPic: 31440)
					(storeManBig setCel: 7 init: setCycle: Beg self)
				)
				(11
					(storeManBig dispose:)
					(door init: show:)
					(gCurRoom drawPic: 31400)
					(= local0 1)
					(storeMan init: setHotspot: 4 3 show: doit:) ; Do, Move
					(gEgo
						posn: 145 116
						setScaler: Scaler 136 100 130 108
						show:
						put: 1 ; invMoney
						get: 13 ; invDrainCln
						normalize: 3
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (gCast contains: canisterCU)
						(canisterCU dispose:)
					)
					(if (gCast contains: storeManBig)
						(storeManBig dispose:)
					)
					(SetFlag 162)
					(door init: show:)
					(= local0 1)
					(storeMan init: setHotspot: 4 3 show: doit:) ; Do, Move
					(gCurRoom drawPic: 31400)
					(gEgo
						posn: 145 116
						setScaler: Scaler 136 100 130 108
						show:
						put: 1 ; invMoney
						get: 13 ; invDrainCln
						normalize: 3
					)
					(gGame handsOn:)
					(= global115 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLooking of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (storeMan cycler:)
						(storeMan setCycle: Beg self)
					else
						(self cue:)
					)
				)
				(1
					(door31200 init:)
					(storeMan hide:)
					(DoRobot 2850 139 36)
					(gCurRoom drawPic: 31200)
				)
				(2
					(door31200 dispose:)
					(gCurRoom drawPic: 31400)
					(storeMan show:)
					(gEgo normalize: 3 show:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (gCast contains: door31200)
						(door31200 dispose:)
					)
					(gEgo normalize: 3 show:)
					(storeMan show:)
					(gGame handsOn:)
					(gCurRoom drawPic: 31400)
					(= global115 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance sToOutside of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 90 self)
				)
				(1
					(storeMan hide:)
					(door hide:)
					(gEgo hide:)
					(DoRobot 2701 0 0 gEgo -1 1)
					(gCurRoom drawPic: 31460)
				)
				(2)
				(3
					(DoAudio 12 1) ; AudMixCheck
					(gGDacSound number: 903 setLoop: -1 play: setVol: 75)
					(gCurRoom newRoom: 34225)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(DoAudio 12 1) ; AudMixCheck
					(gGDacSound number: 903 setLoop: -1 play: setVol: 75)
					(gCurRoom newRoom: 34225)
				)
			)
		)
	)
)

(instance sTo312 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setHeading: 270 self)
				)
				(1
					(gCurRoom newRoom: 31200)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 31200)
				)
			)
		)
	)
)

(instance storeManFX of Sound
	(properties)
)

(instance storeMan of Actor
	(properties
		x 121
		y 75
		view 2701
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 10)
	)

	(method (doit)
		(if
			(or
				local0
				(and
					(not cycler)
					(not (gCurRoom script:))
					(== (Random 0 300) 150)
				)
			)
			(self posn: 121 75)
			(= local0 0)
			(switch (Random 0 3)
				(0
					(self x: 121)
					(= view 2701)
				)
				(1
					(self x: 119)
					(= view 2702)
				)
				(2
					(self x: 121)
					(= view 2703)
				)
				(3
					(self x: 120)
					(= view 2704)
				)
			)
			(self setCycle: End)
		)
		(super doit: &rest)
		(switch view
			(2701
				(switch cel
					(5
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31021 play:)
						)
					)
					(49
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31022 play:)
						)
					)
				)
			)
			(2702
				(switch cel
					(6
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31021 play:)
						)
					)
					(57
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31022 play:)
						)
					)
				)
			)
			(2704
				(switch cel
					(5
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31021 play:)
						)
					)
					(14
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31023 play:)
						)
					)
					(20
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31024 play:)
						)
					)
					(29
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31025 play:)
						)
					)
					(35
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31026 play:)
						)
					)
					(46
						(if (and (!= local1 view) (!= local2 cel))
							(= local1 view)
							(= local2 cel)
							(storeManFX number: 31022 play:)
						)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((== (gCurRoom script:) theWaitScript)
						(theWaitScript cue:)
					)
					((IsFlag 162)
						(gCurRoom setScript: sLooking)
					)
					((not (IsFlag 238))
						(gCurRoom setScript: sTalkKeeper)
					)
					((not (gEgo has: 1)) ; invMoney
						(gCurRoom setScript: talkAgainNoCash)
					)
					(else
						(gCurRoom setScript: sTalkAgain)
					)
				)
			)
			(6 ; invMoney
				(gCurRoom setScript: sBuyCleaner)
			)
			(else
				(if (== (gCurRoom script:) theWaitScript)
					(gCurRoom setScript: sPutUp)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance storeManBig of Prop
	(properties
		x -2
		y 129
		view 2798
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 15)
	)
)

(instance canisterCU of View
	(properties
		x 39
		y 126
		view 31410
	)
)

(instance storeManCU of View ; UNUSED
	(properties
		x -3
		y 123
		view 31410
	)
)

(instance door of View
	(properties
		x 243
		y 127
		view 2700
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

(instance door31200 of View
	(properties
		x 147
		y 83
		view 31200
	)
)

(instance canister of Feature
	(properties
		nsLeft 153
		nsTop 62
		nsRight 174
		nsBottom 80
		sightAngle 20
		x 163
		y 106
		z 35
	)

	(method (init)
		(super init:)
		(self setHotspot: 1 3 6) ; ???, Move, invMoney
	)

	(method (doVerb theVerb)
		(cond
			((== (gCurRoom script:) theWaitScript)
				(theWaitScript cue:)
			)
			((== theVerb 1) ; ???
				(gGame handsOff:)
				(gCurRoom setScript: sLookAtCanister)
			)
			((== theVerb 6) ; invMoney
				(gGame handsOff:)
				(gCurRoom setScript: sDoDonations)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 233
		nsTop 31
		nsRight 269
		nsBottom 123
		approachX 290
		approachY 80
		x 261
		y 128
		nextRoom 34225
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(if (== (gCurRoom script:) theWaitScript)
				(theWaitScript cue:)
			else
				(gCurRoom setScript: sToOutside)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsRight 30
		nextRoom 31200
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(if (== (gCurRoom script:) theWaitScript)
				(theWaitScript cue:)
			else
				(gCurRoom setScript: sTo312)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

