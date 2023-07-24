;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 765)
(include sci.sh)
(use Main)
(use LightRoom)
(use SwitchView)
(use PanelPlane)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm765 0
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
)

(instance rm765 of LightRoom
	(properties)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(if (IsFlag 171)
			(gGame setScript: (ScriptID 18)) ; sBatteryScript
			(sBatteryFlash init:)
		)
		(if (== gPrevRoomNum 760)
			(self changeScene: 773 5)
		else
			(ClearFlag 142)
			(ClearFlag 173)
			(ClearFlag 150)
			(ClearFlag 141)
			(ClearFlag 205)
			(ClearFlag 139)
			(= local13 1)
			(self changeScene: -1)
		)
	)

	(method (changeScene param1)
		(if
			(and
				(== param1 765)
				(or
					local6
					(and
						(IsFlag 173)
						(IsFlag 205)
						(IsFlag 139)
						(not local6)
						(not (and local3 (not (IsFlag 318))))
					)
				)
			)
			(= local15 1)
			(= param1 0)
		)
		(super changeScene: param1 &rest)
		(if local15
			(= param1 765)
			(= scene 765)
		)
		(= local0 (= local1 (= local2 0)))
		(TPMonitor760 dispose:)
		(mainSwitch760 dispose:)
		(lights760 dispose:)
		(bulbs760 dispose:)
		(domainMonitor760 dispose:)
		(fortressMonitor760 dispose:)
		(roostMonitor760 dispose:)
		(templeMonitor760 dispose:)
		(lirylDoor762 dispose:)
		(lirylDoorFeat762 dispose:)
		(tpMonitor762 dispose:)
		(lirylRoom762 dispose:)
		(lirylFeat762 dispose:)
		(battLight0763 dispose:)
		(battLight1763 dispose:)
		(battLight2763 dispose:)
		(plugView763 dispose:)
		(lever763 dispose:)
		(lights765 dispose:)
		(bulbs765 dispose:)
		(tpMonitor765 dispose:)
		(domainMonitor765 dispose:)
		(fortressMonitor765 dispose:)
		(templeMonitor765 dispose:)
		(roostMonitor765 dispose:)
		(battLight0771 dispose:)
		(battLight1771 dispose:)
		(battLight2771 dispose:)
		(lirylDoor772 dispose:)
		(lirylRoom772 dispose:)
		(battLight773 dispose:)
		(pulpit773 dispose:)
		(beam773 dispose:)
		(TPMonitor774 dispose:)
		(mainSwitch774 dispose:)
		(bulbs774 dispose:)
		(domainMonitor774 dispose:)
		(fortressMonitor774 dispose:)
		(roostMonitor774 dispose:)
		(templeMonitor774 dispose:)
		(battLight0774 dispose:)
		(battLight1774 dispose:)
		(lirylDoor774 dispose:)
		(pulpit774 dispose:)
		(beam774 dispose:)
		(lirylDoor775 dispose:)
		(pulpit776 dispose:)
		(battLight0778 dispose:)
		(battLight1778 dispose:)
		(plugFeat779 dispose:)
		(plugView779 dispose:)
		(battLight0779 dispose:)
		(battLight1779 dispose:)
		(bulbs780 dispose:)
		(mainSwitch780 dispose:)
		(templeMonitor780 dispose:)
		(lights780 dispose:)
		(tpMonitor780 dispose:)
		(lirylDoor780 dispose:)
		(lirylRoom780 dispose:)
		(lirylFeat780 dispose:)
		(battLight0781 dispose:)
		(battLight1781 dispose:)
		(beam781 dispose:)
		(pulpit781 dispose:)
		(lirylFeat782 dispose:)
		(lirylControl782 dispose:)
		(lirylLights782 dispose:)
		(switch param1
			(-1
				(gCurRoom setScript: sFromCentral)
			)
			(760
				(TPMonitor760 init:)
				(mainSwitch760 init:)
				(if (and (IsFlag 188) (IsFlag 143))
					(lights760 init: setCycle: Fwd)
					(bulbs760 init: setCycle: Fwd)
				)
				(domainMonitor760 init:)
				(fortressMonitor760 init:)
				(roostMonitor760 init:)
				(templeMonitor760 init:)
				((ScriptID 1 2) newPic: 767 5) ; exitBack
				((ScriptID 1 1) ; exitForward
					newRoom: 760
					nsLeft: 109
					nsTop: 41
					nsRight: 406
					nsBottom: 208
				)
				((ScriptID 1 3) newPic: 763 3) ; exitLeft
				((ScriptID 1 4) newPic: 762 7) ; exitRight
			)
			(761
				((ScriptID 1 2) newPic: 774 1) ; exitBack
				((ScriptID 1 3) newPic: 775 15) ; exitLeft
			)
			(762
				(cond
					((and (== global236 765) (IsFlag 286) local13)
						(ClearFlag 286)
						(gCurRoom setScript: sLirylEnter)
					)
					((and local3 local14)
						(= local14 0)
						(gGame handsOff:)
						(gCurRoom setScript: sLirylLeavePissed)
					)
					(local5
						(gGame handsOff:)
						(gCurRoom setScript: sLirylExit)
					)
				)
				(= local13 0)
				(if local3
					(lirylDoor762 init:)
					(lirylRoom762 init:)
					(lirylFeat762 init:)
				else
					(lirylDoorFeat762 init:)
				)
				((ScriptID 1 2) newPic: 763 3) ; exitBack
				((ScriptID 1 1) ; exitForward
					newPic: 780 1
					arrowStyle: 8
					nsLeft: 152
					nsTop: 57
					nsRight: 195
					nsBottom: 228
				)
				((ScriptID 1 3) newPic: 760 1) ; exitLeft
				((ScriptID 1 4) newPic: 767 5) ; exitRight
				((ScriptID 1 7) ; exitBackUp
					newPic: 776 4
					arrowStyle: 7
					nsLeft: 369
					nsTop: 107
					nsRight: 446
					nsBottom: 279
				)
				(tpMonitor762 init:)
			)
			(763
				(lever763 init:)
				(if (IsFlag 171)
					(plugView763 init:)
					(battLight0763 init: hide:)
					(battLight1763 init: hide:)
					(battLight2763 init: hide:)
					(= local0 battLight0763)
					(= local1 battLight1763)
					(= local2 battLight2763)
				)
				((ScriptID 1 2) ; exitBack
					newPic: 762 7
					nsLeft: 183
					nsTop: 270
					nsRight: 344
					nsBottom: 299
				)
				((ScriptID 1 1) ; exitForward
					newPic: 779 11
					arrowStyle: 8
					nsLeft: 114
					nsTop: 73
					nsRight: 282
					nsBottom: 216
				)
				((ScriptID 1 6) ; exitUp
					newPic: 778 1
					arrowStyle: 7
					nsLeft: 283
					nsTop: 73
					nsRight: 460
					nsBottom: 216
				)
				((ScriptID 1 3) newPic: 767 5) ; exitLeft
				((ScriptID 1 4) newPic: 760 1) ; exitRight
			)
			(765
				(cond
					(
						(and
							(IsFlag 173)
							(IsFlag 205)
							(IsFlag 139)
							(not local6)
						)
						(if (and local3 (not (IsFlag 318)))
							(gGame handsOff:)
							(= local10 1)
							(gCurRoom changeScene: 782 7)
						else
							(= local6 1)
						)
					)
					((not local6)
						(if (and (IsFlag 188) (IsFlag 143))
							(lights765 init: setCycle: Fwd)
							(bulbs765 init: setCycle: Fwd)
						)
						(tpMonitor765 init:)
						(domainMonitor765 init:)
						(fortressMonitor765 init:)
						(templeMonitor765 init:)
						(roostMonitor765 init:)
						((ScriptID 1 2) newPic: 761 5) ; exitBack
					)
				)
				(if local6
					(SetFlag 318)
					(gGame handsOff:)
					(gCurRoom setScript: sTimeToZap)
				)
			)
			(767
				((ScriptID 1 3) newPic: 762 7) ; exitLeft
				((ScriptID 1 4) newPic: 763 3) ; exitRight
				((ScriptID 1 2) newPic: 760 1) ; exitBack
			)
			(771
				(if (IsFlag 171)
					(battLight0771 init: hide:)
					(battLight1771 init: hide:)
					(battLight2771 init: hide:)
					(= local0 battLight0771)
					(= local1 battLight1771)
					(= local2 battLight2771)
				)
				((ScriptID 1 1) newPic: 779 11) ; exitForward
				((ScriptID 1 4) newRoom: 760) ; exitRight
			)
			(772
				(if local3
					(lirylDoor772 init:)
					(lirylRoom772 init:)
				)
				((ScriptID 1 4) newPic: 781 5 arrowStyle: 7) ; exitRight
				((ScriptID 1 3) newPic: 780 1) ; exitLeft
				((ScriptID 1 2) newRoom: 760) ; exitBack
			)
			(773
				(if (IsFlag 171)
					(battLight773 init: hide:)
					(= local0 battLight773)
				)
				(if (and (IsFlag 188) (IsFlag 141))
					(pulpit773 init:)
				else
					((ScriptID 1 1) newPic: 767 5) ; exitForward
				)
				(if (and (IsFlag 173) (IsFlag 205) (IsFlag 139))
					(beam773 init: setCycle: Fwd)
				)
				(if
					(and
						(== global236 765)
						(not (IsFlag 286))
						(not (IsFlag 234))
					)
					(= local3 1)
				)
				((ScriptID 1 4) newPic: 771 4 arrowStyle: 7) ; exitRight
				((ScriptID 1 3) newPic: 772 6 arrowStyle: 8) ; exitLeft
				((ScriptID 1 2) newRoom: 760) ; exitBack
			)
			(774
				(if local3
					(lirylDoor774 init:)
				)
				(TPMonitor774 init:)
				(mainSwitch774 init:)
				(if (and (IsFlag 188) (IsFlag 143))
					(bulbs774 init: setCycle: Fwd)
				)
				(domainMonitor774 init:)
				(fortressMonitor774 init:)
				(roostMonitor774 init:)
				(templeMonitor774 init:)
				(if (IsFlag 171)
					(battLight0774 init: hide:)
					(battLight1774 init: hide:)
					(= local1 battLight1774)
					(= local2 battLight0774)
				)
				(if (and (IsFlag 141) (IsFlag 188))
					(pulpit774 init:)
					((ScriptID 1 1) newPic: 765 1) ; exitForward
				)
				(if (and (IsFlag 173) (IsFlag 205) (IsFlag 139))
					(beam774 init: setCycle: Fwd)
				)
				((ScriptID 1 4) newPic: 775 15) ; exitRight
			)
			(775
				(if local3
					(lirylDoor775 init: setPri: 10)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 780 1
					arrowStyle: 8
					nsLeft: 40
					nsTop: 74
					nsRight: 263
					nsBottom: 255
				)
				((ScriptID 1 2) newPic: 774 1) ; exitBack
			)
			(776
				(if (and (IsFlag 188) (IsFlag 141))
					(pulpit776 init:)
				)
				((ScriptID 1 1) newPic: 774 1 arrowStyle: 7) ; exitForward
				((ScriptID 1 2) newPic: 780 1) ; exitBack
			)
			(778
				(if (IsFlag 171)
					(battLight0778 init: hide:)
					(battLight1778 init: hide:)
					(= local1 battLight0778)
					(= local2 battLight1778)
				)
				((ScriptID 1 4) newRoom: 760) ; exitRight
				((ScriptID 1 3) newPic: 779 11) ; exitLeft
				(if (not (and (IsFlag 188) (IsFlag 141)))
					((ScriptID 1 7) newPic: 763 3) ; exitBackUp
				)
			)
			(779
				(if (IsFlag 171)
					(plugView779 init:)
					(battLight0779 init: hide:)
					(battLight1779 init: hide:)
					(= local0 battLight1779)
					(= local1 battLight0779)
				else
					(plugFeat779 init:)
				)
				((ScriptID 1 4) newPic: 778 1) ; exitRight
				(if (not (and (IsFlag 188) (IsFlag 141)))
					((ScriptID 1 7) newPic: 763 3) ; exitBackUp
				)
			)
			(780
				(if local3
					(lirylDoor780 init:)
					(lirylRoom780 init:)
					(lirylFeat780 init:)
				)
				(if (and (IsFlag 188) (IsFlag 143))
					(lights780 init: setCycle: Fwd)
					(bulbs780 init: setCycle: Fwd)
				)
				(mainSwitch780 init:)
				(templeMonitor780 init:)
				(tpMonitor780 init:)
				((ScriptID 1 3) newRoom: 760 arrowStyle: 8) ; exitLeft
				((ScriptID 1 2) newPic: 781 5) ; exitBack
			)
			(781
				(if (IsFlag 171)
					(battLight0781 init:)
					(battLight1781 init:)
					(= local0 battLight0781)
					(= local1 battLight1781)
				)
				(if (and (IsFlag 188) (IsFlag 141))
					(pulpit781 init:)
				)
				(if (and (IsFlag 173) (IsFlag 205) (IsFlag 139))
					(beam781 init: setPri: 300 setCycle: Fwd)
				)
				(if (not (and (IsFlag 188) (IsFlag 141)))
					((ScriptID 1 4) ; exitRight
						newPic: 763 3
						arrowStyle: 7
						nsLeft: 299
						nsTop: 80
						nsRight: 439
						nsBottom: 207
					)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 776 4
					arrowStyle: 7
					nsLeft: 6
					nsTop: 116
					nsRight: 188
					nsBottom: 238
				)
				((ScriptID 1 2) newPic: 780 1) ; exitBack
			)
			(782
				(lirylControl782 init:)
				(lirylFeat782 init:)
				(lirylLights782 init:)
				((ScriptID 1 7) newPic: 762 7) ; exitBackUp
				(if local11
					(= local11 0)
					(lirylFeat782 doVerb: 5)
				)
				(if local10
					(= local10 1)
					(gCurRoom setScript: sLirylFarewell)
				)
			)
		)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0)
		(if (== newRoomNumber 760)
			(super newRoom: newRoomNumber)
		else
			(gBackMusic fade: 0 10 7 1 0)
			(gBackMusic2 fade: 0 10 7 1 0)
			(if (not local4)
				(cond
					((< (= temp0 (Random 1 8)) 4)
						(= global236 765)
						(if (not local3)
							(SetFlag 286)
						)
					)
					((< temp0 7)
						(if (!= global236 750)
							(SetFlag 286)
						)
						(= global236 750)
					)
					(else
						(if (!= global236 740)
							(SetFlag 286)
						)
						(= global236 740)
					)
				)
			)
			(if (and local3 (!= global236 765))
				(if local6
					(= local3 0)
					(= local4 1)
				else
					(gGame handsOff:)
					(= local5 1)
					(gCurRoom changeScene: 762)
				)
			)
			(if (or (not local3) (== global236 765) local4)
				(gGame setScript: 0)
				(super newRoom: newRoomNumber)
			)
		)
	)
)

(instance roomSfx of Sound
	(properties)
)

(instance sFromCentral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(if (and (== global236 740) (not (IsFlag 286)))
					(= register 743)
				else
					(= register 754)
				)
				(gGlobalVMD number: register holdLastFrame: 1 init: play: close:)
				(gBackMusic
					number: (if (Random 0 1) 701 else 703)
					loop: -1
					setVol: 127
					init:
					play:
				)
				(gGlobalVMD holdLastFrame: 0 putOptions: 256 boostRGB: 0)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) show:) ; PlCompass
				)
				(if (and (== global236 765) (IsFlag 286))
					(gCurRoom changeScene: 762 7)
				else
					(if (== global236 765)
						(= local3 1)
					)
					(gCurRoom changeScene: 763 3)
				)
				(if (IsFlag 171)
					(gGame setScript: (ScriptID 18)) ; sBatteryScript
					(sBatteryFlash init:)
				)
				(self dispose:)
			)
		)
	)
)

(instance TPMonitor760 of SwitchView
	(properties
		x 322
		y 161
		view 6731
		loop 9
		myFlag 142
		offCel 0
	)
)

(instance mainSwitch760 of SwitchView
	(properties
		x 217
		y 174
		view 6731
		myFlag 143
		offCel 0
	)
)

(instance lights760 of Prop
	(properties
		x 210
		y 171
		view 6731
		loop 1
	)
)

(instance bulbs760 of Prop
	(properties
		x 231
		y 156
		view 6731
		loop 7
	)
)

(instance templeMonitor760 of SwitchView
	(properties
		x 139
		y 122
		view 6731
		loop 3
		myFlag 148
		offCel 0
	)
)

(instance domainMonitor760 of SwitchView
	(properties
		x 173
		y 133
		view 6731
		loop 6
		myFlag 146
		offCel 0
	)
)

(instance roostMonitor760 of SwitchView
	(properties
		x 139
		y 157
		view 6731
		loop 4
		myFlag 147
		offCel 0
	)
)

(instance fortressMonitor760 of SwitchView
	(properties
		x 172
		y 156
		view 6731
		loop 5
		myFlag 149
		offCel 0
	)
)

(instance tpMonitor762 of View
	(properties
		y 180
		view 6732
		loop 1
	)
)

(instance lirylFeat762 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 108 76 128 78 136 88 156 95 156 133 139 161 82 162 70 141 49 134 51 119 81 89 97 86
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(= local11 1)
				(gCurRoom changeScene: 782 7)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lirylDoor762 of View
	(properties
		x 53
		y 34
		view 6732
	)
)

(instance lirylRoom762 of Feature
	(properties
		nsLeft 221
		nsTop 125
		nsRight 286
		nsBottom 222
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(++ local9)
				(sSaySomething init: 0 0 local9)
				(if (>= local9 2)
					(= local9 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lirylDoorFeat762 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 235 110 271 110 307 141 309 185 280 220 227 220 197 196 196 141
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(roomSfx number: 776 play:)
				(if (and (not local3) (not (IsFlag 234)) (== (Random 1 6) 1))
					(gGame handsOff:)
					(gCurRoom setScript: sLirylEnter)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sLirylEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KillRobot 4172 50 35)
			)
			(1
				(= local3 1)
				(= global236 765)
				(lirylDoor762 init:)
				(lirylFeat762 init:)
				(lirylDoorFeat762 dispose:)
				(SetFlag 295)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLirylLeavePissed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 0)
				(KillRobot 4174 50 33)
			)
			(1
				(lirylDoorFeat762 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLirylExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KillRobot 4174 50 33)
				(= local3 0)
			)
			(1
				(gCurRoom changeScene: 763)
				(= seconds 2)
			)
			(2
				(= local4 1)
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance lever763 of Prop
	(properties
		x 255
		y 298
		view 6764
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (IsFlag 188) (IsFlag 152))
					(roomSfx number: 709 play:)
				else
					(gGame handsOff:)
					(roomSfx number: 777 play:)
					(gCurRoom setScript: sToCentral)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sToCentral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lever763 setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance plugView763 of View
	(properties
		x 104
		y 249
		view 763
		loop 1
	)
)

(instance battLight0763 of View
	(properties
		x 132
		y 190
		view 763
	)
)

(instance battLight1763 of View
	(properties
		x 132
		y 190
		view 763
		cel 1
	)
)

(instance battLight2763 of View
	(properties
		x 132
		y 190
		view 763
		cel 2
	)
)

(instance sTimeToZap of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gBackMusic stop:)
				(gBackMusic2 stop:)
				(= cycles 2)
			)
			(1
				(ClearFlag 152)
				(ClearFlag 145)
				(gCurRoom drawPic: -1)
				(proc0_8 7765)
				(self cue:)
			)
			(2
				(switch global235
					(226
						(= temp0 212)
					)
					(352
						(= temp0 350)
					)
					(373
						(= temp0 360)
						(SetFlag 285)
					)
					(376
						(= temp0 360)
						(ClearFlag 285)
					)
					(464
						(= temp0 470)
						(SetFlag 304)
					)
					(476
						(= temp0 470)
						(ClearFlag 304)
					)
					(493
						(= temp0 490)
					)
					(609
						(= temp0 600)
					)
					(611
						(= temp0 610)
					)
					(656
						(= temp0 660)
					)
					(706
						(= temp0 710)
					)
					(815
						(= temp0 810)
					)
					(839
						(= temp0 800)
					)
				)
				(cond
					((and (IsFlag 349) (OneOf temp0 350 360))
						(= global224 1)
						(= global225 380)
						(gGame getDisc: global224)
						(gCurRoom newRoom: 380)
					)
					(
						(and
							(OneOf temp0 350 360)
							(not (gInventory contains: (ScriptID 9 39))) ; invModulator
							(not global207)
							(not (IsFlag 289))
							(not (IsFlag 290))
						)
						(SetFlag 397)
						(= global224 1)
						(= global225 380)
						(gGame getDisc: global224)
						(gCurRoom newRoom: 380)
					)
					((OneOf temp0 470 490 610 660)
						(if
							(and
								(OneOf temp0 610 660)
								(!= global226 3)
								(IsFlag 306)
							)
							(if (== temp0 610)
								(SetFlag 220)
							else
								(SetFlag 203)
							)
							(= global224 1)
							(= global225 380)
							(gGame getDisc: global224)
							(gCurRoom newRoom: 380)
						else
							(= global224 2)
							(= global225 temp0)
							(gGame getDisc: global224)
							(gCurRoom newRoom: temp0)
						)
					)
					(else
						(gCurRoom newRoom: temp0)
					)
				)
			)
		)
	)
)

(instance lights765 of Prop
	(properties
		x 193
		y 152
		view 6765
	)
)

(instance bulbs765 of Prop
	(properties
		x 227
		y 147
		view 6765
		loop 1
	)
)

(instance tpMonitor765 of SwitchView
	(properties
		x 350
		y 169
		view 6765
		loop 2
		myFlag 173
		offCel 0
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag myFlag)
			(self cel: (self lastCel:))
		)
	)
)

(instance domainMonitor765 of SwitchView
	(properties
		x 156
		y 89
		view 6765
		loop 3
		myFlag 146
		offCel 0
	)
)

(instance fortressMonitor765 of SwitchView
	(properties
		x 132
		y 124
		view 6765
		loop 4
		myFlag 147
		offCel 0
	)
)

(instance templeMonitor765 of SwitchView
	(properties
		x 182
		y 124
		view 6765
		loop 5
		myFlag 149
		offCel 0
	)
)

(instance roostMonitor765 of SwitchView
	(properties
		x 131
		y 76
		view 6765
		loop 6
		myFlag 148
		offCel 0
	)
)

(instance battLight0771 of View
	(properties
		x 137
		y 221
		view 3740
	)
)

(instance battLight1771 of View
	(properties
		x 137
		y 221
		view 3740
		cel 1
	)
)

(instance battLight2771 of View
	(properties
		x 137
		y 221
		view 3740
		cel 2
	)
)

(instance lirylDoor772 of View
	(properties
		y 81
		view 785
	)
)

(instance lirylRoom772 of Feature
	(properties
		nsLeft 145
		nsTop 120
		nsRight 224
		nsBottom 238
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(++ local9)
				(sSaySomething init: 0 0 local9)
				(if (>= local9 2)
					(= local9 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance battLight773 of View
	(properties
		x 453
		y 184
		view 7773
		loop 1
	)
)

(instance pulpit773 of Prop
	(properties
		x 135
		y 299
		view 7773
	)
)

(instance beam773 of Prop
	(properties
		x 134
		y 299
		view 6773
	)
)

(instance pulpit774 of Prop
	(properties
		x 46
		y 299
		view 7774
		loop 8
	)
)

(instance beam774 of Prop
	(properties
		x 100
		y 299
		view 6774
	)
)

(instance lirylDoor774 of View
	(properties
		x 335
		y 66
		view 2739
	)
)

(instance TPMonitor774 of SwitchView
	(properties
		x 293
		y 163
		view 7774
		loop 15
		myFlag 142
		offCel 0
	)

	(method (init)
		(super init: &rest)
		(self cel: (self lastCel:))
	)
)

(instance mainSwitch774 of SwitchView
	(properties
		x 228
		y 163
		view 7774
		loop 10
		myFlag 143
		offCel 0
	)
)

(instance bulbs774 of Prop
	(properties
		x 239
		y 151
		view 7774
		loop 2
	)
)

(instance domainMonitor774 of SwitchView
	(properties
		x 179
		y 138
		view 7774
		loop 14
		myFlag 148
		offCel 0
	)
)

(instance templeMonitor774 of SwitchView
	(properties
		x 179
		y 156
		view 7774
		loop 13
		myFlag 147
		offCel 0
	)
)

(instance roostMonitor774 of SwitchView
	(properties
		x 203
		y 139
		view 7774
		loop 11
		myFlag 146
		offCel 0
	)
)

(instance fortressMonitor774 of SwitchView
	(properties
		x 202
		y 156
		view 7774
		loop 12
		myFlag 149
		offCel 0
	)
)

(instance battLight0774 of View
	(properties
		x 69
		y 171
		view 7774
	)
)

(instance battLight1774 of View
	(properties
		y 182
		view 7774
		loop 1
	)
)

(instance lirylDoor775 of View
	(properties
		view 6730
	)
)

(instance pulpit776 of View
	(properties
		x 285
		y 299
		view 3776
	)
)

(instance battLight0778 of View
	(properties
		y 168
		view 3744
	)
)

(instance battLight1778 of View
	(properties
		x 216
		y 137
		view 3744
		loop 1
	)
)

(instance battLight0779 of View
	(properties
		x 378
		y 151
		view 3742
	)
)

(instance battLight1779 of View
	(properties
		x 167
		y 144
		view 3742
		loop 1
	)
)

(instance plugView779 of View
	(properties
		x 99
		y 124
		view 779
	)
)

(instance plugFeat779 of Feature
	(properties
		nsLeft 101
		nsTop 104
		nsRight 180
		nsBottom 238
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(plugInset init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance plugInset of InsetPanelPlane
	(properties)

	(method (init)
		(super init: 0 0 200 200)
		(self setBitmap: 6763 0 0)
		(plugInsetFeat init: self 1 1)
		(global105 delete: (bitmap approachX:))
	)

	(method (dispose)
		(plugInsetFeat dispose:)
		(super dispose:)
	)
)

(instance plugInsetFeat of PanelFeature
	(properties
		nsLeft 80
		nsTop 90
		nsRight 120
		nsBottom 160
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sPlugIn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance plugInsetProp of PanelProp
	(properties
		view 6763
	)
)

(instance sPlugIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(plugInsetProp
					init: plugInset 1 0
					setPri: (+ (GetHighPlanePri) 1)
					setCycle: End self
				)
			)
			(1
				(roomSfx number: 343 play:)
				(ClearFlag 139)
				(ClearFlag 140)
				(ClearFlag 141)
				(ClearFlag 143)
				(ClearFlag 144)
				(plugInset dispose:)
				(plugInsetProp dispose:)
				(plugFeat779 dispose:)
				(SetFlag 171)
				(plugView779 init:)
				(battLight0779 init: hide:)
				(battLight1779 init: hide:)
				(= local0 battLight1779)
				(= local1 battLight0779)
				(gGame setScript: (ScriptID 18)) ; sBatteryScript
				(sBatteryFlash init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lirylRoom780 of Feature
	(properties
		nsLeft 414
		nsTop 56
		nsRight 499
		nsBottom 287
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(++ local9)
				(sSaySomething init: 0 0 local9)
				(if (>= local9 2)
					(= local9 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lirylDoor780 of View
	(properties
		x 146
		y 2
		view 2738
	)
)

(instance lirylFeat780 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 230 49 253 49 269 88 271 120 234 144 161 154 134 110 192 82 179 64
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(= local11 1)
				(gCurRoom changeScene: 782 7)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bulbs780 of Prop
	(properties
		x 51
		y 140
		view 780
	)
)

(instance mainSwitch780 of SwitchView
	(properties
		x 31
		y 184
		view 780
		loop 2
		myFlag 143
	)
)

(instance templeMonitor780 of SwitchView
	(properties
		y 150
		view 780
		loop 7
		myFlag 149
		offCel 0
	)
)

(instance lights780 of Prop
	(properties
		x 24
		y 113
		view 780
		loop 5
	)
)

(instance tpMonitor780 of SwitchView
	(properties
		x 131
		y 151
		view 780
		loop 8
		myFlag 142
		offCel 0
	)
)

(instance pulpit781 of View
	(properties
		x 149
		y 299
		view 7781
		loop 2
	)
)

(instance beam781 of Prop
	(properties
		x 294
		y 212
		view 6781
	)
)

(instance battLight0781 of View
	(properties
		x 338
		y 140
		view 7781
	)
)

(instance battLight1781 of View
	(properties
		x 436
		y 140
		view 7781
		loop 1
	)
)

(instance lirylLights782 of Prop
	(properties
		x 249
		y 182
		view 175
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 14 setCycle: Fwd)
	)
)

(instance lirylFeat782 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 166 83 208 83 277 140 303 160 328 234 312 286 310 301 121 301 50 268 95 122
		)
		(approachX hotVerbs: 5 60 96 19 51 94 20 21 47)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 234)
					(switch (++ local12)
						(1
							(gMessager say: 8 0 17 1 0 720) ; "Go (click) away! I do not trust you!"
						)
						(2
							(gMessager say: 8 0 18 1 0 720) ; "I am busy now, I will talk to you later.( Liryl turns away toward her work table)"
						)
						(3
							(gGame handsOff:)
							(gCurRoom setScript: sLirylLeaves)
						)
					)
				else
					(gMessager say: 7 0 16 (Random 1 6) 0 720)
				)
			)
			(60 ; invCD
				(gMessager say: 9 0 20 1 0 720) ; "You are not of this land. To understand what has happened here, you must first learn our history."
			)
			(96 ; invBeingInBottle
				(gMessager say: 8 96 0 1 0 720) ; "Thank for saving our land. I could not have stopped him by myself."
			)
			(19 ; invShell
				(if (IsFlag 234)
					(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
					(ClearFlag 234)
					(gInventory deleteItem: (ScriptID 9 88)) ; invShell
				else
					(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
					(gInventory deleteItem: (ScriptID 9 88)) ; invShell
				)
			)
			(51 ; invBaubles
				(if (IsFlag 234)
					(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
					(ClearFlag 234)
					(gInventory deleteItem: (ScriptID 9 41)) ; invBaubles
				else
					(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
					(gInventory deleteItem: (ScriptID 9 41)) ; invBaubles
				)
			)
			(94 ; invDooDads
				(if (IsFlag 234)
					(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
					(ClearFlag 234)
					(gInventory deleteItem: (ScriptID 9 85)) ; invDooDads
				else
					(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
					(gInventory deleteItem: (ScriptID 9 85)) ; invDooDads
				)
			)
			(20 ; invFish
				(gMessager say: 6 20 0 1 0 720) ; "It stinks! Take it away!"
			)
			(21 ; invSparrow
				(gMessager say: 6 21 0 1 0 720) ; "It's beautifully made, but I don't need it."
			)
			(47 ; invBottleNote
				(gMessager say: 1 18 0 1 0 720) ; "This means they are dead! They will never return! I am alone here, with no-one to help me! No pretty stones for(click) Liryl(click) Nothing but tears, nothing but...(click) tears.( Liryl leaves )"
			)
			(else
				(if (OneOf theVerb 73 40 69 68 67 71 66 70) ; invCannon, invIonizer, invPowerSupply, invStock, invVacuumPump, invBarrel, invCrystalBottle, invFiringMechanism
					(gMessager say: 6 22 0 1 0 720) ; "That's part of the device! They called it a particle ionizing vacuum cannon! If you can assemble it, I think you can defeat him."
				else
					(gMessager say: 6 0 0 1 0 720) ; "Liryl: That's interesting. What is it for?"
				)
			)
		)
	)
)

(instance lirylControl782 of Feature
	(properties
		nsLeft 126
		nsTop 232
		nsRight 168
		nsBottom 260
	)

	(method (doVerb theVerb)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: sLirylControl)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sLirylControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (++ global230)
					(1
						(gMessager say: 7 0 1 1 self 720) ; "I use those controls to move about. Please don't hinder me by touching them."
					)
					(2
						(gMessager say: 7 0 8 1 self 720) ; "(scared)Go away!(rattle). Don't touch that!"
					)
					(3
						(gMessager say: 7 0 9 1 self 720) ; "Leave me alone! (pod rattles badly, shaking the girl)D..D..on't touch my controls! (crackle, Liryl turns and exits through pod door. She will not return unless coaxed from her room with shells and baubles.)"
					)
				)
			)
			(1
				(if (== global230 3)
					(SetFlag 234)
					(= local14 1)
					(gCurRoom changeScene: 762)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sLirylLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 0 19 1 self 720) ; "If you won't listen, I'm not going to help you. Go away!( She shuts the pod door, and will not come out unless coaxed.)"
				(= local3 0)
			)
			(1
				(gCurRoom setScript: sLirylLeavePissed)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLirylFarewell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 17 0 39 1 self 720) ; "I know that if the Dark Being is not stopped, it will mean the end for our land. Of that much I am certain. It may mean danger for your land as well! you MUST stop him. There is no-one left who can save us! Farewell!"
			)
			(1
				(= local6 1)
				(gCurRoom changeScene: 765 1)
			)
		)
	)
)

(instance batteryNoise of Sound
	(properties
		number 740
	)
)

(instance sBatteryFlash of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (doit)
		(cond
			((== (gCurRoom scene:) 781)
				(self dispose:)
				(sBatteryFlash781 init:)
			)
			((IsFlag 343)
				(ClearFlag 343)
				(self cue:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(batteryNoise play:)
				(if local0
					(local0 show:)
				)
				(= ticks 15)
			)
			(2
				(if local0
					(local0 hide:)
				)
			)
			(3
				(batteryNoise play:)
				(if local1
					(local1 show:)
				)
				(= ticks 15)
			)
			(4
				(if local1
					(local1 hide:)
				)
			)
			(5
				(batteryNoise play:)
				(if local2
					(local2 show:)
				)
				(= ticks 15)
			)
			(6
				(if local2
					(local2 hide:)
				)
				(self init:)
			)
		)
	)
)

(instance sBatteryFlash781 of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (doit)
		(cond
			((!= (gCurRoom scene:) 781)
				(self dispose:)
				(sBatteryFlash init:)
			)
			((IsFlag 343)
				(ClearFlag 343)
				(self cue:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (gCurRoom scene:) 781)
					(self dispose:)
				)
			)
			(1
				(batteryNoise play:)
				(if local0
					(local0 hide:)
				)
				(= ticks 15)
			)
			(2
				(if local0
					(local0 show:)
				)
			)
			(3
				(batteryNoise play:)
				(if local1
					(local1 hide:)
				)
				(= ticks 15)
			)
			(4
				(if local1
					(local1 show:)
				)
			)
			(5
				(batteryNoise play:)
				(self init:)
			)
		)
	)
)

(instance sSaySomething of Script
	(properties)

	(method (init param1 param2 param3)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
				)
			)
		)
		(= state (- start 1))
		(self cue:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local8 (gCurRoom scene:))
				(gCurRoom changeScene: 782 7)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(switch register
					(1
						(gMessager say: 4 0 1 1 self 720) ; "That room is(whir) private!"
					)
					(2
						(gMessager say: 4 0 8 1 self 720) ; "That door is none(click) of your business!(Liryl move to block door)"
					)
				)
			)
			(2
				(gGame handsOn:)
				(switch local8
					(760
						(= temp0 1)
					)
					(761
						(= temp0 5)
					)
					(762
						(= temp0 7)
					)
					(763
						(= temp0 3)
					)
					(765
						(= temp0 1)
					)
					(767
						(= temp0 5)
					)
					(771
						(= temp0 4)
					)
					(772
						(= temp0 6)
					)
					(773
						(= temp0 5)
					)
					(774
						(= temp0 1)
					)
					(775
						(= temp0 15)
					)
					(776
						(= temp0 4)
					)
					(778
						(= temp0 1)
					)
					(779
						(= temp0 11)
					)
					(780
						(= temp0 1)
					)
					(781
						(= temp0 5)
					)
					(782
						(= temp0 7)
					)
				)
				(gCurRoom changeScene: local8 temp0)
				(self dispose:)
			)
		)
	)
)

