;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4350)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use OogaBooga)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4350 0
	catTalk 1
	digTalk 2
	boogeyTalk 3
)

(local
	local0
	local1
	local2
	local3
)

(instance rm4350 of KQRoom
	(properties
		picture 4350
		horizon 74
		north 4101
		east 4400
		eastSide 330
	)

	(method (dispose)
		(killTimer client: 0 dispose: delete:)
		(ClearFlag 192)
		((ScriptID 19 2) nsBottom: local2 nsLeft: 0 nsRight: 289) ; northFeat
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(local3 0)
			((> (gEgo x:) 318)
				(= local3 1)
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 350 (gEgo y:) self)
			)
			((< (gEgo y:) (+ horizon 13))
				(gGame handsOff:)
				(= local3 2)
				(gEgo setMotion: MoveTo (gEgo x:) horizon self)
			)
		)
	)

	(method (init)
		(= local2 ((ScriptID 19 2) nsBottom:)) ; northFeat
		((ScriptID 19 2) nsBottom: horizon nsLeft: 170 nsRight: 320) ; northFeat
		(super init:)
		(= eastSide 330)
		(if (== gChapter 5)
			(ClearFlag 172)
		)
		(SetFlag 192)
		(= local0 (Random 0 1))
		(cond
			((and (not (IsFlag 5)) (== gPrevRoomNum 4500))
				(gKqMusic1 fade: 0 4 2 1)
			)
			((!= (gKqMusic1 number:) 4400)
				(gKqMusic1 number: 4400 setLoop: -1 play:)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 236 63 214 57 192 83 122 92 77 103 41 97 27 88 6 101 85 137 244 140 320 109 340 109 340 95 320 95 283 95 236 99 227 73
					yourself:
				)
		)
		(Load rsMESSAGE 4350)
		(if (IsFlag 172)
			(hole init:)
			(= local0 0)
		)
		(branch init:)
		(deadFall init:)
		(switch gPrevRoomNum
			(4500
				(if (IsFlag 5)
					(gEgo posn: 160 110 setHeading: 270 normalize: init:)
				else
					(self setScript: deathFromBelow)
				)
			)
			(4400
				(gEgo
					posn: 318 110
					setHeading: 270
					normalize:
					init:
					setMotion: PolyPath 290 110
				)
			)
			(4101
				(gEgo
					posn: 227 (+ horizon 14)
					setHeading: 180
					normalize:
					init:
					setMotion: PolyPath 227 100
				)
			)
			(else
				(gEgo
					posn: 317 110
					normalize:
					init:
					setMotion: PolyPath 290 110
				)
			)
		)
		(cond
			((and (not (IsFlag 215)) (== gChapter 5) (not (IsFlag 203)))
				(SetFlag 215)
				(blackCat init:)
				(self setScript: chap5Open)
			)
			((not script)
				(gGame handsOn:)
			)
		)
		(gEgo setScaler: Scaler 100 75 135 65)
		(if (and local0 (or (!= gChapter 4) (not (IsFlag 151))))
			(killTimer setReal: killTimer 15)
		)
		(if (IsFlag 5)
			(ClearFlag 5)
		)
	)

	(method (cue)
		(switch local3
			(1
				(self newRoom: 4400)
			)
			(2
				(self newRoom: 4101)
			)
		)
	)

	(method (notify)
		(if (not script)
			(cond
				((>= global374 2)
					(self setScript: (ScriptID 4001 1)) ; wakeTheDead
				)
				(local0
					(self setScript: crawlOut 0 1)
				)
				(else
					(self setScript: digTheHole)
				)
			)
		)
	)
)

(instance chap5Open of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(deadFall setHotspot: 0)
				(blackCat setCycle: CT 6 1 self)
				(gEgo setMotion: PolyPath 118 121)
			)
			(1
				(blackCat
					fixPriority: 1
					signal: (| (blackCat signal:) $1000)
					priority: 80
					setCycle: CT 25 1 self
				)
			)
			(2
				(blackCat fixPriority: 0 setCycle: End self)
			)
			(3
				(if (gEgo mover:)
					(-- state)
					(= cycles 1)
				else
					(gEgo setHeading: 315 self)
				)
			)
			(4
				(catTalk view: 4360 loop: 20 client: blackCat)
				(gMessager say: 0 0 4 1 self) ; "My lady, are you Valanice of Daventry?"
			)
			(5
				(gEgo view: 8345 loop: 1 cel: 0 setCycle: End self)
				(gMessager say: 0 0 4 2 self) ; "(SURPRISED)Why, yes! How did you know...?"
			)
			(6)
			(7
				(gEgo setCycle: Beg self)
				(gMessager say: 0 0 4 3 self) ; "(URGENTLY)Listen carefully. Your daughter has left this land. She is in dire trouble in the bowels of the great volcano...but that is not the worst of it. The volcano will soon erupt, and then all will be lost, including your daughter."
			)
			(8)
			(9
				(gEgo view: 8265 loop: 1 cel: 0 setCycle: End self)
				(gMessager say: 0 0 4 4 self) ; "(ANGRY AND SCARED)What? We can't just stand by and do nothing!"
			)
			(10)
			(11
				(gEgo setCycle: Beg self)
				(gMessager say: 0 0 4 5 self) ; "(EMPHATICALLY)Seek help from the Kingdom of Etheria, Valanice. They have to power to break the enchantment. You must!"
			)
			(12)
			(13
				(gEgo normalize:)
				(gMessager say: 3 8 5 0 self) ; "(HOPEFUL)Where is this Etheria? How can I get there?"
			)
			(14
				(blackCat
					x: 76
					y: 100
					view: 4361
					loop: 0
					cel: 0
					setCycle: CT 59 1 self
				)
				(= ticks 120)
			)
			(15
				(gEgo setHeading: 0 self)
			)
			(16)
			(17
				(blackCat setPri: 0 setCycle: End self)
			)
			(18
				(deadFall setHotspot: 8 10) ; Do, Exit
				(gGame handsOn:)
				(blackCat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance crawlOut of Script
	(properties)

	(method (doit)
		(if (and (< (gEgo x:) 120) (gEgo mover:))
			(gEgo setMotion: 0)
			(gGame handsOff:)
		)
		(super doit:)
	)

	(method (dispose)
		(ClearFlag 338)
		(gEgo enableHotspot:)
		(if (gEgo has: 53) ; Magic_Wand
			((gInventory at: 53) addRespondVerb: 74) ; Magic_Wand, Scarab
			((gInventory at: 55) addRespondVerb: 69) ; Scarab, Magic_Wand
		)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(deadFall setHotspot: 0)
				(if (gEgo has: 53) ; Magic_Wand
					((gInventory at: 53) deleteHotVerb: 74) ; Magic_Wand, Scarab
					((gInventory at: 55) deleteHotVerb: 69) ; Scarab, Magic_Wand
				)
				(gEgo disableHotspot:)
				(if register
					(gGame handsOff:)
					(if (> (gEgo x:) 165)
						(gEgo setMotion: PolyPath 150 120 self)
					else
						(= cycles 1)
					)
				else
					(self changeState: 6)
				)
			)
			(1
				(Load rsVIEW 4355)
				(Load rsSOUND 4358)
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 4355)
				(gEgo setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(sfx number: 4358 loop: 1 play: self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: 0)
				(= cycles 2)
			)
			(6
				(deadFall hide:)
				(boogey loop: 0 cel: 0 init: setCycle: CT 9 1 self)
				(sfx2 number: 4355 setLoop: 1 setVol: 0 play: fade: 127 4 2 0)
				(sfx number: 4357 setLoop: 1 play:)
			)
			(7
				(deadFall view: 4358 loop: 1 cel: 0 x: 64 y: 93 setPri: 0 show:)
				(boogey setCycle: End self)
			)
			(8
				(if (not register)
					(gGame handsOff:)
				)
				(gEgo setMotion: 0)
				(proc11_3 gEgo boogey self)
			)
			(9
				(if (== (gEgo loop:) (- (NumLoops gEgo) 1))
					(= temp0 (gEgo cel:))
				else
					(= temp0 (gEgo loop:))
				)
				(switch temp0
					(0
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8681 loop: 0)
						else
							(gEgo view: 8341 loop: 0)
						)
					)
					(1
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8681 loop: 1)
						else
							(gEgo view: 8341 loop: 1)
						)
					)
					(2
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8682 loop: 0)
						else
							(gEgo view: 8342 loop: 0)
						)
					)
					(3
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8683 loop: 0)
						else
							(gEgo view: 8343 loop: 0)
						)
					)
					(4
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8684 loop: 0)
						else
							(gEgo view: 8344 loop: 0)
						)
					)
					(5
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8684 loop: 1)
						else
							(gEgo view: 8344 loop: 1)
						)
					)
					(6
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8685 loop: 0)
						else
							(gEgo view: 8345 loop: 0)
						)
					)
					(7
						(if (== gValOrRoz -3) ; Roz
							(gEgo view: 8685 loop: 1)
						else
							(gEgo view: 8345 loop: 1)
						)
					)
				)
				(gEgo cel: 0 setCycle: End self)
				(sfx number: 4402 setLoop: 1 play:)
			)
			(10
				(if register
					(gMessager say: 1 65 1 0 self) ; "(DROOLY AND DISGUSTING)Thanks for calling me to dinner, toots!"
				else
					(self cue:)
				)
			)
			(11
				(boogey loop: 1 cel: 0 setCycle: End self)
			)
			(12
				(gEgo setCycle: Beg self)
			)
			(13
				(gEgo normalize:)
				(if (not register)
					(gGame handsOn:)
					(= seconds 15)
					(= scratch 1)
				else
					(self cue:)
				)
			)
			(14
				(= register 0)
				(self setScript: pounceScript self)
			)
			(15
				(boogey view: 4351 loop: 0 cel: 0 x: 74 y: 101 dispose:)
				(deadFall
					view: 4359
					loop: 0
					cel: 0
					x: 61
					y: 88
					setHotspot: 8 10 ; Do, Exit
				)
				(gEgo show:)
				(killTimer setReal: killTimer 15)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance pounceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(boogey view: 43510 loop: 0 cel: 0 setCycle: End self)
				(sfx
					number:
						(switch (Random 0 2)
							(0 4353)
							(1 4501)
							(2 4502)
						)
					setLoop: 1
					play:
				)
				(gEgo
					setMotion: 0
					setHeading:
						(GetAngle
							(gEgo x:)
							(gEgo y:)
							(boogey x:)
							(boogey y:)
						)
				)
				(= ticks 60)
			)
			(1
				(sfx2 number: 4354 setLoop: 1 play:)
			)
			(2
				(boogey
					x: (gEgo x:)
					y: (gEgo y:)
					setPri: (- (gEgo priority:) 1)
					loop: (+ (boogey loop:) 2)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(sfx number: 4402 setLoop: 1 play:)
				(gEgo hide:)
				(if (== gValOrRoz -3) ; Roz
					(boogey
						view: 43512
						loop: (if (== (boogey loop:) 2) 0 else 1)
						cel: 0
						setCycle: End self
					)
				else
					(boogey
						view: 43511
						loop: (if (== (boogey loop:) 2) 0 else 1)
						cel: 0
						setCycle: End self
					)
				)
			)
			(4
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 19 self)
				else
					(EgoDead 57 self)
				)
			)
			(5
				(deadFall setPri: -1 init:)
				(ClearFlag 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance deathFromBelow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gKqSound1 number: 908 setLoop: 1 play:)
				((= register (Prop new:))
					view: 4358
					loop: 0
					cel: 0
					x: 78
					y: 93
					setPri: 0
					init:
					setCycle: End self
				)
				(deadFall setPri: 1)
			)
			(1
				(gKqSound1 number: 4351 setLoop: 1 play:)
				(gKqMusic1 number: 5316 setLoop: 1 play: self)
				(deadFall setCycle: End self)
			)
			(2
				(gKqSound1 stop:)
			)
			(3
				(gMessager say: 0 0 3 0 self) ; "(MUFFLED; VOICE COMING FROM FAR UNDER THE GROUND)Nooooooooo!"
			)
			(4
				(ClearFlag 172)
				(gCurRoom newRoom: 4700)
			)
		)
	)
)

(instance digTheHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: diggerComes self)
			)
			(1
				(gMessager say: 1 65 2 1 self) ; "(NERVOUS)Where exactly do you want me to dig?"
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(gMessager say: 1 65 2 2 self) ; "Right there."
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gEgo view: 4355 loop: 6 cel: 0 setCycle: End self)
			)
			(4)
			(5
				(gMessager say: 1 65 2 3 self) ; "(REALLY WORRIED)Oh, geez, lady. Are you sure? Are you positive?"
				(gEgo setCycle: Beg self)
			)
			(6)
			(7
				(gEgo normalize: setMotion: PolyPath 269 108 self)
			)
			(8
				(gEgo setHeading: 45 self)
			)
			(9
				(gMessager say: 1 65 2 4 self) ; "Yup."
			)
			(10
				(gEgo view: 4355 loop: 5 cel: 0 setCycle: CT 3 1 self)
			)
			(11
				(gEgo view: 4355 loop: 5 cel: 3 setCycle: End self)
				(sTink number: 2616 loop: 1 play:)
			)
			(12
				(gMessager say: 1 65 2 5 self) ; "All right, if you insist. Stand back, Miss."
			)
			(13
				(sfx number: 4092 loop: -1 play:)
				(register setCycle: Fwd setMotion: MoveTo 85 103 self)
				(gEgo normalize: setMotion: PolyPath 200 140 self)
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
			)
			(14
				(if (not (gEgo mover:))
					(gEgo setHeading: 315)
				)
			)
			(15
				(if (!= (gEgo heading:) 315)
					(gEgo setHeading: 315)
				)
				(register loop: 2 cel: 0 x: 171 y: 109 setCycle: End self)
			)
			(16
				(register loop: 3 cel: 0 setCycle: Fwd)
				(deadFall
					view: 4358
					loop: 1
					cel: 0
					x: 64
					y: 93
					setHotspot: 0
					_approachVerbs: 0
					setPri: 0
				)
				(sfx setVol: 64)
				(gKqSound1 number: 4351 setLoop: 1 play: self)
			)
			(17
				(sfx setVol: 127)
				(register loop: 2)
				(register cel: (register lastCel:) setCycle: Beg self)
			)
			(18
				(gMessager say: 1 65 2 6 self) ; "(SHOUTING OVER THE NOISE OF THE MACHINE)There you go. I really don't advise you go down there, Miss. I'm out of here!"
				(register
					setLoop: 1 1
					x: 85
					y: 103
					setCycle: Rev
					setMotion: MoveTo 319 103 self
				)
			)
			(19)
			(20
				(gEgo put: 49) ; Grave_Digger_s_Horn
				(gKqMusic1 fade: 127 10 2 0)
				(sfx fade: 0 10 2 1)
				(sfx2 fade: 0 10 2 1)
				(hole init:)
				(register dispose:)
				(SetFlag 172)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fallIntoHole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 60 90 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 4357 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 4500)
				(= cycles 1)
			)
			(4
				(gMessager say: 2 8 0 0) ; "(SHORT SHRIEK)EEEEK!"
			)
		)
	)
)

(instance deadFallDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(1
				(= cycles 4)
			)
			(2
				(gKqSound1 number: 4351 setLoop: 1 play:)
				(deadFall setCycle: End self)
				(if (not register)
					(gEgo
						setLoop:
							(if (== (gEgo loop:) (- (NumLoops gEgo) 1))
								(gEgo cel:)
							else
								(gEgo loop:)
							)
							1
						setCycle: Rev
					)
				)
				(gEgo setMotion: MoveTo 137 105 self)
				(= ticks 10)
			)
			(3
				(if (not register)
					(sfx number: 4402 setLoop: 1 play:)
				)
			)
			(4)
			(5
				(switch register
					(0
						(deadFall setCycle: Beg self)
						(gEgo setHeading: 315)
						(gEgo setLoop: -1 normalize:)
					)
					(1
						(gEgo setHeading: 300)
						(deadFall loop: 1 cel: 0 setCycle: End self)
					)
					(2
						(if (== gValOrRoz -3) ; Roz
							(if (IsFlag 151)
								(deadFall
									view: 43592
									loop: 0
									cel: 0
									setCycle: CT 2 1 self
								)
							else
								(deadFall
									view: 43590
									loop: 0
									cel: 0
									setCycle: CT 2 1 self
								)
							)
						else
							(deadFall
								view: 43591
								loop: 0
								cel: 0
								setCycle: CT 2 1 self
							)
						)
					)
				)
			)
			(6
				(switch register
					(0
						(gGame handsOn:)
						(self dispose:)
					)
					(1
						(deadFall setCycle: Beg self)
					)
					(2
						(gKqSound1
							number: (if (== gValOrRoz -3) 43520 else 41081) ; Roz
							setLoop: 1
							play:
						)
						(gEgo hide:)
						(deadFall cel: 3)
						(UpdateScreenItem deadFall)
						(deadFall setCycle: End self)
					)
				)
			)
			(7
				(switch register
					(1
						(deadFall loop: 0)
						(deadFall cel: (deadFall lastCel:) setCycle: Beg self)
					)
					(2
						(deadFall view: 4359 loop: 0 cel: 0)
						(EgoDead (if (== gValOrRoz -3) 58 else 59) self) ; Roz
					)
				)
			)
			(8
				(gGame handsOn:)
				(ClearFlag 5)
				(self dispose:)
			)
		)
	)
)

(instance boogeyTalk of KQTalker
	(properties)

	(method (init)
		(= client boogey)
		(super init:)
	)
)

(instance catTalk of KQTalker
	(properties)
)

(instance blackCat of Actor
	(properties
		x 100
		y 91
		view 4360
	)
)

(instance diggerComes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= register (Actor new:)) view: 43550 init: hide:)
				(digTalk clientCel: -2 loop: 21 view: 43550 client: register)
				(if (> (gEgo x:) 165)
					(gEgo setMotion: PolyPath 150 120 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Load rsVIEW 4355)
				(Load rsSOUND 4358)
				(if (!= (gEgo heading:) 90)
					(gEgo setHeading: 90 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 4355)
				(gEgo setLoop: 0 setCel: 0 setCycle: End self)
			)
			(3
				(sfx number: 4358 setLoop: 1 play: self)
			)
			(4
				(Load rsSOUND 4091)
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: 0)
				(= cycles 2)
			)
			(6
				(gKqMusic1 fade: 0 4 2 0)
				(sfx number: 4092 loop: -1 play:)
				(sfx2 number: 4091 loop: -1 play:)
				(= cycles 6)
			)
			(7
				(register
					loop: 1
					x: 319
					y: 103
					cel: 0
					setCycle: Fwd
					show:
					setMotion: MoveTo 222 103 self
				)
			)
			(8
				(sfx stop:)
				(register setCycle: 0)
				(if (IsFlag 171)
					(client register: register)
					(self dispose:)
				else
					(= caller 0)
					(gMessager say: 1 65 2 0 self 4001) ; "Where do you want me to dig?"
				)
			)
			(9
				(sfx number: 4092 loop: -1 play:)
				(register
					setLoop: 1 1
					setCycle: Rev
					setMotion: MoveTo 319 (register y:) self
				)
			)
			(10
				(sfx fade: 0 10 2 1)
				(sfx2 fade: 0 10 2 1)
				(register dispose:)
				(gGame handsOn:)
				(client dispose:)
			)
		)
	)
)

(instance boogey of Actor
	(properties
		x 74
		y 101
		view 4351
	)
)

(instance branch of View
	(properties
		x 144
		y 30
		view 4362
	)

	(method (init)
		(super init:)
		(self setPri: 70 setCel: (if local0 0 else 1))
	)
)

(instance deadFall of Prop
	(properties
		x 61
		y 88
		view 4359
	)

	(method (init)
		(if (IsFlag 172)
			(self
				view: 4358
				loop: 1
				cel: 0
				x: 64
				y: 93
				signal: (| signal $1000)
				setPri: 0
			)
		else
			(self
				view: 4359
				loop: 0
				cel: 0
				x: 61
				y: 88
				setHotspot: 8 10 ; Do, Exit
				approachVerbs: 8 ; Do
				approachX: 118
				approachY: 103
				cycleSpeed: 14
				signal: (| signal $1000)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: deadFallDeath 0 local1)
					(if (< local1 2)
						(= local1 2)
					)
				)
			)
		)
	)
)

(instance hole of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			approachX: 60
			approachY: 90
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 51 81 76 87 102 79 92 73 65 73
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: fallIntoHole)
	)
)

(instance sfx of Sound
	(properties)
)

(instance sfx2 of Sound
	(properties)
)

(instance sTink of Sound
	(properties)
)

(instance digTalk of KQTalker
	(properties)

	(method (doit)
		(if mouth
			(mouth x: (client x:) y: (client y:))
		)
		(super doit:)
	)
)

(instance killTimer of Timer
	(properties)

	(method (cue)
		(if
			(or
				(< (gEgo x:) 130)
				(gCast contains: blackCat)
				(gCurRoom script:)
				(OogaBooga script:)
			)
			(self setReal: self 15)
		else
			(gCurRoom setScript: crawlOut)
		)
	)
)

