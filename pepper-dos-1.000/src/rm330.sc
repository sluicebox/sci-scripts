;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use ExitFeature)
(use BalloonTalker)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm330 0
	benTalker 16
)

(local
	local0
	local1
	local2 = 288
	local3 = 146
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(= temp0 0)
	(= temp1 0)
	(switch param1
		(leydenJar
			(= local1 1)
			(= temp0 174)
			(= temp1 161)
		)
		(schematic
			(= local1 2)
			(= temp0 156)
			(= temp1 164)
		)
		(kite
			(= local1 3)
			(= temp0 199)
			(= temp1 156)
		)
		(kiteString
			(= local1 4)
			(= temp0 107)
			(= temp1 155)
		)
		(key_
			(= local1 5)
			(= temp0 127)
			(= temp1 160)
		)
	)
	(if param2
		(if (gCurRoom script:)
			((gCurRoom script:) next: positionScr)
		else
			(gCurRoom setScript: positionScr 0 local1)
		)
	else
		(param1 posn: temp0 temp1 setPri: 12 init: stopUpd:)
	)
)

(procedure (localproc_1)
	(if argc
		(gNarrator x: 25 y: 20)
	else
		(gNarrator x: -1 y: -1)
	)
)

(class BlastingProp of Prop
	(properties)

	(method (doVerb theVerb invItem param3 &tmp temp0)
		(cond
			((== theVerb 84) ; Trivia
				(if (IsFlag 46)
					(if param3
						(= temp0 2)
					else
						(= temp0 0)
					)
					(gMessager say: invItem theVerb temp0)
				else
					(if param3
						(= temp0 1)
					else
						(= temp0 0)
					)
					(gMessager say: invItem theVerb temp0)
				)
			)
			((OneOf theVerb 7 6) ; Do, Look
				(if (not (IsFlag 46))
					(= temp0 1)
				else
					(= temp0 2)
				)
				(gMessager say: invItem theVerb temp0)
			)
		)
	)
)

(instance rm330 of ADRoom
	(properties
		noun 1
		picture 330
		horizon 75
		east 320
		vanishingY -60
	)

	(method (init &tmp temp0)
		(if (IsFlag 46)
			(= picture 331)
			(= local2 284)
			(= local3 152)
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 319 135 297 125 297 136 263 141 244 128 214 138 173 117 125 131 113 150 132 161 156 169 162 188 179 189 188 165 216 165 234 151 239 154 258 164 269 156 319 165
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 296 123 259 123 259 136 281 136 281 149 293 149 293 174 274 174 274 179 90 179 90 146 87 146 87 184 319 184 319 130 296 130
						yourself:
					)
			)
		)
		(if (== gPrevRoomNum 310)
			(= style 7)
		)
		(if (not global218)
			(= global218 1)
			(windMill init: setOnMeCheck: 1 128)
		)
		(super init: &rest)
		((ScriptID 895 0) ; pepper
			init:
			setScale: 0
			normalize:
			setHeading: 270
			actions: pepperDoVerb
		)
		(if (< gAct 4)
			(bookArm init:)
		else
			(nukedTub init: setOnMeCheck: 1 2048)
			(blastedBook init: setOnMeCheck: 1 16384)
		)
		(cond
			((and (< gAct 5) (not (IsFlag 40)))
				(ben init: setPri: 14 cycleSpeed: 3 stopUpd:)
			)
			((and (IsFlag 40) (== gAct 3))
				(ben view: 817 setLoop: 8 cel: 1 posn: 286 164 init:)
				((ScriptID 895 0) ; pepper
					view: 790
					setLoop: 1
					cel: 4
					normalize:
					posn: 250 137
				)
			)
		)
		(switch gPrevRoomNum
			(320
				((ScriptID 895 0) posn: 330 152) ; pepper
				(if (and (not (IsFlag 85)) (IsFlag 53))
					(gCurRoom setScript: meetBenFirstTimeScr)
				else
					(gCurRoom setScript: startScr)
				)
			)
			(310
				((ScriptID 895 0) posn: 310 152 loop: 8 cel: 1) ; pepper
				(gCurRoom setScript: benSoakingScr)
			)
			(345
				(gCurRoom setScript: fromKiteKeyScr)
			)
			(else
				((ScriptID 895 0) posn: 330 152) ; pepper
				(gCurRoom setScript: startScr)
			)
		)
		(if (and (< gAct 4) (!= gPrevRoomNum 345))
			(= temp0 330)
		else
			(= temp0 331)
		)
		(gLongSong number: temp0 setLoop: -1 flags: 1 play:)
		(if (IsFlag 40)
			(if (not (IsFlag 41))
				(backScratcher init: stopUpd:)
			)
			(if (not (IsFlag 42))
				(fan init: stopUpd:)
			)
			(if (not (IsFlag 43))
				(paddles init: stopUpd:)
			)
			(if (not (IsFlag 44))
				(lever init: stopUpd:)
			)
			(if (not (IsFlag 45))
				(stepStool init: setPri: 13 stopUpd:)
			)
		)
		(if (not (IsFlag 40))
			(if (not (IsFlag 20))
				(tomato init: stopUpd:)
			)
			(if (not (IsFlag 19))
				(ironRod init: stopUpd:)
			)
		)
		(if (and (not (IsFlag 148)) (== gAct 3))
			(if (IsFlag 35)
				(localproc_0 leydenJar 0)
			)
			(if (IsFlag 36)
				(localproc_0 schematic 0)
			)
			(if (IsFlag 37)
				(localproc_0 kite 0)
			)
			(if (IsFlag 38)
				(localproc_0 kiteString 0)
			)
			(if (IsFlag 39)
				(localproc_0 key_ 0)
			)
		)
		(bensHouse init:)
		(clouds init: setOnMeCheck: 1 2048)
		(cabbagePatch init: setOnMeCheck: 1 2)
		(fence init: setOnMeCheck: 1 4)
		(hills init: setOnMeCheck: 1 1024)
		(hotTub init: setOnMeCheck: 1 8)
		(tomatoPatch init: setOnMeCheck: 1 16)
		(tulips init: setOnMeCheck: 1 64)
		(hotTubWater init: setOnMeCheck: 1 512)
		(waterPipe init: setOnMeCheck: 1 256)
		(windMill init: setOnMeCheck: 1 128)
		(windMillCycler cycleSpeed: 5 setCycle: Fwd init:)
		(if (and (< gAct 4) (not (IsFlag 46)))
			(bellow1 cycleSpeed: 5 setPri: 11 setCycle: Fwd init:)
			(bellow2 setCycle: Fwd init:)
			(hotTubParts cycleSpeed: 5 setPri: 9 setCycle: Fwd init:)
			(hotTubParts2 cycleSpeed: 5 setPri: 9 setCycle: Fwd init:)
		)
		(if (not (IsFlag 46))
			(stepStoolFeature init: setOnMeCheck: 1 32)
		)
		(eastEFeature init:)
	)

	(method (dispose)
		(gLongSong fade:)
		(super dispose:)
	)

	(method (doit)
		(cond
			(script 0)
			((& ((ScriptID 895 0) onControl: 1) $4000) ; pepper
				(gCurRoom setScript: checkIfOkScr)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		((ScriptID 895 0) normalize:) ; pepper
	)
)

(instance dunkJar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 895 0) setMotion: PolyPath 91 156 self) ; pepper
			)
			(1
				(gGame points: 490 1)
				(SetFlag 142)
				(self dispose:)
			)
		)
	)
)

(instance startScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if (and (not (IsFlag 7)) (== gAct 2))
			(= next franklinCartoonScr)
		)
	)

	(method (dispose)
		(gGame handsOn:)
		((ScriptID 895 0) normalize:) ; pepper
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo local2 local3 self)
			)
			(2
				(if (not (OneOf gPrevRoomNum 320 310))
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(3
				(if (not (IsFlag 7))
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance franklinCartoonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 7)
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 600)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance meetBenFirstTimeScr of Script
	(properties)

	(method (init)
		(if (and (not (IsFlag 7)) (== gAct 2))
			(= next franklinCartoonScr)
		)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(deborah init: stopUpd:)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) setMotion: MoveTo local2 local3 self) ; pepper
			)
			(2
				((ScriptID 895 0) normalize: 1790) ; pepper
				(SetFlag 85)
				(= cycles 1)
			)
			(3
				(= seconds 2)
			)
			(4
				(gMessager say: 29 0 3 0 self) ; "Ben?"
			)
			(5
				(= seconds 2)
			)
			(6
				(deborah
					view: 841
					setCycle: Walk
					setMotion: PolyPath 295 124 self
				)
			)
			(7
				(deborah setCycle: Walk setMotion: PolyPath 319 145 self)
			)
			(8
				(deborah dispose:)
				(= cycles 1)
			)
			(9
				((ScriptID 895 0) normalize: 790) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance benTalk1Scr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gEgo get: 14) ; Ordinary_String
		(gEgo get: 10) ; Doctrine
		(SetFlag 9)
		(SetFlag 31)
		(SetFlag 62)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ben setCycle: End self)
			)
			(1
				(gGame points: 319 1)
				(= cycles 1)
			)
			(2
				(gMessager say: 31 85 4 1 5 self) ; "Uh, Mr. Franklin? Can I talk to you?"
			)
			(3
				(gMessager say: 31 85 4 6 self) ; "Hey, little dude, mellow out! Here, take this string. I wear it to remind me to forget anything stressful!"
			)
			(4
				(gGame points: 321 1)
				(= cycles 1)
			)
			(5
				(gMessager say: 31 85 4 7 8 self) ; "Er, thanks. But Mr. Franklin, I really need to get my dog back! Can you help me? Please?"
			)
			(6
				(gGame points: 320 1)
				(= cycles 1)
			)
			(7
				(gMessager say: 31 85 4 9 15 self) ; "I don't WANT to come to grips with my hostility! I WANT my DOG!"
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance benTalk2Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ben setCycle: End self)
			)
			(1
				(gMessager say: 31 85 5 0 self) ; "Mr. Franklin, are you SURE you can't help me?"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sayItNow of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 31 38 7 1 self) ; "Check it out, Mr. Franklin! This book on electricity came for you in the mail!"
			)
			(1
				(gMessager say: 31 38 7 2 self) ; "I used to be interested in that sort of thing. I can't remember why. 'Scuse me, I feel a nap coming on."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance schematicTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gDictionaryWord 104)
				(gMessager say: 31 40 7 1 self) ; "Mr. Franklin, look what I have! It's a |r||c0|schematic|c||r| for your famous Kite/Key experiment! I found it in your work room."
			)
			(1
				(= gDictionaryWord 18)
				(gMessager say: 31 40 7 2 self) ; "That's nice, child. You keep it. I'm totally beyond science now. I'm into cosmic |r||c0|consciousness|c||r|, you dig? Go meditate in the cabbage patch, okay?"
			)
			(2
				(= gDictionaryWord 22)
				(gMessager say: 31 40 7 3 self) ; "|r||c0|Cosmic|c||r| consciousness, my foot! He looks like a cosmic couch potato to me!"
			)
			(3
				(gMessager say: 31 40 7 4 8 self) ; "What did you say, child? The music of the universe was filling my ears, so I didn't hear you."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance fromKiteKeyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(= seconds 5)
			)
			(2
				(gMessager say: 29 0 20 0 self 330) ; "Oh, geez, Ben! Look at this!"
			)
			(3
				(gCurRoom newRoom: 600)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance benSoakingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 316 152)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) setCycle: Walk setMotion: MoveTo 282 129 self) ; pepper
			)
			(2
				(= ticks 50)
			)
			(3
				((ScriptID 895 0) normalize: 1790) ; pepper
				(waterSpicket init: setLoop: 4 setCycle: Fwd)
				(= cycles 1)
			)
			(4
				(= gDictionaryWord 108)
				(gMessager say: 29 0 13 1 self) ; "<Sigh!> Ah, that feels wonderful. I can feel my |r||c0|aura|c||r| turning purple."
			)
			(5
				(gMessager say: 29 0 13 2 6 self) ; "Okay, now you'll help me with the kite/key experiment, right?"
			)
			(6
				((ScriptID 895 0) normalize: 790) ; pepper
				(gGame handsOn:)
				(SetFlag 18)
				(self dispose:)
			)
		)
	)
)

(instance tomato of View
	(properties
		x 64
		y 167
		noun 15
		approachX 81
		approachY 177
		view 330
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 6) ; Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getTomatoScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ironRod of View
	(properties
		x 76
		y 128
		noun 19
		view 330
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getIronRodScr)
			)
			(84 ; Trivia
				(= gDictionaryWord 8)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leydenJar of View
	(properties
		noun 33
		view 330
		cel 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance schematic of View
	(properties
		x 156
		y 164
		noun 37
		view 330
		loop 1
		cel 1
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 7 6 84) ; Do, Look, Trivia
			(= gDictionaryWord 104)
			(super doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance kite of View
	(properties
		x 199
		y 156
		noun 35
		view 330
		loop 1
		cel 2
	)
)

(instance kiteString of View
	(properties
		x 75
		y 131
		noun 34
		view 330
		cel 6
	)
)

(instance key_ of View
	(properties
		x 292
		y 161
		noun 36
		view 330
		loop 1
		priority 14
	)
)

(instance backScratcher of BlastingProp
	(properties
		x 157
		y 120
		noun 9
		view 330
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getBackScratcherScr)
			)
			(else
				(super doVerb: theVerb (self noun:) 1 &rest)
			)
		)
	)
)

(instance fan of BlastingProp
	(properties
		x 136
		y 108
		noun 10
		view 330
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getFanScr)
			)
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 flags: 1 play:)
				(gMessager say: 10 84 2) ; "|c1|TRUE. Ben invented the rocking chair, then he invented a sort of fan that would attach to the chair and spin as the person rocked. He apparently took apart somebody's fanning rocking chair to put the fan on his hot tub.|c|"
			)
			(85 ; Talk
				(gMessager say: 10 85 2) ; "A fan! I'll bet I could use that."
			)
			(6 ; Look
				(gMessager say: 10 6 2) ; "The fan lies amid the wreckage of the hot tub."
			)
			(else
				(super doVerb: theVerb (self noun:) 1 &rest)
			)
		)
	)
)

(instance lever of BlastingProp
	(properties
		x 211
		y 133
		noun 12
		view 330
		cel 3
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getLeverScr)
			)
			(6 ; Look
				(gMessager say: 12 6 2) ; "The lever has been blasted loose. It's lying in the wreckage."
			)
			(85 ; Talk
				(gMessager say: 12 85 2) ; "Hey, that looks like it used to part of some big machine..."
			)
			(84 ; Trivia
				(gMessager say: 12 84) ; "TRUE. No, no, not the hot tub, the lever. Levers have been around since the first machinery. As the Greek mathematician, philosopher and inventor Archimedes said; "Give me a lever big enough, and I can move the world.""
			)
			(else
				(super doVerb: theVerb (self noun:) 0 &rest)
			)
		)
	)
)

(instance paddles of BlastingProp
	(properties
		x 163
		y 166
		noun 13
		view 330
		loop 1
		cel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getPaddlesScr)
			)
			(6 ; Look
				(gMessager say: 13 6 2) ; "The paddles are lying in the wreckage of the hot tub."
			)
			(85 ; Talk
				(gMessager say: 13 85 2) ; "Those paddles look totally useful!"
			)
			(else
				(super doVerb: theVerb (self noun:) 0 &rest)
			)
		)
	)
)

(instance waterSpicket of Prop
	(properties
		x 227
		y 90
		view 333
		priority 14
		signal 26640
	)
)

(instance stepStool of Prop
	(properties
		x 121
		y 142
		noun 6
		view 330
		cel 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getStepStoolScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stepStoolFeature of Feature
	(properties
		noun 6
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 7 6 85 84) ; Do, Look, Talk, Trivia
			(gMessager say: 6 theVerb 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance eastEFeature of ExitFeature
	(properties
		nsTop 133
		nsLeft 309
		nsBottom 189
		nsRight 319
		cursor 913
		exitDir 2
		noun 32
	)
)

(instance bensHouse of Feature
	(properties
		x 312
		y 65
		noun 22
		nsLeft 305
		nsBottom 130
		nsRight 319
		sightAngle 40
		approachX 300
		approachY 129
	)
)

(instance bookArm of Feature
	(properties
		x 236
		y 78
		noun 11
		nsTop 69
		nsLeft 224
		nsBottom 87
		nsRight 249
		sightAngle 40
		approachX 257
		approachY 114
	)
)

(instance clouds of Feature
	(properties
		x 184
		y 3
		noun 16
		sightAngle 40
		approachX 277
		approachY 121
	)
)

(instance cabbagePatch of Feature
	(properties
		noun 16
	)
)

(instance fence of Feature
	(properties
		noun 5
	)
)

(instance hills of Feature
	(properties
		noun 24
	)
)

(instance nukedTub of Feature
	(properties
		noun 3
	)
)

(instance blastedBook of Feature
	(properties
		noun 38
	)
)

(instance hotTub of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 46))
			(self noun: 2)
		else
			(self noun: 3)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 97 52 49 53) ; ???, Glass_Jar, Glass_Jar [empty], Glass_Jar [tin]
				(hotTubWater doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tomatoPatch of Feature
	(properties
		noun 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(= gDictionaryWord 55)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tulips of Feature
	(properties
		noun 25
	)
)

(instance hotTubWater of Feature
	(properties
		noun 4
	)

	(method (doVerb theVerb)
		(hotTubParts doVerb: theVerb)
	)
)

(instance waterPipe of Feature
	(properties
		noun 7
	)
)

(instance windMill of Feature
	(properties
		noun 23
	)
)

(instance deborah of Actor
	(properties
		x 276
		y 120
		view 841
		loop 1
	)
)

(instance goKiteKeyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong2 number: 916 setLoop: 1 flags: 1 play: self)
			)
			(1
				(gMessager say: 29 0 18 0 self) ; "Yikes! That was some serious thunder!"
			)
			(2
				(gMessager say: 29 0 19 0 self) ; "That's everything, isn't it? It's time!"
			)
			(3
				(SetFlag 40)
				(SetFlag 46)
				(SetFlag 148)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 345)
				(self dispose:)
			)
		)
	)
)

(instance checkIfOkScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if (IsFlag 9)
			(= next leaveRoomScr)
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) setMotion: PolyPath 271 179 self) ; pepper
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(gMessager say: 29 0 22 0 self) ; "Pepper came all this way just to see Ben! She doesn't want to leave before she talks to him!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					setMotion:
						MoveTo
						(+ ((ScriptID 895 0) x:) 30) ; pepper
						((ScriptID 895 0) y:) ; pepper
						self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(self dispose:)
				(= gNewRoomNum 320)
			)
		)
	)
)

(instance positionScr of Script
	(properties)

	(method (init)
		(if (== global217 5)
			(= next goKiteKeyScr)
		)
		(super init: &rest)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(= register local1)
				(= cycles 1)
			)
			(1
				(switch register
					(1
						((ScriptID 895 0) setMotion: PolyPath 204 177 self) ; pepper
					)
					(2
						((ScriptID 895 0) setMotion: PolyPath 149 177 self) ; pepper
					)
					(3
						((ScriptID 895 0) setMotion: PolyPath 235 176 self) ; pepper
					)
					(4
						((ScriptID 895 0) setMotion: PolyPath 102 163 self) ; pepper
					)
					(5
						((ScriptID 895 0) setMotion: PolyPath 121 176 self) ; pepper
					)
				)
			)
			(2
				(if (OneOf register 2 4 5)
					((ScriptID 895 0) setLoop: 0) ; pepper
				else
					((ScriptID 895 0) setLoop: 1) ; pepper
				)
				((ScriptID 895 0) ; pepper
					view: 805
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(3
				(switch local1
					(1
						(= temp0 leydenJar)
						(= temp1 174)
						(= temp2 161)
					)
					(2
						(= temp0 schematic)
						(= temp1 156)
						(= temp2 164)
					)
					(3
						(= temp0 kite)
						(= temp1 199)
						(= temp2 156)
					)
					(4
						(= temp0 kiteString)
						(= temp1 107)
						(= temp2 155)
					)
					(5
						(= temp0 key_)
						(= temp1 127)
						(= temp2 160)
					)
				)
				(temp0 posn: temp1 temp2 setPri: 13 init: stopUpd:)
				(= cycles 1)
			)
			(4
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(5
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance benTalker of BalloonTalker
	(properties
		x 20
		y 76
		talkWidth 150
		tailPosn 1
	)
)

(instance windMillCycler of Prop
	(properties
		x 67
		noun 23
		view 334
		loop 3
		detailLevel 2
	)
)

(instance hotTubParts of Prop
	(properties
		x 140
		y 107
		noun 4
		view 336
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(53 ; Glass_Jar [tin]
				((gInventory at: 18) loop: 4 cel: 11) ; Glass_Jar
				((ScriptID 894 2) init:) ; inventoryCursor
				(gMessager say: 2 theVerb 0) ; "'Scuse me, Ben. I'm just going to fill this jar with water."
				(if (== theVerb 53) ; Glass_Jar [tin]
					(gCurRoom setScript: dunkJar)
				)
			)
			(52 ; Glass_Jar
				(gMessager say: 2 52) ; "Pepper needs to get rid of the cabbage before she fills the jar with water."
			)
			((OneOf theVerb 49 97) ; Glass_Jar [empty], ???
				(gMessager say: 2 49) ; "Pepper will need water for the Leyden jar, but she has to put it together in the right order. She needs to add in something first."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hotTubParts2 of Prop
	(properties
		x 214
		y 106
		noun 4
		view 336
		loop 1
		detailLevel 2
	)

	(method (doVerb theVerb)
		(hotTubParts doVerb: theVerb)
	)
)

(instance bellow1 of Prop
	(properties
		x 213
		y 152
		noun 8
		view 334
		loop 1
		detailLevel 2
	)
)

(instance bellow2 of Prop
	(properties
		x 124
		y 150
		noun 8
		view 334
		loop 2
		priority 11
		signal 26640
		cycleSpeed 5
		detailLevel 2
	)
)

(instance getTomatoScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 12) ; Tomato
				(SetFlag 20)
				(gGame points: 322 2)
				(= local0 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(localproc_1 1)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 84 171 self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(= seconds 2)
			)
			(3
				(gMessager say: 15 7 0 0 self) ; "Pepper carefully takes the big tomato."
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 805
					cycleSpeed: 10
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(5
				(tomato dispose:)
				(= cycles 1)
			)
			(6
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(7
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 3)
			)
			(8
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance getIronRodScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 16) ; Metal_Rod
				(SetFlag 19)
				(gGame points: 324 1)
				(= local0 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(localproc_1 1)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 98 135 self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(= seconds 2)
			)
			(3
				(gMessager say: 19 7 0 0 self) ; "Pepper picks up the iron rod. Ben doesn't seem to need it."
			)
			(4
				((ScriptID 895 0) ; pepper
					cycleSpeed: 10
					view: 805
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(5
				(ironRod dispose:)
				(= cycles 1)
			)
			(6
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(7
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 3)
			)
			(8
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance getBackScratcherScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 23) ; Back_Scratcher
				(SetFlag 41)
				(= local0 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(gGame points: 331 2)
				(localproc_1 1)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 180 124 self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(= seconds 2)
			)
			(3
				(BlastingProp doVerb: 7 9 1 &rest)
				(= seconds 1)
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 805
					cycleSpeed: 10
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(5
				(backScratcher dispose:)
				(= cycles 1)
			)
			(6
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(7
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 3)
			)
			(8
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance getFanScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 334 2)
				(gEgo get: 24) ; Tub_Fan
				(SetFlag 42)
				(= local0 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(localproc_1 1)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 162 117 self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(= seconds 2)
			)
			(3
				((ScriptID 895 0) ; pepper
					view: 805
					cycleSpeed: 10
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(4
				(fan dispose:)
				(= cycles 1)
			)
			(5
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(6
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 3)
			)
			(7
				(gMessager say: 10 7 2 0 self) ; "Pepper picks up the fan, thinking it might be useful."
			)
			(8
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance getLeverScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 333 2)
				(gEgo get: 26) ; Press_Lever
				(SetFlag 44)
				(= local0 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(localproc_1 1)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 228 144 self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(= seconds 2)
			)
			(3
				(BlastingProp doVerb: 7 12 1 &rest)
				(= seconds 1)
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 805
					cycleSpeed: 10
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(5
				(lever dispose:)
				(= cycles 1)
			)
			(6
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(7
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 3)
			)
			(8
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance getPaddlesScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 25) ; Paddles
				(SetFlag 43)
				(= local0 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(gGame points: 332 2)
				(localproc_1 1)
				(= cycles 2)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 196 168 self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(= seconds 2)
			)
			(3
				(BlastingProp doVerb: 7 13 1 &rest)
				(= seconds 1)
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 805
					cycleSpeed: 10
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(5
				(paddles dispose:)
				(= cycles 1)
			)
			(6
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(7
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 3)
			)
			(8
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance getStepStoolScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo get: 27) ; StepStool
				(SetFlag 45)
				(gGame points: 335 2)
				(= local0 ((ScriptID 895 0) cycleSpeed:)) ; pepper
				(localproc_1 1)
				(= cycles 10)
			)
			(1
				((ScriptID 895 0) ; pepper
					ignoreActors:
					setCycle: Walk
					setMotion: PolyPath 156 160 self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(= seconds 2)
			)
			(3
				(gMessager say: 6 7 0 1 self) ; "Hey, I'll bet I could use this stepstool. I'll just see if I can lift it..."
			)
			(4
				((ScriptID 895 0) ; pepper
					view: 805
					cycleSpeed: 10
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(5
				(stepStool dispose:)
				(= cycles 1)
			)
			(6
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(7
				(= ticks 25)
			)
			(8
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 3)
			)
			(9
				(gMessager say: 6 7 0 2 self) ; "Cool! My pockets are bigger than I thought!"
			)
			(10
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance pepperDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Tomato
				(gMessager say: 18 41) ; "That's a very interesting idea! Why don't you go try it somewhere else?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance messageScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 895 0) view: 1790) ; pepper
				(switch register
					(3
						(gGame points: 325 1)
					)
					(4
						(gGame points: 326 1)
					)
					(5
						(gGame points: 327 1)
					)
					(1
						(if
							(and
								(IsFlag 25)
								(IsFlag 142)
								(IsFlag 26)
								(IsFlag 17)
								(IsFlag 28)
							)
							(gGame points: 328 3)
						)
					)
				)
				(= cycles 2)
			)
			(1
				(switch register
					(1
						(cond
							((not (IsFlag 147))
								(gMessager say: 31 97 7 0 self) ; "Here's a jar for you, Ben."
							)
							(
								(and
									(IsFlag 25)
									(IsFlag 142)
									(IsFlag 26)
									(IsFlag 17)
									(IsFlag 28)
								)
								(gEgo put: 18) ; Glass_Jar
								(SetFlag 35)
								(localproc_0 leydenJar 1)
								(++ global217)
								(= gDictionaryWord 58)
								(gMessager say: 31 97 15 0 self) ; "Here, Ben, we'll need this for the experiment."
							)
							(else
								(gMessager say: 31 97 14 0 self) ; "Here's a jar for the experiment."
							)
						)
					)
					(2
						(cond
							((IsFlag 17)
								(++ global217)
								(gEgo put: 11) ; Schematic
								(SetFlag 36)
								(gGame points: 329 1)
								(localproc_0 schematic 1)
								(gMessager say: 31 40 9 0 self) ; "Here's the schematic for the experiment, Ben!"
							)
							((IsFlag 147)
								(gMessager say: 31 40 24 0 self) ; "Child, I won't even LOOK at that until you get me some hot water."
							)
							(else
								(gGame points: 330 2)
								(SetFlag 147)
								(self setScript: schematicTalkScr self)
							)
						)
					)
					(3
						(if (IsFlag 17)
							(++ global217)
							(gEgo put: 13) ; Kite
							(SetFlag 37)
							(localproc_0 kite 1)
							(gMessager say: 31 44 9 0 self) ; "Look what I've got!"
						else
							(gMessager say: 31 44 7 0 self) ; "Here, Ben, this kite is for you!"
						)
					)
					(4
						(if (IsFlag 17)
							(gEgo put: 15) ; Kite_String
							(SetFlag 38)
							(localproc_0 kiteString 1)
							(++ global217)
							(gMessager say: 31 87 9 0 self) ; "Will this string work for the experiment, Ben?"
						else
							(gMessager say: 31 87 7 0 self) ; "Here, Ben! This is some really nice string. Tie it around your finger, and maybe you'll remember what you used to be like!"
						)
					)
					(5
						(if (IsFlag 17)
							(gEgo put: 21) ; A_Brass_Key
							(SetFlag 39)
							(localproc_0 key_ 1)
							(++ global217)
							(gMessager say: 31 101 9 0 self) ; "Will this key work for the experiment, Ben?"
						else
							(gMessager say: 31 101 7 0 self) ; "Here you go, Ben, a nice, shiny key!"
						)
					)
				)
			)
			(2
				(switch global217
					(3
						(gLongSong2 number: 914 setLoop: 1 play:)
						(gMessager say: 29 0 16 0 self) ; "Hey, did you hear that? It sounded like thunder!"
					)
					(4
						(gLongSong2 number: 915 setLoop: 1 play:)
						(gMessager say: 29 0 17 0 self) ; "Hey! That WAS thunder! I wonder if it's gonna rain?"
					)
					(else
						(= cycles 2)
					)
				)
			)
			(3
				(if (== global217 5)
					((ScriptID 895 0) normalize:) ; pepper
					(self dispose:)
				else
					(gGame handsOn:)
					((ScriptID 895 0) normalize:) ; pepper
					(self dispose:)
				)
			)
		)
	)
)

(instance ben of Actor
	(properties
		x 184
		y 112
		noun 31
		approachX 110
		approachY 182
		approachDist 5
		view 332
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 85 7 6 86 30 89 999) ; Talk, Do, Look, Nose, Paw, Teeth, ???
	)

	(method (doVerb theVerb &tmp temp0)
		(if (and (!= ((ScriptID 895 0) heading:) 30) (== theVerb 85)) ; pepper, Talk
			((ScriptID 895 0) setHeading: 30) ; pepper
		)
		(switch theVerb
			((OneOf theVerb 4 47) ; ???, Metal_Rod
				(gMessager say: 31 4 9) ; "Here's a metal rod, Ben. Just what you always wanted, right?"
			)
			((OneOf theVerb 38 37) ; ???, ???
				(if (IsFlag 17)
					(gMessager say: 31 38 9) ; "Do you need this for the experiment, Ben?"
				else
					(gMessager say: 31 38 7) ; "Check it out, Mr. Franklin! This book on electricity came for you in the mail!"
				)
			)
			(50 ; Tin
				(gMessager say: 31 50 9) ; "Here you go, a piece of tin!"
			)
			(87 ; ???
				(gCurRoom setScript: messageScr 0 4)
			)
			((OneOf theVerb 7 84) ; Do, Trivia
				(gMessager say: 31 theVerb 6)
			)
			(6 ; Look
				((ScriptID 895 0) view: 1790) ; pepper
				(gMessager say: 31 6 6 0 gCurRoom) ; "Geez, is that REALLY Ben Franklin? He looks like a total retro-hippie! ...And he's in a HOT TUB! YIKES!"
			)
			(41 ; Tomato
				(gMessager say: 31 41 6) ; "Maybe if you eat something, you'll feel better. Here, Ben!"
			)
			(85 ; Talk
				(gCurRoom setScript: sTalkBen)
			)
			(51 ; Stopper
				(gMessager say: 31 51 9) ; "Here's a rubber stopper, Ben."
			)
			(40 ; Schematic
				(gCurRoom setScript: messageScr 0 2)
			)
			(44 ; Kite
				(gCurRoom setScript: messageScr 0 3)
			)
			(46 ; Kite_String
				(gCurRoom setScript: messageScr 0 4)
			)
			((OneOf theVerb 101 56) ; ???, A_Brass_Key
				(gCurRoom setScript: messageScr 0 5)
			)
			(45 ; Ordinary_String
				(if (not (IsFlag 17))
					(gMessager say: 31 45 7 0) ; "Here, Ben! Have some string!"
				else
					(gMessager say: 31 45 9 0) ; "Here's some string, Ben. It'll work for the kite, won't it?"
				)
			)
			((OneOf theVerb 153 39) ; ???, Doctrine
				(gMessager say: 31 153) ; "Uh, listen, Ben, I don't think this Doctrine thing will do me much good. Why don't you take it back, okay?"
			)
			((OneOf theVerb 145 97 52 49 53 144 54 55) ; Glass_Jar [tin+water+stopper], ???, Glass_Jar, Glass_Jar [empty], Glass_Jar [tin], Glass_Jar [tin+water], Glass_Jar [tin+water+stopper+rod], Glass_Jar [Leyden]
				(gCurRoom setScript: messageScr 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sTalkBen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) view: 1790) ; pepper
				(= cycles 2)
			)
			(1
				(cond
					((and (IsFlag 147) (IsFlag 17))
						(ben setCycle: End)
						(gMessager say: 31 85 11 0 self) ; "Do you have any idea where I could find all the stuff for the experiment, Ben?"
					)
					((and (IsFlag 147) (not (IsFlag 17)))
						(ben setCycle: End)
						(= gDictionaryWord 32)
						(gMessager say: 31 85 8 0 self) ; "Go find me some hot water, okay, child? My karma is chilled, and my |r||c0|dogma|c||r| is freezing its tail off!"
					)
					((< global218 3)
						(switch global218
							(1
								(self setScript: benTalk1Scr self)
							)
							(2
								(self setScript: benTalk2Scr self)
							)
						)
						(++ global218)
					)
					(else
						(gMessager say: 31 85 23 0 self) ; "Ben seems to have drifted off to sleep, or at least out of reality. Either way, he's not talking anymore."
					)
				)
			)
			(2
				(gGame handsOn:)
				((ScriptID 895 0) normalize:) ; pepper
				(ben setCycle: Beg)
				(self dispose:)
			)
		)
	)
)

