;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 740)
(include sci.sh)
(use Main)
(use LightRoom)
(use LightInv)
(use TrackingProp)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm740 0
)

(local
	local0
	local1
	local2
	local3
	[local4 2] = [1 0]
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13 = 1
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
)

(instance rm740 of LightRoom
	(properties)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(SetFlag 302)
		(roomMusic setVol: 64 play:)
		(gBackMusic number: 705 setVol: 64 play:)
		(switch gPrevRoomNum
			(765
				(= local16 1)
				(self changeScene: -1)
			)
			(780
				(self changeScene: -1)
			)
			(else
				(= local16 1)
				(self changeScene: 752 3)
			)
		)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(botSnd stop:)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(mag744 dispose:)
		(magHoriz744 dispose:)
		(fakeMagHoriz744 dispose:)
		(magVert744 dispose:)
		(Lock rsAUDIO 711 0)
		(Lock rsAUDIO 796 0)
		(lirylFeat745 dispose:)
		(lirylControl745 dispose:)
		(lirylLights745 dispose:)
		(throttle750 dispose:)
		(lirylFeat752 dispose:)
		(lirylProp752 dispose:)
		(door752 dispose:)
		(lever752 dispose:)
		(lirylRoom752 dispose:)
		(switch param1
			(-1
				(if (== gPrevRoomNum 765)
					(gCurRoom setScript: sFromDome)
				else
					(gCurRoom setScript: sFromMachines)
				)
			)
			(744
				(if (IsFlag 369)
					(fakeMagHoriz744 init:)
					(fakeMagHoriz744 cel: (fakeMagHoriz744 lastCel:))
				else
					(Lock rsAUDIO 711 1)
					(Lock rsAUDIO 796 1)
					(magHoriz744 init:)
				)
				(magVert744 init:)
				(mag744 init:)
				(if (IsFlag 369)
					((ScriptID 1 1) newPic: 751 1) ; exitForward
					(mag744 cel: (mag744 lastCel:) x: 339)
					(botSnd play:)
					(proc0_9 172 0 0)
				else
					((ScriptID 1 1) newPic: 746 1) ; exitForward
				)
			)
			(745
				(lirylFeat745 init:)
				(lirylControl745 init:)
				(lirylLights745 init:)
				((ScriptID 1 7) newPic: 752 3 exitCode: cExitCode745) ; exitBackUp
				(if local14
					(= local14 0)
					(lirylFeat745 doVerb: 5)
				)
			)
			(746
				((ScriptID 1 3) newPic: 752 3) ; exitLeft
				((ScriptID 1 4) newPic: 750 7) ; exitRight
				((ScriptID 1 2) newPic: 748 5) ; exitBack
			)
			(748
				((ScriptID 1 3) newPic: 750 7) ; exitLeft
				((ScriptID 1 4) newPic: 752 3) ; exitRight
				(if (IsFlag 369)
					((ScriptID 1 2) newPic: 751 1) ; exitBack
				else
					((ScriptID 1 2) newPic: 746 1) ; exitBack
				)
				((ScriptID 1 1) newPic: 744 9) ; exitForward
			)
			(750
				(if (IsFlag 357)
					(throttle750 init:)
				)
				(if (IsFlag 369)
					((ScriptID 1 3) newPic: 751 1) ; exitLeft
				else
					((ScriptID 1 3) newPic: 746 1) ; exitLeft
				)
				((ScriptID 1 4) newPic: 748 5) ; exitRight
				((ScriptID 1 2) newPic: 752 3) ; exitBack
				((ScriptID 1 1) newRoom: 720) ; exitForward
			)
			(751
				(botSnd play:)
				(proc0_9 751 0 0)
				((ScriptID 1 3) newPic: 752 3) ; exitLeft
				((ScriptID 1 4) newPic: 750 7) ; exitRight
				((ScriptID 1 2) newPic: 748 5) ; exitBack
			)
			(752
				(lever752 init:)
				(cond
					((and (not (IsFlag 256)) (not local0))
						(gGame handsOff:)
						(= global236 740)
						(gCurRoom setScript: sBeginGreeting)
					)
					((and (== global236 740) (IsFlag 286) local16)
						(= local16 0)
						(gGame handsOff:)
						(gCurRoom setScript: sLirylEnter)
					)
					((or (and local0 local19) local17)
						(= local17 0)
						(gGame handsOff:)
						(gCurRoom setScript: sLirylLeavePissed)
					)
					(local18
						(= local18 0)
						(gGame handsOff:)
						(gCurRoom setScript: sLirylMagnetPissed)
					)
					((or local0 (and (== global236 740) local16))
						(= local16 0)
						(= local0 1)
						(lirylFeat752 init:)
						(lirylProp752 init:)
						(lirylRoom752 init:)
					)
				)
				(if (not local0)
					(door752 init:)
				)
				((ScriptID 1 3) newPic: 748 5) ; exitLeft
				(if (IsFlag 369)
					((ScriptID 1 4) newPic: 751 1) ; exitRight
				else
					((ScriptID 1 4) newPic: 746 1) ; exitRight
				)
				((ScriptID 1 2) newPic: 750 7 exitCode: cExitBack752) ; exitBack
			)
		)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber)
		(roomMusic fade: 0 10 7 1 0)
		(if (and (== newRoomNumber 765) (not (IsFlag 295)) (not local21))
			(= local21 1)
			(= global236 765)
			(SetFlag 286)
			(if local0
				(gCurRoom setScript: sLirylExit 0 1)
			else
				(super newRoom: newRoomNumber)
			)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance roomMusic of Sound
	(properties
		number 752
		loop -1
	)
)

(instance roomSfx of Sound
	(properties)
)

(instance botSnd of Sound
	(properties
		number 7271
		flags 4
		loop -1
	)
)

(instance sFromDome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 752)
				(lever752 init:)
				(if (and (== global236 740) (not (IsFlag 286)))
					(= local0 1)
					(lirylProp752 init:)
					(= register 744)
				else
					(= register 755)
				)
				(proc0_8 register)
				(self cue:)
			)
			(1
				(gCurRoom changeScene: 752 3)
				(self dispose:)
			)
		)
	)
)

(instance sFromMachines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 752)
				(lever752 init:)
				(if (and (== global236 740) (not (IsFlag 286)))
					(= local0 1)
					(lirylProp752 init:)
				)
				(proc0_8 753)
				(self cue:)
			)
			(1
				(gBackMusic number: 705 loop: -1 setVol: 64 play:)
				(gCurRoom changeScene: 752 3)
				(self dispose:)
			)
		)
	)
)

(instance mag744 of Prop
	(properties
		x 387
		y 65
		view 756
	)

	(method (init)
		(super init: &rest)
		(= cel 0)
		(= cycleSpeed 3)
	)
)

(instance magSound of Sound
	(properties
		number 712
		loop -1
	)
)

(instance fakeMagHoriz744 of View
	(properties
		x 204
		y 299
		view 741
	)
)

(instance magHoriz744 of TrackingProp
	(properties
		x 204
		y 299
		view 741
		wrap 0
	)

	(method (init)
		(super init: &rest)
		(self
			cel: 5
			setPoints:
				178
				-90
				162
				-90
				150
				-90
				136
				-90
				122
				-90
				110
				-90
				95
				-90
				84
				-90
				70
				-90
				57
				-90
				43
				-90
		)
		(= local11 5)
	)

	(method (doMouseUp)
		(cond
			((== cel 5) 0)
			((OneOf cel 3 4)
				(self setCycle: CT 5 1)
			)
			((OneOf cel 6 7)
				(self setCycle: CT 5 -1)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (and (OneOf cel 2 5 8) (!= cel local11))
			(roomSfx number: 711 play:)
			(= local11 cel)
		)
		(cond
			(
				(and
					(OneOf cel 0 1 2)
					(not (IsFlag 369))
					(not (mag744 cel:))
					(< (= temp0 (mag744 x:)) 435)
				)
				(if (not local12)
					(= local12 1)
					(magSound play:)
				)
				(if
					(or
						(and
							local0
							(IsFlag 199)
							(not (IsFlag 258))
							(not local9)
						)
						(and
							local0
							(not (IsFlag 258))
							(not local9)
							(not (gTheDoits contains: sMagTimer))
						)
					)
					(sMagTimer init:)
				)
				(if local13
					(mag744 x: (++ temp0))
					(= local13 0)
				else
					(= local13 1)
				)
			)
			(
				(and
					(OneOf cel 8 9 10)
					(not (mag744 cel:))
					(not (IsFlag 369))
					(> (= temp0 (mag744 x:)) 339)
				)
				(if (not local12)
					(= local12 1)
					(magSound play:)
				)
				(if
					(or
						(and
							local0
							(IsFlag 199)
							(not (IsFlag 258))
							(not local9)
						)
						(and
							local0
							(not (IsFlag 258))
							(not local9)
							(not (gTheDoits contains: sMagTimer))
						)
					)
					(sMagTimer init:)
				)
				(if local13
					(mag744 x: (-- temp0))
					(= local13 0)
				else
					(= local13 1)
				)
			)
			(else
				(magSound stop:)
				(= local12 0)
			)
		)
	)
)

(instance sMagTimer of Script
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

	(method (doit)
		(if (not (gPanels contains: gControlPanel))
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 1 1) dispose:) ; exitForward
				(if (and local0 (IsFlag 199) (not (IsFlag 258)))
					(= seconds 2)
				else
					(= seconds 5)
				)
			)
			(1
				(gGame handsOff:)
				(if (and local0 (IsFlag 199) (not (IsFlag 258)))
					(gCurRoom setScript: sBirdmanAttack)
					(self dispose:)
				else
					(++ global231)
					(sSaySomething init: 0 0 (+ global231 3))
					(self dispose:)
				)
			)
		)
	)
)

(instance magVert744 of Prop
	(properties
		x 10
		y 299
		view 742
	)

	(method (init)
		(super init: &rest)
		(= cycleSpeed 3)
	)

	(method (doVerb theVerb)
		(if
			(and
				local0
				(not (IsFlag 258))
				(not local9)
				(not (gTheDoits contains: sMagTimer))
			)
			(sMagTimer init:)
		)
		(switch theVerb
			(5 ; Do
				(if (and (not cycler) (not (IsFlag 369)))
					(self setScript: sLowerMag)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sLowerMag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 796 play:)
				(if local9
					(magVert744 cycleSpeed: 0)
					(mag744 cycleSpeed: 0)
				)
				(magVert744 setCycle: End self)
				(mag744 setCycle: End self)
			)
			(1 0)
			(2
				(cond
					((not local9)
						(self cue:)
					)
					((and (< (mag744 x:) 349) (< 130 (Robot 11) 141)) ; FrameNum
						(gGame handsOff:)
						(gCurRoom setScript: sCaughtBirdman)
						(magSound stop:)
						(= local12 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(magVert744 setCycle: Beg self)
				(mag744 setCycle: Beg self)
			)
			(4 0)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sCaughtBirdman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoRobot)
				(proc0_9 172 0 0)
				(proc0_8 171)
				(self cue:)
			)
			(1
				(birdmanMusic fade: 0 10 7 0)
				(gBackMusic play:)
				(roomMusic play:)
				(gInventory disable: 0)
				(= local9 0)
				(SetFlag 258)
				(SetFlag 369)
				(sSaySomething init: 0 0 9)
				(self dispose:)
			)
		)
	)
)

(instance birdmanMusic of Sound
	(properties
		number 760
		flags 4
		loop -1
	)
)

(instance sBirdmanAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 256)
				(gBackMusic stop:)
				(roomMusic stop:)
				(birdmanMusic setVol: 0 play:)
				(birdmanMusic fade: 127 60 10 0)
				(gCurRoom drawPic: -1)
				(gCast eachElementDo: #hide)
				(cTossPanels doit:)
				(gInventory disable: 1)
				(= cycles 2)
			)
			(1
				(if
					(and
						(IsFlag 257)
						(not (IsFlag 357))
						(not (gInventory contains: (ScriptID 9 32))) ; invThrottle
					)
					(SetFlag 357)
					(proc0_8 5160)
				else
					(proc0_8 5161)
				)
				(self cue:)
			)
			(2
				(gCurRoom drawPic: 744)
				(gCast eachElementDo: #show)
				(KillRobot 4173 0 6 0 6)
				(gGame handsOn:)
				(= local9 1)
			)
			(3
				(magSound stop:)
				(= local12 0)
				(if (gPanels contains: (ScriptID 9 2)) ; PlBagPlane
					((ScriptID 9 2) dispose:) ; PlBagPlane
					((ScriptID 9 1) init:) ; PlInterface
				)
				(gGame handsOff:)
				(= local9 0)
				(SetFlag 258)
				(ClearFlag 369)
				(proc0_8 4164)
				(birdmanMusic fade: 0 10 7 0)
				(gBackMusic play:)
				(roomMusic play:)
				(= local15 1)
				(= local17 1)
				(gCurRoom changeScene: 752)
				(gInventory disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance cTossPanels of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(if (gPanels contains: InvInset)
			(InvInset dispose:)
		)
		(for ((= temp0 0)) (< temp0 (gPanels size:)) ((++ temp0))
			(if ((= temp1 (gPanels at: temp0)) isKindOf: FullInsetPanelPlane)
				(temp1 dispose:)
			)
		)
	)
)

(instance lirylLights745 of Prop
	(properties
		x 238
		y 174
		loop 1
		view 174
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 14 setCycle: Fwd)
	)
)

(instance lirylFeat745 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 191 134 208 135 212 158 208 174 224 175 228 252 214 271 174 273 160 245 171 242 169 203 140 203 161 175 173 173 172 141
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(switch theVerb
			(5 ; Do
				(cond
					((not (IsFlag 256))
						(SetFlag 256)
						(gMessager say: 1 0 1 1 0 720) ; "I am(rattle) Liryl, Guardian and(whir) Sacred Ward of the T...T..Temple. You are a stranger here!(agitated) Who are(rattle) you?(valves popping) Are you a(electrical snap) priest? Are you a(snap) friend? Did you bring me(pop) shells and pebblesssss?(the 's' in pebbles turns into a hiss) What(pop) is it that you want?"
					)
					((IsFlag 234)
						(switch (++ local2)
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
					)
					(local1
						(= local1 0)
						(= local3 0)
						(gMessager say: 1 0 3 1 0 720) ; "(Brief pause, then sadly)I see you have not.(disappointed) No new(pop) shells for little(whir as of tape rewinding) little Liryl(whir). I fear (whir)something bad has happened."
					)
					(local3
						(= local3 0)
						(cond
							((not (IsFlag 258))
								(cond
									((not (IsFlag 235))
										(gMessager say: 1 0 2 1 0 720) ; "I am(click) alone here. It has been a long(skip)...long(skip)... time since anyone has come. Tell me, have you seen the(rattle) temple priests?"
										(SetFlag 235)
										(= local1 1)
									)
									((not (IsFlag 236))
										(gMessager say: 1 0 5 1 0 720) ; "(She brightens slightly) Let me tell you about the priests, and perhaps you can watch for them on your journey.( expresses grief ) They set out in(pop) the Ironclad ship... They should have returned by now."
										(SetFlag 236)
									)
									((not (IsFlag 237))
										(gMessager say: 1 0 7 1 0 720) ; "In six separate pieces a weapon they built(pop), and five of those(click) pieces they hid.(rattle) The priests and the sixth(pop) set out in the Ironclad ship,(bzzzz)...collecting the pieces(click) to assemble the whole.(Liryl starts to lose it again) This scattered device is the last chance we have(pop), but what of the priests at sea?(click) I know no more.(click) There is no more to tell.(click)(mournfully) No more pebbles,(click) no more shellsssss(hiss)."
										(SetFlag 237)
									)
								)
							)
							((not (IsFlag 238))
								(gMessager say: 14 0 25 1 0 720) ; "The priests thought he came from our past, or maybe from another world. He lives in the ancient volcano. Not long ago the priests noticed black smoke in the sky. They believed it was an eruption, but when they looked they discovered a strange being, a tattooed devil, altering the volcano to suit some plan of his own. He has built a factory there, in tunnels beneath the mountain."
								(SetFlag 238)
							)
							((not (IsFlag 239))
								(gMessager say: 14 0 26 1 0 720) ; "They kept him under close watch. They saw the effects of his work: smoke darkened the skies, sludge and poisonous chemicals contaminated the sea. The Dark Being, as he came to be called, thus revealed his wicked nature."
								(SetFlag 239)
							)
							((not (IsFlag 240))
								(gMessager say: 14 0 26 2 0 720) ; "The priests knew something must be done, before the Dark Being corrupted the land. From the safety of his stronghold he plotted. He drove the people away from their homes, and released a monster to guard should they try to return. The priests pored through the ancient texts, uncovering long buried secrets of the old Technology."
								(SetFlag 240)
							)
							((not (IsFlag 241))
								(gMessager say: 14 0 26 3 0 720) ; "Using this knowledge, they created a device to contain him. As they finished each part of the device, they sent it away for safekeeping. When they completed the sixth and final piece, they set off in the Ironclad ship to collect the other five and assemble them. That was the last I saw of them."
								(SetFlag 241)
							)
						)
					)
					((and (IsFlag 258) (not (IsFlag 242)))
						(gGame handsOff:)
						(gCurRoom setScript: sAllowElevator)
					)
					((not (IsFlag 258))
						(if
							(and
								(== (= temp0 (Random 1 7)) 1)
								(IsFlag 235)
								(IsFlag 236)
								(IsFlag 237)
							)
							(= temp0 (Random 2 7))
						)
						(switch temp0
							(1
								(cond
									((not (IsFlag 235))
										(gMessager say: 1 0 2 1 0 720) ; "I am(click) alone here. It has been a long(skip)...long(skip)... time since anyone has come. Tell me, have you seen the(rattle) temple priests?"
										(= local1 1)
										(SetFlag 235)
									)
									((not (IsFlag 236))
										(gMessager say: 1 0 5 1 0 720) ; "(She brightens slightly) Let me tell you about the priests, and perhaps you can watch for them on your journey.( expresses grief ) They set out in(pop) the Ironclad ship... They should have returned by now."
										(SetFlag 236)
									)
									((not (IsFlag 237))
										(gMessager say: 1 0 7 1 0 720) ; "In six separate pieces a weapon they built(pop), and five of those(click) pieces they hid.(rattle) The priests and the sixth(pop) set out in the Ironclad ship,(bzzzz)...collecting the pieces(click) to assemble the whole.(Liryl starts to lose it again) This scattered device is the last chance we have(pop), but what of the priests at sea?(click) I know no more.(click) There is no more to tell.(click)(mournfully) No more pebbles,(click) no more shellsssss(hiss)."
										(SetFlag 237)
									)
								)
							)
							(else
								(gMessager say: 7 0 16 (- temp0 1) 0 720)
							)
						)
					)
					(else
						(gMessager say: 7 0 16 (Random 1 6) 0 720)
					)
				)
			)
			(60 ; invCD
				(if local1
					(= local1 0)
					(gMessager say: 1 0 3 1 0 720) ; "(Brief pause, then sadly)I see you have not.(disappointed) No new(pop) shells for little(whir as of tape rewinding) little Liryl(whir). I fear (whir)something bad has happened."
				else
					(gMessager say: 9 0 20 1 0 720) ; "You are not of this land. To understand what has happened here, you must first learn our history."
				)
			)
			(96 ; invBeingInBottle
				(if local1
					(= local1 0)
					(gMessager say: 1 0 3 1 0 720) ; "(Brief pause, then sadly)I see you have not.(disappointed) No new(pop) shells for little(whir as of tape rewinding) little Liryl(whir). I fear (whir)something bad has happened."
				else
					(gMessager say: 8 96 0 1 0 720) ; "Thank for saving our land. I could not have stopped him by myself."
				)
			)
			(47 ; invBottleNote
				(if local1
					(= local1 0)
					(gMessager say: 1 18 0 1 0 720) ; "This means they are dead! They will never return! I am alone here, with no-one to help me! No pretty stones for(click) Liryl(click) Nothing but tears, nothing but...(click) tears.( Liryl leaves )"
				else
					(gMessager say: 1 18 0 1 0 720) ; "This means they are dead! They will never return! I am alone here, with no-one to help me! No pretty stones for(click) Liryl(click) Nothing but tears, nothing but...(click) tears.( Liryl leaves )"
				)
			)
			(19 ; invShell
				(cond
					(local1
						(= local1 0)
						(gMessager say: 1 0 3 1 0 720) ; "(Brief pause, then sadly)I see you have not.(disappointed) No new(pop) shells for little(whir as of tape rewinding) little Liryl(whir). I fear (whir)something bad has happened."
					)
					((IsFlag 234)
						(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
						(ClearFlag 234)
						(gInventory deleteItem: (ScriptID 9 88)) ; invShell
					)
					(else
						(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
						(gInventory deleteItem: (ScriptID 9 88)) ; invShell
					)
				)
			)
			(51 ; invBaubles
				(cond
					(local1
						(= local1 0)
						(gMessager say: 1 0 3 1 0 720) ; "(Brief pause, then sadly)I see you have not.(disappointed) No new(pop) shells for little(whir as of tape rewinding) little Liryl(whir). I fear (whir)something bad has happened."
					)
					((IsFlag 234)
						(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
						(ClearFlag 234)
						(gInventory deleteItem: (ScriptID 9 41)) ; invBaubles
					)
					(else
						(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
						(gInventory deleteItem: (ScriptID 9 41)) ; invBaubles
					)
				)
			)
			(94 ; invDooDads
				(cond
					(local1
						(= local1 0)
						(gMessager say: 1 0 3 1 0 720) ; "(Brief pause, then sadly)I see you have not.(disappointed) No new(pop) shells for little(whir as of tape rewinding) little Liryl(whir). I fear (whir)something bad has happened."
					)
					((IsFlag 234)
						(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
						(ClearFlag 234)
						(gInventory deleteItem: (ScriptID 9 85)) ; invDooDads
					)
					(else
						(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
						(gInventory deleteItem: (ScriptID 9 85)) ; invDooDads
					)
				)
			)
			(20 ; invFish
				(if local1
					(= local1 0)
					(gMessager say: 1 0 3 1 0 720) ; "(Brief pause, then sadly)I see you have not.(disappointed) No new(pop) shells for little(whir as of tape rewinding) little Liryl(whir). I fear (whir)something bad has happened."
				else
					(gMessager say: 6 20 0 1 0 720) ; "It stinks! Take it away!"
				)
			)
			(21 ; invSparrow
				(if local1
					(= local1 0)
					(gMessager say: 1 0 3 1 0 720) ; "(Brief pause, then sadly)I see you have not.(disappointed) No new(pop) shells for little(whir as of tape rewinding) little Liryl(whir). I fear (whir)something bad has happened."
				else
					(gMessager say: 6 21 0 1 0 720) ; "It's beautifully made, but I don't need it."
				)
			)
			(else
				(cond
					(local1
						(= local1 0)
						(gMessager say: 1 0 3 1 0 720) ; "(Brief pause, then sadly)I see you have not.(disappointed) No new(pop) shells for little(whir as of tape rewinding) little Liryl(whir). I fear (whir)something bad has happened."
					)
					((OneOf theVerb 73 40 69 68 67 71 66 70) ; invCannon, invIonizer, invPowerSupply, invStock, invVacuumPump, invBarrel, invCrystalBottle, invFiringMechanism
						(gMessager say: 6 22 0 1 0 720) ; "That's part of the device! They called it a particle ionizing vacuum cannon! If you can assemble it, I think you can defeat him."
					)
					(else
						(gMessager say: 6 0 0 1 0 720) ; "Liryl: That's interesting. What is it for?"
					)
				)
			)
		)
	)
)

(instance sAllowElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 242)
				(SetFlag 303)
				(gMessager say: 16 0 30 1 self 720) ; "I trust you(pop) now. You may ascend(click) or descend."
			)
			(1
				(gMessager say: 16 0 28 1 self 720) ; "Perhaps the dome contains some of the answers you seek."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cExitCode745 of Code
	(properties)

	(method (doit)
		(cond
			((IsFlag 234)
				(= local1 0)
				(gCurRoom changeScene: 752 3)
			)
			(local3
				(= local1 0)
				(= local3 0)
				(gCurRoom changeScene: 752 3)
			)
			(
				(and
					(not (IsFlag 258))
					(or
						(not (IsFlag 235))
						(not (IsFlag 236))
						(not (IsFlag 237))
					)
				)
				(if (not (gTalkers isEmpty:))
					(gTalkers eachElementDo: #dispose)
				)
				(= local1 0)
				(= local3 1)
				(if (Random 0 1)
					(gMessager say: 1 0 4 1 0 720) ; "Wait!(bzzzzz) There is more I could tell!"
				else
					(gMessager say: 1 0 6 1 0 720) ; "Wait!(bzzzzz) I know more!"
				)
			)
			(
				(and
					(IsFlag 258)
					(or
						(not (IsFlag 238))
						(not (IsFlag 239))
						(not (IsFlag 240))
						(not (IsFlag 241))
					)
				)
				(if (not (gTalkers isEmpty:))
					(gTalkers eachElementDo: #dispose)
				)
				(= local1 0)
				(= local3 1)
				(gMessager say: 15 0 25 1 0 720) ; "Wait! You should know more!"
			)
			(else
				(= local1 0)
				(gCurRoom changeScene: 752 3)
			)
		)
	)
)

(instance lirylControl745 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 135 208 167 208 167 241 135 241)
	)

	(method (doVerb theVerb)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(= local1 0)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
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
					(= global230 0)
					(SetFlag 234)
					(= local19 1)
					(gCurRoom changeScene: 752)
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
			)
			(1
				(self dispose:)
				(= local19 1)
				(gCurRoom changeScene: 752)
			)
		)
	)
)

(instance throttle750 of View
	(properties
		x 34
		y 217
		view 750
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gInventory addItem: (ScriptID 9 32)) ; invThrottle
				(ClearFlag 357)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cExitBack752 of Code
	(properties)

	(method (doit &tmp temp0)
		(cond
			((< (= temp0 (Random 1 8)) 4)
				(= global236 740)
				(if (not local0)
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
				(if (!= global236 765)
					(SetFlag 286)
				)
				(= global236 765)
			)
		)
		(if (or (not local0) (== global236 740))
			(gCurRoom changeScene: 750 7)
		else
			(gGame handsOff:)
			(gCurRoom setScript: sLirylExit 0 0)
		)
	)
)

(instance lirylRoom752 of Feature
	(properties
		nsBottom 160
		nsLeft 222
		nsRight 271
		nsTop 86
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(++ local8)
				(sSaySomething init: 0 0 (+ local8 6))
				(if (>= local8 2)
					(= local8 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door752 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 218 86 277 86 291 95 298 109 303 122 305 142 301 155 292 172 266 175 224 175 213 173 196 170 189 153 188 128 195 105
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(roomSfx number: 776 play:)
				(if
					(and
						(not local0)
						(not (IsFlag 234))
						(not local15)
						(== (Random 1 6) 1)
					)
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

(instance lirylFeat752 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 408 109 418 109 427 120 442 123 445 143 438 164 421 180 396 178 369 160 371 141 389 118
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(= local14 1)
				(gCurRoom changeScene: 745 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lirylProp752 of Prop
	(properties
		x 98
		y 195
		view 752
	)
)

(instance leverSound of Sound
	(properties
		number 789
	)
)

(instance lever752 of TrackingProp
	(properties
		x 248
		y 245
		view 757
		wrap 0
	)

	(method (init)
		(super init: &rest)
		(self
			cel: 6
			setPoints:
				0
				-88
				0
				-86
				0
				-84
				0
				-82
				0
				-79
				0
				-77
				0
				-74
				0
				-70
				0
				-62
				0
				-51
				0
				-38
				0
				-28
				0
				-23
		)
		(= local10 6)
	)

	(method (doit)
		(super doit: &rest)
		(if (!= cel local10)
			(leverSound play:)
		)
		(= local10 cel)
	)

	(method (doMouseUp)
		(cond
			((== cel 6) 0)
			((OneOf cel 3 4 5)
				(self setCycle: CT 6 1)
			)
			((OneOf cel 7 8 9)
				(self setCycle: CT 6 -1)
			)
			((OneOf cel 0 1 2)
				(cond
					((not (IsFlag 258))
						(if local0
							(++ local7)
							(sSaySomething init: 0 0 local7)
							(if (>= local7 3)
								(= local7 0)
							)
						else
							(self setCycle: CT 6 1)
						)
					)
					((not local0)
						(if (IsFlag 242)
							(gGame handsOff:)
							(gCurRoom newRoom: 765)
						else
							(self setCycle: CT 6 1)
						)
					)
					((not (IsFlag 302))
						(SetFlag 302)
						(sSaySomething init: 0 0 11)
						(self setCycle: CT 6 1)
					)
					((not (IsFlag 242))
						(self setCycle: CT 6 1)
					)
					((not (IsFlag 244))
						(SetFlag 244)
						(= local20 765)
						(sSaySomething init: 0 0 15)
					)
					(else
						(gGame handsOff:)
						(gCurRoom newRoom: 765)
					)
				)
			)
			((not (IsFlag 258))
				(if local0
					(++ local7)
					(sSaySomething init: 0 0 local7)
					(if (>= local7 3)
						(= local7 0)
					)
				else
					(self setCycle: CT 6 -1)
				)
			)
			((not local0)
				(if (IsFlag 242)
					(gGame handsOff:)
					(gBackMusic stop:)
					(gCurRoom newRoom: 780)
				else
					(self setCycle: CT 6 -1)
				)
			)
			((not (IsFlag 302))
				(SetFlag 302)
				(sSaySomething init: 0 0 11)
				(self setCycle: CT 6 -1)
			)
			((not (IsFlag 242))
				(self setCycle: CT 6 -1)
			)
			((not (IsFlag 243))
				(SetFlag 243)
				(= local20 780)
				(sSaySomething init: 0 0 14)
			)
			(else
				(gGame handsOff:)
				(gBackMusic stop:)
				(gCurRoom newRoom: 780)
			)
		)
	)
)

(instance sLirylEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KillRobot 752 0 0)
			)
			(1
				(= local0 1)
				(= global236 740)
				(ClearFlag 286)
				(lirylFeat752 init:)
				(lirylProp752 init:)
				(lirylRoom752 init:)
				(door752 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLirylExit of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCurRoom changeScene: 752)
				(= cycles 2)
			)
			(1
				(lirylProp752 dispose:)
				(KillRobot 7520 0 0)
			)
			(2
				(= local0 0)
				(if (not register)
					(self dispose:)
					(gGame handsOn:)
					(gCurRoom changeScene: 750 7)
				else
					(self dispose:)
					(gCurRoom newRoom: 765)
				)
			)
		)
	)
)

(instance sLirylLeavePissed of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local0 0)
				(= global236 0)
				(KillRobot 7520 0 0)
			)
			(1
				(door752 init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLirylMagnetPissed of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local0 0)
				(= global236 0)
				(KillRobot 7520 0 0)
			)
			(1
				(self dispose:)
				(gCurRoom changeScene: 744 9)
			)
		)
	)
)

(instance sBeginGreeting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KillRobot 752 0 0 0 -1 1)
			)
			(1
				(self dispose:)
				(gGame handsOn:)
				(= local16 0)
				(= local0 1)
				(lirylFeat752 init:)
				(lirylProp752 init:)
				(lirylRoom752 init:)
				(door752 dispose:)
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
				(= local6 (gCurRoom scene:))
				(gCurRoom changeScene: 745 2)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(switch register
					(1
						(gMessager say: 5 0 10 1 self 720) ; "(suddenly wary)I do not know(click) you! None but the(rattle) trusted may ascend or descend."
					)
					(2
						(gMessager say: 5 0 11 1 self 720) ; "It is my duty to protect the Temple against intruders. I am sorry...(Whir) You cannot enter the inner chambers."
					)
					(3
						(gMessager say: 5 0 12 1 self 720) ; "The machines we protect belong to an ancient time. I cannot let you see them."
					)
					(4
						(gMessager say: 2 0 1 1 self 720) ; "(agitated)(pod rattles)Don't touch the machines!(rattle)"
					)
					(5
						(gMessager say: 2 0 8 1 self 720) ; "Stop! Those controls operate the electromagnet. Please do not touch them!"
					)
					(6
						(gMessager say: 2 0 9 1 self 720) ; "Why do you(bzzz) do that when I already asked(bzzz) you not to?(Liryl leaves again.)"
					)
					(7
						(gMessager say: 4 0 1 1 self 720) ; "That room is(whir) private!"
					)
					(8
						(gMessager say: 4 0 8 1 self 720) ; "That door is none(click) of your business!(Liryl move to block door)"
					)
					(9
						(gMessager say: 13 0 25 1 self 720) ; "He has changed. When Martin built him, he was good! I will keep him here, so he won't hurt anyone else. Maybe in time I can repair him. Perhaps he can be a companion for me. Thank you for saving me! I could not have stopped him by myself."
					)
					(10
						(gMessager say: 13 0 25 2 self 720) ; "You have helped me and so I will help you. There is an evil in the land that threatens to undo all that the Temple have accomplished. I trust you now. Maybe you can save us!"
					)
					(11
						(gMessager say: 5 0 29 1 self 720) ; "This Temple is a storehouse for what little remains of the old technology, a sacred place in which to carefully study the remnants of a dead age. It is hoped that with wisdom and caution, some of the ancient ways might be incorporated into the technology of today. The priests scoured the land and brought the old machines here."
					)
					(12
						(gMessager say: 16 0 28 1 self 720) ; "Perhaps the dome contains some of the answers you seek."
					)
					(13
						(gMessager say: 16 0 30 1 self 720) ; "I trust you(pop) now. You may ascend(click) or descend."
					)
					(14
						(gMessager say: 5 0 31 1 self 720) ; "Descend to the(click) Room of the Ancient Machines."
					)
					(15
						(gMessager say: 5 0 32 1 self 720) ; "Ascend to the(click) Dome.( Note that after the player uses the lift for the first time [either to go up or down], Liryl need not be present on subsequent times, nor does she deliver the lines that accompany the lift's operation.)"
					)
				)
			)
			(2
				(cond
					((== register 6)
						(= global231 0)
						(= local18 1)
						(gCurRoom changeScene: 752)
					)
					((== register 9)
						(botSnd play:)
						(gCurRoom changeScene: 744 9)
					)
					((== register 14)
						(gBackMusic stop:)
						(gCurRoom newRoom: 780)
					)
					((== register 15)
						(gCurRoom newRoom: 765)
					)
					(else
						(gGame handsOn:)
						(switch local6
							(752
								(= temp0 3)
							)
							(751
								(= temp0 1)
							)
							(746
								(= temp0 1)
							)
							(750
								(= temp0 7)
							)
							(748
								(= temp0 5)
							)
							(744
								(= temp0 9)
							)
							(745
								(= temp0 2)
							)
						)
						(gCurRoom changeScene: local6 temp0)
					)
				)
				(self dispose:)
			)
		)
	)
)

