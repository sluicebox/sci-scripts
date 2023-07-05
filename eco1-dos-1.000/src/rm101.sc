;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Talker)
(use Osc)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm101 0
)

(local
	local0 = 1
	[local1 500]
)

(procedure (localproc_0 param1)
	(Print (GetMessage 16 101 param1 @local1) 33 310 67 -1 15 28 global207)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0)
	(for ((= temp0 param2)) (>= temp0 param3) ((-= temp0 5))
		(Palette palSET_INTENSITY 33 255 temp0)
		(Wait param1)
	)
)

(instance rm101 of EcoRoom
	(properties
		lookStr 37
		picture 100
		style 10
		horizon 15
	)

	(method (init)
		(whale init:)
		(gEgo
			init:
			view: 850
			setLoop: 1
			setCel: 0
			posn: 15 48
			setPri: 10
			signal: 16400
		)
		(LoadMany
			rsVIEW
			100
			850
			851
			852
			853
			660
			662
			957
			107
			242
			142
			236
			234
			235
			249
			166
			185
			106
		)
		(LoadMany rsPIC 660 340)
		(LoadMany rsSOUND 666 381 646)
		(plant setCycle: Fwd init:)
		(leaves setCycle: Fwd init:)
		(super init:)
		(gLongSong number: 666 loop: -1 play:)
		(HandsOff)
		(SetCursor 957 0 9)
		(self setScript: cetusRide)
	)

	(method (doit)
		(MoveCursor 0 200)
		(SetCursor 957 0 9)
		(super doit: &rest)
	)
)

(instance cetusRide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gLongSong prevSignal:) 10)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(1
				(whale setMotion: MoveTo 70 79 self)
			)
			(2
				(Narrator posn: -1 16 init: 1 self) ; "In a true champion's welcome, Adam rides on the back of King Cetus in a slow procession to the city!"
			)
			(3
				(whale setMotion: MoveTo 140 79 self)
			)
			(4
				(Narrator posn: -1 16 init: 2 self) ; "Cetus bellows an announcement of their triumphant return!"
			)
			(5
				(gSoundEffects number: 646 play:)
				(whale setMotion: MoveTo 213 79 self)
			)
			(6
				(localproc_0 1)
				(= cycles 1)
			)
			(7
				(= local0 0)
				(= ticks 120)
			)
			(8
				(Narrator posn: -1 16 init: 3 self) ; "Adam slips off the back of the mighty whale and swims to join the happy Elurians."
			)
			(9
				(gEgo
					setLoop: 2
					setCel: 0
					posn: 144 63
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(10
				(gEgo setScript: adamSwim)
				(fish1 init: setCycle: Fwd setMotion: MoveTo 114 129 self)
				(fish2 init: setCycle: Fwd setMotion: MoveTo 230 127 self)
			)
			(11 0)
			(12
				(fish1
					setLoop: 3
					setCel: 0
					posn: 136 124
					cycleSpeed: 18
					setCycle: End
				)
				(fish2
					setLoop: 2
					setCel: 0
					posn: 206 124
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(13
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 660 9 setScript: conchCeremony)
				(self dispose:)
			)
		)
	)
)

(instance adamSwim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop: 3
					setCel: 0
					posn: 187 100
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: 4
					setCel: 0
					posn: 170 121
					cycleSpeed: 3
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance conchCeremony of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					show:
					view: 660
					setLoop: 6
					setCel: 0
					posn: 162 89
					cycleSpeed: 12
				)
				(epiderm init: setCycle: Fwd)
				(hippo init: setCycle: Fwd)
				(olympia init: setCycle: Fwd)
				(erron init: setCycle: Fwd)
				(narc init: setCycle: Fwd)
				(delph init: setCycle: Fwd)
				(greg init: setCycle: Fwd)
				(superf init: setCycle: Fwd)
				(lobster init: setCycle: Fwd)
				(oracle init: setCycle: Fwd)
				(= ticks 360)
			)
			(1
				(Superfluous init: 1 1 self) ; "Congratulations <sob>, Adam! I'm so moved <boo hoo>!"
			)
			(2
				(= cycles 1)
			)
			(3
				(= ticks 120)
			)
			(4
				(= cycles 1)
			)
			(5
				(Hippocrates init: 1 1 self) ; "Bravo! I knew a strapping lad like you could do it!"
			)
			(6
				(= ticks 120)
			)
			(7
				(= cycles 1)
			)
			(8
				(Epidermis init: 1 1 self) ; "Like, unbelievably radical, Adam! Major way to go!"
			)
			(9
				(= ticks 120)
			)
			(10
				(= cycles 1)
			)
			(11
				(Demeter init: 1 1 self) ; "You have proven yourself one with the greens, Adam."
			)
			(12
				(= ticks 120)
			)
			(13
				(= cycles 1)
			)
			(14
				(Erroneous init: 1 1 self) ; "Good show, old boy! Quite spectacular indeed!"
			)
			(15
				(= ticks 120)
			)
			(16
				(= cycles 1)
			)
			(17
				(Gregarious init: 1 1 self) ; "Yer a real he-ro now, Adam! <a-hyuh>"
			)
			(18
				(= ticks 120)
			)
			(19
				(= cycles 1)
			)
			(20
				(Narcissus init: 1 1 self) ; "Eet is as well that you deed the job, Adam, since I deed not have zee time <ho-hum>. You deed almost as well as I would have, mon ami!"
			)
			(21
				(= ticks 120)
			)
			(22
				(= cycles 1)
			)
			(23
				(Olympia init: 1 1 self) ; "You were very, very brave, Adam."
			)
			(24
				(= ticks 120)
			)
			(25
				(= cycles 1)
			)
			(26
				(Oracle init: 1 1 self) ; "Child of man, to you we owe our lives, our thanks we now bestow."
			)
			(27
				(= ticks 120)
			)
			(28
				(= cycles 1)
			)
			(29
				(localproc_0 2)
				(= cycles 1)
			)
			(30
				(= ticks 120)
			)
			(31
				(= cycles 1)
			)
			(32
				(localproc_0 3)
				(= cycles 1)
			)
			(33
				(= ticks 120)
			)
			(34
				(= cycles 1)
			)
			(35
				(localproc_0 4)
				(= cycles 1)
			)
			(36
				(= ticks 120)
			)
			(37
				(= cycles 1)
			)
			(38
				(localproc_0 5)
				(= cycles 1)
			)
			(39
				(= ticks 120)
			)
			(40
				(= cycles 1)
			)
			(41
				((ScriptID 2 1) init: 1 1 self) ; Adam, "Thank you, great Cetus. I have learned much from all of you too."
			)
			(42
				(cushionFish
					init:
					setLoop: 7
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 132 97 self
				)
				(conch init: setLoop: 8 setCel: 0 setMotion: MoveTo 166 88 self)
			)
			(43 0)
			(44
				(localproc_0 6)
				(= cycles 1)
			)
			(45
				(= cycles 1)
			)
			(46
				(cushionFish setMotion: MoveTo 152 97 self)
				(conch setMotion: MoveTo 186 88 self)
			)
			(47 0)
			(48
				(= ticks 60)
			)
			(49
				(gEgo
					view: 660
					setLoop: 7
					setCel: 0
					posn: 165 95
					setCycle: CT 5 1 self
				)
			)
			(50
				(SetScore 20 251)
				(conch hide:)
				(gEgo setCycle: End self)
			)
			(51
				(gEgo view: 853 setLoop: 12 setCel: 0 setCycle: Fwd)
				(= ticks 60)
			)
			(52
				(gEgo setLoop: 13 setCel: 0 setCycle: CT 5 1 self)
			)
			(53
				(gSoundEffects number: 646 play:)
				(gEgo setCycle: CT 8 1)
				(= ticks 90)
			)
			(54
				(gEgo setCycle: End self)
			)
			(55
				(gEgo setLoop: 14 setCel: 0 setCycle: Fwd)
				(= ticks 120)
			)
			(56
				((ScriptID 2 1) init: 2 1 self) ; Adam, "Poseidon's conch! Wow! Thank you, your Majesty!"
			)
			(57
				(= ticks 180)
			)
			(58
				(cushionFish setMotion: MoveTo 350 97)
				(localproc_0 7)
				(= cycles 1)
			)
			(59
				(= ticks 120)
			)
			(60
				((ScriptID 2 0) init: 1 1 self) ; Delphineus, "Yes Sir, your Majesty! Grab a fin, Adam!"
			)
			(61
				(gLongSong fade: 0 10 2 1)
				(= cycles 1)
			)
			(62
				(if (> (cushionFish x:) 349)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(63
				(= ticks 20)
			)
			(64
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 340 -32759 setScript: delphDialog)
				(self dispose:)
			)
		)
	)
)

(instance delphDialog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 381 loop: -1 play:)
				(= cycles 2)
			)
			(1
				(Narrator init: 4 self) ; "Adam bids farewell to Eluria and King Cetus and, grabbing onto Delphineus' dorsal fin, hangs on tight for the long ride home."
			)
			(2
				(localproc_1 5 100 90)
				(gEgo
					show:
					view: 106
					setLoop: 0
					setCel: 0
					posn: -20 100
					setStep: 7 4
					cycleSpeed: 5
					moveSpeed: 2
					setCycle: Fwd
					setMotion: MoveTo 80 100 self
				)
			)
			(3
				(gEgo setMotion: MoveTo 370 100 self)
				(Print (GetMessage 3 101 3 @local1) #at 112 132 #time 5 #dispose self)
			)
			(4 0)
			(5
				(localproc_1 5 90 80)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(6
				(gEgo setMotion: MoveTo 370 100 self)
				(Print (GetMessage 4 101 2 @local1) #at 64 28 #time 5 #dispose self)
			)
			(7 0)
			(8
				(localproc_1 5 80 70)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(9
				(gEgo setMotion: MoveTo 370 100 self)
				(Print (GetMessage 3 101 4 @local1) #at 112 132 #time 5 #dispose self)
			)
			(10 0)
			(11
				(localproc_1 5 70 60)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(12
				(gEgo setScript: adamDelSwim)
				(Print (GetMessage 4 101 3 @local1) #at 64 15 #time 10 #dispose self)
			)
			(13
				(localproc_1 5 50 40)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(14
				(gEgo setMotion: MoveTo 370 100 self)
				(Print (GetMessage 3 101 5 @local1) #at 112 132 #time 5 #dispose self)
			)
			(15 0)
			(16
				(localproc_1 5 40 30)
				(gEgo posn: -20 100 setMotion: MoveTo 80 100 self)
			)
			(17
				(gEgo setMotion: MoveTo 370 100 self)
				(Print (GetMessage 4 101 4 @local1) #at 64 28 #time 5 #dispose self)
			)
			(18 0)
			(19
				(localproc_1 5 30 0)
				(= cycles 1)
			)
			(20
				(= ticks 60)
			)
			(21
				(gCurRoom newRoom: 680)
				(self dispose:)
			)
		)
	)
)

(instance adamDelSwim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 370 100 self)
			)
			(1
				(localproc_1 5 60 50)
				(gEgo posn: -20 100 setMotion: MoveTo 370 100 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance leaves of Prop
	(properties
		x 281
		y 100
		lookStr 8
		view 100
		loop 1
		priority 10
		signal 16400
		cycleSpeed 12
		detailLevel 2
	)
)

(instance plant of Prop
	(properties
		x 258
		y 5
		lookStr 8
		view 100
		loop 2
		signal 16400
		cycleSpeed 12
		detailLevel 2
	)
)

(instance whale of Actor
	(properties
		y 50
		view 850
	)

	(method (doit)
		(super doit: &rest)
		(if local0
			(gEgo posn: (+ (whale x:) 15) (- (whale y:) 2))
		)
	)
)

(instance eye1 of Actor ; UNUSED
	(properties
		x 139
		y 63
		view 660
		loop 2
		cel 1
	)
)

(instance fin of Actor ; UNUSED
	(properties
		x 18
		y 70
		view 660
		loop 3
		cel 1
	)
)

(instance eye3 of Actor ; UNUSED
	(properties
		x 129
		y 71
		view 662
		loop 1
		signal 16384
	)
)

(instance eye4 of Actor ; UNUSED
	(properties
		x 129
		y 71
		view 662
		loop 2
		signal 16384
	)
)

(instance eye2 of Actor ; UNUSED
	(properties
		x 129
		y 71
		view 662
	)
)

(instance eye5 of Actor ; UNUSED
	(properties
		x 129
		y 71
		view 662
		loop 3
		signal 16384
	)
)

(instance eye6 of Actor ; UNUSED
	(properties
		x 129
		y 71
		view 662
		loop 4
		signal 16384
	)
)

(instance brow of Actor ; UNUSED
	(properties
		x 119
		y 73
		view 662
		loop 5
	)
)

(instance epiderm of Prop
	(properties
		x 72
		y 121
		view 853
		loop 1
		cel 2
	)
)

(instance hippo of Prop
	(properties
		x 273
		y 96
		view 853
		loop 5
		cycleSpeed 12
	)
)

(instance olympia of Prop
	(properties
		x 96
		y 150
		view 853
		loop 2
		cel 1
		cycleSpeed 12
	)
)

(instance erron of Prop
	(properties
		x 69
		y 61
		view 853
		cycleSpeed 18
	)
)

(instance narc of Prop
	(properties
		x 251
		y 57
		view 853
		loop 6
		cel 1
		cycleSpeed 12
	)
)

(instance delph of Prop
	(properties
		x 254
		y 138
		view 853
		loop 4
		cel 5
		cycleSpeed 12
	)
)

(instance greg of Prop
	(properties
		x 172
		y 163
		view 853
		loop 3
		cel 1
		cycleSpeed 12
	)
)

(instance egogetshell of Actor ; UNUSED
	(properties
		x 163
		y 94
		view 853
		loop 10
		cel 8
		signal 16384
	)
)

(instance superf of Prop
	(properties
		x 216
		y 26
		view 162
		loop 1
		cel 2
		cycleSpeed 12
	)
)

(instance lobster of Prop
	(properties
		x 97
		y 37
		view 341
		loop 4
		cel 3
		cycleSpeed 12
	)
)

(instance oracle of Prop
	(properties
		x 154
		y 26
		view 853
		loop 11
		cel 5
	)
)

(instance fish1 of Actor
	(properties
		y 189
		view 851
	)
)

(instance fish1b of Actor ; UNUSED
	(properties
		x 133
		y 147
		view 851
	)
)

(instance fish2 of Actor
	(properties
		x 317
		y 116
		view 851
		loop 4
	)
)

(instance fish2a of Actor ; UNUSED
	(properties
		x 218
		y 131
		view 851
		loop 4
	)
)

(instance cushionFish of Actor
	(properties
		x -10
		y 103
		view 853
		loop 7
		signal 16400
	)
)

(instance conch of Actor
	(properties
		x 24
		y 95
		view 853
		loop 8
		priority 7
		signal 16
	)
)

(instance cushionFishB of Actor ; UNUSED
	(properties
		x 152
		y 97
		view 853
		loop 7
		signal 16384
	)
)

(instance conchB of Actor ; UNUSED
	(properties
		x 186
		y 88
		view 853
		loop 8
		priority 7
		signal 16400
	)
)

(instance Narcissus of Talker
	(properties
		nsTop 16
		nsLeft 16
		view 236
		viewInPrint 1
		charNum 11
		keepWindow 1
	)

	(method (init)
		(super init: nBust nEyes nMouth &rest)
	)
)

(instance nBust of Prop
	(properties
		view 236
		cel 1
	)
)

(instance nEyes of Prop
	(properties
		nsTop 3
		nsLeft 11
		view 236
		loop 2
		cycleSpeed 30
	)
)

(instance nMouth of Prop
	(properties
		nsTop 11
		nsLeft 12
		view 236
		loop 1
		cycleSpeed 10
	)
)

(instance Epidermis of Talker
	(properties
		nsTop 16
		nsLeft 16
		view 234
		viewInPrint 1
		charNum 10
		keepWindow 1
	)

	(method (init)
		(super init: eBust eEyes eMouth &rest)
	)
)

(instance eBust of Prop
	(properties
		view 234
		cel 1
	)
)

(instance eEyes of Prop
	(properties
		nsTop 16
		nsLeft 29
		view 234
		loop 2
		cycleSpeed 30
	)
)

(instance eMouth of Prop
	(properties
		nsTop 21
		nsLeft 26
		view 234
		loop 1
		cycleSpeed 10
	)
)

(instance Hippocrates of Talker
	(properties
		nsTop 130
		nsLeft 70
		view 235
		viewInPrint 1
		charNum 12
		keepWindow 1
	)

	(method (init)
		(super init: hBust hEyes hMouth &rest)
	)
)

(instance hBust of Prop
	(properties
		view 235
		cel 1
	)
)

(instance hEyes of Prop
	(properties
		nsTop 5
		nsLeft 17
		view 235
		loop 3
		cycleSpeed 30
	)
)

(instance hMouth of Prop
	(properties
		nsTop 10
		nsLeft 15
		view 235
		loop 1
		cycleSpeed 10
	)
)

(instance Erroneous of Talker
	(properties
		nsTop 16
		nsLeft 16
		view 107
		viewInPrint 1
		charNum 13
		keepWindow 1
	)

	(method (init)
		(super init: erBust erEyes erMouth &rest)
	)
)

(instance erBust of Prop
	(properties
		view 107
		cel 1
	)
)

(instance erEyes of Prop
	(properties
		nsTop 10
		nsLeft 6
		view 107
		loop 2
		cycleSpeed 30
	)
)

(instance erMouth of Prop
	(properties
		nsTop 14
		view 107
		loop 1
		cycleSpeed 10
	)
)

(instance Gregarious of Talker
	(properties
		nsTop 130
		nsLeft 60
		view 249
		viewInPrint 1
		charNum 7
		keepWindow 1
	)

	(method (init)
		(super init: gBust gEyes gMouth &rest)
	)
)

(instance gBust of Prop
	(properties
		view 249
		cel 1
	)
)

(instance gEyes of Prop
	(properties
		nsTop 9
		nsLeft 9
		view 249
		loop 2
		cycleSpeed 30
	)
)

(instance gMouth of Prop
	(properties
		nsTop 12
		nsLeft 4
		view 249
		loop 1
		cycleSpeed 10
	)
)

(instance Superfluous of Talker
	(properties
		nsTop 16
		nsLeft 16
		view 166
		viewInPrint 1
		charNum 5
		keepWindow 1
	)

	(method (init)
		(super init: sBust sEyes sMouth &rest)
	)
)

(instance sBust of Prop
	(properties
		view 166
		cel 1
	)
)

(instance sEyes of Prop
	(properties
		nsTop 2
		view 166
		loop 2
		cycleSpeed 30
	)
)

(instance sMouth of Prop
	(properties
		view 166
		loop 1
		cycleSpeed 10
	)
)

(instance Demeter of Talker
	(properties
		nsTop 130
		nsLeft 60
		view 185
		loop 3
		viewInPrint 1
		charNum 18
		keepWindow 1
	)

	(method (init)
		(super init: demBust demEyes demMouth &rest)
	)
)

(instance demBust of Prop
	(properties
		view 185
	)
)

(instance demEyes of Prop
	(properties
		nsTop 13
		view 185
		loop 2
		cycleSpeed 30
	)
)

(instance demMouth of Prop
	(properties
		nsTop 18
		nsLeft 13
		view 185
		loop 1
		cycleSpeed 10
	)
)

(instance conchTreading of Osc ; UNUSED
	(properties)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) 10) (< temp0 5))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)
)

(instance Olympia of Talker
	(properties
		nsTop 130
		nsLeft 80
		view 242
		viewInPrint 1
		charNum 14
		keepWindow 1
	)

	(method (init)
		(super init: oBust oEyes oMouth &rest)
	)
)

(instance oBust of Prop
	(properties
		view 242
		cel 1
	)
)

(instance oEyes of Prop
	(properties
		nsTop 7
		nsLeft 6
		view 242
		loop 2
		cycleSpeed 30
	)
)

(instance oMouth of Prop
	(properties
		nsTop 11
		nsLeft 14
		view 242
		loop 1
		cycleSpeed 10
	)
)

(instance Oracle of Talker
	(properties
		nsTop 16
		nsLeft 16
		view 142
		viewInPrint 1
		charNum 1
		keepWindow 1
	)

	(method (init)
		(super init: oracleBust oracleEye oracleMouth &rest)
	)
)

(instance oracleBust of Prop
	(properties
		view 142
	)
)

(instance oracleEye of Prop
	(properties
		nsTop 12
		nsLeft 30
		view 142
		loop 2
		cycleSpeed 30
	)
)

(instance oracleMouth of Prop
	(properties
		nsTop 13
		nsLeft 35
		view 142
		loop 1
		cycleSpeed 10
	)
)

