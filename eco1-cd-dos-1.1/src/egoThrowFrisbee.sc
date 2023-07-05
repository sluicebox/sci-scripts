;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use rm380)
(use n819)
(use EcoFeature)
(use PolyPath)
(use LoadMany)
(use Motion)
(use System)

(public
	egoThrowFrisbee 0
	gotIt 1
)

(local
	[local0 16] = [0 3 6 -34 1 3 -8 -34 2 2 17 -31 3 2 -16 -31]
	[local16 8] = [2 5 25 -25 3 5 -25 -25]
	[local24 16] = [7 3 -20 -30 8 3 20 -30 1 2 -3 -7 0 2 3 -7]
	[local40 8] = [3 5 -3 -13 4 5 3 -13]
	local48
	local49
	local50
	local51
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	[local66 26] = [65 126 78 120 99 112 110 116 112 122 101 128 92 136 78 146 70 153 52 159 40 155 48 143 54 134]
)

(procedure (localproc_0)
	((ScriptID 380 4) y: (- ((ScriptID 380 4) y:) 100) z: 0) ; tFrisbee, tFrisbee
	(cond
		((InRect 0 15 50 100 (ScriptID 380 4)) ; tFrisbee
			(= local64 21)
			(= local65 74)
		)
		((InRect 51 8 110 104 (ScriptID 380 4)) ; tFrisbee
			(= local64 72)
			(= local65 67)
		)
		((InRect 111 8 160 105 (ScriptID 380 4)) ; tFrisbee
			(= local64 132)
			(= local65 78)
		)
		(else
			(= local64 193)
			(= local65 97)
		)
	)
	((ScriptID 380 4) y: (+ ((ScriptID 380 4) y:) 100) z: 100) ; tFrisbee, tFrisbee
)

(procedure (localproc_1)
	(if (== ((ScriptID gCurRoomNum 3) loop:) 1)
		((ScriptID gCurRoomNum 3) cel: 5)
	)
	((ScriptID gCurRoomNum 3)
		posn:
			[local66 (* ((ScriptID gCurRoomNum 3) cel:) 2)]
			[local66 (+ (* ((ScriptID gCurRoomNum 3) cel:) 2) 1)]
	)
)

(instance exchangeFrisbee of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= local48 [local40 (= temp0 (* (Random 0 1) 4))])
				(= local60 [local40 (+ temp0 1)])
				(= local52 (+ (gEgo x:) [local40 (+ temp0 2)]))
				(= local53 (+ (gEgo y:) [local40 (+ temp0 3)] 100))
				(= local50 [local24 (= temp0 (* (Random 0 3) 4))])
				(= local61 [local24 (+ temp0 1)])
				(= local54 (+ (gEgo x:) [local24 (+ temp0 2)]))
				(= local55 (+ (gEgo y:) [local24 (+ temp0 3)] 100))
				(= local51
					[local0
						(= temp0
							(*
								(+
									(if
										(>
											(gEgo x:)
											((ScriptID gCurRoomNum 3) x:)
										)
										0
									else
										1
									)
									(* (Random 0 1) 2)
								)
								4
							)
						)
					]
				)
				(= local63 [local0 (+ temp0 1)])
				(= local58 (+ ((ScriptID gCurRoomNum 3) x:) [local0 (+ temp0 2)]))
				(= local59
					(+ ((ScriptID gCurRoomNum 3) y:) [local0 (+ temp0 3)] 100)
				)
				(= local49
					[local16
						(= temp0
							(*
								(if (> (gEgo x:) ((ScriptID gCurRoomNum 3) x:))
									1
								else
									0
								)
								4
							)
						)
					]
				)
				(= local62 [local16 (+ temp0 1)])
				(= local56 (+ ((ScriptID gCurRoomNum 3) x:) [local16 (+ temp0 2)]))
				(= local57
					(+ ((ScriptID gCurRoomNum 3) y:) [local16 (+ temp0 3)] 100)
				)
				(ClearFlag 112)
				((ScriptID gCurRoomNum 3)
					setScript: 0
					setMotion: 0
					view: 390
					setLoop: local51
					cycleSpeed: 10
					cel: 0
				)
				(gEgo view: 383 setLoop: local48 cel: 0 cycleSpeed: 10)
				(gEgo setCycle: CT local60 1 self)
			)
			(1
				((ScriptID 380 4) ; tFrisbee
					startUpd:
					nsLeft: (- ((ScriptID 380 4) nsLeft:) 5) ; tFrisbee
					nsRight: (+ ((ScriptID 380 4) nsRight:) 5) ; tFrisbee
					nsTop: (+ ((ScriptID 380 4) nsTop:) 5) ; tFrisbee
					nsBottom: (- ((ScriptID 380 4) nsBottom:) 5) ; tFrisbee
					view: 391
					setLoop: (Random 0 7)
					z: 100
					setPri: 6
					ignoreActors: 1
					cel: 0
					setCycle: Fwd
					posn: local52 local53
					show:
					approachVerbs:
					setMotion: (ScriptID 380 7) local58 local59 self ; fJump
				)
				(gEgo setCycle: End)
			)
			(2
				(NormalEgo 2)
				((ScriptID gCurRoomNum 3) cel: 0 setCycle: CT local63 1 self)
			)
			(3
				((ScriptID 380 4) hide: setCycle: 0) ; tFrisbee
				((ScriptID gCurRoomNum 3) setCycle: End self)
			)
			(4
				(if (Random 0 1)
					((ScriptID gCurRoomNum 3)
						view: 397
						setLoop:
							(if (& ((ScriptID gCurRoomNum 3) loop:) $0001)
								1
							else
								0
							)
						cel: 0
					)
					(= register 4)
					((ScriptID gCurRoomNum 3) setCycle: CT 7 1 self)
				else
					(= register 2)
					(= ticks (++ state))
				)
			)
			(5
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gCurRoomNum 3) setCycle: End self)
			)
			(6
				(if (== register 4)
					((ScriptID gCurRoomNum 3) hide:)
				)
				(= seconds register)
			)
			(7
				((ScriptID gCurRoomNum 3)
					show:
					view: 397
					setLoop: local49
					cel: 0
					setCycle: CT local62 1 self
				)
			)
			(8
				(gUser canControl: 1 canInput: 1)
				(gTheIconBar enable: 2)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				((ScriptID 380 4) ; tFrisbee
					show:
					setLoop: (Random 0 7)
					posn: local56 local57
					setCycle: Fwd
					setMotion: MoveTo local54 local55 self
				)
				((ScriptID gCurRoomNum 3) setCycle: End)
			)
			(9
				(HandsOff)
				(if (IsFlag 112)
					(= global123 0)
					(= global122 0)
					(= global120 0)
					(= global121 0)
					(gEgo
						view: 383
						cycleSpeed: 10
						setLoop: local50
						cel: 0
						setCycle: CT local61 1 self
					)
				else
					(localproc_0)
					(if (< (gEgo x:) ((ScriptID 380 4) x:)) ; tFrisbee
						(= temp1 -13)
						(= temp2 4)
					else
						(= temp1 25)
						(= temp2 4)
					)
					(= global123 (+ local65 temp2))
					(= global122 (+ local64 temp1))
					(= global120 local64)
					(= global121 (+ local65 100))
					((ScriptID 380 4) ; tFrisbee
						approachX: (+ local64 temp1)
						approachY: (+ local65 temp2)
						setMotion: MoveTo local64 (+ local65 100) self
					)
				)
				(HandsOff)
			)
			(10
				(HandsOff)
				(if (IsFlag 112)
					(gEgo get: 15 setCycle: End self) ; frisbee
					((ScriptID 380 4) setCycle: 0 hide:) ; tFrisbee
				else
					(gSoundEffects number: 390 loop: 1 play:)
					((ScriptID 380 4) ; tFrisbee
						view: 380
						loop: 5
						cel: 0
						setPri: 1
						setCycle: 0
					)
					(= cycles 1)
				)
			)
			(11
				((ScriptID 380 4) stopUpd:) ; tFrisbee
				(self dispose:)
			)
		)
	)
)

(instance egoThrowFrisbee of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 61)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 15 380) ; frisbee
				(HandsOff)
				(gTheIconBar disable: 7)
				((ScriptID gCurRoomNum 3) setScript: 0)
				(LoadMany rsVIEW 383 397 390 391)
				(if (> (gEgo x:) 228)
					(gEgo setMotion: PolyPath 139 82 self)
				else
					(= cycles 1)
				)
			)
			(1
				(SetFlag 111)
				(if (<= 11 global247 14)
					(if (== ((ScriptID gCurRoomNum 3) loop:) 1)
						((ScriptID gCurRoomNum 3) loop: 0 cel: 5)
					)
					(= global248 ((ScriptID gCurRoomNum 3) cel:))
					(localproc_1)
					((ScriptID gCurRoomNum 3)
						view: 390
						z: 0
						cel: 0
						setCycle: 0
						setMotion: 0
						setScript: 0
					)
					(= ticks 1)
				else
					((ScriptID 2 0) init: 1 0 0 31 1) ; Delphineus, "Well, maybe just a couple more tosses, then I gotta go!"
					((ScriptID gCurRoomNum 3)
						setCycle: 0
						setScript: 0
						setMotion: MoveTo 94 109 self
					)
				)
				(++ global247)
			)
			(2
				(switch global247
					(12
						(SetScore 1 231)
					)
					(13
						(SetScore 1 232)
					)
					(14
						(SetScore 1 233)
					)
					(16
						(SetScore 1 234)
					)
					(17
						(SetScore 1 235)
					)
				)
				(self setScript: exchangeFrisbee self)
			)
			(3
				(NormalEgo 2)
				(if (<= global247 14)
					((ScriptID gCurRoomNum 3)
						setLoop: 0
						setScript: (ScriptID 380 11) ; dolphinSwimAbout
					)
				else
					(proc380_5)
					((ScriptID 380 6) seconds: 0) ; bugEgoScript
					((ScriptID gCurRoomNum 3) setScript: (ScriptID 380 6)) ; bugEgoScript
				)
				(= seconds 2)
			)
			(4
				(if
					(and
						(== client gCurRoom)
						(!= ((ScriptID gCurRoomNum 3) script:) (ScriptID 380 6)) ; bugEgoScript
					)
					(HandsOn)
					(gTheIconBar enable: 7)
				)
				(ClearFlag 111)
				(self dispose:)
			)
		)
	)
)

(instance gotIt of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 61)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable: 7)
				(SetScore 1 234)
				(LoadMany rsVIEW 396 383 397 390 391 386 385)
				((ScriptID gCurRoomNum 3) setScript: 0 setCycle: Fwd)
				(gEgo setMotion: PolyPath 29 76 self)
			)
			(1
				(localproc_1)
				(proc380_5)
				((ScriptID gCurRoomNum 3) setPri: 6 setMotion: MoveTo 81 152 self)
			)
			(2
				((ScriptID gCurRoomNum 3) setHeading: 90 self)
			)
			(3
				((ScriptID gCurRoomNum 3) setCycle: 0)
				(gEgo view: 383 loop: 4 cel: 0 setCycle: CT 5 1 self)
			)
			(4
				(gEgo setCycle: End)
				((ScriptID 380 4) ; tFrisbee
					startUpd:
					show:
					z: 0
					setPri: 15
					view: 391
					setLoop: 5
					setCycle: Fwd
					posn: 31 62
					setMotion: (ScriptID 380 7) 109 109 self ; fJump
				)
			)
			(5
				((ScriptID 380 4) setCycle: 0) ; tFrisbee
				(gLongSong number: 382 loop: 1 play:)
				((ScriptID gCurRoomNum 3)
					view: 395
					loop: 3
					cel: 0
					cycleSpeed: 10
					setCycle: CT 3 1 self
				)
			)
			(6
				((ScriptID 2 0) init: 1 0 0 1 1 self) ; Delphineus, "I got it!"
				(= ticks 1)
			)
			(7
				((ScriptID 380 1) ; junk
					view: 381
					loop: 7
					cel: 0
					setPri: 15
					posn: 29 44
					init:
				)
				(gLongSong number: 384 loop: -1 play:)
				((ScriptID 380 4) hide: setCycle: 0) ; tFrisbee
				((ScriptID gCurRoomNum 3) setCycle: CT 7 1 self)
			)
			(8
				(gSoundEffects number: 398 loop: 1 play:)
				((ScriptID gCurRoomNum 3) setCycle: End self)
			)
			(9
				(NormalEgo 4)
				(= seconds 3)
			)
			(10
				(UnLoad 128 395)
				((ScriptID 380 1) dispose:) ; junk
				(gEgo view: 383 loop: 6 cel: 0)
				((ScriptID gCurRoomNum 3)
					view: 397
					loop: 3
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(11
				((ScriptID 380 4) ; tFrisbee
					startUpd:
					show:
					posn: 63 129
					setCycle: Fwd
					setPri: 15
					setMotion: MoveTo 76 56 self
				)
			)
			(12
				(gEgo
					cycleSpeed: (+ (gEgo cycleSpeed:) 7)
					setCycle: CT 3 1 self
				)
			)
			(13
				((ScriptID 380 4) hide: setCycle: 0 setPri: -1) ; tFrisbee
				(gEgo setCycle: CT 7 1 self)
			)
			(14
				((ScriptID 380 4) stopUpd:) ; tFrisbee
				(gSoundEffects number: 398 loop: 1 play:)
				(gEgo setPri: -1 setCycle: End self)
			)
			(15
				(proc380_8)
				(gEgo hide: posn: 71 101 get: 15) ; frisbee
				(SetFlag 113)
				(proc380_5)
				((ScriptID gCurRoomNum 3)
					ignoreActors: 1
					setMotion: MoveTo 95 102 self
				)
			)
			(16
				(gEgo show:)
				(Face gEgo (ScriptID gCurRoomNum 3))
				(Face (ScriptID gCurRoomNum 3) gEgo self)
			)
			(17
				((ScriptID gCurRoomNum 3) setCycle: 0)
				(= cycles 1)
			)
			(18
				(gEgo hide:)
				(gEgo put: 15 360) ; frisbee
				((ScriptID gCurRoomNum 3) view: 385 loop: 3 cel: 0 posn: 94 102)
				((ScriptID 380 4) dispose:) ; tFrisbee
				(UnLoad 128 383)
				(UnLoad 128 397)
				(= seconds 3)
			)
			(19
				((ScriptID 2 1) init: 2 0 0 1 1 self) ; Adam, "Whuh? You talked!"
			)
			(20
				((ScriptID 2 0) init: 1 0 0 2 1 self) ; Delphineus, "Did I? Oh, uh, I guess I did...Er, I guess the hermit's out of the crab, so to speak! Allow me to introduce myself, Adam--"
			)
			(21
				((ScriptID 2 1) init: 2 0 0 2 1 self) ; Adam, "And you know my name?"
			)
			(22
				((ScriptID 2 0) init: 1 0 0 3 0 self) ; Delphineus, "Nothin' wrong with my hearing - above or under the water!"
			)
			(23
				((ScriptID 2 0) init: 1 0 0 4 1 self) ; Delphineus, "As I was trying to say, my name's Delphineus!"
			)
			(24
				((ScriptID 2 1) init: 2 0 0 3 1 self) ; Adam, "Del- er, what?"
			)
			(25
				((ScriptID 2 0) init: 1 0 0 5 1 self) ; Delphineus, "DEL- FIN- EEE- US. Got it?"
			)
			(26
				((ScriptID 2 1) init: 2 0 0 4 1 self) ; Adam, "Del-phin-e-us. Got it! Complicated name."
			)
			(27
				((ScriptID 2 0) init: 1 0 0 6 0 self) ; Delphineus, "Cetus, our Great Whale King named me. Of course it sounds different in our language, sort of like this --#&%--++(~."
			)
			(28
				((ScriptID 2 0) init: 1 0 0 7 0 self) ; Delphineus, "I believe your human scientists call that my 'signature whistle.'"
			)
			(29
				((ScriptID 2 0) init: 1 0 0 8 1 self) ; Delphineus, "I also speak tuna and some of the more obscure coral dialects! Those are too high-pitched for you to hear. Anyway, they're only useful in my kingdom."
			)
			(30
				((ScriptID 2 1) init: 2 0 0 5 1 self) ; Adam, "Cool! Your kingdom?"
			)
			(31
				((ScriptID 2 0) init: 1 0 0 9 1 self) ; Delphineus, "Right...My kingdom, it's...Oh no! My kingdom! Cetus!!! I remember now. I don't know what I've been thinking! How long have I been here?"
			)
			(32
				((ScriptID 2 1) init: 2 0 0 6 1 self) ; Adam, "About a week. You were in pretty bad shape--"
			)
			(33
				((ScriptID 2 0) init: 1 0 0 10 1 self) ; Delphineus, "A week! What a disaster! I've got to get out of here right away!"
			)
			(34
				((ScriptID 2 1) init: 2 0 0 7 1 self) ; Adam, "Hold on. I'm not getting this. What are you talking about? What's the matter?"
			)
			(35
				((ScriptID 2 0) init: 1 0 0 11 0 self) ; Delphineus, "That's me all over. Just rushing straight ahead, not looking where I'm going. That's how I got into this mess in the first place."
			)
			(36
				((ScriptID 2 0) init: 1 0 0 12 0 self) ; Delphineus, "When I ran into that net, it's because I was searching for Cetus. He's missing and I was sent to find him. Maybe he's in trouble, or hurt, or worse. I have to find out before it's too late."
			)
			(37
				((ScriptID 2 0) init: 1 0 0 13 1 self) ; Delphineus, "Adam, please help me get out of here!"
			)
			(38
				((ScriptID gCurRoomNum 3) cycleSpeed: 25 setCycle: End self)
			)
			(39
				((ScriptID 2 1) init: 3 0 0 14 1 self) ; Adam, "Of course I'll help you, Delphineus!"
			)
			(40
				(hugBackDrop init:)
				(egoEyes init:)
				(delphEyes init:)
				(= seconds 4)
			)
			(41
				(egoEyes setCycle: End self)
				(= seconds 4)
			)
			(42
				(delphEyes setCycle: End)
				(= seconds 4)
			)
			(43
				(hugBackDrop dispose:)
				(egoEyes dispose:)
				(delphEyes dispose:)
				(UnLoad 128 385)
				(= cycles 1)
			)
			(44
				((ScriptID gCurRoomNum 3) cycleSpeed: 25 setCycle: Beg self)
			)
			(45
				(proc380_5)
				((ScriptID gCurRoomNum 3) loop: 1)
				(gEgo show:)
				(= seconds 2)
			)
			(46
				(gEgo setMotion: PolyPath 69 100 self)
			)
			(47
				(gEgo
					view: 381
					loop: 0
					cel: 12
					posn: 84 83
					setPri: -1
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(48
				(NormalEgo 6)
				(ClearFlag 113)
				(gEgo setMotion: MoveTo 94 73 self)
			)
			(49
				(HandsOn)
				((ScriptID gCurRoomNum 3) setScript: (ScriptID 380 6)) ; bugEgoScript
				(UnLoad 128 381 385)
				(= global247 15)
				(gTheIconBar enable: 7)
				(self dispose:)
			)
		)
	)
)

(instance hugBackDrop of EcoView
	(properties
		x 72
		y 109
		view 385
		priority 13
		signal 16400
	)
)

(instance egoEyes of EcoProp
	(properties
		x 52
		y 67
		view 385
		loop 1
		priority 14
		signal 16400
	)
)

(instance delphEyes of EcoProp
	(properties
		x 80
		y 65
		view 385
		loop 2
		priority 14
		signal 16400
	)
)

