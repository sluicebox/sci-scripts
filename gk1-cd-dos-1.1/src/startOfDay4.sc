;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 214)
(include sci.sh)
(use Main)
(use n013)
(use ROsc)
(use Osc)
(use RandCycle)
(use PolyPath)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	startOfDay4 1
	startOfDay6 2
	readIt4 3
)

(local
	local0
)

(instance startOfDay4 of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gTalkers size:)
				(gMessager cue: 1)
			)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(if ((ScriptID 210 1) cycler:) ; graceProp
				((ScriptID 210 1) setCycle: 0) ; graceProp
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(SetFlag 10)
				(gGame handsOff:)
				((ScriptID 210 1) init: setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(gEgo
					setPri: -1
					view: 212
					setCel: 0
					setLoop: 0
					posn: 291 123
					setSpeed: 11
					setCycle: End self
				)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(Load 140 214) ; WAVE
				)
			)
			(1
				(gEgo setCel: 0 setLoop: 1 posn: 271 151 setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				(gEgo
					view: 901
					setSpeed: 6
					setCycle: StopWalk -1
					setMotion: MoveTo 137 138 self
				)
			)
			(4
				(gEgo
					view: 215
					setCel: 0
					setLoop: 0
					posn: 81 139
					setSpeed: 10
					setCycle: CT 1 1 self
				)
			)
			(5
				((ScriptID 210 2) dispose:) ; gabsMug
				(gEgo view: 215 setCel: 2 setLoop: 0 setCycle: End self)
			)
			(6
				(gEgo view: 215 setCel: 0 setLoop: 1 setCycle: CT 2 1 self)
			)
			(7
				((ScriptID 210 3) hide:) ; coffeePot
				(gEgo view: 215 setCel: 3 setLoop: 1 setCycle: End self)
				(gGkSound1 number: 214 play:)
			)
			(8
				(gEgo setCel: 0 setLoop: 2 setCycle: CT 4 1 self)
			)
			(9
				((ScriptID 210 3) show:) ; coffeePot
				(gEgo setCel: 5 setLoop: 2 setCycle: End self)
			)
			(10
				(gEgo setCel: 0 setLoop: 3 setCycle: Osc 1 self)
			)
			(11
				(= seconds 3)
			)
			(12
				(gEgo view: 2150 setCel: 0 setLoop: 0 setCycle: RandCycle)
				(gMessager say: 11 0 39 1 self) ; "You're not speaking to me this morning?"
			)
			(13
				(gEgo setCel: 0 setCycle: 0)
				((ScriptID 210 4) dispose:) ; graceDoStuff
				((ScriptID 210 1) ; graceProp
					view: 2111
					setCel: 8
					setLoop: 0
					cycleSpeed: 8
					setCycle: CT 5 -1 self
				)
			)
			(14
				(gMessager say: 11 0 39 2 self) ; "(FLAT. PISSED)Don't be silly. I just have nothing to say."
			)
			(15
				(if (IsFlag 36)
					(gMessager say: 11 0 45 1 self) ; "Did you find out anything about that pattern I gave you?"
				else
					(gMessager say: 11 0 40 0 self) ; "Have it your way."
				)
				(gEgo view: 2150 setCel: 0 setLoop: 0 setCycle: RandCycle)
			)
			(16
				(if (IsFlag 36)
					((ScriptID 210 4) dispose:) ; graceDoStuff
					(gEgo setCel: 0 setCycle: 0)
					((ScriptID 210 1) ; graceProp
						view: 213
						setCel: 3
						setLoop: 0
						setCycle: End
					)
					(gMessager say: 11 0 45 2 self) ; "(ARCC)Yeah. I did find something."
				else
					(gEgo view: 215 setCel: 0 setLoop: 3 setCycle: End self)
				)
			)
			(17
				(if (IsFlag 36)
					(gEgo
						view: 215
						setCel: 0
						setLoop: 4
						setCycle: CT 3 1 self
					)
				else
					(gEgo setCel: 0 setLoop: 4 setCycle: CT 3 1 self)
				)
			)
			(18
				(if (IsFlag 36)
					((ScriptID 210 2) init: posn: 86 120) ; gabsMug
					(gEgo view: 215 setCel: 4 setLoop: 4 setCycle: End self)
				else
					((ScriptID 210 2) init: posn: 86 120) ; gabsMug
					(gEgo setCel: 4 setLoop: 4 setCycle: End self)
				)
			)
			(19
				(if (IsFlag 36)
					(gEgo
						view: 901
						setSpeed: 6
						setCycle: StopWalk -1
						setMotion: MoveTo 187 125 self
					)
				else
					((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
					(gEgo normalize: 0 901 ignoreActors: 1)
					(gKeyDownHandler delete: self)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(20
				(gEgo hide:)
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 1
					posn: 222 118
					setCycle: End self
				)
			)
			(21
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 4
					posn: 251 115
					setCycle: End self
				)
				(gEgo show: get: 9 getPoints: 455 1) ; news1810
			)
			(22
				(ClearFlag 361)
				(gMessager say: 11 0 45 3 self) ; "I checked the micro-fiche at the public library. I found an article about a murder in 1810. The newspaper published part of a pattern found around the body. It looks damn close."
				((ScriptID 210 1) setCel: 0 setLoop: 4 setCycle: RandCycle) ; graceProp
			)
			(23
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 45 4 self) ; "You're incredible. All that work..."
			)
			(24
				(gMessager say: 11 0 45 5 self) ; "(MIFFED BECAUSE HE'S DATING MALIA AND SHE FEELS MARTYRED)Forget it."
				((ScriptID 210 1) setCel: 0 setLoop: 4 setCycle: RandCycle) ; graceProp
			)
			(25
				(gMessager say: 11 0 40 0 self) ; "Have it your way."
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
			)
			(26
				(gKeyDownHandler delete: self)
				(SetFlag 361)
				(gEgo normalize: 0 901 ignoreActors: 1)
				(gGame handsOn:)
				(self dispose:)
			)
			(99
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local0 100)) (>= local0 0) ((-= local0 2))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 15)
			)
			(100
				(gEgo show: normalize: 0 901 ignoreActors: 1 posn: 187 125)
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(if (not ((ScriptID 210 3) isNotHidden:)) ; coffeePot
					((ScriptID 210 3) show:) ; coffeePot
				)
				(if (not (gCast contains: (ScriptID 210 2))) ; gabsMug
					((ScriptID 210 2) init:) ; gabsMug
				)
				(if (IsFlag 36)
					(gEgo get: 9 getPoints: 455) ; news1810
				)
				(= cycles 1)
			)
			(101
				(for ((= local0 0)) (<= local0 100) ((+= local0 2))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(SetFlag 361)
				(gKeyDownHandler delete: self)
				(SetFlag 10)
				(= cycles 2)
			)
			(102
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 214)
			)
		)
	)
)

(instance startOfDay6 of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_SPACE) (SkipSceneDialog))
			(gMessager caller: 0)
			(gMessager killed: 1)
			(if (gTalkers size:)
				(gMessager cue: 1)
			)
			(if (gEgo cycler:)
				(gEgo setCycle: 0)
			)
			(if ((ScriptID 210 1) cycler:) ; graceProp
				((ScriptID 210 1) setCycle: 0) ; graceProp
			)
			(self changeState: 99)
			(return 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler add: self)
				(gGame handsOff:)
				(ClearFlag 361)
				(SetFlag 10)
				((ScriptID 210 1) ; graceProp
					view: 2101
					setCel: 5
					setLoop: 1
					init:
					posn: 101 99
					setCycle: End self
				)
				(chicken init:)
			)
			(1
				(= seconds 2)
			)
			(2
				(gMessager say: 11 0 43 1) ; "(SCREAM OF HORROR-SEES VOODOO CURSE LEFT ON RUG AS WARNING)Ahhhh!"
				(chickenInset init:)
				(chickenLeg init:)
				(chickenHead init:)
				(chickenWing init:)
				(= seconds 10)
			)
			(3
				(chickenInset dispose:)
				(chickenLeg dispose:)
				(chickenHead dispose:)
				(chickenWing dispose:)
				(gEgo
					show:
					view: 2101
					setCel: 0
					setLoop: 0
					posn: 292 109
					setCycle: End self
				)
			)
			(4
				(gMessager say: 11 0 43 2) ; "(STARTLED, READY TO FIGHT)What is it? What's wrong?"
				(gEgo normalize: 1 901 setMotion: PolyPath 175 124 self)
			)
			(5
				(gMessager say: 11 0 43 3 self) ; "(CONFUSED, AFRAID)Gabriel?"
				((ScriptID 210 1) ; graceProp
					view: 2100
					setCel: 0
					setLoop: 0
					setCycle: RandCycle
				)
			)
			(6
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gEgo view: 2100 setCel: 0 setLoop: 1 setCycle: Osc 1 self)
				(gMessager say: 11 0 43 4 self) ; "(GRIM)I see it, Grace. Hold on."
			)
			(7)
			(8
				(gEgo normalize: 1 901)
				(gMessager say: 11 0 43 5 self) ; "(RRCC. URGENT. RERECORD--WATCH BRITISH ON FIRST SENTENCE)There's no one in the shop, and I know there's no one in back. It's okay."
			)
			(9
				(gMessager say: 11 0 43 6 self) ; "Okay? Gabriel, that thing is still barely alive! How could someone DO this?"
				((ScriptID 210 1) setCel: 0 setLoop: 0 setCycle: RandCycle) ; graceProp
			)
			(10
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 43 7 self) ; "(TRYING TO BE FUNNY, BUT SHOOK)With a knife, maybe?"
			)
			(11
				((ScriptID 210 1) setCel: 0 setLoop: 0 setCycle: RandCycle) ; graceProp
				(gMessager say: 11 0 43 8 self) ; "God, don't even start. We should call the police."
			)
			(12
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 43 9 self) ; "(FIRM)No. I'll take care of it."
			)
			(13
				((ScriptID 210 1) setCel: 0 setLoop: 0 setCycle: RandCycle) ; graceProp
				(gMessager say: 11 0 43 10 self) ; "But, Gabriel...."
			)
			(14
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 43 11 self) ; "I said I'll take care of it. Why don't you go get some coffee. I'll have it all cleaned up before you get back."
			)
			(15
				((ScriptID 210 1) setCel: 0 setLoop: 0 setCycle: RandCycle) ; graceProp
				(gMessager say: 11 0 43 12 self) ; "<sigh> They know where you live now."
			)
			(16
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 43 13 self) ; "Shhhh. It's going to be fine. Now go on."
			)
			(17
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local0 100)) (>= local0 0) ((-= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 15)
			)
			(18
				(chicken dispose:)
				(gEgo normalize: 0 901 ignoreActors: 1)
				((ScriptID 210 1) posn: 251 115 setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(= cycles 1)
			)
			(19
				(for ((= local0 0)) (<= local0 100) ((+= local0 1))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 1)
			)
			(20
				(gMessager say: 11 0 43 14 self) ; "Later...."
			)
			(21
				(SetFlag 361)
				(if (and (IsFlag 73) (not (gEgo has: 14))) ; drumBook
					(gMessager say: 11 0 78 0 self 210) ; "(GK-AM2. SINCERELY CONCERNED)Are you sure you don't want to go home? I could close the shop today."
				else
					(gMessager say: 11 0 77 0 self 210) ; "(GK-AM2. SINCERELY CONCERNED)Are you sure you don't want to go home? I could close the shop today."
				)
			)
			(22
				(if (and (IsFlag 73) (not (gEgo has: 14))) ; drumBook
					((ScriptID 210 4) dispose:) ; graceDoStuff
					(gMessager say: 11 0 68 1 self 210) ; "We got that book you ordered in this morning--the one on Rada drums."
				else
					(self cue:)
				)
			)
			(23
				(if (and (IsFlag 73) (not (gEgo has: 14))) ; drumBook
					((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
					(gEgo setMotion: MoveTo 187 125 self)
				else
					(gKeyDownHandler delete: self)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(24
				(gMessager say: 11 0 68 2 self 210) ; "Really? Great!"
			)
			(25
				(gEgo hide:)
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 1
					posn: 222 118
					setCycle: End self
				)
			)
			(26
				((ScriptID 210 1) setCel: 0 setLoop: 2 posn: 251 115) ; graceProp
				(gEgo show: get: 14) ; drumBook
				(= cycles 1)
			)
			(27
				(gKeyDownHandler delete: self)
				(gEgo getPoints: 456 1)
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(gEgo normalize: 0 901)
				(gGame handsOn:)
				(self dispose:)
			)
			(99
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local0 100)) (>= local0 0) ((-= local0 2))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(= cycles 15)
			)
			(100
				(if (and (IsFlag 73) (not (gEgo has: 14))) ; drumBook
					(gEgo
						show:
						normalize: 0 901
						ignoreActors: 1
						get: 14 ; drumBook
						getPoints: 456 1
						posn: 187 125
					)
				else
					(gEgo
						show:
						normalize: 0 901
						ignoreActors: 1
						posn: 175 124
					)
				)
				((ScriptID 210 1) posn: 251 115 setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(if (gCast contains: chicken)
					(chicken dispose:)
				)
				(if (gCast contains: chickenInset)
					(chickenInset dispose:)
				)
				(if (gCast contains: chickenLeg)
					(chickenLeg dispose:)
				)
				(if (gCast contains: chickenHead)
					(chickenHead dispose:)
				)
				(if (gCast contains: chickenWing)
					(chickenWing dispose:)
				)
				(= cycles 2)
			)
			(101
				(for ((= local0 0)) (<= local0 100) ((+= local0 2))
					(Palette 2 0 255 local0) ; PalIntensity
				)
				(gKeyDownHandler delete: self)
				(SetFlag 10)
				(= cycles 2)
			)
			(102
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 214)
			)
		)
	)
)

(instance readIt4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(if (not (and (== (gEgo x:) 137) (== (gEgo y:) 138)))
					(gEgo setMotion: PolyPath 137 138 self)
				else
					(self cue:)
				)
			)
			(1
				1
				(if (IsFlag 336)
					(self changeState: 14)
				else
					((ScriptID 210 7) hide:) ; newsPaper
					(gEgo
						posn: 136 120
						view: 214
						loop: 0
						cel: 0
						setCycle: CT 2 1 self
					)
				)
			)
			(2
				2
				(gGkSound1 number: 213 play:)
				(gEgo posn: 136 120 loop: 0 cel: 3 setCycle: End self)
			)
			(3
				3
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(4
				4
				(gMessager sayRange: 35 12 19 1 3 self 211) ; "Times Picayune, dated June 21, 1993. Gabriel's eye is immediately drawn to an article about the Voodoo Murders. He scans it quickly."
			)
			(5
				5
				(Load rsVIEW 901)
				(gGkSound1 number: 213 play:)
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(6
				6
				((ScriptID 210 7) show:) ; newsPaper
				(gEgo normalize: 2 901 posn: 137 138)
				(self cue:)
			)
			(7
				7
				(Face gEgo (ScriptID 210 1) self) ; graceProp
			)
			(8
				8
				(= cycles 2)
			)
			(9
				9
				(gMessager say: 35 12 19 4 self 211) ; "The Voodoo Murders case! The paper says that the police have learned that the murders were the result of an underworld cartel war, and that the war is over."
			)
			(10
				10
				(gMessager say: 35 12 19 5 self 211) ; "That's not good?"
				((ScriptID 210 1) cel: 0 setCycle: ROsc -1 0 4) ; graceProp
			)
			(11
				11
				((ScriptID 210 1) setCycle: 0) ; graceProp
				(gMessager say: 35 12 19 6 self 211) ; "It's ridiculous! What about the killers? And the Voodoo angle, they never got anything on that!"
			)
			(12
				12
				(gMessager say: 35 12 19 7 self 211) ; "(MRCC)I know you were into it, Gabriel, but if it's over, that's hardly a NEGATIVE. Anyway, if you're that upset, why don't you talk it over with your pal Mosely?"
				((ScriptID 210 1) cel: 0 setCycle: ROsc -1 0 4) ; graceProp
			)
			(13
				13
				((ScriptID 210 1) cel: 0 setCycle: End) ; graceProp
				(gMessager say: 35 12 19 8 self 211) ; "You don't get it, Grace. Just...forget it, OKAY?"
			)
			(14
				14
				(Face gEgo (ScriptID 210 7) self) ; newsPaper
				(if (IsFlag 336)
					(self cue:)
				else
					(gMessager say: 35 12 19 9 self 211) ; "Gabriel decides to check his horoscope, despite his disgust."
				)
			)
			(15 15)
			(16
				16
				(if (not (IsFlag 336))
					((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				)
				((ScriptID 210 7) hide:) ; newsPaper
				(gEgo
					posn: 136 120
					view: 214
					loop: 0
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(17
				17
				(gGkSound1 number: 213 play:)
				(gEgo loop: 0 cel: 3 setCycle: End self)
			)
			(18
				18
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(19
				19
				(if (IsFlag 336)
					(gMessager say: 35 12 26 0 self 211) ; "Gabriel skips the Voodoo Murders article (what a farce) and rereads his horoscope."
				else
					(gMessager sayRange: 35 12 19 10 11 self 211) ; "Death walks close to you today. Resist temptation lest His eye fall on you, too."
				)
			)
			(20
				20
				(Load rsVIEW 901)
				(gGkSound1 number: 213 play:)
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(21
				21
				(SetFlag 336)
				((ScriptID 210 7) show:) ; newsPaper
				(gGame handsOn:)
				(gEgo
					normalize: 2 901
					ignoreActors: 1
					posn: 137 138
					getPoints: 144 1
				)
				(self dispose:)
			)
		)
	)
)

(instance chicken of View
	(properties
		x 134
		y 103
		view 2101
		loop 2
	)
)

(instance chickenInset of View
	(properties
		x 74
		y 37
		view 81
	)

	(method (init)
		(self ignoreActors: 1 setPri: 200)
		(super init:)
	)
)

(instance chickenLeg of Prop
	(properties
		x 103
		y 64
		view 81
		loop 1
	)

	(method (init)
		(self setPri: 201)
		(super init:)
		(self ignoreActors: 1 setCycle: RandCycle cycleSpeed: 11)
	)
)

(instance chickenHead of Prop
	(properties
		x 175
		y 74
		view 81
		loop 2
	)

	(method (init)
		(self setPri: 201)
		(super init:)
		(self setCycle: RandCycle cycleSpeed: 11)
	)
)

(instance chickenWing of Prop
	(properties
		x 129
		y 91
		view 81
		loop 3
	)

	(method (init)
		(self setPri: 201)
		(super init:)
		(self setCycle: RandCycle cycleSpeed: 11)
	)
)

