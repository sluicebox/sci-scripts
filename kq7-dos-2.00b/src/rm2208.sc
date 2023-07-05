;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2208)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use n777)
(use Talker)
(use Scaler)
(use ROsc)
(use Osc)
(use PolyPath)
(use Polygon)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2208 0
	valTalker 1
)

(instance rm2208 of KQRoom
	(properties
		picture 2200
	)

	(method (init)
		(super init: &rest)
		(extraSnd init:)
		(extraSnd2 init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 108 133 129 127 102 115 96 110 139 99 132 97 119 102 105 102 91 97 73 95 51 104 53 111 68 110
					yourself:
				)
		)
		(Load rsMESSAGE 2200)
		(Load rsVIEW 2241 2242 22131 2214)
		(gEgo disableHotspot:)
		(self setScript: grandFinale)
	)

	(method (dispose)
		(edgerLifeTimer client: 0 delete: dispose:)
		(extraSnd stop:)
		(extraSnd2 stop:)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
		(super dispose: &rest)
	)
)

(instance grandFinale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 2264 2265) ; WAVE
				(gEgo
					posn: 91 112
					normalize: 4 2241
					setSpeed: 6
					setScaler: Scaler 90 90 145 101
					init:
				)
				(king
					posn: 210 112
					view: 2213
					setPri: 122
					setLoop: 2 1
					setCel: 0
					init:
				)
				(if (IsFlag 258)
					(if (IsFlag 259)
						(theDevice init: setCycle: Fwd)
					else
						(theDevice init: setLoop: 0 1 cel: 5)
					)
				)
				(gauge cel: (- (NumCels gauge) 1) init:)
				(= cycles 2)
			)
			(1
				(Load 140 922) ; WAVE
				(king setScript: kingBeatsConsole self)
			)
			(2
				(extraSnd2 number: 2264 setLoop: 1 play:)
				(proc777_0 gThePlane 1 3)
				(= cycles 8)
			)
			(3
				(proc777_0 gThePlane 1 2)
				(= cycles 6)
			)
			(4
				(extraSnd2 fade: 0 5 5 1)
				(gauge setScript: gaugeSubsides)
				(king
					posn: 196 117
					view: 2214
					setLoop: 0 1
					setCel: 0
					setPri: 119
					setCycle: End self
				)
				(lever setPri: 122)
			)
			(5
				(= ticks 45)
			)
			(6
				(gEgo view: 2242 setLoop: 0 1 cel: 0 setCycle: Fwd)
				(king posn: 209 117 setLoop: 2 1 setCel: 0 setCycle: Fwd)
				(extraSnd2 number: 2265 setLoop: 1 play:)
				(= ticks 340)
			)
			(7
				(if (< (gEgo cel:) (- (NumCels gEgo) 1))
					(gEgo setCycle: End)
				)
				(if (< (king cel:) (- (NumCels king) 1))
					(king setCycle: End self)
				else
					(= ticks 1)
				)
			)
			(8
				(gKqMusic1 number: 2208 setLoop: -1 play: setVol: 127)
				(val
					view: 2215
					setLoop: 0 1
					setCel: 0
					posn: 195 126
					init:
					setCycle: End self
				)
			)
			(9
				(king posn: 210 114 view: 22150 setLoop: 0 1 setCel: 0)
				(extraSnd2 number: 2268 setLoop: 1 play:)
				(= ticks 30)
			)
			(10
				(extraSnd2 number: 2267 setLoop: 1 play:)
				(king setCycle: End)
				(val posn: 216 133 setLoop: 2 1 setCel: 0 setCycle: CT 5 1 self)
				(edger
					view: 22151
					loop: 0
					cel: 0
					posn: 326 117
					setPri: 125
					init:
					setCycle: End
				)
			)
			(11
				(gEgo hide:)
				(val cel: 6 setCycle: End self)
				(UpdateScreenItem val)
			)
			(12
				(val hide:)
				(gEgo
					setScale: 0
					posn: 101 120
					view: 2215
					setLoop: 3 1
					setCel: 0
					show:
					setCycle: End self
				)
			)
			(13
				(gEgo
					posn: 101 121
					setLoop: 4 1
					setCel: 0
					setCycle: End self
				)
			)
			(14
				(gEgo
					posn: 102 119
					setLoop: 6 1
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(15
				(extraSnd2 stop:)
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(valTalker client: gEgo loop: 27)
				(gMessager say: 0 0 7 1 self 2200) ; "(WHISPERING, CRYING, OVERCOME WITH EMOTION)My daughter...I though I'd never see you again."
			)
			(16
				(gMessager say: 0 0 7 2 self 2200) ; "Mama, I'm so sorry...I saw the castle, and I jumped in to see, and the Troll King--I mean Edgar--"
			)
			(17
				(gMessager say: 0 0 7 3 self 2200) ; ""(QUESTIONING)Edgar...?"
			)
			(18
				(valTalker client: val)
				(gEgo setCycle: End)
				(edger
					posn: 250 124
					view: 2216
					setLoop: 0 1
					setCel: 0
					setPri: -1
					setCycle: End self
				)
			)
			(19
				(gEgo
					posn: 100 118
					setLoop: 7 1
					setCel: 0
					setCycle: CT 19 1 self
				)
				(edger
					posn: 192 128
					setLoop: 1 1
					setCel: 0
					setPri: 122
					setCycle: End
				)
				(extraSnd2 number: 2268 setLoop: 1 play:)
			)
			(20
				(edger
					posn: 124 118
					setLoop: 2 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(21
				(gEgo hide:)
				(edger setCel: 3 setCycle: End self)
				(UpdateScreenItem edger)
				(val
					view: 2215
					setLoop: 7 1
					setCel: 20
					posn: 100 118
					show:
					setCycle: End
				)
			)
			(22
				(king setScript: kingApplauds self)
			)
			(23
				(king setScript: kingReacts)
				(malicia
					init:
					posn: 237 134
					view: 2203
					setLoop: 0 1
					setCel: 0
					setPri: 130
					setCycle: End self
				)
				(extraSnd2 number: 816 setLoop: 1 play: setVol: 127)
				(gKqMusic1 number: 941 setLoop: -1 play: setVol: 127)
			)
			(24
				(malicia posn: 230 133 view: 2218 setCel: 0 setLoop: 0 1)
				(UpdateScreenItem malicia)
				(edger posn: 128 117 setLoop: 4 1 setCel: 0 setCycle: End self)
			)
			(25
				(malicia cycleSpeed: 12 setCycle: End self)
			)
			(26
				(edger
					posn: 140 121
					view: 22170
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
				(gEgo
					posn: 92 119
					view: 2217
					setLoop: 2 1
					cel: 0
					show:
					setCycle: End
				)
				(val
					posn: 82 102
					view: 2217
					setLoop: 1 1
					setCel: 0
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
			)
			(27
				((ScriptID 7001 4) ; edgerTalker
					client: edger
					view: (edger view:)
					loop: (+ (edger loop:) 20)
				)
				((ScriptID 7001 1) ; maliciaTalker
					client: malicia
					view: (malicia view:)
					loop: (+ (malicia loop:) 20)
				)
				(gMessager say: 0 0 7 4 self 2200) ; "(QUIET BUT FURIOUS)No. You'll not touch her."
			)
			(28
				(gMessager say: 0 0 7 5 self 2200) ; "(FURIOUS, SCREECHING)Out of my way, whelp! I enslaved your little mind once. Don't think I'll be so kind this time."
			)
			(29
				(gMessager say: 0 0 7 6 self 2200) ; "(SNARLING)Never again, Malicia!"
			)
			(30
				(malicia
					posn: 238 132
					setLoop: 1 1
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(31
				(malicia posn: 248 128 setLoop: 2 1 setCel: 0)
				(Load rsVIEW 2219)
				(Load 140 845 845 2271 2269 22690) ; WAVE
				(Load rsSOUND 2270)
				(= ticks 60)
			)
			(32
				(malicia
					posn: 251 130
					setLoop: 3 1
					setCel: 0
					setCycle: End self
				)
			)
			(33
				(edger
					posn: 138 134
					view: 2219
					setLoop: 0 1
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(34
				(extraSnd2 number: 2269 setLoop: 1 play:)
				(edger setCycle: End self)
			)
			(35
				(extraSnd number: 22690 setLoop: 1 play:)
				(malicia
					posn: 223 135
					view: 22190
					setLoop: 1 1
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(36
				(extraSnd2 number: 845 setLoop: 1 play:)
				(malicia setCycle: CT 11 1 self)
			)
			(37
				(malicia setCycle: End)
				(edger
					posn: 137 132
					setLoop: 2 1
					setCel: 0
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
				(extraSnd2 number: 2271 setLoop: 1 play:)
			)
			(38
				(edger setCycle: End)
				(blast
					init:
					cel: 0
					setPri: (- (malicia priority:) 1)
					setCycle: CT 6 1 self
				)
			)
			(39
				(= cycles (blast cycleSpeed:))
			)
			(40
				(extraSnd number: 22690 setLoop: 1 play:)
				(extraSnd2 stop:)
				(malicia hide:)
				(blast setCel: 7 setCycle: End self)
				(UpdateScreenItem blast)
			)
			(41
				(blast dispose:)
				(malicia show: view: 22191 posn: 233 132 setLoop: 4 1 setCel: 0)
				(= ticks 20)
			)
			(42
				(malicia setCycle: End self)
			)
			(43
				(edger
					view: 22192
					posn: 131 132
					setLoop: 5 1
					setCel: 0
					setPri: -1
					setCycle: End self
				)
			)
			(44
				(Load 140 865 843 22711) ; WAVE
				(= ticks 45)
			)
			(45
				(edger
					posn: 103 132
					setLoop: 6 1
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(46
				(gEgo hide:)
				(edger setCel: 5 setCycle: End self)
				(UpdateScreenItem edger)
			)
			(47
				(malicia
					posn: 255 131
					view: 2220
					setLoop: 0 1
					setCel: 0
					setCycle: CT 11 1 self
				)
				(extraSnd2 number: 843 setLoop: 1 play:)
			)
			(48
				(edger
					posn: 79 130
					view: 22200
					setLoop: 1 1
					setCel: 0
					setCycle: CT 5 1 self
				)
				(malicia setCycle: End)
				(extraSnd number: 22711 setLoop: 1 play:)
			)
			(49
				(SetFlag 254)
				(extraSnd2 number: 865 setLoop: 1 play:)
				(edger setCel: 6 setCycle: End self)
				(gEgo setScale: 0 show:)
			)
			(50
				(gEgo
					setScale:
					scaleX: 134
					scaleY: 134
					posn: 94 120
					view: 22202
					setLoop: 4 1
					setCel: 0
					setCycle: CT 2 1
				)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(val
					posn: 66 124
					view: 22202
					setLoop: 5 1
					setCel: -1
					setCycle: Beg
				)
				(malicia
					posn: 246 131
					view: 22201
					setLoop: 2 1
					setCel: 0
					setCycle: End
				)
				(gMessager say: 0 0 7 7 self 2200) ; "(ANGUISHED SCREAM)EDGAR!"
			)
			(51
				(= ticks 45)
			)
			(52
				(gEgo setCycle: End self)
			)
			(53
				(SetFlag 254)
				(gEgo
					normalize: 4 2241
					setSpeed: 6
					setScaler: Scaler 90 90 145 101
				)
				(edger ignoreActors: 1 setPri: 90)
				(malicia setScript: malMovesForKill)
				(self dispose:)
			)
		)
	)
)

(instance malMovesForKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 2272) ; WAVE
				(gGame handsOn:)
				(client
					view: 22201
					posn: 265 137
					setLoop: 3 1
					setCel: 0
					setCycle: End self
				)
				(extraSnd2 number: 2272 setLoop: 1 play:)
			)
			(1
				(client
					view: 22210
					setLoop: 3 1
					setCel: 0
					posn: 264 76
					setMotion: MoveTo 181 76 self
					setCycle: Fwd
				)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(extraSnd2 number: 22720 setLoop: -1 play:)
				(client
					view: 2203
					posn: 174 128
					setLoop: 1 1
					setCel: 2
					setCycle: ROsc 101 2 5
				)
				(= seconds 10)
			)
			(4
				(gGame handsOff:)
				(gEgo setScript: 0 setMotion: 0)
				(malicia deleteHotspot:)
				(self setScript: malKills self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance edLives of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (doit)
		(super doit: &rest)
		(if (and register (not (gEgo script:)))
			(= register 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(edger deleteHotspot: setPri: -1)
				(malicia setPri: (+ (edger y:) 2))
				(= cycles 2)
			)
			(1
				(gEgo
					setPri: (+ (edger priority:) 1)
					setMotion: MoveTo 102 128 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 117 124 self)
			)
			(3
				(gEgo setHeading: 45 self)
			)
			(4
				(gEgo
					view: 2228
					setLoop: 0 1
					setCel: 0
					posn: 124 128
					setCycle: End self
				)
			)
			(5
				(SetFlag 252)
				(gEgo put: 58 setScript: roseBacksUp) ; Extra_Life
				(edger
					view: 2228
					setLoop: 1 1
					cel: 0
					posn: 141 123
					setCycle: End self
				)
				(extraSnd2 number: 2281 setLoop: 1 play: setVol: 127)
			)
			(6
				(edger
					view: 2228
					setLoop: 2 1
					cel: 0
					posn: 136 123
					setCycle: End self
				)
			)
			(7
				(gKqMusic1 number: 2282 setLoop: -1 play: setVol: 127)
				(edger
					view: 2228
					setLoop: 3 1
					setCel: 0
					posn: 149 121
					setCycle: End self
				)
			)
			(8
				(= register 1)
			)
			(9
				(gEgo
					view: 2244
					setLoop: 0 1
					setCel: (- (NumCels gEgo) 1)
					posn: 129 125
					setCycle: CT (- (NumCels gEgo) 5) -1 self
				)
			)
			(10
				(gEgo hide:)
				(edger
					view: 2228
					setLoop: 4 1
					setCel: 0
					posn: 137 123
					setCycle: End self
				)
				(UpdateScreenItem edger)
			)
			(11
				(titania
					init:
					setCel: 0
					setPri: (+ (malicia priority:) 1)
					setCycle: CT 11 1 self
				)
			)
			(12
				(malicia setPri: 90)
				(titania setCycle: End self)
			)
			(13
				(oberon init: setCel: 0 setCycle: End)
				(edger
					view: 2230
					setLoop: 0 1
					setCel: 0
					posn: 146 111
					setCycle: End self
				)
				(gEgo
					view: 2244
					setLoop: 0 1
					setCel: 0
					posn: 121 115
					setScale:
					scaleX: 115
					scaleY: 115
					show:
					setCycle: End
				)
			)
			(14
				(titania
					view: 2230
					setLoop: 1 1
					setCel: 0
					posn: 141 131
					setCycle: End
				)
				((ScriptID 7001 10) client: titania hide_mouth: 1) ; titaniaTalker
				(gMessager say: 0 0 10 1 self 2200) ; "(EMOTIONAL, TO HER SON)I thought we'd never see you again..."
			)
			(15
				(gEgo posn: 102 115 normalize: 4 2241 setSpeed: 6)
				(edger
					setLoop: 2 1
					setCel: 0
					posn: 140 126
					setCycle: CT 4 1 self
				)
			)
			(16
				(= cycles 6)
			)
			(17
				(titania hide:)
				(edger cel: 5)
				(UpdateScreenItem edger)
				(= cycles 2)
			)
			(18
				(edger setLoop: 3 1 setCel: 0 posn: 138 128 setCycle: End self)
			)
			(19
				(oberon setLoop: 3 1 setCel: 0 posn: 228 134 setCycle: End self)
			)
			(20
				(edger
					view: 22305
					setLoop: 6 1
					setCel: 0
					posn: 149 138
					setPri: (- (oberon priority:) 1)
					setCycle: CT 5 1 self
				)
				(titania
					setLoop: 4 1
					setCel: 0
					posn: 138 128
					show:
					setCycle: End
				)
			)
			(21
				(= cycles 6)
			)
			(22
				(oberon hide:)
				(edger cel: 6 setPri: -1 setCycle: End self)
				(UpdateScreenItem edger)
			)
			(23
				(val
					view: 2245
					setLoop: 8 1
					setCel: 4
					setScale:
					scaleX: 115
					scaleY: 115
				)
				(titania
					view: 22361
					setLoop: 7 1
					setCel: -1
					posn: 121 124
					setCycle: Beg self
				)
			)
			(24
				(gKqMusic1 fade: 65 25 10 0)
				((ScriptID 7001 0) client: king hide_mouth: 1) ; kingTalker
				((ScriptID 7001 9) ; oberonTalker
					client: edger
					view: (edger view:)
					loop: (+ (edger loop:) 20)
				)
				((ScriptID 7001 10) ; titaniaTalker
					client: titania
					view: (titania view:)
					loop: (+ (titania loop:) 20)
					hide_mouth: 0
				)
				((ScriptID 7001 4) ; edgerTalker
					client: edger
					view: (edger view:)
					loop: (+ (edger loop:) 21)
				)
				(valTalker loop: 28)
				(gMessager say: 0 0 10 2 self 2200) ; "(SINCERELY)Valanice, I cannot thank you enough. You have not only saved our world, you have given us back our greatest treasure. Our son."
			)
			(25
				(gMessager say: 0 0 10 3 self 2200) ; "(CONFUSED)Your son? Edgar?"
			)
			(26
				(gMessager say: 0 0 10 4 self 2200) ; "(CONFUSED)You...know our son?"
			)
			(27
				(king
					posn: 209 117
					view: 2214
					setLoop: 2 1
					setCel: 0
					setCycle: ROsc 1 0 10
				)
				(gMessager say: 0 0 10 5 self 2200) ; "(LAUGHS)"
			)
			(28
				(king setCycle: 0 posn: 210 114 view: 22150 setLoop: 0 1)
				(king cel: (- (NumCels king) 1))
				(gMessager say: 0 0 10 6 self 2200) ; "(UNSURE)Well...you see...I was stolen as a baby, by an evil faerie named Lolotte. She twisted my body and tried to twist my mind, but somehow I know I was not her son...then Rosella appeared. I--knew she was special. She released me from my slavery to Lolotte, and I went home to Etheria."
			)
			(29
				(gMessager say: 0 0 10 7 self 2200) ; "(PAIN IN HER VOICE, VOICE BREAKS ON LAST LINE)We were so happy! The whole kingdom was overjoyed. We held a ball in our son's honor--"
			)
			(30
				(gMessager say: 0 0 10 8 self 2200) ; "(STRONG, BUT PAIN IN HIS VOICE. VOICE GETS COLD ON LAST LINE)Our boy vanished from the gardens on the night of the party. We were crushed. We set off to search for him immediately. Now I know it was all part of Malicia's evil plot."
			)
			(31
				(malicia
					view: 22305
					setLoop: 8 1
					setCel: 0
					posn: 150 144
					setCycle: End self
				)
			)
			(32
				(titania setCycle: Beg self)
			)
			(33
				(titania
					view: 22305
					setLoop: 7 1
					setCel: 0
					posn: 149 138
					show:
					setCycle: CT 10 1 self
				)
			)
			(34
				(= cycles 6)
			)
			(35
				(malicia hide:)
				(titania setPri: 100 setCycle: End self)
				(UpdateScreenItem titania)
				(extraSnd2 number: 2284 setLoop: 1 play:)
				(= ticks 200)
			)
			(36)
			(37
				(gMessager say: 0 0 10 9 self 2200) ; "(SOFTLY, FORGIVING)Something went terribly wrong with you, my sister. Let us start over again, shall we?"
			)
			(38
				(extraSnd2 number: 2277 setLoop: 1 play:)
				(edger
					view: 2231
					setLoop: 0 1
					setCel: 0
					posn: 155 137
					setPri: 117
					setCycle: End self
				)
				(oberon view: 2230 setLoop: 5 1 setCel: 11 posn: 167 118 show:)
			)
			(39
				(gEgo setMotion: MoveTo 121 114 self)
			)
			(40
				(edger
					setLoop: 2 1
					setCel: 0
					posn: 154 138
					ignoreActors: 0
					setCycle: End self
				)
				(gEgo
					view: 2231
					setLoop: 1 1
					setCel: 0
					posn: 150 140
					setPri: (- (edger priority:) 1)
					setCycle: End
				)
			)
			(41
				((ScriptID 7001 0) hide_mouth: 0) ; kingTalker
				(gCurRoom newRoom: 2210)
			)
		)
	)
)

(instance roseBacksUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 2250
					setLoop: 0 1
					setCel: 0
					posn: 131 124
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 2244
					setLoop: 0 1
					setCel: 0
					posn: 136 124
					setCycle: End self
				)
			)
			(2
				(gEgo setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance edDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScript: rosMovesAway self)
			)
			(1
				(edger deleteHotspot: setPri: -1)
				(malicia setPri: (+ (edger y:) 1))
				(ghostEd init: cel: 0 setCycle: End self)
				(extraSnd2 number: 2280 setLoop: 1 play:)
			)
			(2
				(ghostEd hide: dispose:)
				(= cycles 2)
			)
			(3
				(gKqMusic1 number: 2285 setLoop: -1 play: setVol: 127)
				(titania
					init:
					view: 2236
					setLoop: 0 1
					setCel: 0
					posn: 166 137
					setPri: (+ (malicia priority:) 1)
					setCycle: CT 31 1 self
				)
				(king posn: 210 114 view: 22150 setLoop: 0 1)
				(king setCel: (- (NumCels king) 1) setCycle: CT 4 -1)
			)
			(4
				(titania
					setPri: (- (edger priority:) 2)
					cel: 32
					setCycle: CT 50 1 self
				)
			)
			(5
				(edger hide:)
				(titania setCel: 51 setCycle: End self)
				(UpdateScreenItem titania)
			)
			(6
				(extraSnd2 number: 2286 setLoop: 1 play: setVol: 127)
				(titsMouth
					init:
					posn: (titania x:) (titania y:)
					setPri: (+ (titania priority:) 1)
					setCycle: Fwd
				)
				(oberon
					init:
					view: 22360
					setLoop: 1 1
					setCel: 0
					posn: 191 130
					setPri: (+ (malicia priority:) 1)
					setCycle: End self
				)
			)
			(7
				(oberon setLoop: 2 1 setCel: 0 posn: 191 128 setCycle: End self)
			)
			(8
				(oberon setLoop: 3 1 setCel: 0 posn: 141 130 setCycle: End self)
			)
			(9
				(= ticks 90)
			)
			(10
				(oberon
					setLoop: 6 1
					setCel: 0
					posn: 127 128
					setCycle: CT 2 1 self
				)
			)
			(11
				(titsMouth setCycle: 0 hide: dispose:)
				(oberon cel: 3 setCycle: End)
				(extraSnd2 stop:)
				(titania
					view: 22361
					setLoop: 5 1
					setCel: 0
					posn: 148 126
					setCycle: CT 4 1 self
				)
			)
			(12
				(titania cel: 5 setCycle: End self)
				(edger show:)
			)
			(13
				(titania
					setLoop: 7 1
					setCel: 0
					posn: 158 120
					setCycle: End self
				)
				(oberon setLoop: 8 1 setCel: 0 posn: 157 148 setCycle: End)
			)
			(14
				(oberon
					view: 22305
					setLoop: 9 1
					setCel: 3
					posn: 100 131
					setCycle: CT 2 -1 self
				)
			)
			(15
				((ScriptID 7001 0) client: king hide_mouth: 1) ; kingTalker
				((ScriptID 7001 9) client: oberon view: (oberon view:) loop: 29) ; oberonTalker
				((ScriptID 7001 10) client: titania hide_mouth: 1) ; titaniaTalker
				((ScriptID 7001 4) hide_mouth: 1) ; edgerTalker
				(valTalker view: (val view:) loop: 27)
				(gKqMusic1 fade: 65 25 10 0)
				(gMessager say: 0 0 11 1 self 2200) ; "(DEEPLY SORROWFUL)We thank you for saving our world, my lady."
			)
			(16
				(gMessager say: 0 0 11 2 self 2200) ; "(SOFTLY, HEARTBROKEN)My son..."
			)
			(17
				(gMessager say: 0 0 11 3 self 2200) ; "(ASTONISHED AND SAD)Edgar...was your son?"
			)
			(18
				(gMessager say: 0 0 11 4 self 2200) ; "(DEEPLY SORROWFUL)Yes. He was first taken from us as a babe, by an evil faerie named Lolotte. It was your valient daughter who freed him, and we were a family once more. Then--then he vanished again at his own homecoming celebration. I know now it was all part of Malicia's evil plot."
			)
			(19
				(titania
					view: 2237
					setLoop: 0 1
					setCel: 0
					posn: 145 120
					setCycle: End self
				)
			)
			(20
				((ScriptID 7001 10) ; titaniaTalker
					client: titania
					view: (titania view:)
					loop: 20
					hide_mouth: 0
				)
				(gMessager say: 0 0 11 5 self 2200) ; "(FURIOUS, HEARTBROKEN)Monster...MONSTER! How could you?"
			)
			(21
				(malicia
					view: 2237
					setLoop: 1 1
					setCel: 0
					posn: 148 124
					setCycle: End self
				)
			)
			(22
				(oberon
					view: 2237
					setLoop: 2 1
					setCel: 0
					posn: 134 129
					setCycle: End self
				)
			)
			(23
				((ScriptID 7001 9) hide_mouth: 1) ; oberonTalker
				(gMessager say: 0 0 11 6 self 2200) ; "(GENTLY, IN GREAT PAIN)No, my love. No. Whatever Malicia was...she is no more. Can't you see this is only an innocent babe?"
			)
			(24
				(oberon setCycle: Beg self)
			)
			(25
				(titania
					setLoop: 3 1
					setCel: 0
					posn: 151 122
					cycleSpeed: 8
					setCycle: End self
				)
				(extraSnd2 number: 2287 setLoop: 1 play:)
			)
			(26
				(edger ignoreActors: 1)
				(malicia ignoreActors: 1)
				(titania ignoreActors: 1 setMotion: MoveTo 156 127 self)
			)
			(27
				(malicia ignoreActors: 0)
				(edger ignoreActors: 0 hide:)
				(titania
					ignoreActors: 0
					setLoop: 4 1
					setCel: 0
					posn: 158 124
					setCycle: CT 1 1 self
				)
			)
			(28
				(malicia hide:)
				(titania cel: 2 setCycle: End self)
				(UpdateScreenItem titania)
			)
			(29
				(= ticks 30)
			)
			(30
				((ScriptID 7001 10) loop: 24) ; titaniaTalker
				(gMessager say: 0 0 11 7 self 2200) ; "(SOB)"
			)
			(31
				(gMessager say: 0 0 11 8 self 2200) ; "(SOFTLY, HEARTBROKEN)Something went terribly wrong with you, my sister. Let us start over again."
			)
			(32
				(gMessager say: 0 0 11 9 self 2200) ; "(SADLY)Come, lady Valanice, lady Rosella. We will take you home."
			)
			(33
				(edger show:)
				(titania
					setLoop: 5 1
					setCel: 0
					posn: 180 146
					cycleSpeed: 6
					setCycle: Osc 3 self
				)
			)
			(34
				((ScriptID 7001 0) hide_mouth: 0) ; kingTalker
				(gCurRoom newRoom: 34)
				(self dispose:)
			)
		)
	)
)

(instance rosMovesAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 92 104 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance shootMal of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (doit)
		(if
			(and
				register
				(malicia script:)
				(== (malicia script:) malMovesForKill)
				(> ((malicia script:) state:) 1)
			)
			(= register 0)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 80 109 self)
			)
			(1
				(= register 1)
			)
			(2
				(malicia deleteHotspot: setScript: 0 setMotion: 0)
				(gEgo
					setScale: 0
					posn: 80 109
					view: 2221
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(if (IsFlag 259)
					(gEgo setScript: transformMal)
				else
					(gEgo setScript: fizzleOut)
				)
				(self dispose:)
			)
		)
	)
)

(instance unplugDevice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 2243
					setLoop: 1 1
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(gEgo get: 62 setCycle: CT 0 -1 self) ; Device
				(theDevice hide: dispose:)
			)
			(2
				(gEgo normalize: 7 2241 setSpeed: 6 setHeading: 90 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fizzleOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(extraSnd2 number: 2274 setLoop: 1 play: setVol: 127)
				(fizzle init: setCel: 0 setCycle: End self)
			)
			(1
				(fizzle hide: dispose:)
				(= cycles 2)
			)
			(2
				(malicia setScript: malKills)
				(self dispose:)
			)
		)
	)
)

(instance transformMal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 2222)
				(Load 140 2275 2276) ; WAVE
				(deviceBlast
					init:
					setCel: 0
					setPri: (- (malicia priority:) 1)
					setCycle: End self
				)
				(extraSnd2 number: 2275 setLoop: 1 play:)
			)
			(1
				(deviceBlast hide:)
				(malicia
					view: 2222
					setLoop: 0 1
					setCel: 0
					x: 138
					y: 140
					setCycle: End self
				)
				(extraSnd number: 2276 setLoop: 1 play:)
			)
			(2
				(malicia
					setLoop: 1 1
					setCel: 0
					x: 152
					y: 145
					setCycle: End self
				)
			)
			(3
				(gKqMusic1 fade: 0 25 10 0)
				(malicia
					setLoop: 2 1
					setCel: 0
					x: 151
					y: 122
					setPri: (+ (edger priority:) 1)
					setCycle: End
				)
				(king setScript: 0 setCycle: End)
				(val
					view: 2245
					setLoop: 8 1
					setCel: 0
					setScale:
					scaleX: 115
					scaleY: 115
				)
				(extraSnd2 number: 2284 setLoop: 1 play:)
				(= ticks 200)
			)
			(4
				(gEgo
					scaleX: 128
					scaleY: 128
					view: 2222
					setLoop: 3 1
					setCel: 0
					posn: 90 111
					setCycle: End self
				)
			)
			(5
				(gEgo
					normalize: 4 2241
					setSpeed: 6
					setScale:
					scaleX: 115
					scaleY: 115
				)
				(= cycles 2)
			)
			(6
				(Load 140 4006 2277 4463 2278 2513 935) ; WAVE
				(cuddles init: setCel: 0 setPri: 122 setCycle: End self)
				(extraSnd2 number: 935 setLoop: -1 play: setVol: 127)
			)
			(7
				(cuddles
					setLoop: 1 1
					setCel: 0
					posn: 146 150
					setCycle: End self
				)
			)
			(8
				(extraSnd2 number: 4006 setLoop: 1 play:)
				(= ticks 275)
			)
			(9
				(extraSnd number: 2277 setLoop: 1 play:)
				(cuddles setLoop: 2 1 setCel: 0 posn: 157 148 setCycle: End)
				(= ticks 150)
			)
			(10
				(cuddles setLoop: 3 1 setCel: 0 posn: 159 149 setCycle: Fwd)
				(extraSnd2 number: 4463 setLoop: 1 play:)
				(= ticks 185)
			)
			(11
				(malicia hide:)
				(cuddles
					view: 2224
					setLoop: 0 1
					setCel: 0
					posn: 146 124
					setCycle: CT 14 1 self
				)
				(extraSnd2 number: 22770 setLoop: 1 play: setVol: 127)
			)
			(12
				(= cycles 6)
			)
			(13
				(cuddles setCel: 15 setCycle: End self)
				(malicia show:)
			)
			(14
				(gGame handsOn:)
				(cuddles
					view: 2224
					setLoop: 1 1
					setCel: 0
					posn: 164 149
					show:
					z: 20
					setCycle: Fwd
				)
				(extraSnd2 number: 2513 setLoop: -1 play: setVol: 127)
				(= seconds 8)
			)
			(15
				(gGame handsOff:)
				(deviceBlast dispose:)
				(cuddles
					view: 2224
					setLoop: 2 1
					setCel: 0
					posn: 151 130
					z: 0
					setCycle: End self
				)
				(extraSnd2 number: 2278 play:)
			)
			(16
				(cuddles hide:)
				(extraSnd2 stop:)
				(= cycles 2)
			)
			(17
				(edger setHotspot: 0 77 setPri: 90) ; Extra_Life
				(edgerLifeTimer setReal: edgerLifeTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance transformCuddles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: 0
					posn: 80 109
					view: 2221
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(deviceBlast
					view: 2225
					setLoop: 0 1
					setCel: 0
					posn: 90 73
					show:
					setCycle: End self
				)
				(extraSnd2 number: 2275 setLoop: 1 play:)
			)
			(2
				(deviceBlast setCycle: Beg)
				(cuddles
					view: 2225
					setLoop: 1 1
					setCel: 0
					x: 151
					y: 126
					z: 0
					setCycle: End self
				)
				(extraSnd2 number: 825 setLoop: 1 play:)
			)
			(3
				(deviceBlast hide: dispose:)
				(extraSnd2 number: 954 setLoop: 1 play:)
				(= ticks 100)
			)
			(4
				(extraSnd2 number: 2277 setLoop: 1 play:)
				(= ticks 150)
			)
			(5
				(cuddles
					view: 2225
					setLoop: 2 1
					setCel: 0
					x: 164
					y: 120
					setCycle: End self
				)
				(extraSnd2 number: 948 setLoop: -1 play:)
			)
			(6
				(cuddles hide: setPri: -1)
				(extraSnd2 stop:)
				(= cycles 2)
			)
			(7
				(gEgo
					scaleX: 128
					scaleY: 128
					view: 2222
					setLoop: 3 1
					setCel: 0
					posn: 90 111
					setCycle: End self
				)
			)
			(8
				(gEgo
					normalize: 4 2241
					setSpeed: 6
					setScale:
					scaleX: 115
					scaleY: 115
				)
				(edger setHotspot: 0 77 setPri: 90) ; Extra_Life
				(edgerLifeTimer setReal: edgerLifeTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance malKills of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(malicia
					view: 2203
					setLoop: 1 1
					posn: 174 128
					setMotion: MoveTo 209 128 self
				)
				(if (not (malicia cycler:))
					(malicia setCel: 2 setCycle: ROsc 101 2 5)
				)
			)
			(1
				(malicia
					view: 2203
					posn: 209 128
					setLoop: 1 1
					setCycle: End self
				)
				(extraSnd2 number: 843 setLoop: 1 play: setVol: 127)
			)
			(2
				(malicia hide:)
				(gEgo
					view: 2203
					setLoop: 2 1
					setCel: 0
					posn: 212 128
					setCycle: CT 5 1 self
				)
				(val setPri: (+ (malicia priority:) 1))
			)
			(3
				(gEgo setCel: 6 setCycle: End self)
				(malicia view: 2218 setLoop: 1 1 setCel: 0 posn: 225 140 show:)
			)
			(4
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(EgoDead 43 self)
			)
			(5
				(ClearFlag 254)
				(king setScript: 0)
				(edger hide:)
				(val hide: setPri: -1)
				(malicia hide: setPri: -1)
				(lever hide:)
				(gKqMusic1 stop:)
				(if
					(or
						(and (gEgo has: 62) (not (IsFlag 258))) ; Device
						(and (IsFlag 258) (not (IsFlag 259)))
					)
					(SetFlag 258)
					(SetFlag 259)
					((ScriptID 0 9) ; volcanoDeathTimer
						setReal: (ScriptID 0 9) ((ScriptID 0 9) getTime:) ; volcanoDeathTimer, volcanoDeathTimer
					)
					((ScriptID 0 5) ; lavaDeathTimer
						setReal: (ScriptID 0 5) ((ScriptID 0 5) getTime:) ; lavaDeathTimer, lavaDeathTimer
					)
					(ClearFlag 258)
					(ClearFlag 259)
					(gEgo get: 62 1) ; Device
					(gCurRoom newRoom: 2206)
				else
					(gEgo put: 62) ; Device
					(gCurRoom setScript: grandFinale)
				)
				(self dispose:)
			)
		)
	)
)

(instance kingReacts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(king posn: 210 114 view: 22150 setLoop: 0 1)
				(king setCel: (- (NumCels king) 1) setCycle: Beg self)
			)
			(1
				(= ticks (Random 10 20))
			)
			(2
				(king setCycle: CT (Random 3 4) 1 self)
			)
			(3
				(= ticks (Random 10 20))
			)
			(4
				(king setCycle: CT 2 -1 self)
			)
			(5
				(= state 0)
				(= ticks 1)
			)
		)
	)
)

(instance kingBeatsConsole of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(extraSnd number: 922 setLoop: 1 play: setVol: 127)
				(king
					posn: 210 112
					view: 22131
					setLoop: 2 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				(= cycles 6)
			)
			(2
				(lever init: setPri: 123)
				(king cel: 3 setCycle: CT 12 1 self)
				(UpdateScreenItem king)
				(gKqMusic1 number: 2207 setLoop: 1 play: setVol: 127)
			)
			(3
				(king setCycle: CT 8 -1 self)
				(extraSnd number: 947 play:)
			)
			(4
				(king setCycle: CT 12 1 self)
			)
			(5
				(extraSnd play:)
				(king setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance kingApplauds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(extraSnd2 number: 22810 setLoop: 1 play: setVol: 127)
				(king
					posn: 187 116
					view: 2216
					setLoop: 3 1
					setCel: 0
					setPri: 119
					setCycle: CT 3 1 self
				)
			)
			(1
				(king setCycle: ROsc 100 3 4)
				(= ticks 90)
			)
			(2
				(king setCel: 2 setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance gaugeSubsides of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Beg self)
			)
			(1
				(client hide: dispose:)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance edger of Actor
	(properties
		x 293
		y 123
		view 2215
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(77 ; Extra_Life
				(if (IsFlag 254)
					(ClearFlag 254)
					(edgerLifeTimer client: 0 delete: dispose:)
					(gCurRoom setScript: edLives)
				)
			)
		)
	)
)

(instance cuddles of Actor
	(properties
		x 209
		y 126
		view 2223
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 85) ; Device
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Device
				(gEgo setScript: transformCuddles)
			)
		)
	)
)

(instance oberon of Actor
	(properties
		x 228
		y 135
		view 2229
		loop 2
	)
)

(instance titania of Actor
	(properties
		x 170
		y 135
		view 2229
	)
)

(instance malicia of Actor
	(properties
		x 208
		y 127
		view 2203
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 85) ; Device
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Device
				(gEgo setScript: shootMal)
			)
		)
	)
)

(instance king of Actor
	(properties
		x 210
		y 112
		view 2213
		loop 2
		signal 4129
	)
)

(instance blast of Prop
	(properties
		x 136
		y 73
		view 22191
		loop 3
	)
)

(instance val of Actor
	(properties
		x 195
		y 126
		view 2215
	)
)

(instance theDevice of Prop
	(properties
		approachX 74
		approachY 95
		x 55
		y 80
		view 2210
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 10 setHotspot: 8 10) ; Do, Exit, Do, Exit
	)

	(method (cue)
		(self setCel: 0 setCycle: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(grandFinale dispose:)
				(gEgo setScript: unplugDevice)
			)
		)
	)
)

(instance fizzle of Prop
	(properties
		x 94
		y 75
		view 2221
		loop 1
	)
)

(instance deviceBlast of Prop
	(properties
		x 90
		y 81
		priority 140
		fixPriority 1
		view 2221
		loop 2
	)
)

(instance gauge of Prop
	(properties
		x 148
		y 72
		priority 97
		fixPriority 1
		view 22390
		loop 2
		cycleSpeed 22
	)
)

(instance ghostEd of Prop
	(properties
		x 146
		y 111
		view 2227
	)
)

(instance titsMouth of Prop
	(properties
		x 146
		y 111
		view 2236
		loop 20
	)
)

(instance lever of Prop
	(properties
		x 210
		y 111
		view 22130
	)
)

(instance valTalker of KQTalker
	(properties)
)

(instance extraSnd of Sound
	(properties)
)

(instance extraSnd2 of Sound
	(properties)
)

(instance edgerLifeTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: edDies)
		(self client: 0 delete: dispose:)
	)
)

