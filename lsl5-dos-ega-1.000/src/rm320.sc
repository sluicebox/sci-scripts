;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use n940)
(use RandCycle)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	cueCounter
	dreaming
	palNumber
	choice
)

(procedure (RetControl)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(HandsOn)
	(User canControl: 0)
	(gTheIconBar disable: 0)
)

(instance rm320 of LLRoom
	(properties
		picture 320
		style 7
	)

	(method (init)
		(if (== gPrevRoomNum 101)
			(switch
				(= choice
					(PrintD
						{Enter dream to debug:}
						106
						81
						{Dream of Athens}
						1
						106
						81
						{Wake up from Athens}
						5
						106
						81
						{Dream of Venice}
						2
						106
						81
						{Wake up from Venice}
						6
						106
						81
						{Dream of Taj Mahal}
						3
						106
						81
						{Wake up from Taj Mahal}
						7
						106
						81
						{Dream of Casablanca}
						4
					)
				)
				(1
					(= gREMState 0)
				)
				(2
					(= gREMState 1)
				)
				(3
					(= gREMState 2)
				)
				(4
					(= gREMState 3)
				)
				(5
					(= gPrevRoomNum 200)
					(= gREMState 0)
				)
				(6
					(= gPrevRoomNum 200)
					(= gREMState 1)
				)
				(7
					(= gPrevRoomNum 200)
					(= gREMState 2)
				)
			)
		)
		(chair init:)
		(floor init:)
		(super init:)
		(if (!= gPrevRoomNum 200)
			(gTheMusic number: 321 loop: -1 play:)
		)
		(cloud
			init:
			setStep: 1 1
			posn: 244 (Random 30 44)
			setMotion: MoveTo 63 (cloud y:) cloud
		)
		(switch gPrevRoomNum
			(200
				(Load rsSOUND 312)
				(= dreaming 1)
				(switch gREMState
					(0
						(larry init: setCel: 1 stopUpd:)
						(if (== gPattiDest 1)
							(= gREMState 1)
						else
							(= gREMState 2)
						)
						(Load rsSOUND 347)
						(self setScript: sWakeUpAthens)
					)
					(1
						(larry init: setCel: 1 stopUpd:)
						(if (and (IsFlag 28) (IsFlag 29))
							(= gREMState 3)
						else
							(= gREMState 2)
						)
						(self setScript: sWakeUpVenice)
					)
					(2
						(if (and (IsFlag 28) (IsFlag 29))
							(= gREMState 3)
						else
							(= gREMState 1)
						)
						(self setScript: sWakeUpTaj)
					)
				)
			)
			(else
				(Load rsVIEW 322)
				(larry init: stopUpd:)
				(body init: stopUpd:)
				(arm init: stopUpd:)
				(tray init: stopUpd:)
				(arm2 init: stopUpd:)
				(if (and (not (IsFlag 52)) (not (gEgo has: 9))) ; AeroDork_s_In-Flight_Magazine
					(theMagazine init:)
					(magazine init:)
				)
				(self setScript: sFlyingCoach)
			)
		)
		(HandsOff)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 320 0) ; "For the first game in your life, you are traveling First Class. You feel certain you could easily grow accustomed to such luxury. You kick back in the leather seat, relax, and find yourself growing rather sleepy."
				(if (and (not (IsFlag 52)) (not (gEgo has: 9))) ; AeroDork_s_In-Flight_Magazine
					(TPrint 320 1) ; "In fact, you feel too sleepy to even read the stupid "AeroDork In-Flight Magazine" in the seatback pocket in front of you."
				)
			)
			(5 ; Talk
				(TPrint 320 2) ; "You think about ordering a drink, but instead you find yourself growing sleepy."
			)
			(3 ; Do
				(TPrint 320 3) ; "There's nothing to do here in First Class--they have people to do things for you!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if dreaming
			(Palette palANIMATE palNumber (+ palNumber 7) 6)
		)
	)
)

(instance sFlyingCoach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(User canInput: 1)
				(Load rsSOUND 320)
				(switch gREMState
					(0
						(SetFFRoom 400)
						(Load rsVIEW 330)
						(Load rsVIEW 335)
						(Load rsVIEW 341)
						(Load rsPIC 330)
						(Load rsPIC 335)
						(Load rsPIC 340)
						(Load rsSOUND 330)
					)
					(1
						(SetFFRoom 600)
						(Load rsVIEW 350)
						(Load rsVIEW 351)
						(Load rsVIEW 321)
						(Load rsVIEW 356)
						(Load rsPIC 350)
						(Load rsPIC 355)
					)
					(2
						(SetFFRoom 800)
						(Load rsVIEW 370)
						(Load rsVIEW 371)
						(Load rsPIC 370)
						(Load rsSOUND 370)
					)
					(3
						(SetFFRoom 385)
						(Load rsVIEW 380)
						(Load rsPIC 380)
					)
				)
				(RetControl)
				(= seconds (Random 10 20))
			)
			(2
				(HandsOff)
				(larry setCel: 1)
				(gTheMusic number: 321 fade: 0 15 10 1)
				(gTheMusic2 number: 320 loop: -1 play: 10 fade: 127 15 5 0)
				(= seconds 3)
			)
			(3
				(larry addToPic: dispose:)
				(= seconds 2)
			)
			(4
				(dreamProp1 init: view: 322 setCel: 1 posn: 146 37)
				(= ticks 40)
			)
			(5
				(dreamProp1 setCel: 2 posn: 171 51)
				(= ticks 40)
			)
			(6
				(dreamProp1 setCel: 3 posn: 195 78)
				(gTheMusic2 fade: 0 15 5 1)
				(= ticks 60)
			)
			(7
				(switch gREMState
					(0
						(gTheMusic
							number: 330
							loop: 1
							play: 30
							fade: 127 15 10 0
						)
					)
					(1
						(gTheMusic
							number: 350
							loop: -1
							play: 30
							fade: 127 15 10 0
						)
					)
					(2
						(gTheMusic2
							number: 370
							loop: -1
							play: 30
							fade: 127 15 10 0
						)
					)
					(3
						(gTheMusic
							number: 381
							loop: -1
							play: 30
							fade: 127 15 10 0
						)
					)
				)
				(= ticks 40)
			)
			(8
				(dreamProp1 setCel: 4 posn: 201 122)
				(= ticks 30)
			)
			(9
				(= dreaming 1)
				(switch gREMState
					(0
						(self setScript: sDreamAthens)
					)
					(1
						(self setScript: sDreamVenice)
					)
					(2
						(self setScript: sDreamTaj)
					)
					(3
						(self setScript: sDreamCasa)
					)
				)
			)
		)
	)
)

(instance larry of Actor
	(properties
		x 134
		y 70
		description {your head}
		view 321
		loop 1
		priority 4
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 320 4) ; "You've hated airplane travel ever since "Leisure Suit Larry 2: Looking for Love (in Several Wrong Places).""
				(TPrint 320 5 67 -1 185) ; "(Another fine Al Lowe game.)"
			)
			(5 ; Talk
				(TPrint 320 6) ; "You briefly consider talking to yourself but then realize you already know what you were going to say!"
			)
			(3 ; Do
				(TPrint 320 7) ; "You tighten your seat belt and wish this flight were over."
				(TPrint 320 8 67 -1 185) ; "(Perhaps on this trip, you'll be able to get a little shut-eye.)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tray of Prop
	(properties
		x 202
		y 204
		z 100
		description {the tray}
		view 325
		loop 4
		priority 4
		signal 18448
	)

	(method (onMe theObj)
		(return (InRect 164 80 199 96 theObj))
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 320 9) ; "This tray sometimes holds your food."
			)
			(5 ; Talk
				(TPrint 320 10) ; "You consider eating some of that delicious airline food, but realize you are getting sleepy."
			)
			(3 ; Do
				(TPrint 320 11) ; "You could fold up the tray table but then you'd have no place to rest your stomach!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance arm of Prop
	(properties
		x 126
		y 79
		description {your arm}
		lookStr {You've always liked this arm.}
		view 321
		loop 2
		priority 5
		signal 18448
	)
)

(instance arm2 of Prop
	(properties
		x 173
		y 84
		description {your arm}
		lookStr {You've always liked this arm.}
		view 321
		loop 2
		cel 1
		priority 5
		signal 18448
	)
)

(instance body of Prop
	(properties
		x 165
		y 125
		description {your body}
		view 321
		priority 2
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 320 12) ; "What a body!"
				(TPrint 320 13 67 -1 185) ; "(You need!)"
			)
			(5 ; Talk
				(larry doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cloud of Actor
	(properties
		x 244
		y 44
		description {the cloud}
		view 320
		loop 1
		signal 18448
	)

	(method (cue)
		(switch (++ cueCounter)
			(1
				(Delay (Random 2 5) 0 self)
			)
			(2
				(= cueCounter 0)
				(cloud
					posn: 244 (Random 30 44)
					setMotion: MoveTo 63 (cloud y:) self
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 320 14) ; "Clouds drift lazily by outside your window, at about 650 miles per hour!"
			)
			(3 ; Do
				(TPrint 320 15) ; "You reach over and leave your fingerprints on the window, thus ruining the next amateur photographer's chances of getting a clear picture of the ground."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance patti of Prop
	(properties
		view 320
		priority 14
		signal 18448
	)
)

(instance dreamProp1 of Prop
	(properties
		view 320
		priority 14
		signal 18448
	)
)

(instance dreamProp2 of Prop
	(properties
		view 320
		priority 14
		signal 18448
	)
)

(instance dreamProp3 of Prop
	(properties
		view 320
		priority 14
		signal 18448
	)
)

(instance dreamProp4 of Prop
	(properties
		view 320
		priority 14
		signal 18448
	)
)

(instance dreamProp5 of Prop
	(properties
		view 320
		priority 14
		signal 18448
	)
)

(instance conf of Prop
	(properties
		x 181
		y 74
		view 340
		priority 14
		signal 18448
	)

	(method (cue)
		(super cue:)
		(switch (Random 1 10)
			(1
				(self
					show:
					setLoop: 0
					posn: 181 74
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(self
					show:
					setLoop: 0
					posn: 219 77
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(self
					show:
					setLoop: 0
					posn: 246 73
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(self
					show:
					setLoop: 1
					posn: 169 74
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(self
					show:
					setLoop: 1
					posn: 212 78
					setCel: 0
					setCycle: End self
				)
			)
			(6
				(self
					show:
					setLoop: 1
					posn: 227 65
					setCel: 0
					setCycle: End self
				)
			)
			(else
				(self hide:)
				(Delay (Random 2 6) 1 self)
			)
		)
	)
)

(instance sSqeezeNuts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 322 loop: 1 play: self)
				(arm setCycle: End)
				(arm2 setCycle: End)
			)
			(1
				(arm setCel: 0)
				(arm2 setCel: 0)
				(= ticks 30)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance magazine of View
	(properties
		x 208
		y 114
		description {the airline magazine}
		view 320
		priority 1
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 320 16) ; "There's a copy of AeroDork Airlines' complimentary magazine, "Fly the Dorky Skies.""
			)
			(3 ; Do
				(gEgo get: 9) ; AeroDork_s_In-Flight_Magazine
				(theMagazine dispose:)
				(Points 8)
				(TPrint 320 17) ; "You take the magazine because you never know when you might be having so much fun that you need something boring to read just to calm down."
				(magazine dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance MyForward of Fwd
	(properties)

	(method (cycleDone)
		(client cycleSpeed: (Random 6 10))
		(super cycleDone: &rest)
	)
)

(instance sDreamAthens of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (not state)
			(switch (gTheMusic prevSignal:)
				(10
					(gTheMusic prevSignal: 0)
					(patti setCycle: 0)
				)
				(-1
					(gTheMusic prevSignal: 0)
					(self cue:)
				)
			)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (and (not (IsFlag 52)) (not (gEgo has: 9))) ; AeroDork_s_In-Flight_Magazine
					(magazine dispose:)
				)
				(dreamProp1 dispose:)
				(body dispose:)
				(arm dispose:)
				(tray dispose:)
				(cloud dispose:)
				(arm2 dispose:)
				(patti
					init:
					view: 330
					posn: 172 125
					cycleSpeed: 10
					setCycle: RandCycle
				)
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= palNumber 40)
				(gCurRoom overlay: 330)
			)
			(1
				(= dreaming 0)
				(gCurRoom drawPic: (gCurRoom picture:))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(larry init: addToPic: dispose:)
				(= palNumber 40)
				(gCurRoom overlay: 335)
				(patti view: 335 posn: 213 88 setCycle: 0)
				(gTheMusic2 number: 331 loop: -1 play:)
				(= ticks 10)
			)
			(2
				(= dreaming 1)
				(= seconds 8)
			)
			(3
				(= dreaming 0)
				(gCurRoom drawPic: (gCurRoom picture:))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(larry init: addToPic: dispose:)
				(= palNumber 56)
				(gCurRoom overlay: 340)
				(patti
					view: 341
					setLoop: 0
					posn: 197 89
					setCel: 0
					setCycle: End
				)
				(conf init: setCycle: End conf)
				(= ticks 10)
			)
			(4
				(= dreaming 1)
				(dreamProp2 init: view: 341 setLoop: 3 setCel: 0 posn: 252 67)
				(= ticks 2)
			)
			(5
				(dreamProp2 setCel: 1 posn: 252 67)
				(= ticks 2)
			)
			(6
				(dreamProp2 setCel: 2 posn: 224 87)
				(= ticks 2)
			)
			(7
				(dreamProp2 setCel: 3 posn: 213 102 addToPic: dispose:)
				(= seconds 3)
			)
			(8
				(patti setCycle: Beg)
				(dreamProp3 init: view: 341 setLoop: 4 setCel: 3 posn: 163 63)
				(= ticks 2)
			)
			(9
				(dreamProp3 setCel: 4 posn: 169 70)
				(= ticks 2)
			)
			(10
				(dreamProp3 setCel: 5 posn: 177 78)
				(= ticks 2)
			)
			(11
				(dreamProp3 setCel: 6 posn: 184 88 addToPic: dispose:)
				(= seconds 3)
			)
			(12
				(patti setLoop: 1 setCel: 0 setCycle: End)
				(dreamProp4 init: view: 341 setLoop: 5 setCel: 3 posn: 205 69)
				(= ticks 2)
			)
			(13
				(dreamProp4 setCel: 4 posn: 215 78)
				(= ticks 2)
			)
			(14
				(dreamProp4 setCel: 5 posn: 230 91)
				(= ticks 2)
			)
			(15
				(dreamProp4 setCel: 6 posn: 236 103)
				(= seconds 2)
			)
			(16
				(patti setCycle: Beg)
				(conf dispose:)
				(= dreaming 0)
				(gTheMusic fade: 0 15 10 1)
				(gTheMusic2 fade: 0 15 10 1)
				(= seconds 2)
			)
			(17
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance sWakeUpAthens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFFRoom 310)
				(cloud hide:)
				(gCurRoom drawPic: (gCurRoom picture:))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= palNumber 56)
				(gCurRoom overlay: 345)
				(gTheMusic2 number: 345 loop: 1 play:)
				(dreamProp2
					init:
					view: 345
					posn: 168 118
					setPri: 13
					setLoop: 0
					signal: 18448
				)
				(dreamProp4
					init:
					view: 345
					setLoop: 1
					posn: 168 118
					cycleSpeed: 10
					setPri: 14
					setCel: -1
					signal: 18448
				)
				(patti
					init:
					view: 346
					posn: 209 140
					cycleSpeed: 8
					setPri: 13
					setLoop: 0
					setCel: -1
				)
				(dreamProp1
					init:
					view: 346
					setLoop: 2
					posn: 209 140
					setPri: 13
					setCel: -1
					signal: 18448
				)
				(= ticks 60)
			)
			(1
				(TPrint 320 18 67 -1 185 70 280) ; "During our absence, your dream of Passionate Patti's Parthenon performance progressed. The concert, a huge success, is now over; the critics have acclaimed her technique, interpretation, and mature musicianship; her promoter is arranging a one year tour; and the two of you take this opportunity to celebrate...."
				(dreamProp4 setLoop: 1 cycleSpeed: 10 setCycle: Fwd)
				(= seconds 2)
			)
			(2
				(= seconds 2)
			)
			(3
				(dreamProp2 cycleSpeed: 10 setCycle: End)
				(dreamProp4 setLoop: 2 cycleSpeed: 10 setCycle: End)
				(dreamProp3
					init:
					view: 346
					setLoop: 1
					posn: 208 104
					setPri: 14
					setCel: 0
					signal: 18448
				)
				(dreamProp1 cycleSpeed: 10 setPri: 13 setCycle: End self)
				(zipperSound play:)
			)
			(4
				(dreamProp4 setLoop: 3 cycleSpeed: 10 setCycle: End)
				(patti setCycle: End)
				(dreamProp1 hide:)
				(dreamProp3 setPri: 14 cycleSpeed: 10 setCycle: End self)
			)
			(5
				(dreamProp1
					view: 346
					setLoop: 3
					posn: 209 140
					setCel: -1
					setCycle: Fwd
					setPri: 14
					show:
				)
				(= cycles 30)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= dreaming 0)
				(gCurRoom drawPic: (gCurRoom picture:))
				(body init: stopUpd:)
				(tray init: stopUpd:)
				(if (and (not (IsFlag 52)) (not (gEgo has: 9))) ; AeroDork_s_In-Flight_Magazine
					(magazine init:)
				)
				(patti dispose:)
				(dreamProp1 dispose:)
				(dreamProp2 dispose:)
				(dreamProp3 dispose:)
				(dreamProp4 dispose:)
				(gTheMusic number: 321 loop: -1 play:)
				(gTheMusic2 number: 346 loop: 1 play: 60 fade: 127 15 10 0)
				(arm
					init:
					view: 323
					setLoop: 1
					posn: 122 86
					setPri: 14
					ignoreActors: 1
					cycleSpeed: 10
					setScript: sSqeezeNuts
				)
				(arm2
					init:
					view: 323
					setLoop: 0
					posn: 138 78
					setPri: 5
					cycleSpeed: 10
					ignoreActors: 1
				)
				(larry
					init:
					view: 321
					loop: 1
					setCel: 1
					posn: 135 72
					setPri: 4
					signal: 18448
				)
				(= seconds 3)
			)
			(7
				(TPrint 320 19 67 -1 15 70 280) ; "You awaken with a start to hear the stewardess say..."
				(larry view: 325 setLoop: 1)
				(TPrint 320 20 67 -1 185 80 {The Stewardess} 108 self) ; "Why, Mr. Laffer! Is there a problem with your nuts?"
				(arm setScript: 0)
			)
			(8
				(larry setCel: 1 cycleSpeed: 10 setCycle: CT 7 1 self)
			)
			(9
				(= seconds 7)
			)
			(10
				(arm view: 321 setLoop: 2 setCel: 0 posn: 126 79 setPri: 5)
				(arm2 view: 321 setLoop: 2 setCel: 1 posn: 173 84 setPri: 5)
				(gTheMusic2 stop:)
				(= seconds 2)
			)
			(11
				(TPrint 320 21 67 -1 185 70 280) ; "A voice crackles through the intercom speaker above your head, "Please tighten your seatbelts and return your tray tables to their fully upright and locked position. We'll be landing momentarily.""
				(gTheMusic fade: 0 15 10 1)
				(gTheMusic2 fade: 0 15 10 1)
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance sWakeUpVenice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFFRoom 310)
				(cloud hide:)
				(gCurRoom drawPic: (gCurRoom picture:))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= palNumber 56)
				(gCurRoom overlay: 355)
				(dreamProp2
					init:
					view: 356
					setLoop: 0
					posn: 187 126
					cycleSpeed: 10
					setCel: 255
					setPri: 14
					setCycle: Beg self
				)
				(gTheMusic number: 350 loop: -1 play: 60 fade: 127 15 10 0)
				(HandsOff)
			)
			(1
				(= ticks 60)
			)
			(2
				(TPrint 320 22 67 -1 15 70 280 108 self) ; "During our absence, your dream of you and Passionate Patti has progressed. You snuggle up together, drifting dreamily through the moonlit canals of Venice, the songs of other gondoliers wafting softly across the waters. Suddenly your gondola springs a most inopportune leak...."
			)
			(3
				(gTheMusic2 number: 352 loop: -1 play: 60 fade: 127 15 15 0)
				(= ticks 10)
			)
			(4
				(dreamProp1
					init:
					view: 355
					setLoop: 0
					setCycle: Fwd
					setPri: 14
					posn: 205 137
					signal: 18448
				)
				(= ticks 123)
			)
			(5
				(gTheMusic2 fade: 0 15 5 1 self)
			)
			(6
				(= dreaming 0)
				(gCurRoom drawPic: (gCurRoom picture:))
				(if (and (not (IsFlag 52)) (not (gEgo has: 9))) ; AeroDork_s_In-Flight_Magazine
					(magazine init:)
				)
				(cloud show:)
				(dreamProp1 dispose:)
				(dreamProp2 dispose:)
				(gTheMusic number: 321 loop: -1 play:)
				(gTheMusic2 number: 346 loop: 1 play: 60 fade: 127 15 10 0)
				(body
					init:
					view: 325
					loop: 0
					setCel: 0
					posn: 165 124
					setPri: 4
					stopUpd:
				)
				(arm
					init:
					view: 324
					setLoop: 0
					setCel: 2
					posn: 147 105
					setPri: 8
				)
				(arm2
					init:
					view: 324
					setLoop: 1
					setCel: 0
					posn: 169 82
					setPri: 6
				)
				(larry setPri: 5 startUpd:)
				(= ticks 10)
			)
			(7
				(arm2 cycleSpeed: 10 setCycle: End self)
			)
			(8
				(larry view: 324 setLoop: 0 setCel: 0 posn: 139 72)
				(= seconds 3)
			)
			(9
				(larry
					view: 325
					loop: 1
					setCel: 5
					posn: 134 70
					cycleSpeed: 17
					setCycle: CT 7 1 self
				)
			)
			(10
				(= seconds 3)
			)
			(11
				(TPrint 320 23 67 -1 15 70 280 108 self) ; "Awakening from your dream, you realize you just filled your lap with complimentary beverage!"
			)
			(12
				(= ticks 30)
			)
			(13
				(TPrint 320 21 67 -1 185 70 280) ; "A voice crackles through the intercom speaker above your head, "Please tighten your seatbelts and return your tray tables to their fully upright and locked position. We'll be landing momentarily.""
				(gTheMusic fade: 0 15 10 1)
				(gTheMusic2 fade: 0 15 10 1)
				(= seconds 2)
			)
			(14
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance sDreamTaj of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (and (not (IsFlag 52)) (not (gEgo has: 9))) ; AeroDork_s_In-Flight_Magazine
					(magazine dispose:)
				)
				(body dispose:)
				(arm dispose:)
				(tray dispose:)
				(cloud dispose:)
				(arm2 dispose:)
				(dreamProp1
					view: 370
					setLoop: 0
					setCycle: RandCycle
					posn: 72 122
					cycleSpeed: 8
					signal: 18448
				)
				(dreamProp2
					init:
					view: 370
					setLoop: 2
					posn: 155 80
					cycleSpeed: 3
					setCycle: RandCycle
				)
				(dreamProp3
					init:
					view: 370
					setLoop: 1
					setCycle: RandCycle
					cycleSpeed: 8
					posn: 236 112
				)
				(dreamProp4
					init:
					view: 370
					setLoop: 3
					setCycle: RandCycle
					cycleSpeed: 6
					posn: 126 88
				)
				(dreamProp5
					init:
					view: 370
					setLoop: 4
					setCycle: RandCycle
					cycleSpeed: 6
					posn: 193 94
				)
				(patti
					init:
					view: 371
					posn: 166 151
					setLoop: 0
					setCycle: Fwd
					cycleSpeed: 8
					setScript: sPlayGuitar
				)
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= palNumber 56)
				(gCurRoom overlay: 370)
				(= seconds 3)
			)
			(1
				(TPrint 320 24 108 self 67 -1 15 70 280) ; "In your dream, you are watching Passionate Patti perform a rock concert before the reflecting pool of the Taj Mahal! What a great musician! What a romantic setting! What a gorgeous babe!!"
			)
			(2
				(= ticks 90)
			)
			(3
				(gTheMusic fade: 0 15 10 1)
				(gTheMusic2 fade: 0 15 10 1)
				(= seconds 3)
			)
			(4
				(= dreaming 0)
				(= cycles 2)
			)
			(5
				(gCurRoom newRoom: 800)
			)
		)
	)
)

(instance sWakeUpTaj of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(SetFFRoom 310)
				(cloud hide:)
				(gCurRoom drawPic: (gCurRoom picture:))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= palNumber 56)
				(gCurRoom overlay: 375)
				(dreamProp1
					init:
					view: 376
					setLoop: 0
					setCel: 0
					posn: 170 137
					setPri: 14
					cycleSpeed: 10
				)
				(larry
					init:
					view: 376
					setLoop: 2
					posn: 170 137
					cycleSpeed: 10
					setPri: 13
					stopUpd:
				)
				(dreamProp2 init: view: 375 setLoop: 0 posn: 197 141 setPri: 15)
				(patti
					init:
					view: 377
					setLoop: 0
					posn: 226 135
					setPri: 14
					cycleSpeed: 10
				)
				(= ticks 10)
			)
			(1
				(HandsOff)
				(TPrint 320 25 67 -1 15 70 280) ; "During our absence, your dream of Passionate Patti's Taj Mahal concert has progressed. Late at night, the gig over, the amps and drums packed in the road cases, it's now time for just the two of you, relaxing together on a couple of overstuffed cushions, emotionally drained. To calm herself, and prepare you for the evening ahead, Patti plays a little selection on her oboe...."
				(gTheMusic2 number: 375 loop: -1 play:)
				(patti cycleSpeed: 10 setCycle: Fwd)
				(dreamProp2 cycleSpeed: 10 setCel: 0 setCycle: End self)
			)
			(2
				(dreamProp2 setLoop: 1 setCycle: MyForward)
				(= seconds 3)
			)
			(3
				(dreamProp1 setCel: 0 setCycle: End self)
			)
			(4
				(dreamProp1 setLoop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(TPrint 320 26 67 -1 15 70 280 108) ; "You soon realize the snake is not the only thing Patti has charmed!"
				(gTheMusic2 fade: 0 15 12 1)
				(= seconds 4)
			)
			(6
				(= dreaming 0)
				(gCurRoom drawPic: (gCurRoom picture:))
				(body init: stopUpd:)
				(arm init:)
				(tray init:)
				(if (and (not (IsFlag 52)) (not (gEgo has: 9))) ; AeroDork_s_In-Flight_Magazine
					(magazine init:)
				)
				(dreamProp1 dispose:)
				(dreamProp2 dispose:)
				(patti dispose:)
				(gTheMusic number: 321 loop: -1 play:)
				(gTheMusic2 number: 346 loop: 1 play: 60 fade: 127 15 10 0)
				(cloud show:)
				(tray init: cycleSpeed: 10 setCycle: End self)
				(larry init: view: 325 posn: 136 68 setLoop: 1 setCel: 0)
				(body init: view: 325 setLoop: 0 setCel: 0 stopUpd:)
				(arm
					init:
					view: 325
					setLoop: 2
					setCel: 1
					posn: 132 76
					setPri: 6
				)
				(arm2
					init:
					view: 325
					setLoop: 3
					setCel: 1
					setPri: 6
					posn: 183 56
				)
			)
			(7
				(larry setCel: 1 cycleSpeed: 10 setCycle: CT 5 1 self)
			)
			(8
				(larry setCel: 6 posn: 144 66)
				(body setCel: 1)
				(arm setCel: 2 posn: 129 78)
				(arm2 setCel: 2 posn: 170 60)
				(= ticks 30)
			)
			(9
				(arm setCel: 3 posn: 129 75)
				(larry setCel: 7 posn: 152 61)
				(body setCel: 2)
				(= seconds 3)
			)
			(10
				(TPrint 320 21 67 -1 185 70 280) ; "A voice crackles through the intercom speaker above your head, "Please tighten your seatbelts and return your tray tables to their fully upright and locked position. We'll be landing momentarily.""
				(TPrint 320 27 67 -1 185 70 280) ; "You hope none of the other passengers notices that your tray table is already up!"
				(gTheMusic fade: 0 15 10 1)
				(gTheMusic2 fade: 0 15 10 1)
				(= seconds 3)
			)
			(11
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance sDreamVenice of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (and (not (IsFlag 52)) (not (gEgo has: 9))) ; AeroDork_s_In-Flight_Magazine
					(magazine dispose:)
				)
				(body dispose:)
				(arm dispose:)
				(tray dispose:)
				(cloud dispose:)
				(arm2 dispose:)
				(dreamProp1
					view: 350
					setLoop: 0
					posn: 216 93
					setPri: 12
					setCycle: Fwd
					cycleSpeed: 10
					signal: 18448
				)
				(dreamProp2
					init:
					view: 350
					setLoop: 1
					posn: 209 135
					setCycle: Fwd
					cycleSpeed: 10
					setPri: 12
					signal: 18448
				)
				(larry
					init:
					view: 351
					setLoop: 0
					setCel: 0
					posn: 297 77
					setPri: 13
					signal: 18448
				)
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= palNumber 56)
				(gCurRoom overlay: 350)
				(= ticks 30)
			)
			(1
				(TPrint 320 28 67 -1 185 70 280) ; "Ah, this is the life! In your dream, you are the handsome gondolier, poling through the canals of Venice with your lone, lovely female customer: Passionate Patti! Everything is going well until..."
				(larry
					cycleSpeed: 8
					moveSpeed: 12
					setCycle: Fwd
					setMotion: MoveTo 285 83 self
				)
			)
			(2
				(larry setMotion: MoveTo 266 90 self)
			)
			(3
				(larry setMotion: MoveTo 255 96 self)
			)
			(4
				(larry setCel: 0)
				(= cycles 2)
			)
			(5
				(TPrint 320 29 67 -1 28) ; "...you stick it in too deeply."
				(TPrint 320 30 67 -1 185) ; "(An experience wholly unfamiliar to you!)"
				(larry setLoop: 1 setCel: 0)
				(= ticks 30)
			)
			(6
				(gTheMusic2 number: 351 loop: 1 play:)
				(larry setCel: 1)
				(dreamProp3 init: view: 351 setPri: 14 setLoop: 2 posn: 241 98)
				(= cycles 2)
			)
			(7
				(larry
					cycleSpeed: 20
					setCycle: End
					setMotion: MoveTo 145 143 self
				)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(dreamProp1 dispose:)
				(dreamProp2 dispose:)
				(patti dispose:)
				(gCurRoom drawPic: (gCurRoom picture:))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= palNumber 56)
				(larry
					setMotion: 0
					view: 321
					setLoop: 1
					setCel: 1
					posn: 134 70
					setPri: 4
					addToPic:
					dispose:
				)
				(gCurRoom overlay: 355)
				(dreamProp3
					init:
					view: 356
					setLoop: 0
					posn: 187 126
					cycleSpeed: 10
					setCel: 0
					setCycle: End self
				)
			)
			(9
				(TPrint 320 31 67 -1 15 70 280) ; "Deciding to seize the moment, you wriggle down beside your Patti, relying on the subtle canal currents to propel you through your night of love..."
				(= ticks 30)
			)
			(10
				(= dreaming 0)
				(gTheMusic fade: 0 15 10 1)
				(gTheMusic2 fade: 0 15 10 1)
				(= seconds 2)
			)
			(11
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance theMagazine of Feature
	(properties
		x 206
		y 202
		z 100
		nsTop 92
		nsLeft 196
		nsBottom 112
		nsRight 216
		description {the magazine}
		sightAngle 40
	)

	(method (doVerb)
		(magazine doVerb: &rest)
	)
)

(instance sDreamCasa of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (and (not (IsFlag 52)) (not (gEgo has: 9))) ; AeroDork_s_In-Flight_Magazine
					(magazine dispose:)
				)
				(body dispose:)
				(arm dispose:)
				(tray dispose:)
				(cloud dispose:)
				(arm2 dispose:)
				(gTheMusic2 number: 380 loop: -1 play:)
				(dreamProp1
					init:
					view: 380
					setLoop: 0
					posn: 228 47
					setPri: 14
					show:
					addToPic:
				)
				(dreamProp2
					init:
					view: 380
					setLoop: 1
					posn: 267 49
					setPri: 14
					show:
					addToPic:
				)
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= palNumber 56)
				(gCurRoom overlay: 380)
				(= seconds 4)
			)
			(1
				(Say Leisure_Suit_Bogie 320 32 108 139 self) ; "It's not hard to see, Patti, the problems of two little people don't amount to a hill of beans in this crazy mixed-up world..."
			)
			(2
				(= seconds 3)
			)
			(3
				(Say Ingrid_Patti 320 33 108 139 self) ; "Larry, in all the scenes, in all the games, in all the world... you had to walk into mine!"
			)
			(4
				(= seconds 3)
			)
			(5
				(Say Ingrid_Patti 320 34 108 139 self) ; "Remember Larry: we'll always have Nontoonyt!"
			)
			(6
				(= seconds 3)
			)
			(7
				(Say Leisure_Suit_Bogie 320 35 108 139 self) ; "Here's looking at you, kid!"
			)
			(8
				(gTheMusic fade: 0 15 10 1)
				(= dreaming 0)
				(= ticks 10)
			)
			(9
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance Leisure_Suit_Bogie of Talker
	(properties
		name {Leisure Suit Bogie}
		x 1
		y 180
		nsTop 83
		nsLeft 125
		view 1381
		loop 1
		talkWidth 180
	)

	(method (init)
		(= mouth hisMouth)
		(super init:)
	)
)

(instance hisMouth of Prop
	(properties
		view 1381
	)
)

(instance Ingrid_Patti of Talker
	(properties
		name {Ingrid Patti}
		x 140
		y 180
		nsTop 82
		nsLeft 169
		view 1382
		loop 1
		talkWidth 180
	)

	(method (init)
		(= mouth herMouth)
		(super init:)
	)
)

(instance herMouth of Prop
	(properties
		view 1382
	)
)

(instance theMusic3 of Sound
	(properties
		number 322
	)
)

(instance zipperSound of Sound
	(properties
		number 347
	)
)

(instance sPlayGuitar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dreamProp1 cycleSpeed: (Random 3 8))
				(dreamProp2 cycleSpeed: (Random 3 8))
				(dreamProp3 cycleSpeed: (Random 3 8))
				(dreamProp4 cycleSpeed: (Random 3 8))
				(dreamProp5 cycleSpeed: (Random 3 8))
				(patti setLoop: 0 cycleSpeed: (Random 3 8) setCycle: Fwd)
				(= ticks (Random 20 40))
			)
			(1
				(patti setLoop: 1 cycleSpeed: (Random 3 8) setCycle: End self)
			)
			(2
				(patti setLoop: 2 cycleSpeed: (Random 3 8) setCycle: Fwd)
				(= ticks (Random 20 40))
			)
			(3
				(patti setLoop: 1 cycleSpeed: (Random 3 8) setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 129
		y 295
		z 100
		nsTop 51
		nsLeft 65
		nsBottom 140
		nsRight 194
		description {the seat}
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 320 4) ; "You've hated airplane travel ever since "Leisure Suit Larry 2: Looking for Love (in Several Wrong Places).""
				(TPrint 320 5 67 -1 185) ; "(Another fine Al Lowe game.)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance floor of Feature
	(properties
		x 176
		y 245
		z 100
		nsTop 107
		nsLeft 108
		nsBottom 183
		nsRight 245
		description {the floor}
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 320 4) ; "You've hated airplane travel ever since "Leisure Suit Larry 2: Looking for Love (in Several Wrong Places).""
				(TPrint 320 5 67 -1 185) ; "(Another fine Al Lowe game.)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

