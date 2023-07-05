;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use n013)
(use GKTeller)
(use Osc)
(use RandCycle)
(use PolyPath)
(use ForwardCounter)
(use StopWalk)
(use Cursor)
(use Motion)
(use Actor)
(use System)

(public
	startingCartoon 1
	startOfDay2 2
	readIt2 3
	getSomeCoffee 4
	enterFlorist 5
	florist 6
)

(local
	local0
	local1
	local2
	local3
)

(instance startingCartoon of Script
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
				(gGame handsOff:)
				(gKeyDownHandler add: self)
				(ClearFlag 361)
				(SetFlag 10)
				(gEgo
					view: 212
					setLoop: 0
					posn: 291 123
					setSpeed: 11
					setCycle: CT 2 1 self
				)
				((ScriptID 210 1) ; graceProp
					setCel: 0
					setLoop: 0
					init:
					cycleSpeed: 10
					setCycle: ForwardCounter 5
				)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(Load 140 214) ; WAVE
				)
			)
			(1
				(gEgo view: 212 setCel: 3 setLoop: 0 setCycle: End self)
				(gGkSound1 number: 215 play:)
			)
			(2
				(gMessager say: 11 0 34 1 self) ; "(ON PHONE AS GABE COMES OUT OF STUDIO IN THE MORNING)Mmmm-hmmm. I bet. Just a minute."
				(gEgo setCel: 0 setLoop: 1 posn: 271 151 setCycle: End self)
			)
			(3)
			(4
				((ScriptID 210 1) setCel: 0 setLoop: 1 setCycle: End self) ; graceProp
			)
			(5
				(gMessager say: 11 0 34 2 self) ; "(TO GABRIEL)It lives, I see. Do you want to speak with 'Lolita?'"
				(gEgo setLoop: 2 setSpeed: 11 setCycle: End self)
			)
			(6)
			(7
				(gEgo setLoop: 3 setSpeed: 10 setCycle: Osc 2 self)
			)
			(8
				((ScriptID 210 1) setCel: 4 setLoop: 1 setCycle: Beg self) ; graceProp
			)
			(9
				(gMessager say: 11 0 34 3) ; "(TO PHONE AGAIN)<sigh> I'm sorry, but Gabriel is a lout...I mean, he's out."
				(gEgo
					setCel: 0
					setLoop: 4
					posn: 254 153
					setSpeed: 10
					setCycle: End self
				)
				((ScriptID 210 1) ; graceProp
					setCel: 0
					setLoop: 0
					setCycle: ForwardCounter 6
				)
			)
			(10
				(gEgo
					view: 901
					posn: 257 152
					setSpeed: 6
					setCycle: StopWalk -1
					setMotion: MoveTo 137 138 self
				)
			)
			(11
				(gEgo
					view: 215
					setCel: 0
					setLoop: 0
					posn: 81 139
					setSpeed: 10
					setCycle: CT 1 1 self
				)
			)
			(12
				(gMessager say: 11 0 34 4) ; "Yeah, if he ever comes back, I'll tell him. You know, you could do better. I know I don't know you, but you could do better. Sure. Bye."
				((ScriptID 210 2) dispose:) ; gabsMug
				(gEgo view: 215 setCel: 2 setLoop: 0 setCycle: End self)
			)
			(13
				(gEgo view: 215 setCel: 0 setLoop: 1 setCycle: CT 2 1 self)
			)
			(14
				(gGkSound1 number: 214 play:)
				((ScriptID 210 3) hide:) ; coffeePot
				(gEgo setCel: 3 setLoop: 1 setCycle: End self)
			)
			(15
				(gEgo setCel: 0 setLoop: 2 setCycle: CT 4 1 self)
			)
			(16
				((ScriptID 210 3) show:) ; coffeePot
				(gEgo setCel: 5 setLoop: 2 setCycle: End self)
			)
			(17
				(gEgo setCel: 0 setLoop: 5 posn: 81 141 setCycle: End self)
			)
			(18
				(gEgo
					view: 2151
					setCel: 0
					setLoop: 0
					posn: 150 123
					setCycle: Osc 1 self
				)
			)
			(19
				((ScriptID 210 1) setCel: 4 setLoop: 2 setCycle: End self) ; graceProp
				(SetFlag 361)
				(SetFlag 311)
			)
			(20
				(gEgo view: 215 setCel: 6 setLoop: 6)
				(gMessager sayRange: 11 0 34 5 11 self) ; "(TO GABE)Good morning. The phone's been ringing off the hook all morning. Let me know when you want your messages."
			)
			(21
				(ClearFlag 311)
				((ScriptID 210 1) cel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 35 1) ; "Really? Great!"
				(gEgo view: 2151 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(22
				(gEgo loop: 2 cel: 0)
				((ScriptID 210 2) init:) ; gabsMug
				(= cycles 1)
			)
			(23
				(gEgo loop: 2 cel: 1 setCycle: CT 3 1 self)
			)
			(24
				(gEgo
					view: 901
					posn: 123 139
					setSpeed: 6
					setCycle: StopWalk -1
					setLoop: 0
					setMotion: MoveTo 187 125 self
				)
				((ScriptID 210 1) ; graceProp
					view: 213
					loop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: End
				)
			)
			(25
				(gEgo hide:)
				(self cue:)
			)
			(26
				((ScriptID 210 1) ; graceProp
					posn: 222 118
					setCel: 0
					setLoop: 1
					setCycle: End self
				)
			)
			(27
				(gEgo show: normalize: 0 901)
				((ScriptID 210 1) ; graceProp
					posn: 251 115
					setCel: 0
					setLoop: 2
					setCycle: End self
				)
			)
			(28
				(ClearFlag 361)
				(gMessager say: 11 0 35 2 self) ; "I can't wait to see what human rights you violate with this one."
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 2
					setCycle: RandCycle -1 0 1
				)
			)
			(29
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 35 3 self) ; "I can't wait to violate them. For example, if you would just let me...."
			)
			(30
				(= cycles 1)
			)
			(31
				(gMessager say: 11 0 35 4 self) ; "AND I located some local Voodoo references for you. Dixieland Drug Store and The Historical Museum of Voodoo. Both are right here in the French Quarter."
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 2
					setCycle: RandCycle -1 0 1
				)
			)
			(32
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 35 5 self) ; "How would I ever manage without you?"
			)
			(33
				(gMessager say: 11 0 35 6 self) ; "You? Give me a break. The devil himself couldn't change you."
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 3
					setCycle: Osc 1
				)
			)
			(34
				(= cycles 1)
			)
			(35
				((ScriptID 210 1) setCel: 0 setCycle: 0) ; graceProp
				(gMessager say: 11 0 35 7 self) ; "Well...if the devil had great legs, perhaps...like yours."
			)
			(36
				(= cycles 1)
			)
			(37
				(gMessager say: 11 0 35 8 self) ; "(RRCC. MISSED FIRST WORD. SARCASTIC, THEN DRY)And a riveting personality, I'm sure. If you need any more research done, just ask. It's not as though we're swamped with customers."
				((ScriptID 210 1) ; graceProp
					view: 213
					setCel: 0
					setLoop: 2
					setCycle: RandCycle -1 0 1
				)
			)
			(38
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(SetFlag 361)
				(gKeyDownHandler delete: self)
				(= cycles 2)
			)
			(39
				(gGame handsOn:)
				(self dispose:)
			)
			(99
				(for ((= local3 100)) (>= local3 0) ((-= local3 1))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(= cycles 15)
			)
			(100
				(gEgo normalize: 0 901 ignoreActors: 1 posn: 187 125)
				((ScriptID 210 1) posn: 251 115 setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(if (not (gCast contains: (ScriptID 210 2))) ; gabsMug
					((ScriptID 210 2) init:) ; gabsMug
				)
				(if (not ((ScriptID 210 3) isNotHidden:)) ; coffeePot
					((ScriptID 210 3) show:) ; coffeePot
				)
				(= cycles 1)
			)
			(101
				(for ((= local3 0)) (<= local3 100) ((+= local3 1))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(SetFlag 361)
				(ClearFlag 311)
				(SetFlag 10)
				(gKeyDownHandler delete: self)
				(= cycles 2)
			)
			(102
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance startOfDay2 of Script
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
				(gGame handsOff:)
				(gKeyDownHandler add: self)
				(ClearFlag 278)
				(SetFlag 10)
				(SetFlag 311)
				((ScriptID 210 1) ; graceProp
					init:
					view: 208
					setCel: 0
					setLoop: 1
					cycleSpeed: 8
					setCycle: End
				)
				(gEgo
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
				((ScriptID 210 1) setCel: 4 setLoop: 0 setCycle: Beg self) ; graceProp
			)
			(2
				(gMessager say: 11 0 36 1 self) ; "Good morning. Don't you look swell today...actually, swollen."
			)
			(3
				(gMessager say: 11 0 36 2) ; "(GRUNT PROTEST. PRE COFFEE NON-VERBAL.)Uhhh!!"
				(gEgo setCel: 0 setLoop: 1 posn: 271 151 setCycle: End self)
			)
			(4
				(gMessager say: 11 0 36 3) ; "So have some. There's a fresh pot on the table."
				(gEgo
					view: 901
					setSpeed: 6
					setCycle: StopWalk -1
					setMotion: MoveTo 137 138 self
				)
			)
			(5
				(gEgo
					view: 215
					setCel: 0
					setLoop: 0
					posn: 81 139
					setSpeed: 10
					setCycle: CT 1 1 self
				)
			)
			(6
				((ScriptID 210 2) dispose:) ; gabsMug
				(gEgo view: 215 setCel: 2 setLoop: 0 setCycle: End self)
			)
			(7
				(gEgo view: 215 setCel: 0 setLoop: 1 setCycle: CT 2 1 self)
			)
			(8
				((ScriptID 210 3) hide:) ; coffeePot
				(gEgo setCel: 3 setLoop: 1 setCycle: End self)
				(gGkSound1 number: 214 play:)
			)
			(9
				(gEgo setCel: 0 setLoop: 2 setCycle: CT 4 1 self)
			)
			(10
				((ScriptID 210 3) show:) ; coffeePot
				(gEgo setCel: 5 setLoop: 2 setCycle: End self)
			)
			(11
				(gEgo setCel: 0 setLoop: 5 posn: 81 141 setCycle: End self)
			)
			(12
				(gEgo
					view: 2151
					setCel: 0
					setLoop: 0
					posn: 150 123
					setCycle: Osc 1 self
				)
				(gMessager sayRange: 11 0 36 4 5 self) ; "Seriously, you look like hell. Your hair is sticking straight up like a.... Oh. It always does that. Never mind."
			)
			(13)
			(14
				(gEgo view: 215 setCel: 6 setLoop: 6)
				(gMessager sayRange: 11 0 36 6 14 self) ; "(RRCC. MORNING DIALOGUE LINE CHG. CURIOUS)Did you dream about the fire and the hanged guy and that lion thing last night?"
			)
			(15
				(ClearFlag 311)
				(gEgo view: 2151 setCel: 0 setLoop: 0 setCycle: Osc 1)
				(gMessager say: 11 0 36 15 self) ; "<sigh>Men."
			)
			(16
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(17
				(gEgo getPoints: 458 1)
				(gEgo setCel: 0 setLoop: 2)
				((ScriptID 210 2) init:) ; gabsMug
				(= cycles 1)
			)
			(18
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(gEgo setCel: 1 setLoop: 2 setCycle: CT 3 1 self)
			)
			(19
				(SetFlag 24)
				(gEgo
					normalize: 0 901
					posn: 127 137
					ignoreActors: 1
					setMotion: MoveTo 131 137 self
				)
			)
			(20
				(gKeyDownHandler delete: self)
				(gGame handsOn:)
				(self dispose:)
			)
			(99
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(for ((= local3 100)) (>= local3 0) ((-= local3 1))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(= cycles 5)
			)
			(100
				(gEgo
					normalize: 0 901
					ignoreActors: 1
					getPoints: 458 1
					posn: 131 137
				)
				((ScriptID 210 1) posn: 251 115 setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				(if (not (gCast contains: (ScriptID 210 2))) ; gabsMug
					((ScriptID 210 2) init:) ; gabsMug
				)
				(if (not ((ScriptID 210 3) isNotHidden:)) ; coffeePot
					((ScriptID 210 3) show:) ; coffeePot
				)
				(= cycles 1)
			)
			(101
				(for ((= local3 0)) (<= local3 100) ((+= local3 1))
					(Palette 2 0 255 local3) ; PalIntensity
				)
				(ClearFlag 311)
				(ClearFlag 278)
				(SetFlag 10)
				(SetFlag 24)
				(gKeyDownHandler delete: self)
				(= cycles 2)
			)
			(102
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance readIt2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 137) (!= (gEgo y:) 138))
					(gEgo setMotion: PolyPath 137 138 self)
				else
					(self cue:)
				)
			)
			(1
				((ScriptID 210 7) hide:) ; newsPaper
				(gEgo
					view: 214
					setCel: 0
					setLoop: 0
					posn: 136 120
					setCycle: CT 2 1 self
				)
			)
			(2
				(gGkSound1 number: 213 play:)
				(gEgo setCel: 3 setLoop: 0 posn: 136 120 setCycle: End self)
			)
			(3
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(gMessager say: 35 12 17 1 self 211) ; "Times Picayune, dated June 19, 1993. A front page article describes the most recent of the Voodoo Murders. Gabriel scans it but learns nothing new."
			)
			(5
				(gGkSound1 number: 213 play:)
				(gEgo setCel: 0 setLoop: 1 setCycle: Osc 1 self)
			)
			(6
				(gMessager sayRange: 35 12 17 2 3 self 211) ; "The article reiterates that the Voodoo aspect of the crimes is faked. Gabriel shivers. It looked real enough to him!"
			)
			(7
				(gGkSound1 number: 213 play:)
				(gEgo setCel: 0 setLoop: 1 setCycle: Osc 1 self)
			)
			(8
				(gMessager sayRange: 35 12 17 4 6 self 211) ; "Called "La Plaza d'Armas" under French rule, it was used for executions: firing squads, hangings, even impalement and breaking on the wheel. Yikes!"
			)
			(9
				(gGkSound1 number: 213 play:)
				(gEgo setCel: 0 setLoop: 1 setCycle: Osc 1 self)
			)
			(10
				(gMessager sayRange: 35 12 17 7 8 self 211) ; "Chances of a dark star rising on this day. Do not trust your instincts."
			)
			(11
				(Load rsVIEW 901)
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(12
				((ScriptID 210 7) show:) ; newsPaper
				(gEgo
					normalize: 2 901
					ignoreActors: 1
					posn: 137 138
					getPoints: 142 1
				)
				(= cycles 2)
			)
			(13
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 211)
			)
		)
	)
)

(instance getSomeCoffee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 137) (!= (gEgo y:) 138))
					(gEgo setMotion: PolyPath 137 138 self)
				else
					(self cue:)
				)
			)
			(1
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(Load 140 214) ; WAVE
				)
				(gEgo
					view: 215
					setCel: 0
					setLoop: 0
					posn: 81 139
					setSpeed: 10
					setCycle: CT 1 1 self
				)
			)
			(2
				((ScriptID 210 2) dispose:) ; gabsMug
				(gEgo setCel: 2 setLoop: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				((ScriptID 210 3) hide:) ; coffeePot
				(gEgo loop: 1 cel: 3 setCycle: End self)
				(gGkSound1 number: 214 play:)
			)
			(5
				(gEgo loop: 2 setCycle: End self)
			)
			(6
				((ScriptID 210 3) show:) ; coffeePot
				(= seconds 3)
			)
			(7
				(gEgo loop: 3 setCycle: End self)
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(gMessager say: 19 12 13 1 self 211) ; "Mmmm. Good coffee."
			)
			(10
				(gEgo loop: 4 cel: 0 setCycle: CT 3 1 self)
			)
			(11
				((ScriptID 210 2) posn: 86 120 setPri: 14 init:) ; gabsMug
				(gEgo loop: 4 cel: 4 setCycle: End self)
			)
			(12
				(gGame handsOn:)
				(gEgo normalize: 0 901 ignoreActors: 1)
				(self dispose:)
				(DisposeScript 211)
			)
		)
	)
)

(instance enterFlorist of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 217)
				(Load rsVIEW 2173)
				(Load rsVIEW 901)
				(if (gEgo inRect: 71 82 171 125)
					(gEgo setMotion: PolyPath 160 125)
					(= cycles 15)
				else
					(self cue:)
				)
			)
			(1
				(Load rsVIEW 2171)
				((ScriptID 210 21) hide:) ; shopDoor
				(gGkSound1 number: 373 setLoop: 1 play:)
				(florist
					view: 217
					setCel: 0
					setLoop: 1
					init:
					posn: 92 95
					ignoreActors: 1
					setCycle: End self
				)
			)
			(2
				(gGkSound1 number: 374 setLoop: 1 play:)
				((ScriptID 210 21) show:) ; shopDoor
				((ScriptID 210 4) dispose:) ; graceDoStuff
				(florist
					setCel: 0
					setLoop: 0 1
					setCycle: Walk
					posn: 103 101
					xStep: 4
					yStep: 3
					setMotion: MoveTo 128 108 self
				)
				(floristTeller init:)
			)
			(3
				(Face gEgo florist)
				((ScriptID 210 1) ; graceProp
					setCel: 4
					setLoop: 0
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(4
				(if (IsFlag 240)
					(gMessager sayRange: 11 0 55 1 3 self) ; "Hey, kids!"
				else
					(gMessager sayRange: 11 0 54 1 7 self) ; "Hey, kids!"
				)
			)
			(5
				(florist
					view: 217
					setCel: 0
					setLoop: 0 1
					setCycle: Walk
					setMotion: MoveTo 210 107 self
				)
			)
			(6
				(florist view: 2173 setCel: 0 setLoop: 0 setCycle: End self)
			)
			(7
				(if (IsFlag 240)
					(gMessager say: 11 0 55 4 self) ; "Gabe, pet, I just popped in to see if you're desperate enough to sell me that painting."
				else
					(gMessager say: 11 0 54 8 self) ; "That explains why I so RAREly see anyone in here. Are you going to sell me that wonderful painting of yours today?"
				)
			)
			(8
				(gEgo ignoreActors: 1 setMotion: PolyPath 277 106 self)
			)
			(9
				(gEgo view: 2171 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(10
				(= seconds 3)
			)
			(11
				(gEgo setCel: 0 setLoop: 0 setCycle: End self)
			)
			(12
				(floristTeller doVerb: 11)
			)
			(13
				(if local0
					(gMessager sayRange: 7 2 22 1 2 self) ; "Forget it, Bruno. Not for a hundred. Not now."
				else
					(self cue:)
				)
			)
			(14
				(gEgo normalize: 1 901 ignoreActors: 1)
				(florist view: 2173 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(15
				(florist
					view: 217
					setCel: 0
					setLoop: 2 1
					setCycle: Walk
					setMotion: MoveTo 144 112 self
				)
			)
			(16
				(florist setMotion: PolyPath 103 103 self)
			)
			(17
				(gGkSound1 number: 373 setLoop: 1 play:)
				(florist setCel: 0 setLoop: 3 setCycle: End self)
				((ScriptID 210 21) hide:) ; shopDoor
			)
			(18
				(gGkSound1 number: 374 setLoop: 1 play:)
				(if local0
					(gMessager sayRange: 7 2 22 3 4 self) ; "(ANGRY, FLUSTERED, TRYING TO THINK OF A COME-BACK)Yeah? Well...I'll show you wanting it!"
				else
					(self cue:)
				)
			)
			(19
				((ScriptID 210 21) show:) ; shopDoor
				(floristTeller dispose:)
				(florist dispose:)
				(SetFlag 240)
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				((ScriptID 210 11) client: 0) ; entranceTimer
				((ScriptID 210 11) dispose: delete:) ; entranceTimer
				(= cycles 2)
			)
			(20
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 211)
			)
		)
	)
)

(instance takeThePainting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 2172)
				(gMessager sayRange: 7 2 15 1 3 self) ; "(AGREEING, BUT VERY RELUCTANTLY. ANGRY)Fine. It's yours."
				(gEgo setCel: 0 setLoop: 3 setCycle: End self)
			)
			(1)
			(2
				(florist view: 2171 setCel: 0 setLoop: 6 setCycle: End)
				(gEgo view: 2171 setCel: 0 setLoop: 4 setCycle: End self)
				(gEgo getPoints: -999 2)
			)
			(3
				(gMessager sayRange: 7 2 15 4 6 self) ; "(WARNING TONE)You'd better take good care of this, Bruno. This is not just another of your hip art pieces, you know."
			)
			(4
				(gEgo
					setCel: 0
					setLoop: 5
					cycleSpeed: 11
					setCycle: CT 5 1 self
				)
			)
			(5
				((ScriptID 210 10) dispose:) ; painting
				(gEgo setCel: 6 setLoop: 5 get: 30 setCycle: CT 8 1 self) ; hundred
			)
			(6
				(florist setCel: 0 setLoop: 7 setCycle: End)
				(gEgo setCel: 9 setLoop: 5 setCycle: End self)
			)
			(7
				(gEgo normalize: 1 901 ignoreActors: 1)
				(florist
					view: 2172
					setCel: 0
					setLoop: 0 1
					setCycle: Walk
					cycleSpeed: 6
					setMotion: MoveTo 144 112 self
				)
			)
			(8
				(florist
					ignoreActors: 1
					setCycle: StopWalk -1
					setMotion: PolyPath 103 103 self
				)
			)
			(9
				(gGkSound1 number: 373 setLoop: 1 play:)
				(florist setCel: 0 setLoop: 1 setCycle: End self)
				(UpdateScreenItem florist)
				((ScriptID 210 21) hide:) ; shopDoor
			)
			(10
				(gGkSound1 number: 374 setLoop: 1 play:)
				((ScriptID 210 21) show:) ; shopDoor
				(SetFlag 289)
				(florist dispose:)
				(gEgo setMotion: PolyPath 235 127 self)
			)
			(11
				(Face gEgo (ScriptID 210 1) self) ; graceProp
			)
			(12
				(gMessager sayRange: 7 2 15 7 8 self) ; "(PISSED. PAUSE BETWEEN DON'T AND BELIEVE)I don't believe you."
			)
			(13
				((ScriptID 210 1) setScript: (ScriptID 210 4)) ; graceProp, graceDoStuff
				((ScriptID 210 11) client: 0) ; entranceTimer
				((ScriptID 210 11) dispose: delete:) ; entranceTimer
				((ScriptID 215 27) init:) ; xbehindPic
				(= cycles 2)
			)
			(14
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 211)
			)
		)
	)
)

(instance floristTeller of GKTeller
	(properties
		curNoun 6
		sayNoun 7
		verb 2
	)

	(method (showCases)
		(super showCases: 20 (IsFlag 35) 21 (not (IsFlag 35))) ; How much would you give me for it?, How much would you give me for it?
	)

	(method (cue)
		(cond
			(
				(or
					(== iconValue 16) ; Well...I guess I don't need the money that badly.
					(== iconValue 18) ; Are you ready to drop dead today?
					(== iconValue 21) ; How much would you give me for it?
					(== iconValue 19) ; Gee, is today the day that hell freezes over?
				)
				(enterFlorist cue:)
			)
			((not (== iconValue 15)) ; "(AGREEING, BUT VERY RELUCTANTLY. ANGRY)Fine. It's yours."
				(self doVerb: 11)
			)
		)
	)

	(method (sayMessage)
		(cond
			((== iconValue 15) ; "(AGREEING, BUT VERY RELUCTANTLY. ANGRY)Fine. It's yours."
				(gEgo setScript: takeThePainting)
				(self dispose:)
				(enterFlorist dispose:)
			)
			((== iconValue 22) ; "Forget it, Bruno. Not for a hundred. Not now."
				(= local0 1)
				(enterFlorist cue:)
			)
			(else
				(super sayMessage:)
			)
		)
	)

	(method (doVerb)
		(= local2 (gGame setCursor:))
		(SetCursor -2)
		(gGame setCursor: myArrowCursor 1)
		(while 1
			(if (self respond:)
				(break)
			)
		)
		(SetCursor 0 0 319 153)
		(gGame setCursor: local2 1)
		(return 1)
	)
)

(instance florist of Actor
	(properties
		noun 6
		x 210
		y 107
		view 2173
	)
)

(instance myArrowCursor of Cursor
	(properties
		view 999
	)
)

