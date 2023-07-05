;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use arcadaRegion)
(use RandCycle)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm13 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(buttonSound number: 317 loop: 1 play:)
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

(instance rm13 of Rm
	(properties
		lookStr {The inside of the Arcada's escape pod is not exactly packed with luxurious appointments. However, when it comes to saving one's posterior, the pod's as good as a Rolls.}
		picture 13
	)

	(method (init)
		(gEgo view: 0)
		(= global166 1)
		(Load rsPIC 213)
		(LoadMany rsVIEW 216 113)
		(LoadMany rsSOUND 805 326 804 333 370)
		(self setRegions: 700) ; arcadaRegion
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
		(ledLights init:)
		(survivalKit init: stopUpd:)
		(screen init:)
		(if (IsFlag 10)
			(gCurRoom overlay: 413)
		else
			(gCurRoom overlay: 513)
		)
		(if (proc700_1 553 1)
			(= local0 1)
			(cockpitSound number: 326 loop: -1 flags: 1 play:)
			(ledLights setCycle: Fwd)
			(screen setCycle: Fwd)
		else
			(ledLights hide:)
			(screen hide:)
		)
		(head init: stopUpd:)
		(arm init: stopUpd:)
		(seatbelt1 init: stopUpd:)
		(HandsOn)
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
			(cond
				((not local2)
					(Print 13 0) ; "You exit the escape pod."
					(gCurRoom newRoom: 12)
				)
				(local2
					(Print 13 1) ; "Remove your seatbelt first. It works better."
				)
			)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 12) (!= (gLongSong number:) 355))
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= global166 2)
		(cockpitSound loop: 0 fade:)
		(gSoundEffects loop: 0 stop: number: 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(localproc_1)
		(super doVerb: theVerb &rest)
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
					(Print 13 2) ; "Please press the desired button on the inset."
				)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance escapeArcada of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom drawPic: 16 10)
				(ledLights dispose:)
				(survivalKit dispose:)
				(screen dispose:)
				(gLongSong2 pause:)
				(cockpitSound stop:)
				(if (> global172 30)
					(gLongSong2 number: 370 loop: 0 play:)
				)
				(deltaurArm init:)
				(arcada init:)
				(deltaur init:)
				(star1 init: setCycle: Fwd)
				(star2 init: setCycle: Fwd)
				(star3 init: setCycle: Fwd)
				(= cycles 3)
			)
			(1
				(UnLoad 132 326)
				(cockpitSound number: 804 loop: 1 play:)
				(deltaur
					illegalBits: 0
					setMotion: MoveTo (- (deltaur x:) 50) (- (deltaur y:) 120)
				)
				(deltaurArm
					setMotion:
						MoveTo
						(- (deltaurArm x:) 50)
						(- (deltaurArm y:) 120)
					setCycle: End
				)
				(= seconds 4)
			)
			(2
				(gSoundEffects number: 333 loop: 1 play:)
				(escapePod
					init:
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo -75 160
				)
				(= cycles 20)
			)
			(3
				(cockpitSound number: 805 loop: 1 play:)
				(arcada setCycle: End arcada)
				(= seconds 6)
			)
			(4
				(gCurRoom newRoom: 14)
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
				(switch register
					(1
						(if (not local0)
							(Print 13 3) ; "This option works better with the power on."
						else
							(Print 13 4) ; "You will need to leave the Launch Bay first."
						)
					)
					(2
						(if (not local0)
							(= local0 1)
							((ScriptID 700 0) ; arcadaRegion
								rFlag1: (| ((ScriptID 700 0) rFlag1:) $0001) ; arcadaRegion
							)
							(ledLights show:)
							(screen show:)
							(if (not local2)
								(gSoundEffects number: 331 loop: 6 play:)
							)
							(gLongSong2
								number: 328
								loop: 1
								flags: 1
								play:
								hold: 1
							)
							(cockpitSound number: 326 loop: -1 flags: 1 play:)
						else
							(gSoundEffects loop: 0 stop:)
							(gLongSong2 stop: hold: 0)
							(cockpitSound number: 326 loop: 0 stop:)
							(= local0 0)
							((ScriptID 700 0) ; arcadaRegion
								rFlag1: (| ((ScriptID 700 0) rFlag1:) $fffe) ; arcadaRegion
							)
							(ledLights hide:)
							(screen hide:)
						)
					)
					(else
						(if (not local0)
							(Print 13 3) ; "This option works better with the power on."
						else
							(Print 13 5) ; "This option works only when clear of the Arcada."
						)
					)
				)
				(= register 0)
				(= cycles 3)
			)
			(5
				(arm loop: 1 cel: 1 setCycle: Beg self)
			)
			(6
				(head cel: 0 forceUpd:)
				(arm loop: 1 cel: 0)
				(= cycles 2)
			)
			(7
				(arm stopUpd:)
				(HandsOn)
				(self dispose:)
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
				(if local0
					((ScriptID 700 0) inGame: 0) ; arcadaRegion
				)
				(if register
					(= register 0)
					(= state 2)
					(= seconds 1)
				else
					(arm loop: 1 setCycle: End self)
				)
			)
			(1
				(= state 2)
				(cond
					((not local0)
						(Print 13 6) ; "Nothing much will happen without power."
						(= cycles 3)
					)
					((not (IsFlag 10))
						((ScriptID 700 0) inGame: 0) ; arcadaRegion
						(gLongSong2 number: 327 loop: 1 play: hold: 1)
						(gCurRoom setScript: crashThruDoors)
					)
					((not local2)
						(EgoDead 948 0 0 13 7) ; "Buckle up for safety, buckle up."
					)
					(else
						(= state 1)
						(UnLoad 132 328)
						(UnLoad 132 337)
						(UnLoad 132 325)
						(gLongSong2 number: 327 loop: 1 flags: 1 play: hold: 1)
						(= cycles 60)
					)
				)
			)
			(2
				(Print 13 8) ; "As you slide the throttle forward, you can feel the Arcada start to shake."
				(SetScore 15 138)
				(gCurRoom setScript: escapeArcada)
				(= cycles 3)
			)
			(3
				(arm setCycle: Beg self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance buckleUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(head cel: 1)
				(arm loop: 3 cel: 0 setCycle: CT 2 1 self)
				(seatbelt1 setCycle: CT 2 1)
			)
			(1
				(seatBeltSound number: 337 loop: 1 play:)
				(arm loop: 3 cel: 3 setCycle: CT 5 1 self)
				(seatbelt1 cel: 3 setCycle: CT 5 1)
			)
			(2
				(gSoundEffects loop: 0 stop:)
				(seatBeltSound number: 325 loop: 1 play:)
				(head cel: 0 forceUpd:)
				(seatbelt1 cel: 6)
				(seatbelt2 init: setPri: 3)
				(= local2 1)
				(= ticks 40)
			)
			(3
				(arm loop: 1 cel: 0)
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
				(seatBeltSound number: 325 loop: 1 play: self)
			)
			(1
				(seatBeltSound number: 337 loop: 1 play:)
				(head cel: 1 forceUpd:)
				(arm setCycle: Beg self)
				(seatbelt1 cel: 5 setCycle: Beg)
				(seatbelt2 dispose:)
				(= local2 0)
			)
			(2
				(seatBeltSound loop: 0 stop:)
				(head cel: 0 forceUpd:)
				(arm loop: 1 cel: 0)
				(seatbelt1 cel: 0 stopUpd:)
				(= cycles 6)
			)
			(3
				(if register
					(= register 0)
					(gLongSong fade: 127 25 10 0)
					(gCurRoom newRoom: 37)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance crashThruDoors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCurRoom drawPic: 14 -32759)
				(gLongSong2 pause:)
				(cockpitSound stop:)
				(deltaurArm
					init:
					view: 114
					setLoop: 0
					setCel: 0
					posn: 201 76
					setPri: 12
					stopUpd:
				)
				(armsR init: stopUpd:)
				(buldge init:)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(gSoundEffects number: 361 loop: 1 play:)
				(buldge setPri: 11 cycleSpeed: 8 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(gSoundEffects number: 805 loop: 1 play:)
				(xplosion init: setPri: 13 cycleSpeed: 4 setCycle: CT 5 1 self)
			)
			(5
				(xplosion setCycle: End self)
				(buldge posn: 167 164 setPri: 12 setLoop: 4 cel: 0)
			)
			(6
				(xplosion dispose:)
				(= seconds 3)
			)
			(7
				(EgoDead 945 0 0 13 9) ; "Guess those doors are as strong as they look."
				(self dispose:)
			)
		)
	)
)

(instance joystick of Feature
	(properties
		description {thruster}
		sightAngle 45
		onMeCheck 32
		lookStr {This lever causes forward propulsion of the pod when powered-up.}
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
				(cond
					(local2
						(gCurRoom setScript: unBuckle)
					)
					((not local2)
						(gCurRoom setScript: buckleUp)
					)
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
		lookStr {Dials galore populate the instrument console of the pod cabin.}
	)

	(method (doVerb theVerb)
		(localproc_1)
		(super doVerb: theVerb &rest)
	)
)

(instance ControlPanel of Feature
	(properties
		description {ControlPanel}
		onMeCheck 256
		lookStr {This is the pod's instrument console. Dials, gauges, and a couple of controls fill out the board.}
	)

	(method (doVerb theVerb)
		(localproc_1)
		(super doVerb: theVerb &rest)
	)
)

(instance Chair of Feature
	(properties
		description {Chair}
		onMeCheck 1024
		lookStr {This is the lucky escapee's seat.}
	)

	(method (doVerb theVerb)
		(localproc_1)
		(super doVerb: theVerb &rest)
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
				(if (IsFlag 10)
					(Print 13 10) ; "Through the open bay doors you can see a plethora of stars."
				else
					(Print 13 11) ; "Your view is limited by the closed bay doors."
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
		lookStr {This is a button pad.}
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 2) ; Do, Look
			(gCurRoom setScript: buttonInset)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance armsR of View
	(properties
		x 201
		y 76
		description {deltaur arms}
		lookStr {don't need this}
		view 114
	)
)

(instance survivalKit of View
	(properties
		x 295
		y 177
		description {survival kit}
		lookStr {The survival kit contains the basics for deep space survival.}
		view 113
		loop 10
	)

	(method (doVerb theVerb)
		(localproc_1)
		(switch theVerb
			(3 ; Do
				(Print 13 12) ; "You don't need that right now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buldge of Prop
	(properties
		x 167
		y 154
		description {buldge}
		lookStr {don't need one.}
		view 214
		loop 2
	)
)

(instance xplosion of Prop
	(properties
		x 172
		y 152
		description {explosion}
		lookStr {don't need one.}
		view 214
		loop 3
	)
)

(instance ledLights of Prop
	(properties
		x 42
		y 112
		description {lights}
		lookStr {Nice lights, huh?}
		view 113
		loop 6
		cel 2
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setCycle: RandCycle)
	)
)

(instance screen of Prop
	(properties
		x 108
		y 117
		description {radar}
		lookStr {This is radar for the Autonav system.}
		view 113
		loop 5
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
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
		signal 16384
	)

	(method (doVerb theVerb)
		(localproc_1)
		(seatBeltFeat doVerb: theVerb &rest)
	)
)

(instance star1 of Prop
	(properties
		x 155
		y 51
		description {star}
		lookStr {Stars glow from afar.}
		view 216
		loop 4
		cel 3
		priority 1
		signal 22544
		cycleSpeed 20
	)
)

(instance star2 of Prop
	(properties
		x 271
		y 114
		description { star}
		lookStr {Stars glow from afar.}
		view 216
		loop 4
		cel 1
		priority 1
		signal 22544
		cycleSpeed 14
	)
)

(instance star3 of Prop
	(properties
		x 105
		y 154
		description { star}
		lookStr {Stars glow from afar.}
		view 216
		loop 4
		cel 2
		priority 1
		signal 22544
		cycleSpeed 8
	)
)

(instance arcada of Prop
	(properties
		x 247
		y 100
		description {Arcada}
		lookStr {It's your former ship, the Arcada.}
		view 216
		signal 26624
		cycleSpeed 5
	)

	(method (cue)
		(self dispose:)
	)
)

(instance deltaur of Actor
	(properties
		x 253
		y 49
		description {Deltaur}
		lookStr {Deltaur lookStr}
		view 216
		loop 1
		signal 26624
		xStep 1
	)
)

(instance deltaurArm of Actor
	(properties
		x 253
		y 49
		description { deltaur}
		lookStr {don't need this}
		view 216
		loop 2
		priority 12
		signal 30736
		cycleSpeed 5
	)
)

(instance escapePod of Actor
	(properties
		x 223
		y 70
		description {escape pod}
		lookStr {This is the escape pod. It is currently occupied by you.}
		yStep 12
		view 216
		loop 3
		signal 26624
		cycleSpeed 5
		xStep 25
		moveSpeed 4
	)
)

(instance cockpitSound of Sound
	(properties
		number 326
	)
)

(instance buttonSound of Sound
	(properties)
)

(instance seatBeltSound of Sound
	(properties)
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
				(Print 13 13) ; "THIS BUTTON IS NOT TO BE PUSHED AT ANYTIME."
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
				(Print 13 14) ; "This is the power button for the escape pod."
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
		lookStr {Choose the appropriate button.}
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

