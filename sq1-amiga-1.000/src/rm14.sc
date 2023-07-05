;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Interface)
(use Osc)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm14 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 45] = [0 0 0 1 290 79 2 280 84 3 270 87 4 262 93 5 254 98 6 246 99 7 236 104 8 224 112 9 215 116 10 206 122 11 197 128 12 188 134 14 181 138 -1 -1 -1]
	[local50 24] = [0 0 0 3 218 106 1 211 112 5 199 115 6 186 115 2 175 120 1 165 127 -1 -1 -1]
	local74 = 180
	local75
	local76
)

(procedure (localproc_0)
	(gLongSong2 number: 317 loop: 1 play:)
)

(procedure (localproc_1)
	(if (gCast contains: padInset)
		(AutoNavButton dispose:)
		(DontPressButton dispose:)
		(PowerButton dispose:)
		(padInset dispose:)
	)
	(Animate (gCast elements:) 0)
)

(instance rm14 of Rm
	(properties
		picture 13
	)

	(method (init)
		(LoadMany rsPIC 16 17 38 37 313 213)
		(LoadMany rsVIEW 138 113 137 238 117 169)
		(LoadMany rsSOUND 326 334 336 335 332 405 400 402 401 807 808 328 325 337)
		(super init:)
		(gFeatures
			add:
				joystick
				egoSuit
				seatBeltFeat
				PodWindow
				Chair
				ControlPanel
				Dials
				ButtonPad
			eachElementDo: #init
		)
		(survivalKit init: stopUpd:)
		(= local0 1)
		(cockpitSound number: 326 loop: -1 flags: 1 init: play:)
		(gLongSong number: 367 loop: -1 play:)
		(ledLights init: setCycle: Fwd)
		(screen init: setCycle: Fwd)
		(gLongSong2 pause: 0)
		(head init: stopUpd:)
		(arm init: stopUpd:)
		(seatbelt1 init: stopUpd:)
		(seatbelt2 init: stopUpd:)
		(HandsOn)
	)

	(method (doit)
		(super doit:)
		(if (and (not script) (!= local75 (= local76 (GetTime 1)))) ; SysTime12
			(= local75 local76)
			(switch (-- local74)
				(-30
					(Print 14 0) ; "Gee, all of a sudden the engines have grown quiet. Boy, you sure were zooming along for quite some time."
				)
				(-60
					(Print 14 1) ; "Of course, the zooming part is over now since you've run out of fuel. You'll just float along on inertia with no control of your attitude or destination."
				)
				(-90
					(Print 14 2) ; "Yep, you're still drifting hopelessly through space. Bummer, eh?"
				)
				(-120
					(Print 14 3) ; "Hunger grows to a level where your body decides to start feasting on itself. In your last conscious thoughts it dawns on you that navigation of some sort might have been a big helper here."
					(self setScript: outOfGas)
				)
			)
		)
	)

	(method (drawPic param1)
		(if (== param1 13)
			(gCast eachElementDo: #show)
		else
			(gCast eachElementDo: #hide)
		)
		(super drawPic: param1 &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				(or (== (event message:) JOY_UP) (& (event type:) $0040)) ; direction
			)
			(if (and local1 (gCast contains: seatbelt2))
				(Print 14 4) ; "Remove your seatbelt first. It works better."
			else
				(Print 14 5) ; "Please stay seated until the space pod has come to a complete stop. Thank you for your cooperation."
			)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		(cockpitSound loop: 0 fade:)
		(gSoundEffects loop: 0 stop:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(2 ; Look
				(if local1
					(Print 14 6) ; "The pod has gone through some changes. All systems seem to have died and the windshield is now embossed with a lovely mosaic pattern."
				else
					(Print 14 7) ; "The inside of the Arcada's escape pods is not exactly packed with luxurious appointments. However, when it comes to saving one's posterior, it's as good as a Rolls."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 flags: 0)
		(super newRoom: newRoomNumber)
	)
)

(instance outOfGas of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 99 10)
				(gCast eachElementDo: #dispose)
				(= cycles 1)
			)
			(2
				(EgoDead 948 0 0 14 8) ; "The pain fades away along with any sense of belonging to the community of the living. Your powerless pod drifts through space for eons, eventually being plowed by some primitive deep space probe. Knowing that your insurance deductible was much too high anyway, you gain a new appreciation for death."
			)
		)
	)
)

(instance buttonInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gCast contains: padInset))
					(gFeatures addToFront: AutoNavButton)
					(gFeatures addToFront: DontPressButton)
					(gFeatures addToFront: PowerButton)
					(padInset init:)
				else
					(Print 14 9) ; "Please press the desired button."
				)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance showKerona of Script
	(properties)

	(method (doit)
		(if local2
			(Palette palANIMATE 208 254 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cockpitSound setVol: 50)
				(gSoundEffects number: 334 loop: -1 play: hold: 1)
				(tempProp init: posn: 90 36 setCycle: CT 2 1 self)
			)
			(1
				(tempProp setCycle: End tempProp)
				(hologram init: cycleSpeed: 8 setCycle: End self)
			)
			(2
				(gLongSong number: 336 loop: -1 play:)
				(= cycles 3)
			)
			(3
				(= local2 1)
				(hologram loop: 8 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				(= seconds 10)
			)
			(4
				(= local2 0)
				(hologram loop: 7 cel: 5 cycleSpeed: 8 setCycle: Beg self)
			)
			(5
				(gLongSong stop: loop: 0)
				(gSoundEffects number: 335 loop: 1 play:)
				(tempProp show: setCycle: Beg self)
			)
			(6
				(gSoundEffects stop:)
				(UnLoad 132 335)
				(UnLoad 132 334)
				(UnLoad 132 336)
				(tempProp dispose:)
				(hologram dispose:)
				(= cycles 25)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance doHyperspace of Script
	(properties)

	(method (doit)
		(Palette palANIMATE 208 254 -1)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom overlay: 213 7)
				(= seconds register)
			)
			(1
				(= register 0)
				(self dispose:)
			)
		)
	)
)

(instance autoNavScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== (gLongSong prevSignal:) 10))
			(gLongSong prevSignal: 0)
			(= cycles 3)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSounds eachElementDo: #stop)
				(self setScript: showKerona self)
			)
			(1
				(cockpitSound number: 326 loop: 0 stop:)
				(gLongSong number: 332 loop: 1 play:)
			)
			(2
				(self setScript: doHyperspace self 10)
			)
			(3
				(gCurRoom drawPic: 17 10)
				(escapePod
					init:
					view: 116
					loop: 2
					posn: 320 -10
					setStep: 3 2
					cel: 0
					cycleSpeed: 5
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo -90 151 self
				)
				(survivalKit dispose:)
			)
			(4
				(gCurRoom setScript: watchPodLand)
			)
		)
	)
)

(instance watchPodLand of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 5) (== (gLongSong prevSignal:) 10))
			(gLongSong prevSignal: 0)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 400 402 405)
				(gCurRoom drawPic: 16 -32759)
				(kerona init: stopUpd: setPri: 0 ignoreActors: 1 addToPic:)
				(escapePod
					show:
					posn: 331 106
					setCycle: Fwd
					setMotion: MoveTo 222 151 self
				)
			)
			(1
				(escapePod
					setLoop: 5
					cel: 0
					setMotion: MoveTo 201 159
					setCycle: End self
				)
			)
			(2
				(escapePod
					setLoop: 6
					cel: 0
					setCycle: End self
					setMotion: MoveTo 135 168
				)
			)
			(3
				(escapePod hide:)
				(= cycles 2)
			)
			(4
				(gLongSong fade:)
				(gCurRoom drawPic: 38 10)
				(kerona dispose:)
				(tempProp dispose:)
				(gAddToPics
					add: back1 back2 back3 back4 back5
					eachElementDo: #setPri 0
					eachElementDo: #init
					doit:
				)
				(= cycles 13)
			)
			(5
				(gLongSong number: 400 loop: 1 play: 127)
				(= seconds 20)
			)
			(6
				(= seconds 0)
				(gLongSong2 number: 402 loop: 1 play:)
				(escapePod
					show:
					view: 138
					posn: 329 36
					illegalBits: 0
					setStep: 10 6
					setLoop: 0
					setCel: 0
					moveSpeed: 1
					setMotion: MoveTo 299 70 self
				)
				(= register (+ 1 (* gHowFast 2)))
			)
			(7
				(if (!= [local5 (+= local4 3)] -1)
					(-- state)
					(if (== local4 3)
						(gLongSong stop:)
					)
					(if
						(or
							(== [local5 local4] 4)
							(== [local5 local4] 9)
							(== [local5 local4] 12)
						)
						(gLongSong2 number: 405 loop: 1 play:)
						(gLongSong stop:)
					)
					(escapePod
						setCel: [local5 local4]
						x: [local5 (+ local4 1)]
						y: [local5 (+ local4 2)]
					)
				)
				(= cycles register)
			)
			(8
				(gCurRoom setScript: crashedPod)
			)
		)
	)
)

(instance crashedPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 44)
			)
			(1
				(gCurRoom drawPic: 37 10)
				(gLongSong number: 401 loop: -1 play:)
				(gLongSong2 number: 807 loop: -1 play:)
				(back1 dispose:)
				(back2 dispose:)
				(back3 dispose:)
				(back4 dispose:)
				(back5 dispose:)
				(escapePod dispose:)
				(glass init:)
				(smoke init: setCycle: Fwd)
				(door init:)
				(= cycles 12)
			)
			(2
				(gSoundEffects number: 808 loop: 1 play:)
				(glass setCycle: Osc 1 self)
			)
			(3
				(= seconds 3)
			)
			(4
				(gLongSong setVol: 70)
				(gLongSong2 fade:)
				(gCurRoom drawPic: 13 10)
				(gCurRoom overlay: 313 100)
				(smoke dispose:)
				(door dispose:)
				(glass dispose:)
				(Print 14 10) ; "Thank you for flying Arcada Getaway Podlines! It's nearly been a pleasure serving you. Tell a friend (if you've got one)."
				(screen setCycle: 0)
				(ledLights setCycle: 0)
				(= local1 1)
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance pushButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(BUTTON init:)
				(= cycles 20)
			)
			(1
				(AutoNavButton dispose:)
				(DontPressButton dispose:)
				(PowerButton dispose:)
				(padInset dispose:)
				(BUTTON dispose:)
				(head cel: 1 forceUpd:)
				(= cycles 1)
			)
			(2
				(arm loop: 1 setCycle: CT 1 1 self)
			)
			(3
				(arm loop: 2 cel: register)
				(= cycles 12)
			)
			(4
				(if (not local1)
					(switch register
						(1
							(cond
								(local1
									(Print 14 11) ; "This has been rendered inoperable due to the shock of that less-than-graceful landing."
								)
								((not local0)
									(Print 14 12) ; "This option works better with the power on."
								)
								((<= local74 0)
									(Print 14 13) ; "The fuel supply has expired."
								)
								((not local1)
									(gLongSong stop:)
									(self next: pressedWrongButton)
								)
							)
						)
						(2
							(if (not local0)
								(= local0 1)
								(ledLights show:)
								(screen show:)
								(gLongSong2 pause: 0)
								(cockpitSound number: 326 loop: -1 play:)
							else
								(cockpitSound number: 326 loop: 0 stop:)
								(= local0 0)
								(gLongSong2 pause:)
								(ledLights hide:)
								(screen hide:)
							)
						)
						(else
							(cond
								((not local0)
									(Print 14 12) ; "This option works better with the power on."
								)
								((<= local74 0)
									(Print 14 13) ; "The fuel supply has expired."
								)
								(else
									(SetScore 2 139)
									(gLongSong fade:)
									(self next: autoNavScript)
								)
							)
						)
					)
				else
					(Print 14 14) ; "This button just doesn't work the same since the accident."
				)
				(= register 0)
				(= cycles 3)
			)
			(5
				(arm loop: 1 cel: 1 setCycle: Beg self)
			)
			(6
				(head cel: 0 forceUpd:)
				(arm loop: 1 cel: 0 stopUpd:)
				(HandsOn)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance pressedWrongButton of Script
	(properties)

	(method (init)
		(UnLoad 132 326)
		(UnLoad 132 334)
		(UnLoad 132 336)
		(UnLoad 132 335)
		(UnLoad 132 332)
		(UnLoad 132 405)
		(UnLoad 132 401)
		(UnLoad 132 807)
		(UnLoad 132 808)
		(UnLoad 132 328)
		(UnLoad 132 325)
		(UnLoad 132 337)
		(UnLoad 129 16)
		(UnLoad 129 17)
		(UnLoad 129 38)
		(UnLoad 129 37)
		(UnLoad 129 313)
		(UnLoad 129 213)
		(UnLoad 128 138)
		(UnLoad 128 113)
		(UnLoad 128 137)
		(UnLoad 128 238)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doit)
		(if local3
			(Palette palANIMATE 48 70 1)
		)
		(super doit:)
		(if (and (== state 1) (== (gLongSong prevSignal:) 10))
			(gLongSong prevSignal: 0)
			(= cycles 1)
		)
		(if (and (== state 6) (== (gLongSong prevSignal:) 10))
			(gLongSong prevSignal: 0)
			(= cycles 1)
		)
	)

	(method (handleEvent event)
		(if (and register (event type:))
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(= register 0)
			(event claimed: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 14 15 #at 33 139 #dispose self) ; "You have a feeling you shouldn't have pressed that button."
				(LoadMany rsSOUND 359 371 400 402 362 356 411)
				(Load rsPIC 69)
				(gEgo init: hide:)
				(= register 1)
			)
			(1
				(gSounds eachElementDo: #stop)
				(gLongSong number: 359 loop: 1 play:)
				(= seconds 20)
			)
			(2
				(= seconds 0)
				(self setScript: doHyperspace self 10)
			)
			(3
				(gCurRoom drawPic: 69 10)
				(gLongSong fade:)
				(cockpitSound stop:)
				(= cycles 1)
			)
			(4
				(= seconds 2)
			)
			(5
				(= local3 1)
				(gSoundEffects number: 371 loop: 1 play:)
				(tempProp
					init:
					posn: 297 50
					view: 169
					setLoop: 2
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(6
				(gLongSong number: 400 loop: 1 play:)
				(tempProp setLoop: 3 cel: 0 setCycle: Fwd)
			)
			(7
				(escapePod
					init:
					view: 169
					setLoop: 0
					setStep: 13 7
					posn: 288 63
					cycleSpeed: 5
					setCycle: Fwd
					setMotion: MoveTo 228 105 self
				)
			)
			(8
				(escapePod setLoop: 1 setPri: 4 setCycle: 0)
				(= ticks 1)
			)
			(9
				(if (!= [local50 (+= local4 3)] -1)
					(-- state)
					(if (== [local50 local4] 1)
						(gSoundEffects number: 362 loop: 1 play: 127)
						(gLongSong number: 402 loop: 1 play:)
					)
					(escapePod
						cel: [local50 local4]
						x: [local50 (+ local4 1)]
						y: [local50 (+ local4 2)]
					)
				)
				(= cycles 1)
			)
			(10
				(escapePod setCel: 1 setMotion: MoveTo 84 168 self)
			)
			(11
				(gLongSong stop:)
				(gSoundEffects number: 411 loop: 1 play: self)
				(gEgo
					show:
					posn: 81 158
					view: 169
					setLoop: 4
					cel: 0
					cycleSpeed: 7
					setPri: 6
					setCycle: End self
				)
			)
			(12 0)
			(13
				(gLongSong2 fade:)
				(gLongSong number: 356 loop: 1 play: self)
				(tempProp setLoop: 2 cel: 3 setCycle: Beg)
				(= seconds 4)
			)
			(14
				(= local3 0)
			)
			(15
				(Print 14 16) ; "Ouch! I think we've got some serious organ damage here! All of them, of course, could be easily replaced in the time period from which you've just arrived. However, a quick scenery check reveals that you are now in the Dark Ages. The only transplant you'll get here is from carcass to spit over flame."
				(Print 14 17) ; "As you draw a few final lungfuls of oxygen through your newly-acquired sucking chest wound, you gleefully notice your final resting place is near beautiful Nottingham Castle - universally renowned for its inclusion in Sierra's 'Conquests of the Longbow'."
				(Print 14 18) ; "Oh, my goodness! You're shocked to hear some highly inflammatory language making its way into your auditory canals. Must be some uncivilized ruffians in the nearby pub."
				(EgoDead 948 0 0 14 19) ; "Well, you're dead again. We even warned you not to push that button. You have no one to blame but yourself for having to sit through a plug for another fine Sierra product. Maybe you'll follow directions next time. Thanks for playing (and all that stuff)."
			)
		)
	)
)

(instance throttleUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if register
					(= register 0)
					(= seconds (= state 1))
				else
					(arm loop: 1 setCycle: End self)
				)
			)
			(1
				(cond
					(local1
						(Print 14 11) ; "This has been rendered inoperable due to the shock of that less-than-graceful landing."
					)
					((not local0)
						(Print 14 20) ; "Nothing much will happen without power."
					)
					((not local74)
						(Print 14 21) ; "The lack of fuel allows you to float aimlessly through space."
					)
					(else
						(Print 14 22) ; "You are already thrusting through space."
					)
				)
				(= cycles 3)
			)
			(2
				(arm setCycle: Beg self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance unBuckle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(arm loop: 3 startUpd: cel: 5)
				(gLongSong2 number: 325 loop: 1 play: self)
			)
			(1
				(gLongSong2 number: 337 loop: 1 play:)
				(head cel: 1 forceUpd:)
				(arm setCycle: Beg self)
				(seatbelt1 cel: 5 setCycle: Beg)
				(seatbelt2 dispose:)
			)
			(2
				(gLongSong2 loop: 0 stop:)
				(head cel: 0 forceUpd:)
				(arm loop: 1 cel: 0)
				(seatbelt1 cel: 0 stopUpd:)
				(= cycles 6)
			)
			(3
				(= register 0)
				(gLongSong fade: 127 25 10 0)
				(gCurRoom newRoom: 37)
			)
		)
	)
)

(instance joystick of Feature
	(properties
		description {thruster}
		sightAngle 45
		onMeCheck 32
		lookStr {This lever causes forward propulsion of the pod when powered-up and in space.}
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: throttleUp)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoSuit of Feature
	(properties
		x 160
		y 100
		nsBottom 180
		nsRight 320
		description {Roger}
		sightAngle 45
		onMeCheck 16384
		lookStr {There doesn't seem to be enough room.}
	)

	(method (doVerb theVerb)
		(localproc_1)
		(super doVerb: theVerb &rest)
	)
)

(instance seatBeltFeat of Feature
	(properties
		x 293
		y 16
		nsTop -1
		nsLeft 270
		nsBottom 33
		nsRight 317
		description {seat belt}
		sightAngle 45
		onMeCheck 64
		lookStr {The seatbelt is dummy-tested, which ought to suit you just fine.}
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(3 ; Do
				(if local1
					(gCurRoom setScript: unBuckle 0 1)
				else
					(Print 14 23) ; "You have no need to remove your seatbelt."
				)
			)
			(2 ; Look
				(if local1
					(Print 14 24) ; "Hey, this baby saved your life. The view out the window, however, might make you regret it."
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

(instance Dials of Feature
	(properties
		description {Dials}
		onMeCheck 128
		lookStr {Dials galore populate the instrument console of the pod cabin. Too bad none of them work anymore.}
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(2 ; Look
				(Printf ; "Dials galore populate the instrument console of the pod cabin.%s"
					14
					25
					(if local1 { Too bad none of them work anymore.} else { })
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ControlPanel of Feature
	(properties
		description {ControlPanel}
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(2 ; Look
				(Printf ; "This is the pod's instrument console. Dials, gauges, and a couple of controls fill out the board.%s"
					14
					26
					(if local1 { Too bad none of them work anymore.} else {})
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Chair of Feature
	(properties
		description {Chair}
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(2 ; Look
				(Printf ; "This is the lucky escapee's seat.%s"
					14
					27
					(if local1
						{ It might have been dampened slightly by that landing.}
					else
						{ }
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance PodWindow of Feature
	(properties
		description {Window}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(2 ; Look
				(if local1
					(Print 14 28) ; "Through the fractured pod window, you see utter desolation spread out before you. You suddenly feel very lonely."
				else
					(Print 14 29) ; "The window allows you an unrestricted view of the vast nothingness of space."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ButtonPad of Feature
	(properties
		description {ButtonPad}
		onMeCheck 4118
		lookStr {On this button pad are the AUTONAV, POWER, and DON'T TOUCH buttons.}
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 2) ; Do, Look
			(gCurRoom setScript: buttonInset)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance kerona of View
	(properties
		x 92
		y 189
		description {Kerona}
		lookStr {should be hands-off}
		view 117
		loop 1
	)
)

(instance survivalKit of View
	(properties
		x 295
		y 177
		description {survival kit}
		lookStr {Within the survival kit are the necessities for surviving a brief stay in a less-than-hospitable environment.}
		view 113
		loop 10
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(2 ; Look
				(if local1
					(Print 14 30) ; "The rugged landing liberated the survival kit from its mounting fixture."
				else
					(Print 14 31) ; "Within the survival kit are the necessities for surviving a brief stay in a less-than-hospitable environment."
				)
			)
			(3 ; Do
				(Print 14 32) ; "You can't get that now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance back1 of View
	(properties
		x 142
		y 57
		description { mountain}
		lookStr {Mountains generously dappled with spires of unknown formational origin loom at your visual terminus.}
		view 238
		cel 1
	)
)

(instance back2 of View
	(properties
		x 59
		y 57
		description { mountain}
		lookStr {Mountains generously dappled with spires of unknown formational origin loom at your visual terminus.}
		view 238
		signal 16384
	)
)

(instance back3 of View
	(properties
		x 220
		y 57
		description { mountain}
		lookStr {Mountains generously dappled with spires of unknown formational origin loom at your visual terminus.}
		view 238
		loop 3
	)
)

(instance back4 of View
	(properties
		x 279
		y 56
		description { mountain}
		lookStr {Mountains generously dappled with spires of unknown formational origin loom at your visual terminus.}
		view 238
		loop 3
		cel 2
	)
)

(instance back5 of View
	(properties
		y 57
		description { mountain}
		lookStr {Mountains generously dappled with spires of unknown formational origin loom at your visual terminus.}
		view 238
		loop 3
		cel 2
	)
)

(instance ledLights of Prop
	(properties
		x 42
		y 112
		description {lights}
		view 113
		loop 6
		cel 2
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(2 ; Look
				(if local1
					(Print 14 11) ; "This has been rendered inoperable due to the shock of that less-than-graceful landing."
				else
					(Print 14 33) ; "Nice lights, huh?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 108
		y 117
		description {radar}
		lookStr {Simple radar.}
		view 113
		loop 5
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(2 ; Look
				(if local1
					(Print 14 11) ; "This has been rendered inoperable due to the shock of that less-than-graceful landing."
				else
					(Print 14 34) ; "This is a radar used by the Autonav system."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance arm of Prop
	(properties
		x 194
		y 86
		description { arm}
		lookStr {This is your arm.}
		view 113
		loop 1
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(localproc_1)
		(super doVerb: theVerb &rest)
	)
)

(instance head of Prop
	(properties
		x 225
		y 63
		description { head}
		lookStr {This is your head. This is your head in a fishbowl.}
		view 113
	)

	(method (doVerb theVerb)
		(localproc_1)
		(super doVerb: theVerb &rest)
	)
)

(instance seatbelt1 of Prop
	(properties
		x 276
		y 26
		view 113
		loop 4
		cel 6
		signal 16384
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(localproc_1)
		(seatBeltFeat doVerb: theVerb &rest)
	)
)

(instance seatbelt2 of Prop
	(properties
		x 194
		y 116
		z 30
		view 113
		loop 3
		cel 6
		priority 3
		signal 16400
	)

	(method (doVerb theVerb)
		(localproc_1)
		(seatBeltFeat doVerb: theVerb &rest)
	)
)

(instance star1 of Prop ; UNUSED
	(properties
		x 155
		y 51
		description { star}
		lookStr {star 1}
		view 216
		loop 4
		cel 3
		priority 1
		signal 22544
		cycleSpeed 20
	)
)

(instance star2 of Prop ; UNUSED
	(properties
		x 271
		y 114
		description { star}
		lookStr {star 2}
		view 216
		loop 4
		cel 1
		priority 1
		signal 22544
		cycleSpeed 14
	)
)

(instance star3 of Prop ; UNUSED
	(properties
		x 105
		y 154
		description { star}
		lookStr {don't need}
		view 216
		loop 4
		cel 2
		priority 1
		signal 22544
		cycleSpeed 16
	)
)

(instance smoke of Prop
	(properties
		x 195
		y 57
		description {smoke}
		lookStr {The spent drives of the pod vent fumes after the long escape from the Arcada.}
		view 137
		cycleSpeed 20
	)
)

(instance door of Prop
	(properties
		x 126
		y 98
		description {door}
		lookStr {This is the escape pod's hatch.}
		view 137
		loop 1
		priority 12
		signal 16400
		cycleSpeed 28
	)
)

(instance glass of Prop
	(properties
		x 96
		y 151
		description {glass}
		lookStr {glass}
		view 137
		loop 2
	)
)

(instance hologram of Prop
	(properties
		x 90
		y 36
		description { hologram}
		lookStr {hologram}
		view 113
		loop 7
		signal 24576
	)
)

(instance tempProp of Prop
	(properties
		view 113
		loop 9
		signal 24576
	)

	(method (init)
		(super init: &rest)
		(if (== view 116)
			(self x: (+ (escapePod x:) 37) y: (- (escapePod y:) 12))
		)
	)

	(method (doit)
		(if (== view 116)
			(self x: (+ (escapePod x:) 37) y: (- (escapePod y:) 12))
		)
		(super doit:)
	)

	(method (cue)
		(self hide:)
		(super cue:)
	)
)

(instance escapePod of Actor
	(properties
		x 223
		y 70
		description {escape pod}
		lookStr {escape pod}
		yStep 12
		view 216
		loop 3
		signal 26624
		cycleSpeed 5
		xStep 25
		moveSpeed 1
	)
)

(instance cockpitSound of Sound
	(properties
		number 326
	)
)

(instance AutoNavButton of Feature
	(properties
		x 62
		y 34
		nsTop 24
		nsLeft 54
		nsBottom 40
		nsRight 70
		description {Autonav button}
		sightAngle 0
		lookStr {This is the Autonav button. When operative it allows the pod to navigate to the closest habitable planet.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: pushButton 0 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance DontPressButton of Feature
	(properties
		x 86
		y 34
		nsTop 24
		nsLeft 80
		nsBottom 40
		nsRight 96
		description {button}
		sightAngle 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if local1
					(Print 14 35) ; "This button WASN'T to be pushed at anytime. Now that it's dead go crazy and push away."
				else
					(Print 14 36) ; "THIS BUTTON IS NOT TO BE PUSHED AT ANYTIME."
				)
			)
			(3 ; Do
				(gCurRoom setScript: pushButton 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance PowerButton of Feature
	(properties
		x 110
		y 34
		nsTop 24
		nsLeft 104
		nsBottom 40
		nsRight 120
		description {power button}
		sightAngle 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Printf ; "This is the power button for the escape pod.%s"
					14
					37
					(if local1
						{ Its service life has expired as a result of the rugged touch-down.}
					else
						{ }
					)
				)
			)
			(3 ; Do
				(gCurRoom setScript: pushButton 0 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance padInset of View
	(properties
		x 87
		y 14
		description {button pad}
		lookStr {Please press the desired button.}
		view 113
		loop 11
		signal 24577
	)
)

(instance BUTTON of View
	(properties
		view 113
		loop 11
		cel 1
		priority 5
		signal 24592
	)

	(method (init)
		(localproc_0)
		(self x: ((CueObj client:) x:) y: ((CueObj client:) y:))
		(super init: &rest)
	)
)

