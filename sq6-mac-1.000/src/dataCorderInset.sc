;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use Inset)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	dataCorderInset 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5 = 1
	local6 = 1
	local7 = 1
	local8 = 1
	local9
	local10
	local11
	local12 = 15
)

(procedure (localproc_0 param1)
	(switch param1
		(0
			(= [global138 0] 0)
			(emptySlot1 init:)
		)
		(1
			(= [global138 1] 0)
			(emptySlot2 init:)
		)
		(2
			(= [global138 2] 0)
			(emptySlot3 init:)
		)
		(3
			(= [global138 3] 0)
			(emptySlot4 init:)
		)
		(4
			(= [global138 4] 0)
			(emptySlot5 init:)
		)
	)
)

(procedure (localproc_1 param1 param2)
	(dataSound number: 952 play:)
	(switch (gTheCursor loop:)
		(0
			(TT
				view: 896
				loop: param1
				cel: (gTheCursor loop:)
				x: 128
				y: param2
				show:
			)
			(= [global128 0] param1)
			(localproc_2 [global128 0] (gTheCursor cel:))
		)
		(1
			(PS
				view: 896
				loop: param1
				cel: (gTheCursor loop:)
				x: 128
				y: param2
				show:
			)
			(= [global128 1] param1)
			(localproc_2 [global128 1] (gTheCursor cel:))
		)
		(2
			(SE
				view: 896
				loop: param1
				cel: (gTheCursor loop:)
				x: 128
				y: param2
				show:
			)
			(= [global128 2] param1)
			(localproc_2 [global128 2] (gTheCursor cel:))
		)
		(3
			(RF
				view: 896
				loop: param1
				cel: (gTheCursor loop:)
				x: 128
				y: param2
				show:
			)
			(= [global128 3] param1)
			(localproc_2 [global128 3] (gTheCursor cel:))
		)
		(4
			(FC
				view: 896
				loop: param1
				cel: (gTheCursor loop:)
				x: 128
				y: param2
				show:
			)
			(= [global128 4] param1)
			(localproc_2 [global128 4] (gTheCursor cel:))
		)
	)
	(localproc_5)
)

(procedure (localproc_2 param1 param2 &tmp temp0)
	(switch param1
		(0
			(= temp0 20)
		)
		(1
			(= temp0 43)
		)
		(2
			(= temp0 67)
		)
		(3
			(= temp0 89)
		)
		(4
			(= temp0 113)
		)
	)
	(switch param2
		(0
			(dentium loop: param1 x: 128 y: temp0 show:)
		)
		(1
			(repentium loop: param1 x: 128 y: temp0 show:)
		)
		(2
			(fermentium loop: param1 x: 128 y: temp0 show:)
		)
		(3
			(dimtel loop: param1 x: 128 y: temp0 show:)
		)
		(4
			(spentium loop: param1 x: 128 y: temp0 show:)
		)
	)
)

(procedure (localproc_3 param1)
	(dataSound number: 953 play:)
	(switch param1
		(0
			(= local4 0)
		)
		(1
			(= local5 0)
		)
		(2
			(= local6 0)
		)
		(3
			(= local7 0)
		)
		(4
			(= local8 0)
		)
	)
)

(procedure (localproc_4)
	(localproc_10)
	(= local12 0)
	(= local11 0)
	(if (== [global123 0] 4)
		(++ local11)
	)
	(if (== [global123 1] 3)
		(++ local11)
	)
	(if (== [global123 2] 0)
		(++ local11)
	)
	(if (== [global123 3] 2)
		(++ local11)
	)
	(if (== [global123 4] 1)
		(++ local11)
	)
	(if (== [global128 0] 1)
		(++ local11)
	)
	(if (== [global128 1] 2)
		(++ local11)
	)
	(if (== [global128 2] 4)
		(++ local11)
	)
	(if (== [global128 3] 0)
		(++ local11)
	)
	(if (== [global128 4] 3)
		(++ local11)
	)
	(if (== [global133 0] 0)
		(++ local11)
	)
	(if (== [global133 1] 4)
		(++ local11)
	)
	(if (== [global133 2] 1)
		(++ local11)
	)
	(if (== [global133 3] 2)
		(++ local11)
	)
	(if (== [global133 4] 3)
		(++ local11)
	)
	(if (== [global123 0] 0)
		(++ local12)
	)
	(if (== [global123 1] 1)
		(++ local12)
	)
	(if (== [global123 2] 2)
		(++ local12)
	)
	(if (== [global123 3] 3)
		(++ local12)
	)
	(if (== [global123 4] 4)
		(++ local12)
	)
	(if (== [global128 0] 0)
		(++ local12)
	)
	(if (== [global128 1] 1)
		(++ local12)
	)
	(if (== [global128 2] 2)
		(++ local12)
	)
	(if (== [global128 3] 3)
		(++ local12)
	)
	(if (== [global128 4] 4)
		(++ local12)
	)
	(if (== [global133 0] 0)
		(++ local12)
	)
	(if (== [global133 1] 1)
		(++ local12)
	)
	(if (== [global133 2] 2)
		(++ local12)
	)
	(if (== [global133 3] 3)
		(++ local12)
	)
	(if (== [global133 4] 4)
		(++ local12)
	)
)

(procedure (localproc_5)
	(gTheCursor view: 953 setLoop: 0 setCel: 0 init: show:)
	(newCursor hide:)
)

(procedure (localproc_6 param1)
	(switch param1
		(0
			(dentiumFeature
				y: (+ gMouseY 1)
				nsLeft: (- gMouseX 5)
				nsTop: (- gMouseY 5)
				nsBottom: (+ gMouseY 5)
				nsRight: (+ gMouseX 6)
				init:
			)
		)
		(1
			(repentiumFeature
				y: (+ gMouseY 1)
				nsLeft: (- gMouseX 5)
				nsTop: (- gMouseY 5)
				nsBottom: (+ gMouseY 5)
				nsRight: (+ gMouseX 6)
				init:
			)
		)
		(2
			(fermentiumFeature
				y: (+ gMouseY 1)
				nsLeft: (- gMouseX 5)
				nsTop: (- gMouseY 5)
				nsBottom: (+ gMouseY 5)
				nsRight: (+ gMouseX 6)
				init:
			)
		)
		(3
			(dimtelFeature
				y: (+ gMouseY 1)
				nsLeft: (- gMouseX 5)
				nsTop: (- gMouseY 5)
				nsBottom: (+ gMouseY 5)
				nsRight: (+ gMouseX 6)
				init:
			)
		)
		(4
			(spentiumFeature
				y: (+ gMouseY 1)
				nsLeft: (- gMouseX 5)
				nsTop: (- gMouseY 5)
				nsBottom: (+ gMouseY 5)
				nsRight: (+ gMouseX 6)
				init:
			)
		)
	)
)

(procedure (localproc_7 param1)
	(switch param1
		(0
			(dentiumFeature dispose:)
		)
		(1
			(repentiumFeature dispose:)
		)
		(2
			(fermentiumFeature dispose:)
		)
		(3
			(dimtelFeature dispose:)
		)
		(4
			(spentiumFeature dispose:)
		)
	)
)

(procedure (localproc_8 param1)
	(dataSound number: 953 play:)
	(switch param1
		(0
			(= local4 0)
			(TT cel: 5)
		)
		(1
			(= local5 0)
			(PS cel: 5)
		)
		(2
			(= local6 0)
			(SE cel: 5)
		)
		(3
			(= local7 0)
			(RF cel: 5)
		)
		(4
			(= local8 0)
			(FC cel: 5)
		)
	)
)

(procedure (localproc_9)
	(redA cel: 0)
	(redB cel: 2)
	(redC cel: 0)
	(redD cel: 0)
	(redE cel: 2)
	(yellowA cel: 0)
	(yellowB cel: 2)
	(yellowC cel: 0)
	(yellowD cel: 0)
	(yellowE cel: 2)
	(greenA cel: 0)
	(greenB cel: 2)
	(greenC cel: 0)
	(greenD cel: 0)
	(greenE cel: 2)
	(blueA cel: 0)
	(blueB cel: 2)
	(blueC cel: 0)
	(blueD cel: 0)
	(blueE cel: 2)
	(greyA cel: 0)
	(greyB cel: 2)
	(greyC cel: 0)
	(greyD cel: 0)
	(greyE cel: 2)
	(switch [global123 0]
		(0
			(redA cel: 1)
		)
		(1
			(yellowA cel: 1)
		)
		(2
			(greenA cel: 1)
		)
		(3
			(blueA cel: 1)
		)
		(4
			(greyA cel: 1)
		)
	)
	(switch [global123 1]
		(0
			(redB cel: 3)
		)
		(1
			(yellowB cel: 3)
		)
		(2
			(greenB cel: 3)
		)
		(3
			(blueB cel: 3)
		)
		(4
			(greyB cel: 3)
		)
	)
	(switch [global123 2]
		(0
			(redC cel: 1)
		)
		(1
			(yellowC cel: 1)
		)
		(2
			(greenC cel: 1)
		)
		(3
			(blueC cel: 1)
		)
		(4
			(greyC cel: 1)
		)
	)
	(switch [global123 3]
		(0
			(redD cel: 1)
		)
		(1
			(yellowD cel: 1)
		)
		(2
			(greenD cel: 1)
		)
		(3
			(blueD cel: 1)
		)
		(4
			(greyD cel: 1)
		)
	)
	(switch [global123 4]
		(0
			(redE cel: 3)
		)
		(1
			(yellowE cel: 3)
		)
		(2
			(greenE cel: 3)
		)
		(3
			(blueE cel: 3)
		)
		(4
			(greyE cel: 3)
		)
	)
)

(procedure (localproc_10)
	(if
		(and
			(== (redA cel:) 0)
			(== (yellowA cel:) 0)
			(== (greenA cel:) 0)
			(== (blueA cel:) 0)
			(== (greyA cel:) 0)
		)
		(= [global123 0] 5)
	)
	(if
		(and
			(== (redB cel:) 2)
			(== (yellowB cel:) 2)
			(== (greenB cel:) 2)
			(== (blueB cel:) 2)
			(== (greyB cel:) 2)
		)
		(= [global123 1] 5)
	)
	(if
		(and
			(== (redC cel:) 0)
			(== (yellowC cel:) 0)
			(== (greenC cel:) 0)
			(== (blueC cel:) 0)
			(== (greyC cel:) 0)
		)
		(= [global123 2] 5)
	)
	(if
		(and
			(== (redD cel:) 0)
			(== (yellowD cel:) 0)
			(== (greenD cel:) 0)
			(== (blueD cel:) 0)
			(== (greyD cel:) 0)
		)
		(= [global123 3] 5)
	)
	(if
		(and
			(== (redE cel:) 2)
			(== (yellowE cel:) 2)
			(== (greenE cel:) 2)
			(== (blueE cel:) 2)
			(== (greyE cel:) 2)
		)
		(= [global123 4] 5)
	)
)

(procedure (localproc_11)
	(if (and (== local3 0) (== local1 1))
		(cond
			((IsFlag 21)
				(lights setCycle: 0 cel: 0)
			)
			((== local11 15)
				(lights setCycle: Fwd)
			)
			((== gCurRoomNum 310)
				(lights setCycle: 0 cel: 1)
			)
			((== gCurRoomNum 300)
				(lights setCycle: 0 cel: 2)
			)
			((== gCurRoomNum 290)
				(lights setCycle: 0 cel: 3)
			)
			(else
				(lights setCycle: 0 cel: 0)
			)
		)
	else
		(lights setCycle: 0 cel: 0)
	)
)

(instance dataCorderInset of Inset
	(properties
		disposeNotOnMe 1
		modNum 900
		noun 13
	)

	(method (init)
		(if (IsFlag 159)
			(= picture 901)
		else
			(= picture 900)
		)
		(PalCycle 2) ; Pause
		(if (== (Platform) 2)
			(= local9 8951)
		else
			(= local9 895)
		)
		(Load rsVIEW local9)
		(Load 140 950 951 954 955 953 952 918 917 920 919 956) ; WAVE
		(super init: &rest)
		(dataCorderTop init:)
		(goUpButton init:)
		(goDownButton init:)
		(viewScreen init:)
		(lights init:)
		(powerButton init:)
		(openCloseButton init:)
		(curcuitBoard init:)
		(rogerHand init:)
		(leftDeskTop init:)
		(rightDeskTop init:)
		(reconfigButton init:)
		(newCursor init:)
		(dentium init:)
		(repentium init:)
		(fermentium init:)
		(dimtel init:)
		(spentium init:)
		(TT init:)
		(PS init:)
		(SE init:)
		(RF init:)
		(FC init:)
		(redA init:)
		(redB init:)
		(redC init:)
		(redD init:)
		(redE init:)
		(yellowA init:)
		(yellowB init:)
		(yellowC init:)
		(yellowD init:)
		(yellowE init:)
		(greenA init:)
		(greenB init:)
		(greenC init:)
		(greenD init:)
		(greenE init:)
		(blueA init:)
		(blueB init:)
		(blueC init:)
		(blueD init:)
		(blueE init:)
		(greyA init:)
		(greyB init:)
		(greyC init:)
		(greyD init:)
		(greyE init:)
		(if (IsFlag 191)
			(emptyFuse init:)
		else
			(fuseFeature init:)
		)
		(localproc_9)
		(localproc_4)
		(gTheIconBar setupExit: 1)
		(gGame handsOn:)
		(gTheIconBar select: (gTheIconBar at: 1))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(super doVerb: theVerb)
				else
					((gUser curEvent:) claimed: 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(newCursor x: gMouseX)
		(newCursor y: gMouseY)
	)

	(method (dispose)
		(PalCycle 3) ; Go
		(dataSound dispose:)
		(SetFlag 65)
		(gGame handsOn:)
		(super dispose:)
	)
)

(instance newCursor of View
	(properties
		view 896
	)

	(method (init)
		(super init:)
		(self hide:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance sButtonAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(switch client
					(openCloseButton
						(if local0
							(dataSound number: 951 play:)
						else
							(dataSound number: 950 play:)
						)
					)
					(goUpButton
						(if local1
							(dataSound number: 920 play:)
						)
					)
					(goDownButton
						(if local1
							(dataSound number: 919 play:)
						)
					)
				)
				(client cel: 1)
				(= ticks 20)
			)
			(1
				(client cel: 0)
				(= cycles 1)
			)
			(2
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance sReconfig of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(dataSound number: 917 play: self)
				(client cel: 1)
				(= ticks 20)
			)
			(2
				(lights setCycle: 0 cel: 0)
				(viewScreen loop: 12 cel: 0 cycleSpeed: 15 setCycle: Fwd)
				(client cel: 0)
			)
			(3
				(= ticks 20)
			)
			(4
				(TT loop: 0 cel: 0 y: 18)
				(PS loop: 1 cel: 1 y: 41)
				(SE loop: 2 cel: 2 y: 64)
				(RF loop: 3 cel: 3 y: 88)
				(FC loop: 4 cel: 4 y: 111)
				(dentium loop: 0 cel: 0 y: 20)
				(repentium loop: 1 cel: 1 y: 43)
				(fermentium loop: 2 cel: 2 y: 67)
				(dimtel loop: 3 cel: 3 y: 89)
				(spentium loop: 4 cel: 4 y: 113)
				(= local4 1)
				(= local5 1)
				(= local6 1)
				(= local7 1)
				(= local8 1)
				(= global143 0)
				(= global144 1)
				(= global145 2)
				(= global146 3)
				(= global147 4)
				(= local11 0)
				(= local12 15)
				(= [global128 0] 0)
				(= [global128 1] 1)
				(= [global128 2] 2)
				(= [global128 3] 3)
				(= [global128 4] 4)
				(= [global133 0] 0)
				(= [global133 1] 1)
				(= [global133 2] 2)
				(= [global133 3] 3)
				(= [global133 4] 4)
				(= [global138 0] 0)
				(= [global138 1] 1)
				(= [global138 2] 2)
				(= [global138 3] 3)
				(= [global138 4] 4)
				(= [global123 0] 0)
				(= [global123 1] 1)
				(= [global123 2] 2)
				(= [global123 3] 3)
				(= [global123 4] 4)
				(localproc_9)
				(= cycles 10)
			)
			(5
				(dataSound number: 956 play: self)
			)
			(6
				(viewScreen setCycle: End self)
			)
			(7
				(viewScreen loop: 13 cel: 0)
				(= ticks 30)
			)
			(8
				(gMessager say: 6 4 1 0 self 900) ; "You have successfully reconfigured the Datacorder\05 for standard use."
			)
			(9
				(viewScreen loop: 0)
				(= local3 0)
				(localproc_11)
				(= cycles 10)
			)
			(10
				(gTheIconBar setupExit: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goUpButton of Prop
	(properties
		noun 1
		modNum 900
		x 120
		y 189
		z 151
		view 898
		loop 1
	)

	(method (init)
		(self setPri: 25)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local2 0)
					(self setScript: sButtonAction)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(cond
			((not local1)
				(gMessager say: noun 4 0 0 0 900) ; "Ahem. This button doesn't do squat unless the power is on."
			)
			((and (> (viewScreen loop:) 0) (< (viewScreen loop:) 11))
				(-- local3)
				(viewScreen loop: local3)
				(localproc_11)
			)
		)
		(= local2 0)
	)
)

(instance goDownButton of Prop
	(properties
		noun 2
		modNum 900
		x 133
		y 189
		z 151
		view 898
		loop 2
	)

	(method (init)
		(self setPri: 25)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local2 0)
					(self setScript: sButtonAction)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(cond
			((not local1)
				(gMessager say: noun 4 0 0 0 900) ; "Ahem. This button doesn't do squat unless the power is on."
			)
			((< (viewScreen loop:) 10)
				(++ local3)
				(viewScreen loop: local3)
				(localproc_11)
			)
		)
		(= local2 0)
	)
)

(instance reconfigButton of Prop
	(properties
		noun 6
		modNum 900
		x 189
		y 189
		z 151
		view 898
		loop 3
	)

	(method (init)
		(self setPri: 25)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local2 0)
					(if local1
						(self setScript: sReconfig)
					else
						(self setScript: sButtonAction)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gMessager say: noun 4 0 0 0 900) ; "The power must be ON before you can reconfigure this unit."
		(= local2 0)
	)
)

(instance sCheckBeacon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 20 407)
				(self cue:)
			)
			(1
				(dataSound number: 918 play: self)
			)
			(2
				(lights setCycle: Fwd)
				(self cue:)
			)
			(3
				(cond
					((IsFlag 184)
						(gCurRoom notify:)
						(self dispose:)
					)
					((IsFlag 80)
						(gMessager say: 0 0 13 0 self 900) ; "It's not transmitting very well from here. Maybe I should try a different place."
					)
					(else
						(gMessager say: 0 0 12 0 self 900) ; "There seems to be something stopping the datacorder from transmitting."
					)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance powerButton of Prop
	(properties
		noun 3
		modNum 900
		x 224
		y 3
		view 897
		loop 7
	)

	(method (init)
		(self setPri: 5)
		(super init:)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(localproc_4)
				(if (and (== local2 0) (== (gTheCursor view:) 953))
					(cond
						((IsFlag 159)
							(gMessager say: 0 0 10 0 0 900) ; "Oh, great! The datacorder seems to be fried!"
						)
						(local0
							(gMessager say: noun theVerb 2 0 0 900) ; "You should close the faceplate before turning the power on."
						)
						((gEgo has: 23) ; Crystal
							(gMessager say: noun theVerb 3 0 0 900) ; "Sorry, Bucko, the Datacorder\05 won't work now that you've removed the power source. You'll have to put the Divalium crystal chip back."
						)
						(else
							(if (== (self cel:) 0)
								(self cel: 1)
								(= local1 1)
								(cond
									((== local11 15)
										(viewScreen loop: 14)
										(dataCorderInset
											setScript: sCheckBeacon
										)
									)
									((== local12 15)
										(dataSound number: 918 play:)
										(viewScreen loop: local3)
									)
									(else
										(dataSound number: 918 play:)
										(viewScreen
											loop: 15
											cycleSpeed: 14
											setCycle: Fwd
										)
									)
								)
							else
								(dataSound number: 918 play:)
								(self cel: 0)
								(viewScreen loop: 11 setCycle: 0)
								(= local1 0)
							)
							(localproc_11)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance openCloseButton of Prop
	(properties
		noun 4
		modNum 900
		x 223
		y 102
		view 897
		loop 8
	)

	(method (init)
		(self setPri: 10)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (== local2 0) (== (gTheCursor view:) 953))
					(cond
						(local1
							(super doVerb: theVerb &rest)
						)
						(
							(or
								(not local4)
								(not local5)
								(not local6)
								(not local7)
								(not local8)
							)
							(gMessager say: noun theVerb 5 0 0 900) ; "Put all the chips back before closing the faceplate. Thank you."
						)
						(
							(or
								(> (TT x:) 180)
								(> (PS x:) 180)
								(> (SE x:) 180)
								(> (RF x:) 180)
								(> (FC x:) 180)
							)
							(gMessager say: noun theVerb 7 0 0 900) ; "Put all the plates back before you close the faceplate."
						)
						(else
							(self setScript: sButtonAction)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if local0
			(gTheIconBar enable: 0)
			(dataCorderTop init:)
			(localproc_4)
			(= local0 0)
		else
			(gTheIconBar disable: 0)
			(dataCorderTop dispose:)
			(= local0 1)
		)
		(= local2 0)
	)
)

(instance lights of Prop
	(properties
		noun 11
		modNum 900
		x 91
		y 153
		z 151
		view 897
		loop 6
	)

	(method (init)
		(self setPri: 10)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance viewScreen of Prop
	(properties
		noun 5
		modNum 900
		x 122
		y 180
		z 151
		view 893
		loop 11
	)

	(method (init)
		(self setPri: 25)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dataCorderTop of View
	(properties
		noun 12
		modNum 900
		x 98
		y 150
		z 150
		priority 15
		fixPriority 1
		view 898
	)

	(method (init)
		(self setPri: 15)
		(reconfigButton show:)
		(goUpButton show:)
		(goDownButton show:)
		(viewScreen show:)
		(super init:)
	)

	(method (dispose)
		(reconfigButton hide:)
		(goUpButton hide:)
		(goDownButton hide:)
		(viewScreen hide:)
		(super dispose:)
	)
)

(instance emptyFuse of View
	(properties
		noun 10
		modNum 900
		x 114
		y 124
		priority 5
		fixPriority 1
		view 897
		loop 5
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27 ; Crystal
				(if (and (!= (gTheCursor view:) 894) (!= (gTheCursor view:) local9))
					(dataSound number: 955 play:)
					(gEgo put: 23) ; Crystal
					(ClearFlag 191)
					(fuseFeature init:)
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(self setPri: 5)
		(super init:)
	)
)

(class ChipView of View
	(properties
		modNum 900
		view 896
	)

	(method (init)
		(self setPri: 5)
		(switch [global128 cel]
			(0
				(self x: 128 y: 18 loop: 0)
			)
			(1
				(self x: 128 y: 41 loop: 1)
			)
			(2
				(self x: 128 y: 64 loop: 2)
			)
			(3
				(self x: 128 y: 88 loop: 3)
			)
			(4
				(self x: 128 y: 111 loop: 4)
			)
		)
		(super init:)
	)

	(method (hide)
		(dataSound number: 953 play:)
		(gTheCursor hide:)
		(newCursor view: view setLoop: loop setCel: cel show:)
		(super hide:)
	)
)

(instance TT of ChipView
	(properties
		noun 14
		x 128
		y 18
	)

	(method (init)
		(self setPri: 5)
		(localproc_2 [global128 0] global143)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((>= gMouseX 180)
						(cond
							(
								(and
									(>= gMouseX 180)
									(not local4)
									(== (gTheCursor view:) 894)
								)
								(= cel (gTheCursor cel:))
								(= local4 1)
								(= global143 (gTheCursor cel:))
								(= [global133 global143] 0)
								(dataSound number: 957 play:)
								(localproc_6 global143)
								(localproc_5)
							)
							((== (gTheCursor view:) 953)
								(self hide:)
								(if local4
									(gTheCursor
										view: local9
										setLoop: 0
										setCel: global143
										init:
									)
									(localproc_7 global143)
								else
									(gTheCursor
										view: local9
										setLoop: 0
										setCel: 5
										init:
									)
								)
							)
							((== (gTheCursor view:) local9)
								(gMessager say: 0 0 9 0 0 900) ; "You can't daisy-chain circuit plates. Nor do you need to."
							)
							(local4
								(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
							)
						)
					)
					((and (not local4) (== (gTheCursor view:) 894))
						(= local4 1)
						(= global143 (gTheCursor cel:))
						(= [global133 global143] 0)
						(dataSound number: 957 play:)
						(localproc_2 loop (gTheCursor cel:))
						(localproc_5)
					)
					((== (gTheCursor view:) 953)
						(= [global128 0] 0)
						(self hide:)
						(localproc_0 loop)
						(if local4
							(switch global143
								(0
									(dentium hide:)
								)
								(1
									(repentium hide:)
								)
								(2
									(fermentium hide:)
								)
								(3
									(dimtel hide:)
								)
								(4
									(spentium hide:)
								)
							)
							(gTheCursor
								view: local9
								setLoop: 0
								setCel: global143
								init:
							)
							(newCursor
								view: local9
								setLoop: 0
								setCel: global143
							)
						else
							(gTheCursor view: local9 setLoop: 0 setCel: 5 init:)
							(newCursor view: local9 setLoop: 0 setCel: 5)
						)
					)
					((== (gTheCursor view:) local9)
						(gMessager say: 0 0 6 0 0 900) ; "There's already a plate in this socket. Please remove it before attempting to insert a new plate. Thank you SO much."
					)
					(local4
						(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance PS of ChipView
	(properties
		noun 15
		x 128
		y 41
		loop 1
		cel 1
	)

	(method (init)
		(self setPri: 5)
		(localproc_2 [global128 1] global144)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((>= gMouseX 180)
						(cond
							(
								(and
									(>= gMouseX 180)
									(not local5)
									(== (gTheCursor view:) 894)
								)
								(= cel (gTheCursor cel:))
								(= local5 1)
								(= global144 (gTheCursor cel:))
								(= [global133 global144] 1)
								(dataSound number: 957 play:)
								(localproc_6 global144)
								(localproc_5)
							)
							((== (gTheCursor view:) 953)
								(self hide:)
								(if local5
									(gTheCursor
										view: local9
										setLoop: 1
										setCel: global144
										init:
									)
									(localproc_7 global144)
								else
									(gTheCursor
										view: local9
										setLoop: 1
										setCel: 5
										init:
									)
								)
							)
							((== (gTheCursor view:) local9)
								(gMessager say: 0 0 9 0 0 900) ; "You can't daisy-chain circuit plates. Nor do you need to."
							)
							(local5
								(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
							)
						)
					)
					((and (not local5) (== (gTheCursor view:) 894))
						(= local5 1)
						(= global144 (gTheCursor cel:))
						(= [global133 global144] 1)
						(dataSound number: 957 play:)
						(localproc_2 loop (gTheCursor cel:))
						(localproc_5)
					)
					((== (gTheCursor view:) 953)
						(= [global128 1] 0)
						(self hide:)
						(localproc_0 loop)
						(if local5
							(switch global144
								(0
									(dentium hide:)
								)
								(1
									(repentium hide:)
								)
								(2
									(fermentium hide:)
								)
								(3
									(dimtel hide:)
								)
								(4
									(spentium hide:)
								)
							)
							(gTheCursor
								view: local9
								setLoop: 1
								setCel: global144
								init:
							)
							(newCursor
								view: local9
								setLoop: 1
								setCel: global144
							)
						else
							(gTheCursor view: local9 setLoop: 1 setCel: 5 init:)
							(newCursor view: local9 setLoop: 1 setCel: 5)
						)
					)
					((== (gTheCursor view:) local9)
						(gMessager say: 0 0 6 0 0 900) ; "There's already a plate in this socket. Please remove it before attempting to insert a new plate. Thank you SO much."
					)
					(local5
						(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance SE of ChipView
	(properties
		noun 16
		x 128
		y 64
		loop 2
		cel 2
	)

	(method (init)
		(self setPri: 5)
		(localproc_2 [global128 2] global145)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((>= gMouseX 180)
						(cond
							(
								(and
									(>= gMouseX 180)
									(not local6)
									(== (gTheCursor view:) 894)
								)
								(= cel (gTheCursor cel:))
								(= local6 1)
								(= global145 (gTheCursor cel:))
								(= [global133 global145] 2)
								(dataSound number: 957 play:)
								(localproc_6 global145)
								(localproc_5)
							)
							((== (gTheCursor view:) 953)
								(self hide:)
								(if local6
									(gTheCursor
										view: local9
										setLoop: 2
										setCel: global145
										init:
									)
									(localproc_7 global145)
								else
									(gTheCursor
										view: local9
										setLoop: 2
										setCel: 5
										init:
									)
								)
							)
							((== (gTheCursor view:) local9)
								(gMessager say: 0 0 9 0 0 900) ; "You can't daisy-chain circuit plates. Nor do you need to."
							)
							(local6
								(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
							)
						)
					)
					((and (not local6) (== (gTheCursor view:) 894))
						(= local6 1)
						(= global145 (gTheCursor cel:))
						(= [global133 global145] 2)
						(dataSound number: 957 play:)
						(localproc_2 loop (gTheCursor cel:))
						(localproc_5)
					)
					((== (gTheCursor view:) 953)
						(= [global128 2] 0)
						(self hide:)
						(localproc_0 loop)
						(if local6
							(switch global145
								(0
									(dentium hide:)
								)
								(1
									(repentium hide:)
								)
								(2
									(fermentium hide:)
								)
								(3
									(dimtel hide:)
								)
								(4
									(spentium hide:)
								)
							)
							(gTheCursor
								view: local9
								setLoop: 2
								setCel: global145
								init:
							)
							(newCursor
								view: local9
								setLoop: 2
								setCel: global145
							)
						else
							(gTheCursor view: local9 setLoop: 2 setCel: 5 init:)
							(newCursor view: local9 setLoop: 2 setCel: 5)
						)
					)
					((== (gTheCursor view:) local9)
						(gMessager say: 0 0 6 0 0 900) ; "There's already a plate in this socket. Please remove it before attempting to insert a new plate. Thank you SO much."
					)
					(local6
						(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance RF of ChipView
	(properties
		noun 18
		x 128
		y 88
		loop 3
		cel 3
	)

	(method (init)
		(self setPri: 5)
		(localproc_2 [global128 3] global146)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((>= gMouseX 180)
						(cond
							(
								(and
									(>= gMouseX 180)
									(not local7)
									(== (gTheCursor view:) 894)
								)
								(= cel (gTheCursor cel:))
								(= local7 1)
								(= global146 (gTheCursor cel:))
								(= [global133 global146] 3)
								(dataSound number: 957 play:)
								(localproc_6 global146)
								(localproc_5)
							)
							((== (gTheCursor view:) 953)
								(self hide:)
								(if local7
									(gTheCursor
										view: local9
										setLoop: 3
										setCel: global146
										init:
									)
									(localproc_7 global146)
								else
									(gTheCursor
										view: local9
										setLoop: 3
										setCel: 5
										init:
									)
								)
							)
							((== (gTheCursor view:) local9)
								(gMessager say: 0 0 9 0 0 900) ; "You can't daisy-chain circuit plates. Nor do you need to."
							)
							(local7
								(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
							)
						)
					)
					((and (not local7) (== (gTheCursor view:) 894))
						(= local7 1)
						(= global146 (gTheCursor cel:))
						(= [global133 global146] 3)
						(dataSound number: 957 play:)
						(localproc_2 loop (gTheCursor cel:))
						(localproc_5)
					)
					((== (gTheCursor view:) 953)
						(= [global128 3] 0)
						(self hide:)
						(localproc_0 loop)
						(if local7
							(switch global146
								(0
									(dentium hide:)
								)
								(1
									(repentium hide:)
								)
								(2
									(fermentium hide:)
								)
								(3
									(dimtel hide:)
								)
								(4
									(spentium hide:)
								)
							)
							(gTheCursor
								view: local9
								setLoop: 3
								setCel: global146
								init:
							)
							(newCursor
								view: local9
								setLoop: 3
								setCel: global146
							)
						else
							(gTheCursor view: local9 setLoop: 3 setCel: 5 init:)
							(newCursor view: local9 setLoop: 3 setCel: 5)
						)
					)
					((== (gTheCursor view:) local9)
						(gMessager say: 0 0 6 0 0 900) ; "There's already a plate in this socket. Please remove it before attempting to insert a new plate. Thank you SO much."
					)
					(local7
						(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance FC of ChipView
	(properties
		noun 24
		x 128
		y 111
		loop 4
		cel 4
	)

	(method (init)
		(self setPri: 5)
		(localproc_2 [global128 4] global147)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((>= gMouseX 180)
						(cond
							(
								(and
									(>= gMouseX 180)
									(not local8)
									(== (gTheCursor view:) 894)
								)
								(= cel (gTheCursor cel:))
								(= local8 1)
								(= global147 (gTheCursor cel:))
								(= [global133 global147] 4)
								(dataSound number: 957 play:)
								(localproc_6 global147)
								(localproc_5)
							)
							((== (gTheCursor view:) 953)
								(self hide:)
								(if local8
									(gTheCursor
										view: local9
										setLoop: 4
										setCel: global147
										init:
									)
									(localproc_7 global147)
								else
									(gTheCursor
										view: local9
										setLoop: 4
										setCel: 5
										init:
									)
								)
							)
							((== (gTheCursor view:) local9)
								(gMessager say: 0 0 9 0 0 900) ; "You can't daisy-chain circuit plates. Nor do you need to."
							)
							(local8
								(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
							)
						)
					)
					((and (not local8) (== (gTheCursor view:) 894))
						(= local8 1)
						(= global147 (gTheCursor cel:))
						(= [global133 global147] 4)
						(dataSound number: 957 play:)
						(localproc_2 loop (gTheCursor cel:))
						(localproc_5)
					)
					((== (gTheCursor view:) 953)
						(= [global128 4] 0)
						(self hide:)
						(localproc_0 loop)
						(if local8
							(switch global147
								(0
									(dentium hide:)
								)
								(1
									(repentium hide:)
								)
								(2
									(fermentium hide:)
								)
								(3
									(dimtel hide:)
								)
								(4
									(spentium hide:)
								)
							)
							(gTheCursor
								view: local9
								setLoop: 4
								setCel: global147
								init:
							)
							(newCursor
								view: local9
								setLoop: 4
								setCel: global147
							)
						else
							(gTheCursor view: local9 setLoop: 4 setCel: 5 init:)
							(newCursor view: local9 setLoop: 4 setCel: 5)
						)
					)
					((== (gTheCursor view:) local9)
						(gMessager say: 0 0 6 0 0 900) ; "There's already a plate in this socket. Please remove it before attempting to insert a new plate. Thank you SO much."
					)
					(local8
						(gMessager say: 0 0 4 0 0 900) ; "That plate's chip socket is currently occupado! Please remove the first chip before attempting to insert the new one."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class PinView of View
	(properties
		modNum 900
		x 128
		view 894
	)

	(method (init)
		(self setPri: 10)
		(switch [global133 cel]
			(0
				(self y: 20 loop: 0)
			)
			(1
				(self y: 43 loop: 1)
			)
			(2
				(self y: 67 loop: 2)
			)
			(3
				(self y: 89 loop: 3)
			)
			(4
				(self y: 113 loop: 4)
			)
		)
		(super init:)
	)
)

(instance dentium of PinView
	(properties
		noun 19
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(self hide:)
					(gTheCursor view: view setLoop: loop setCel: cel init: hide:)
					(newCursor view: view setLoop: loop setCel: cel show:)
					(dataSound number: 953 play:)
					(if (<= gMouseX 180)
						(localproc_3 [global133 0])
					)
				else
					(gMessager say: 0 0 8 0 0 900) ; "Didn't that Sally Struthers learn-at-home course teach you not to stack components on top of each other?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance repentium of PinView
	(properties
		noun 20
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(self hide:)
					(gTheCursor view: view setLoop: loop setCel: cel init: hide:)
					(newCursor view: view setLoop: loop setCel: cel show:)
					(dataSound number: 953 play:)
					(if (<= gMouseX 180)
						(localproc_3 [global133 1])
					)
				else
					(gMessager say: 0 0 8 0 0 900) ; "Didn't that Sally Struthers learn-at-home course teach you not to stack components on top of each other?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fermentium of PinView
	(properties
		noun 21
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(self hide:)
					(gTheCursor view: view setLoop: loop setCel: cel init: hide:)
					(newCursor view: view setLoop: loop setCel: cel show:)
					(dataSound number: 953 play:)
					(if (<= gMouseX 180)
						(localproc_3 [global133 2])
					)
				else
					(gMessager say: 0 0 8 0 0 900) ; "Didn't that Sally Struthers learn-at-home course teach you not to stack components on top of each other?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dimtel of PinView
	(properties
		noun 22
		cel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(self hide:)
					(gTheCursor view: view setLoop: loop setCel: cel init: hide:)
					(newCursor view: view setLoop: loop setCel: cel show:)
					(dataSound number: 953 play:)
					(if (<= gMouseX 180)
						(localproc_3 [global133 3])
					)
				else
					(gMessager say: 0 0 8 0 0 900) ; "Didn't that Sally Struthers learn-at-home course teach you not to stack components on top of each other?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spentium of PinView
	(properties
		noun 23
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(self hide:)
					(gTheCursor view: view setLoop: loop setCel: cel init: hide:)
					(newCursor view: view setLoop: loop setCel: cel show:)
					(dataSound number: 953 play:)
					(if (<= gMouseX 180)
						(localproc_3 [global133 4])
					)
				else
					(gMessager say: 0 0 8 0 0 900) ; "Didn't that Sally Struthers learn-at-home course teach you not to stack components on top of each other?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dentiumFeature of Feature
	(properties
		noun 19
		modNum 900
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(gTheCursor view: 894 setLoop: 0 setCel: 0 init: hide:)
					(newCursor view: 894 setLoop: 0 setCel: 0 show:)
					(localproc_8 [global133 0])
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance repentiumFeature of Feature
	(properties
		noun 20
		modNum 900
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(gTheCursor view: 894 setLoop: 1 setCel: 1 init: hide:)
					(newCursor view: 894 setLoop: 1 setCel: 1 show:)
					(localproc_8 [global133 1])
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fermentiumFeature of Feature
	(properties
		noun 21
		modNum 900
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(gTheCursor view: 894 setLoop: 2 setCel: 2 init: hide:)
					(newCursor view: 894 setLoop: 2 setCel: 2 show:)
					(localproc_8 [global133 2])
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dimtelFeature of Feature
	(properties
		noun 22
		modNum 900
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(gTheCursor view: 894 setLoop: 3 setCel: 3 init: hide:)
					(newCursor view: 894 setLoop: 3 setCel: 3 show:)
					(localproc_8 [global133 3])
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spentiumFeature of Feature
	(properties
		noun 23
		modNum 900
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(gTheCursor view: 894 setLoop: 4 setCel: 4 init: hide:)
					(newCursor view: 894 setLoop: 4 setCel: 4 show:)
					(localproc_8 [global133 4])
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance curcuitBoard of Feature
	(properties
		noun 8
		modNum 900
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 219 2 219 131 217 133 103 133 100 131 100 2
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if (IsFlag 159)
					(gMessager say: 0 0 10 0 0 900) ; "Oh, great! The datacorder seems to be fried!"
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

(instance fuseFeature of Feature
	(properties
		noun 9
		modNum 900
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 115 126 115 129 124 130 133 129 133 126 123 125
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(if (IsFlag 462)
						(dataSound number: 955 play:)
					else
						(gGame points: 1 462)
					)
					(gEgo get: 23) ; Crystal
					(SetFlag 191)
					(emptyFuse init:)
					(self dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightDeskTop of Feature
	(properties
		noun 25
		modNum 900
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 241 0 241 138 320 138 320 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= (gTheCursor view:) 953)
					(cond
						((== (gTheCursor view:) 894)
							(if
								(and
									(< gMouseX 312)
									(> gMouseX 246)
									(< gMouseY 135)
									(> gMouseY 7)
								)
								(dataSound number: 953 play:)
								(switch (gTheCursor cel:)
									(0
										(dentium x: gMouseX y: gMouseY show:)
									)
									(1
										(repentium
											x: gMouseX
											y: gMouseY
											show:
										)
									)
									(2
										(fermentium
											x: gMouseX
											y: gMouseY
											show:
										)
									)
									(3
										(dimtel x: gMouseX y: gMouseY show:)
									)
									(4
										(spentium x: gMouseX y: gMouseY show:)
									)
								)
								(localproc_5)
							)
						)
						(
							(and
								(< gMouseX 305)
								(> gMouseX 262)
								(< gMouseY 130)
								(> gMouseY 10)
							)
							(dataSound number: 953 play:)
							(switch (gTheCursor loop:)
								(0
									(TT
										view: 895
										loop: (gTheCursor loop:)
										cel: (gTheCursor cel:)
										x: gMouseX
										y: gMouseY
										show:
									)
									(if local4
										(localproc_6 global143)
									)
								)
								(1
									(PS
										view: 895
										loop: (gTheCursor loop:)
										cel: (gTheCursor cel:)
										x: gMouseX
										y: gMouseY
										show:
									)
									(if local5
										(localproc_6 global144)
									)
								)
								(2
									(SE
										view: 895
										loop: (gTheCursor loop:)
										cel: (gTheCursor cel:)
										x: gMouseX
										y: gMouseY
										show:
									)
									(if local6
										(localproc_6 global145)
									)
								)
								(3
									(RF
										view: 895
										loop: (gTheCursor loop:)
										cel: (gTheCursor cel:)
										x: gMouseX
										y: gMouseY
										show:
									)
									(if local7
										(localproc_6 global146)
									)
								)
								(4
									(FC
										view: 895
										loop: (gTheCursor loop:)
										cel: (gTheCursor cel:)
										x: gMouseX
										y: gMouseY
										show:
									)
									(if local8
										(localproc_6 global147)
									)
								)
							)
							(localproc_5)
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftDeskTop of Feature
	(properties
		noun 17
		modNum 900
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 0 0 79 0 79 11 79 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rogerHand of Feature
	(properties
		noun 26
		modNum 900
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 79 11 60 17 56 20 33 56 25 85 15 126 14 138 80 138 86 115 87 95 91 75 97 57 95 39 88 34 83 34 78 37 74 47 73 38 79 36
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class ColumnView of View
	(properties
		noun 7
		modNum 900
		view 897
		rowNum 0
	)

	(method (init)
		(self setPri: 5)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch loop
					(0
						(redA cel: 0)
						(redB cel: 2)
						(redC cel: 0)
						(redD cel: 0)
						(redE cel: 2)
						(self cel: 1)
					)
					(1
						(yellowA cel: 0)
						(yellowB cel: 2)
						(yellowC cel: 0)
						(yellowD cel: 0)
						(yellowE cel: 2)
						(self cel: 3)
					)
					(2
						(greenA cel: 0)
						(greenB cel: 2)
						(greenC cel: 0)
						(greenD cel: 0)
						(greenE cel: 2)
						(self cel: 1)
					)
					(3
						(blueA cel: 0)
						(blueB cel: 2)
						(blueC cel: 0)
						(blueD cel: 0)
						(blueE cel: 2)
						(self cel: 1)
					)
					(4
						(greyA cel: 0)
						(greyB cel: 2)
						(greyC cel: 0)
						(greyD cel: 0)
						(greyE cel: 2)
						(self cel: 3)
					)
				)
				(= [global123 rowNum] loop)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class RowView of ColumnView
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) 953)
					(dataSound number: 954 play:)
					(switch rowNum
						(0
							(if (== cel 0)
								(redA cel: 0)
								(yellowA cel: 0)
								(greenA cel: 0)
								(blueA cel: 0)
								(greyA cel: 0)
								(super doVerb: theVerb &rest)
							else
								(self cel: 0)
							)
						)
						(1
							(if (== cel 2)
								(redB cel: 2)
								(yellowB cel: 2)
								(greenB cel: 2)
								(blueB cel: 2)
								(greyB cel: 2)
								(super doVerb: theVerb &rest)
							else
								(self cel: 2)
							)
						)
						(2
							(if (== cel 0)
								(redC cel: 0)
								(yellowC cel: 0)
								(greenC cel: 0)
								(blueC cel: 0)
								(greyC cel: 0)
								(super doVerb: theVerb &rest)
							else
								(self cel: 0)
							)
						)
						(3
							(if (== cel 0)
								(redD cel: 0)
								(yellowD cel: 0)
								(greenD cel: 0)
								(blueD cel: 0)
								(greyD cel: 0)
								(super doVerb: theVerb &rest)
							else
								(self cel: 0)
							)
						)
						(4
							(if (== cel 2)
								(redE cel: 2)
								(yellowE cel: 2)
								(greenE cel: 2)
								(blueE cel: 2)
								(greyE cel: 2)
								(super doVerb: theVerb &rest)
							else
								(self cel: 2)
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance redA of RowView
	(properties
		x 154
		y 10
	)
)

(instance yellowA of RowView
	(properties
		x 166
		y 10
		loop 1
	)
)

(instance greenA of RowView
	(properties
		x 177
		y 10
		loop 2
	)
)

(instance blueA of RowView
	(properties
		x 188
		y 10
		loop 3
	)
)

(instance greyA of RowView
	(properties
		x 200
		y 10
		loop 4
	)
)

(instance redB of RowView
	(properties
		x 154
		y 33
		cel 2
		rowNum 1
	)
)

(instance yellowB of RowView
	(properties
		x 166
		y 33
		loop 1
		cel 2
		rowNum 1
	)
)

(instance greenB of RowView
	(properties
		x 177
		y 33
		loop 2
		cel 2
		rowNum 1
	)
)

(instance blueB of RowView
	(properties
		x 188
		y 33
		loop 3
		cel 2
		rowNum 1
	)
)

(instance greyB of RowView
	(properties
		x 200
		y 33
		loop 4
		cel 2
		rowNum 1
	)
)

(instance redC of RowView
	(properties
		x 154
		y 57
		rowNum 2
	)
)

(instance yellowC of RowView
	(properties
		x 166
		y 57
		loop 1
		rowNum 2
	)
)

(instance greenC of RowView
	(properties
		x 177
		y 57
		loop 2
		rowNum 2
	)
)

(instance blueC of RowView
	(properties
		x 188
		y 57
		loop 3
		rowNum 2
	)
)

(instance greyC of RowView
	(properties
		x 200
		y 57
		loop 4
		rowNum 2
	)
)

(instance redD of RowView
	(properties
		x 154
		y 80
		rowNum 3
	)
)

(instance yellowD of RowView
	(properties
		x 166
		y 80
		loop 1
		rowNum 3
	)
)

(instance greenD of RowView
	(properties
		x 177
		y 80
		loop 2
		rowNum 3
	)
)

(instance blueD of RowView
	(properties
		x 188
		y 80
		loop 3
		rowNum 3
	)
)

(instance greyD of RowView
	(properties
		x 200
		y 80
		loop 4
		rowNum 3
	)
)

(instance redE of RowView
	(properties
		x 154
		y 103
		cel 2
		rowNum 4
	)
)

(instance yellowE of RowView
	(properties
		x 166
		y 103
		loop 1
		cel 2
		rowNum 4
	)
)

(instance greenE of RowView
	(properties
		x 177
		y 103
		loop 2
		cel 2
		rowNum 4
	)
)

(instance blueE of RowView
	(properties
		x 188
		y 103
		loop 3
		cel 2
		rowNum 4
	)
)

(instance greyE of RowView
	(properties
		x 200
		y 103
		loop 4
		cel 2
		rowNum 4
	)
)

(instance emptySlot1 of Feature
	(properties
		noun 27
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 113 26 142 26 144 24 144 16 137 10 122 10 109 15 109 24
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) local9)
					(= [global138 0] (gTheCursor loop:))
					(localproc_1 0 18)
					(self dispose:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance emptySlot2 of Feature
	(properties
		noun 28
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 111 49 142 49 144 48 144 40 136 33 122 33 109 38 109 47
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) local9)
					(= [global138 1] (gTheCursor loop:))
					(localproc_1 1 41)
					(self dispose:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance emptySlot3 of Feature
	(properties
		noun 29
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 112 72 142 72 145 70 145 63 136 56 121 56 109 62 109 70
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) local9)
					(= [global138 2] (gTheCursor loop:))
					(localproc_1 2 64)
					(self dispose:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance emptySlot4 of Feature
	(properties
		noun 30
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 111 96 142 96 145 93 145 87 137 79 121 79 109 85 109 94
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) local9)
					(= [global138 3] (gTheCursor loop:))
					(localproc_1 3 88)
					(self dispose:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance emptySlot5 of Feature
	(properties
		noun 31
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 111 119 142 119 144 117 144 108 138 103 122 103 109 108 109 117
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gTheCursor view:) local9)
					(= [global138 4] (gTheCursor loop:))
					(localproc_1 4 111)
					(self dispose:)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dataSound of Sound
	(properties
		flags 1
	)
)

