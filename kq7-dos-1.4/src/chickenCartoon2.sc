;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5301)
(include sci.sh)
(use Main)
(use ExitButton)
(use rm5300)
(use Scaler)
(use PolyPath)
(use Rev)
(use Motion)
(use System)

(public
	chickenCartoon2 0
	congrats 1
	openingScript 2
	dukeWalkOut 3
	crackFauxDoor 4
	crackChinaDoor 5
	wereGonnaDie 6
	fallFromCloudland 7
)

(local
	[local0 5] = [1 3 6 14 -1]
)

(instance chickenCartoon2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load rsSOUND 5310)
					(Load 140 5311) ; WAVE
					(Load rsSOUND 817)
					(= cycles 2)
				)
				(1
					(gKqMusic1 pause: 1)
					((ScriptID 5300 2) number: 5310 loop: -1 play:) ; chickenSound
					((ScriptID 5300 1) ; chickenPetite
						posn: 315 104
						view: 5311
						setLoop: 0 1
						setCel: 0
						init:
						setCycle: Fwd
						setMotion:
							PolyPath
							(- (gEgo x:) 17)
							(+ (gEgo y:) 3)
							self
					)
					(= global372 9)
					(gMessager say: 0 0 12 1 (ScriptID 5300 1)) ; "(SCREAMING)The sky is falling! Buck buck buck buck! The sky is falling!", chickenPetite
					(proc11_3 gEgo (ScriptID 5300 1)) ; chickenPetite
				)
				(2
					(proc11_3 gEgo (ScriptID 5300 1)) ; chickenPetite
					((ScriptID 5300 1) setLoop: 1 setCel: 0 setCycle: End self) ; chickenPetite
				)
				(3
					(gKqSound1 number: 5311 loop: -1 play:)
					((ScriptID 5300 1) ; chickenPetite
						posn:
							(+ ((ScriptID 5300 1) x:) 1) ; chickenPetite
							(- ((ScriptID 5300 1) y:) 31) ; chickenPetite
						setLoop: 2
						setCel: 0
						setPri: (+ (gEgo priority:) 1)
						setCycle: End self
					)
				)
				(4
					(gKqSound1 stop:)
					(gEgo hide:)
					((ScriptID 5300 1) ; chickenPetite
						posn: (gEgo x:) (gEgo y:)
						setLoop: 3
						setCel: 0
						setCycle: End self
					)
					(gMessager say: 0 0 12 2 self) ; "DID YOU HEAR ME, LADY? I SAID THE SKY IS FALLING!"
				)
				(5 0)
				(6
					((ScriptID 5300 1) setLoop: 4 setCel: 0 setCycle: End self) ; chickenPetite
				)
				(7
					(gEgo show:)
					((ScriptID 5300 1) ; chickenPetite
						posn: (- (gEgo x:) 25) (gEgo y:)
						setLoop: 5
						setCel: 0
						setCycle: End self
					)
				)
				(8
					(gKqSound1 number: 817 loop: 1 play: self)
				)
				(9
					((ScriptID 5300 2) stop:) ; chickenSound
					(gKqMusic1 setVol: 0 pause: 0 fade: 127 25 10 0)
					((ScriptID 5300 1) setScript: (ScriptID 5300 3) 0 10) ; chickenPetite, chickenTimerScript
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					((ScriptID 5300 2) stop:) ; chickenSound
					(gKqSound1 stop:)
					(gKqMusic1 setVol: 0 pause: 0 fade: 127 25 10 0)
					(gEgo show: normalize: 2)
					((ScriptID 5300 1) setCycle: 0 setMotion: 0 setScript: 0) ; chickenPetite
					(proc5300_4)
					(gGame handsOn:)
					(ClearFlag 539)
					(self dispose:)
				)
			)
		)
	)
)

(instance congrats of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 205)
				(proc11_3 gEgo (ScriptID 5300 5) self) ; archDuke
				(gCurRoom centerScreen: 0 self 10)
			)
			(1 0)
			(2
				(gKqSound1 number: 801 loop: 1 play:)
				((ScriptID 5300 6) setPri: 80 setCycle: CT 4 1 self) ; townHallDoor
			)
			(3
				((ScriptID 5300 5) ; archDuke
					view: 5334
					setLoop: 0 1
					cel: 0
					posn: 225 83
					ignoreActors: 1
					ignoreHorizon:
					init:
					setPri: 82
					setCycle: CT 6 1 self
				)
			)
			(4
				((ScriptID 5300 5) ; archDuke
					setCycle: End self
					setMotion: MoveTo 222 93 self
				)
			)
			(5 0)
			(6
				((ScriptID 5300 5) setLoop: 1 1 cel: 0 setCycle: End self) ; archDuke
			)
			(7
				(gMessager say: 0 0 41 0 self) ; "(NERVOUS, DISTRACTED)Congratulathionth, o hairleth one. Thinth you have returned the moon to the thky, you are granted a full pardon. (slurp)"
			)
			(8
				((ScriptID 5300 5) setLoop: 2 1 cel: 0 setCycle: End self) ; archDuke
			)
			(9
				((ScriptID 5300 5) ; archDuke
					setLoop: 3 1
					cel: 0
					setCycle: Walk
					setScaler: Scaler 92 73 86 78
					setMotion: MoveTo 177 75 self
				)
			)
			(10
				((ScriptID 5300 5) dispose:) ; archDuke
				((ScriptID 5300 7) ; gateGuard
					setCycle: Walk
					setLoop: 2 1
					setMotion: PolyPath 226 99 self
				)
			)
			(11
				((ScriptID 5300 7) ; gateGuard
					setScaler: Scaler 100 70 91 78
					setPri: 82
					setLoop: 3
					setMotion: MoveTo 179 72 self
				)
			)
			(12
				((ScriptID 5300 7) dispose:) ; gateGuard
				((ScriptID 5300 6) setCycle: Beg self) ; townHallDoor
			)
			(13
				(gKqSound1 number: 802 loop: 1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 5300 5) setScript: dukeWalkOut self) ; archDuke
				(self setScript: (ScriptID 5300 8) self) ; enterFromGate
			)
			(1 0)
			(2
				(gEgo
					setMotion:
						PolyPath
						((ScriptID 5300 5) approachX:) ; archDuke
						((ScriptID 5300 5) approachY:) ; archDuke
						self
				)
			)
			(3
				(gMessager say: 0 0 1 1 self) ; "YAP!"
			)
			(4
				(gMessager say: 0 0 1 2 self) ; "(IMPORTANTLY)THTOP! I, Arch-Duke Fifi le Yipyap, do order it! (slurp) You are a thtranger here, and you have no buthineth in the town of Falderal!"
			)
			(5
				(SetFlag 404)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dukeWalkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 5302) ; WAVE
				(Load 140 5304) ; WAVE
				((ScriptID 5300 6) cel: 4) ; townHallDoor
				(gKqMusic1 pause: 1)
				((ScriptID 5300 9) number: 5301 loop: 1 play:) ; archDukeSound
				((ScriptID 5300 5) ; archDuke
					posn: 225 96
					view: 5301
					setLoop: 0
					setCel: 0
					init:
					setCycle: End self
				)
			)
			(1
				((ScriptID 5300 5) ; archDuke
					setLoop: 1
					setCel: 0
					posn: 204 99
					setCycle: End self
				)
			)
			(2
				((ScriptID 5300 5) ; archDuke
					setLoop: 2
					cel: 0
					posn: 222 112
					setCycle: End self
				)
			)
			(3
				(gKqSound1 number: 5302 loop: 1 play:)
				((ScriptID 5300 5) ; archDuke
					setLoop: 3
					cel: 0
					posn: 181 111
					setCycle: CT 1 1 self
				)
				(= register 0)
			)
			(4
				(gKqSound1 number: 5302 loop: 1 play:)
				(if (!= [local0 (++ register)] -1)
					(-- state)
					((ScriptID 5300 5) setCycle: CT [local0 register] 1 self) ; archDuke
				else
					((ScriptID 5300 5) setCycle: End self) ; archDuke
				)
			)
			(5
				(gKqSound1 number: 5304 loop: 1 play:)
				((ScriptID 5300 5) ; archDuke
					setLoop: 4
					cel: 0
					posn: 157 111
					setCycle: CT 7 1 self
				)
			)
			(6
				(gKqSound1 stop:)
				((ScriptID 5300 5) setCycle: End self) ; archDuke
			)
			(7
				((ScriptID 5300 9) fade:) ; archDukeSound
				(gKqMusic1 setVol: 0 pause: 0 fade: 127 25 10 0)
				(self dispose:)
			)
		)
	)
)

(instance crackFauxDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 5338)
				(gEgo view: 8121 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(gKqSound1 number: 803 loop: 1 play: self)
			)
			(2
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(gMessager say: 0 0 47 0 self) ; "It's Locked"
			)
			(3
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo
					normalize: 0
					setCycle: Rev
					setMotion: MoveTo 424 72 self
				)
			)
			(4
				(gEgo normalize: 0)
				(gKqSound1 number: 857 loop: 1 play:)
				((ScriptID 5300 10) ; fauxDoor
					view: 5338
					setLoop: 0 1
					cel: 0
					posn: 442 71
					setPri: 10
					setCycle: End self
				)
			)
			(5
				(gMessager say: 12 8 43 0 self) ; "(PANICKED)Lady Valanice! This world is no longer safe for you! Go back to your own world if you can, for we are all doomed!"
			)
			(6
				((ScriptID 5300 10) setCycle: Beg self) ; fauxDoor
			)
			(7
				(gKqSound1 number: 802 loop: 1 play:)
				(gGame handsOn:)
				(SetFlag 276)
				((ScriptID 5300 10) setHotspot:) ; fauxDoor
				(self dispose:)
			)
		)
	)
)

(instance crackChinaDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 284)
				(gEgo view: 8123 setLoop: 1 1 cel: 0 setCycle: CT 5 1 self)
				((ScriptID 13 0) client: gEgo hide_mouth: 1 clientCel: -2) ; aEgoTalker
			)
			(1
				(gKqSound1 number: 803 loop: 1 play: self)
			)
			(2
				(gMessager say: 0 0 47 0 self) ; "It's Locked"
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gEgo normalize: 3)
				(gKqSound1 number: 857 loop: 1 play:)
				((ScriptID 5300 12) setCycle: CT 2 1 self) ; chinaDoor
				((ScriptID 5300 11) init: setCycle: End self) ; bull
			)
			(5 0)
			(6
				(gEgo
					setLoop: 7 1
					setCycle: Rev
					setMotion: MoveTo 127 110 self
				)
			)
			(7
				(gEgo normalize: 7)
				(= cycles 1)
			)
			(8
				(gMessager say: 11 8 43 0 self) ; "(WORRIED, IN A HURRY)What--? Oh! Lady Valanice! Take cover, my lady! THe volcano is about to explode! Run for your life!"
			)
			(9
				((ScriptID 5300 11) setCycle: Beg self) ; bull
			)
			(10
				((ScriptID 5300 11) dispose:) ; bull
				((ScriptID 5300 12) setCycle: Beg self) ; chinaDoor
			)
			(11
				(gKqSound1 number: 802 loop: 1 play:)
				((ScriptID 5300 12) setHotspot: 0) ; chinaDoor
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wereGonnaDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 42 0 self) ; "(FROM BEHIND THE DOOR)We're all gonna roast! We're all gonna roast!"
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fallFromCloudland of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(= cycles 2)
			)
			(1
				(gKqSound1 number: 852 loop: 1 play:)
				(gEgo
					view: 3261
					loop: 0
					cel: 0
					x: 449
					y: 90
					setScale: 0
					show:
					setCycle: CT 3 1 self
				)
			)
			(2
				(gKqSound1 number: 865 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					normalize: 6
					posn: 450 94
					setScaler: Scaler 83 53 98 78
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

